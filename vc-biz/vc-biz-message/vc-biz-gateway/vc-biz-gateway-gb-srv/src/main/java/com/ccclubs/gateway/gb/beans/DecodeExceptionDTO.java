package com.ccclubs.gateway.gb.beans;

import com.ccclubs.gateway.gb.constant.PackagePart;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 21:29
 * Email:  yeanzhi@ccclubs.com
 * 包装解析异常信息
 */
public class DecodeExceptionDTO {

    private static final String EXCEPTION_DECRIPTION_PRIFIX= "解析数据包时出现异常: ";

    // 记录当前解析的位置
    private int decodeMarkIndex;

    // 异常值
    private String exceptionVal;

    // 期望值
    private String expectedVal;

    // 异常原因
    private String reason;

    // 是否解析未结束
    private boolean decodeNotFinished;

    // 源数据包
    private ByteBuf source;

    public DecodeExceptionDTO(ByteBuf source) {
        this.source = source;
        this.decodeNotFinished = true;
        source.resetReaderIndex();
    }

    public DecodeExceptionDTO next() {
        ++ this.decodeMarkIndex;
        return this;
    }

    public DecodeExceptionDTO fail() {
        this.decodeNotFinished = false;
        return this;
    }

    public String toLogString() {
        StringBuilder desSb = new StringBuilder(EXCEPTION_DECRIPTION_PRIFIX);
        PackagePart packagePart = PackagePart.getByCode(decodeMarkIndex);
        desSb
                .append("位置[").append(packagePart.getDes()).append("]")
                .append("异常值[").append(exceptionVal).append("]");
        if (StringUtils.isNotEmpty(expectedVal)) {
            desSb.append("期望值[").append(expectedVal).append("]");
        }
        if (StringUtils.isNotEmpty(reason)) {
            desSb.append("异常原因[").append(reason).append("]");
        }

        desSb.append("原始消息[").append(ByteBufUtil.hexDump(source.resetReaderIndex())).append("]");
        return desSb.toString();
    }

    // -------------------------------------------------------

    public int getDecodeMarkIndex() {
        return decodeMarkIndex;
    }

    public DecodeExceptionDTO setDecodeMarkIndex(int decodeMarkIndex) {
        this.decodeMarkIndex = decodeMarkIndex;
        return this;
    }

    public String getExceptionVal() {
        return exceptionVal;
    }

    public DecodeExceptionDTO setExceptionVal(String exceptionVal) {
        this.exceptionVal = exceptionVal;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public DecodeExceptionDTO setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public boolean isDecodeNotFinished() {
        return decodeNotFinished;
    }

    public DecodeExceptionDTO setDecodeNotFinished(boolean decodeNotFinished) {
        this.decodeNotFinished = decodeNotFinished;
        return this;
    }

    public ByteBuf getSource() {
        return source;
    }

    public DecodeExceptionDTO setSource(ByteBuf source) {
        this.source = source;
        return this;
    }

    public String getExpectedVal() {
        return expectedVal;
    }

    public DecodeExceptionDTO setExpectedVal(String expectedVal) {
        this.expectedVal = expectedVal;
        return this;
    }
}
