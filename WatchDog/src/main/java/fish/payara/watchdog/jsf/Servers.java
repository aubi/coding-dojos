package fish.payara.watchdog.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Time;
import java.time.Duration;
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
        servers.add("http://google.com");
        servers.add("http://seznam.cz");
        servers.add("not-an-uri");
    }

    public List<String> getList() {
        return servers;
    }

    public void setList(List<String> servers) {
        this.servers = servers;
    }

    public List<TimeMeasurement> getTimes() {
        List<TimeMeasurement> times = new ArrayList<>();
        for (String s : servers) {
            URI uri = URI.create(s);
            try {
                long start = System.currentTimeMillis();

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                                 .uri(uri)
                                                 .build();
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                      .thenApply(HttpResponse::body)
                      .thenAccept(System.out::println)
                      .join();
                long end = System.currentTimeMillis();
                times.add(new TimeMeasurement(uri, Duration.ofMillis(end - start), null));
            } catch (Exception e) {
                times.add(new TimeMeasurement(uri, null, e.getMessage()));
            }
        }
        return times;
    }

    public record TimeMeasurement(URI target, Duration duration, String error) {
    
        public long getMS() {
            return duration == null ? -1 : duration.toMillis();
        }
        
    }

}
