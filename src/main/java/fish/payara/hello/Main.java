package fish.payara.hello;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

public class Main {

    public static void main(String[] args) {
        // Default instance of client
        Client client = ClientBuilder.newClient();

        Response response = client.target("http://localhost:8080/rest/v1/entities")
                .request("text/plain").get();
    }
}
