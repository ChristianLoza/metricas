package com.tharsis.person.resource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.kumuluz.ee.cors.annotations.CrossOrigin;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

/**
 *
 * @author christian
 */
@ApplicationPath("v1")
@SwaggerDefinition(info = @Info(title = "Person-REST", version = "v1.0.0"))
@CrossOrigin
public class Resource extends Application {

}
