package com.ccclubs.quota.orm.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CsIndexReport implements Serializable {

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.cs_vin
     *
     * @mbg.generated
     */
    private String csVin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.cs_number
     *
     * @mbg.generated
     */
    private String csNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.monthly_avg_mile
     *
     * @mbg.generated
     */
    private BigDecimal monthlyAvgMile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.avg_drive_time_per_day
     *
     * @mbg.generated
     */
    private BigDecimal avgDriveTimePerDay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.power_consume_per_hundred
     *
     * @mbg.generated
     */
    private BigDecimal powerConsumePerHundred;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.electric_range
     *
     * @mbg.generated
     */
    private BigDecimal electricRange;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.max_charge_power
     *
     * @mbg.generated
     */
    private BigDecimal maxChargePower;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.min_charge_time
     *
     * @mbg.generated
     */
    private BigDecimal minChargeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.cumulative_mileage
     *
     * @mbg.generated
     */
    private BigDecimal cumulativeMileage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.cumulative_charge
     *
     * @mbg.generated
     */
    private BigDecimal cumulativeCharge;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_index_report.data_type
     *
     * @mbg.generated
     */
    private Integer dataType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */

    /**
     * 修改时间
     */

    private Date modifyDate;


    private Date facTime;


    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.cs_vin
     *
     * @return the value of cs_index_report.cs_vin
     *
     * @mbg.generated
     */
    public String getCsVin() {
        return csVin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.cs_vin
     *
     * @param csVin the value for cs_index_report.cs_vin
     *
     * @mbg.generated
     */
    public void setCsVin(String csVin) {
        this.csVin = csVin == null ? null : csVin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.cs_number
     *
     * @return the value of cs_index_report.cs_number
     *
     * @mbg.generated
     */
    public String getCsNumber() {
        return csNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.cs_number
     *
     * @param csNumber the value for cs_index_report.cs_number
     *
     * @mbg.generated
     */
    public void setCsNumber(String csNumber) {
        this.csNumber = csNumber == null ? null : csNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.monthly_avg_mile
     *
     * @return the value of cs_index_report.monthly_avg_mile
     *
     * @mbg.generated
     */
    public BigDecimal getMonthlyAvgMile() {
        return monthlyAvgMile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.monthly_avg_mile
     *
     * @param monthlyAvgMile the value for cs_index_report.monthly_avg_mile
     *
     * @mbg.generated
     */
    public void setMonthlyAvgMile(BigDecimal monthlyAvgMile) {
        this.monthlyAvgMile = monthlyAvgMile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.avg_drive_time_per_day
     *
     * @return the value of cs_index_report.avg_drive_time_per_day
     *
     * @mbg.generated
     */
    public BigDecimal getAvgDriveTimePerDay() {
        return avgDriveTimePerDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.avg_drive_time_per_day
     *
     * @param avgDriveTimePerDay the value for cs_index_report.avg_drive_time_per_day
     *
     * @mbg.generated
     */
    public void setAvgDriveTimePerDay(BigDecimal avgDriveTimePerDay) {
        this.avgDriveTimePerDay = avgDriveTimePerDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.power_consume_per_hundred
     *
     * @return the value of cs_index_report.power_consume_per_hundred
     *
     * @mbg.generated
     */
    public BigDecimal getPowerConsumePerHundred() {
        return powerConsumePerHundred;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.power_consume_per_hundred
     *
     * @param powerConsumePerHundred the value for cs_index_report.power_consume_per_hundred
     *
     * @mbg.generated
     */
    public void setPowerConsumePerHundred(BigDecimal powerConsumePerHundred) {
        this.powerConsumePerHundred = powerConsumePerHundred;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.electric_range
     *
     * @return the value of cs_index_report.electric_range
     *
     * @mbg.generated
     */
    public BigDecimal getElectricRange() {
        return electricRange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.electric_range
     *
     * @param electricRange the value for cs_index_report.electric_range
     *
     * @mbg.generated
     */
    public void setElectricRange(BigDecimal electricRange) {
        this.electricRange = electricRange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.max_charge_power
     *
     * @return the value of cs_index_report.max_charge_power
     *
     * @mbg.generated
     */
    public BigDecimal getMaxChargePower() {
        return maxChargePower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.max_charge_power
     *
     * @param maxChargePower the value for cs_index_report.max_charge_power
     *
     * @mbg.generated
     */
    public void setMaxChargePower(BigDecimal maxChargePower) {
        this.maxChargePower = maxChargePower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.min_charge_time
     *
     * @return the value of cs_index_report.min_charge_time
     *
     * @mbg.generated
     */
    public BigDecimal getMinChargeTime() {
        return minChargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.min_charge_time
     *
     * @param minChargeTime the value for cs_index_report.min_charge_time
     *
     * @mbg.generated
     */
    public void setMinChargeTime(BigDecimal minChargeTime) {
        this.minChargeTime = minChargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.cumulative_mileage
     *
     * @return the value of cs_index_report.cumulative_mileage
     *
     * @mbg.generated
     */
    public BigDecimal getCumulativeMileage() {
        return cumulativeMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.cumulative_mileage
     *
     * @param cumulativeMileage the value for cs_index_report.cumulative_mileage
     *
     * @mbg.generated
     */
    public void setCumulativeMileage(BigDecimal cumulativeMileage) {
        this.cumulativeMileage = cumulativeMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.cumulative_charge
     *
     * @return the value of cs_index_report.cumulative_charge
     *
     * @mbg.generated
     */
    public BigDecimal getCumulativeCharge() {
        return cumulativeCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.cumulative_charge
     *
     * @param cumulativeCharge the value for cs_index_report.cumulative_charge
     *
     * @mbg.generated
     */
    public void setCumulativeCharge(BigDecimal cumulativeCharge) {
        this.cumulativeCharge = cumulativeCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_index_report.data_type
     *
     * @return the value of cs_index_report.data_type
     *
     * @mbg.generated
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_index_report.data_type
     *
     * @param dataType the value for cs_index_report.data_type
     *
     * @mbg.generated
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getFacTime() {
        return facTime;
    }

    public void setFacTime(Date facTime) {
        this.facTime = facTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
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
        CsIndexReport other = (CsIndexReport) that;
        return (this.getCsVin() == null ? other.getCsVin() == null : this.getCsVin().equals(other.getCsVin()))
            && (this.getCsNumber() == null ? other.getCsNumber() == null : this.getCsNumber().equals(other.getCsNumber()))
            && (this.getMonthlyAvgMile() == null ? other.getMonthlyAvgMile() == null : this.getMonthlyAvgMile().equals(other.getMonthlyAvgMile()))
            && (this.getAvgDriveTimePerDay() == null ? other.getAvgDriveTimePerDay() == null : this.getAvgDriveTimePerDay().equals(other.getAvgDriveTimePerDay()))
            && (this.getPowerConsumePerHundred() == null ? other.getPowerConsumePerHundred() == null : this.getPowerConsumePerHundred().equals(other.getPowerConsumePerHundred()))
            && (this.getElectricRange() == null ? other.getElectricRange() == null : this.getElectricRange().equals(other.getElectricRange()))
            && (this.getMaxChargePower() == null ? other.getMaxChargePower() == null : this.getMaxChargePower().equals(other.getMaxChargePower()))
            && (this.getMinChargeTime() == null ? other.getMinChargeTime() == null : this.getMinChargeTime().equals(other.getMinChargeTime()))
            && (this.getCumulativeMileage() == null ? other.getCumulativeMileage() == null : this.getCumulativeMileage().equals(other.getCumulativeMileage()))
            && (this.getCumulativeCharge() == null ? other.getCumulativeCharge() == null : this.getCumulativeCharge().equals(other.getCumulativeCharge()))
            && (this.getDataType() == null ? other.getDataType() == null : this.getDataType().equals(other.getDataType()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCsVin() == null) ? 0 : getCsVin().hashCode());
        result = prime * result + ((getCsNumber() == null) ? 0 : getCsNumber().hashCode());
        result = prime * result + ((getMonthlyAvgMile() == null) ? 0 : getMonthlyAvgMile().hashCode());
        result = prime * result + ((getAvgDriveTimePerDay() == null) ? 0 : getAvgDriveTimePerDay().hashCode());
        result = prime * result + ((getPowerConsumePerHundred() == null) ? 0 : getPowerConsumePerHundred().hashCode());
        result = prime * result + ((getElectricRange() == null) ? 0 : getElectricRange().hashCode());
        result = prime * result + ((getMaxChargePower() == null) ? 0 : getMaxChargePower().hashCode());
        result = prime * result + ((getMinChargeTime() == null) ? 0 : getMinChargeTime().hashCode());
        result = prime * result + ((getCumulativeMileage() == null) ? 0 : getCumulativeMileage().hashCode());
        result = prime * result + ((getCumulativeCharge() == null) ? 0 : getCumulativeCharge().hashCode());
        result = prime * result + ((getDataType() == null) ? 0 : getDataType().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
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
        sb.append(", monthlyAvgMile=").append(monthlyAvgMile);
        sb.append(", avgDriveTimePerDay=").append(avgDriveTimePerDay);
        sb.append(", powerConsumePerHundred=").append(powerConsumePerHundred);
        sb.append(", electricRange=").append(electricRange);
        sb.append(", maxChargePower=").append(maxChargePower);
        sb.append(", minChargeTime=").append(minChargeTime);
        sb.append(", cumulativeMileage=").append(cumulativeMileage);
        sb.append(", cumulativeCharge=").append(cumulativeCharge);
        sb.append(", dataType=").append(dataType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}