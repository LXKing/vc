package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 版本模块关系数据查询条件对象
 * @author Joel
 */
public class VerModuleRelationCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VerModuleRelationCrieria() {
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
	        public Criteria andverIdIsNull() {
	            addCriterion("ver_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andverIdIsNotNull() {
	            addCriterion("ver_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andverIdEqualTo(Integer value) {
	            addCriterion("ver_id =", value, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdNotEqualTo(Integer value) {
	            addCriterion("ver_id <>", value, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdGreaterThan(Integer value) {
	            addCriterion("ver_id >", value, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("ver_id >=", value, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdLessThan(Integer value) {
	            addCriterion("ver_id <", value, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdLessThanOrEqualTo(Integer value) {
	            addCriterion("ver_id <=", value, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdIn(List<Integer> values) {
	            addCriterion("ver_id in", values, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdNotIn(List<Integer> values) {
	            addCriterion("ver_id not in", values, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdBetween(Integer value1, Integer value2) {
	            addCriterion("ver_id between", value1, value2, "verId");
	            return (Criteria) this;
	        }

	        public Criteria andverIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("ver_id not between", value1, value2, "verId");
	            return (Criteria) this;
	        }
	        public Criteria andmoduleIdIsNull() {
	            addCriterion("module_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdIsNotNull() {
	            addCriterion("module_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andmoduleIdEqualTo(Integer value) {
	            addCriterion("module_id =", value, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdNotEqualTo(Integer value) {
	            addCriterion("module_id <>", value, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdGreaterThan(Integer value) {
	            addCriterion("module_id >", value, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("module_id >=", value, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdLessThan(Integer value) {
	            addCriterion("module_id <", value, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdLessThanOrEqualTo(Integer value) {
	            addCriterion("module_id <=", value, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdIn(List<Integer> values) {
	            addCriterion("module_id in", values, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdNotIn(List<Integer> values) {
	            addCriterion("module_id not in", values, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdBetween(Integer value1, Integer value2) {
	            addCriterion("module_id between", value1, value2, "moduleId");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("module_id not between", value1, value2, "moduleId");
	            return (Criteria) this;
	        }
	        public Criteria andmoduleValIsNull() {
	            addCriterion("module_val is null");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValIsNotNull() {
	            addCriterion("module_val is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andmoduleValLike(String value) {
	            addCriterion("module_val like", "%"+value+"%", "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValNotLike(String value) {
	            addCriterion("module_val not like", "%"+value+"%", "moduleVal");
	            return (Criteria) this;
	        }
	        
	        public Criteria andmoduleValEqualTo(String value) {
	            addCriterion("module_val =", value, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValNotEqualTo(String value) {
	            addCriterion("module_val <>", value, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValGreaterThan(String value) {
	            addCriterion("module_val >", value, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValGreaterThanOrEqualTo(String value) {
	            addCriterion("module_val >=", value, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValLessThan(String value) {
	            addCriterion("module_val <", value, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValLessThanOrEqualTo(String value) {
	            addCriterion("module_val <=", value, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValIn(List<String> values) {
	            addCriterion("module_val in", values, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValNotIn(List<String> values) {
	            addCriterion("module_val not in", values, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValBetween(String value1, String value2) {
	            addCriterion("module_val between", value1, value2, "moduleVal");
	            return (Criteria) this;
	        }

	        public Criteria andmoduleValNotBetween(String value1, String value2) {
	            addCriterion("module_val not between", value1, value2, "moduleVal");
	            return (Criteria) this;
	        }
	        public Criteria andisSupIsNull() {
	            addCriterion("is_sup is null");
	            return (Criteria) this;
	        }

	        public Criteria andisSupIsNotNull() {
	            addCriterion("is_sup is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andisSupEqualTo(Short value) {
	            addCriterion("is_sup =", value, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupNotEqualTo(Short value) {
	            addCriterion("is_sup <>", value, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupGreaterThan(Short value) {
	            addCriterion("is_sup >", value, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupGreaterThanOrEqualTo(Short value) {
	            addCriterion("is_sup >=", value, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupLessThan(Short value) {
	            addCriterion("is_sup <", value, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupLessThanOrEqualTo(Short value) {
	            addCriterion("is_sup <=", value, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupIn(List<Short> values) {
	            addCriterion("is_sup in", values, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupNotIn(List<Short> values) {
	            addCriterion("is_sup not in", values, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupBetween(Short value1, Short value2) {
	            addCriterion("is_sup between", value1, value2, "isSup");
	            return (Criteria) this;
	        }

	        public Criteria andisSupNotBetween(Short value1, Short value2) {
	            addCriterion("is_sup not between", value1, value2, "isSup");
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