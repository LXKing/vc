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
 * 主机厂用户车型管理
 * @author Joel
 */
public class CsModelMapping implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [user_id]主机厂用户
	 */
	
	private   Integer userId;
	/**
	 * [model_id]车型
	 */
	
	private   Integer modelId;
	/**
	 * [remark]备注
	 */
	
	private   String remark;
	/**
	 * [add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date addTime;
	/**
	 * [update_time]更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date updateTime;
	
	//默认构造函数
	public CsModelMapping(){
	
	}
	
	//主键构造函数
	public CsModelMapping(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public CsModelMapping setNotNull(Integer id,Integer userId,Integer modelId,Date addTime){
		this.id=id;
		this.userId=userId;
		this.modelId=modelId;
		this.addTime=addTime;
		return this;
	}
	
	public Object getUserIdText(){
		return resolve("userIdText");
	}
	public Object getModelIdText(){
		return resolve("modelIdText");
	}
	
	@Transient
	Map<String, Resolver<CsModelMapping>> resolvers = new HashMap<String, Resolver<CsModelMapping>>();
	
	public void registResolver(Resolver<CsModelMapping> resolver){
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
	/*******************************主机厂用户**********************************/	
	/**
	* 主机厂用户 [非空]      
	**/
	public Integer getUserId(){
		return this.userId;
	}
	
	/**
	* 主机厂用户 [非空]     
	**/
	public void setUserId(Integer userId){
		this.userId = userId;
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
	/*******************************备注**********************************/	
	/**
	* 备注 [可空]      
	**/
	public String getremark(){
		return this.remark;
	}
	
	/**
	* 备注 [可空]     
	**/
	public void setremark(String remark){
		this.remark = remark;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [非空]      
	**/
	public Date getAddTime(){
		return this.addTime;
	}
	
	/**
	* 添加时间 [非空]     
	**/
	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}
	/*******************************更新时间**********************************/	
	/**
	* 更新时间 [可空]      
	**/
	public Date getUpdateTime(){
		return this.updateTime;
	}
	
	/**
	* 更新时间 [可空]     
	**/
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
}