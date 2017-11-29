package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车辆信息管理数据查询条件对象
 * @author Joel
 */
public class CsVehicleCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsVehicleCrieria() {
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
	        public Criteria andcsvIdIsNull() {
	            addCriterion("csv_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdIsNotNull() {
	            addCriterion("csv_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvIdEqualTo(Integer value) {
	            addCriterion("csv_id =", value, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdNotEqualTo(Integer value) {
	            addCriterion("csv_id <>", value, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdGreaterThan(Integer value) {
	            addCriterion("csv_id >", value, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csv_id >=", value, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdLessThan(Integer value) {
	            addCriterion("csv_id <", value, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdLessThanOrEqualTo(Integer value) {
	            addCriterion("csv_id <=", value, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdIn(List<Integer> values) {
	            addCriterion("csv_id in", values, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdNotIn(List<Integer> values) {
	            addCriterion("csv_id not in", values, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdBetween(Integer value1, Integer value2) {
	            addCriterion("csv_id between", value1, value2, "csvId");
	            return (Criteria) this;
	        }

	        public Criteria andcsvIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("csv_id not between", value1, value2, "csvId");
	            return (Criteria) this;
	        }
	        public Criteria andcsvAccessIsNull() {
	            addCriterion("csv_access is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessIsNotNull() {
	            addCriterion("csv_access is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvAccessEqualTo(Integer value) {
	            addCriterion("csv_access =", value, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessNotEqualTo(Integer value) {
	            addCriterion("csv_access <>", value, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessGreaterThan(Integer value) {
	            addCriterion("csv_access >", value, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csv_access >=", value, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessLessThan(Integer value) {
	            addCriterion("csv_access <", value, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessLessThanOrEqualTo(Integer value) {
	            addCriterion("csv_access <=", value, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessIn(List<Integer> values) {
	            addCriterion("csv_access in", values, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessNotIn(List<Integer> values) {
	            addCriterion("csv_access not in", values, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessBetween(Integer value1, Integer value2) {
	            addCriterion("csv_access between", value1, value2, "csvAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAccessNotBetween(Integer value1, Integer value2) {
	            addCriterion("csv_access not between", value1, value2, "csvAccess");
	            return (Criteria) this;
	        }
	        public Criteria andcsvCarNoIsNull() {
	            addCriterion("csv_car_no is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoIsNotNull() {
	            addCriterion("csv_car_no is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvCarNoLike(String value) {
	            addCriterion("csv_car_no like", "%"+value+"%", "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoNotLike(String value) {
	            addCriterion("csv_car_no not like", "%"+value+"%", "csvCarNo");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvCarNoEqualTo(String value) {
	            addCriterion("csv_car_no =", value, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoNotEqualTo(String value) {
	            addCriterion("csv_car_no <>", value, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoGreaterThan(String value) {
	            addCriterion("csv_car_no >", value, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoGreaterThanOrEqualTo(String value) {
	            addCriterion("csv_car_no >=", value, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoLessThan(String value) {
	            addCriterion("csv_car_no <", value, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoLessThanOrEqualTo(String value) {
	            addCriterion("csv_car_no <=", value, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoIn(List<String> values) {
	            addCriterion("csv_car_no in", values, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoNotIn(List<String> values) {
	            addCriterion("csv_car_no not in", values, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoBetween(String value1, String value2) {
	            addCriterion("csv_car_no between", value1, value2, "csvCarNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCarNoNotBetween(String value1, String value2) {
	            addCriterion("csv_car_no not between", value1, value2, "csvCarNo");
	            return (Criteria) this;
	        }
	        public Criteria andcsvVinIsNull() {
	            addCriterion("csv_vin is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinIsNotNull() {
	            addCriterion("csv_vin is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvVinLike(String value) {
	            addCriterion("csv_vin like", "%"+value+"%", "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinNotLike(String value) {
	            addCriterion("csv_vin not like", "%"+value+"%", "csvVin");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvVinEqualTo(String value) {
	            addCriterion("csv_vin =", value, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinNotEqualTo(String value) {
	            addCriterion("csv_vin <>", value, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinGreaterThan(String value) {
	            addCriterion("csv_vin >", value, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinGreaterThanOrEqualTo(String value) {
	            addCriterion("csv_vin >=", value, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinLessThan(String value) {
	            addCriterion("csv_vin <", value, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinLessThanOrEqualTo(String value) {
	            addCriterion("csv_vin <=", value, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinIn(List<String> values) {
	            addCriterion("csv_vin in", values, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinNotIn(List<String> values) {
	            addCriterion("csv_vin not in", values, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinBetween(String value1, String value2) {
	            addCriterion("csv_vin between", value1, value2, "csvVin");
	            return (Criteria) this;
	        }

	        public Criteria andcsvVinNotBetween(String value1, String value2) {
	            addCriterion("csv_vin not between", value1, value2, "csvVin");
	            return (Criteria) this;
	        }
	        public Criteria andcsvEngineNoIsNull() {
	            addCriterion("csv_engine_no is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoIsNotNull() {
	            addCriterion("csv_engine_no is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvEngineNoLike(String value) {
	            addCriterion("csv_engine_no like", "%"+value+"%", "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoNotLike(String value) {
	            addCriterion("csv_engine_no not like", "%"+value+"%", "csvEngineNo");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvEngineNoEqualTo(String value) {
	            addCriterion("csv_engine_no =", value, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoNotEqualTo(String value) {
	            addCriterion("csv_engine_no <>", value, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoGreaterThan(String value) {
	            addCriterion("csv_engine_no >", value, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoGreaterThanOrEqualTo(String value) {
	            addCriterion("csv_engine_no >=", value, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoLessThan(String value) {
	            addCriterion("csv_engine_no <", value, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoLessThanOrEqualTo(String value) {
	            addCriterion("csv_engine_no <=", value, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoIn(List<String> values) {
	            addCriterion("csv_engine_no in", values, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoNotIn(List<String> values) {
	            addCriterion("csv_engine_no not in", values, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoBetween(String value1, String value2) {
	            addCriterion("csv_engine_no between", value1, value2, "csvEngineNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsvEngineNoNotBetween(String value1, String value2) {
	            addCriterion("csv_engine_no not between", value1, value2, "csvEngineNo");
	            return (Criteria) this;
	        }
	        public Criteria andcsvCertificIsNull() {
	            addCriterion("csv_certific is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificIsNotNull() {
	            addCriterion("csv_certific is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvCertificLike(String value) {
	            addCriterion("csv_certific like", "%"+value+"%", "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificNotLike(String value) {
	            addCriterion("csv_certific not like", "%"+value+"%", "csvCertific");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvCertificEqualTo(String value) {
	            addCriterion("csv_certific =", value, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificNotEqualTo(String value) {
	            addCriterion("csv_certific <>", value, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificGreaterThan(String value) {
	            addCriterion("csv_certific >", value, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificGreaterThanOrEqualTo(String value) {
	            addCriterion("csv_certific >=", value, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificLessThan(String value) {
	            addCriterion("csv_certific <", value, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificLessThanOrEqualTo(String value) {
	            addCriterion("csv_certific <=", value, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificIn(List<String> values) {
	            addCriterion("csv_certific in", values, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificNotIn(List<String> values) {
	            addCriterion("csv_certific not in", values, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificBetween(String value1, String value2) {
	            addCriterion("csv_certific between", value1, value2, "csvCertific");
	            return (Criteria) this;
	        }

	        public Criteria andcsvCertificNotBetween(String value1, String value2) {
	            addCriterion("csv_certific not between", value1, value2, "csvCertific");
	            return (Criteria) this;
	        }
	        public Criteria andcsvColorIsNull() {
	            addCriterion("csv_color is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorIsNotNull() {
	            addCriterion("csv_color is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvColorEqualTo(Short value) {
	            addCriterion("csv_color =", value, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorNotEqualTo(Short value) {
	            addCriterion("csv_color <>", value, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorGreaterThan(Short value) {
	            addCriterion("csv_color >", value, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorGreaterThanOrEqualTo(Short value) {
	            addCriterion("csv_color >=", value, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorLessThan(Short value) {
	            addCriterion("csv_color <", value, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorLessThanOrEqualTo(Short value) {
	            addCriterion("csv_color <=", value, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorIn(List<Short> values) {
	            addCriterion("csv_color in", values, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorNotIn(List<Short> values) {
	            addCriterion("csv_color not in", values, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorBetween(Short value1, Short value2) {
	            addCriterion("csv_color between", value1, value2, "csvColor");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorNotBetween(Short value1, Short value2) {
	            addCriterion("csv_color not between", value1, value2, "csvColor");
	            return (Criteria) this;
	        }
	        public Criteria andcsvModelIsNull() {
	            addCriterion("csv_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelIsNotNull() {
	            addCriterion("csv_model is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvModelEqualTo(Integer value) {
	            addCriterion("csv_model =", value, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelNotEqualTo(Integer value) {
	            addCriterion("csv_model <>", value, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelGreaterThan(Integer value) {
	            addCriterion("csv_model >", value, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csv_model >=", value, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelLessThan(Integer value) {
	            addCriterion("csv_model <", value, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelLessThanOrEqualTo(Integer value) {
	            addCriterion("csv_model <=", value, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelIn(List<Integer> values) {
	            addCriterion("csv_model in", values, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelNotIn(List<Integer> values) {
	            addCriterion("csv_model not in", values, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelBetween(Integer value1, Integer value2) {
	            addCriterion("csv_model between", value1, value2, "csvModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsvModelNotBetween(Integer value1, Integer value2) {
	            addCriterion("csv_model not between", value1, value2, "csvModel");
	            return (Criteria) this;
	        }
	        public Criteria andcsvMachineIsNull() {
	            addCriterion("csv_machine is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineIsNotNull() {
	            addCriterion("csv_machine is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvMachineEqualTo(Integer value) {
	            addCriterion("csv_machine =", value, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineNotEqualTo(Integer value) {
	            addCriterion("csv_machine <>", value, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineGreaterThan(Integer value) {
	            addCriterion("csv_machine >", value, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csv_machine >=", value, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineLessThan(Integer value) {
	            addCriterion("csv_machine <", value, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineLessThanOrEqualTo(Integer value) {
	            addCriterion("csv_machine <=", value, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineIn(List<Integer> values) {
	            addCriterion("csv_machine in", values, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineNotIn(List<Integer> values) {
	            addCriterion("csv_machine not in", values, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineBetween(Integer value1, Integer value2) {
	            addCriterion("csv_machine between", value1, value2, "csvMachine");
	            return (Criteria) this;
	        }

	        public Criteria andcsvMachineNotBetween(Integer value1, Integer value2) {
	            addCriterion("csv_machine not between", value1, value2, "csvMachine");
	            return (Criteria) this;
	        }
	        public Criteria andcsvColorCodeIsNull() {
	            addCriterion("csv_color_code is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeIsNotNull() {
	            addCriterion("csv_color_code is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvColorCodeEqualTo(Short value) {
	            addCriterion("csv_color_code =", value, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeNotEqualTo(Short value) {
	            addCriterion("csv_color_code <>", value, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeGreaterThan(Short value) {
	            addCriterion("csv_color_code >", value, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeGreaterThanOrEqualTo(Short value) {
	            addCriterion("csv_color_code >=", value, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeLessThan(Short value) {
	            addCriterion("csv_color_code <", value, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeLessThanOrEqualTo(Short value) {
	            addCriterion("csv_color_code <=", value, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeIn(List<Short> values) {
	            addCriterion("csv_color_code in", values, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeNotIn(List<Short> values) {
	            addCriterion("csv_color_code not in", values, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeBetween(Short value1, Short value2) {
	            addCriterion("csv_color_code between", value1, value2, "csvColorCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvColorCodeNotBetween(Short value1, Short value2) {
	            addCriterion("csv_color_code not between", value1, value2, "csvColorCode");
	            return (Criteria) this;
	        }
	        public Criteria andcsvBataccuCodeIsNull() {
	            addCriterion("csv_bataccu_code is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeIsNotNull() {
	            addCriterion("csv_bataccu_code is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvBataccuCodeLike(String value) {
	            addCriterion("csv_bataccu_code like", "%"+value+"%", "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeNotLike(String value) {
	            addCriterion("csv_bataccu_code not like", "%"+value+"%", "csvBataccuCode");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvBataccuCodeEqualTo(String value) {
	            addCriterion("csv_bataccu_code =", value, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeNotEqualTo(String value) {
	            addCriterion("csv_bataccu_code <>", value, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeGreaterThan(String value) {
	            addCriterion("csv_bataccu_code >", value, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeGreaterThanOrEqualTo(String value) {
	            addCriterion("csv_bataccu_code >=", value, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeLessThan(String value) {
	            addCriterion("csv_bataccu_code <", value, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeLessThanOrEqualTo(String value) {
	            addCriterion("csv_bataccu_code <=", value, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeIn(List<String> values) {
	            addCriterion("csv_bataccu_code in", values, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeNotIn(List<String> values) {
	            addCriterion("csv_bataccu_code not in", values, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeBetween(String value1, String value2) {
	            addCriterion("csv_bataccu_code between", value1, value2, "csvBataccuCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsvBataccuCodeNotBetween(String value1, String value2) {
	            addCriterion("csv_bataccu_code not between", value1, value2, "csvBataccuCode");
	            return (Criteria) this;
	        }
	        public Criteria andcsvProdDateIsNull() {
	            addCriterion("csv_prod_date is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateIsNotNull() {
	            addCriterion("csv_prod_date is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvProdDateEqualTo(Date value) {
	            addCriterion("csv_prod_date =", value, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateNotEqualTo(Date value) {
	            addCriterion("csv_prod_date <>", value, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateGreaterThan(Date value) {
	            addCriterion("csv_prod_date >", value, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateGreaterThanOrEqualTo(Date value) {
	            addCriterion("csv_prod_date >=", value, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateLessThan(Date value) {
	            addCriterion("csv_prod_date <", value, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateLessThanOrEqualTo(Date value) {
	            addCriterion("csv_prod_date <=", value, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateIn(List<Date> values) {
	            addCriterion("csv_prod_date in", values, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateNotIn(List<Date> values) {
	            addCriterion("csv_prod_date not in", values, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateBetween(Date value1, Date value2) {
	            addCriterion("csv_prod_date between", value1, value2, "csvProdDate");
	            return (Criteria) this;
	        }

	        public Criteria andcsvProdDateNotBetween(Date value1, Date value2) {
	            addCriterion("csv_prod_date not between", value1, value2, "csvProdDate");
	            return (Criteria) this;
	        }
	        public Criteria andcsvLandmarkIsNull() {
	            addCriterion("csv_landmark is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkIsNotNull() {
	            addCriterion("csv_landmark is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvLandmarkLike(String value) {
	            addCriterion("csv_landmark like", "%"+value+"%", "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkNotLike(String value) {
	            addCriterion("csv_landmark not like", "%"+value+"%", "csvLandmark");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsvLandmarkEqualTo(String value) {
	            addCriterion("csv_landmark =", value, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkNotEqualTo(String value) {
	            addCriterion("csv_landmark <>", value, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkGreaterThan(String value) {
	            addCriterion("csv_landmark >", value, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkGreaterThanOrEqualTo(String value) {
	            addCriterion("csv_landmark >=", value, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkLessThan(String value) {
	            addCriterion("csv_landmark <", value, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkLessThanOrEqualTo(String value) {
	            addCriterion("csv_landmark <=", value, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkIn(List<String> values) {
	            addCriterion("csv_landmark in", values, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkNotIn(List<String> values) {
	            addCriterion("csv_landmark not in", values, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkBetween(String value1, String value2) {
	            addCriterion("csv_landmark between", value1, value2, "csvLandmark");
	            return (Criteria) this;
	        }

	        public Criteria andcsvLandmarkNotBetween(String value1, String value2) {
	            addCriterion("csv_landmark not between", value1, value2, "csvLandmark");
	            return (Criteria) this;
	        }
	        public Criteria andcsvStatusIsNull() {
	            addCriterion("csv_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusIsNotNull() {
	            addCriterion("csv_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvStatusEqualTo(Short value) {
	            addCriterion("csv_status =", value, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusNotEqualTo(Short value) {
	            addCriterion("csv_status <>", value, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusGreaterThan(Short value) {
	            addCriterion("csv_status >", value, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("csv_status >=", value, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusLessThan(Short value) {
	            addCriterion("csv_status <", value, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusLessThanOrEqualTo(Short value) {
	            addCriterion("csv_status <=", value, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusIn(List<Short> values) {
	            addCriterion("csv_status in", values, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusNotIn(List<Short> values) {
	            addCriterion("csv_status not in", values, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusBetween(Short value1, Short value2) {
	            addCriterion("csv_status between", value1, value2, "csvStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsvStatusNotBetween(Short value1, Short value2) {
	            addCriterion("csv_status not between", value1, value2, "csvStatus");
	            return (Criteria) this;
	        }
	        public Criteria andcsvAddTimeIsNull() {
	            addCriterion("csv_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeIsNotNull() {
	            addCriterion("csv_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvAddTimeEqualTo(Date value) {
	            addCriterion("csv_add_time =", value, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeNotEqualTo(Date value) {
	            addCriterion("csv_add_time <>", value, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeGreaterThan(Date value) {
	            addCriterion("csv_add_time >", value, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csv_add_time >=", value, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeLessThan(Date value) {
	            addCriterion("csv_add_time <", value, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csv_add_time <=", value, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeIn(List<Date> values) {
	            addCriterion("csv_add_time in", values, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeNotIn(List<Date> values) {
	            addCriterion("csv_add_time not in", values, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeBetween(Date value1, Date value2) {
	            addCriterion("csv_add_time between", value1, value2, "csvAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csv_add_time not between", value1, value2, "csvAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andcsvUpdateTimeIsNull() {
	            addCriterion("csv_update_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeIsNotNull() {
	            addCriterion("csv_update_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsvUpdateTimeEqualTo(Date value) {
	            addCriterion("csv_update_time =", value, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeNotEqualTo(Date value) {
	            addCriterion("csv_update_time <>", value, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeGreaterThan(Date value) {
	            addCriterion("csv_update_time >", value, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csv_update_time >=", value, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeLessThan(Date value) {
	            addCriterion("csv_update_time <", value, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csv_update_time <=", value, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeIn(List<Date> values) {
	            addCriterion("csv_update_time in", values, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeNotIn(List<Date> values) {
	            addCriterion("csv_update_time not in", values, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeBetween(Date value1, Date value2) {
	            addCriterion("csv_update_time between", value1, value2, "csvUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsvUpdateTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csv_update_time not between", value1, value2, "csvUpdateTime");
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