package com.ccclubs.protocol.dto.beiqi;

import java.io.Serializable;

/**
 * 北汽新能源平台返回结果 基本控制指令应答消息 {@link BeiQiBody} 内容
 * <ul>
 * <li>预定车辆接口应答</li>
 * <li>车辆双闪接口应答</li>
 * <li>车辆双闪和鸣笛接口应答</li>
 * <li>解锁车门接口应答</li>
 * <li>锁定车门接口应答</li>
 * <li>断电接口应答</li>
 * <li>供电接口应答</li>
 * </ul>
 * Created by qsxiaogang on 2017/3/16.
 */
public class SimpleOperateResponse implements Serializable {

  private static final long serialVersionUID = -2147351023189354774L;
  /**
   * 设备 id（每台 T-box 硬件的 ID）
   */
  private String devID;
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
    sb.append(",\"result\":\"")
        .append(result).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
