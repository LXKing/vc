package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 车辆实时状态
 * @author Joel
 */
public class CsState implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [css_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer cssId;
	/**
	 * [css_access]接入商
	 */
	
	private   Short cssAccess;
	/**
	 * [css_host]子域
	 */
	
	private   Short cssHost;
	/**
	 * [css_number]车机号
	 */
	
	private   String cssNumber;
	/**
	 * [css_car]车辆
	 */
	
	private   Integer cssCar;
	/**
	 * [css_add_time]接收时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cssAddTime;
	/**
	 * [css_current_time]报文时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cssCurrentTime;
	/**
	 * [css_rented]租赁状态
	 */
	
	private   String cssRented;
	/**
	 * [css_warn]报警码
	 */
	
	private   Integer cssWarn;
	/**
	 * [css_rfid]RFID卡号
	 */
	
	private   String cssRfid;
	/**
	 * [css_rfid_dte]用户RFID
	 */
	
	private   String cssRfidDte;
	/**
	 * [css_obd_mile]累计里程
	 */
	
	private BigDecimal cssObdMile;
	/**
	 * [css_engine_t]发动机温度
	 */
	
	private   BigDecimal cssEngineT;
	/**
	 * [css_mileage]订单总里程
	 */
	
	private   BigDecimal cssMileage;
	/**
	 * [css_speed]车速
	 */
	
	private   BigDecimal cssSpeed;
	/**
	 * [css_motor]转速
	 */
	
	private   Integer cssMotor;
	/**
	 * [css_oil]燃油量
	 */
	
	private   BigDecimal cssOil;
	/**
	 * [css_power]小电瓶电量
	 */
	
	private   Integer cssPower;
	/**
	 * [css_ev_battery]SOC
	 */
	
	private   Short cssEvBattery;
	/**
	 * [css_charging]充电状态0:未充电 1:慢充 2:快充 3:充电完成
	 */
	
	private   Short cssCharging;
	/**
	 * [css_fuel_mileage]订单油里程
	 */
	
	private   BigDecimal cssFuelMileage;
	/**
	 * [css_electric_mileage]订单电里程
	 */
	
	private   BigDecimal cssElectricMileage;
	/**
	 * [css_endurance]续航里程
	 */
	
	private   BigDecimal cssEndurance;
	/**
	 * [css_temperature]温度
	 */
	
	private   BigDecimal cssTemperature;
	/**
	 * [css_csq]CSQ
	 */
	
	private   Short cssCsq;
	/**
	 * [css_longitude]经度
	 */
	
	private   BigDecimal cssLongitude;
	/**
	 * [css_latitude]纬度
	 */
	
	private   BigDecimal cssLatitude;
	/**
	 * [css_gps_valid]GPS有效性0:无效 1:有效
	 */
	
	private   Short cssGpsValid;
	/**
	 * [css_gps_cn]GPS强度
	 */
	
	private   Short cssGpsCn;
	/**
	 * [css_gps_count]GPS卫星数
	 */
	
	private   Short cssGpsCount;
	/**
	 * [css_dir]方向角
	 */
	
	private   BigDecimal cssDir;
	/**
	 * [css_circular]循环模式0:内循环 1:外循环
	 */
	
	private   Short cssCircular;
	/**
	 * [css_ptc]PTC启停0:OFF 1:ON
	 */
	
	private   Short cssPtc;
	/**
	 * [css_compres]压缩机0:OFF 1:ON
	 */
	
	private   Short cssCompres;
	/**
	 * [css_fan]档风量0:OFF 1:1档 2:2档 3:3档 4:4档
	 */
	
	private   Short cssFan;
	/**
	 * [css_saving]功耗模式0:标准模式 1:最佳省电 2:极度省电
	 */
	
	private   Short cssSaving;
	/**
	 * [css_door]车门状态
	 */
	
	private   String cssDoor;
	/**
	 * [css_engine]发动机状态0:无效 1:未熄火 2:已熄火
	 */
	
	private   Short cssEngine;
	/**
	 * [css_key]钥匙状态
	 */
	
	private   Short cssKey;
	/**
	 * [css_gear]档位0:空挡 1:1挡 2:2挡 3:3挡 4:4挡 5:5挡 6:6挡 7:7挡 8:8挡 9:9挡 10:10挡 11:11挡 12:12挡 13:倒挡 14:自动D挡 15:停车P挡
	 */
	
	private   Short cssGear;
	/**
	 * [css_light]车灯状态
	 */
	
	private   Integer cssLight;
	/**
	 * [css_lock]车锁状态
	 */
	
	private   Integer cssLock;
	/**
	 * [css_net_type]网络类型0:GSM 1:3G/4G 2:CDMA
	 */
	
	private   Short cssNetType;
	/**
	 * [css_base_lac]LAC
	 */
	
	private   Integer cssBaseLac;
	/**
	 * [css_base_ci]CI
	 */
	
	private   Integer cssBaseCi;
	/**
	 * [css_order]订单号
	 */
	
	private   Long cssOrder;
	/**
	 * [css_mo_data]报文数据
	 */
	
	private   String cssMoData;
	/**
	 * [css_te_no]终端信息
	 */
	
	private   String cssTeNo;
	/**
	 * [css_autopilot]自动驾驶状态
	 */
	
	private   Integer cssAutopilot;
	/**
	 * [css_handbrake]手刹状态0:所有刹车释放 1:所有刹车应用 2:所有刹车不工作（应用或释放中） 3:未知
	 */
	
	private   Integer cssHandbrake;
	
	//默认构造函数
	public CsState(){
	
	}
	
	//主键构造函数
	public CsState(Integer id){
		this.cssId = id;
	}
	
	//设置非空字段
	public CsState setNotNull(Integer cssId,Short cssAccess,Short cssHost,String cssNumber,Date cssAddTime,BigDecimal cssObdMile,Integer cssMotor,BigDecimal cssOil,Integer cssPower,BigDecimal cssFuelMileage,Short cssGpsValid,Short cssGpsCn,Short cssGpsCount,Short cssEngine,Short cssKey,Short cssGear,Integer cssLight,Integer cssLock){
		this.cssId=cssId;
		this.cssAccess=cssAccess;
		this.cssHost=cssHost;
		this.cssNumber=cssNumber;
		this.cssAddTime=cssAddTime;
		this.cssObdMile=cssObdMile;
		this.cssMotor=cssMotor;
		this.cssOil=cssOil;
		this.cssPower=cssPower;
		this.cssFuelMileage=cssFuelMileage;
		this.cssGpsValid=cssGpsValid;
		this.cssGpsCn=cssGpsCn;
		this.cssGpsCount=cssGpsCount;
		this.cssEngine=cssEngine;
		this.cssKey=cssKey;
		this.cssGear=cssGear;
		this.cssLight=cssLight;
		this.cssLock=cssLock;
		return this;
	}
	
	public Object getCssAccessText(){
		return resolve("cssAccessText");
	}
	public Object getCssNumberText(){
		return resolve("cssNumberText");
	}
	public Object getCssCarText(){
		return resolve("cssCarText");
	}
	public Object getCssChargingText(){
		return resolve("cssChargingText");
	}
	public Object getCssGpsValidText(){
		return resolve("cssGpsValidText");
	}
	public Object getCssCircularText(){
		return resolve("cssCircularText");
	}
	public Object getCssPtcText(){
		return resolve("cssPtcText");
	}
	public Object getCssCompresText(){
		return resolve("cssCompresText");
	}
	public Object getCssFanText(){
		return resolve("cssFanText");
	}
	public Object getCssSavingText(){
		return resolve("cssSavingText");
	}
	public Object getCssEngineText(){
		return resolve("cssEngineText");
	}
	public Object getCssGearText(){
		return resolve("cssGearText");
	}
	public Object getCssNetTypeText(){
		return resolve("cssNetTypeText");
	}
	public Object getCssHandbrakeText(){
		return resolve("cssHandbrakeText");
	}
	
	@Transient
	Map<String, Resolver<CsState>> resolvers = new HashMap<String, Resolver<CsState>>();
	
	public void registResolver(Resolver<CsState> resolver){
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
	* 编号 [非空]      
	**/
	public Integer getCssId(){
		return this.cssId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setCssId(Integer cssId){
		this.cssId = cssId;
	}
	/*******************************接入商**********************************/	
	/**
	* 接入商 [非空]      
	**/
	public Short getCssAccess(){
		return this.cssAccess;
	}
	
	/**
	* 接入商 [非空]     
	**/
	public void setCssAccess(Short cssAccess){
		this.cssAccess = cssAccess;
	}
	/*******************************子域**********************************/	
	/**
	* 子域 [非空]      
	**/
	public Short getCssHost(){
		return this.cssHost;
	}
	
	/**
	* 子域 [非空]     
	**/
	public void setCssHost(Short cssHost){
		this.cssHost = cssHost;
	}
	/*******************************车机号**********************************/	
	/**
	* 车机号 [非空]      
	**/
	public String getCssNumber(){
		return this.cssNumber;
	}
	
	/**
	* 车机号 [非空]     
	**/
	public void setCssNumber(String cssNumber){
		this.cssNumber = cssNumber;
	}
	/*******************************车辆**********************************/	
	/**
	* 车辆 [可空]      
	**/
	public Integer getCssCar(){
		return this.cssCar;
	}
	
	/**
	* 车辆 [可空]     
	**/
	public void setCssCar(Integer cssCar){
		this.cssCar = cssCar;
	}
	/*******************************接收时间**********************************/	
	/**
	* 接收时间 [非空]      
	**/
	public Date getCssAddTime(){
		return this.cssAddTime;
	}
	
	/**
	* 接收时间 [非空]     
	**/
	public void setCssAddTime(Date cssAddTime){
		this.cssAddTime = cssAddTime;
	}
	/*******************************报文时间**********************************/	
	/**
	* 报文时间 [可空]      
	**/
	public Date getCssCurrentTime(){
		return this.cssCurrentTime;
	}
	
	/**
	* 报文时间 [可空]     
	**/
	public void setCssCurrentTime(Date cssCurrentTime){
		this.cssCurrentTime = cssCurrentTime;
	}
	/*******************************租赁状态**********************************/	
	/**
	* 租赁状态 [可空]      
	**/
	public String getCssRented(){
		return this.cssRented;
	}
	
	/**
	* 租赁状态 [可空]     
	**/
	public void setCssRented(String cssRented){
		this.cssRented = cssRented;
	}
	/*******************************报警码**********************************/	
	/**
	* 报警码 [可空]      
	**/
	public Integer getCssWarn(){
		return this.cssWarn;
	}
	
	/**
	* 报警码 [可空]     
	**/
	public void setCssWarn(Integer cssWarn){
		this.cssWarn = cssWarn;
	}
	/*******************************RFID卡号**********************************/	
	/**
	* RFID卡号 [可空]      
	**/
	public String getCssRfid(){
		return this.cssRfid;
	}
	
	/**
	* RFID卡号 [可空]     
	**/
	public void setCssRfid(String cssRfid){
		this.cssRfid = cssRfid;
	}
	/*******************************用户RFID**********************************/	
	/**
	* 用户RFID [可空]      
	**/
	public String getCssRfidDte(){
		return this.cssRfidDte;
	}
	
	/**
	* 用户RFID [可空]     
	**/
	public void setCssRfidDte(String cssRfidDte){
		this.cssRfidDte = cssRfidDte;
	}
	/*******************************累计里程**********************************/	
	/**
	* 累计里程 [非空]      
	**/
	public BigDecimal getCssObdMile(){
		return this.cssObdMile;
	}
	
	/**
	* 累计里程 [非空]     
	**/
	public void setCssObdMile(BigDecimal cssObdMile){
		this.cssObdMile = cssObdMile;
	}
	/*******************************发动机温度**********************************/	
	/**
	* 发动机温度 [可空]      
	**/
	public BigDecimal getCssEngineT(){
		return this.cssEngineT;
	}
	
	/**
	* 发动机温度 [可空]     
	**/
	public void setCssEngineT(BigDecimal cssEngineT){
		this.cssEngineT = cssEngineT;
	}
	/*******************************订单总里程**********************************/	
	/**
	* 订单总里程 [可空]      
	**/
	public BigDecimal getCssMileage(){
		return this.cssMileage;
	}
	
	/**
	* 订单总里程 [可空]     
	**/
	public void setCssMileage(BigDecimal cssMileage){
		this.cssMileage = cssMileage;
	}
	/*******************************车速**********************************/	
	/**
	* 车速 [可空]      
	**/
	public BigDecimal getCssSpeed(){
		return this.cssSpeed;
	}
	
	/**
	* 车速 [可空]     
	**/
	public void setCssSpeed(BigDecimal cssSpeed){
		this.cssSpeed = cssSpeed;
	}
	/*******************************转速**********************************/	
	/**
	* 转速 [非空]      
	**/
	public Integer getCssMotor(){
		return this.cssMotor;
	}
	
	/**
	* 转速 [非空]     
	**/
	public void setCssMotor(Integer cssMotor){
		this.cssMotor = cssMotor;
	}
	/*******************************燃油量**********************************/	
	/**
	* 燃油量 [非空]      
	**/
	public BigDecimal getCssOil(){
		return this.cssOil;
	}
	
	/**
	* 燃油量 [非空]     
	**/
	public void setCssOil(BigDecimal cssOil){
		this.cssOil = cssOil;
	}
	/*******************************小电瓶电量**********************************/	
	/**
	* 小电瓶电量 [非空]      
	**/
	public Integer getCssPower(){
		return this.cssPower;
	}
	
	/**
	* 小电瓶电量 [非空]     
	**/
	public void setCssPower(Integer cssPower){
		this.cssPower = cssPower;
	}
	/*******************************SOC**********************************/	
	/**
	* SOC [可空]      
	**/
	public Short getCssEvBattery(){
		return this.cssEvBattery;
	}
	
	/**
	* SOC [可空]     
	**/
	public void setCssEvBattery(Short cssEvBattery){
		this.cssEvBattery = cssEvBattery;
	}
	/*******************************充电状态**********************************/	
	/**
	* 充电状态 [可空]      
	**/
	public Short getCssCharging(){
		return this.cssCharging;
	}
	
	/**
	* 充电状态 [可空]     
	**/
	public void setCssCharging(Short cssCharging){
		this.cssCharging = cssCharging;
	}
	/*******************************订单油里程**********************************/	
	/**
	* 订单油里程 [非空]      
	**/
	public BigDecimal getCssFuelMileage(){
		return this.cssFuelMileage;
	}
	
	/**
	* 订单油里程 [非空]     
	**/
	public void setCssFuelMileage(BigDecimal cssFuelMileage){
		this.cssFuelMileage = cssFuelMileage;
	}
	/*******************************订单电里程**********************************/	
	/**
	* 订单电里程 [可空]      
	**/
	public BigDecimal getCssElectricMileage(){
		return this.cssElectricMileage;
	}
	
	/**
	* 订单电里程 [可空]     
	**/
	public void setCssElectricMileage(BigDecimal cssElectricMileage){
		this.cssElectricMileage = cssElectricMileage;
	}
	/*******************************续航里程**********************************/	
	/**
	* 续航里程 [可空]      
	**/
	public BigDecimal getCssEndurance(){
		return this.cssEndurance;
	}
	
	/**
	* 续航里程 [可空]     
	**/
	public void setCssEndurance(BigDecimal cssEndurance){
		this.cssEndurance = cssEndurance;
	}
	/*******************************温度**********************************/	
	/**
	* 温度 [可空]      
	**/
	public BigDecimal getCssTemperature(){
		return this.cssTemperature;
	}
	
	/**
	* 温度 [可空]     
	**/
	public void setCssTemperature(BigDecimal cssTemperature){
		this.cssTemperature = cssTemperature;
	}
	/*******************************CSQ**********************************/	
	/**
	* CSQ [可空]      
	**/
	public Short getCssCsq(){
		return this.cssCsq;
	}
	
	/**
	* CSQ [可空]     
	**/
	public void setCssCsq(Short cssCsq){
		this.cssCsq = cssCsq;
	}
	/*******************************经度**********************************/	
	/**
	* 经度 [可空]      
	**/
	public BigDecimal getCssLongitude(){
		return this.cssLongitude;
	}
	
	/**
	* 经度 [可空]     
	**/
	public void setCssLongitude(BigDecimal cssLongitude){
		this.cssLongitude = cssLongitude;
	}
	/*******************************纬度**********************************/	
	/**
	* 纬度 [可空]      
	**/
	public BigDecimal getCssLatitude(){
		return this.cssLatitude;
	}
	
	/**
	* 纬度 [可空]     
	**/
	public void setCssLatitude(BigDecimal cssLatitude){
		this.cssLatitude = cssLatitude;
	}
	/*******************************GPS有效性**********************************/	
	/**
	* GPS有效性 [非空]      
	**/
	public Short getCssGpsValid(){
		return this.cssGpsValid;
	}
	
	/**
	* GPS有效性 [非空]     
	**/
	public void setCssGpsValid(Short cssGpsValid){
		this.cssGpsValid = cssGpsValid;
	}
	/*******************************GPS强度**********************************/	
	/**
	* GPS强度 [非空]      
	**/
	public Short getCssGpsCn(){
		return this.cssGpsCn;
	}
	
	/**
	* GPS强度 [非空]     
	**/
	public void setCssGpsCn(Short cssGpsCn){
		this.cssGpsCn = cssGpsCn;
	}
	/*******************************GPS卫星数**********************************/	
	/**
	* GPS卫星数 [非空]      
	**/
	public Short getCssGpsCount(){
		return this.cssGpsCount;
	}
	
	/**
	* GPS卫星数 [非空]     
	**/
	public void setCssGpsCount(Short cssGpsCount){
		this.cssGpsCount = cssGpsCount;
	}
	/*******************************方向角**********************************/	
	/**
	* 方向角 [可空]      
	**/
	public BigDecimal getCssDir(){
		return this.cssDir;
	}
	
	/**
	* 方向角 [可空]     
	**/
	public void setCssDir(BigDecimal cssDir){
		this.cssDir = cssDir;
	}
	/*******************************循环模式**********************************/	
	/**
	* 循环模式 [可空]      
	**/
	public Short getCssCircular(){
		return this.cssCircular;
	}
	
	/**
	* 循环模式 [可空]     
	**/
	public void setCssCircular(Short cssCircular){
		this.cssCircular = cssCircular;
	}
	/*******************************PTC启停**********************************/	
	/**
	* PTC启停 [可空]      
	**/
	public Short getCssPtc(){
		return this.cssPtc;
	}
	
	/**
	* PTC启停 [可空]     
	**/
	public void setCssPtc(Short cssPtc){
		this.cssPtc = cssPtc;
	}
	/*******************************压缩机**********************************/	
	/**
	* 压缩机 [可空]      
	**/
	public Short getCssCompres(){
		return this.cssCompres;
	}
	
	/**
	* 压缩机 [可空]     
	**/
	public void setCssCompres(Short cssCompres){
		this.cssCompres = cssCompres;
	}
	/*******************************档风量**********************************/	
	/**
	* 档风量 [可空]      
	**/
	public Short getCssFan(){
		return this.cssFan;
	}
	
	/**
	* 档风量 [可空]     
	**/
	public void setCssFan(Short cssFan){
		this.cssFan = cssFan;
	}
	/*******************************功耗模式**********************************/	
	/**
	* 功耗模式 [可空]      
	**/
	public Short getCssSaving(){
		return this.cssSaving;
	}
	
	/**
	* 功耗模式 [可空]     
	**/
	public void setCssSaving(Short cssSaving){
		this.cssSaving = cssSaving;
	}
	/*******************************车门状态**********************************/	
	/**
	* 车门状态 [可空]      
	**/
	public String getCssDoor(){
		return this.cssDoor;
	}
	
	/**
	* 车门状态 [可空]     
	**/
	public void setCssDoor(String cssDoor){
		this.cssDoor = cssDoor;
	}
	/*******************************发动机状态**********************************/	
	/**
	* 发动机状态 [非空]      
	**/
	public Short getCssEngine(){
		return this.cssEngine;
	}
	
	/**
	* 发动机状态 [非空]     
	**/
	public void setCssEngine(Short cssEngine){
		this.cssEngine = cssEngine;
	}
	/*******************************钥匙状态**********************************/	
	/**
	* 钥匙状态 [非空]      
	**/
	public Short getCssKey(){
		return this.cssKey;
	}
	
	/**
	* 钥匙状态 [非空]     
	**/
	public void setCssKey(Short cssKey){
		this.cssKey = cssKey;
	}
	/*******************************档位**********************************/	
	/**
	* 档位 [非空]      
	**/
	public Short getCssGear(){
		return this.cssGear;
	}
	
	/**
	* 档位 [非空]     
	**/
	public void setCssGear(Short cssGear){
		this.cssGear = cssGear;
	}
	/*******************************车灯状态**********************************/	
	/**
	* 车灯状态 [非空]      
	**/
	public Integer getCssLight(){
		return this.cssLight;
	}
	
	/**
	* 车灯状态 [非空]     
	**/
	public void setCssLight(Integer cssLight){
		this.cssLight = cssLight;
	}
	/*******************************车锁状态**********************************/	
	/**
	* 车锁状态 [非空]      
	**/
	public Integer getCssLock(){
		return this.cssLock;
	}
	
	/**
	* 车锁状态 [非空]     
	**/
	public void setCssLock(Integer cssLock){
		this.cssLock = cssLock;
	}
	/*******************************网络类型**********************************/	
	/**
	* 网络类型 [可空]      
	**/
	public Short getCssNetType(){
		return this.cssNetType;
	}
	
	/**
	* 网络类型 [可空]     
	**/
	public void setCssNetType(Short cssNetType){
		this.cssNetType = cssNetType;
	}
	/*******************************LAC**********************************/	
	/**
	* LAC [可空]      
	**/
	public Integer getCssBaseLac(){
		return this.cssBaseLac;
	}
	
	/**
	* LAC [可空]     
	**/
	public void setCssBaseLac(Integer cssBaseLac){
		this.cssBaseLac = cssBaseLac;
	}
	/*******************************CI**********************************/	
	/**
	* CI [可空]      
	**/
	public Integer getCssBaseCi(){
		return this.cssBaseCi;
	}
	
	/**
	* CI [可空]     
	**/
	public void setCssBaseCi(Integer cssBaseCi){
		this.cssBaseCi = cssBaseCi;
	}
	/*******************************订单号**********************************/	
	/**
	* 订单号 [可空]      
	**/
	public Long getCssOrder(){
		return this.cssOrder;
	}
	
	/**
	* 订单号 [可空]     
	**/
	public void setCssOrder(Long cssOrder){
		this.cssOrder = cssOrder;
	}
	/*******************************报文数据**********************************/	
	/**
	* 报文数据 [可空]      
	**/
	public String getCssMoData(){
		return this.cssMoData;
	}
	
	/**
	* 报文数据 [可空]     
	**/
	public void setCssMoData(String cssMoData){
		this.cssMoData = cssMoData;
	}
	/*******************************终端信息**********************************/	
	/**
	* 终端信息 [可空]      
	**/
	public String getCssTeNo(){
		return this.cssTeNo;
	}
	
	/**
	* 终端信息 [可空]     
	**/
	public void setCssTeNo(String cssTeNo){
		this.cssTeNo = cssTeNo;
	}
	/*******************************自动驾驶状态**********************************/	
	/**
	* 自动驾驶状态 [可空]      
	**/
	public Integer getCssAutopilot(){
		return this.cssAutopilot;
	}
	
	/**
	* 自动驾驶状态 [可空]     
	**/
	public void setCssAutopilot(Integer cssAutopilot){
		this.cssAutopilot = cssAutopilot;
	}
	/*******************************手刹状态**********************************/	
	/**
	* 手刹状态 [可空]      
	**/
	public Integer getCssHandbrake(){
		return this.cssHandbrake;
	}
	
	/**
	* 手刹状态 [可空]     
	**/
	public void setCssHandbrake(Integer cssHandbrake){
		this.cssHandbrake = cssHandbrake;
	}
}