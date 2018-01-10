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
 * 车辆实时CAN信息
 * @author Joel
 */
public class CsCan implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [csc_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long cscId;
	/**
	 * [csc_access]接入商
	 */
	
	private   Integer cscAccess;
	/**
	 * [csc_number]车机号
	 */
	
	private   String cscNumber;
	/**
	 * [csc_car]车辆
	 */
	
	private   Integer cscCar;
	/**
	 * [csc_model]适配车型
	 */
	
	private   Short cscModel;
	/**
	 * [csc_type]CAN类型1:11bit 2:29bit
	 */
	
	private   Short cscType;
	/**
	 * [csc_order]订单号
	 */
	
	private   Long cscOrder;
	/**
	 * [csc_data]报文数据
	 */
	
	private   String cscData;
	/**
	 * [csc_upload_time]报文时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cscUploadTime;
	/**
	 * [csc_add_time]接收时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cscAddTime;
	/**
	 * [csc_status]状态
	 */
	
	private   Short cscStatus;
	
	//默认构造函数
	public CsCan(){
	
	}
	
	//主键构造函数
	public CsCan(Long id){
		this.cscId = id;
	}
	
	//设置非空字段
	public CsCan setNotNull(Long cscId,Integer cscAccess,String cscNumber,Date cscUploadTime,Date cscAddTime){
		this.cscId=cscId;
		this.cscAccess=cscAccess;
		this.cscNumber=cscNumber;
		this.cscUploadTime=cscUploadTime;
		this.cscAddTime=cscAddTime;
		return this;
	}
	
	public Object getCscAccessText(){
		return resolve("cscAccessText");
	}
	public Object getCscNumberText(){
		return resolve("cscNumberText");
	}
	public Object getCscCarText(){
		return resolve("cscCarText");
	}
	public Object getCscTypeText(){
		return resolve("cscTypeText");
	}
	
	@Transient
	Map<String, Resolver<CsCan>> resolvers = new HashMap<String, Resolver<CsCan>>();
	
	public void registResolver(Resolver<CsCan> resolver){
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
	public Long getCscId(){
		return this.cscId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setCscId(Long cscId){
		this.cscId = cscId;
	}
	/*******************************接入商**********************************/	
	/**
	* 接入商 [非空]      
	**/
	public Integer getCscAccess(){
		return this.cscAccess;
	}
	
	/**
	* 接入商 [非空]     
	**/
	public void setCscAccess(Integer cscAccess){
		this.cscAccess = cscAccess;
	}
	/*******************************车机号**********************************/	
	/**
	* 车机号 [非空]      
	**/
	public String getCscNumber(){
		return this.cscNumber;
	}
	
	/**
	* 车机号 [非空]     
	**/
	public void setCscNumber(String cscNumber){
		this.cscNumber = cscNumber;
	}
	/*******************************车辆**********************************/	
	/**
	* 车辆 [可空]      
	**/
	public Integer getCscCar(){
		return this.cscCar;
	}
	
	/**
	* 车辆 [可空]     
	**/
	public void setCscCar(Integer cscCar){
		this.cscCar = cscCar;
	}
	/*******************************适配车型**********************************/	
	/**
	* 适配车型 [可空]      
	**/
	public Short getCscModel(){
		return this.cscModel;
	}
	
	/**
	* 适配车型 [可空]     
	**/
	public void setCscModel(Short cscModel){
		this.cscModel = cscModel;
	}
	/*******************************CAN类型**********************************/	
	/**
	* CAN类型 [可空]      
	**/
	public Short getCscType(){
		return this.cscType;
	}
	
	/**
	* CAN类型 [可空]     
	**/
	public void setCscType(Short cscType){
		this.cscType = cscType;
	}
	/*******************************订单号**********************************/	
	/**
	* 订单号 [可空]      
	**/
	public Long getCscOrder(){
		return this.cscOrder;
	}
	
	/**
	* 订单号 [可空]     
	**/
	public void setCscOrder(Long cscOrder){
		this.cscOrder = cscOrder;
	}
	/*******************************报文数据**********************************/	
	/**
	* 报文数据 [可空]      
	**/
	public String getCscData(){
		return this.cscData;
	}
	
	/**
	* 报文数据 [可空]     
	**/
	public void setCscData(String cscData){
		this.cscData = cscData;
	}
	/*******************************报文时间**********************************/	
	/**
	* 报文时间 [非空]      
	**/
	public Date getCscUploadTime(){
		return this.cscUploadTime;
	}
	
	/**
	* 报文时间 [非空]     
	**/
	public void setCscUploadTime(Date cscUploadTime){
		this.cscUploadTime = cscUploadTime;
	}
	/*******************************接收时间**********************************/	
	/**
	* 接收时间 [非空]      
	**/
	public Date getCscAddTime(){
		return this.cscAddTime;
	}
	
	/**
	* 接收时间 [非空]     
	**/
	public void setCscAddTime(Date cscAddTime){
		this.cscAddTime = cscAddTime;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [可空]      
	**/
	public Short getCscStatus(){
		return this.cscStatus;
	}
	
	/**
	* 状态 [可空]     
	**/
	public void setCscStatus(Short cscStatus){
		this.cscStatus = cscStatus;
	}
}