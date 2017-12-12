package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 角色组管理数据查询条件对象
 * @author Joel
 */
public class SrvGroupCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public SrvGroupCrieria() {
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
	        public Criteria andsgIdIsNull() {
	            addCriterion("sg_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdIsNotNull() {
	            addCriterion("sg_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsgIdEqualTo(Integer value) {
	            addCriterion("sg_id =", value, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdNotEqualTo(Integer value) {
	            addCriterion("sg_id <>", value, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdGreaterThan(Integer value) {
	            addCriterion("sg_id >", value, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("sg_id >=", value, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdLessThan(Integer value) {
	            addCriterion("sg_id <", value, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdLessThanOrEqualTo(Integer value) {
	            addCriterion("sg_id <=", value, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdIn(List<Integer> values) {
	            addCriterion("sg_id in", values, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdNotIn(List<Integer> values) {
	            addCriterion("sg_id not in", values, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdBetween(Integer value1, Integer value2) {
	            addCriterion("sg_id between", value1, value2, "sgId");
	            return (Criteria) this;
	        }

	        public Criteria andsgIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("sg_id not between", value1, value2, "sgId");
	            return (Criteria) this;
	        }
	        public Criteria andsgNameIsNull() {
	            addCriterion("sg_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameIsNotNull() {
	            addCriterion("sg_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsgNameLike(String value) {
	            addCriterion("sg_name like", "%"+value+"%", "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameNotLike(String value) {
	            addCriterion("sg_name not like", "%"+value+"%", "sgName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsgNameEqualTo(String value) {
	            addCriterion("sg_name =", value, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameNotEqualTo(String value) {
	            addCriterion("sg_name <>", value, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameGreaterThan(String value) {
	            addCriterion("sg_name >", value, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameGreaterThanOrEqualTo(String value) {
	            addCriterion("sg_name >=", value, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameLessThan(String value) {
	            addCriterion("sg_name <", value, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameLessThanOrEqualTo(String value) {
	            addCriterion("sg_name <=", value, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameIn(List<String> values) {
	            addCriterion("sg_name in", values, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameNotIn(List<String> values) {
	            addCriterion("sg_name not in", values, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameBetween(String value1, String value2) {
	            addCriterion("sg_name between", value1, value2, "sgName");
	            return (Criteria) this;
	        }

	        public Criteria andsgNameNotBetween(String value1, String value2) {
	            addCriterion("sg_name not between", value1, value2, "sgName");
	            return (Criteria) this;
	        }
	        public Criteria andsgParentIsNull() {
	            addCriterion("sg_parent is null");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentIsNotNull() {
	            addCriterion("sg_parent is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsgParentEqualTo(Long value) {
	            addCriterion("sg_parent =", value, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentNotEqualTo(Long value) {
	            addCriterion("sg_parent <>", value, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentGreaterThan(Long value) {
	            addCriterion("sg_parent >", value, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentGreaterThanOrEqualTo(Long value) {
	            addCriterion("sg_parent >=", value, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentLessThan(Long value) {
	            addCriterion("sg_parent <", value, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentLessThanOrEqualTo(Long value) {
	            addCriterion("sg_parent <=", value, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentIn(List<Long> values) {
	            addCriterion("sg_parent in", values, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentNotIn(List<Long> values) {
	            addCriterion("sg_parent not in", values, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentBetween(Long value1, Long value2) {
	            addCriterion("sg_parent between", value1, value2, "sgParent");
	            return (Criteria) this;
	        }

	        public Criteria andsgParentNotBetween(Long value1, Long value2) {
	            addCriterion("sg_parent not between", value1, value2, "sgParent");
	            return (Criteria) this;
	        }
	        public Criteria andsgFamilyIsNull() {
	            addCriterion("sg_family is null");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyIsNotNull() {
	            addCriterion("sg_family is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsgFamilyLike(String value) {
	            addCriterion("sg_family like", "%"+value+"%", "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyNotLike(String value) {
	            addCriterion("sg_family not like", "%"+value+"%", "sgFamily");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsgFamilyEqualTo(String value) {
	            addCriterion("sg_family =", value, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyNotEqualTo(String value) {
	            addCriterion("sg_family <>", value, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyGreaterThan(String value) {
	            addCriterion("sg_family >", value, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyGreaterThanOrEqualTo(String value) {
	            addCriterion("sg_family >=", value, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyLessThan(String value) {
	            addCriterion("sg_family <", value, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyLessThanOrEqualTo(String value) {
	            addCriterion("sg_family <=", value, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyIn(List<String> values) {
	            addCriterion("sg_family in", values, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyNotIn(List<String> values) {
	            addCriterion("sg_family not in", values, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyBetween(String value1, String value2) {
	            addCriterion("sg_family between", value1, value2, "sgFamily");
	            return (Criteria) this;
	        }

	        public Criteria andsgFamilyNotBetween(String value1, String value2) {
	            addCriterion("sg_family not between", value1, value2, "sgFamily");
	            return (Criteria) this;
	        }
	        public Criteria andsgUserIsNull() {
	            addCriterion("sg_user is null");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserIsNotNull() {
	            addCriterion("sg_user is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsgUserEqualTo(Long value) {
	            addCriterion("sg_user =", value, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserNotEqualTo(Long value) {
	            addCriterion("sg_user <>", value, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserGreaterThan(Long value) {
	            addCriterion("sg_user >", value, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserGreaterThanOrEqualTo(Long value) {
	            addCriterion("sg_user >=", value, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserLessThan(Long value) {
	            addCriterion("sg_user <", value, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserLessThanOrEqualTo(Long value) {
	            addCriterion("sg_user <=", value, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserIn(List<Long> values) {
	            addCriterion("sg_user in", values, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserNotIn(List<Long> values) {
	            addCriterion("sg_user not in", values, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserBetween(Long value1, Long value2) {
	            addCriterion("sg_user between", value1, value2, "sgUser");
	            return (Criteria) this;
	        }

	        public Criteria andsgUserNotBetween(Long value1, Long value2) {
	            addCriterion("sg_user not between", value1, value2, "sgUser");
	            return (Criteria) this;
	        }
	        public Criteria andsgFlagIsNull() {
	            addCriterion("sg_flag is null");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagIsNotNull() {
	            addCriterion("sg_flag is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsgFlagLike(String value) {
	            addCriterion("sg_flag like", "%"+value+"%", "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagNotLike(String value) {
	            addCriterion("sg_flag not like", "%"+value+"%", "sgFlag");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsgFlagEqualTo(String value) {
	            addCriterion("sg_flag =", value, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagNotEqualTo(String value) {
	            addCriterion("sg_flag <>", value, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagGreaterThan(String value) {
	            addCriterion("sg_flag >", value, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagGreaterThanOrEqualTo(String value) {
	            addCriterion("sg_flag >=", value, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagLessThan(String value) {
	            addCriterion("sg_flag <", value, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagLessThanOrEqualTo(String value) {
	            addCriterion("sg_flag <=", value, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagIn(List<String> values) {
	            addCriterion("sg_flag in", values, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagNotIn(List<String> values) {
	            addCriterion("sg_flag not in", values, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagBetween(String value1, String value2) {
	            addCriterion("sg_flag between", value1, value2, "sgFlag");
	            return (Criteria) this;
	        }

	        public Criteria andsgFlagNotBetween(String value1, String value2) {
	            addCriterion("sg_flag not between", value1, value2, "sgFlag");
	            return (Criteria) this;
	        }
	        public Criteria andsgStatusIsNull() {
	            addCriterion("sg_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusIsNotNull() {
	            addCriterion("sg_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsgStatusEqualTo(Short value) {
	            addCriterion("sg_status =", value, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusNotEqualTo(Short value) {
	            addCriterion("sg_status <>", value, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusGreaterThan(Short value) {
	            addCriterion("sg_status >", value, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("sg_status >=", value, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusLessThan(Short value) {
	            addCriterion("sg_status <", value, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusLessThanOrEqualTo(Short value) {
	            addCriterion("sg_status <=", value, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusIn(List<Short> values) {
	            addCriterion("sg_status in", values, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusNotIn(List<Short> values) {
	            addCriterion("sg_status not in", values, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusBetween(Short value1, Short value2) {
	            addCriterion("sg_status between", value1, value2, "sgStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsgStatusNotBetween(Short value1, Short value2) {
	            addCriterion("sg_status not between", value1, value2, "sgStatus");
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