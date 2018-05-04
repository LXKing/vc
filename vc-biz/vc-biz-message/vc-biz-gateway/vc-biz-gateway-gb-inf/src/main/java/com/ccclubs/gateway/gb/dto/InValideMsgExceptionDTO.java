package com.ccclubs.gateway.gb.dto;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.gb.inf.IExceptionDtoJsonParse;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 19:29
 * Email:  yeanzhi@ccclubs.com
 * 校验异常包dto
 */
public class InValideMsgExceptionDTO implements IExceptionDtoJsonParse {

    private String vin;

    private String source;

    @Override
    public String toJson() {
        return JSON.toJSONString(this);
    }

    public String getVin() {
        return vin;
    }

    public InValideMsgExceptionDTO setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getSource() {
        return source;
    }

    public InValideMsgExceptionDTO setSource(String source) {
        this.source = source;
        return this;
    }
}
