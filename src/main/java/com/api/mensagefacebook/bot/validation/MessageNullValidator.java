package com.api.mensagefacebook.bot.validation;

import com.api.mensagefacebook.api.exceptions.ExceptionsPersonalized;
import com.api.mensagefacebook.api.model.MessageFacebookModel;
import com.api.mensagefacebook.api.model.SenderModel;

public class MessageNullValidator {

    public String verifyMessageSender(MessageFacebookModel text) throws ExceptionsPersonalized.VerifyMessageException {
        System.out.println(text);
        if (text == null || text.getText() == null) {
            return "Mensagem não fornecida";
        } else {
            return text.getText();
        }
    }

    public String verifyRecipientIdSender (SenderModel id) throws ExceptionsPersonalized.VerifyMessageException{
        System.out.println(id);
        if (id == null || id.getId() == null) {
            return "Id não fornecido ou error";
        } else {
            return id.getId();
        }
    }
}

