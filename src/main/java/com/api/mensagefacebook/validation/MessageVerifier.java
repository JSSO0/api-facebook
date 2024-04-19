package com.api.mensagefacebook.validation;

import com.api.mensagefacebook.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.model.MessageFacebookModel;

public class MessageVerifier {

    public String verifyMessage(MessageFacebookModel messageFacebookUser) throws ExceptionsPersonalized.VerifyMessageException {
        if (messageFacebookUser == null || messageFacebookUser.getText() == null) {
            return "Mensagem não fornecida";
        } else {
            return messageFacebookUser.getText();
        }
    }
}

