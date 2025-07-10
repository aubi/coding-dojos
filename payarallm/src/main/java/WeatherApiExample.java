/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiExample {
    public static String getWeather(String city) {
        String apiKey = "46478374cf2d4a6c8d4143123250207";
        String url = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String city = "Lucknow";
        String weatherJson = getWeather(city);
        System.out.println("Raw JSON Response:");
        System.out.println(weatherJson);
    }
}
/**
 * {"location":{"name":"Lucknow","region":"Uttar Pradesh","country":"India","lat":26.85,"lon":80.917,"tz_id":"Asia/Kolkata","localtime_epoch":1751467221,"localtime":"2025-07-02 20:10"},"current":{"last_updated_epoch":1751466600,"last_updated":"2025-07-02 20:00","temp_c":31.0,"temp_f":87.8,"is_day":0,"condition":{"text":"Mist","icon":"//cdn.weatherapi.com/weather/64x64/night/143.png","code":1030},"wind_mph":7.8,"wind_kph":12.6,"wind_degree":101,"wind_dir":"ESE","pressure_mb":997.0,"pressure_in":29.44,"precip_mm":0.0,"precip_in":0.0,"humidity":84,"cloud":50,"feelslike_c":33.0,"feelslike_f":91.5,"windchill_c":34.3,"windchill_f":93.7,"heatindex_c":39.4,"heatindex_f":102.9,"dewpoint_c":22.2,"dewpoint_f":72.0,"vis_km":5.0,"vis_miles":3.0,"uv":0.0,"gust_mph":11.7,"gust_kph":18.8}
 */