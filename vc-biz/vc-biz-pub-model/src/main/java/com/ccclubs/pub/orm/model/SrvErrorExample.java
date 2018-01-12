package com.ccclubs.pub.orm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SrvErrorExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public SrvErrorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_error
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table srv_error
     *
     * @mbg.generated
     */
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

        public Criteria andSeIdIsNull() {
            addCriterion("se_id is null");
            return (Criteria) this;
        }

        public Criteria andSeIdIsNotNull() {
            addCriterion("se_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeIdEqualTo(Integer value) {
            addCriterion("se_id =", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdNotEqualTo(Integer value) {
            addCriterion("se_id <>", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdGreaterThan(Integer value) {
            addCriterion("se_id >", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("se_id >=", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdLessThan(Integer value) {
            addCriterion("se_id <", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdLessThanOrEqualTo(Integer value) {
            addCriterion("se_id <=", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdIn(List<Integer> values) {
            addCriterion("se_id in", values, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdNotIn(List<Integer> values) {
            addCriterion("se_id not in", values, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdBetween(Integer value1, Integer value2) {
            addCriterion("se_id between", value1, value2, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("se_id not between", value1, value2, "seId");
            return (Criteria) this;
        }

        public Criteria andSeTitleIsNull() {
            addCriterion("se_title is null");
            return (Criteria) this;
        }

        public Criteria andSeTitleIsNotNull() {
            addCriterion("se_title is not null");
            return (Criteria) this;
        }

        public Criteria andSeTitleEqualTo(String value) {
            addCriterion("se_title =", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleNotEqualTo(String value) {
            addCriterion("se_title <>", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleGreaterThan(String value) {
            addCriterion("se_title >", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("se_title >=", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleLessThan(String value) {
            addCriterion("se_title <", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleLessThanOrEqualTo(String value) {
            addCriterion("se_title <=", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleLike(String value) {
            addCriterion("se_title like", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleNotLike(String value) {
            addCriterion("se_title not like", value, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleIn(List<String> values) {
            addCriterion("se_title in", values, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleNotIn(List<String> values) {
            addCriterion("se_title not in", values, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleBetween(String value1, String value2) {
            addCriterion("se_title between", value1, value2, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeTitleNotBetween(String value1, String value2) {
            addCriterion("se_title not between", value1, value2, "seTitle");
            return (Criteria) this;
        }

        public Criteria andSeContentIsNull() {
            addCriterion("se_content is null");
            return (Criteria) this;
        }

        public Criteria andSeContentIsNotNull() {
            addCriterion("se_content is not null");
            return (Criteria) this;
        }

        public Criteria andSeContentEqualTo(String value) {
            addCriterion("se_content =", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentNotEqualTo(String value) {
            addCriterion("se_content <>", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentGreaterThan(String value) {
            addCriterion("se_content >", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentGreaterThanOrEqualTo(String value) {
            addCriterion("se_content >=", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentLessThan(String value) {
            addCriterion("se_content <", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentLessThanOrEqualTo(String value) {
            addCriterion("se_content <=", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentLike(String value) {
            addCriterion("se_content like", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentNotLike(String value) {
            addCriterion("se_content not like", value, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentIn(List<String> values) {
            addCriterion("se_content in", values, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentNotIn(List<String> values) {
            addCriterion("se_content not in", values, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentBetween(String value1, String value2) {
            addCriterion("se_content between", value1, value2, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeContentNotBetween(String value1, String value2) {
            addCriterion("se_content not between", value1, value2, "seContent");
            return (Criteria) this;
        }

        public Criteria andSeFlagIsNull() {
            addCriterion("se_flag is null");
            return (Criteria) this;
        }

        public Criteria andSeFlagIsNotNull() {
            addCriterion("se_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSeFlagEqualTo(String value) {
            addCriterion("se_flag =", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagNotEqualTo(String value) {
            addCriterion("se_flag <>", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagGreaterThan(String value) {
            addCriterion("se_flag >", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagGreaterThanOrEqualTo(String value) {
            addCriterion("se_flag >=", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagLessThan(String value) {
            addCriterion("se_flag <", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagLessThanOrEqualTo(String value) {
            addCriterion("se_flag <=", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagLike(String value) {
            addCriterion("se_flag like", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagNotLike(String value) {
            addCriterion("se_flag not like", value, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagIn(List<String> values) {
            addCriterion("se_flag in", values, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagNotIn(List<String> values) {
            addCriterion("se_flag not in", values, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagBetween(String value1, String value2) {
            addCriterion("se_flag between", value1, value2, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeFlagNotBetween(String value1, String value2) {
            addCriterion("se_flag not between", value1, value2, "seFlag");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeIsNull() {
            addCriterion("se_update_time is null");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeIsNotNull() {
            addCriterion("se_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeEqualTo(Date value) {
            addCriterion("se_update_time =", value, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeNotEqualTo(Date value) {
            addCriterion("se_update_time <>", value, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeGreaterThan(Date value) {
            addCriterion("se_update_time >", value, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("se_update_time >=", value, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeLessThan(Date value) {
            addCriterion("se_update_time <", value, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("se_update_time <=", value, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeIn(List<Date> values) {
            addCriterion("se_update_time in", values, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeNotIn(List<Date> values) {
            addCriterion("se_update_time not in", values, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("se_update_time between", value1, value2, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("se_update_time not between", value1, value2, "seUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeIsNull() {
            addCriterion("se_add_time is null");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeIsNotNull() {
            addCriterion("se_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeEqualTo(Date value) {
            addCriterion("se_add_time =", value, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeNotEqualTo(Date value) {
            addCriterion("se_add_time <>", value, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeGreaterThan(Date value) {
            addCriterion("se_add_time >", value, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("se_add_time >=", value, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeLessThan(Date value) {
            addCriterion("se_add_time <", value, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("se_add_time <=", value, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeIn(List<Date> values) {
            addCriterion("se_add_time in", values, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeNotIn(List<Date> values) {
            addCriterion("se_add_time not in", values, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeBetween(Date value1, Date value2) {
            addCriterion("se_add_time between", value1, value2, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("se_add_time not between", value1, value2, "seAddTime");
            return (Criteria) this;
        }

        public Criteria andSeStatusIsNull() {
            addCriterion("se_status is null");
            return (Criteria) this;
        }

        public Criteria andSeStatusIsNotNull() {
            addCriterion("se_status is not null");
            return (Criteria) this;
        }

        public Criteria andSeStatusEqualTo(Byte value) {
            addCriterion("se_status =", value, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusNotEqualTo(Byte value) {
            addCriterion("se_status <>", value, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusGreaterThan(Byte value) {
            addCriterion("se_status >", value, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("se_status >=", value, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusLessThan(Byte value) {
            addCriterion("se_status <", value, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusLessThanOrEqualTo(Byte value) {
            addCriterion("se_status <=", value, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusIn(List<Byte> values) {
            addCriterion("se_status in", values, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusNotIn(List<Byte> values) {
            addCriterion("se_status not in", values, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusBetween(Byte value1, Byte value2) {
            addCriterion("se_status between", value1, value2, "seStatus");
            return (Criteria) this;
        }

        public Criteria andSeStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("se_status not between", value1, value2, "seStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table srv_error
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table srv_error
     *
     * @mbg.generated
     */
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