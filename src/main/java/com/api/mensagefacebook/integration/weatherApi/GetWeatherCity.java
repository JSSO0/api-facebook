package com.api.mensagefacebook.integration.weatherApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetWeatherCity {

    public String getWeather(String cityName) throws IOException {
        cityName = encodeCityName(cityName);
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=936723fe0a83c50a4cef000952cc96e4";

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

            return makeSucessResponseWeatherCity(temperature, cityName);

        } else {
            return makeFailResponseWeatherCity(cityName);
        }
    }


    private String makeSucessResponseWeatherCity(Double temperature, String cityName) throws IOException {

        cityName = decoderNameCity(cityName);
        return "A temperatura em " + cityName + " é de " + String.format("%.1f", (temperature - 273.15)) + "°C.";
    }

    private String makeFailResponseWeatherCity(String cityName) throws IOException {
        cityName = decoderNameCity(cityName);
        return "Falha ao obter a temperatura para " + cityName;
    }

    private String decoderNameCity(String cityName) throws IOException {
        String cityNameEncoded = cityName;
        String cityNameDecoded = URLDecoder.decode(cityNameEncoded, StandardCharsets.UTF_8.toString());
        return cityNameDecoded;
    }

    private String encodeCityName(String cityName) throws UnsupportedEncodingException {
        return URLEncoder.encode(cityName, StandardCharsets.UTF_8.toString());
    }
}