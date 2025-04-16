package fish.payara.test.rest.resource;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorDefinition;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Path("/numbers")
@ManagedExecutorDefinition(name = "java:app/VirtMES", maxAsync = 10, virtual = true)
public class ApiResource {
    @Resource(lookup = "java:app/VirtMES")
    private ManagedExecutorService mes;

    @GET
    @Produces("text/plain")
    @Path("{number}")
    public int getSquare(@PathParam("number") int number) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));
        return number * number;
    }

    @GET
    @Produces("text/plain")
    @Path("/sequence/{number}")
    public int getSequenceSum(@PathParam("number") int number) throws InterruptedException, ExecutionException {
        Client client = ClientBuilder.newClient();
        int sum = 0;
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
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

    @GET
    @Produces("text/plain")
    @Path("/sequenceVT/{number}")
    public int getSequenceSumVT(@PathParam("number") int number) throws InterruptedException, ExecutionException {
        Client client = ClientBuilder.newClient();
        int sum = 0;
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            final int ii = i;
            futures.add(mes.submit(() -> {
                return client.target("http://localhost:8080/coding-dojos/api/numbers/" + (number + ii))
                        .request(MediaType.TEXT_PLAIN)
                        .get(Integer.class);
            }));
        }
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        return sum;
    }

}
