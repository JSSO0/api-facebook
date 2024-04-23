package com.api.mensagefacebook.messagesresponses;

import org.springframework.stereotype.Component;

@Component
public class MessagesResponse {

    public String messageText(String receivedMessage) {
        String response = "";

        switch (receivedMessage) {
            case "Oi":
                response = "Olá, vamos iniciar seu atendimento\n Qual a sua pergunta?";
                break;
            case "Qual seu nome?":
                response = "Joely";
                break;
            case "Qual sua idade?":
                response = "20 anos";
                break;
            default:
                response = "Desculpe, não entendi a pergunta.";
        }
        System.out.println(response);

        return response;
    }
}
