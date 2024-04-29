package com.api.mensagefacebook.integration.weatherApi;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
@Component
public class FormatCityName {
    public String makeCityName(String cityName) throws IOException {

        cityName = cityName.trim();
        cityName = cityName.replace(" ", "-");
        cityName = URLEncoder.encode(cityName, StandardCharsets.UTF_8.toString());

        return cityName;
    }
}
