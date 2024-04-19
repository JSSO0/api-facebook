package com.api.mensagefacebook.message;

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

    public void sendMessage(String body,String recipientId, String receivedMessage ) {

        System.out.println("05 sendMessage: \n" + recipientId +"\n"+ body);

        String responseEntity = messengerRequestSender.sendRequest(body);
        System.out.println("Response from Facebook Messenger: " + responseEntity);
    }
}
