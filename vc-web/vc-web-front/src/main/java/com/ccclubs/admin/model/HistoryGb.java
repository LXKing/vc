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
 * 车辆国标历史数据
 * @author Joel
 */
public class HistoryGb implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [car_gb_history_id]ID
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long carGbHistoryId;
	/**
	 * [cs_vin]车辆vin码
	 */
	
	private   String csVin;
	/**
	 * [cs_access]授权系统
	 */
	
	private   Integer csAccess;
	/**
	 * [add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date addTime;
	/**
	 * [current_time]报文上传时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date currentTime;
	/**
	 * [cs_protocol]协议类型0:国标 1:地标
	 */
	
	private   Integer csProtocol;
	/**
	 * [gb_data]报文内容
	 */
	
	private   String gbData;
	/**
	 * [gb_type]报文类型0:未知 1:车辆登入 2:实时上报 3:补发上报 4:车辆登出 5:平台登入 6:平台登出 7:心跳 8:终端校时
	 */
	
	private   Integer gbType;
	/**
	 * [cs_verify]校验结果1:成功 0:失败
	 */
	
	private   Integer csVerify;


	
	//默认构造函数
	public HistoryGb(){
	
	}
	
	//主键构造函数
	public HistoryGb(Long id){
		this.carGbHistoryId = id;
	}
	
	//设置非空字段
	public HistoryGb setNotNull(String csVin,Integer csAccess,Date addTime,Date currentTime,Integer csProtocol,String gbData,Integer gbType,Integer csVerify){
		this.csVin=csVin;
		this.csAccess=csAccess;
		this.addTime=addTime;
		this.currentTime=currentTime;
		this.csProtocol=csProtocol;
		this.gbData=gbData;
		this.gbType=gbType;
		this.csVerify=csVerify;
		return this;
	}
	
	public Object getCsAccessText(){
		return resolve("csAccessText");
	}
	public Object getCsProtocolText(){
		return resolve("csProtocolText");
	}
	public Object getGbTypeText(){
		return resolve("gbTypeText");
	}
	public Object getCsVerifyText(){
		return resolve("csVerifyText");
	}
	
	@Transient
	Map<String, Resolver<HistoryGb>> resolvers = new HashMap<String, Resolver<HistoryGb>>();
	
	public void registResolver(Resolver<HistoryGb> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************ID**********************************/	
	/**
	* ID [可空]      
	**/
	public Long getCarGbHistoryId(){
		return this.carGbHistoryId;
	}
	
	/**
	* ID [可空]     
	**/
	public void setCarGbHistoryId(Long carGbHistoryId){
		this.carGbHistoryId = carGbHistoryId;
	}
	/*******************************车辆vin码**********************************/	
	/**
	* 车辆vin码 [非空]      
	**/
	public String getCsVin(){
		return this.csVin;
	}
	
	/**
	* 车辆vin码 [非空]     
	**/
	public void setCsVin(String csVin){
		this.csVin = csVin;
	}
	/*******************************授权系统**********************************/	
	/**
	* 授权系统 [非空]      
	**/
	public Integer getCsAccess(){
		return this.csAccess;
	}
	
	/**
	* 授权系统 [非空]     
	**/
	public void setCsAccess(Integer csAccess){
		this.csAccess = csAccess;
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
	/*******************************报文上传时间**********************************/	
	/**
	* 报文上传时间 [非空]      
	**/
	public Date getCurrentTime(){
		return this.currentTime;
	}
	
	/**
	* 报文上传时间 [非空]     
	**/
	public void setCurrentTime(Date currentTime){
		this.currentTime = currentTime;
	}
	/*******************************协议类型**********************************/	
	/**
	* 协议类型 [非空]      
	**/
	public Integer getCsProtocol(){
		return this.csProtocol;
	}
	
	/**
	* 协议类型 [非空]     
	**/
	public void setCsProtocol(Integer csProtocol){
		this.csProtocol = csProtocol;
	}
	/*******************************报文内容**********************************/	
	/**
	* 报文内容 [非空]      
	**/
	public String getGbData(){
		return this.gbData;
	}
	
	/**
	* 报文内容 [非空]     
	**/
	public void setGbData(String gbData){
		this.gbData = gbData;
	}
	/*******************************报文类型**********************************/	
	/**
	* 报文类型 [非空]      
	**/
	public Integer getGbType(){
		return this.gbType;
	}
	
	/**
	* 报文类型 [非空]     
	**/
	public void setGbType(Integer gbType){
		this.gbType = gbType;
	}
	/*******************************校验结果**********************************/	
	/**
	* 校验结果 [非空]      
	**/
	public Integer getCsVerify(){
		return this.csVerify;
	}
	
	/**
	* 校验结果 [非空]     
	**/
	public void setCsVerify(Integer csVerify){
		this.csVerify = csVerify;
	}
}