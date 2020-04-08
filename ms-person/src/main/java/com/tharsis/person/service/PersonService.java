package com.tharsis.person.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.tharsis.info.config.PathService;
import com.tharsis.info.config.Route;
import com.tharsis.info.model.PersonModel;
import com.tharsis.info.model.StudentModel;
import com.tharsis.info.service.ClientService;
import com.tharsis.info.service.RucService;
import com.tharsis.info.service.Usuario;
import com.tharsis.info.service.UsuarioService;
import com.tharsis.info.vo.RucVo;
import com.tharsis.info.vo.ServirVo;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@Path("services")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Api(tags = "Person find service")
public class PersonService {

    @RestClient
    private ClientService clientService;

    @RestClient
    private RucService rucService;

    @PostConstruct
    private void init() {
        clientService = PathService
                .clientBuilder(Route.TALENTOPERU)
                .build(ClientService.class);

        rucService = PathService
                .clientBuilder(Route.RUCPERU)
                .build(RucService.class);
    }

    @GET
    @Path("find-by-ruc/{ruc}")
    public Response findByRuc(@PathParam("ruc") String ruc) {
        if (isNullOrEmpty(ruc) || ruc.length() != 11) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            RucVo rucVo = rucService.getDataByRuc(ruc);

            if (rucVo.getStatus() == 0) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            } else {
                return Response.ok(rucVo).build();
            }
        }
    }

    @GET
    @Path("find-person/{dni}")
    public Response findPersonDni(@PathParam("dni") String dni) {
        if (isNullOrEmpty(dni) || dni.length() != 8) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            ServirVo servirVo = new ServirVo();
            servirVo.setId(dni);
            servirVo.setTipoDocumentoID("03");
            PersonModel model = clientService.getInfoPersonByDni(servirVo);
            return Response.ok(model).build();
        }
    }

    @GET
    @Path("find-student/{dni}")
    public Response findStudentDni(@PathParam("dni") String dni) {

        if (isNullOrEmpty(dni)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            UsuarioService userService = new UsuarioService();
            Usuario user = userService.getUsuario();

            if (!isNullOrEmpty(user.getInformacion(dni))) {
                String[] values = user.getInformacion(dni).split("█");

                StudentModel studentModel = new StudentModel();

                for (int i = 0; i < values.length; i++) {
                    studentModel.setDni(values[0]);
                    studentModel.setName(values[1]);
                    studentModel.setLastName(values[2] + " " + values[3]);
                    studentModel.setNumberPhone(values[4]);
                    studentModel.setDateBirth(values[5]);
                    studentModel.setEmail(values[7]);
                    studentModel.setUrlPicture(values[8]);
                }

                String replaceUrl = studentModel.getUrlPicture().replaceAll("http://academico.ulasalle.edu.pe:8080", "http://siberia.ulasalle.edu.pe:8080");
                studentModel.setUrlPicture(replaceUrl);
                return Response.ok(studentModel).status(Response.Status.CREATED).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }

    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
