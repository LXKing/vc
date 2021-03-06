package com.ccclubs.pub.orm.model;

import java.io.Serializable;
import java.util.Date;

public class SrvUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_id
     *
     * @mbg.generated
     */
    private Integer suId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_host
     *
     * @mbg.generated
     */
    private String suHost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_group
     *
     * @mbg.generated
     */
    private Long suGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_username
     *
     * @mbg.generated
     */
    private String suUsername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_password
     *
     * @mbg.generated
     */
    private String suPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_real_name
     *
     * @mbg.generated
     */
    private String suRealName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_mobile
     *
     * @mbg.generated
     */
    private String suMobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_add_time
     *
     * @mbg.generated
     */
    private Date suAddTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_last_time
     *
     * @mbg.generated
     */
    private Date suLastTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_last_ip
     *
     * @mbg.generated
     */
    private String suLastIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_status
     *
     * @mbg.generated
     */
    private Short suStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_shortcut
     *
     * @mbg.generated
     */
    private String suShortcut;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_id
     *
     * @return the value of srv_user.su_id
     *
     * @mbg.generated
     */
    public Integer getSuId() {
        return suId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_id
     *
     * @param suId the value for srv_user.su_id
     *
     * @mbg.generated
     */
    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_host
     *
     * @return the value of srv_user.su_host
     *
     * @mbg.generated
     */
    public String getSuHost() {
        return suHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_host
     *
     * @param suHost the value for srv_user.su_host
     *
     * @mbg.generated
     */
    public void setSuHost(String suHost) {
        this.suHost = suHost == null ? null : suHost.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_group
     *
     * @return the value of srv_user.su_group
     *
     * @mbg.generated
     */
    public Long getSuGroup() {
        return suGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_group
     *
     * @param suGroup the value for srv_user.su_group
     *
     * @mbg.generated
     */
    public void setSuGroup(Long suGroup) {
        this.suGroup = suGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_username
     *
     * @return the value of srv_user.su_username
     *
     * @mbg.generated
     */
    public String getSuUsername() {
        return suUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_username
     *
     * @param suUsername the value for srv_user.su_username
     *
     * @mbg.generated
     */
    public void setSuUsername(String suUsername) {
        this.suUsername = suUsername == null ? null : suUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_password
     *
     * @return the value of srv_user.su_password
     *
     * @mbg.generated
     */
    public String getSuPassword() {
        return suPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_password
     *
     * @param suPassword the value for srv_user.su_password
     *
     * @mbg.generated
     */
    public void setSuPassword(String suPassword) {
        this.suPassword = suPassword == null ? null : suPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_real_name
     *
     * @return the value of srv_user.su_real_name
     *
     * @mbg.generated
     */
    public String getSuRealName() {
        return suRealName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_real_name
     *
     * @param suRealName the value for srv_user.su_real_name
     *
     * @mbg.generated
     */
    public void setSuRealName(String suRealName) {
        this.suRealName = suRealName == null ? null : suRealName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_mobile
     *
     * @return the value of srv_user.su_mobile
     *
     * @mbg.generated
     */
    public String getSuMobile() {
        return suMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_mobile
     *
     * @param suMobile the value for srv_user.su_mobile
     *
     * @mbg.generated
     */
    public void setSuMobile(String suMobile) {
        this.suMobile = suMobile == null ? null : suMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_add_time
     *
     * @return the value of srv_user.su_add_time
     *
     * @mbg.generated
     */
    public Date getSuAddTime() {
        return suAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_add_time
     *
     * @param suAddTime the value for srv_user.su_add_time
     *
     * @mbg.generated
     */
    public void setSuAddTime(Date suAddTime) {
        this.suAddTime = suAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_last_time
     *
     * @return the value of srv_user.su_last_time
     *
     * @mbg.generated
     */
    public Date getSuLastTime() {
        return suLastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_last_time
     *
     * @param suLastTime the value for srv_user.su_last_time
     *
     * @mbg.generated
     */
    public void setSuLastTime(Date suLastTime) {
        this.suLastTime = suLastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_last_ip
     *
     * @return the value of srv_user.su_last_ip
     *
     * @mbg.generated
     */
    public String getSuLastIp() {
        return suLastIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_last_ip
     *
     * @param suLastIp the value for srv_user.su_last_ip
     *
     * @mbg.generated
     */
    public void setSuLastIp(String suLastIp) {
        this.suLastIp = suLastIp == null ? null : suLastIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_status
     *
     * @return the value of srv_user.su_status
     *
     * @mbg.generated
     */
    public Short getSuStatus() {
        return suStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_status
     *
     * @param suStatus the value for srv_user.su_status
     *
     * @mbg.generated
     */
    public void setSuStatus(Short suStatus) {
        this.suStatus = suStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_shortcut
     *
     * @return the value of srv_user.su_shortcut
     *
     * @mbg.generated
     */
    public String getSuShortcut() {
        return suShortcut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_shortcut
     *
     * @param suShortcut the value for srv_user.su_shortcut
     *
     * @mbg.generated
     */
    public void setSuShortcut(String suShortcut) {
        this.suShortcut = suShortcut == null ? null : suShortcut.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_user
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
        SrvUser other = (SrvUser) that;
        return (this.getSuId() == null ? other.getSuId() == null : this.getSuId().equals(other.getSuId()))
            && (this.getSuHost() == null ? other.getSuHost() == null : this.getSuHost().equals(other.getSuHost()))
            && (this.getSuGroup() == null ? other.getSuGroup() == null : this.getSuGroup().equals(other.getSuGroup()))
            && (this.getSuUsername() == null ? other.getSuUsername() == null : this.getSuUsername().equals(other.getSuUsername()))
            && (this.getSuPassword() == null ? other.getSuPassword() == null : this.getSuPassword().equals(other.getSuPassword()))
            && (this.getSuRealName() == null ? other.getSuRealName() == null : this.getSuRealName().equals(other.getSuRealName()))
            && (this.getSuMobile() == null ? other.getSuMobile() == null : this.getSuMobile().equals(other.getSuMobile()))
            && (this.getSuAddTime() == null ? other.getSuAddTime() == null : this.getSuAddTime().equals(other.getSuAddTime()))
            && (this.getSuLastTime() == null ? other.getSuLastTime() == null : this.getSuLastTime().equals(other.getSuLastTime()))
            && (this.getSuLastIp() == null ? other.getSuLastIp() == null : this.getSuLastIp().equals(other.getSuLastIp()))
            && (this.getSuStatus() == null ? other.getSuStatus() == null : this.getSuStatus().equals(other.getSuStatus()))
            && (this.getSuShortcut() == null ? other.getSuShortcut() == null : this.getSuShortcut().equals(other.getSuShortcut()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_user
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuId() == null) ? 0 : getSuId().hashCode());
        result = prime * result + ((getSuHost() == null) ? 0 : getSuHost().hashCode());
        result = prime * result + ((getSuGroup() == null) ? 0 : getSuGroup().hashCode());
        result = prime * result + ((getSuUsername() == null) ? 0 : getSuUsername().hashCode());
        result = prime * result + ((getSuPassword() == null) ? 0 : getSuPassword().hashCode());
        result = prime * result + ((getSuRealName() == null) ? 0 : getSuRealName().hashCode());
        result = prime * result + ((getSuMobile() == null) ? 0 : getSuMobile().hashCode());
        result = prime * result + ((getSuAddTime() == null) ? 0 : getSuAddTime().hashCode());
        result = prime * result + ((getSuLastTime() == null) ? 0 : getSuLastTime().hashCode());
        result = prime * result + ((getSuLastIp() == null) ? 0 : getSuLastIp().hashCode());
        result = prime * result + ((getSuStatus() == null) ? 0 : getSuStatus().hashCode());
        result = prime * result + ((getSuShortcut() == null) ? 0 : getSuShortcut().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_user
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", suId=").append(suId);
        sb.append(", suHost=").append(suHost);
        sb.append(", suGroup=").append(suGroup);
        sb.append(", suUsername=").append(suUsername);
        sb.append(", suPassword=").append(suPassword);
        sb.append(", suRealName=").append(suRealName);
        sb.append(", suMobile=").append(suMobile);
        sb.append(", suAddTime=").append(suAddTime);
        sb.append(", suLastTime=").append(suLastTime);
        sb.append(", suLastIp=").append(suLastIp);
        sb.append(", suStatus=").append(suStatus);
        sb.append(", suShortcut=").append(suShortcut);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}