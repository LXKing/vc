package com.ccclubs.command.dto;

import java.io.Serializable;

/**
 * 共有输出属性
 *
 * @author jianghaiyang
 * @create 2017-07-25
 **/
public class CommonOutput implements Serializable{
    private Long messageId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}
