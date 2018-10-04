package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloResource {

    @GET
    @Produces
    public String hello(){
        return "hello man";
    }
}
