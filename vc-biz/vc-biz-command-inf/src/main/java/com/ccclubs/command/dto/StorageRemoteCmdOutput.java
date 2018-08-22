package com.ccclubs.command.dto;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @time 2018/8/21
 * @auther Alban
 * @email fengjun@ccclubs.com
 * @description 请填写描述！
 */
public class StorageRemoteCmdOutput  implements Serializable {

    private static final long serialVersionUID = 2476097876337185471L;

    /**
     * 远程控制记录ID
     */
    private Long remoteId;

    private String strJson;

    public String getStrJson() {
        return strJson;
    }

    public void setStrJson(String strJson) {
        this.strJson = strJson;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }
}
