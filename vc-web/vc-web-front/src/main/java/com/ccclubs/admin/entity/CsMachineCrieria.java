package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * T-box信息管理数据查询条件对象
 * @author Joel
 */
public class CsMachineCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsMachineCrieria() {
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
	        public Criteria andcsmIdIsNull() {
	            addCriterion("csm_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdIsNotNull() {
	            addCriterion("csm_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmIdEqualTo(Integer value) {
	            addCriterion("csm_id =", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdNotEqualTo(Integer value) {
	            addCriterion("csm_id <>", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdGreaterThan(Integer value) {
	            addCriterion("csm_id >", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_id >=", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdLessThan(Integer value) {
	            addCriterion("csm_id <", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_id <=", value, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdIn(List<Integer> values) {
	            addCriterion("csm_id in", values, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdNotIn(List<Integer> values) {
	            addCriterion("csm_id not in", values, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdBetween(Integer value1, Integer value2) {
	            addCriterion("csm_id between", value1, value2, "csmId");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_id not between", value1, value2, "csmId");
	            return (Criteria) this;
	        }
	        public Criteria andcsmAccessIsNull() {
	            addCriterion("csm_access is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessIsNotNull() {
	            addCriterion("csm_access is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmAccessEqualTo(Integer value) {
	            addCriterion("csm_access =", value, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessNotEqualTo(Integer value) {
	            addCriterion("csm_access <>", value, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessGreaterThan(Integer value) {
	            addCriterion("csm_access >", value, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_access >=", value, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessLessThan(Integer value) {
	            addCriterion("csm_access <", value, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_access <=", value, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessIn(List<Integer> values) {
	            addCriterion("csm_access in", values, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessNotIn(List<Integer> values) {
	            addCriterion("csm_access not in", values, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessBetween(Integer value1, Integer value2) {
	            addCriterion("csm_access between", value1, value2, "csmAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAccessNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_access not between", value1, value2, "csmAccess");
	            return (Criteria) this;
	        }
	        public Criteria andcsmHostIsNull() {
	            addCriterion("csm_host is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostIsNotNull() {
	            addCriterion("csm_host is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmHostEqualTo(Integer value) {
	            addCriterion("csm_host =", value, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostNotEqualTo(Integer value) {
	            addCriterion("csm_host <>", value, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostGreaterThan(Integer value) {
	            addCriterion("csm_host >", value, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_host >=", value, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostLessThan(Integer value) {
	            addCriterion("csm_host <", value, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_host <=", value, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostIn(List<Integer> values) {
	            addCriterion("csm_host in", values, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostNotIn(List<Integer> values) {
	            addCriterion("csm_host not in", values, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostBetween(Integer value1, Integer value2) {
	            addCriterion("csm_host between", value1, value2, "csmHost");
	            return (Criteria) this;
	        }

	        public Criteria andcsmHostNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_host not between", value1, value2, "csmHost");
	            return (Criteria) this;
	        }
	        public Criteria andcsmNumberIsNull() {
	            addCriterion("csm_number is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberIsNotNull() {
	            addCriterion("csm_number is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmNumberLike(String value) {
	            addCriterion("csm_number like", "%"+value+"%", "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberNotLike(String value) {
	            addCriterion("csm_number not like", "%"+value+"%", "csmNumber");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmNumberEqualTo(String value) {
	            addCriterion("csm_number =", value, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberNotEqualTo(String value) {
	            addCriterion("csm_number <>", value, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberGreaterThan(String value) {
	            addCriterion("csm_number >", value, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_number >=", value, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberLessThan(String value) {
	            addCriterion("csm_number <", value, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberLessThanOrEqualTo(String value) {
	            addCriterion("csm_number <=", value, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberIn(List<String> values) {
	            addCriterion("csm_number in", values, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberNotIn(List<String> values) {
	            addCriterion("csm_number not in", values, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberBetween(String value1, String value2) {
	            addCriterion("csm_number between", value1, value2, "csmNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNumberNotBetween(String value1, String value2) {
	            addCriterion("csm_number not between", value1, value2, "csmNumber");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTeNoIsNull() {
	            addCriterion("csm_te_no is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoIsNotNull() {
	            addCriterion("csm_te_no is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeNoLike(String value) {
	            addCriterion("csm_te_no like", "%"+value+"%", "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoNotLike(String value) {
	            addCriterion("csm_te_no not like", "%"+value+"%", "csmTeNo");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeNoEqualTo(String value) {
	            addCriterion("csm_te_no =", value, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoNotEqualTo(String value) {
	            addCriterion("csm_te_no <>", value, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoGreaterThan(String value) {
	            addCriterion("csm_te_no >", value, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_te_no >=", value, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoLessThan(String value) {
	            addCriterion("csm_te_no <", value, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoLessThanOrEqualTo(String value) {
	            addCriterion("csm_te_no <=", value, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoIn(List<String> values) {
	            addCriterion("csm_te_no in", values, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoNotIn(List<String> values) {
	            addCriterion("csm_te_no not in", values, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoBetween(String value1, String value2) {
	            addCriterion("csm_te_no between", value1, value2, "csmTeNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeNoNotBetween(String value1, String value2) {
	            addCriterion("csm_te_no not between", value1, value2, "csmTeNo");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTeTypeIsNull() {
	            addCriterion("csm_te_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeIsNotNull() {
	            addCriterion("csm_te_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmTeTypeEqualTo(Short value) {
	            addCriterion("csm_te_type =", value, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeNotEqualTo(Short value) {
	            addCriterion("csm_te_type <>", value, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeGreaterThan(Short value) {
	            addCriterion("csm_te_type >", value, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_te_type >=", value, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeLessThan(Short value) {
	            addCriterion("csm_te_type <", value, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeLessThanOrEqualTo(Short value) {
	            addCriterion("csm_te_type <=", value, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeIn(List<Short> values) {
	            addCriterion("csm_te_type in", values, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeNotIn(List<Short> values) {
	            addCriterion("csm_te_type not in", values, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeBetween(Short value1, Short value2) {
	            addCriterion("csm_te_type between", value1, value2, "csmTeType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeTypeNotBetween(Short value1, Short value2) {
	            addCriterion("csm_te_type not between", value1, value2, "csmTeType");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTeModelIsNull() {
	            addCriterion("csm_te_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelIsNotNull() {
	            addCriterion("csm_te_model is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeModelLike(String value) {
	            addCriterion("csm_te_model like", "%"+value+"%", "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelNotLike(String value) {
	            addCriterion("csm_te_model not like", "%"+value+"%", "csmTeModel");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeModelEqualTo(String value) {
	            addCriterion("csm_te_model =", value, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelNotEqualTo(String value) {
	            addCriterion("csm_te_model <>", value, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelGreaterThan(String value) {
	            addCriterion("csm_te_model >", value, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_te_model >=", value, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelLessThan(String value) {
	            addCriterion("csm_te_model <", value, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelLessThanOrEqualTo(String value) {
	            addCriterion("csm_te_model <=", value, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelIn(List<String> values) {
	            addCriterion("csm_te_model in", values, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelNotIn(List<String> values) {
	            addCriterion("csm_te_model not in", values, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelBetween(String value1, String value2) {
	            addCriterion("csm_te_model between", value1, value2, "csmTeModel");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeModelNotBetween(String value1, String value2) {
	            addCriterion("csm_te_model not between", value1, value2, "csmTeModel");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTeCodeIsNull() {
	            addCriterion("csm_te_code is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeIsNotNull() {
	            addCriterion("csm_te_code is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeCodeLike(String value) {
	            addCriterion("csm_te_code like", "%"+value+"%", "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeNotLike(String value) {
	            addCriterion("csm_te_code not like", "%"+value+"%", "csmTeCode");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeCodeEqualTo(String value) {
	            addCriterion("csm_te_code =", value, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeNotEqualTo(String value) {
	            addCriterion("csm_te_code <>", value, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeGreaterThan(String value) {
	            addCriterion("csm_te_code >", value, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_te_code >=", value, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeLessThan(String value) {
	            addCriterion("csm_te_code <", value, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeLessThanOrEqualTo(String value) {
	            addCriterion("csm_te_code <=", value, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeIn(List<String> values) {
	            addCriterion("csm_te_code in", values, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeNotIn(List<String> values) {
	            addCriterion("csm_te_code not in", values, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeBetween(String value1, String value2) {
	            addCriterion("csm_te_code between", value1, value2, "csmTeCode");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeCodeNotBetween(String value1, String value2) {
	            addCriterion("csm_te_code not between", value1, value2, "csmTeCode");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTeLotNoIsNull() {
	            addCriterion("csm_te_lot_no is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoIsNotNull() {
	            addCriterion("csm_te_lot_no is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeLotNoLike(String value) {
	            addCriterion("csm_te_lot_no like", "%"+value+"%", "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoNotLike(String value) {
	            addCriterion("csm_te_lot_no not like", "%"+value+"%", "csmTeLotNo");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeLotNoEqualTo(String value) {
	            addCriterion("csm_te_lot_no =", value, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoNotEqualTo(String value) {
	            addCriterion("csm_te_lot_no <>", value, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoGreaterThan(String value) {
	            addCriterion("csm_te_lot_no >", value, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_te_lot_no >=", value, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoLessThan(String value) {
	            addCriterion("csm_te_lot_no <", value, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoLessThanOrEqualTo(String value) {
	            addCriterion("csm_te_lot_no <=", value, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoIn(List<String> values) {
	            addCriterion("csm_te_lot_no in", values, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoNotIn(List<String> values) {
	            addCriterion("csm_te_lot_no not in", values, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoBetween(String value1, String value2) {
	            addCriterion("csm_te_lot_no between", value1, value2, "csmTeLotNo");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeLotNoNotBetween(String value1, String value2) {
	            addCriterion("csm_te_lot_no not between", value1, value2, "csmTeLotNo");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTeSerialIsNull() {
	            addCriterion("csm_te_serial is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialIsNotNull() {
	            addCriterion("csm_te_serial is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeSerialLike(String value) {
	            addCriterion("csm_te_serial like", "%"+value+"%", "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialNotLike(String value) {
	            addCriterion("csm_te_serial not like", "%"+value+"%", "csmTeSerial");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTeSerialEqualTo(String value) {
	            addCriterion("csm_te_serial =", value, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialNotEqualTo(String value) {
	            addCriterion("csm_te_serial <>", value, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialGreaterThan(String value) {
	            addCriterion("csm_te_serial >", value, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_te_serial >=", value, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialLessThan(String value) {
	            addCriterion("csm_te_serial <", value, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialLessThanOrEqualTo(String value) {
	            addCriterion("csm_te_serial <=", value, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialIn(List<String> values) {
	            addCriterion("csm_te_serial in", values, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialNotIn(List<String> values) {
	            addCriterion("csm_te_serial not in", values, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialBetween(String value1, String value2) {
	            addCriterion("csm_te_serial between", value1, value2, "csmTeSerial");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTeSerialNotBetween(String value1, String value2) {
	            addCriterion("csm_te_serial not between", value1, value2, "csmTeSerial");
	            return (Criteria) this;
	        }
	        public Criteria andcsmMobileIsNull() {
	            addCriterion("csm_mobile is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileIsNotNull() {
	            addCriterion("csm_mobile is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmMobileLike(String value) {
	            addCriterion("csm_mobile like", "%"+value+"%", "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileNotLike(String value) {
	            addCriterion("csm_mobile not like", "%"+value+"%", "csmMobile");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmMobileEqualTo(String value) {
	            addCriterion("csm_mobile =", value, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileNotEqualTo(String value) {
	            addCriterion("csm_mobile <>", value, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileGreaterThan(String value) {
	            addCriterion("csm_mobile >", value, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_mobile >=", value, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileLessThan(String value) {
	            addCriterion("csm_mobile <", value, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileLessThanOrEqualTo(String value) {
	            addCriterion("csm_mobile <=", value, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileIn(List<String> values) {
	            addCriterion("csm_mobile in", values, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileNotIn(List<String> values) {
	            addCriterion("csm_mobile not in", values, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileBetween(String value1, String value2) {
	            addCriterion("csm_mobile between", value1, value2, "csmMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMobileNotBetween(String value1, String value2) {
	            addCriterion("csm_mobile not between", value1, value2, "csmMobile");
	            return (Criteria) this;
	        }
	        public Criteria andcsmIccidIsNull() {
	            addCriterion("csm_iccid is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidIsNotNull() {
	            addCriterion("csm_iccid is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmIccidLike(String value) {
	            addCriterion("csm_iccid like", "%"+value+"%", "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidNotLike(String value) {
	            addCriterion("csm_iccid not like", "%"+value+"%", "csmIccid");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmIccidEqualTo(String value) {
	            addCriterion("csm_iccid =", value, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidNotEqualTo(String value) {
	            addCriterion("csm_iccid <>", value, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidGreaterThan(String value) {
	            addCriterion("csm_iccid >", value, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_iccid >=", value, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidLessThan(String value) {
	            addCriterion("csm_iccid <", value, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidLessThanOrEqualTo(String value) {
	            addCriterion("csm_iccid <=", value, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidIn(List<String> values) {
	            addCriterion("csm_iccid in", values, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidNotIn(List<String> values) {
	            addCriterion("csm_iccid not in", values, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidBetween(String value1, String value2) {
	            addCriterion("csm_iccid between", value1, value2, "csmIccid");
	            return (Criteria) this;
	        }

	        public Criteria andcsmIccidNotBetween(String value1, String value2) {
	            addCriterion("csm_iccid not between", value1, value2, "csmIccid");
	            return (Criteria) this;
	        }
	        public Criteria andcsmPasswordIsNull() {
	            addCriterion("csm_password is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordIsNotNull() {
	            addCriterion("csm_password is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmPasswordLike(String value) {
	            addCriterion("csm_password like", "%"+value+"%", "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordNotLike(String value) {
	            addCriterion("csm_password not like", "%"+value+"%", "csmPassword");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmPasswordEqualTo(String value) {
	            addCriterion("csm_password =", value, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordNotEqualTo(String value) {
	            addCriterion("csm_password <>", value, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordGreaterThan(String value) {
	            addCriterion("csm_password >", value, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_password >=", value, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordLessThan(String value) {
	            addCriterion("csm_password <", value, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordLessThanOrEqualTo(String value) {
	            addCriterion("csm_password <=", value, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordIn(List<String> values) {
	            addCriterion("csm_password in", values, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordNotIn(List<String> values) {
	            addCriterion("csm_password not in", values, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordBetween(String value1, String value2) {
	            addCriterion("csm_password between", value1, value2, "csmPassword");
	            return (Criteria) this;
	        }

	        public Criteria andcsmPasswordNotBetween(String value1, String value2) {
	            addCriterion("csm_password not between", value1, value2, "csmPassword");
	            return (Criteria) this;
	        }
	        public Criteria andcsmProtocolIsNull() {
	            addCriterion("csm_protocol is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolIsNotNull() {
	            addCriterion("csm_protocol is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmProtocolEqualTo(Long value) {
	            addCriterion("csm_protocol =", value, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolNotEqualTo(Long value) {
	            addCriterion("csm_protocol <>", value, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolGreaterThan(Long value) {
	            addCriterion("csm_protocol >", value, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolGreaterThanOrEqualTo(Long value) {
	            addCriterion("csm_protocol >=", value, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolLessThan(Long value) {
	            addCriterion("csm_protocol <", value, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolLessThanOrEqualTo(Long value) {
	            addCriterion("csm_protocol <=", value, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolIn(List<Long> values) {
	            addCriterion("csm_protocol in", values, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolNotIn(List<Long> values) {
	            addCriterion("csm_protocol not in", values, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolBetween(Long value1, Long value2) {
	            addCriterion("csm_protocol between", value1, value2, "csmProtocol");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProtocolNotBetween(Long value1, Long value2) {
	            addCriterion("csm_protocol not between", value1, value2, "csmProtocol");
	            return (Criteria) this;
	        }
	        public Criteria andcsmFunctionsIsNull() {
	            addCriterion("csm_functions is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsIsNotNull() {
	            addCriterion("csm_functions is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmFunctionsLike(String value) {
	            addCriterion("csm_functions like", "%"+value+"%", "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsNotLike(String value) {
	            addCriterion("csm_functions not like", "%"+value+"%", "csmFunctions");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmFunctionsEqualTo(String value) {
	            addCriterion("csm_functions =", value, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsNotEqualTo(String value) {
	            addCriterion("csm_functions <>", value, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsGreaterThan(String value) {
	            addCriterion("csm_functions >", value, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_functions >=", value, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsLessThan(String value) {
	            addCriterion("csm_functions <", value, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsLessThanOrEqualTo(String value) {
	            addCriterion("csm_functions <=", value, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsIn(List<String> values) {
	            addCriterion("csm_functions in", values, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsNotIn(List<String> values) {
	            addCriterion("csm_functions not in", values, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsBetween(String value1, String value2) {
	            addCriterion("csm_functions between", value1, value2, "csmFunctions");
	            return (Criteria) this;
	        }

	        public Criteria andcsmFunctionsNotBetween(String value1, String value2) {
	            addCriterion("csm_functions not between", value1, value2, "csmFunctions");
	            return (Criteria) this;
	        }
	        public Criteria andcsmBluetoothVersionIsNull() {
	            addCriterion("csm_bluetooth_version is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionIsNotNull() {
	            addCriterion("csm_bluetooth_version is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmBluetoothVersionEqualTo(Integer value) {
	            addCriterion("csm_bluetooth_version =", value, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionNotEqualTo(Integer value) {
	            addCriterion("csm_bluetooth_version <>", value, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionGreaterThan(Integer value) {
	            addCriterion("csm_bluetooth_version >", value, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_bluetooth_version >=", value, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionLessThan(Integer value) {
	            addCriterion("csm_bluetooth_version <", value, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_bluetooth_version <=", value, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionIn(List<Integer> values) {
	            addCriterion("csm_bluetooth_version in", values, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionNotIn(List<Integer> values) {
	            addCriterion("csm_bluetooth_version not in", values, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionBetween(Integer value1, Integer value2) {
	            addCriterion("csm_bluetooth_version between", value1, value2, "csmBluetoothVersion");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothVersionNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_bluetooth_version not between", value1, value2, "csmBluetoothVersion");
	            return (Criteria) this;
	        }
	        public Criteria andcsmBluetoothMacIsNull() {
	            addCriterion("csm_bluetooth_mac is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacIsNotNull() {
	            addCriterion("csm_bluetooth_mac is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmBluetoothMacLike(String value) {
	            addCriterion("csm_bluetooth_mac like", "%"+value+"%", "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacNotLike(String value) {
	            addCriterion("csm_bluetooth_mac not like", "%"+value+"%", "csmBluetoothMac");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmBluetoothMacEqualTo(String value) {
	            addCriterion("csm_bluetooth_mac =", value, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacNotEqualTo(String value) {
	            addCriterion("csm_bluetooth_mac <>", value, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacGreaterThan(String value) {
	            addCriterion("csm_bluetooth_mac >", value, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_bluetooth_mac >=", value, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacLessThan(String value) {
	            addCriterion("csm_bluetooth_mac <", value, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacLessThanOrEqualTo(String value) {
	            addCriterion("csm_bluetooth_mac <=", value, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacIn(List<String> values) {
	            addCriterion("csm_bluetooth_mac in", values, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacNotIn(List<String> values) {
	            addCriterion("csm_bluetooth_mac not in", values, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacBetween(String value1, String value2) {
	            addCriterion("csm_bluetooth_mac between", value1, value2, "csmBluetoothMac");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothMacNotBetween(String value1, String value2) {
	            addCriterion("csm_bluetooth_mac not between", value1, value2, "csmBluetoothMac");
	            return (Criteria) this;
	        }
	        public Criteria andcsmBluetoothPsdIsNull() {
	            addCriterion("csm_bluetooth_psd is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdIsNotNull() {
	            addCriterion("csm_bluetooth_psd is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmBluetoothPsdLike(String value) {
	            addCriterion("csm_bluetooth_psd like", "%"+value+"%", "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdNotLike(String value) {
	            addCriterion("csm_bluetooth_psd not like", "%"+value+"%", "csmBluetoothPsd");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmBluetoothPsdEqualTo(String value) {
	            addCriterion("csm_bluetooth_psd =", value, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdNotEqualTo(String value) {
	            addCriterion("csm_bluetooth_psd <>", value, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdGreaterThan(String value) {
	            addCriterion("csm_bluetooth_psd >", value, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_bluetooth_psd >=", value, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdLessThan(String value) {
	            addCriterion("csm_bluetooth_psd <", value, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdLessThanOrEqualTo(String value) {
	            addCriterion("csm_bluetooth_psd <=", value, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdIn(List<String> values) {
	            addCriterion("csm_bluetooth_psd in", values, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdNotIn(List<String> values) {
	            addCriterion("csm_bluetooth_psd not in", values, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdBetween(String value1, String value2) {
	            addCriterion("csm_bluetooth_psd between", value1, value2, "csmBluetoothPsd");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBluetoothPsdNotBetween(String value1, String value2) {
	            addCriterion("csm_bluetooth_psd not between", value1, value2, "csmBluetoothPsd");
	            return (Criteria) this;
	        }
	        public Criteria andcsmMqttFlagIsNull() {
	            addCriterion("csm_mqtt_flag is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagIsNotNull() {
	            addCriterion("csm_mqtt_flag is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmMqttFlagLike(String value) {
	            addCriterion("csm_mqtt_flag like", "%"+value+"%", "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagNotLike(String value) {
	            addCriterion("csm_mqtt_flag not like", "%"+value+"%", "csmMqttFlag");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmMqttFlagEqualTo(String value) {
	            addCriterion("csm_mqtt_flag =", value, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagNotEqualTo(String value) {
	            addCriterion("csm_mqtt_flag <>", value, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagGreaterThan(String value) {
	            addCriterion("csm_mqtt_flag >", value, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_mqtt_flag >=", value, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagLessThan(String value) {
	            addCriterion("csm_mqtt_flag <", value, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagLessThanOrEqualTo(String value) {
	            addCriterion("csm_mqtt_flag <=", value, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagIn(List<String> values) {
	            addCriterion("csm_mqtt_flag in", values, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagNotIn(List<String> values) {
	            addCriterion("csm_mqtt_flag not in", values, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagBetween(String value1, String value2) {
	            addCriterion("csm_mqtt_flag between", value1, value2, "csmMqttFlag");
	            return (Criteria) this;
	        }

	        public Criteria andcsmMqttFlagNotBetween(String value1, String value2) {
	            addCriterion("csm_mqtt_flag not between", value1, value2, "csmMqttFlag");
	            return (Criteria) this;
	        }
	        public Criteria andcsmSuperSimIsNull() {
	            addCriterion("csm_super_sim is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimIsNotNull() {
	            addCriterion("csm_super_sim is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmSuperSimLike(String value) {
	            addCriterion("csm_super_sim like", "%"+value+"%", "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimNotLike(String value) {
	            addCriterion("csm_super_sim not like", "%"+value+"%", "csmSuperSim");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmSuperSimEqualTo(String value) {
	            addCriterion("csm_super_sim =", value, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimNotEqualTo(String value) {
	            addCriterion("csm_super_sim <>", value, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimGreaterThan(String value) {
	            addCriterion("csm_super_sim >", value, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_super_sim >=", value, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimLessThan(String value) {
	            addCriterion("csm_super_sim <", value, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimLessThanOrEqualTo(String value) {
	            addCriterion("csm_super_sim <=", value, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimIn(List<String> values) {
	            addCriterion("csm_super_sim in", values, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimNotIn(List<String> values) {
	            addCriterion("csm_super_sim not in", values, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimBetween(String value1, String value2) {
	            addCriterion("csm_super_sim between", value1, value2, "csmSuperSim");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuperSimNotBetween(String value1, String value2) {
	            addCriterion("csm_super_sim not between", value1, value2, "csmSuperSim");
	            return (Criteria) this;
	        }
	        public Criteria andcsmV2IsNull() {
	            addCriterion("csm_v2 is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2IsNotNull() {
	            addCriterion("csm_v2 is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmV2Like(String value) {
	            addCriterion("csm_v2 like", "%"+value+"%", "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2NotLike(String value) {
	            addCriterion("csm_v2 not like", "%"+value+"%", "csmV2");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmV2EqualTo(String value) {
	            addCriterion("csm_v2 =", value, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2NotEqualTo(String value) {
	            addCriterion("csm_v2 <>", value, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2GreaterThan(String value) {
	            addCriterion("csm_v2 >", value, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2GreaterThanOrEqualTo(String value) {
	            addCriterion("csm_v2 >=", value, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2LessThan(String value) {
	            addCriterion("csm_v2 <", value, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2LessThanOrEqualTo(String value) {
	            addCriterion("csm_v2 <=", value, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2In(List<String> values) {
	            addCriterion("csm_v2 in", values, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2NotIn(List<String> values) {
	            addCriterion("csm_v2 not in", values, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2Between(String value1, String value2) {
	            addCriterion("csm_v2 between", value1, value2, "csmV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV2NotBetween(String value1, String value2) {
	            addCriterion("csm_v2 not between", value1, value2, "csmV2");
	            return (Criteria) this;
	        }
	        public Criteria andcsmV3IsNull() {
	            addCriterion("csm_v3 is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3IsNotNull() {
	            addCriterion("csm_v3 is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmV3Like(String value) {
	            addCriterion("csm_v3 like", "%"+value+"%", "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3NotLike(String value) {
	            addCriterion("csm_v3 not like", "%"+value+"%", "csmV3");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmV3EqualTo(String value) {
	            addCriterion("csm_v3 =", value, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3NotEqualTo(String value) {
	            addCriterion("csm_v3 <>", value, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3GreaterThan(String value) {
	            addCriterion("csm_v3 >", value, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3GreaterThanOrEqualTo(String value) {
	            addCriterion("csm_v3 >=", value, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3LessThan(String value) {
	            addCriterion("csm_v3 <", value, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3LessThanOrEqualTo(String value) {
	            addCriterion("csm_v3 <=", value, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3In(List<String> values) {
	            addCriterion("csm_v3 in", values, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3NotIn(List<String> values) {
	            addCriterion("csm_v3 not in", values, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3Between(String value1, String value2) {
	            addCriterion("csm_v3 between", value1, value2, "csmV3");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3NotBetween(String value1, String value2) {
	            addCriterion("csm_v3 not between", value1, value2, "csmV3");
	            return (Criteria) this;
	        }
	        public Criteria andcsmV3ToIsNull() {
	            addCriterion("csm_v3_to is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToIsNotNull() {
	            addCriterion("csm_v3_to is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmV3ToLike(String value) {
	            addCriterion("csm_v3_to like", "%"+value+"%", "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToNotLike(String value) {
	            addCriterion("csm_v3_to not like", "%"+value+"%", "csmV3To");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmV3ToEqualTo(String value) {
	            addCriterion("csm_v3_to =", value, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToNotEqualTo(String value) {
	            addCriterion("csm_v3_to <>", value, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToGreaterThan(String value) {
	            addCriterion("csm_v3_to >", value, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_v3_to >=", value, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToLessThan(String value) {
	            addCriterion("csm_v3_to <", value, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToLessThanOrEqualTo(String value) {
	            addCriterion("csm_v3_to <=", value, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToIn(List<String> values) {
	            addCriterion("csm_v3_to in", values, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToNotIn(List<String> values) {
	            addCriterion("csm_v3_to not in", values, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToBetween(String value1, String value2) {
	            addCriterion("csm_v3_to between", value1, value2, "csmV3To");
	            return (Criteria) this;
	        }

	        public Criteria andcsmV3ToNotBetween(String value1, String value2) {
	            addCriterion("csm_v3_to not between", value1, value2, "csmV3To");
	            return (Criteria) this;
	        }
	        public Criteria andcsmSuitIsNull() {
	            addCriterion("csm_suit is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitIsNotNull() {
	            addCriterion("csm_suit is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmSuitEqualTo(Integer value) {
	            addCriterion("csm_suit =", value, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitNotEqualTo(Integer value) {
	            addCriterion("csm_suit <>", value, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitGreaterThan(Integer value) {
	            addCriterion("csm_suit >", value, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_suit >=", value, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitLessThan(Integer value) {
	            addCriterion("csm_suit <", value, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_suit <=", value, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitIn(List<Integer> values) {
	            addCriterion("csm_suit in", values, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitNotIn(List<Integer> values) {
	            addCriterion("csm_suit not in", values, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitBetween(Integer value1, Integer value2) {
	            addCriterion("csm_suit between", value1, value2, "csmSuit");
	            return (Criteria) this;
	        }

	        public Criteria andcsmSuitNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_suit not between", value1, value2, "csmSuit");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTlV1IsNull() {
	            addCriterion("csm_tl_v1 is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1IsNotNull() {
	            addCriterion("csm_tl_v1 is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTlV1Like(String value) {
	            addCriterion("csm_tl_v1 like", "%"+value+"%", "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1NotLike(String value) {
	            addCriterion("csm_tl_v1 not like", "%"+value+"%", "csmTlV1");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmTlV1EqualTo(String value) {
	            addCriterion("csm_tl_v1 =", value, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1NotEqualTo(String value) {
	            addCriterion("csm_tl_v1 <>", value, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1GreaterThan(String value) {
	            addCriterion("csm_tl_v1 >", value, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1GreaterThanOrEqualTo(String value) {
	            addCriterion("csm_tl_v1 >=", value, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1LessThan(String value) {
	            addCriterion("csm_tl_v1 <", value, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1LessThanOrEqualTo(String value) {
	            addCriterion("csm_tl_v1 <=", value, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1In(List<String> values) {
	            addCriterion("csm_tl_v1 in", values, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1NotIn(List<String> values) {
	            addCriterion("csm_tl_v1 not in", values, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1Between(String value1, String value2) {
	            addCriterion("csm_tl_v1 between", value1, value2, "csmTlV1");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV1NotBetween(String value1, String value2) {
	            addCriterion("csm_tl_v1 not between", value1, value2, "csmTlV1");
	            return (Criteria) this;
	        }
	        public Criteria andcsmTlV2IsNull() {
	            addCriterion("csm_tl_v2 is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2IsNotNull() {
	            addCriterion("csm_tl_v2 is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmTlV2EqualTo(Integer value) {
	            addCriterion("csm_tl_v2 =", value, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2NotEqualTo(Integer value) {
	            addCriterion("csm_tl_v2 <>", value, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2GreaterThan(Integer value) {
	            addCriterion("csm_tl_v2 >", value, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2GreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_tl_v2 >=", value, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2LessThan(Integer value) {
	            addCriterion("csm_tl_v2 <", value, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2LessThanOrEqualTo(Integer value) {
	            addCriterion("csm_tl_v2 <=", value, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2In(List<Integer> values) {
	            addCriterion("csm_tl_v2 in", values, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2NotIn(List<Integer> values) {
	            addCriterion("csm_tl_v2 not in", values, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2Between(Integer value1, Integer value2) {
	            addCriterion("csm_tl_v2 between", value1, value2, "csmTlV2");
	            return (Criteria) this;
	        }

	        public Criteria andcsmTlV2NotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_tl_v2 not between", value1, value2, "csmTlV2");
	            return (Criteria) this;
	        }
	        public Criteria andcsmNetTypeIsNull() {
	            addCriterion("csm_net_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeIsNotNull() {
	            addCriterion("csm_net_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmNetTypeEqualTo(Short value) {
	            addCriterion("csm_net_type =", value, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeNotEqualTo(Short value) {
	            addCriterion("csm_net_type <>", value, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeGreaterThan(Short value) {
	            addCriterion("csm_net_type >", value, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_net_type >=", value, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeLessThan(Short value) {
	            addCriterion("csm_net_type <", value, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeLessThanOrEqualTo(Short value) {
	            addCriterion("csm_net_type <=", value, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeIn(List<Short> values) {
	            addCriterion("csm_net_type in", values, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeNotIn(List<Short> values) {
	            addCriterion("csm_net_type not in", values, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeBetween(Short value1, Short value2) {
	            addCriterion("csm_net_type between", value1, value2, "csmNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmNetTypeNotBetween(Short value1, Short value2) {
	            addCriterion("csm_net_type not between", value1, value2, "csmNetType");
	            return (Criteria) this;
	        }
	        public Criteria andcsmProTypeIsNull() {
	            addCriterion("csm_pro_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeIsNotNull() {
	            addCriterion("csm_pro_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmProTypeEqualTo(Short value) {
	            addCriterion("csm_pro_type =", value, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeNotEqualTo(Short value) {
	            addCriterion("csm_pro_type <>", value, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeGreaterThan(Short value) {
	            addCriterion("csm_pro_type >", value, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_pro_type >=", value, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeLessThan(Short value) {
	            addCriterion("csm_pro_type <", value, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeLessThanOrEqualTo(Short value) {
	            addCriterion("csm_pro_type <=", value, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeIn(List<Short> values) {
	            addCriterion("csm_pro_type in", values, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeNotIn(List<Short> values) {
	            addCriterion("csm_pro_type not in", values, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeBetween(Short value1, Short value2) {
	            addCriterion("csm_pro_type between", value1, value2, "csmProType");
	            return (Criteria) this;
	        }

	        public Criteria andcsmProTypeNotBetween(Short value1, Short value2) {
	            addCriterion("csm_pro_type not between", value1, value2, "csmProType");
	            return (Criteria) this;
	        }
	        public Criteria andcsmBaudRateIsNull() {
	            addCriterion("csm_baud_rate is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateIsNotNull() {
	            addCriterion("csm_baud_rate is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmBaudRateEqualTo(Integer value) {
	            addCriterion("csm_baud_rate =", value, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateNotEqualTo(Integer value) {
	            addCriterion("csm_baud_rate <>", value, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateGreaterThan(Integer value) {
	            addCriterion("csm_baud_rate >", value, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateGreaterThanOrEqualTo(Integer value) {
	            addCriterion("csm_baud_rate >=", value, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateLessThan(Integer value) {
	            addCriterion("csm_baud_rate <", value, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateLessThanOrEqualTo(Integer value) {
	            addCriterion("csm_baud_rate <=", value, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateIn(List<Integer> values) {
	            addCriterion("csm_baud_rate in", values, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateNotIn(List<Integer> values) {
	            addCriterion("csm_baud_rate not in", values, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateBetween(Integer value1, Integer value2) {
	            addCriterion("csm_baud_rate between", value1, value2, "csmBaudRate");
	            return (Criteria) this;
	        }

	        public Criteria andcsmBaudRateNotBetween(Integer value1, Integer value2) {
	            addCriterion("csm_baud_rate not between", value1, value2, "csmBaudRate");
	            return (Criteria) this;
	        }
	        public Criteria andcsmRemarkIsNull() {
	            addCriterion("csm_remark is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkIsNotNull() {
	            addCriterion("csm_remark is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmRemarkLike(String value) {
	            addCriterion("csm_remark like", "%"+value+"%", "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkNotLike(String value) {
	            addCriterion("csm_remark not like", "%"+value+"%", "csmRemark");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcsmRemarkEqualTo(String value) {
	            addCriterion("csm_remark =", value, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkNotEqualTo(String value) {
	            addCriterion("csm_remark <>", value, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkGreaterThan(String value) {
	            addCriterion("csm_remark >", value, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkGreaterThanOrEqualTo(String value) {
	            addCriterion("csm_remark >=", value, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkLessThan(String value) {
	            addCriterion("csm_remark <", value, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkLessThanOrEqualTo(String value) {
	            addCriterion("csm_remark <=", value, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkIn(List<String> values) {
	            addCriterion("csm_remark in", values, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkNotIn(List<String> values) {
	            addCriterion("csm_remark not in", values, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkBetween(String value1, String value2) {
	            addCriterion("csm_remark between", value1, value2, "csmRemark");
	            return (Criteria) this;
	        }

	        public Criteria andcsmRemarkNotBetween(String value1, String value2) {
	            addCriterion("csm_remark not between", value1, value2, "csmRemark");
	            return (Criteria) this;
	        }
	        public Criteria andcsmUpdateTimeIsNull() {
	            addCriterion("csm_update_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeIsNotNull() {
	            addCriterion("csm_update_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmUpdateTimeEqualTo(Date value) {
	            addCriterion("csm_update_time =", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeNotEqualTo(Date value) {
	            addCriterion("csm_update_time <>", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeGreaterThan(Date value) {
	            addCriterion("csm_update_time >", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csm_update_time >=", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeLessThan(Date value) {
	            addCriterion("csm_update_time <", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csm_update_time <=", value, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeIn(List<Date> values) {
	            addCriterion("csm_update_time in", values, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeNotIn(List<Date> values) {
	            addCriterion("csm_update_time not in", values, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeBetween(Date value1, Date value2) {
	            addCriterion("csm_update_time between", value1, value2, "csmUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmUpdateTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csm_update_time not between", value1, value2, "csmUpdateTime");
	            return (Criteria) this;
	        }
	        public Criteria andcsmAddTimeIsNull() {
	            addCriterion("csm_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeIsNotNull() {
	            addCriterion("csm_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmAddTimeEqualTo(Date value) {
	            addCriterion("csm_add_time =", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeNotEqualTo(Date value) {
	            addCriterion("csm_add_time <>", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeGreaterThan(Date value) {
	            addCriterion("csm_add_time >", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("csm_add_time >=", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeLessThan(Date value) {
	            addCriterion("csm_add_time <", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("csm_add_time <=", value, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeIn(List<Date> values) {
	            addCriterion("csm_add_time in", values, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeNotIn(List<Date> values) {
	            addCriterion("csm_add_time not in", values, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeBetween(Date value1, Date value2) {
	            addCriterion("csm_add_time between", value1, value2, "csmAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcsmAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("csm_add_time not between", value1, value2, "csmAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andcsmStatusIsNull() {
	            addCriterion("csm_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusIsNotNull() {
	            addCriterion("csm_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcsmStatusEqualTo(Short value) {
	            addCriterion("csm_status =", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusNotEqualTo(Short value) {
	            addCriterion("csm_status <>", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusGreaterThan(Short value) {
	            addCriterion("csm_status >", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("csm_status >=", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusLessThan(Short value) {
	            addCriterion("csm_status <", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusLessThanOrEqualTo(Short value) {
	            addCriterion("csm_status <=", value, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusIn(List<Short> values) {
	            addCriterion("csm_status in", values, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusNotIn(List<Short> values) {
	            addCriterion("csm_status not in", values, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusBetween(Short value1, Short value2) {
	            addCriterion("csm_status between", value1, value2, "csmStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcsmStatusNotBetween(Short value1, Short value2) {
	            addCriterion("csm_status not between", value1, value2, "csmStatus");
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