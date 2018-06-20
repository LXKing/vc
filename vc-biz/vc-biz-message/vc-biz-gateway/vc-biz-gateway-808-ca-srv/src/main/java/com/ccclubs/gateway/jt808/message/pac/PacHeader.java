package com.ccclubs.gateway.jt808.message.pac;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 16:17
 * Email:  yeanzhi@ccclubs.com
 * 报文头
 */
public class PacHeader {
    /**
     * 消息ID
     */
    private Integer pacId;

    /**
     * 消息体属性
     */
    private PacContentAttr pacContentAttr;

    /**
     * 终端手机号
     */
    private String terMobile;

    /**
     * 消息流水号
     */
    private Integer pacSerialNo;

    /**
     * 消息包装封顶
     */
    private PacSealInfo pacSealInfo;


    public Integer getPacId() {
        return pacId;
    }

    public PacHeader setPacId(Integer pacId) {
        this.pacId = pacId;
        return this;
    }

    public PacContentAttr getPacContentAttr() {
        return pacContentAttr;
    }

    public PacHeader setPacContentAttr(PacContentAttr pacContentAttr) {
        this.pacContentAttr = pacContentAttr;
        return this;
    }

    public String getTerMobile() {
        return terMobile;
    }

    public PacHeader setTerMobile(String terMobile) {
        this.terMobile = terMobile;
        return this;
    }

    public Integer getPacSerialNo() {
        return pacSerialNo;
    }

    public PacHeader setPacSerialNo(Integer pacSerialNo) {
        this.pacSerialNo = pacSerialNo;
        return this;
    }

    public PacSealInfo getPacSealInfo() {
        return pacSealInfo;
    }

    public PacHeader setPacSealInfo(PacSealInfo pacSealInfo) {
        this.pacSealInfo = pacSealInfo;
        return this;
    }
}
