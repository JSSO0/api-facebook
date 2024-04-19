package com.api.mensagefacebook.message;

import com.api.mensagefacebook.exceptions.ExceptionsPersonalized;
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

    public String getMessage(String recipientId, String receivedMessage) throws ExceptionsPersonalized.GetMessageException {
        String recipient = String.format("\"recipient\":{\"id\":\"%s\"}", recipientId);
        String message = String.format("\"message\":{\"text\":\"%s\"}", messagesresponse.messageText(receivedMessage));
        String messagingType = "\"messaging_type\":\"RESPONSE\"";
        String accessToken = "\"access_token\":\"EAAGEWHmp5oABO84yWC4Qpu6o5dNaTCwZBKKlebF8x6qptnGexm28mK4Obg4lCHe8Dcia3En2sGv2iPqm8YbVvFdHxK5801uqq51n7IUzjUDJ1hTzxykOi0ufJChKB6T4FmKY1NNb8vRESkApShJZAl9XyZBHFcn4V3dOcKSRuckBtDQO8I0Y8uw1sczRilTHyAFl16ypZAq7m8lyms42h8MjZAICeah7m\"";
        return String.format("{%s,%s,%s,%s}", recipient, message, messagingType, accessToken);
    }

}
