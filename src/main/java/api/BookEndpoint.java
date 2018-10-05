package api;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
@RequestScoped
public class BookEndpoint {

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response saveBook(Book book) {
        System.out.println("Saving book");
        System.out.printf("%s %s %s\n", book.getTitle(), book.getAuthor(), book.getIsbn());
        return Response.ok().build();
    }


    @GET
    @Path("/{isbn}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book get(@PathParam("isbn") String isbn) {

        return new Book("MockTitle", "SomeAuthor", isbn);
    }
}