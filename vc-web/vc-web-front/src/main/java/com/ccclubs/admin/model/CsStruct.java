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
 * 控制指令管理
 * @author Joel
 */
public class CsStruct implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [css_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long cssId;
	/**
	 * [css_name]指令名称
	 */
	
	private   String cssName;
	/**
	 * [css_type]命令类型0:一般命令 1:高级命令
	 */
	
	private   Short cssType;
	/**
	 * [css_req_code]请求示例
	 */
	
	private   String cssReqCode;
	/**
	 * [css_request]请求结构
	 */
	
	private   String cssRequest;
	/**
	 * [css_rep_code]响应示例
	 */
	
	private   String cssRepCode;
	/**
	 * [css_response]响应结构
	 */
	
	private   String cssResponse;
	/**
	 * [css_status]状态
	 */
	
	private   Short cssStatus;
	
	//默认构造函数
	public CsStruct(){
	
	}
	
	//主键构造函数
	public CsStruct(Long id){
		this.cssId = id;
	}
	
	//设置非空字段
	public CsStruct setNotNull(Long cssId,String cssName,Short cssType,Short cssStatus){
		this.cssId=cssId;
		this.cssName=cssName;
		this.cssType=cssType;
		this.cssStatus=cssStatus;
		return this;
	}
	
	public Object getCssTypeText(){
		return resolve("cssTypeText");
	}
	public Object getCssStatusText(){
		return resolve("cssStatusText");
	}
	
	@Transient
	Map<String, Resolver<CsStruct>> resolvers = new HashMap<String, Resolver<CsStruct>>();
	
	public void registResolver(Resolver<CsStruct> resolver){
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
	public Long getCssId(){
		return this.cssId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setCssId(Long cssId){
		this.cssId = cssId;
	}
	/*******************************指令名称**********************************/	
	/**
	* 指令名称 [非空]      
	**/
	public String getCssName(){
		return this.cssName;
	}
	
	/**
	* 指令名称 [非空]     
	**/
	public void setCssName(String cssName){
		this.cssName = cssName;
	}
	/*******************************命令类型**********************************/	
	/**
	* 命令类型 [非空]      
	**/
	public Short getCssType(){
		return this.cssType;
	}
	
	/**
	* 命令类型 [非空]     
	**/
	public void setCssType(Short cssType){
		this.cssType = cssType;
	}
	/*******************************请求示例**********************************/	
	/**
	* 请求示例 [可空]      
	**/
	public String getCssReqCode(){
		return this.cssReqCode;
	}
	
	/**
	* 请求示例 [可空]     
	**/
	public void setCssReqCode(String cssReqCode){
		this.cssReqCode = cssReqCode;
	}
	/*******************************请求结构**********************************/	
	/**
	* 请求结构 [可空]      
	**/
	public String getCssRequest(){
		return this.cssRequest;
	}
	
	/**
	* 请求结构 [可空]     
	**/
	public void setCssRequest(String cssRequest){
		this.cssRequest = cssRequest;
	}
	/*******************************响应示例**********************************/	
	/**
	* 响应示例 [可空]      
	**/
	public String getCssRepCode(){
		return this.cssRepCode;
	}
	
	/**
	* 响应示例 [可空]     
	**/
	public void setCssRepCode(String cssRepCode){
		this.cssRepCode = cssRepCode;
	}
	/*******************************响应结构**********************************/	
	/**
	* 响应结构 [可空]      
	**/
	public String getCssResponse(){
		return this.cssResponse;
	}
	
	/**
	* 响应结构 [可空]     
	**/
	public void setCssResponse(String cssResponse){
		this.cssResponse = cssResponse;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getCssStatus(){
		return this.cssStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setCssStatus(Short cssStatus){
		this.cssStatus = cssStatus;
	}
}