package com.ccclubs.gateway.gb.dto;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.gb.inf.IExceptionDtoJsonParse;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 19:14
 * Email:  yeanzhi@ccclubs.com
 * 消息业务处理异常dto
 */
public class MsgValidateExceptionDTO implements IExceptionDtoJsonParse {

    private String causeMsg;

    // 校验异常出现的位置
    private int dataType;

    @Override
    public String toJson() {
        return JSON.toJSONString(this);
    }



    public String getCauseMsg() {
        return causeMsg;
    }

    public MsgValidateExceptionDTO setCauseMsg(String causeMsg) {
        this.causeMsg = causeMsg;
        return this;
    }

    public int getDataType() {
        return dataType;
    }

    public MsgValidateExceptionDTO setDataType(int dataType) {
        this.dataType = dataType;
        return this;
    }
}
