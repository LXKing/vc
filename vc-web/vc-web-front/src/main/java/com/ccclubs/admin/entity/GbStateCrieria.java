package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车辆国标历史信息数据查询条件对象
 * @author Joel
 */
public class GbStateCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public GbStateCrieria() {
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
	        public Criteria andgsIdIsNull() {
	            addCriterion("gs_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdIsNotNull() {
	            addCriterion("gs_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andgsIdEqualTo(Integer value) {
	            addCriterion("gs_id =", value, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdNotEqualTo(Integer value) {
	            addCriterion("gs_id <>", value, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdGreaterThan(Integer value) {
	            addCriterion("gs_id >", value, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("gs_id >=", value, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdLessThan(Integer value) {
	            addCriterion("gs_id <", value, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdLessThanOrEqualTo(Integer value) {
	            addCriterion("gs_id <=", value, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdIn(List<Integer> values) {
	            addCriterion("gs_id in", values, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdNotIn(List<Integer> values) {
	            addCriterion("gs_id not in", values, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdBetween(Integer value1, Integer value2) {
	            addCriterion("gs_id between", value1, value2, "gsId");
	            return (Criteria) this;
	        }

	        public Criteria andgsIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("gs_id not between", value1, value2, "gsId");
	            return (Criteria) this;
	        }
	        public Criteria andvinIsNull() {
	            addCriterion("vin is null");
	            return (Criteria) this;
	        }

	        public Criteria andvinIsNotNull() {
	            addCriterion("vin is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvinLike(String value) {
	            addCriterion("vin like", "%"+value+"%", "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinNotLike(String value) {
	            addCriterion("vin not like", "%"+value+"%", "vin");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvinEqualTo(String value) {
	            addCriterion("vin =", value, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinNotEqualTo(String value) {
	            addCriterion("vin <>", value, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinGreaterThan(String value) {
	            addCriterion("vin >", value, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinGreaterThanOrEqualTo(String value) {
	            addCriterion("vin >=", value, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinLessThan(String value) {
	            addCriterion("vin <", value, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinLessThanOrEqualTo(String value) {
	            addCriterion("vin <=", value, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinIn(List<String> values) {
	            addCriterion("vin in", values, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinNotIn(List<String> values) {
	            addCriterion("vin not in", values, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinBetween(String value1, String value2) {
	            addCriterion("vin between", value1, value2, "vin");
	            return (Criteria) this;
	        }

	        public Criteria andvinNotBetween(String value1, String value2) {
	            addCriterion("vin not between", value1, value2, "vin");
	            return (Criteria) this;
	        }
	        public Criteria andtimeTextIsNull() {
	            addCriterion("time_text is null");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextIsNotNull() {
	            addCriterion("time_text is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andtimeTextLike(String value) {
	            addCriterion("time_text like", "%"+value+"%", "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextNotLike(String value) {
	            addCriterion("time_text not like", "%"+value+"%", "timeText");
	            return (Criteria) this;
	        }
	        
	        public Criteria andtimeTextEqualTo(String value) {
	            addCriterion("time_text =", value, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextNotEqualTo(String value) {
	            addCriterion("time_text <>", value, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextGreaterThan(String value) {
	            addCriterion("time_text >", value, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextGreaterThanOrEqualTo(String value) {
	            addCriterion("time_text >=", value, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextLessThan(String value) {
	            addCriterion("time_text <", value, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextLessThanOrEqualTo(String value) {
	            addCriterion("time_text <=", value, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextIn(List<String> values) {
	            addCriterion("time_text in", values, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextNotIn(List<String> values) {
	            addCriterion("time_text not in", values, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextBetween(String value1, String value2) {
	            addCriterion("time_text between", value1, value2, "timeText");
	            return (Criteria) this;
	        }

	        public Criteria andtimeTextNotBetween(String value1, String value2) {
	            addCriterion("time_text not between", value1, value2, "timeText");
	            return (Criteria) this;
	        }
	        public Criteria andvehicleStatusStringIsNull() {
	            addCriterion("vehicle_status_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringIsNotNull() {
	            addCriterion("vehicle_status_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvehicleStatusStringLike(String value) {
	            addCriterion("vehicle_status_string like", "%"+value+"%", "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringNotLike(String value) {
	            addCriterion("vehicle_status_string not like", "%"+value+"%", "vehicleStatusString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvehicleStatusStringEqualTo(String value) {
	            addCriterion("vehicle_status_string =", value, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringNotEqualTo(String value) {
	            addCriterion("vehicle_status_string <>", value, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringGreaterThan(String value) {
	            addCriterion("vehicle_status_string >", value, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringGreaterThanOrEqualTo(String value) {
	            addCriterion("vehicle_status_string >=", value, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringLessThan(String value) {
	            addCriterion("vehicle_status_string <", value, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringLessThanOrEqualTo(String value) {
	            addCriterion("vehicle_status_string <=", value, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringIn(List<String> values) {
	            addCriterion("vehicle_status_string in", values, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringNotIn(List<String> values) {
	            addCriterion("vehicle_status_string not in", values, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringBetween(String value1, String value2) {
	            addCriterion("vehicle_status_string between", value1, value2, "vehicleStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleStatusStringNotBetween(String value1, String value2) {
	            addCriterion("vehicle_status_string not between", value1, value2, "vehicleStatusString");
	            return (Criteria) this;
	        }
	        public Criteria andchargingStringIsNull() {
	            addCriterion("charging_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringIsNotNull() {
	            addCriterion("charging_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andchargingStringLike(String value) {
	            addCriterion("charging_string like", "%"+value+"%", "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringNotLike(String value) {
	            addCriterion("charging_string not like", "%"+value+"%", "chargingString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andchargingStringEqualTo(String value) {
	            addCriterion("charging_string =", value, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringNotEqualTo(String value) {
	            addCriterion("charging_string <>", value, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringGreaterThan(String value) {
	            addCriterion("charging_string >", value, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringGreaterThanOrEqualTo(String value) {
	            addCriterion("charging_string >=", value, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringLessThan(String value) {
	            addCriterion("charging_string <", value, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringLessThanOrEqualTo(String value) {
	            addCriterion("charging_string <=", value, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringIn(List<String> values) {
	            addCriterion("charging_string in", values, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringNotIn(List<String> values) {
	            addCriterion("charging_string not in", values, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringBetween(String value1, String value2) {
	            addCriterion("charging_string between", value1, value2, "chargingString");
	            return (Criteria) this;
	        }

	        public Criteria andchargingStringNotBetween(String value1, String value2) {
	            addCriterion("charging_string not between", value1, value2, "chargingString");
	            return (Criteria) this;
	        }
	        public Criteria andrunningModeStringIsNull() {
	            addCriterion("running_mode_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringIsNotNull() {
	            addCriterion("running_mode_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andrunningModeStringLike(String value) {
	            addCriterion("running_mode_string like", "%"+value+"%", "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringNotLike(String value) {
	            addCriterion("running_mode_string not like", "%"+value+"%", "runningModeString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andrunningModeStringEqualTo(String value) {
	            addCriterion("running_mode_string =", value, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringNotEqualTo(String value) {
	            addCriterion("running_mode_string <>", value, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringGreaterThan(String value) {
	            addCriterion("running_mode_string >", value, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringGreaterThanOrEqualTo(String value) {
	            addCriterion("running_mode_string >=", value, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringLessThan(String value) {
	            addCriterion("running_mode_string <", value, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringLessThanOrEqualTo(String value) {
	            addCriterion("running_mode_string <=", value, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringIn(List<String> values) {
	            addCriterion("running_mode_string in", values, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringNotIn(List<String> values) {
	            addCriterion("running_mode_string not in", values, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringBetween(String value1, String value2) {
	            addCriterion("running_mode_string between", value1, value2, "runningModeString");
	            return (Criteria) this;
	        }

	        public Criteria andrunningModeStringNotBetween(String value1, String value2) {
	            addCriterion("running_mode_string not between", value1, value2, "runningModeString");
	            return (Criteria) this;
	        }
	        public Criteria andspeedStringIsNull() {
	            addCriterion("speed_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringIsNotNull() {
	            addCriterion("speed_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspeedStringLike(String value) {
	            addCriterion("speed_string like", "%"+value+"%", "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringNotLike(String value) {
	            addCriterion("speed_string not like", "%"+value+"%", "speedString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspeedStringEqualTo(String value) {
	            addCriterion("speed_string =", value, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringNotEqualTo(String value) {
	            addCriterion("speed_string <>", value, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringGreaterThan(String value) {
	            addCriterion("speed_string >", value, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringGreaterThanOrEqualTo(String value) {
	            addCriterion("speed_string >=", value, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringLessThan(String value) {
	            addCriterion("speed_string <", value, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringLessThanOrEqualTo(String value) {
	            addCriterion("speed_string <=", value, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringIn(List<String> values) {
	            addCriterion("speed_string in", values, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringNotIn(List<String> values) {
	            addCriterion("speed_string not in", values, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringBetween(String value1, String value2) {
	            addCriterion("speed_string between", value1, value2, "speedString");
	            return (Criteria) this;
	        }

	        public Criteria andspeedStringNotBetween(String value1, String value2) {
	            addCriterion("speed_string not between", value1, value2, "speedString");
	            return (Criteria) this;
	        }
	        public Criteria andmileageStringIsNull() {
	            addCriterion("mileage_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringIsNotNull() {
	            addCriterion("mileage_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andmileageStringLike(String value) {
	            addCriterion("mileage_string like", "%"+value+"%", "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringNotLike(String value) {
	            addCriterion("mileage_string not like", "%"+value+"%", "mileageString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andmileageStringEqualTo(String value) {
	            addCriterion("mileage_string =", value, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringNotEqualTo(String value) {
	            addCriterion("mileage_string <>", value, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringGreaterThan(String value) {
	            addCriterion("mileage_string >", value, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringGreaterThanOrEqualTo(String value) {
	            addCriterion("mileage_string >=", value, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringLessThan(String value) {
	            addCriterion("mileage_string <", value, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringLessThanOrEqualTo(String value) {
	            addCriterion("mileage_string <=", value, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringIn(List<String> values) {
	            addCriterion("mileage_string in", values, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringNotIn(List<String> values) {
	            addCriterion("mileage_string not in", values, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringBetween(String value1, String value2) {
	            addCriterion("mileage_string between", value1, value2, "mileageString");
	            return (Criteria) this;
	        }

	        public Criteria andmileageStringNotBetween(String value1, String value2) {
	            addCriterion("mileage_string not between", value1, value2, "mileageString");
	            return (Criteria) this;
	        }
	        public Criteria andvoltageStringIsNull() {
	            addCriterion("voltage_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringIsNotNull() {
	            addCriterion("voltage_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvoltageStringLike(String value) {
	            addCriterion("voltage_string like", "%"+value+"%", "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringNotLike(String value) {
	            addCriterion("voltage_string not like", "%"+value+"%", "voltageString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvoltageStringEqualTo(String value) {
	            addCriterion("voltage_string =", value, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringNotEqualTo(String value) {
	            addCriterion("voltage_string <>", value, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringGreaterThan(String value) {
	            addCriterion("voltage_string >", value, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringGreaterThanOrEqualTo(String value) {
	            addCriterion("voltage_string >=", value, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringLessThan(String value) {
	            addCriterion("voltage_string <", value, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringLessThanOrEqualTo(String value) {
	            addCriterion("voltage_string <=", value, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringIn(List<String> values) {
	            addCriterion("voltage_string in", values, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringNotIn(List<String> values) {
	            addCriterion("voltage_string not in", values, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringBetween(String value1, String value2) {
	            addCriterion("voltage_string between", value1, value2, "voltageString");
	            return (Criteria) this;
	        }

	        public Criteria andvoltageStringNotBetween(String value1, String value2) {
	            addCriterion("voltage_string not between", value1, value2, "voltageString");
	            return (Criteria) this;
	        }
	        public Criteria andcurrentStringIsNull() {
	            addCriterion("current_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringIsNotNull() {
	            addCriterion("current_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcurrentStringLike(String value) {
	            addCriterion("current_string like", "%"+value+"%", "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringNotLike(String value) {
	            addCriterion("current_string not like", "%"+value+"%", "currentString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcurrentStringEqualTo(String value) {
	            addCriterion("current_string =", value, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringNotEqualTo(String value) {
	            addCriterion("current_string <>", value, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringGreaterThan(String value) {
	            addCriterion("current_string >", value, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringGreaterThanOrEqualTo(String value) {
	            addCriterion("current_string >=", value, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringLessThan(String value) {
	            addCriterion("current_string <", value, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringLessThanOrEqualTo(String value) {
	            addCriterion("current_string <=", value, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringIn(List<String> values) {
	            addCriterion("current_string in", values, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringNotIn(List<String> values) {
	            addCriterion("current_string not in", values, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringBetween(String value1, String value2) {
	            addCriterion("current_string between", value1, value2, "currentString");
	            return (Criteria) this;
	        }

	        public Criteria andcurrentStringNotBetween(String value1, String value2) {
	            addCriterion("current_string not between", value1, value2, "currentString");
	            return (Criteria) this;
	        }
	        public Criteria andsocStringIsNull() {
	            addCriterion("soc_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringIsNotNull() {
	            addCriterion("soc_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsocStringLike(String value) {
	            addCriterion("soc_string like", "%"+value+"%", "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringNotLike(String value) {
	            addCriterion("soc_string not like", "%"+value+"%", "socString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsocStringEqualTo(String value) {
	            addCriterion("soc_string =", value, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringNotEqualTo(String value) {
	            addCriterion("soc_string <>", value, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringGreaterThan(String value) {
	            addCriterion("soc_string >", value, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringGreaterThanOrEqualTo(String value) {
	            addCriterion("soc_string >=", value, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringLessThan(String value) {
	            addCriterion("soc_string <", value, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringLessThanOrEqualTo(String value) {
	            addCriterion("soc_string <=", value, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringIn(List<String> values) {
	            addCriterion("soc_string in", values, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringNotIn(List<String> values) {
	            addCriterion("soc_string not in", values, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringBetween(String value1, String value2) {
	            addCriterion("soc_string between", value1, value2, "socString");
	            return (Criteria) this;
	        }

	        public Criteria andsocStringNotBetween(String value1, String value2) {
	            addCriterion("soc_string not between", value1, value2, "socString");
	            return (Criteria) this;
	        }
	        public Criteria anddcDcStatusStringIsNull() {
	            addCriterion("dc_dc_status_string is null");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringIsNotNull() {
	            addCriterion("dc_dc_status_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddcDcStatusStringLike(String value) {
	            addCriterion("dc_dc_status_string like", "%"+value+"%", "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringNotLike(String value) {
	            addCriterion("dc_dc_status_string not like", "%"+value+"%", "dcDcStatusString");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddcDcStatusStringEqualTo(String value) {
	            addCriterion("dc_dc_status_string =", value, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringNotEqualTo(String value) {
	            addCriterion("dc_dc_status_string <>", value, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringGreaterThan(String value) {
	            addCriterion("dc_dc_status_string >", value, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringGreaterThanOrEqualTo(String value) {
	            addCriterion("dc_dc_status_string >=", value, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringLessThan(String value) {
	            addCriterion("dc_dc_status_string <", value, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringLessThanOrEqualTo(String value) {
	            addCriterion("dc_dc_status_string <=", value, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringIn(List<String> values) {
	            addCriterion("dc_dc_status_string in", values, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringNotIn(List<String> values) {
	            addCriterion("dc_dc_status_string not in", values, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringBetween(String value1, String value2) {
	            addCriterion("dc_dc_status_string between", value1, value2, "dcDcStatusString");
	            return (Criteria) this;
	        }

	        public Criteria anddcDcStatusStringNotBetween(String value1, String value2) {
	            addCriterion("dc_dc_status_string not between", value1, value2, "dcDcStatusString");
	            return (Criteria) this;
	        }
	        public Criteria andgearStringIsNull() {
	            addCriterion("gear_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringIsNotNull() {
	            addCriterion("gear_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andgearStringLike(String value) {
	            addCriterion("gear_string like", "%"+value+"%", "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringNotLike(String value) {
	            addCriterion("gear_string not like", "%"+value+"%", "gearString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andgearStringEqualTo(String value) {
	            addCriterion("gear_string =", value, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringNotEqualTo(String value) {
	            addCriterion("gear_string <>", value, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringGreaterThan(String value) {
	            addCriterion("gear_string >", value, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringGreaterThanOrEqualTo(String value) {
	            addCriterion("gear_string >=", value, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringLessThan(String value) {
	            addCriterion("gear_string <", value, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringLessThanOrEqualTo(String value) {
	            addCriterion("gear_string <=", value, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringIn(List<String> values) {
	            addCriterion("gear_string in", values, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringNotIn(List<String> values) {
	            addCriterion("gear_string not in", values, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringBetween(String value1, String value2) {
	            addCriterion("gear_string between", value1, value2, "gearString");
	            return (Criteria) this;
	        }

	        public Criteria andgearStringNotBetween(String value1, String value2) {
	            addCriterion("gear_string not between", value1, value2, "gearString");
	            return (Criteria) this;
	        }
	        public Criteria andinsulationResistanceStringIsNull() {
	            addCriterion("insulation_resistance_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringIsNotNull() {
	            addCriterion("insulation_resistance_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andinsulationResistanceStringLike(String value) {
	            addCriterion("insulation_resistance_string like", "%"+value+"%", "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringNotLike(String value) {
	            addCriterion("insulation_resistance_string not like", "%"+value+"%", "insulationResistanceString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andinsulationResistanceStringEqualTo(String value) {
	            addCriterion("insulation_resistance_string =", value, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringNotEqualTo(String value) {
	            addCriterion("insulation_resistance_string <>", value, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringGreaterThan(String value) {
	            addCriterion("insulation_resistance_string >", value, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringGreaterThanOrEqualTo(String value) {
	            addCriterion("insulation_resistance_string >=", value, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringLessThan(String value) {
	            addCriterion("insulation_resistance_string <", value, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringLessThanOrEqualTo(String value) {
	            addCriterion("insulation_resistance_string <=", value, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringIn(List<String> values) {
	            addCriterion("insulation_resistance_string in", values, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringNotIn(List<String> values) {
	            addCriterion("insulation_resistance_string not in", values, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringBetween(String value1, String value2) {
	            addCriterion("insulation_resistance_string between", value1, value2, "insulationResistanceString");
	            return (Criteria) this;
	        }

	        public Criteria andinsulationResistanceStringNotBetween(String value1, String value2) {
	            addCriterion("insulation_resistance_string not between", value1, value2, "insulationResistanceString");
	            return (Criteria) this;
	        }
	        public Criteria andacceleratedPedalStrokeValueStringIsNull() {
	            addCriterion("accelerated_pedal_stroke_value_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringIsNotNull() {
	            addCriterion("accelerated_pedal_stroke_value_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andacceleratedPedalStrokeValueStringLike(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string like", "%"+value+"%", "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringNotLike(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string not like", "%"+value+"%", "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andacceleratedPedalStrokeValueStringEqualTo(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string =", value, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringNotEqualTo(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string <>", value, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringGreaterThan(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string >", value, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringGreaterThanOrEqualTo(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string >=", value, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringLessThan(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string <", value, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringLessThanOrEqualTo(String value) {
	            addCriterion("accelerated_pedal_stroke_value_string <=", value, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringIn(List<String> values) {
	            addCriterion("accelerated_pedal_stroke_value_string in", values, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringNotIn(List<String> values) {
	            addCriterion("accelerated_pedal_stroke_value_string not in", values, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringBetween(String value1, String value2) {
	            addCriterion("accelerated_pedal_stroke_value_string between", value1, value2, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }

	        public Criteria andacceleratedPedalStrokeValueStringNotBetween(String value1, String value2) {
	            addCriterion("accelerated_pedal_stroke_value_string not between", value1, value2, "acceleratedPedalStrokeValueString");
	            return (Criteria) this;
	        }
	        public Criteria andbrakePedalStateStringIsNull() {
	            addCriterion("brake_pedal_state_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringIsNotNull() {
	            addCriterion("brake_pedal_state_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andbrakePedalStateStringLike(String value) {
	            addCriterion("brake_pedal_state_string like", "%"+value+"%", "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringNotLike(String value) {
	            addCriterion("brake_pedal_state_string not like", "%"+value+"%", "brakePedalStateString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andbrakePedalStateStringEqualTo(String value) {
	            addCriterion("brake_pedal_state_string =", value, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringNotEqualTo(String value) {
	            addCriterion("brake_pedal_state_string <>", value, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringGreaterThan(String value) {
	            addCriterion("brake_pedal_state_string >", value, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringGreaterThanOrEqualTo(String value) {
	            addCriterion("brake_pedal_state_string >=", value, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringLessThan(String value) {
	            addCriterion("brake_pedal_state_string <", value, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringLessThanOrEqualTo(String value) {
	            addCriterion("brake_pedal_state_string <=", value, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringIn(List<String> values) {
	            addCriterion("brake_pedal_state_string in", values, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringNotIn(List<String> values) {
	            addCriterion("brake_pedal_state_string not in", values, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringBetween(String value1, String value2) {
	            addCriterion("brake_pedal_state_string between", value1, value2, "brakePedalStateString");
	            return (Criteria) this;
	        }

	        public Criteria andbrakePedalStateStringNotBetween(String value1, String value2) {
	            addCriterion("brake_pedal_state_string not between", value1, value2, "brakePedalStateString");
	            return (Criteria) this;
	        }
	        public Criteria andpositionStatusStringIsNull() {
	            addCriterion("position_status_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringIsNotNull() {
	            addCriterion("position_status_string is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andpositionStatusStringLike(String value) {
	            addCriterion("position_status_string like", "%"+value+"%", "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringNotLike(String value) {
	            addCriterion("position_status_string not like", "%"+value+"%", "positionStatusString");
	            return (Criteria) this;
	        }
	        
	        public Criteria andpositionStatusStringEqualTo(String value) {
	            addCriterion("position_status_string =", value, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringNotEqualTo(String value) {
	            addCriterion("position_status_string <>", value, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringGreaterThan(String value) {
	            addCriterion("position_status_string >", value, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringGreaterThanOrEqualTo(String value) {
	            addCriterion("position_status_string >=", value, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringLessThan(String value) {
	            addCriterion("position_status_string <", value, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringLessThanOrEqualTo(String value) {
	            addCriterion("position_status_string <=", value, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringIn(List<String> values) {
	            addCriterion("position_status_string in", values, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringNotIn(List<String> values) {
	            addCriterion("position_status_string not in", values, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringBetween(String value1, String value2) {
	            addCriterion("position_status_string between", value1, value2, "positionStatusString");
	            return (Criteria) this;
	        }

	        public Criteria andpositionStatusStringNotBetween(String value1, String value2) {
	            addCriterion("position_status_string not between", value1, value2, "positionStatusString");
	            return (Criteria) this;
	        }
	        public Criteria andlongitudeStringIsNull() {
	            addCriterion("longitude_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringIsNotNull() {
	            addCriterion("longitude_string is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andlongitudeStringEqualTo(Long value) {
	            addCriterion("longitude_string =", value, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringNotEqualTo(Long value) {
	            addCriterion("longitude_string <>", value, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringGreaterThan(Long value) {
	            addCriterion("longitude_string >", value, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringGreaterThanOrEqualTo(Long value) {
	            addCriterion("longitude_string >=", value, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringLessThan(Long value) {
	            addCriterion("longitude_string <", value, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringLessThanOrEqualTo(Long value) {
	            addCriterion("longitude_string <=", value, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringIn(List<Long> values) {
	            addCriterion("longitude_string in", values, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringNotIn(List<Long> values) {
	            addCriterion("longitude_string not in", values, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringBetween(Long value1, Long value2) {
	            addCriterion("longitude_string between", value1, value2, "longitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlongitudeStringNotBetween(Long value1, Long value2) {
	            addCriterion("longitude_string not between", value1, value2, "longitudeString");
	            return (Criteria) this;
	        }
	        public Criteria andlatitudeStringIsNull() {
	            addCriterion("latitude_string is null");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringIsNotNull() {
	            addCriterion("latitude_string is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andlatitudeStringEqualTo(Long value) {
	            addCriterion("latitude_string =", value, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringNotEqualTo(Long value) {
	            addCriterion("latitude_string <>", value, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringGreaterThan(Long value) {
	            addCriterion("latitude_string >", value, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringGreaterThanOrEqualTo(Long value) {
	            addCriterion("latitude_string >=", value, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringLessThan(Long value) {
	            addCriterion("latitude_string <", value, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringLessThanOrEqualTo(Long value) {
	            addCriterion("latitude_string <=", value, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringIn(List<Long> values) {
	            addCriterion("latitude_string in", values, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringNotIn(List<Long> values) {
	            addCriterion("latitude_string not in", values, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringBetween(Long value1, Long value2) {
	            addCriterion("latitude_string between", value1, value2, "latitudeString");
	            return (Criteria) this;
	        }

	        public Criteria andlatitudeStringNotBetween(Long value1, Long value2) {
	            addCriterion("latitude_string not between", value1, value2, "latitudeString");
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