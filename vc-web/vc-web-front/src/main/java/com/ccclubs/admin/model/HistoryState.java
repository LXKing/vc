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

import com.ccclubs.frm.spring.resolver.Resolver;

/**
 * 车辆状态历史数据
 * @author Joel
 */
public class HistoryState implements java.io.Serializable
{
	/**
	 * [cs_number]车机号
	 */
	
	private   String csNumber;
	/**
	 * [cs_access]授权系统
	 */
	
	private   Integer csAccess;
	/**
	 * [add_time]添加时间
	 */
	
	private   Long addTime;
	/**
	 * [current_time]下位机时间
	 */
	
	private   Long currentTime;
	/**
	 * [rent_flg]租赁状态
	 */
	
	private   Integer rentFlg;
	/**
	 * [warn_code]报警代码
	 */
	
	private   String warnCode;
	/**
	 * [rfid]RFID卡号
	 */
	
	private   String rfid;
	/**
	 * [user_rfid]用户RFID
	 */
	
	private   String userRfid;
	/**
	 * [obd_miles]OBD里程
	 */
	
	private   Float obdMiles;
	/**
	 * [engine_tempe]发动机温度
	 */
	
	private   Float engineTempe;
	/**
	 * [total_miles]总里程
	 */
	
	private   Float totalMiles;
	/**
	 * [speed]车速
	 */
	
	private   Float speed;
	/**
	 * [motor_speed]转速
	 */
	
	private   Float motorSpeed;
	/**
	 * [oil_cost]燃油量
	 */
	
	private   Float oilCost;
	/**
	 * [power_reserve]蓄电量
	 */
	
	private   Float powerReserve;
	/**
	 * [ev_battery]动力电池电量
	 */
	
	private   Float evBattery;
	/**
	 * [charging_status]充电状态
	 */
	
	private   Integer chargingStatus;
	/**
	 * [fuel_miles]油里程
	 */
	
	private   Float fuelMiles;
	/**
	 * [elec_miles]电量程
	 */
	
	private   Float elecMiles;
	/**
	 * [endur_miles]续航里程
	 */
	
	private   Float endurMiles;
	/**
	 * [tempe]温度
	 */
	
	private   Float tempe;
	/**
	 * [gps_num]卫星数量
	 */
	
	private   Integer gpsNum;
	/**
	 * [gps_strength]卫星信号强度
	 */
	
	private   Integer gpsStrength;
	/**
	 * [gps_valid]gps有效性
	 */
	
	private   Integer gpsValid;
	/**
	 * [net_strength]网络信号强度
	 */
	
	private   Integer netStrength;
	/**
	 * [longitude]经度
	 */
	
	private   Double longitude;
	/**
	 * [latitude]纬度
	 */
	
	private   Double latitude;
	/**
	 * [direction_angle]方向角度
	 */
	
	private   Float directionAngle;
	/**
	 * [circular_mode]循环模式
	 */
	
	private   Integer circularMode;
	/**
	 * [ptc_status]PTC启停
	 */
	
	private   Integer ptcStatus;
	/**
	 * [compre_status]压缩机状态
	 */
	
	private   Integer compreStatus;
	/**
	 * [fan_mode]档风量
	 */
	
	private   Integer fanMode;
	/**
	 * [saving_mode]省电模式
	 */
	
	private   Integer savingMode;
	/**
	 * [door_status]车门状态
	 */
	
	private   Integer doorStatus;
	/**
	 * [engine_status]发动机
	 */
	
	private   Integer engineStatus;
	/**
	 * [key_status]钥匙状态
	 */
	
	private   Integer keyStatus;
	/**
	 * [light_status]灯状态
	 */
	
	private   Integer lightStatus;
	/**
	 * [lock_status]锁状态
	 */
	
	private   Integer lockStatus;
	/**
	 * [net_type]网络类型
	 */
	
	private   String netType;
	/**
	 * [base_lac]基站LAC
	 */
	
	private   String baseLac;
	/**
	 * [base_ci]基站CI
	 */
	
	private   String baseCi;
	/**
	 * [cur_order]当前订单
	 */
	
