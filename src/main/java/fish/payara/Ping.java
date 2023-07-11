package fish.payara;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/ping")
public class Ping {

    @GET
    public Response pong() {
        return Response.ok("Pong").build();
    }
}
