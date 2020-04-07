package com.tharsis.info.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

/**
 *
 * @author christian
 */
public class PathService {
    
    private static URL StudentURI(String pathService) {
        URL url = null;
        try {
            url = new URL(pathService);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PathService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }
    
    public static RestClientBuilder clientBuilder(String path) {
        return RestClientBuilder.newBuilder().baseUrl(StudentURI(path));
    }
        
}
