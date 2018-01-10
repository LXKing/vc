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
 * 用户管理
 * @author Joel
 */
public class SrvUser implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [su_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer suId;
	/**
	 * [su_host]编号
	 */
	
	private   String suHost;
	/**
	 * [su_group]所属组
	 */
	
	private   Long suGroup;
	/**
	 * [su_username]登录账号
	 */
	
	private   String suUsername;
	/**
	 * [su_password]登录密码
	 */
	
	private   String suPassword;
	/**
	 * [su_real_name]真实姓名
	 */
	
	private   String suRealName;
	/**
	 * [su_mobile]手机号码
	 */
	
	private   String suMobile;
	/**
	 * [su_shortcut]快捷方式
	 */
	
	private   String suShortcut;
	/**
	 * [su_add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date suAddTime;
	/**
	 * [su_last_time]最后登录时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date suLastTime;
	/**
	 * [su_last_ip]最后登录IP
	 */
	
	private   String suLastIp;
	/**
	 * [su_status]状态
	 */
	
	private   Short suStatus;
	
	//默认构造函数
	public SrvUser(){
	
	}
	
	//主键构造函数
	public SrvUser(Integer id){
		this.suId = id;
	}
	
	//设置非空字段
	public SrvUser setNotNull(Integer suId,Long suGroup,String suUsername,String suPassword,String suRealName,Short suStatus){
		this.suId=suId;
		this.suGroup=suGroup;
		this.suUsername=suUsername;
		this.suPassword=suPassword;
		this.suRealName=suRealName;
		this.suStatus=suStatus;
		return this;
	}
	
	
	@Transient
	Map<String, Resolver<SrvUser>> resolvers = new HashMap<String, Resolver<SrvUser>>();
	
	public void registResolver(Resolver<SrvUser> resolver){
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
	public Integer getSuId(){
		return this.suId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setSuId(Integer suId){
		this.suId = suId;
	}
	/*******************************编号**********************************/	
	/**
	* 编号 [可空]      
	**/
	public String getSuHost(){
		return this.suHost;
	}
	
	/**
	* 编号 [可空]     
	**/
	public void setSuHost(String suHost){
		this.suHost = suHost;
	}
	/*******************************所属组**********************************/	
	/**
	* 所属组 [非空]      
	**/
	public Long getSuGroup(){
		return this.suGroup;
	}
	
	/**
	* 所属组 [非空]     
	**/
	public void setSuGroup(Long suGroup){
		this.suGroup = suGroup;
	}
	/*******************************登录账号**********************************/	
	/**
	* 登录账号 [非空]      
	**/
	public String getSuUsername(){
		return this.suUsername;
	}
	
	/**
	* 登录账号 [非空]     
	**/
	public void setSuUsername(String suUsername){
		this.suUsername = suUsername;
	}
	/*******************************登录密码**********************************/	
	/**
	* 登录密码 [非空]      
	**/
	public String getSuPassword(){
		return this.suPassword;
	}
	
	/**
	* 登录密码 [非空]     
	**/
	public void setSuPassword(String suPassword){
		this.suPassword = suPassword;
	}
	/*******************************真实姓名**********************************/	
	/**
	* 真实姓名 [非空]      
	**/
	public String getSuRealName(){
		return this.suRealName;
	}
	
	/**
	* 真实姓名 [非空]     
	**/
	public void setSuRealName(String suRealName){
		this.suRealName = suRealName;
	}
	/*******************************手机号码**********************************/	
	/**
	* 手机号码 [可空]      
	**/
	public String getSuMobile(){
		return this.suMobile;
	}
	
	/**
	* 手机号码 [可空]     
	**/
	public void setSuMobile(String suMobile){
		this.suMobile = suMobile;
	}
	/*******************************快捷方式**********************************/	
	/**
	* 快捷方式 [可空]      
	**/
	public String getSuShortcut(){
		return this.suShortcut;
	}
	
	/**
	* 快捷方式 [可空]     
	**/
	public void setSuShortcut(String suShortcut){
		this.suShortcut = suShortcut;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [可空]      
	**/
	public Date getSuAddTime(){
		return this.suAddTime;
	}
	
	/**
	* 添加时间 [可空]     
	**/
	public void setSuAddTime(Date suAddTime){
		this.suAddTime = suAddTime;
	}
	/*******************************最后登录时间**********************************/	
	/**
	* 最后登录时间 [可空]      
	**/
	public Date getSuLastTime(){
		return this.suLastTime;
	}
	
	/**
	* 最后登录时间 [可空]     
	**/
	public void setSuLastTime(Date suLastTime){
		this.suLastTime = suLastTime;
	}
	/*******************************最后登录IP**********************************/	
	/**
	* 最后登录IP [可空]      
	**/
	public String getSuLastIp(){
		return this.suLastIp;
	}
	
	/**
	* 最后登录IP [可空]     
	**/
	public void setSuLastIp(String suLastIp){
		this.suLastIp = suLastIp;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getSuStatus(){
		return this.suStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setSuStatus(Short suStatus){
		this.suStatus = suStatus;
	}
}