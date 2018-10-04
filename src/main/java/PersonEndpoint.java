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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jan", "Kowalski", "123456789", 23));
        people.add(new Person("Kasia", "Abacka", "987654321", 33));
        people.add(new Person("Wojciech", "Zumba", "132435465", 13));
        return people;
    }

    @GET
    @Path("/{pesel}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByPesel(@PathParam("pesel") String pesel) {
        return new Person("Jan", "Kowalski", pesel, 23);
    }
}
