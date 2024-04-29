package com.api.mensagefacebook.api.controller;

import com.api.mensagefacebook.api.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.api.model.MessageWebhookModel;
import com.api.mensagefacebook.api.service.WebhookService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class WebhookController {

    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {

        this.webhookService = webhookService;
    }

    @RequestMapping(value = "/webhookfacebook", method = RequestMethod.GET)
    public ResponseEntity<String> verifyWebhook(
            @RequestParam("hub.verify_token") String verifyToken,
            @RequestParam("hub.challenge") String challenge) {
        return webhookService.verifyWebhook(verifyToken, challenge);
    }

    @PostMapping("/webhookfacebook")
    public ResponseEntity<String> handleWebhook(@RequestBody MessageWebhookModel request) throws ExceptionsPersonalized.ControllerException {
        webhookService.WebhookFacebookService(request);
        return ResponseEntity.status(HttpStatus.OK).body("EVENT_RECEIVED");
    }
}
