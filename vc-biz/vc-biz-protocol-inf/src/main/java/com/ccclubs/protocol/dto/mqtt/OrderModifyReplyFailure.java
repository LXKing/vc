package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.annotation.size;

/**
 * 订单修改信息确认回复
 * <p>
 * 包括车牌号，订单号等
 * </p>
 *
 * @author Administrator
 */
public class OrderModifyReplyFailure extends CStruct {

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
   * Fuc Code 标识位 0x53
   */
  public byte mFucCode = (byte) 0x90;
  /**
   * 失败值
   */
  public byte mFlag;

  public OrderModifyReplyFailure() {
    // TODO Auto-generated constructor stub
  }

  /**
   *
   */
  public OrderModifyReplyFailure(String carNum, Long orderId, byte flag) {
    // TODO Auto-generated constructor stub
    this.mCarNum = carNum;
    this.mOrderId = orderId;
    this.mFlag = flag;
  }
}
