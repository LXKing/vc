package com.ccclubs.admin.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 车机升级记录
 * @author Joel
 */
public class VerUpgradeRecord implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]记录编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [vin]车架号
	 */
	
	private   String vin;
	/**
	 * [car_model]车型
	 */
	
	private   Integer carModel;
	/**
	 * [te_number]车机号
	 */
	
	private   String teNumber;
	/**
	 * [te_type]车机类型0:车厘子,1:中导,2:慧翰,3:通领
	 */
	
	private   Short teType;
	/**
	 * [te_model]车机型号
	 */
	
	private   String teModel;
	/**
	 * [from_version]当前版本
	 */
	
	private   Integer fromVersion;
	/**
	 * [to_version]目的版本
	 */
	
	private   Integer toVersion;
	/**
	 * [status]状态-1:无效 0:待升级 1:升级中 2:已升级 3:升级失败
	 */
	
	private   Short status;
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
	public VerUpgradeRecord(){
	
	}
	
	//主键构造函数
	public VerUpgradeRecord(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public VerUpgradeRecord setNotNull(Integer id,String vin){
		this.id=id;
		this.vin=vin;
		return this;
	}
	
	public Object getCarModelText(){
		return resolve("carModelText");
	}
	public Object getTeTypeText(){
		return resolve("teTypeText");
	}
	public Object getFromVersionText(){
		return resolve("fromVersionText");
	}
	public Object getToVersionText(){
		return resolve("toVersionText");
	}
	public Object getstatusText(){
		return resolve("statusText");
	}
	
	@Transient
	Map<String, Resolver<VerUpgradeRecord>> resolvers = new HashMap<String, Resolver<VerUpgradeRecord>>();
	
	public void registResolver(Resolver<VerUpgradeRecord> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************记录编号**********************************/	
	/**
	* 记录编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 记录编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************车架号**********************************/	
	/**
	* 车架号 [非空]      
	**/
	public String getvin(){
		return this.vin;
	}
	
	/**
	* 车架号 [非空]     
	**/
	public void setvin(String vin){
		this.vin = vin;
	}
	/*******************************车型**********************************/	
	/**
	* 车型 [可空]      
	**/
	public Integer getCarModel(){
		return this.carModel;
	}
	
	/**
	* 车型 [可空]     
	**/
	public void setCarModel(Integer carModel){
		this.carModel = carModel;
	}
	/*******************************车机号**********************************/	
	/**
	* 车机号 [可空]      
	**/
	public String getTeNumber(){
		return this.teNumber;
	}
	
	/**
	* 车机号 [可空]     
	**/
	public void setTeNumber(String teNumber){
		this.teNumber = teNumber;
	}
	/*******************************车机类型**********************************/	
	/**
	* 车机类型 [可空]      
	**/
	public Short getTeType(){
		return this.teType;
	}
	
	/**
	* 车机类型 [可空]     
	**/
	public void setTeType(Short teType){
		this.teType = teType;
	}
	/*******************************车机型号**********************************/	
	/**
	* 车机型号 [可空]      
	**/
	public String getTeModel(){
		return this.teModel;
	}
	
	/**
	* 车机型号 [可空]     
	**/
	public void setTeModel(String teModel){
		this.teModel = teModel;
	}
	/*******************************当前版本**********************************/	
	/**
	* 当前版本 [可空]      
	**/
	public Integer getFromVersion(){
		return this.fromVersion;
	}
	
	/**
	* 当前版本 [可空]     
	**/
	public void setFromVersion(Integer fromVersion){
		this.fromVersion = fromVersion;
	}
	/*******************************目的版本**********************************/	
	/**
	* 目的版本 [可空]      
	**/
	public Integer getToVersion(){
		return this.toVersion;
	}
	
	/**
	* 目的版本 [可空]     
	**/
	public void setToVersion(Integer toVersion){
		this.toVersion = toVersion;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [可空]      
	**/
	public Short getstatus(){
		return this.status;
	}
	
	/**
	* 状态 [可空]     
	**/
	public void setstatus(Short status){
		this.status = status;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [可空]      
	**/
	public Date getAddTime(){
		return this.addTime;
	}
	
	/**
	* 添加时间 [可空]     
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