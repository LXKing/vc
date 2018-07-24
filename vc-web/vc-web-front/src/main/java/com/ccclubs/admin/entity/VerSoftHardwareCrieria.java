package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 软硬件版本管理数据查询条件对象
 * @author Joel
 */
public class VerSoftHardwareCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VerSoftHardwareCrieria() {
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
	        public Criteria andverNoIsNull() {
	            addCriterion("ver_no is null");
	            return (Criteria) this;
	        }

	        public Criteria andverNoIsNotNull() {
	            addCriterion("ver_no is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andverNoLike(String value) {
	            addCriterion("ver_no like", "%"+value+"%", "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoNotLike(String value) {
	            addCriterion("ver_no not like", "%"+value+"%", "verNo");
	            return (Criteria) this;
	        }
	        
	        public Criteria andverNoEqualTo(String value) {
	            addCriterion("ver_no =", value, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoNotEqualTo(String value) {
	            addCriterion("ver_no <>", value, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoGreaterThan(String value) {
	            addCriterion("ver_no >", value, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoGreaterThanOrEqualTo(String value) {
	            addCriterion("ver_no >=", value, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoLessThan(String value) {
	            addCriterion("ver_no <", value, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoLessThanOrEqualTo(String value) {
	            addCriterion("ver_no <=", value, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoIn(List<String> values) {
	            addCriterion("ver_no in", values, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoNotIn(List<String> values) {
	            addCriterion("ver_no not in", values, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoBetween(String value1, String value2) {
	            addCriterion("ver_no between", value1, value2, "verNo");
	            return (Criteria) this;
	        }

	        public Criteria andverNoNotBetween(String value1, String value2) {
	            addCriterion("ver_no not between", value1, value2, "verNo");
	            return (Criteria) this;
	        }
	        public Criteria anddesIsNull() {
	            addCriterion("des is null");
	            return (Criteria) this;
	        }

	        public Criteria anddesIsNotNull() {
	            addCriterion("des is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddesLike(String value) {
	            addCriterion("des like", "%"+value+"%", "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotLike(String value) {
	            addCriterion("des not like", "%"+value+"%", "des");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddesEqualTo(String value) {
	            addCriterion("des =", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotEqualTo(String value) {
	            addCriterion("des <>", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesGreaterThan(String value) {
	            addCriterion("des >", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesGreaterThanOrEqualTo(String value) {
	            addCriterion("des >=", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesLessThan(String value) {
	            addCriterion("des <", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesLessThanOrEqualTo(String value) {
	            addCriterion("des <=", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesIn(List<String> values) {
	            addCriterion("des in", values, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotIn(List<String> values) {
	            addCriterion("des not in", values, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesBetween(String value1, String value2) {
	            addCriterion("des between", value1, value2, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotBetween(String value1, String value2) {
	            addCriterion("des not between", value1, value2, "des");
	            return (Criteria) this;
	        }
	        public Criteria andtypeIsNull() {
	            addCriterion("type is null");
	            return (Criteria) this;
	        }

	        public Criteria andtypeIsNotNull() {
	            addCriterion("type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andtypeEqualTo(Short value) {
	            addCriterion("type =", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotEqualTo(Short value) {
	            addCriterion("type <>", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeGreaterThan(Short value) {
	            addCriterion("type >", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("type >=", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeLessThan(Short value) {
	            addCriterion("type <", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeLessThanOrEqualTo(Short value) {
	            addCriterion("type <=", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeIn(List<Short> values) {
	            addCriterion("type in", values, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotIn(List<Short> values) {
	            addCriterion("type not in", values, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeBetween(Short value1, Short value2) {
	            addCriterion("type between", value1, value2, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotBetween(Short value1, Short value2) {
	            addCriterion("type not between", value1, value2, "type");
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