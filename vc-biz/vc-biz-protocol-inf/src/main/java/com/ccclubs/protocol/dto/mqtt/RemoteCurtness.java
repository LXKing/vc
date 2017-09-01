package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.annotation.size;

public class RemoteCurtness extends CStruct {

  /**
   * 车牌号
   */
  public
  @size(8)
  String number;
  /**
   * 消息ID,对应的数据记录ID
   */
  public long id;
  /**
   * [远程开门,远程关门,远程允许启动,远程禁止启动(断油电)] 0x05 [远程初始化] 0x06
   */
  public byte function;

}
