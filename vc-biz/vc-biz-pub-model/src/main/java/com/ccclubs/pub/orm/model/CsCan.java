package com.ccclubs.pub.orm.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cs_can
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class CsCan implements Serializable {
    /**
     * Database Column Remarks:
     *   编号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_id
     *
     * @mbg.generated
     */
    private Long cscId;

    /**
     * Database Column Remarks:
     *   授权系统:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_access
     *
     * @mbg.generated
     */
    private Integer cscAccess;

    /**
     * Database Column Remarks:
     *   子域:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_host
     *
     * @mbg.generated
     */
    private Integer cscHost;

    /**
     * Database Column Remarks:
     *   车机号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_number
     *
     * @mbg.generated
     */
    private String cscNumber;

    /**
     * 自定义字段:
     *   车架号:
     * add by jhy 2018.5.5
     * This field was generated by MyBatis Generator.
     *
     * @mbg.generated
     */
    private String cscVin;
    private String iccid;
    private String mobile;
    private String teNo;
    /**
     * Database Column Remarks:
     *   CARID:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_car
     *
     * @mbg.generated
     */
    private Integer cscCar;

    /**
     * Database Column Remarks:
     *   车型:0:未知,1:北汽E150,2:奇瑞EQ,3:别克凯越,4:北汽绅宝C70,5:众泰Eway200,6:北汽D50,7:北汽D70,8:大众新捷达,9:现代索纳塔8,10:江淮IEV5,11:江淮IEV4;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_model
     *
     * @mbg.generated
     */
    private Short cscModel;

    /**
     * Database Column Remarks:
     *   Can类型:1:11bit,2:29bit;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_type
     *
     * @mbg.generated
     */
    private Short cscType;

    /**
     * Database Column Remarks:
     *   订单ID:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_order
     *
     * @mbg.generated
     */
    private Long cscOrder;

    /**
     * Database Column Remarks:
     *   数据包:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_data
     *
     * @mbg.generated
     */
    private String cscData;

    /**
     * Database Column Remarks:
     *   CAN故障:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_fault
     *
     * @mbg.generated
     */
    private String cscFault;

    /**
     * Database Column Remarks:
     *   上传时间:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_upload_time
     *
     * @mbg.generated
     */
    private Date cscUploadTime;

    /**
     * Database Column Remarks:
     *   添加时间:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_add_time
     *
     * @mbg.generated
     */
    private Date cscAddTime;

    /**
     * Database Column Remarks:
     *   故障信息:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_larum
     *
     * @mbg.generated
     */
    private String cscLarum;

    /**
     * Database Column Remarks:
     *   警报信息:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_prompt
     *
     * @mbg.generated
     */
    private String cscPrompt;

    /**
     * Database Column Remarks:
     *   处理描述:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_deal_desc
     *
     * @mbg.generated
     */
    private String cscDealDesc;

    /**
     * Database Column Remarks:
     *   处理时间:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_deal_time
     *
     * @mbg.generated
     */
    private Date cscDealTime;

    /**
     * Database Column Remarks:
     *   状态:0:默认,1:报警;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can.csc_status
     *
     * @mbg.generated
     */
    private Byte cscStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_id
     *
     * @return the value of cs_can.csc_id
     *
     * @mbg.generated
     */
    public Long getCscId() {
        return cscId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_id
     *
     * @param cscId the value for cs_can.csc_id
     *
     * @mbg.generated
     */
    public void setCscId(Long cscId) {
        this.cscId = cscId;
    }

    public String getCscVin() {
        return cscVin;
    }

    public void setCscVin(String cscVin) {
        this.cscVin = cscVin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_access
     *
     * @return the value of cs_can.csc_access
     *
     * @mbg.generated
     */
    public Integer getCscAccess() {
        return cscAccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_access
     *
     * @param cscAccess the value for cs_can.csc_access
     *
     * @mbg.generated
     */
    public void setCscAccess(Integer cscAccess) {
        this.cscAccess = cscAccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_host
     *
     * @return the value of cs_can.csc_host
     *
     * @mbg.generated
     */
    public Integer getCscHost() {
        return cscHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_host
     *
     * @param cscHost the value for cs_can.csc_host
     *
     * @mbg.generated
     */
    public void setCscHost(Integer cscHost) {
        this.cscHost = cscHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_number
     *
     * @return the value of cs_can.csc_number
     *
     * @mbg.generated
     */
    public String getCscNumber() {
        return cscNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_number
     *
     * @param cscNumber the value for cs_can.csc_number
     *
     * @mbg.generated
     */
    public void setCscNumber(String cscNumber) {
        this.cscNumber = cscNumber == null ? null : cscNumber.trim();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_car
     *
     * @return the value of cs_can.csc_car
     *
     * @mbg.generated
     */
    public Integer getCscCar() {
        return cscCar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_car
     *
     * @param cscCar the value for cs_can.csc_car
     *
     * @mbg.generated
     */
    public void setCscCar(Integer cscCar) {
        this.cscCar = cscCar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_model
     *
     * @return the value of cs_can.csc_model
     *
     * @mbg.generated
     */
    public Short getCscModel() {
        return cscModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_model
     *
     * @param cscModel the value for cs_can.csc_model
     *
     * @mbg.generated
     */
    public void setCscModel(Short cscModel) {
        this.cscModel = cscModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_type
     *
     * @return the value of cs_can.csc_type
     *
     * @mbg.generated
     */
    public Short getCscType() {
        return cscType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_type
     *
     * @param cscType the value for cs_can.csc_type
     *
     * @mbg.generated
     */
    public void setCscType(Short cscType) {
        this.cscType = cscType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_order
     *
     * @return the value of cs_can.csc_order
     *
     * @mbg.generated
     */
    public Long getCscOrder() {
        return cscOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_order
     *
     * @param cscOrder the value for cs_can.csc_order
     *
     * @mbg.generated
     */
    public void setCscOrder(Long cscOrder) {
        this.cscOrder = cscOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_data
     *
     * @return the value of cs_can.csc_data
     *
     * @mbg.generated
     */
    public String getCscData() {
        return cscData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_data
     *
     * @param cscData the value for cs_can.csc_data
     *
     * @mbg.generated
     */
    public void setCscData(String cscData) {
        this.cscData = cscData == null ? null : cscData.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_fault
     *
     * @return the value of cs_can.csc_fault
     *
     * @mbg.generated
     */
    public String getCscFault() {
        return cscFault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_fault
     *
     * @param cscFault the value for cs_can.csc_fault
     *
     * @mbg.generated
     */
    public void setCscFault(String cscFault) {
        this.cscFault = cscFault == null ? null : cscFault.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_upload_time
     *
     * @return the value of cs_can.csc_upload_time
     *
     * @mbg.generated
     */
    public Date getCscUploadTime() {
        return cscUploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_upload_time
     *
     * @param cscUploadTime the value for cs_can.csc_upload_time
     *
     * @mbg.generated
     */
    public void setCscUploadTime(Date cscUploadTime) {
        this.cscUploadTime = cscUploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_add_time
     *
     * @return the value of cs_can.csc_add_time
     *
     * @mbg.generated
     */
    public Date getCscAddTime() {
        return cscAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_add_time
     *
     * @param cscAddTime the value for cs_can.csc_add_time
     *
     * @mbg.generated
     */
    public void setCscAddTime(Date cscAddTime) {
        this.cscAddTime = cscAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_larum
     *
     * @return the value of cs_can.csc_larum
     *
     * @mbg.generated
     */
    public String getCscLarum() {
        return cscLarum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_larum
     *
     * @param cscLarum the value for cs_can.csc_larum
     *
     * @mbg.generated
     */
    public void setCscLarum(String cscLarum) {
        this.cscLarum = cscLarum == null ? null : cscLarum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_prompt
     *
     * @return the value of cs_can.csc_prompt
     *
     * @mbg.generated
     */
    public String getCscPrompt() {
        return cscPrompt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_prompt
     *
     * @param cscPrompt the value for cs_can.csc_prompt
     *
     * @mbg.generated
     */
    public void setCscPrompt(String cscPrompt) {
        this.cscPrompt = cscPrompt == null ? null : cscPrompt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_deal_desc
     *
     * @return the value of cs_can.csc_deal_desc
     *
     * @mbg.generated
     */
    public String getCscDealDesc() {
        return cscDealDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_deal_desc
     *
     * @param cscDealDesc the value for cs_can.csc_deal_desc
     *
     * @mbg.generated
     */
    public void setCscDealDesc(String cscDealDesc) {
        this.cscDealDesc = cscDealDesc == null ? null : cscDealDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_deal_time
     *
     * @return the value of cs_can.csc_deal_time
     *
     * @mbg.generated
     */
    public Date getCscDealTime() {
        return cscDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_deal_time
     *
     * @param cscDealTime the value for cs_can.csc_deal_time
     *
     * @mbg.generated
     */
    public void setCscDealTime(Date cscDealTime) {
        this.cscDealTime = cscDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can.csc_status
     *
     * @return the value of cs_can.csc_status
     *
     * @mbg.generated
     */
    public Byte getCscStatus() {
        return cscStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can.csc_status
     *
     * @param cscStatus the value for cs_can.csc_status
     *
     * @mbg.generated
     */
    public void setCscStatus(Byte cscStatus) {
        this.cscStatus = cscStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CsCan other = (CsCan) that;
        return (this.getCscId() == null ? other.getCscId() == null : this.getCscId().equals(other.getCscId()))
            && (this.getCscAccess() == null ? other.getCscAccess() == null : this.getCscAccess().equals(other.getCscAccess()))
            && (this.getCscHost() == null ? other.getCscHost() == null : this.getCscHost().equals(other.getCscHost()))
            && (this.getCscNumber() == null ? other.getCscNumber() == null : this.getCscNumber().equals(other.getCscNumber()))
            && (this.getCscCar() == null ? other.getCscCar() == null : this.getCscCar().equals(other.getCscCar()))
            && (this.getCscModel() == null ? other.getCscModel() == null : this.getCscModel().equals(other.getCscModel()))
            && (this.getCscType() == null ? other.getCscType() == null : this.getCscType().equals(other.getCscType()))
            && (this.getCscOrder() == null ? other.getCscOrder() == null : this.getCscOrder().equals(other.getCscOrder()))
            && (this.getCscData() == null ? other.getCscData() == null : this.getCscData().equals(other.getCscData()))
            && (this.getCscFault() == null ? other.getCscFault() == null : this.getCscFault().equals(other.getCscFault()))
            && (this.getCscUploadTime() == null ? other.getCscUploadTime() == null : this.getCscUploadTime().equals(other.getCscUploadTime()))
            && (this.getCscAddTime() == null ? other.getCscAddTime() == null : this.getCscAddTime().equals(other.getCscAddTime()))
            && (this.getCscLarum() == null ? other.getCscLarum() == null : this.getCscLarum().equals(other.getCscLarum()))
            && (this.getCscPrompt() == null ? other.getCscPrompt() == null : this.getCscPrompt().equals(other.getCscPrompt()))
            && (this.getCscDealDesc() == null ? other.getCscDealDesc() == null : this.getCscDealDesc().equals(other.getCscDealDesc()))
            && (this.getCscDealTime() == null ? other.getCscDealTime() == null : this.getCscDealTime().equals(other.getCscDealTime()))
            && (this.getCscStatus() == null ? other.getCscStatus() == null : this.getCscStatus().equals(other.getCscStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCscId() == null) ? 0 : getCscId().hashCode());
        result = prime * result + ((getCscAccess() == null) ? 0 : getCscAccess().hashCode());
        result = prime * result + ((getCscHost() == null) ? 0 : getCscHost().hashCode());
        result = prime * result + ((getCscNumber() == null) ? 0 : getCscNumber().hashCode());
        result = prime * result + ((getCscCar() == null) ? 0 : getCscCar().hashCode());
        result = prime * result + ((getCscModel() == null) ? 0 : getCscModel().hashCode());
        result = prime * result + ((getCscType() == null) ? 0 : getCscType().hashCode());
        result = prime * result + ((getCscOrder() == null) ? 0 : getCscOrder().hashCode());
        result = prime * result + ((getCscData() == null) ? 0 : getCscData().hashCode());
        result = prime * result + ((getCscFault() == null) ? 0 : getCscFault().hashCode());
        result = prime * result + ((getCscUploadTime() == null) ? 0 : getCscUploadTime().hashCode());
        result = prime * result + ((getCscAddTime() == null) ? 0 : getCscAddTime().hashCode());
        result = prime * result + ((getCscLarum() == null) ? 0 : getCscLarum().hashCode());
        result = prime * result + ((getCscPrompt() == null) ? 0 : getCscPrompt().hashCode());
        result = prime * result + ((getCscDealDesc() == null) ? 0 : getCscDealDesc().hashCode());
        result = prime * result + ((getCscDealTime() == null) ? 0 : getCscDealTime().hashCode());
        result = prime * result + ((getCscStatus() == null) ? 0 : getCscStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        return "CsCan{" +
                "cscId=" + cscId +
                ", cscAccess=" + cscAccess +
                ", cscHost=" + cscHost +
                ", cscNumber='" + cscNumber + '\'' +
                ", cscVin='" + cscVin + '\'' +
                ", iccid='" + iccid + '\'' +
                ", mobile='" + mobile + '\'' +
                ", teNo='" + teNo + '\'' +
                ", cscCar=" + cscCar +
                ", cscModel=" + cscModel +
                ", cscType=" + cscType +
                ", cscOrder=" + cscOrder +
                ", cscData='" + cscData + '\'' +
                ", cscFault='" + cscFault + '\'' +
                ", cscUploadTime=" + cscUploadTime +
                ", cscAddTime=" + cscAddTime +
                ", cscLarum='" + cscLarum + '\'' +
                ", cscPrompt='" + cscPrompt + '\'' +
                ", cscDealDesc='" + cscDealDesc + '\'' +
                ", cscDealTime=" + cscDealTime +
                ", cscStatus=" + cscStatus +
                '}';
    }
}