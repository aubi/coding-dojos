package fish.payara.codingdojos.jakarta10view.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("ping")
public class JakartaEE10Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("Pong")
                .build();
    }
}
