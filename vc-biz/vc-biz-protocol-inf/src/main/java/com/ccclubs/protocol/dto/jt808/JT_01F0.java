package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 通领终端升级指令，
 */
public class JT_01F0 implements IMessageBody {

  /**
   * 命令字
   */
  private byte messageType;
  /**
   * 指令执行结果
   */
  private int result;

  public byte getMessageType() {
    return messageType;
  }

  public void setMessageType(byte messageType) {
    this.messageType = messageType;
  }

  public int getResult() {
    return result & 0xFF;
  }

  public void setResult(int result) {
    this.result = result;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getMessageType());
    buff.put((byte) getResult());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);

    setMessageType(buff.get());
    setResult(buff.get());
  }

  public String getResultString() {
    String content = "其他原因更新失败";
    switch (getResult()) {
      case 0x00:
        content = "未更新代码";
        break;
      case 0x01:
        content = "更新成功";
        break;
      case 0x02:
        content = "更新失败";
        break;
      case 0x03:
        content = "不需要升级";
        break;
      case 0x04:
        content = "文件不存在";
        break;
      case 0x05:
        content = "文件错误";
        break;
      case 0x06:
        content = "命令响应错误";
        break;
      case 0x07:
        content = "用户名错误";
        break;
      case 0x08:
        content = "密码错误";
        break;
      case 0x09:
        content = "目录错误";
        break;
      case 0x0A:
        content = "命令端口出错";
        break;
      case 0x0B:
        content = "数据端口出错";
        break;
      case 0x0C:
        content = "设备类型错误";
        break;
      case 0x0D:
        content = "内存不足";
        break;
      case 0x0E:
        content = "编程错误";
        break;
      case 0x0F:
        content = "文件校验错误";
        break;
      case 0x10:
        content = "PPP 拨号错误";
        break;
      case 0x11:
        content = "系统忙无法响应";
        break;
      case 0x12:
        content = "异常中断";
        break;
      case 0x80:
        content = "启动升级成功";
        break;
      case 0x81:
        content = "启动失败,参数错误";
        break;
      case 0x82:
        content = "启动失败,正在升级中";
        break;
      case 0x83:
        content = "启动失败,系统忙";
        break;
      case 0x84:
        content = "启动失败,用户名/密码错误";
        break;
      case 0x85:
        content = "启动失败,其他错误";
        break;
      default:
        break;
    }
    return content;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"messageType\":")
        .append(messageType);
    sb.append(",\"result\":")
        .append(result);
    sb.append('}');
    return sb.toString();
  }
}
