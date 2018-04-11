package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车管关系数据查询条件对象
 * @author Joel
 */
public class CsMappingCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsMappingCrieria() {
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
	        public Criteria andcsmCarIsNull() {
	            addCriterion("csm_car is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarIsNotNull() {
	            addCriterion("csm_car is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmCarEqualTo(Integer value) {
	            addCriterion("csm_car =", value, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarNotEqualTo(Integer value) {
	            addCriterion("csm_car <>", value, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarGreaterThan(Integer value) {
	            addCriterion("csm_car >", value, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_car >=", value, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarLessThan(Integer value) {
	            addCriterion("csm_car <", value, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_car <=", value, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarIn(List<Integer> values) {
	            addCriterion("csm_car in", values, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarNotIn(List<Integer> values) {
	            addCriterion("csm_car not in", values, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarBetween(Integer value1, Integer value2) {
	            addCriterion("csm_car between", value1, value2, "csmCar");
	            return (Criteria) this;
	        }

	        public Criteria andcsmCarNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_car not between", value1, value2, "csmCar");
	            return (Criteria) this;
	        }
	        public Criteria andcsmManageIsNull() {
	            addCriterion("csm_manage is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageIsNotNull() {
	            addCriterion("csm_manage is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmManageEqualTo(Integer value) {
	            addCriterion("csm_manage =", value, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageNotEqualTo(Integer value) {
	            addCriterion("csm_manage <>", value, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageGreaterThan(Integer value) {
	            addCriterion("csm_manage >", value, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_manage >=", value, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageLessThan(Integer value) {
	            addCriterion("csm_manage <", value, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_manage <=", value, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageIn(List<Integer> values) {
	            addCriterion("csm_manage in", values, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageNotIn(List<Integer> values) {
	            addCriterion("csm_manage not in", values, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageBetween(Integer value1, Integer value2) {
	            addCriterion("csm_manage between", value1, value2, "csmManage");
	            return (Criteria) this;
	        }

	        public Criteria andcsmManageNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_manage not between", value1, value2, "csmManage");
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