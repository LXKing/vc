package com.ccclubs.phoenix.tasks.model;

import java.io.Serializable;

/**
 * can历史
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
public class CsHistoryCan  implements Serializable {

    private Long cshcId;
    private Integer cshcAccess;
    private Integer cshcHost;
    private String cshcNumber;
    private Integer cshcCar;
    private Short cshcModel;//0:未知 1:北汽E150 2:奇瑞EQ 3:别克凯越 4:北汽绅宝C70 5:众泰Eway200 6:北汽D50 7:北汽D70 8:大众新捷达 9:现代索纳塔8 10:江淮IEV5 11:江淮IEV4
    private Short cshcType;//1:11bit 2:29bit
    private Long cshcOrder;
    private String cshcData;
    private String cshcFault;
    private Long cshcUploadTime;
    private Long cshcAddTime;
    private String cshcLarum;
    private String cshcPrompt;

    public Long getCshcId() {
        return cshcId;
    }

    public void setCshcId(Long cshcId) {
        this.cshcId = cshcId;
    }

    public Integer getCshcAccess() {
        return cshcAccess;
    }

    public void setCshcAccess(Integer cshcAccess) {
        this.cshcAccess = cshcAccess;
    }

    public Integer getCshcHost() {
        return cshcHost;
    }

    public void setCshcHost(Integer cshcHost) {
        this.cshcHost = cshcHost;
    }

    public String getCshcNumber() {
        return cshcNumber;
    }

    public void setCshcNumber(String cshcNumber) {
        this.cshcNumber = cshcNumber;
    }

    public Integer getCshcCar() {
        return cshcCar;
    }

    public void setCshcCar(Integer cshcCar) {
        this.cshcCar = cshcCar;
    }

    public Short getCshcModel() {
        return cshcModel;
    }

    public void setCshcModel(Short cshcModel) {
        this.cshcModel = cshcModel;
    }

    public Short getCshcType() {
        return cshcType;
    }

    public void setCshcType(Short cshcType) {
        this.cshcType = cshcType;
    }

    public Long getCshcOrder() {
        return cshcOrder;
    }

    public void setCshcOrder(Long cshcOrder) {
        this.cshcOrder = cshcOrder;
    }

    public String getCshcData() {
        return cshcData;
    }

    public void setCshcData(String cshcData) {
        this.cshcData = cshcData;
    }

    public String getCshcFault() {
        return cshcFault;
    }

    public void setCshcFault(String cshcFault) {
        this.cshcFault = cshcFault;
    }

    public Long getCshcUploadTime() {
        return cshcUploadTime;
    }

    public void setCshcUploadTime(Long cshcUploadTime) {
        this.cshcUploadTime = cshcUploadTime;
    }

    public Long getCshcAddTime() {
        return cshcAddTime;
    }

    public void setCshcAddTime(Long cshcAddTime) {
        this.cshcAddTime = cshcAddTime;
    }

    public String getCshcLarum() {
        return cshcLarum;
    }

    public void setCshcLarum(String cshcLarum) {
        this.cshcLarum = cshcLarum;
    }

    public String getCshcPrompt() {
        return cshcPrompt;
    }

    public void setCshcPrompt(String cshcPrompt) {
        this.cshcPrompt = cshcPrompt;
    }
}
