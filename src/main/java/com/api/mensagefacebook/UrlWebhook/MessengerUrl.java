package com.api.mensagefacebook.UrlWebhook;

import org.springframework.stereotype.Component;

@Component
public class MessengerUrl {

    public String getUrl() {
        System.out.println("07 - getUrl");
        return "https://graph.facebook.com/v19.0/300107813175496/messages";
    }
}
