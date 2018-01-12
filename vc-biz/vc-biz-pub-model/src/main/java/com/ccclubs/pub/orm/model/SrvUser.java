package com.ccclubs.pub.orm.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table srv_user
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class SrvUser implements Serializable {
    /**
     * Database Column Remarks:
     *   编号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_id
     *
     * @mbg.generated
     */
    private Long suId;

    /**
     * Database Column Remarks:
     *   所属帐号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_login
     *
     * @mbg.generated
     */
    private Long suLogin;

    /**
     * Database Column Remarks:
     *   所属组:{suParentId}:sgParentId;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_group_id
     *
     * @mbg.generated
     */
    private Long suGroupId;

    /**
     * Database Column Remarks:
     *   上级管理:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_parent_id
     *
     * @mbg.generated
     */
    private Long suParentId;

    /**
     * Database Column Remarks:
     *   用户名称:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_name
     *
     * @mbg.generated
     */
    private String suName;

    /**
     * Database Column Remarks:
     *   手机号码:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_mobile
     *
     * @mbg.generated
     */
    private String suMobile;

    /**
     * Database Column Remarks:
     *   族序号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_family
     *
     * @mbg.generated
     */
    private String suFamily;

    /**
     * Database Column Remarks:
     *   添加时间:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_add_time
     *
     * @mbg.generated
     */
    private Date suAddTime;

    /**
     * Database Column Remarks:
     *   最后登录时间:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_last_time
     *
     * @mbg.generated
     */
    private Date suLastTime;

    /**
     * Database Column Remarks:
     *   最后登录IP:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_last_ip
     *
     * @mbg.generated
     */
    private String suLastIp;

    /**
     * Database Column Remarks:
     *   状态:1:有效,0:无效;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_user.su_status
     *
     * @mbg.generated
     */
    private Short suStatus;

    /**
     * Database Column Remarks:
     *   快捷方式:
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
    public Long getSuId() {
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
    public void setSuId(Long suId) {
        this.suId = suId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_login
     *
     * @return the value of srv_user.su_login
     *
     * @mbg.generated
     */
    public Long getSuLogin() {
        return suLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_login
     *
     * @param suLogin the value for srv_user.su_login
     *
     * @mbg.generated
     */
    public void setSuLogin(Long suLogin) {
        this.suLogin = suLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_group_id
     *
     * @return the value of srv_user.su_group_id
     *
     * @mbg.generated
     */
    public Long getSuGroupId() {
        return suGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_group_id
     *
     * @param suGroupId the value for srv_user.su_group_id
     *
     * @mbg.generated
     */
    public void setSuGroupId(Long suGroupId) {
        this.suGroupId = suGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_parent_id
     *
     * @return the value of srv_user.su_parent_id
     *
     * @mbg.generated
     */
    public Long getSuParentId() {
        return suParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_parent_id
     *
     * @param suParentId the value for srv_user.su_parent_id
     *
     * @mbg.generated
     */
    public void setSuParentId(Long suParentId) {
        this.suParentId = suParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_user.su_name
     *
     * @return the value of srv_user.su_name
     *
     * @mbg.generated
     */
    public String getSuName() {
        return suName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_name
     *
     * @param suName the value for srv_user.su_name
     *
     * @mbg.generated
     */
    public void setSuName(String suName) {
        this.suName = suName == null ? null : suName.trim();
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
     * This method returns the value of the database column srv_user.su_family
     *
     * @return the value of srv_user.su_family
     *
     * @mbg.generated
     */
    public String getSuFamily() {
        return suFamily;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_user.su_family
     *
     * @param suFamily the value for srv_user.su_family
     *
     * @mbg.generated
     */
    public void setSuFamily(String suFamily) {
        this.suFamily = suFamily == null ? null : suFamily.trim();
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
            && (this.getSuLogin() == null ? other.getSuLogin() == null : this.getSuLogin().equals(other.getSuLogin()))
            && (this.getSuGroupId() == null ? other.getSuGroupId() == null : this.getSuGroupId().equals(other.getSuGroupId()))
            && (this.getSuParentId() == null ? other.getSuParentId() == null : this.getSuParentId().equals(other.getSuParentId()))
            && (this.getSuName() == null ? other.getSuName() == null : this.getSuName().equals(other.getSuName()))
            && (this.getSuMobile() == null ? other.getSuMobile() == null : this.getSuMobile().equals(other.getSuMobile()))
            && (this.getSuFamily() == null ? other.getSuFamily() == null : this.getSuFamily().equals(other.getSuFamily()))
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
        result = prime * result + ((getSuLogin() == null) ? 0 : getSuLogin().hashCode());
        result = prime * result + ((getSuGroupId() == null) ? 0 : getSuGroupId().hashCode());
        result = prime * result + ((getSuParentId() == null) ? 0 : getSuParentId().hashCode());
        result = prime * result + ((getSuName() == null) ? 0 : getSuName().hashCode());
        result = prime * result + ((getSuMobile() == null) ? 0 : getSuMobile().hashCode());
        result = prime * result + ((getSuFamily() == null) ? 0 : getSuFamily().hashCode());
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
        sb.append(", suLogin=").append(suLogin);
        sb.append(", suGroupId=").append(suGroupId);
        sb.append(", suParentId=").append(suParentId);
        sb.append(", suName=").append(suName);
        sb.append(", suMobile=").append(suMobile);
        sb.append(", suFamily=").append(suFamily);
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