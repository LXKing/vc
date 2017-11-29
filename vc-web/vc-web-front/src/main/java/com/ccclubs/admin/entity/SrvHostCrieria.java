package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 接入商信息管理数据查询条件对象
 * @author Joel
 */
public class SrvHostCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public SrvHostCrieria() {
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
	        public Criteria andshIdIsNull() {
	            addCriterion("sh_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andshIdIsNotNull() {
	            addCriterion("sh_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andshIdEqualTo(Integer value) {
	            addCriterion("sh_id =", value, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdNotEqualTo(Integer value) {
	            addCriterion("sh_id <>", value, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdGreaterThan(Integer value) {
	            addCriterion("sh_id >", value, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("sh_id >=", value, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdLessThan(Integer value) {
	            addCriterion("sh_id <", value, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdLessThanOrEqualTo(Integer value) {
	            addCriterion("sh_id <=", value, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdIn(List<Integer> values) {
	            addCriterion("sh_id in", values, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdNotIn(List<Integer> values) {
	            addCriterion("sh_id not in", values, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdBetween(Integer value1, Integer value2) {
	            addCriterion("sh_id between", value1, value2, "shId");
	            return (Criteria) this;
	        }

	        public Criteria andshIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("sh_id not between", value1, value2, "shId");
	            return (Criteria) this;
	        }
	        public Criteria andshNameIsNull() {
	            addCriterion("sh_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andshNameIsNotNull() {
	            addCriterion("sh_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshNameLike(String value) {
	            addCriterion("sh_name like", "%"+value+"%", "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameNotLike(String value) {
	            addCriterion("sh_name not like", "%"+value+"%", "shName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshNameEqualTo(String value) {
	            addCriterion("sh_name =", value, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameNotEqualTo(String value) {
	            addCriterion("sh_name <>", value, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameGreaterThan(String value) {
	            addCriterion("sh_name >", value, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameGreaterThanOrEqualTo(String value) {
	            addCriterion("sh_name >=", value, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameLessThan(String value) {
	            addCriterion("sh_name <", value, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameLessThanOrEqualTo(String value) {
	            addCriterion("sh_name <=", value, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameIn(List<String> values) {
	            addCriterion("sh_name in", values, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameNotIn(List<String> values) {
	            addCriterion("sh_name not in", values, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameBetween(String value1, String value2) {
	            addCriterion("sh_name between", value1, value2, "shName");
	            return (Criteria) this;
	        }

	        public Criteria andshNameNotBetween(String value1, String value2) {
	            addCriterion("sh_name not between", value1, value2, "shName");
	            return (Criteria) this;
	        }
	        public Criteria andshKeyIsNull() {
	            addCriterion("sh_key is null");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyIsNotNull() {
	            addCriterion("sh_key is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshKeyLike(String value) {
	            addCriterion("sh_key like", "%"+value+"%", "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyNotLike(String value) {
	            addCriterion("sh_key not like", "%"+value+"%", "shKey");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshKeyEqualTo(String value) {
	            addCriterion("sh_key =", value, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyNotEqualTo(String value) {
	            addCriterion("sh_key <>", value, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyGreaterThan(String value) {
	            addCriterion("sh_key >", value, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyGreaterThanOrEqualTo(String value) {
	            addCriterion("sh_key >=", value, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyLessThan(String value) {
	            addCriterion("sh_key <", value, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyLessThanOrEqualTo(String value) {
	            addCriterion("sh_key <=", value, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyIn(List<String> values) {
	            addCriterion("sh_key in", values, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyNotIn(List<String> values) {
	            addCriterion("sh_key not in", values, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyBetween(String value1, String value2) {
	            addCriterion("sh_key between", value1, value2, "shKey");
	            return (Criteria) this;
	        }

	        public Criteria andshKeyNotBetween(String value1, String value2) {
	            addCriterion("sh_key not between", value1, value2, "shKey");
	            return (Criteria) this;
	        }
	        public Criteria andshTopicIsNull() {
	            addCriterion("sh_topic is null");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicIsNotNull() {
	            addCriterion("sh_topic is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshTopicLike(String value) {
	            addCriterion("sh_topic like", "%"+value+"%", "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicNotLike(String value) {
	            addCriterion("sh_topic not like", "%"+value+"%", "shTopic");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshTopicEqualTo(String value) {
	            addCriterion("sh_topic =", value, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicNotEqualTo(String value) {
	            addCriterion("sh_topic <>", value, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicGreaterThan(String value) {
	            addCriterion("sh_topic >", value, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicGreaterThanOrEqualTo(String value) {
	            addCriterion("sh_topic >=", value, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicLessThan(String value) {
	            addCriterion("sh_topic <", value, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicLessThanOrEqualTo(String value) {
	            addCriterion("sh_topic <=", value, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicIn(List<String> values) {
	            addCriterion("sh_topic in", values, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicNotIn(List<String> values) {
	            addCriterion("sh_topic not in", values, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicBetween(String value1, String value2) {
	            addCriterion("sh_topic between", value1, value2, "shTopic");
	            return (Criteria) this;
	        }

	        public Criteria andshTopicNotBetween(String value1, String value2) {
	            addCriterion("sh_topic not between", value1, value2, "shTopic");
	            return (Criteria) this;
	        }
	        public Criteria andshAddTimeIsNull() {
	            addCriterion("sh_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeIsNotNull() {
	            addCriterion("sh_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andshAddTimeEqualTo(Date value) {
	            addCriterion("sh_add_time =", value, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeNotEqualTo(Date value) {
	            addCriterion("sh_add_time <>", value, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeGreaterThan(Date value) {
	            addCriterion("sh_add_time >", value, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("sh_add_time >=", value, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeLessThan(Date value) {
	            addCriterion("sh_add_time <", value, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("sh_add_time <=", value, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeIn(List<Date> values) {
	            addCriterion("sh_add_time in", values, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeNotIn(List<Date> values) {
	            addCriterion("sh_add_time not in", values, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeBetween(Date value1, Date value2) {
	            addCriterion("sh_add_time between", value1, value2, "shAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andshAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("sh_add_time not between", value1, value2, "shAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andshUptTimeIsNull() {
	            addCriterion("sh_upt_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeIsNotNull() {
	            addCriterion("sh_upt_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andshUptTimeEqualTo(Date value) {
	            addCriterion("sh_upt_time =", value, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeNotEqualTo(Date value) {
	            addCriterion("sh_upt_time <>", value, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeGreaterThan(Date value) {
	            addCriterion("sh_upt_time >", value, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("sh_upt_time >=", value, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeLessThan(Date value) {
	            addCriterion("sh_upt_time <", value, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeLessThanOrEqualTo(Date value) {
	            addCriterion("sh_upt_time <=", value, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeIn(List<Date> values) {
	            addCriterion("sh_upt_time in", values, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeNotIn(List<Date> values) {
	            addCriterion("sh_upt_time not in", values, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeBetween(Date value1, Date value2) {
	            addCriterion("sh_upt_time between", value1, value2, "shUptTime");
	            return (Criteria) this;
	        }

	        public Criteria andshUptTimeNotBetween(Date value1, Date value2) {
	            addCriterion("sh_upt_time not between", value1, value2, "shUptTime");
	            return (Criteria) this;
	        }
	        public Criteria andshStatusIsNull() {
	            addCriterion("sh_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusIsNotNull() {
	            addCriterion("sh_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andshStatusEqualTo(Short value) {
	            addCriterion("sh_status =", value, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusNotEqualTo(Short value) {
	            addCriterion("sh_status <>", value, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusGreaterThan(Short value) {
	            addCriterion("sh_status >", value, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("sh_status >=", value, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusLessThan(Short value) {
	            addCriterion("sh_status <", value, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusLessThanOrEqualTo(Short value) {
	            addCriterion("sh_status <=", value, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusIn(List<Short> values) {
	            addCriterion("sh_status in", values, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusNotIn(List<Short> values) {
	            addCriterion("sh_status not in", values, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusBetween(Short value1, Short value2) {
	            addCriterion("sh_status between", value1, value2, "shStatus");
	            return (Criteria) this;
	        }

	        public Criteria andshStatusNotBetween(Short value1, Short value2) {
	            addCriterion("sh_status not between", value1, value2, "shStatus");
	            return (Criteria) this;
	        }
	        public Criteria andshAppidIsNull() {
	            addCriterion("sh_appid is null");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidIsNotNull() {
	            addCriterion("sh_appid is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshAppidLike(String value) {
	            addCriterion("sh_appid like", "%"+value+"%", "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidNotLike(String value) {
	            addCriterion("sh_appid not like", "%"+value+"%", "shAppid");
	            return (Criteria) this;
	        }
	        
	        public Criteria andshAppidEqualTo(String value) {
	            addCriterion("sh_appid =", value, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidNotEqualTo(String value) {
	            addCriterion("sh_appid <>", value, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidGreaterThan(String value) {
	            addCriterion("sh_appid >", value, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidGreaterThanOrEqualTo(String value) {
	            addCriterion("sh_appid >=", value, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidLessThan(String value) {
	            addCriterion("sh_appid <", value, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidLessThanOrEqualTo(String value) {
	            addCriterion("sh_appid <=", value, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidIn(List<String> values) {
	            addCriterion("sh_appid in", values, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidNotIn(List<String> values) {
	            addCriterion("sh_appid not in", values, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidBetween(String value1, String value2) {
	            addCriterion("sh_appid between", value1, value2, "shAppid");
	            return (Criteria) this;
	        }

	        public Criteria andshAppidNotBetween(String value1, String value2) {
	            addCriterion("sh_appid not between", value1, value2, "shAppid");
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