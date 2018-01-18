package com.ccclubs.gateway.zotye.dto;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/1/18
 * \* Time: 14:35
 * \* Description:
 * \
 */
public class ZotyeMessageHeader implements Serializable{

    private static final long serialVersionUID = 1105358922053032971L;
    /**
     * 长度：4 Byte
     * 名称：报文头
     * 解释：固定的四个字节，恒为：0x74,0x42,0x6F,0x78。
     * */
    private Byte[] fixHeader;

    /**
     * 长度：1 Byte
     * 名称：服务数据校验
     * 解释：服务数据（ServiceDate）原始数据（未加密前）的异或值。
     * */
    private Byte serviceDateCheck;

    /**
     * 长度：1 Byte
     * 名称：服务版本
     * 解释：服务版本号，Aid服务版本，默认为0。
     * */
    private Byte serviceVersion;

    /**
     * 长度：4 Byte
     * 名称：识别Id
     * 解释：Tbox识别码。由“注册”服务提供，未注册时为0x00000000
     * */
    private Byte[] bid;

    /**
     * 长度：1 Byte
     * 名称：消息标记
     * 解释：消息标签，平台根据MessageFlag调度消息至不同模块具体参考ServiceList。
     * */
    private Byte messageFlag;

    public Byte[] getFixHeader() {
        return fixHeader;
    }

    public void setFixHeader(Byte[] fixHeader) {
        this.fixHeader = fixHeader;
    }

    public Byte getServiceDateCheck() {
        return serviceDateCheck;
    }

    public void setServiceDateCheck(Byte serviceDateCheck) {
        this.serviceDateCheck = serviceDateCheck;
    }

    public Byte getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(Byte serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public Byte[] getBid() {
        return bid;
    }

    public void setBid(Byte[] bid) {
        this.bid = bid;
    }

    public Byte getMessageFlag() {
        return messageFlag;
    }

    public void setMessageFlag(Byte messageFlag) {
        this.messageFlag = messageFlag;
    }
}
