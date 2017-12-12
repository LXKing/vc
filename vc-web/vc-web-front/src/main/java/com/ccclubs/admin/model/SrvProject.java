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
 * 项目菜单管理
 * @author Joel
 */
public class SrvProject implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [sp_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long spId;
	/**
	 * [sp_name]项目名称
	 */
	
	private   String spName;
	/**
	 * [sp_parent_id]父节点
	 */
	
	private   Long spParentId;
	/**
	 * [sp_flag]标识
	 */
	
	private   String spFlag;
	/**
	 * [sp_family]家族
	 */
	
	private   String spFamily;
	/**
	 * [sp_url]项目地址
	 */
	
	private   String spUrl;
	/**
	 * [sp_logo]Logo
	 */
	
	private   String spLogo;
	/**
	 * [sp_descript]项目描述
	 */
	
	private   String spDescript;
	/**
	 * [sp_level]优先级:
	 */
	
	private   Integer spLevel;
	/**
	 * [sp_limit_exp]扩展权限
	 */
	
	private   String spLimitExp;
	/**
	 * [sp_group]项目分组
	 */
	
	private   String spGroup;
	/**
	 * [sp_mind]流程信息
	 */
	
	private   String spMind;
	/**
	 * [sp_status]状态
	 */
	
	private   Short spStatus;
	
	//默认构造函数
	public SrvProject(){
	
	}
	
	//主键构造函数
	public SrvProject(Long id){
		this.spId = id;
	}
	
	//设置非空字段
	public SrvProject setNotNull(Long spId,String spName,Long spParentId,String spUrl,Short spStatus){
		this.spId=spId;
		this.spName=spName;
		this.spParentId=spParentId;
		this.spUrl=spUrl;
		this.spStatus=spStatus;
		return this;
	}
	
	public Object getSpStatusText(){
		return resolve("spStatusText");
	}
	
	@Transient
	Map<String, Resolver<SrvProject>> resolvers = new HashMap<String, Resolver<SrvProject>>();
	
	public void registResolver(Resolver<SrvProject> resolver){
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
	public Long getSpId(){
		return this.spId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setSpId(Long spId){
		this.spId = spId;
	}
	/*******************************项目名称**********************************/	
	/**
	* 项目名称 [非空]      
	**/
	public String getSpName(){
		return this.spName;
	}
	
	/**
	* 项目名称 [非空]     
	**/
	public void setSpName(String spName){
		this.spName = spName;
	}
	/*******************************父节点**********************************/	
	/**
	* 父节点 [非空]      
	**/
	public Long getSpParentId(){
		return this.spParentId;
	}
	
	/**
	* 父节点 [非空]     
	**/
	public void setSpParentId(Long spParentId){
		this.spParentId = spParentId;
	}
	/*******************************标识**********************************/	
	/**
	* 标识 [可空]      
	**/
	public String getSpFlag(){
		return this.spFlag;
	}
	
	/**
	* 标识 [可空]     
	**/
	public void setSpFlag(String spFlag){
		this.spFlag = spFlag;
	}
	/*******************************家族**********************************/	
	/**
	* 家族 [可空]      
	**/
	public String getSpFamily(){
		return this.spFamily;
	}
	
	/**
	* 家族 [可空]     
	**/
	public void setSpFamily(String spFamily){
		this.spFamily = spFamily;
	}
	/*******************************项目地址**********************************/	
	/**
	* 项目地址 [非空]      
	**/
	public String getSpUrl(){
		return this.spUrl;
	}
	
	/**
	* 项目地址 [非空]     
	**/
	public void setSpUrl(String spUrl){
		this.spUrl = spUrl;
	}
	/*******************************Logo**********************************/	
	/**
	* Logo [可空]      
	**/
	public String getSpLogo(){
		return this.spLogo;
	}
	
	/**
	* Logo [可空]     
	**/
	public void setSpLogo(String spLogo){
		this.spLogo = spLogo;
	}
	/*******************************项目描述**********************************/	
	/**
	* 项目描述 [可空]      
	**/
	public String getSpDescript(){
		return this.spDescript;
	}
	
	/**
	* 项目描述 [可空]     
	**/
	public void setSpDescript(String spDescript){
		this.spDescript = spDescript;
	}
	/*******************************优先级:**********************************/	
	/**
	* 优先级: [可空]      
	**/
	public Integer getSpLevel(){
		return this.spLevel;
	}
	
	/**
	* 优先级: [可空]     
	**/
	public void setSpLevel(Integer spLevel){
		this.spLevel = spLevel;
	}
	/*******************************扩展权限**********************************/	
	/**
	* 扩展权限 [可空]      
	**/
	public String getSpLimitExp(){
		return this.spLimitExp;
	}
	
	/**
	* 扩展权限 [可空]     
	**/
	public void setSpLimitExp(String spLimitExp){
		this.spLimitExp = spLimitExp;
	}
	/*******************************项目分组**********************************/	
	/**
	* 项目分组 [可空]      
	**/
	public String getSpGroup(){
		return this.spGroup;
	}
	
	/**
	* 项目分组 [可空]     
	**/
	public void setSpGroup(String spGroup){
		this.spGroup = spGroup;
	}
	/*******************************流程信息**********************************/	
	/**
	* 流程信息 [可空]      
	**/
	public String getSpMind(){
		return this.spMind;
	}
	
	/**
	* 流程信息 [可空]     
	**/
	public void setSpMind(String spMind){
		this.spMind = spMind;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getSpStatus(){
		return this.spStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setSpStatus(Short spStatus){
		this.spStatus = spStatus;
	}
}