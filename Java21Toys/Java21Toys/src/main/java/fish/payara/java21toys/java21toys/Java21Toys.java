/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fish.payara.java21toys.java21toys;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
                    .map(line -> parseTSV(line))
                    .toList();

            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StateData parseTSV(String line) {
        List<String> split = List.of(line.split("\t"));
        String app20 = split.get(1);
        String over20 = split.get(3);
        String app10 = split.get(4);
        String over10 = split.get(6);
        StateData stateData = new StateData(
                split.get(0),
                app20.equals("X") ? null : Integer.parseInt(app20),
                Integer.parseInt(split.get(2)),
                over20.equals("X") ? null : Integer.parseInt(over20),
                app10.equals("X") ? null : Integer.parseInt(app10),
                Integer.parseInt(split.get(5)),
                over10.equals("X") ? null : Integer.parseInt(over10));
        return stateData;
    }
}
