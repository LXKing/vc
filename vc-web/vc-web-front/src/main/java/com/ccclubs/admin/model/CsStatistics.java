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
 * 车辆统计数据
 * @author Joel
 */
public class CsStatistics implements java.io.Serializable
{

	/**
	 * [css_id]ID
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer cssId;
	/**
	 * [css_time]统计时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cssTime;
	/**
	 * [css_unit_time]间隔时间
	 */
	
	private   Long cssUnitTime;
	/**
	 * [css_registered_num]总注册数
	 */
	
	private   Integer cssRegisteredNum;
	/**
	 * [css_online_num]在线数
	 */
	
	private   Integer cssOnlineNum;
	/**
	 * [css_offline_num]离线数
	 */
	
	private   Integer cssOfflineNum;
	/**
	 * [css_run_num]运行数
	 */
	
	private   Integer cssRunNum;
	/**
	 * [css_charging_num]充电数
	 */
	
	private   Integer cssChargingNum;
	/**
	 * [css_total_mileage]运行总里程
	 */
	
	private   Float cssTotalMileage;
	/**
	 * [css_total_charge]总充电量
	 */
	
	private   Float cssTotalCharge;
	/**
	 * [css_total_power_consumption]电池增量
	 */
	
	private   Float cssTotalPowerConsumption;
	/**
	 * [css_total_run_time]总运行时间
	 */
	
	private   Long cssTotalRunTime;
	/**
	 * [css_increment_mileage]增量里程
	 */
	
	private   Long cssIncrementMileage;
	/**
	 * [css_access]授权系统
	 */
	
	private   Integer cssAccess;
	/**
	 * [css_car_model]车型
	 */
	
	private   Integer cssCarModel;

	private static final long serialVersionUID =         1L;


	//默认构造函数
	public CsStatistics(){
	
	}
	
	//主键构造函数
	public CsStatistics(Integer id){
		this.cssId = id;
	}
	
	//设置非空字段
	public CsStatistics setNotNull(Date cssTime){
		this.cssTime=cssTime;
		return this;
	}
	
	
	@Transient
	Map<String, Resolver<CsStatistics>> resolvers = new HashMap<String, Resolver<CsStatistics>>();
	
	public void registResolver(Resolver<CsStatistics> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************ID**********************************/	
	/**
	* ID [可空]      
	**/
	public Integer getCssId(){
		return this.cssId;
	}
	
	/**
	* ID [可空]     
	**/
	public void setCssId(Integer cssId){
		this.cssId = cssId;
	}
	/*******************************统计时间**********************************/	
	/**
	* 统计时间 [非空]      
	**/
	public Date getCssTime(){
		return this.cssTime;
	}
	
	/**
	* 统计时间 [非空]     
	**/
	public void setCssTime(Date cssTime){
		this.cssTime = cssTime;
	}
	/*******************************间隔时间**********************************/	
	/**
	* 间隔时间 [可空]      
	**/
	public Long getCssUnitTime(){
		return this.cssUnitTime;
	}
	
	/**
	* 间隔时间 [可空]     
	**/
	public void setCssUnitTime(Long cssUnitTime){
		this.cssUnitTime = cssUnitTime;
	}
	/*******************************总注册数**********************************/	
	/**
	* 总注册数 [可空]      
	**/
	public Integer getCssRegisteredNum(){
		return this.cssRegisteredNum;
	}
	
	/**
	* 总注册数 [可空]     
	**/
	public void setCssRegisteredNum(Integer cssRegisteredNum){
		this.cssRegisteredNum = cssRegisteredNum;
	}
	/*******************************在线数**********************************/	
	/**
	* 在线数 [可空]      
	**/
	public Integer getCssOnlineNum(){
		return this.cssOnlineNum;
	}
	
	/**
	* 在线数 [可空]     
	**/
	public void setCssOnlineNum(Integer cssOnlineNum){
		this.cssOnlineNum = cssOnlineNum;
	}
	/*******************************离线数**********************************/	
	/**
	* 离线数 [可空]      
	**/
	public Integer getCssOfflineNum(){
		return this.cssOfflineNum;
	}
	
	/**
	* 离线数 [可空]     
	**/
	public void setCssOfflineNum(Integer cssOfflineNum){
		this.cssOfflineNum = cssOfflineNum;
	}
	/*******************************运行数**********************************/	
	/**
	* 运行数 [可空]      
	**/
	public Integer getCssRunNum(){
		return this.cssRunNum;
	}
	
	/**
	* 运行数 [可空]     
	**/
	public void setCssRunNum(Integer cssRunNum){
		this.cssRunNum = cssRunNum;
	}
	/*******************************充电数**********************************/	
	/**
	* 充电数 [可空]      
	**/
	public Integer getCssChargingNum(){
		return this.cssChargingNum;
	}
	
	/**
	* 充电数 [可空]     
	**/
	public void setCssChargingNum(Integer cssChargingNum){
		this.cssChargingNum = cssChargingNum;
	}
	/*******************************运行总里程**********************************/	
	/**
	* 运行总里程 [可空]      
	**/
	public Float getCssTotalMileage(){
		return this.cssTotalMileage;
	}
	
	/**
	* 运行总里程 [可空]     
	**/
	public void setCssTotalMileage(Float cssTotalMileage){
		this.cssTotalMileage = cssTotalMileage;
	}
	/*******************************总充电量**********************************/	
	/**
	* 总充电量 [可空]      
	**/
	public Float getCssTotalCharge(){
		return this.cssTotalCharge;
	}
	
	/**
	* 总充电量 [可空]     
	**/
	public void setCssTotalCharge(Float cssTotalCharge){
		this.cssTotalCharge = cssTotalCharge;
	}
	/*******************************电池增量**********************************/	
	/**
	* 电池增量 [可空]      
	**/
	public Float getCssTotalPowerConsumption(){
		return this.cssTotalPowerConsumption;
	}
	
	/**
	* 电池增量 [可空]     
	**/
	public void setCssTotalPowerConsumption(Float cssTotalPowerConsumption){
		this.cssTotalPowerConsumption = cssTotalPowerConsumption;
	}
	/*******************************总运行时间**********************************/	
	/**
	* 总运行时间 [可空]      
	**/
	public Long getCssTotalRunTime(){
		return this.cssTotalRunTime;
	}
	
	/**
	* 总运行时间 [可空]     
	**/
	public void setCssTotalRunTime(Long cssTotalRunTime){
		this.cssTotalRunTime = cssTotalRunTime;
	}
	/*******************************增量里程**********************************/	
	/**
	* 增量里程 [可空]      
	**/
	public Long getCssIncrementMileage(){
		return this.cssIncrementMileage;
	}
	
	/**
	* 增量里程 [可空]     
	**/
	public void setCssIncrementMileage(Long cssIncrementMileage){
		this.cssIncrementMileage = cssIncrementMileage;
	}
	/*******************************授权系统**********************************/	
	/**
	* 授权系统 [可空]      
	**/
	public Integer getCssAccess(){
		return this.cssAccess;
	}
	
	/**
	* 授权系统 [可空]     
	**/
	public void setCssAccess(Integer cssAccess){
		this.cssAccess = cssAccess;
	}
	/*******************************车型**********************************/	
	/**
	* 车型 [可空]      
	**/
	public Integer getCssCarModel(){
		return this.cssCarModel;
	}
	
	/**
	* 车型 [可空]     
	**/
	public void setCssCarModel(Integer cssCarModel){
		this.cssCarModel = cssCarModel;
	}
}