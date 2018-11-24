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

import com.ub.ropalinda.utils.commons.Controller;
import com.ub.ropalinda.entities.ProspectiveCustomer;
import com.ub.ropalinda.models.ModelProspectiveCustomer;
import com.ub.ropalinda.utils.UtilsJWT;
import static com.ub.ropalinda.utils.UtilsService.error;
import static com.ub.ropalinda.utils.UtilsService.invalidParam;
import static com.ub.ropalinda.utils.UtilsService.invalidToken;
import static com.ub.ropalinda.utils.UtilsService.warning;
import com.ub.ropalinda.utils.commons.reponses.AccessDeniedException;
import com.ub.ropalinda.utils.commons.reponses.Response;
import com.ub.ropalinda.utils.validation.InvalidValueException;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Path("/prospectiveCustomers")
public class ControllerProspectiveCustomer extends Controller<ModelProspectiveCustomer, ProspectiveCustomer, String> {

    public ControllerProspectiveCustomer() {
        super(new ModelProspectiveCustomer());
    }

    @POST
    @Path("/request")
    public Response customerRequest(ProspectiveCustomer req) {
        Response res = new Response();
        try {
            model.validateProspective(req);
            String token = model.customerRequest(req);
            res.setData(token);
        } catch (InvalidValueException e) {
            invalidParam(res, e);
        } catch (Exception e) {
            error(res, e);        
        } 
        return res;
    }

    @POST
    @Path("/activate")
    public Response customerRequest(HashMap<String, String> req) {
        Response res = new Response();
        try {                     
            model.customerActivation(req.get("token"), req.get("code"));            
        } catch (InvalidValueException e) {
            warning(res, e.getMessage(), null);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }
    
    @PUT
    @Path("/reject")
    public Response<Boolean> reject(@HeaderParam("Authorization") String token, 
            Map<String, String> body){
        Response<Boolean> res = new Response<>();        
        try {                     
            UtilsJWT.validate(token);
            model.reject(body.get("mail"));            
        } catch (InvalidValueException e) {
            warning(res, e.getMessage(), null);
        }catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (Exception e) {
            error(res, e);
        }        
        return res;
    }
    
    @POST
    @Path("/accept")
    public Response<Boolean> accept(@HeaderParam("Authorization") String token, 
            Map<String, String> body){
        Response<Boolean> res = new Response<>();        
        try {                     
            UtilsJWT.validate(token);
            model.accept(body.get("mail"));            
        } catch (InvalidValueException e) {
            warning(res, e.getMessage(), null);
        }catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (Exception e) {
            error(res, e);
        }        
        return res;
    }

}
