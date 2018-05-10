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

}
