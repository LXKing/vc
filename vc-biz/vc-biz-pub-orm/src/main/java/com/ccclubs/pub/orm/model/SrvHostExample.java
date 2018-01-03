package com.ccclubs.pub.orm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SrvHostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SrvHostExample() {
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

        public Criteria andShIdIsNull() {
            addCriterion("sh_id is null");
            return (Criteria) this;
        }

        public Criteria andShIdIsNotNull() {
            addCriterion("sh_id is not null");
            return (Criteria) this;
        }

        public Criteria andShIdEqualTo(Integer value) {
            addCriterion("sh_id =", value, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdNotEqualTo(Integer value) {
            addCriterion("sh_id <>", value, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdGreaterThan(Integer value) {
            addCriterion("sh_id >", value, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sh_id >=", value, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdLessThan(Integer value) {
            addCriterion("sh_id <", value, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdLessThanOrEqualTo(Integer value) {
            addCriterion("sh_id <=", value, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdIn(List<Integer> values) {
            addCriterion("sh_id in", values, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdNotIn(List<Integer> values) {
            addCriterion("sh_id not in", values, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdBetween(Integer value1, Integer value2) {
            addCriterion("sh_id between", value1, value2, "shId");
            return (Criteria) this;
        }

        public Criteria andShIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sh_id not between", value1, value2, "shId");
            return (Criteria) this;
        }

        public Criteria andShNameIsNull() {
            addCriterion("sh_name is null");
            return (Criteria) this;
        }

        public Criteria andShNameIsNotNull() {
            addCriterion("sh_name is not null");
            return (Criteria) this;
        }

        public Criteria andShNameEqualTo(String value) {
            addCriterion("sh_name =", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotEqualTo(String value) {
            addCriterion("sh_name <>", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameGreaterThan(String value) {
            addCriterion("sh_name >", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameGreaterThanOrEqualTo(String value) {
            addCriterion("sh_name >=", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameLessThan(String value) {
            addCriterion("sh_name <", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameLessThanOrEqualTo(String value) {
            addCriterion("sh_name <=", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameLike(String value) {
            addCriterion("sh_name like", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotLike(String value) {
            addCriterion("sh_name not like", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameIn(List<String> values) {
            addCriterion("sh_name in", values, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotIn(List<String> values) {
            addCriterion("sh_name not in", values, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameBetween(String value1, String value2) {
            addCriterion("sh_name between", value1, value2, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotBetween(String value1, String value2) {
            addCriterion("sh_name not between", value1, value2, "shName");
            return (Criteria) this;
        }

        public Criteria andShKeyIsNull() {
            addCriterion("sh_key is null");
            return (Criteria) this;
        }

        public Criteria andShKeyIsNotNull() {
            addCriterion("sh_key is not null");
            return (Criteria) this;
        }

        public Criteria andShKeyEqualTo(String value) {
            addCriterion("sh_key =", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyNotEqualTo(String value) {
            addCriterion("sh_key <>", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyGreaterThan(String value) {
            addCriterion("sh_key >", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sh_key >=", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyLessThan(String value) {
            addCriterion("sh_key <", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyLessThanOrEqualTo(String value) {
            addCriterion("sh_key <=", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyLike(String value) {
            addCriterion("sh_key like", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyNotLike(String value) {
            addCriterion("sh_key not like", value, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyIn(List<String> values) {
            addCriterion("sh_key in", values, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyNotIn(List<String> values) {
            addCriterion("sh_key not in", values, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyBetween(String value1, String value2) {
            addCriterion("sh_key between", value1, value2, "shKey");
            return (Criteria) this;
        }

        public Criteria andShKeyNotBetween(String value1, String value2) {
            addCriterion("sh_key not between", value1, value2, "shKey");
            return (Criteria) this;
        }

        public Criteria andShTopicIsNull() {
            addCriterion("sh_topic is null");
            return (Criteria) this;
        }

        public Criteria andShTopicIsNotNull() {
            addCriterion("sh_topic is not null");
            return (Criteria) this;
        }

        public Criteria andShTopicEqualTo(String value) {
            addCriterion("sh_topic =", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicNotEqualTo(String value) {
            addCriterion("sh_topic <>", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicGreaterThan(String value) {
            addCriterion("sh_topic >", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicGreaterThanOrEqualTo(String value) {
            addCriterion("sh_topic >=", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicLessThan(String value) {
            addCriterion("sh_topic <", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicLessThanOrEqualTo(String value) {
            addCriterion("sh_topic <=", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicLike(String value) {
            addCriterion("sh_topic like", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicNotLike(String value) {
            addCriterion("sh_topic not like", value, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicIn(List<String> values) {
            addCriterion("sh_topic in", values, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicNotIn(List<String> values) {
            addCriterion("sh_topic not in", values, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicBetween(String value1, String value2) {
            addCriterion("sh_topic between", value1, value2, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTopicNotBetween(String value1, String value2) {
            addCriterion("sh_topic not between", value1, value2, "shTopic");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteIsNull() {
            addCriterion("sh_transform_remote is null");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteIsNotNull() {
            addCriterion("sh_transform_remote is not null");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteEqualTo(String value) {
            addCriterion("sh_transform_remote =", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteNotEqualTo(String value) {
            addCriterion("sh_transform_remote <>", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteGreaterThan(String value) {
            addCriterion("sh_transform_remote >", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteGreaterThanOrEqualTo(String value) {
            addCriterion("sh_transform_remote >=", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteLessThan(String value) {
            addCriterion("sh_transform_remote <", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteLessThanOrEqualTo(String value) {
            addCriterion("sh_transform_remote <=", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteLike(String value) {
            addCriterion("sh_transform_remote like", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteNotLike(String value) {
            addCriterion("sh_transform_remote not like", value, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteIn(List<String> values) {
            addCriterion("sh_transform_remote in", values, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteNotIn(List<String> values) {
            addCriterion("sh_transform_remote not in", values, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteBetween(String value1, String value2) {
            addCriterion("sh_transform_remote between", value1, value2, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformRemoteNotBetween(String value1, String value2) {
            addCriterion("sh_transform_remote not between", value1, value2, "shTransformRemote");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusIsNull() {
            addCriterion("sh_transform_status is null");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusIsNotNull() {
            addCriterion("sh_transform_status is not null");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusEqualTo(String value) {
            addCriterion("sh_transform_status =", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusNotEqualTo(String value) {
            addCriterion("sh_transform_status <>", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusGreaterThan(String value) {
            addCriterion("sh_transform_status >", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sh_transform_status >=", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusLessThan(String value) {
            addCriterion("sh_transform_status <", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusLessThanOrEqualTo(String value) {
            addCriterion("sh_transform_status <=", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusLike(String value) {
            addCriterion("sh_transform_status like", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusNotLike(String value) {
            addCriterion("sh_transform_status not like", value, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusIn(List<String> values) {
            addCriterion("sh_transform_status in", values, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusNotIn(List<String> values) {
            addCriterion("sh_transform_status not in", values, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusBetween(String value1, String value2) {
            addCriterion("sh_transform_status between", value1, value2, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformStatusNotBetween(String value1, String value2) {
            addCriterion("sh_transform_status not between", value1, value2, "shTransformStatus");
            return (Criteria) this;
        }

        public Criteria andShTransformCanIsNull() {
            addCriterion("sh_transform_can is null");
            return (Criteria) this;
        }

        public Criteria andShTransformCanIsNotNull() {
            addCriterion("sh_transform_can is not null");
            return (Criteria) this;
        }

        public Criteria andShTransformCanEqualTo(String value) {
            addCriterion("sh_transform_can =", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanNotEqualTo(String value) {
            addCriterion("sh_transform_can <>", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanGreaterThan(String value) {
            addCriterion("sh_transform_can >", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanGreaterThanOrEqualTo(String value) {
            addCriterion("sh_transform_can >=", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanLessThan(String value) {
            addCriterion("sh_transform_can <", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanLessThanOrEqualTo(String value) {
            addCriterion("sh_transform_can <=", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanLike(String value) {
            addCriterion("sh_transform_can like", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanNotLike(String value) {
            addCriterion("sh_transform_can not like", value, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanIn(List<String> values) {
            addCriterion("sh_transform_can in", values, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanNotIn(List<String> values) {
            addCriterion("sh_transform_can not in", values, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanBetween(String value1, String value2) {
            addCriterion("sh_transform_can between", value1, value2, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShTransformCanNotBetween(String value1, String value2) {
            addCriterion("sh_transform_can not between", value1, value2, "shTransformCan");
            return (Criteria) this;
        }

        public Criteria andShAddTimeIsNull() {
            addCriterion("sh_add_time is null");
            return (Criteria) this;
        }

        public Criteria andShAddTimeIsNotNull() {
            addCriterion("sh_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andShAddTimeEqualTo(Date value) {
            addCriterion("sh_add_time =", value, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeNotEqualTo(Date value) {
            addCriterion("sh_add_time <>", value, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeGreaterThan(Date value) {
            addCriterion("sh_add_time >", value, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sh_add_time >=", value, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeLessThan(Date value) {
            addCriterion("sh_add_time <", value, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("sh_add_time <=", value, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeIn(List<Date> values) {
            addCriterion("sh_add_time in", values, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeNotIn(List<Date> values) {
            addCriterion("sh_add_time not in", values, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeBetween(Date value1, Date value2) {
            addCriterion("sh_add_time between", value1, value2, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("sh_add_time not between", value1, value2, "shAddTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeIsNull() {
            addCriterion("sh_upt_time is null");
            return (Criteria) this;
        }

        public Criteria andShUptTimeIsNotNull() {
            addCriterion("sh_upt_time is not null");
            return (Criteria) this;
        }

        public Criteria andShUptTimeEqualTo(Date value) {
            addCriterion("sh_upt_time =", value, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeNotEqualTo(Date value) {
            addCriterion("sh_upt_time <>", value, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeGreaterThan(Date value) {
            addCriterion("sh_upt_time >", value, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sh_upt_time >=", value, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeLessThan(Date value) {
            addCriterion("sh_upt_time <", value, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeLessThanOrEqualTo(Date value) {
            addCriterion("sh_upt_time <=", value, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeIn(List<Date> values) {
            addCriterion("sh_upt_time in", values, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeNotIn(List<Date> values) {
            addCriterion("sh_upt_time not in", values, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeBetween(Date value1, Date value2) {
            addCriterion("sh_upt_time between", value1, value2, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShUptTimeNotBetween(Date value1, Date value2) {
            addCriterion("sh_upt_time not between", value1, value2, "shUptTime");
            return (Criteria) this;
        }

        public Criteria andShStatusIsNull() {
            addCriterion("sh_status is null");
            return (Criteria) this;
        }

        public Criteria andShStatusIsNotNull() {
            addCriterion("sh_status is not null");
            return (Criteria) this;
        }

        public Criteria andShStatusEqualTo(Byte value) {
            addCriterion("sh_status =", value, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusNotEqualTo(Byte value) {
            addCriterion("sh_status <>", value, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusGreaterThan(Byte value) {
            addCriterion("sh_status >", value, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("sh_status >=", value, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusLessThan(Byte value) {
            addCriterion("sh_status <", value, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusLessThanOrEqualTo(Byte value) {
            addCriterion("sh_status <=", value, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusIn(List<Byte> values) {
            addCriterion("sh_status in", values, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusNotIn(List<Byte> values) {
            addCriterion("sh_status not in", values, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusBetween(Byte value1, Byte value2) {
            addCriterion("sh_status between", value1, value2, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("sh_status not between", value1, value2, "shStatus");
            return (Criteria) this;
        }

        public Criteria andShAppidIsNull() {
            addCriterion("sh_appid is null");
            return (Criteria) this;
        }

        public Criteria andShAppidIsNotNull() {
            addCriterion("sh_appid is not null");
            return (Criteria) this;
        }

        public Criteria andShAppidEqualTo(String value) {
            addCriterion("sh_appid =", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidNotEqualTo(String value) {
            addCriterion("sh_appid <>", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidGreaterThan(String value) {
            addCriterion("sh_appid >", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidGreaterThanOrEqualTo(String value) {
            addCriterion("sh_appid >=", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidLessThan(String value) {
            addCriterion("sh_appid <", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidLessThanOrEqualTo(String value) {
            addCriterion("sh_appid <=", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidLike(String value) {
            addCriterion("sh_appid like", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidNotLike(String value) {
            addCriterion("sh_appid not like", value, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidIn(List<String> values) {
            addCriterion("sh_appid in", values, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidNotIn(List<String> values) {
            addCriterion("sh_appid not in", values, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidBetween(String value1, String value2) {
            addCriterion("sh_appid between", value1, value2, "shAppid");
            return (Criteria) this;
        }

        public Criteria andShAppidNotBetween(String value1, String value2) {
            addCriterion("sh_appid not between", value1, value2, "shAppid");
            return (Criteria) this;
        }
    }

    /**
     */
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