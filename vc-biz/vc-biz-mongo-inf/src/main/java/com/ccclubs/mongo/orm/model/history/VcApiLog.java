package com.ccclubs.mongo.orm.model.history;

import com.ccclubs.frm.spring.annotation.AutomaticSequence;
import com.ccclubs.mongo.orm.model.AbstractDocumentOld;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * API调用日志
 *
 * @author jianghaiyang
 * @create 2017-08-29
 **/
@Document(collection = "VcApiLog")
public class VcApiLog extends AbstractDocumentOld implements Serializable {
    //编号
    @AutomaticSequence
    private Long logId;
    /*调用者APPID*/
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
        logId = logId;
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
