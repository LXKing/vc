package com.ccclubs.gateway.zotye.dto;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/1/18
 * \* Time: 14:58
 * \* Description:
 * \
 */
public class ZotyeDispatchDate implements Serializable {
    private static final long serialVersionUID = -8428007315939895616L;

    /**
     * 长度： 4Byte
     * 名称：事件创建时间
     * 含义：事件创建时间，从1970-01-01 00:00:00到现在的秒数，
     * 在同一事件中应该保持一致。
     * */
    private Byte[] eventCreationTime;

    /**
     * 长度： 1Byte
     * 名称：应用Id
     * 含义：Application Id,T服务Id，具体参考服务的指令列表。
     * */
    private Byte aid;

    /**
     * 长度： 1Byte
     * 名称：消息类型Id
     * 含义：Message Type Id，当前服务下的消息Id，具体参考服务的指令列表。
     * */
    private Byte mid;

    /**
     * 长度： 2Byte
     * 名称：消息标记
     * 含义：对当前服务及eventCreationTime事件的上下链路分别进行计数.
     * byte[0]对应uplinkCount,byte[1]对应downlinkCount。
     * */
    private Byte[] messageCounter;

    /**
     * 长度： 2Byte
     * 名称：消息长度
     * 含义：ServiceDate（加密后）的长度。
     * */
    private Byte[] serviceDateLength;

    /**
     * 长度： 1Byte
     * 名称：返回结果
     * 含义：（服务器）对消息结果的确认，上行时保持为0。
     * */
    private Byte result;

    /**
     * 长度： 1Byte
     * 名称：密钥版本
     * 含义：密钥版本号（密钥类型），为0时为不加密。
     * */
    private Byte securityVersion;

    /**
     * 长度： 4 Byte
     * 名称：消息创建时间
     * 含义：当前消息的创建时间，从1970-01-01 00:00:00到现在的秒数。
     * */
    private Byte[] dispatchCreationTime;

    public Byte[] getEventCreationTime() {
        return eventCreationTime;
    }

    public void setEventCreationTime(Byte[] eventCreationTime) {
        this.eventCreationTime = eventCreationTime;
    }

    public Byte getAid() {
        return aid;
    }

    public void setAid(Byte aid) {
        this.aid = aid;
    }

    public Byte getMid() {
        return mid;
    }

    public void setMid(Byte mid) {
        this.mid = mid;
    }

    public Byte[] getMessageCounter() {
        return messageCounter;
    }

    public void setMessageCounter(Byte[] messageCounter) {
        this.messageCounter = messageCounter;
    }

    public Byte[] getServiceDateLength() {
        return serviceDateLength;
    }

    public void setServiceDateLength(Byte[] serviceDateLength) {
        this.serviceDateLength = serviceDateLength;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public Byte getSecurityVersion() {
        return securityVersion;
    }

    public void setSecurityVersion(Byte securityVersion) {
        this.securityVersion = securityVersion;
    }

    public Byte[] getDispatchCreationTime() {
        return dispatchCreationTime;
    }

    public void setDispatchCreationTime(Byte[] dispatchCreationTime) {
        this.dispatchCreationTime = dispatchCreationTime;
    }
}
