package com.bughunter.bree.code.chatsystem.Model;

import lombok.Data;

@Data
public class MessageModel {

    private String content;

    private Integer  Id;

    private Long replyToId;
}
