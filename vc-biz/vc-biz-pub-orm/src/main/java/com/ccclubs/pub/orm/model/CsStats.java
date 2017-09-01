package com.ccclubs.pub.orm.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cs_stats
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class CsStats implements Serializable {
    /**
     * Database Column Remarks:
     *   编号:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_id
     *
     * @mbg.generated
     */
    private Long cssId;

    /**
     * Database Column Remarks:
     *   统计日期:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_date
     *
     * @mbg.generated
     */
    private Date cssDate;

    /**
     * Database Column Remarks:
     *   所属车辆:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_car
     *
     * @mbg.generated
     */
    private Long cssCar;

    /**
     * Database Column Remarks:
     *   百公里能耗:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_energy
     *
     * @mbg.generated
     */
    private Double cssEnergy;

    /**
     * Database Column Remarks:
     *   平均速度:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_speed
     *
     * @mbg.generated
     */
    private Double cssSpeed;

    /**
     * Database Column Remarks:
     *   行驶里程:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_mileage
     *
     * @mbg.generated
     */
    private Double cssMileage;

    /**
     * Database Column Remarks:
     *   运行时长:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_time
     *
     * @mbg.generated
     */
    private Double cssTime;

    /**
     * Database Column Remarks:
     *   修改时间:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_update_time
     *
     * @mbg.generated
     */
    private Date cssUpdateTime;

    /**
     * Database Column Remarks:
     *   添加时间:
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_add_time
     *
     * @mbg.generated
     */
    private Date cssAddTime;

    /**
     * Database Column Remarks:
     *   状态:1:正常,0:无效;
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_stats.css_status
     *
     * @mbg.generated
     */
    private Short cssStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_stats
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_id
     *
     * @return the value of cs_stats.css_id
     *
     * @mbg.generated
     */
    public Long getCssId() {
        return cssId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_id
     *
     * @param cssId the value for cs_stats.css_id
     *
     * @mbg.generated
     */
    public void setCssId(Long cssId) {
        this.cssId = cssId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_date
     *
     * @return the value of cs_stats.css_date
     *
     * @mbg.generated
     */
    public Date getCssDate() {
        return cssDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_date
     *
     * @param cssDate the value for cs_stats.css_date
     *
     * @mbg.generated
     */
    public void setCssDate(Date cssDate) {
        this.cssDate = cssDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_car
     *
     * @return the value of cs_stats.css_car
     *
     * @mbg.generated
     */
    public Long getCssCar() {
        return cssCar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_car
     *
     * @param cssCar the value for cs_stats.css_car
     *
     * @mbg.generated
     */
    public void setCssCar(Long cssCar) {
        this.cssCar = cssCar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_energy
     *
     * @return the value of cs_stats.css_energy
     *
     * @mbg.generated
     */
    public Double getCssEnergy() {
        return cssEnergy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_energy
     *
     * @param cssEnergy the value for cs_stats.css_energy
     *
     * @mbg.generated
     */
    public void setCssEnergy(Double cssEnergy) {
        this.cssEnergy = cssEnergy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_speed
     *
     * @return the value of cs_stats.css_speed
     *
     * @mbg.generated
     */
    public Double getCssSpeed() {
        return cssSpeed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_speed
     *
     * @param cssSpeed the value for cs_stats.css_speed
     *
     * @mbg.generated
     */
    public void setCssSpeed(Double cssSpeed) {
        this.cssSpeed = cssSpeed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_mileage
     *
     * @return the value of cs_stats.css_mileage
     *
     * @mbg.generated
     */
    public Double getCssMileage() {
        return cssMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_mileage
     *
     * @param cssMileage the value for cs_stats.css_mileage
     *
     * @mbg.generated
     */
    public void setCssMileage(Double cssMileage) {
        this.cssMileage = cssMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_time
     *
     * @return the value of cs_stats.css_time
     *
     * @mbg.generated
     */
    public Double getCssTime() {
        return cssTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_time
     *
     * @param cssTime the value for cs_stats.css_time
     *
     * @mbg.generated
     */
    public void setCssTime(Double cssTime) {
        this.cssTime = cssTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_update_time
     *
     * @return the value of cs_stats.css_update_time
     *
     * @mbg.generated
     */
    public Date getCssUpdateTime() {
        return cssUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_update_time
     *
     * @param cssUpdateTime the value for cs_stats.css_update_time
     *
     * @mbg.generated
     */
    public void setCssUpdateTime(Date cssUpdateTime) {
        this.cssUpdateTime = cssUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_add_time
     *
     * @return the value of cs_stats.css_add_time
     *
     * @mbg.generated
     */
    public Date getCssAddTime() {
        return cssAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_add_time
     *
     * @param cssAddTime the value for cs_stats.css_add_time
     *
     * @mbg.generated
     */
    public void setCssAddTime(Date cssAddTime) {
        this.cssAddTime = cssAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_stats.css_status
     *
     * @return the value of cs_stats.css_status
     *
     * @mbg.generated
     */
    public Short getCssStatus() {
        return cssStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_stats.css_status
     *
     * @param cssStatus the value for cs_stats.css_status
     *
     * @mbg.generated
     */
    public void setCssStatus(Short cssStatus) {
        this.cssStatus = cssStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_stats
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
        CsStats other = (CsStats) that;
        return (this.getCssId() == null ? other.getCssId() == null : this.getCssId().equals(other.getCssId()))
            && (this.getCssDate() == null ? other.getCssDate() == null : this.getCssDate().equals(other.getCssDate()))
            && (this.getCssCar() == null ? other.getCssCar() == null : this.getCssCar().equals(other.getCssCar()))
            && (this.getCssEnergy() == null ? other.getCssEnergy() == null : this.getCssEnergy().equals(other.getCssEnergy()))
            && (this.getCssSpeed() == null ? other.getCssSpeed() == null : this.getCssSpeed().equals(other.getCssSpeed()))
            && (this.getCssMileage() == null ? other.getCssMileage() == null : this.getCssMileage().equals(other.getCssMileage()))
            && (this.getCssTime() == null ? other.getCssTime() == null : this.getCssTime().equals(other.getCssTime()))
            && (this.getCssUpdateTime() == null ? other.getCssUpdateTime() == null : this.getCssUpdateTime().equals(other.getCssUpdateTime()))
            && (this.getCssAddTime() == null ? other.getCssAddTime() == null : this.getCssAddTime().equals(other.getCssAddTime()))
            && (this.getCssStatus() == null ? other.getCssStatus() == null : this.getCssStatus().equals(other.getCssStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_stats
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCssId() == null) ? 0 : getCssId().hashCode());
        result = prime * result + ((getCssDate() == null) ? 0 : getCssDate().hashCode());
        result = prime * result + ((getCssCar() == null) ? 0 : getCssCar().hashCode());
        result = prime * result + ((getCssEnergy() == null) ? 0 : getCssEnergy().hashCode());
        result = prime * result + ((getCssSpeed() == null) ? 0 : getCssSpeed().hashCode());
        result = prime * result + ((getCssMileage() == null) ? 0 : getCssMileage().hashCode());
        result = prime * result + ((getCssTime() == null) ? 0 : getCssTime().hashCode());
        result = prime * result + ((getCssUpdateTime() == null) ? 0 : getCssUpdateTime().hashCode());
        result = prime * result + ((getCssAddTime() == null) ? 0 : getCssAddTime().hashCode());
        result = prime * result + ((getCssStatus() == null) ? 0 : getCssStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_stats
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cssId=").append(cssId);
        sb.append(", cssDate=").append(cssDate);
        sb.append(", cssCar=").append(cssCar);
        sb.append(", cssEnergy=").append(cssEnergy);
        sb.append(", cssSpeed=").append(cssSpeed);
        sb.append(", cssMileage=").append(cssMileage);
        sb.append(", cssTime=").append(cssTime);
        sb.append(", cssUpdateTime=").append(cssUpdateTime);
        sb.append(", cssAddTime=").append(cssAddTime);
        sb.append(", cssStatus=").append(cssStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}