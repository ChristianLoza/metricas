package com.tharsis.person.resource;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import io.swagger.annotations.Api;

/**
 *
 * @author christian
 */
@RequestScoped
@Path("login")
@Api(tags = "Person")
public class PersonResource {

}
