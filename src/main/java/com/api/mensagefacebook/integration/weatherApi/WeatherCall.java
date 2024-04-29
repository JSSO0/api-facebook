package com.api.mensagefacebook.integration.weatherApi;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherCall {
    private final GetWeatherCity getWeatherCity;
    private final FormatCityName formatCityName;

    public WeatherCall(FormatCityName formatCityName, GetWeatherCity getWeatherCity) {
        this.formatCityName = formatCityName;
        this.getWeatherCity = getWeatherCity;
    }

    public String initializeIntegrationWeather(String city) throws IOException {
        String CityName = formatCityName.makeCityName(city);

        return getWeatherCity.getWeather(CityName);

    }
}
