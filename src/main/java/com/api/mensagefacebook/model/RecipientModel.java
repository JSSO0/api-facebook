package com.api.mensagefacebook.model;

import org.springframework.stereotype.Component;

@Component
public class RecipientModel {
    private String id;

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
