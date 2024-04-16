package fish.payara.hello;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;

@Path("entities")
public class HelloWorldResource {

    @EJB
    private EntityBean entityBean;
    
    @GET
    public List<User> getAllUsers() {
       return entityBean.getUsers();
    }

}