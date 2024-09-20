package com.bughunter.bree.code.chatsystem.Service;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Entity.User;
import com.bughunter.bree.code.chatsystem.ExceptionHandler.MessageNotFoundException;
import com.bughunter.bree.code.chatsystem.Repository.MessageRepo;
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

    public final MessageRepo messageRepo;

    public void saveMessage(String content, User sender, Message replyTo){
        
        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setTimestamp(LocalDateTime.now());
        message.setReplyTo(replyTo);
        messageRepo.save(message);
    }

    public List<Message> getMessagesByDateRange(LocalDateTime startOfDay, LocalDateTime endOfDay) {
        return messageRepo.findAllByTimestampBetween(startOfDay, endOfDay);
    }

    public Message getMessageById(Long id) {
        Optional<Message> messageOptional = messageRepo.findById(id);
        if (messageOptional.isPresent()) {
            return messageOptional.get();
        } else {
            throw new MessageNotFoundException("Message with id " + id + " not found");
        }
    }
}
