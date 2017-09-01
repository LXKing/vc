package com.ccclubs.usr.dto;

import java.io.Serializable;

/**
 * @author jianghaiyang
 * @create 2017-08-29
 **/
public class ApiLogOutput implements Serializable {
    private Long logId;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }
}
