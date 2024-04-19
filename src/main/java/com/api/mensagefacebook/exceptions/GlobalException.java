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
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("01 - Erro no handleWebhook: "+ e);
    }
    @ExceptionHandler(ExceptionsPersonalized.ServiceException.class)
    public ResponseEntity<String> handleServiceException(ExceptionsPersonalized.ServiceException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("02 - Erro no handleWebhookService: "+ e);
    }

    @ExceptionHandler(ExceptionsPersonalized.VerifyMessageException.class)
    public ResponseEntity<String> handleVerifyMessage(ExceptionsPersonalized.VerifyMessageException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("03 - Erro no VerifyMessage: "+ e);
    }

    @ExceptionHandler(ExceptionsPersonalized.GetMessageException.class)
    public ResponseEntity<String> handleGetMessageException(ExceptionsPersonalized.GetMessageException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("04 - Erro no GetMessage: "+ e);
    }

    @ExceptionHandler(ExceptionsPersonalized.SendMessageException.class)
    public ResponseEntity<String> handleSendMessageException(ExceptionsPersonalized.SendMessageException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("05 - Erro no SendMessage: "+ e);
    }

    @ExceptionHandler(ExceptionsPersonalized.SendRequestException.class)
    public ResponseEntity<String> handleSendRequestException(ExceptionsPersonalized.SendRequestException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("06 - Erro no SendRequest: "+ e);
    }
    @ExceptionHandler(ExceptionsPersonalized.GetUrlException.class)
    public ResponseEntity<String> handleGetUrlException(ExceptionsPersonalized.GetUrlException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("07 - Erro no GetUrl: "+ e);
    }
}
