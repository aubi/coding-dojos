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
import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Performance {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = URI.create("http://localhost:8080/hello-world-0.1-SNAPSHOT/").toURL();

        long time1 = System.nanoTime();
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; ++i) {
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


        long timeSpent = (System.nanoTime() - time1) / 1000;
        Duration duration = Duration.ofNanos(timeSpent);
        System.out.println("It took " + duration + " seconds");
    }
}
