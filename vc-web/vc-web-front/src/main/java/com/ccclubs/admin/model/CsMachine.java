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
 * T-box信息管理
 * @author Joel
 */
public class CsMachine implements java.io.Serializable
{

	/**
	 * [csm_id]编号
	 */
	
	private @Id@GeneratedValue(strategy = GenerationType.IDENTITY)  Integer csmId;
	/**
	 * [csm_access]接入商
	 */
	
	private   Integer csmAccess;
	/**
	 * [csm_host]子域
	 */
	
	private   Integer csmHost;
	/**
	 * [csm_number]车机号
	 */
	
	private   String csmNumber;
	/**
	 * [csm_te_no]序列号
	 */
	
	private   String csmTeNo;
	/**
	 * [csm_te_type]终端类型
	 */
	
	private   Short csmTeType;
	/**
	 * [csm_te_model]终端型号
	 */
	
	private   String csmTeModel;
	/**
	 * [csm_te_code]厂商代码
	 */
	
	private   String csmTeCode;
	/**
	 * [csm_te_lot_no]终端批号
	 */
	
	private   String csmTeLotNo;
	/**
	 * [csm_te_serial]终端流水
	 */
	
	private   String csmTeSerial;
	/**
	 * [csm_mobile]SIM卡
	 */
	
	private   String csmMobile;
	/**
	 * [csm_iccid]ICCID
	 */
	
	private   String csmIccid;
	/**
	 * [csm_password]服务密码
	 */
	
	private   String csmPassword;
	/**
	 * [csm_protocol]协议类型
	 */
	
	private   Long csmProtocol;
	/**
	 * [csm_functions]功能标签
	 */
	
	private   String csmFunctions;
	/**
	 * [csm_bluetooth_version]蓝牙版本
	 */
	
	private   Integer csmBluetoothVersion;
	/**
	 * [csm_bluetooth_mac]蓝牙地址
	 */
	
	private   String csmBluetoothMac;
	/**
	 * [csm_bluetooth_psd]蓝牙密码
	 */
	
	private   String csmBluetoothPsd;
	/**
	 * [csm_mqtt_flag]服务器标识
	 */
	
	private   String csmMqttFlag;
	/**
	 * [csm_super_sim]超级手机号
	 */
	
	private   String csmSuperSim;
	/**
	 * [csm_v2]硬件版本
	 */
	
	private   String csmV2;
	/**
	 * [csm_v3]DVD当前版本
	 */
	
	private   String csmV3;
	/**
	 * [csm_v3_to]DVD最新版本
	 */
	
	private   String csmV3To;
	/**
	 * [csm_suit]适配车型
	 */
	
	private   Integer csmSuit;
	/**
	 * [csm_tl_v1]软件版本
	 */
	
	private   String csmTlV1;
	/**
	 * [csm_tl_v2]分时租赁版本
	 */
	
	private   Integer csmTlV2;
	/**
	 * [csm_net_type]网络类型
	 */
	
	private   Short csmNetType;
	/**
	 * [csm_pro_type]终端协议1:mqtt 2:808
	 */
	
	private   Short csmProType;
	/**
	 * [csm_baud_rate]CAN1波特率
	 */
	
	private   Integer csmBaudRate;
	/**
	 * [csm_remark]备注信息
	 */
	
	private   String csmRemark;
	/**
	 * [csm_update_time]修改时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date csmUpdateTime;
	/**
	 * [csm_add_time]添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private   Date csmAddTime;
	/**
	 * [csm_status]状态
	 */
	
	private   Short csmStatus;


	private static final long serialVersionUID =         1L;
	//默认构造函数
	public CsMachine(){
	
	}
	
	//主键构造函数
	public CsMachine(Integer id){
		this.csmId = id;
	}
	
	//设置非空字段
	public CsMachine setNotNull(Integer csmId,Integer csmAccess,Integer csmBluetoothVersion,String csmSuperSim,Date csmUpdateTime,Date csmAddTime,Short csmStatus){
		this.csmId=csmId;
		this.csmAccess=csmAccess;
		this.csmBluetoothVersion=csmBluetoothVersion;
		this.csmSuperSim=csmSuperSim;
		this.csmUpdateTime=csmUpdateTime;
		this.csmAddTime=csmAddTime;
		this.csmStatus=csmStatus;
		return this;
	}
	
