package com.ccclubs.gateway.gb.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 21:04
 * Email:  yeanzhi@ccclubs.com
 * kafka发送工具类
 */
@ConfigurationProperties(prefix = "kafka.topic.gateway")
public class KafkaProperties {

    private String success;

    private String error;

    private String conn;

    private String test;

    public String getSuccess() {
        return success;
    }

    public KafkaProperties setSuccess(String success) {
        this.success = success;
        return this;
    }

    public String getError() {
        return error;
    }

    public KafkaProperties setError(String error) {
        this.error = error;
        return this;
    }

    public String getConn() {
        return conn;
    }

    public KafkaProperties setConn(String conn) {
        this.conn = conn;
        return this;
    }

    public String getTest() {
        return test;
    }

    public KafkaProperties setTest(String test) {
        this.test = test;
        return this;
    }
}
