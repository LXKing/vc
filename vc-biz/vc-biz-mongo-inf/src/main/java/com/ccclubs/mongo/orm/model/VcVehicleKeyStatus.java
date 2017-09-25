package com.ccclubs.mongo.orm.model;

import com.ccclubs.pub.orm.model.CsMachine;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author qsxiaogang
 * @create 2017-09-20
 **/
@Document(collection = "VcVehicleKeyStatus")
public class VcVehicleKeyStatus extends AbstractDocument implements Serializable {

  //授权系统
  private Integer access;
  //授权系统名称
  private String accessName;
  //车机Id
  private Integer terminalId;
  //@caption("车机号")
  private String terminalNumber;
  //终端信息
  private CsMachine terminal;
  //@caption("关联车辆")
  private Integer vehicleId;
  //@caption("VIN码")
  private String vin;
  //业务订单号
  private Long transOrderId;
  //钥匙状态
  private List<VehicleKeyStatus> keyStatusList;

  public Integer getAccess() {
    return access;
  }

  public void setAccess(Integer access) {
    this.access = access;
  }

  public String getAccessName() {
    return accessName;
  }

  public void setAccessName(String accessName) {
    this.accessName = accessName;
  }

  public Integer getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(Integer terminalId) {
    this.terminalId = terminalId;
  }

  public String getTerminalNumber() {
    return terminalNumber;
  }

  public void setTerminalNumber(String terminalNumber) {
    this.terminalNumber = terminalNumber;
  }

  public CsMachine getTerminal() {
    return terminal;
  }

  public void setTerminal(CsMachine terminal) {
    this.terminal = terminal;
  }

  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public Long getTransOrderId() {
    return transOrderId;
  }

  public void setTransOrderId(Long transOrderId) {
    this.transOrderId = transOrderId;
  }

  public List<VehicleKeyStatus> getKeyStatusList() {
    return keyStatusList;
  }

  public void setKeyStatusList(List<VehicleKeyStatus> keyStatusList) {
    this.keyStatusList = keyStatusList;
  }
}
