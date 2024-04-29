package com.api.mensagefacebook.api.restwebhook;

import com.api.mensagefacebook.api.exceptions.ExceptionsPersonalized;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MessengerRequestSender {

    @Value("${url}")
    private String urlBase;

    public String createHeader(String body) throws ExceptionsPersonalized.SendRequestException{
        RestTemplate restTemplate = new RestTemplate();
        String url = urlBase;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }
}