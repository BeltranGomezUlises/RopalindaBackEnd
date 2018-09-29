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
public class ProspectiveCustomerController 
        extends Controller<ProspectiveCustomer, String> {

    public ProspectiveCustomerController() {
        super(new ModelProspectiveCustomer());
    }    
    
}
