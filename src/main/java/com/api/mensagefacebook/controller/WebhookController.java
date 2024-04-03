package com.api.mensagefacebook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @GetMapping("/webhook")
    public ResponseEntity<String> verifyWebhook(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.verify_token") String verifyToken,
            @RequestParam("hub.challenge") String challenge
    ) {
        if ("subscribe".equals(mode) && "EAAGEWHmp5oABO2MhOaIHa5kEIty9YF7grsdOfJLEdTWCP1BGGrZC9A74aTYUJ5ZBjvobqe61dZASSTWiuySehUv1Ncm2C7PULYUSkMOG6uzBJh0jLgYGI2mZAVZAFHwqpztkOVisLKc9E8JepuPuKHKRJVywSM0SFeBClZCkn5L4ioBC7lQSQanCkJMBjnnbX5oS3T8kAt5wZDZD".equals(verifyToken)) {
            return ResponseEntity.status(HttpStatus.OK).body(challenge);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}