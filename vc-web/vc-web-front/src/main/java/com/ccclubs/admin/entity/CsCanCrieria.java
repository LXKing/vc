package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车辆实时CAN信息数据查询条件对象
 * @author Joel
 */
public class CsCanCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsCanCrieria() {
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
	        public Criteria andcscIdIsNull() {
	            addCriterion("csc_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdIsNotNull() {
	            addCriterion("csc_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscIdEqualTo(Long value) {
	            addCriterion("csc_id =", value, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdNotEqualTo(Long value) {
	            addCriterion("csc_id <>", value, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdGreaterThan(Long value) {
	            addCriterion("csc_id >", value, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("csc_id >=", value, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdLessThan(Long value) {
	            addCriterion("csc_id <", value, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdLessThanOrEqualTo(Long value) {
	            addCriterion("csc_id <=", value, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdIn(List<Long> values) {
	            addCriterion("csc_id in", values, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdNotIn(List<Long> values) {
	            addCriterion("csc_id not in", values, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdBetween(Long value1, Long value2) {
	            addCriterion("csc_id between", value1, value2, "cscId");
	            return (Criteria) this;
	        }

	        public Criteria andcscIdNotBetween(Long value1, Long value2) {
	            addCriterion("csc_id not between", value1, value2, "cscId");
	            return (Criteria) this;
	        }
	        public Criteria andcscAccessIsNull() {
	            addCriterion("csc_access is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessIsNotNull() {
	            addCriterion("csc_access is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscAccessEqualTo(Integer value) {
	            addCriterion("csc_access =", value, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessNotEqualTo(Integer value) {
	            addCriterion("csc_access <>", value, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessGreaterThan(Integer value) {
	            addCriterion("csc_access >", value, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csc_access >=", value, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessLessThan(Integer value) {
	            addCriterion("csc_access <", value, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessLessThanOrEqualTo(Integer value) {
	            addCriterion("csc_access <=", value, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessIn(List<Integer> values) {
	            addCriterion("csc_access in", values, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessNotIn(List<Integer> values) {
	            addCriterion("csc_access not in", values, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessBetween(Integer value1, Integer value2) {
	            addCriterion("csc_access between", value1, value2, "cscAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcscAccessNotBetween(Integer value1, Integer value2) {
	            addCriterion("csc_access not between", value1, value2, "cscAccess");
	            return (Criteria) this;
	        }
	        public Criteria andcscNumberIsNull() {
	            addCriterion("csc_number is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberIsNotNull() {
	            addCriterion("csc_number is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcscNumberLike(String value) {
	            addCriterion("csc_number like", "%"+value+"%", "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberNotLike(String value) {
	            addCriterion("csc_number not like", "%"+value+"%", "cscNumber");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcscNumberEqualTo(String value) {
	            addCriterion("csc_number =", value, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberNotEqualTo(String value) {
	            addCriterion("csc_number <>", value, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberGreaterThan(String value) {
	            addCriterion("csc_number >", value, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberGreaterThanOrEqualTo(String value) {
	            addCriterion("csc_number >=", value, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberLessThan(String value) {
	            addCriterion("csc_number <", value, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberLessThanOrEqualTo(String value) {
	            addCriterion("csc_number <=", value, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberIn(List<String> values) {
	            addCriterion("csc_number in", values, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberNotIn(List<String> values) {
	            addCriterion("csc_number not in", values, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberBetween(String value1, String value2) {
	            addCriterion("csc_number between", value1, value2, "cscNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcscNumberNotBetween(String value1, String value2) {
	            addCriterion("csc_number not between", value1, value2, "cscNumber");
	            return (Criteria) this;
	        }
	        public Criteria andcscCarIsNull() {
	            addCriterion("csc_car is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarIsNotNull() {
	            addCriterion("csc_car is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscCarEqualTo(Integer value) {
	            addCriterion("csc_car =", value, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarNotEqualTo(Integer value) {
	            addCriterion("csc_car <>", value, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarGreaterThan(Integer value) {
	            addCriterion("csc_car >", value, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csc_car >=", value, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarLessThan(Integer value) {
	            addCriterion("csc_car <", value, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarLessThanOrEqualTo(Integer value) {
	            addCriterion("csc_car <=", value, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarIn(List<Integer> values) {
	            addCriterion("csc_car in", values, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarNotIn(List<Integer> values) {
	            addCriterion("csc_car not in", values, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarBetween(Integer value1, Integer value2) {
	            addCriterion("csc_car between", value1, value2, "cscCar");
	            return (Criteria) this;
	        }

	        public Criteria andcscCarNotBetween(Integer value1, Integer value2) {
	            addCriterion("csc_car not between", value1, value2, "cscCar");
	            return (Criteria) this;
	        }
	        public Criteria andcscModelIsNull() {
	            addCriterion("csc_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelIsNotNull() {
	            addCriterion("csc_model is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscModelEqualTo(Short value) {
	            addCriterion("csc_model =", value, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelNotEqualTo(Short value) {
	            addCriterion("csc_model <>", value, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelGreaterThan(Short value) {
	            addCriterion("csc_model >", value, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelGreaterThanOrEqualTo(Short value) {
	            addCriterion("csc_model >=", value, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelLessThan(Short value) {
	            addCriterion("csc_model <", value, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelLessThanOrEqualTo(Short value) {
	            addCriterion("csc_model <=", value, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelIn(List<Short> values) {
	            addCriterion("csc_model in", values, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelNotIn(List<Short> values) {
	            addCriterion("csc_model not in", values, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelBetween(Short value1, Short value2) {
	            addCriterion("csc_model between", value1, value2, "cscModel");
	            return (Criteria) this;
	        }

	        public Criteria andcscModelNotBetween(Short value1, Short value2) {
	            addCriterion("csc_model not between", value1, value2, "cscModel");
	            return (Criteria) this;
	        }
	        public Criteria andcscTypeIsNull() {
	            addCriterion("csc_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeIsNotNull() {
	            addCriterion("csc_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscTypeEqualTo(Short value) {
	            addCriterion("csc_type =", value, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeNotEqualTo(Short value) {
	            addCriterion("csc_type <>", value, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeGreaterThan(Short value) {
	            addCriterion("csc_type >", value, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("csc_type >=", value, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeLessThan(Short value) {
	            addCriterion("csc_type <", value, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeLessThanOrEqualTo(Short value) {
	            addCriterion("csc_type <=", value, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeIn(List<Short> values) {
	            addCriterion("csc_type in", values, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeNotIn(List<Short> values) {
	            addCriterion("csc_type not in", values, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeBetween(Short value1, Short value2) {
	            addCriterion("csc_type between", value1, value2, "cscType");
	            return (Criteria) this;
	        }

	        public Criteria andcscTypeNotBetween(Short value1, Short value2) {
	            addCriterion("csc_type not between", value1, value2, "cscType");
	            return (Criteria) this;
	        }
	        public Criteria andcscOrderIsNull() {
	            addCriterion("csc_order is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderIsNotNull() {
	            addCriterion("csc_order is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscOrderEqualTo(Long value) {
	            addCriterion("csc_order =", value, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderNotEqualTo(Long value) {
	            addCriterion("csc_order <>", value, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderGreaterThan(Long value) {
	            addCriterion("csc_order >", value, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderGreaterThanOrEqualTo(Long value) {
	            addCriterion("csc_order >=", value, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderLessThan(Long value) {
	            addCriterion("csc_order <", value, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderLessThanOrEqualTo(Long value) {
	            addCriterion("csc_order <=", value, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderIn(List<Long> values) {
	            addCriterion("csc_order in", values, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderNotIn(List<Long> values) {
	            addCriterion("csc_order not in", values, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderBetween(Long value1, Long value2) {
	            addCriterion("csc_order between", value1, value2, "cscOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcscOrderNotBetween(Long value1, Long value2) {
	            addCriterion("csc_order not between", value1, value2, "cscOrder");
	            return (Criteria) this;
	        }
	        public Criteria andcscDataIsNull() {
	            addCriterion("csc_data is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataIsNotNull() {
	            addCriterion("csc_data is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcscDataLike(String value) {
	            addCriterion("csc_data like", "%"+value+"%", "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataNotLike(String value) {
	            addCriterion("csc_data not like", "%"+value+"%", "cscData");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcscDataEqualTo(String value) {
	            addCriterion("csc_data =", value, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataNotEqualTo(String value) {
	            addCriterion("csc_data <>", value, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataGreaterThan(String value) {
	            addCriterion("csc_data >", value, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataGreaterThanOrEqualTo(String value) {
	            addCriterion("csc_data >=", value, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataLessThan(String value) {
	            addCriterion("csc_data <", value, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataLessThanOrEqualTo(String value) {
	            addCriterion("csc_data <=", value, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataIn(List<String> values) {
	            addCriterion("csc_data in", values, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataNotIn(List<String> values) {
	            addCriterion("csc_data not in", values, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataBetween(String value1, String value2) {
	            addCriterion("csc_data between", value1, value2, "cscData");
	            return (Criteria) this;
	        }

	        public Criteria andcscDataNotBetween(String value1, String value2) {
	            addCriterion("csc_data not between", value1, value2, "cscData");
	            return (Criteria) this;
	        }
	        public Criteria andcscUploadTimeIsNull() {
	            addCriterion("csc_upload_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeIsNotNull() {
	            addCriterion("csc_upload_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscUploadTimeEqualTo(Date value) {
	            addCriterion("csc_upload_time =", value, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeNotEqualTo(Date value) {
	            addCriterion("csc_upload_time <>", value, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeGreaterThan(Date value) {
	            addCriterion("csc_upload_time >", value, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csc_upload_time >=", value, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeLessThan(Date value) {
	            addCriterion("csc_upload_time <", value, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csc_upload_time <=", value, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeIn(List<Date> values) {
	            addCriterion("csc_upload_time in", values, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeNotIn(List<Date> values) {
	            addCriterion("csc_upload_time not in", values, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeBetween(Date value1, Date value2) {
	            addCriterion("csc_upload_time between", value1, value2, "cscUploadTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscUploadTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csc_upload_time not between", value1, value2, "cscUploadTime");
	            return (Criteria) this;
	        }
	        public Criteria andcscAddTimeIsNull() {
	            addCriterion("csc_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeIsNotNull() {
	            addCriterion("csc_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscAddTimeEqualTo(Date value) {
	            addCriterion("csc_add_time =", value, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeNotEqualTo(Date value) {
	            addCriterion("csc_add_time <>", value, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeGreaterThan(Date value) {
	            addCriterion("csc_add_time >", value, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csc_add_time >=", value, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeLessThan(Date value) {
	            addCriterion("csc_add_time <", value, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csc_add_time <=", value, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeIn(List<Date> values) {
	            addCriterion("csc_add_time in", values, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeNotIn(List<Date> values) {
	            addCriterion("csc_add_time not in", values, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeBetween(Date value1, Date value2) {
	            addCriterion("csc_add_time between", value1, value2, "cscAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcscAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csc_add_time not between", value1, value2, "cscAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andcscStatusIsNull() {
	            addCriterion("csc_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusIsNotNull() {
	            addCriterion("csc_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcscStatusEqualTo(Short value) {
	            addCriterion("csc_status =", value, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusNotEqualTo(Short value) {
	            addCriterion("csc_status <>", value, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusGreaterThan(Short value) {
	            addCriterion("csc_status >", value, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("csc_status >=", value, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusLessThan(Short value) {
	            addCriterion("csc_status <", value, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusLessThanOrEqualTo(Short value) {
	            addCriterion("csc_status <=", value, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusIn(List<Short> values) {
	            addCriterion("csc_status in", values, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusNotIn(List<Short> values) {
	            addCriterion("csc_status not in", values, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusBetween(Short value1, Short value2) {
	            addCriterion("csc_status between", value1, value2, "cscStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcscStatusNotBetween(Short value1, Short value2) {
	            addCriterion("csc_status not between", value1, value2, "cscStatus");
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