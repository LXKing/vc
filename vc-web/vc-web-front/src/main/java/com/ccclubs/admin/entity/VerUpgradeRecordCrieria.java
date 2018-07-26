package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车机升级记录数据查询条件对象
 * @author Joel
 */
public class VerUpgradeRecordCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VerUpgradeRecordCrieria() {
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
	        
	        
	        public Criteria andidEqualTo(Integer value) {
	            addCriterion("id =", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidNotEqualTo(Integer value) {
	            addCriterion("id <>", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidGreaterThan(Integer value) {
	            addCriterion("id >", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidGreaterThanOrEqualTo(Integer value) {
	            addCriterion("id >=", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidLessThan(Integer value) {
	            addCriterion("id <", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidLessThanOrEqualTo(Integer value) {
	            addCriterion("id <=", value, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidIn(List<Integer> values) {
	            addCriterion("id in", values, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidNotIn(List<Integer> values) {
	            addCriterion("id not in", values, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidBetween(Integer value1, Integer value2) {
	            addCriterion("id between", value1, value2, "id");
	            return (Criteria) this;
	        }

	        public Criteria andidNotBetween(Integer value1, Integer value2) {
	            addCriterion("id not between", value1, value2, "id");
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
	        public Criteria andcarModelIsNull() {
	            addCriterion("car_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelIsNotNull() {
	            addCriterion("car_model is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcarModelEqualTo(Integer value) {
	            addCriterion("car_model =", value, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelNotEqualTo(Integer value) {
	            addCriterion("car_model <>", value, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelGreaterThan(Integer value) {
	            addCriterion("car_model >", value, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelGreaterThanOrEqualTo(Integer value) {
	            addCriterion("car_model >=", value, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelLessThan(Integer value) {
	            addCriterion("car_model <", value, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelLessThanOrEqualTo(Integer value) {
	            addCriterion("car_model <=", value, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelIn(List<Integer> values) {
	            addCriterion("car_model in", values, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelNotIn(List<Integer> values) {
	            addCriterion("car_model not in", values, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelBetween(Integer value1, Integer value2) {
	            addCriterion("car_model between", value1, value2, "carModel");
	            return (Criteria) this;
	        }

	        public Criteria andcarModelNotBetween(Integer value1, Integer value2) {
	            addCriterion("car_model not between", value1, value2, "carModel");
	            return (Criteria) this;
	        }
	        public Criteria andteNumberIsNull() {
	            addCriterion("te_number is null");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberIsNotNull() {
	            addCriterion("te_number is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andteNumberLike(String value) {
	            addCriterion("te_number like", "%"+value+"%", "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberNotLike(String value) {
	            addCriterion("te_number not like", "%"+value+"%", "teNumber");
	            return (Criteria) this;
	        }
	        
	        public Criteria andteNumberEqualTo(String value) {
	            addCriterion("te_number =", value, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberNotEqualTo(String value) {
	            addCriterion("te_number <>", value, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberGreaterThan(String value) {
	            addCriterion("te_number >", value, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberGreaterThanOrEqualTo(String value) {
	            addCriterion("te_number >=", value, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberLessThan(String value) {
	            addCriterion("te_number <", value, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberLessThanOrEqualTo(String value) {
	            addCriterion("te_number <=", value, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberIn(List<String> values) {
	            addCriterion("te_number in", values, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberNotIn(List<String> values) {
	            addCriterion("te_number not in", values, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberBetween(String value1, String value2) {
	            addCriterion("te_number between", value1, value2, "teNumber");
	            return (Criteria) this;
	        }

	        public Criteria andteNumberNotBetween(String value1, String value2) {
	            addCriterion("te_number not between", value1, value2, "teNumber");
	            return (Criteria) this;
	        }
	        public Criteria andteTypeIsNull() {
	            addCriterion("te_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeIsNotNull() {
	            addCriterion("te_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andteTypeEqualTo(Short value) {
	            addCriterion("te_type =", value, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeNotEqualTo(Short value) {
	            addCriterion("te_type <>", value, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeGreaterThan(Short value) {
	            addCriterion("te_type >", value, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("te_type >=", value, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeLessThan(Short value) {
	            addCriterion("te_type <", value, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeLessThanOrEqualTo(Short value) {
	            addCriterion("te_type <=", value, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeIn(List<Short> values) {
	            addCriterion("te_type in", values, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeNotIn(List<Short> values) {
	            addCriterion("te_type not in", values, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeBetween(Short value1, Short value2) {
	            addCriterion("te_type between", value1, value2, "teType");
	            return (Criteria) this;
	        }

	        public Criteria andteTypeNotBetween(Short value1, Short value2) {
	            addCriterion("te_type not between", value1, value2, "teType");
	            return (Criteria) this;
	        }
	        public Criteria andteModelIsNull() {
	            addCriterion("te_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andteModelIsNotNull() {
	            addCriterion("te_model is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andteModelLike(String value) {
	            addCriterion("te_model like", "%"+value+"%", "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelNotLike(String value) {
	            addCriterion("te_model not like", "%"+value+"%", "teModel");
	            return (Criteria) this;
	        }
	        
	        public Criteria andteModelEqualTo(String value) {
	            addCriterion("te_model =", value, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelNotEqualTo(String value) {
	            addCriterion("te_model <>", value, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelGreaterThan(String value) {
	            addCriterion("te_model >", value, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelGreaterThanOrEqualTo(String value) {
	            addCriterion("te_model >=", value, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelLessThan(String value) {
	            addCriterion("te_model <", value, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelLessThanOrEqualTo(String value) {
	            addCriterion("te_model <=", value, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelIn(List<String> values) {
	            addCriterion("te_model in", values, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelNotIn(List<String> values) {
	            addCriterion("te_model not in", values, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelBetween(String value1, String value2) {
	            addCriterion("te_model between", value1, value2, "teModel");
	            return (Criteria) this;
	        }

	        public Criteria andteModelNotBetween(String value1, String value2) {
	            addCriterion("te_model not between", value1, value2, "teModel");
	            return (Criteria) this;
	        }
	        public Criteria andfromVersionIsNull() {
	            addCriterion("from_version is null");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionIsNotNull() {
	            addCriterion("from_version is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andfromVersionEqualTo(Integer value) {
	            addCriterion("from_version =", value, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionNotEqualTo(Integer value) {
	            addCriterion("from_version <>", value, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionGreaterThan(Integer value) {
	            addCriterion("from_version >", value, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionGreaterThanOrEqualTo(Integer value) {
	            addCriterion("from_version >=", value, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionLessThan(Integer value) {
	            addCriterion("from_version <", value, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionLessThanOrEqualTo(Integer value) {
	            addCriterion("from_version <=", value, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionIn(List<Integer> values) {
	            addCriterion("from_version in", values, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionNotIn(List<Integer> values) {
	            addCriterion("from_version not in", values, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionBetween(Integer value1, Integer value2) {
	            addCriterion("from_version between", value1, value2, "fromVersion");
	            return (Criteria) this;
	        }

	        public Criteria andfromVersionNotBetween(Integer value1, Integer value2) {
	            addCriterion("from_version not between", value1, value2, "fromVersion");
	            return (Criteria) this;
	        }
	        public Criteria andfromTypeIsNull() {
	            addCriterion("from_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeIsNotNull() {
	            addCriterion("from_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andfromTypeEqualTo(Short value) {
	            addCriterion("from_type =", value, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeNotEqualTo(Short value) {
	            addCriterion("from_type <>", value, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeGreaterThan(Short value) {
	            addCriterion("from_type >", value, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("from_type >=", value, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeLessThan(Short value) {
	            addCriterion("from_type <", value, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeLessThanOrEqualTo(Short value) {
	            addCriterion("from_type <=", value, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeIn(List<Short> values) {
	            addCriterion("from_type in", values, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeNotIn(List<Short> values) {
	            addCriterion("from_type not in", values, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeBetween(Short value1, Short value2) {
	            addCriterion("from_type between", value1, value2, "fromType");
	            return (Criteria) this;
	        }

	        public Criteria andfromTypeNotBetween(Short value1, Short value2) {
	            addCriterion("from_type not between", value1, value2, "fromType");
	            return (Criteria) this;
	        }
	        public Criteria andtoVersionIsNull() {
	            addCriterion("to_version is null");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionIsNotNull() {
	            addCriterion("to_version is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andtoVersionEqualTo(Integer value) {
	            addCriterion("to_version =", value, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionNotEqualTo(Integer value) {
	            addCriterion("to_version <>", value, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionGreaterThan(Integer value) {
	            addCriterion("to_version >", value, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionGreaterThanOrEqualTo(Integer value) {
	            addCriterion("to_version >=", value, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionLessThan(Integer value) {
	            addCriterion("to_version <", value, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionLessThanOrEqualTo(Integer value) {
	            addCriterion("to_version <=", value, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionIn(List<Integer> values) {
	            addCriterion("to_version in", values, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionNotIn(List<Integer> values) {
	            addCriterion("to_version not in", values, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionBetween(Integer value1, Integer value2) {
	            addCriterion("to_version between", value1, value2, "toVersion");
	            return (Criteria) this;
	        }

	        public Criteria andtoVersionNotBetween(Integer value1, Integer value2) {
	            addCriterion("to_version not between", value1, value2, "toVersion");
	            return (Criteria) this;
	        }
	        public Criteria andstatusIsNull() {
	            addCriterion("status is null");
	            return (Criteria) this;
	        }

	        public Criteria andstatusIsNotNull() {
	            addCriterion("status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andstatusEqualTo(Short value) {
	            addCriterion("status =", value, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusNotEqualTo(Short value) {
	            addCriterion("status <>", value, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusGreaterThan(Short value) {
	            addCriterion("status >", value, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("status >=", value, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusLessThan(Short value) {
	            addCriterion("status <", value, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusLessThanOrEqualTo(Short value) {
	            addCriterion("status <=", value, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusIn(List<Short> values) {
	            addCriterion("status in", values, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusNotIn(List<Short> values) {
	            addCriterion("status not in", values, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusBetween(Short value1, Short value2) {
	            addCriterion("status between", value1, value2, "status");
	            return (Criteria) this;
	        }

	        public Criteria andstatusNotBetween(Short value1, Short value2) {
	            addCriterion("status not between", value1, value2, "status");
	            return (Criteria) this;
	        }
	        public Criteria andaddTimeIsNull() {
	            addCriterion("add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeIsNotNull() {
	            addCriterion("add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andaddTimeEqualTo(Date value) {
	            addCriterion("add_time =", value, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeNotEqualTo(Date value) {
	            addCriterion("add_time <>", value, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeGreaterThan(Date value) {
	            addCriterion("add_time >", value, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("add_time >=", value, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeLessThan(Date value) {
	            addCriterion("add_time <", value, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("add_time <=", value, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeIn(List<Date> values) {
	            addCriterion("add_time in", values, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeNotIn(List<Date> values) {
	            addCriterion("add_time not in", values, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeBetween(Date value1, Date value2) {
	            addCriterion("add_time between", value1, value2, "addTime");
	            return (Criteria) this;
	        }

	        public Criteria andaddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("add_time not between", value1, value2, "addTime");
	            return (Criteria) this;
	        }
	        public Criteria andupdateTimeIsNull() {
	            addCriterion("update_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeIsNotNull() {
	            addCriterion("update_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andupdateTimeEqualTo(Date value) {
	            addCriterion("update_time =", value, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeNotEqualTo(Date value) {
	            addCriterion("update_time <>", value, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeGreaterThan(Date value) {
	            addCriterion("update_time >", value, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("update_time >=", value, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeLessThan(Date value) {
	            addCriterion("update_time <", value, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeLessThanOrEqualTo(Date value) {
	            addCriterion("update_time <=", value, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeIn(List<Date> values) {
	            addCriterion("update_time in", values, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeNotIn(List<Date> values) {
	            addCriterion("update_time not in", values, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeBetween(Date value1, Date value2) {
	            addCriterion("update_time between", value1, value2, "updateTime");
	            return (Criteria) this;
	        }

	        public Criteria andupdateTimeNotBetween(Date value1, Date value2) {
	            addCriterion("update_time not between", value1, value2, "updateTime");
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