package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 接入车型管理数据查询条件对象
 * @author Joel
 */
public class CsModelCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsModelCrieria() {
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
	        public Criteria andcsmIdIsNull() {
	            addCriterion("csm_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdIsNotNull() {
	            addCriterion("csm_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmIdEqualTo(Integer value) {
	            addCriterion("csm_id =", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdNotEqualTo(Integer value) {
	            addCriterion("csm_id <>", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdGreaterThan(Integer value) {
	            addCriterion("csm_id >", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_id >=", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdLessThan(Integer value) {
	            addCriterion("csm_id <", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_id <=", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdIn(List<Integer> values) {
	            addCriterion("csm_id in", values, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdNotIn(List<Integer> values) {
	            addCriterion("csm_id not in", values, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdBetween(Integer value1, Integer value2) {
	            addCriterion("csm_id between", value1, value2, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_id not between", value1, value2, "csmId");
	            return (Criteria) this;
	        }
	        public Criteria andcsmNameIsNull() {
	            addCriterion("csm_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameIsNotNull() {
	            addCriterion("csm_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmNameLike(String value) {
	            addCriterion("csm_name like", "%"+value+"%", "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameNotLike(String value) {
	            addCriterion("csm_name not like", "%"+value+"%", "csmName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmNameEqualTo(String value) {
	            addCriterion("csm_name =", value, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameNotEqualTo(String value) {
	            addCriterion("csm_name <>", value, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameGreaterThan(String value) {
	            addCriterion("csm_name >", value, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_name >=", value, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameLessThan(String value) {
	            addCriterion("csm_name <", value, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameLessThanOrEqualTo(String value) {
	            addCriterion("csm_name <=", value, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameIn(List<String> values) {
	            addCriterion("csm_name in", values, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameNotIn(List<String> values) {
	            addCriterion("csm_name not in", values, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameBetween(String value1, String value2) {
	            addCriterion("csm_name between", value1, value2, "csmName");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNameNotBetween(String value1, String value2) {
	            addCriterion("csm_name not between", value1, value2, "csmName");
	            return (Criteria) this;
	        }
	        public Criteria andcsmFlagIsNull() {
	            addCriterion("csm_flag is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagIsNotNull() {
	            addCriterion("csm_flag is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmFlagLike(String value) {
	            addCriterion("csm_flag like", "%"+value+"%", "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagNotLike(String value) {
	            addCriterion("csm_flag not like", "%"+value+"%", "csmFlag");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmFlagEqualTo(String value) {
	            addCriterion("csm_flag =", value, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagNotEqualTo(String value) {
	            addCriterion("csm_flag <>", value, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagGreaterThan(String value) {
	            addCriterion("csm_flag >", value, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_flag >=", value, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagLessThan(String value) {
	            addCriterion("csm_flag <", value, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagLessThanOrEqualTo(String value) {
	            addCriterion("csm_flag <=", value, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagIn(List<String> values) {
	            addCriterion("csm_flag in", values, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagNotIn(List<String> values) {
	            addCriterion("csm_flag not in", values, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagBetween(String value1, String value2) {
	            addCriterion("csm_flag between", value1, value2, "csmFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFlagNotBetween(String value1, String value2) {
	            addCriterion("csm_flag not between", value1, value2, "csmFlag");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTypeIsNull() {
	            addCriterion("csm_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeIsNotNull() {
	            addCriterion("csm_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmTypeEqualTo(Short value) {
	            addCriterion("csm_type =", value, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeNotEqualTo(Short value) {
	            addCriterion("csm_type <>", value, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeGreaterThan(Short value) {
	            addCriterion("csm_type >", value, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_type >=", value, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeLessThan(Short value) {
	            addCriterion("csm_type <", value, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeLessThanOrEqualTo(Short value) {
	            addCriterion("csm_type <=", value, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeIn(List<Short> values) {
	            addCriterion("csm_type in", values, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeNotIn(List<Short> values) {
	            addCriterion("csm_type not in", values, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeBetween(Short value1, Short value2) {
	            addCriterion("csm_type between", value1, value2, "csmType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTypeNotBetween(Short value1, Short value2) {
	            addCriterion("csm_type not between", value1, value2, "csmType");
	            return (Criteria) this;
	        }
	        public Criteria andcsmFileIsNull() {
	            addCriterion("csm_file is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileIsNotNull() {
	            addCriterion("csm_file is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmFileEqualTo(Short value) {
	            addCriterion("csm_file =", value, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileNotEqualTo(Short value) {
	            addCriterion("csm_file <>", value, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileGreaterThan(Short value) {
	            addCriterion("csm_file >", value, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_file >=", value, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileLessThan(Short value) {
	            addCriterion("csm_file <", value, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileLessThanOrEqualTo(Short value) {
	            addCriterion("csm_file <=", value, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileIn(List<Short> values) {
	            addCriterion("csm_file in", values, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileNotIn(List<Short> values) {
	            addCriterion("csm_file not in", values, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileBetween(Short value1, Short value2) {
	            addCriterion("csm_file between", value1, value2, "csmFile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFileNotBetween(Short value1, Short value2) {
	            addCriterion("csm_file not between", value1, value2, "csmFile");
	            return (Criteria) this;
	        }
	        public Criteria andcsmCatagoryIsNull() {
	            addCriterion("csm_catagory is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryIsNotNull() {
	            addCriterion("csm_catagory is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmCatagoryEqualTo(Short value) {
	            addCriterion("csm_catagory =", value, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryNotEqualTo(Short value) {
	            addCriterion("csm_catagory <>", value, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryGreaterThan(Short value) {
	            addCriterion("csm_catagory >", value, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_catagory >=", value, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryLessThan(Short value) {
	            addCriterion("csm_catagory <", value, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryLessThanOrEqualTo(Short value) {
	            addCriterion("csm_catagory <=", value, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryIn(List<Short> values) {
	            addCriterion("csm_catagory in", values, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryNotIn(List<Short> values) {
	            addCriterion("csm_catagory not in", values, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryBetween(Short value1, Short value2) {
	            addCriterion("csm_catagory between", value1, value2, "csmCatagory");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCatagoryNotBetween(Short value1, Short value2) {
	            addCriterion("csm_catagory not between", value1, value2, "csmCatagory");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTankCapacityIsNull() {
	            addCriterion("csm_tank_capacity is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityIsNotNull() {
	            addCriterion("csm_tank_capacity is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmTankCapacityEqualTo(Double value) {
	            addCriterion("csm_tank_capacity =", value, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityNotEqualTo(Double value) {
	            addCriterion("csm_tank_capacity <>", value, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityGreaterThan(Double value) {
	            addCriterion("csm_tank_capacity >", value, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityGreaterThanOrEqualTo(Double value) {
	            addCriterion("csm_tank_capacity >=", value, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityLessThan(Double value) {
	            addCriterion("csm_tank_capacity <", value, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityLessThanOrEqualTo(Double value) {
	            addCriterion("csm_tank_capacity <=", value, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityIn(List<Double> values) {
	            addCriterion("csm_tank_capacity in", values, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityNotIn(List<Double> values) {
	            addCriterion("csm_tank_capacity not in", values, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityBetween(Double value1, Double value2) {
	            addCriterion("csm_tank_capacity between", value1, value2, "csmTankCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTankCapacityNotBetween(Double value1, Double value2) {
	            addCriterion("csm_tank_capacity not between", value1, value2, "csmTankCapacity");
	            return (Criteria) this;
	        }
	        public Criteria andcsmBatteryCapacityIsNull() {
	            addCriterion("csm_battery_capacity is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityIsNotNull() {
	            addCriterion("csm_battery_capacity is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmBatteryCapacityEqualTo(Double value) {
	            addCriterion("csm_battery_capacity =", value, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityNotEqualTo(Double value) {
	            addCriterion("csm_battery_capacity <>", value, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityGreaterThan(Double value) {
	            addCriterion("csm_battery_capacity >", value, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityGreaterThanOrEqualTo(Double value) {
	            addCriterion("csm_battery_capacity >=", value, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityLessThan(Double value) {
	            addCriterion("csm_battery_capacity <", value, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityLessThanOrEqualTo(Double value) {
	            addCriterion("csm_battery_capacity <=", value, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityIn(List<Double> values) {
	            addCriterion("csm_battery_capacity in", values, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityNotIn(List<Double> values) {
	            addCriterion("csm_battery_capacity not in", values, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityBetween(Double value1, Double value2) {
	            addCriterion("csm_battery_capacity between", value1, value2, "csmBatteryCapacity");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBatteryCapacityNotBetween(Double value1, Double value2) {
	            addCriterion("csm_battery_capacity not between", value1, value2, "csmBatteryCapacity");
	            return (Criteria) this;
	        }
	        public Criteria andcsmStatusIsNull() {
	            addCriterion("csm_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusIsNotNull() {
	            addCriterion("csm_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmStatusEqualTo(Short value) {
	            addCriterion("csm_status =", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusNotEqualTo(Short value) {
	            addCriterion("csm_status <>", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusGreaterThan(Short value) {
	            addCriterion("csm_status >", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_status >=", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusLessThan(Short value) {
	            addCriterion("csm_status <", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusLessThanOrEqualTo(Short value) {
	            addCriterion("csm_status <=", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusIn(List<Short> values) {
	            addCriterion("csm_status in", values, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusNotIn(List<Short> values) {
	            addCriterion("csm_status not in", values, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusBetween(Short value1, Short value2) {
	            addCriterion("csm_status between", value1, value2, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusNotBetween(Short value1, Short value2) {
	            addCriterion("csm_status not between", value1, value2, "csmStatus");
	            return (Criteria) this;
	        }
	        public Criteria andcsmAddTimeIsNull() {
	            addCriterion("csm_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeIsNotNull() {
	            addCriterion("csm_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmAddTimeEqualTo(Date value) {
	            addCriterion("csm_add_time =", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeNotEqualTo(Date value) {
	            addCriterion("csm_add_time <>", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeGreaterThan(Date value) {
	            addCriterion("csm_add_time >", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csm_add_time >=", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeLessThan(Date value) {
	            addCriterion("csm_add_time <", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csm_add_time <=", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeIn(List<Date> values) {
	            addCriterion("csm_add_time in", values, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeNotIn(List<Date> values) {
	            addCriterion("csm_add_time not in", values, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeBetween(Date value1, Date value2) {
	            addCriterion("csm_add_time between", value1, value2, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csm_add_time not between", value1, value2, "csmAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andcsmUpdateTimeIsNull() {
	            addCriterion("csm_update_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeIsNotNull() {
	            addCriterion("csm_update_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmUpdateTimeEqualTo(Date value) {
	            addCriterion("csm_update_time =", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeNotEqualTo(Date value) {
	            addCriterion("csm_update_time <>", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeGreaterThan(Date value) {
	            addCriterion("csm_update_time >", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csm_update_time >=", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeLessThan(Date value) {
	            addCriterion("csm_update_time <", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csm_update_time <=", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeIn(List<Date> values) {
	            addCriterion("csm_update_time in", values, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeNotIn(List<Date> values) {
	            addCriterion("csm_update_time not in", values, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeBetween(Date value1, Date value2) {
	            addCriterion("csm_update_time between", value1, value2, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csm_update_time not between", value1, value2, "csmUpdateTime");
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