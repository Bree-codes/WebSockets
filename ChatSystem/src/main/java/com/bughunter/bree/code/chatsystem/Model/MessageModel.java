package com.bughunter.bree.code.chatsystem.Model;

import com.bughunter.bree.code.chatsystem.Entity.User;
import lombok.Data;

@Data
public class MessageModel {

    private String content;
    private User sender;
    private Long replyToId;
}
