package com.tharsis.info.service;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.tharsis.info.model.PersonModel;
import com.tharsis.info.vo.ServirVo;

/**
 *
 * @author christian
 */
@Path("buscar.tra")
@RegisterRestClient
@Dependent
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ClientService {
    @POST
    public PersonModel getInfoPersonByDni(ServirVo servirVo);
}
