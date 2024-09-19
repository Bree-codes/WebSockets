package com.bughunter.bree.code.chatsystem.Entity.Service;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import com.bughunter.bree.code.chatsystem.Entity.Repository.MessageRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    public final MessageRepo messageRepo;

    public void saveMessage(Message message){
        log.info("Message saved successfully.");
    }

}
