package fish.payara.cd.jpa.jpasample.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jpa")
public class JakartaEE10Resource {
    
    @GET()
    @Path("ping")
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @GET()
    public Response getJpaData() {
        return Response
                .ok()
                .build();
    }
}
