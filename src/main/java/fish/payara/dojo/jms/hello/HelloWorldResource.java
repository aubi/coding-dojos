package fish.payara.dojo.jms.hello;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("hello")
public class HelloWorldResource {

//    @Inject
//    TopicCounter topicCounter;

    @Inject
    TestMessageService testMessageService;

    @GET
    public Response hello(@QueryParam("name") String name) {
//        if ((name == null) || name.trim().isEmpty()) {
//            name = "world " + " count is " + testMessageService;
//        }
        testMessageService.sendMessage(name);
        return Response
                .ok("Message was sent")
                .build();
    }



    
        
}