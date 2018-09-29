package com.ub.ropalinda.controllers;

import com.ub.ropalinda.utils.commons.reponses.Response;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Utilities services
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/utilities")
public class Utilerias {

    /**
     * Returns the server date
     *
     * @return instancia DateClass
     */
    @Path("/date")
    @GET
    public Response<Date> serverDate() {
        Response<Date> res = new Response<>();
        res.setData(new Date());
        return res;
    }

}
