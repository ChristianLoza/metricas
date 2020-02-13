package com.tharsis.person.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

/**
 *
 * @author christian
 */
@ApplicationPath("v1")
@SwaggerDefinition(info = @Info(title = "Person-REST", version = "v1.0.0"), host = "localhost:8080")

public class PersonApplication extends Application {

}
