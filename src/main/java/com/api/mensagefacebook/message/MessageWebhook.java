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
        String accessToken = "\"access_token\":\"EAAGEWHmp5oABOz1oodWGENhgMDJCN62mZB9l2mh5rUzgMhA4IIbJ9ZCXzSKD9iz4PmsMDMXqoZC8tHSrscY2OaLzqPIvgrlJSQoT0OOZB7SDsNZClLzv4zL1Dxe46bFwx0S41tFMJtHnUHvPIouHfmqrCg39iIb33B6zHRfzRhNEcBSXIYzpYJK2M3mvsjAsvwG6Jb6BkxwZDZD\"";
        return String.format("{%s,%s,%s,%s}", recipient, message, messagingType, accessToken);
    }

}
