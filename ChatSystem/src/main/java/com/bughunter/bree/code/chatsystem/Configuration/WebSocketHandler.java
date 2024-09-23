/*
package com.bughunter.bree.code.chatsystem.Configuration;

import lombok.NonNull;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WebSocketHandler extends TextWebSocketHandler {

    private static Set<WebSocketSession> sessions = new HashSet<>();


    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) {
        sessions.add(session);

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        for(WebSocketSession webSocketSession : sessions){
            if(webSocketSession.isOpen()){
                try {
                    webSocketSession.sendMessage(message);
                }
                catch (IOException e){
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }
}
*/
