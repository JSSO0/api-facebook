package com.api.mensagefacebook.validation;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebhookValidation {

    private static final String MY_VERIFY_TOKEN = "EAAGEWHmp5oABO1XcZBjFLAcLixW9QTEZCS31rjZAQghKQCwZAfZCThLhkKNt880h4qIxJJtJmeYgojGyfah52yteFKZCPyZAh4SEx27oqiLmTAUCBZCwQoDN01eEnXgNsiUOikBU9VZBqUxzw7aGUxxxs6i0ySPv2pIcwy4VpiOGWEtV2cWbJjNH7ymvffpFy1kD2jFGVExKL78s2bk8e7AmZCzIKGvwZDZD";

    public boolean validate(String verifyToken) {
        return "subscribe".equals(verifyToken) && MY_VERIFY_TOKEN.equals(verifyToken);
    }
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public boolean isValid(String json) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);

            // Verifica se todos os campos necessários estão presentes
            if (!rootNode.has("object")) return false;
            if (!rootNode.has("entry")) return false;

            JsonNode entryNode = rootNode.get("entry").get(0);
            if (!entryNode.has("time")) return false;
            if (!entryNode.has("id")) return false;
            if (!entryNode.has("messaging")) return false;

            JsonNode messagingNode = entryNode.get("messaging").get(0);
            if (!messagingNode.has("sender")) return false;
            if (!messagingNode.has("recipient")) return false;
            if (!messagingNode.has("timestamp")) return false;
            if (!messagingNode.has("message")) return false;

            JsonNode messageNode = messagingNode.get("message");
            if (!messageNode.has("mid")) return false;
            if (!messageNode.has("text")) return false;

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}