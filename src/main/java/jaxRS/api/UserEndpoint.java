package jaxRS.api;

import jaxRS.model.User;
import jaxRS.model.UserDetails;
import jaxRS.model.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;

@RequestScoped
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {

    @Inject
    UserRepository userRepository;

    @GET
    public Response getAll() {

        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            return Response.noContent().build();
        else
            return Response.ok(users).build();
    }

    @GET
    @Path("/{userId}")
    public Response getById(@PathParam("userId") Long id) {

        User user = userRepository.findById(id);
        if (user == null)
            return Response.noContent().build();
        else return Response.ok(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createUserForm(
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("telephone") String telephone,
            @FormParam("pesel") String pesel,
            @FormParam("country") String country,
            @FormParam("address") String address,
            @Context HttpServletResponse response,
            @Context HttpServletRequest req
    ) throws IOException {

        User user = new User(firstName,lastName,telephone,pesel);
        UserDetails userDetails = new UserDetails(address,country);
        user.setDetails(userDetails);

        userRepository.add(user);

        response.sendRedirect(req.getContextPath());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user, @Context UriInfo uriInfo) {
        if(user != null && user.getId() == null) {
            userRepository.add(user);
            return Response
                    .created(uriInfo
                            .getAbsolutePathBuilder()
                            .path(user.getId().toString())
                            .build())
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
