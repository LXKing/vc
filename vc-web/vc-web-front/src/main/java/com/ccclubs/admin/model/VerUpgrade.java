package com.ccclubs.admin.model;

import com.ccclubs.frm.spring.resolver.Resolver;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * 车辆信息管理
 * @author Joel
 */
public class VerUpgrade implements java.io.Serializable
{
	private static final long serialVersionUID =         1L;
	/**
	 * [id]版本编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id;
	/**
	 * [soft_ver_id]插件版本
	 */
	
	private   Integer softVerId;
	/**
	 * [hard_ver_id]硬件版本
	 */
	
	private   Integer hardVerId;
	/**
	 * [bluetooth_ver_id]蓝牙版本
	 */
	
	private   Integer bluetoothVerId;
	/**
	 * [major_version_id]主版本
	 */
	
	private   Integer majorVersionId;
	/**
	 * [model_id]车型
	 */
	
	private   Integer modelId;
	/**
	 * [tel_type]终端类型（0:车厘子,1:中导,2:慧翰,3:通领）
	 */
	
	private   Short telType;
	/**
	 * [tel_model]终端型号
	 */
	
	private   String telModel;
	/**
	 * [inner_ver]生产内部版本号
	 */
	
	private   String innerVer;
	/**
	 * [is_open]是否对外开放
	 */
	
	private   Short isOpen;
	/**
	 * [des]描述
	 */
	
	private   String des;
	/**
	 * [up_ver_no]升级包版本号
	 */
	
	private   String upVerNo;
	/**
	 * [ser_ftp_id]升级的ftp服务器账号信息
	 */
	
	private   Integer serFtpId;
	/**
	 * [per_timeout]单次升级超时时间（单位：毫秒）
	 */
	
	private   Integer perTimeout;
	/**
	 * [per_max_vehicle]单次升级允许的最大车辆数
	 */
	
	private   Integer perMaxVehicle;
	/**
	 * [file_name]升级文件名称
	 */
	
	private   String fileName;
	/**
	 * [turn_off_flag]是否拐点版本（0=否，1=是）
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
	public VerUpgrade setNotNull(Integer id,Integer softVerId,Integer hardVerId,Integer modelId,String innerVer,Short isOpen,String upVerNo){
		this.id=id;
		this.softVerId=softVerId;
		this.hardVerId=hardVerId;
		this.modelId=modelId;
		this.innerVer=innerVer;
		this.isOpen=isOpen;
		this.upVerNo=upVerNo;
		return this;
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

    public Object getSoftVerIdText(){
        return resolve("softVerIdText");
    }
    public Object getHardVerIdText(){
        return resolve("hardVerIdText");
    }
    public Object getBluetoothVerIdText() {
	    return resolve("bluetoothVerIdText");
    }
    public Object getMajorVersionIdText() {
        return resolve("majorVersionIdText");
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
	
	/*******************************版本编号**********************************/	
	/**
	* 版本编号 [非空]      
	**/
	public Integer getid(){
		return this.id;
	}
	
	/**
	* 版本编号 [非空]     
	**/
	public void setid(Integer id){
		this.id = id;
	}
	/*******************************插件版本**********************************/	
	/**
	* 插件版本 [非空]      
	**/
	public Integer getSoftVerId(){
		return this.softVerId;
	}
	
	/**
	* 插件版本 [非空]     
	**/
	public void setSoftVerId(Integer softVerId){
		this.softVerId = softVerId;
	}
	/*******************************硬件版本**********************************/	
	/**
	* 硬件版本 [非空]      
	**/
	public Integer getHardVerId(){
		return this.hardVerId;
	}
	
	/**
	* 硬件版本 [非空]     
	**/
	public void setHardVerId(Integer hardVerId){
		this.hardVerId = hardVerId;
	}
	/*******************************蓝牙版本**********************************/	
	/**
	* 蓝牙版本 [可空]      
	**/
	public Integer getBluetoothVerId(){
		return this.bluetoothVerId;
	}
	
	/**
	* 蓝牙版本 [可空]     
	**/
	public void setBluetoothVerId(Integer bluetoothVerId){
		this.bluetoothVerId = bluetoothVerId;
	}
	/*******************************主版本**********************************/	
	/**
	* 主版本 [可空]      
	**/
	public Integer getMajorVersionId(){
		return this.majorVersionId;
	}
	
	/**
	* 主版本 [可空]     
	**/
	public void setMajorVersionId(Integer majorVersionId){
		this.majorVersionId = majorVersionId;
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
	/*******************************终端类型（0:车厘子,1:中导,2:慧翰,3:通领）**********************************/	
	/**
	* 终端类型（0:车厘子,1:中导,2:慧翰,3:通领） [可空]      
	**/
	public Short getTelType(){
		return this.telType;
	}
	
	/**
	* 终端类型（0:车厘子,1:中导,2:慧翰,3:通领） [可空]     
	**/
	public void setTelType(Short telType){
		this.telType = telType;
	}
	/*******************************终端型号**********************************/	
	/**
	* 终端型号 [可空]      
	**/
	public String getTelModel(){
		return this.telModel;
	}
	
	/**
	* 终端型号 [可空]     
	**/
	public void setTelModel(String telModel){
		this.telModel = telModel;
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
	/*******************************升级包版本号**********************************/	
	/**
	* 升级包版本号 [非空]      
	**/
	public String getUpVerNo(){
		return this.upVerNo;
	}
	
	/**
	* 升级包版本号 [非空]     
	**/
	public void setUpVerNo(String upVerNo){
		this.upVerNo = upVerNo;
	}
	/*******************************升级的ftp服务器账号信息**********************************/	
	/**
	* 升级的ftp服务器账号信息 [可空]      
	**/
	public Integer getSerFtpId(){
		return this.serFtpId;
	}
	
	/**
	* 升级的ftp服务器账号信息 [可空]     
	**/
	public void setSerFtpId(Integer serFtpId){
		this.serFtpId = serFtpId;
	}
	/*******************************单次升级超时时间（单位：毫秒）**********************************/	
	/**
	* 单次升级超时时间（单位：毫秒） [可空]      
	**/
	public Integer getPerTimeout(){
		return this.perTimeout;
	}
	
	/**
	* 单次升级超时时间（单位：毫秒） [可空]     
	**/
	public void setPerTimeout(Integer perTimeout){
		this.perTimeout = perTimeout;
	}
	/*******************************单次升级允许的最大车辆数**********************************/	
	/**
	* 单次升级允许的最大车辆数 [可空]      
	**/
	public Integer getPerMaxVehicle(){
		return this.perMaxVehicle;
	}
	
	/**
	* 单次升级允许的最大车辆数 [可空]     
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
	/*******************************是否拐点版本（0=否，1=是）**********************************/	
	/**
	* 是否拐点版本（0=否，1=是） [可空]      
	**/
	public Short getTurnOffFlag(){
		return this.turnOffFlag;
	}
	
	/**
	* 是否拐点版本（0=否，1=是） [可空]     
	**/
	public void setTurnOffFlag(Short turnOffFlag){
		this.turnOffFlag = turnOffFlag;
	}
}