package com.ccclubs.quota.orm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsModelExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    public CsModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
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
     * This method corresponds to the database table cs_model
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
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
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
     * This class corresponds to the database table cs_model
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

        public Criteria andCsmIdIsNull() {
            addCriterion("csm_id is null");
            return (Criteria) this;
        }

        public Criteria andCsmIdIsNotNull() {
            addCriterion("csm_id is not null");
            return (Criteria) this;
        }

        public Criteria andCsmIdEqualTo(Integer value) {
            addCriterion("csm_id =", value, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdNotEqualTo(Integer value) {
            addCriterion("csm_id <>", value, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdGreaterThan(Integer value) {
            addCriterion("csm_id >", value, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("csm_id >=", value, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdLessThan(Integer value) {
            addCriterion("csm_id <", value, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdLessThanOrEqualTo(Integer value) {
            addCriterion("csm_id <=", value, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdIn(List<Integer> values) {
            addCriterion("csm_id in", values, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdNotIn(List<Integer> values) {
            addCriterion("csm_id not in", values, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdBetween(Integer value1, Integer value2) {
            addCriterion("csm_id between", value1, value2, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("csm_id not between", value1, value2, "csmId");
            return (Criteria) this;
        }

        public Criteria andCsmNameIsNull() {
            addCriterion("csm_name is null");
            return (Criteria) this;
        }

        public Criteria andCsmNameIsNotNull() {
            addCriterion("csm_name is not null");
            return (Criteria) this;
        }

        public Criteria andCsmNameEqualTo(String value) {
            addCriterion("csm_name =", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameNotEqualTo(String value) {
            addCriterion("csm_name <>", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameGreaterThan(String value) {
            addCriterion("csm_name >", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameGreaterThanOrEqualTo(String value) {
            addCriterion("csm_name >=", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameLessThan(String value) {
            addCriterion("csm_name <", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameLessThanOrEqualTo(String value) {
            addCriterion("csm_name <=", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameLike(String value) {
            addCriterion("csm_name like", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameNotLike(String value) {
            addCriterion("csm_name not like", value, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameIn(List<String> values) {
            addCriterion("csm_name in", values, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameNotIn(List<String> values) {
            addCriterion("csm_name not in", values, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameBetween(String value1, String value2) {
            addCriterion("csm_name between", value1, value2, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmNameNotBetween(String value1, String value2) {
            addCriterion("csm_name not between", value1, value2, "csmName");
            return (Criteria) this;
        }

        public Criteria andCsmFlagIsNull() {
            addCriterion("csm_flag is null");
            return (Criteria) this;
        }

        public Criteria andCsmFlagIsNotNull() {
            addCriterion("csm_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCsmFlagEqualTo(String value) {
            addCriterion("csm_flag =", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagNotEqualTo(String value) {
            addCriterion("csm_flag <>", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagGreaterThan(String value) {
            addCriterion("csm_flag >", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagGreaterThanOrEqualTo(String value) {
            addCriterion("csm_flag >=", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagLessThan(String value) {
            addCriterion("csm_flag <", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagLessThanOrEqualTo(String value) {
            addCriterion("csm_flag <=", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagLike(String value) {
            addCriterion("csm_flag like", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagNotLike(String value) {
            addCriterion("csm_flag not like", value, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagIn(List<String> values) {
            addCriterion("csm_flag in", values, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagNotIn(List<String> values) {
            addCriterion("csm_flag not in", values, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagBetween(String value1, String value2) {
            addCriterion("csm_flag between", value1, value2, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmFlagNotBetween(String value1, String value2) {
            addCriterion("csm_flag not between", value1, value2, "csmFlag");
            return (Criteria) this;
        }

        public Criteria andCsmTypeIsNull() {
            addCriterion("csm_type is null");
            return (Criteria) this;
        }

        public Criteria andCsmTypeIsNotNull() {
            addCriterion("csm_type is not null");
            return (Criteria) this;
        }

        public Criteria andCsmTypeEqualTo(Integer value) {
            addCriterion("csm_type =", value, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeNotEqualTo(Integer value) {
            addCriterion("csm_type <>", value, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeGreaterThan(Integer value) {
            addCriterion("csm_type >", value, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("csm_type >=", value, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeLessThan(Integer value) {
            addCriterion("csm_type <", value, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeLessThanOrEqualTo(Integer value) {
            addCriterion("csm_type <=", value, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeIn(List<Integer> values) {
            addCriterion("csm_type in", values, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeNotIn(List<Integer> values) {
            addCriterion("csm_type not in", values, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeBetween(Integer value1, Integer value2) {
            addCriterion("csm_type between", value1, value2, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("csm_type not between", value1, value2, "csmType");
            return (Criteria) this;
        }

        public Criteria andCsmFileIsNull() {
            addCriterion("csm_file is null");
            return (Criteria) this;
        }

        public Criteria andCsmFileIsNotNull() {
            addCriterion("csm_file is not null");
            return (Criteria) this;
        }

        public Criteria andCsmFileEqualTo(Integer value) {
            addCriterion("csm_file =", value, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileNotEqualTo(Integer value) {
            addCriterion("csm_file <>", value, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileGreaterThan(Integer value) {
            addCriterion("csm_file >", value, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileGreaterThanOrEqualTo(Integer value) {
            addCriterion("csm_file >=", value, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileLessThan(Integer value) {
            addCriterion("csm_file <", value, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileLessThanOrEqualTo(Integer value) {
            addCriterion("csm_file <=", value, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileIn(List<Integer> values) {
            addCriterion("csm_file in", values, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileNotIn(List<Integer> values) {
            addCriterion("csm_file not in", values, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileBetween(Integer value1, Integer value2) {
            addCriterion("csm_file between", value1, value2, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmFileNotBetween(Integer value1, Integer value2) {
            addCriterion("csm_file not between", value1, value2, "csmFile");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryIsNull() {
            addCriterion("csm_catagory is null");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryIsNotNull() {
            addCriterion("csm_catagory is not null");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryEqualTo(Integer value) {
            addCriterion("csm_catagory =", value, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryNotEqualTo(Integer value) {
            addCriterion("csm_catagory <>", value, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryGreaterThan(Integer value) {
            addCriterion("csm_catagory >", value, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("csm_catagory >=", value, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryLessThan(Integer value) {
            addCriterion("csm_catagory <", value, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryLessThanOrEqualTo(Integer value) {
            addCriterion("csm_catagory <=", value, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryIn(List<Integer> values) {
            addCriterion("csm_catagory in", values, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryNotIn(List<Integer> values) {
            addCriterion("csm_catagory not in", values, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryBetween(Integer value1, Integer value2) {
            addCriterion("csm_catagory between", value1, value2, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmCatagoryNotBetween(Integer value1, Integer value2) {
            addCriterion("csm_catagory not between", value1, value2, "csmCatagory");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityIsNull() {
            addCriterion("csm_tank_capacity is null");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityIsNotNull() {
            addCriterion("csm_tank_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityEqualTo(BigDecimal value) {
            addCriterion("csm_tank_capacity =", value, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityNotEqualTo(BigDecimal value) {
            addCriterion("csm_tank_capacity <>", value, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityGreaterThan(BigDecimal value) {
            addCriterion("csm_tank_capacity >", value, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("csm_tank_capacity >=", value, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityLessThan(BigDecimal value) {
            addCriterion("csm_tank_capacity <", value, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("csm_tank_capacity <=", value, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityIn(List<BigDecimal> values) {
            addCriterion("csm_tank_capacity in", values, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityNotIn(List<BigDecimal> values) {
            addCriterion("csm_tank_capacity not in", values, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("csm_tank_capacity between", value1, value2, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmTankCapacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("csm_tank_capacity not between", value1, value2, "csmTankCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityIsNull() {
            addCriterion("csm_battery_capacity is null");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityIsNotNull() {
            addCriterion("csm_battery_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityEqualTo(BigDecimal value) {
            addCriterion("csm_battery_capacity =", value, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityNotEqualTo(BigDecimal value) {
            addCriterion("csm_battery_capacity <>", value, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityGreaterThan(BigDecimal value) {
            addCriterion("csm_battery_capacity >", value, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("csm_battery_capacity >=", value, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityLessThan(BigDecimal value) {
            addCriterion("csm_battery_capacity <", value, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("csm_battery_capacity <=", value, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityIn(List<BigDecimal> values) {
            addCriterion("csm_battery_capacity in", values, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityNotIn(List<BigDecimal> values) {
            addCriterion("csm_battery_capacity not in", values, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("csm_battery_capacity between", value1, value2, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmBatteryCapacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("csm_battery_capacity not between", value1, value2, "csmBatteryCapacity");
            return (Criteria) this;
        }

        public Criteria andCsmStatusIsNull() {
            addCriterion("csm_status is null");
            return (Criteria) this;
        }

        public Criteria andCsmStatusIsNotNull() {
            addCriterion("csm_status is not null");
            return (Criteria) this;
        }

        public Criteria andCsmStatusEqualTo(Integer value) {
            addCriterion("csm_status =", value, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusNotEqualTo(Integer value) {
            addCriterion("csm_status <>", value, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusGreaterThan(Integer value) {
            addCriterion("csm_status >", value, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("csm_status >=", value, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusLessThan(Integer value) {
            addCriterion("csm_status <", value, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusLessThanOrEqualTo(Integer value) {
            addCriterion("csm_status <=", value, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusIn(List<Integer> values) {
            addCriterion("csm_status in", values, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusNotIn(List<Integer> values) {
            addCriterion("csm_status not in", values, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusBetween(Integer value1, Integer value2) {
            addCriterion("csm_status between", value1, value2, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("csm_status not between", value1, value2, "csmStatus");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeIsNull() {
            addCriterion("csm_add_time is null");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeIsNotNull() {
            addCriterion("csm_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeEqualTo(Date value) {
            addCriterion("csm_add_time =", value, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeNotEqualTo(Date value) {
            addCriterion("csm_add_time <>", value, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeGreaterThan(Date value) {
            addCriterion("csm_add_time >", value, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("csm_add_time >=", value, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeLessThan(Date value) {
            addCriterion("csm_add_time <", value, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("csm_add_time <=", value, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeIn(List<Date> values) {
            addCriterion("csm_add_time in", values, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeNotIn(List<Date> values) {
            addCriterion("csm_add_time not in", values, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeBetween(Date value1, Date value2) {
            addCriterion("csm_add_time between", value1, value2, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("csm_add_time not between", value1, value2, "csmAddTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeIsNull() {
            addCriterion("csm_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeIsNotNull() {
            addCriterion("csm_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeEqualTo(Date value) {
            addCriterion("csm_update_time =", value, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeNotEqualTo(Date value) {
            addCriterion("csm_update_time <>", value, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeGreaterThan(Date value) {
            addCriterion("csm_update_time >", value, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("csm_update_time >=", value, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeLessThan(Date value) {
            addCriterion("csm_update_time <", value, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("csm_update_time <=", value, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeIn(List<Date> values) {
            addCriterion("csm_update_time in", values, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeNotIn(List<Date> values) {
            addCriterion("csm_update_time not in", values, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("csm_update_time between", value1, value2, "csmUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCsmUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("csm_update_time not between", value1, value2, "csmUpdateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cs_model
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
     * This class corresponds to the database table cs_model
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