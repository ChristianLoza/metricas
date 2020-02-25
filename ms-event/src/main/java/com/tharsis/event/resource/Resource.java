package com.tharsis.event.resource;

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
@SwaggerDefinition(info = @Info(title = "Event-REST", version = "v1.0.0"), host = "localhost:8082")
@CrossOrigin
public class Resource extends Application{    
}
