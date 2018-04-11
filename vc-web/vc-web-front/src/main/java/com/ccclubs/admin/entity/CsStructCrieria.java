package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 控制指令管理数据查询条件对象
 * @author Joel
 */
public class CsStructCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsStructCrieria() {
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
	        public Criteria andcssIdIsNull() {
	            addCriterion("css_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdIsNotNull() {
	            addCriterion("css_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssIdEqualTo(Long value) {
	            addCriterion("css_id =", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotEqualTo(Long value) {
	            addCriterion("css_id <>", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdGreaterThan(Long value) {
	            addCriterion("css_id >", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("css_id >=", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdLessThan(Long value) {
	            addCriterion("css_id <", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdLessThanOrEqualTo(Long value) {
	            addCriterion("css_id <=", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdIn(List<Long> values) {
	            addCriterion("css_id in", values, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotIn(List<Long> values) {
	            addCriterion("css_id not in", values, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdBetween(Long value1, Long value2) {
	            addCriterion("css_id between", value1, value2, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotBetween(Long value1, Long value2) {
	            addCriterion("css_id not between", value1, value2, "cssId");
	            return (Criteria) this;
	        }
	        public Criteria andcssNameIsNull() {
	            addCriterion("css_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameIsNotNull() {
	            addCriterion("css_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssNameLike(String value) {
	            addCriterion("css_name like", "%"+value+"%", "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameNotLike(String value) {
	            addCriterion("css_name not like", "%"+value+"%", "cssName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssNameEqualTo(String value) {
	            addCriterion("css_name =", value, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameNotEqualTo(String value) {
	            addCriterion("css_name <>", value, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameGreaterThan(String value) {
	            addCriterion("css_name >", value, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameGreaterThanOrEqualTo(String value) {
	            addCriterion("css_name >=", value, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameLessThan(String value) {
	            addCriterion("css_name <", value, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameLessThanOrEqualTo(String value) {
	            addCriterion("css_name <=", value, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameIn(List<String> values) {
	            addCriterion("css_name in", values, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameNotIn(List<String> values) {
	            addCriterion("css_name not in", values, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameBetween(String value1, String value2) {
	            addCriterion("css_name between", value1, value2, "cssName");
	            return (Criteria) this;
	        }

	        public Criteria andcssNameNotBetween(String value1, String value2) {
	            addCriterion("css_name not between", value1, value2, "cssName");
	            return (Criteria) this;
	        }
	        public Criteria andcssTypeIsNull() {
	            addCriterion("css_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeIsNotNull() {
	            addCriterion("css_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssTypeEqualTo(Short value) {
	            addCriterion("css_type =", value, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeNotEqualTo(Short value) {
	            addCriterion("css_type <>", value, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeGreaterThan(Short value) {
	            addCriterion("css_type >", value, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_type >=", value, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeLessThan(Short value) {
	            addCriterion("css_type <", value, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeLessThanOrEqualTo(Short value) {
	            addCriterion("css_type <=", value, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeIn(List<Short> values) {
	            addCriterion("css_type in", values, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeNotIn(List<Short> values) {
	            addCriterion("css_type not in", values, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeBetween(Short value1, Short value2) {
	            addCriterion("css_type between", value1, value2, "cssType");
	            return (Criteria) this;
	        }

	        public Criteria andcssTypeNotBetween(Short value1, Short value2) {
	            addCriterion("css_type not between", value1, value2, "cssType");
	            return (Criteria) this;
	        }
	        public Criteria andcssReqCodeIsNull() {
	            addCriterion("css_req_code is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeIsNotNull() {
	            addCriterion("css_req_code is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssReqCodeLike(String value) {
	            addCriterion("css_req_code like", "%"+value+"%", "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeNotLike(String value) {
	            addCriterion("css_req_code not like", "%"+value+"%", "cssReqCode");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssReqCodeEqualTo(String value) {
	            addCriterion("css_req_code =", value, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeNotEqualTo(String value) {
	            addCriterion("css_req_code <>", value, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeGreaterThan(String value) {
	            addCriterion("css_req_code >", value, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeGreaterThanOrEqualTo(String value) {
	            addCriterion("css_req_code >=", value, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeLessThan(String value) {
	            addCriterion("css_req_code <", value, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeLessThanOrEqualTo(String value) {
	            addCriterion("css_req_code <=", value, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeIn(List<String> values) {
	            addCriterion("css_req_code in", values, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeNotIn(List<String> values) {
	            addCriterion("css_req_code not in", values, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeBetween(String value1, String value2) {
	            addCriterion("css_req_code between", value1, value2, "cssReqCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssReqCodeNotBetween(String value1, String value2) {
	            addCriterion("css_req_code not between", value1, value2, "cssReqCode");
	            return (Criteria) this;
	        }
	        public Criteria andcssRequestIsNull() {
	            addCriterion("css_request is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestIsNotNull() {
	            addCriterion("css_request is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRequestLike(String value) {
	            addCriterion("css_request like", "%"+value+"%", "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestNotLike(String value) {
	            addCriterion("css_request not like", "%"+value+"%", "cssRequest");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRequestEqualTo(String value) {
	            addCriterion("css_request =", value, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestNotEqualTo(String value) {
	            addCriterion("css_request <>", value, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestGreaterThan(String value) {
	            addCriterion("css_request >", value, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestGreaterThanOrEqualTo(String value) {
	            addCriterion("css_request >=", value, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestLessThan(String value) {
	            addCriterion("css_request <", value, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestLessThanOrEqualTo(String value) {
	            addCriterion("css_request <=", value, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestIn(List<String> values) {
	            addCriterion("css_request in", values, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestNotIn(List<String> values) {
	            addCriterion("css_request not in", values, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestBetween(String value1, String value2) {
	            addCriterion("css_request between", value1, value2, "cssRequest");
	            return (Criteria) this;
	        }

	        public Criteria andcssRequestNotBetween(String value1, String value2) {
	            addCriterion("css_request not between", value1, value2, "cssRequest");
	            return (Criteria) this;
	        }
	        public Criteria andcssRepCodeIsNull() {
	            addCriterion("css_rep_code is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeIsNotNull() {
	            addCriterion("css_rep_code is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRepCodeLike(String value) {
	            addCriterion("css_rep_code like", "%"+value+"%", "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeNotLike(String value) {
	            addCriterion("css_rep_code not like", "%"+value+"%", "cssRepCode");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRepCodeEqualTo(String value) {
	            addCriterion("css_rep_code =", value, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeNotEqualTo(String value) {
	            addCriterion("css_rep_code <>", value, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeGreaterThan(String value) {
	            addCriterion("css_rep_code >", value, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeGreaterThanOrEqualTo(String value) {
	            addCriterion("css_rep_code >=", value, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeLessThan(String value) {
	            addCriterion("css_rep_code <", value, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeLessThanOrEqualTo(String value) {
	            addCriterion("css_rep_code <=", value, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeIn(List<String> values) {
	            addCriterion("css_rep_code in", values, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeNotIn(List<String> values) {
	            addCriterion("css_rep_code not in", values, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeBetween(String value1, String value2) {
	            addCriterion("css_rep_code between", value1, value2, "cssRepCode");
	            return (Criteria) this;
	        }

	        public Criteria andcssRepCodeNotBetween(String value1, String value2) {
	            addCriterion("css_rep_code not between", value1, value2, "cssRepCode");
	            return (Criteria) this;
	        }
	        public Criteria andcssResponseIsNull() {
	            addCriterion("css_response is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseIsNotNull() {
	            addCriterion("css_response is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssResponseLike(String value) {
	            addCriterion("css_response like", "%"+value+"%", "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseNotLike(String value) {
	            addCriterion("css_response not like", "%"+value+"%", "cssResponse");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssResponseEqualTo(String value) {
	            addCriterion("css_response =", value, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseNotEqualTo(String value) {
	            addCriterion("css_response <>", value, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseGreaterThan(String value) {
	            addCriterion("css_response >", value, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseGreaterThanOrEqualTo(String value) {
	            addCriterion("css_response >=", value, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseLessThan(String value) {
	            addCriterion("css_response <", value, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseLessThanOrEqualTo(String value) {
	            addCriterion("css_response <=", value, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseIn(List<String> values) {
	            addCriterion("css_response in", values, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseNotIn(List<String> values) {
	            addCriterion("css_response not in", values, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseBetween(String value1, String value2) {
	            addCriterion("css_response between", value1, value2, "cssResponse");
	            return (Criteria) this;
	        }

	        public Criteria andcssResponseNotBetween(String value1, String value2) {
	            addCriterion("css_response not between", value1, value2, "cssResponse");
	            return (Criteria) this;
	        }
	        public Criteria andcssStatusIsNull() {
	            addCriterion("css_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusIsNotNull() {
	            addCriterion("css_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssStatusEqualTo(Short value) {
	            addCriterion("css_status =", value, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusNotEqualTo(Short value) {
	            addCriterion("css_status <>", value, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusGreaterThan(Short value) {
	            addCriterion("css_status >", value, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_status >=", value, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusLessThan(Short value) {
	            addCriterion("css_status <", value, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusLessThanOrEqualTo(Short value) {
	            addCriterion("css_status <=", value, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusIn(List<Short> values) {
	            addCriterion("css_status in", values, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusNotIn(List<Short> values) {
	            addCriterion("css_status not in", values, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusBetween(Short value1, Short value2) {
	            addCriterion("css_status between", value1, value2, "cssStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcssStatusNotBetween(Short value1, Short value2) {
	            addCriterion("css_status not between", value1, value2, "cssStatus");
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