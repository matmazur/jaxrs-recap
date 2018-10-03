import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/people/{id}")
@RequestScoped
public class PersonEndpoint {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPerson(@PathParam("id") Long id){

        return "Person " + id;
    }
}
