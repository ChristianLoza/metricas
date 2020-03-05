package com.tharsis.person.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.tharsis.person.logic.PersonLogic;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@RequestScoped
@Path("login")
@Api(tags = "Person")
public class PersonResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private PersonLogic personLogic;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authUser(@FormParam("dni") String dni,
            @FormParam("password") String password) {

        if (personLogic.login(dni, password)) {
            String val = personLogic.generateToken(dni, uriInfo.getAbsolutePath().toString());
            return Response.ok(val).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }
}
