package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.annotation.size;

/**
 * 远程车辆回复的订单信息
 * <p>
 * 包括车牌号，订单号等
 * </p>
 *
 * @author Administrator
 */
public class OrderUpStreamII extends CStruct {

  /**
   * 车牌号
   */
  public
  @size(8)
  String mCarNum;
  /**
   * 消息ID
   */
  public long mId;
  /**
   * Fuc Code 标识位 0x44
   */
  public byte mFucCode = 0x44;
  /**
   * 订单号
   */
  public long mOrderId;
  /**
   * 输出地址
   */
  public short mOutputAddress = (short) 0x9000;
  /**
   * 输出数量
   */
  public short mQuantityOfOutputs = (short) 0x0014;
  /**
   * 车机当前状态
   */
  public short mCurrentStatus;

  /**
   *
   */
  public OrderUpStreamII() {
    // TODO Auto-generated constructor stub
  }

  /**
   * 订单下发是否成功
   */
  public boolean isSuccess() {
    if (mCurrentStatus == 0x0000) {
      return true;
    }
    return false;
  }
}
