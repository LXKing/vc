package com.ccclubs.gateway.gb.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 21:04
 * Email:  yeanzhi@ccclubs.com
 * kafka发送工具类
 */
@ConfigurationProperties(prefix = "kafka.topic.gateway.gb")
public class KafkaProperties {

    private String successLogin;
    private String successReal;
    private String successReissue;
    private String successLogout;
    private String successHeart;
    private String successTime;

    private String error;

    private String online;

    public String getSuccessLogin() {
        return successLogin;
    }

    public KafkaProperties setSuccessLogin(String successLogin) {
        this.successLogin = successLogin;
        return this;
    }

    public String getSuccessReal() {
        return successReal;
    }

    public KafkaProperties setSuccessReal(String successReal) {
        this.successReal = successReal;
        return this;
    }

    public String getSuccessReissue() {
        return successReissue;
    }

    public KafkaProperties setSuccessReissue(String successReissue) {
        this.successReissue = successReissue;
        return this;
    }

    public String getSuccessLogout() {
        return successLogout;
    }

    public KafkaProperties setSuccessLogout(String successLogout) {
        this.successLogout = successLogout;
        return this;
    }

    public String getSuccessHeart() {
        return successHeart;
    }

    public KafkaProperties setSuccessHeart(String successHeart) {
        this.successHeart = successHeart;
        return this;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public KafkaProperties setSuccessTime(String successTime) {
        this.successTime = successTime;
        return this;
    }

    public String getError() {
        return error;
    }

    public KafkaProperties setError(String error) {
        this.error = error;
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
