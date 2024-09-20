package com.bughunter.bree.code.chatsystem.Service;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Repository.MessageRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    public final MessageRepo messageRepo;

    public void saveMessage(Message message){
        log.info("Message saved successfully.");
        messageRepo.save(message);
    }

    public List<Message> getMessagesByDateRange(LocalDateTime startOfDay, LocalDateTime endOfDay) {
        return messageRepo.findAllByTimestampBetween(startOfDay, endOfDay);
    }

}
