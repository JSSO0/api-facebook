package com.api.mensagefacebook.service;

import com.api.mensagefacebook.message.MessageWebhook;
import com.api.mensagefacebook.message.SendMessageWebhook;
import com.api.mensagefacebook.model.MessageWebhookModel;
import com.api.mensagefacebook.restwebhook.MessengerRequestSender;

import com.api.mensagefacebook.validation.MessageVerifier;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    @Autowired
    private MessageWebhook messengerMessage;

    @Autowired
    private MessengerRequestSender messengerRequestSender;

    public ResponseEntity<String> verifyWebhook(String verifyToken, String challenge) {
        return ResponseEntity.status(HttpStatus.OK).body(challenge);
    }

    public void handleWebhookService(@NotNull MessageWebhookModel request) {
        System.out.println("02 - HandleWebhook: " + request);

        String recipientId = request.getEntry().get(0).getMessaging().get(0).getSender().getId();
        System.out.println("02 - RecipientId: \n" + recipientId);

        MessageVerifier messageVerifier = new MessageVerifier();
        String receivedMessage = messageVerifier
                .verifyMessage(request.getEntry().get(0).getMessaging().get(0).getMessageFacebookUser());


        String body = messengerMessage.getMessage(recipientId, receivedMessage);
        System.out.println(body);
        SendMessageWebhook sendMessageWebhook = new SendMessageWebhook(messengerRequestSender);
        sendMessageWebhook.sendMessage(body, recipientId, receivedMessage);

    }
}
