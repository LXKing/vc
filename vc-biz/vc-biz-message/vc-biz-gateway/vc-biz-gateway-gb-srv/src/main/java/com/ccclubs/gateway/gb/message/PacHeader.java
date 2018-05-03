package com.ccclubs.gateway.gb.message;

import com.ccclubs.gateway.gb.enums.AckType;
import com.ccclubs.gateway.gb.enums.CommandType;
import com.ccclubs.gateway.gb.enums.EncryType;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 消息头部
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 15:12
 * Email:  yeanzhi@ccclubs.com
 */
public class PacHeader {

    /**
     * 起始符
     * 固定为"##"
     */
    private String startSymbol;

    /**
     * 命令标识
     */
    private CommandType commandMark;

    /**
     * 应答标志
     */
    private AckType ackMark;

    /**
     * 唯一标识码
     */
    private String uniqueNo;

    /**
     * 数据单元加密方式
     */
    private EncryType encryptType;

    /**
     * 数据单元长度
     */
    private int contentLength;

    public String getStartSymbol() {
        return startSymbol;
    }

    public PacHeader setStartSymbol(String startSymbol) {
        this.startSymbol = startSymbol;
        return this;
    }

    public CommandType getCommandMark() {
        return commandMark;
    }

    public PacHeader setCommandMark(CommandType commandMark) {
        this.commandMark = commandMark;
        return this;
    }

    public AckType getAckMark() {
        return ackMark;
    }

    public PacHeader setAckMark(AckType ackMark) {
        this.ackMark = ackMark;
        return this;
    }

    public String getUniqueNo() {
        return uniqueNo;
    }

    public PacHeader setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
        return this;
    }

    public EncryType getEncryptType() {
        return encryptType;
    }

    public PacHeader setEncryptType(EncryType encryptType) {
        this.encryptType = encryptType;
        return this;
    }

    public int getContentLength() {
        return contentLength;
    }

    public PacHeader setContentLength(int contentLength) {
        this.contentLength = contentLength;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("startSymbol", startSymbol)
                .append("commandMark", commandMark)
                .append("ackMark", ackMark)
                .append("uniqueNo", uniqueNo)
                .append("encryptType", encryptType)
                .append("contentLength", contentLength)
                .toString();
    }
}
