package com.api.mensagefacebook.bot.messagesresponses;

import com.api.mensagefacebook.integration.weatherApi.WeatherCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;

@Component
public class MessageMatcherResponse {
    @Autowired
    private MessagePattern messagePattern;
    @Autowired
    private final WeatherCall weatherCall;

    public MessageMatcherResponse(WeatherCall weatherCall) {
        this.weatherCall = weatherCall;
    }

    public String messageMatchers(String receivedMessage) throws IOException {

        Matcher oiMatcher = MessagePattern.regexPatterns.oiPattern.matcher(receivedMessage);
        Matcher nomeMatcher = MessagePattern.regexPatterns.nomePattern.matcher(receivedMessage);
        Matcher idadeMatcher = MessagePattern.regexPatterns.idadePattern.matcher(receivedMessage);
        Matcher cityMatcher = MessagePattern.regexPatterns.cityPattern.matcher(receivedMessage);

        return messageFindToBot(oiMatcher, nomeMatcher, idadeMatcher, cityMatcher, receivedMessage);
    }

    private String messageFindToBot(
            Matcher oiMatcher, Matcher nomeMatcher, Matcher idadeMatcher, Matcher cityMatcher, String receivedMessage)
            throws IOException {

        String response = "";
        if (oiMatcher.matches()) {
            response = "Olá, vamos iniciar seu atendimento. Qual a sua pergunta?";
        } else if (nomeMatcher.matches()) {
            response = "Joely";
        } else if (idadeMatcher.matches()) {
            response = "20 anos";
        } else if (cityMatcher.matches()) {
            String cityName = cityMatcher.group(1);
            response = weatherCall.initializeIntegrationWeather(cityName);

        } else {
            response = "Desculpe, não entendi a pergunta.";
        }
        return response;
    }

}
