package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * 升级版本管理
 * @author Joel
 */
public class VerUpgrade implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]升级版本编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [soft_ver_id]软件版本号
	 */
	
	private   Integer softVerId;
	/**
	 * [hard_ver_id]硬件版本号
	 */
	
	private   Integer hardVerId;
	/**
	 * [model_id]车型
	 */
	
	private   Integer modelId;
	/**
	 * [tel_type]终端类型0:车厘子 1:中导 2:慧翰 3:通领
	 */
	
	private   Integer telType;
	/**
	 * [inner_ver]生产内部版本号
	 */
	
	private   String innerVer;
	/**
	 * [is_open]是否对外开放0:是 1:否
	 */
	
	private   Short isOpen;
	/**
	 * [des]描述
	 */
	
	private   String des;
	/**
	 * [up_ver_no]升级版本号
	 */
	
	private   String upVerNo;
	/**
	 * [ser_ftp_id]文件服务器名称
	 */
	
	private   Integer serFtpId;
	/**
	 * [per_timeout]单次升级超时时长（毫秒）
	 */
	
	private   Integer perTimeout;
	/**
	 * [per_max_vehicle]单次升级最大车辆数
	 */
	
	private   Integer perMaxVehicle;
	/**
	 * [file_name]升级文件名称
	 */
	
	private   String fileName;
	/**
	 * [turn_off_flag]是否为拐点版本0:否 1:是
	 */
	
	private   Short turnOffFlag;
	
	//默认构造函数
	public VerUpgrade(){
	
	}
	
	//主键构造函数
	public VerUpgrade(Integer id){
		this.id = id;
	}
	
	//设置非空字段
	public VerUpgrade setNotNull(Integer id, Integer softVerId, Integer hardVerId, Integer modelId, String innerVer, Short isOpen, String upVerNo){
		this.id=id;
		this.softVerId=softVerId;
		this.hardVerId=hardVerId;
		this.modelId=modelId;
		this.innerVer=innerVer;
		this.isOpen=isOpen;
		this.upVerNo=upVerNo;
		return this;
	}
	
	public Object getSoftVerIdText(){
		return resolve("softVerIdText");
	}
	public Object getHardVerIdText(){
		return resolve("hardVerIdText");
	}
	public Object getModelIdText(){
		return resolve("modelIdText");
	}
	public Object getTelTypeText(){
		return resolve("telTypeText");
	}
	public Object getIsOpenText(){
		return resolve("isOpenText");
	}
	public Object getSerFtpIdText(){
		return resolve("serFtpIdText");
	}
	public Object getTurnOffFlagText(){
		return resolve("turnOffFlagText");
	}
	
	@Transient
	Map<String, Resolver<VerUpgrade>> resolvers = new HashMap<String, Resolver<VerUpgrade>>();
	
	public void registResolver(Resolver<VerUpgrade> resolver){
		this.resolvers.put(resolver.getName(), resolver);
	}
	
	public Object resolve(String key){
		if(resolvers.get(key)!=null){
			return resolvers.get(key).execute(this);
		}
		return null;
	}
	
	/*******************************升级版本编号**********************************/	
	/**
	* 升级版本编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 升级版本编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************软件版本号**********************************/	
	/**
	* 软件版本号 [非空]      
	**/
	public Integer getSoftVerId(){
		return this.softVerId;
	}
	
	/**
	* 软件版本号 [非空]     
	**/
	public void setSoftVerId(Integer softVerId){
		this.softVerId = softVerId;
	}
	/*******************************硬件版本号**********************************/	
	/**
	* 硬件版本号 [非空]      
	**/
	public Integer getHardVerId(){
		return this.hardVerId;
	}
	
	/**
	* 硬件版本号 [非空]     
	**/
	public void setHardVerId(Integer hardVerId){
		this.hardVerId = hardVerId;
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
	/*******************************终端类型**********************************/	
	/**
	* 终端类型 [可空]      
	**/
	public Integer getTelType(){
		return this.telType;
	}
	
	/**
	* 终端类型 [可空]     
	**/
	public void setTelType(Integer telType){
		this.telType = telType;
	}
	/*******************************生产内部版本号**********************************/	
	/**
	* 生产内部版本号 [非空]      
	**/
	public String getInnerVer(){
		return this.innerVer;
	}
	
	/**
	* 生产内部版本号 [非空]     
	**/
	public void setInnerVer(String innerVer){
		this.innerVer = innerVer;
	}
	/*******************************是否对外开放**********************************/	
	/**
	* 是否对外开放 [非空]      
	**/
	public Short getIsOpen(){
		return this.isOpen;
	}
	
	/**
	* 是否对外开放 [非空]     
	**/
	public void setIsOpen(Short isOpen){
		this.isOpen = isOpen;
	}
	/*******************************描述**********************************/	
	/**
	* 描述 [可空]      
	**/
	public String getdes(){
		return this.des;
	}
	
	/**
	* 描述 [可空]     
	**/
	public void setdes(String des){
		this.des = des;
	}
	/*******************************升级版本号**********************************/	
	/**
	* 升级版本号 [非空]      
	**/
	public String getUpVerNo(){
		return this.upVerNo;
	}
	
	/**
	* 升级版本号 [非空]     
	**/
	public void setUpVerNo(String upVerNo){
		this.upVerNo = upVerNo;
	}
	/*******************************文件服务器名称**********************************/	
	/**
	* 文件服务器名称 [可空]      
	**/
	public Integer getSerFtpId(){
		return this.serFtpId;
	}
	
	/**
	* 文件服务器名称 [可空]     
	**/
	public void setSerFtpId(Integer serFtpId){
		this.serFtpId = serFtpId;
	}
	/*******************************单次升级超时时长（毫秒）**********************************/	
	/**
	* 单次升级超时时长（毫秒） [可空]      
	**/
	public Integer getPerTimeout(){
		return this.perTimeout;
	}
	
	/**
	* 单次升级超时时长（毫秒） [可空]     
	**/
	public void setPerTimeout(Integer perTimeout){
		this.perTimeout = perTimeout;
	}
	/*******************************单次升级最大车辆数**********************************/	
	/**
	* 单次升级最大车辆数 [可空]      
	**/
	public Integer getPerMaxVehicle(){
		return this.perMaxVehicle;
	}
	
	/**
	* 单次升级最大车辆数 [可空]     
	**/
	public void setPerMaxVehicle(Integer perMaxVehicle){
		this.perMaxVehicle = perMaxVehicle;
	}
	/*******************************升级文件名称**********************************/	
	/**
	* 升级文件名称 [可空]      
	**/
	public String getFileName(){
		return this.fileName;
	}
	
	/**
	* 升级文件名称 [可空]     
	**/
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	/*******************************是否为拐点版本**********************************/	
	/**
	* 是否为拐点版本 [可空]      
	**/
	public Short getTurnOffFlag(){
		return this.turnOffFlag;
	}
	
	/**
	* 是否为拐点版本 [可空]     
	**/
	public void setTurnOffFlag(Short turnOffFlag){
		this.turnOffFlag = turnOffFlag;
	}
}