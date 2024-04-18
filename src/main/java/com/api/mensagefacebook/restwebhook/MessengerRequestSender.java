package com.api.mensagefacebook.restwebhook;
import com.api.mensagefacebook.UrlWebhook.MessengerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MessengerRequestSender {

    @Autowired
    private MessengerUrl messengerUrl;

    public String sendRequest(String body) {
        System.out.println("04 - SendRequest");
        RestTemplate restTemplate = new RestTemplate();
        String url = messengerUrl.getUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}