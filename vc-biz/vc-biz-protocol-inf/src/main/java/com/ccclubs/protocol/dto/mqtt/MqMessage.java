package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 分时租赁协议
 *
 * @author qsxiaogang
 */
public class MqMessage {

  private static final Logger logger = LoggerFactory.getLogger(MqMessage.class);

  // 分时租赁协议最小消息体长度：车机号+消息ID+FC CODE
  public static int MESSAGE_MIN_LENGTH = 17;
  /**
   * 8位长度的车机号
   */
  private String carNumber;
  private long transId;
  private byte fucCode;
  private byte[] msgBody;
  private String upTopic;
  private String downTopic;
  /**
   * 808协议透传mqtt消息时，设置当前手机号
   */
  private String simNo;
  /**
   * 国标协议透传mqtt消息时，设置当前VIN码
   */
  private String vin;
  // 接收数据时间
  private long timeStamp;
  /**
   * 客户端clientId
   */
  private String clientId;
  private String hexString;
  private String errorMessage;
  private CommondType commondType;

  public static enum CommondType {
    ORDER, RENEW_ORDER, REMOTE
  }

  public final void ReadFromBytes(byte[] messageBytes) {
    this.hexString = Tools.ToHexString(messageBytes);
    try {
      MyBuffer buff = new MyBuffer(messageBytes);
      byte[] carNumberBytes = buff.gets(8);
      setCarNumber((new String(carNumberBytes)).trim().toUpperCase());
      setTransId(buff.getLong());
      setFucCode(buff.get());
      setMsgBody(buff.gets(messageBytes.length - 8 - 8 - 1));
    } catch (Exception e) {
      e.printStackTrace();
      setErrorMessage("原始数据长度不正确，需要不小于17！");
      logger.error(getErrorMessage() + ":" + Tools.ToHexFormatString(messageBytes));
    }
  }

  public final byte[] WriteToBytes() {

    MyBuffer buff = new MyBuffer();
    buff.put(getCarNumber().getBytes());
    buff.put(getTransId());
    buff.put(getFucCode());
    buff.put(getMsgBody());

    return buff.array();
  }

  public byte[] getMsgBody() {
    return msgBody;
  }

  public void setMsgBody(byte[] msgBody) {
    this.msgBody = msgBody;
  }

  public String getUpTopic() {
    return upTopic;
  }

  public void setUpTopic(String upTopic) {
    this.upTopic = upTopic;
  }

  public String getCarNumber() {
    return carNumber.trim();
  }

  public void setCarNumber(String carNumber) {
    this.carNumber = carNumber;
  }

  public long getTransId() {
    return transId;
  }

  public void setTransId(long transId) {
    this.transId = transId;
  }

  public byte getFucCode() {
    return fucCode;
  }

  public void setFucCode(byte fucCode) {
    this.fucCode = fucCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getHexString() {
    return hexString;
  }

  public void setHexString(String hexString) {
    this.hexString = hexString;
  }

  public CommondType getCommondType() {
    return commondType;
  }

  public void setCommondType(CommondType commondType) {
    this.commondType = commondType;
  }

  public String getDownTopic() {
    return downTopic;
  }

  public void setDownTopic(String downTopic) {
    this.downTopic = downTopic;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getSimNo() {
    return simNo;
  }

  public void setSimNo(String simNo) {
    this.simNo = simNo;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }
}
