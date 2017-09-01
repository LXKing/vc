package com.ccclubs.protocol.dto.mqtt.can;


import com.ccclubs.protocol.annotation.size;
import com.ccclubs.protocol.dto.mqtt.CStruct;

/**
 * 远程车辆发上来的CAN信息
 */
public class CanStatusZotye extends CStruct {

  /**
   * 车牌号
   */
  public
  @size(8)
  String mCarNum;
  /**
   * 订单号
   */
  public long mOrderId;
  /**
   * Fuc Code 标识位 0x69
   */
  public byte mFucCode = 0x69;
  /**
   * 车型
   */
  public byte mSubfuc;
  /**
   * 车机时间
   */
  public int mTime;
  /**
   * Can 类型 <li>0x01：11bit - 2个byte</li> <li>0x02：29bit - 4个byte</li>
   */
  public byte mCanType;
  /**
   * Can包数量
   */
  public byte mCanNum;

  public CanStatusZotye() {
    // TODO Auto-generated constructor stub
  }
}
