package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 字典信息管理数据查询条件对象
 * @author Joel
 */
public class SrvDictCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public SrvDictCrieria() {
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
	        public Criteria andvalueIsNull() {
	            addCriterion("value is null");
	            return (Criteria) this;
	        }

	        public Criteria andvalueIsNotNull() {
	            addCriterion("value is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvalueLike(String value) {
	            addCriterion("value like", "%"+value+"%", "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueNotLike(String value) {
	            addCriterion("value not like", "%"+value+"%", "value");
	            return (Criteria) this;
	        }
	        
	        public Criteria andvalueEqualTo(String value) {
	            addCriterion("value =", value, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueNotEqualTo(String value) {
	            addCriterion("value <>", value, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueGreaterThan(String value) {
	            addCriterion("value >", value, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueGreaterThanOrEqualTo(String value) {
	            addCriterion("value >=", value, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueLessThan(String value) {
	            addCriterion("value <", value, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueLessThanOrEqualTo(String value) {
	            addCriterion("value <=", value, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueIn(List<String> values) {
	            addCriterion("value in", values, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueNotIn(List<String> values) {
	            addCriterion("value not in", values, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueBetween(String value1, String value2) {
	            addCriterion("value between", value1, value2, "value");
	            return (Criteria) this;
	        }

	        public Criteria andvalueNotBetween(String value1, String value2) {
	            addCriterion("value not between", value1, value2, "value");
	            return (Criteria) this;
	        }
	        public Criteria andlabelIsNull() {
	            addCriterion("label is null");
	            return (Criteria) this;
	        }

	        public Criteria andlabelIsNotNull() {
	            addCriterion("label is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andlabelLike(String value) {
	            addCriterion("label like", "%"+value+"%", "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelNotLike(String value) {
	            addCriterion("label not like", "%"+value+"%", "label");
	            return (Criteria) this;
	        }
	        
	        public Criteria andlabelEqualTo(String value) {
	            addCriterion("label =", value, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelNotEqualTo(String value) {
	            addCriterion("label <>", value, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelGreaterThan(String value) {
	            addCriterion("label >", value, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelGreaterThanOrEqualTo(String value) {
	            addCriterion("label >=", value, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelLessThan(String value) {
	            addCriterion("label <", value, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelLessThanOrEqualTo(String value) {
	            addCriterion("label <=", value, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelIn(List<String> values) {
	            addCriterion("label in", values, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelNotIn(List<String> values) {
	            addCriterion("label not in", values, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelBetween(String value1, String value2) {
	            addCriterion("label between", value1, value2, "label");
	            return (Criteria) this;
	        }

	        public Criteria andlabelNotBetween(String value1, String value2) {
	            addCriterion("label not between", value1, value2, "label");
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
	        
	        public Criteria andtypeLike(String value) {
	            addCriterion("type like", "%"+value+"%", "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotLike(String value) {
	            addCriterion("type not like", "%"+value+"%", "type");
	            return (Criteria) this;
	        }
	        
	        public Criteria andtypeEqualTo(String value) {
	            addCriterion("type =", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotEqualTo(String value) {
	            addCriterion("type <>", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeGreaterThan(String value) {
	            addCriterion("type >", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeGreaterThanOrEqualTo(String value) {
	            addCriterion("type >=", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeLessThan(String value) {
	            addCriterion("type <", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeLessThanOrEqualTo(String value) {
	            addCriterion("type <=", value, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeIn(List<String> values) {
	            addCriterion("type in", values, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotIn(List<String> values) {
	            addCriterion("type not in", values, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeBetween(String value1, String value2) {
	            addCriterion("type between", value1, value2, "type");
	            return (Criteria) this;
	        }

	        public Criteria andtypeNotBetween(String value1, String value2) {
	            addCriterion("type not between", value1, value2, "type");
	            return (Criteria) this;
	        }
	        public Criteria anddescriptionIsNull() {
	            addCriterion("description is null");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionIsNotNull() {
	            addCriterion("description is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddescriptionLike(String value) {
	            addCriterion("description like", "%"+value+"%", "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionNotLike(String value) {
	            addCriterion("description not like", "%"+value+"%", "description");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddescriptionEqualTo(String value) {
	            addCriterion("description =", value, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionNotEqualTo(String value) {
	            addCriterion("description <>", value, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionGreaterThan(String value) {
	            addCriterion("description >", value, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionGreaterThanOrEqualTo(String value) {
	            addCriterion("description >=", value, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionLessThan(String value) {
	            addCriterion("description <", value, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionLessThanOrEqualTo(String value) {
	            addCriterion("description <=", value, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionIn(List<String> values) {
	            addCriterion("description in", values, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionNotIn(List<String> values) {
	            addCriterion("description not in", values, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionBetween(String value1, String value2) {
	            addCriterion("description between", value1, value2, "description");
	            return (Criteria) this;
	        }

	        public Criteria anddescriptionNotBetween(String value1, String value2) {
	            addCriterion("description not between", value1, value2, "description");
	            return (Criteria) this;
	        }
	        public Criteria andsortIsNull() {
	            addCriterion("sort is null");
	            return (Criteria) this;
	        }

	        public Criteria andsortIsNotNull() {
	            addCriterion("sort is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsortEqualTo(Integer value) {
	            addCriterion("sort =", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortNotEqualTo(Integer value) {
	            addCriterion("sort <>", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortGreaterThan(Integer value) {
	            addCriterion("sort >", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortGreaterThanOrEqualTo(Integer value) {
	            addCriterion("sort >=", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortLessThan(Integer value) {
	            addCriterion("sort <", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortLessThanOrEqualTo(Integer value) {
	            addCriterion("sort <=", value, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortIn(List<Integer> values) {
	            addCriterion("sort in", values, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortNotIn(List<Integer> values) {
	            addCriterion("sort not in", values, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortBetween(Integer value1, Integer value2) {
	            addCriterion("sort between", value1, value2, "sort");
	            return (Criteria) this;
	        }

	        public Criteria andsortNotBetween(Integer value1, Integer value2) {
	            addCriterion("sort not between", value1, value2, "sort");
	            return (Criteria) this;
	        }
	        public Criteria andcreateByIsNull() {
	            addCriterion("create_by is null");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByIsNotNull() {
	            addCriterion("create_by is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcreateByLike(String value) {
	            addCriterion("create_by like", "%"+value+"%", "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByNotLike(String value) {
	            addCriterion("create_by not like", "%"+value+"%", "createBy");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcreateByEqualTo(String value) {
	            addCriterion("create_by =", value, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByNotEqualTo(String value) {
	            addCriterion("create_by <>", value, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByGreaterThan(String value) {
	            addCriterion("create_by >", value, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByGreaterThanOrEqualTo(String value) {
	            addCriterion("create_by >=", value, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByLessThan(String value) {
	            addCriterion("create_by <", value, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByLessThanOrEqualTo(String value) {
	            addCriterion("create_by <=", value, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByIn(List<String> values) {
	            addCriterion("create_by in", values, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByNotIn(List<String> values) {
	            addCriterion("create_by not in", values, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByBetween(String value1, String value2) {
	            addCriterion("create_by between", value1, value2, "createBy");
	            return (Criteria) this;
	        }

	        public Criteria andcreateByNotBetween(String value1, String value2) {
	            addCriterion("create_by not between", value1, value2, "createBy");
	            return (Criteria) this;
	        }
	        public Criteria andcreateDateIsNull() {
	            addCriterion("create_date is null");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateIsNotNull() {
	            addCriterion("create_date is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcreateDateEqualTo(Date value) {
	            addCriterion("create_date =", value, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateNotEqualTo(Date value) {
	            addCriterion("create_date <>", value, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateGreaterThan(Date value) {
	            addCriterion("create_date >", value, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateGreaterThanOrEqualTo(Date value) {
	            addCriterion("create_date >=", value, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateLessThan(Date value) {
	            addCriterion("create_date <", value, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateLessThanOrEqualTo(Date value) {
	            addCriterion("create_date <=", value, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateIn(List<Date> values) {
	            addCriterion("create_date in", values, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateNotIn(List<Date> values) {
	            addCriterion("create_date not in", values, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateBetween(Date value1, Date value2) {
	            addCriterion("create_date between", value1, value2, "createDate");
	            return (Criteria) this;
	        }

	        public Criteria andcreateDateNotBetween(Date value1, Date value2) {
	            addCriterion("create_date not between", value1, value2, "createDate");
	            return (Criteria) this;
	        }
	        public Criteria andupdateByIsNull() {
	            addCriterion("update_by is null");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByIsNotNull() {
	            addCriterion("update_by is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andupdateByLike(String value) {
	            addCriterion("update_by like", "%"+value+"%", "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByNotLike(String value) {
	            addCriterion("update_by not like", "%"+value+"%", "updateBy");
	            return (Criteria) this;
	        }
	        
	        public Criteria andupdateByEqualTo(String value) {
	            addCriterion("update_by =", value, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByNotEqualTo(String value) {
	            addCriterion("update_by <>", value, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByGreaterThan(String value) {
	            addCriterion("update_by >", value, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByGreaterThanOrEqualTo(String value) {
	            addCriterion("update_by >=", value, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByLessThan(String value) {
	            addCriterion("update_by <", value, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByLessThanOrEqualTo(String value) {
	            addCriterion("update_by <=", value, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByIn(List<String> values) {
	            addCriterion("update_by in", values, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByNotIn(List<String> values) {
	            addCriterion("update_by not in", values, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByBetween(String value1, String value2) {
	            addCriterion("update_by between", value1, value2, "updateBy");
	            return (Criteria) this;
	        }

	        public Criteria andupdateByNotBetween(String value1, String value2) {
	            addCriterion("update_by not between", value1, value2, "updateBy");
	            return (Criteria) this;
	        }
	        public Criteria andupdateDateIsNull() {
	            addCriterion("update_date is null");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateIsNotNull() {
	            addCriterion("update_date is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andupdateDateEqualTo(Date value) {
	            addCriterion("update_date =", value, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateNotEqualTo(Date value) {
	            addCriterion("update_date <>", value, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateGreaterThan(Date value) {
	            addCriterion("update_date >", value, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateGreaterThanOrEqualTo(Date value) {
	            addCriterion("update_date >=", value, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateLessThan(Date value) {
	            addCriterion("update_date <", value, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateLessThanOrEqualTo(Date value) {
	            addCriterion("update_date <=", value, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateIn(List<Date> values) {
	            addCriterion("update_date in", values, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateNotIn(List<Date> values) {
	            addCriterion("update_date not in", values, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateBetween(Date value1, Date value2) {
	            addCriterion("update_date between", value1, value2, "updateDate");
	            return (Criteria) this;
	        }

	        public Criteria andupdateDateNotBetween(Date value1, Date value2) {
	            addCriterion("update_date not between", value1, value2, "updateDate");
	            return (Criteria) this;
	        }
	        public Criteria andremarksIsNull() {
	            addCriterion("remarks is null");
	            return (Criteria) this;
	        }

	        public Criteria andremarksIsNotNull() {
	            addCriterion("remarks is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andremarksLike(String value) {
	            addCriterion("remarks like", "%"+value+"%", "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksNotLike(String value) {
	            addCriterion("remarks not like", "%"+value+"%", "remarks");
	            return (Criteria) this;
	        }
	        
	        public Criteria andremarksEqualTo(String value) {
	            addCriterion("remarks =", value, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksNotEqualTo(String value) {
	            addCriterion("remarks <>", value, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksGreaterThan(String value) {
	            addCriterion("remarks >", value, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksGreaterThanOrEqualTo(String value) {
	            addCriterion("remarks >=", value, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksLessThan(String value) {
	            addCriterion("remarks <", value, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksLessThanOrEqualTo(String value) {
	            addCriterion("remarks <=", value, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksIn(List<String> values) {
	            addCriterion("remarks in", values, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksNotIn(List<String> values) {
	            addCriterion("remarks not in", values, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksBetween(String value1, String value2) {
	            addCriterion("remarks between", value1, value2, "remarks");
	            return (Criteria) this;
	        }

	        public Criteria andremarksNotBetween(String value1, String value2) {
	            addCriterion("remarks not between", value1, value2, "remarks");
	            return (Criteria) this;
	        }
	        public Criteria anddelFlagIsNull() {
	            addCriterion("del_flag is null");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagIsNotNull() {
	            addCriterion("del_flag is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddelFlagLike(String value) {
	            addCriterion("del_flag like", "%"+value+"%", "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagNotLike(String value) {
	            addCriterion("del_flag not like", "%"+value+"%", "delFlag");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddelFlagEqualTo(String value) {
	            addCriterion("del_flag =", value, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagNotEqualTo(String value) {
	            addCriterion("del_flag <>", value, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagGreaterThan(String value) {
	            addCriterion("del_flag >", value, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagGreaterThanOrEqualTo(String value) {
	            addCriterion("del_flag >=", value, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagLessThan(String value) {
	            addCriterion("del_flag <", value, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagLessThanOrEqualTo(String value) {
	            addCriterion("del_flag <=", value, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagIn(List<String> values) {
	            addCriterion("del_flag in", values, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagNotIn(List<String> values) {
	            addCriterion("del_flag not in", values, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagBetween(String value1, String value2) {
	            addCriterion("del_flag between", value1, value2, "delFlag");
	            return (Criteria) this;
	        }

	        public Criteria anddelFlagNotBetween(String value1, String value2) {
	            addCriterion("del_flag not between", value1, value2, "delFlag");
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