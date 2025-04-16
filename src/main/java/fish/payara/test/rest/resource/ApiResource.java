package fish.payara.test.rest.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
    public int getSequenceSum(@PathParam("number") int number) throws InterruptedException, ExecutionException {
        Client client = ClientBuilder.newClient();
        int sum = 0;
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            futures.add(client.target("http://localhost:8080/coding-dojos/api/numbers/" + (number + i))
                    .request(MediaType.TEXT_PLAIN)
                    .rx()
                    .get(Integer.class)
                    .toCompletableFuture());
        }

        for (CompletableFuture<Integer> future : futures) {
            sum += future.get();
        }

        return sum;
    }
}
