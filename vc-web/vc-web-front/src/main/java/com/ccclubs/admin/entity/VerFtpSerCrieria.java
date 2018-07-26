package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 升级文件服务器管理数据查询条件对象
 * @author Joel
 */
public class VerFtpSerCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VerFtpSerCrieria() {
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
	        public Criteria andserUsernameIsNull() {
	            addCriterion("ser_username is null");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameIsNotNull() {
	            addCriterion("ser_username is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andserUsernameLike(String value) {
	            addCriterion("ser_username like", "%"+value+"%", "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameNotLike(String value) {
	            addCriterion("ser_username not like", "%"+value+"%", "serUsername");
	            return (Criteria) this;
	        }
	        
	        public Criteria andserUsernameEqualTo(String value) {
	            addCriterion("ser_username =", value, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameNotEqualTo(String value) {
	            addCriterion("ser_username <>", value, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameGreaterThan(String value) {
	            addCriterion("ser_username >", value, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameGreaterThanOrEqualTo(String value) {
	            addCriterion("ser_username >=", value, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameLessThan(String value) {
	            addCriterion("ser_username <", value, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameLessThanOrEqualTo(String value) {
	            addCriterion("ser_username <=", value, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameIn(List<String> values) {
	            addCriterion("ser_username in", values, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameNotIn(List<String> values) {
	            addCriterion("ser_username not in", values, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameBetween(String value1, String value2) {
	            addCriterion("ser_username between", value1, value2, "serUsername");
	            return (Criteria) this;
	        }

	        public Criteria andserUsernameNotBetween(String value1, String value2) {
	            addCriterion("ser_username not between", value1, value2, "serUsername");
	            return (Criteria) this;
	        }
	        public Criteria andserPwdIsNull() {
	            addCriterion("ser_pwd is null");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdIsNotNull() {
	            addCriterion("ser_pwd is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andserPwdLike(String value) {
	            addCriterion("ser_pwd like", "%"+value+"%", "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdNotLike(String value) {
	            addCriterion("ser_pwd not like", "%"+value+"%", "serPwd");
	            return (Criteria) this;
	        }
	        
	        public Criteria andserPwdEqualTo(String value) {
	            addCriterion("ser_pwd =", value, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdNotEqualTo(String value) {
	            addCriterion("ser_pwd <>", value, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdGreaterThan(String value) {
	            addCriterion("ser_pwd >", value, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdGreaterThanOrEqualTo(String value) {
	            addCriterion("ser_pwd >=", value, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdLessThan(String value) {
	            addCriterion("ser_pwd <", value, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdLessThanOrEqualTo(String value) {
	            addCriterion("ser_pwd <=", value, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdIn(List<String> values) {
	            addCriterion("ser_pwd in", values, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdNotIn(List<String> values) {
	            addCriterion("ser_pwd not in", values, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdBetween(String value1, String value2) {
	            addCriterion("ser_pwd between", value1, value2, "serPwd");
	            return (Criteria) this;
	        }

	        public Criteria andserPwdNotBetween(String value1, String value2) {
	            addCriterion("ser_pwd not between", value1, value2, "serPwd");
	            return (Criteria) this;
	        }
	        public Criteria andurlIsNull() {
	            addCriterion("url is null");
	            return (Criteria) this;
	        }

	        public Criteria andurlIsNotNull() {
	            addCriterion("url is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andurlLike(String value) {
	            addCriterion("url like", "%"+value+"%", "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlNotLike(String value) {
	            addCriterion("url not like", "%"+value+"%", "url");
	            return (Criteria) this;
	        }
	        
	        public Criteria andurlEqualTo(String value) {
	            addCriterion("url =", value, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlNotEqualTo(String value) {
	            addCriterion("url <>", value, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlGreaterThan(String value) {
	            addCriterion("url >", value, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlGreaterThanOrEqualTo(String value) {
	            addCriterion("url >=", value, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlLessThan(String value) {
	            addCriterion("url <", value, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlLessThanOrEqualTo(String value) {
	            addCriterion("url <=", value, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlIn(List<String> values) {
	            addCriterion("url in", values, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlNotIn(List<String> values) {
	            addCriterion("url not in", values, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlBetween(String value1, String value2) {
	            addCriterion("url between", value1, value2, "url");
	            return (Criteria) this;
	        }

	        public Criteria andurlNotBetween(String value1, String value2) {
	            addCriterion("url not between", value1, value2, "url");
	            return (Criteria) this;
	        }
	        public Criteria andportIsNull() {
	            addCriterion("port is null");
	            return (Criteria) this;
	        }

	        public Criteria andportIsNotNull() {
	            addCriterion("port is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andportEqualTo(Integer value) {
	            addCriterion("port =", value, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportNotEqualTo(Integer value) {
	            addCriterion("port <>", value, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportGreaterThan(Integer value) {
	            addCriterion("port >", value, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportGreaterThanOrEqualTo(Integer value) {
	            addCriterion("port >=", value, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportLessThan(Integer value) {
	            addCriterion("port <", value, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportLessThanOrEqualTo(Integer value) {
	            addCriterion("port <=", value, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportIn(List<Integer> values) {
	            addCriterion("port in", values, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportNotIn(List<Integer> values) {
	            addCriterion("port not in", values, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportBetween(Integer value1, Integer value2) {
	            addCriterion("port between", value1, value2, "port");
	            return (Criteria) this;
	        }

	        public Criteria andportNotBetween(Integer value1, Integer value2) {
	            addCriterion("port not between", value1, value2, "port");
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
	        
	        
	        public Criteria andtypeEqualTo(Integer value) {
	            addCriterion("type =", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotEqualTo(Integer value) {
	            addCriterion("type <>", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeGreaterThan(Integer value) {
	            addCriterion("type >", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeGreaterThanOrEqualTo(Integer value) {
	            addCriterion("type >=", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeLessThan(Integer value) {
	            addCriterion("type <", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeLessThanOrEqualTo(Integer value) {
	            addCriterion("type <=", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeIn(List<Integer> values) {
	            addCriterion("type in", values, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotIn(List<Integer> values) {
	            addCriterion("type not in", values, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeBetween(Integer value1, Integer value2) {
	            addCriterion("type between", value1, value2, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotBetween(Integer value1, Integer value2) {
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