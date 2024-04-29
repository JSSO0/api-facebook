package com.api.mensagefacebook.bot.validation;

import java.io.IOException;

import com.api.mensagefacebook.api.model.MessageWebhookModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageBodyValidator {
    @Value("${verifyToken}")
    private String verifyToken;

    public boolean validate(String verifyToken) {
        return "subscribe".equals(verifyToken) && verifyToken.equals(verifyToken);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public boolean isValidBodyMessage(String json) {
        try {
            JsonNode jsonObject = objectMapper.readTree(json);
            return hasRequiredFields(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean hasRequiredFields(JsonNode jsonObject) {
        return jsonObject.has("object") &&
                jsonObject.has("entry") &&
                hasRequiredEntryFields(jsonObject.get("entry").get(0));
    }

    private boolean hasRequiredEntryFields(JsonNode entryNode) {
        return entryNode.has("time") &&
                entryNode.has("id") &&
                entryNode.has("messaging") &&
                hasRequiredMessagingFields(entryNode.get("messaging").get(0));
    }

    private boolean hasRequiredMessagingFields(JsonNode messagingNode) {
        return messagingNode.has("sender") &&
                messagingNode.has("recipient") &&
                messagingNode.has("timestamp") &&
                messagingNode.has("message") &&
                hasRequiredMessageFields(messagingNode.get("message"));
    }

    private boolean hasRequiredMessageFields(JsonNode messageNode) {
        return messageNode.has("mid") && messageNode.has("text");
    }


}
