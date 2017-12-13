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
 * 车辆CAN历史数据
 * @author Joel
 */
public class HistoryCan implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [car_can_history_id]ID
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long carCanHistoryId;
	/**
	 * [cs_number]车机号
	 */
	
	private   String csNumber;
	/**
	 * [can_data]车辆can数据
	 */
	
	private   String canData;
	/**
	 * [add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date addTime;
	/**
	 * [current_time]下位机时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date currentTime;
	
	//默认构造函数
	public HistoryCan(){
	
	}
	
	//主键构造函数
	public HistoryCan(Long id){
		this.carCanHistoryId = id;
	}
	
	//设置非空字段
	public HistoryCan setNotNull(String csNumber,String canData,Date addTime,Date currentTime){
		this.csNumber=csNumber;
		this.canData=canData;
		this.addTime=addTime;
		this.currentTime=currentTime;
		return this;
	}
	
	
	@Transient
	Map<String, Resolver<HistoryCan>> resolvers = new HashMap<String, Resolver<HistoryCan>>();
	
	public void registResolver(Resolver<HistoryCan> resolver){
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
	public Long getCarCanHistoryId(){
		return this.carCanHistoryId;
	}
	
	/**
	* ID [可空]     
	**/
	public void setCarCanHistoryId(Long carCanHistoryId){
		this.carCanHistoryId = carCanHistoryId;
	}
	/*******************************车机号**********************************/	
	/**
	* 车机号 [非空]      
	**/
	public String getCsNumber(){
		return this.csNumber;
	}
	
	/**
	* 车机号 [非空]     
	**/
	public void setCsNumber(String csNumber){
		this.csNumber = csNumber;
	}
	/*******************************车辆can数据**********************************/	
	/**
	* 车辆can数据 [非空]      
	**/
	public String getCanData(){
		return this.canData;
	}
	
	/**
	* 车辆can数据 [非空]     
	**/
	public void setCanData(String canData){
		this.canData = canData;
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
	/*******************************下位机时间**********************************/	
	/**
	* 下位机时间 [非空]      
	**/
	public Date getCurrentTime(){
		return this.currentTime;
	}
	
	/**
	* 下位机时间 [非空]     
	**/
	public void setCurrentTime(Date currentTime){
		this.currentTime = currentTime;
	}
}