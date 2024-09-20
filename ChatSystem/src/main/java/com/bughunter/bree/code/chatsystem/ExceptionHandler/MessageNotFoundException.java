package com.bughunter.bree.code.chatsystem.ExceptionHandler;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException (String message){
        super(message);
    }
}
