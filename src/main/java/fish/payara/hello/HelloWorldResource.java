package fish.payara.hello;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("entities")
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

}