package fish.payara.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("hello")
public class HelloWorldResource {

//    @Inject
//    @ConfigProperty(name = "defaultName", defaultValue = "world")
//    private String defaultName;

    @Context
    private SecurityContext security;

    @GET
    public Response hello(@QueryParam("name") String name) {
        if ((name == null) || name.trim().isEmpty()) {
            name = "defaultName";
        }
        return Response
                .ok(name)
                .build();
    }

    @GET
    @Path("me")
    public Response me() {
        Principal userPrincipal = security.getUserPrincipal();
        return Response
                .ok(userPrincipal == null ? "Not logged in" : userPrincipal.getName())
                .build();
    }
    

}