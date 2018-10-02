/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.controllers;

import com.ub.ropalinda.entities.Customer;
import com.ub.ropalinda.models.ModelCustomer;
import com.ub.ropalinda.utils.commons.Controller;
import javax.ws.rs.Path;

/**
 *
 * @author ulises
 */
@Path("/customers")
public class ControllerCustomer extends Controller<Customer, String>{
    
    public ControllerCustomer() {
        super(new ModelCustomer());
    }
    
}
