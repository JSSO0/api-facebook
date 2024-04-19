package com.api.mensagefacebook.message;

import com.api.mensagefacebook.messagesresponses.MessagesResponse;

import com.api.mensagefacebook.restwebhook.MessengerRequestSender;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageWebhook {

    private MessagesResponse messagesresponse;
    @Autowired
    private MessengerRequestSender messengerRequestSender;
    @Autowired
    public MessageWebhook(MessagesResponse messagesresponse, MessengerRequestSender messengerrequestsender){
        this.messengerRequestSender = messengerrequestsender;
        this.messagesresponse = messagesresponse;
    }

    public String getMessage(String recipientId, String receivedMessage) {
        System.out.println("04 - getMessage\n");

        String recipient = String.format("\"recipient\":{\"id\":\"%s\"}", recipientId);
        System.out.println("04 \n" + recipient);

        String message = String.format("\"message\":{\"text\":\"%s\"}", messagesresponse.messageText(receivedMessage));
        System.out.println("04 \n" + message);

        String messagingType = "\"messaging_type\":\"RESPONSE\"";
        String accessToken = "\"access_token\":\"EAAGEWHmp5oABO84yWC4Qpu6o5dNaTCwZBKKlebF8x6qptnGexm28mK4Obg4lCHe8Dcia3En2sGv2iPqm8YbVvFdHxK5801uqq51n7IUzjUDJ1hTzxykOi0ufJChKB6T4FmKY1NNb8vRESkApShJZAl9XyZBHFcn4V3dOcKSRuckBtDQO8I0Y8uw1sczRilTHyAFl16ypZAq7m8lyms42h8MjZAICeah7m\"";

        return String.format("{%s,%s,%s,%s}", recipient, message, messagingType, accessToken);
    }

   /* public void sendMessage(String recipientId, String receivedMessage, String body) {
        System.out.println("ID: " + recipientId);
        String responseEntity = messengerRequestSender.sendRequest(body);
        System.out.println("Response from Facebook Messenger: " + responseEntity);
    }*/
}
