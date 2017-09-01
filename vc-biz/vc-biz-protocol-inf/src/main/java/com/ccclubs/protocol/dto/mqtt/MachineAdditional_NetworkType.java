package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 网络类型，终端信息
 */
public class MachineAdditional_NetworkType implements IMachineAdditionalItem {

  /**
   * 网络类型
   * #define IRUN_EVT_COPS_ACT_GSM    (0)
   * #define IRUN_EVT_COPS_ACT_UTRAN    (2)
   * #define IRUN_EVT_COPS_ACT_EGPRS    (3)
   * #define IRUN_EVT_COPS_ACT_HSDPA    (4)
   * #define IRUN_EVT_COPS_ACT_HSUPA    (5)
   * #define IRUN_EVT_COPS_ACT_HSDPA_HSUPA  (6)
   * #define IRUN_EVT_COPS_ACT_EUTRAN   (7)
   * #define IRUN_EVT_COPS_ACT_CDMA    (10)
   * #define IRUN_EVT_COPS_ACT_EVDO    (11)
   * #define IRUN_EVT_COPS_ACT_CDMA_EVDO   (12)
   */
  private int networkType;

  public int getNetworkType() {
    return networkType;
  }

  public void setNetworkType(int networkType) {
    this.networkType = networkType;
  }

  @Override
  public byte getAdditionalId() {
    return 0x09;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getNetworkType());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setNetworkType(buff.get());
  }
}
