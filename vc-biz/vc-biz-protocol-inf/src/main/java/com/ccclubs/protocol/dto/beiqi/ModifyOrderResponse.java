package com.ccclubs.protocol.dto.beiqi;

import java.io.Serializable;

/**
 * 北汽新能源平台返回结果 取消订单消息返回
 * Created by qsxiaogang on 2017/3/16.
 */
public class ModifyOrderResponse implements Serializable {

  private static final long serialVersionUID = 343861483771366143L;
  /**
   * 设备 id（每台 T-box 硬件的 ID）
   */
  private String devID;
  /**
   * 第三方接入平台的订单号
   */
  private String orderID;
  /**
   * 预定结果，0 预定成功，1 预定失败
   */
  private String result;

  public String getDevID() {
    return devID;
  }

  public void setDevID(String devID) {
    this.devID = devID;
  }

  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"devID\":\"")
        .append(devID).append('\"');
    sb.append(",\"orderID\":\"")
        .append(orderID).append('\"');
    sb.append(",\"result\":\"")
        .append(result).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
