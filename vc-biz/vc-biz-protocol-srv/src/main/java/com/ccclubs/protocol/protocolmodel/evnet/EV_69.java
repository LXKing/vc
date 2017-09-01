package com.ccclubs.protocol.protocolmodel.evnet;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 9.扩展CAN数据上传(功能码0x69)
 */
public class EV_69 implements IMessageBody, IEvMessage {

  //车型号（1 byte,subfunc Code）
  private byte carType;
  //车机时间（4 byte）
  private int time;
  //包类型（1byte ：01:CAN bus(ID:11 bit)，02:CAN bus(ID:29 bit)）
  private byte canType;
  //包的个数（1byte）
  private byte canCount;
  //
  private List<EV_69_can_item> canList;

  public byte getCarType() {
    return carType;
  }

  public void setCarType(byte carType) {
    this.carType = carType;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public byte getCanType() {
    return canType;
  }

  public void setCanType(byte canType) {
    this.canType = canType;
  }

  @Override
  public byte getCanCount() {
    return canCount;
  }

  public void setCanCount(byte canCount) {
    this.canCount = canCount;
  }

//    public List<EV_69_can_item> getCanList() {
//        return canList;
//    }

  @Override
  public List getCanList() {
    return canList;
  }

  public void setCanList(List<EV_69_can_item> canList) {
    this.canList = canList;
  }

  @Override
  public byte[] WriteToBytes() {

    MyBuffer buff = new MyBuffer();

    buff.put(getCarType());
    buff.put(getTime());    //呆改

    buff.put(getCanType());
    buff.put(getCanCount());

    if (getCanCount() > 0) {
      for (EV_69_can_item item : canList) {
        if (item != null && item.getCanId() > 0) {
          buff.put(item.WriteToBytes());
        }
      }
    }
    return buff.array();

  }

  @Override
  public void ReadFromBytes(byte[] bytes) {

    if (verifyPacketData(bytes)) {
      MyBuffer buff = new MyBuffer(bytes);
      setCarType(buff.get());
      setTime(buff.getInt());//呆改
      setCanType(buff.get());
      setCanCount(buff.get());
      this.canList = new ArrayList<EV_69_can_item>();
      //
      int dataLength = 8;
      switch (getCanType()) {
        case 0x01:
          dataLength = 3 + dataLength;
          break;
        case 0x02:
          dataLength = 5 + dataLength;
          break;
      }
      for (int m = 0; m < getCanCount(); m++) {
        EV_69_can_item jt = new EV_69_can_item();
        jt.setCanType(getCanType());
        jt.ReadFromBytes(buff.gets(dataLength));
        this.canList.add(jt);

      }
    }

  }

  /**
   * 通过包类型，包数量验证接收到的包是否正确
   */
  public boolean verifyPacketData(byte[] bytes) {
    boolean flag = false;
    byte cantype = bytes[5];//包类型
    byte canNum = bytes[6];//包数量
    int len = 1;
    switch (cantype) {
      case 0x01:
        len = canNum * 11;
        break;
      case 0x02:
        len = canNum * 13;
        break;
    }
    //
    if (len == bytes.length - 7) {
      flag = true;
    }
    return flag;
  }

//    /**
//     * 包数据转换给GB格式数据
//     * @return
//     */
//
//    public String getGBFromCanData(byte[] bytes ) {
//
//                byte[]  destBytes=new byte[bytes.length-17];
//                //去除包数据开头的部分
//                System.arraycopy(bytes,17,destBytes,0,bytes.length-17);
//                ReadFromBytes(destBytes);
//                //
//
//                return jsonString;
//
//
//    }


}
