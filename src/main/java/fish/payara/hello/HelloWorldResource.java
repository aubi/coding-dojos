package fish.payara.hello;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

@Path("/v1/entities")
public class HelloWorldResource {

    @EJB
    private EntityBean entityBean;
    
    @GET
    public List<User> getAllUsers() {
       return entityBean.getUsers();
    }

    @GET
    @Path("/{name}")
    public User getByName(@PathParam("name") String userName) {
        return entityBean.getByName(userName).get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNew(User user) throws URISyntaxException {
        entityBean.createNewUser(user);
        return Response
                .created(new URI("/v1/entities/" + user.getUsername()))
                .build();
    }

}