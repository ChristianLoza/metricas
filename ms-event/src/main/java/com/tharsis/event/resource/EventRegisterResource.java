package com.tharsis.event.resource;

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

import com.tharsis.event.logic.EventRegisterLogic;
import com.tharsis.event.vo.EventRegisterVO;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("register")
@Api(tags = "Event register")
public class EventRegisterResource {

    @Inject
    private EventRegisterLogic eventRegisterLogic;

    @POST
    @Path("add")
    public Response saveRegister(EventRegisterVO registerVO) {
        eventRegisterLogic.saveEventRegister(registerVO);
        return Response.ok().build();
    }

    @GET
    @Path("list-event-by-student/{idStudent}")
    public Response getAllEventRegisterByStudent(@PathParam("idStudent") Integer idStudent) {
        return Response.ok(eventRegisterLogic.listEventRegisterByStudent(idStudent)).build();
    }

    @GET
    @Path("total-credits/{idStudent}")
    public Response getSumCreditsByStudent(@PathParam("idStudent") Integer idStudent) {
        return Response.ok(eventRegisterLogic.totalCreditsByIdStudent(idStudent)).build();
    }

    @GET
    @Path("list-student-by-event/{idEvent}")
    public Response getStudentByEvent(@PathParam("idEvent") Integer idEvent) {
        return Response.ok(eventRegisterLogic.listStudentByIdEvent(idEvent)).build();
    }

}
