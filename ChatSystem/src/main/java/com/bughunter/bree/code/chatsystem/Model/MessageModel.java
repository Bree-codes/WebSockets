package com.bughunter.bree.code.chatsystem.Model;

import lombok.Data;

@Data
public class MessageModel {

    private String content;

    private Long replyToId;

    private String fileUrl;

}
