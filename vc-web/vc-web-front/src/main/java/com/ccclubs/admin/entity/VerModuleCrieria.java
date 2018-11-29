package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 版本模块管理数据查询条件对象
 * @author Joel
 */
public class VerModuleCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VerModuleCrieria() {
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
	        public Criteria andnameIsNull() {
	            addCriterion("name is null");
	            return (Criteria) this;
	        }

	        public Criteria andnameIsNotNull() {
	            addCriterion("name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andnameLike(String value) {
	            addCriterion("name like", "%"+value+"%", "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameNotLike(String value) {
	            addCriterion("name not like", "%"+value+"%", "name");
	            return (Criteria) this;
	        }
	        
	        public Criteria andnameEqualTo(String value) {
	            addCriterion("name =", value, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameNotEqualTo(String value) {
	            addCriterion("name <>", value, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameGreaterThan(String value) {
	            addCriterion("name >", value, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameGreaterThanOrEqualTo(String value) {
	            addCriterion("name >=", value, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameLessThan(String value) {
	            addCriterion("name <", value, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameLessThanOrEqualTo(String value) {
	            addCriterion("name <=", value, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameIn(List<String> values) {
	            addCriterion("name in", values, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameNotIn(List<String> values) {
	            addCriterion("name not in", values, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameBetween(String value1, String value2) {
	            addCriterion("name between", value1, value2, "name");
	            return (Criteria) this;
	        }

	        public Criteria andnameNotBetween(String value1, String value2) {
	            addCriterion("name not between", value1, value2, "name");
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
	        public Criteria andversionIsNull() {
	            addCriterion("version is null");
	            return (Criteria) this;
	        }

	        public Criteria andversionIsNotNull() {
	            addCriterion("version is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andversionLike(String value) {
	            addCriterion("version like", "%"+value+"%", "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionNotLike(String value) {
	            addCriterion("version not like", "%"+value+"%", "version");
	            return (Criteria) this;
	        }
	        
	        public Criteria andversionEqualTo(String value) {
	            addCriterion("version =", value, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionNotEqualTo(String value) {
	            addCriterion("version <>", value, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionGreaterThan(String value) {
	            addCriterion("version >", value, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionGreaterThanOrEqualTo(String value) {
	            addCriterion("version >=", value, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionLessThan(String value) {
	            addCriterion("version <", value, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionLessThanOrEqualTo(String value) {
	            addCriterion("version <=", value, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionIn(List<String> values) {
	            addCriterion("version in", values, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionNotIn(List<String> values) {
	            addCriterion("version not in", values, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionBetween(String value1, String value2) {
	            addCriterion("version between", value1, value2, "version");
	            return (Criteria) this;
	        }

	        public Criteria andversionNotBetween(String value1, String value2) {
	            addCriterion("version not between", value1, value2, "version");
	            return (Criteria) this;
	        }
	        public Criteria anddataTypeIsNull() {
	            addCriterion("data_type is null");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeIsNotNull() {
	            addCriterion("data_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria anddataTypeEqualTo(Long value) {
	            addCriterion("data_type =", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeNotEqualTo(Long value) {
	            addCriterion("data_type <>", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeGreaterThan(Long value) {
	            addCriterion("data_type >", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeGreaterThanOrEqualTo(Long value) {
	            addCriterion("data_type >=", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeLessThan(Long value) {
	            addCriterion("data_type <", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeLessThanOrEqualTo(Long value) {
	            addCriterion("data_type <=", value, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeIn(List<Long> values) {
	            addCriterion("data_type in", values, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeNotIn(List<Long> values) {
	            addCriterion("data_type not in", values, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeBetween(Long value1, Long value2) {
	            addCriterion("data_type between", value1, value2, "dataType");
	            return (Criteria) this;
	        }

	        public Criteria anddataTypeNotBetween(Long value1, Long value2) {
	            addCriterion("data_type not between", value1, value2, "dataType");
	            return (Criteria) this;
	        }
	        public Criteria anddataItemTypeIsNull() {
	            addCriterion("data_item_type is null");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeIsNotNull() {
	            addCriterion("data_item_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria anddataItemTypeEqualTo(Long value) {
	            addCriterion("data_item_type =", value, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeNotEqualTo(Long value) {
	            addCriterion("data_item_type <>", value, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeGreaterThan(Long value) {
	            addCriterion("data_item_type >", value, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeGreaterThanOrEqualTo(Long value) {
	            addCriterion("data_item_type >=", value, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeLessThan(Long value) {
	            addCriterion("data_item_type <", value, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeLessThanOrEqualTo(Long value) {
	            addCriterion("data_item_type <=", value, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeIn(List<Long> values) {
	            addCriterion("data_item_type in", values, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeNotIn(List<Long> values) {
	            addCriterion("data_item_type not in", values, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeBetween(Long value1, Long value2) {
	            addCriterion("data_item_type between", value1, value2, "dataItemType");
	            return (Criteria) this;
	        }

	        public Criteria anddataItemTypeNotBetween(Long value1, Long value2) {
	            addCriterion("data_item_type not between", value1, value2, "dataItemType");
	            return (Criteria) this;
	        }
	        public Criteria anddataValueIsNull() {
	            addCriterion("data_value is null");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueIsNotNull() {
	            addCriterion("data_value is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddataValueLike(String value) {
	            addCriterion("data_value like", "%"+value+"%", "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueNotLike(String value) {
	            addCriterion("data_value not like", "%"+value+"%", "dataValue");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddataValueEqualTo(String value) {
	            addCriterion("data_value =", value, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueNotEqualTo(String value) {
	            addCriterion("data_value <>", value, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueGreaterThan(String value) {
	            addCriterion("data_value >", value, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueGreaterThanOrEqualTo(String value) {
	            addCriterion("data_value >=", value, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueLessThan(String value) {
	            addCriterion("data_value <", value, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueLessThanOrEqualTo(String value) {
	            addCriterion("data_value <=", value, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueIn(List<String> values) {
	            addCriterion("data_value in", values, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueNotIn(List<String> values) {
	            addCriterion("data_value not in", values, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueBetween(String value1, String value2) {
	            addCriterion("data_value between", value1, value2, "dataValue");
	            return (Criteria) this;
	        }

	        public Criteria anddataValueNotBetween(String value1, String value2) {
	            addCriterion("data_value not between", value1, value2, "dataValue");
	            return (Criteria) this;
	        }
	        public Criteria andsortIsNull() {
	            addCriterion("sort is null");
	            return (Criteria) this;
	        }

	        public Criteria andsortIsNotNull() {
	            addCriterion("sort is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsortEqualTo(Integer value) {
	            addCriterion("sort =", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortNotEqualTo(Integer value) {
	            addCriterion("sort <>", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortGreaterThan(Integer value) {
	            addCriterion("sort >", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortGreaterThanOrEqualTo(Integer value) {
	            addCriterion("sort >=", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortLessThan(Integer value) {
	            addCriterion("sort <", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortLessThanOrEqualTo(Integer value) {
	            addCriterion("sort <=", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortIn(List<Integer> values) {
	            addCriterion("sort in", values, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortNotIn(List<Integer> values) {
	            addCriterion("sort not in", values, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortBetween(Integer value1, Integer value2) {
	            addCriterion("sort between", value1, value2, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortNotBetween(Integer value1, Integer value2) {
	            addCriterion("sort not between", value1, value2, "sort");
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