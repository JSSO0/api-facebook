package com.api.mensagefacebook.validation;

import org.springframework.stereotype.Component;

@Component
public class WebhookValidation {

    private static final String MY_VERIFY_TOKEN = "EAAGEWHmp5oABO2MhOaIHa5kEIty9YF7grsdOfJLEdTWCP1BGGrZC9A74aTYUJ5ZBjvobqe61dZASSTWiuySehUv1Ncm2C7PULYUSkMOG6uzBJh0jLgYGI2mZAVZAFHwqpztkOVisLKc9E8JepuPuKHKRJVywSM0SFeBClZCkn5L4ioBC7lQSQanCkJMBjnnbX5oS3T8kAt5wZDZD";

    public boolean validate(String mode, String verifyToken) {
        return "subscribe".equals(mode) && MY_VERIFY_TOKEN.equals(verifyToken);
    }
}