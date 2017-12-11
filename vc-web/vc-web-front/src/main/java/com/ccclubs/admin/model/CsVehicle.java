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
 * 车辆信息管理
 * @author Joel
 */
public class CsVehicle implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [csv_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer csvId;
	/**
	 * [csv_access]接入商
	 */
	
	private   Integer csvAccess;
	/**
	 * [csv_car_no]车牌号
	 */
	
	private   String csvCarNo;
	/**
	 * [csv_vin]车架号
	 */
	
	private   String csvVin;
	/**
	 * [csv_engine_no]发动机(电机)编号
	 */
	
	private   String csvEngineNo;
	/**
	 * [csv_certific]合格证号
	 */
	
	private   String csvCertific;
	/**
	 * [csv_model]车型
	 */
	
	private   Integer csvModel;
	/**
	 * [csv_machine]车机设备
	 */
	
	private   Integer csvMachine;
	/**
	 * [csv_color_code]车身颜色
	 */
	
	private   Short csvColorCode;
	/**
	 * [csv_bataccu_code]可充电储能系统编码
	 */
	
	private   String csvBataccuCode;
	/**
	 * [csv_prod_date]出厂日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd") @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private   Date csvProdDate;
	/**
	 * [csv_landmark]地标类型
	 */
	
	private   String csvLandmark;
	/**
	 * [csv_domain]车辆领域0:未知 1:个人领域 2:公共领域
	 */
	
	private   Short csvDomain;
	/**
	 * [csv_model_code_full]车型代码
	 */
	
	private   String csvModelCodeFull;
	/**
	 * [csv_model_code_simple]车型备案号
	 */
	
	private   String csvModelCodeSimple;
	/**
	 * [csv_interior_color_code]内饰颜色
	 */
	
	private   String csvInteriorColorCode;
	/**
	 * [csv_status]状态
	 */
	
	private   Short csvStatus;
	/**
	 * [csv_add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date csvAddTime;
	/**
	 * [csv_update_time]修改时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date csvUpdateTime;
	
	//默认构造函数
	public CsVehicle(){
	
	}
	
	//主键构造函数
	public CsVehicle(Integer id){
		this.csvId = id;
	}
	
	//设置非空字段
	public CsVehicle setNotNull(Integer csvId,Integer csvAccess,String csvVin,Integer csvModel,Short csvStatus,Date csvAddTime,Date csvUpdateTime){
		this.csvId=csvId;
		this.csvAccess=csvAccess;
		this.csvVin=csvVin;
		this.csvModel=csvModel;
		this.csvStatus=csvStatus;
		this.csvAddTime=csvAddTime;
		this.csvUpdateTime=csvUpdateTime;
		return this;
	}
	
	public Object getCsvAccessText(){
		return resolve("csvAccessText");
	}
	public Object getCsvModelText(){
		return resolve("csvModelText");
	}
	public Object getCsvMachineText(){
		return resolve("csvMachineText");
	}
	public Object getCsvColorCodeText(){
		return resolve("csvColorCodeText");
	}
	public Object getCsvLandmarkText(){
		return resolve("csvLandmarkText");
	}
	public Object getCsvDomainText(){
		return resolve("csvDomainText");
	}
	public Object getCsvStatusText(){
		return resolve("csvStatusText");
	}
	
	@Transient
	Map<String, Resolver<CsVehicle>> resolvers = new HashMap<String, Resolver<CsVehicle>>();
	
	public void registResolver(Resolver<CsVehicle> resolver){
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
	public Integer getCsvId(){
		return this.csvId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setCsvId(Integer csvId){
		this.csvId = csvId;
	}
	/*******************************接入商**********************************/	
	/**
	* 接入商 [非空]      
	**/
	public Integer getCsvAccess(){
		return this.csvAccess;
	}
	
	/**
	* 接入商 [非空]     
	**/
	public void setCsvAccess(Integer csvAccess){
		this.csvAccess = csvAccess;
	}
	/*******************************车牌号**********************************/	
	/**
	* 车牌号 [可空]      
	**/
	public String getCsvCarNo(){
		return this.csvCarNo;
	}
	
	/**
	* 车牌号 [可空]     
	**/
	public void setCsvCarNo(String csvCarNo){
		this.csvCarNo = csvCarNo;
	}
	/*******************************车架号**********************************/	
	/**
	* 车架号 [非空]      
	**/
	public String getCsvVin(){
		return this.csvVin;
	}
	
	/**
	* 车架号 [非空]     
	**/
	public void setCsvVin(String csvVin){
		this.csvVin = csvVin;
	}
	/*******************************发动机(电机)编号**********************************/	
	/**
	* 发动机(电机)编号 [可空]      
	**/
	public String getCsvEngineNo(){
		return this.csvEngineNo;
	}
	
	/**
	* 发动机(电机)编号 [可空]     
	**/
	public void setCsvEngineNo(String csvEngineNo){
		this.csvEngineNo = csvEngineNo;
	}
	/*******************************合格证号**********************************/	
	/**
	* 合格证号 [可空]      
	**/
	public String getCsvCertific(){
		return this.csvCertific;
	}
	
	/**
	* 合格证号 [可空]     
	**/
	public void setCsvCertific(String csvCertific){
		this.csvCertific = csvCertific;
	}
	/*******************************车型**********************************/	
	/**
	* 车型 [非空]      
	**/
	public Integer getCsvModel(){
		return this.csvModel;
	}
	
	/**
	* 车型 [非空]     
	**/
	public void setCsvModel(Integer csvModel){
		this.csvModel = csvModel;
	}
	/*******************************车机设备**********************************/	
	/**
	* 车机设备 [可空]      
	**/
	public Integer getCsvMachine(){
		return this.csvMachine;
	}
	
	/**
	* 车机设备 [可空]     
	**/
	public void setCsvMachine(Integer csvMachine){
		this.csvMachine = csvMachine;
	}
	/*******************************车身颜色**********************************/	
	/**
	* 车身颜色 [可空]      
	**/
	public Short getCsvColorCode(){
		return this.csvColorCode;
	}
	
	/**
	* 车身颜色 [可空]     
	**/
	public void setCsvColorCode(Short csvColorCode){
		this.csvColorCode = csvColorCode;
	}
	/*******************************可充电储能系统编码**********************************/	
	/**
	* 可充电储能系统编码 [可空]      
	**/
	public String getCsvBataccuCode(){
		return this.csvBataccuCode;
	}
	
	/**
	* 可充电储能系统编码 [可空]     
	**/
	public void setCsvBataccuCode(String csvBataccuCode){
		this.csvBataccuCode = csvBataccuCode;
	}
	/*******************************出厂日期**********************************/	
	/**
	* 出厂日期 [可空]      
	**/
	public Date getCsvProdDate(){
		return this.csvProdDate;
	}
	
	/**
	* 出厂日期 [可空]     
	**/
	public void setCsvProdDate(Date csvProdDate){
		this.csvProdDate = csvProdDate;
	}
	/*******************************地标类型**********************************/	
	/**
	* 地标类型 [可空]      
	**/
	public String getCsvLandmark(){
		return this.csvLandmark;
	}
	
	/**
	* 地标类型 [可空]     
	**/
	public void setCsvLandmark(String csvLandmark){
		this.csvLandmark = csvLandmark;
	}
	/*******************************车辆领域**********************************/	
	/**
	* 车辆领域 [可空]      
	**/
	public Short getCsvDomain(){
		return this.csvDomain;
	}
	
	/**
	* 车辆领域 [可空]     
	**/
	public void setCsvDomain(Short csvDomain){
		this.csvDomain = csvDomain;
	}
	/*******************************车型代码**********************************/	
	/**
	* 车型代码 [可空]      
	**/
	public String getCsvModelCodeFull(){
		return this.csvModelCodeFull;
	}
	
	/**
	* 车型代码 [可空]     
	**/
	public void setCsvModelCodeFull(String csvModelCodeFull){
		this.csvModelCodeFull = csvModelCodeFull;
	}
	/*******************************车型备案号**********************************/	
	/**
	* 车型备案号 [可空]      
	**/
	public String getCsvModelCodeSimple(){
		return this.csvModelCodeSimple;
	}
	
	/**
	* 车型备案号 [可空]     
	**/
	public void setCsvModelCodeSimple(String csvModelCodeSimple){
		this.csvModelCodeSimple = csvModelCodeSimple;
	}
	/*******************************内饰颜色**********************************/	
	/**
	* 内饰颜色 [可空]      
	**/
	public String getCsvInteriorColorCode(){
		return this.csvInteriorColorCode;
	}
	
	/**
	* 内饰颜色 [可空]     
	**/
	public void setCsvInteriorColorCode(String csvInteriorColorCode){
		this.csvInteriorColorCode = csvInteriorColorCode;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getCsvStatus(){
		return this.csvStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setCsvStatus(Short csvStatus){
		this.csvStatus = csvStatus;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [非空]      
	**/
	public Date getCsvAddTime(){
		return this.csvAddTime;
	}
	
	/**
	* 添加时间 [非空]     
	**/
	public void setCsvAddTime(Date csvAddTime){
		this.csvAddTime = csvAddTime;
	}
	/*******************************修改时间**********************************/	
	/**
	* 修改时间 [非空]      
	**/
	public Date getCsvUpdateTime(){
		return this.csvUpdateTime;
	}
	
	/**
	* 修改时间 [非空]     
	**/
	public void setCsvUpdateTime(Date csvUpdateTime){
		this.csvUpdateTime = csvUpdateTime;
	}
}