/*
 * Copyright (C) 2018 Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.ub.ropalinda.models;

import com.ub.ropalinda.entities.Address;
import com.ub.ropalinda.entities.CompatibleGarment;
import com.ub.ropalinda.entities.Customer;
import com.ub.ropalinda.entities.Garment;
import com.ub.ropalinda.entities.OrderDetail;
import com.ub.ropalinda.entities.OrderDetailCompatible;
import com.ub.ropalinda.entities.PurchaseOrder;
import com.ub.ropalinda.utils.commons.Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ModelOrder extends Model<PurchaseOrder, Integer> {

    public ModelOrder() {
        super(PurchaseOrder.class);
    }

    public PurchaseOrder persistOrder(PersistOrder po) {
        EntityManager em = this.createEm();

        em.getTransaction().begin();

        int folio = (int) em.createNativeQuery("WITH upd AS (\n"
                + "   UPDATE folio\n"
                + "   SET    folio = folio + 1   \n"
                + "   RETURNING folio\n"
                + "   )\n"
                + "SELECT folio FROM upd;").getSingleResult();

        PurchaseOrder order = new PurchaseOrder(folio);
        order.setActive(true);
        order.setAddress(em.find(Address.class, po.getCustomerAddressId()));
        order.setCustomer(em.find(Customer.class, po.getCustomerMail()));
        order.setOrderDate(new Date());
        order.setDeliveryDate(deliveryDateService());

        em.persist(order);
        em.flush();
        
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (PersistOrder.OrderLine l : po.getLines()) {
            OrderDetail d = new OrderDetail();
            Garment g = em.find(Garment.class, l.getGarmentId());
            d.setGarment(g);
            d.setQuantity(l.getQuantity());
            d.setPrice(g.getPrice());
            d.setPurchaseOrder(order);            
            
            em.persist(d);
            em.flush();
            
            List<OrderDetailCompatible> detailCompatibles = new ArrayList<>();
            for (Integer compatibleId : l.getCompatibleIds()) {                
                OrderDetailCompatible odc = new OrderDetailCompatible();
                CompatibleGarment cg = em.find(CompatibleGarment.class, compatibleId);
                odc.setCompatibleGarment(cg);
                odc.setActive(true);
                odc.setPrice(cg.getPrice());
                odc.setOrderDetail(d);
                
                em.persist(odc);
                em.flush();
                
                detailCompatibles.add(odc);
            }
            d.setOrderDetailCompatibleList(detailCompatibles);
            orderDetails.add(d);
        }
        order.setOrderDetailList(orderDetails);
        
        em.merge(order);
        em.getTransaction().commit();
        em.close();

        return order;
    }

    public Date deliveryDateService() {
        return new Date();
    }

}
