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

import com.ub.ropalinda.entities.Garment;
import com.ub.ropalinda.entities.Subcategory;
import com.ub.ropalinda.utils.commons.Model;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ModelGarment extends Model<Garment, Integer>{
    
    public ModelGarment() {
        super(Garment.class);
    }

    @Override
    public Garment persist(Garment t) throws UniqueException {
        Subcategory subCat = this.createEm().find(Subcategory.class, t.getSubcategory().getId());
        t.setSubcategory(subCat);
        return super.persist(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Garment t) throws UniqueException {
        Subcategory subCat = this.createEm().find(Subcategory.class, t.getSubcategory().getId());
        t.setSubcategory(subCat);
        super.update(t); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
