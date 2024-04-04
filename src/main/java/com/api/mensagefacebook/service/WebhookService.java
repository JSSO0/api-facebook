package com.api.mensagefacebook.service;

import com.api.mensagefacebook.validation.WebhookValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    private final WebhookValidation webhookValidation;

    public WebhookService(WebhookValidation webhookValidation) {
        this.webhookValidation = webhookValidation;
    }

    public ResponseEntity<String> verifyWebhook(String mode, String verifyToken, String challenge) {
        // Validação
        if (!webhookValidation.validate(mode, verifyToken)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Verification failed.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(challenge);
    }

    public ResponseEntity<String> processUpdate(String payload) {
        // Processamento da carga útil
        System.out.println("Webhook event received: " + payload);
        // Aqui você pode adicionar a lógica do chatbot
        return ResponseEntity.status(HttpStatus.OK).body("EVENT_RECEIVED");
    }
}
