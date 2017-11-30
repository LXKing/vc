package com.ccclubs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 车辆实时状态数据查询条件对象
 * @author Joel
 */
public class CsStateCrieria{
	 protected String orderByClause;
	 protected boolean distinct;
	 protected List<Criteria> oredCriteria;
	 
	 public CsStateCrieria() {
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
	        public Criteria andcssIdIsNull() {
	            addCriterion("css_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdIsNotNull() {
	            addCriterion("css_id is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssIdEqualTo(Integer value) {
	            addCriterion("css_id =", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotEqualTo(Integer value) {
	            addCriterion("css_id <>", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdGreaterThan(Integer value) {
	            addCriterion("css_id >", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_id >=", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdLessThan(Integer value) {
	            addCriterion("css_id <", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdLessThanOrEqualTo(Integer value) {
	            addCriterion("css_id <=", value, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdIn(List<Integer> values) {
	            addCriterion("css_id in", values, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotIn(List<Integer> values) {
	            addCriterion("css_id not in", values, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdBetween(Integer value1, Integer value2) {
	            addCriterion("css_id between", value1, value2, "cssId");
	            return (Criteria) this;
	        }

	        public Criteria andcssIdNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_id not between", value1, value2, "cssId");
	            return (Criteria) this;
	        }
	        public Criteria andcssAccessIsNull() {
	            addCriterion("css_access is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessIsNotNull() {
	            addCriterion("css_access is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssAccessEqualTo(Short value) {
	            addCriterion("css_access =", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessNotEqualTo(Short value) {
	            addCriterion("css_access <>", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessGreaterThan(Short value) {
	            addCriterion("css_access >", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_access >=", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessLessThan(Short value) {
	            addCriterion("css_access <", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessLessThanOrEqualTo(Short value) {
	            addCriterion("css_access <=", value, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessIn(List<Short> values) {
	            addCriterion("css_access in", values, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessNotIn(List<Short> values) {
	            addCriterion("css_access not in", values, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessBetween(Short value1, Short value2) {
	            addCriterion("css_access between", value1, value2, "cssAccess");
	            return (Criteria) this;
	        }

	        public Criteria andcssAccessNotBetween(Short value1, Short value2) {
	            addCriterion("css_access not between", value1, value2, "cssAccess");
	            return (Criteria) this;
	        }
	        public Criteria andcssHostIsNull() {
	            addCriterion("css_host is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostIsNotNull() {
	            addCriterion("css_host is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssHostEqualTo(Short value) {
	            addCriterion("css_host =", value, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostNotEqualTo(Short value) {
	            addCriterion("css_host <>", value, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostGreaterThan(Short value) {
	            addCriterion("css_host >", value, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_host >=", value, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostLessThan(Short value) {
	            addCriterion("css_host <", value, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostLessThanOrEqualTo(Short value) {
	            addCriterion("css_host <=", value, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostIn(List<Short> values) {
	            addCriterion("css_host in", values, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostNotIn(List<Short> values) {
	            addCriterion("css_host not in", values, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostBetween(Short value1, Short value2) {
	            addCriterion("css_host between", value1, value2, "cssHost");
	            return (Criteria) this;
	        }

	        public Criteria andcssHostNotBetween(Short value1, Short value2) {
	            addCriterion("css_host not between", value1, value2, "cssHost");
	            return (Criteria) this;
	        }
	        public Criteria andcssNumberIsNull() {
	            addCriterion("css_number is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberIsNotNull() {
	            addCriterion("css_number is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssNumberLike(String value) {
	            addCriterion("css_number like", "%"+value+"%", "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberNotLike(String value) {
	            addCriterion("css_number not like", "%"+value+"%", "cssNumber");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssNumberEqualTo(String value) {
	            addCriterion("css_number =", value, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberNotEqualTo(String value) {
	            addCriterion("css_number <>", value, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberGreaterThan(String value) {
	            addCriterion("css_number >", value, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberGreaterThanOrEqualTo(String value) {
	            addCriterion("css_number >=", value, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberLessThan(String value) {
	            addCriterion("css_number <", value, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberLessThanOrEqualTo(String value) {
	            addCriterion("css_number <=", value, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberIn(List<String> values) {
	            addCriterion("css_number in", values, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberNotIn(List<String> values) {
	            addCriterion("css_number not in", values, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberBetween(String value1, String value2) {
	            addCriterion("css_number between", value1, value2, "cssNumber");
	            return (Criteria) this;
	        }

	        public Criteria andcssNumberNotBetween(String value1, String value2) {
	            addCriterion("css_number not between", value1, value2, "cssNumber");
	            return (Criteria) this;
	        }
	        public Criteria andcssCarIsNull() {
	            addCriterion("css_car is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarIsNotNull() {
	            addCriterion("css_car is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssCarEqualTo(Integer value) {
	            addCriterion("css_car =", value, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarNotEqualTo(Integer value) {
	            addCriterion("css_car <>", value, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarGreaterThan(Integer value) {
	            addCriterion("css_car >", value, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_car >=", value, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarLessThan(Integer value) {
	            addCriterion("css_car <", value, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarLessThanOrEqualTo(Integer value) {
	            addCriterion("css_car <=", value, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarIn(List<Integer> values) {
	            addCriterion("css_car in", values, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarNotIn(List<Integer> values) {
	            addCriterion("css_car not in", values, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarBetween(Integer value1, Integer value2) {
	            addCriterion("css_car between", value1, value2, "cssCar");
	            return (Criteria) this;
	        }

	        public Criteria andcssCarNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_car not between", value1, value2, "cssCar");
	            return (Criteria) this;
	        }
	        public Criteria andcssAddTimeIsNull() {
	            addCriterion("css_add_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeIsNotNull() {
	            addCriterion("css_add_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssAddTimeEqualTo(Date value) {
	            addCriterion("css_add_time =", value, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeNotEqualTo(Date value) {
	            addCriterion("css_add_time <>", value, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeGreaterThan(Date value) {
	            addCriterion("css_add_time >", value, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("css_add_time >=", value, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeLessThan(Date value) {
	            addCriterion("css_add_time <", value, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeLessThanOrEqualTo(Date value) {
	            addCriterion("css_add_time <=", value, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeIn(List<Date> values) {
	            addCriterion("css_add_time in", values, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeNotIn(List<Date> values) {
	            addCriterion("css_add_time not in", values, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeBetween(Date value1, Date value2) {
	            addCriterion("css_add_time between", value1, value2, "cssAddTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssAddTimeNotBetween(Date value1, Date value2) {
	            addCriterion("css_add_time not between", value1, value2, "cssAddTime");
	            return (Criteria) this;
	        }
	        public Criteria andcssCurrentTimeIsNull() {
	            addCriterion("css_current_time is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeIsNotNull() {
	            addCriterion("css_current_time is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssCurrentTimeEqualTo(Date value) {
	            addCriterion("css_current_time =", value, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeNotEqualTo(Date value) {
	            addCriterion("css_current_time <>", value, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeGreaterThan(Date value) {
	            addCriterion("css_current_time >", value, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("css_current_time >=", value, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeLessThan(Date value) {
	            addCriterion("css_current_time <", value, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeLessThanOrEqualTo(Date value) {
	            addCriterion("css_current_time <=", value, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeIn(List<Date> values) {
	            addCriterion("css_current_time in", values, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeNotIn(List<Date> values) {
	            addCriterion("css_current_time not in", values, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeBetween(Date value1, Date value2) {
	            addCriterion("css_current_time between", value1, value2, "cssCurrentTime");
	            return (Criteria) this;
	        }

	        public Criteria andcssCurrentTimeNotBetween(Date value1, Date value2) {
	            addCriterion("css_current_time not between", value1, value2, "cssCurrentTime");
	            return (Criteria) this;
	        }
	        public Criteria andcssRentedIsNull() {
	            addCriterion("css_rented is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedIsNotNull() {
	            addCriterion("css_rented is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRentedLike(String value) {
	            addCriterion("css_rented like", "%"+value+"%", "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedNotLike(String value) {
	            addCriterion("css_rented not like", "%"+value+"%", "cssRented");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRentedEqualTo(String value) {
	            addCriterion("css_rented =", value, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedNotEqualTo(String value) {
	            addCriterion("css_rented <>", value, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedGreaterThan(String value) {
	            addCriterion("css_rented >", value, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedGreaterThanOrEqualTo(String value) {
	            addCriterion("css_rented >=", value, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedLessThan(String value) {
	            addCriterion("css_rented <", value, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedLessThanOrEqualTo(String value) {
	            addCriterion("css_rented <=", value, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedIn(List<String> values) {
	            addCriterion("css_rented in", values, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedNotIn(List<String> values) {
	            addCriterion("css_rented not in", values, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedBetween(String value1, String value2) {
	            addCriterion("css_rented between", value1, value2, "cssRented");
	            return (Criteria) this;
	        }

	        public Criteria andcssRentedNotBetween(String value1, String value2) {
	            addCriterion("css_rented not between", value1, value2, "cssRented");
	            return (Criteria) this;
	        }
	        public Criteria andcssWarnIsNull() {
	            addCriterion("css_warn is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnIsNotNull() {
	            addCriterion("css_warn is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssWarnEqualTo(Integer value) {
	            addCriterion("css_warn =", value, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnNotEqualTo(Integer value) {
	            addCriterion("css_warn <>", value, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnGreaterThan(Integer value) {
	            addCriterion("css_warn >", value, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_warn >=", value, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnLessThan(Integer value) {
	            addCriterion("css_warn <", value, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnLessThanOrEqualTo(Integer value) {
	            addCriterion("css_warn <=", value, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnIn(List<Integer> values) {
	            addCriterion("css_warn in", values, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnNotIn(List<Integer> values) {
	            addCriterion("css_warn not in", values, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnBetween(Integer value1, Integer value2) {
	            addCriterion("css_warn between", value1, value2, "cssWarn");
	            return (Criteria) this;
	        }

	        public Criteria andcssWarnNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_warn not between", value1, value2, "cssWarn");
	            return (Criteria) this;
	        }
	        public Criteria andcssRfidIsNull() {
	            addCriterion("css_rfid is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidIsNotNull() {
	            addCriterion("css_rfid is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRfidLike(String value) {
	            addCriterion("css_rfid like", "%"+value+"%", "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidNotLike(String value) {
	            addCriterion("css_rfid not like", "%"+value+"%", "cssRfid");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRfidEqualTo(String value) {
	            addCriterion("css_rfid =", value, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidNotEqualTo(String value) {
	            addCriterion("css_rfid <>", value, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidGreaterThan(String value) {
	            addCriterion("css_rfid >", value, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidGreaterThanOrEqualTo(String value) {
	            addCriterion("css_rfid >=", value, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidLessThan(String value) {
	            addCriterion("css_rfid <", value, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidLessThanOrEqualTo(String value) {
	            addCriterion("css_rfid <=", value, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidIn(List<String> values) {
	            addCriterion("css_rfid in", values, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidNotIn(List<String> values) {
	            addCriterion("css_rfid not in", values, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidBetween(String value1, String value2) {
	            addCriterion("css_rfid between", value1, value2, "cssRfid");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidNotBetween(String value1, String value2) {
	            addCriterion("css_rfid not between", value1, value2, "cssRfid");
	            return (Criteria) this;
	        }
	        public Criteria andcssRfidDteIsNull() {
	            addCriterion("css_rfid_dte is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteIsNotNull() {
	            addCriterion("css_rfid_dte is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRfidDteLike(String value) {
	            addCriterion("css_rfid_dte like", "%"+value+"%", "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteNotLike(String value) {
	            addCriterion("css_rfid_dte not like", "%"+value+"%", "cssRfidDte");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssRfidDteEqualTo(String value) {
	            addCriterion("css_rfid_dte =", value, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteNotEqualTo(String value) {
	            addCriterion("css_rfid_dte <>", value, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteGreaterThan(String value) {
	            addCriterion("css_rfid_dte >", value, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteGreaterThanOrEqualTo(String value) {
	            addCriterion("css_rfid_dte >=", value, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteLessThan(String value) {
	            addCriterion("css_rfid_dte <", value, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteLessThanOrEqualTo(String value) {
	            addCriterion("css_rfid_dte <=", value, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteIn(List<String> values) {
	            addCriterion("css_rfid_dte in", values, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteNotIn(List<String> values) {
	            addCriterion("css_rfid_dte not in", values, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteBetween(String value1, String value2) {
	            addCriterion("css_rfid_dte between", value1, value2, "cssRfidDte");
	            return (Criteria) this;
	        }

	        public Criteria andcssRfidDteNotBetween(String value1, String value2) {
	            addCriterion("css_rfid_dte not between", value1, value2, "cssRfidDte");
	            return (Criteria) this;
	        }
	        public Criteria andcssObdMileIsNull() {
	            addCriterion("css_obd_mile is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileIsNotNull() {
	            addCriterion("css_obd_mile is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssObdMileEqualTo(Integer value) {
	            addCriterion("css_obd_mile =", value, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileNotEqualTo(Integer value) {
	            addCriterion("css_obd_mile <>", value, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileGreaterThan(Integer value) {
	            addCriterion("css_obd_mile >", value, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_obd_mile >=", value, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileLessThan(Integer value) {
	            addCriterion("css_obd_mile <", value, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileLessThanOrEqualTo(Integer value) {
	            addCriterion("css_obd_mile <=", value, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileIn(List<Integer> values) {
	            addCriterion("css_obd_mile in", values, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileNotIn(List<Integer> values) {
	            addCriterion("css_obd_mile not in", values, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileBetween(Integer value1, Integer value2) {
	            addCriterion("css_obd_mile between", value1, value2, "cssObdMile");
	            return (Criteria) this;
	        }

	        public Criteria andcssObdMileNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_obd_mile not between", value1, value2, "cssObdMile");
	            return (Criteria) this;
	        }
	        public Criteria andcssEngineTIsNull() {
	            addCriterion("css_engine_t is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTIsNotNull() {
	            addCriterion("css_engine_t is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssEngineTEqualTo(Integer value) {
	            addCriterion("css_engine_t =", value, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTNotEqualTo(Integer value) {
	            addCriterion("css_engine_t <>", value, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTGreaterThan(Integer value) {
	            addCriterion("css_engine_t >", value, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_engine_t >=", value, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTLessThan(Integer value) {
	            addCriterion("css_engine_t <", value, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTLessThanOrEqualTo(Integer value) {
	            addCriterion("css_engine_t <=", value, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTIn(List<Integer> values) {
	            addCriterion("css_engine_t in", values, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTNotIn(List<Integer> values) {
	            addCriterion("css_engine_t not in", values, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTBetween(Integer value1, Integer value2) {
	            addCriterion("css_engine_t between", value1, value2, "cssEngineT");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineTNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_engine_t not between", value1, value2, "cssEngineT");
	            return (Criteria) this;
	        }
	        public Criteria andcssMileageIsNull() {
	            addCriterion("css_mileage is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageIsNotNull() {
	            addCriterion("css_mileage is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssMileageEqualTo(Integer value) {
	            addCriterion("css_mileage =", value, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageNotEqualTo(Integer value) {
	            addCriterion("css_mileage <>", value, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageGreaterThan(Integer value) {
	            addCriterion("css_mileage >", value, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_mileage >=", value, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageLessThan(Integer value) {
	            addCriterion("css_mileage <", value, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageLessThanOrEqualTo(Integer value) {
	            addCriterion("css_mileage <=", value, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageIn(List<Integer> values) {
	            addCriterion("css_mileage in", values, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageNotIn(List<Integer> values) {
	            addCriterion("css_mileage not in", values, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageBetween(Integer value1, Integer value2) {
	            addCriterion("css_mileage between", value1, value2, "cssMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssMileageNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_mileage not between", value1, value2, "cssMileage");
	            return (Criteria) this;
	        }
	        public Criteria andcssSpeedIsNull() {
	            addCriterion("css_speed is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedIsNotNull() {
	            addCriterion("css_speed is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssSpeedEqualTo(Short value) {
	            addCriterion("css_speed =", value, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedNotEqualTo(Short value) {
	            addCriterion("css_speed <>", value, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedGreaterThan(Short value) {
	            addCriterion("css_speed >", value, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_speed >=", value, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedLessThan(Short value) {
	            addCriterion("css_speed <", value, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedLessThanOrEqualTo(Short value) {
	            addCriterion("css_speed <=", value, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedIn(List<Short> values) {
	            addCriterion("css_speed in", values, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedNotIn(List<Short> values) {
	            addCriterion("css_speed not in", values, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedBetween(Short value1, Short value2) {
	            addCriterion("css_speed between", value1, value2, "cssSpeed");
	            return (Criteria) this;
	        }

	        public Criteria andcssSpeedNotBetween(Short value1, Short value2) {
	            addCriterion("css_speed not between", value1, value2, "cssSpeed");
	            return (Criteria) this;
	        }
	        public Criteria andcssMotorIsNull() {
	            addCriterion("css_motor is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorIsNotNull() {
	            addCriterion("css_motor is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssMotorEqualTo(Integer value) {
	            addCriterion("css_motor =", value, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorNotEqualTo(Integer value) {
	            addCriterion("css_motor <>", value, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorGreaterThan(Integer value) {
	            addCriterion("css_motor >", value, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_motor >=", value, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorLessThan(Integer value) {
	            addCriterion("css_motor <", value, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorLessThanOrEqualTo(Integer value) {
	            addCriterion("css_motor <=", value, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorIn(List<Integer> values) {
	            addCriterion("css_motor in", values, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorNotIn(List<Integer> values) {
	            addCriterion("css_motor not in", values, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorBetween(Integer value1, Integer value2) {
	            addCriterion("css_motor between", value1, value2, "cssMotor");
	            return (Criteria) this;
	        }

	        public Criteria andcssMotorNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_motor not between", value1, value2, "cssMotor");
	            return (Criteria) this;
	        }
	        public Criteria andcssOilIsNull() {
	            addCriterion("css_oil is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilIsNotNull() {
	            addCriterion("css_oil is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssOilLike(String value) {
	            addCriterion("css_oil like", "%"+value+"%", "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilNotLike(String value) {
	            addCriterion("css_oil not like", "%"+value+"%", "cssOil");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssOilEqualTo(String value) {
	            addCriterion("css_oil =", value, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilNotEqualTo(String value) {
	            addCriterion("css_oil <>", value, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilGreaterThan(String value) {
	            addCriterion("css_oil >", value, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilGreaterThanOrEqualTo(String value) {
	            addCriterion("css_oil >=", value, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilLessThan(String value) {
	            addCriterion("css_oil <", value, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilLessThanOrEqualTo(String value) {
	            addCriterion("css_oil <=", value, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilIn(List<String> values) {
	            addCriterion("css_oil in", values, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilNotIn(List<String> values) {
	            addCriterion("css_oil not in", values, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilBetween(String value1, String value2) {
	            addCriterion("css_oil between", value1, value2, "cssOil");
	            return (Criteria) this;
	        }

	        public Criteria andcssOilNotBetween(String value1, String value2) {
	            addCriterion("css_oil not between", value1, value2, "cssOil");
	            return (Criteria) this;
	        }
	        public Criteria andcssPowerIsNull() {
	            addCriterion("css_power is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerIsNotNull() {
	            addCriterion("css_power is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssPowerEqualTo(Integer value) {
	            addCriterion("css_power =", value, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerNotEqualTo(Integer value) {
	            addCriterion("css_power <>", value, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerGreaterThan(Integer value) {
	            addCriterion("css_power >", value, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_power >=", value, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerLessThan(Integer value) {
	            addCriterion("css_power <", value, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerLessThanOrEqualTo(Integer value) {
	            addCriterion("css_power <=", value, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerIn(List<Integer> values) {
	            addCriterion("css_power in", values, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerNotIn(List<Integer> values) {
	            addCriterion("css_power not in", values, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerBetween(Integer value1, Integer value2) {
	            addCriterion("css_power between", value1, value2, "cssPower");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_power not between", value1, value2, "cssPower");
	            return (Criteria) this;
	        }
	        public Criteria andcssEvBatteryIsNull() {
	            addCriterion("css_ev_battery is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryIsNotNull() {
	            addCriterion("css_ev_battery is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssEvBatteryEqualTo(Short value) {
	            addCriterion("css_ev_battery =", value, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryNotEqualTo(Short value) {
	            addCriterion("css_ev_battery <>", value, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryGreaterThan(Short value) {
	            addCriterion("css_ev_battery >", value, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_ev_battery >=", value, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryLessThan(Short value) {
	            addCriterion("css_ev_battery <", value, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryLessThanOrEqualTo(Short value) {
	            addCriterion("css_ev_battery <=", value, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryIn(List<Short> values) {
	            addCriterion("css_ev_battery in", values, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryNotIn(List<Short> values) {
	            addCriterion("css_ev_battery not in", values, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryBetween(Short value1, Short value2) {
	            addCriterion("css_ev_battery between", value1, value2, "cssEvBattery");
	            return (Criteria) this;
	        }

	        public Criteria andcssEvBatteryNotBetween(Short value1, Short value2) {
	            addCriterion("css_ev_battery not between", value1, value2, "cssEvBattery");
	            return (Criteria) this;
	        }
	        public Criteria andcssChargingIsNull() {
	            addCriterion("css_charging is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingIsNotNull() {
	            addCriterion("css_charging is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssChargingEqualTo(Short value) {
	            addCriterion("css_charging =", value, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNotEqualTo(Short value) {
	            addCriterion("css_charging <>", value, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingGreaterThan(Short value) {
	            addCriterion("css_charging >", value, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_charging >=", value, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingLessThan(Short value) {
	            addCriterion("css_charging <", value, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingLessThanOrEqualTo(Short value) {
	            addCriterion("css_charging <=", value, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingIn(List<Short> values) {
	            addCriterion("css_charging in", values, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNotIn(List<Short> values) {
	            addCriterion("css_charging not in", values, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingBetween(Short value1, Short value2) {
	            addCriterion("css_charging between", value1, value2, "cssCharging");
	            return (Criteria) this;
	        }

	        public Criteria andcssChargingNotBetween(Short value1, Short value2) {
	            addCriterion("css_charging not between", value1, value2, "cssCharging");
	            return (Criteria) this;
	        }
	        public Criteria andcssFuelMileageIsNull() {
	            addCriterion("css_fuel_mileage is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageIsNotNull() {
	            addCriterion("css_fuel_mileage is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssFuelMileageLike(String value) {
	            addCriterion("css_fuel_mileage like", "%"+value+"%", "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageNotLike(String value) {
	            addCriterion("css_fuel_mileage not like", "%"+value+"%", "cssFuelMileage");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssFuelMileageEqualTo(String value) {
	            addCriterion("css_fuel_mileage =", value, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageNotEqualTo(String value) {
	            addCriterion("css_fuel_mileage <>", value, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageGreaterThan(String value) {
	            addCriterion("css_fuel_mileage >", value, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageGreaterThanOrEqualTo(String value) {
	            addCriterion("css_fuel_mileage >=", value, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageLessThan(String value) {
	            addCriterion("css_fuel_mileage <", value, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageLessThanOrEqualTo(String value) {
	            addCriterion("css_fuel_mileage <=", value, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageIn(List<String> values) {
	            addCriterion("css_fuel_mileage in", values, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageNotIn(List<String> values) {
	            addCriterion("css_fuel_mileage not in", values, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageBetween(String value1, String value2) {
	            addCriterion("css_fuel_mileage between", value1, value2, "cssFuelMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssFuelMileageNotBetween(String value1, String value2) {
	            addCriterion("css_fuel_mileage not between", value1, value2, "cssFuelMileage");
	            return (Criteria) this;
	        }
	        public Criteria andcssElectricMileageIsNull() {
	            addCriterion("css_electric_mileage is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageIsNotNull() {
	            addCriterion("css_electric_mileage is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssElectricMileageLike(String value) {
	            addCriterion("css_electric_mileage like", "%"+value+"%", "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageNotLike(String value) {
	            addCriterion("css_electric_mileage not like", "%"+value+"%", "cssElectricMileage");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssElectricMileageEqualTo(String value) {
	            addCriterion("css_electric_mileage =", value, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageNotEqualTo(String value) {
	            addCriterion("css_electric_mileage <>", value, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageGreaterThan(String value) {
	            addCriterion("css_electric_mileage >", value, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageGreaterThanOrEqualTo(String value) {
	            addCriterion("css_electric_mileage >=", value, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageLessThan(String value) {
	            addCriterion("css_electric_mileage <", value, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageLessThanOrEqualTo(String value) {
	            addCriterion("css_electric_mileage <=", value, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageIn(List<String> values) {
	            addCriterion("css_electric_mileage in", values, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageNotIn(List<String> values) {
	            addCriterion("css_electric_mileage not in", values, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageBetween(String value1, String value2) {
	            addCriterion("css_electric_mileage between", value1, value2, "cssElectricMileage");
	            return (Criteria) this;
	        }

	        public Criteria andcssElectricMileageNotBetween(String value1, String value2) {
	            addCriterion("css_electric_mileage not between", value1, value2, "cssElectricMileage");
	            return (Criteria) this;
	        }
	        public Criteria andcssEnduranceIsNull() {
	            addCriterion("css_endurance is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceIsNotNull() {
	            addCriterion("css_endurance is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssEnduranceLike(String value) {
	            addCriterion("css_endurance like", "%"+value+"%", "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceNotLike(String value) {
	            addCriterion("css_endurance not like", "%"+value+"%", "cssEndurance");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssEnduranceEqualTo(String value) {
	            addCriterion("css_endurance =", value, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceNotEqualTo(String value) {
	            addCriterion("css_endurance <>", value, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceGreaterThan(String value) {
	            addCriterion("css_endurance >", value, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceGreaterThanOrEqualTo(String value) {
	            addCriterion("css_endurance >=", value, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceLessThan(String value) {
	            addCriterion("css_endurance <", value, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceLessThanOrEqualTo(String value) {
	            addCriterion("css_endurance <=", value, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceIn(List<String> values) {
	            addCriterion("css_endurance in", values, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceNotIn(List<String> values) {
	            addCriterion("css_endurance not in", values, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceBetween(String value1, String value2) {
	            addCriterion("css_endurance between", value1, value2, "cssEndurance");
	            return (Criteria) this;
	        }

	        public Criteria andcssEnduranceNotBetween(String value1, String value2) {
	            addCriterion("css_endurance not between", value1, value2, "cssEndurance");
	            return (Criteria) this;
	        }
	        public Criteria andcssTemperatureIsNull() {
	            addCriterion("css_temperature is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureIsNotNull() {
	            addCriterion("css_temperature is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssTemperatureEqualTo(Short value) {
	            addCriterion("css_temperature =", value, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureNotEqualTo(Short value) {
	            addCriterion("css_temperature <>", value, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureGreaterThan(Short value) {
	            addCriterion("css_temperature >", value, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_temperature >=", value, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureLessThan(Short value) {
	            addCriterion("css_temperature <", value, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureLessThanOrEqualTo(Short value) {
	            addCriterion("css_temperature <=", value, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureIn(List<Short> values) {
	            addCriterion("css_temperature in", values, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureNotIn(List<Short> values) {
	            addCriterion("css_temperature not in", values, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureBetween(Short value1, Short value2) {
	            addCriterion("css_temperature between", value1, value2, "cssTemperature");
	            return (Criteria) this;
	        }

	        public Criteria andcssTemperatureNotBetween(Short value1, Short value2) {
	            addCriterion("css_temperature not between", value1, value2, "cssTemperature");
	            return (Criteria) this;
	        }
	        public Criteria andcssCsqIsNull() {
	            addCriterion("css_csq is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqIsNotNull() {
	            addCriterion("css_csq is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssCsqEqualTo(Short value) {
	            addCriterion("css_csq =", value, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqNotEqualTo(Short value) {
	            addCriterion("css_csq <>", value, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqGreaterThan(Short value) {
	            addCriterion("css_csq >", value, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_csq >=", value, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqLessThan(Short value) {
	            addCriterion("css_csq <", value, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqLessThanOrEqualTo(Short value) {
	            addCriterion("css_csq <=", value, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqIn(List<Short> values) {
	            addCriterion("css_csq in", values, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqNotIn(List<Short> values) {
	            addCriterion("css_csq not in", values, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqBetween(Short value1, Short value2) {
	            addCriterion("css_csq between", value1, value2, "cssCsq");
	            return (Criteria) this;
	        }

	        public Criteria andcssCsqNotBetween(Short value1, Short value2) {
	            addCriterion("css_csq not between", value1, value2, "cssCsq");
	            return (Criteria) this;
	        }
	        public Criteria andcssPowerConsumptionIsNull() {
	            addCriterion("css_power_consumption is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionIsNotNull() {
	            addCriterion("css_power_consumption is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssPowerConsumptionLike(String value) {
	            addCriterion("css_power_consumption like", "%"+value+"%", "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionNotLike(String value) {
	            addCriterion("css_power_consumption not like", "%"+value+"%", "cssPowerConsumption");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssPowerConsumptionEqualTo(String value) {
	            addCriterion("css_power_consumption =", value, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionNotEqualTo(String value) {
	            addCriterion("css_power_consumption <>", value, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionGreaterThan(String value) {
	            addCriterion("css_power_consumption >", value, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionGreaterThanOrEqualTo(String value) {
	            addCriterion("css_power_consumption >=", value, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionLessThan(String value) {
	            addCriterion("css_power_consumption <", value, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionLessThanOrEqualTo(String value) {
	            addCriterion("css_power_consumption <=", value, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionIn(List<String> values) {
	            addCriterion("css_power_consumption in", values, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionNotIn(List<String> values) {
	            addCriterion("css_power_consumption not in", values, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionBetween(String value1, String value2) {
	            addCriterion("css_power_consumption between", value1, value2, "cssPowerConsumption");
	            return (Criteria) this;
	        }

	        public Criteria andcssPowerConsumptionNotBetween(String value1, String value2) {
	            addCriterion("css_power_consumption not between", value1, value2, "cssPowerConsumption");
	            return (Criteria) this;
	        }
	        public Criteria andcssLongitudeIsNull() {
	            addCriterion("css_longitude is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeIsNotNull() {
	            addCriterion("css_longitude is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssLongitudeEqualTo(Double value) {
	            addCriterion("css_longitude =", value, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeNotEqualTo(Double value) {
	            addCriterion("css_longitude <>", value, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeGreaterThan(Double value) {
	            addCriterion("css_longitude >", value, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeGreaterThanOrEqualTo(Double value) {
	            addCriterion("css_longitude >=", value, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeLessThan(Double value) {
	            addCriterion("css_longitude <", value, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeLessThanOrEqualTo(Double value) {
	            addCriterion("css_longitude <=", value, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeIn(List<Double> values) {
	            addCriterion("css_longitude in", values, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeNotIn(List<Double> values) {
	            addCriterion("css_longitude not in", values, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeBetween(Double value1, Double value2) {
	            addCriterion("css_longitude between", value1, value2, "cssLongitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLongitudeNotBetween(Double value1, Double value2) {
	            addCriterion("css_longitude not between", value1, value2, "cssLongitude");
	            return (Criteria) this;
	        }
	        public Criteria andcssLatitudeIsNull() {
	            addCriterion("css_latitude is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeIsNotNull() {
	            addCriterion("css_latitude is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssLatitudeEqualTo(Double value) {
	            addCriterion("css_latitude =", value, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeNotEqualTo(Double value) {
	            addCriterion("css_latitude <>", value, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeGreaterThan(Double value) {
	            addCriterion("css_latitude >", value, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeGreaterThanOrEqualTo(Double value) {
	            addCriterion("css_latitude >=", value, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeLessThan(Double value) {
	            addCriterion("css_latitude <", value, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeLessThanOrEqualTo(Double value) {
	            addCriterion("css_latitude <=", value, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeIn(List<Double> values) {
	            addCriterion("css_latitude in", values, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeNotIn(List<Double> values) {
	            addCriterion("css_latitude not in", values, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeBetween(Double value1, Double value2) {
	            addCriterion("css_latitude between", value1, value2, "cssLatitude");
	            return (Criteria) this;
	        }

	        public Criteria andcssLatitudeNotBetween(Double value1, Double value2) {
	            addCriterion("css_latitude not between", value1, value2, "cssLatitude");
	            return (Criteria) this;
	        }
	        public Criteria andcssGpsValidIsNull() {
	            addCriterion("css_gps_valid is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidIsNotNull() {
	            addCriterion("css_gps_valid is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssGpsValidEqualTo(Short value) {
	            addCriterion("css_gps_valid =", value, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidNotEqualTo(Short value) {
	            addCriterion("css_gps_valid <>", value, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidGreaterThan(Short value) {
	            addCriterion("css_gps_valid >", value, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_gps_valid >=", value, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidLessThan(Short value) {
	            addCriterion("css_gps_valid <", value, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidLessThanOrEqualTo(Short value) {
	            addCriterion("css_gps_valid <=", value, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidIn(List<Short> values) {
	            addCriterion("css_gps_valid in", values, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidNotIn(List<Short> values) {
	            addCriterion("css_gps_valid not in", values, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidBetween(Short value1, Short value2) {
	            addCriterion("css_gps_valid between", value1, value2, "cssGpsValid");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsValidNotBetween(Short value1, Short value2) {
	            addCriterion("css_gps_valid not between", value1, value2, "cssGpsValid");
	            return (Criteria) this;
	        }
	        public Criteria andcssGpsCnIsNull() {
	            addCriterion("css_gps_cn is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnIsNotNull() {
	            addCriterion("css_gps_cn is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssGpsCnEqualTo(Short value) {
	            addCriterion("css_gps_cn =", value, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnNotEqualTo(Short value) {
	            addCriterion("css_gps_cn <>", value, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnGreaterThan(Short value) {
	            addCriterion("css_gps_cn >", value, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_gps_cn >=", value, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnLessThan(Short value) {
	            addCriterion("css_gps_cn <", value, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnLessThanOrEqualTo(Short value) {
	            addCriterion("css_gps_cn <=", value, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnIn(List<Short> values) {
	            addCriterion("css_gps_cn in", values, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnNotIn(List<Short> values) {
	            addCriterion("css_gps_cn not in", values, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnBetween(Short value1, Short value2) {
	            addCriterion("css_gps_cn between", value1, value2, "cssGpsCn");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCnNotBetween(Short value1, Short value2) {
	            addCriterion("css_gps_cn not between", value1, value2, "cssGpsCn");
	            return (Criteria) this;
	        }
	        public Criteria andcssGpsCountIsNull() {
	            addCriterion("css_gps_count is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountIsNotNull() {
	            addCriterion("css_gps_count is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssGpsCountEqualTo(Short value) {
	            addCriterion("css_gps_count =", value, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountNotEqualTo(Short value) {
	            addCriterion("css_gps_count <>", value, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountGreaterThan(Short value) {
	            addCriterion("css_gps_count >", value, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_gps_count >=", value, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountLessThan(Short value) {
	            addCriterion("css_gps_count <", value, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountLessThanOrEqualTo(Short value) {
	            addCriterion("css_gps_count <=", value, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountIn(List<Short> values) {
	            addCriterion("css_gps_count in", values, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountNotIn(List<Short> values) {
	            addCriterion("css_gps_count not in", values, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountBetween(Short value1, Short value2) {
	            addCriterion("css_gps_count between", value1, value2, "cssGpsCount");
	            return (Criteria) this;
	        }

	        public Criteria andcssGpsCountNotBetween(Short value1, Short value2) {
	            addCriterion("css_gps_count not between", value1, value2, "cssGpsCount");
	            return (Criteria) this;
	        }
	        public Criteria andcssDirIsNull() {
	            addCriterion("css_dir is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirIsNotNull() {
	            addCriterion("css_dir is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssDirLike(String value) {
	            addCriterion("css_dir like", "%"+value+"%", "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirNotLike(String value) {
	            addCriterion("css_dir not like", "%"+value+"%", "cssDir");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssDirEqualTo(String value) {
	            addCriterion("css_dir =", value, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirNotEqualTo(String value) {
	            addCriterion("css_dir <>", value, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirGreaterThan(String value) {
	            addCriterion("css_dir >", value, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirGreaterThanOrEqualTo(String value) {
	            addCriterion("css_dir >=", value, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirLessThan(String value) {
	            addCriterion("css_dir <", value, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirLessThanOrEqualTo(String value) {
	            addCriterion("css_dir <=", value, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirIn(List<String> values) {
	            addCriterion("css_dir in", values, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirNotIn(List<String> values) {
	            addCriterion("css_dir not in", values, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirBetween(String value1, String value2) {
	            addCriterion("css_dir between", value1, value2, "cssDir");
	            return (Criteria) this;
	        }

	        public Criteria andcssDirNotBetween(String value1, String value2) {
	            addCriterion("css_dir not between", value1, value2, "cssDir");
	            return (Criteria) this;
	        }
	        public Criteria andcssCircularIsNull() {
	            addCriterion("css_circular is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularIsNotNull() {
	            addCriterion("css_circular is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssCircularEqualTo(Short value) {
	            addCriterion("css_circular =", value, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularNotEqualTo(Short value) {
	            addCriterion("css_circular <>", value, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularGreaterThan(Short value) {
	            addCriterion("css_circular >", value, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_circular >=", value, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularLessThan(Short value) {
	            addCriterion("css_circular <", value, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularLessThanOrEqualTo(Short value) {
	            addCriterion("css_circular <=", value, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularIn(List<Short> values) {
	            addCriterion("css_circular in", values, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularNotIn(List<Short> values) {
	            addCriterion("css_circular not in", values, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularBetween(Short value1, Short value2) {
	            addCriterion("css_circular between", value1, value2, "cssCircular");
	            return (Criteria) this;
	        }

	        public Criteria andcssCircularNotBetween(Short value1, Short value2) {
	            addCriterion("css_circular not between", value1, value2, "cssCircular");
	            return (Criteria) this;
	        }
	        public Criteria andcssPtcIsNull() {
	            addCriterion("css_ptc is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcIsNotNull() {
	            addCriterion("css_ptc is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssPtcEqualTo(Short value) {
	            addCriterion("css_ptc =", value, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcNotEqualTo(Short value) {
	            addCriterion("css_ptc <>", value, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcGreaterThan(Short value) {
	            addCriterion("css_ptc >", value, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_ptc >=", value, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcLessThan(Short value) {
	            addCriterion("css_ptc <", value, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcLessThanOrEqualTo(Short value) {
	            addCriterion("css_ptc <=", value, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcIn(List<Short> values) {
	            addCriterion("css_ptc in", values, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcNotIn(List<Short> values) {
	            addCriterion("css_ptc not in", values, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcBetween(Short value1, Short value2) {
	            addCriterion("css_ptc between", value1, value2, "cssPtc");
	            return (Criteria) this;
	        }

	        public Criteria andcssPtcNotBetween(Short value1, Short value2) {
	            addCriterion("css_ptc not between", value1, value2, "cssPtc");
	            return (Criteria) this;
	        }
	        public Criteria andcssCompresIsNull() {
	            addCriterion("css_compres is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresIsNotNull() {
	            addCriterion("css_compres is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssCompresEqualTo(Short value) {
	            addCriterion("css_compres =", value, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresNotEqualTo(Short value) {
	            addCriterion("css_compres <>", value, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresGreaterThan(Short value) {
	            addCriterion("css_compres >", value, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_compres >=", value, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresLessThan(Short value) {
	            addCriterion("css_compres <", value, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresLessThanOrEqualTo(Short value) {
	            addCriterion("css_compres <=", value, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresIn(List<Short> values) {
	            addCriterion("css_compres in", values, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresNotIn(List<Short> values) {
	            addCriterion("css_compres not in", values, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresBetween(Short value1, Short value2) {
	            addCriterion("css_compres between", value1, value2, "cssCompres");
	            return (Criteria) this;
	        }

	        public Criteria andcssCompresNotBetween(Short value1, Short value2) {
	            addCriterion("css_compres not between", value1, value2, "cssCompres");
	            return (Criteria) this;
	        }
	        public Criteria andcssFanIsNull() {
	            addCriterion("css_fan is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanIsNotNull() {
	            addCriterion("css_fan is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssFanEqualTo(Short value) {
	            addCriterion("css_fan =", value, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanNotEqualTo(Short value) {
	            addCriterion("css_fan <>", value, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanGreaterThan(Short value) {
	            addCriterion("css_fan >", value, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_fan >=", value, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanLessThan(Short value) {
	            addCriterion("css_fan <", value, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanLessThanOrEqualTo(Short value) {
	            addCriterion("css_fan <=", value, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanIn(List<Short> values) {
	            addCriterion("css_fan in", values, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanNotIn(List<Short> values) {
	            addCriterion("css_fan not in", values, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanBetween(Short value1, Short value2) {
	            addCriterion("css_fan between", value1, value2, "cssFan");
	            return (Criteria) this;
	        }

	        public Criteria andcssFanNotBetween(Short value1, Short value2) {
	            addCriterion("css_fan not between", value1, value2, "cssFan");
	            return (Criteria) this;
	        }
	        public Criteria andcssSavingIsNull() {
	            addCriterion("css_saving is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingIsNotNull() {
	            addCriterion("css_saving is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssSavingEqualTo(Short value) {
	            addCriterion("css_saving =", value, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingNotEqualTo(Short value) {
	            addCriterion("css_saving <>", value, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingGreaterThan(Short value) {
	            addCriterion("css_saving >", value, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_saving >=", value, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingLessThan(Short value) {
	            addCriterion("css_saving <", value, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingLessThanOrEqualTo(Short value) {
	            addCriterion("css_saving <=", value, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingIn(List<Short> values) {
	            addCriterion("css_saving in", values, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingNotIn(List<Short> values) {
	            addCriterion("css_saving not in", values, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingBetween(Short value1, Short value2) {
	            addCriterion("css_saving between", value1, value2, "cssSaving");
	            return (Criteria) this;
	        }

	        public Criteria andcssSavingNotBetween(Short value1, Short value2) {
	            addCriterion("css_saving not between", value1, value2, "cssSaving");
	            return (Criteria) this;
	        }
	        public Criteria andcssDoorIsNull() {
	            addCriterion("css_door is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorIsNotNull() {
	            addCriterion("css_door is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssDoorLike(String value) {
	            addCriterion("css_door like", "%"+value+"%", "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorNotLike(String value) {
	            addCriterion("css_door not like", "%"+value+"%", "cssDoor");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssDoorEqualTo(String value) {
	            addCriterion("css_door =", value, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorNotEqualTo(String value) {
	            addCriterion("css_door <>", value, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorGreaterThan(String value) {
	            addCriterion("css_door >", value, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorGreaterThanOrEqualTo(String value) {
	            addCriterion("css_door >=", value, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorLessThan(String value) {
	            addCriterion("css_door <", value, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorLessThanOrEqualTo(String value) {
	            addCriterion("css_door <=", value, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorIn(List<String> values) {
	            addCriterion("css_door in", values, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorNotIn(List<String> values) {
	            addCriterion("css_door not in", values, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorBetween(String value1, String value2) {
	            addCriterion("css_door between", value1, value2, "cssDoor");
	            return (Criteria) this;
	        }

	        public Criteria andcssDoorNotBetween(String value1, String value2) {
	            addCriterion("css_door not between", value1, value2, "cssDoor");
	            return (Criteria) this;
	        }
	        public Criteria andcssEngineIsNull() {
	            addCriterion("css_engine is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineIsNotNull() {
	            addCriterion("css_engine is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssEngineEqualTo(Short value) {
	            addCriterion("css_engine =", value, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineNotEqualTo(Short value) {
	            addCriterion("css_engine <>", value, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineGreaterThan(Short value) {
	            addCriterion("css_engine >", value, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_engine >=", value, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineLessThan(Short value) {
	            addCriterion("css_engine <", value, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineLessThanOrEqualTo(Short value) {
	            addCriterion("css_engine <=", value, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineIn(List<Short> values) {
	            addCriterion("css_engine in", values, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineNotIn(List<Short> values) {
	            addCriterion("css_engine not in", values, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineBetween(Short value1, Short value2) {
	            addCriterion("css_engine between", value1, value2, "cssEngine");
	            return (Criteria) this;
	        }

	        public Criteria andcssEngineNotBetween(Short value1, Short value2) {
	            addCriterion("css_engine not between", value1, value2, "cssEngine");
	            return (Criteria) this;
	        }
	        public Criteria andcssKeyIsNull() {
	            addCriterion("css_key is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyIsNotNull() {
	            addCriterion("css_key is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssKeyEqualTo(Short value) {
	            addCriterion("css_key =", value, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyNotEqualTo(Short value) {
	            addCriterion("css_key <>", value, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyGreaterThan(Short value) {
	            addCriterion("css_key >", value, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_key >=", value, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyLessThan(Short value) {
	            addCriterion("css_key <", value, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyLessThanOrEqualTo(Short value) {
	            addCriterion("css_key <=", value, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyIn(List<Short> values) {
	            addCriterion("css_key in", values, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyNotIn(List<Short> values) {
	            addCriterion("css_key not in", values, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyBetween(Short value1, Short value2) {
	            addCriterion("css_key between", value1, value2, "cssKey");
	            return (Criteria) this;
	        }

	        public Criteria andcssKeyNotBetween(Short value1, Short value2) {
	            addCriterion("css_key not between", value1, value2, "cssKey");
	            return (Criteria) this;
	        }
	        public Criteria andcssGearIsNull() {
	            addCriterion("css_gear is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearIsNotNull() {
	            addCriterion("css_gear is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssGearEqualTo(Short value) {
	            addCriterion("css_gear =", value, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearNotEqualTo(Short value) {
	            addCriterion("css_gear <>", value, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearGreaterThan(Short value) {
	            addCriterion("css_gear >", value, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_gear >=", value, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearLessThan(Short value) {
	            addCriterion("css_gear <", value, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearLessThanOrEqualTo(Short value) {
	            addCriterion("css_gear <=", value, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearIn(List<Short> values) {
	            addCriterion("css_gear in", values, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearNotIn(List<Short> values) {
	            addCriterion("css_gear not in", values, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearBetween(Short value1, Short value2) {
	            addCriterion("css_gear between", value1, value2, "cssGear");
	            return (Criteria) this;
	        }

	        public Criteria andcssGearNotBetween(Short value1, Short value2) {
	            addCriterion("css_gear not between", value1, value2, "cssGear");
	            return (Criteria) this;
	        }
	        public Criteria andcssLightIsNull() {
	            addCriterion("css_light is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightIsNotNull() {
	            addCriterion("css_light is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssLightEqualTo(Integer value) {
	            addCriterion("css_light =", value, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightNotEqualTo(Integer value) {
	            addCriterion("css_light <>", value, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightGreaterThan(Integer value) {
	            addCriterion("css_light >", value, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_light >=", value, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightLessThan(Integer value) {
	            addCriterion("css_light <", value, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightLessThanOrEqualTo(Integer value) {
	            addCriterion("css_light <=", value, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightIn(List<Integer> values) {
	            addCriterion("css_light in", values, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightNotIn(List<Integer> values) {
	            addCriterion("css_light not in", values, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightBetween(Integer value1, Integer value2) {
	            addCriterion("css_light between", value1, value2, "cssLight");
	            return (Criteria) this;
	        }

	        public Criteria andcssLightNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_light not between", value1, value2, "cssLight");
	            return (Criteria) this;
	        }
	        public Criteria andcssLockIsNull() {
	            addCriterion("css_lock is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockIsNotNull() {
	            addCriterion("css_lock is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssLockEqualTo(Integer value) {
	            addCriterion("css_lock =", value, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockNotEqualTo(Integer value) {
	            addCriterion("css_lock <>", value, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockGreaterThan(Integer value) {
	            addCriterion("css_lock >", value, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_lock >=", value, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockLessThan(Integer value) {
	            addCriterion("css_lock <", value, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockLessThanOrEqualTo(Integer value) {
	            addCriterion("css_lock <=", value, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockIn(List<Integer> values) {
	            addCriterion("css_lock in", values, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockNotIn(List<Integer> values) {
	            addCriterion("css_lock not in", values, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockBetween(Integer value1, Integer value2) {
	            addCriterion("css_lock between", value1, value2, "cssLock");
	            return (Criteria) this;
	        }

	        public Criteria andcssLockNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_lock not between", value1, value2, "cssLock");
	            return (Criteria) this;
	        }
	        public Criteria andcssNetTypeIsNull() {
	            addCriterion("css_net_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeIsNotNull() {
	            addCriterion("css_net_type is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssNetTypeEqualTo(Short value) {
	            addCriterion("css_net_type =", value, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeNotEqualTo(Short value) {
	            addCriterion("css_net_type <>", value, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeGreaterThan(Short value) {
	            addCriterion("css_net_type >", value, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeGreaterThanOrEqualTo(Short value) {
	            addCriterion("css_net_type >=", value, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeLessThan(Short value) {
	            addCriterion("css_net_type <", value, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeLessThanOrEqualTo(Short value) {
	            addCriterion("css_net_type <=", value, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeIn(List<Short> values) {
	            addCriterion("css_net_type in", values, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeNotIn(List<Short> values) {
	            addCriterion("css_net_type not in", values, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeBetween(Short value1, Short value2) {
	            addCriterion("css_net_type between", value1, value2, "cssNetType");
	            return (Criteria) this;
	        }

	        public Criteria andcssNetTypeNotBetween(Short value1, Short value2) {
	            addCriterion("css_net_type not between", value1, value2, "cssNetType");
	            return (Criteria) this;
	        }
	        public Criteria andcssBaseLacIsNull() {
	            addCriterion("css_base_lac is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacIsNotNull() {
	            addCriterion("css_base_lac is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssBaseLacEqualTo(Integer value) {
	            addCriterion("css_base_lac =", value, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacNotEqualTo(Integer value) {
	            addCriterion("css_base_lac <>", value, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacGreaterThan(Integer value) {
	            addCriterion("css_base_lac >", value, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_base_lac >=", value, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacLessThan(Integer value) {
	            addCriterion("css_base_lac <", value, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacLessThanOrEqualTo(Integer value) {
	            addCriterion("css_base_lac <=", value, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacIn(List<Integer> values) {
	            addCriterion("css_base_lac in", values, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacNotIn(List<Integer> values) {
	            addCriterion("css_base_lac not in", values, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacBetween(Integer value1, Integer value2) {
	            addCriterion("css_base_lac between", value1, value2, "cssBaseLac");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseLacNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_base_lac not between", value1, value2, "cssBaseLac");
	            return (Criteria) this;
	        }
	        public Criteria andcssBaseCiIsNull() {
	            addCriterion("css_base_ci is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiIsNotNull() {
	            addCriterion("css_base_ci is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssBaseCiEqualTo(Integer value) {
	            addCriterion("css_base_ci =", value, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiNotEqualTo(Integer value) {
	            addCriterion("css_base_ci <>", value, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiGreaterThan(Integer value) {
	            addCriterion("css_base_ci >", value, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_base_ci >=", value, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiLessThan(Integer value) {
	            addCriterion("css_base_ci <", value, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiLessThanOrEqualTo(Integer value) {
	            addCriterion("css_base_ci <=", value, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiIn(List<Integer> values) {
	            addCriterion("css_base_ci in", values, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiNotIn(List<Integer> values) {
	            addCriterion("css_base_ci not in", values, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiBetween(Integer value1, Integer value2) {
	            addCriterion("css_base_ci between", value1, value2, "cssBaseCi");
	            return (Criteria) this;
	        }

	        public Criteria andcssBaseCiNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_base_ci not between", value1, value2, "cssBaseCi");
	            return (Criteria) this;
	        }
	        public Criteria andcssOrderIsNull() {
	            addCriterion("css_order is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderIsNotNull() {
	            addCriterion("css_order is not null");
	            return (Criteria) this;
	        }
	        
	        
	        public Criteria andcssOrderEqualTo(Integer value) {
	            addCriterion("css_order =", value, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderNotEqualTo(Integer value) {
	            addCriterion("css_order <>", value, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderGreaterThan(Integer value) {
	            addCriterion("css_order >", value, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderGreaterThanOrEqualTo(Integer value) {
	            addCriterion("css_order >=", value, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderLessThan(Integer value) {
	            addCriterion("css_order <", value, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderLessThanOrEqualTo(Integer value) {
	            addCriterion("css_order <=", value, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderIn(List<Integer> values) {
	            addCriterion("css_order in", values, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderNotIn(List<Integer> values) {
	            addCriterion("css_order not in", values, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderBetween(Integer value1, Integer value2) {
	            addCriterion("css_order between", value1, value2, "cssOrder");
	            return (Criteria) this;
	        }

	        public Criteria andcssOrderNotBetween(Integer value1, Integer value2) {
	            addCriterion("css_order not between", value1, value2, "cssOrder");
	            return (Criteria) this;
	        }
	        public Criteria andcssMoDataIsNull() {
	            addCriterion("css_mo_data is null");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataIsNotNull() {
	            addCriterion("css_mo_data is not null");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssMoDataLike(String value) {
	            addCriterion("css_mo_data like", "%"+value+"%", "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataNotLike(String value) {
	            addCriterion("css_mo_data not like", "%"+value+"%", "cssMoData");
	            return (Criteria) this;
	        }
	        
	        public Criteria andcssMoDataEqualTo(String value) {
	            addCriterion("css_mo_data =", value, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataNotEqualTo(String value) {
	            addCriterion("css_mo_data <>", value, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataGreaterThan(String value) {
	            addCriterion("css_mo_data >", value, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataGreaterThanOrEqualTo(String value) {
	            addCriterion("css_mo_data >=", value, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataLessThan(String value) {
	            addCriterion("css_mo_data <", value, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataLessThanOrEqualTo(String value) {
	            addCriterion("css_mo_data <=", value, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataIn(List<String> values) {
	            addCriterion("css_mo_data in", values, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataNotIn(List<String> values) {
	            addCriterion("css_mo_data not in", values, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataBetween(String value1, String value2) {
	            addCriterion("css_mo_data between", value1, value2, "cssMoData");
	            return (Criteria) this;
	        }

	        public Criteria andcssMoDataNotBetween(String value1, String value2) {
	            addCriterion("css_mo_data not between", value1, value2, "cssMoData");
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