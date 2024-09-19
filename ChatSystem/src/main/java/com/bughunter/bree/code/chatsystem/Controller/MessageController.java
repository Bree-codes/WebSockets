package com.bughunter.bree.code.chatsystem.Controller;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/messaging")
@RequiredArgsConstructor
public class MessageController {

    public final MessageService messageService;

    @PostMapping("/send/message")
    public ResponseEntity<String> saveMessage(@RequestBody Message message){
        message.setTimestamp(LocalDateTime.now());
        messageService.saveMessage(message);

        return ResponseEntity.ok("Message stored successfully.");
    }
    public ResponseEntity<String> fetchMessagesByDate(@RequestParam)
}
