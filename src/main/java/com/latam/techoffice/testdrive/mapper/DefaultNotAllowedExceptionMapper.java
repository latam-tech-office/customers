package com.latam.techoffice.testdrive.mapper;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 405 Method Not Allowed: HTTP Method not supported
 * 
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com>
 */
@Provider
public class DefaultNotAllowedExceptionMapper implements ExceptionMapper<NotAllowedException> {

    private static final Logger LOG = Logger.getLogger(DefaultNotAllowedExceptionMapper.class.getName());

    @Override
    public Response toResponse(NotAllowedException ex) {
        LOG.log(Level.INFO, "### (DEFAULT) Not Allowed Exception");
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
