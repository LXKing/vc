package com.ccclubs.protocol.dto.beiqi;

import java.io.Serializable;

/**
 * 北汽新能源平台返回结果 消息体
 * Created by qsxiaogang on 2017/3/16.
 */
public class BeiQiMessage<T> implements Serializable {

  private static final long serialVersionUID = -7827717487451912912L;
  private BeiQiHeader header;
  private BeiQiBody<T> body;

  public boolean isSuccess() {
    if (body == null) {
      return false;
    }
    if (BeiQiBody.SUCCESS_CODE.equals(body.getResCode())) {
      return true;
    }
    return false;
  }

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
  public String getMessage() {
    String message = null;
    if (body == null) {
      return message;
    }
    switch (body.getResCode()) {
      case BeiQiBody.SUCCESS_CODE:
        message = "正常";
        break;
      case "800006":
        message = "缺少参数";
        break;
      case "800007":
        message = "验签错误";
        break;
      case "999999":
        message = "系统异常";
        break;
      case "100005":
        message = "无此车辆";
        break;
      case "200006":
        message = "不是合作用户 请检查 authorsSign 是否正确";
        break;
      case "-10004":
        message = "自定义错误描述";
        break;
      default:
        break;
    }

    return message;
  }

  public BeiQiHeader getHeader() {
    return header;
  }

  public void setHeader(BeiQiHeader header) {
    this.header = header;
  }

  public BeiQiBody<T> getBody() {
    return body;
  }

  public void setBody(BeiQiBody<T> body) {
    this.body = body;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"header\":")
        .append(header.toString());
    sb.append(",\"body\":")
        .append(body.toString());
    sb.append('}');
    return sb.toString();
  }
}
