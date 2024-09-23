package com.bughunter.bree.code.chatsystem.Controller;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Model.MessageModel;
import com.bughunter.bree.code.chatsystem.Service.FileService;
import com.bughunter.bree.code.chatsystem.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/messaging")
@RequiredArgsConstructor
public class MessageController {

    //private final FileService fileService;
    private final MessageService messageService;

    // Endpoint for saving a message (can include file uploads)
    @PostMapping("/save")
    public ResponseEntity<String> saveMessage(@RequestParam("userId") Integer userId,
                                              @ModelAttribute MessageModel messageModel,
                                              @RequestParam(value = "file", required = false) MultipartFile file) {
        // Save the message (including optional file)
        messageService.saveMessage(userId, messageModel, file);
        return new ResponseEntity<>("Message saved successfully", HttpStatus.OK);
    }

    // Endpoint for retrieving messages by date range
    @GetMapping("/by-date")
    public ResponseEntity<List<Message>> getMessagesByDate(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        // Fetch messages within the provided date range
        List<Message> messages = messageService.getMessagesByDateRange(start, end);

        // Return the messages
        return ResponseEntity.ok(messages);
    }
}
