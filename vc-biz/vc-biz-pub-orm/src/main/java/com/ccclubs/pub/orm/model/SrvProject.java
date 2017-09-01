package com.ccclubs.pub.orm.model;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table srv_project
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class SrvProject implements Serializable {
    /**
     * Database Column Remarks:
     *   编号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_id
     *
     * @mbg.generated
     */
    private Long spId;

    /**
     * Database Column Remarks:
     *   项目名称:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_name
     *
     * @mbg.generated
     */
    private String spName;

    /**
     * Database Column Remarks:
     *   父节点:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_parent_id
     *
     * @mbg.generated
     */
    private Long spParentId;

    /**
     * Database Column Remarks:
     *   家族:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_family
     *
     * @mbg.generated
     */
    private String spFamily;

    /**
     * Database Column Remarks:
     *   项目地址:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_url
     *
     * @mbg.generated
     */
    private String spUrl;

    /**
     * Database Column Remarks:
     *   Logo:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_logo
     *
     * @mbg.generated
     */
    private String spLogo;

    /**
     * Database Column Remarks:
     *   项目描述:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_descript
     *
     * @mbg.generated
     */
    private String spDescript;

    /**
     * Database Column Remarks:
     *   优先级:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_level
     *
     * @mbg.generated
     */
    private Integer spLevel;

    /**
     * Database Column Remarks:
     *   扩展权限:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_limit_exp
     *
     * @mbg.generated
     */
    private String spLimitExp;

    /**
     * Database Column Remarks:
     *   项目分组:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_group
     *
     * @mbg.generated
     */
    private String spGroup;

    /**
     * Database Column Remarks:
     *   状态:1:有效,0:无效;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_status
     *
     * @mbg.generated
     */
    private Short spStatus;

    /**
     * Database Column Remarks:
     *   流程信息:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column srv_project.sp_mind
     *
     * @mbg.generated
     */
    private String spMind;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_project
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_id
     *
     * @return the value of srv_project.sp_id
     *
     * @mbg.generated
     */
    public Long getSpId() {
        return spId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_id
     *
     * @param spId the value for srv_project.sp_id
     *
     * @mbg.generated
     */
    public void setSpId(Long spId) {
        this.spId = spId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_name
     *
     * @return the value of srv_project.sp_name
     *
     * @mbg.generated
     */
    public String getSpName() {
        return spName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_name
     *
     * @param spName the value for srv_project.sp_name
     *
     * @mbg.generated
     */
    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_parent_id
     *
     * @return the value of srv_project.sp_parent_id
     *
     * @mbg.generated
     */
    public Long getSpParentId() {
        return spParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_parent_id
     *
     * @param spParentId the value for srv_project.sp_parent_id
     *
     * @mbg.generated
     */
    public void setSpParentId(Long spParentId) {
        this.spParentId = spParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_family
     *
     * @return the value of srv_project.sp_family
     *
     * @mbg.generated
     */
    public String getSpFamily() {
        return spFamily;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_family
     *
     * @param spFamily the value for srv_project.sp_family
     *
     * @mbg.generated
     */
    public void setSpFamily(String spFamily) {
        this.spFamily = spFamily == null ? null : spFamily.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_url
     *
     * @return the value of srv_project.sp_url
     *
     * @mbg.generated
     */
    public String getSpUrl() {
        return spUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_url
     *
     * @param spUrl the value for srv_project.sp_url
     *
     * @mbg.generated
     */
    public void setSpUrl(String spUrl) {
        this.spUrl = spUrl == null ? null : spUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_logo
     *
     * @return the value of srv_project.sp_logo
     *
     * @mbg.generated
     */
    public String getSpLogo() {
        return spLogo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_logo
     *
     * @param spLogo the value for srv_project.sp_logo
     *
     * @mbg.generated
     */
    public void setSpLogo(String spLogo) {
        this.spLogo = spLogo == null ? null : spLogo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_descript
     *
     * @return the value of srv_project.sp_descript
     *
     * @mbg.generated
     */
    public String getSpDescript() {
        return spDescript;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_descript
     *
     * @param spDescript the value for srv_project.sp_descript
     *
     * @mbg.generated
     */
    public void setSpDescript(String spDescript) {
        this.spDescript = spDescript == null ? null : spDescript.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_level
     *
     * @return the value of srv_project.sp_level
     *
     * @mbg.generated
     */
    public Integer getSpLevel() {
        return spLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_level
     *
     * @param spLevel the value for srv_project.sp_level
     *
     * @mbg.generated
     */
    public void setSpLevel(Integer spLevel) {
        this.spLevel = spLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_limit_exp
     *
     * @return the value of srv_project.sp_limit_exp
     *
     * @mbg.generated
     */
    public String getSpLimitExp() {
        return spLimitExp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_limit_exp
     *
     * @param spLimitExp the value for srv_project.sp_limit_exp
     *
     * @mbg.generated
     */
    public void setSpLimitExp(String spLimitExp) {
        this.spLimitExp = spLimitExp == null ? null : spLimitExp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_group
     *
     * @return the value of srv_project.sp_group
     *
     * @mbg.generated
     */
    public String getSpGroup() {
        return spGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_group
     *
     * @param spGroup the value for srv_project.sp_group
     *
     * @mbg.generated
     */
    public void setSpGroup(String spGroup) {
        this.spGroup = spGroup == null ? null : spGroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_status
     *
     * @return the value of srv_project.sp_status
     *
     * @mbg.generated
     */
    public Short getSpStatus() {
        return spStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_status
     *
     * @param spStatus the value for srv_project.sp_status
     *
     * @mbg.generated
     */
    public void setSpStatus(Short spStatus) {
        this.spStatus = spStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column srv_project.sp_mind
     *
     * @return the value of srv_project.sp_mind
     *
     * @mbg.generated
     */
    public String getSpMind() {
        return spMind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column srv_project.sp_mind
     *
     * @param spMind the value for srv_project.sp_mind
     *
     * @mbg.generated
     */
    public void setSpMind(String spMind) {
        this.spMind = spMind == null ? null : spMind.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_project
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
        SrvProject other = (SrvProject) that;
        return (this.getSpId() == null ? other.getSpId() == null : this.getSpId().equals(other.getSpId()))
            && (this.getSpName() == null ? other.getSpName() == null : this.getSpName().equals(other.getSpName()))
            && (this.getSpParentId() == null ? other.getSpParentId() == null : this.getSpParentId().equals(other.getSpParentId()))
            && (this.getSpFamily() == null ? other.getSpFamily() == null : this.getSpFamily().equals(other.getSpFamily()))
            && (this.getSpUrl() == null ? other.getSpUrl() == null : this.getSpUrl().equals(other.getSpUrl()))
            && (this.getSpLogo() == null ? other.getSpLogo() == null : this.getSpLogo().equals(other.getSpLogo()))
            && (this.getSpDescript() == null ? other.getSpDescript() == null : this.getSpDescript().equals(other.getSpDescript()))
            && (this.getSpLevel() == null ? other.getSpLevel() == null : this.getSpLevel().equals(other.getSpLevel()))
            && (this.getSpLimitExp() == null ? other.getSpLimitExp() == null : this.getSpLimitExp().equals(other.getSpLimitExp()))
            && (this.getSpGroup() == null ? other.getSpGroup() == null : this.getSpGroup().equals(other.getSpGroup()))
            && (this.getSpStatus() == null ? other.getSpStatus() == null : this.getSpStatus().equals(other.getSpStatus()))
            && (this.getSpMind() == null ? other.getSpMind() == null : this.getSpMind().equals(other.getSpMind()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_project
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpId() == null) ? 0 : getSpId().hashCode());
        result = prime * result + ((getSpName() == null) ? 0 : getSpName().hashCode());
        result = prime * result + ((getSpParentId() == null) ? 0 : getSpParentId().hashCode());
        result = prime * result + ((getSpFamily() == null) ? 0 : getSpFamily().hashCode());
        result = prime * result + ((getSpUrl() == null) ? 0 : getSpUrl().hashCode());
        result = prime * result + ((getSpLogo() == null) ? 0 : getSpLogo().hashCode());
        result = prime * result + ((getSpDescript() == null) ? 0 : getSpDescript().hashCode());
        result = prime * result + ((getSpLevel() == null) ? 0 : getSpLevel().hashCode());
        result = prime * result + ((getSpLimitExp() == null) ? 0 : getSpLimitExp().hashCode());
        result = prime * result + ((getSpGroup() == null) ? 0 : getSpGroup().hashCode());
        result = prime * result + ((getSpStatus() == null) ? 0 : getSpStatus().hashCode());
        result = prime * result + ((getSpMind() == null) ? 0 : getSpMind().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_project
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spId=").append(spId);
        sb.append(", spName=").append(spName);
        sb.append(", spParentId=").append(spParentId);
        sb.append(", spFamily=").append(spFamily);
        sb.append(", spUrl=").append(spUrl);
        sb.append(", spLogo=").append(spLogo);
        sb.append(", spDescript=").append(spDescript);
        sb.append(", spLevel=").append(spLevel);
        sb.append(", spLimitExp=").append(spLimitExp);
        sb.append(", spGroup=").append(spGroup);
        sb.append(", spStatus=").append(spStatus);
        sb.append(", spMind=").append(spMind);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}