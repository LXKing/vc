package com.ccclubs.mongodb.orm.model;

import com.ccclubs.frm.mongodb.lang.AutomaticSequence;

import java.io.Serializable;
import java.util.Date;

/**
 * 报文
 *
 * @author jianghaiyang
 * @create 2017-08-09
 **/
public class CsMessage extends AbstractDocumentOld implements Serializable {
    //编号
    @AutomaticSequence
    private Long csmId;
    //授权系统
    private Integer csmAccess;
    //@caption("车机号")
    private String csmNumber;
    //@caption("关联车辆")
    private Long csmCar;
    //@caption("VIN码")
    private String csmVin;
    //@caption("规约类型")
    //@note(" 0:国标 1:地标  ")
    private Short csmProtocol;
    //@caption("报文类型")
    //@note(" 0:未知 1:车辆登入 2:实时上报 3:补发上报 4:车辆登出 5:平台登入 6:平台登出 7:心跳 8:终端校时  ")
    private Short csmType;
    //@caption("报文检验")
    //@note(" 1:成功 0:失败  ")
    private Short csmVerify;
    //@caption("报文时间")
    private Date csmMsgTime;
    //@caption("上传时间")
    private Date csmAddTime;
    //@caption("原始报文")
    private String csmData;
    //@caption("状态")
    //@note(" 1:成功 0:失败  ")
    private Short csmStatus;

    public Long getCsmId() {
        return csmId;
    }

    public void setCsmId(Long csmId) {
        this.csmId = csmId;
    }

    public Integer getCsmAccess() {
        return csmAccess;
    }

    public void setCsmAccess(Integer csmAccess) {
        this.csmAccess = csmAccess;
    }

    public String getCsmNumber() {
        return csmNumber;
    }

    public void setCsmNumber(String csmNumber) {
        this.csmNumber = csmNumber;
    }

    public Long getCsmCar() {
        return csmCar;
    }

    public void setCsmCar(Long csmCar) {
        this.csmCar = csmCar;
    }

    public String getCsmVin() {
        return csmVin;
    }

    public void setCsmVin(String csmVin) {
        this.csmVin = csmVin;
    }

    public Short getCsmProtocol() {
        return csmProtocol;
    }

    public void setCsmProtocol(Short csmProtocol) {
        this.csmProtocol = csmProtocol;
    }

    public Short getCsmType() {
        return csmType;
    }

    public void setCsmType(Short csmType) {
        this.csmType = csmType;
    }

    public Short getCsmVerify() {
        return csmVerify;
    }

    public void setCsmVerify(Short csmVerify) {
        this.csmVerify = csmVerify;
    }

    public Date getCsmMsgTime() {
        return csmMsgTime;
    }

    public void setCsmMsgTime(Date csmMsgTime) {
        this.csmMsgTime = csmMsgTime;
    }

    public Date getCsmAddTime() {
        return csmAddTime;
    }

    public void setCsmAddTime(Date csmAddTime) {
        this.csmAddTime = csmAddTime;
    }

    public String getCsmData() {
        return csmData;
    }

    public void setCsmData(String csmData) {
        this.csmData = csmData;
    }

    public Short getCsmStatus() {
        return csmStatus;
    }

    public void setCsmStatus(Short csmStatus) {
        this.csmStatus = csmStatus;
    }
}
