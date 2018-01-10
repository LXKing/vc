package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * TBox注册信息数据查询条件对象
 * @author Joel
 */
public class CsTerminalCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsTerminalCrieria() {
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
	        public Criteria andcstIdIsNull() {
	            addCriterion("cst_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdIsNotNull() {
	            addCriterion("cst_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcstIdEqualTo(Long value) {
	            addCriterion("cst_id =", value, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdNotEqualTo(Long value) {
	            addCriterion("cst_id <>", value, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdGreaterThan(Long value) {
	            addCriterion("cst_id >", value, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("cst_id >=", value, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdLessThan(Long value) {
	            addCriterion("cst_id <", value, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdLessThanOrEqualTo(Long value) {
	            addCriterion("cst_id <=", value, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdIn(List<Long> values) {
	            addCriterion("cst_id in", values, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdNotIn(List<Long> values) {
	            addCriterion("cst_id not in", values, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdBetween(Long value1, Long value2) {
	            addCriterion("cst_id between", value1, value2, "cstId");
	            return (Criteria) this;
	        }

	        public Criteria andcstIdNotBetween(Long value1, Long value2) {
	            addCriterion("cst_id not between", value1, value2, "cstId");
	            return (Criteria) this;
	        }
	        public Criteria andcstIddIsNull() {
	            addCriterion("cst_idd is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddIsNotNull() {
	            addCriterion("cst_idd is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstIddLike(String value) {
	            addCriterion("cst_idd like", "%"+value+"%", "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddNotLike(String value) {
	            addCriterion("cst_idd not like", "%"+value+"%", "cstIdd");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstIddEqualTo(String value) {
	            addCriterion("cst_idd =", value, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddNotEqualTo(String value) {
	            addCriterion("cst_idd <>", value, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddGreaterThan(String value) {
	            addCriterion("cst_idd >", value, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddGreaterThanOrEqualTo(String value) {
	            addCriterion("cst_idd >=", value, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddLessThan(String value) {
	            addCriterion("cst_idd <", value, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddLessThanOrEqualTo(String value) {
	            addCriterion("cst_idd <=", value, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddIn(List<String> values) {
	            addCriterion("cst_idd in", values, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddNotIn(List<String> values) {
	            addCriterion("cst_idd not in", values, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddBetween(String value1, String value2) {
	            addCriterion("cst_idd between", value1, value2, "cstIdd");
	            return (Criteria) this;
	        }

	        public Criteria andcstIddNotBetween(String value1, String value2) {
	            addCriterion("cst_idd not between", value1, value2, "cstIdd");
	            return (Criteria) this;
	        }
	        public Criteria andcstModelIsNull() {
	            addCriterion("cst_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelIsNotNull() {
	            addCriterion("cst_model is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstModelLike(String value) {
	            addCriterion("cst_model like", "%"+value+"%", "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelNotLike(String value) {
	            addCriterion("cst_model not like", "%"+value+"%", "cstModel");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstModelEqualTo(String value) {
	            addCriterion("cst_model =", value, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelNotEqualTo(String value) {
	            addCriterion("cst_model <>", value, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelGreaterThan(String value) {
	            addCriterion("cst_model >", value, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelGreaterThanOrEqualTo(String value) {
	            addCriterion("cst_model >=", value, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelLessThan(String value) {
	            addCriterion("cst_model <", value, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelLessThanOrEqualTo(String value) {
	            addCriterion("cst_model <=", value, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelIn(List<String> values) {
	            addCriterion("cst_model in", values, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelNotIn(List<String> values) {
	            addCriterion("cst_model not in", values, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelBetween(String value1, String value2) {
	            addCriterion("cst_model between", value1, value2, "cstModel");
	            return (Criteria) this;
	        }

	        public Criteria andcstModelNotBetween(String value1, String value2) {
	            addCriterion("cst_model not between", value1, value2, "cstModel");
	            return (Criteria) this;
	        }
	        public Criteria andcstMadeIsNull() {
	            addCriterion("cst_made is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeIsNotNull() {
	            addCriterion("cst_made is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstMadeLike(String value) {
	            addCriterion("cst_made like", "%"+value+"%", "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeNotLike(String value) {
	            addCriterion("cst_made not like", "%"+value+"%", "cstMade");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstMadeEqualTo(String value) {
	            addCriterion("cst_made =", value, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeNotEqualTo(String value) {
	            addCriterion("cst_made <>", value, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeGreaterThan(String value) {
	            addCriterion("cst_made >", value, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeGreaterThanOrEqualTo(String value) {
	            addCriterion("cst_made >=", value, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeLessThan(String value) {
	            addCriterion("cst_made <", value, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeLessThanOrEqualTo(String value) {
	            addCriterion("cst_made <=", value, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeIn(List<String> values) {
	            addCriterion("cst_made in", values, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeNotIn(List<String> values) {
	            addCriterion("cst_made not in", values, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeBetween(String value1, String value2) {
	            addCriterion("cst_made between", value1, value2, "cstMade");
	            return (Criteria) this;
	        }

	        public Criteria andcstMadeNotBetween(String value1, String value2) {
	            addCriterion("cst_made not between", value1, value2, "cstMade");
	            return (Criteria) this;
	        }
	        public Criteria andcstProvinceIsNull() {
	            addCriterion("cst_province is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceIsNotNull() {
	            addCriterion("cst_province is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstProvinceLike(String value) {
	            addCriterion("cst_province like", "%"+value+"%", "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceNotLike(String value) {
	            addCriterion("cst_province not like", "%"+value+"%", "cstProvince");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstProvinceEqualTo(String value) {
	            addCriterion("cst_province =", value, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceNotEqualTo(String value) {
	            addCriterion("cst_province <>", value, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceGreaterThan(String value) {
	            addCriterion("cst_province >", value, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceGreaterThanOrEqualTo(String value) {
	            addCriterion("cst_province >=", value, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceLessThan(String value) {
	            addCriterion("cst_province <", value, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceLessThanOrEqualTo(String value) {
	            addCriterion("cst_province <=", value, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceIn(List<String> values) {
	            addCriterion("cst_province in", values, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceNotIn(List<String> values) {
	            addCriterion("cst_province not in", values, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceBetween(String value1, String value2) {
	            addCriterion("cst_province between", value1, value2, "cstProvince");
	            return (Criteria) this;
	        }

	        public Criteria andcstProvinceNotBetween(String value1, String value2) {
	            addCriterion("cst_province not between", value1, value2, "cstProvince");
	            return (Criteria) this;
	        }
	        public Criteria andcstCityIsNull() {
	            addCriterion("cst_city is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityIsNotNull() {
	            addCriterion("cst_city is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstCityLike(String value) {
	            addCriterion("cst_city like", "%"+value+"%", "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityNotLike(String value) {
	            addCriterion("cst_city not like", "%"+value+"%", "cstCity");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstCityEqualTo(String value) {
	            addCriterion("cst_city =", value, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityNotEqualTo(String value) {
	            addCriterion("cst_city <>", value, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityGreaterThan(String value) {
	            addCriterion("cst_city >", value, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityGreaterThanOrEqualTo(String value) {
	            addCriterion("cst_city >=", value, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityLessThan(String value) {
	            addCriterion("cst_city <", value, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityLessThanOrEqualTo(String value) {
	            addCriterion("cst_city <=", value, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityIn(List<String> values) {
	            addCriterion("cst_city in", values, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityNotIn(List<String> values) {
	            addCriterion("cst_city not in", values, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityBetween(String value1, String value2) {
	            addCriterion("cst_city between", value1, value2, "cstCity");
	            return (Criteria) this;
	        }

	        public Criteria andcstCityNotBetween(String value1, String value2) {
	            addCriterion("cst_city not between", value1, value2, "cstCity");
	            return (Criteria) this;
	        }
	        public Criteria andcstColorIsNull() {
	            addCriterion("cst_color is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorIsNotNull() {
	            addCriterion("cst_color is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcstColorEqualTo(Short value) {
	            addCriterion("cst_color =", value, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorNotEqualTo(Short value) {
	            addCriterion("cst_color <>", value, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorGreaterThan(Short value) {
	            addCriterion("cst_color >", value, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorGreaterThanOrEqualTo(Short value) {
	            addCriterion("cst_color >=", value, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorLessThan(Short value) {
	            addCriterion("cst_color <", value, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorLessThanOrEqualTo(Short value) {
	            addCriterion("cst_color <=", value, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorIn(List<Short> values) {
	            addCriterion("cst_color in", values, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorNotIn(List<Short> values) {
	            addCriterion("cst_color not in", values, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorBetween(Short value1, Short value2) {
	            addCriterion("cst_color between", value1, value2, "cstColor");
	            return (Criteria) this;
	        }

	        public Criteria andcstColorNotBetween(Short value1, Short value2) {
	            addCriterion("cst_color not between", value1, value2, "cstColor");
	            return (Criteria) this;
	        }
	        public Criteria andcstNumberIsNull() {
	            addCriterion("cst_number is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberIsNotNull() {
	            addCriterion("cst_number is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstNumberLike(String value) {
	            addCriterion("cst_number like", "%"+value+"%", "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberNotLike(String value) {
	            addCriterion("cst_number not like", "%"+value+"%", "cstNumber");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstNumberEqualTo(String value) {
	            addCriterion("cst_number =", value, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberNotEqualTo(String value) {
	            addCriterion("cst_number <>", value, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberGreaterThan(String value) {
	            addCriterion("cst_number >", value, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberGreaterThanOrEqualTo(String value) {
	            addCriterion("cst_number >=", value, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberLessThan(String value) {
	            addCriterion("cst_number <", value, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberLessThanOrEqualTo(String value) {
	            addCriterion("cst_number <=", value, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberIn(List<String> values) {
	            addCriterion("cst_number in", values, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberNotIn(List<String> values) {
	            addCriterion("cst_number not in", values, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberBetween(String value1, String value2) {
	            addCriterion("cst_number between", value1, value2, "cstNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcstNumberNotBetween(String value1, String value2) {
	            addCriterion("cst_number not between", value1, value2, "cstNumber");
	            return (Criteria) this;
	        }
	        public Criteria andcstMobileIsNull() {
	            addCriterion("cst_mobile is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileIsNotNull() {
	            addCriterion("cst_mobile is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstMobileLike(String value) {
	            addCriterion("cst_mobile like", "%"+value+"%", "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileNotLike(String value) {
	            addCriterion("cst_mobile not like", "%"+value+"%", "cstMobile");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcstMobileEqualTo(String value) {
	            addCriterion("cst_mobile =", value, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileNotEqualTo(String value) {
	            addCriterion("cst_mobile <>", value, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileGreaterThan(String value) {
	            addCriterion("cst_mobile >", value, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileGreaterThanOrEqualTo(String value) {
	            addCriterion("cst_mobile >=", value, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileLessThan(String value) {
	            addCriterion("cst_mobile <", value, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileLessThanOrEqualTo(String value) {
	            addCriterion("cst_mobile <=", value, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileIn(List<String> values) {
	            addCriterion("cst_mobile in", values, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileNotIn(List<String> values) {
	            addCriterion("cst_mobile not in", values, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileBetween(String value1, String value2) {
	            addCriterion("cst_mobile between", value1, value2, "cstMobile");
	            return (Criteria) this;
	        }

	        public Criteria andcstMobileNotBetween(String value1, String value2) {
	            addCriterion("cst_mobile not between", value1, value2, "cstMobile");
	            return (Criteria) this;
	        }
	        public Criteria andcstUpdateTimeIsNull() {
	            addCriterion("cst_update_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeIsNotNull() {
	            addCriterion("cst_update_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcstUpdateTimeEqualTo(Date value) {
	            addCriterion("cst_update_time =", value, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeNotEqualTo(Date value) {
	            addCriterion("cst_update_time <>", value, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeGreaterThan(Date value) {
	            addCriterion("cst_update_time >", value, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("cst_update_time >=", value, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeLessThan(Date value) {
	            addCriterion("cst_update_time <", value, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeLessThanOrEqualTo(Date value) {
	            addCriterion("cst_update_time <=", value, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeIn(List<Date> values) {
	            addCriterion("cst_update_time in", values, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeNotIn(List<Date> values) {
	            addCriterion("cst_update_time not in", values, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeBetween(Date value1, Date value2) {
	            addCriterion("cst_update_time between", value1, value2, "cstUpdateTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstUpdateTimeNotBetween(Date value1, Date value2) {
	            addCriterion("cst_update_time not between", value1, value2, "cstUpdateTime");
	            return (Criteria) this;
	        }
	        public Criteria andcstAddTimeIsNull() {
	            addCriterion("cst_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeIsNotNull() {
	            addCriterion("cst_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcstAddTimeEqualTo(Date value) {
	            addCriterion("cst_add_time =", value, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeNotEqualTo(Date value) {
	            addCriterion("cst_add_time <>", value, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeGreaterThan(Date value) {
	            addCriterion("cst_add_time >", value, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("cst_add_time >=", value, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeLessThan(Date value) {
	            addCriterion("cst_add_time <", value, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("cst_add_time <=", value, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeIn(List<Date> values) {
	            addCriterion("cst_add_time in", values, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeNotIn(List<Date> values) {
	            addCriterion("cst_add_time not in", values, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeBetween(Date value1, Date value2) {
	            addCriterion("cst_add_time between", value1, value2, "cstAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcstAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("cst_add_time not between", value1, value2, "cstAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andcstStatusIsNull() {
	            addCriterion("cst_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusIsNotNull() {
	            addCriterion("cst_status is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcstStatusEqualTo(Short value) {
	            addCriterion("cst_status =", value, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusNotEqualTo(Short value) {
	            addCriterion("cst_status <>", value, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusGreaterThan(Short value) {
	            addCriterion("cst_status >", value, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusGreaterThanOrEqualTo(Short value) {
	            addCriterion("cst_status >=", value, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusLessThan(Short value) {
	            addCriterion("cst_status <", value, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusLessThanOrEqualTo(Short value) {
	            addCriterion("cst_status <=", value, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusIn(List<Short> values) {
	            addCriterion("cst_status in", values, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusNotIn(List<Short> values) {
	            addCriterion("cst_status not in", values, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusBetween(Short value1, Short value2) {
	            addCriterion("cst_status between", value1, value2, "cstStatus");
	            return (Criteria) this;
	        }

	        public Criteria andcstStatusNotBetween(Short value1, Short value2) {
	            addCriterion("cst_status not between", value1, value2, "cstStatus");
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