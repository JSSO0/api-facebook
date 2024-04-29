package com.api.mensagefacebook.bot.messagesresponses;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
@Component
public class MessagePattern {
    public static class regexPatterns {
        static Pattern oiPattern = Pattern.compile("(?i)^oi$");
        static Pattern nomePattern = Pattern.compile("(?i)^qual seu nome[?]*$");
        static Pattern idadePattern = Pattern.compile("(?i)^qual sua idade[?]*$");
        static Pattern cityPattern = Pattern.compile("(?i)\\b(como está a temperatura em)\\b\\s+(\\b\\w+\\s?)+", Pattern.CASE_INSENSITIVE);
    }

}
