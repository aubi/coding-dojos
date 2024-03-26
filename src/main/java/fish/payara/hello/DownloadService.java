package fish.payara.hello;

import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Singleton
public class DownloadService {

    private String joke;

    @Schedule(second = "*/2", hour = "*", minute = "*")
    public void downloadJoke() throws IOException {
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
        joke = joke + content.toString();
    }

    public String getJoke() {
        return joke;
    }

    private HttpURLConnection createRequest() throws IOException {
        URL url = new URL("https://api.chucknorris.io/jokes/random");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con;
    }
}
