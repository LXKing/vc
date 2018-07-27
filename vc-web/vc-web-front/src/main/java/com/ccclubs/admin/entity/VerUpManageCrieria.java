package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车机升级管理数据查询条件对象
 * @author Joel
 */
public class VerUpManageCrieria {
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VerUpManageCrieria() {
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
	        public Criteria andstatusUpgradeIsNull() {
	            addCriterion("status_upgrade is null");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeIsNotNull() {
	            addCriterion("status_upgrade is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andstatusUpgradeEqualTo(Integer value) {
	            addCriterion("status_upgrade =", value, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeNotEqualTo(Integer value) {
	            addCriterion("status_upgrade <>", value, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeGreaterThan(Integer value) {
	            addCriterion("status_upgrade >", value, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeGreaterThanOrEqualTo(Integer value) {
	            addCriterion("status_upgrade >=", value, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeLessThan(Integer value) {
	            addCriterion("status_upgrade <", value, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeLessThanOrEqualTo(Integer value) {
	            addCriterion("status_upgrade <=", value, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeIn(List<Integer> values) {
	            addCriterion("status_upgrade in", values, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeNotIn(List<Integer> values) {
	            addCriterion("status_upgrade not in", values, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeBetween(Integer value1, Integer value2) {
	            addCriterion("status_upgrade between", value1, value2, "statusUpgrade");
	            return (Criteria) this;
	        }

	        public Criteria andstatusUpgradeNotBetween(Integer value1, Integer value2) {
	            addCriterion("status_upgrade not between", value1, value2, "statusUpgrade");
	            return (Criteria) this;
	        }
	        public Criteria andverCurIdIsNull() {
	            addCriterion("ver_cur_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdIsNotNull() {
	            addCriterion("ver_cur_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andverCurIdEqualTo(Integer value) {
	            addCriterion("ver_cur_id =", value, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdNotEqualTo(Integer value) {
	            addCriterion("ver_cur_id <>", value, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdGreaterThan(Integer value) {
	            addCriterion("ver_cur_id >", value, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("ver_cur_id >=", value, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdLessThan(Integer value) {
	            addCriterion("ver_cur_id <", value, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdLessThanOrEqualTo(Integer value) {
	            addCriterion("ver_cur_id <=", value, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdIn(List<Integer> values) {
	            addCriterion("ver_cur_id in", values, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdNotIn(List<Integer> values) {
	            addCriterion("ver_cur_id not in", values, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdBetween(Integer value1, Integer value2) {
	            addCriterion("ver_cur_id between", value1, value2, "verCurId");
	            return (Criteria) this;
	        }

	        public Criteria andverCurIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("ver_cur_id not between", value1, value2, "verCurId");
	            return (Criteria) this;
	        }
	        public Criteria andmodelIdIsNull() {
	            addCriterion("model_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdIsNotNull() {
	            addCriterion("model_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andmodelIdEqualTo(Integer value) {
	            addCriterion("model_id =", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdNotEqualTo(Integer value) {
	            addCriterion("model_id <>", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdGreaterThan(Integer value) {
	            addCriterion("model_id >", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("model_id >=", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdLessThan(Integer value) {
	            addCriterion("model_id <", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdLessThanOrEqualTo(Integer value) {
	            addCriterion("model_id <=", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdIn(List<Integer> values) {
	            addCriterion("model_id in", values, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdNotIn(List<Integer> values) {
	            addCriterion("model_id not in", values, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdBetween(Integer value1, Integer value2) {
	            addCriterion("model_id between", value1, value2, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("model_id not between", value1, value2, "modelId");
	            return (Criteria) this;
	        }
	        public Criteria andvehicleIdIsNull() {
	            addCriterion("vehicle_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdIsNotNull() {
	            addCriterion("vehicle_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andvehicleIdEqualTo(Integer value) {
	            addCriterion("vehicle_id =", value, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdNotEqualTo(Integer value) {
	            addCriterion("vehicle_id <>", value, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdGreaterThan(Integer value) {
	            addCriterion("vehicle_id >", value, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("vehicle_id >=", value, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdLessThan(Integer value) {
	            addCriterion("vehicle_id <", value, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdLessThanOrEqualTo(Integer value) {
	            addCriterion("vehicle_id <=", value, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdIn(List<Integer> values) {
	            addCriterion("vehicle_id in", values, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdNotIn(List<Integer> values) {
	            addCriterion("vehicle_id not in", values, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdBetween(Integer value1, Integer value2) {
	            addCriterion("vehicle_id between", value1, value2, "vehicleId");
	            return (Criteria) this;
	        }

	        public Criteria andvehicleIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("vehicle_id not between", value1, value2, "vehicleId");
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