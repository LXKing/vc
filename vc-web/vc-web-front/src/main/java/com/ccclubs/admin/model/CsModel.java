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
 * 接入车型管理
 * @author Joel
 */
public class CsModel implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [csm_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer csmId;
	/**
	 * [csm_name]车型名称
	 */
	
	private   String csmName;
	/**
	 * [csm_flag]车型标识
	 */
	
	private   String csmFlag;
	/**
	 * [csm_type]动力类型
	 */
	
	private   Short csmType;
	/**
	 * [csm_file]变速箱类型
	 */
	
	private   Short csmFile;
	/**
	 * [csm_catagory]车辆种类
	 */
	
	private   Short csmCatagory;
	/**
	 * [csm_tank_capacity]油箱容量(L)
	 */
	
	private   Double csmTankCapacity;
	/**
	 * [csm_battery_capacity]电池容量(KW.H)
	 */
	
	private   Double csmBatteryCapacity;
	/**
	 * [csm_status]状态
	 */
	
	private   Short csmStatus;
	/**
	 * [csm_add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date csmAddTime;
	/**
	 * [csm_update_time]修改时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date csmUpdateTime;
	
	//默认构造函数
	public CsModel(){
	
	}
	
	//主键构造函数
	public CsModel(Integer id){
		this.csmId = id;
	}
	
	//设置非空字段
	public CsModel setNotNull(Integer csmId,String csmName,Short csmStatus,Date csmAddTime,Date csmUpdateTime){
		this.csmId=csmId;
		this.csmName=csmName;
		this.csmStatus=csmStatus;
		this.csmAddTime=csmAddTime;
		this.csmUpdateTime=csmUpdateTime;
		return this;
	}
	
	public Object getCsmTypeText(){
		return resolve("csmTypeText");
	}
	public Object getCsmFileText(){
		return resolve("csmFileText");
	}
	public Object getCsmCatagoryText(){
		return resolve("csmCatagoryText");
	}
	public Object getCsmStatusText(){
		return resolve("csmStatusText");
	}
	
	@Transient
	Map<String, Resolver<CsModel>> resolvers = new HashMap<String, Resolver<CsModel>>();
	
	public void registResolver(Resolver<CsModel> resolver){
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
	public Integer getCsmId(){
		return this.csmId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setCsmId(Integer csmId){
		this.csmId = csmId;
	}
	/*******************************车型名称**********************************/	
	/**
	* 车型名称 [非空]      
	**/
	public String getCsmName(){
		return this.csmName;
	}
	
	/**
	* 车型名称 [非空]     
	**/
	public void setCsmName(String csmName){
		this.csmName = csmName;
	}
	/*******************************车型标识**********************************/	
	/**
	* 车型标识 [可空]      
	**/
	public String getCsmFlag(){
		return this.csmFlag;
	}
	
	/**
	* 车型标识 [可空]     
	**/
	public void setCsmFlag(String csmFlag){
		this.csmFlag = csmFlag;
	}
	/*******************************动力类型**********************************/	
	/**
	* 动力类型 [可空]      
	**/
	public Short getCsmType(){
		return this.csmType;
	}
	
	/**
	* 动力类型 [可空]     
	**/
	public void setCsmType(Short csmType){
		this.csmType = csmType;
	}
	/*******************************变速箱类型**********************************/	
	/**
	* 变速箱类型 [可空]      
	**/
	public Short getCsmFile(){
		return this.csmFile;
	}
	
	/**
	* 变速箱类型 [可空]     
	**/
	public void setCsmFile(Short csmFile){
		this.csmFile = csmFile;
	}
	/*******************************车辆种类**********************************/	
	/**
	* 车辆种类 [可空]      
	**/
	public Short getCsmCatagory(){
		return this.csmCatagory;
	}
	
	/**
	* 车辆种类 [可空]     
	**/
	public void setCsmCatagory(Short csmCatagory){
		this.csmCatagory = csmCatagory;
	}
	/*******************************油箱容量(L)**********************************/	
	/**
	* 油箱容量(L) [可空]      
	**/
	public Double getCsmTankCapacity(){
		return this.csmTankCapacity;
	}
	
	/**
	* 油箱容量(L) [可空]     
	**/
	public void setCsmTankCapacity(Double csmTankCapacity){
		this.csmTankCapacity = csmTankCapacity;
	}
	/*******************************电池容量(KW.H)**********************************/	
	/**
	* 电池容量(KW.H) [可空]      
	**/
	public Double getCsmBatteryCapacity(){
		return this.csmBatteryCapacity;
	}
	
	/**
	* 电池容量(KW.H) [可空]     
	**/
	public void setCsmBatteryCapacity(Double csmBatteryCapacity){
		this.csmBatteryCapacity = csmBatteryCapacity;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getCsmStatus(){
		return this.csmStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setCsmStatus(Short csmStatus){
		this.csmStatus = csmStatus;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [非空]      
	**/
	public Date getCsmAddTime(){
		return this.csmAddTime;
	}
	
	/**
	* 添加时间 [非空]     
	**/
	public void setCsmAddTime(Date csmAddTime){
		this.csmAddTime = csmAddTime;
	}
	/*******************************修改时间**********************************/	
	/**
	* 修改时间 [非空]      
	**/
	public Date getCsmUpdateTime(){
		return this.csmUpdateTime;
	}
	
	/**
	* 修改时间 [非空]     
	**/
	public void setCsmUpdateTime(Date csmUpdateTime){
		this.csmUpdateTime = csmUpdateTime;
	}
}