package com.ccclubs.pub.orm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SrvHost implements Serializable {
    /**
     * 编号:
     */
    private Integer shId;

    /**
     * 域名称:
     */
    private String shName;

    /**
     * 授权密钥:
     */
    private String shKey;

    /**
     * 应用转发Topic
     */
    private String shTopic;

    /**
     * 转发指令结果
     */
    private String shTransformRemote;

    /**
     * 转发状态
     */
    private String shTransformStatus;

    /**
     * 转发CAN
     */
    private String shTransformCan;

    /**
     * 添加时间:
     */
    private Date shAddTime;

    private Date shUptTime;

    /**
     * 状态:1:正常,0:无效;
     */
    private Byte shStatus;

    /**
     * 应用ID
     */
    private String shAppid;

    private static final long serialVersionUID = 1L;

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName;
    }

    public String getShKey() {
        return shKey;
    }

    public void setShKey(String shKey) {
        this.shKey = shKey;
    }

    public String getShTopic() {
        return shTopic;
    }

    public void setShTopic(String shTopic) {
        this.shTopic = shTopic;
    }

    public String getShTransformRemote() {
        return shTransformRemote;
    }

    public void setShTransformRemote(String shTransformRemote) {
        this.shTransformRemote = shTransformRemote;
    }

    public String getShTransformStatus() {
        return shTransformStatus;
    }

    public void setShTransformStatus(String shTransformStatus) {
        this.shTransformStatus = shTransformStatus;
    }

    public String getShTransformCan() {
        return shTransformCan;
    }

    public void setShTransformCan(String shTransformCan) {
        this.shTransformCan = shTransformCan;
    }

    public Date getShAddTime() {
        return shAddTime;
    }

    public void setShAddTime(Date shAddTime) {
        this.shAddTime = shAddTime;
    }

    public Date getShUptTime() {
        return shUptTime;
    }

    public void setShUptTime(Date shUptTime) {
        this.shUptTime = shUptTime;
    }

    public Byte getShStatus() {
        return shStatus;
    }

    public void setShStatus(Byte shStatus) {
        this.shStatus = shStatus;
    }

    public String getShAppid() {
        return shAppid;
    }

    public void setShAppid(String shAppid) {
        this.shAppid = shAppid;
    }

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
        SrvHost other = (SrvHost) that;
        return (this.getShId() == null ? other.getShId() == null : this.getShId().equals(other.getShId()))
            && (this.getShName() == null ? other.getShName() == null : this.getShName().equals(other.getShName()))
            && (this.getShKey() == null ? other.getShKey() == null : this.getShKey().equals(other.getShKey()))
            && (this.getShTopic() == null ? other.getShTopic() == null : this.getShTopic().equals(other.getShTopic()))
            && (this.getShTransformRemote() == null ? other.getShTransformRemote() == null : this.getShTransformRemote().equals(other.getShTransformRemote()))
            && (this.getShTransformStatus() == null ? other.getShTransformStatus() == null : this.getShTransformStatus().equals(other.getShTransformStatus()))
            && (this.getShTransformCan() == null ? other.getShTransformCan() == null : this.getShTransformCan().equals(other.getShTransformCan()))
            && (this.getShAddTime() == null ? other.getShAddTime() == null : this.getShAddTime().equals(other.getShAddTime()))
            && (this.getShUptTime() == null ? other.getShUptTime() == null : this.getShUptTime().equals(other.getShUptTime()))
            && (this.getShStatus() == null ? other.getShStatus() == null : this.getShStatus().equals(other.getShStatus()))
            && (this.getShAppid() == null ? other.getShAppid() == null : this.getShAppid().equals(other.getShAppid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShId() == null) ? 0 : getShId().hashCode());
        result = prime * result + ((getShName() == null) ? 0 : getShName().hashCode());
        result = prime * result + ((getShKey() == null) ? 0 : getShKey().hashCode());
        result = prime * result + ((getShTopic() == null) ? 0 : getShTopic().hashCode());
        result = prime * result + ((getShTransformRemote() == null) ? 0 : getShTransformRemote().hashCode());
        result = prime * result + ((getShTransformStatus() == null) ? 0 : getShTransformStatus().hashCode());
        result = prime * result + ((getShTransformCan() == null) ? 0 : getShTransformCan().hashCode());
        result = prime * result + ((getShAddTime() == null) ? 0 : getShAddTime().hashCode());
        result = prime * result + ((getShUptTime() == null) ? 0 : getShUptTime().hashCode());
        result = prime * result + ((getShStatus() == null) ? 0 : getShStatus().hashCode());
        result = prime * result + ((getShAppid() == null) ? 0 : getShAppid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shId=").append(shId);
        sb.append(", shName=").append(shName);
        sb.append(", shKey=").append(shKey);
        sb.append(", shTopic=").append(shTopic);
        sb.append(", shTransformRemote=").append(shTransformRemote);
        sb.append(", shTransformStatus=").append(shTransformStatus);
        sb.append(", shTransformCan=").append(shTransformCan);
        sb.append(", shAddTime=").append(shAddTime);
        sb.append(", shUptTime=").append(shUptTime);
        sb.append(", shStatus=").append(shStatus);
        sb.append(", shAppid=").append(shAppid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}