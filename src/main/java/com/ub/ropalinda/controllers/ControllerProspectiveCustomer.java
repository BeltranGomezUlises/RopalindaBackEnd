package com.ub.ropalinda.controllers;

import com.ub.ropalinda.utils.commons.Controller;
import com.ub.ropalinda.entities.ProspectiveCustomer;
import com.ub.ropalinda.models.ModelProspectiveCustomer;
import javax.ws.rs.Path;

/**
 *
 * @author ulises
 */
@Path("/prospectiveCustomers")
public class ControllerProspectiveCustomer 
        extends Controller<ProspectiveCustomer, String> {

    public ControllerProspectiveCustomer() {
        super(new ModelProspectiveCustomer());
    }        
    
    @Override
    protected boolean persistRequiresToken() {
        return false;
    }    
           
}
