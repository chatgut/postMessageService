package com.example.postmessageservice.exception;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(Exception exception){
        super(exception);
    }
}
