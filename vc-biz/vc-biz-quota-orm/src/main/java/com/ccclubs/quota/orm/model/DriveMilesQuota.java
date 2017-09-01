package com.ccclubs.quota.orm.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DriveMilesQuota implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drive_miles_quota.cs_vin
     *
     * @mbg.generated
     */
    private String csVin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drive_miles_quota.cs_number
     *
     * @mbg.generated
     */
    private String csNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drive_miles_quota.serial_no
     *
     * @mbg.generated
     */
    private Long serialNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drive_miles_quota.monthly_avg_mile
     *
     * @mbg.generated
     */
    private BigDecimal monthlyAvgMile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drive_miles_quota.avg_drive_time_per_day
     *
     * @mbg.generated
     */
    private BigDecimal avgDriveTimePerDay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drive_miles_quota.power_consume_per_hundred
     *
     * @mbg.generated
     */
    private BigDecimal powerConsumePerHundred;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drive_miles_quota.cumulative_mileage
     *
     * @mbg.generated
     */
    private BigDecimal cumulativeMileage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table drive_miles_quota
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drive_miles_quota.cs_vin
     *
     * @return the value of drive_miles_quota.cs_vin
     *
     * @mbg.generated
     */
    public String getCsVin() {
        return csVin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drive_miles_quota.cs_vin
     *
     * @param csVin the value for drive_miles_quota.cs_vin
     *
     * @mbg.generated
     */
    public void setCsVin(String csVin) {
        this.csVin = csVin == null ? null : csVin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drive_miles_quota.cs_number
     *
     * @return the value of drive_miles_quota.cs_number
     *
     * @mbg.generated
     */
    public String getCsNumber() {
        return csNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drive_miles_quota.cs_number
     *
     * @param csNumber the value for drive_miles_quota.cs_number
     *
     * @mbg.generated
     */
    public void setCsNumber(String csNumber) {
        this.csNumber = csNumber == null ? null : csNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drive_miles_quota.serial_no
     *
     * @return the value of drive_miles_quota.serial_no
     *
     * @mbg.generated
     */
    public Long getSerialNo() {
        return serialNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drive_miles_quota.serial_no
     *
     * @param serialNo the value for drive_miles_quota.serial_no
     *
     * @mbg.generated
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drive_miles_quota.monthly_avg_mile
     *
     * @return the value of drive_miles_quota.monthly_avg_mile
     *
     * @mbg.generated
     */
    public BigDecimal getMonthlyAvgMile() {
        return monthlyAvgMile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drive_miles_quota.monthly_avg_mile
     *
     * @param monthlyAvgMile the value for drive_miles_quota.monthly_avg_mile
     *
     * @mbg.generated
     */
    public void setMonthlyAvgMile(BigDecimal monthlyAvgMile) {
        this.monthlyAvgMile = monthlyAvgMile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drive_miles_quota.avg_drive_time_per_day
     *
     * @return the value of drive_miles_quota.avg_drive_time_per_day
     *
     * @mbg.generated
     */
    public BigDecimal getAvgDriveTimePerDay() {
        return avgDriveTimePerDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drive_miles_quota.avg_drive_time_per_day
     *
     * @param avgDriveTimePerDay the value for drive_miles_quota.avg_drive_time_per_day
     *
     * @mbg.generated
     */
    public void setAvgDriveTimePerDay(BigDecimal avgDriveTimePerDay) {
        this.avgDriveTimePerDay = avgDriveTimePerDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drive_miles_quota.power_consume_per_hundred
     *
     * @return the value of drive_miles_quota.power_consume_per_hundred
     *
     * @mbg.generated
     */
    public BigDecimal getPowerConsumePerHundred() {
        return powerConsumePerHundred;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drive_miles_quota.power_consume_per_hundred
     *
     * @param powerConsumePerHundred the value for drive_miles_quota.power_consume_per_hundred
     *
     * @mbg.generated
     */
    public void setPowerConsumePerHundred(BigDecimal powerConsumePerHundred) {
        this.powerConsumePerHundred = powerConsumePerHundred;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drive_miles_quota.cumulative_mileage
     *
     * @return the value of drive_miles_quota.cumulative_mileage
     *
     * @mbg.generated
     */
    public BigDecimal getCumulativeMileage() {
        return cumulativeMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drive_miles_quota.cumulative_mileage
     *
     * @param cumulativeMileage the value for drive_miles_quota.cumulative_mileage
     *
     * @mbg.generated
     */
    public void setCumulativeMileage(BigDecimal cumulativeMileage) {
        this.cumulativeMileage = cumulativeMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_quota
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
        DriveMilesQuota other = (DriveMilesQuota) that;
        return (this.getCsVin() == null ? other.getCsVin() == null : this.getCsVin().equals(other.getCsVin()))
            && (this.getCsNumber() == null ? other.getCsNumber() == null : this.getCsNumber().equals(other.getCsNumber()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getMonthlyAvgMile() == null ? other.getMonthlyAvgMile() == null : this.getMonthlyAvgMile().equals(other.getMonthlyAvgMile()))
            && (this.getAvgDriveTimePerDay() == null ? other.getAvgDriveTimePerDay() == null : this.getAvgDriveTimePerDay().equals(other.getAvgDriveTimePerDay()))
            && (this.getPowerConsumePerHundred() == null ? other.getPowerConsumePerHundred() == null : this.getPowerConsumePerHundred().equals(other.getPowerConsumePerHundred()))
            && (this.getCumulativeMileage() == null ? other.getCumulativeMileage() == null : this.getCumulativeMileage().equals(other.getCumulativeMileage()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_quota
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCsVin() == null) ? 0 : getCsVin().hashCode());
        result = prime * result + ((getCsNumber() == null) ? 0 : getCsNumber().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getMonthlyAvgMile() == null) ? 0 : getMonthlyAvgMile().hashCode());
        result = prime * result + ((getAvgDriveTimePerDay() == null) ? 0 : getAvgDriveTimePerDay().hashCode());
        result = prime * result + ((getPowerConsumePerHundred() == null) ? 0 : getPowerConsumePerHundred().hashCode());
        result = prime * result + ((getCumulativeMileage() == null) ? 0 : getCumulativeMileage().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_quota
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", csVin=").append(csVin);
        sb.append(", csNumber=").append(csNumber);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", monthlyAvgMile=").append(monthlyAvgMile);
        sb.append(", avgDriveTimePerDay=").append(avgDriveTimePerDay);
        sb.append(", powerConsumePerHundred=").append(powerConsumePerHundred);
        sb.append(", cumulativeMileage=").append(cumulativeMileage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}