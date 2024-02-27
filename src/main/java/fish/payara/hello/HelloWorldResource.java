package fish.payara.hello;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("hello")
public class HelloWorldResource {

    @Inject
    @ConfigProperty(name = "defaultName", defaultValue = "world")
    private String defaultName;

    @GET
    public Response hello(@QueryParam("name") String name) {
        if ((name == null) || name.trim().isEmpty()) {
            name = defaultName;
        }
        return Response
                .ok(name)
                .build();
    }

    

}