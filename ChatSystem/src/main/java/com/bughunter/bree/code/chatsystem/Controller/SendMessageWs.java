package com.bughunter.bree.code.chatsystem.Controller;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Model.MessageModel;
import com.bughunter.bree.code.chatsystem.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendMessageWs {


    private final MessageService messageService;

    // Endpoint for sending messages
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public Message sendMessage(MessageModel messageModel) {
        return messageService.saveMessage(messageModel.getUserId(), messageModel);
    }
}
