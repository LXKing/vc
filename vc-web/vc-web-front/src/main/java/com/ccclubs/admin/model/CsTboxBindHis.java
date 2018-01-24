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
 *
 * @author Joel
 */
public class CsTboxBindHis implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [cstb_id]主键
	 */

	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Long cstbId;
	/**
	 * [cstb_vehicle_id]车辆
	 */

	private   Long cstbVehicleId;
	/**
	 * [cstb_machine_id]终端
	 */

	private   Long cstbMachineId;
	/**
	 * [cstb_vin]车辆vin码
	 */

	private   String cstbVin;
	/**
	 * [cstb_number]车机号
	 */

	private   String cstbNumber;
	/**
	 * [cstb_te_no]终端编号
	 */

	private   String cstbTeNo;
	/**
	 * [cstb_start_time]开始时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cstbStartTime;
	/**
	 * [cstb_end_time]结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cstbEndTime;
	/**
	 * [cstb_status]状态 1:正常 0:无效
	 */

	private   Short cstbStatus;
	/**
	 * [cstb_add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cstbAddTime;
	/**
	 * [cstb_mod_time]修改时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date cstbModTime;
	/**
	 * [cstb_bind_oper_id]绑定人
	 */

	private   Long cstbBindOperId;
	/**
	 * [cstb_unbind_oper_id]解绑人
	 */

	private   Long cstbUnbindOperId;
	/**
	 * [cstb_oper_type]操作人类型 1:运营商 2:后台用户
	 */

	private   Short cstbOperType;

	//默认构造函数
	public CsTboxBindHis(){

	}

	//主键构造函数
	public CsTboxBindHis(Long id){
		this.cstbId = id;
	}

	//设置非空字段
	public CsTboxBindHis setNotNull(Long cstbId){
		this.cstbId=cstbId;
		return this;
	}


	@Transient
	Map<String, Resolver<CsTboxBindHis>> resolvers = new HashMap<String, Resolver<CsTboxBindHis>>();

	public void registResolver(Resolver<CsTboxBindHis> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}

	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}

	/*******************************主键**********************************/
	/**
	 * 主键 [非空]
	 **/
	public Long getCstbId(){
		return this.cstbId;
	}

	/**
	 * 主键 [非空]
	 **/
	public void setCstbId(Long cstbId){
		this.cstbId = cstbId;
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
	/*******************************车辆vin码**********************************/
	/**
	 * 车辆vin码 [可空]
	 **/
	public String getCstbVin(){
		return this.cstbVin;
	}

	/**
	 * 车辆vin码 [可空]
	 **/
	public void setCstbVin(String cstbVin){
		this.cstbVin = cstbVin;
	}
	/*******************************车机号**********************************/
	/**
	 * 车机号 [可空]
	 **/
	public String getCstbNumber(){
		return this.cstbNumber;
	}

	/**
	 * 车机号 [可空]
	 **/
	public void setCstbNumber(String cstbNumber){
		this.cstbNumber = cstbNumber;
	}
	/*******************************终端编号**********************************/
	/**
	 * 终端编号 [可空]
	 **/
	public String getCstbTeNo(){
		return this.cstbTeNo;
	}

	/**
	 * 终端编号 [可空]
	 **/
	public void setCstbTeNo(String cstbTeNo){
		this.cstbTeNo = cstbTeNo;
	}
	/*******************************开始时间**********************************/
	/**
	 * 开始时间 [可空]
	 **/
	public Date getCstbStartTime(){
		return this.cstbStartTime;
	}

	/**
	 * 开始时间 [可空]
	 **/
	public void setCstbStartTime(Date cstbStartTime){
		this.cstbStartTime = cstbStartTime;
	}
	/*******************************结束时间**********************************/
	/**
	 * 结束时间 [可空]
	 **/
	public Date getCstbEndTime(){
		return this.cstbEndTime;
	}

	/**
	 * 结束时间 [可空]
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
	/*******************************绑定人**********************************/
	/**
	 * 绑定人 [可空]
	 **/
	public Long getCstbBindOperId(){
		return this.cstbBindOperId;
	}

	/**
	 * 绑定人 [可空]
	 **/
	public void setCstbBindOperId(Long cstbBindOperId){
		this.cstbBindOperId = cstbBindOperId;
	}
	/*******************************解绑人**********************************/
	/**
	 * 解绑人 [可空]
	 **/
	public Long getCstbUnbindOperId(){
		return this.cstbUnbindOperId;
	}

	/**
	 * 解绑人 [可空]
	 **/
	public void setCstbUnbindOperId(Long cstbUnbindOperId){
		this.cstbUnbindOperId = cstbUnbindOperId;
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