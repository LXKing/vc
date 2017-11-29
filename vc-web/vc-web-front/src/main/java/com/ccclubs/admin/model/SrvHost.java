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
 * 接入商信息管理
 * @author Joel
 */
public class SrvHost implements java.io.Serializable
{
	private static final long serialVersionUID =         1l;
	/**
	 * [sh_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer shId;
	/**
	 * [sh_name]接入商
	 */
	
	private   String shName;
	/**
	 * [sh_key]接入KEY
	 */
	
	private   String shKey;
	/**
	 * [sh_topic]转发Topic
	 */
	
	private   String shTopic;
	/**
	 * [sh_add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date shAddTime;
	/**
	 * [sh_upt_time]更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date shUptTime;
	/**
	 * [sh_status]状态
	 */
	
	private   Short shStatus;
	/**
	 * [sh_appid]接入ID
	 */
	
	private   String shAppid;
	
	//默认构造函数
	public SrvHost(){
	
	}
	
	//主键构造函数
	public SrvHost(Integer id){
		this.shId = id;
	}
	
	//设置非空字段
	public SrvHost setNotNull(Integer shId,String shName,String shKey,String shTopic,Date shAddTime,Date shUptTime,Short shStatus){
		this.shId=shId;
		this.shName=shName;
		this.shKey=shKey;
		this.shTopic=shTopic;
		this.shAddTime=shAddTime;
		this.shUptTime=shUptTime;
		this.shStatus=shStatus;
		return this;
	}
	
	public Object getShStatusText(){
		return resolve("shStatusText");
	}
	
	@Transient
	Map<String, Resolver<SrvHost>> resolvers = new HashMap<String, Resolver<SrvHost>>();
	
	public void registResolver(Resolver<SrvHost> resolver){
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
	public Integer getShId(){
		return this.shId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setShId(Integer shId){
		this.shId = shId;
	}
	/*******************************接入商**********************************/	
	/**
	* 接入商 [非空]      
	**/
	public String getShName(){
		return this.shName;
	}
	
	/**
	* 接入商 [非空]     
	**/
	public void setShName(String shName){
		this.shName = shName;
	}
	/*******************************接入KEY**********************************/	
	/**
	* 接入KEY [非空]      
	**/
	public String getShKey(){
		return this.shKey;
	}
	
	/**
	* 接入KEY [非空]     
	**/
	public void setShKey(String shKey){
		this.shKey = shKey;
	}
	/*******************************转发Topic**********************************/	
	/**
	* 转发Topic [非空]      
	**/
	public String getShTopic(){
		return this.shTopic;
	}
	
	/**
	* 转发Topic [非空]     
	**/
	public void setShTopic(String shTopic){
		this.shTopic = shTopic;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [非空]      
	**/
	public Date getShAddTime(){
		return this.shAddTime;
	}
	
	/**
	* 添加时间 [非空]     
	**/
	public void setShAddTime(Date shAddTime){
		this.shAddTime = shAddTime;
	}
	/*******************************更新时间**********************************/	
	/**
	* 更新时间 [非空]      
	**/
	public Date getShUptTime(){
		return this.shUptTime;
	}
	
	/**
	* 更新时间 [非空]     
	**/
	public void setShUptTime(Date shUptTime){
		this.shUptTime = shUptTime;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getShStatus(){
		return this.shStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setShStatus(Short shStatus){
		this.shStatus = shStatus;
	}
	/*******************************接入ID**********************************/	
	/**
	* 接入ID [可空]      
	**/
	public String getShAppid(){
		return this.shAppid;
	}
	
	/**
	* 接入ID [可空]     
	**/
	public void setShAppid(String shAppid){
		this.shAppid = shAppid;
	}
}