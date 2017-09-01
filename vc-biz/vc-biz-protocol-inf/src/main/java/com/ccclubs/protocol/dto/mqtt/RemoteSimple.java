package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.annotation.size;

public class RemoteSimple extends CStruct {

  /**
   *
   */
  public RemoteSimple() {
    // TODO Auto-generated constructor stub
  }


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
   * 参数
   */
  public Object[] params = new Object[]{};

  /**
   * @param number
   * @param id
   * @param params
   */
  public RemoteSimple(String number, long id, Object[] params) {
    super();
    this.number = number;
    this.id = id;
    this.params = params;
  }

}
