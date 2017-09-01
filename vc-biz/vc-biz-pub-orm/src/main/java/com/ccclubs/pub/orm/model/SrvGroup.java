package com.ccclubs.pub.orm.model;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table srv_group
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class SrvGroup implements Serializable {
    /**
     * Database Column Remarks:
     *   编号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_group.sg_id
     *
     * @mbg.generated
     */
    private Long sgId;

    /**
     * Database Column Remarks:
     *   组名称:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_group.sg_name
     *
     * @mbg.generated
     */
    private String sgName;

    /**
     * Database Column Remarks:
     *   所属管理员:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_group.sg_parent_id
     *
     * @mbg.generated
     */
    private Long sgParentId;

    /**
     * Database Column Remarks:
     *   序列号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_group.sg_family
     *
     * @mbg.generated
     */
    private String sgFamily;

    /**
     * Database Column Remarks:
     *   组标识:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_group.sg_flag
     *
     * @mbg.generated
     */
    private String sgFlag;

    /**
     * Database Column Remarks:
     *   状态:0:默认;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_group.sg_status
     *
     * @mbg.generated
     */
    private Short sgStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_group.sg_id
     *
     * @return the value of srv_group.sg_id
     *
     * @mbg.generated
     */
    public Long getSgId() {
        return sgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_group.sg_id
     *
     * @param sgId the value for srv_group.sg_id
     *
     * @mbg.generated
     */
    public void setSgId(Long sgId) {
        this.sgId = sgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_group.sg_name
     *
     * @return the value of srv_group.sg_name
     *
     * @mbg.generated
     */
    public String getSgName() {
        return sgName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_group.sg_name
     *
     * @param sgName the value for srv_group.sg_name
     *
     * @mbg.generated
     */
    public void setSgName(String sgName) {
        this.sgName = sgName == null ? null : sgName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_group.sg_parent_id
     *
     * @return the value of srv_group.sg_parent_id
     *
     * @mbg.generated
     */
    public Long getSgParentId() {
        return sgParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_group.sg_parent_id
     *
     * @param sgParentId the value for srv_group.sg_parent_id
     *
     * @mbg.generated
     */
    public void setSgParentId(Long sgParentId) {
        this.sgParentId = sgParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_group.sg_family
     *
     * @return the value of srv_group.sg_family
     *
     * @mbg.generated
     */
    public String getSgFamily() {
        return sgFamily;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_group.sg_family
     *
     * @param sgFamily the value for srv_group.sg_family
     *
     * @mbg.generated
     */
    public void setSgFamily(String sgFamily) {
        this.sgFamily = sgFamily == null ? null : sgFamily.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_group.sg_flag
     *
     * @return the value of srv_group.sg_flag
     *
     * @mbg.generated
     */
    public String getSgFlag() {
        return sgFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_group.sg_flag
     *
     * @param sgFlag the value for srv_group.sg_flag
     *
     * @mbg.generated
     */
    public void setSgFlag(String sgFlag) {
        this.sgFlag = sgFlag == null ? null : sgFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_group.sg_status
     *
     * @return the value of srv_group.sg_status
     *
     * @mbg.generated
     */
    public Short getSgStatus() {
        return sgStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_group.sg_status
     *
     * @param sgStatus the value for srv_group.sg_status
     *
     * @mbg.generated
     */
    public void setSgStatus(Short sgStatus) {
        this.sgStatus = sgStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
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
        SrvGroup other = (SrvGroup) that;
        return (this.getSgId() == null ? other.getSgId() == null : this.getSgId().equals(other.getSgId()))
            && (this.getSgName() == null ? other.getSgName() == null : this.getSgName().equals(other.getSgName()))
            && (this.getSgParentId() == null ? other.getSgParentId() == null : this.getSgParentId().equals(other.getSgParentId()))
            && (this.getSgFamily() == null ? other.getSgFamily() == null : this.getSgFamily().equals(other.getSgFamily()))
            && (this.getSgFlag() == null ? other.getSgFlag() == null : this.getSgFlag().equals(other.getSgFlag()))
            && (this.getSgStatus() == null ? other.getSgStatus() == null : this.getSgStatus().equals(other.getSgStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSgId() == null) ? 0 : getSgId().hashCode());
        result = prime * result + ((getSgName() == null) ? 0 : getSgName().hashCode());
        result = prime * result + ((getSgParentId() == null) ? 0 : getSgParentId().hashCode());
        result = prime * result + ((getSgFamily() == null) ? 0 : getSgFamily().hashCode());
        result = prime * result + ((getSgFlag() == null) ? 0 : getSgFlag().hashCode());
        result = prime * result + ((getSgStatus() == null) ? 0 : getSgStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sgId=").append(sgId);
        sb.append(", sgName=").append(sgName);
        sb.append(", sgParentId=").append(sgParentId);
        sb.append(", sgFamily=").append(sgFamily);
        sb.append(", sgFlag=").append(sgFlag);
        sb.append(", sgStatus=").append(sgStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}