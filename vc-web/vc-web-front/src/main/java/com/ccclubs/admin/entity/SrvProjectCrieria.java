package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 项目菜单管理数据查询条件对象
 * @author Joel
 */
public class SrvProjectCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public SrvProjectCrieria() {
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
	        public Criteria andspIdIsNull() {
	            addCriterion("sp_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andspIdIsNotNull() {
	            addCriterion("sp_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andspIdEqualTo(Long value) {
	            addCriterion("sp_id =", value, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdNotEqualTo(Long value) {
	            addCriterion("sp_id <>", value, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdGreaterThan(Long value) {
	            addCriterion("sp_id >", value, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("sp_id >=", value, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdLessThan(Long value) {
	            addCriterion("sp_id <", value, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdLessThanOrEqualTo(Long value) {
	            addCriterion("sp_id <=", value, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdIn(List<Long> values) {
	            addCriterion("sp_id in", values, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdNotIn(List<Long> values) {
	            addCriterion("sp_id not in", values, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdBetween(Long value1, Long value2) {
	            addCriterion("sp_id between", value1, value2, "spId");
	            return (Criteria) this;
	        }

	        public Criteria andspIdNotBetween(Long value1, Long value2) {
	            addCriterion("sp_id not between", value1, value2, "spId");
	            return (Criteria) this;
	        }
	        public Criteria andspNameIsNull() {
	            addCriterion("sp_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andspNameIsNotNull() {
	            addCriterion("sp_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspNameLike(String value) {
	            addCriterion("sp_name like", "%"+value+"%", "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameNotLike(String value) {
	            addCriterion("sp_name not like", "%"+value+"%", "spName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspNameEqualTo(String value) {
	            addCriterion("sp_name =", value, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameNotEqualTo(String value) {
	            addCriterion("sp_name <>", value, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameGreaterThan(String value) {
	            addCriterion("sp_name >", value, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_name >=", value, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameLessThan(String value) {
	            addCriterion("sp_name <", value, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameLessThanOrEqualTo(String value) {
	            addCriterion("sp_name <=", value, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameIn(List<String> values) {
	            addCriterion("sp_name in", values, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameNotIn(List<String> values) {
	            addCriterion("sp_name not in", values, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameBetween(String value1, String value2) {
	            addCriterion("sp_name between", value1, value2, "spName");
	            return (Criteria) this;
	        }

	        public Criteria andspNameNotBetween(String value1, String value2) {
	            addCriterion("sp_name not between", value1, value2, "spName");
	            return (Criteria) this;
	        }
	        public Criteria andspParentIdIsNull() {
	            addCriterion("sp_parent_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdIsNotNull() {
	            addCriterion("sp_parent_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andspParentIdEqualTo(Long value) {
	            addCriterion("sp_parent_id =", value, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdNotEqualTo(Long value) {
	            addCriterion("sp_parent_id <>", value, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdGreaterThan(Long value) {
	            addCriterion("sp_parent_id >", value, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("sp_parent_id >=", value, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdLessThan(Long value) {
	            addCriterion("sp_parent_id <", value, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdLessThanOrEqualTo(Long value) {
	            addCriterion("sp_parent_id <=", value, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdIn(List<Long> values) {
	            addCriterion("sp_parent_id in", values, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdNotIn(List<Long> values) {
	            addCriterion("sp_parent_id not in", values, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdBetween(Long value1, Long value2) {
	            addCriterion("sp_parent_id between", value1, value2, "spParentId");
	            return (Criteria) this;
	        }

	        public Criteria andspParentIdNotBetween(Long value1, Long value2) {
	            addCriterion("sp_parent_id not between", value1, value2, "spParentId");
	            return (Criteria) this;
	        }
	        public Criteria andspFlagIsNull() {
	            addCriterion("sp_flag is null");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagIsNotNull() {
	            addCriterion("sp_flag is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspFlagLike(String value) {
	            addCriterion("sp_flag like", "%"+value+"%", "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagNotLike(String value) {
	            addCriterion("sp_flag not like", "%"+value+"%", "spFlag");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspFlagEqualTo(String value) {
	            addCriterion("sp_flag =", value, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagNotEqualTo(String value) {
	            addCriterion("sp_flag <>", value, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagGreaterThan(String value) {
	            addCriterion("sp_flag >", value, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_flag >=", value, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagLessThan(String value) {
	            addCriterion("sp_flag <", value, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagLessThanOrEqualTo(String value) {
	            addCriterion("sp_flag <=", value, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagIn(List<String> values) {
	            addCriterion("sp_flag in", values, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagNotIn(List<String> values) {
	            addCriterion("sp_flag not in", values, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagBetween(String value1, String value2) {
	            addCriterion("sp_flag between", value1, value2, "spFlag");
	            return (Criteria) this;
	        }

	        public Criteria andspFlagNotBetween(String value1, String value2) {
	            addCriterion("sp_flag not between", value1, value2, "spFlag");
	            return (Criteria) this;
	        }
	        public Criteria andspFamilyIsNull() {
	            addCriterion("sp_family is null");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyIsNotNull() {
	            addCriterion("sp_family is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspFamilyLike(String value) {
	            addCriterion("sp_family like", "%"+value+"%", "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyNotLike(String value) {
	            addCriterion("sp_family not like", "%"+value+"%", "spFamily");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspFamilyEqualTo(String value) {
	            addCriterion("sp_family =", value, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyNotEqualTo(String value) {
	            addCriterion("sp_family <>", value, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyGreaterThan(String value) {
	            addCriterion("sp_family >", value, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_family >=", value, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyLessThan(String value) {
	            addCriterion("sp_family <", value, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyLessThanOrEqualTo(String value) {
	            addCriterion("sp_family <=", value, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyIn(List<String> values) {
	            addCriterion("sp_family in", values, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyNotIn(List<String> values) {
	            addCriterion("sp_family not in", values, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyBetween(String value1, String value2) {
	            addCriterion("sp_family between", value1, value2, "spFamily");
	            return (Criteria) this;
	        }

	        public Criteria andspFamilyNotBetween(String value1, String value2) {
	            addCriterion("sp_family not between", value1, value2, "spFamily");
	            return (Criteria) this;
	        }
	        public Criteria andspUrlIsNull() {
	            addCriterion("sp_url is null");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlIsNotNull() {
	            addCriterion("sp_url is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspUrlLike(String value) {
	            addCriterion("sp_url like", "%"+value+"%", "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlNotLike(String value) {
	            addCriterion("sp_url not like", "%"+value+"%", "spUrl");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspUrlEqualTo(String value) {
	            addCriterion("sp_url =", value, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlNotEqualTo(String value) {
	            addCriterion("sp_url <>", value, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlGreaterThan(String value) {
	            addCriterion("sp_url >", value, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_url >=", value, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlLessThan(String value) {
	            addCriterion("sp_url <", value, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlLessThanOrEqualTo(String value) {
	            addCriterion("sp_url <=", value, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlIn(List<String> values) {
	            addCriterion("sp_url in", values, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlNotIn(List<String> values) {
	            addCriterion("sp_url not in", values, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlBetween(String value1, String value2) {
	            addCriterion("sp_url between", value1, value2, "spUrl");
	            return (Criteria) this;
	        }

	        public Criteria andspUrlNotBetween(String value1, String value2) {
	            addCriterion("sp_url not between", value1, value2, "spUrl");
	            return (Criteria) this;
	        }
	        public Criteria andspLogoIsNull() {
	            addCriterion("sp_logo is null");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoIsNotNull() {
	            addCriterion("sp_logo is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspLogoLike(String value) {
	            addCriterion("sp_logo like", "%"+value+"%", "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoNotLike(String value) {
	            addCriterion("sp_logo not like", "%"+value+"%", "spLogo");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspLogoEqualTo(String value) {
	            addCriterion("sp_logo =", value, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoNotEqualTo(String value) {
	            addCriterion("sp_logo <>", value, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoGreaterThan(String value) {
	            addCriterion("sp_logo >", value, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_logo >=", value, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoLessThan(String value) {
	            addCriterion("sp_logo <", value, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoLessThanOrEqualTo(String value) {
	            addCriterion("sp_logo <=", value, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoIn(List<String> values) {
	            addCriterion("sp_logo in", values, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoNotIn(List<String> values) {
	            addCriterion("sp_logo not in", values, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoBetween(String value1, String value2) {
	            addCriterion("sp_logo between", value1, value2, "spLogo");
	            return (Criteria) this;
	        }

	        public Criteria andspLogoNotBetween(String value1, String value2) {
	            addCriterion("sp_logo not between", value1, value2, "spLogo");
	            return (Criteria) this;
	        }
	        public Criteria andspDescriptIsNull() {
	            addCriterion("sp_descript is null");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptIsNotNull() {
	            addCriterion("sp_descript is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspDescriptLike(String value) {
	            addCriterion("sp_descript like", "%"+value+"%", "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptNotLike(String value) {
	            addCriterion("sp_descript not like", "%"+value+"%", "spDescript");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspDescriptEqualTo(String value) {
	            addCriterion("sp_descript =", value, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptNotEqualTo(String value) {
	            addCriterion("sp_descript <>", value, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptGreaterThan(String value) {
	            addCriterion("sp_descript >", value, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_descript >=", value, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptLessThan(String value) {
	            addCriterion("sp_descript <", value, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptLessThanOrEqualTo(String value) {
	            addCriterion("sp_descript <=", value, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptIn(List<String> values) {
	            addCriterion("sp_descript in", values, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptNotIn(List<String> values) {
	            addCriterion("sp_descript not in", values, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptBetween(String value1, String value2) {
	            addCriterion("sp_descript between", value1, value2, "spDescript");
	            return (Criteria) this;
	        }

	        public Criteria andspDescriptNotBetween(String value1, String value2) {
	            addCriterion("sp_descript not between", value1, value2, "spDescript");
	            return (Criteria) this;
	        }
	        public Criteria andspLevelIsNull() {
	            addCriterion("sp_level is null");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelIsNotNull() {
	            addCriterion("sp_level is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andspLevelEqualTo(Integer value) {
	            addCriterion("sp_level =", value, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelNotEqualTo(Integer value) {
	            addCriterion("sp_level <>", value, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelGreaterThan(Integer value) {
	            addCriterion("sp_level >", value, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelGreaterThanOrEqualTo(Integer value) {
	            addCriterion("sp_level >=", value, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelLessThan(Integer value) {
	            addCriterion("sp_level <", value, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelLessThanOrEqualTo(Integer value) {
	            addCriterion("sp_level <=", value, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelIn(List<Integer> values) {
	            addCriterion("sp_level in", values, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelNotIn(List<Integer> values) {
	            addCriterion("sp_level not in", values, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelBetween(Integer value1, Integer value2) {
	            addCriterion("sp_level between", value1, value2, "spLevel");
	            return (Criteria) this;
	        }

	        public Criteria andspLevelNotBetween(Integer value1, Integer value2) {
	            addCriterion("sp_level not between", value1, value2, "spLevel");
	            return (Criteria) this;
	        }
	        public Criteria andspLimitExpIsNull() {
	            addCriterion("sp_limit_exp is null");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpIsNotNull() {
	            addCriterion("sp_limit_exp is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspLimitExpLike(String value) {
	            addCriterion("sp_limit_exp like", "%"+value+"%", "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpNotLike(String value) {
	            addCriterion("sp_limit_exp not like", "%"+value+"%", "spLimitExp");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspLimitExpEqualTo(String value) {
	            addCriterion("sp_limit_exp =", value, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpNotEqualTo(String value) {
	            addCriterion("sp_limit_exp <>", value, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpGreaterThan(String value) {
	            addCriterion("sp_limit_exp >", value, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_limit_exp >=", value, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpLessThan(String value) {
	            addCriterion("sp_limit_exp <", value, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpLessThanOrEqualTo(String value) {
	            addCriterion("sp_limit_exp <=", value, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpIn(List<String> values) {
	            addCriterion("sp_limit_exp in", values, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpNotIn(List<String> values) {
	            addCriterion("sp_limit_exp not in", values, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpBetween(String value1, String value2) {
	            addCriterion("sp_limit_exp between", value1, value2, "spLimitExp");
	            return (Criteria) this;
	        }

	        public Criteria andspLimitExpNotBetween(String value1, String value2) {
	            addCriterion("sp_limit_exp not between", value1, value2, "spLimitExp");
	            return (Criteria) this;
	        }
	        public Criteria andspGroupIsNull() {
	            addCriterion("sp_group is null");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupIsNotNull() {
	            addCriterion("sp_group is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspGroupLike(String value) {
	            addCriterion("sp_group like", "%"+value+"%", "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupNotLike(String value) {
	            addCriterion("sp_group not like", "%"+value+"%", "spGroup");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspGroupEqualTo(String value) {
	            addCriterion("sp_group =", value, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupNotEqualTo(String value) {
	            addCriterion("sp_group <>", value, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupGreaterThan(String value) {
	            addCriterion("sp_group >", value, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_group >=", value, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupLessThan(String value) {
	            addCriterion("sp_group <", value, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupLessThanOrEqualTo(String value) {
	            addCriterion("sp_group <=", value, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupIn(List<String> values) {
	            addCriterion("sp_group in", values, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupNotIn(List<String> values) {
	            addCriterion("sp_group not in", values, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupBetween(String value1, String value2) {
	            addCriterion("sp_group between", value1, value2, "spGroup");
	            return (Criteria) this;
	        }

	        public Criteria andspGroupNotBetween(String value1, String value2) {
	            addCriterion("sp_group not between", value1, value2, "spGroup");
	            return (Criteria) this;
	        }
	        public Criteria andspMindIsNull() {
	            addCriterion("sp_mind is null");
	            return (Criteria) this;
	        }

	        public Criteria andspMindIsNotNull() {
	            addCriterion("sp_mind is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspMindLike(String value) {
	            addCriterion("sp_mind like", "%"+value+"%", "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindNotLike(String value) {
	            addCriterion("sp_mind not like", "%"+value+"%", "spMind");
	            return (Criteria) this;
	        }
	        
	        public Criteria andspMindEqualTo(String value) {
	            addCriterion("sp_mind =", value, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindNotEqualTo(String value) {
	            addCriterion("sp_mind <>", value, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindGreaterThan(String value) {
	            addCriterion("sp_mind >", value, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindGreaterThanOrEqualTo(String value) {
	            addCriterion("sp_mind >=", value, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindLessThan(String value) {
	            addCriterion("sp_mind <", value, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindLessThanOrEqualTo(String value) {
	            addCriterion("sp_mind <=", value, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindIn(List<String> values) {
	            addCriterion("sp_mind in", values, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindNotIn(List<String> values) {
	            addCriterion("sp_mind not in", values, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindBetween(String value1, String value2) {
	            addCriterion("sp_mind between", value1, value2, "spMind");
	            return (Criteria) this;
	        }

	        public Criteria andspMindNotBetween(String value1, String value2) {
	            addCriterion("sp_mind not between", value1, value2, "spMind");
	            return (Criteria) this;
	        }
	        public Criteria andspStatusIsNull() {
	            addCriterion("sp_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusIsNotNull() {
	            addCriterion("sp_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andspStatusEqualTo(Short value) {
	            addCriterion("sp_status =", value, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusNotEqualTo(Short value) {
	            addCriterion("sp_status <>", value, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusGreaterThan(Short value) {
	            addCriterion("sp_status >", value, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("sp_status >=", value, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusLessThan(Short value) {
	            addCriterion("sp_status <", value, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusLessThanOrEqualTo(Short value) {
	            addCriterion("sp_status <=", value, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusIn(List<Short> values) {
	            addCriterion("sp_status in", values, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusNotIn(List<Short> values) {
	            addCriterion("sp_status not in", values, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusBetween(Short value1, Short value2) {
	            addCriterion("sp_status between", value1, value2, "spStatus");
	            return (Criteria) this;
	        }

	        public Criteria andspStatusNotBetween(Short value1, Short value2) {
	            addCriterion("sp_status not between", value1, value2, "spStatus");
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