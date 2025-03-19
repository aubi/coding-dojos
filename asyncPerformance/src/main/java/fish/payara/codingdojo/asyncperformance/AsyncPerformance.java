package fish.payara.codingdojo.asyncperformance;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class AsyncPerformance {

    private static final int REQUESTS = 1_000;
    private static final String URL = "http://localhost:8080/async/api/data/";

    public static void main(String[] args) {
// 100_000 - 43.561 s
        System.out.println("Concurrency Asynchronous calls:");
        executeRemoteAccess("asyncConc");
// 100_000 - 38.776 s
        System.out.println("Asynchronous calls:");
        executeRemoteAccess("async");
// 100_000 - 40.035 s
        System.out.println("ManagedExecutorService calls:");
        executeRemoteAccess("exec");
// 100_000 - 42.649 s, but got some problems around #99846
        System.out.println("JMS calls:");
        executeRemoteAccess("jms");
    }

    private static void executeRemoteAccess(String variant) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            try (HttpClient client = HttpClient.newBuilder().executor(executor).version(HttpClient.Version.HTTP_1_1/*HTTP_2*/).build()) {
                ObjectMapper objectMapper = new ObjectMapper();

                for (int i = 0; i < REQUESTS; i++) {
                    Data data = new Data(i, 81207.87613, 56, 46, variant);
                    String json = objectMapper.writeValueAsString(data);
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(new URI(URL + variant))
                            .header("Content-Type", "application/json") // Set the content type
                            .POST(HttpRequest.BodyPublishers.ofString(json)) // This is the default method
                            .build();
                    HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
                    System.out.printf("Request #%,6d executed, %s%n", i, variant);
                }
            } catch (IOException | InterruptedException | URISyntaxException ex) {
                Logger.getLogger(AsyncPerformance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
