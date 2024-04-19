package com.api.mensagefacebook.message;

import com.api.mensagefacebook.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.restwebhook.MessengerRequestSender;
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
        String responseEntity = messengerRequestSender.sendRequest(body);
        System.out.println("Response from Facebook Messenger: " + responseEntity);
    }
}
