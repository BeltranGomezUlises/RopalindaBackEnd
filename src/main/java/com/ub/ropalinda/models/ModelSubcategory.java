/*
 * Copyright (C) 2018 valle
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

import com.ub.ropalinda.entities.Category;
import com.ub.ropalinda.entities.Subcategory;
import com.ub.ropalinda.utils.commons.Model;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;
import com.ub.ropalinda.utils.validation.InvalidValueException;

/**
 *
 * @author valle
 */
public class ModelSubcategory extends Model<Subcategory, Integer> {

    public ModelSubcategory() {
        super(Subcategory.class);
    }

    @Override
    public Subcategory persist(Subcategory t) throws UniqueException, InvalidValueException {
        Category cat = this.createEm().find(Category.class, t.getCategory().getId());
        t.setCategory(cat);
        return super.persist(t);
    }

}
