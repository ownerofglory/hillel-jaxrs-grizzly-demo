package ua.hillel.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("/hello/{name}")
    public String getHello(@PathParam("name") String name) {
        return "Hello " + name;
    }

    @POST
    public void setHello(@HeaderParam("x-sname") String name) {
        System.out.println(name);
    }
}
