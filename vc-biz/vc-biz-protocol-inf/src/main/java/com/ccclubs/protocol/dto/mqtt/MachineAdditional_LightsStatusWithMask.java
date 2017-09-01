package com.ccclubs.protocol.dto.mqtt;
import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 灯状态 with mask ,终端信息
 */
public class MachineAdditional_LightsStatusWithMask implements IMachineAdditionalItem {

  /**
   * 高WORD车灯MASK
   * 1 Bit0 所有灯有效位： 0-无效，1-有效
   * 2 Bit1 近光灯有效位： 0-无效，1-有效
   * 3 Bit2 远光灯有效位：0-无效，1-有效
   * 4 Bit3 前雾灯有效位：0-无效，1-有效
   * 5 Bit4 后雾灯有效位：0-无效，1-有效
   * 6 Bit5 左转向有效位：0-无效，1-有效
   * 7 Bit6 右转向有效位：0-无效，1-有效
   * 8 Bit7 位置灯有效位：0-无效，1-有效
   * 9 Bit8 故障灯有效位：0-无效，1-有效
   * 以下预留
   */
  /**
   * 低WORD车灯值
   * 1 Bit0 所有灯有效位： 0-OFF，1-ON
   * 2 Bit1 近光灯有效位： 0-OFF，1-ON
   * 3 Bit2 远光灯有效位：0-OFF，1-ON
   * 4 Bit3 前雾灯有效位：0-OFF，1-ON
   * 5 Bit4 后雾灯有效位：0-OFF，1-ON
   * 6 Bit5 左转向有效位：0-OFF，1-ON
   * 7 Bit6 右转向有效位：0-OFF，1-ON
   * 8 Bit7 位置灯有效位：0-OFF，1-ON
   * 9 Bit8 故障灯有效位：0-OFF，1-ON
   * 以下预留
   */
  private int lightsStatus;

  public int getLightsStatus() {
    return lightsStatus;
  }

  public void setLightsStatus(int lightsStatus) {
    this.lightsStatus = lightsStatus;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 206;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getLightsStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setLightsStatus(buff.getInt());
  }
}
