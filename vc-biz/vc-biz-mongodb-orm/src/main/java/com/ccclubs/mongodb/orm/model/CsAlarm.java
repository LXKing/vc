package com.ccclubs.mongodb.orm.model;

import com.ccclubs.frm.mongodb.lang.AutomaticSequence;

import java.io.Serializable;
import java.util.Date;

/**
 * 警报
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
public class CsAlarm extends AbstractDocumentOld implements Serializable {
    @AutomaticSequence
    private Long csaId;
    private Integer csaAccess;
    private Integer csaHost;
    private String csaNumber;
    private Integer csaCar;
    private Date csaAddTime;
    private String csaInfo;
    private String csaOrder;

    public Long getCsaId() {
        return csaId;
    }

    public void setCsaId(Long csaId) {
        this.csaId = csaId;
    }

    public Integer getCsaAccess() {
        return csaAccess;
    }

    public void setCsaAccess(Integer csaAccess) {
        this.csaAccess = csaAccess;
    }

    public Integer getCsaHost() {
        return csaHost;
    }

    public void setCsaHost(Integer csaHost) {
        this.csaHost = csaHost;
    }

    public String getCsaNumber() {
        return csaNumber;
    }

    public void setCsaNumber(String csaNumber) {
        this.csaNumber = csaNumber;
    }

    public Integer getCsaCar() {
        return csaCar;
    }

    public void setCsaCar(Integer csaCar) {
        this.csaCar = csaCar;
    }

    public Date getCsaAddTime() {
        return csaAddTime;
    }

    public void setCsaAddTime(Date csaAddTime) {
        this.csaAddTime = csaAddTime;
    }

    public String getCsaInfo() {
        return csaInfo;
    }

    public void setCsaInfo(String csaInfo) {
        this.csaInfo = csaInfo;
    }

    public String getCsaOrder() {
        return csaOrder;
    }

    public void setCsaOrder(String csaOrder) {
        this.csaOrder = csaOrder;
    }
}
