package api;

import model.User;
import model.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {


    @Inject
    UserRepository userRepository;

    @GET
    public List<User> getAll(){
        return userRepository.findAll();
    }










}
