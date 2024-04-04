package com.api.mensagefacebook.controller;

import com.api.mensagefacebook.service.WebhookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class WebhookController {

    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @RequestMapping(value = "/webhook", method = RequestMethod.GET)
    public ResponseEntity<String> verifyWebhook(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.verify_token") String verifyToken,
            @RequestParam("hub.challenge") String challenge
    ) {
        return webhookService.verifyWebhook(mode, verifyToken, challenge);
    }

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public ResponseEntity<String> receiveUpdate(@RequestBody String payload) {
        return webhookService.processUpdate(payload);
    }
}

