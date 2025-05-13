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

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Performance {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = URI.create("http://localhost:8080/hello-world/").toURL();

        long time1 = System.nanoTime();
        for (int i = 0; i < 1000; ++i) {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                System.out.println(responseBuilder.toString());
                //            assertNotNull(responseBuilder);
                //            assertTrue(responseBuilder.toString()
                //                    .contains("<html>"));
            }
        }
        System.out.println(System.nanoTime() - time1);
    }
}
