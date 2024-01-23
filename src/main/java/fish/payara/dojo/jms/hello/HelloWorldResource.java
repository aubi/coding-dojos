package fish.payara.dojo.jms.hello;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("hello")
public class HelloWorldResource {

    @Inject
    TopicCounter topicCounter;

    @GET
    public Response hello(@QueryParam("name") String name) {
        if ((name == null) || name.trim().isEmpty()) {
            name = "world " + " count is " + topicCounter.countMessage();
        }
        return Response
                .ok(name)
                .build();
    }

    
        
}