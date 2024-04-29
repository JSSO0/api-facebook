package com.api.mensagefacebook.api.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EntryModel {
    private long time;
    private String id;
    private List<MessagingFacebookModel> messaging;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MessagingFacebookModel> getMessaging() {
        return messaging;
    }

    public void setMessaging(List<MessagingFacebookModel> messaging) {
        this.messaging = messaging;
    }
}
