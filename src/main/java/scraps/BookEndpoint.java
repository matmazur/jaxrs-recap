package scraps;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;

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
            return Response.ok().entity(new Book("Mocktitle", "MockAuthor", isbn)).build();

    }

    @GET
    public Response getInfo() {
        return Response
                .ok()
                .cookie(new NewCookie("auth-token", Long.toString(System.currentTimeMillis())))
                .header("test-header", "example value")
                .encoding("UTF-8")
                .build();
    }

    @Context
    private HttpHeaders headers;

    @GET
    @Path("useragent")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAgent() {
        return Response
                .ok(headers.getHeaderString("user-agent"))
                .build();
    }

    @GET
    @Path("givecookie")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCookie(@CookieParam("auth-token") Cookie cookie) {

        if (cookie != null)
            return Response.ok(cookie).build();
        else
            return Response.status(404).build();
    }

    //can be done with HttpHeaders aswell
    // header.cookies gives map String,Cookie

    @POST
    @Path("form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response getForm(@FormParam("message") String message, @FormParam("number") Integer number) {

        return Response.ok("message from number " + number + ": " + message).build();

    }

    @Context
    private HttpServletRequest request;


    @GET
    @Path("request")
    public void requestInfo(@Context HttpServletResponse response) throws IOException {
        String param = request.getParameter("param");
        System.out.println(param);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath);
    }

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response save(@FormParam("email") String email, @Context UriInfo uriInfo) {

        return Response
                .created(uriInfo
                        .getAbsolutePathBuilder().path(email).build())
                .build();

    }
}