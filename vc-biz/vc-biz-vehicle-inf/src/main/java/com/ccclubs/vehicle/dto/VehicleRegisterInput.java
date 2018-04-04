package com.ccclubs.vehicle.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 车辆注册入参
 *
 * @author jianghaiyang
 * @create 2017-07-10
 **/
public class VehicleRegisterInput  implements Serializable {

    /**
     *   真实车牌
     */
    private String csvCarNo;

    /**
     *   车架号
     */
    @NotNull(message = "车辆VIN码必填")
    private String csvVin;

    /**
     *   发动机号
     */
    @NotNull(message = "发动机号必填")
    private String csvEngineNo;

    /**
     *   合格证号
     */
    @NotNull(message = "合格证号必填")
    private String csvCertific;

    /**
     *   车颜色代码0: 白套红橙1: 白套玫瑰金2: 白套苹果绿3: 红橙套黑4: 红套黑5: 黄/黑6: 黄套黑7: 蓝白套8: 苹果绿/白9: 深空黑/红橙10: 紫白套
     */
    @NotNull(message = "车颜色必填")
    @InArray(range = {0,1,2,3,4,5,6,7,8,9,10},message = "车颜色代码范围0: 白套红橙1: 白套玫瑰金2: 白套苹果绿3: 红橙套黑4: 红套黑5: 黄/黑6: 黄套黑7: 蓝白套8: 苹果绿/白9: 深空黑/红橙10: 紫白套")
    private Byte csvColorCode;

    /**
     *   车型
     */
    @NotNull(message = "车型备案型号必填")
    private String csvModel;

    /**
     *   出厂日期
     */
    @NotNull(message = "出厂日期(yyyy-MM-dd)必填")
    @Pattern(regexp = "^((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$",message = "日期格式不正确(YYYY-MM-DD)")
    private String csvProdDate;

    /**
     *   终端序列号
     */
    //@NotNull(message = "终端序列号必填")
    private String teNo;

    /**
     *  可充电储能系统编码
     */
    //@NotNull(message = "可充电储能系统编码必填")
    private String csvBataccuCode;

    /**
     * 车辆领域：0:未知,1:个人领域,2:公共领域
     */
    private Byte csvDomain;

    /**
     * 车型代码
     */
    private String csvModelCodeFull;

    /**
     * 车型备案型号
     */
    private String csvModelCodeSimple;

    public VehicleRegisterInput(){}
    public VehicleRegisterInput(String csvCarNo, String csvVin, String csvEngineNo, String csvCertific, Byte csvColorCode, String csvModel, String csvProdDate, String teNo, String csvBataccuCode) {
        this.csvCarNo = csvCarNo;
        this.csvVin = csvVin;
        this.csvEngineNo = csvEngineNo;
        this.csvCertific = csvCertific;
        this.csvColorCode = csvColorCode;
        this.csvModel = csvModel;
        this.csvProdDate = csvProdDate;
        this.teNo = teNo;
        this.csvBataccuCode = csvBataccuCode;
    }

    public VehicleRegisterInput(String csvVin, String csvEngineNo, String csvCertific, Byte csvColorCode, String csvModel, String csvProdDate, String teNo, String csvBataccuCode) {
        this.csvVin = csvVin;
        this.csvEngineNo = csvEngineNo;
        this.csvCertific = csvCertific;
        this.csvColorCode = csvColorCode;
        this.csvModel = csvModel;
        this.csvProdDate = csvProdDate;
        this.teNo = teNo;
        this.csvBataccuCode = csvBataccuCode;
    }

    public String getCsvCarNo() {
        return csvCarNo;
    }

    public void setCsvCarNo(String csvCarNo) {
        this.csvCarNo = csvCarNo;
    }

    public String getCsvVin() {
        return csvVin;
    }

    public void setCsvVin(String csvVin) {
        this.csvVin = csvVin;
    }

    public String getCsvEngineNo() {
        return csvEngineNo;
    }

    public void setCsvEngineNo(String csvEngineNo) {
        this.csvEngineNo = csvEngineNo;
    }

    public String getCsvCertific() {
        return csvCertific;
    }

    public void setCsvCertific(String csvCertific) {
        this.csvCertific = csvCertific;
    }

    public Byte getCsvColorCode() {
        return csvColorCode;
    }

    public void setCsvColorCode(Byte csvColorCode) {
        this.csvColorCode = csvColorCode;
    }

    public String getCsvModel() {
        return csvModel;
    }

    public void setCsvModel(String csvModel) {
        this.csvModel = csvModel;
    }

    public String getCsvProdDate() {
        return csvProdDate;
    }

    public void setCsvProdDate(String csvProdDate) {
        this.csvProdDate = csvProdDate;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }

    public String getCsvBataccuCode() {
        return csvBataccuCode;
    }

    public void setCsvBataccuCode(String csvBataccuCode) {
        this.csvBataccuCode = csvBataccuCode;
    }
}
