package com.ccclubs.mongo.orm.model.history;

import com.ccclubs.frm.spring.annotation.AutomaticSequence;
import com.ccclubs.frm.spring.resolver.Resolver;
import com.ccclubs.mongo.orm.model.AbstractDocumentOld;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 车机网络日志
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

  //默认构造函数
  public CsLogger(){

  }

  //主键构造函数
  public CsLogger(Long id){
    this.cslId = id;
  }

  //设置非空字段
  public CsLogger setNotNull(Long cslId){
    this.cslId=cslId;
    return this;
  }

  public Object getcslStatusText(){
    return resolve("cslStatusText");
  }

  @Transient
  Map<String, Resolver<CsLogger>> resolvers = new HashMap<String, Resolver<CsLogger>>();

  public void registResolver(Resolver<CsLogger> resolver){
    this.resolvers.put(resolver.getName(), resolver);
  }

  public Object resolve(String key){
    if(resolvers.get(key)!=null){
      return resolvers.get(key).execute(this);
    }
    return null;
  }
}
