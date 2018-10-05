package api;

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
    public Response get(@PathParam("isbn") @DefaultValue("214235") String isbn) {

        if ("214235".equals(isbn))
            return Response.status(404).build();
        else
            return Response.ok().entity(new Book("Mocktitle","MockAuthor",isbn)).build();

    }
}