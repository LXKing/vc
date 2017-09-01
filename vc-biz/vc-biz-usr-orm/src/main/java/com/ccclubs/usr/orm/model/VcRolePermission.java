package com.ccclubs.usr.orm.model;

import java.io.Serializable;

public class VcRolePermission implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_role_permission.role_permission_id
     *
     * @mbg.generated
     */
    private String rolePermissionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_role_permission.role_id
     *
     * @mbg.generated
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_role_permission.permission_id
     *
     * @mbg.generated
     */
    private String permissionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vc_role_permission
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_role_permission.role_permission_id
     *
     * @return the value of vc_role_permission.role_permission_id
     *
     * @mbg.generated
     */
    public String getRolePermissionId() {
        return rolePermissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_role_permission.role_permission_id
     *
     * @param rolePermissionId the value for vc_role_permission.role_permission_id
     *
     * @mbg.generated
     */
    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId == null ? null : rolePermissionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_role_permission.role_id
     *
     * @return the value of vc_role_permission.role_id
     *
     * @mbg.generated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_role_permission.role_id
     *
     * @param roleId the value for vc_role_permission.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_role_permission.permission_id
     *
     * @return the value of vc_role_permission.permission_id
     *
     * @mbg.generated
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_role_permission.permission_id
     *
     * @param permissionId the value for vc_role_permission.permission_id
     *
     * @mbg.generated
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_role_permission
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
        VcRolePermission other = (VcRolePermission) that;
        return (this.getRolePermissionId() == null ? other.getRolePermissionId() == null : this.getRolePermissionId().equals(other.getRolePermissionId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_role_permission
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRolePermissionId() == null) ? 0 : getRolePermissionId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_role_permission
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rolePermissionId=").append(rolePermissionId);
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}