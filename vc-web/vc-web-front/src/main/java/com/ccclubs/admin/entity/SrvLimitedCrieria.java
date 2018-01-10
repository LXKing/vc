package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 权限配置管理数据查询条件对象
 * @author Joel
 */
public class SrvLimitedCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public SrvLimitedCrieria() {
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
	        public Criteria andslIdIsNull() {
	            addCriterion("sl_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andslIdIsNotNull() {
	            addCriterion("sl_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andslIdEqualTo(Integer value) {
	            addCriterion("sl_id =", value, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdNotEqualTo(Integer value) {
	            addCriterion("sl_id <>", value, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdGreaterThan(Integer value) {
	            addCriterion("sl_id >", value, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("sl_id >=", value, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdLessThan(Integer value) {
	            addCriterion("sl_id <", value, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdLessThanOrEqualTo(Integer value) {
	            addCriterion("sl_id <=", value, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdIn(List<Integer> values) {
	            addCriterion("sl_id in", values, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdNotIn(List<Integer> values) {
	            addCriterion("sl_id not in", values, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdBetween(Integer value1, Integer value2) {
	            addCriterion("sl_id between", value1, value2, "slId");
	            return (Criteria) this;
	        }

	        public Criteria andslIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("sl_id not between", value1, value2, "slId");
	            return (Criteria) this;
	        }
	        public Criteria andslProjectIsNull() {
	            addCriterion("sl_project is null");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectIsNotNull() {
	            addCriterion("sl_project is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andslProjectEqualTo(Long value) {
	            addCriterion("sl_project =", value, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectNotEqualTo(Long value) {
	            addCriterion("sl_project <>", value, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectGreaterThan(Long value) {
	            addCriterion("sl_project >", value, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectGreaterThanOrEqualTo(Long value) {
	            addCriterion("sl_project >=", value, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectLessThan(Long value) {
	            addCriterion("sl_project <", value, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectLessThanOrEqualTo(Long value) {
	            addCriterion("sl_project <=", value, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectIn(List<Long> values) {
	            addCriterion("sl_project in", values, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectNotIn(List<Long> values) {
	            addCriterion("sl_project not in", values, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectBetween(Long value1, Long value2) {
	            addCriterion("sl_project between", value1, value2, "slProject");
	            return (Criteria) this;
	        }

	        public Criteria andslProjectNotBetween(Long value1, Long value2) {
	            addCriterion("sl_project not between", value1, value2, "slProject");
	            return (Criteria) this;
	        }
	        public Criteria andslUserIsNull() {
	            addCriterion("sl_user is null");
	            return (Criteria) this;
	        }

	        public Criteria andslUserIsNotNull() {
	            addCriterion("sl_user is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andslUserEqualTo(Long value) {
	            addCriterion("sl_user =", value, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserNotEqualTo(Long value) {
	            addCriterion("sl_user <>", value, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserGreaterThan(Long value) {
	            addCriterion("sl_user >", value, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserGreaterThanOrEqualTo(Long value) {
	            addCriterion("sl_user >=", value, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserLessThan(Long value) {
	            addCriterion("sl_user <", value, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserLessThanOrEqualTo(Long value) {
	            addCriterion("sl_user <=", value, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserIn(List<Long> values) {
	            addCriterion("sl_user in", values, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserNotIn(List<Long> values) {
	            addCriterion("sl_user not in", values, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserBetween(Long value1, Long value2) {
	            addCriterion("sl_user between", value1, value2, "slUser");
	            return (Criteria) this;
	        }

	        public Criteria andslUserNotBetween(Long value1, Long value2) {
	            addCriterion("sl_user not between", value1, value2, "slUser");
	            return (Criteria) this;
	        }
	        public Criteria andslGroupIsNull() {
	            addCriterion("sl_group is null");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupIsNotNull() {
	            addCriterion("sl_group is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andslGroupEqualTo(Long value) {
	            addCriterion("sl_group =", value, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupNotEqualTo(Long value) {
	            addCriterion("sl_group <>", value, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupGreaterThan(Long value) {
	            addCriterion("sl_group >", value, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupGreaterThanOrEqualTo(Long value) {
	            addCriterion("sl_group >=", value, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupLessThan(Long value) {
	            addCriterion("sl_group <", value, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupLessThanOrEqualTo(Long value) {
	            addCriterion("sl_group <=", value, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupIn(List<Long> values) {
	            addCriterion("sl_group in", values, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupNotIn(List<Long> values) {
	            addCriterion("sl_group not in", values, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupBetween(Long value1, Long value2) {
	            addCriterion("sl_group between", value1, value2, "slGroup");
	            return (Criteria) this;
	        }

	        public Criteria andslGroupNotBetween(Long value1, Long value2) {
	            addCriterion("sl_group not between", value1, value2, "slGroup");
	            return (Criteria) this;
	        }
	        public Criteria andslLimitIsNull() {
	            addCriterion("sl_limit is null");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitIsNotNull() {
	            addCriterion("sl_limit is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andslLimitEqualTo(Integer value) {
	            addCriterion("sl_limit =", value, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitNotEqualTo(Integer value) {
	            addCriterion("sl_limit <>", value, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitGreaterThan(Integer value) {
	            addCriterion("sl_limit >", value, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitGreaterThanOrEqualTo(Integer value) {
	            addCriterion("sl_limit >=", value, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitLessThan(Integer value) {
	            addCriterion("sl_limit <", value, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitLessThanOrEqualTo(Integer value) {
	            addCriterion("sl_limit <=", value, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitIn(List<Integer> values) {
	            addCriterion("sl_limit in", values, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitNotIn(List<Integer> values) {
	            addCriterion("sl_limit not in", values, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitBetween(Integer value1, Integer value2) {
	            addCriterion("sl_limit between", value1, value2, "slLimit");
	            return (Criteria) this;
	        }

	        public Criteria andslLimitNotBetween(Integer value1, Integer value2) {
	            addCriterion("sl_limit not between", value1, value2, "slLimit");
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