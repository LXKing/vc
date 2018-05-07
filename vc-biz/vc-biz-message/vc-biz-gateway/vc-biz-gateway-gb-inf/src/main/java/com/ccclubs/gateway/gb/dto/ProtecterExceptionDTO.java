package com.ccclubs.gateway.gb.dto;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.gb.inf.IExceptionDtoJsonParse;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 19:14
 * Email:  yeanzhi@ccclubs.com
 * 守卫者处理异常dto
 */
public class ProtecterExceptionDTO implements IExceptionDtoJsonParse {

    private String causeMsg;

    @Override
    public String toJson() {
        return JSON.toJSONString(this);
    }



    public String getCauseMsg() {
        return causeMsg;
    }

    public ProtecterExceptionDTO setCauseMsg(String causeMsg) {
        this.causeMsg = causeMsg;
        return this;
    }
}
