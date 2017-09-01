package com.ccclubs.usr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * api日志
 *
 * @author jianghaiyang
 * @create 2017-08-29
 **/
public class ApiLogInput implements Serializable{
    /*日志ID*/
    private Long logId;
    /*用户ID*/
    private String appId;
    /*接口URL*/
    private String url;
    /*接口调用方式*/
    private String httpMethod;
    /*调用者IP*/
    private String ip;
    /*接口类&方法*/
    private String classMethod;
    /*输入参数*/
    private String input;
    /*输出参数*/
    private String output;
    /*输入时间*/
    private Date inTime;
    /*输出时间*/
    private Date outTime;
    /*调用时间ms*/
    private Long elapsed;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Long getElapsed() {
        return elapsed;
    }

    public void setElapsed(Long elapsed) {
        this.elapsed = elapsed;
    }
}
