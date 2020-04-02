package com.tharsis.person.auth;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.tharsis.person.domain.Role;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 *
 * @author christian
 */
@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException(Response.Status.UNAUTHORIZED);
        }

        String token = authorizationHeader.substring("Bearer ".length()).trim();

        try {
            Role userRole = Role.valueOf(Token.validateToken(token));

            if (Token.tokenIsValid(token)) {
                List<Role> classRole = getRoles(resourceInfo.getResourceClass());
                List<Role> methodRole = getRoles(resourceInfo.getResourceMethod());

                if (methodRole.size() > 0) {
                    if (!methodRole.contains(userRole)) {
                        requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
                    }
                }

                if (classRole.size() > 0) {
                    if (!classRole.contains(userRole)) {
                        requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
                    }
                }
            } else {
                throw new NotAuthorizedException(Response.Status.UNAUTHORIZED);
            }
        } catch (NotAuthorizedException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private List<Role> getRoles(AnnotatedElement annotatedElement) {
        List<Role> listRoles = new ArrayList<>();
        if (annotatedElement == null) {
            return listRoles;
        } else {
            Secured secured = annotatedElement.getAnnotation(Secured.class);
            if (secured == null) {
                return listRoles;
            } else {
                Role[] allowRoles = secured.value();
                return Arrays.asList(allowRoles);
            }
        }

    }

}
