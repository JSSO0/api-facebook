package com.api.mensagefacebook.api.message;

import com.api.mensagefacebook.api.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.api.restwebhook.MessengerRequestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMessageWebhook {
    @Autowired
    private MessengerRequestSender messengerRequestSender;

    public SendMessageWebhook(MessengerRequestSender messengerRequestSender){
        this.messengerRequestSender = messengerRequestSender;
    }

    public void sendMessage(String body,String recipientId, String receivedMessage ) throws ExceptionsPersonalized.SendMessageException {
        String responseEntity = messengerRequestSender.createHeader(body);
        System.out.println("Response from Facebook Messenger: " + responseEntity);
    }
}
