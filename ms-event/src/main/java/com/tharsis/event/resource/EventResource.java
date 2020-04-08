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

import com.tharsis.event.logic.EventLogic;
import com.tharsis.event.vo.EventVO;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("event")
@Api(tags = "Event")
public class EventResource {

    @Inject
    private EventLogic eventLogic;

    @POST
    @Path("add")
    public Response saveEvent(EventVO eventVO) {
        eventLogic.saveEvent(eventVO);
        return Response.ok().build();
    }

    @PUT
    @Path("edit")
    public Response updateEvent(EventVO eventVO) {
        eventLogic.updateEvent(eventVO);
        return Response.ok().build();
    }

    @DELETE
    @Path("delete/{idEvent}")
    public Response deleteEvent(@PathParam("idEvent") Integer idEvent) {
        eventLogic.deleteEvent(idEvent);
        return Response.noContent().build();
    }

    @GET
    @Path("{id}")
    public Response getEventId(@PathParam("id") Integer id) {
        return Response.ok(eventLogic.findEventById(id)).build();
    }

    @GET
    @Path("list")
    public Response getListEvent() {
        return Response.ok(eventLogic.allActiveEvent()).build();
    }
    
    @GET
    @Path("list-active-events")
    public Response getListActiveEvent() {
        return Response.ok(eventLogic.findAllEventByDate()).build();
    }
    
    @GET
    @Path("list-expired-events")
    public Response getExpiredEvent() {
        return Response.ok(eventLogic.allExpiredEvent()).build();
    }

    @GET
    @Path("list-by-type-event/{idTypeEvent}")
    public Response getListEventByType(@PathParam("idTypeEvent") Integer idTypeEvent) {
        return Response.ok(eventLogic.allActiveEventByTypeEvent(idTypeEvent)).build();
    }
}
