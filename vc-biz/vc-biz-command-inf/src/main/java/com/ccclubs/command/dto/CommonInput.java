package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 共有input属性
 *
 * @author jianghaiyang
 * @create 2017-07-25
 **/
public class CommonInput implements Serializable {
    private String appId;

    @NotNull
    @InArray(range = {1, 2, 3}, message = "指令结果确认方式：1:async,2:sync,3:http")
    private Integer resultType = 1;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }
}
