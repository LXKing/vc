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
 * TBox注册信息
 * @author Joel
 */
public class CsTerminal implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [cst_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long cstId;
	/**
	 * [cst_idd]序列号
	 */
	
	private   String cstIdd;
	/**
	 * [cst_model]型号
	 */
	
	private   String cstModel;
	/**
	 * [cst_made]制造商
	 */
	
	private   String cstMade;
	/**
	 * [cst_province]省域
	 */
	
	private   String cstProvince;
	/**
	 * [cst_city]市县域
	 */
	
	private   String cstCity;
	/**
	 * [cst_color]车牌颜色
	 */
	
	private   Short cstColor;
	/**
	 * [cst_number]车辆标识
	 */
	
	private   String cstNumber;
	/**
	 * [cst_mobile]SIM
	 */
	
	private   String cstMobile;
	/**
	 * [cst_update_time]更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cstUpdateTime;
	/**
	 * [cst_add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cstAddTime;
	/**
	 * [cst_status]状态0:无效 1:有效 3:未授权
	 */
	
	private   Short cstStatus;
	
	//默认构造函数
	public CsTerminal(){
	
	}
	
	//主键构造函数
	public CsTerminal(Long id){
		this.cstId = id;
	}
	
	//设置非空字段
	public CsTerminal setNotNull(Long cstId,String cstIdd,Date cstUpdateTime,Date cstAddTime,Short cstStatus){
		this.cstId=cstId;
		this.cstIdd=cstIdd;
		this.cstUpdateTime=cstUpdateTime;
		this.cstAddTime=cstAddTime;
		this.cstStatus=cstStatus;
		return this;
	}
	
	public Object getCstStatusText(){
		return resolve("cstStatusText");
	}
	
	@Transient
	Map<String, Resolver<CsTerminal>> resolvers = new HashMap<String, Resolver<CsTerminal>>();
	
	public void registResolver(Resolver<CsTerminal> resolver){
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
	public Long getCstId(){
		return this.cstId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setCstId(Long cstId){
		this.cstId = cstId;
	}
	/*******************************序列号**********************************/	
	/**
	* 序列号 [非空]      
	**/
	public String getCstIdd(){
		return this.cstIdd;
	}
	
	/**
	* 序列号 [非空]     
	**/
	public void setCstIdd(String cstIdd){
		this.cstIdd = cstIdd;
	}
	/*******************************型号**********************************/	
	/**
	* 型号 [可空]      
	**/
	public String getCstModel(){
		return this.cstModel;
	}
	
	/**
	* 型号 [可空]     
	**/
	public void setCstModel(String cstModel){
		this.cstModel = cstModel;
	}
	/*******************************制造商**********************************/	
	/**
	* 制造商 [可空]      
	**/
	public String getCstMade(){
		return this.cstMade;
	}
	
	/**
	* 制造商 [可空]     
	**/
	public void setCstMade(String cstMade){
		this.cstMade = cstMade;
	}
	/*******************************省域**********************************/	
	/**
	* 省域 [可空]      
	**/
	public String getCstProvince(){
		return this.cstProvince;
	}
	
	/**
	* 省域 [可空]     
	**/
	public void setCstProvince(String cstProvince){
		this.cstProvince = cstProvince;
	}
	/*******************************市县域**********************************/	
	/**
	* 市县域 [可空]      
	**/
	public String getCstCity(){
		return this.cstCity;
	}
	
	/**
	* 市县域 [可空]     
	**/
	public void setCstCity(String cstCity){
		this.cstCity = cstCity;
	}
	/*******************************车牌颜色**********************************/	
	/**
	* 车牌颜色 [可空]      
	**/
	public Short getCstColor(){
		return this.cstColor;
	}
	
	/**
	* 车牌颜色 [可空]     
	**/
	public void setCstColor(Short cstColor){
		this.cstColor = cstColor;
	}
	/*******************************车辆标识**********************************/	
	/**
	* 车辆标识 [可空]      
	**/
	public String getCstNumber(){
		return this.cstNumber;
	}
	
	/**
	* 车辆标识 [可空]     
	**/
	public void setCstNumber(String cstNumber){
		this.cstNumber = cstNumber;
	}
	/*******************************SIM**********************************/	
	/**
	* SIM [可空]      
	**/
	public String getCstMobile(){
		return this.cstMobile;
	}
	
	/**
	* SIM [可空]     
	**/
	public void setCstMobile(String cstMobile){
		this.cstMobile = cstMobile;
	}
	/*******************************更新时间**********************************/	
	/**
	* 更新时间 [非空]      
	**/
	public Date getCstUpdateTime(){
		return this.cstUpdateTime;
	}
	
	/**
	* 更新时间 [非空]     
	**/
	public void setCstUpdateTime(Date cstUpdateTime){
		this.cstUpdateTime = cstUpdateTime;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [非空]      
	**/
	public Date getCstAddTime(){
		return this.cstAddTime;
	}
	
	/**
	* 添加时间 [非空]     
	**/
	public void setCstAddTime(Date cstAddTime){
		this.cstAddTime = cstAddTime;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getCstStatus(){
		return this.cstStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setCstStatus(Short cstStatus){
		this.cstStatus = cstStatus;
	}
}