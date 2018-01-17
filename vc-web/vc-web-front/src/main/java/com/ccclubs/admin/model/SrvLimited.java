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
 * 权限配置管理
 * @author Joel
 */
public class SrvLimited implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [sl_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer slId;
	/**
	 * [sl_project]项目ID
	 */
	
	private   Long slProject;
	/**
	 * [sl_user]关联用户
	 */
	
	private   Long slUser;
	/**
	 * [sl_group]角色组
	 */
	
	private   Long slGroup;
	/**
	 * [sl_limit]权限值0:无效 1:有效
	 */
	
	private   Integer slLimit;
	
	//默认构造函数
	public SrvLimited(){
	
	}
	
	//主键构造函数
	public SrvLimited(Integer id){
		this.slId = id;
	}
	
	//设置非空字段
	public SrvLimited setNotNull(Integer slId,Long slProject,Integer slLimit){
		this.slId=slId;
		this.slProject=slProject;
		this.slLimit=slLimit;
		return this;
	}
	
	public Object getSlLimitText(){
		return resolve("slLimitText");
	}
	
	@Transient
	Map<String, Resolver<SrvLimited>> resolvers = new HashMap<String, Resolver<SrvLimited>>();
	
	public void registResolver(Resolver<SrvLimited> resolver){
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
	public Integer getSlId(){
		return this.slId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setSlId(Integer slId){
		this.slId = slId;
	}
	/*******************************项目ID**********************************/	
	/**
	* 项目ID [非空]      
	**/
	public Long getSlProject(){
		return this.slProject;
	}
	
	/**
	* 项目ID [非空]     
	**/
	public void setSlProject(Long slProject){
		this.slProject = slProject;
	}
	/*******************************关联用户**********************************/	
	/**
	* 关联用户 [可空]      
	**/
	public Long getSlUser(){
		return this.slUser;
	}
	
	/**
	* 关联用户 [可空]     
	**/
	public void setSlUser(Long slUser){
		this.slUser = slUser;
	}
	/*******************************角色组**********************************/	
	/**
	* 角色组 [可空]      
	**/
	public Long getSlGroup(){
		return this.slGroup;
	}
	
	/**
	* 角色组 [可空]     
	**/
	public void setSlGroup(Long slGroup){
		this.slGroup = slGroup;
	}
	/*******************************权限值**********************************/	
	/**
	* 权限值 [非空]      
	**/
	public Integer getSlLimit(){
		return this.slLimit;
	}
	
	/**
	* 权限值 [非空]     
	**/
	public void setSlLimit(Integer slLimit){
		this.slLimit = slLimit;
	}
}