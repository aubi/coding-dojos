package fish.payara.hello;

import jakarta.ejb.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Singleton
public class DownloadService {


    public String joke() throws IOException {
        HttpURLConnection request = createRequest();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(request.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        request.disconnect();
        return content.toString();
    }

    private HttpURLConnection createRequest() throws IOException {
        URL url = new URL("https://api.chucknorris.io/jokes/random");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con;
    }
}
