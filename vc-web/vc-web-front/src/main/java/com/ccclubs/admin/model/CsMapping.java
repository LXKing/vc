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
 * 车管关系
 * @author Joel
 */
public class CsMapping implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [csm_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer csmId;
	/**
	 * [csm_car]车辆
	 */
	
	private   Integer csmCar;
	/**
	 * [csm_manage]管理员
	 */
	
	private   Integer csmManage;
	
	//默认构造函数
	public CsMapping(){
	
	}
	
	//主键构造函数
	public CsMapping(Integer id){
		this.csmId = id;
	}
	
	//设置非空字段
	public CsMapping setNotNull(Integer csmCar,Integer csmManage){
		this.csmCar=csmCar;
		this.csmManage=csmManage;
		return this;
	}
	
	
	@Transient
	Map<String, Resolver<CsMapping>> resolvers = new HashMap<String, Resolver<CsMapping>>();
	
	public void registResolver(Resolver<CsMapping> resolver){
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
	public Integer getCsmId(){
		return this.csmId;
	}
	
	/**
	* 编号 [可空]     
	**/
	public void setCsmId(Integer csmId){
		this.csmId = csmId;
	}
	/*******************************车辆**********************************/	
	/**
	* 车辆 [非空]      
	**/
	public Integer getCsmCar(){
		return this.csmCar;
	}
	
	/**
	* 车辆 [非空]     
	**/
	public void setCsmCar(Integer csmCar){
		this.csmCar = csmCar;
	}
	/*******************************管理员**********************************/	
	/**
	* 管理员 [非空]      
	**/
	public Integer getCsmManage(){
		return this.csmManage;
	}
	
	/**
	* 管理员 [非空]     
	**/
	public void setCsmManage(Integer csmManage){
		this.csmManage = csmManage;
	}
}