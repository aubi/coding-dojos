package fish.payara.cd.jpa.jpasample.resources;

import fish.payara.cd.jpa.domain.Actor;
import fish.payara.cd.jpa.jpasample.JpaSampleService;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 *
 * @author 
 */
@Path("jpa")
public class JakartaEE10Resource {

    @EJB
    JpaSampleService jpaSampleService;
    
    @GET()
    @Path("ping")
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @GET()
    public Response getJpaData() {
        List<Actor>  actorList = jpaSampleService.loadJpaData();
        return Response
                .ok(actorList)
                .build();
    }

}
