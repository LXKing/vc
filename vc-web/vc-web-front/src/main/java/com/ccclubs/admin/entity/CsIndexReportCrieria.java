package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 指标统计数据查询条件对象
 * @author Joel
 */
public class CsIndexReportCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsIndexReportCrieria() {
	    oredCriteria = new ArrayList<Criteria>();
	 }
	 
	 public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
	 }
	 
	 public String getOrderByClause() {
        return orderByClause;
     }
	 
	 public void setDistinct(boolean distinct) {
        this.distinct = distinct;
     }
	 
	 public boolean isDistinct() {
        return distinct;
     }
	 
	 public List<Criteria> getOredCriteria() {
        return oredCriteria;
     }
	 
	 public void or(Criteria criteria) {
        oredCriteria.add(criteria);
     }
	 
	 public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
     }
	 
	 public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
     }
	 
	 protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
     }
	 
	 public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
     }
	 
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

	        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
	            if (value == null) {
	                throw new RuntimeException("Value for " + property + " cannot be null");
	            }
	            addCriterion(condition, new java.sql.Date(value.getTime()), property);
	        }

	        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
	            if (values == null || values.size() == 0) {
	                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
	            }
	            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
	            Iterator<Date> iter = values.iterator();
	            while (iter.hasNext()) {
	                dateList.add(new java.sql.Date(iter.next().getTime()));
	            }
	            addCriterion(condition, dateList, property);
	        }

	        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
	            if (value1 == null || value2 == null) {
	                throw new RuntimeException("Between values for " + property + " cannot be null");
	            }
	            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
	        }
	        public Criteria andidIsNull() {
	            addCriterion("id is null");
	            return (Criteria) this;
	        }

	        public Criteria andidIsNotNull() {
	            addCriterion("id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andidEqualTo(Long value) {
	            addCriterion("id =", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidNotEqualTo(Long value) {
	            addCriterion("id <>", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidGreaterThan(Long value) {
	            addCriterion("id >", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidGreaterThanOrEqualTo(Long value) {
	            addCriterion("id >=", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidLessThan(Long value) {
	            addCriterion("id <", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidLessThanOrEqualTo(Long value) {
	            addCriterion("id <=", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidIn(List<Long> values) {
	            addCriterion("id in", values, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidNotIn(List<Long> values) {
	            addCriterion("id not in", values, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidBetween(Long value1, Long value2) {
	            addCriterion("id between", value1, value2, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidNotBetween(Long value1, Long value2) {
	            addCriterion("id not between", value1, value2, "id");
	            return (Criteria) this;
	        }
	        public Criteria andcsVinIsNull() {
	            addCriterion("cs_vin is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinIsNotNull() {
	            addCriterion("cs_vin is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsVinLike(String value) {
	            addCriterion("cs_vin like", "%"+value+"%", "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinNotLike(String value) {
	            addCriterion("cs_vin not like", "%"+value+"%", "csVin");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsVinEqualTo(String value) {
	            addCriterion("cs_vin =", value, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinNotEqualTo(String value) {
	            addCriterion("cs_vin <>", value, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinGreaterThan(String value) {
	            addCriterion("cs_vin >", value, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinGreaterThanOrEqualTo(String value) {
	            addCriterion("cs_vin >=", value, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinLessThan(String value) {
	            addCriterion("cs_vin <", value, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinLessThanOrEqualTo(String value) {
	            addCriterion("cs_vin <=", value, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinIn(List<String> values) {
	            addCriterion("cs_vin in", values, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinNotIn(List<String> values) {
	            addCriterion("cs_vin not in", values, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinBetween(String value1, String value2) {
	            addCriterion("cs_vin between", value1, value2, "csVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsVinNotBetween(String value1, String value2) {
	            addCriterion("cs_vin not between", value1, value2, "csVin");
	            return (Criteria) this;
	        }
	        public Criteria andcsNumberIsNull() {
	            addCriterion("cs_number is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberIsNotNull() {
	            addCriterion("cs_number is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsNumberLike(String value) {
	            addCriterion("cs_number like", "%"+value+"%", "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberNotLike(String value) {
	            addCriterion("cs_number not like", "%"+value+"%", "csNumber");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsNumberEqualTo(String value) {
	            addCriterion("cs_number =", value, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberNotEqualTo(String value) {
	            addCriterion("cs_number <>", value, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberGreaterThan(String value) {
	            addCriterion("cs_number >", value, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberGreaterThanOrEqualTo(String value) {
	            addCriterion("cs_number >=", value, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberLessThan(String value) {
	            addCriterion("cs_number <", value, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberLessThanOrEqualTo(String value) {
	            addCriterion("cs_number <=", value, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberIn(List<String> values) {
	            addCriterion("cs_number in", values, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberNotIn(List<String> values) {
	            addCriterion("cs_number not in", values, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberBetween(String value1, String value2) {
	            addCriterion("cs_number between", value1, value2, "csNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsNumberNotBetween(String value1, String value2) {
	            addCriterion("cs_number not between", value1, value2, "csNumber");
	            return (Criteria) this;
	        }
	        public Criteria andmonthlyAvgMileIsNull() {
	            addCriterion("monthly_avg_mile is null");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileIsNotNull() {
	            addCriterion("monthly_avg_mile is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andmonthlyAvgMileEqualTo(Double value) {
	            addCriterion("monthly_avg_mile =", value, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileNotEqualTo(Double value) {
	            addCriterion("monthly_avg_mile <>", value, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileGreaterThan(Double value) {
	            addCriterion("monthly_avg_mile >", value, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileGreaterThanOrEqualTo(Double value) {
	            addCriterion("monthly_avg_mile >=", value, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileLessThan(Double value) {
	            addCriterion("monthly_avg_mile <", value, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileLessThanOrEqualTo(Double value) {
	            addCriterion("monthly_avg_mile <=", value, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileIn(List<Double> values) {
	            addCriterion("monthly_avg_mile in", values, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileNotIn(List<Double> values) {
	            addCriterion("monthly_avg_mile not in", values, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileBetween(Double value1, Double value2) {
	            addCriterion("monthly_avg_mile between", value1, value2, "monthlyAvgMile");
	            return (Criteria) this;
	        }

	        public Criteria andmonthlyAvgMileNotBetween(Double value1, Double value2) {
	            addCriterion("monthly_avg_mile not between", value1, value2, "monthlyAvgMile");
	            return (Criteria) this;
	        }
	        public Criteria andavgDriveTimePerDayIsNull() {
	            addCriterion("avg_drive_time_per_day is null");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayIsNotNull() {
	            addCriterion("avg_drive_time_per_day is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andavgDriveTimePerDayEqualTo(Double value) {
	            addCriterion("avg_drive_time_per_day =", value, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayNotEqualTo(Double value) {
	            addCriterion("avg_drive_time_per_day <>", value, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayGreaterThan(Double value) {
	            addCriterion("avg_drive_time_per_day >", value, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayGreaterThanOrEqualTo(Double value) {
	            addCriterion("avg_drive_time_per_day >=", value, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayLessThan(Double value) {
	            addCriterion("avg_drive_time_per_day <", value, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayLessThanOrEqualTo(Double value) {
	            addCriterion("avg_drive_time_per_day <=", value, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayIn(List<Double> values) {
	            addCriterion("avg_drive_time_per_day in", values, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayNotIn(List<Double> values) {
	            addCriterion("avg_drive_time_per_day not in", values, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayBetween(Double value1, Double value2) {
	            addCriterion("avg_drive_time_per_day between", value1, value2, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }

	        public Criteria andavgDriveTimePerDayNotBetween(Double value1, Double value2) {
	            addCriterion("avg_drive_time_per_day not between", value1, value2, "avgDriveTimePerDay");
	            return (Criteria) this;
	        }
	        public Criteria andpowerConsumePerHundredIsNull() {
	            addCriterion("power_consume_per_hundred is null");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredIsNotNull() {
	            addCriterion("power_consume_per_hundred is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andpowerConsumePerHundredEqualTo(Double value) {
	            addCriterion("power_consume_per_hundred =", value, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredNotEqualTo(Double value) {
	            addCriterion("power_consume_per_hundred <>", value, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredGreaterThan(Double value) {
	            addCriterion("power_consume_per_hundred >", value, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredGreaterThanOrEqualTo(Double value) {
	            addCriterion("power_consume_per_hundred >=", value, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredLessThan(Double value) {
	            addCriterion("power_consume_per_hundred <", value, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredLessThanOrEqualTo(Double value) {
	            addCriterion("power_consume_per_hundred <=", value, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredIn(List<Double> values) {
	            addCriterion("power_consume_per_hundred in", values, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredNotIn(List<Double> values) {
	            addCriterion("power_consume_per_hundred not in", values, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredBetween(Double value1, Double value2) {
	            addCriterion("power_consume_per_hundred between", value1, value2, "powerConsumePerHundred");
	            return (Criteria) this;
	        }

	        public Criteria andpowerConsumePerHundredNotBetween(Double value1, Double value2) {
	            addCriterion("power_consume_per_hundred not between", value1, value2, "powerConsumePerHundred");
	            return (Criteria) this;
	        }
	        public Criteria andelectricRangeIsNull() {
	            addCriterion("electric_range is null");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeIsNotNull() {
	            addCriterion("electric_range is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andelectricRangeEqualTo(Double value) {
	            addCriterion("electric_range =", value, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeNotEqualTo(Double value) {
	            addCriterion("electric_range <>", value, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeGreaterThan(Double value) {
	            addCriterion("electric_range >", value, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeGreaterThanOrEqualTo(Double value) {
	            addCriterion("electric_range >=", value, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeLessThan(Double value) {
	            addCriterion("electric_range <", value, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeLessThanOrEqualTo(Double value) {
	            addCriterion("electric_range <=", value, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeIn(List<Double> values) {
	            addCriterion("electric_range in", values, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeNotIn(List<Double> values) {
	            addCriterion("electric_range not in", values, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeBetween(Double value1, Double value2) {
	            addCriterion("electric_range between", value1, value2, "electricRange");
	            return (Criteria) this;
	        }

	        public Criteria andelectricRangeNotBetween(Double value1, Double value2) {
	            addCriterion("electric_range not between", value1, value2, "electricRange");
	            return (Criteria) this;
	        }
	        public Criteria andmaxChargePowerIsNull() {
	            addCriterion("max_charge_power is null");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerIsNotNull() {
	            addCriterion("max_charge_power is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andmaxChargePowerEqualTo(Double value) {
	            addCriterion("max_charge_power =", value, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerNotEqualTo(Double value) {
	            addCriterion("max_charge_power <>", value, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerGreaterThan(Double value) {
	            addCriterion("max_charge_power >", value, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerGreaterThanOrEqualTo(Double value) {
	            addCriterion("max_charge_power >=", value, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerLessThan(Double value) {
	            addCriterion("max_charge_power <", value, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerLessThanOrEqualTo(Double value) {
	            addCriterion("max_charge_power <=", value, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerIn(List<Double> values) {
	            addCriterion("max_charge_power in", values, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerNotIn(List<Double> values) {
	            addCriterion("max_charge_power not in", values, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerBetween(Double value1, Double value2) {
	            addCriterion("max_charge_power between", value1, value2, "maxChargePower");
	            return (Criteria) this;
	        }

	        public Criteria andmaxChargePowerNotBetween(Double value1, Double value2) {
	            addCriterion("max_charge_power not between", value1, value2, "maxChargePower");
	            return (Criteria) this;
	        }
	        public Criteria andminChargeTimeIsNull() {
	            addCriterion("min_charge_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeIsNotNull() {
	            addCriterion("min_charge_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andminChargeTimeEqualTo(Double value) {
	            addCriterion("min_charge_time =", value, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeNotEqualTo(Double value) {
	            addCriterion("min_charge_time <>", value, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeGreaterThan(Double value) {
	            addCriterion("min_charge_time >", value, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeGreaterThanOrEqualTo(Double value) {
	            addCriterion("min_charge_time >=", value, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeLessThan(Double value) {
	            addCriterion("min_charge_time <", value, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeLessThanOrEqualTo(Double value) {
	            addCriterion("min_charge_time <=", value, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeIn(List<Double> values) {
	            addCriterion("min_charge_time in", values, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeNotIn(List<Double> values) {
	            addCriterion("min_charge_time not in", values, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeBetween(Double value1, Double value2) {
	            addCriterion("min_charge_time between", value1, value2, "minChargeTime");
	            return (Criteria) this;
	        }

	        public Criteria andminChargeTimeNotBetween(Double value1, Double value2) {
	            addCriterion("min_charge_time not between", value1, value2, "minChargeTime");
	            return (Criteria) this;
	        }
	        public Criteria andcumulativeMileageIsNull() {
	            addCriterion("cumulative_mileage is null");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageIsNotNull() {
	            addCriterion("cumulative_mileage is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcumulativeMileageEqualTo(Double value) {
	            addCriterion("cumulative_mileage =", value, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageNotEqualTo(Double value) {
	            addCriterion("cumulative_mileage <>", value, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageGreaterThan(Double value) {
	            addCriterion("cumulative_mileage >", value, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageGreaterThanOrEqualTo(Double value) {
	            addCriterion("cumulative_mileage >=", value, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageLessThan(Double value) {
	            addCriterion("cumulative_mileage <", value, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageLessThanOrEqualTo(Double value) {
	            addCriterion("cumulative_mileage <=", value, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageIn(List<Double> values) {
	            addCriterion("cumulative_mileage in", values, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageNotIn(List<Double> values) {
	            addCriterion("cumulative_mileage not in", values, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageBetween(Double value1, Double value2) {
	            addCriterion("cumulative_mileage between", value1, value2, "cumulativeMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeMileageNotBetween(Double value1, Double value2) {
	            addCriterion("cumulative_mileage not between", value1, value2, "cumulativeMileage");
	            return (Criteria) this;
	        }
	        public Criteria andcumulativeChargeIsNull() {
	            addCriterion("cumulative_charge is null");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeIsNotNull() {
	            addCriterion("cumulative_charge is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcumulativeChargeEqualTo(Double value) {
	            addCriterion("cumulative_charge =", value, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeNotEqualTo(Double value) {
	            addCriterion("cumulative_charge <>", value, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeGreaterThan(Double value) {
	            addCriterion("cumulative_charge >", value, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeGreaterThanOrEqualTo(Double value) {
	            addCriterion("cumulative_charge >=", value, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeLessThan(Double value) {
	            addCriterion("cumulative_charge <", value, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeLessThanOrEqualTo(Double value) {
	            addCriterion("cumulative_charge <=", value, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeIn(List<Double> values) {
	            addCriterion("cumulative_charge in", values, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeNotIn(List<Double> values) {
	            addCriterion("cumulative_charge not in", values, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeBetween(Double value1, Double value2) {
	            addCriterion("cumulative_charge between", value1, value2, "cumulativeCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcumulativeChargeNotBetween(Double value1, Double value2) {
	            addCriterion("cumulative_charge not between", value1, value2, "cumulativeCharge");
	            return (Criteria) this;
	        }
	        public Criteria anddataTypeIsNull() {
	            addCriterion("data_type is null");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeIsNotNull() {
	            addCriterion("data_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria anddataTypeEqualTo(Integer value) {
	            addCriterion("data_type =", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeNotEqualTo(Integer value) {
	            addCriterion("data_type <>", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeGreaterThan(Integer value) {
	            addCriterion("data_type >", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeGreaterThanOrEqualTo(Integer value) {
	            addCriterion("data_type >=", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeLessThan(Integer value) {
	            addCriterion("data_type <", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeLessThanOrEqualTo(Integer value) {
	            addCriterion("data_type <=", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeIn(List<Integer> values) {
	            addCriterion("data_type in", values, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeNotIn(List<Integer> values) {
	            addCriterion("data_type not in", values, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeBetween(Integer value1, Integer value2) {
	            addCriterion("data_type between", value1, value2, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeNotBetween(Integer value1, Integer value2) {
	            addCriterion("data_type not between", value1, value2, "dataType");
	            return (Criteria) this;
	        }
	        public Criteria andcreateTimeIsNull() {
	            addCriterion("createTime is null");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeIsNotNull() {
	            addCriterion("createTime is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcreateTimeEqualTo(Date value) {
	            addCriterion("createTime =", value, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeNotEqualTo(Date value) {
	            addCriterion("createTime <>", value, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeGreaterThan(Date value) {
	            addCriterion("createTime >", value, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("createTime >=", value, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeLessThan(Date value) {
	            addCriterion("createTime <", value, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeLessThanOrEqualTo(Date value) {
	            addCriterion("createTime <=", value, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeIn(List<Date> values) {
	            addCriterion("createTime in", values, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeNotIn(List<Date> values) {
	            addCriterion("createTime not in", values, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeBetween(Date value1, Date value2) {
	            addCriterion("createTime between", value1, value2, "createTime");
	            return (Criteria) this;
	        }

	        public Criteria andcreateTimeNotBetween(Date value1, Date value2) {
	            addCriterion("createTime not between", value1, value2, "createTime");
	            return (Criteria) this;
	        }
	        public Criteria andmodifyDateIsNull() {
	            addCriterion("modifyDate is null");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateIsNotNull() {
	            addCriterion("modifyDate is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andmodifyDateEqualTo(Date value) {
	            addCriterion("modifyDate =", value, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateNotEqualTo(Date value) {
	            addCriterion("modifyDate <>", value, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateGreaterThan(Date value) {
	            addCriterion("modifyDate >", value, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateGreaterThanOrEqualTo(Date value) {
	            addCriterion("modifyDate >=", value, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateLessThan(Date value) {
	            addCriterion("modifyDate <", value, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateLessThanOrEqualTo(Date value) {
	            addCriterion("modifyDate <=", value, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateIn(List<Date> values) {
	            addCriterion("modifyDate in", values, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateNotIn(List<Date> values) {
	            addCriterion("modifyDate not in", values, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateBetween(Date value1, Date value2) {
	            addCriterion("modifyDate between", value1, value2, "modifyDate");
	            return (Criteria) this;
	        }

	        public Criteria andmodifyDateNotBetween(Date value1, Date value2) {
	            addCriterion("modifyDate not between", value1, value2, "modifyDate");
	            return (Criteria) this;
	        }
	        public Criteria andfacTimeIsNull() {
	            addCriterion("fac_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeIsNotNull() {
	            addCriterion("fac_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andfacTimeEqualTo(Date value) {
	            addCriterion("fac_time =", value, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeNotEqualTo(Date value) {
	            addCriterion("fac_time <>", value, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeGreaterThan(Date value) {
	            addCriterion("fac_time >", value, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("fac_time >=", value, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeLessThan(Date value) {
	            addCriterion("fac_time <", value, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeLessThanOrEqualTo(Date value) {
	            addCriterion("fac_time <=", value, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeIn(List<Date> values) {
	            addCriterion("fac_time in", values, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeNotIn(List<Date> values) {
	            addCriterion("fac_time not in", values, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeBetween(Date value1, Date value2) {
	            addCriterion("fac_time between", value1, value2, "facTime");
	            return (Criteria) this;
	        }

	        public Criteria andfacTimeNotBetween(Date value1, Date value2) {
	            addCriterion("fac_time not between", value1, value2, "facTime");
	            return (Criteria) this;
	        }
	 }
	 
	 public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
     }
	 
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