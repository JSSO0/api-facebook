package com.api.mensagefacebook.service;

import com.api.mensagefacebook.model.MessageFacebookModel;
import com.api.mensagefacebook.model.MessageWebhookModel;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private final MessageWebhookModel messageModel;

    @Autowired
    public MessageService(RestTemplateBuilder restTemplateBuilder, MessageWebhookModel messageModel) {
        this.restTemplate = restTemplateBuilder.build();
        this.messageModel = messageModel;
    }


    public void processMessage(Message message) {
        System.out.println("processMessage");
        System.out.print("processMessage");
        String url = "https://graph.facebook.com/v19.0/300107813175496/messages?recipient={id%3A"
                + messageModel.getEntry().get(0).getMessaging().get(0).getSender().getId()
                + "}&mesaging_type=RESPONSE&message={%22text%22%3A%22ola%22}&access_token=EAAGEWHmp5oABO7lqA4hmZACzmjiUBkKsBw2ZA2MhD4EWb3ZC2EpfSywcvAJcQ2cisCNZCFsHTmoWBhwkxG0yave4x6KAfQsbwd9sXgtxlCScN7v67zOiHJXBb7BnXXmD5aXmraLpdZCclDBQj0OhKZBJUJeEwuEv60SoCC9w27JZAuoe85G50BeH927ZBiZBEhI70EkdETpS6E3eGZAI4o1F8n1bBrMWTDtEop";
        System.out.println("url" + messageModel.getEntry().get(0).getMessaging().get(0).getSender().getId());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", "ps_l=0; ps_n=0");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
