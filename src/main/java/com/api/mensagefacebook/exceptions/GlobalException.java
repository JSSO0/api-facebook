package com.api.mensagefacebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor: " + e);
    }

    @ExceptionHandler(ExceptionsPersonalized.ControllerException.class)
    public ResponseEntity<String> handleControllerException(ExceptionsPersonalized.ControllerException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("01 - Erro no Controller, Class handleWebhook: "+ e);
    }
    @ExceptionHandler(ExceptionsPersonalized.ServiceException.class)
    public ResponseEntity<String> handleServiceException(ExceptionsPersonalized.ServiceException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("02 - Erro no Service, Class handleWebhookService: "+ e);
    }
}
