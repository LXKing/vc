package com.ccclubs.demo.orm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsMachineMappingExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    public CsMachineMappingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
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
     * This method corresponds to the database table cs_machine_mapping
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
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
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
     * This class corresponds to the database table cs_machine_mapping
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

        public Criteria andCsIdIsNull() {
            addCriterion("cs_id is null");
            return (Criteria) this;
        }

        public Criteria andCsIdIsNotNull() {
            addCriterion("cs_id is not null");
            return (Criteria) this;
        }

        public Criteria andCsIdEqualTo(Integer value) {
            addCriterion("cs_id =", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotEqualTo(Integer value) {
            addCriterion("cs_id <>", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThan(Integer value) {
            addCriterion("cs_id >", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs_id >=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThan(Integer value) {
            addCriterion("cs_id <", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThanOrEqualTo(Integer value) {
            addCriterion("cs_id <=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdIn(List<Integer> values) {
            addCriterion("cs_id in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotIn(List<Integer> values) {
            addCriterion("cs_id not in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdBetween(Integer value1, Integer value2) {
            addCriterion("cs_id between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cs_id not between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCsAccessIsNull() {
            addCriterion("cs_access is null");
            return (Criteria) this;
        }

        public Criteria andCsAccessIsNotNull() {
            addCriterion("cs_access is not null");
            return (Criteria) this;
        }

        public Criteria andCsAccessEqualTo(Byte value) {
            addCriterion("cs_access =", value, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessNotEqualTo(Byte value) {
            addCriterion("cs_access <>", value, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessGreaterThan(Byte value) {
            addCriterion("cs_access >", value, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessGreaterThanOrEqualTo(Byte value) {
            addCriterion("cs_access >=", value, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessLessThan(Byte value) {
            addCriterion("cs_access <", value, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessLessThanOrEqualTo(Byte value) {
            addCriterion("cs_access <=", value, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessIn(List<Byte> values) {
            addCriterion("cs_access in", values, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessNotIn(List<Byte> values) {
            addCriterion("cs_access not in", values, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessBetween(Byte value1, Byte value2) {
            addCriterion("cs_access between", value1, value2, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsAccessNotBetween(Byte value1, Byte value2) {
            addCriterion("cs_access not between", value1, value2, "csAccess");
            return (Criteria) this;
        }

        public Criteria andCsTeNoIsNull() {
            addCriterion("cs_te_no is null");
            return (Criteria) this;
        }

        public Criteria andCsTeNoIsNotNull() {
            addCriterion("cs_te_no is not null");
            return (Criteria) this;
        }

        public Criteria andCsTeNoEqualTo(String value) {
            addCriterion("cs_te_no =", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoNotEqualTo(String value) {
            addCriterion("cs_te_no <>", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoGreaterThan(String value) {
            addCriterion("cs_te_no >", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoGreaterThanOrEqualTo(String value) {
            addCriterion("cs_te_no >=", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoLessThan(String value) {
            addCriterion("cs_te_no <", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoLessThanOrEqualTo(String value) {
            addCriterion("cs_te_no <=", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoLike(String value) {
            addCriterion("cs_te_no like", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoNotLike(String value) {
            addCriterion("cs_te_no not like", value, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoIn(List<String> values) {
            addCriterion("cs_te_no in", values, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoNotIn(List<String> values) {
            addCriterion("cs_te_no not in", values, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoBetween(String value1, String value2) {
            addCriterion("cs_te_no between", value1, value2, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsTeNoNotBetween(String value1, String value2) {
            addCriterion("cs_te_no not between", value1, value2, "csTeNo");
            return (Criteria) this;
        }

        public Criteria andCsNumberIsNull() {
            addCriterion("cs_number is null");
            return (Criteria) this;
        }

        public Criteria andCsNumberIsNotNull() {
            addCriterion("cs_number is not null");
            return (Criteria) this;
        }

        public Criteria andCsNumberEqualTo(String value) {
            addCriterion("cs_number =", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotEqualTo(String value) {
            addCriterion("cs_number <>", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberGreaterThan(String value) {
            addCriterion("cs_number >", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("cs_number >=", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberLessThan(String value) {
            addCriterion("cs_number <", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberLessThanOrEqualTo(String value) {
            addCriterion("cs_number <=", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberLike(String value) {
            addCriterion("cs_number like", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotLike(String value) {
            addCriterion("cs_number not like", value, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberIn(List<String> values) {
            addCriterion("cs_number in", values, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotIn(List<String> values) {
            addCriterion("cs_number not in", values, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberBetween(String value1, String value2) {
            addCriterion("cs_number between", value1, value2, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsNumberNotBetween(String value1, String value2) {
            addCriterion("cs_number not between", value1, value2, "csNumber");
            return (Criteria) this;
        }

        public Criteria andCsMobileIsNull() {
            addCriterion("cs_mobile is null");
            return (Criteria) this;
        }

        public Criteria andCsMobileIsNotNull() {
            addCriterion("cs_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andCsMobileEqualTo(String value) {
            addCriterion("cs_mobile =", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileNotEqualTo(String value) {
            addCriterion("cs_mobile <>", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileGreaterThan(String value) {
            addCriterion("cs_mobile >", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileGreaterThanOrEqualTo(String value) {
            addCriterion("cs_mobile >=", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileLessThan(String value) {
            addCriterion("cs_mobile <", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileLessThanOrEqualTo(String value) {
            addCriterion("cs_mobile <=", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileLike(String value) {
            addCriterion("cs_mobile like", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileNotLike(String value) {
            addCriterion("cs_mobile not like", value, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileIn(List<String> values) {
            addCriterion("cs_mobile in", values, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileNotIn(List<String> values) {
            addCriterion("cs_mobile not in", values, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileBetween(String value1, String value2) {
            addCriterion("cs_mobile between", value1, value2, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsMobileNotBetween(String value1, String value2) {
            addCriterion("cs_mobile not between", value1, value2, "csMobile");
            return (Criteria) this;
        }

        public Criteria andCsVinIsNull() {
            addCriterion("cs_vin is null");
            return (Criteria) this;
        }

        public Criteria andCsVinIsNotNull() {
            addCriterion("cs_vin is not null");
            return (Criteria) this;
        }

        public Criteria andCsVinEqualTo(String value) {
            addCriterion("cs_vin =", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotEqualTo(String value) {
            addCriterion("cs_vin <>", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinGreaterThan(String value) {
            addCriterion("cs_vin >", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinGreaterThanOrEqualTo(String value) {
            addCriterion("cs_vin >=", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinLessThan(String value) {
            addCriterion("cs_vin <", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinLessThanOrEqualTo(String value) {
            addCriterion("cs_vin <=", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinLike(String value) {
            addCriterion("cs_vin like", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotLike(String value) {
            addCriterion("cs_vin not like", value, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinIn(List<String> values) {
            addCriterion("cs_vin in", values, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotIn(List<String> values) {
            addCriterion("cs_vin not in", values, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinBetween(String value1, String value2) {
            addCriterion("cs_vin between", value1, value2, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsVinNotBetween(String value1, String value2) {
            addCriterion("cs_vin not between", value1, value2, "csVin");
            return (Criteria) this;
        }

        public Criteria andCsCarNoIsNull() {
            addCriterion("cs_car_no is null");
            return (Criteria) this;
        }

        public Criteria andCsCarNoIsNotNull() {
            addCriterion("cs_car_no is not null");
            return (Criteria) this;
        }

        public Criteria andCsCarNoEqualTo(String value) {
            addCriterion("cs_car_no =", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoNotEqualTo(String value) {
            addCriterion("cs_car_no <>", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoGreaterThan(String value) {
            addCriterion("cs_car_no >", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoGreaterThanOrEqualTo(String value) {
            addCriterion("cs_car_no >=", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoLessThan(String value) {
            addCriterion("cs_car_no <", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoLessThanOrEqualTo(String value) {
            addCriterion("cs_car_no <=", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoLike(String value) {
            addCriterion("cs_car_no like", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoNotLike(String value) {
            addCriterion("cs_car_no not like", value, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoIn(List<String> values) {
            addCriterion("cs_car_no in", values, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoNotIn(List<String> values) {
            addCriterion("cs_car_no not in", values, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoBetween(String value1, String value2) {
            addCriterion("cs_car_no between", value1, value2, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsCarNoNotBetween(String value1, String value2) {
            addCriterion("cs_car_no not between", value1, value2, "csCarNo");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeIsNull() {
            addCriterion("cs_te_type is null");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeIsNotNull() {
            addCriterion("cs_te_type is not null");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeEqualTo(Byte value) {
            addCriterion("cs_te_type =", value, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeNotEqualTo(Byte value) {
            addCriterion("cs_te_type <>", value, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeGreaterThan(Byte value) {
            addCriterion("cs_te_type >", value, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("cs_te_type >=", value, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeLessThan(Byte value) {
            addCriterion("cs_te_type <", value, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("cs_te_type <=", value, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeIn(List<Byte> values) {
            addCriterion("cs_te_type in", values, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeNotIn(List<Byte> values) {
            addCriterion("cs_te_type not in", values, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeBetween(Byte value1, Byte value2) {
            addCriterion("cs_te_type between", value1, value2, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCsTeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("cs_te_type not between", value1, value2, "csTeType");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cs_machine_mapping
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
     * This class corresponds to the database table cs_machine_mapping
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