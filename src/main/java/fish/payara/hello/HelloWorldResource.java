package fish.payara.hello;

import fish.payara.hello.model.SampleData;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("hello")
public class HelloWorldResource {


    @GET
    public Response hello(@QueryParam("name") String name) {
        if ((name == null) || name.trim().isEmpty()) {
            name = "world";
        }
        return Response
                .ok(name)
                .build();
    }

    @Path("data")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response data() {
        return Response.ok(new SampleData(1, "test")).build();
    }

}