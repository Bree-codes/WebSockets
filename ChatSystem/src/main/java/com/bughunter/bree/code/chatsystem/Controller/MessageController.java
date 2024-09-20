package com.bughunter.bree.code.chatsystem.Controller;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Model.MessageModel;
import com.bughunter.bree.code.chatsystem.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/messaging")
@RequiredArgsConstructor
public class MessageController {

    public final MessageService messageService;

    // Endpoint for sending a message (including replies and file uploads)
    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageModel model) {
        Message replyTo = model.getReplyToId() != null ?
                messageService.getMessageById(model.getReplyToId()) : null;
        messageService.saveMessage(model.getContent(), model.getSender(), replyTo);
        return ResponseEntity.ok().build();
    }

    // Endpoint for retrieving messages by date range
    @GetMapping("/by-date")
    public ResponseEntity<List<Message>> getMessagesByDate(
            @RequestParam("start") String startDateTime,
            @RequestParam("end") String endDateTime) {

        LocalDateTime start = LocalDateTime.parse(startDateTime);
        LocalDateTime end = LocalDateTime.parse(endDateTime);

        List<Message> messages = messageService.getMessagesByDateRange(start, end);
        return ResponseEntity.ok(messages);
    }
}


