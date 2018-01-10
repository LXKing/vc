package com.ccclubs.terminal.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * 终端信息模糊查询
 *
 * @author qsxiaogang
 * @create 2017-11-16
 **/
public class TerminalListQryInput implements Serializable {
    @NotNull(message = "T-Box序列号必填")
    @Length(min = 4,message = "最少输入T-Box序列号4位")
    private String key;

    private String appId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
