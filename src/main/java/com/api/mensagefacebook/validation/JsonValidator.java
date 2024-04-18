package com.api.mensagefacebook.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class JsonValidator {

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
