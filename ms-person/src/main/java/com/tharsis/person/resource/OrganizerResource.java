package com.tharsis.person.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tharsis.person.domain.Organizer;
import com.tharsis.person.logic.OrganizerLogic;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("organizer")
@Api(tags = "Organizer")
public class OrganizerResource {

    @Inject
    private OrganizerLogic organizerLogic;

    @POST
    @Path("add")
    public Response saveOrganizer(Organizer organizer) {
        organizerLogic.saveOrganizer(organizer);
        return Response.ok(organizer).build();
    }
    
    @POST
    @Path("edit")
    public Response updateOrganizer(Organizer organizer) {
        organizerLogic.updateOrganizer(organizer);
        return Response.ok().build();
    }
    
    @POST
    @Path("delete")
    public Response deleteOrganizer(Organizer organizer){
        organizerLogic.deleteOrganizer(organizer);
        return Response.ok().build();
    }

    @GET
    @Path("list")
    @RolesAllowed("user")
    public Response getAllOrganizer() {
        return Response.ok(organizerLogic.allOrganizer()).build();
    }
    
    @GET
    @Path("{id}")
    public Response getOrganizer(@PathParam("id") Integer id) {
        List<Organizer> list = organizerLogic.findOrganizer(id);
        return Response.ok(list).build();
    }
}
