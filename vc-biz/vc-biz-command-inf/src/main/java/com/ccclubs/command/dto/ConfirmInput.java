package com.ccclubs.command.dto;

import java.io.Serializable;

/**
 * @author jianghaiyang
 * @create 2017-07-25
 **/
public class ConfirmInput implements Serializable {
    private Long messageId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

}
