package com.tharsis.event.filter;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 *
 * @author christian
 */
@Provider
public class JacksonProducer implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public JacksonProducer() {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        mapper.setDateFormat(dateFormat);                       
    }

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return mapper;
    }
}
