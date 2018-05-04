package com.ccclubs.gateway.gb.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 21:04
 * Email:  yeanzhi@ccclubs.com
 * kafka发送工具类
 */
@ConfigurationProperties(prefix = "kafka.topic.gateway.gb.error")
public class KafkaProperties {

    private String decode;

    private String process;

    private String online;

    public String getDecode() {
        return decode;
    }

    public KafkaProperties setDecode(String decode) {
        this.decode = decode;
        return this;
    }

    public String getProcess() {
        return process;
    }

    public KafkaProperties setProcess(String process) {
        this.process = process;
        return this;
    }

    public String getOnline() {
        return online;
    }

    public KafkaProperties setOnline(String online) {
        this.online = online;
        return this;
    }
}
