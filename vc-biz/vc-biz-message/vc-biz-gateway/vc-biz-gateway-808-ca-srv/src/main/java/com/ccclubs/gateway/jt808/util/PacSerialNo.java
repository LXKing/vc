package com.ccclubs.gateway.jt808.util;

/**
 * @Author: yeanzi
 * @Date: 2018/6/8
 * @Time: 11:13
 * Email:  yeanzhi@ccclubs.com
 * 包序列号
 */
public class PacSerialNo {

    // 序列号
    private short value;

    public PacSerialNo(short value) {
        this.value = value;
    }

    public PacSerialNo increase() {
        if (value == Short.MAX_VALUE) {
            value = 0;
        } else {
            value ++;
        }
        return this;
    }

    public short getValue() {
        return value;
    }

    public PacSerialNo setValue(short value) {
        this.value = value;
        return this;
    }
}
