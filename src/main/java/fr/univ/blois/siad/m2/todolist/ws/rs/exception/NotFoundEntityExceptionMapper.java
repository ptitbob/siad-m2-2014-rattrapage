package fr.univ.blois.siad.m2.todolist.ws.rs.exception;

import fr.univ.blois.siad.m2.todolist.exception.NotFoundEntityException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by francois on 01/07/15.
 */
@Provider
public class NotFoundEntityExceptionMapper implements ExceptionMapper<NotFoundEntityException> {
    @Override
    public Response toResponse(NotFoundEntityException exception) {
        return Response.status(499).build();
    }
}
