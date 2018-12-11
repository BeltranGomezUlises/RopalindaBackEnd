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
package com.ub.ropalinda.controllers;

import com.ub.ropalinda.entities.PersonalizedGarment;
import com.ub.ropalinda.models.ModelPersonalizedGarment;
import com.ub.ropalinda.models.PersistPersonalized;
import com.ub.ropalinda.utils.UtilsJWT;
import com.ub.ropalinda.utils.UtilsService;
import com.ub.ropalinda.utils.commons.Controller;
import com.ub.ropalinda.utils.commons.reponses.AccessDeniedException;
import com.ub.ropalinda.utils.commons.reponses.Response;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Path("/personalizedGarments")
public class ControllerPersonalizedGarment extends
        Controller<ModelPersonalizedGarment, PersonalizedGarment, Integer> {

    public ControllerPersonalizedGarment() {
        super(new ModelPersonalizedGarment());
    }

    
    @POST
    @Path("/persist")
    public Response persistPersonalized(@HeaderParam("Authorization") String token, PersistPersonalized pp) {
        Response res = new Response();
        try {
            UtilsJWT.validate(token);
            PersonalizedGarment pg = this.model.persistPersonalized(pp);
            res.setData(pg);
        } catch (AccessDeniedException e) {
            UtilsService.invalidToken(res);
        } catch (Exception e) {
            UtilsService.error(res, e);
        }
        return res;
    }

}
