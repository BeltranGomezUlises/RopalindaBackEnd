package com.ub.ropalinda.utils.commons;

import com.ub.ropalinda.utils.UtilsJWT;
import static com.ub.ropalinda.utils.UtilsService.*;
import com.ub.ropalinda.utils.commons.reponses.AccessDeniedException;
import com.ub.ropalinda.utils.commons.reponses.Response;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;
import java.security.InvalidParameterException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Base controller for all the entities of this proyect
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 * @param <T> Entity type
 * @param <K> Entity primary key type
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Controller<T extends IEntity<K>, K> {

    protected Model<T, K> model;

    public Controller(Model<T, K> manager) {
        this.model = manager;
    }

    @GET
    public Response<List> findAll(
            @HeaderParam("Authorization") String token,
            @QueryParam("select") String select,
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to
    ) {
        Response res = new Response();
        try {
            if (this.findAllRequiresToken()) {
                UtilsJWT.validate(token);
            }
            if (select != null) {
                res.setData(this.model.findAll(select, from, to));
            } else {
                res.setData(this.model.findAll(from, to));
            }
        } catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (InvalidParameterException e) {
            invalidParam(res, e);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

    @POST
    @Path("/detail")
    public Response<T> findById(
            @HeaderParam("Authorization") String token, K id) {
        Response<T> res = new Response();
        try {
            if (this.findByRequiresToken()) {
                UtilsJWT.validate(token);
            }
            ok(res, this.model.findById(id));
        } catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (InvalidParameterException e) {
            invalidParam(res, e);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

    @POST
    public Response<T> persist(
            @HeaderParam("Authorization") String token, T t) {
        Response<T> res = new Response();
        try {
            if (this.persistRequiresToken()) {
                UtilsJWT.validate(token);
            }
            ok(res, this.model.persist(t));
        } catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (UniqueException e) {
            unique(res, e);
        } catch (InvalidParameterException e) {
            invalidParam(res, e);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

    @PUT
    public Response<T> update(
            @HeaderParam("Authorization") String token, T t) {
        Response res = new Response();
        try {
            if (this.updateRequiresToken()) {
                UtilsJWT.validate(token);
            }
            this.model.update(t);
        } catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (UniqueException e) {
            unique(res, e);
        } catch (InvalidParameterException e) {
            invalidParam(res, e);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

    @DELETE
    public Response<T> delete(
            @HeaderParam("Authorization") String token, K id) throws Exception {
        Response res = new Response();
        try {
            if (this.deleteRequiresToken()) {
                UtilsJWT.validate(token);
            }
            this.model.delete(id);
        } catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (InvalidParameterException e) {
            invalidParam(res, e);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

    @GET
    @Path("/count")
    public Response<Long> count(@HeaderParam("Authorization") String token) {
        Response<Long> res = new Response<>();
        try {
            if (this.countRequiresToken()) {
                UtilsJWT.validate(token);
            }
            ok(res, "Total entities", model.count());
        } catch (AccessDeniedException e) {
            invalidToken(res);
        } catch (InvalidParameterException e) {
            invalidParam(res, e);
        } catch (Exception e) {
            error(res, e);
        }
        return res;
    }

    protected boolean findAllRequiresToken() {
        return true;
    }

    protected boolean findByRequiresToken() {
        return true;
    }

    protected boolean persistRequiresToken() {
        return true;
    }

    protected boolean updateRequiresToken() {
        return true;
    }

    protected boolean deleteRequiresToken() {
        return true;
    }

    protected boolean countRequiresToken() {
        return true;
    }

}
