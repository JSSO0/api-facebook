package com.api.mensagefacebook.integration.weatherApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetWeatherCity {

    @Value("${weatherToken}")
    private static String weatherToken;


    public String getWeatherToken() {
        return weatherToken;
    }



    public String getWeather(String cityName) throws IOException {
        String apiKey = getWeatherToken();
        System.out.println(weatherToken);
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject main = jsonResponse.getJSONObject("main");
            double temperature = main.getDouble("temp");
            return "A temperatura em " + cityName + " é de " + (temperature - 273.15) + "°C.";
        } else {
            return "Falha ao obter a temperatura para " + cityName + ". Código de resposta: " + responseCode;
        }
    }

}