package com.ccclubs.gateway.jt808.message.pac;

import io.netty.buffer.ByteBuf;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 16:19
 * Email:  yeanzhi@ccclubs.com
 * 808报文
 */
public class Package808 {

    /*消息的原始部分*/

    /**
     * 消息头部
     */
    private PacHeader header;

    /**
     * 消息体
     */
    private PacBody body;

    /**
     * 消息的校正码
     */
    private Byte validCode;



    /*消息的附加部分*/
    /**
     * 源数据包缓冲区(引用)
     */
    private ByteBuf sourceBuff;

    /**
     * 原始消息对应的16进制字符串
     */
    private String sourceHexStr;

    /**
     * 是否为校验异常包
     */
    private Boolean errorPac;

    public static Package808 ofNew() {
        return new Package808()
                .setHeader(new PacHeader())
                .setBody(new PacBody())
                .setErrorPac(false);
    }

    public PacHeader getHeader() {
        return header;
    }

    public Package808 setHeader(PacHeader header) {
        this.header = header;
        return this;
    }

    public PacBody getBody() {
        return body;
    }

    public Package808 setBody(PacBody body) {
        this.body = body;
        return this;
    }

    public Byte getValidCode() {
        return validCode;
    }

    public Package808 setValidCode(Byte validCode) {
        this.validCode = validCode;
        return this;
    }

    public ByteBuf getSourceBuff() {
        return sourceBuff;
    }

    public Package808 setSourceBuff(ByteBuf sourceBuff) {
        this.sourceBuff = sourceBuff;
        return this;
    }

    public String getSourceHexStr() {
        return sourceHexStr;
    }

    public Package808 setSourceHexStr(String sourceHexStr) {
        this.sourceHexStr = sourceHexStr;
        return this;
    }

    public Boolean getErrorPac() {
        return errorPac;
    }

    public Package808 setErrorPac(Boolean errorPac) {
        this.errorPac = errorPac;
        return this;
    }
}
