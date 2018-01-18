package com.ccclubs.pub.orm.model;

import java.util.Date;

/**
 * 
 * @author Joel
 */
public class CsTboxBindHis implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;

	/**
	 * [cstb_vehicle_id]车辆
	 */
	
	private   Long cstbVehicleId;
	/**
	 * [cstb_machine_id]终端
	 */
	
	private   Long cstbMachineId;
	/**
	 * [cstb_start_time]绑定开始时间
	 */
	private   Date cstbStartTime;
	/**
	 * [cstb_end_time]绑定结束时间
	 */
	private   Date cstbEndTime;
	/**
	 * [cstb_status]状态 1:正常 0:无效
	 */
	
	private   Short cstbStatus;
	/**
	 * [cstb_add_time]添加时间
	 */
	private   Date cstbAddTime;
	/**
	 * [cstb_mod_time]修改时间
	 */
	private   Date cstbModTime;
	/**
	 * [cstb_oper_id]操作人
	 */
	
	private   Long cstbOperId;
	/**
	 * [cstb_oper_type]操作人类型 1:运营商 2:后台用户
	 */
	
	private   Short cstbOperType;
	
	//默认构造函数
	public CsTboxBindHis(){
	
	}
	

	/*******************************车辆**********************************/
	/**
	* 车辆 [可空]      
	**/
	public Long getCstbVehicleId(){
		return this.cstbVehicleId;
	}
	
	/**
	* 车辆 [可空]     
	**/
	public void setCstbVehicleId(Long cstbVehicleId){
		this.cstbVehicleId = cstbVehicleId;
	}
	/*******************************终端**********************************/	
	/**
	* 终端 [可空]      
	**/
	public Long getCstbMachineId(){
		return this.cstbMachineId;
	}
	
	/**
	* 终端 [可空]     
	**/
	public void setCstbMachineId(Long cstbMachineId){
		this.cstbMachineId = cstbMachineId;
	}
	/*******************************绑定开始时间**********************************/	
	/**
	* 绑定开始时间 [可空]      
	**/
	public Date getCstbStartTime(){
		return this.cstbStartTime;
	}
	
	/**
	* 绑定开始时间 [可空]     
	**/
	public void setCstbStartTime(Date cstbStartTime){
		this.cstbStartTime = cstbStartTime;
	}
	/*******************************绑定结束时间**********************************/	
	/**
	* 绑定结束时间 [可空]      
	**/
	public Date getCstbEndTime(){
		return this.cstbEndTime;
	}
	
	/**
	* 绑定结束时间 [可空]     
	**/
	public void setCstbEndTime(Date cstbEndTime){
		this.cstbEndTime = cstbEndTime;
	}
	/*******************************状态 1:正常 0:无效**********************************/	
	/**
	* 状态 1:正常 0:无效 [可空]      
	**/
	public Short getCstbStatus(){
		return this.cstbStatus;
	}
	
	/**
	* 状态 1:正常 0:无效 [可空]     
	**/
	public void setCstbStatus(Short cstbStatus){
		this.cstbStatus = cstbStatus;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [可空]      
	**/
	public Date getCstbAddTime(){
		return this.cstbAddTime;
	}
	
	/**
	* 添加时间 [可空]     
	**/
	public void setCstbAddTime(Date cstbAddTime){
		this.cstbAddTime = cstbAddTime;
	}
	/*******************************修改时间**********************************/	
	/**
	* 修改时间 [可空]      
	**/
	public Date getCstbModTime(){
		return this.cstbModTime;
	}
	
	/**
	* 修改时间 [可空]     
	**/
	public void setCstbModTime(Date cstbModTime){
		this.cstbModTime = cstbModTime;
	}
	/*******************************操作人**********************************/	
	/**
	* 操作人 [可空]      
	**/
	public Long getCstbOperId(){
		return this.cstbOperId;
	}
	
	/**
	* 操作人 [可空]     
	**/
	public void setCstbOperId(Long cstbOperId){
		this.cstbOperId = cstbOperId;
	}
	/*******************************操作人类型 1:运营商 2:后台用户**********************************/	
	/**
	* 操作人类型 1:运营商 2:后台用户 [可空]      
	**/
	public Short getCstbOperType(){
		return this.cstbOperType;
	}
	
	/**
	* 操作人类型 1:运营商 2:后台用户 [可空]     
	**/
	public void setCstbOperType(Short cstbOperType){
		this.cstbOperType = cstbOperType;
	}
}