package com.api.mensagefacebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mensagefacebook.atribuitions.DatabaseService;
import com.api.mensagefacebook.model.EntryModel;
import com.api.mensagefacebook.model.MessageWebhookModel;
import com.api.mensagefacebook.model.MessagingFacebookModel;

@Service
public class DatabaseCoordinatorService {

    @Autowired
    private DatabaseService databaseService;

    public void saveWebhookData(MessageWebhookModel messageWebhookModelt) {
        // Salva o EntryModel
        for (EntryModel entry : messageWebhookModelt.getEntry()) {
            databaseService.saveEntryModel(entry);

            // Salva o MessagingFacebookModel e seus componentes
            for (MessagingFacebookModel messaging : entry.getMessaging()) {
                databaseService.saveSenderModel(messaging.getSender());
                databaseService.saveRecipientModel(messaging.getRecipient());
                databaseService.saveMessageFacebookModel(messaging.getMessageFacebookUser());

                databaseService.saveMessagingFacebookModel(messaging, messaging.getSender().getId(), messaging.getMessageFacebookUser().getMid());
            }
        }
    }
}
