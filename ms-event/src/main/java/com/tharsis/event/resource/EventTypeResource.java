package com.tharsis.event.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tharsis.event.domain.Eventtype;
import com.tharsis.event.logic.EventTypeLogic;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("eventtype")
@Api(tags = "Event Type")
public class EventTypeResource {

    @Inject
    private EventTypeLogic eventTypeLogic;

    @POST
    @Path("add")
    public Response saveEventType(Eventtype eventType) {
        eventTypeLogic.saveTypeEvent(eventType);
        return Response.ok().build();
    }

    @PUT
    @Path("edit/{id}")
    public Response updateEventType(@PathParam("id") Integer id, Eventtype eventType) {
        eventTypeLogic.updateTypeEvent(id, eventType);
        return Response.ok().build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteEventType(@PathParam("id") Integer id) {
        eventTypeLogic.deleteTypeEvent(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response getEventTypeId(@PathParam("id") Integer id) {
        return Response.ok(eventTypeLogic.findEvenTypeById(id)).build();
    }

    @GET
    @Path("list")
    public Response getAllEventType() {
        return Response.ok(eventTypeLogic.AllTypeEvent()).build();
    }
}
