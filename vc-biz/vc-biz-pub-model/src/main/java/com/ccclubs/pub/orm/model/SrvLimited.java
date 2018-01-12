package com.ccclubs.pub.orm.model;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table srv_limited
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class SrvLimited implements Serializable {
    /**
     * Database Column Remarks:
     *   编号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_limited.sl_id
     *
     * @mbg.generated
     */
    private Long slId;

    /**
     * Database Column Remarks:
     *   项目ID:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_limited.sl_project
     *
     * @mbg.generated
     */
    private Long slProject;

    /**
     * Database Column Remarks:
     *   关联用户:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_limited.sl_user
     *
     * @mbg.generated
     */
    private Long slUser;

    /**
     * Database Column Remarks:
     *   关联组:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_limited.sl_group
     *
     * @mbg.generated
     */
    private Long slGroup;

    /**
     * Database Column Remarks:
     *   权限值:1:有效,0:无效;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_limited.sl_limit
     *
     * @mbg.generated
     */
    private Integer slLimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_limited
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_limited.sl_id
     *
     * @return the value of srv_limited.sl_id
     *
     * @mbg.generated
     */
    public Long getSlId() {
        return slId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_limited.sl_id
     *
     * @param slId the value for srv_limited.sl_id
     *
     * @mbg.generated
     */
    public void setSlId(Long slId) {
        this.slId = slId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_limited.sl_project
     *
     * @return the value of srv_limited.sl_project
     *
     * @mbg.generated
     */
    public Long getSlProject() {
        return slProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_limited.sl_project
     *
     * @param slProject the value for srv_limited.sl_project
     *
     * @mbg.generated
     */
    public void setSlProject(Long slProject) {
        this.slProject = slProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_limited.sl_user
     *
     * @return the value of srv_limited.sl_user
     *
     * @mbg.generated
     */
    public Long getSlUser() {
        return slUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_limited.sl_user
     *
     * @param slUser the value for srv_limited.sl_user
     *
     * @mbg.generated
     */
    public void setSlUser(Long slUser) {
        this.slUser = slUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_limited.sl_group
     *
     * @return the value of srv_limited.sl_group
     *
     * @mbg.generated
     */
    public Long getSlGroup() {
        return slGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_limited.sl_group
     *
     * @param slGroup the value for srv_limited.sl_group
     *
     * @mbg.generated
     */
    public void setSlGroup(Long slGroup) {
        this.slGroup = slGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_limited.sl_limit
     *
     * @return the value of srv_limited.sl_limit
     *
     * @mbg.generated
     */
    public Integer getSlLimit() {
        return slLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_limited.sl_limit
     *
     * @param slLimit the value for srv_limited.sl_limit
     *
     * @mbg.generated
     */
    public void setSlLimit(Integer slLimit) {
        this.slLimit = slLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_limited
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
        SrvLimited other = (SrvLimited) that;
        return (this.getSlId() == null ? other.getSlId() == null : this.getSlId().equals(other.getSlId()))
            && (this.getSlProject() == null ? other.getSlProject() == null : this.getSlProject().equals(other.getSlProject()))
            && (this.getSlUser() == null ? other.getSlUser() == null : this.getSlUser().equals(other.getSlUser()))
            && (this.getSlGroup() == null ? other.getSlGroup() == null : this.getSlGroup().equals(other.getSlGroup()))
            && (this.getSlLimit() == null ? other.getSlLimit() == null : this.getSlLimit().equals(other.getSlLimit()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_limited
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSlId() == null) ? 0 : getSlId().hashCode());
        result = prime * result + ((getSlProject() == null) ? 0 : getSlProject().hashCode());
        result = prime * result + ((getSlUser() == null) ? 0 : getSlUser().hashCode());
        result = prime * result + ((getSlGroup() == null) ? 0 : getSlGroup().hashCode());
        result = prime * result + ((getSlLimit() == null) ? 0 : getSlLimit().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_limited
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", slId=").append(slId);
        sb.append(", slProject=").append(slProject);
        sb.append(", slUser=").append(slUser);
        sb.append(", slGroup=").append(slGroup);
        sb.append(", slLimit=").append(slLimit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}