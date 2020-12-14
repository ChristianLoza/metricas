package com.tharsis.person.resource;

import java.time.temporal.ChronoUnit;

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

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Timeout;

import com.tharsis.person.domain.Student;
import com.tharsis.person.logic.StudentLogic;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("student")
@Api(tags = "Student")
public class StudentResource {

    @Inject
    private StudentLogic studentLogic;

    @POST
    @Path("add")
    public Response saveStudent(Student student) {
        studentLogic.saveStudent(student);
        return Response.ok().build();
    }

    @PUT
    @Path("edit/{id}")
    public Response updateStudent(@PathParam("id") Integer id, Student student) {
        studentLogic.updateStudent(id, student);
        return Response.ok().build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteStudent(@PathParam("id") Integer id) {
        studentLogic.deleteStudent(id);
        return Response.noContent().build();
    }

    @CircuitBreaker
    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    @GET
    @Path("list")
    public Response getAllStudent() {
        return Response.ok(studentLogic.allStudent()).build();
    }
    
    @GET
    @Path("list/{limit}")
    public Response getAllStudentLimit(@PathParam("limit") Integer limit) {
        return Response.ok(studentLogic.allStudent(limit)).build();
    }

    @GET
    @Path("{id}")
    public Response getStudentId(@PathParam("id") Integer id) {
        Student student = studentLogic.findStudentById(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(student).build();
    }

    @GET
    @Path("dni/{dni}")
    public Response getStudentDni(@PathParam("dni") String dni) {
        Student student = studentLogic.findStudentByDni(dni);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(student).build();
    }

    @GET
    @Path("nfc/{nfc}")
    public Response getStudentNfc(@PathParam("nfc") String nfc) {
        Integer id = studentLogic.findStudentByNfc(nfc);
        if (id != null) {
            return Response.ok(studentLogic.findStudentByNfc(nfc)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }
}
