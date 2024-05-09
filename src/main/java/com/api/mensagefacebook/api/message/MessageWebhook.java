package com.api.mensagefacebook.api.message;

import com.api.mensagefacebook.api.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.api.restwebhook.MessengerRequestSender;
import com.api.mensagefacebook.bot.messagesresponses.MessageMatcherResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageWebhook {
    @Value("${token}")
    private String token;

    private MessageMatcherResponse messagesresponse;
    @Autowired
    private MessengerRequestSender messengerRequestSender;

    @Autowired
    public MessageWebhook(MessageMatcherResponse messagesresponse, MessengerRequestSender messengerrequestsender) {
        this.messengerRequestSender = messengerrequestsender;
        this.messagesresponse = messagesresponse;
    }

    public String createBodyMessage(String recipientId, String receivedMessage)
            throws ExceptionsPersonalized.GetMessageException, IOException {

        String recipient = String.format("\"recipient\":{\"id\":\"%s\"}",
                recipientId);
        String message = String.format("\"message\":{\"text\":\"%s\"}",
                messagesresponse.messageMatchers(receivedMessage));
        String messagingType = "\"messaging_type\":\"RESPONSE\"";
        String accessToken = "\"access_token\":\"" + token + "\"";

        return String.format("{%s,%s,%s,%s}", recipient, message, messagingType, accessToken);
    }

}
