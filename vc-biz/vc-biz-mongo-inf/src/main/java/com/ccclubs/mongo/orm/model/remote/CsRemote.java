package com.ccclubs.mongo.orm.model.remote;

import com.ccclubs.frm.spring.annotation.AutomaticSequence;
import com.ccclubs.mongo.orm.model.AbstractDocumentOld;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "CsRemote")
public class CsRemote extends AbstractDocumentOld implements Serializable {

  private static final long serialVersionUID = -5888775270769402565L;

  @AutomaticSequence
  private Long csrId;// 主键 非空
  private Integer csrAccess;// 非空
  private Integer csrHost;// 非空
  private String csrNumber;// 非空
  private Integer csrCar;// 非空
  /**
   * 非空
   * 0:网关 1:短信 断线的车辆建议用短信方式
   */
  private Integer csrWay;
  /**
   * 非空
   * 0:远程开门 1:远程关门 2:允许启动 3:断油电 4:初始化 5:同步时钟 6:远程取车
   * 7:远程还车 8:远程升级 9:远程重启 10:GPS远程开 11:GPS远程关
   * 12:读取RFID序列号 13:设置GPS坐标 14:查询手机号 15:刷卡器开 16:刷卡器关
   * 17:远程鸣笛 18:空调控制 19:省电模式
   */
  private Integer csrType;
  private String csrCode;//
  private String csrResultCode;//
  private String csrResult;//
  private String csrEditor;// 非空
  private String csrRemark;// 非空
  private Long csrUpdateTime;//
  private Long csrAddTime;// 非空
  private Integer csrState;// 非空 0:未发送 1:已发送 2:组装中
  private Integer csrStatus;// 非空 0:未知 1:操作成功 2:操作失败

  public Long getCsrId() {
    return csrId;
  }

  public void setCsrId(Long csrId) {
    this.csrId = csrId;
  }

  public Integer getCsrAccess() {
    return csrAccess;
  }

  public void setCsrAccess(Integer csrAccess) {
    this.csrAccess = csrAccess;
  }

  public Integer getCsrHost() {
    return csrHost;
  }

  public void setCsrHost(Integer csrHost) {
    this.csrHost = csrHost;
  }

  public String getCsrNumber() {
    return csrNumber;
  }

  public void setCsrNumber(String csrNumber) {
    this.csrNumber = csrNumber;
  }

  public Integer getCsrCar() {
    return csrCar;
  }

  public void setCsrCar(Integer csrCar) {
    this.csrCar = csrCar;
  }

  public Integer getCsrWay() {
    return csrWay;
  }

  public void setCsrWay(Integer csrWay) {
    this.csrWay = csrWay;
  }

  public Integer getCsrType() {
    return csrType;
  }

  public void setCsrType(Integer csrType) {
    this.csrType = csrType;
  }

  public String getCsrCode() {
    return csrCode;
  }

  public void setCsrCode(String csrCode) {
    this.csrCode = csrCode;
  }

  public String getCsrResultCode() {
    return csrResultCode;
  }

  public void setCsrResultCode(String csrResultCode) {
    this.csrResultCode = csrResultCode;
  }

  public String getCsrResult() {
    return csrResult;
  }

  public void setCsrResult(String csrResult) {
    this.csrResult = csrResult;
  }

  public String getCsrEditor() {
    return csrEditor;
  }

  public void setCsrEditor(String csrEditor) {
    this.csrEditor = csrEditor;
  }

  public String getCsrRemark() {
    return csrRemark;
  }

  public void setCsrRemark(String csrRemark) {
    this.csrRemark = csrRemark;
  }

  public Long getCsrUpdateTime() {
    return csrUpdateTime;
  }

  public void setCsrUpdateTime(Long csrUpdateTime) {
    this.csrUpdateTime = csrUpdateTime;
  }

  public Long getCsrAddTime() {
    return csrAddTime;
  }

  public void setCsrAddTime(Long csrAddTime) {
    this.csrAddTime = csrAddTime;
  }

  public Integer getCsrState() {
    return csrState;
  }

  public void setCsrState(Integer csrState) {
    this.csrState = csrState;
  }

  public Integer getCsrStatus() {
    return csrStatus;
  }

  public void setCsrStatus(Integer csrStatus) {
    this.csrStatus = csrStatus;
  }
}
