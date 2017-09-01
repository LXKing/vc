package com.ccclubs.frm.ons;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by qsxiaogang on 2017/7/23.
 */
@ConfigurationProperties(prefix = "ons")
public class OnsProperties {

  private String producerId;
  private String consumerId;
  private String accessKey;
  private String secretKey;
  private String onsAddr;
  private String nameSerAddr;
  private String consumeThreadNums;
  private String topic;
  private String expression;

  public String getProducerId() {
    return producerId;
  }

  public void setProducerId(String producerId) {
    this.producerId = producerId;
  }

  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  public String getOnsAddr() {
    return onsAddr;
  }

  public void setOnsAddr(String onsAddr) {
    this.onsAddr = onsAddr;
  }

  public String getNameSerAddr() {
    return nameSerAddr;
  }

  public void setNameSerAddr(String nameSerAddr) {
    this.nameSerAddr = nameSerAddr;
  }

  public String getConsumeThreadNums() {
    return consumeThreadNums;
  }

  public void setConsumeThreadNums(String consumeThreadNums) {
    this.consumeThreadNums = consumeThreadNums;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }
}
