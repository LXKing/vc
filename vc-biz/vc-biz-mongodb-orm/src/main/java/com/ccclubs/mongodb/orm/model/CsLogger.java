package com.ccclubs.mongodb.orm.model;

import com.ccclubs.frm.mongodb.lang.AutomaticSequence;
import java.io.Serializable;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
@Document(collection = "CsLogger")
public class CsLogger extends AbstractDocumentOld implements Serializable {

  private static final long serialVersionUID = -5888775270769402565L;

  //编号
  @AutomaticSequence
  private Long cslId;
  //车机号
  private String cslNumber;
  //订单号
  private Long cslOrder;
  //日志信息
  private String cslLog;
  //原始数据
  private String cslData;
  //添加时间
  private Long cslAddTime;
  //状态 1:正常 0:无效
  private Short cslStatus;


  public Long getCslId() {
    return cslId;
  }

  public void setCslId(Long cslId) {
    this.cslId = cslId;
  }

  public String getCslNumber() {
    return cslNumber;
  }

  public void setCslNumber(String cslNumber) {
    this.cslNumber = cslNumber;
  }

  public Long getCslOrder() {
    return cslOrder;
  }

  public void setCslOrder(Long cslOrder) {
    this.cslOrder = cslOrder;
  }

  public String getCslLog() {
    return cslLog;
  }

  public void setCslLog(String cslLog) {
    this.cslLog = cslLog;
  }

  public String getCslData() {
    return cslData;
  }

  public void setCslData(String cslData) {
    this.cslData = cslData;
  }

  public Long getCslAddTime() {
    return cslAddTime;
  }

  public void setCslAddTime(Long cslAddTime) {
    this.cslAddTime = cslAddTime;
  }

  public Short getCslStatus() {
    return cslStatus;
  }

  public void setCslStatus(Short cslStatus) {
    this.cslStatus = cslStatus;
  }
}
