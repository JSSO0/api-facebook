package com.api.mensagefacebook.bot.validation;

import java.io.IOException;

import com.api.mensagefacebook.api.model.MessageWebhookModel;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageBodyValidator {

    private static final String MY_VERIFY_TOKEN = "EAAGEWHmp5oABO1XcZBjFLAcLixW9QTEZCS31rjZAQghKQCwZAfZCThLhkKNt880h4qIxJJtJmeYgojGyfah52yteFKZCPyZAh4SEx27oqiLmTAUCBZCwQoDN01eEnXgNsiUOikBU9VZBqUxzw7aGUxxxs6i0ySPv2pIcwy4VpiOGWEtV2cWbJjNH7ymvffpFy1kD2jFGVExKL78s2bk8e7AmZCzIKGvwZDZD";

    public boolean validate(String verifyToken) {
        return "subscribe".equals(verifyToken) && MY_VERIFY_TOKEN.equals(verifyToken);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public boolean isValidBodyMessage(String json) {
        try {
            JsonNode jsonObject = objectMapper.readTree(json);
            return hasRequiredFields(jsonObject);
        } catch (IOException e) {
            // Tratar a exceção de leitura do JSON (lançar exceção ou retornar false)
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
