package com.ccclubs.frm.mqtt.inf;


/**
 * mqtt客户端，具备数据收、发功能
 *
 * @author qsxiaogang
 */
public interface IMqClient {

  void stop();

  boolean send(String topic, byte[] srcByteArray);

  boolean send(String topic, byte[] srcByteArray,int qos);

  boolean start();

  void subscribeTopic();

  // boolean isOnline();

}