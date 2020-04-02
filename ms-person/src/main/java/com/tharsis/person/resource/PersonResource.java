package com.tharsis.person.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.tharsis.person.logic.PersonLogic;
import com.tharsis.person.vo.LoginVO;

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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authUser(LoginVO loginVO) {
        if (personLogic.login(loginVO.getDni(), loginVO.getPassword())) {
            return Response.ok(personLogic
                    .generateToken(loginVO.getDni(), uriInfo.getAbsolutePath().toString()))
                    .build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
