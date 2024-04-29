package com.api.mensagefacebook.api.exceptions;

public class ExceptionsPersonalized {
    public static class ControllerException extends RuntimeException {
        public ControllerException(String message) {
            super(message);
        }
    }

    public static class ServiceException extends RuntimeException {
        public ServiceException(String message) {
            super(message);
        }
    }

    public static class VerifyMessageException extends RuntimeException {
        public VerifyMessageException(String message) {
            super(message);
        }
    }

    public static class GetMessageException extends RuntimeException {
        public GetMessageException(String message) {
            super(message);
        }
    }

    public static class SendMessageException extends RuntimeException {
        public SendMessageException(String message) {
            super(message);
        }
    }

    public static class SendRequestException extends RuntimeException {
        public SendRequestException(String message) {
            super(message);
        }
    }

    public static class GetUrlException extends RuntimeException {
        public GetUrlException(String message) {
            super(message);
        }
    }


}