	public Object getCsmAccessText(){
		return resolve("csmAccessText");
	}
	public Object getCsmTeTypeText(){
		return resolve("csmTeTypeText");
	}
	public Object getCsmProtocolText(){
		return resolve("csmProtocolText");
	}
	public Object getCsmSuitText(){
		return resolve("csmSuitText");
	}
	public Object getCsmProTypeText(){
		return resolve("csmProTypeText");
	}
	public Object getCsmStatusText(){
		return resolve("csmStatusText");
	}
	
	@Transient
	Map<String, Resolver<CsMachine>> resolvers = new HashMap<String, Resolver<CsMachine>>();
	
	public void registResolver(Resolver<CsMachine> resolver){
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
	public Integer getCsmId(){
		return this.csmId;
	}
	
	/**
	* 编号 [非空]     
	**/
	public void setCsmId(Integer csmId){
		this.csmId = csmId;
	}
	/*******************************接入商**********************************/	
	/**
	* 接入商 [非空]      
	**/
	public Integer getCsmAccess(){
		return this.csmAccess;
	}
	
	/**
	* 接入商 [非空]     
	**/
	public void setCsmAccess(Integer csmAccess){
		this.csmAccess = csmAccess;
	}
	/*******************************子域**********************************/	
	/**
	* 子域 [可空]      
	**/
	public Integer getCsmHost(){
		return this.csmHost;
	}
	
	/**
	* 子域 [可空]     
	**/
	public void setCsmHost(Integer csmHost){
		this.csmHost = csmHost;
	}
	/*******************************车机号**********************************/	
	/**
	* 车机号 [可空]      
	**/
	public String getCsmNumber(){
		return this.csmNumber;
	}
	
	/**
	* 车机号 [可空]     
	**/
	public void setCsmNumber(String csmNumber){
		this.csmNumber = csmNumber;
	}
	/*******************************序列号**********************************/	
	/**
	* 序列号 [可空]      
	**/
	public String getCsmTeNo(){
		return this.csmTeNo;
	}
	
	/**
	* 序列号 [可空]     
	**/
	public void setCsmTeNo(String csmTeNo){
		this.csmTeNo = csmTeNo;
	}
	/*******************************终端类型**********************************/	
	/**
	* 终端类型 [可空]      
	**/
	public Short getCsmTeType(){
		return this.csmTeType;
	}
	
	/**
	* 终端类型 [可空]     
	**/
	public void setCsmTeType(Short csmTeType){
		this.csmTeType = csmTeType;
	}
	/*******************************终端型号**********************************/	
	/**
	* 终端型号 [可空]      
	**/
	public String getCsmTeModel(){
		return this.csmTeModel;
	}
	
	/**
	* 终端型号 [可空]     
	**/
	public void setCsmTeModel(String csmTeModel){
		this.csmTeModel = csmTeModel;
	}
	/*******************************厂商代码**********************************/	
	/**
	* 厂商代码 [可空]      
	**/
	public String getCsmTeCode(){
		return this.csmTeCode;
	}
	
	/**
	* 厂商代码 [可空]     
	**/
	public void setCsmTeCode(String csmTeCode){
		this.csmTeCode = csmTeCode;
	}
	/*******************************终端批号**********************************/	
	/**
	* 终端批号 [可空]      
	**/
	public String getCsmTeLotNo(){
		return this.csmTeLotNo;
	}
	
	/**
	* 终端批号 [可空]     
	**/
	public void setCsmTeLotNo(String csmTeLotNo){
		this.csmTeLotNo = csmTeLotNo;
	}
	/*******************************终端流水**********************************/	
	/**
	* 终端流水 [可空]      
	**/
	public String getCsmTeSerial(){
		return this.csmTeSerial;
	}
	
	/**
	* 终端流水 [可空]     
	**/
	public void setCsmTeSerial(String csmTeSerial){
		this.csmTeSerial = csmTeSerial;
	}
	/*******************************SIM卡**********************************/	
	/**
	* SIM卡 [可空]      
	**/
	public String getCsmMobile(){
		return this.csmMobile;
	}
	
	/**
	* SIM卡 [可空]     
	**/
	public void setCsmMobile(String csmMobile){
		this.csmMobile = csmMobile;
	}
	/*******************************ICCID**********************************/	
	/**
	* ICCID [可空]      
	**/
	public String getCsmIccid(){
		return this.csmIccid;
	}
	
	/**
	* ICCID [可空]     
	**/
	public void setCsmIccid(String csmIccid){
		this.csmIccid = csmIccid;
	}
	/*******************************服务密码**********************************/	
	/**
	* 服务密码 [可空]      
	**/
	public String getCsmPassword(){
		return this.csmPassword;
	}
	
	/**
	* 服务密码 [可空]     
	**/
	public void setCsmPassword(String csmPassword){
		this.csmPassword = csmPassword;
	}
	/*******************************协议类型**********************************/	
	/**
	* 协议类型 [可空]      
	**/
	public Long getCsmProtocol(){
		return this.csmProtocol;
	}
	
	/**
	* 协议类型 [可空]     
	**/
	public void setCsmProtocol(Long csmProtocol){
		this.csmProtocol = csmProtocol;
	}
	/*******************************功能标签**********************************/	
	/**
	* 功能标签 [可空]      
	**/
	public String getCsmFunctions(){
		return this.csmFunctions;
	}
	
	/**
	* 功能标签 [可空]     
	**/
	public void setCsmFunctions(String csmFunctions){
		this.csmFunctions = csmFunctions;
	}
	/*******************************蓝牙版本**********************************/	
	/**
	* 蓝牙版本 [非空]      
	**/
	public Integer getCsmBluetoothVersion(){
		return this.csmBluetoothVersion;
	}
	
	/**
	* 蓝牙版本 [非空]     
	**/
	public void setCsmBluetoothVersion(Integer csmBluetoothVersion){
		this.csmBluetoothVersion = csmBluetoothVersion;
	}
	/*******************************蓝牙地址**********************************/	
	/**
	* 蓝牙地址 [可空]      
	**/
	public String getCsmBluetoothMac(){
		return this.csmBluetoothMac;
	}
	
	/**
	* 蓝牙地址 [可空]     
	**/
	public void setCsmBluetoothMac(String csmBluetoothMac){
		this.csmBluetoothMac = csmBluetoothMac;
	}
	/*******************************蓝牙密码**********************************/	
	/**
	* 蓝牙密码 [可空]      
	**/
	public String getCsmBluetoothPsd(){
		return this.csmBluetoothPsd;
	}
	
	/**
	* 蓝牙密码 [可空]     
	**/
	public void setCsmBluetoothPsd(String csmBluetoothPsd){
		this.csmBluetoothPsd = csmBluetoothPsd;
	}
	/*******************************服务器标识**********************************/	
	/**
	* 服务器标识 [可空]      
	**/
	public String getCsmMqttFlag(){
		return this.csmMqttFlag;
	}
	
	/**
	* 服务器标识 [可空]     
	**/
	public void setCsmMqttFlag(String csmMqttFlag){
		this.csmMqttFlag = csmMqttFlag;
	}
	/*******************************超级手机号**********************************/	
	/**
	* 超级手机号 [非空]      
	**/
	public String getCsmSuperSim(){
		return this.csmSuperSim;
	}
	
	/**
	* 超级手机号 [非空]     
	**/
	public void setCsmSuperSim(String csmSuperSim){
		this.csmSuperSim = csmSuperSim;
	}
	/*******************************硬件版本**********************************/	
	/**
	* 硬件版本 [可空]      
	**/
	public String getCsmV2(){
		return this.csmV2;
	}
	
	/**
	* 硬件版本 [可空]     
	**/
	public void setCsmV2(String csmV2){
		this.csmV2 = csmV2;
	}
	/*******************************DVD当前版本**********************************/	
	/**
	* DVD当前版本 [可空]      
	**/
	public String getCsmV3(){
		return this.csmV3;
	}
	
	/**
	* DVD当前版本 [可空]     
	**/
	public void setCsmV3(String csmV3){
		this.csmV3 = csmV3;
	}
	/*******************************DVD最新版本**********************************/	
	/**
	* DVD最新版本 [可空]      
	**/
	public String getCsmV3To(){
		return this.csmV3To;
	}
	
	/**
	* DVD最新版本 [可空]     
	**/
	public void setCsmV3To(String csmV3To){
		this.csmV3To = csmV3To;
	}
	/*******************************适配车型**********************************/	
	/**
	* 适配车型 [可空]      
	**/
	public Integer getCsmSuit(){
		return this.csmSuit;
	}
	
	/**
	* 适配车型 [可空]     
	**/
	public void setCsmSuit(Integer csmSuit){
		this.csmSuit = csmSuit;
	}
	/*******************************软件版本**********************************/	
	/**
	* 软件版本 [可空]      
	**/
	public String getCsmTlV1(){
		return this.csmTlV1;
	}
	
	/**
	* 软件版本 [可空]     
	**/
	public void setCsmTlV1(String csmTlV1){
		this.csmTlV1 = csmTlV1;
	}
	/*******************************分时租赁版本**********************************/	
	/**
	* 分时租赁版本 [可空]      
	**/
	public Integer getCsmTlV2(){
		return this.csmTlV2;
	}
	
	/**
	* 分时租赁版本 [可空]     
	**/
	public void setCsmTlV2(Integer csmTlV2){
		this.csmTlV2 = csmTlV2;
	}
	/*******************************网络类型**********************************/	
	/**
	* 网络类型 [可空]      
	**/
	public Short getCsmNetType(){
		return this.csmNetType;
	}
	
	/**
	* 网络类型 [可空]     
	**/
	public void setCsmNetType(Short csmNetType){
		this.csmNetType = csmNetType;
	}
	/*******************************终端协议**********************************/	
	/**
	* 终端协议 [可空]      
	**/
	public Short getCsmProType(){
		return this.csmProType;
	}
	
	/**
	* 终端协议 [可空]     
	**/
	public void setCsmProType(Short csmProType){
		this.csmProType = csmProType;
	}
	/*******************************CAN1波特率**********************************/	
	/**
	* CAN1波特率 [可空]      
	**/
	public Integer getCsmBaudRate(){
		return this.csmBaudRate;
	}
	
	/**
	* CAN1波特率 [可空]     
	**/
	public void setCsmBaudRate(Integer csmBaudRate){
		this.csmBaudRate = csmBaudRate;
	}
	/*******************************备注信息**********************************/	
	/**
	* 备注信息 [可空]      
	**/
	public String getCsmRemark(){
		return this.csmRemark;
	}
	
	/**
	* 备注信息 [可空]     
	**/
	public void setCsmRemark(String csmRemark){
		this.csmRemark = csmRemark;
	}
	/*******************************修改时间**********************************/	
	/**
	* 修改时间 [非空]      
	**/
	public Date getCsmUpdateTime(){
		return this.csmUpdateTime;
	}
	
	/**
	* 修改时间 [非空]     
	**/
	public void setCsmUpdateTime(Date csmUpdateTime){
		this.csmUpdateTime = csmUpdateTime;
	}
	/*******************************添加时间**********************************/	
	/**
	* 添加时间 [非空]      
	**/
	public Date getCsmAddTime(){
		return this.csmAddTime;
	}
	
	/**
	* 添加时间 [非空]     
	**/
	public void setCsmAddTime(Date csmAddTime){
		this.csmAddTime = csmAddTime;
	}
	/*******************************状态**********************************/	
	/**
	* 状态 [非空]      
	**/
	public Short getCsmStatus(){
		return this.csmStatus;
	}
	
	/**
	* 状态 [非空]     
	**/
	public void setCsmStatus(Short csmStatus){
		this.csmStatus = csmStatus;
	}
}