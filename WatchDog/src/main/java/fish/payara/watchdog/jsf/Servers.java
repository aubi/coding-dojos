package fish.payara.watchdog.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubi
 */
@Named(value = "servers")
@RequestScoped
public class Servers {
    private List<String> servers = new ArrayList<>();
    /**
     * Creates a new instance of Servers
     */
    public Servers() {
        servers.add("google.com");
        servers.add("seznam.cz");
    }

    public List<String> getList() {
        return servers;
    }

    public void setList(List<String> servers) {
        this.servers = servers;
    }

    public List<String> getTimes() {
        List<String> times = new ArrayList<>();
        for (String s : servers) {
            try {
                long start = System.currentTimeMillis();

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                                 .uri(URI.create(s))
                                                 .build();
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                      .thenApply(HttpResponse::body)
                      .thenAccept(System.out::println)
                      .join();
                long end = System.currentTimeMillis();
                times.add((end - start) + "ms");
            } catch (Exception e) {
                times.add("0ms");
            }
        }
        return times;
    }

}
