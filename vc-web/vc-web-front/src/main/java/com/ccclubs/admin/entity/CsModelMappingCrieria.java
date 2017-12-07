package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 主机厂用户车型管理数据查询条件对象
 * @author Joel
 */
public class CsModelMappingCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsModelMappingCrieria() {
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
	        public Criteria anduserIdIsNull() {
	            addCriterion("user_id is null");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdIsNotNull() {
	            addCriterion("user_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria anduserIdEqualTo(Integer value) {
	            addCriterion("user_id =", value, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdNotEqualTo(Integer value) {
	            addCriterion("user_id <>", value, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdGreaterThan(Integer value) {
	            addCriterion("user_id >", value, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("user_id >=", value, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdLessThan(Integer value) {
	            addCriterion("user_id <", value, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdLessThanOrEqualTo(Integer value) {
	            addCriterion("user_id <=", value, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdIn(List<Integer> values) {
	            addCriterion("user_id in", values, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdNotIn(List<Integer> values) {
	            addCriterion("user_id not in", values, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdBetween(Integer value1, Integer value2) {
	            addCriterion("user_id between", value1, value2, "userId");
	            return (Criteria) this;
	        }

	        public Criteria anduserIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("user_id not between", value1, value2, "userId");
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
	        public Criteria andremarkIsNull() {
	            addCriterion("remark is null");
	            return (Criteria) this;
	        }

	        public Criteria andremarkIsNotNull() {
	            addCriterion("remark is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andremarkLike(String value) {
	            addCriterion("remark like", "%"+value+"%", "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkNotLike(String value) {
	            addCriterion("remark not like", "%"+value+"%", "remark");
	            return (Criteria) this;
	        }
	        
	        public Criteria andremarkEqualTo(String value) {
	            addCriterion("remark =", value, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkNotEqualTo(String value) {
	            addCriterion("remark <>", value, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkGreaterThan(String value) {
	            addCriterion("remark >", value, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkGreaterThanOrEqualTo(String value) {
	            addCriterion("remark >=", value, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkLessThan(String value) {
	            addCriterion("remark <", value, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkLessThanOrEqualTo(String value) {
	            addCriterion("remark <=", value, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkIn(List<String> values) {
	            addCriterion("remark in", values, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkNotIn(List<String> values) {
	            addCriterion("remark not in", values, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkBetween(String value1, String value2) {
	            addCriterion("remark between", value1, value2, "remark");
	            return (Criteria) this;
	        }

	        public Criteria andremarkNotBetween(String value1, String value2) {
	            addCriterion("remark not between", value1, value2, "remark");
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