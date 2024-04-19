package com.api.mensagefacebook.validation;

import com.api.mensagefacebook.model.MessageFacebookModel;

public class MessageVerifier {

    public String verifyMessage(MessageFacebookModel messageFacebookUser) {

        System.out.println("03 - Validador da mensagem");
        if (messageFacebookUser == null || messageFacebookUser.getText() == null) {
            return "Mensagem não fornecida";
        } else {
            return messageFacebookUser.getText();
        }
    }
}

