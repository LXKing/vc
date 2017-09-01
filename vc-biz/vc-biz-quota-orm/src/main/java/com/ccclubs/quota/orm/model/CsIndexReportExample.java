package com.ccclubs.quota.orm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsIndexReportExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public CsIndexReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCsVinIsNull() {
            addCriterion("cs_vin is null");
            return (Criteria) this;
        }

        public Criteria andCsVinIsNotNull() {
            addCriterion("cs_vin is not null");
            return (Criteria) this;
        }

        public Criteria andCsVinEqualTo(String value) {
            addCriterion("cs_vin =", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotEqualTo(String value) {
            addCriterion("cs_vin <>", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinGreaterThan(String value) {
            addCriterion("cs_vin >", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinGreaterThanOrEqualTo(String value) {
            addCriterion("cs_vin >=", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinLessThan(String value) {
            addCriterion("cs_vin <", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinLessThanOrEqualTo(String value) {
            addCriterion("cs_vin <=", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinLike(String value) {
            addCriterion("cs_vin like", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotLike(String value) {
            addCriterion("cs_vin not like", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinIn(List<String> values) {
            addCriterion("cs_vin in", values, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotIn(List<String> values) {
            addCriterion("cs_vin not in", values, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinBetween(String value1, String value2) {
            addCriterion("cs_vin between", value1, value2, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotBetween(String value1, String value2) {
            addCriterion("cs_vin not between", value1, value2, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsNumberIsNull() {
            addCriterion("cs_number is null");
            return (Criteria) this;
        }

        public Criteria andCsNumberIsNotNull() {
            addCriterion("cs_number is not null");
            return (Criteria) this;
        }

        public Criteria andCsNumberEqualTo(String value) {
            addCriterion("cs_number =", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotEqualTo(String value) {
            addCriterion("cs_number <>", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberGreaterThan(String value) {
            addCriterion("cs_number >", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("cs_number >=", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberLessThan(String value) {
            addCriterion("cs_number <", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberLessThanOrEqualTo(String value) {
            addCriterion("cs_number <=", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberLike(String value) {
            addCriterion("cs_number like", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotLike(String value) {
            addCriterion("cs_number not like", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberIn(List<String> values) {
            addCriterion("cs_number in", values, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotIn(List<String> values) {
            addCriterion("cs_number not in", values, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberBetween(String value1, String value2) {
            addCriterion("cs_number between", value1, value2, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotBetween(String value1, String value2) {
            addCriterion("cs_number not between", value1, value2, "csNumber");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileIsNull() {
            addCriterion("monthly_avg_mile is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileIsNotNull() {
            addCriterion("monthly_avg_mile is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileEqualTo(BigDecimal value) {
            addCriterion("monthly_avg_mile =", value, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileNotEqualTo(BigDecimal value) {
            addCriterion("monthly_avg_mile <>", value, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileGreaterThan(BigDecimal value) {
            addCriterion("monthly_avg_mile >", value, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_avg_mile >=", value, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileLessThan(BigDecimal value) {
            addCriterion("monthly_avg_mile <", value, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_avg_mile <=", value, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileIn(List<BigDecimal> values) {
            addCriterion("monthly_avg_mile in", values, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileNotIn(List<BigDecimal> values) {
            addCriterion("monthly_avg_mile not in", values, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_avg_mile between", value1, value2, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andMonthlyAvgMileNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_avg_mile not between", value1, value2, "monthlyAvgMile");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayIsNull() {
            addCriterion("avg_drive_time_per_day is null");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayIsNotNull() {
            addCriterion("avg_drive_time_per_day is not null");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayEqualTo(BigDecimal value) {
            addCriterion("avg_drive_time_per_day =", value, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayNotEqualTo(BigDecimal value) {
            addCriterion("avg_drive_time_per_day <>", value, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayGreaterThan(BigDecimal value) {
            addCriterion("avg_drive_time_per_day >", value, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_drive_time_per_day >=", value, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayLessThan(BigDecimal value) {
            addCriterion("avg_drive_time_per_day <", value, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_drive_time_per_day <=", value, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayIn(List<BigDecimal> values) {
            addCriterion("avg_drive_time_per_day in", values, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayNotIn(List<BigDecimal> values) {
            addCriterion("avg_drive_time_per_day not in", values, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_drive_time_per_day between", value1, value2, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andAvgDriveTimePerDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_drive_time_per_day not between", value1, value2, "avgDriveTimePerDay");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredIsNull() {
            addCriterion("power_consume_per_hundred is null");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredIsNotNull() {
            addCriterion("power_consume_per_hundred is not null");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredEqualTo(BigDecimal value) {
            addCriterion("power_consume_per_hundred =", value, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredNotEqualTo(BigDecimal value) {
            addCriterion("power_consume_per_hundred <>", value, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredGreaterThan(BigDecimal value) {
            addCriterion("power_consume_per_hundred >", value, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("power_consume_per_hundred >=", value, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredLessThan(BigDecimal value) {
            addCriterion("power_consume_per_hundred <", value, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredLessThanOrEqualTo(BigDecimal value) {
            addCriterion("power_consume_per_hundred <=", value, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredIn(List<BigDecimal> values) {
            addCriterion("power_consume_per_hundred in", values, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredNotIn(List<BigDecimal> values) {
            addCriterion("power_consume_per_hundred not in", values, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("power_consume_per_hundred between", value1, value2, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andPowerConsumePerHundredNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("power_consume_per_hundred not between", value1, value2, "powerConsumePerHundred");
            return (Criteria) this;
        }

        public Criteria andElectricRangeIsNull() {
            addCriterion("electric_range is null");
            return (Criteria) this;
        }

        public Criteria andElectricRangeIsNotNull() {
            addCriterion("electric_range is not null");
            return (Criteria) this;
        }

        public Criteria andElectricRangeEqualTo(BigDecimal value) {
            addCriterion("electric_range =", value, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeNotEqualTo(BigDecimal value) {
            addCriterion("electric_range <>", value, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeGreaterThan(BigDecimal value) {
            addCriterion("electric_range >", value, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("electric_range >=", value, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeLessThan(BigDecimal value) {
            addCriterion("electric_range <", value, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("electric_range <=", value, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeIn(List<BigDecimal> values) {
            addCriterion("electric_range in", values, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeNotIn(List<BigDecimal> values) {
            addCriterion("electric_range not in", values, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electric_range between", value1, value2, "electricRange");
            return (Criteria) this;
        }

        public Criteria andElectricRangeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electric_range not between", value1, value2, "electricRange");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerIsNull() {
            addCriterion("max_charge_power is null");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerIsNotNull() {
            addCriterion("max_charge_power is not null");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerEqualTo(BigDecimal value) {
            addCriterion("max_charge_power =", value, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerNotEqualTo(BigDecimal value) {
            addCriterion("max_charge_power <>", value, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerGreaterThan(BigDecimal value) {
            addCriterion("max_charge_power >", value, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_charge_power >=", value, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerLessThan(BigDecimal value) {
            addCriterion("max_charge_power <", value, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_charge_power <=", value, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerIn(List<BigDecimal> values) {
            addCriterion("max_charge_power in", values, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerNotIn(List<BigDecimal> values) {
            addCriterion("max_charge_power not in", values, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_charge_power between", value1, value2, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMaxChargePowerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_charge_power not between", value1, value2, "maxChargePower");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeIsNull() {
            addCriterion("min_charge_time is null");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeIsNotNull() {
            addCriterion("min_charge_time is not null");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeEqualTo(BigDecimal value) {
            addCriterion("min_charge_time =", value, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeNotEqualTo(BigDecimal value) {
            addCriterion("min_charge_time <>", value, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeGreaterThan(BigDecimal value) {
            addCriterion("min_charge_time >", value, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_charge_time >=", value, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeLessThan(BigDecimal value) {
            addCriterion("min_charge_time <", value, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_charge_time <=", value, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeIn(List<BigDecimal> values) {
            addCriterion("min_charge_time in", values, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeNotIn(List<BigDecimal> values) {
            addCriterion("min_charge_time not in", values, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_charge_time between", value1, value2, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andMinChargeTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_charge_time not between", value1, value2, "minChargeTime");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageIsNull() {
            addCriterion("cumulative_mileage is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageIsNotNull() {
            addCriterion("cumulative_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageEqualTo(BigDecimal value) {
            addCriterion("cumulative_mileage =", value, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageNotEqualTo(BigDecimal value) {
            addCriterion("cumulative_mileage <>", value, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageGreaterThan(BigDecimal value) {
            addCriterion("cumulative_mileage >", value, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cumulative_mileage >=", value, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageLessThan(BigDecimal value) {
            addCriterion("cumulative_mileage <", value, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cumulative_mileage <=", value, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageIn(List<BigDecimal> values) {
            addCriterion("cumulative_mileage in", values, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageNotIn(List<BigDecimal> values) {
            addCriterion("cumulative_mileage not in", values, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cumulative_mileage between", value1, value2, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeMileageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cumulative_mileage not between", value1, value2, "cumulativeMileage");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeIsNull() {
            addCriterion("cumulative_charge is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeIsNotNull() {
            addCriterion("cumulative_charge is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeEqualTo(BigDecimal value) {
            addCriterion("cumulative_charge =", value, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeNotEqualTo(BigDecimal value) {
            addCriterion("cumulative_charge <>", value, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeGreaterThan(BigDecimal value) {
            addCriterion("cumulative_charge >", value, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cumulative_charge >=", value, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeLessThan(BigDecimal value) {
            addCriterion("cumulative_charge <", value, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cumulative_charge <=", value, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeIn(List<BigDecimal> values) {
            addCriterion("cumulative_charge in", values, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeNotIn(List<BigDecimal> values) {
            addCriterion("cumulative_charge not in", values, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cumulative_charge between", value1, value2, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andCumulativeChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cumulative_charge not between", value1, value2, "cumulativeCharge");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(Integer value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(Integer value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(Integer value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(Integer value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(Integer value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<Integer> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<Integer> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(Integer value1, Integer value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cs_index_report
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}