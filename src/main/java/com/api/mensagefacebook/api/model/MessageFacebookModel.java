package com.api.mensagefacebook.api.model;

import org.springframework.stereotype.Component;

@Component
public class MessageFacebookModel {
    private String mid;
    private String text;

    // getters and setters
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
