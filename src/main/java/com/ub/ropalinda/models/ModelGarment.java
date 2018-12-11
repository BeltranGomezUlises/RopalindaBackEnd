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
import com.ub.ropalinda.entities.Garment;
import com.ub.ropalinda.entities.Subcategory;
import com.ub.ropalinda.utils.commons.Model;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;
import com.ub.ropalinda.utils.validation.InvalidValueException;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ModelGarment extends Model<Garment, Integer> {

    public ModelGarment() {
        super(Garment.class);
    }

    @Override
    public Garment persist(Garment t) throws UniqueException, InvalidValueException {
        EntityManager em = this.createEm();
        Subcategory subCat = em.find(Subcategory.class, t.getSubcategory().getId());
        t.setSubcategory(subCat);
        em.close();
        return super.persist(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Garment t) throws UniqueException {
        EntityManager em = this.createEm();
        try {
            em.getTransaction().begin();

            Garment actual = em.find(Garment.class, t.getId());
            actual.setActive(t.getActive());
            actual.setDescription(t.getDescription());
            actual.setName(t.getName());
            actual.setPrice(t.getPrice());
            actual.setPreviewImage(t.getPreviewImage());
            actual.setSubcategory(em.find(Subcategory.class, t.getSubcategory().getId()));

            actual.getImagesList().clear();
            em.flush();

            t.getImagesList().forEach(i -> {
                i.setGarment1(actual);
                actual.addImage(i);
                em.persist(i);
            });

            actual.getCompatibleGarmentList().clear();
            em.createNativeQuery("delete from garmet_compatible_garment where garment = ?")
                    .setParameter(1, actual.getId()).executeUpdate();

            t.getCompatibleGarmentList().forEach(c -> {
                CompatibleGarment cmp = em.find(CompatibleGarment.class, c.getId());
                actual.addCompatibleGarment(cmp);
                cmp.addGarment(actual);
            });

            em.merge(actual);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

}
