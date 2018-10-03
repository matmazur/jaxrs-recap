import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Path("/people")
@RequestScoped
public class PersonEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getAll(@QueryParam("orderBy") @DefaultValue("asc") String order) {
        List<String> people = new ArrayList<>(Arrays.asList("Person 1", "Person 2"));

        if (order.equals("asc")) {
            people.sort(String::compareTo);
        } else {
            people.sort(Comparator.reverseOrder());
        }
        return people;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPerson(@PathParam("id") Long id) {

        return "Person " + id;
    }
}
