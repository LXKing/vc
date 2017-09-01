package com.ccclubs.protocol.dto.beiqi;

import java.io.Serializable;

/**
 * 北汽新能源平台返回结果 消息体
 * Created by qsxiaogang on 2017/3/16.
 */
public class BeiQiBody<T> implements Serializable {

  private static final long serialVersionUID = -1171155331481116026L;

  /**
   *
   */
  public final static String SUCCESS_CODE = "000000";
  /**
   * 返回码
   * 000000 正常 数字类型即可
   * 800006 缺少参数
   * 800007 验签错误
   * 999999 系统异常
   * 900000 操作失败
   * 100005 无此车辆
   * 200006 不是合作用户 请检查 authorsSign 是否正确
   * -10004 自定义错误描述 注：此处 resMsg 按处理者自定义回复，但不应超过
   * 255 个字符
   */
  private String resCode;
  /**
   * 返回描述信息，长度不超过 255 个字符
   * 000000 正常 数字类型即可
   * 800006 缺少参数
   * 800007 验签错误
   * 999999 系统异常
   * 900000 操作失败
   * 100005 无此车辆
   * 200006 不是合作用户 请检查 authorsSign 是否正确
   * -10004 自定义错误描述 注：此处 resMsg 按处理者自定义回复，但不应超过
   * 255 个字符
   */
  private String resMsg;

  private BeiQiInfo beiJingInfo;

  private T data;

  public String getResCode() {
    return resCode;
  }

  public void setResCode(String resCode) {
    this.resCode = resCode;
  }

  public String getResMsg() {
    return resMsg;
  }

  public void setResMsg(String resMsg) {
    this.resMsg = resMsg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public BeiQiInfo getBeiJingInfo() {
    return beiJingInfo;
  }

  public void setBeiJingInfo(BeiQiInfo beiJingInfo) {
    this.beiJingInfo = beiJingInfo;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"resCode\":\"")
        .append(resCode).append('\"');
    sb.append(",\"resMsg\":\"")
        .append(resMsg).append('\"');
    if (beiJingInfo != null && SUCCESS_CODE.equals(getResCode())) {
      sb.append(",\"beiJingInfo\":\"")
          .append(beiJingInfo.toString());
    } else {
      sb.append(",\"beiJingInfo\":")
          .append("\"\"");
    }

    if (data != null && SUCCESS_CODE.equals(getResCode())) {
      sb.append(",\"data\":")
          .append(data.toString());
    } else {
      sb.append(",\"data\":")
          .append("\"\"");
    }
    sb.append('}');
    return sb.toString();
  }
}
