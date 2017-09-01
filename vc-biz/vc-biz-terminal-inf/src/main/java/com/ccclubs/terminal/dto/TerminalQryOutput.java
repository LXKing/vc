package com.ccclubs.terminal.dto;

import java.io.Serializable;

/**
 * 终端信息查询
 *
 * @author jianghaiyang
 * @create 2017-07-27
 **/
public class TerminalQryOutput implements Serializable {
    private String csmTeNo;//终端编号
    private Byte csmTeType;//终端类型:0:车厘子,1:中导,2:慧翰,3:通领
    private String csmTeModel;//终端型号
    private String csmTeCode;//厂商代码
    private String csmMobile;//手机号码
    private String csmIccid;//ICCID
    private String csmFunctions;//功能标签
    private Integer csmBluetoothVersion;//蓝牙版本
    private String csmBluetoothMac;//蓝牙地址
    private String csmBluetoothPsd;//蓝牙密码
    private Byte csmNetType;//网络类型
    private Integer csmBaudRate;//波特率
    private String csmV3;//DVD当前版本
    private String csmV3To;//DVD最新版本

    /*软件版本 硬件版本 插件版本*/
    private String softVersion;//软件版本
    private String hardVersion;//硬件版本
    private String pluginVersion;//插件版本

    public String getCsmTeNo() {
        return csmTeNo;
    }

    public void setCsmTeNo(String csmTeNo) {
        this.csmTeNo = csmTeNo;
    }

    public Byte getCsmTeType() {
        return csmTeType;
    }

    public void setCsmTeType(Byte csmTeType) {
        this.csmTeType = csmTeType;
    }

    public String getCsmTeModel() {
        return csmTeModel;
    }

    public void setCsmTeModel(String csmTeModel) {
        this.csmTeModel = csmTeModel;
    }

    public String getCsmTeCode() {
        return csmTeCode;
    }

    public void setCsmTeCode(String csmTeCode) {
        this.csmTeCode = csmTeCode;
    }

    public String getCsmMobile() {
        return csmMobile;
    }

    public void setCsmMobile(String csmMobile) {
        this.csmMobile = csmMobile;
    }

    public String getCsmIccid() {
        return csmIccid;
    }

    public void setCsmIccid(String csmIccid) {
        this.csmIccid = csmIccid;
    }

    public String getCsmFunctions() {
        return csmFunctions;
    }

    public void setCsmFunctions(String csmFunctions) {
        this.csmFunctions = csmFunctions;
    }

    public Integer getCsmBluetoothVersion() {
        return csmBluetoothVersion;
    }

    public void setCsmBluetoothVersion(Integer csmBluetoothVersion) {
        this.csmBluetoothVersion = csmBluetoothVersion;
    }

    public String getCsmBluetoothMac() {
        return csmBluetoothMac;
    }

    public void setCsmBluetoothMac(String csmBluetoothMac) {
        this.csmBluetoothMac = csmBluetoothMac;
    }

    public String getCsmBluetoothPsd() {
        return csmBluetoothPsd;
    }

    public void setCsmBluetoothPsd(String csmBluetoothPsd) {
        this.csmBluetoothPsd = csmBluetoothPsd;
    }

    public String getCsmV3() {
        return csmV3;
    }

    public void setCsmV3(String csmV3) {
        this.csmV3 = csmV3;
    }

    public String getCsmV3To() {
        return csmV3To;
    }

    public void setCsmV3To(String csmV3To) {
        this.csmV3To = csmV3To;
    }

    public Byte getCsmNetType() {
        return csmNetType;
    }

    public void setCsmNetType(Byte csmNetType) {
        this.csmNetType = csmNetType;
    }

    public Integer getCsmBaudRate() {
        return csmBaudRate;
    }

    public void setCsmBaudRate(Integer csmBaudRate) {
        this.csmBaudRate = csmBaudRate;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public String getHardVersion() {
        return hardVersion;
    }

    public void setHardVersion(String hardVersion) {
        this.hardVersion = hardVersion;
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }
}
