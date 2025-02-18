/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fish.payara.java21toys.java21toys;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Gaurav Gupta
 */
public class Java21Toys {

    public static void main(String[] args) throws URISyntaxException {
        String url = "https://petr.aubrecht.net/work/cd/apportionment-2020-tableA.csv";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            List<StateData> data = response.body()
                .lines()
                .skip(1)
                .map(line -> {
                    List<String> split = List.of(line.split(" "));
                    return new StateData(
                        split.get(0),
                        Integer.parseInt(split.get(1)),
                        Integer.parseInt(split.get(2)), Integer.parseInt(split.get(3)), Integer.parseInt(split.get(4)), Integer.parseInt(split.get(5)), Integer.parseInt(split.get(6)));
                }).toList();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
