package com.api.mensagefacebook.api.service;

import com.api.mensagefacebook.api.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.api.message.MessageWebhook;
import com.api.mensagefacebook.api.message.SendMessageWebhook;
import com.api.mensagefacebook.api.model.MessageWebhookModel;
import com.api.mensagefacebook.api.restwebhook.MessengerRequestSender;

import com.api.mensagefacebook.bot.validation.MessageBodyValidator;
import com.api.mensagefacebook.bot.validation.MessageNullValidator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WebhookService {

    @Autowired
    private MessageWebhook messengerMessage;

    @Autowired
    private MessengerRequestSender messengerRequestSender;

    @Autowired
    private MessageBodyValidator messageBodyValidator;

    public ResponseEntity<String> verifyWebhook(String verifyToken, String challenge) {
        return ResponseEntity.status(HttpStatus.OK).body(challenge);
    }


    public void WebhookFacebookService(@NotNull MessageWebhookModel request) throws ExceptionsPersonalized.ServiceException {


        MessageNullValidator messageNullValidator = new MessageNullValidator();
        MessageBodyValidator messageBodyValidator = new MessageBodyValidator();
        SendMessageWebhook sendMessageWebhook = new SendMessageWebhook(messengerRequestSender);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonRequest = objectMapper.writeValueAsString(request);
            if (messageBodyValidator.isValidBodyMessage(jsonRequest)) {
                String receivedMessage = messageNullValidator.verifyMessageSender(request.getEntry().get(0).getMessaging().get(0).getMessage());
                String recipientId = messageNullValidator.verifyRecipientIdSender(request.getEntry().get(0).getMessaging().get(0).getSender());
                String body = messengerMessage.createBodyMessage(recipientId, receivedMessage);
                sendMessageWebhook.sendMessage(body, recipientId, receivedMessage);
            } else {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
