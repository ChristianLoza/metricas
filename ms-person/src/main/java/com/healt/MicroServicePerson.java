package com.healt;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author christian
 */
@Readiness
@ApplicationScoped
public class MicroServicePerson implements HealthCheck {

    private static final String URL = "http://localhost:8081/v1/student/list";

    private static final Logger LOG = Logger.getLogger(MicroServicePerson.class.getSimpleName());

    @Override
    public HealthCheckResponse call() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod("HEAD");

            if (connection.getResponseCode() == 200) {
                return HealthCheckResponse.named(MicroServicePerson.class.getSimpleName()).up().build();
            }
        } catch (IOException exception) {
            LOG.severe(exception.getMessage());
        }
        return HealthCheckResponse.named(MicroServicePerson.class.getSimpleName()).down().build();
    }
}
