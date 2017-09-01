package com.ccclubs.vehicle.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆信息修改
 *
 * @author jianghaiyang
 * @create 2017-07-19
 **/
public class ModifyVehicleInput implements Serializable{

    /**
     * Database Column Remarks:
     *   真实车牌:
     *
     */
    private String csvCarNo;

    /**
     * Database Column Remarks:
     *   车架号:
     *
     */
    @NotNull(message = "车辆vin码必填")
    private String vin;

    /**
     * Database Column Remarks:
     *   发动机号
     *
     */
    private String csvEngineNo;

    /**
     * Database Column Remarks:
     *   合格证号
     *
     */
    private String csvCertific;

    /**
     * Database Column Remarks:
     *   颜色
     *
     */
    private Byte csvColor;

    /**
     * Database Column Remarks:
     *   车颜色代码0: 白套红橙1: 白套玫瑰金2: 白套苹果绿3: 红橙套黑4: 红套黑5: 黄/黑6: 黄套黑7: 蓝白套8: 苹果绿/白9: 深空黑/红橙10: 紫白套
     *
     */
    @InArray(range = {0,1,2,3,4,5,6,7,8,9,10},message = "车颜色代码范围0: 白套红橙1: 白套玫瑰金2: 白套苹果绿3: 红橙套黑4: 红套黑5: 黄/黑6: 黄套黑7: 蓝白套8: 苹果绿/白9: 深空黑/红橙10: 紫白套")
    private Byte csvColorCode;

    /**
     * Database Column Remarks:
     *   车型:
     *
     */
    private Integer csvModel;

    /**
     * Database Column Remarks:
     *   可充电储能系统编码
     *
     */
    private String csvBataccuCode;

    /**
     * Database Column Remarks:
     *   出厂日期
     *
     */
    @Pattern(regexp = "^((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$",message = "日期格式不正确(YYYY-MM-DD)")
    private String csvProdDate;

    /**
     * appId
     *
     */
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCsvCarNo() {
        return csvCarNo;
    }

    public void setCsvCarNo(String csvCarNo) {
        this.csvCarNo = csvCarNo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public Byte getCsvColor() {
        return csvColor;
    }

    public void setCsvColor(Byte csvColor) {
        this.csvColor = csvColor;
    }

    public Byte getCsvColorCode() {
        return csvColorCode;
    }

    public void setCsvColorCode(Byte csvColorCode) {
        this.csvColorCode = csvColorCode;
    }

    public Integer getCsvModel() {
        return csvModel;
    }

    public void setCsvModel(Integer csvModel) {
        this.csvModel = csvModel;
    }

    public String getCsvBataccuCode() {
        return csvBataccuCode;
    }

    public void setCsvBataccuCode(String csvBataccuCode) {
        this.csvBataccuCode = csvBataccuCode;
    }

    public String getCsvProdDate() {
        return csvProdDate;
    }

    public void setCsvProdDate(String csvProdDate) {
        this.csvProdDate = csvProdDate;
    }
}
