package com.ccclubs.admin.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 车辆国标历史信息
 * @author Joel
 */
public class GbState implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [gs_id]ID
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer gsId;
	/**
	 * [vin]VIN
	 */
	
	private   String vin;
	/**
	 * [time_text]报文时间
	 */
	
	private   String timeText;
	/**
	 * [vehicle_status_string]车辆状态
	 */
	
	private   String vehicleStatusString;
	/**
	 * [charging_string]充电状态
	 */
	
	private   String chargingString;
	/**
	 * [running_mode_string]运行模式
	 */
	
	private   String runningModeString;
	/**
	 * [speed_string]车速
	 */
	
	private   String speedString;
	/**
	 * [mileage_string]累计里程
	 */
	
	private   String mileageString;
	/**
	 * [voltage_string]总电压
	 */
	
	private   String voltageString;
	/**
	 * [current_string]总电流
	 */
	
	private   String currentString;
	/**
	 * [soc_string]SOC
	 */
	
	private   String socString;
	/**
	 * [dc_dc_status_string]DC-DC状态
	 */
	
	private   String dcDcStatusString;
	/**
	 * [gear_string]挡位
	 */
	
	private   String gearString;
	/**
	 * [insulation_resistance_string]绝缘电阻
	 */
	
	private   String insulationResistanceString;
	/**
	 * [accelerated_pedal_stroke_value_string]加速踏板行程值
	 */
	
	private   String acceleratedPedalStrokeValueString;
	/**
	 * [brake_pedal_state_string]制动踏板状态
	 */
	
	private   String brakePedalStateString;
	/**
	 * [position_status_string]定位状态
	 */
	
	private   String positionStatusString;
	/**
	 * [longitude_string]经度
	 */
	
	private   Float longitudeString;
	/**
	 * [latitude_string]纬度
	 */
	
	private   Float latitudeString;
	
	//默认构造函数
	public GbState(){
	
	}
	
	//主键构造函数
	public GbState(Integer id){
		this.gsId = id;
	}
	
	//设置非空字段
	public GbState setNotNull(String vin,String timeText){
		this.vin=vin;
		this.timeText=timeText;
		return this;
	}
	
	
	@Transient
	Map<String, Resolver<GbState>> resolvers = new HashMap<String, Resolver<GbState>>();
	
	public void registResolver(Resolver<GbState> resolver){
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
	public Integer getGsId(){
		return this.gsId;
	}
	
	/**
	* ID [可空]     
	**/
	public void setGsId(Integer gsId){
		this.gsId = gsId;
	}
	/*******************************VIN**********************************/	
	/**
	* VIN [非空]      
	**/
	public String getvin(){
		return this.vin;
	}
	
	/**
	* VIN [非空]     
	**/
	public void setvin(String vin){
		this.vin = vin;
	}
	/*******************************报文时间**********************************/	
	/**
	* 报文时间 [非空]      
	**/
	public String getTimeText(){
		return this.timeText;
	}
	
	/**
	* 报文时间 [非空]     
	**/
	public void setTimeText(String timeText){
		this.timeText = timeText;
	}
	/*******************************车辆状态**********************************/	
	/**
	* 车辆状态 [可空]      
	**/
	public String getVehicleStatusString(){
		return this.vehicleStatusString;
	}
	
	/**
	* 车辆状态 [可空]     
	**/
	public void setVehicleStatusString(String vehicleStatusString){
		this.vehicleStatusString = vehicleStatusString;
	}
	/*******************************充电状态**********************************/	
	/**
	* 充电状态 [可空]      
	**/
	public String getChargingString(){
		return this.chargingString;
	}
	
	/**
	* 充电状态 [可空]     
	**/
	public void setChargingString(String chargingString){
		this.chargingString = chargingString;
	}
	/*******************************运行模式**********************************/	
	/**
	* 运行模式 [可空]      
	**/
	public String getRunningModeString(){
		return this.runningModeString;
	}
	
	/**
	* 运行模式 [可空]     
	**/
	public void setRunningModeString(String runningModeString){
		this.runningModeString = runningModeString;
	}
	/*******************************车速**********************************/	
	/**
	* 车速 [可空]      
	**/
	public String getSpeedString(){
		return this.speedString;
	}
	
	/**
	* 车速 [可空]     
	**/
	public void setSpeedString(String speedString){
		this.speedString = speedString;
	}
	/*******************************累计里程**********************************/	
	/**
	* 累计里程 [可空]      
	**/
	public String getMileageString(){
		return this.mileageString;
	}
	
	/**
	* 累计里程 [可空]     
	**/
	public void setMileageString(String mileageString){
		this.mileageString = mileageString;
	}
	/*******************************总电压**********************************/	
	/**
	* 总电压 [可空]      
	**/
	public String getVoltageString(){
		return this.voltageString;
	}
	
	/**
	* 总电压 [可空]     
	**/
	public void setVoltageString(String voltageString){
		this.voltageString = voltageString;
	}
	/*******************************总电流**********************************/	
	/**
	* 总电流 [可空]      
	**/
	public String getCurrentString(){
		return this.currentString;
	}
	
	/**
	* 总电流 [可空]     
	**/
	public void setCurrentString(String currentString){
		this.currentString = currentString;
	}
	/*******************************SOC**********************************/	
	/**
	* SOC [可空]      
	**/
	public String getSocString(){
		return this.socString;
	}
	
	/**
	* SOC [可空]     
	**/
	public void setSocString(String socString){
		this.socString = socString;
	}
	/*******************************DC-DC状态**********************************/	
	/**
	* DC-DC状态 [可空]      
	**/
	public String getDcDcStatusString(){
		return this.dcDcStatusString;
	}
	
	/**
	* DC-DC状态 [可空]     
	**/
	public void setDcDcStatusString(String dcDcStatusString){
		this.dcDcStatusString = dcDcStatusString;
	}
	/*******************************挡位**********************************/	
	/**
	* 挡位 [可空]      
	**/
	public String getGearString(){
		return this.gearString;
	}
	
	/**
	* 挡位 [可空]     
	**/
	public void setGearString(String gearString){
		this.gearString = gearString;
	}
	/*******************************绝缘电阻**********************************/	
	/**
	* 绝缘电阻 [可空]      
	**/
	public String getInsulationResistanceString(){
		return this.insulationResistanceString;
	}
	
	/**
	* 绝缘电阻 [可空]     
	**/
	public void setInsulationResistanceString(String insulationResistanceString){
		this.insulationResistanceString = insulationResistanceString;
	}
	/*******************************加速踏板行程值**********************************/	
	/**
	* 加速踏板行程值 [可空]      
	**/
	public String getAcceleratedPedalStrokeValueString(){
		return this.acceleratedPedalStrokeValueString;
	}
	
	/**
	* 加速踏板行程值 [可空]     
	**/
	public void setAcceleratedPedalStrokeValueString(String acceleratedPedalStrokeValueString){
		this.acceleratedPedalStrokeValueString = acceleratedPedalStrokeValueString;
	}
	/*******************************制动踏板状态**********************************/	
	/**
	* 制动踏板状态 [可空]      
	**/
	public String getBrakePedalStateString(){
		return this.brakePedalStateString;
	}
	
	/**
	* 制动踏板状态 [可空]     
	**/
	public void setBrakePedalStateString(String brakePedalStateString){
		this.brakePedalStateString = brakePedalStateString;
	}
	/*******************************定位状态**********************************/	
	/**
	* 定位状态 [可空]      
	**/
	public String getPositionStatusString(){
		return this.positionStatusString;
	}
	
	/**
	* 定位状态 [可空]     
	**/
	public void setPositionStatusString(String positionStatusString){
		this.positionStatusString = positionStatusString;
	}
	/*******************************经度**********************************/	
	/**
	* 经度 [可空]      
	**/
	public Float getLongitudeString(){
		return this.longitudeString;
	}
	
	/**
	* 经度 [可空]     
	**/
	public void setLongitudeString(Float longitudeString){
		this.longitudeString = longitudeString;
	}
	/*******************************纬度**********************************/	
	/**
	* 纬度 [可空]      
	**/
	public Float getLatitudeString(){
		return this.latitudeString;
	}
	
	/**
	* 纬度 [可空]     
	**/
	public void setLatitudeString(Float latitudeString){
		this.latitudeString = latitudeString;
	}
}