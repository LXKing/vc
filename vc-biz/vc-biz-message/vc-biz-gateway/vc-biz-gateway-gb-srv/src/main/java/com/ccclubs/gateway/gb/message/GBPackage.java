package com.ccclubs.gateway.gb.message;

import com.ccclubs.gateway.gb.constant.PacErrorType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 15:17
 * Email:  yeanzhi@ccclubs.com
 */
public final class GBPackage {
    /**
     * 源数据包缓冲区(引用)
     */
    private ByteBuf sourceBuff;

    /**
     * 原始消息对应的16进制字符串
     */
    private String sourceHexStr;

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
    private byte validCode;

    /**
     * 是否为校验异常包
     */
    private boolean errorPac;

    private PacErrorType pacErrorType;

    public static GBPackage valueOfEmpty() {
        GBPackage gbPackage = new GBPackage();
        gbPackage.setHeader(new PacHeader())
                .setBody(new PacBody())
                .setValidCode((byte)0x00)
                .setErrorPac(false);
        return gbPackage;
    }

    public String toLogString() {
        StringBuilder pacSb = new StringBuilder();
        pacSb
                .append("车机(").append(getHeader().getUniqueNo()).append(")")
                .append("上传")
                .append("[").append(getHeader().getCommandMark().getDes()).append("]消息.")
                .append("原始消息[").append(getSourceHexStr()).append("]");
        return pacSb.toString();
    }

    // getter and setter
    // ---------------------------------------------------------
    public ByteBuf getSourceBuff() {
        // 因为处理buffer时，总是希望拿到一个重置了readerIndex的buf
        if (Objects.nonNull(this.sourceBuff)) {
            this.sourceBuff.resetReaderIndex();
        }
        return this.sourceBuff;
    }

    public GBPackage setSourceBuff(ByteBuf sourceBuff) {
        this.sourceBuff = sourceBuff;
        if (StringUtils.isEmpty(this.sourceHexStr)) {
            this.sourceBuff.resetReaderIndex();
            this.sourceHexStr = ByteBufUtil.hexDump(this.sourceBuff);
            this.sourceBuff.resetReaderIndex();
        }
        return this;
    }

    public PacHeader getHeader() {
        return header;
    }

    public GBPackage setHeader(PacHeader header) {
        this.header = header;
        return this;
    }

    public PacBody getBody() {
        return body;
    }

    public GBPackage setBody(PacBody body) {
        this.body = body;
        return this;
    }

    public byte getValidCode() {
        return validCode;
    }

    public GBPackage setValidCode(byte validCode) {
        this.validCode = validCode;
        return this;
    }

    public boolean isErrorPac() {
        return errorPac;
    }

    public GBPackage setErrorPac(boolean errorPac) {
        this.errorPac = errorPac;
        return this;
    }

    public String getSourceHexStr() {
        return sourceHexStr;
    }

    public GBPackage setSourceHexStr(String sourceHexStr) {
        this.sourceHexStr = sourceHexStr;
        return this;
    }

    public PacErrorType getPacErrorType() {
        return pacErrorType;
    }

    public GBPackage setPacErrorType(PacErrorType pacErrorType) {
        this.pacErrorType = pacErrorType;
        return this;
    }
}
