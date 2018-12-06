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
package com.ub.ropalinda.controllers;

import com.ub.ropalinda.entities.Category;
import com.ub.ropalinda.models.ModelCategory;
import com.ub.ropalinda.utils.commons.Controller;
import javax.ws.rs.Path;

/**
 *
 * @author valle
 */

@Path("/categories")
public class ControllerCategory extends Controller<ModelCategory, Category, Integer>{
    
    public ControllerCategory() {
        super(new ModelCategory());
    }

    @Override
    protected boolean findAllRequiresToken() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean findByRequiresToken() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
}
