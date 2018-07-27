package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车辆信息管理数据查询条件对象
 * @author Joel
 */
public class VerUpgradeCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public VerUpgradeCrieria() {
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
	        public Criteria andsoftVerIdIsNull() {
	            addCriterion("soft_ver_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdIsNotNull() {
	            addCriterion("soft_ver_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andsoftVerIdEqualTo(Integer value) {
	            addCriterion("soft_ver_id =", value, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdNotEqualTo(Integer value) {
	            addCriterion("soft_ver_id <>", value, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdGreaterThan(Integer value) {
	            addCriterion("soft_ver_id >", value, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("soft_ver_id >=", value, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdLessThan(Integer value) {
	            addCriterion("soft_ver_id <", value, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdLessThanOrEqualTo(Integer value) {
	            addCriterion("soft_ver_id <=", value, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdIn(List<Integer> values) {
	            addCriterion("soft_ver_id in", values, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdNotIn(List<Integer> values) {
	            addCriterion("soft_ver_id not in", values, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdBetween(Integer value1, Integer value2) {
	            addCriterion("soft_ver_id between", value1, value2, "softVerId");
	            return (Criteria) this;
	        }

	        public Criteria andsoftVerIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("soft_ver_id not between", value1, value2, "softVerId");
	            return (Criteria) this;
	        }
	        public Criteria andhardVerIdIsNull() {
	            addCriterion("hard_ver_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdIsNotNull() {
	            addCriterion("hard_ver_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andhardVerIdEqualTo(Integer value) {
	            addCriterion("hard_ver_id =", value, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdNotEqualTo(Integer value) {
	            addCriterion("hard_ver_id <>", value, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdGreaterThan(Integer value) {
	            addCriterion("hard_ver_id >", value, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("hard_ver_id >=", value, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdLessThan(Integer value) {
	            addCriterion("hard_ver_id <", value, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdLessThanOrEqualTo(Integer value) {
	            addCriterion("hard_ver_id <=", value, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdIn(List<Integer> values) {
	            addCriterion("hard_ver_id in", values, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdNotIn(List<Integer> values) {
	            addCriterion("hard_ver_id not in", values, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdBetween(Integer value1, Integer value2) {
	            addCriterion("hard_ver_id between", value1, value2, "hardVerId");
	            return (Criteria) this;
	        }

	        public Criteria andhardVerIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("hard_ver_id not between", value1, value2, "hardVerId");
	            return (Criteria) this;
	        }
	        public Criteria andbluetoothVerIdIsNull() {
	            addCriterion("bluetooth_ver_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdIsNotNull() {
	            addCriterion("bluetooth_ver_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andbluetoothVerIdEqualTo(Integer value) {
	            addCriterion("bluetooth_ver_id =", value, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdNotEqualTo(Integer value) {
	            addCriterion("bluetooth_ver_id <>", value, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdGreaterThan(Integer value) {
	            addCriterion("bluetooth_ver_id >", value, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("bluetooth_ver_id >=", value, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdLessThan(Integer value) {
	            addCriterion("bluetooth_ver_id <", value, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdLessThanOrEqualTo(Integer value) {
	            addCriterion("bluetooth_ver_id <=", value, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdIn(List<Integer> values) {
	            addCriterion("bluetooth_ver_id in", values, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdNotIn(List<Integer> values) {
	            addCriterion("bluetooth_ver_id not in", values, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdBetween(Integer value1, Integer value2) {
	            addCriterion("bluetooth_ver_id between", value1, value2, "bluetoothVerId");
	            return (Criteria) this;
	        }

	        public Criteria andbluetoothVerIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("bluetooth_ver_id not between", value1, value2, "bluetoothVerId");
	            return (Criteria) this;
	        }
	        public Criteria andmajorVersionIdIsNull() {
	            addCriterion("major_version_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdIsNotNull() {
	            addCriterion("major_version_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andmajorVersionIdEqualTo(Integer value) {
	            addCriterion("major_version_id =", value, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdNotEqualTo(Integer value) {
	            addCriterion("major_version_id <>", value, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdGreaterThan(Integer value) {
	            addCriterion("major_version_id >", value, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("major_version_id >=", value, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdLessThan(Integer value) {
	            addCriterion("major_version_id <", value, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdLessThanOrEqualTo(Integer value) {
	            addCriterion("major_version_id <=", value, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdIn(List<Integer> values) {
	            addCriterion("major_version_id in", values, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdNotIn(List<Integer> values) {
	            addCriterion("major_version_id not in", values, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdBetween(Integer value1, Integer value2) {
	            addCriterion("major_version_id between", value1, value2, "majorVersionId");
	            return (Criteria) this;
	        }

	        public Criteria andmajorVersionIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("major_version_id not between", value1, value2, "majorVersionId");
	            return (Criteria) this;
	        }
	        public Criteria andmodelIdIsNull() {
	            addCriterion("model_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdIsNotNull() {
	            addCriterion("model_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andmodelIdEqualTo(Integer value) {
	            addCriterion("model_id =", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdNotEqualTo(Integer value) {
	            addCriterion("model_id <>", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdGreaterThan(Integer value) {
	            addCriterion("model_id >", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("model_id >=", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdLessThan(Integer value) {
	            addCriterion("model_id <", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdLessThanOrEqualTo(Integer value) {
	            addCriterion("model_id <=", value, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdIn(List<Integer> values) {
	            addCriterion("model_id in", values, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdNotIn(List<Integer> values) {
	            addCriterion("model_id not in", values, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdBetween(Integer value1, Integer value2) {
	            addCriterion("model_id between", value1, value2, "modelId");
	            return (Criteria) this;
	        }

	        public Criteria andmodelIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("model_id not between", value1, value2, "modelId");
	            return (Criteria) this;
	        }
	        public Criteria andtelTypeIsNull() {
	            addCriterion("tel_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeIsNotNull() {
	            addCriterion("tel_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andtelTypeEqualTo(Short value) {
	            addCriterion("tel_type =", value, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeNotEqualTo(Short value) {
	            addCriterion("tel_type <>", value, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeGreaterThan(Short value) {
	            addCriterion("tel_type >", value, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("tel_type >=", value, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeLessThan(Short value) {
	            addCriterion("tel_type <", value, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeLessThanOrEqualTo(Short value) {
	            addCriterion("tel_type <=", value, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeIn(List<Short> values) {
	            addCriterion("tel_type in", values, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeNotIn(List<Short> values) {
	            addCriterion("tel_type not in", values, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeBetween(Short value1, Short value2) {
	            addCriterion("tel_type between", value1, value2, "telType");
	            return (Criteria) this;
	        }

	        public Criteria andtelTypeNotBetween(Short value1, Short value2) {
	            addCriterion("tel_type not between", value1, value2, "telType");
	            return (Criteria) this;
	        }
	        public Criteria andtelModelIsNull() {
	            addCriterion("tel_model is null");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelIsNotNull() {
	            addCriterion("tel_model is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andtelModelLike(String value) {
	            addCriterion("tel_model like", "%"+value+"%", "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelNotLike(String value) {
	            addCriterion("tel_model not like", "%"+value+"%", "telModel");
	            return (Criteria) this;
	        }
	        
	        public Criteria andtelModelEqualTo(String value) {
	            addCriterion("tel_model =", value, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelNotEqualTo(String value) {
	            addCriterion("tel_model <>", value, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelGreaterThan(String value) {
	            addCriterion("tel_model >", value, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelGreaterThanOrEqualTo(String value) {
	            addCriterion("tel_model >=", value, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelLessThan(String value) {
	            addCriterion("tel_model <", value, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelLessThanOrEqualTo(String value) {
	            addCriterion("tel_model <=", value, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelIn(List<String> values) {
	            addCriterion("tel_model in", values, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelNotIn(List<String> values) {
	            addCriterion("tel_model not in", values, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelBetween(String value1, String value2) {
	            addCriterion("tel_model between", value1, value2, "telModel");
	            return (Criteria) this;
	        }

	        public Criteria andtelModelNotBetween(String value1, String value2) {
	            addCriterion("tel_model not between", value1, value2, "telModel");
	            return (Criteria) this;
	        }
	        public Criteria andinnerVerIsNull() {
	            addCriterion("inner_ver is null");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerIsNotNull() {
	            addCriterion("inner_ver is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andinnerVerLike(String value) {
	            addCriterion("inner_ver like", "%"+value+"%", "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerNotLike(String value) {
	            addCriterion("inner_ver not like", "%"+value+"%", "innerVer");
	            return (Criteria) this;
	        }
	        
	        public Criteria andinnerVerEqualTo(String value) {
	            addCriterion("inner_ver =", value, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerNotEqualTo(String value) {
	            addCriterion("inner_ver <>", value, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerGreaterThan(String value) {
	            addCriterion("inner_ver >", value, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerGreaterThanOrEqualTo(String value) {
	            addCriterion("inner_ver >=", value, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerLessThan(String value) {
	            addCriterion("inner_ver <", value, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerLessThanOrEqualTo(String value) {
	            addCriterion("inner_ver <=", value, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerIn(List<String> values) {
	            addCriterion("inner_ver in", values, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerNotIn(List<String> values) {
	            addCriterion("inner_ver not in", values, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerBetween(String value1, String value2) {
	            addCriterion("inner_ver between", value1, value2, "innerVer");
	            return (Criteria) this;
	        }

	        public Criteria andinnerVerNotBetween(String value1, String value2) {
	            addCriterion("inner_ver not between", value1, value2, "innerVer");
	            return (Criteria) this;
	        }
	        public Criteria andisOpenIsNull() {
	            addCriterion("is_open is null");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenIsNotNull() {
	            addCriterion("is_open is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andisOpenEqualTo(Short value) {
	            addCriterion("is_open =", value, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenNotEqualTo(Short value) {
	            addCriterion("is_open <>", value, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenGreaterThan(Short value) {
	            addCriterion("is_open >", value, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenGreaterThanOrEqualTo(Short value) {
	            addCriterion("is_open >=", value, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenLessThan(Short value) {
	            addCriterion("is_open <", value, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenLessThanOrEqualTo(Short value) {
	            addCriterion("is_open <=", value, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenIn(List<Short> values) {
	            addCriterion("is_open in", values, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenNotIn(List<Short> values) {
	            addCriterion("is_open not in", values, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenBetween(Short value1, Short value2) {
	            addCriterion("is_open between", value1, value2, "isOpen");
	            return (Criteria) this;
	        }

	        public Criteria andisOpenNotBetween(Short value1, Short value2) {
	            addCriterion("is_open not between", value1, value2, "isOpen");
	            return (Criteria) this;
	        }
	        public Criteria anddesIsNull() {
	            addCriterion("des is null");
	            return (Criteria) this;
	        }

	        public Criteria anddesIsNotNull() {
	            addCriterion("des is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddesLike(String value) {
	            addCriterion("des like", "%"+value+"%", "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotLike(String value) {
	            addCriterion("des not like", "%"+value+"%", "des");
	            return (Criteria) this;
	        }
	        
	        public Criteria anddesEqualTo(String value) {
	            addCriterion("des =", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotEqualTo(String value) {
	            addCriterion("des <>", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesGreaterThan(String value) {
	            addCriterion("des >", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesGreaterThanOrEqualTo(String value) {
	            addCriterion("des >=", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesLessThan(String value) {
	            addCriterion("des <", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesLessThanOrEqualTo(String value) {
	            addCriterion("des <=", value, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesIn(List<String> values) {
	            addCriterion("des in", values, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotIn(List<String> values) {
	            addCriterion("des not in", values, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesBetween(String value1, String value2) {
	            addCriterion("des between", value1, value2, "des");
	            return (Criteria) this;
	        }

	        public Criteria anddesNotBetween(String value1, String value2) {
	            addCriterion("des not between", value1, value2, "des");
	            return (Criteria) this;
	        }
	        public Criteria andupVerNoIsNull() {
	            addCriterion("up_ver_no is null");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoIsNotNull() {
	            addCriterion("up_ver_no is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andupVerNoLike(String value) {
	            addCriterion("up_ver_no like", "%"+value+"%", "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoNotLike(String value) {
	            addCriterion("up_ver_no not like", "%"+value+"%", "upVerNo");
	            return (Criteria) this;
	        }
	        
	        public Criteria andupVerNoEqualTo(String value) {
	            addCriterion("up_ver_no =", value, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoNotEqualTo(String value) {
	            addCriterion("up_ver_no <>", value, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoGreaterThan(String value) {
	            addCriterion("up_ver_no >", value, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoGreaterThanOrEqualTo(String value) {
	            addCriterion("up_ver_no >=", value, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoLessThan(String value) {
	            addCriterion("up_ver_no <", value, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoLessThanOrEqualTo(String value) {
	            addCriterion("up_ver_no <=", value, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoIn(List<String> values) {
	            addCriterion("up_ver_no in", values, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoNotIn(List<String> values) {
	            addCriterion("up_ver_no not in", values, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoBetween(String value1, String value2) {
	            addCriterion("up_ver_no between", value1, value2, "upVerNo");
	            return (Criteria) this;
	        }

	        public Criteria andupVerNoNotBetween(String value1, String value2) {
	            addCriterion("up_ver_no not between", value1, value2, "upVerNo");
	            return (Criteria) this;
	        }
	        public Criteria andserFtpIdIsNull() {
	            addCriterion("ser_ftp_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdIsNotNull() {
	            addCriterion("ser_ftp_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andserFtpIdEqualTo(Integer value) {
	            addCriterion("ser_ftp_id =", value, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdNotEqualTo(Integer value) {
	            addCriterion("ser_ftp_id <>", value, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdGreaterThan(Integer value) {
	            addCriterion("ser_ftp_id >", value, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("ser_ftp_id >=", value, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdLessThan(Integer value) {
	            addCriterion("ser_ftp_id <", value, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdLessThanOrEqualTo(Integer value) {
	            addCriterion("ser_ftp_id <=", value, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdIn(List<Integer> values) {
	            addCriterion("ser_ftp_id in", values, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdNotIn(List<Integer> values) {
	            addCriterion("ser_ftp_id not in", values, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdBetween(Integer value1, Integer value2) {
	            addCriterion("ser_ftp_id between", value1, value2, "serFtpId");
	            return (Criteria) this;
	        }

	        public Criteria andserFtpIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("ser_ftp_id not between", value1, value2, "serFtpId");
	            return (Criteria) this;
	        }
	        public Criteria andperTimeoutIsNull() {
	            addCriterion("per_timeout is null");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutIsNotNull() {
	            addCriterion("per_timeout is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andperTimeoutEqualTo(Integer value) {
	            addCriterion("per_timeout =", value, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutNotEqualTo(Integer value) {
	            addCriterion("per_timeout <>", value, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutGreaterThan(Integer value) {
	            addCriterion("per_timeout >", value, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutGreaterThanOrEqualTo(Integer value) {
	            addCriterion("per_timeout >=", value, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutLessThan(Integer value) {
	            addCriterion("per_timeout <", value, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutLessThanOrEqualTo(Integer value) {
	            addCriterion("per_timeout <=", value, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutIn(List<Integer> values) {
	            addCriterion("per_timeout in", values, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutNotIn(List<Integer> values) {
	            addCriterion("per_timeout not in", values, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutBetween(Integer value1, Integer value2) {
	            addCriterion("per_timeout between", value1, value2, "perTimeout");
	            return (Criteria) this;
	        }

	        public Criteria andperTimeoutNotBetween(Integer value1, Integer value2) {
	            addCriterion("per_timeout not between", value1, value2, "perTimeout");
	            return (Criteria) this;
	        }
	        public Criteria andperMaxVehicleIsNull() {
	            addCriterion("per_max_vehicle is null");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleIsNotNull() {
	            addCriterion("per_max_vehicle is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andperMaxVehicleEqualTo(Integer value) {
	            addCriterion("per_max_vehicle =", value, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleNotEqualTo(Integer value) {
	            addCriterion("per_max_vehicle <>", value, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleGreaterThan(Integer value) {
	            addCriterion("per_max_vehicle >", value, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleGreaterThanOrEqualTo(Integer value) {
	            addCriterion("per_max_vehicle >=", value, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleLessThan(Integer value) {
	            addCriterion("per_max_vehicle <", value, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleLessThanOrEqualTo(Integer value) {
	            addCriterion("per_max_vehicle <=", value, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleIn(List<Integer> values) {
	            addCriterion("per_max_vehicle in", values, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleNotIn(List<Integer> values) {
	            addCriterion("per_max_vehicle not in", values, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleBetween(Integer value1, Integer value2) {
	            addCriterion("per_max_vehicle between", value1, value2, "perMaxVehicle");
	            return (Criteria) this;
	        }

	        public Criteria andperMaxVehicleNotBetween(Integer value1, Integer value2) {
	            addCriterion("per_max_vehicle not between", value1, value2, "perMaxVehicle");
	            return (Criteria) this;
	        }
	        public Criteria andfileNameIsNull() {
	            addCriterion("file_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameIsNotNull() {
	            addCriterion("file_name is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andfileNameLike(String value) {
	            addCriterion("file_name like", "%"+value+"%", "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameNotLike(String value) {
	            addCriterion("file_name not like", "%"+value+"%", "fileName");
	            return (Criteria) this;
	        }
	        
	        public Criteria andfileNameEqualTo(String value) {
	            addCriterion("file_name =", value, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameNotEqualTo(String value) {
	            addCriterion("file_name <>", value, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameGreaterThan(String value) {
	            addCriterion("file_name >", value, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameGreaterThanOrEqualTo(String value) {
	            addCriterion("file_name >=", value, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameLessThan(String value) {
	            addCriterion("file_name <", value, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameLessThanOrEqualTo(String value) {
	            addCriterion("file_name <=", value, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameIn(List<String> values) {
	            addCriterion("file_name in", values, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameNotIn(List<String> values) {
	            addCriterion("file_name not in", values, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameBetween(String value1, String value2) {
	            addCriterion("file_name between", value1, value2, "fileName");
	            return (Criteria) this;
	        }

	        public Criteria andfileNameNotBetween(String value1, String value2) {
	            addCriterion("file_name not between", value1, value2, "fileName");
	            return (Criteria) this;
	        }
	        public Criteria andturnOffFlagIsNull() {
	            addCriterion("turn_off_flag is null");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagIsNotNull() {
	            addCriterion("turn_off_flag is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andturnOffFlagEqualTo(Short value) {
	            addCriterion("turn_off_flag =", value, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagNotEqualTo(Short value) {
	            addCriterion("turn_off_flag <>", value, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagGreaterThan(Short value) {
	            addCriterion("turn_off_flag >", value, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagGreaterThanOrEqualTo(Short value) {
	            addCriterion("turn_off_flag >=", value, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagLessThan(Short value) {
	            addCriterion("turn_off_flag <", value, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagLessThanOrEqualTo(Short value) {
	            addCriterion("turn_off_flag <=", value, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagIn(List<Short> values) {
	            addCriterion("turn_off_flag in", values, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagNotIn(List<Short> values) {
	            addCriterion("turn_off_flag not in", values, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagBetween(Short value1, Short value2) {
	            addCriterion("turn_off_flag between", value1, value2, "turnOffFlag");
	            return (Criteria) this;
	        }

	        public Criteria andturnOffFlagNotBetween(Short value1, Short value2) {
	            addCriterion("turn_off_flag not between", value1, value2, "turnOffFlag");
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