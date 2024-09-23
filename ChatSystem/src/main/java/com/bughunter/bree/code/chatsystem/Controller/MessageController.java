package com.bughunter.bree.code.chatsystem.Controller;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Model.MessageModel;
import com.bughunter.bree.code.chatsystem.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    // Endpoint for sending messages
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public Message sendMessage(MessageModel messageModel) {
        return messageService.saveMessage(messageModel.getUserId(), messageModel);
    }

    // Endpoint for retrieving messages by date range
    @GetMapping("/messages/by-date")
    public ResponseEntity<List<Message>> getMessagesByDate(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        // Fetch messages within the provided date range
        List<Message> messages = messageService.getMessagesByDateRange(start, end);

        // Return the messages
        return ResponseEntity.ok(messages);
    }
}
