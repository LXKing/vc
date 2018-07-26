package com.ccclubs.gateway.jt808.process.command;

import com.ccclubs.gateway.jt808.constant.CommandStatus;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 18:01
 * Email:  yeanzhi@ccclubs.com
 * 下行命令
 */
public class Command {

    /**
     * 终端唯一标识
     */
    private String uniqueNo;

    /**
     * 808报文流水号
     */
    private Short serialNo808;

    /**
     * mqtt协议流水号
     */
    private Long serialNoMqtt;

    /**
     * 命令状态
     */
    private CommandStatus commandStatus;

    /**
     * 命令发送时间
     */
    private String sendTime;

    /**
     * 808应答时间
     */
    private String ack808Time;

    /**
     * mqtt应答时间
     */
    private String ackMQTTTime;

    /**
     * 命令的原始报文
     */
    private String cmdHex;

    /**
     * 从MQTT协议返回的应答报文
     */
    private String ackFromMQTTHex;

    public String getUniqueNo() {
        return uniqueNo;
    }

    public Command setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
        return this;
    }

    public Short getSerialNo808() {
        return serialNo808;
    }

    public Command setSerialNo808(Short serialNo808) {
        this.serialNo808 = serialNo808;
        return this;
    }

    public CommandStatus getCommandStatus() {
        return commandStatus;
    }

    public Command setCommandStatus(CommandStatus commandStatus) {
        this.commandStatus = commandStatus;
        return this;
    }

    public String getSendTime() {
        return sendTime;
    }

    public Long getSerialNoMqtt() {
        return serialNoMqtt;
    }

    public Command setSerialNoMqtt(Long serialNoMqtt) {
        this.serialNoMqtt = serialNoMqtt;
        return this;
    }

    public Command setSendTime(String sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    public String getAck808Time() {
        return ack808Time;
    }

    public Command setAck808Time(String ack808Time) {
        this.ack808Time = ack808Time;
        return this;
    }

    public String getAckMQTTTime() {
        return ackMQTTTime;
    }

    public Command setAckMQTTTime(String ackMQTTTime) {
        this.ackMQTTTime = ackMQTTTime;
        return this;
    }

    public String getCmdHex() {
        return cmdHex;
    }

    public Command setCmdHex(String cmdHex) {
        this.cmdHex = cmdHex;
        return this;
    }

    public String getAckFromMQTTHex() {
        return ackFromMQTTHex;
    }

    public Command setAckFromMQTTHex(String ackFromMQTTHex) {
        this.ackFromMQTTHex = ackFromMQTTHex;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Command command = (Command) o;

        return new EqualsBuilder()
                .append(uniqueNo, command.uniqueNo)
                .append(serialNo808, command.serialNo808)
                .append(serialNoMqtt, command.serialNoMqtt)
                .append(sendTime, command.sendTime)
                .append(cmdHex, command.cmdHex)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(uniqueNo)
                .append(serialNo808)
                .append(serialNoMqtt)
                .append(sendTime)
                .append(cmdHex)
                .toHashCode();
    }
}