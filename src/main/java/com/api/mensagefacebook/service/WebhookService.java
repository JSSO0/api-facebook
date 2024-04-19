package com.api.mensagefacebook.service;

import com.api.mensagefacebook.exceptions.ExceptionsPersonalized;
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

    public void handleWebhookService(@NotNull MessageWebhookModel request) throws ExceptionsPersonalized.ServiceException {
        String recipientId = request.getEntry().get(0).getMessaging().get(0).getSender().getId();
        MessageVerifier messageVerifier = new MessageVerifier();
        String receivedMessage = messageVerifier
                .verifyMessage(request.getEntry().get(0).getMessaging().get(0).getMessageFacebookUser());
        String body = messengerMessage.getMessage(recipientId, receivedMessage);
        SendMessageWebhook sendMessageWebhook = new SendMessageWebhook(messengerRequestSender);
        sendMessageWebhook.sendMessage(body, recipientId, receivedMessage);

    }
}
