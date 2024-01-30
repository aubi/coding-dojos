package fish.payara.hello;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("hello")
public class HelloWorldResource {

    @Inject
    TestClient testClient;

    @GET
    public Response hello(@QueryParam("name") String name) {
        if ((name == null) || name.trim().isEmpty()) {
            name = "world";
        }
        return Response
                .ok(name)
                .build();
    }

    @Inject
    ProcessingManager processingManager;

    @GET
    @Path("uuids")
    public String uuids(@QueryParam("number") @DefaultValue("1") int number) {
        return processingManager.expensiveComputation(number);
    }

    @GET
    @Path("sendMessage")
    public void setMessage(@QueryParam("message") String msg) {
        testClient.sendMessage(msg);
    }
        
}