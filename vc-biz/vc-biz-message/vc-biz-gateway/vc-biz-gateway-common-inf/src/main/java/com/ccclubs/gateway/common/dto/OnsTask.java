package com.ccclubs.gateway.common.dto;

/**
 * @Author: yeanzi
 * @Date: 2018/6/7
 * @Time: 15:22
 * Email:  yeanzhi@ccclubs.com
 * 发送至阿里云ons的消息
 */
public class OnsTask {

    private String tag;

    private String sourceHex;

    public OnsTask (String tag, String sourceHex) {
        this.tag = tag;
        this.sourceHex = sourceHex;
    }

    public String getTag() {
        return tag;
    }

    public OnsTask setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getSourceHex() {
        return sourceHex;
    }

    public OnsTask setSourceHex(String sourceHex) {
        this.sourceHex = sourceHex;
        return this;
    }
}
