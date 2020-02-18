package com.tharsis.person.resource;

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
    @Path("edit")
    public Response updateStudent(Student student) {
        studentLogic.updateStudent(student);
        return Response.ok().build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteStudent(@PathParam("id") Integer id) {
        studentLogic.deleteStudent(id);
        return Response.noContent().build();
    }

    @GET
    @Path("list")
    public Response getAllStudent() {
        return Response.ok(studentLogic.allStudent()).build();
    }

    @GET
    @Path("{id}")
    public Response getStudentId(@PathParam("id") Integer id) {
        return Response.ok(studentLogic.findStudentById(id)).build();
    }

    @GET
    @Path("dni/{dni}")
    public Response getStudentDni(@PathParam("dni") String dni) {
        return Response.ok(studentLogic.findStudentByDni(dni)).build();
    }

}
