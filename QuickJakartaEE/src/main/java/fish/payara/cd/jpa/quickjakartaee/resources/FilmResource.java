package fish.payara.cd.jpa.quickjakartaee.resources;

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
                .ok("Ping from Jakarta EE succeeded!")
                .build();
    }
}
