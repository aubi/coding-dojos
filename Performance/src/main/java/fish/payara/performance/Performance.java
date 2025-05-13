/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fish.payara.performance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Performance {
    private static final int TRIES = 10_000;

    public static void main(String[] args) throws MalformedURLException, IOException {
        measure("");
        measure("test");
    }

    private static void measure(String urlPath) throws MalformedURLException, IOException {
        System.out.println("Measuring path '" + urlPath + "'");
        URL url = URI.create("http://localhost:8080/hello-world-0.1-SNAPSHOT/" + urlPath).toURL();

        long time1 = System.nanoTime();
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < TRIES; ++i) {
                executorService.submit(() -> {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");

                        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                            StringBuilder responseBuilder = new StringBuilder();
                            String line;
                            while ((line = reader.readLine()) != null) {
                                responseBuilder.append(line);
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        long timeSpent = (System.nanoTime() - time1) / TRIES;
        Duration duration = Duration.ofNanos(timeSpent);
        System.out.println("It took " + duration + " seconds");

        System.out.printf("%.3f req/s%n", (1_000_000_000 / (double) timeSpent));
    }
}
