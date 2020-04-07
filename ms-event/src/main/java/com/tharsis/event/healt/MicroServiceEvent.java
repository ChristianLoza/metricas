package com.tharsis.event.healt;

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
public class MicroServiceEvent implements HealthCheck {

    private static final String URL = "http://localhost:8082/v1/event/list";

    private static final Logger LOG = Logger.getLogger(MicroServiceEvent.class.getSimpleName());

    @Override
    public HealthCheckResponse call() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod("HEAD");

            if (connection.getResponseCode() == 200) {
                return HealthCheckResponse.named(MicroServiceEvent.class.getSimpleName()).up().build();
            }
        } catch (IOException exception) {
            LOG.severe(exception.getMessage());
        }
        return HealthCheckResponse.named(MicroServiceEvent.class.getSimpleName()).down().build();
    }
}
