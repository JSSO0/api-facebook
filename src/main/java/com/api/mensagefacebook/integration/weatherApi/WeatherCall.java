package com.api.mensagefacebook.integration.weatherApi;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherCall {
    private final GetWeatherCity getWeatherCity;

    public WeatherCall( GetWeatherCity getWeatherCity) {
        this.getWeatherCity = getWeatherCity;
    }

    public String initializeIntegrationWeather(String cityName) throws IOException {

        return getWeatherCity.getWeather(cityName);

    }
}
