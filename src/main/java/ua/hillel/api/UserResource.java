package ua.hillel.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ua.hillel.model.User;
import ua.hillel.service.UserService;

import java.util.List;

@Path("users")
public class UserResource {
    @Inject
    private UserService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") int id) {
        return service.getUserById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User user) {
        service.addUser(user);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("id") int id, User user) {
        service.updateUser(id, user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id)  {
        service.deleteUser(id);
    }

    @GET
    @Path("/search")
    public List<User> searchUsers(@QueryParam("q") String q, @QueryParam("maxResults") Integer maxResults) {
        return service.searchUsers(q, maxResults);
    }
}
