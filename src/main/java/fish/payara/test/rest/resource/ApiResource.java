package fish.payara.test.rest.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/numbers")
public class ApiResource {
    
    @GET
    @Produces("text/plain")
    public int getSquare(@PathParam("number") int number) {
        return number * number;
    }
}
