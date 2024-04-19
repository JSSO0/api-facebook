package com.api.mensagefacebook.exceptions;

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
}
