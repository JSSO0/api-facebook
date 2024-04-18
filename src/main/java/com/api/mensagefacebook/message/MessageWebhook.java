package com.api.mensagefacebook.message;

import com.api.mensagefacebook.messagesresponses.MessagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageWebhook {

    private MessagesResponse messagesresponse;

    @Autowired
    public MessageWebhook(MessagesResponse messagesresponse){
        this.messagesresponse = messagesresponse;
    }

    public String getMessage(String recipientId) {
        System.out.println("03 - getMessage");
        String recipient = String.format("\"recipient\":{\"id\":\"" + recipientId + "\"}");
        String message = "\"message\":{\"text\":\""+  messagesresponse.messageText() +"\"}";
        String messagingType = "\"messaging_type\":\"RESPONSE\"";
        String accessToken = "\"access_token\":\"EAAGEWHmp5oABO7lqA4hmZACzmjiUBkKsBw2ZA2MhD4EWb3ZC2EpfSywcvAJcQ2cisCNZCFsHTmoWBhwkxG0yave4x6KAfQsbwd9sXgtxlCScN7v67zOiHJXBb7BnXXmD5aXmraLpdZCclDBQj0OhKZBJUJeEwuEv60SoCC9w27JZAuoe85G50BeH927ZBiZBEhI70EkdETpS6E3eGZAI4o1F8n1bBrMWTDtEop\"";
        return String.format("{%s,%s,%s,%s}", recipient, message, messagingType, accessToken);
    }
}
