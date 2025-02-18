/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fish.payara.java21toys.java21toys;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Gaurav Gupta
 */
public class Java21Toys {

    public static void main(String[] args) throws URISyntaxException {
        String url = "http://petr.aubrecht.net/work/cd/apportionment-2020-tableA.csv";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(new URI(url)).GET().build();
        client.send(request, (res) -> {});
    }
}
