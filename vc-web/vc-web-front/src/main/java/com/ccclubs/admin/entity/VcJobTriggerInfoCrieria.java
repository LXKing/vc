package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 定时任务参数
 * @author Joel
 */
public class VcJobTriggerInfoCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VcJobTriggerInfoCrieria() {
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
	        public Criteria andjobIdIsNull() {
	            addCriterion("job_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdIsNotNull() {
	            addCriterion("job_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andjobIdEqualTo(Long value) {
	            addCriterion("job_id =", value, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdNotEqualTo(Long value) {
	            addCriterion("job_id <>", value, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdGreaterThan(Long value) {
	            addCriterion("job_id >", value, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("job_id >=", value, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdLessThan(Long value) {
	            addCriterion("job_id <", value, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdLessThanOrEqualTo(Long value) {
	            addCriterion("job_id <=", value, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdIn(List<Long> values) {
	            addCriterion("job_id in", values, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdNotIn(List<Long> values) {
	            addCriterion("job_id not in", values, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdBetween(Long value1, Long value2) {
	            addCriterion("job_id between", value1, value2, "jobId");
	            return (Criteria) this;
	        }

	        public Criteria andjobIdNotBetween(Long value1, Long value2) {
	            addCriterion("job_id not between", value1, value2, "jobId");
	            return (Criteria) this;
	        }
	        public Criteria andjobCodeIsNull() {
	            addCriterion("job_code is null");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeIsNotNull() {
	            addCriterion("job_code is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobCodeLike(String value) {
	            addCriterion("job_code like", "%"+value+"%", "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeNotLike(String value) {
	            addCriterion("job_code not like", "%"+value+"%", "jobCode");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobCodeEqualTo(String value) {
	            addCriterion("job_code =", value, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeNotEqualTo(String value) {
	            addCriterion("job_code <>", value, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeGreaterThan(String value) {
	            addCriterion("job_code >", value, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeGreaterThanOrEqualTo(String value) {
	            addCriterion("job_code >=", value, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeLessThan(String value) {
	            addCriterion("job_code <", value, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeLessThanOrEqualTo(String value) {
	            addCriterion("job_code <=", value, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeIn(List<String> values) {
	            addCriterion("job_code in", values, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeNotIn(List<String> values) {
	            addCriterion("job_code not in", values, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeBetween(String value1, String value2) {
	            addCriterion("job_code between", value1, value2, "jobCode");
	            return (Criteria) this;
	        }

	        public Criteria andjobCodeNotBetween(String value1, String value2) {
	            addCriterion("job_code not between", value1, value2, "jobCode");
	            return (Criteria) this;
	        }
	        public Criteria andjobNameIsNull() {
	            addCriterion("job_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameIsNotNull() {
	            addCriterion("job_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobNameLike(String value) {
	            addCriterion("job_name like", "%"+value+"%", "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameNotLike(String value) {
	            addCriterion("job_name not like", "%"+value+"%", "jobName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobNameEqualTo(String value) {
	            addCriterion("job_name =", value, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameNotEqualTo(String value) {
	            addCriterion("job_name <>", value, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameGreaterThan(String value) {
	            addCriterion("job_name >", value, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameGreaterThanOrEqualTo(String value) {
	            addCriterion("job_name >=", value, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameLessThan(String value) {
	            addCriterion("job_name <", value, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameLessThanOrEqualTo(String value) {
	            addCriterion("job_name <=", value, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameIn(List<String> values) {
	            addCriterion("job_name in", values, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameNotIn(List<String> values) {
	            addCriterion("job_name not in", values, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameBetween(String value1, String value2) {
	            addCriterion("job_name between", value1, value2, "jobName");
	            return (Criteria) this;
	        }

	        public Criteria andjobNameNotBetween(String value1, String value2) {
	            addCriterion("job_name not between", value1, value2, "jobName");
	            return (Criteria) this;
	        }
	        public Criteria andjobParamIsNull() {
	            addCriterion("job_param is null");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamIsNotNull() {
	            addCriterion("job_param is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobParamLike(String value) {
	            addCriterion("job_param like", "%"+value+"%", "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamNotLike(String value) {
	            addCriterion("job_param not like", "%"+value+"%", "jobParam");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobParamEqualTo(String value) {
	            addCriterion("job_param =", value, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamNotEqualTo(String value) {
	            addCriterion("job_param <>", value, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamGreaterThan(String value) {
	            addCriterion("job_param >", value, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamGreaterThanOrEqualTo(String value) {
	            addCriterion("job_param >=", value, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamLessThan(String value) {
	            addCriterion("job_param <", value, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamLessThanOrEqualTo(String value) {
	            addCriterion("job_param <=", value, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamIn(List<String> values) {
	            addCriterion("job_param in", values, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamNotIn(List<String> values) {
	            addCriterion("job_param not in", values, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamBetween(String value1, String value2) {
	            addCriterion("job_param between", value1, value2, "jobParam");
	            return (Criteria) this;
	        }

	        public Criteria andjobParamNotBetween(String value1, String value2) {
	            addCriterion("job_param not between", value1, value2, "jobParam");
	            return (Criteria) this;
	        }
	        public Criteria andjobDescIsNull() {
	            addCriterion("job_desc is null");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescIsNotNull() {
	            addCriterion("job_desc is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobDescLike(String value) {
	            addCriterion("job_desc like", "%"+value+"%", "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescNotLike(String value) {
	            addCriterion("job_desc not like", "%"+value+"%", "jobDesc");
	            return (Criteria) this;
	        }
	        
	        public Criteria andjobDescEqualTo(String value) {
	            addCriterion("job_desc =", value, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescNotEqualTo(String value) {
	            addCriterion("job_desc <>", value, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescGreaterThan(String value) {
	            addCriterion("job_desc >", value, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescGreaterThanOrEqualTo(String value) {
	            addCriterion("job_desc >=", value, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescLessThan(String value) {
	            addCriterion("job_desc <", value, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescLessThanOrEqualTo(String value) {
	            addCriterion("job_desc <=", value, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescIn(List<String> values) {
	            addCriterion("job_desc in", values, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescNotIn(List<String> values) {
	            addCriterion("job_desc not in", values, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescBetween(String value1, String value2) {
	            addCriterion("job_desc between", value1, value2, "jobDesc");
	            return (Criteria) this;
	        }

	        public Criteria andjobDescNotBetween(String value1, String value2) {
	            addCriterion("job_desc not between", value1, value2, "jobDesc");
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