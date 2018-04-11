package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 用户管理数据查询条件对象
 * @author Joel
 */
public class SrvUserCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public SrvUserCrieria() {
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
	        public Criteria andsuIdIsNull() {
	            addCriterion("su_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdIsNotNull() {
	            addCriterion("su_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsuIdEqualTo(Integer value) {
	            addCriterion("su_id =", value, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdNotEqualTo(Integer value) {
	            addCriterion("su_id <>", value, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdGreaterThan(Integer value) {
	            addCriterion("su_id >", value, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("su_id >=", value, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdLessThan(Integer value) {
	            addCriterion("su_id <", value, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdLessThanOrEqualTo(Integer value) {
	            addCriterion("su_id <=", value, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdIn(List<Integer> values) {
	            addCriterion("su_id in", values, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdNotIn(List<Integer> values) {
	            addCriterion("su_id not in", values, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdBetween(Integer value1, Integer value2) {
	            addCriterion("su_id between", value1, value2, "suId");
	            return (Criteria) this;
	        }

	        public Criteria andsuIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("su_id not between", value1, value2, "suId");
	            return (Criteria) this;
	        }
	        public Criteria andsuHostIsNull() {
	            addCriterion("su_host is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostIsNotNull() {
	            addCriterion("su_host is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuHostLike(String value) {
	            addCriterion("su_host like", "%"+value+"%", "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostNotLike(String value) {
	            addCriterion("su_host not like", "%"+value+"%", "suHost");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuHostEqualTo(String value) {
	            addCriterion("su_host =", value, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostNotEqualTo(String value) {
	            addCriterion("su_host <>", value, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostGreaterThan(String value) {
	            addCriterion("su_host >", value, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostGreaterThanOrEqualTo(String value) {
	            addCriterion("su_host >=", value, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostLessThan(String value) {
	            addCriterion("su_host <", value, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostLessThanOrEqualTo(String value) {
	            addCriterion("su_host <=", value, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostIn(List<String> values) {
	            addCriterion("su_host in", values, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostNotIn(List<String> values) {
	            addCriterion("su_host not in", values, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostBetween(String value1, String value2) {
	            addCriterion("su_host between", value1, value2, "suHost");
	            return (Criteria) this;
	        }

	        public Criteria andsuHostNotBetween(String value1, String value2) {
	            addCriterion("su_host not between", value1, value2, "suHost");
	            return (Criteria) this;
	        }
	        public Criteria andsuGroupIsNull() {
	            addCriterion("su_group is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupIsNotNull() {
	            addCriterion("su_group is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsuGroupEqualTo(Long value) {
	            addCriterion("su_group =", value, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupNotEqualTo(Long value) {
	            addCriterion("su_group <>", value, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupGreaterThan(Long value) {
	            addCriterion("su_group >", value, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupGreaterThanOrEqualTo(Long value) {
	            addCriterion("su_group >=", value, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupLessThan(Long value) {
	            addCriterion("su_group <", value, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupLessThanOrEqualTo(Long value) {
	            addCriterion("su_group <=", value, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupIn(List<Long> values) {
	            addCriterion("su_group in", values, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupNotIn(List<Long> values) {
	            addCriterion("su_group not in", values, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupBetween(Long value1, Long value2) {
	            addCriterion("su_group between", value1, value2, "suGroup");
	            return (Criteria) this;
	        }

	        public Criteria andsuGroupNotBetween(Long value1, Long value2) {
	            addCriterion("su_group not between", value1, value2, "suGroup");
	            return (Criteria) this;
	        }
	        public Criteria andsuUsernameIsNull() {
	            addCriterion("su_username is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameIsNotNull() {
	            addCriterion("su_username is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuUsernameLike(String value) {
	            addCriterion("su_username like", "%"+value+"%", "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameNotLike(String value) {
	            addCriterion("su_username not like", "%"+value+"%", "suUsername");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuUsernameEqualTo(String value) {
	            addCriterion("su_username =", value, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameNotEqualTo(String value) {
	            addCriterion("su_username <>", value, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameGreaterThan(String value) {
	            addCriterion("su_username >", value, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameGreaterThanOrEqualTo(String value) {
	            addCriterion("su_username >=", value, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameLessThan(String value) {
	            addCriterion("su_username <", value, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameLessThanOrEqualTo(String value) {
	            addCriterion("su_username <=", value, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameIn(List<String> values) {
	            addCriterion("su_username in", values, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameNotIn(List<String> values) {
	            addCriterion("su_username not in", values, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameBetween(String value1, String value2) {
	            addCriterion("su_username between", value1, value2, "suUsername");
	            return (Criteria) this;
	        }

	        public Criteria andsuUsernameNotBetween(String value1, String value2) {
	            addCriterion("su_username not between", value1, value2, "suUsername");
	            return (Criteria) this;
	        }
	        public Criteria andsuPasswordIsNull() {
	            addCriterion("su_password is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordIsNotNull() {
	            addCriterion("su_password is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuPasswordLike(String value) {
	            addCriterion("su_password like", "%"+value+"%", "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordNotLike(String value) {
	            addCriterion("su_password not like", "%"+value+"%", "suPassword");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuPasswordEqualTo(String value) {
	            addCriterion("su_password =", value, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordNotEqualTo(String value) {
	            addCriterion("su_password <>", value, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordGreaterThan(String value) {
	            addCriterion("su_password >", value, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordGreaterThanOrEqualTo(String value) {
	            addCriterion("su_password >=", value, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordLessThan(String value) {
	            addCriterion("su_password <", value, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordLessThanOrEqualTo(String value) {
	            addCriterion("su_password <=", value, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordIn(List<String> values) {
	            addCriterion("su_password in", values, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordNotIn(List<String> values) {
	            addCriterion("su_password not in", values, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordBetween(String value1, String value2) {
	            addCriterion("su_password between", value1, value2, "suPassword");
	            return (Criteria) this;
	        }

	        public Criteria andsuPasswordNotBetween(String value1, String value2) {
	            addCriterion("su_password not between", value1, value2, "suPassword");
	            return (Criteria) this;
	        }
	        public Criteria andsuRealNameIsNull() {
	            addCriterion("su_real_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameIsNotNull() {
	            addCriterion("su_real_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuRealNameLike(String value) {
	            addCriterion("su_real_name like", "%"+value+"%", "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameNotLike(String value) {
	            addCriterion("su_real_name not like", "%"+value+"%", "suRealName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuRealNameEqualTo(String value) {
	            addCriterion("su_real_name =", value, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameNotEqualTo(String value) {
	            addCriterion("su_real_name <>", value, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameGreaterThan(String value) {
	            addCriterion("su_real_name >", value, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameGreaterThanOrEqualTo(String value) {
	            addCriterion("su_real_name >=", value, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameLessThan(String value) {
	            addCriterion("su_real_name <", value, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameLessThanOrEqualTo(String value) {
	            addCriterion("su_real_name <=", value, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameIn(List<String> values) {
	            addCriterion("su_real_name in", values, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameNotIn(List<String> values) {
	            addCriterion("su_real_name not in", values, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameBetween(String value1, String value2) {
	            addCriterion("su_real_name between", value1, value2, "suRealName");
	            return (Criteria) this;
	        }

	        public Criteria andsuRealNameNotBetween(String value1, String value2) {
	            addCriterion("su_real_name not between", value1, value2, "suRealName");
	            return (Criteria) this;
	        }
	        public Criteria andsuMobileIsNull() {
	            addCriterion("su_mobile is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileIsNotNull() {
	            addCriterion("su_mobile is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuMobileLike(String value) {
	            addCriterion("su_mobile like", "%"+value+"%", "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileNotLike(String value) {
	            addCriterion("su_mobile not like", "%"+value+"%", "suMobile");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuMobileEqualTo(String value) {
	            addCriterion("su_mobile =", value, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileNotEqualTo(String value) {
	            addCriterion("su_mobile <>", value, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileGreaterThan(String value) {
	            addCriterion("su_mobile >", value, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileGreaterThanOrEqualTo(String value) {
	            addCriterion("su_mobile >=", value, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileLessThan(String value) {
	            addCriterion("su_mobile <", value, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileLessThanOrEqualTo(String value) {
	            addCriterion("su_mobile <=", value, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileIn(List<String> values) {
	            addCriterion("su_mobile in", values, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileNotIn(List<String> values) {
	            addCriterion("su_mobile not in", values, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileBetween(String value1, String value2) {
	            addCriterion("su_mobile between", value1, value2, "suMobile");
	            return (Criteria) this;
	        }

	        public Criteria andsuMobileNotBetween(String value1, String value2) {
	            addCriterion("su_mobile not between", value1, value2, "suMobile");
	            return (Criteria) this;
	        }
	        public Criteria andsuShortcutIsNull() {
	            addCriterion("su_shortcut is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutIsNotNull() {
	            addCriterion("su_shortcut is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuShortcutLike(String value) {
	            addCriterion("su_shortcut like", "%"+value+"%", "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutNotLike(String value) {
	            addCriterion("su_shortcut not like", "%"+value+"%", "suShortcut");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuShortcutEqualTo(String value) {
	            addCriterion("su_shortcut =", value, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutNotEqualTo(String value) {
	            addCriterion("su_shortcut <>", value, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutGreaterThan(String value) {
	            addCriterion("su_shortcut >", value, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutGreaterThanOrEqualTo(String value) {
	            addCriterion("su_shortcut >=", value, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutLessThan(String value) {
	            addCriterion("su_shortcut <", value, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutLessThanOrEqualTo(String value) {
	            addCriterion("su_shortcut <=", value, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutIn(List<String> values) {
	            addCriterion("su_shortcut in", values, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutNotIn(List<String> values) {
	            addCriterion("su_shortcut not in", values, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutBetween(String value1, String value2) {
	            addCriterion("su_shortcut between", value1, value2, "suShortcut");
	            return (Criteria) this;
	        }

	        public Criteria andsuShortcutNotBetween(String value1, String value2) {
	            addCriterion("su_shortcut not between", value1, value2, "suShortcut");
	            return (Criteria) this;
	        }
	        public Criteria andsuAddTimeIsNull() {
	            addCriterion("su_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeIsNotNull() {
	            addCriterion("su_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsuAddTimeEqualTo(Date value) {
	            addCriterion("su_add_time =", value, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeNotEqualTo(Date value) {
	            addCriterion("su_add_time <>", value, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeGreaterThan(Date value) {
	            addCriterion("su_add_time >", value, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("su_add_time >=", value, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeLessThan(Date value) {
	            addCriterion("su_add_time <", value, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("su_add_time <=", value, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeIn(List<Date> values) {
	            addCriterion("su_add_time in", values, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeNotIn(List<Date> values) {
	            addCriterion("su_add_time not in", values, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeBetween(Date value1, Date value2) {
	            addCriterion("su_add_time between", value1, value2, "suAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("su_add_time not between", value1, value2, "suAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andsuLastTimeIsNull() {
	            addCriterion("su_last_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeIsNotNull() {
	            addCriterion("su_last_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsuLastTimeEqualTo(Date value) {
	            addCriterion("su_last_time =", value, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeNotEqualTo(Date value) {
	            addCriterion("su_last_time <>", value, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeGreaterThan(Date value) {
	            addCriterion("su_last_time >", value, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("su_last_time >=", value, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeLessThan(Date value) {
	            addCriterion("su_last_time <", value, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeLessThanOrEqualTo(Date value) {
	            addCriterion("su_last_time <=", value, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeIn(List<Date> values) {
	            addCriterion("su_last_time in", values, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeNotIn(List<Date> values) {
	            addCriterion("su_last_time not in", values, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeBetween(Date value1, Date value2) {
	            addCriterion("su_last_time between", value1, value2, "suLastTime");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastTimeNotBetween(Date value1, Date value2) {
	            addCriterion("su_last_time not between", value1, value2, "suLastTime");
	            return (Criteria) this;
	        }
	        public Criteria andsuLastIpIsNull() {
	            addCriterion("su_last_ip is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpIsNotNull() {
	            addCriterion("su_last_ip is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuLastIpLike(String value) {
	            addCriterion("su_last_ip like", "%"+value+"%", "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpNotLike(String value) {
	            addCriterion("su_last_ip not like", "%"+value+"%", "suLastIp");
	            return (Criteria) this;
	        }
	        
	        public Criteria andsuLastIpEqualTo(String value) {
	            addCriterion("su_last_ip =", value, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpNotEqualTo(String value) {
	            addCriterion("su_last_ip <>", value, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpGreaterThan(String value) {
	            addCriterion("su_last_ip >", value, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpGreaterThanOrEqualTo(String value) {
	            addCriterion("su_last_ip >=", value, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpLessThan(String value) {
	            addCriterion("su_last_ip <", value, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpLessThanOrEqualTo(String value) {
	            addCriterion("su_last_ip <=", value, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpIn(List<String> values) {
	            addCriterion("su_last_ip in", values, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpNotIn(List<String> values) {
	            addCriterion("su_last_ip not in", values, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpBetween(String value1, String value2) {
	            addCriterion("su_last_ip between", value1, value2, "suLastIp");
	            return (Criteria) this;
	        }

	        public Criteria andsuLastIpNotBetween(String value1, String value2) {
	            addCriterion("su_last_ip not between", value1, value2, "suLastIp");
	            return (Criteria) this;
	        }
	        public Criteria andsuStatusIsNull() {
	            addCriterion("su_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusIsNotNull() {
	            addCriterion("su_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsuStatusEqualTo(Short value) {
	            addCriterion("su_status =", value, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusNotEqualTo(Short value) {
	            addCriterion("su_status <>", value, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusGreaterThan(Short value) {
	            addCriterion("su_status >", value, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("su_status >=", value, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusLessThan(Short value) {
	            addCriterion("su_status <", value, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusLessThanOrEqualTo(Short value) {
	            addCriterion("su_status <=", value, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusIn(List<Short> values) {
	            addCriterion("su_status in", values, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusNotIn(List<Short> values) {
	            addCriterion("su_status not in", values, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusBetween(Short value1, Short value2) {
	            addCriterion("su_status between", value1, value2, "suStatus");
	            return (Criteria) this;
	        }

	        public Criteria andsuStatusNotBetween(Short value1, Short value2) {
	            addCriterion("su_status not between", value1, value2, "suStatus");
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