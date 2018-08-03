package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * 车机升级管理
 * @author Joel
 */
public class VerUpManage implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [status_upgrade]升级状态0:无升级 1:升级中 2:升级失败 3:升级成功
	 */
	
	private   Integer statusUpgrade;
	/**
	 * [ver_cur_id]当前版本
	 */
	
	private   Integer verCurId;
	/**
	 * [model_id]车型
	 */
	
	private   Integer modelId;
	/**
	 * [vehicle_id]车辆VIN码
	 */
	
	private   Integer vehicleId;
	
	//默认构造函数
	public VerUpManage(){
	
	}
	
	//主键构造函数
	public VerUpManage(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public VerUpManage setNotNull(Integer id, Integer statusUpgrade, Integer verCurId, Integer modelId, Integer vehicleId){
		this.id=id;
		this.statusUpgrade=statusUpgrade;
		this.verCurId=verCurId;
		this.modelId=modelId;
		this.vehicleId=vehicleId;
		return this;
	}
	
	public Object getStatusUpgradeText(){
		return resolve("statusUpgradeText");
	}
	public Object getVerCurIdText(){
		return resolve("verCurIdText");
	}
	public Object getModelIdText(){
		return resolve("modelIdText");
	}
	public Object getVehicleIdText(){
		return resolve("vehicleIdText");
	}
	
	@Transient
	Map<String, Resolver<VerUpManage>> resolvers = new HashMap<String, Resolver<VerUpManage>>();
	
	public void registResolver(Resolver<VerUpManage> resolver){
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
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************升级状态**********************************/	
	/**
	* 升级状态 [非空]      
	**/
	public Integer getStatusUpgrade(){
		return this.statusUpgrade;
	}
	
	/**
	* 升级状态 [非空]     
	**/
	public void setStatusUpgrade(Integer statusUpgrade){
		this.statusUpgrade = statusUpgrade;
	}
	/*******************************当前版本**********************************/	
	/**
	* 当前版本 [非空]      
	**/
	public Integer getVerCurId(){
		return this.verCurId;
	}
	
	/**
	* 当前版本 [非空]     
	**/
	public void setVerCurId(Integer verCurId){
		this.verCurId = verCurId;
	}
	/*******************************车型**********************************/	
	/**
	* 车型 [非空]      
	**/
	public Integer getModelId(){
		return this.modelId;
	}
	
	/**
	* 车型 [非空]     
	**/
	public void setModelId(Integer modelId){
		this.modelId = modelId;
	}
	/*******************************车辆VIN码**********************************/	
	/**
	* 车辆VIN码 [非空]      
	**/
	public Integer getVehicleId(){
		return this.vehicleId;
	}
	
	/**
	* 车辆VIN码 [非空]     
	**/
	public void setVehicleId(Integer vehicleId){
		this.vehicleId = vehicleId;
	}
}