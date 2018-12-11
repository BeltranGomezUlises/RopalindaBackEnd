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

import com.ub.ropalinda.entities.CompatibleGarment;
import com.ub.ropalinda.entities.Customer;
import com.ub.ropalinda.entities.Garment;
import com.ub.ropalinda.entities.PersonalizedGarment;
import com.ub.ropalinda.entities.PersonalizedGarmentCompatible;
import com.ub.ropalinda.utils.commons.Model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ModelPersonalizedGarment extends Model<PersonalizedGarment, Integer> {

    public ModelPersonalizedGarment() {
        super(PersonalizedGarment.class);
    }

    public PersonalizedGarment persistPersonalized(PersistPersonalized pp){
        EntityManager em = this.createEm();       
        em.getTransaction().begin();
        PersonalizedGarment pg = new PersonalizedGarment();
        pg.setActive(true);
        pg.setGarment(em.find(Garment.class, pp.getGarmentId()));
        pg.setCustomer(em.find(Customer.class, pp.getCustomerMail()));
        
        em.persist(pg);
        em.flush();
        
        List<PersonalizedGarmentCompatible> personalizedGarmentCompatibles = new ArrayList<>();
        pp.getCompatiblesIds().forEach(id -> {
            PersonalizedGarmentCompatible pgc = new PersonalizedGarmentCompatible();
            pgc.setActive(true);            
            pgc.setCompatibleGarment(em.find(CompatibleGarment.class, id));            
            pgc.setPersonalizedGarment(pg);
            em.persist(pgc);
            personalizedGarmentCompatibles.add(pgc);
        });
        pg.setPersonalizedGarmentCompatibleList(personalizedGarmentCompatibles);
        em.merge(pg);
        em.getTransaction().commit();   
        return pg;
    }
    
    

}
