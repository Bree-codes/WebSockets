package com.bughunter.bree.code.chatsystem.Service;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Entity.User;
import com.bughunter.bree.code.chatsystem.ExceptionHandler.MessageNotFoundException;
import com.bughunter.bree.code.chatsystem.Model.MessageModel;
import com.bughunter.bree.code.chatsystem.Repository.MessageRepo;
import com.bughunter.bree.code.chatsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final MessageRepo messageRepo;

    private final UserRepository userRepository;


    public Message saveMessage(Integer userId, MessageModel messageModel) {

        // Fetch the sender (user) from the database
        User sender = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Initialize a new message
        Message message = new Message();
        message.setContent(messageModel.getContent());
        message.setSender(sender);
        message.setTimestamp(LocalDateTime.now());

        // Handle the reply to a message
        if (messageModel.getReplyToId() != null) {
            Message replyToMessage = getMessageById(messageModel.getReplyToId());
            message.setReplyTo(replyToMessage);
        }

        if (messageModel.getFileUrl() != null) message.setFileUrl(messageModel.getFileUrl());

        // Save the message
        messageRepo.save(message);

        return message;
    }

    public List<Message> getMessagesByDateRange(LocalDateTime startOfDay, LocalDateTime endOfDay) {
        return messageRepo.findAllByTimestampBetween(startOfDay, endOfDay);
    }

    // Checking whether the message being replied to exists
    public Message getMessageById(Long id) {
        Optional<Message> messageOptional = messageRepo.findById(id);
        if (messageOptional.isPresent())
            return messageOptional.get();
        else
            throw new MessageNotFoundException("Message with id " + id + " not found");
    }
}
