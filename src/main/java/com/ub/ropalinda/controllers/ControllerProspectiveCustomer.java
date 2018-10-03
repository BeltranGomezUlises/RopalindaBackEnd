package com.ub.ropalinda.controllers;

import com.ub.ropalinda.utils.commons.Controller;
import com.ub.ropalinda.entities.ProspectiveCustomer;
import com.ub.ropalinda.models.ModelProspectiveCustomer;
import com.ub.ropalinda.utils.UtilsService;
import static com.ub.ropalinda.utils.UtilsService.error;
import com.ub.ropalinda.utils.commons.reponses.Response;
import com.ub.ropalinda.utils.validation.InvalidValueException;
import java.util.HashMap;
import javax.ws.rs.POST;
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

    @POST
    @Path("/request")
    public Response customerRequest(ProspectiveCustomer req) {
        Response res = new Response();
        try {
            ModelProspectiveCustomer model = new ModelProspectiveCustomer();
            model.validateProspective(req);
            String token = model.customerRequest(req);
            res.setData(token);
        } catch (InvalidValueException e) {
            UtilsService.invalidParam(res, e);
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
            ModelProspectiveCustomer model = new ModelProspectiveCustomer();            
            model.customerActivation(req.get("token"), req.get("code"));            
        } catch (InvalidValueException e) {
            UtilsService.warning(res, e.getMessage(), null);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

}
