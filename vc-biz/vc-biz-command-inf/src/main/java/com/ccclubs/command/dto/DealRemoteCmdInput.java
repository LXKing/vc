package com.ccclubs.command.dto;

import java.io.Serializable;

/**
 * 远程下发指令入参
 *
 * @author jianghaiyang
 * @create 2018-08-16
 **/
public class DealRemoteCmdInput implements Serializable {

    /**
     * 远程控制记录ID
     */
    private Long remoteId;
    /**
     * 控制值
     */
    private String strJson;

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }

    public String getStrJson() {
        return strJson;
    }

    public void setStrJson(String strJson) {
        this.strJson = strJson;
    }
}
