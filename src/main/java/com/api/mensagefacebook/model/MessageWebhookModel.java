package com.api.mensagefacebook.model;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MessageWebhookModel {
    private String object;
    private List<EntryModel> entry;

    // getters and setters
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<EntryModel> getEntry() {
        return entry;
    }

    public void setEntry(List<EntryModel> entry) {
        this.entry = entry;
    }
}
