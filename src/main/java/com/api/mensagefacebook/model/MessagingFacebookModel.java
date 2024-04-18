package com.api.mensagefacebook.model;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Component;
@Component
public class MessagingFacebookModel {
    private SenderModel sender;
    private RecipientModel recipient;
    private long timestamp;
    private MessageFacebookModel messageFacebookUser;

    // getters and setters
    public SenderModel getSender() {
        return sender;
    }

    public void setSender(SenderModel sender) {
        this.sender = sender;
    }

    public RecipientModel getRecipient() {
        return recipient;
    }

    public void setRecipient(RecipientModel recipient) {
        this.recipient = recipient;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public MessageFacebookModel getMessageFacebookUser() {
        return messageFacebookUser;
    }

    public void setMessageFacebookUser(MessageFacebookModel messageFacebookUser) {
        this.messageFacebookUser = messageFacebookUser;
    }
}
