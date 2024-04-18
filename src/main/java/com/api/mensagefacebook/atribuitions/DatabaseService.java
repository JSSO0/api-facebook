package com.api.mensagefacebook.atribuitions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.api.mensagefacebook.config.DatabaseConnection;
import com.api.mensagefacebook.model.EntryModel;
import com.api.mensagefacebook.model.MessageFacebookModel;
import com.api.mensagefacebook.model.MessagingFacebookModel;
import com.api.mensagefacebook.model.RecipientModel;
import com.api.mensagefacebook.model.SenderModel;

@Component
public class DatabaseService {
    private final DatabaseConnection databaseConnection;

    public DatabaseService(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void saveEntryModel(EntryModel entry) {
        String sql = "INSERT INTO EntryModel (time, id) VALUES (?, ?)";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, entry.getTime());
            pstmt.setString(2, entry.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void saveSenderModel(SenderModel sender) {
        String sql = "INSERT INTO SenderModel (id) VALUES (?)";
    
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, sender.getId());
    
            pstmt.executeUpdate();
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void saveRecipientModel(RecipientModel recipient) {
        String sql = "INSERT INTO RecipientModel (id) VALUES (?)";
    
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, recipient.getId());
    
            pstmt.executeUpdate();
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void saveMessageFacebookModel(MessageFacebookModel message) {
        String sql = "INSERT INTO MessageFacebookModel (mid, text) VALUES (?, ?)";
    
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, message.getMid());
            pstmt.setString(2, message.getText());
    
            pstmt.executeUpdate();
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void saveMessagingFacebookModel(MessagingFacebookModel messaging, String senderId, String messageId) {
        String sql = "INSERT INTO MessagingFacebookModel ( timestamp, sender_id, recipient_id, message_mid) VALUES ( ?, ?, ?, ?)";
    
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setLong(2, messaging.getTimestamp());
            pstmt.setString(3, senderId);
            pstmt.setString(4, messaging.getRecipient().getId());
            pstmt.setString(5, messageId);
    
            pstmt.executeUpdate();
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
