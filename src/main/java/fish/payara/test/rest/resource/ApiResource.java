package fish.payara.test.rest.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/numbers")
public class ApiResource {

    @GET
    @Produces("text/plain")
    @Path("{number}")
    public int getSquare(@PathParam("number") int number) throws InterruptedException {
        Thread.sleep(1000);
        return number * number;
    }

    @GET
    @Produces("text/plain")
    @Path("/sequence/{number}")
    public int getSequenceSum (@PathParam("number") int number) {
        Client client = ClientBuilder.newClient();
        int sum = 0;
        for (int i = 0; i < 5; ++i) {
            sum += client.target("http://localhost:8080/dojo/api/numbers/" + (number + i))
                .request(MediaType.TEXT_PLAIN)
                .get(Integer.class);
        }
        return sum;
    }

}
