package validatorsJaxRS;

import org.jboss.resteasy.api.validation.ResteasyViolationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ViolationExceptionMapper implements ExceptionMapper<ResteasyViolationException> {

    @Override
    public Response toResponse(ResteasyViolationException e) {

        System.out.println(e.getViolations());
        return Response.status(Response.Status.BAD_REQUEST).entity("Bad request").build();


    }
}
