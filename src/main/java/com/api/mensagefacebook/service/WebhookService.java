package com.api.mensagefacebook.service;
import com.api.mensagefacebook.message.MessageWebhook;
import com.api.mensagefacebook.model.MessageWebhookModel;
import com.api.mensagefacebook.restwebhook.MessengerRequestSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    @Autowired
    private MessageWebhook messengerMessage;
    @Autowired
    private DatabaseCoordinatorService databaseCoordinatorService;
    @Autowired
    private MessengerRequestSender messengerRequestSender;

    public ResponseEntity<String> verifyWebhook(String verifyToken, String challenge) {
        return ResponseEntity.status(HttpStatus.OK).body(challenge);
    }

    public void handleWebhook(MessageWebhookModel request) {
        System.out.println("HandleWebhook");
        String recipientId = request.getEntry().get(0).getMessaging().get(0).getSender().getId();
        System.out.println("ID" + recipientId);
        String body = messengerMessage.getMessage(recipientId);
        String responseEntity = messengerRequestSender.sendRequest(body);
        System.out.println("Response from Facebook Messenger: " + responseEntity);
        //databaseCoordinatorService.saveWebhookData(request);
    }
}
