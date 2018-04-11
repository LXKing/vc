package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 远程车辆发上来的钥匙插入、拔出信息，基础信息
 */
public class MQTT_07 implements IMessageBody {

  /**
   * 协议版本
   */
  private byte subFucCode;
  /**
   * 终端当前时间
   */
  private int time;

  /**
   * 消息流水号
   */
  private short messageSerialNo;
  /**
   * 钥匙包数量
   */
  private byte count;

  private List<MQTT_07_Item> list;

  public byte getSubFucCode() {
    return subFucCode;
  }

  public void setSubFucCode(byte subFucCode) {
    this.subFucCode = subFucCode;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public short getMessageSerialNo() {
    return messageSerialNo;
  }

  public void setMessageSerialNo(short messageSerialNo) {
    this.messageSerialNo = messageSerialNo;
  }

  public byte getCount() {
    return count;
  }

  public void setCount(byte count) {
    this.count = count;
  }

  public List<MQTT_07_Item> getList() {
    return list;
  }

  public void setList(List<MQTT_07_Item> list) {
    this.list = list;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSubFucCode());
    buff.put(getTime());
    buff.put(getMessageSerialNo());
    buff.put(getCount());
    if (getCount() > 0) {
      for (MQTT_07_Item item : getList()) {
        if (item != null) {
          buff.put(item.WriteToBytes());
        }
      }
    }
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSubFucCode(buff.get());
    setTime(buff.getInt());
    setMessageSerialNo(buff.getShort());
    setCount(buff.get());
    this.list = new ArrayList<>();
    for (int m = 0; m < getCount(); m++) {
      MQTT_07_Item item = new MQTT_07_Item();
      int dataLength = 1 + 4;
      item.ReadFromBytes(buff.gets(dataLength));
      this.list.add(item);
    }

  }
}
