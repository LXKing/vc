package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 平台应答 远程车辆发上来的钥匙插入、拔出信息
 */
public class MQTT_07_Ack implements IMessageBody {

  /**
   * 协议版本
   */
  private byte subFucCode;

  /**
   * 消息流水号
   */
  private short messageSerialNo;

  public byte getSubFucCode() {
    return subFucCode;
  }

  public void setSubFucCode(byte subFucCode) {
    this.subFucCode = subFucCode;
  }

  public short getMessageSerialNo() {
    return messageSerialNo;
  }

  public void setMessageSerialNo(short messageSerialNo) {
    this.messageSerialNo = messageSerialNo;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSubFucCode());
    buff.put(getMessageSerialNo());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSubFucCode(buff.get());
    setMessageSerialNo(buff.getShort());
  }
}
