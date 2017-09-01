package com.ccclubs.demo.orm.model;

import java.io.Serializable;
import java.util.Date;

public class CsQuber implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_id
     *
     * @mbg.generated
     */
    private Long csqId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_host
     *
     * @mbg.generated
     */
    private Long csqHost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_name
     *
     * @mbg.generated
     */
    private String csqName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_username
     *
     * @mbg.generated
     */
    private String csqUsername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_password
     *
     * @mbg.generated
     */
    private String csqPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_remark
     *
     * @mbg.generated
     */
    private String csqRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_update_time
     *
     * @mbg.generated
     */
    private Date csqUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_add_time
     *
     * @mbg.generated
     */
    private Date csqAddTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_quber.csq_status
     *
     * @mbg.generated
     */
    private Short csqStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_quber
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_id
     *
     * @return the value of cs_quber.csq_id
     *
     * @mbg.generated
     */
    public Long getCsqId() {
        return csqId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_id
     *
     * @param csqId the value for cs_quber.csq_id
     *
     * @mbg.generated
     */
    public void setCsqId(Long csqId) {
        this.csqId = csqId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_host
     *
     * @return the value of cs_quber.csq_host
     *
     * @mbg.generated
     */
    public Long getCsqHost() {
        return csqHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_host
     *
     * @param csqHost the value for cs_quber.csq_host
     *
     * @mbg.generated
     */
    public void setCsqHost(Long csqHost) {
        this.csqHost = csqHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_name
     *
     * @return the value of cs_quber.csq_name
     *
     * @mbg.generated
     */
    public String getCsqName() {
        return csqName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_name
     *
     * @param csqName the value for cs_quber.csq_name
     *
     * @mbg.generated
     */
    public void setCsqName(String csqName) {
        this.csqName = csqName == null ? null : csqName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_username
     *
     * @return the value of cs_quber.csq_username
     *
     * @mbg.generated
     */
    public String getCsqUsername() {
        return csqUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_username
     *
     * @param csqUsername the value for cs_quber.csq_username
     *
     * @mbg.generated
     */
    public void setCsqUsername(String csqUsername) {
        this.csqUsername = csqUsername == null ? null : csqUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_password
     *
     * @return the value of cs_quber.csq_password
     *
     * @mbg.generated
     */
    public String getCsqPassword() {
        return csqPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_password
     *
     * @param csqPassword the value for cs_quber.csq_password
     *
     * @mbg.generated
     */
    public void setCsqPassword(String csqPassword) {
        this.csqPassword = csqPassword == null ? null : csqPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_remark
     *
     * @return the value of cs_quber.csq_remark
     *
     * @mbg.generated
     */
    public String getCsqRemark() {
        return csqRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_remark
     *
     * @param csqRemark the value for cs_quber.csq_remark
     *
     * @mbg.generated
     */
    public void setCsqRemark(String csqRemark) {
        this.csqRemark = csqRemark == null ? null : csqRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_update_time
     *
     * @return the value of cs_quber.csq_update_time
     *
     * @mbg.generated
     */
    public Date getCsqUpdateTime() {
        return csqUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_update_time
     *
     * @param csqUpdateTime the value for cs_quber.csq_update_time
     *
     * @mbg.generated
     */
    public void setCsqUpdateTime(Date csqUpdateTime) {
        this.csqUpdateTime = csqUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_add_time
     *
     * @return the value of cs_quber.csq_add_time
     *
     * @mbg.generated
     */
    public Date getCsqAddTime() {
        return csqAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_add_time
     *
     * @param csqAddTime the value for cs_quber.csq_add_time
     *
     * @mbg.generated
     */
    public void setCsqAddTime(Date csqAddTime) {
        this.csqAddTime = csqAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_quber.csq_status
     *
     * @return the value of cs_quber.csq_status
     *
     * @mbg.generated
     */
    public Short getCsqStatus() {
        return csqStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_quber.csq_status
     *
     * @param csqStatus the value for cs_quber.csq_status
     *
     * @mbg.generated
     */
    public void setCsqStatus(Short csqStatus) {
        this.csqStatus = csqStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_quber
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
        CsQuber other = (CsQuber) that;
        return (this.getCsqId() == null ? other.getCsqId() == null : this.getCsqId().equals(other.getCsqId()))
            && (this.getCsqHost() == null ? other.getCsqHost() == null : this.getCsqHost().equals(other.getCsqHost()))
            && (this.getCsqName() == null ? other.getCsqName() == null : this.getCsqName().equals(other.getCsqName()))
            && (this.getCsqUsername() == null ? other.getCsqUsername() == null : this.getCsqUsername().equals(other.getCsqUsername()))
            && (this.getCsqPassword() == null ? other.getCsqPassword() == null : this.getCsqPassword().equals(other.getCsqPassword()))
            && (this.getCsqRemark() == null ? other.getCsqRemark() == null : this.getCsqRemark().equals(other.getCsqRemark()))
            && (this.getCsqUpdateTime() == null ? other.getCsqUpdateTime() == null : this.getCsqUpdateTime().equals(other.getCsqUpdateTime()))
            && (this.getCsqAddTime() == null ? other.getCsqAddTime() == null : this.getCsqAddTime().equals(other.getCsqAddTime()))
            && (this.getCsqStatus() == null ? other.getCsqStatus() == null : this.getCsqStatus().equals(other.getCsqStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_quber
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCsqId() == null) ? 0 : getCsqId().hashCode());
        result = prime * result + ((getCsqHost() == null) ? 0 : getCsqHost().hashCode());
        result = prime * result + ((getCsqName() == null) ? 0 : getCsqName().hashCode());
        result = prime * result + ((getCsqUsername() == null) ? 0 : getCsqUsername().hashCode());
        result = prime * result + ((getCsqPassword() == null) ? 0 : getCsqPassword().hashCode());
        result = prime * result + ((getCsqRemark() == null) ? 0 : getCsqRemark().hashCode());
        result = prime * result + ((getCsqUpdateTime() == null) ? 0 : getCsqUpdateTime().hashCode());
        result = prime * result + ((getCsqAddTime() == null) ? 0 : getCsqAddTime().hashCode());
        result = prime * result + ((getCsqStatus() == null) ? 0 : getCsqStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_quber
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", csqId=").append(csqId);
        sb.append(", csqHost=").append(csqHost);
        sb.append(", csqName=").append(csqName);
        sb.append(", csqUsername=").append(csqUsername);
        sb.append(", csqPassword=").append(csqPassword);
        sb.append(", csqRemark=").append(csqRemark);
        sb.append(", csqUpdateTime=").append(csqUpdateTime);
        sb.append(", csqAddTime=").append(csqAddTime);
        sb.append(", csqStatus=").append(csqStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}