package com.api.mensagefacebook.validation;

import com.api.mensagefacebook.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.model.MessageFacebookModel;

public class MessageNullVerifier {

    public String verifyMessage(MessageFacebookModel text) throws ExceptionsPersonalized.VerifyMessageException {
        System.out.println(text);
        if (text == null || text.getText() == null) {
            return "Mensagem não fornecida";
        } else {
            return text.getText();
        }
    }
}

