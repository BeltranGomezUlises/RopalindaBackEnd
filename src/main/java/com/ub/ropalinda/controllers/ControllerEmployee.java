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

import com.ub.ropalinda.entities.Employee;
import com.ub.ropalinda.models.ModelEmployee;
import com.ub.ropalinda.utils.UtilsService;
import static com.ub.ropalinda.utils.UtilsService.error;
import com.ub.ropalinda.utils.commons.Controller;
import com.ub.ropalinda.utils.commons.reponses.Response;
import com.ub.ropalinda.utils.validation.InvalidValueException;
import java.util.Map;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Path("/employees")
public class ControllerEmployee extends Controller<ModelEmployee, Employee, String> {

    public ControllerEmployee() {
        super(new ModelEmployee());
    }

    @Path("/login")
    @POST
    public Response<Map> login(Map<String, String> map) {
        Response<Map> res = new Response();
        try {
            String mail = map.get("mail");
            String pass = map.get("pass");
            Map<String, Object> data = this.model.login(mail, pass);
            res.setData(data);
        } catch (InvalidValueException e) {
            UtilsService.invalidParam(res, e, e.getMessage());
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

}
