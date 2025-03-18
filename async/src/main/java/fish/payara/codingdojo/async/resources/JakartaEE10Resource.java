package fish.payara.codingdojo.async.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.time.LocalDateTime;

/**
 *
 * @author 
 */
@Path("ping")
public class JakartaEE10Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("pong " + LocalDateTime.now())
                .build();
    }
}
