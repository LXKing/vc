package com.ccclubs.gateway.jt808.message.pac;

import com.ccclubs.gateway.common.constant.PacErrorType;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
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
     *      true:  校验异常的报文(包含鉴权成功)
     *      false： 检验正确的报文(包含鉴权失败)
     */
    private Boolean errorPac;

    /**
     * 消息错误类型
     */
    private PacErrorType pacErrorType;

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

    public PacErrorType getPacErrorType() {
        return pacErrorType;
    }

    public Package808 setPacErrorType(PacErrorType pacErrorType) {
        this.pacErrorType = pacErrorType;
        return this;
    }

    public String printLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("车辆(").append(getHeader().getTerMobile()).append(")").append("上传了[");
        if (getHeader().getPacContentAttr().isMultiPac()) {
            sb.append("分包(").append(getHeader().getPacSealInfo().getPacNo()).append("/").append(getHeader().getPacSealInfo().getTotalPacCount()).append(")]");
        } else {
            sb.append("整包]");
        }
        sb.append("-[").append(UpPacType.getByCode(getHeader().getPacId()).getDes()).append("]消息,")
                .append("流水号[").append(getHeader().getPacSerialNo()).append("],")
                .append("原始报文[").append(getSourceHexStr()).append("]");
        return sb.toString();
    }

}