	private   String curOrder;
	/**
	 * [gear]档位0:空挡 1:1挡 2:2挡 3:3挡 4:4挡 5:5挡 6:6挡 7:7挡 8:8挡 9:9挡 10:10挡 11:11挡 12:12挡 13:倒挡 14:自动D挡 15:停车P挡
	 */

	private   Integer gear;
	
	//默认构造函数
	public HistoryState(){
	
	}


	private static final long serialVersionUID =         1L;
	/**
	 * [car_state_history_id]ID
	 */

	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long carStateHistoryId;


	//主键构造函数
	public HistoryState(Long id){
		this.carStateHistoryId = id;
	}
	
	//设置非空字段
	public HistoryState setNotNull(String csNumber,Integer csAccess,Long addTime,Long currentTime){
		this.csNumber=csNumber;
		this.csAccess=csAccess;
		this.addTime=addTime;
		this.currentTime=currentTime;
		return this;
	}

	public Object getCsAccessText(){
		return resolve("csAccessText");
	}
	public Object getCurrentTimeText(){
		return resolve("currentTimeText");
	}
	public Object getAddTimeText(){
		return resolve("addTimeText");
	}
	public Object getChargingStatusText(){
		return resolve("chargingStatusText");
	}
	public Object getGpsValidText(){
		return resolve("gpsValidText");
	}
	public Object getCircularModeText(){
		return resolve("circularModeText");
	}
	public Object getPtcStatusText(){
		return resolve("ptcStatusText");
	}
	public Object getCompreStatusText(){
		return resolve("compreStatusText");
	}
	public Object getFanModeText(){
		return resolve("fanModeText");
	}
	public Object getSavingModeText(){
		return resolve("savingModeText");
	}
	public Object getEngineStatusText(){
		return resolve("engineStatusText");
	}
	public Object getNetTypeText(){
		return resolve("netTypeText");
	}
	public Object getgearText(){
		return resolve("gearText");
	}
	
	@Transient
	Map<String, Resolver<HistoryState>> resolvers = new HashMap<String, Resolver<HistoryState>>();
	
