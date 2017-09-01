package com.ccclubs.demo.orm.model;

import java.util.ArrayList;
import java.util.List;

public class SrvGroupExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    public SrvGroupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
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
     * This method corresponds to the database table srv_group
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
     * This method corresponds to the database table srv_group
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_group
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
     * This class corresponds to the database table srv_group
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

        public Criteria andSgIdIsNull() {
            addCriterion("sg_id is null");
            return (Criteria) this;
        }

        public Criteria andSgIdIsNotNull() {
            addCriterion("sg_id is not null");
            return (Criteria) this;
        }

        public Criteria andSgIdEqualTo(Long value) {
            addCriterion("sg_id =", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdNotEqualTo(Long value) {
            addCriterion("sg_id <>", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdGreaterThan(Long value) {
            addCriterion("sg_id >", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sg_id >=", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdLessThan(Long value) {
            addCriterion("sg_id <", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdLessThanOrEqualTo(Long value) {
            addCriterion("sg_id <=", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdIn(List<Long> values) {
            addCriterion("sg_id in", values, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdNotIn(List<Long> values) {
            addCriterion("sg_id not in", values, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdBetween(Long value1, Long value2) {
            addCriterion("sg_id between", value1, value2, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdNotBetween(Long value1, Long value2) {
            addCriterion("sg_id not between", value1, value2, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgNameIsNull() {
            addCriterion("sg_name is null");
            return (Criteria) this;
        }

        public Criteria andSgNameIsNotNull() {
            addCriterion("sg_name is not null");
            return (Criteria) this;
        }

        public Criteria andSgNameEqualTo(String value) {
            addCriterion("sg_name =", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotEqualTo(String value) {
            addCriterion("sg_name <>", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameGreaterThan(String value) {
            addCriterion("sg_name >", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameGreaterThanOrEqualTo(String value) {
            addCriterion("sg_name >=", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameLessThan(String value) {
            addCriterion("sg_name <", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameLessThanOrEqualTo(String value) {
            addCriterion("sg_name <=", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameLike(String value) {
            addCriterion("sg_name like", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotLike(String value) {
            addCriterion("sg_name not like", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameIn(List<String> values) {
            addCriterion("sg_name in", values, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotIn(List<String> values) {
            addCriterion("sg_name not in", values, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameBetween(String value1, String value2) {
            addCriterion("sg_name between", value1, value2, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotBetween(String value1, String value2) {
            addCriterion("sg_name not between", value1, value2, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgParentIdIsNull() {
            addCriterion("sg_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andSgParentIdIsNotNull() {
            addCriterion("sg_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andSgParentIdEqualTo(Long value) {
            addCriterion("sg_parent_id =", value, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdNotEqualTo(Long value) {
            addCriterion("sg_parent_id <>", value, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdGreaterThan(Long value) {
            addCriterion("sg_parent_id >", value, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sg_parent_id >=", value, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdLessThan(Long value) {
            addCriterion("sg_parent_id <", value, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdLessThanOrEqualTo(Long value) {
            addCriterion("sg_parent_id <=", value, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdIn(List<Long> values) {
            addCriterion("sg_parent_id in", values, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdNotIn(List<Long> values) {
            addCriterion("sg_parent_id not in", values, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdBetween(Long value1, Long value2) {
            addCriterion("sg_parent_id between", value1, value2, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgParentIdNotBetween(Long value1, Long value2) {
            addCriterion("sg_parent_id not between", value1, value2, "sgParentId");
            return (Criteria) this;
        }

        public Criteria andSgFamilyIsNull() {
            addCriterion("sg_family is null");
            return (Criteria) this;
        }

        public Criteria andSgFamilyIsNotNull() {
            addCriterion("sg_family is not null");
            return (Criteria) this;
        }

        public Criteria andSgFamilyEqualTo(String value) {
            addCriterion("sg_family =", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyNotEqualTo(String value) {
            addCriterion("sg_family <>", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyGreaterThan(String value) {
            addCriterion("sg_family >", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyGreaterThanOrEqualTo(String value) {
            addCriterion("sg_family >=", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyLessThan(String value) {
            addCriterion("sg_family <", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyLessThanOrEqualTo(String value) {
            addCriterion("sg_family <=", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyLike(String value) {
            addCriterion("sg_family like", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyNotLike(String value) {
            addCriterion("sg_family not like", value, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyIn(List<String> values) {
            addCriterion("sg_family in", values, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyNotIn(List<String> values) {
            addCriterion("sg_family not in", values, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyBetween(String value1, String value2) {
            addCriterion("sg_family between", value1, value2, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFamilyNotBetween(String value1, String value2) {
            addCriterion("sg_family not between", value1, value2, "sgFamily");
            return (Criteria) this;
        }

        public Criteria andSgFlagIsNull() {
            addCriterion("sg_flag is null");
            return (Criteria) this;
        }

        public Criteria andSgFlagIsNotNull() {
            addCriterion("sg_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSgFlagEqualTo(String value) {
            addCriterion("sg_flag =", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagNotEqualTo(String value) {
            addCriterion("sg_flag <>", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagGreaterThan(String value) {
            addCriterion("sg_flag >", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagGreaterThanOrEqualTo(String value) {
            addCriterion("sg_flag >=", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagLessThan(String value) {
            addCriterion("sg_flag <", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagLessThanOrEqualTo(String value) {
            addCriterion("sg_flag <=", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagLike(String value) {
            addCriterion("sg_flag like", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagNotLike(String value) {
            addCriterion("sg_flag not like", value, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagIn(List<String> values) {
            addCriterion("sg_flag in", values, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagNotIn(List<String> values) {
            addCriterion("sg_flag not in", values, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagBetween(String value1, String value2) {
            addCriterion("sg_flag between", value1, value2, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgFlagNotBetween(String value1, String value2) {
            addCriterion("sg_flag not between", value1, value2, "sgFlag");
            return (Criteria) this;
        }

        public Criteria andSgStatusIsNull() {
            addCriterion("sg_status is null");
            return (Criteria) this;
        }

        public Criteria andSgStatusIsNotNull() {
            addCriterion("sg_status is not null");
            return (Criteria) this;
        }

        public Criteria andSgStatusEqualTo(Short value) {
            addCriterion("sg_status =", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusNotEqualTo(Short value) {
            addCriterion("sg_status <>", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusGreaterThan(Short value) {
            addCriterion("sg_status >", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("sg_status >=", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusLessThan(Short value) {
            addCriterion("sg_status <", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusLessThanOrEqualTo(Short value) {
            addCriterion("sg_status <=", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusIn(List<Short> values) {
            addCriterion("sg_status in", values, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusNotIn(List<Short> values) {
            addCriterion("sg_status not in", values, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusBetween(Short value1, Short value2) {
            addCriterion("sg_status between", value1, value2, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusNotBetween(Short value1, Short value2) {
            addCriterion("sg_status not between", value1, value2, "sgStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table srv_group
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
     * This class corresponds to the database table srv_group
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