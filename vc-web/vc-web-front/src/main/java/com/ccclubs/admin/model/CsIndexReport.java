package com.ccclubs.admin.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import com.ccclubs.admin.vo.Resolver;

/**
 * 指标统计
 * @author Joel
 */
public class CsIndexReport implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long id;
	/**
	 * [cs_vin]车辆VIN码
	 */
	
	private   String csVin;
	/**
	 * [cs_number]车机号
	 */
	
	private   String csNumber;
	/**
	 * [monthly_avg_mile]月均行驶里程(KM)
	 */
	
	private   Double monthlyAvgMile;
	/**
	 * [avg_drive_time_per_day]平均单日运行时间
	 */
	
	private   Double avgDriveTimePerDay;
	/**
	 * [power_consume_per_hundred]百公里耗电量
	 */
	
	private   Double powerConsumePerHundred;
	/**
	 * [electric_range]车辆纯电续驶里程
	 */
	
	private   Double electricRange;
	/**
	 * [max_charge_power]最大充电功率
	 */
	
	private   Double maxChargePower;
	/**
	 * [min_charge_time]车辆一次充满电所用最少时间
	 */
	
	private   Double minChargeTime;
	/**
	 * [cumulative_mileage]累计行驶里程
	 */
	
	private   Double cumulativeMileage;
	/**
	 * [cumulative_charge]累计充电量
	 */
	
	private   Double cumulativeCharge;
	/**
	 * [data_type]数据类型0:正常 1:未纳入 2:超标
	 */
	
	private   Integer dataType;
	/**
	 * [createTime]此行创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date createTime;
	/**
	 * [modifyDate]此行更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date modifyDate;
	/**
	 * [fac_time]车辆出厂日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date facTime;
	
	//默认构造函数
	public CsIndexReport(){
	
	}
	
	//主键构造函数
	public CsIndexReport(Long id){
		this.id = id;
	}
	
	//设置非空字段
	public CsIndexReport setNotNull(Date createTime){
		this.createTime=createTime;
		return this;
	}
	
	public Object getCsVinText(){
		return resolve("csVinText");
	}
	public Object getCsNumberText(){
		return resolve("csNumberText");
	}
	public Object getDataTypeText(){
		return resolve("dataTypeText");
	}
	
	@Transient
	Map<String, Resolver<CsIndexReport>> resolvers = new HashMap<String, Resolver<CsIndexReport>>();
	
	public void registResolver(Resolver<CsIndexReport> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************编号**********************************/	
	/**
	* 编号 [可空]      
	**/
	public Long getid(){
		return this.id;
	}
	
	/**
	* 编号 [可空]     
	**/
	public void setid(Long id){
		this.id = id;
	}
	/*******************************车辆VIN码**********************************/	
	/**
	* 车辆VIN码 [可空]      
	**/
	public String getCsVin(){
		return this.csVin;
	}
	
	/**
	* 车辆VIN码 [可空]     
	**/
	public void setCsVin(String csVin){
		this.csVin = csVin;
	}
	/*******************************车机号**********************************/	
	/**
	* 车机号 [可空]      
	**/
	public String getCsNumber(){
		return this.csNumber;
	}
	
	/**
	* 车机号 [可空]     
	**/
	public void setCsNumber(String csNumber){
		this.csNumber = csNumber;
	}
	/*******************************月均行驶里程(KM)**********************************/	
	/**
	* 月均行驶里程(KM) [可空]      
	**/
	public Double getMonthlyAvgMile(){
		return this.monthlyAvgMile;
	}
	
	/**
	* 月均行驶里程(KM) [可空]     
	**/
	public void setMonthlyAvgMile(Double monthlyAvgMile){
		this.monthlyAvgMile = monthlyAvgMile;
	}
	/*******************************平均单日运行时间**********************************/	
	/**
	* 平均单日运行时间 [可空]      
	**/
	public Double getAvgDriveTimePerDay(){
		return this.avgDriveTimePerDay;
	}
	
	/**
	* 平均单日运行时间 [可空]     
	**/
	public void setAvgDriveTimePerDay(Double avgDriveTimePerDay){
		this.avgDriveTimePerDay = avgDriveTimePerDay;
	}
	/*******************************百公里耗电量**********************************/	
	/**
	* 百公里耗电量 [可空]      
	**/
	public Double getPowerConsumePerHundred(){
		return this.powerConsumePerHundred;
	}
	
	/**
	* 百公里耗电量 [可空]     
	**/
	public void setPowerConsumePerHundred(Double powerConsumePerHundred){
		this.powerConsumePerHundred = powerConsumePerHundred;
	}
	/*******************************车辆纯电续驶里程**********************************/	
	/**
	* 车辆纯电续驶里程 [可空]      
	**/
	public Double getElectricRange(){
		return this.electricRange;
	}
	
	/**
	* 车辆纯电续驶里程 [可空]     
	**/
	public void setElectricRange(Double electricRange){
		this.electricRange = electricRange;
	}
	/*******************************最大充电功率**********************************/	
	/**
	* 最大充电功率 [可空]      
	**/
	public Double getMaxChargePower(){
		return this.maxChargePower;
	}
	
	/**
	* 最大充电功率 [可空]     
	**/
	public void setMaxChargePower(Double maxChargePower){
		this.maxChargePower = maxChargePower;
	}
	/*******************************车辆一次充满电所用最少时间**********************************/	
	/**
	* 车辆一次充满电所用最少时间 [可空]      
	**/
	public Double getMinChargeTime(){
		return this.minChargeTime;
	}
	
	/**
	* 车辆一次充满电所用最少时间 [可空]     
	**/
	public void setMinChargeTime(Double minChargeTime){
		this.minChargeTime = minChargeTime;
	}
	/*******************************累计行驶里程**********************************/	
	/**
	* 累计行驶里程 [可空]      
	**/
	public Double getCumulativeMileage(){
		return this.cumulativeMileage;
	}
	
	/**
	* 累计行驶里程 [可空]     
	**/
	public void setCumulativeMileage(Double cumulativeMileage){
		this.cumulativeMileage = cumulativeMileage;
	}
	/*******************************累计充电量**********************************/	
	/**
	* 累计充电量 [可空]      
	**/
	public Double getCumulativeCharge(){
		return this.cumulativeCharge;
	}
	
	/**
	* 累计充电量 [可空]     
	**/
	public void setCumulativeCharge(Double cumulativeCharge){
		this.cumulativeCharge = cumulativeCharge;
	}
	/*******************************数据类型**********************************/	
	/**
	* 数据类型 [可空]      
	**/
	public Integer getDataType(){
		return this.dataType;
	}
	
	/**
	* 数据类型 [可空]     
	**/
	public void setDataType(Integer dataType){
		this.dataType = dataType;
	}
	/*******************************此行创建时间**********************************/	
	/**
	* 此行创建时间 [非空]      
	**/
	public Date getcreateTime(){
		return this.createTime;
	}
	
	/**
	* 此行创建时间 [非空]     
	**/
	public void setcreateTime(Date createTime){
		this.createTime = createTime;
	}
	/*******************************此行更新时间**********************************/	
	/**
	* 此行更新时间 [可空]      
	**/
	public Date getmodifyDate(){
		return this.modifyDate;
	}
	
	/**
	* 此行更新时间 [可空]     
	**/
	public void setmodifyDate(Date modifyDate){
		this.modifyDate = modifyDate;
	}
	/*******************************车辆出厂日期**********************************/	
	/**
	* 车辆出厂日期 [可空]      
	**/
	public Date getFacTime(){
		return this.facTime;
	}
	
	/**
	* 车辆出厂日期 [可空]     
	**/
	public void setFacTime(Date facTime){
		this.facTime = facTime;
	}

}