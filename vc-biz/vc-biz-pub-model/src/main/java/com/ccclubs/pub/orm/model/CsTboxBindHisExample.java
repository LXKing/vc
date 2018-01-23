package com.ccclubs.pub.orm.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 数据查询条件对象
 * @author Joel
 */
public class CsTboxBindHisExample{
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public CsTboxBindHisExample() {
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
		public Criteria andcstbIdIsNull() {
			addCriterion("cstb_id is null");
			return (Criteria) this;
		}

		public Criteria andcstbIdIsNotNull() {
			addCriterion("cstb_id is not null");
			return (Criteria) this;
		}


		public Criteria andcstbIdEqualTo(Long value) {
			addCriterion("cstb_id =", value, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdNotEqualTo(Long value) {
			addCriterion("cstb_id <>", value, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdGreaterThan(Long value) {
			addCriterion("cstb_id >", value, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cstb_id >=", value, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdLessThan(Long value) {
			addCriterion("cstb_id <", value, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdLessThanOrEqualTo(Long value) {
			addCriterion("cstb_id <=", value, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdIn(List<Long> values) {
			addCriterion("cstb_id in", values, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdNotIn(List<Long> values) {
			addCriterion("cstb_id not in", values, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdBetween(Long value1, Long value2) {
			addCriterion("cstb_id between", value1, value2, "cstbId");
			return (Criteria) this;
		}

		public Criteria andcstbIdNotBetween(Long value1, Long value2) {
			addCriterion("cstb_id not between", value1, value2, "cstbId");
			return (Criteria) this;
		}
		public Criteria andcstbVehicleIdIsNull() {
			addCriterion("cstb_vehicle_id is null");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdIsNotNull() {
			addCriterion("cstb_vehicle_id is not null");
			return (Criteria) this;
		}


		public Criteria andcstbVehicleIdEqualTo(Long value) {
			addCriterion("cstb_vehicle_id =", value, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdNotEqualTo(Long value) {
			addCriterion("cstb_vehicle_id <>", value, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdGreaterThan(Long value) {
			addCriterion("cstb_vehicle_id >", value, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cstb_vehicle_id >=", value, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdLessThan(Long value) {
			addCriterion("cstb_vehicle_id <", value, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdLessThanOrEqualTo(Long value) {
			addCriterion("cstb_vehicle_id <=", value, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdIn(List<Long> values) {
			addCriterion("cstb_vehicle_id in", values, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdNotIn(List<Long> values) {
			addCriterion("cstb_vehicle_id not in", values, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdBetween(Long value1, Long value2) {
			addCriterion("cstb_vehicle_id between", value1, value2, "cstbVehicleId");
			return (Criteria) this;
		}

		public Criteria andcstbVehicleIdNotBetween(Long value1, Long value2) {
			addCriterion("cstb_vehicle_id not between", value1, value2, "cstbVehicleId");
			return (Criteria) this;
		}
		public Criteria andcstbMachineIdIsNull() {
			addCriterion("cstb_machine_id is null");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdIsNotNull() {
			addCriterion("cstb_machine_id is not null");
			return (Criteria) this;
		}


		public Criteria andcstbMachineIdEqualTo(Long value) {
			addCriterion("cstb_machine_id =", value, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdNotEqualTo(Long value) {
			addCriterion("cstb_machine_id <>", value, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdGreaterThan(Long value) {
			addCriterion("cstb_machine_id >", value, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cstb_machine_id >=", value, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdLessThan(Long value) {
			addCriterion("cstb_machine_id <", value, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdLessThanOrEqualTo(Long value) {
			addCriterion("cstb_machine_id <=", value, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdIn(List<Long> values) {
			addCriterion("cstb_machine_id in", values, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdNotIn(List<Long> values) {
			addCriterion("cstb_machine_id not in", values, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdBetween(Long value1, Long value2) {
			addCriterion("cstb_machine_id between", value1, value2, "cstbMachineId");
			return (Criteria) this;
		}

		public Criteria andcstbMachineIdNotBetween(Long value1, Long value2) {
			addCriterion("cstb_machine_id not between", value1, value2, "cstbMachineId");
			return (Criteria) this;
		}
		public Criteria andcstbVinIsNull() {
			addCriterion("cstb_vin is null");
			return (Criteria) this;
		}

		public Criteria andcstbVinIsNotNull() {
			addCriterion("cstb_vin is not null");
			return (Criteria) this;
		}

		public Criteria andcstbVinLike(String value) {
			addCriterion("cstb_vin like", "%"+value+"%", "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinNotLike(String value) {
			addCriterion("cstb_vin not like", "%"+value+"%", "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinEqualTo(String value) {
			addCriterion("cstb_vin =", value, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinNotEqualTo(String value) {
			addCriterion("cstb_vin <>", value, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinGreaterThan(String value) {
			addCriterion("cstb_vin >", value, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinGreaterThanOrEqualTo(String value) {
			addCriterion("cstb_vin >=", value, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinLessThan(String value) {
			addCriterion("cstb_vin <", value, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinLessThanOrEqualTo(String value) {
			addCriterion("cstb_vin <=", value, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinIn(List<String> values) {
			addCriterion("cstb_vin in", values, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinNotIn(List<String> values) {
			addCriterion("cstb_vin not in", values, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinBetween(String value1, String value2) {
			addCriterion("cstb_vin between", value1, value2, "cstbVin");
			return (Criteria) this;
		}

		public Criteria andcstbVinNotBetween(String value1, String value2) {
			addCriterion("cstb_vin not between", value1, value2, "cstbVin");
			return (Criteria) this;
		}
		public Criteria andcstbNumberIsNull() {
			addCriterion("cstb_number is null");
			return (Criteria) this;
		}

		public Criteria andcstbNumberIsNotNull() {
			addCriterion("cstb_number is not null");
			return (Criteria) this;
		}

		public Criteria andcstbNumberLike(String value) {
			addCriterion("cstb_number like", "%"+value+"%", "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberNotLike(String value) {
			addCriterion("cstb_number not like", "%"+value+"%", "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberEqualTo(String value) {
			addCriterion("cstb_number =", value, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberNotEqualTo(String value) {
			addCriterion("cstb_number <>", value, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberGreaterThan(String value) {
			addCriterion("cstb_number >", value, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberGreaterThanOrEqualTo(String value) {
			addCriterion("cstb_number >=", value, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberLessThan(String value) {
			addCriterion("cstb_number <", value, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberLessThanOrEqualTo(String value) {
			addCriterion("cstb_number <=", value, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberIn(List<String> values) {
			addCriterion("cstb_number in", values, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberNotIn(List<String> values) {
			addCriterion("cstb_number not in", values, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberBetween(String value1, String value2) {
			addCriterion("cstb_number between", value1, value2, "cstbNumber");
			return (Criteria) this;
		}

		public Criteria andcstbNumberNotBetween(String value1, String value2) {
			addCriterion("cstb_number not between", value1, value2, "cstbNumber");
			return (Criteria) this;
		}
		public Criteria andcstbTeNoIsNull() {
			addCriterion("cstb_te_no is null");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoIsNotNull() {
			addCriterion("cstb_te_no is not null");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoLike(String value) {
			addCriterion("cstb_te_no like", "%"+value+"%", "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoNotLike(String value) {
			addCriterion("cstb_te_no not like", "%"+value+"%", "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoEqualTo(String value) {
			addCriterion("cstb_te_no =", value, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoNotEqualTo(String value) {
			addCriterion("cstb_te_no <>", value, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoGreaterThan(String value) {
			addCriterion("cstb_te_no >", value, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoGreaterThanOrEqualTo(String value) {
			addCriterion("cstb_te_no >=", value, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoLessThan(String value) {
			addCriterion("cstb_te_no <", value, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoLessThanOrEqualTo(String value) {
			addCriterion("cstb_te_no <=", value, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoIn(List<String> values) {
			addCriterion("cstb_te_no in", values, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoNotIn(List<String> values) {
			addCriterion("cstb_te_no not in", values, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoBetween(String value1, String value2) {
			addCriterion("cstb_te_no between", value1, value2, "cstbTeNo");
			return (Criteria) this;
		}

		public Criteria andcstbTeNoNotBetween(String value1, String value2) {
			addCriterion("cstb_te_no not between", value1, value2, "cstbTeNo");
			return (Criteria) this;
		}
		public Criteria andcstbStartTimeIsNull() {
			addCriterion("cstb_start_time is null");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeIsNotNull() {
			addCriterion("cstb_start_time is not null");
			return (Criteria) this;
		}


		public Criteria andcstbStartTimeEqualTo(Date value) {
			addCriterion("cstb_start_time =", value, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeNotEqualTo(Date value) {
			addCriterion("cstb_start_time <>", value, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeGreaterThan(Date value) {
			addCriterion("cstb_start_time >", value, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("cstb_start_time >=", value, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeLessThan(Date value) {
			addCriterion("cstb_start_time <", value, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("cstb_start_time <=", value, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeIn(List<Date> values) {
			addCriterion("cstb_start_time in", values, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeNotIn(List<Date> values) {
			addCriterion("cstb_start_time not in", values, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeBetween(Date value1, Date value2) {
			addCriterion("cstb_start_time between", value1, value2, "cstbStartTime");
			return (Criteria) this;
		}

		public Criteria andcstbStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("cstb_start_time not between", value1, value2, "cstbStartTime");
			return (Criteria) this;
		}
		public Criteria andcstbEndTimeIsNull() {
			addCriterion("cstb_end_time is null");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeIsNotNull() {
			addCriterion("cstb_end_time is not null");
			return (Criteria) this;
		}


		public Criteria andcstbEndTimeEqualTo(Date value) {
			addCriterion("cstb_end_time =", value, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeNotEqualTo(Date value) {
			addCriterion("cstb_end_time <>", value, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeGreaterThan(Date value) {
			addCriterion("cstb_end_time >", value, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("cstb_end_time >=", value, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeLessThan(Date value) {
			addCriterion("cstb_end_time <", value, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("cstb_end_time <=", value, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeIn(List<Date> values) {
			addCriterion("cstb_end_time in", values, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeNotIn(List<Date> values) {
			addCriterion("cstb_end_time not in", values, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeBetween(Date value1, Date value2) {
			addCriterion("cstb_end_time between", value1, value2, "cstbEndTime");
			return (Criteria) this;
		}

		public Criteria andcstbEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("cstb_end_time not between", value1, value2, "cstbEndTime");
			return (Criteria) this;
		}
		public Criteria andcstbStatusIsNull() {
			addCriterion("cstb_status is null");
			return (Criteria) this;
		}

		public Criteria andcstbStatusIsNotNull() {
			addCriterion("cstb_status is not null");
			return (Criteria) this;
		}


		public Criteria andcstbStatusEqualTo(Short value) {
			addCriterion("cstb_status =", value, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusNotEqualTo(Short value) {
			addCriterion("cstb_status <>", value, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusGreaterThan(Short value) {
			addCriterion("cstb_status >", value, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusGreaterThanOrEqualTo(Short value) {
			addCriterion("cstb_status >=", value, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusLessThan(Short value) {
			addCriterion("cstb_status <", value, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusLessThanOrEqualTo(Short value) {
			addCriterion("cstb_status <=", value, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusIn(List<Short> values) {
			addCriterion("cstb_status in", values, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusNotIn(List<Short> values) {
			addCriterion("cstb_status not in", values, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusBetween(Short value1, Short value2) {
			addCriterion("cstb_status between", value1, value2, "cstbStatus");
			return (Criteria) this;
		}

		public Criteria andcstbStatusNotBetween(Short value1, Short value2) {
			addCriterion("cstb_status not between", value1, value2, "cstbStatus");
			return (Criteria) this;
		}
		public Criteria andcstbAddTimeIsNull() {
			addCriterion("cstb_add_time is null");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeIsNotNull() {
			addCriterion("cstb_add_time is not null");
			return (Criteria) this;
		}


		public Criteria andcstbAddTimeEqualTo(Date value) {
			addCriterion("cstb_add_time =", value, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeNotEqualTo(Date value) {
			addCriterion("cstb_add_time <>", value, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeGreaterThan(Date value) {
			addCriterion("cstb_add_time >", value, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("cstb_add_time >=", value, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeLessThan(Date value) {
			addCriterion("cstb_add_time <", value, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("cstb_add_time <=", value, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeIn(List<Date> values) {
			addCriterion("cstb_add_time in", values, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeNotIn(List<Date> values) {
			addCriterion("cstb_add_time not in", values, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeBetween(Date value1, Date value2) {
			addCriterion("cstb_add_time between", value1, value2, "cstbAddTime");
			return (Criteria) this;
		}

		public Criteria andcstbAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("cstb_add_time not between", value1, value2, "cstbAddTime");
			return (Criteria) this;
		}
		public Criteria andcstbModTimeIsNull() {
			addCriterion("cstb_mod_time is null");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeIsNotNull() {
			addCriterion("cstb_mod_time is not null");
			return (Criteria) this;
		}


		public Criteria andcstbModTimeEqualTo(Date value) {
			addCriterion("cstb_mod_time =", value, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeNotEqualTo(Date value) {
			addCriterion("cstb_mod_time <>", value, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeGreaterThan(Date value) {
			addCriterion("cstb_mod_time >", value, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("cstb_mod_time >=", value, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeLessThan(Date value) {
			addCriterion("cstb_mod_time <", value, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeLessThanOrEqualTo(Date value) {
			addCriterion("cstb_mod_time <=", value, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeIn(List<Date> values) {
			addCriterion("cstb_mod_time in", values, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeNotIn(List<Date> values) {
			addCriterion("cstb_mod_time not in", values, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeBetween(Date value1, Date value2) {
			addCriterion("cstb_mod_time between", value1, value2, "cstbModTime");
			return (Criteria) this;
		}

		public Criteria andcstbModTimeNotBetween(Date value1, Date value2) {
			addCriterion("cstb_mod_time not between", value1, value2, "cstbModTime");
			return (Criteria) this;
		}
		public Criteria andcstbBindOperIdIsNull() {
			addCriterion("cstb_bind_oper_id is null");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdIsNotNull() {
			addCriterion("cstb_bind_oper_id is not null");
			return (Criteria) this;
		}


		public Criteria andcstbBindOperIdEqualTo(Long value) {
			addCriterion("cstb_bind_oper_id =", value, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdNotEqualTo(Long value) {
			addCriterion("cstb_bind_oper_id <>", value, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdGreaterThan(Long value) {
			addCriterion("cstb_bind_oper_id >", value, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cstb_bind_oper_id >=", value, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdLessThan(Long value) {
			addCriterion("cstb_bind_oper_id <", value, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdLessThanOrEqualTo(Long value) {
			addCriterion("cstb_bind_oper_id <=", value, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdIn(List<Long> values) {
			addCriterion("cstb_bind_oper_id in", values, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdNotIn(List<Long> values) {
			addCriterion("cstb_bind_oper_id not in", values, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdBetween(Long value1, Long value2) {
			addCriterion("cstb_bind_oper_id between", value1, value2, "cstbBindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbBindOperIdNotBetween(Long value1, Long value2) {
			addCriterion("cstb_bind_oper_id not between", value1, value2, "cstbBindOperId");
			return (Criteria) this;
		}
		public Criteria andcstbUnbindOperIdIsNull() {
			addCriterion("cstb_unbind_oper_id is null");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdIsNotNull() {
			addCriterion("cstb_unbind_oper_id is not null");
			return (Criteria) this;
		}


		public Criteria andcstbUnbindOperIdEqualTo(Long value) {
			addCriterion("cstb_unbind_oper_id =", value, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdNotEqualTo(Long value) {
			addCriterion("cstb_unbind_oper_id <>", value, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdGreaterThan(Long value) {
			addCriterion("cstb_unbind_oper_id >", value, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cstb_unbind_oper_id >=", value, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdLessThan(Long value) {
			addCriterion("cstb_unbind_oper_id <", value, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdLessThanOrEqualTo(Long value) {
			addCriterion("cstb_unbind_oper_id <=", value, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdIn(List<Long> values) {
			addCriterion("cstb_unbind_oper_id in", values, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdNotIn(List<Long> values) {
			addCriterion("cstb_unbind_oper_id not in", values, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdBetween(Long value1, Long value2) {
			addCriterion("cstb_unbind_oper_id between", value1, value2, "cstbUnbindOperId");
			return (Criteria) this;
		}

		public Criteria andcstbUnbindOperIdNotBetween(Long value1, Long value2) {
			addCriterion("cstb_unbind_oper_id not between", value1, value2, "cstbUnbindOperId");
			return (Criteria) this;
		}
		public Criteria andcstbOperTypeIsNull() {
			addCriterion("cstb_oper_type is null");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeIsNotNull() {
			addCriterion("cstb_oper_type is not null");
			return (Criteria) this;
		}


		public Criteria andcstbOperTypeEqualTo(Short value) {
			addCriterion("cstb_oper_type =", value, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeNotEqualTo(Short value) {
			addCriterion("cstb_oper_type <>", value, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeGreaterThan(Short value) {
			addCriterion("cstb_oper_type >", value, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeGreaterThanOrEqualTo(Short value) {
			addCriterion("cstb_oper_type >=", value, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeLessThan(Short value) {
			addCriterion("cstb_oper_type <", value, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeLessThanOrEqualTo(Short value) {
			addCriterion("cstb_oper_type <=", value, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeIn(List<Short> values) {
			addCriterion("cstb_oper_type in", values, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeNotIn(List<Short> values) {
			addCriterion("cstb_oper_type not in", values, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeBetween(Short value1, Short value2) {
			addCriterion("cstb_oper_type between", value1, value2, "cstbOperType");
			return (Criteria) this;
		}

		public Criteria andcstbOperTypeNotBetween(Short value1, Short value2) {
			addCriterion("cstb_oper_type not between", value1, value2, "cstbOperType");
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