package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by Administrator on 2017/8/15 0015.
 *
 * 车机类型
 */
public class MachineAdditional_Type implements IMachineAdditionalItem {


  //车机类型  0,通领2G  1,富士康2G   2,中导2G  3,通领3G
  private int machineType;

  public int getMachineType() {
    return machineType;
  }

  public void setMachineType(int machineType) {
    this.machineType = machineType;
  }

  @Override
  public byte getAdditionalId() {
    return 35;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getMachineType());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setMachineType(buff.get());

  }


}
