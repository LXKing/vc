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
 * 角色组管理
 * @author Joel
 */
public class SrvGroup implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [sg_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer sgId;
	/**
	 * [sg_name]角色组名称
	 */
	
	private   String sgName;
	/**
	 * [sg_parent]上级组
	 */
	
	private   Long sgParent;
	/**
	 * [sg_family]序列号
	 */
	
	private   String sgFamily;
	/**
	 * [sg_user]负责人
	 */
	
	private   Long sgUser;
	/**
	 * [sg_flag]组标识
	 */
	
	private   String sgFlag;
	/**
	 * [sg_status]状态
	 */
	
	private   Short sgStatus;
	
	//默认构造函数
	public SrvGroup(){
	
	}
	
	//主键构造函数
	public SrvGroup(Integer id){
		this.sgId = id;
	}
	
	//设置非空字段
	public SrvGroup setNotNull(Integer sgId,String sgName,Long sgParent,Short sgStatus){
		this.sgId=sgId;
		this.sgName=sgName;
		this.sgParent=sgParent;
		this.sgStatus=sgStatus;
		return this;
	}
	
	public Object getSgStatusText(){
		return resolve("sgStatusText");
	}
	
	@Transient
	Map<String, Resolver<SrvGroup>> resolvers = new HashMap<String, Resolver<SrvGroup>>();
	
	public void registResolver(Resolver<SrvGroup> resolver){
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
	public Integer getSgId(){
		return this.sgId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setSgId(Integer sgId){
		this.sgId = sgId;
	}
	/*******************************角色组名称**********************************/	
	/**
	* 角色组名称 [非空]      
	**/
	public String getSgName(){
		return this.sgName;
	}
	
	/**
	* 角色组名称 [非空]     
	**/
	public void setSgName(String sgName){
		this.sgName = sgName;
	}
	/*******************************上级组**********************************/	
	/**
	* 上级组 [非空]      
	**/
	public Long getSgParent(){
		return this.sgParent;
	}
	
	/**
	* 上级组 [非空]     
	**/
	public void setSgParent(Long sgParent){
		this.sgParent = sgParent;
	}
	/*******************************序列号**********************************/	
	/**
	* 序列号 [可空]      
	**/
	public String getSgFamily(){
		return this.sgFamily;
	}
	
	/**
	* 序列号 [可空]     
	**/
	public void setSgFamily(String sgFamily){
		this.sgFamily = sgFamily;
	}
	/*******************************负责人**********************************/	
	/**
	* 负责人 [可空]      
	**/
	public Long getSgUser(){
		return this.sgUser;
	}
	
	/**
	* 负责人 [可空]     
	**/
	public void setSgUser(Long sgUser){
		this.sgUser = sgUser;
	}
	/*******************************组标识**********************************/	
	/**
	* 组标识 [可空]      
	**/
	public String getSgFlag(){
		return this.sgFlag;
	}
	
	/**
	* 组标识 [可空]     
	**/
	public void setSgFlag(String sgFlag){
		this.sgFlag = sgFlag;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getSgStatus(){
		return this.sgStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setSgStatus(Short sgStatus){
		this.sgStatus = sgStatus;
	}
}