	public void registResolver(Resolver<HistoryState> resolver){
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
	public Long getCarStateHistoryId(){
		return this.carStateHistoryId;
	}
	
	/**
	* ID [可空]     
	**/
	public void setCarStateHistoryId(Long carStateHistoryId){
		this.carStateHistoryId = carStateHistoryId;
	}
	/*******************************车机号**********************************/	
	/**
	* 车机号 [非空]      
	**/
	public String getCsNumber(){
		return this.csNumber;
	}
	
	/**
	* 车机号 [非空]     
	**/
	public void setCsNumber(String csNumber){
		this.csNumber = csNumber;
	}
	/*******************************授权系统**********************************/	
	/**
	* 授权系统 [非空]      
	**/
	public Integer getCsAccess(){
		return this.csAccess;
	}

	public String getRfid() {
		return this.rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public Float getSpeed() {
		return this.speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public Float getTempe() {
		return this.tempe;
	}

	public void setTempe(Float tempe) {
		this.tempe = tempe;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getGear() {
		return this.gear;
	}

	public void setGear(Integer gear) {
		this.gear = gear;
	}

	/**
	* 授权系统 [非空]     
	**/
	public void setCsAccess(Integer csAccess){
		this.csAccess = csAccess;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [非空]      
	**/
	public Long getAddTime(){
		return this.addTime;
	}
	
	/**
	* 添加时间 [非空]     
	**/
	public void setAddTime(Long addTime){
		this.addTime = addTime;
	}
	/*******************************下位机时间**********************************/	
	/**
	* 下位机时间 [非空]      
	**/
	public Long getCurrentTime(){
		return this.currentTime;
	}
	
	/**
	* 下位机时间 [非空]     
	**/
	public void setCurrentTime(Long currentTime){
		this.currentTime = currentTime;
	}
	/*******************************租赁状态**********************************/	
	/**
	* 租赁状态 [可空]      
	**/
	public Integer getRentFlg(){
		return this.rentFlg;
	}
	
	/**
	* 租赁状态 [可空]     
	**/
	public void setRentFlg(Integer rentFlg){
		this.rentFlg = rentFlg;
	}
	/*******************************报警代码**********************************/	
	/**
	* 报警代码 [可空]      
	**/
	public String getWarnCode(){
		return this.warnCode;
	}
	
	/**
	* 报警代码 [可空]     
	**/
	public void setWarnCode(String warnCode){
		this.warnCode = warnCode;
	}
	/*******************************RFID卡号**********************************/	
	/**
	* RFID卡号 [可空]      
	**/
	/*public String getrfid(){
		return this.rfid;
	}*/
	
	/**
	* RFID卡号 [可空]     
	**/
	/*public void setrfid(String rfid){
		this.rfid = rfid;
	}*/
	/*******************************用户RFID**********************************/	
	/**
	* 用户RFID [可空]      
	**/
	public String getUserRfid(){
		return this.userRfid;
	}
	
	/**
	* 用户RFID [可空]     
	**/
	public void setUserRfid(String userRfid){
		this.userRfid = userRfid;
	}
	/*******************************OBD里程**********************************/	
	/**
	* OBD里程 [可空]      
	**/
	public Float getObdMiles(){
		return this.obdMiles;
	}
	
	/**
	* OBD里程 [可空]     
	**/
	public void setObdMiles(Float obdMiles){
		this.obdMiles = obdMiles;
	}
	/*******************************发动机温度**********************************/	
	/**
	* 发动机温度 [可空]      
	**/
	public Float getEngineTempe(){
		return this.engineTempe;
	}
	
	/**
	* 发动机温度 [可空]     
	**/
	public void setEngineTempe(Float engineTempe){
		this.engineTempe = engineTempe;
	}
	/*******************************总里程**********************************/	
	/**
	* 总里程 [可空]      
	**/
	public Float getTotalMiles(){
		return this.totalMiles;
	}
	
	/**
	* 总里程 [可空]     
	**/
	public void setTotalMiles(Float totalMiles){
		this.totalMiles = totalMiles;
	}
	/*******************************车速**********************************/	
	/**
	* 车速 [可空]      
	**/
	/*public Float getspeed(){
		return this.speed;
	}*/
	
	/**
	* 车速 [可空]     
	**/
	/*public void setspeed(Float speed){
		this.speed = speed;
	}*/
	/*******************************转速**********************************/	
	/**
	* 转速 [可空]      
	**/
	public Float getMotorSpeed(){
		return this.motorSpeed;
	}
	
	/**
	* 转速 [可空]     
	**/
	public void setMotorSpeed(Float motorSpeed){
		this.motorSpeed = motorSpeed;
	}
	/*******************************燃油量**********************************/	
	/**
	* 燃油量 [可空]      
	**/
	public Float getOilCost(){
		return this.oilCost;
	}
	
	/**
	* 燃油量 [可空]     
	**/
	public void setOilCost(Float oilCost){
		this.oilCost = oilCost;
	}
	/*******************************蓄电量**********************************/	
	/**
	* 蓄电量 [可空]      
	**/
	public Float getPowerReserve(){
		return this.powerReserve;
	}
	
	/**
	* 蓄电量 [可空]     
	**/
	public void setPowerReserve(Float powerReserve){
		this.powerReserve = powerReserve;
	}
	/*******************************动力电池电量**********************************/	
	/**
	* 动力电池电量 [可空]      
	**/
	public Float getEvBattery(){
		return this.evBattery;
	}
	
	/**
	* 动力电池电量 [可空]     
	**/
	public void setEvBattery(Float evBattery){
		this.evBattery = evBattery;
	}
	/*******************************充电状态**********************************/	
	/**
	* 充电状态 [可空]      
	**/
	public Integer getChargingStatus(){
		return this.chargingStatus;
	}
	
	/**
	* 充电状态 [可空]     
	**/
	public void setChargingStatus(Integer chargingStatus){
		this.chargingStatus = chargingStatus;
	}
	/*******************************油里程**********************************/	
	/**
	* 油里程 [可空]      
	**/
	public Float getFuelMiles(){
		return this.fuelMiles;
	}
	
	/**
	* 油里程 [可空]     
	**/
	public void setFuelMiles(Float fuelMiles){
		this.fuelMiles = fuelMiles;
	}
	/*******************************电量程**********************************/	
	/**
	* 电量程 [可空]      
	**/
	public Float getElecMiles(){
		return this.elecMiles;
	}
	
	/**
	* 电量程 [可空]     
	**/
	public void setElecMiles(Float elecMiles){
		this.elecMiles = elecMiles;
	}
	/*******************************续航里程**********************************/	
	/**
	* 续航里程 [可空]      
	**/
	public Float getEndurMiles(){
		return this.endurMiles;
	}
	
	/**
	* 续航里程 [可空]     
	**/
	public void setEndurMiles(Float endurMiles){
		this.endurMiles = endurMiles;
	}
	/*******************************温度**********************************/	
	/**
	* 温度 [可空]      
	**/
	/*public Float gettempe(){
		return this.tempe;
	}*/
	
	/**
	* 温度 [可空]     
	**/
	/*public void settempe(Float tempe){
		this.tempe = tempe;
	}*/
	/*******************************卫星数量**********************************/	
	/**
	* 卫星数量 [可空]      
	**/
	public Integer getGpsNum(){
		return this.gpsNum;
	}
	
	/**
	* 卫星数量 [可空]     
	**/
	public void setGpsNum(Integer gpsNum){
		this.gpsNum = gpsNum;
	}
	/*******************************卫星信号强度**********************************/	
	/**
	* 卫星信号强度 [可空]      
	**/
	public Integer getGpsStrength(){
		return this.gpsStrength;
	}
	
	/**
	* 卫星信号强度 [可空]     
	**/
	public void setGpsStrength(Integer gpsStrength){
		this.gpsStrength = gpsStrength;
	}
	/*******************************gps有效性**********************************/	
	/**
	* gps有效性 [可空]      
	**/
	public Integer getGpsValid(){
		return this.gpsValid;
	}
	
	/**
	* gps有效性 [可空]     
	**/
	public void setGpsValid(Integer gpsValid){
		this.gpsValid = gpsValid;
	}
	/*******************************网络信号强度**********************************/	
	/**
	* 网络信号强度 [可空]      
	**/
	public Integer getNetStrength(){
		return this.netStrength;
	}
	
	/**
	* 网络信号强度 [可空]     
	**/
	public void setNetStrength(Integer netStrength){
		this.netStrength = netStrength;
	}
	/*******************************经度**********************************/	
	/**
	* 经度 [可空]      
	**/
	/*public Double getlongitude(){
		return this.longitude;
	}*/
	
	/**
	* 经度 [可空]     
	**/
	/*public void setlongitude(Double longitude){
		this.longitude = longitude;
	}*/
	/*******************************纬度**********************************/	
	/**
	* 纬度 [可空]      
	**/
	/*public Double getlatitude(){
		return this.latitude;
	}*/
	
	/**
	* 纬度 [可空]     
	**/
	/*public void setlatitude(Double latitude){
		this.latitude = latitude;
	}*/
	/*******************************方向角度**********************************/	
	/**
	* 方向角度 [可空]      
	**/
	public Float getDirectionAngle(){
		return this.directionAngle;
	}
	
	/**
	* 方向角度 [可空]     
	**/
	public void setDirectionAngle(Float directionAngle){
		this.directionAngle = directionAngle;
	}
	/*******************************循环模式**********************************/	
	/**
	* 循环模式 [可空]      
	**/
	public Integer getCircularMode(){
		return this.circularMode;
	}
	
	/**
	* 循环模式 [可空]     
	**/
	public void setCircularMode(Integer circularMode){
		this.circularMode = circularMode;
	}
	/*******************************PTC启停**********************************/	
	/**
	* PTC启停 [可空]      
	**/
	public Integer getPtcStatus(){
		return this.ptcStatus;
	}
	
	/**
	* PTC启停 [可空]     
	**/
	public void setPtcStatus(Integer ptcStatus){
		this.ptcStatus = ptcStatus;
	}
	/*******************************压缩机状态**********************************/	
	/**
	* 压缩机状态 [可空]      
	**/
	public Integer getCompreStatus(){
		return this.compreStatus;
	}
	
	/**
	* 压缩机状态 [可空]     
	**/
	public void setCompreStatus(Integer compreStatus){
		this.compreStatus = compreStatus;
	}
	/*******************************档风量**********************************/	
	/**
	* 档风量 [可空]      
	**/
	public Integer getFanMode(){
		return this.fanMode;
	}
	
	/**
	* 档风量 [可空]     
	**/
	public void setFanMode(Integer fanMode){
		this.fanMode = fanMode;
	}
	/*******************************省电模式**********************************/	
	/**
	* 省电模式 [可空]      
	**/
	public Integer getSavingMode(){
		return this.savingMode;
	}
	
	/**
	* 省电模式 [可空]     
	**/
	public void setSavingMode(Integer savingMode){
		this.savingMode = savingMode;
	}
	/*******************************车门状态**********************************/	
	/**
	* 车门状态 [可空]      
	**/
	public Integer getDoorStatus(){
		return this.doorStatus;
	}
	
	/**
	* 车门状态 [可空]     
	**/
	public void setDoorStatus(Integer doorStatus){
		this.doorStatus = doorStatus;
	}
	/*******************************发动机**********************************/	
	/**
	* 发动机 [可空]      
	**/
	public Integer getEngineStatus(){
		return this.engineStatus;
	}
	
	/**
	* 发动机 [可空]     
	**/
	public void setEngineStatus(Integer engineStatus){
		this.engineStatus = engineStatus;
	}
	/*******************************钥匙状态**********************************/	
	/**
	* 钥匙状态 [可空]      
	**/
	public Integer getKeyStatus(){
		return this.keyStatus;
	}
	
	/**
	* 钥匙状态 [可空]     
	**/
	public void setKeyStatus(Integer keyStatus){
		this.keyStatus = keyStatus;
	}
	/*******************************灯状态**********************************/	
	/**
	* 灯状态 [可空]      
	**/
	public Integer getLightStatus(){
		return this.lightStatus;
	}
	
	/**
	* 灯状态 [可空]     
	**/
	public void setLightStatus(Integer lightStatus){
		this.lightStatus = lightStatus;
	}
	/*******************************锁状态**********************************/	
	/**
	* 锁状态 [可空]      
	**/
	public Integer getLockStatus(){
		return this.lockStatus;
	}
	
	/**
	* 锁状态 [可空]     
	**/
	public void setLockStatus(Integer lockStatus){
		this.lockStatus = lockStatus;
	}
	/*******************************网络类型**********************************/	
	/**
	* 网络类型 [可空]      
	**/
	public String getNetType(){
		return this.netType;
	}
	
	/**
	* 网络类型 [可空]     
	**/
	public void setNetType(String netType){
		this.netType = netType;
	}
	/*******************************基站LAC**********************************/	
	/**
	* 基站LAC [可空]      
	**/
	public String getBaseLac(){
		return this.baseLac;
	}
	
	/**
	* 基站LAC [可空]     
	**/
	public void setBaseLac(String baseLac){
		this.baseLac = baseLac;
	}
	/*******************************基站CI**********************************/	
	/**
	* 基站CI [可空]      
	**/
	public String getBaseCi(){
		return this.baseCi;
	}
	
	/**
	* 基站CI [可空]     
	**/
	public void setBaseCi(String baseCi){
		this.baseCi = baseCi;
	}
	/*******************************当前订单**********************************/	
	/**
	* 当前订单 [可空]      
	**/
	public String getCurOrder(){
		return this.curOrder;
	}
	
	/**
	* 当前订单 [可空]     
	**/
	public void setCurOrder(String curOrder){
		this.curOrder = curOrder;
	}

	/*******************************档位**********************************/
	/**
	 * 档位 [可空]
	 **/
	/*public Integer getgear(){
		return this.gear;
	}*/

	/**
	 * 档位 [可空]
	 **/
	/*public void setgear(Integer gear){
		this.gear = gear;
	}*/






}