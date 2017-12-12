package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车辆统计数据数据查询条件对象
 * @author Joel
 */
public class CsStatisticsCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsStatisticsCrieria() {
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
	        public Criteria andcssIdIsNull() {
	            addCriterion("css_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdIsNotNull() {
	            addCriterion("css_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssIdEqualTo(Integer value) {
	            addCriterion("css_id =", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotEqualTo(Integer value) {
	            addCriterion("css_id <>", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdGreaterThan(Integer value) {
	            addCriterion("css_id >", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_id >=", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdLessThan(Integer value) {
	            addCriterion("css_id <", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdLessThanOrEqualTo(Integer value) {
	            addCriterion("css_id <=", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdIn(List<Integer> values) {
	            addCriterion("css_id in", values, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotIn(List<Integer> values) {
	            addCriterion("css_id not in", values, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdBetween(Integer value1, Integer value2) {
	            addCriterion("css_id between", value1, value2, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_id not between", value1, value2, "cssId");
	            return (Criteria) this;
	        }
	        public Criteria andcssTimeIsNull() {
	            addCriterion("css_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeIsNotNull() {
	            addCriterion("css_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssTimeEqualTo(Date value) {
	            addCriterion("css_time =", value, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeNotEqualTo(Date value) {
	            addCriterion("css_time <>", value, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeGreaterThan(Date value) {
	            addCriterion("css_time >", value, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("css_time >=", value, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeLessThan(Date value) {
	            addCriterion("css_time <", value, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeLessThanOrEqualTo(Date value) {
	            addCriterion("css_time <=", value, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeIn(List<Date> values) {
	            addCriterion("css_time in", values, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeNotIn(List<Date> values) {
	            addCriterion("css_time not in", values, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeBetween(Date value1, Date value2) {
	            addCriterion("css_time between", value1, value2, "cssTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTimeNotBetween(Date value1, Date value2) {
	            addCriterion("css_time not between", value1, value2, "cssTime");
	            return (Criteria) this;
	        }
	        public Criteria andcssUnitTimeIsNull() {
	            addCriterion("css_unit_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeIsNotNull() {
	            addCriterion("css_unit_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssUnitTimeEqualTo(Long value) {
	            addCriterion("css_unit_time =", value, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeNotEqualTo(Long value) {
	            addCriterion("css_unit_time <>", value, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeGreaterThan(Long value) {
	            addCriterion("css_unit_time >", value, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeGreaterThanOrEqualTo(Long value) {
	            addCriterion("css_unit_time >=", value, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeLessThan(Long value) {
	            addCriterion("css_unit_time <", value, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeLessThanOrEqualTo(Long value) {
	            addCriterion("css_unit_time <=", value, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeIn(List<Long> values) {
	            addCriterion("css_unit_time in", values, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeNotIn(List<Long> values) {
	            addCriterion("css_unit_time not in", values, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeBetween(Long value1, Long value2) {
	            addCriterion("css_unit_time between", value1, value2, "cssUnitTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssUnitTimeNotBetween(Long value1, Long value2) {
	            addCriterion("css_unit_time not between", value1, value2, "cssUnitTime");
	            return (Criteria) this;
	        }
	        public Criteria andcssRegisteredNumIsNull() {
	            addCriterion("css_registered_num is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumIsNotNull() {
	            addCriterion("css_registered_num is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssRegisteredNumEqualTo(Integer value) {
	            addCriterion("css_registered_num =", value, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumNotEqualTo(Integer value) {
	            addCriterion("css_registered_num <>", value, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumGreaterThan(Integer value) {
	            addCriterion("css_registered_num >", value, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_registered_num >=", value, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumLessThan(Integer value) {
	            addCriterion("css_registered_num <", value, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumLessThanOrEqualTo(Integer value) {
	            addCriterion("css_registered_num <=", value, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumIn(List<Integer> values) {
	            addCriterion("css_registered_num in", values, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumNotIn(List<Integer> values) {
	            addCriterion("css_registered_num not in", values, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumBetween(Integer value1, Integer value2) {
	            addCriterion("css_registered_num between", value1, value2, "cssRegisteredNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRegisteredNumNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_registered_num not between", value1, value2, "cssRegisteredNum");
	            return (Criteria) this;
	        }
	        public Criteria andcssOnlineNumIsNull() {
	            addCriterion("css_online_num is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumIsNotNull() {
	            addCriterion("css_online_num is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssOnlineNumEqualTo(Integer value) {
	            addCriterion("css_online_num =", value, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumNotEqualTo(Integer value) {
	            addCriterion("css_online_num <>", value, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumGreaterThan(Integer value) {
	            addCriterion("css_online_num >", value, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_online_num >=", value, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumLessThan(Integer value) {
	            addCriterion("css_online_num <", value, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumLessThanOrEqualTo(Integer value) {
	            addCriterion("css_online_num <=", value, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumIn(List<Integer> values) {
	            addCriterion("css_online_num in", values, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumNotIn(List<Integer> values) {
	            addCriterion("css_online_num not in", values, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumBetween(Integer value1, Integer value2) {
	            addCriterion("css_online_num between", value1, value2, "cssOnlineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOnlineNumNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_online_num not between", value1, value2, "cssOnlineNum");
	            return (Criteria) this;
	        }
	        public Criteria andcssOfflineNumIsNull() {
	            addCriterion("css_offline_num is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumIsNotNull() {
	            addCriterion("css_offline_num is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssOfflineNumEqualTo(Integer value) {
	            addCriterion("css_offline_num =", value, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumNotEqualTo(Integer value) {
	            addCriterion("css_offline_num <>", value, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumGreaterThan(Integer value) {
	            addCriterion("css_offline_num >", value, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_offline_num >=", value, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumLessThan(Integer value) {
	            addCriterion("css_offline_num <", value, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumLessThanOrEqualTo(Integer value) {
	            addCriterion("css_offline_num <=", value, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumIn(List<Integer> values) {
	            addCriterion("css_offline_num in", values, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumNotIn(List<Integer> values) {
	            addCriterion("css_offline_num not in", values, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumBetween(Integer value1, Integer value2) {
	            addCriterion("css_offline_num between", value1, value2, "cssOfflineNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssOfflineNumNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_offline_num not between", value1, value2, "cssOfflineNum");
	            return (Criteria) this;
	        }
	        public Criteria andcssRunNumIsNull() {
	            addCriterion("css_run_num is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumIsNotNull() {
	            addCriterion("css_run_num is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssRunNumEqualTo(Integer value) {
	            addCriterion("css_run_num =", value, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumNotEqualTo(Integer value) {
	            addCriterion("css_run_num <>", value, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumGreaterThan(Integer value) {
	            addCriterion("css_run_num >", value, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_run_num >=", value, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumLessThan(Integer value) {
	            addCriterion("css_run_num <", value, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumLessThanOrEqualTo(Integer value) {
	            addCriterion("css_run_num <=", value, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumIn(List<Integer> values) {
	            addCriterion("css_run_num in", values, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumNotIn(List<Integer> values) {
	            addCriterion("css_run_num not in", values, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumBetween(Integer value1, Integer value2) {
	            addCriterion("css_run_num between", value1, value2, "cssRunNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssRunNumNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_run_num not between", value1, value2, "cssRunNum");
	            return (Criteria) this;
	        }
	        public Criteria andcssChargingNumIsNull() {
	            addCriterion("css_charging_num is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumIsNotNull() {
	            addCriterion("css_charging_num is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssChargingNumEqualTo(Integer value) {
	            addCriterion("css_charging_num =", value, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumNotEqualTo(Integer value) {
	            addCriterion("css_charging_num <>", value, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumGreaterThan(Integer value) {
	            addCriterion("css_charging_num >", value, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_charging_num >=", value, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumLessThan(Integer value) {
	            addCriterion("css_charging_num <", value, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumLessThanOrEqualTo(Integer value) {
	            addCriterion("css_charging_num <=", value, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumIn(List<Integer> values) {
	            addCriterion("css_charging_num in", values, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumNotIn(List<Integer> values) {
	            addCriterion("css_charging_num not in", values, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumBetween(Integer value1, Integer value2) {
	            addCriterion("css_charging_num between", value1, value2, "cssChargingNum");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNumNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_charging_num not between", value1, value2, "cssChargingNum");
	            return (Criteria) this;
	        }
	        public Criteria andcssTotalMileageIsNull() {
	            addCriterion("css_total_mileage is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageIsNotNull() {
	            addCriterion("css_total_mileage is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssTotalMileageEqualTo(Float value) {
	            addCriterion("css_total_mileage =", value, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageNotEqualTo(Float value) {
	            addCriterion("css_total_mileage <>", value, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageGreaterThan(Float value) {
	            addCriterion("css_total_mileage >", value, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageGreaterThanOrEqualTo(Float value) {
	            addCriterion("css_total_mileage >=", value, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageLessThan(Float value) {
	            addCriterion("css_total_mileage <", value, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageLessThanOrEqualTo(Float value) {
	            addCriterion("css_total_mileage <=", value, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageIn(List<Float> values) {
	            addCriterion("css_total_mileage in", values, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageNotIn(List<Float> values) {
	            addCriterion("css_total_mileage not in", values, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageBetween(Float value1, Float value2) {
	            addCriterion("css_total_mileage between", value1, value2, "cssTotalMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalMileageNotBetween(Float value1, Float value2) {
	            addCriterion("css_total_mileage not between", value1, value2, "cssTotalMileage");
	            return (Criteria) this;
	        }
	        public Criteria andcssTotalChargeIsNull() {
	            addCriterion("css_total_charge is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeIsNotNull() {
	            addCriterion("css_total_charge is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssTotalChargeEqualTo(Float value) {
	            addCriterion("css_total_charge =", value, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeNotEqualTo(Float value) {
	            addCriterion("css_total_charge <>", value, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeGreaterThan(Float value) {
	            addCriterion("css_total_charge >", value, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeGreaterThanOrEqualTo(Float value) {
	            addCriterion("css_total_charge >=", value, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeLessThan(Float value) {
	            addCriterion("css_total_charge <", value, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeLessThanOrEqualTo(Float value) {
	            addCriterion("css_total_charge <=", value, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeIn(List<Float> values) {
	            addCriterion("css_total_charge in", values, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeNotIn(List<Float> values) {
	            addCriterion("css_total_charge not in", values, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeBetween(Float value1, Float value2) {
	            addCriterion("css_total_charge between", value1, value2, "cssTotalCharge");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalChargeNotBetween(Float value1, Float value2) {
	            addCriterion("css_total_charge not between", value1, value2, "cssTotalCharge");
	            return (Criteria) this;
	        }
	        public Criteria andcssTotalPowerConsumptionIsNull() {
	            addCriterion("css_total_power_consumption is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionIsNotNull() {
	            addCriterion("css_total_power_consumption is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssTotalPowerConsumptionEqualTo(Float value) {
	            addCriterion("css_total_power_consumption =", value, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionNotEqualTo(Float value) {
	            addCriterion("css_total_power_consumption <>", value, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionGreaterThan(Float value) {
	            addCriterion("css_total_power_consumption >", value, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionGreaterThanOrEqualTo(Float value) {
	            addCriterion("css_total_power_consumption >=", value, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionLessThan(Float value) {
	            addCriterion("css_total_power_consumption <", value, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionLessThanOrEqualTo(Float value) {
	            addCriterion("css_total_power_consumption <=", value, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionIn(List<Float> values) {
	            addCriterion("css_total_power_consumption in", values, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionNotIn(List<Float> values) {
	            addCriterion("css_total_power_consumption not in", values, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionBetween(Float value1, Float value2) {
	            addCriterion("css_total_power_consumption between", value1, value2, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalPowerConsumptionNotBetween(Float value1, Float value2) {
	            addCriterion("css_total_power_consumption not between", value1, value2, "cssTotalPowerConsumption");
	            return (Criteria) this;
	        }
	        public Criteria andcssTotalRunTimeIsNull() {
	            addCriterion("css_total_run_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeIsNotNull() {
	            addCriterion("css_total_run_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssTotalRunTimeEqualTo(Long value) {
	            addCriterion("css_total_run_time =", value, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeNotEqualTo(Long value) {
	            addCriterion("css_total_run_time <>", value, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeGreaterThan(Long value) {
	            addCriterion("css_total_run_time >", value, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeGreaterThanOrEqualTo(Long value) {
	            addCriterion("css_total_run_time >=", value, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeLessThan(Long value) {
	            addCriterion("css_total_run_time <", value, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeLessThanOrEqualTo(Long value) {
	            addCriterion("css_total_run_time <=", value, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeIn(List<Long> values) {
	            addCriterion("css_total_run_time in", values, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeNotIn(List<Long> values) {
	            addCriterion("css_total_run_time not in", values, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeBetween(Long value1, Long value2) {
	            addCriterion("css_total_run_time between", value1, value2, "cssTotalRunTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssTotalRunTimeNotBetween(Long value1, Long value2) {
	            addCriterion("css_total_run_time not between", value1, value2, "cssTotalRunTime");
	            return (Criteria) this;
	        }
	        public Criteria andcssIncrementMileageIsNull() {
	            addCriterion("css_increment_mileage is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageIsNotNull() {
	            addCriterion("css_increment_mileage is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssIncrementMileageEqualTo(Long value) {
	            addCriterion("css_increment_mileage =", value, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageNotEqualTo(Long value) {
	            addCriterion("css_increment_mileage <>", value, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageGreaterThan(Long value) {
	            addCriterion("css_increment_mileage >", value, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageGreaterThanOrEqualTo(Long value) {
	            addCriterion("css_increment_mileage >=", value, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageLessThan(Long value) {
	            addCriterion("css_increment_mileage <", value, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageLessThanOrEqualTo(Long value) {
	            addCriterion("css_increment_mileage <=", value, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageIn(List<Long> values) {
	            addCriterion("css_increment_mileage in", values, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageNotIn(List<Long> values) {
	            addCriterion("css_increment_mileage not in", values, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageBetween(Long value1, Long value2) {
	            addCriterion("css_increment_mileage between", value1, value2, "cssIncrementMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssIncrementMileageNotBetween(Long value1, Long value2) {
	            addCriterion("css_increment_mileage not between", value1, value2, "cssIncrementMileage");
	            return (Criteria) this;
	        }
	        public Criteria andcssAccessIsNull() {
	            addCriterion("css_access is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessIsNotNull() {
	            addCriterion("css_access is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssAccessEqualTo(Integer value) {
	            addCriterion("css_access =", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessNotEqualTo(Integer value) {
	            addCriterion("css_access <>", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessGreaterThan(Integer value) {
	            addCriterion("css_access >", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_access >=", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessLessThan(Integer value) {
	            addCriterion("css_access <", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessLessThanOrEqualTo(Integer value) {
	            addCriterion("css_access <=", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessIn(List<Integer> values) {
	            addCriterion("css_access in", values, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessNotIn(List<Integer> values) {
	            addCriterion("css_access not in", values, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessBetween(Integer value1, Integer value2) {
	            addCriterion("css_access between", value1, value2, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_access not between", value1, value2, "cssAccess");
	            return (Criteria) this;
	        }
	        public Criteria andcssCarModelIsNull() {
	            addCriterion("css_car_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelIsNotNull() {
	            addCriterion("css_car_model is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssCarModelEqualTo(Integer value) {
	            addCriterion("css_car_model =", value, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelNotEqualTo(Integer value) {
	            addCriterion("css_car_model <>", value, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelGreaterThan(Integer value) {
	            addCriterion("css_car_model >", value, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_car_model >=", value, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelLessThan(Integer value) {
	            addCriterion("css_car_model <", value, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelLessThanOrEqualTo(Integer value) {
	            addCriterion("css_car_model <=", value, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelIn(List<Integer> values) {
	            addCriterion("css_car_model in", values, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelNotIn(List<Integer> values) {
	            addCriterion("css_car_model not in", values, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelBetween(Integer value1, Integer value2) {
	            addCriterion("css_car_model between", value1, value2, "cssCarModel");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarModelNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_car_model not between", value1, value2, "cssCarModel");
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