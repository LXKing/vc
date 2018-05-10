package com.ccclubs.gateway.gb.dto;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.gb.inf.IExceptionDtoJsonParse;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 21:29
 * Email:  yeanzhi@ccclubs.com
 * 包装解析异常信息
 */
public class MsgDecodeExceptionDTO implements IExceptionDtoJsonParse {

    // 记录当前解析的位置
    private int decodeMarkIndex;

    // 异常值
    private String exceptionVal;

    // 期望值
    private String expectedVal;

    // 异常原因
    private String reason;

    @Override
    public String toJson() {
        return JSON.toJSONString(this);
    }

    public String getExceptionVal() {
        return exceptionVal;
    }

    public MsgDecodeExceptionDTO setExceptionVal(String exceptionVal) {
        this.exceptionVal = exceptionVal;
        return this;
    }

    public String getExpectedVal() {
        return expectedVal;
    }

    public MsgDecodeExceptionDTO setExpectedVal(String expectedVal) {
        this.expectedVal = expectedVal;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public MsgDecodeExceptionDTO setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public int getDecodeMarkIndex() {
        return decodeMarkIndex;
    }

    public MsgDecodeExceptionDTO setDecodeMarkIndex(int decodeMarkIndex) {
        this.decodeMarkIndex = decodeMarkIndex;
        return this;
    }
}
