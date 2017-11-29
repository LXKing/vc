package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsMachineCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsMachineQuery {
	
	private Integer csmIdEquals;
	private Integer[] csmIdIn;
	private Boolean csmIdIsNull;
	private Boolean csmIdIsNotNull;
	
	private Integer csmIdStart;
	
	private Integer csmIdEnd;
	
	private Integer csmIdLess;
	
	private Integer csmIdGreater;
	
	private Integer csmAccessEquals;
	private Integer[] csmAccessIn;
	private Boolean csmAccessIsNull;
	private Boolean csmAccessIsNotNull;
	
	private Integer csmAccessStart;
	
	private Integer csmAccessEnd;
	
	private Integer csmAccessLess;
	
	private Integer csmAccessGreater;
	
	private Integer csmHostEquals;
	private Integer[] csmHostIn;
	private Boolean csmHostIsNull;
	private Boolean csmHostIsNotNull;
	
	private Integer csmHostStart;
	
	private Integer csmHostEnd;
	
	private Integer csmHostLess;
	
	private Integer csmHostGreater;
	private String csmNumberLike;
	
	private String csmNumberEquals;
	private String[] csmNumberIn;
	private Boolean csmNumberIsNull;
	private Boolean csmNumberIsNotNull;
	
	private String csmNumberStart;
	
	private String csmNumberEnd;
	
	private String csmNumberLess;
	
	private String csmNumberGreater;
	private String csmTeNoLike;
	
	private String csmTeNoEquals;
	private String[] csmTeNoIn;
	private Boolean csmTeNoIsNull;
	private Boolean csmTeNoIsNotNull;
	
	private String csmTeNoStart;
	
	private String csmTeNoEnd;
	
	private String csmTeNoLess;
	
	private String csmTeNoGreater;
	
	private Short csmTeTypeEquals;
	private Short[] csmTeTypeIn;
	private Boolean csmTeTypeIsNull;
	private Boolean csmTeTypeIsNotNull;
	
	private Short csmTeTypeStart;
	
	private Short csmTeTypeEnd;
	
	private Short csmTeTypeLess;
	
	private Short csmTeTypeGreater;
	private String csmTeModelLike;
	
	private String csmTeModelEquals;
	private String[] csmTeModelIn;
	private Boolean csmTeModelIsNull;
	private Boolean csmTeModelIsNotNull;
	
	private String csmTeModelStart;
	
	private String csmTeModelEnd;
	
	private String csmTeModelLess;
	
	private String csmTeModelGreater;
	private String csmTeCodeLike;
	
	private String csmTeCodeEquals;
	private String[] csmTeCodeIn;
	private Boolean csmTeCodeIsNull;
	private Boolean csmTeCodeIsNotNull;
	
	private String csmTeCodeStart;
	
	private String csmTeCodeEnd;
	
	private String csmTeCodeLess;
	
	private String csmTeCodeGreater;
	private String csmTeLotNoLike;
	
	private String csmTeLotNoEquals;
	private String[] csmTeLotNoIn;
	private Boolean csmTeLotNoIsNull;
	private Boolean csmTeLotNoIsNotNull;
	
	private String csmTeLotNoStart;
	
	private String csmTeLotNoEnd;
	
	private String csmTeLotNoLess;
	
	private String csmTeLotNoGreater;
	private String csmTeSerialLike;
	
	private String csmTeSerialEquals;
	private String[] csmTeSerialIn;
	private Boolean csmTeSerialIsNull;
	private Boolean csmTeSerialIsNotNull;
	
	private String csmTeSerialStart;
	
	private String csmTeSerialEnd;
	
	private String csmTeSerialLess;
	
	private String csmTeSerialGreater;
	private String csmMobileLike;
	
	private String csmMobileEquals;
	private String[] csmMobileIn;
	private Boolean csmMobileIsNull;
	private Boolean csmMobileIsNotNull;
	
	private String csmMobileStart;
	
	private String csmMobileEnd;
	
	private String csmMobileLess;
	
	private String csmMobileGreater;
	private String csmIccidLike;
	
	private String csmIccidEquals;
	private String[] csmIccidIn;
	private Boolean csmIccidIsNull;
	private Boolean csmIccidIsNotNull;
	
	private String csmIccidStart;
	
	private String csmIccidEnd;
	
	private String csmIccidLess;
	
	private String csmIccidGreater;
	private String csmPasswordLike;
	
	private String csmPasswordEquals;
	private String[] csmPasswordIn;
	private Boolean csmPasswordIsNull;
	private Boolean csmPasswordIsNotNull;
	
	private String csmPasswordStart;
	
	private String csmPasswordEnd;
	
	private String csmPasswordLess;
	
	private String csmPasswordGreater;
	
	private Long csmProtocolEquals;
	private Long[] csmProtocolIn;
	private Boolean csmProtocolIsNull;
	private Boolean csmProtocolIsNotNull;
	
	private Long csmProtocolStart;
	
	private Long csmProtocolEnd;
	
	private Long csmProtocolLess;
	
	private Long csmProtocolGreater;
	private String csmFunctionsLike;
	
	private String csmFunctionsEquals;
	private String[] csmFunctionsIn;
	private Boolean csmFunctionsIsNull;
	private Boolean csmFunctionsIsNotNull;
	
	private String csmFunctionsStart;
	
	private String csmFunctionsEnd;
	
	private String csmFunctionsLess;
	
	private String csmFunctionsGreater;
	
	private Integer csmBluetoothVersionEquals;
	private Integer[] csmBluetoothVersionIn;
	private Boolean csmBluetoothVersionIsNull;
	private Boolean csmBluetoothVersionIsNotNull;
	
	private Integer csmBluetoothVersionStart;
	
	private Integer csmBluetoothVersionEnd;
	
	private Integer csmBluetoothVersionLess;
	
	private Integer csmBluetoothVersionGreater;
	private String csmBluetoothMacLike;
	
	private String csmBluetoothMacEquals;
	private String[] csmBluetoothMacIn;
	private Boolean csmBluetoothMacIsNull;
	private Boolean csmBluetoothMacIsNotNull;
	
	private String csmBluetoothMacStart;
	
	private String csmBluetoothMacEnd;
	
	private String csmBluetoothMacLess;
	
	private String csmBluetoothMacGreater;
	private String csmBluetoothPsdLike;
	
	private String csmBluetoothPsdEquals;
	private String[] csmBluetoothPsdIn;
	private Boolean csmBluetoothPsdIsNull;
	private Boolean csmBluetoothPsdIsNotNull;
	
	private String csmBluetoothPsdStart;
	
	private String csmBluetoothPsdEnd;
	
	private String csmBluetoothPsdLess;
	
	private String csmBluetoothPsdGreater;
	private String csmMqttFlagLike;
	
	private String csmMqttFlagEquals;
	private String[] csmMqttFlagIn;
	private Boolean csmMqttFlagIsNull;
	private Boolean csmMqttFlagIsNotNull;
	
	private String csmMqttFlagStart;
	
	private String csmMqttFlagEnd;
	
	private String csmMqttFlagLess;
	
	private String csmMqttFlagGreater;
	private String csmSuperSimLike;
	
	private String csmSuperSimEquals;
	private String[] csmSuperSimIn;
	private Boolean csmSuperSimIsNull;
	private Boolean csmSuperSimIsNotNull;
	
	private String csmSuperSimStart;
	
	private String csmSuperSimEnd;
	
	private String csmSuperSimLess;
	
	private String csmSuperSimGreater;
	private String csmLandmarkLike;
	
	private String csmLandmarkEquals;
	private String[] csmLandmarkIn;
	private Boolean csmLandmarkIsNull;
	private Boolean csmLandmarkIsNotNull;
	
	private String csmLandmarkStart;
	
	private String csmLandmarkEnd;
	
	private String csmLandmarkLess;
	
	private String csmLandmarkGreater;
	private String csmV2Like;
	
	private String csmV2Equals;
	private String[] csmV2In;
	private Boolean csmV2IsNull;
	private Boolean csmV2IsNotNull;
	
	private String csmV2Start;
	
	private String csmV2End;
	
	private String csmV2Less;
	
	private String csmV2Greater;
	private String csmV3Like;
	
	private String csmV3Equals;
	private String[] csmV3In;
	private Boolean csmV3IsNull;
	private Boolean csmV3IsNotNull;
	
	private String csmV3Start;
	
	private String csmV3End;
	
	private String csmV3Less;
	
	private String csmV3Greater;
	private String csmV3ToLike;
	
	private String csmV3ToEquals;
	private String[] csmV3ToIn;
	private Boolean csmV3ToIsNull;
	private Boolean csmV3ToIsNotNull;
	
	private String csmV3ToStart;
	
	private String csmV3ToEnd;
	
	private String csmV3ToLess;
	
	private String csmV3ToGreater;
	
	private Integer csmSuitEquals;
	private Integer[] csmSuitIn;
	private Boolean csmSuitIsNull;
	private Boolean csmSuitIsNotNull;
	
	private Integer csmSuitStart;
	
	private Integer csmSuitEnd;
	
	private Integer csmSuitLess;
	
	private Integer csmSuitGreater;
	private String csmTlV1Like;
	
	private String csmTlV1Equals;
	private String[] csmTlV1In;
	private Boolean csmTlV1IsNull;
	private Boolean csmTlV1IsNotNull;
	
	private String csmTlV1Start;
	
	private String csmTlV1End;
	
	private String csmTlV1Less;
	
	private String csmTlV1Greater;
	
	private Integer csmTlV2Equals;
	private Integer[] csmTlV2In;
	private Boolean csmTlV2IsNull;
	private Boolean csmTlV2IsNotNull;
	
	private Integer csmTlV2Start;
	
	private Integer csmTlV2End;
	
	private Integer csmTlV2Less;
	
	private Integer csmTlV2Greater;
	
	private Short csmNetTypeEquals;
	private Short[] csmNetTypeIn;
	private Boolean csmNetTypeIsNull;
	private Boolean csmNetTypeIsNotNull;
	
	private Short csmNetTypeStart;
	
	private Short csmNetTypeEnd;
	
	private Short csmNetTypeLess;
	
	private Short csmNetTypeGreater;
	
	private Short csmProTypeEquals;
	private Short[] csmProTypeIn;
	private Boolean csmProTypeIsNull;
	private Boolean csmProTypeIsNotNull;
	
	private Short csmProTypeStart;
	
	private Short csmProTypeEnd;
	
	private Short csmProTypeLess;
	
	private Short csmProTypeGreater;
	
	private Integer csmBaudRateEquals;
	private Integer[] csmBaudRateIn;
	private Boolean csmBaudRateIsNull;
	private Boolean csmBaudRateIsNotNull;
	
	private Integer csmBaudRateStart;
	
	private Integer csmBaudRateEnd;
	
	private Integer csmBaudRateLess;
	
	private Integer csmBaudRateGreater;
	private String csmRemarkLike;
	
	private String csmRemarkEquals;
	private String[] csmRemarkIn;
	private Boolean csmRemarkIsNull;
	private Boolean csmRemarkIsNotNull;
	
	private String csmRemarkStart;
	
	private String csmRemarkEnd;
	
	private String csmRemarkLess;
	
	private String csmRemarkGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmUpdateTimeEquals;
	private Date[] csmUpdateTimeIn;
	private Boolean csmUpdateTimeIsNull;
	private Boolean csmUpdateTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmUpdateTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmUpdateTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmUpdateTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmUpdateTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmAddTimeEquals;
	private Date[] csmAddTimeIn;
	private Boolean csmAddTimeIsNull;
	private Boolean csmAddTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmAddTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date csmAddTimeGreater;
	
	private Short csmStatusEquals;
	private Short[] csmStatusIn;
	private Boolean csmStatusIsNull;
	private Boolean csmStatusIsNotNull;
	
	private Short csmStatusStart;
	
	private Short csmStatusEnd;
	
	private Short csmStatusLess;
	
	private Short csmStatusGreater;
	private String sidx;
	private String sord;

	public CsMachineQuery setCsmIdEquals(Integer csmIdEquals){
		this.csmIdEquals = csmIdEquals;
		return this;
	}
	public Integer getCsmIdEquals(){
		return this.csmIdEquals;
	}
	public CsMachineQuery setCsmIdIn(Integer[] csmIdIn){
		this.csmIdIn = csmIdIn;
		return this;
	}
	public Integer[] getCsmIdIn(){
		return this.csmIdIn;
	}
	public CsMachineQuery setCsmIdIsNull(Boolean csmIdIsNull){
		this.csmIdIsNull = csmIdIsNull;
		return this;
	}
	public Boolean getCsmIdIsNull(){
		return this.csmIdIsNull;
	}
	public CsMachineQuery setCsmIdIsNotNull(Boolean csmIdIsNotNull){
		this.csmIdIsNotNull = csmIdIsNotNull;
		return this;
	}
	public Boolean getCsmIdIsNotNull(){
		return this.csmIdIsNotNull;
	}
	public CsMachineQuery setCsmIdStart(Integer csmIdStart){
		this.csmIdStart = csmIdStart;
		return this;
	}
	public Integer getCsmIdStart(){
		return this.csmIdStart;
	}
	public CsMachineQuery setCsmIdEnd(Integer csmIdEnd){
		this.csmIdEnd = csmIdEnd;
		return this;
	}
	public Integer getCsmIdEnd(){
		return this.csmIdEnd;
	}
	public CsMachineQuery setCsmIdLess(Integer csmIdLess){
		this.csmIdLess = csmIdLess;
		return this;
	}
	public Integer getCsmIdLess(){
		return this.csmIdLess;
	}
	public CsMachineQuery setCsmIdGreater(Integer csmIdGreater){
		this.csmIdGreater = csmIdGreater;
		return this;
	}
	public Integer getCsmIdGreater(){
		return this.csmIdGreater;
	}
	public CsMachineQuery setCsmAccessEquals(Integer csmAccessEquals){
		this.csmAccessEquals = csmAccessEquals;
		return this;
	}
	public Integer getCsmAccessEquals(){
		return this.csmAccessEquals;
	}
	public CsMachineQuery setCsmAccessIn(Integer[] csmAccessIn){
		this.csmAccessIn = csmAccessIn;
		return this;
	}
	public Integer[] getCsmAccessIn(){
		return this.csmAccessIn;
	}
	public CsMachineQuery setCsmAccessIsNull(Boolean csmAccessIsNull){
		this.csmAccessIsNull = csmAccessIsNull;
		return this;
	}
	public Boolean getCsmAccessIsNull(){
		return this.csmAccessIsNull;
	}
	public CsMachineQuery setCsmAccessIsNotNull(Boolean csmAccessIsNotNull){
		this.csmAccessIsNotNull = csmAccessIsNotNull;
		return this;
	}
	public Boolean getCsmAccessIsNotNull(){
		return this.csmAccessIsNotNull;
	}
	public CsMachineQuery setCsmAccessStart(Integer csmAccessStart){
		this.csmAccessStart = csmAccessStart;
		return this;
	}
	public Integer getCsmAccessStart(){
		return this.csmAccessStart;
	}
	public CsMachineQuery setCsmAccessEnd(Integer csmAccessEnd){
		this.csmAccessEnd = csmAccessEnd;
		return this;
	}
	public Integer getCsmAccessEnd(){
		return this.csmAccessEnd;
	}
	public CsMachineQuery setCsmAccessLess(Integer csmAccessLess){
		this.csmAccessLess = csmAccessLess;
		return this;
	}
	public Integer getCsmAccessLess(){
		return this.csmAccessLess;
	}
	public CsMachineQuery setCsmAccessGreater(Integer csmAccessGreater){
		this.csmAccessGreater = csmAccessGreater;
		return this;
	}
	public Integer getCsmAccessGreater(){
		return this.csmAccessGreater;
	}
	public CsMachineQuery setCsmHostEquals(Integer csmHostEquals){
		this.csmHostEquals = csmHostEquals;
		return this;
	}
	public Integer getCsmHostEquals(){
		return this.csmHostEquals;
	}
	public CsMachineQuery setCsmHostIn(Integer[] csmHostIn){
		this.csmHostIn = csmHostIn;
		return this;
	}
	public Integer[] getCsmHostIn(){
		return this.csmHostIn;
	}
	public CsMachineQuery setCsmHostIsNull(Boolean csmHostIsNull){
		this.csmHostIsNull = csmHostIsNull;
		return this;
	}
	public Boolean getCsmHostIsNull(){
		return this.csmHostIsNull;
	}
	public CsMachineQuery setCsmHostIsNotNull(Boolean csmHostIsNotNull){
		this.csmHostIsNotNull = csmHostIsNotNull;
		return this;
	}
	public Boolean getCsmHostIsNotNull(){
		return this.csmHostIsNotNull;
	}
	public CsMachineQuery setCsmHostStart(Integer csmHostStart){
		this.csmHostStart = csmHostStart;
		return this;
	}
	public Integer getCsmHostStart(){
		return this.csmHostStart;
	}
	public CsMachineQuery setCsmHostEnd(Integer csmHostEnd){
		this.csmHostEnd = csmHostEnd;
		return this;
	}
	public Integer getCsmHostEnd(){
		return this.csmHostEnd;
	}
	public CsMachineQuery setCsmHostLess(Integer csmHostLess){
		this.csmHostLess = csmHostLess;
		return this;
	}
	public Integer getCsmHostLess(){
		return this.csmHostLess;
	}
	public CsMachineQuery setCsmHostGreater(Integer csmHostGreater){
		this.csmHostGreater = csmHostGreater;
		return this;
	}
	public Integer getCsmHostGreater(){
		return this.csmHostGreater;
	}
	public CsMachineQuery setCsmNumberLike(String csmNumberLike){
		this.csmNumberLike = csmNumberLike;
		return this;
	}
	public String getCsmNumberLike(){
		return this.csmNumberLike;
	}
	public CsMachineQuery setCsmNumberEquals(String csmNumberEquals){
		this.csmNumberEquals = csmNumberEquals;
		return this;
	}
	public String getCsmNumberEquals(){
		return this.csmNumberEquals;
	}
	public CsMachineQuery setCsmNumberIn(String[] csmNumberIn){
		this.csmNumberIn = csmNumberIn;
		return this;
	}
	public String[] getCsmNumberIn(){
		return this.csmNumberIn;
	}
	public CsMachineQuery setCsmNumberIsNull(Boolean csmNumberIsNull){
		this.csmNumberIsNull = csmNumberIsNull;
		return this;
	}
	public Boolean getCsmNumberIsNull(){
		return this.csmNumberIsNull;
	}
	public CsMachineQuery setCsmNumberIsNotNull(Boolean csmNumberIsNotNull){
		this.csmNumberIsNotNull = csmNumberIsNotNull;
		return this;
	}
	public Boolean getCsmNumberIsNotNull(){
		return this.csmNumberIsNotNull;
	}
	public CsMachineQuery setCsmNumberStart(String csmNumberStart){
		this.csmNumberStart = csmNumberStart;
		return this;
	}
	public String getCsmNumberStart(){
		return this.csmNumberStart;
	}
	public CsMachineQuery setCsmNumberEnd(String csmNumberEnd){
		this.csmNumberEnd = csmNumberEnd;
		return this;
	}
	public String getCsmNumberEnd(){
		return this.csmNumberEnd;
	}
	public CsMachineQuery setCsmNumberLess(String csmNumberLess){
		this.csmNumberLess = csmNumberLess;
		return this;
	}
	public String getCsmNumberLess(){
		return this.csmNumberLess;
	}
	public CsMachineQuery setCsmNumberGreater(String csmNumberGreater){
		this.csmNumberGreater = csmNumberGreater;
		return this;
	}
	public String getCsmNumberGreater(){
		return this.csmNumberGreater;
	}
	public CsMachineQuery setCsmTeNoLike(String csmTeNoLike){
		this.csmTeNoLike = csmTeNoLike;
		return this;
	}
	public String getCsmTeNoLike(){
		return this.csmTeNoLike;
	}
	public CsMachineQuery setCsmTeNoEquals(String csmTeNoEquals){
		this.csmTeNoEquals = csmTeNoEquals;
		return this;
	}
	public String getCsmTeNoEquals(){
		return this.csmTeNoEquals;
	}
	public CsMachineQuery setCsmTeNoIn(String[] csmTeNoIn){
		this.csmTeNoIn = csmTeNoIn;
		return this;
	}
	public String[] getCsmTeNoIn(){
		return this.csmTeNoIn;
	}
	public CsMachineQuery setCsmTeNoIsNull(Boolean csmTeNoIsNull){
		this.csmTeNoIsNull = csmTeNoIsNull;
		return this;
	}
	public Boolean getCsmTeNoIsNull(){
		return this.csmTeNoIsNull;
	}
	public CsMachineQuery setCsmTeNoIsNotNull(Boolean csmTeNoIsNotNull){
		this.csmTeNoIsNotNull = csmTeNoIsNotNull;
		return this;
	}
	public Boolean getCsmTeNoIsNotNull(){
		return this.csmTeNoIsNotNull;
	}
	public CsMachineQuery setCsmTeNoStart(String csmTeNoStart){
		this.csmTeNoStart = csmTeNoStart;
		return this;
	}
	public String getCsmTeNoStart(){
		return this.csmTeNoStart;
	}
	public CsMachineQuery setCsmTeNoEnd(String csmTeNoEnd){
		this.csmTeNoEnd = csmTeNoEnd;
		return this;
	}
	public String getCsmTeNoEnd(){
		return this.csmTeNoEnd;
	}
	public CsMachineQuery setCsmTeNoLess(String csmTeNoLess){
		this.csmTeNoLess = csmTeNoLess;
		return this;
	}
	public String getCsmTeNoLess(){
		return this.csmTeNoLess;
	}
	public CsMachineQuery setCsmTeNoGreater(String csmTeNoGreater){
		this.csmTeNoGreater = csmTeNoGreater;
		return this;
	}
	public String getCsmTeNoGreater(){
		return this.csmTeNoGreater;
	}
	public CsMachineQuery setCsmTeTypeEquals(Short csmTeTypeEquals){
		this.csmTeTypeEquals = csmTeTypeEquals;
		return this;
	}
	public Short getCsmTeTypeEquals(){
		return this.csmTeTypeEquals;
	}
	public CsMachineQuery setCsmTeTypeIn(Short[] csmTeTypeIn){
		this.csmTeTypeIn = csmTeTypeIn;
		return this;
	}
	public Short[] getCsmTeTypeIn(){
		return this.csmTeTypeIn;
	}
	public CsMachineQuery setCsmTeTypeIsNull(Boolean csmTeTypeIsNull){
		this.csmTeTypeIsNull = csmTeTypeIsNull;
		return this;
	}
	public Boolean getCsmTeTypeIsNull(){
		return this.csmTeTypeIsNull;
	}
	public CsMachineQuery setCsmTeTypeIsNotNull(Boolean csmTeTypeIsNotNull){
		this.csmTeTypeIsNotNull = csmTeTypeIsNotNull;
		return this;
	}
	public Boolean getCsmTeTypeIsNotNull(){
		return this.csmTeTypeIsNotNull;
	}
	public CsMachineQuery setCsmTeTypeStart(Short csmTeTypeStart){
		this.csmTeTypeStart = csmTeTypeStart;
		return this;
	}
	public Short getCsmTeTypeStart(){
		return this.csmTeTypeStart;
	}
	public CsMachineQuery setCsmTeTypeEnd(Short csmTeTypeEnd){
		this.csmTeTypeEnd = csmTeTypeEnd;
		return this;
	}
	public Short getCsmTeTypeEnd(){
		return this.csmTeTypeEnd;
	}
	public CsMachineQuery setCsmTeTypeLess(Short csmTeTypeLess){
		this.csmTeTypeLess = csmTeTypeLess;
		return this;
	}
	public Short getCsmTeTypeLess(){
		return this.csmTeTypeLess;
	}
	public CsMachineQuery setCsmTeTypeGreater(Short csmTeTypeGreater){
		this.csmTeTypeGreater = csmTeTypeGreater;
		return this;
	}
	public Short getCsmTeTypeGreater(){
		return this.csmTeTypeGreater;
	}
	public CsMachineQuery setCsmTeModelLike(String csmTeModelLike){
		this.csmTeModelLike = csmTeModelLike;
		return this;
	}
	public String getCsmTeModelLike(){
		return this.csmTeModelLike;
	}
	public CsMachineQuery setCsmTeModelEquals(String csmTeModelEquals){
		this.csmTeModelEquals = csmTeModelEquals;
		return this;
	}
	public String getCsmTeModelEquals(){
		return this.csmTeModelEquals;
	}
	public CsMachineQuery setCsmTeModelIn(String[] csmTeModelIn){
		this.csmTeModelIn = csmTeModelIn;
		return this;
	}
	public String[] getCsmTeModelIn(){
		return this.csmTeModelIn;
	}
	public CsMachineQuery setCsmTeModelIsNull(Boolean csmTeModelIsNull){
		this.csmTeModelIsNull = csmTeModelIsNull;
		return this;
	}
	public Boolean getCsmTeModelIsNull(){
		return this.csmTeModelIsNull;
	}
	public CsMachineQuery setCsmTeModelIsNotNull(Boolean csmTeModelIsNotNull){
		this.csmTeModelIsNotNull = csmTeModelIsNotNull;
		return this;
	}
	public Boolean getCsmTeModelIsNotNull(){
		return this.csmTeModelIsNotNull;
	}
	public CsMachineQuery setCsmTeModelStart(String csmTeModelStart){
		this.csmTeModelStart = csmTeModelStart;
		return this;
	}
	public String getCsmTeModelStart(){
		return this.csmTeModelStart;
	}
	public CsMachineQuery setCsmTeModelEnd(String csmTeModelEnd){
		this.csmTeModelEnd = csmTeModelEnd;
		return this;
	}
	public String getCsmTeModelEnd(){
		return this.csmTeModelEnd;
	}
	public CsMachineQuery setCsmTeModelLess(String csmTeModelLess){
		this.csmTeModelLess = csmTeModelLess;
		return this;
	}
	public String getCsmTeModelLess(){
		return this.csmTeModelLess;
	}
	public CsMachineQuery setCsmTeModelGreater(String csmTeModelGreater){
		this.csmTeModelGreater = csmTeModelGreater;
		return this;
	}
	public String getCsmTeModelGreater(){
		return this.csmTeModelGreater;
	}
	public CsMachineQuery setCsmTeCodeLike(String csmTeCodeLike){
		this.csmTeCodeLike = csmTeCodeLike;
		return this;
	}
	public String getCsmTeCodeLike(){
		return this.csmTeCodeLike;
	}
	public CsMachineQuery setCsmTeCodeEquals(String csmTeCodeEquals){
		this.csmTeCodeEquals = csmTeCodeEquals;
		return this;
	}
	public String getCsmTeCodeEquals(){
		return this.csmTeCodeEquals;
	}
	public CsMachineQuery setCsmTeCodeIn(String[] csmTeCodeIn){
		this.csmTeCodeIn = csmTeCodeIn;
		return this;
	}
	public String[] getCsmTeCodeIn(){
		return this.csmTeCodeIn;
	}
	public CsMachineQuery setCsmTeCodeIsNull(Boolean csmTeCodeIsNull){
		this.csmTeCodeIsNull = csmTeCodeIsNull;
		return this;
	}
	public Boolean getCsmTeCodeIsNull(){
		return this.csmTeCodeIsNull;
	}
	public CsMachineQuery setCsmTeCodeIsNotNull(Boolean csmTeCodeIsNotNull){
		this.csmTeCodeIsNotNull = csmTeCodeIsNotNull;
		return this;
	}
	public Boolean getCsmTeCodeIsNotNull(){
		return this.csmTeCodeIsNotNull;
	}
	public CsMachineQuery setCsmTeCodeStart(String csmTeCodeStart){
		this.csmTeCodeStart = csmTeCodeStart;
		return this;
	}
	public String getCsmTeCodeStart(){
		return this.csmTeCodeStart;
	}
	public CsMachineQuery setCsmTeCodeEnd(String csmTeCodeEnd){
		this.csmTeCodeEnd = csmTeCodeEnd;
		return this;
	}
	public String getCsmTeCodeEnd(){
		return this.csmTeCodeEnd;
	}
	public CsMachineQuery setCsmTeCodeLess(String csmTeCodeLess){
		this.csmTeCodeLess = csmTeCodeLess;
		return this;
	}
	public String getCsmTeCodeLess(){
		return this.csmTeCodeLess;
	}
	public CsMachineQuery setCsmTeCodeGreater(String csmTeCodeGreater){
		this.csmTeCodeGreater = csmTeCodeGreater;
		return this;
	}
	public String getCsmTeCodeGreater(){
		return this.csmTeCodeGreater;
	}
	public CsMachineQuery setCsmTeLotNoLike(String csmTeLotNoLike){
		this.csmTeLotNoLike = csmTeLotNoLike;
		return this;
	}
	public String getCsmTeLotNoLike(){
		return this.csmTeLotNoLike;
	}
	public CsMachineQuery setCsmTeLotNoEquals(String csmTeLotNoEquals){
		this.csmTeLotNoEquals = csmTeLotNoEquals;
		return this;
	}
	public String getCsmTeLotNoEquals(){
		return this.csmTeLotNoEquals;
	}
	public CsMachineQuery setCsmTeLotNoIn(String[] csmTeLotNoIn){
		this.csmTeLotNoIn = csmTeLotNoIn;
		return this;
	}
	public String[] getCsmTeLotNoIn(){
		return this.csmTeLotNoIn;
	}
	public CsMachineQuery setCsmTeLotNoIsNull(Boolean csmTeLotNoIsNull){
		this.csmTeLotNoIsNull = csmTeLotNoIsNull;
		return this;
	}
	public Boolean getCsmTeLotNoIsNull(){
		return this.csmTeLotNoIsNull;
	}
	public CsMachineQuery setCsmTeLotNoIsNotNull(Boolean csmTeLotNoIsNotNull){
		this.csmTeLotNoIsNotNull = csmTeLotNoIsNotNull;
		return this;
	}
	public Boolean getCsmTeLotNoIsNotNull(){
		return this.csmTeLotNoIsNotNull;
	}
	public CsMachineQuery setCsmTeLotNoStart(String csmTeLotNoStart){
		this.csmTeLotNoStart = csmTeLotNoStart;
		return this;
	}
	public String getCsmTeLotNoStart(){
		return this.csmTeLotNoStart;
	}
	public CsMachineQuery setCsmTeLotNoEnd(String csmTeLotNoEnd){
		this.csmTeLotNoEnd = csmTeLotNoEnd;
		return this;
	}
	public String getCsmTeLotNoEnd(){
		return this.csmTeLotNoEnd;
	}
	public CsMachineQuery setCsmTeLotNoLess(String csmTeLotNoLess){
		this.csmTeLotNoLess = csmTeLotNoLess;
		return this;
	}
	public String getCsmTeLotNoLess(){
		return this.csmTeLotNoLess;
	}
	public CsMachineQuery setCsmTeLotNoGreater(String csmTeLotNoGreater){
		this.csmTeLotNoGreater = csmTeLotNoGreater;
		return this;
	}
	public String getCsmTeLotNoGreater(){
		return this.csmTeLotNoGreater;
	}
	public CsMachineQuery setCsmTeSerialLike(String csmTeSerialLike){
		this.csmTeSerialLike = csmTeSerialLike;
		return this;
	}
	public String getCsmTeSerialLike(){
		return this.csmTeSerialLike;
	}
	public CsMachineQuery setCsmTeSerialEquals(String csmTeSerialEquals){
		this.csmTeSerialEquals = csmTeSerialEquals;
		return this;
	}
	public String getCsmTeSerialEquals(){
		return this.csmTeSerialEquals;
	}
	public CsMachineQuery setCsmTeSerialIn(String[] csmTeSerialIn){
		this.csmTeSerialIn = csmTeSerialIn;
		return this;
	}
	public String[] getCsmTeSerialIn(){
		return this.csmTeSerialIn;
	}
	public CsMachineQuery setCsmTeSerialIsNull(Boolean csmTeSerialIsNull){
		this.csmTeSerialIsNull = csmTeSerialIsNull;
		return this;
	}
	public Boolean getCsmTeSerialIsNull(){
		return this.csmTeSerialIsNull;
	}
	public CsMachineQuery setCsmTeSerialIsNotNull(Boolean csmTeSerialIsNotNull){
		this.csmTeSerialIsNotNull = csmTeSerialIsNotNull;
		return this;
	}
	public Boolean getCsmTeSerialIsNotNull(){
		return this.csmTeSerialIsNotNull;
	}
	public CsMachineQuery setCsmTeSerialStart(String csmTeSerialStart){
		this.csmTeSerialStart = csmTeSerialStart;
		return this;
	}
	public String getCsmTeSerialStart(){
		return this.csmTeSerialStart;
	}
	public CsMachineQuery setCsmTeSerialEnd(String csmTeSerialEnd){
		this.csmTeSerialEnd = csmTeSerialEnd;
		return this;
	}
	public String getCsmTeSerialEnd(){
		return this.csmTeSerialEnd;
	}
	public CsMachineQuery setCsmTeSerialLess(String csmTeSerialLess){
		this.csmTeSerialLess = csmTeSerialLess;
		return this;
	}
	public String getCsmTeSerialLess(){
		return this.csmTeSerialLess;
	}
	public CsMachineQuery setCsmTeSerialGreater(String csmTeSerialGreater){
		this.csmTeSerialGreater = csmTeSerialGreater;
		return this;
	}
	public String getCsmTeSerialGreater(){
		return this.csmTeSerialGreater;
	}
	public CsMachineQuery setCsmMobileLike(String csmMobileLike){
		this.csmMobileLike = csmMobileLike;
		return this;
	}
	public String getCsmMobileLike(){
		return this.csmMobileLike;
	}
	public CsMachineQuery setCsmMobileEquals(String csmMobileEquals){
		this.csmMobileEquals = csmMobileEquals;
		return this;
	}
	public String getCsmMobileEquals(){
		return this.csmMobileEquals;
	}
	public CsMachineQuery setCsmMobileIn(String[] csmMobileIn){
		this.csmMobileIn = csmMobileIn;
		return this;
	}
	public String[] getCsmMobileIn(){
		return this.csmMobileIn;
	}
	public CsMachineQuery setCsmMobileIsNull(Boolean csmMobileIsNull){
		this.csmMobileIsNull = csmMobileIsNull;
		return this;
	}
	public Boolean getCsmMobileIsNull(){
		return this.csmMobileIsNull;
	}
	public CsMachineQuery setCsmMobileIsNotNull(Boolean csmMobileIsNotNull){
		this.csmMobileIsNotNull = csmMobileIsNotNull;
		return this;
	}
	public Boolean getCsmMobileIsNotNull(){
		return this.csmMobileIsNotNull;
	}
	public CsMachineQuery setCsmMobileStart(String csmMobileStart){
		this.csmMobileStart = csmMobileStart;
		return this;
	}
	public String getCsmMobileStart(){
		return this.csmMobileStart;
	}
	public CsMachineQuery setCsmMobileEnd(String csmMobileEnd){
		this.csmMobileEnd = csmMobileEnd;
		return this;
	}
	public String getCsmMobileEnd(){
		return this.csmMobileEnd;
	}
	public CsMachineQuery setCsmMobileLess(String csmMobileLess){
		this.csmMobileLess = csmMobileLess;
		return this;
	}
	public String getCsmMobileLess(){
		return this.csmMobileLess;
	}
	public CsMachineQuery setCsmMobileGreater(String csmMobileGreater){
		this.csmMobileGreater = csmMobileGreater;
		return this;
	}
	public String getCsmMobileGreater(){
		return this.csmMobileGreater;
	}
	public CsMachineQuery setCsmIccidLike(String csmIccidLike){
		this.csmIccidLike = csmIccidLike;
		return this;
	}
	public String getCsmIccidLike(){
		return this.csmIccidLike;
	}
	public CsMachineQuery setCsmIccidEquals(String csmIccidEquals){
		this.csmIccidEquals = csmIccidEquals;
		return this;
	}
	public String getCsmIccidEquals(){
		return this.csmIccidEquals;
	}
	public CsMachineQuery setCsmIccidIn(String[] csmIccidIn){
		this.csmIccidIn = csmIccidIn;
		return this;
	}
	public String[] getCsmIccidIn(){
		return this.csmIccidIn;
	}
	public CsMachineQuery setCsmIccidIsNull(Boolean csmIccidIsNull){
		this.csmIccidIsNull = csmIccidIsNull;
		return this;
	}
	public Boolean getCsmIccidIsNull(){
		return this.csmIccidIsNull;
	}
	public CsMachineQuery setCsmIccidIsNotNull(Boolean csmIccidIsNotNull){
		this.csmIccidIsNotNull = csmIccidIsNotNull;
		return this;
	}
	public Boolean getCsmIccidIsNotNull(){
		return this.csmIccidIsNotNull;
	}
	public CsMachineQuery setCsmIccidStart(String csmIccidStart){
		this.csmIccidStart = csmIccidStart;
		return this;
	}
	public String getCsmIccidStart(){
		return this.csmIccidStart;
	}
	public CsMachineQuery setCsmIccidEnd(String csmIccidEnd){
		this.csmIccidEnd = csmIccidEnd;
		return this;
	}
	public String getCsmIccidEnd(){
		return this.csmIccidEnd;
	}
	public CsMachineQuery setCsmIccidLess(String csmIccidLess){
		this.csmIccidLess = csmIccidLess;
		return this;
	}
	public String getCsmIccidLess(){
		return this.csmIccidLess;
	}
	public CsMachineQuery setCsmIccidGreater(String csmIccidGreater){
		this.csmIccidGreater = csmIccidGreater;
		return this;
	}
	public String getCsmIccidGreater(){
		return this.csmIccidGreater;
	}
	public CsMachineQuery setCsmPasswordLike(String csmPasswordLike){
		this.csmPasswordLike = csmPasswordLike;
		return this;
	}
	public String getCsmPasswordLike(){
		return this.csmPasswordLike;
	}
	public CsMachineQuery setCsmPasswordEquals(String csmPasswordEquals){
		this.csmPasswordEquals = csmPasswordEquals;
		return this;
	}
	public String getCsmPasswordEquals(){
		return this.csmPasswordEquals;
	}
	public CsMachineQuery setCsmPasswordIn(String[] csmPasswordIn){
		this.csmPasswordIn = csmPasswordIn;
		return this;
	}
	public String[] getCsmPasswordIn(){
		return this.csmPasswordIn;
	}
	public CsMachineQuery setCsmPasswordIsNull(Boolean csmPasswordIsNull){
		this.csmPasswordIsNull = csmPasswordIsNull;
		return this;
	}
	public Boolean getCsmPasswordIsNull(){
		return this.csmPasswordIsNull;
	}
	public CsMachineQuery setCsmPasswordIsNotNull(Boolean csmPasswordIsNotNull){
		this.csmPasswordIsNotNull = csmPasswordIsNotNull;
		return this;
	}
	public Boolean getCsmPasswordIsNotNull(){
		return this.csmPasswordIsNotNull;
	}
	public CsMachineQuery setCsmPasswordStart(String csmPasswordStart){
		this.csmPasswordStart = csmPasswordStart;
		return this;
	}
	public String getCsmPasswordStart(){
		return this.csmPasswordStart;
	}
	public CsMachineQuery setCsmPasswordEnd(String csmPasswordEnd){
		this.csmPasswordEnd = csmPasswordEnd;
		return this;
	}
	public String getCsmPasswordEnd(){
		return this.csmPasswordEnd;
	}
	public CsMachineQuery setCsmPasswordLess(String csmPasswordLess){
		this.csmPasswordLess = csmPasswordLess;
		return this;
	}
	public String getCsmPasswordLess(){
		return this.csmPasswordLess;
	}
	public CsMachineQuery setCsmPasswordGreater(String csmPasswordGreater){
		this.csmPasswordGreater = csmPasswordGreater;
		return this;
	}
	public String getCsmPasswordGreater(){
		return this.csmPasswordGreater;
	}
	public CsMachineQuery setCsmProtocolEquals(Long csmProtocolEquals){
		this.csmProtocolEquals = csmProtocolEquals;
		return this;
	}
	public Long getCsmProtocolEquals(){
		return this.csmProtocolEquals;
	}
	public CsMachineQuery setCsmProtocolIn(Long[] csmProtocolIn){
		this.csmProtocolIn = csmProtocolIn;
		return this;
	}
	public Long[] getCsmProtocolIn(){
		return this.csmProtocolIn;
	}
	public CsMachineQuery setCsmProtocolIsNull(Boolean csmProtocolIsNull){
		this.csmProtocolIsNull = csmProtocolIsNull;
		return this;
	}
	public Boolean getCsmProtocolIsNull(){
		return this.csmProtocolIsNull;
	}
	public CsMachineQuery setCsmProtocolIsNotNull(Boolean csmProtocolIsNotNull){
		this.csmProtocolIsNotNull = csmProtocolIsNotNull;
		return this;
	}
	public Boolean getCsmProtocolIsNotNull(){
		return this.csmProtocolIsNotNull;
	}
	public CsMachineQuery setCsmProtocolStart(Long csmProtocolStart){
		this.csmProtocolStart = csmProtocolStart;
		return this;
	}
	public Long getCsmProtocolStart(){
		return this.csmProtocolStart;
	}
	public CsMachineQuery setCsmProtocolEnd(Long csmProtocolEnd){
		this.csmProtocolEnd = csmProtocolEnd;
		return this;
	}
	public Long getCsmProtocolEnd(){
		return this.csmProtocolEnd;
	}
	public CsMachineQuery setCsmProtocolLess(Long csmProtocolLess){
		this.csmProtocolLess = csmProtocolLess;
		return this;
	}
	public Long getCsmProtocolLess(){
		return this.csmProtocolLess;
	}
	public CsMachineQuery setCsmProtocolGreater(Long csmProtocolGreater){
		this.csmProtocolGreater = csmProtocolGreater;
		return this;
	}
	public Long getCsmProtocolGreater(){
		return this.csmProtocolGreater;
	}
	public CsMachineQuery setCsmFunctionsLike(String csmFunctionsLike){
		this.csmFunctionsLike = csmFunctionsLike;
		return this;
	}
	public String getCsmFunctionsLike(){
		return this.csmFunctionsLike;
	}
	public CsMachineQuery setCsmFunctionsEquals(String csmFunctionsEquals){
		this.csmFunctionsEquals = csmFunctionsEquals;
		return this;
	}
	public String getCsmFunctionsEquals(){
		return this.csmFunctionsEquals;
	}
	public CsMachineQuery setCsmFunctionsIn(String[] csmFunctionsIn){
		this.csmFunctionsIn = csmFunctionsIn;
		return this;
	}
	public String[] getCsmFunctionsIn(){
		return this.csmFunctionsIn;
	}
	public CsMachineQuery setCsmFunctionsIsNull(Boolean csmFunctionsIsNull){
		this.csmFunctionsIsNull = csmFunctionsIsNull;
		return this;
	}
	public Boolean getCsmFunctionsIsNull(){
		return this.csmFunctionsIsNull;
	}
	public CsMachineQuery setCsmFunctionsIsNotNull(Boolean csmFunctionsIsNotNull){
		this.csmFunctionsIsNotNull = csmFunctionsIsNotNull;
		return this;
	}
	public Boolean getCsmFunctionsIsNotNull(){
		return this.csmFunctionsIsNotNull;
	}
	public CsMachineQuery setCsmFunctionsStart(String csmFunctionsStart){
		this.csmFunctionsStart = csmFunctionsStart;
		return this;
	}
	public String getCsmFunctionsStart(){
		return this.csmFunctionsStart;
	}
	public CsMachineQuery setCsmFunctionsEnd(String csmFunctionsEnd){
		this.csmFunctionsEnd = csmFunctionsEnd;
		return this;
	}
	public String getCsmFunctionsEnd(){
		return this.csmFunctionsEnd;
	}
	public CsMachineQuery setCsmFunctionsLess(String csmFunctionsLess){
		this.csmFunctionsLess = csmFunctionsLess;
		return this;
	}
	public String getCsmFunctionsLess(){
		return this.csmFunctionsLess;
	}
	public CsMachineQuery setCsmFunctionsGreater(String csmFunctionsGreater){
		this.csmFunctionsGreater = csmFunctionsGreater;
		return this;
	}
	public String getCsmFunctionsGreater(){
		return this.csmFunctionsGreater;
	}
	public CsMachineQuery setCsmBluetoothVersionEquals(Integer csmBluetoothVersionEquals){
		this.csmBluetoothVersionEquals = csmBluetoothVersionEquals;
		return this;
	}
	public Integer getCsmBluetoothVersionEquals(){
		return this.csmBluetoothVersionEquals;
	}
	public CsMachineQuery setCsmBluetoothVersionIn(Integer[] csmBluetoothVersionIn){
		this.csmBluetoothVersionIn = csmBluetoothVersionIn;
		return this;
	}
	public Integer[] getCsmBluetoothVersionIn(){
		return this.csmBluetoothVersionIn;
	}
	public CsMachineQuery setCsmBluetoothVersionIsNull(Boolean csmBluetoothVersionIsNull){
		this.csmBluetoothVersionIsNull = csmBluetoothVersionIsNull;
		return this;
	}
	public Boolean getCsmBluetoothVersionIsNull(){
		return this.csmBluetoothVersionIsNull;
	}
	public CsMachineQuery setCsmBluetoothVersionIsNotNull(Boolean csmBluetoothVersionIsNotNull){
		this.csmBluetoothVersionIsNotNull = csmBluetoothVersionIsNotNull;
		return this;
	}
	public Boolean getCsmBluetoothVersionIsNotNull(){
		return this.csmBluetoothVersionIsNotNull;
	}
	public CsMachineQuery setCsmBluetoothVersionStart(Integer csmBluetoothVersionStart){
		this.csmBluetoothVersionStart = csmBluetoothVersionStart;
		return this;
	}
	public Integer getCsmBluetoothVersionStart(){
		return this.csmBluetoothVersionStart;
	}
	public CsMachineQuery setCsmBluetoothVersionEnd(Integer csmBluetoothVersionEnd){
		this.csmBluetoothVersionEnd = csmBluetoothVersionEnd;
		return this;
	}
	public Integer getCsmBluetoothVersionEnd(){
		return this.csmBluetoothVersionEnd;
	}
	public CsMachineQuery setCsmBluetoothVersionLess(Integer csmBluetoothVersionLess){
		this.csmBluetoothVersionLess = csmBluetoothVersionLess;
		return this;
	}
	public Integer getCsmBluetoothVersionLess(){
		return this.csmBluetoothVersionLess;
	}
	public CsMachineQuery setCsmBluetoothVersionGreater(Integer csmBluetoothVersionGreater){
		this.csmBluetoothVersionGreater = csmBluetoothVersionGreater;
		return this;
	}
	public Integer getCsmBluetoothVersionGreater(){
		return this.csmBluetoothVersionGreater;
	}
	public CsMachineQuery setCsmBluetoothMacLike(String csmBluetoothMacLike){
		this.csmBluetoothMacLike = csmBluetoothMacLike;
		return this;
	}
	public String getCsmBluetoothMacLike(){
		return this.csmBluetoothMacLike;
	}
	public CsMachineQuery setCsmBluetoothMacEquals(String csmBluetoothMacEquals){
		this.csmBluetoothMacEquals = csmBluetoothMacEquals;
		return this;
	}
	public String getCsmBluetoothMacEquals(){
		return this.csmBluetoothMacEquals;
	}
	public CsMachineQuery setCsmBluetoothMacIn(String[] csmBluetoothMacIn){
		this.csmBluetoothMacIn = csmBluetoothMacIn;
		return this;
	}
	public String[] getCsmBluetoothMacIn(){
		return this.csmBluetoothMacIn;
	}
	public CsMachineQuery setCsmBluetoothMacIsNull(Boolean csmBluetoothMacIsNull){
		this.csmBluetoothMacIsNull = csmBluetoothMacIsNull;
		return this;
	}
	public Boolean getCsmBluetoothMacIsNull(){
		return this.csmBluetoothMacIsNull;
	}
	public CsMachineQuery setCsmBluetoothMacIsNotNull(Boolean csmBluetoothMacIsNotNull){
		this.csmBluetoothMacIsNotNull = csmBluetoothMacIsNotNull;
		return this;
	}
	public Boolean getCsmBluetoothMacIsNotNull(){
		return this.csmBluetoothMacIsNotNull;
	}
	public CsMachineQuery setCsmBluetoothMacStart(String csmBluetoothMacStart){
		this.csmBluetoothMacStart = csmBluetoothMacStart;
		return this;
	}
	public String getCsmBluetoothMacStart(){
		return this.csmBluetoothMacStart;
	}
	public CsMachineQuery setCsmBluetoothMacEnd(String csmBluetoothMacEnd){
		this.csmBluetoothMacEnd = csmBluetoothMacEnd;
		return this;
	}
	public String getCsmBluetoothMacEnd(){
		return this.csmBluetoothMacEnd;
	}
	public CsMachineQuery setCsmBluetoothMacLess(String csmBluetoothMacLess){
		this.csmBluetoothMacLess = csmBluetoothMacLess;
		return this;
	}
	public String getCsmBluetoothMacLess(){
		return this.csmBluetoothMacLess;
	}
	public CsMachineQuery setCsmBluetoothMacGreater(String csmBluetoothMacGreater){
		this.csmBluetoothMacGreater = csmBluetoothMacGreater;
		return this;
	}
	public String getCsmBluetoothMacGreater(){
		return this.csmBluetoothMacGreater;
	}
	public CsMachineQuery setCsmBluetoothPsdLike(String csmBluetoothPsdLike){
		this.csmBluetoothPsdLike = csmBluetoothPsdLike;
		return this;
	}
	public String getCsmBluetoothPsdLike(){
		return this.csmBluetoothPsdLike;
	}
	public CsMachineQuery setCsmBluetoothPsdEquals(String csmBluetoothPsdEquals){
		this.csmBluetoothPsdEquals = csmBluetoothPsdEquals;
		return this;
	}
	public String getCsmBluetoothPsdEquals(){
		return this.csmBluetoothPsdEquals;
	}
	public CsMachineQuery setCsmBluetoothPsdIn(String[] csmBluetoothPsdIn){
		this.csmBluetoothPsdIn = csmBluetoothPsdIn;
		return this;
	}
	public String[] getCsmBluetoothPsdIn(){
		return this.csmBluetoothPsdIn;
	}
	public CsMachineQuery setCsmBluetoothPsdIsNull(Boolean csmBluetoothPsdIsNull){
		this.csmBluetoothPsdIsNull = csmBluetoothPsdIsNull;
		return this;
	}
	public Boolean getCsmBluetoothPsdIsNull(){
		return this.csmBluetoothPsdIsNull;
	}
	public CsMachineQuery setCsmBluetoothPsdIsNotNull(Boolean csmBluetoothPsdIsNotNull){
		this.csmBluetoothPsdIsNotNull = csmBluetoothPsdIsNotNull;
		return this;
	}
	public Boolean getCsmBluetoothPsdIsNotNull(){
		return this.csmBluetoothPsdIsNotNull;
	}
	public CsMachineQuery setCsmBluetoothPsdStart(String csmBluetoothPsdStart){
		this.csmBluetoothPsdStart = csmBluetoothPsdStart;
		return this;
	}
	public String getCsmBluetoothPsdStart(){
		return this.csmBluetoothPsdStart;
	}
	public CsMachineQuery setCsmBluetoothPsdEnd(String csmBluetoothPsdEnd){
		this.csmBluetoothPsdEnd = csmBluetoothPsdEnd;
		return this;
	}
	public String getCsmBluetoothPsdEnd(){
		return this.csmBluetoothPsdEnd;
	}
	public CsMachineQuery setCsmBluetoothPsdLess(String csmBluetoothPsdLess){
		this.csmBluetoothPsdLess = csmBluetoothPsdLess;
		return this;
	}
	public String getCsmBluetoothPsdLess(){
		return this.csmBluetoothPsdLess;
	}
	public CsMachineQuery setCsmBluetoothPsdGreater(String csmBluetoothPsdGreater){
		this.csmBluetoothPsdGreater = csmBluetoothPsdGreater;
		return this;
	}
	public String getCsmBluetoothPsdGreater(){
		return this.csmBluetoothPsdGreater;
	}
	public CsMachineQuery setCsmMqttFlagLike(String csmMqttFlagLike){
		this.csmMqttFlagLike = csmMqttFlagLike;
		return this;
	}
	public String getCsmMqttFlagLike(){
		return this.csmMqttFlagLike;
	}
	public CsMachineQuery setCsmMqttFlagEquals(String csmMqttFlagEquals){
		this.csmMqttFlagEquals = csmMqttFlagEquals;
		return this;
	}
	public String getCsmMqttFlagEquals(){
		return this.csmMqttFlagEquals;
	}
	public CsMachineQuery setCsmMqttFlagIn(String[] csmMqttFlagIn){
		this.csmMqttFlagIn = csmMqttFlagIn;
		return this;
	}
	public String[] getCsmMqttFlagIn(){
		return this.csmMqttFlagIn;
	}
	public CsMachineQuery setCsmMqttFlagIsNull(Boolean csmMqttFlagIsNull){
		this.csmMqttFlagIsNull = csmMqttFlagIsNull;
		return this;
	}
	public Boolean getCsmMqttFlagIsNull(){
		return this.csmMqttFlagIsNull;
	}
	public CsMachineQuery setCsmMqttFlagIsNotNull(Boolean csmMqttFlagIsNotNull){
		this.csmMqttFlagIsNotNull = csmMqttFlagIsNotNull;
		return this;
	}
	public Boolean getCsmMqttFlagIsNotNull(){
		return this.csmMqttFlagIsNotNull;
	}
	public CsMachineQuery setCsmMqttFlagStart(String csmMqttFlagStart){
		this.csmMqttFlagStart = csmMqttFlagStart;
		return this;
	}
	public String getCsmMqttFlagStart(){
		return this.csmMqttFlagStart;
	}
	public CsMachineQuery setCsmMqttFlagEnd(String csmMqttFlagEnd){
		this.csmMqttFlagEnd = csmMqttFlagEnd;
		return this;
	}
	public String getCsmMqttFlagEnd(){
		return this.csmMqttFlagEnd;
	}
	public CsMachineQuery setCsmMqttFlagLess(String csmMqttFlagLess){
		this.csmMqttFlagLess = csmMqttFlagLess;
		return this;
	}
	public String getCsmMqttFlagLess(){
		return this.csmMqttFlagLess;
	}
	public CsMachineQuery setCsmMqttFlagGreater(String csmMqttFlagGreater){
		this.csmMqttFlagGreater = csmMqttFlagGreater;
		return this;
	}
	public String getCsmMqttFlagGreater(){
		return this.csmMqttFlagGreater;
	}
	public CsMachineQuery setCsmSuperSimLike(String csmSuperSimLike){
		this.csmSuperSimLike = csmSuperSimLike;
		return this;
	}
	public String getCsmSuperSimLike(){
		return this.csmSuperSimLike;
	}
	public CsMachineQuery setCsmSuperSimEquals(String csmSuperSimEquals){
		this.csmSuperSimEquals = csmSuperSimEquals;
		return this;
	}
	public String getCsmSuperSimEquals(){
		return this.csmSuperSimEquals;
	}
	public CsMachineQuery setCsmSuperSimIn(String[] csmSuperSimIn){
		this.csmSuperSimIn = csmSuperSimIn;
		return this;
	}
	public String[] getCsmSuperSimIn(){
		return this.csmSuperSimIn;
	}
	public CsMachineQuery setCsmSuperSimIsNull(Boolean csmSuperSimIsNull){
		this.csmSuperSimIsNull = csmSuperSimIsNull;
		return this;
	}
	public Boolean getCsmSuperSimIsNull(){
		return this.csmSuperSimIsNull;
	}
	public CsMachineQuery setCsmSuperSimIsNotNull(Boolean csmSuperSimIsNotNull){
		this.csmSuperSimIsNotNull = csmSuperSimIsNotNull;
		return this;
	}
	public Boolean getCsmSuperSimIsNotNull(){
		return this.csmSuperSimIsNotNull;
	}
	public CsMachineQuery setCsmSuperSimStart(String csmSuperSimStart){
		this.csmSuperSimStart = csmSuperSimStart;
		return this;
	}
	public String getCsmSuperSimStart(){
		return this.csmSuperSimStart;
	}
	public CsMachineQuery setCsmSuperSimEnd(String csmSuperSimEnd){
		this.csmSuperSimEnd = csmSuperSimEnd;
		return this;
	}
	public String getCsmSuperSimEnd(){
		return this.csmSuperSimEnd;
	}
	public CsMachineQuery setCsmSuperSimLess(String csmSuperSimLess){
		this.csmSuperSimLess = csmSuperSimLess;
		return this;
	}
	public String getCsmSuperSimLess(){
		return this.csmSuperSimLess;
	}
	public CsMachineQuery setCsmSuperSimGreater(String csmSuperSimGreater){
		this.csmSuperSimGreater = csmSuperSimGreater;
		return this;
	}
	public String getCsmSuperSimGreater(){
		return this.csmSuperSimGreater;
	}
	public CsMachineQuery setCsmLandmarkLike(String csmLandmarkLike){
		this.csmLandmarkLike = csmLandmarkLike;
		return this;
	}
	public String getCsmLandmarkLike(){
		return this.csmLandmarkLike;
	}
	public CsMachineQuery setCsmLandmarkEquals(String csmLandmarkEquals){
		this.csmLandmarkEquals = csmLandmarkEquals;
		return this;
	}
	public String getCsmLandmarkEquals(){
		return this.csmLandmarkEquals;
	}
	public CsMachineQuery setCsmLandmarkIn(String[] csmLandmarkIn){
		this.csmLandmarkIn = csmLandmarkIn;
		return this;
	}
	public String[] getCsmLandmarkIn(){
		return this.csmLandmarkIn;
	}
	public CsMachineQuery setCsmLandmarkIsNull(Boolean csmLandmarkIsNull){
		this.csmLandmarkIsNull = csmLandmarkIsNull;
		return this;
	}
	public Boolean getCsmLandmarkIsNull(){
		return this.csmLandmarkIsNull;
	}
	public CsMachineQuery setCsmLandmarkIsNotNull(Boolean csmLandmarkIsNotNull){
		this.csmLandmarkIsNotNull = csmLandmarkIsNotNull;
		return this;
	}
	public Boolean getCsmLandmarkIsNotNull(){
		return this.csmLandmarkIsNotNull;
	}
	public CsMachineQuery setCsmLandmarkStart(String csmLandmarkStart){
		this.csmLandmarkStart = csmLandmarkStart;
		return this;
	}
	public String getCsmLandmarkStart(){
		return this.csmLandmarkStart;
	}
	public CsMachineQuery setCsmLandmarkEnd(String csmLandmarkEnd){
		this.csmLandmarkEnd = csmLandmarkEnd;
		return this;
	}
	public String getCsmLandmarkEnd(){
		return this.csmLandmarkEnd;
	}
	public CsMachineQuery setCsmLandmarkLess(String csmLandmarkLess){
		this.csmLandmarkLess = csmLandmarkLess;
		return this;
	}
	public String getCsmLandmarkLess(){
		return this.csmLandmarkLess;
	}
	public CsMachineQuery setCsmLandmarkGreater(String csmLandmarkGreater){
		this.csmLandmarkGreater = csmLandmarkGreater;
		return this;
	}
	public String getCsmLandmarkGreater(){
		return this.csmLandmarkGreater;
	}
	public CsMachineQuery setCsmV2Like(String csmV2Like){
		this.csmV2Like = csmV2Like;
		return this;
	}
	public String getCsmV2Like(){
		return this.csmV2Like;
	}
	public CsMachineQuery setCsmV2Equals(String csmV2Equals){
		this.csmV2Equals = csmV2Equals;
		return this;
	}
	public String getCsmV2Equals(){
		return this.csmV2Equals;
	}
	public CsMachineQuery setCsmV2In(String[] csmV2In){
		this.csmV2In = csmV2In;
		return this;
	}
	public String[] getCsmV2In(){
		return this.csmV2In;
	}
	public CsMachineQuery setCsmV2IsNull(Boolean csmV2IsNull){
		this.csmV2IsNull = csmV2IsNull;
		return this;
	}
	public Boolean getCsmV2IsNull(){
		return this.csmV2IsNull;
	}
	public CsMachineQuery setCsmV2IsNotNull(Boolean csmV2IsNotNull){
		this.csmV2IsNotNull = csmV2IsNotNull;
		return this;
	}
	public Boolean getCsmV2IsNotNull(){
		return this.csmV2IsNotNull;
	}
	public CsMachineQuery setCsmV2Start(String csmV2Start){
		this.csmV2Start = csmV2Start;
		return this;
	}
	public String getCsmV2Start(){
		return this.csmV2Start;
	}
	public CsMachineQuery setCsmV2End(String csmV2End){
		this.csmV2End = csmV2End;
		return this;
	}
	public String getCsmV2End(){
		return this.csmV2End;
	}
	public CsMachineQuery setCsmV2Less(String csmV2Less){
		this.csmV2Less = csmV2Less;
		return this;
	}
	public String getCsmV2Less(){
		return this.csmV2Less;
	}
	public CsMachineQuery setCsmV2Greater(String csmV2Greater){
		this.csmV2Greater = csmV2Greater;
		return this;
	}
	public String getCsmV2Greater(){
		return this.csmV2Greater;
	}
	public CsMachineQuery setCsmV3Like(String csmV3Like){
		this.csmV3Like = csmV3Like;
		return this;
	}
	public String getCsmV3Like(){
		return this.csmV3Like;
	}
	public CsMachineQuery setCsmV3Equals(String csmV3Equals){
		this.csmV3Equals = csmV3Equals;
		return this;
	}
	public String getCsmV3Equals(){
		return this.csmV3Equals;
	}
	public CsMachineQuery setCsmV3In(String[] csmV3In){
		this.csmV3In = csmV3In;
		return this;
	}
	public String[] getCsmV3In(){
		return this.csmV3In;
	}
	public CsMachineQuery setCsmV3IsNull(Boolean csmV3IsNull){
		this.csmV3IsNull = csmV3IsNull;
		return this;
	}
	public Boolean getCsmV3IsNull(){
		return this.csmV3IsNull;
	}
	public CsMachineQuery setCsmV3IsNotNull(Boolean csmV3IsNotNull){
		this.csmV3IsNotNull = csmV3IsNotNull;
		return this;
	}
	public Boolean getCsmV3IsNotNull(){
		return this.csmV3IsNotNull;
	}
	public CsMachineQuery setCsmV3Start(String csmV3Start){
		this.csmV3Start = csmV3Start;
		return this;
	}
	public String getCsmV3Start(){
		return this.csmV3Start;
	}
	public CsMachineQuery setCsmV3End(String csmV3End){
		this.csmV3End = csmV3End;
		return this;
	}
	public String getCsmV3End(){
		return this.csmV3End;
	}
	public CsMachineQuery setCsmV3Less(String csmV3Less){
		this.csmV3Less = csmV3Less;
		return this;
	}
	public String getCsmV3Less(){
		return this.csmV3Less;
	}
	public CsMachineQuery setCsmV3Greater(String csmV3Greater){
		this.csmV3Greater = csmV3Greater;
		return this;
	}
	public String getCsmV3Greater(){
		return this.csmV3Greater;
	}
	public CsMachineQuery setCsmV3ToLike(String csmV3ToLike){
		this.csmV3ToLike = csmV3ToLike;
		return this;
	}
	public String getCsmV3ToLike(){
		return this.csmV3ToLike;
	}
	public CsMachineQuery setCsmV3ToEquals(String csmV3ToEquals){
		this.csmV3ToEquals = csmV3ToEquals;
		return this;
	}
	public String getCsmV3ToEquals(){
		return this.csmV3ToEquals;
	}
	public CsMachineQuery setCsmV3ToIn(String[] csmV3ToIn){
		this.csmV3ToIn = csmV3ToIn;
		return this;
	}
	public String[] getCsmV3ToIn(){
		return this.csmV3ToIn;
	}
	public CsMachineQuery setCsmV3ToIsNull(Boolean csmV3ToIsNull){
		this.csmV3ToIsNull = csmV3ToIsNull;
		return this;
	}
	public Boolean getCsmV3ToIsNull(){
		return this.csmV3ToIsNull;
	}
	public CsMachineQuery setCsmV3ToIsNotNull(Boolean csmV3ToIsNotNull){
		this.csmV3ToIsNotNull = csmV3ToIsNotNull;
		return this;
	}
	public Boolean getCsmV3ToIsNotNull(){
		return this.csmV3ToIsNotNull;
	}
	public CsMachineQuery setCsmV3ToStart(String csmV3ToStart){
		this.csmV3ToStart = csmV3ToStart;
		return this;
	}
	public String getCsmV3ToStart(){
		return this.csmV3ToStart;
	}
	public CsMachineQuery setCsmV3ToEnd(String csmV3ToEnd){
		this.csmV3ToEnd = csmV3ToEnd;
		return this;
	}
	public String getCsmV3ToEnd(){
		return this.csmV3ToEnd;
	}
	public CsMachineQuery setCsmV3ToLess(String csmV3ToLess){
		this.csmV3ToLess = csmV3ToLess;
		return this;
	}
	public String getCsmV3ToLess(){
		return this.csmV3ToLess;
	}
	public CsMachineQuery setCsmV3ToGreater(String csmV3ToGreater){
		this.csmV3ToGreater = csmV3ToGreater;
		return this;
	}
	public String getCsmV3ToGreater(){
		return this.csmV3ToGreater;
	}
	public CsMachineQuery setCsmSuitEquals(Integer csmSuitEquals){
		this.csmSuitEquals = csmSuitEquals;
		return this;
	}
	public Integer getCsmSuitEquals(){
		return this.csmSuitEquals;
	}
	public CsMachineQuery setCsmSuitIn(Integer[] csmSuitIn){
		this.csmSuitIn = csmSuitIn;
		return this;
	}
	public Integer[] getCsmSuitIn(){
		return this.csmSuitIn;
	}
	public CsMachineQuery setCsmSuitIsNull(Boolean csmSuitIsNull){
		this.csmSuitIsNull = csmSuitIsNull;
		return this;
	}
	public Boolean getCsmSuitIsNull(){
		return this.csmSuitIsNull;
	}
	public CsMachineQuery setCsmSuitIsNotNull(Boolean csmSuitIsNotNull){
		this.csmSuitIsNotNull = csmSuitIsNotNull;
		return this;
	}
	public Boolean getCsmSuitIsNotNull(){
		return this.csmSuitIsNotNull;
	}
	public CsMachineQuery setCsmSuitStart(Integer csmSuitStart){
		this.csmSuitStart = csmSuitStart;
		return this;
	}
	public Integer getCsmSuitStart(){
		return this.csmSuitStart;
	}
	public CsMachineQuery setCsmSuitEnd(Integer csmSuitEnd){
		this.csmSuitEnd = csmSuitEnd;
		return this;
	}
	public Integer getCsmSuitEnd(){
		return this.csmSuitEnd;
	}
	public CsMachineQuery setCsmSuitLess(Integer csmSuitLess){
		this.csmSuitLess = csmSuitLess;
		return this;
	}
	public Integer getCsmSuitLess(){
		return this.csmSuitLess;
	}
	public CsMachineQuery setCsmSuitGreater(Integer csmSuitGreater){
		this.csmSuitGreater = csmSuitGreater;
		return this;
	}
	public Integer getCsmSuitGreater(){
		return this.csmSuitGreater;
	}
	public CsMachineQuery setCsmTlV1Like(String csmTlV1Like){
		this.csmTlV1Like = csmTlV1Like;
		return this;
	}
	public String getCsmTlV1Like(){
		return this.csmTlV1Like;
	}
	public CsMachineQuery setCsmTlV1Equals(String csmTlV1Equals){
		this.csmTlV1Equals = csmTlV1Equals;
		return this;
	}
	public String getCsmTlV1Equals(){
		return this.csmTlV1Equals;
	}
	public CsMachineQuery setCsmTlV1In(String[] csmTlV1In){
		this.csmTlV1In = csmTlV1In;
		return this;
	}
	public String[] getCsmTlV1In(){
		return this.csmTlV1In;
	}
	public CsMachineQuery setCsmTlV1IsNull(Boolean csmTlV1IsNull){
		this.csmTlV1IsNull = csmTlV1IsNull;
		return this;
	}
	public Boolean getCsmTlV1IsNull(){
		return this.csmTlV1IsNull;
	}
	public CsMachineQuery setCsmTlV1IsNotNull(Boolean csmTlV1IsNotNull){
		this.csmTlV1IsNotNull = csmTlV1IsNotNull;
		return this;
	}
	public Boolean getCsmTlV1IsNotNull(){
		return this.csmTlV1IsNotNull;
	}
	public CsMachineQuery setCsmTlV1Start(String csmTlV1Start){
		this.csmTlV1Start = csmTlV1Start;
		return this;
	}
	public String getCsmTlV1Start(){
		return this.csmTlV1Start;
	}
	public CsMachineQuery setCsmTlV1End(String csmTlV1End){
		this.csmTlV1End = csmTlV1End;
		return this;
	}
	public String getCsmTlV1End(){
		return this.csmTlV1End;
	}
	public CsMachineQuery setCsmTlV1Less(String csmTlV1Less){
		this.csmTlV1Less = csmTlV1Less;
		return this;
	}
	public String getCsmTlV1Less(){
		return this.csmTlV1Less;
	}
	public CsMachineQuery setCsmTlV1Greater(String csmTlV1Greater){
		this.csmTlV1Greater = csmTlV1Greater;
		return this;
	}
	public String getCsmTlV1Greater(){
		return this.csmTlV1Greater;
	}
	public CsMachineQuery setCsmTlV2Equals(Integer csmTlV2Equals){
		this.csmTlV2Equals = csmTlV2Equals;
		return this;
	}
	public Integer getCsmTlV2Equals(){
		return this.csmTlV2Equals;
	}
	public CsMachineQuery setCsmTlV2In(Integer[] csmTlV2In){
		this.csmTlV2In = csmTlV2In;
		return this;
	}
	public Integer[] getCsmTlV2In(){
		return this.csmTlV2In;
	}
	public CsMachineQuery setCsmTlV2IsNull(Boolean csmTlV2IsNull){
		this.csmTlV2IsNull = csmTlV2IsNull;
		return this;
	}
	public Boolean getCsmTlV2IsNull(){
		return this.csmTlV2IsNull;
	}
	public CsMachineQuery setCsmTlV2IsNotNull(Boolean csmTlV2IsNotNull){
		this.csmTlV2IsNotNull = csmTlV2IsNotNull;
		return this;
	}
	public Boolean getCsmTlV2IsNotNull(){
		return this.csmTlV2IsNotNull;
	}
	public CsMachineQuery setCsmTlV2Start(Integer csmTlV2Start){
		this.csmTlV2Start = csmTlV2Start;
		return this;
	}
	public Integer getCsmTlV2Start(){
		return this.csmTlV2Start;
	}
	public CsMachineQuery setCsmTlV2End(Integer csmTlV2End){
		this.csmTlV2End = csmTlV2End;
		return this;
	}
	public Integer getCsmTlV2End(){
		return this.csmTlV2End;
	}
	public CsMachineQuery setCsmTlV2Less(Integer csmTlV2Less){
		this.csmTlV2Less = csmTlV2Less;
		return this;
	}
	public Integer getCsmTlV2Less(){
		return this.csmTlV2Less;
	}
	public CsMachineQuery setCsmTlV2Greater(Integer csmTlV2Greater){
		this.csmTlV2Greater = csmTlV2Greater;
		return this;
	}
	public Integer getCsmTlV2Greater(){
		return this.csmTlV2Greater;
	}
	public CsMachineQuery setCsmNetTypeEquals(Short csmNetTypeEquals){
		this.csmNetTypeEquals = csmNetTypeEquals;
		return this;
	}
	public Short getCsmNetTypeEquals(){
		return this.csmNetTypeEquals;
	}
	public CsMachineQuery setCsmNetTypeIn(Short[] csmNetTypeIn){
		this.csmNetTypeIn = csmNetTypeIn;
		return this;
	}
	public Short[] getCsmNetTypeIn(){
		return this.csmNetTypeIn;
	}
	public CsMachineQuery setCsmNetTypeIsNull(Boolean csmNetTypeIsNull){
		this.csmNetTypeIsNull = csmNetTypeIsNull;
		return this;
	}
	public Boolean getCsmNetTypeIsNull(){
		return this.csmNetTypeIsNull;
	}
	public CsMachineQuery setCsmNetTypeIsNotNull(Boolean csmNetTypeIsNotNull){
		this.csmNetTypeIsNotNull = csmNetTypeIsNotNull;
		return this;
	}
	public Boolean getCsmNetTypeIsNotNull(){
		return this.csmNetTypeIsNotNull;
	}
	public CsMachineQuery setCsmNetTypeStart(Short csmNetTypeStart){
		this.csmNetTypeStart = csmNetTypeStart;
		return this;
	}
	public Short getCsmNetTypeStart(){
		return this.csmNetTypeStart;
	}
	public CsMachineQuery setCsmNetTypeEnd(Short csmNetTypeEnd){
		this.csmNetTypeEnd = csmNetTypeEnd;
		return this;
	}
	public Short getCsmNetTypeEnd(){
		return this.csmNetTypeEnd;
	}
	public CsMachineQuery setCsmNetTypeLess(Short csmNetTypeLess){
		this.csmNetTypeLess = csmNetTypeLess;
		return this;
	}
	public Short getCsmNetTypeLess(){
		return this.csmNetTypeLess;
	}
	public CsMachineQuery setCsmNetTypeGreater(Short csmNetTypeGreater){
		this.csmNetTypeGreater = csmNetTypeGreater;
		return this;
	}
	public Short getCsmNetTypeGreater(){
		return this.csmNetTypeGreater;
	}
	public CsMachineQuery setCsmProTypeEquals(Short csmProTypeEquals){
		this.csmProTypeEquals = csmProTypeEquals;
		return this;
	}
	public Short getCsmProTypeEquals(){
		return this.csmProTypeEquals;
	}
	public CsMachineQuery setCsmProTypeIn(Short[] csmProTypeIn){
		this.csmProTypeIn = csmProTypeIn;
		return this;
	}
	public Short[] getCsmProTypeIn(){
		return this.csmProTypeIn;
	}
	public CsMachineQuery setCsmProTypeIsNull(Boolean csmProTypeIsNull){
		this.csmProTypeIsNull = csmProTypeIsNull;
		return this;
	}
	public Boolean getCsmProTypeIsNull(){
		return this.csmProTypeIsNull;
	}
	public CsMachineQuery setCsmProTypeIsNotNull(Boolean csmProTypeIsNotNull){
		this.csmProTypeIsNotNull = csmProTypeIsNotNull;
		return this;
	}
	public Boolean getCsmProTypeIsNotNull(){
		return this.csmProTypeIsNotNull;
	}
	public CsMachineQuery setCsmProTypeStart(Short csmProTypeStart){
		this.csmProTypeStart = csmProTypeStart;
		return this;
	}
	public Short getCsmProTypeStart(){
		return this.csmProTypeStart;
	}
	public CsMachineQuery setCsmProTypeEnd(Short csmProTypeEnd){
		this.csmProTypeEnd = csmProTypeEnd;
		return this;
	}
	public Short getCsmProTypeEnd(){
		return this.csmProTypeEnd;
	}
	public CsMachineQuery setCsmProTypeLess(Short csmProTypeLess){
		this.csmProTypeLess = csmProTypeLess;
		return this;
	}
	public Short getCsmProTypeLess(){
		return this.csmProTypeLess;
	}
	public CsMachineQuery setCsmProTypeGreater(Short csmProTypeGreater){
		this.csmProTypeGreater = csmProTypeGreater;
		return this;
	}
	public Short getCsmProTypeGreater(){
		return this.csmProTypeGreater;
	}
	public CsMachineQuery setCsmBaudRateEquals(Integer csmBaudRateEquals){
		this.csmBaudRateEquals = csmBaudRateEquals;
		return this;
	}
	public Integer getCsmBaudRateEquals(){
		return this.csmBaudRateEquals;
	}
	public CsMachineQuery setCsmBaudRateIn(Integer[] csmBaudRateIn){
		this.csmBaudRateIn = csmBaudRateIn;
		return this;
	}
	public Integer[] getCsmBaudRateIn(){
		return this.csmBaudRateIn;
	}
	public CsMachineQuery setCsmBaudRateIsNull(Boolean csmBaudRateIsNull){
		this.csmBaudRateIsNull = csmBaudRateIsNull;
		return this;
	}
	public Boolean getCsmBaudRateIsNull(){
		return this.csmBaudRateIsNull;
	}
	public CsMachineQuery setCsmBaudRateIsNotNull(Boolean csmBaudRateIsNotNull){
		this.csmBaudRateIsNotNull = csmBaudRateIsNotNull;
		return this;
	}
	public Boolean getCsmBaudRateIsNotNull(){
		return this.csmBaudRateIsNotNull;
	}
	public CsMachineQuery setCsmBaudRateStart(Integer csmBaudRateStart){
		this.csmBaudRateStart = csmBaudRateStart;
		return this;
	}
	public Integer getCsmBaudRateStart(){
		return this.csmBaudRateStart;
	}
	public CsMachineQuery setCsmBaudRateEnd(Integer csmBaudRateEnd){
		this.csmBaudRateEnd = csmBaudRateEnd;
		return this;
	}
	public Integer getCsmBaudRateEnd(){
		return this.csmBaudRateEnd;
	}
	public CsMachineQuery setCsmBaudRateLess(Integer csmBaudRateLess){
		this.csmBaudRateLess = csmBaudRateLess;
		return this;
	}
	public Integer getCsmBaudRateLess(){
		return this.csmBaudRateLess;
	}
	public CsMachineQuery setCsmBaudRateGreater(Integer csmBaudRateGreater){
		this.csmBaudRateGreater = csmBaudRateGreater;
		return this;
	}
	public Integer getCsmBaudRateGreater(){
		return this.csmBaudRateGreater;
	}
	public CsMachineQuery setCsmRemarkLike(String csmRemarkLike){
		this.csmRemarkLike = csmRemarkLike;
		return this;
	}
	public String getCsmRemarkLike(){
		return this.csmRemarkLike;
	}
	public CsMachineQuery setCsmRemarkEquals(String csmRemarkEquals){
		this.csmRemarkEquals = csmRemarkEquals;
		return this;
	}
	public String getCsmRemarkEquals(){
		return this.csmRemarkEquals;
	}
	public CsMachineQuery setCsmRemarkIn(String[] csmRemarkIn){
		this.csmRemarkIn = csmRemarkIn;
		return this;
	}
	public String[] getCsmRemarkIn(){
		return this.csmRemarkIn;
	}
	public CsMachineQuery setCsmRemarkIsNull(Boolean csmRemarkIsNull){
		this.csmRemarkIsNull = csmRemarkIsNull;
		return this;
	}
	public Boolean getCsmRemarkIsNull(){
		return this.csmRemarkIsNull;
	}
	public CsMachineQuery setCsmRemarkIsNotNull(Boolean csmRemarkIsNotNull){
		this.csmRemarkIsNotNull = csmRemarkIsNotNull;
		return this;
	}
	public Boolean getCsmRemarkIsNotNull(){
		return this.csmRemarkIsNotNull;
	}
	public CsMachineQuery setCsmRemarkStart(String csmRemarkStart){
		this.csmRemarkStart = csmRemarkStart;
		return this;
	}
	public String getCsmRemarkStart(){
		return this.csmRemarkStart;
	}
	public CsMachineQuery setCsmRemarkEnd(String csmRemarkEnd){
		this.csmRemarkEnd = csmRemarkEnd;
		return this;
	}
	public String getCsmRemarkEnd(){
		return this.csmRemarkEnd;
	}
	public CsMachineQuery setCsmRemarkLess(String csmRemarkLess){
		this.csmRemarkLess = csmRemarkLess;
		return this;
	}
	public String getCsmRemarkLess(){
		return this.csmRemarkLess;
	}
	public CsMachineQuery setCsmRemarkGreater(String csmRemarkGreater){
		this.csmRemarkGreater = csmRemarkGreater;
		return this;
	}
	public String getCsmRemarkGreater(){
		return this.csmRemarkGreater;
	}
	public CsMachineQuery setCsmUpdateTimeEquals(Date csmUpdateTimeEquals){
		this.csmUpdateTimeEquals = csmUpdateTimeEquals;
		return this;
	}
	public Date getCsmUpdateTimeEquals(){
		return this.csmUpdateTimeEquals;
	}
	public CsMachineQuery setCsmUpdateTimeIn(Date[] csmUpdateTimeIn){
		this.csmUpdateTimeIn = csmUpdateTimeIn;
		return this;
	}
	public Date[] getCsmUpdateTimeIn(){
		return this.csmUpdateTimeIn;
	}
	public CsMachineQuery setCsmUpdateTimeIsNull(Boolean csmUpdateTimeIsNull){
		this.csmUpdateTimeIsNull = csmUpdateTimeIsNull;
		return this;
	}
	public Boolean getCsmUpdateTimeIsNull(){
		return this.csmUpdateTimeIsNull;
	}
	public CsMachineQuery setCsmUpdateTimeIsNotNull(Boolean csmUpdateTimeIsNotNull){
		this.csmUpdateTimeIsNotNull = csmUpdateTimeIsNotNull;
		return this;
	}
	public Boolean getCsmUpdateTimeIsNotNull(){
		return this.csmUpdateTimeIsNotNull;
	}
	public CsMachineQuery setCsmUpdateTimeStart(Date csmUpdateTimeStart){
		this.csmUpdateTimeStart = csmUpdateTimeStart;
		return this;
	}
	public Date getCsmUpdateTimeStart(){
		return this.csmUpdateTimeStart;
	}
	public CsMachineQuery setCsmUpdateTimeEnd(Date csmUpdateTimeEnd){
		this.csmUpdateTimeEnd = csmUpdateTimeEnd;
		return this;
	}
	public Date getCsmUpdateTimeEnd(){
		return this.csmUpdateTimeEnd;
	}
	public CsMachineQuery setCsmUpdateTimeLess(Date csmUpdateTimeLess){
		this.csmUpdateTimeLess = csmUpdateTimeLess;
		return this;
	}
	public Date getCsmUpdateTimeLess(){
		return this.csmUpdateTimeLess;
	}
	public CsMachineQuery setCsmUpdateTimeGreater(Date csmUpdateTimeGreater){
		this.csmUpdateTimeGreater = csmUpdateTimeGreater;
		return this;
	}
	public Date getCsmUpdateTimeGreater(){
		return this.csmUpdateTimeGreater;
	}
	public CsMachineQuery setCsmAddTimeEquals(Date csmAddTimeEquals){
		this.csmAddTimeEquals = csmAddTimeEquals;
		return this;
	}
	public Date getCsmAddTimeEquals(){
		return this.csmAddTimeEquals;
	}
	public CsMachineQuery setCsmAddTimeIn(Date[] csmAddTimeIn){
		this.csmAddTimeIn = csmAddTimeIn;
		return this;
	}
	public Date[] getCsmAddTimeIn(){
		return this.csmAddTimeIn;
	}
	public CsMachineQuery setCsmAddTimeIsNull(Boolean csmAddTimeIsNull){
		this.csmAddTimeIsNull = csmAddTimeIsNull;
		return this;
	}
	public Boolean getCsmAddTimeIsNull(){
		return this.csmAddTimeIsNull;
	}
	public CsMachineQuery setCsmAddTimeIsNotNull(Boolean csmAddTimeIsNotNull){
		this.csmAddTimeIsNotNull = csmAddTimeIsNotNull;
		return this;
	}
	public Boolean getCsmAddTimeIsNotNull(){
		return this.csmAddTimeIsNotNull;
	}
	public CsMachineQuery setCsmAddTimeStart(Date csmAddTimeStart){
		this.csmAddTimeStart = csmAddTimeStart;
		return this;
	}
	public Date getCsmAddTimeStart(){
		return this.csmAddTimeStart;
	}
	public CsMachineQuery setCsmAddTimeEnd(Date csmAddTimeEnd){
		this.csmAddTimeEnd = csmAddTimeEnd;
		return this;
	}
	public Date getCsmAddTimeEnd(){
		return this.csmAddTimeEnd;
	}
	public CsMachineQuery setCsmAddTimeLess(Date csmAddTimeLess){
		this.csmAddTimeLess = csmAddTimeLess;
		return this;
	}
	public Date getCsmAddTimeLess(){
		return this.csmAddTimeLess;
	}
	public CsMachineQuery setCsmAddTimeGreater(Date csmAddTimeGreater){
		this.csmAddTimeGreater = csmAddTimeGreater;
		return this;
	}
	public Date getCsmAddTimeGreater(){
		return this.csmAddTimeGreater;
	}
	public CsMachineQuery setCsmStatusEquals(Short csmStatusEquals){
		this.csmStatusEquals = csmStatusEquals;
		return this;
	}
	public Short getCsmStatusEquals(){
		return this.csmStatusEquals;
	}
	public CsMachineQuery setCsmStatusIn(Short[] csmStatusIn){
		this.csmStatusIn = csmStatusIn;
		return this;
	}
	public Short[] getCsmStatusIn(){
		return this.csmStatusIn;
	}
	public CsMachineQuery setCsmStatusIsNull(Boolean csmStatusIsNull){
		this.csmStatusIsNull = csmStatusIsNull;
		return this;
	}
	public Boolean getCsmStatusIsNull(){
		return this.csmStatusIsNull;
	}
	public CsMachineQuery setCsmStatusIsNotNull(Boolean csmStatusIsNotNull){
		this.csmStatusIsNotNull = csmStatusIsNotNull;
		return this;
	}
	public Boolean getCsmStatusIsNotNull(){
		return this.csmStatusIsNotNull;
	}
	public CsMachineQuery setCsmStatusStart(Short csmStatusStart){
		this.csmStatusStart = csmStatusStart;
		return this;
	}
	public Short getCsmStatusStart(){
		return this.csmStatusStart;
	}
	public CsMachineQuery setCsmStatusEnd(Short csmStatusEnd){
		this.csmStatusEnd = csmStatusEnd;
		return this;
	}
	public Short getCsmStatusEnd(){
		return this.csmStatusEnd;
	}
	public CsMachineQuery setCsmStatusLess(Short csmStatusLess){
		this.csmStatusLess = csmStatusLess;
		return this;
	}
	public Short getCsmStatusLess(){
		return this.csmStatusLess;
	}
	public CsMachineQuery setCsmStatusGreater(Short csmStatusGreater){
		this.csmStatusGreater = csmStatusGreater;
		return this;
	}
	public Short getCsmStatusGreater(){
		return this.csmStatusGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("csmId")){
			return "csm_id";
		}
		else if(this.sidx.equals("csmAccess")){
			return "csm_access";
		}
		else if(this.sidx.equals("csmHost")){
			return "csm_host";
		}
		else if(this.sidx.equals("csmNumber")){
			return "csm_number";
		}
		else if(this.sidx.equals("csmTeNo")){
			return "csm_te_no";
		}
		else if(this.sidx.equals("csmTeType")){
			return "csm_te_type";
		}
		else if(this.sidx.equals("csmTeModel")){
			return "csm_te_model";
		}
		else if(this.sidx.equals("csmTeCode")){
			return "csm_te_code";
		}
		else if(this.sidx.equals("csmTeLotNo")){
			return "csm_te_lot_no";
		}
		else if(this.sidx.equals("csmTeSerial")){
			return "csm_te_serial";
		}
		else if(this.sidx.equals("csmMobile")){
			return "csm_mobile";
		}
		else if(this.sidx.equals("csmIccid")){
			return "csm_iccid";
		}
		else if(this.sidx.equals("csmPassword")){
			return "csm_password";
		}
		else if(this.sidx.equals("csmProtocol")){
			return "csm_protocol";
		}
		else if(this.sidx.equals("csmFunctions")){
			return "csm_functions";
		}
		else if(this.sidx.equals("csmBluetoothVersion")){
			return "csm_bluetooth_version";
		}
		else if(this.sidx.equals("csmBluetoothMac")){
			return "csm_bluetooth_mac";
		}
		else if(this.sidx.equals("csmBluetoothPsd")){
			return "csm_bluetooth_psd";
		}
		else if(this.sidx.equals("csmMqttFlag")){
			return "csm_mqtt_flag";
		}
		else if(this.sidx.equals("csmSuperSim")){
			return "csm_super_sim";
		}
		else if(this.sidx.equals("csmLandmark")){
			return "csm_landmark";
		}
		else if(this.sidx.equals("csmV2")){
			return "csm_v2";
		}
		else if(this.sidx.equals("csmV3")){
			return "csm_v3";
		}
		else if(this.sidx.equals("csmV3To")){
			return "csm_v3_to";
		}
		else if(this.sidx.equals("csmSuit")){
			return "csm_suit";
		}
		else if(this.sidx.equals("csmTlV1")){
			return "csm_tl_v1";
		}
		else if(this.sidx.equals("csmTlV2")){
			return "csm_tl_v2";
		}
		else if(this.sidx.equals("csmNetType")){
			return "csm_net_type";
		}
		else if(this.sidx.equals("csmProType")){
			return "csm_pro_type";
		}
		else if(this.sidx.equals("csmBaudRate")){
			return "csm_baud_rate";
		}
		else if(this.sidx.equals("csmRemark")){
			return "csm_remark";
		}
		else if(this.sidx.equals("csmUpdateTime")){
			return "csm_update_time";
		}
		else if(this.sidx.equals("csmAddTime")){
			return "csm_add_time";
		}
		else if(this.sidx.equals("csmStatus")){
			return "csm_status";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsMachineCrieria getCrieria(){
		CsMachineCrieria q = new CsMachineCrieria();
		CsMachineCrieria.Criteria c = q.createCriteria();
		
		if(this.getCsmIdEquals()!=null){
			c.andcsmIdEqualTo(this.getCsmIdEquals());
		}else if(this.getCsmIdIsNull()!=null && this.getCsmIdIsNull()){
			c.andcsmIdIsNull();
		}else if(this.getCsmIdIsNotNull()!=null && this.getCsmIdIsNotNull()){
			c.andcsmIdIsNotNull();
		}else if(this.getCsmIdIn()!=null){
			c.andcsmIdIn(java.util.Arrays.asList(this.getCsmIdIn()));
		}else if(this.getCsmIdStart()!=null && this.getCsmIdEnd()!=null){
			c.andcsmIdBetween(this.getCsmIdStart(), this.getCsmIdEnd());
		}else if(this.getCsmIdGreater()!=null){
			c.andcsmIdGreaterThan(this.getCsmIdGreater());
		}else if(this.getCsmIdLess()!=null){
			c.andcsmIdLessThan(this.getCsmIdLess());
		}
		if(this.getCsmAccessEquals()!=null){
			c.andcsmAccessEqualTo(this.getCsmAccessEquals());
		}else if(this.getCsmAccessIsNull()!=null && this.getCsmAccessIsNull()){
			c.andcsmAccessIsNull();
		}else if(this.getCsmAccessIsNotNull()!=null && this.getCsmAccessIsNotNull()){
			c.andcsmAccessIsNotNull();
		}else if(this.getCsmAccessIn()!=null){
			c.andcsmAccessIn(java.util.Arrays.asList(this.getCsmAccessIn()));
		}else if(this.getCsmAccessStart()!=null && this.getCsmAccessEnd()!=null){
			c.andcsmAccessBetween(this.getCsmAccessStart(), this.getCsmAccessEnd());
		}else if(this.getCsmAccessGreater()!=null){
			c.andcsmAccessGreaterThan(this.getCsmAccessGreater());
		}else if(this.getCsmAccessLess()!=null){
			c.andcsmAccessLessThan(this.getCsmAccessLess());
		}
		if(this.getCsmHostEquals()!=null){
			c.andcsmHostEqualTo(this.getCsmHostEquals());
		}else if(this.getCsmHostIsNull()!=null && this.getCsmHostIsNull()){
			c.andcsmHostIsNull();
		}else if(this.getCsmHostIsNotNull()!=null && this.getCsmHostIsNotNull()){
			c.andcsmHostIsNotNull();
		}else if(this.getCsmHostIn()!=null){
			c.andcsmHostIn(java.util.Arrays.asList(this.getCsmHostIn()));
		}else if(this.getCsmHostStart()!=null && this.getCsmHostEnd()!=null){
			c.andcsmHostBetween(this.getCsmHostStart(), this.getCsmHostEnd());
		}else if(this.getCsmHostGreater()!=null){
			c.andcsmHostGreaterThan(this.getCsmHostGreater());
		}else if(this.getCsmHostLess()!=null){
			c.andcsmHostLessThan(this.getCsmHostLess());
		}
		if(this.getCsmNumberEquals()!=null){
			c.andcsmNumberEqualTo(this.getCsmNumberEquals());
		}else if(this.getCsmNumberIsNull()!=null && this.getCsmNumberIsNull()){
			c.andcsmNumberIsNull();
		}else if(this.getCsmNumberIsNotNull()!=null && this.getCsmNumberIsNotNull()){
			c.andcsmNumberIsNotNull();
		}else if(this.getCsmNumberLike()!=null){
			c.andcsmNumberLike(this.getCsmNumberLike());
		}else if(this.getCsmNumberIn()!=null){
			c.andcsmNumberIn(java.util.Arrays.asList(this.getCsmNumberIn()));
		}else if(this.getCsmNumberStart()!=null && this.getCsmNumberEnd()!=null){
			c.andcsmNumberBetween(this.getCsmNumberStart(), this.getCsmNumberEnd());
		}else if(this.getCsmNumberGreater()!=null){
			c.andcsmNumberGreaterThan(this.getCsmNumberGreater());
		}else if(this.getCsmNumberLess()!=null){
			c.andcsmNumberLessThan(this.getCsmNumberLess());
		}
		if(this.getCsmTeNoEquals()!=null){
			c.andcsmTeNoEqualTo(this.getCsmTeNoEquals());
		}else if(this.getCsmTeNoIsNull()!=null && this.getCsmTeNoIsNull()){
			c.andcsmTeNoIsNull();
		}else if(this.getCsmTeNoIsNotNull()!=null && this.getCsmTeNoIsNotNull()){
			c.andcsmTeNoIsNotNull();
		}else if(this.getCsmTeNoLike()!=null){
			c.andcsmTeNoLike(this.getCsmTeNoLike());
		}else if(this.getCsmTeNoIn()!=null){
			c.andcsmTeNoIn(java.util.Arrays.asList(this.getCsmTeNoIn()));
		}else if(this.getCsmTeNoStart()!=null && this.getCsmTeNoEnd()!=null){
			c.andcsmTeNoBetween(this.getCsmTeNoStart(), this.getCsmTeNoEnd());
		}else if(this.getCsmTeNoGreater()!=null){
			c.andcsmTeNoGreaterThan(this.getCsmTeNoGreater());
		}else if(this.getCsmTeNoLess()!=null){
			c.andcsmTeNoLessThan(this.getCsmTeNoLess());
		}
		if(this.getCsmTeTypeEquals()!=null){
			c.andcsmTeTypeEqualTo(this.getCsmTeTypeEquals());
		}else if(this.getCsmTeTypeIsNull()!=null && this.getCsmTeTypeIsNull()){
			c.andcsmTeTypeIsNull();
		}else if(this.getCsmTeTypeIsNotNull()!=null && this.getCsmTeTypeIsNotNull()){
			c.andcsmTeTypeIsNotNull();
		}else if(this.getCsmTeTypeIn()!=null){
			c.andcsmTeTypeIn(java.util.Arrays.asList(this.getCsmTeTypeIn()));
		}else if(this.getCsmTeTypeStart()!=null && this.getCsmTeTypeEnd()!=null){
			c.andcsmTeTypeBetween(this.getCsmTeTypeStart(), this.getCsmTeTypeEnd());
		}else if(this.getCsmTeTypeGreater()!=null){
			c.andcsmTeTypeGreaterThan(this.getCsmTeTypeGreater());
		}else if(this.getCsmTeTypeLess()!=null){
			c.andcsmTeTypeLessThan(this.getCsmTeTypeLess());
		}
		if(this.getCsmTeModelEquals()!=null){
			c.andcsmTeModelEqualTo(this.getCsmTeModelEquals());
		}else if(this.getCsmTeModelIsNull()!=null && this.getCsmTeModelIsNull()){
			c.andcsmTeModelIsNull();
		}else if(this.getCsmTeModelIsNotNull()!=null && this.getCsmTeModelIsNotNull()){
			c.andcsmTeModelIsNotNull();
		}else if(this.getCsmTeModelLike()!=null){
			c.andcsmTeModelLike(this.getCsmTeModelLike());
		}else if(this.getCsmTeModelIn()!=null){
			c.andcsmTeModelIn(java.util.Arrays.asList(this.getCsmTeModelIn()));
		}else if(this.getCsmTeModelStart()!=null && this.getCsmTeModelEnd()!=null){
			c.andcsmTeModelBetween(this.getCsmTeModelStart(), this.getCsmTeModelEnd());
		}else if(this.getCsmTeModelGreater()!=null){
			c.andcsmTeModelGreaterThan(this.getCsmTeModelGreater());
		}else if(this.getCsmTeModelLess()!=null){
			c.andcsmTeModelLessThan(this.getCsmTeModelLess());
		}
		if(this.getCsmTeCodeEquals()!=null){
			c.andcsmTeCodeEqualTo(this.getCsmTeCodeEquals());
		}else if(this.getCsmTeCodeIsNull()!=null && this.getCsmTeCodeIsNull()){
			c.andcsmTeCodeIsNull();
		}else if(this.getCsmTeCodeIsNotNull()!=null && this.getCsmTeCodeIsNotNull()){
			c.andcsmTeCodeIsNotNull();
		}else if(this.getCsmTeCodeLike()!=null){
			c.andcsmTeCodeLike(this.getCsmTeCodeLike());
		}else if(this.getCsmTeCodeIn()!=null){
			c.andcsmTeCodeIn(java.util.Arrays.asList(this.getCsmTeCodeIn()));
		}else if(this.getCsmTeCodeStart()!=null && this.getCsmTeCodeEnd()!=null){
			c.andcsmTeCodeBetween(this.getCsmTeCodeStart(), this.getCsmTeCodeEnd());
		}else if(this.getCsmTeCodeGreater()!=null){
			c.andcsmTeCodeGreaterThan(this.getCsmTeCodeGreater());
		}else if(this.getCsmTeCodeLess()!=null){
			c.andcsmTeCodeLessThan(this.getCsmTeCodeLess());
		}
		if(this.getCsmTeLotNoEquals()!=null){
			c.andcsmTeLotNoEqualTo(this.getCsmTeLotNoEquals());
		}else if(this.getCsmTeLotNoIsNull()!=null && this.getCsmTeLotNoIsNull()){
			c.andcsmTeLotNoIsNull();
		}else if(this.getCsmTeLotNoIsNotNull()!=null && this.getCsmTeLotNoIsNotNull()){
			c.andcsmTeLotNoIsNotNull();
		}else if(this.getCsmTeLotNoLike()!=null){
			c.andcsmTeLotNoLike(this.getCsmTeLotNoLike());
		}else if(this.getCsmTeLotNoIn()!=null){
			c.andcsmTeLotNoIn(java.util.Arrays.asList(this.getCsmTeLotNoIn()));
		}else if(this.getCsmTeLotNoStart()!=null && this.getCsmTeLotNoEnd()!=null){
			c.andcsmTeLotNoBetween(this.getCsmTeLotNoStart(), this.getCsmTeLotNoEnd());
		}else if(this.getCsmTeLotNoGreater()!=null){
			c.andcsmTeLotNoGreaterThan(this.getCsmTeLotNoGreater());
		}else if(this.getCsmTeLotNoLess()!=null){
			c.andcsmTeLotNoLessThan(this.getCsmTeLotNoLess());
		}
		if(this.getCsmTeSerialEquals()!=null){
			c.andcsmTeSerialEqualTo(this.getCsmTeSerialEquals());
		}else if(this.getCsmTeSerialIsNull()!=null && this.getCsmTeSerialIsNull()){
			c.andcsmTeSerialIsNull();
		}else if(this.getCsmTeSerialIsNotNull()!=null && this.getCsmTeSerialIsNotNull()){
			c.andcsmTeSerialIsNotNull();
		}else if(this.getCsmTeSerialLike()!=null){
			c.andcsmTeSerialLike(this.getCsmTeSerialLike());
		}else if(this.getCsmTeSerialIn()!=null){
			c.andcsmTeSerialIn(java.util.Arrays.asList(this.getCsmTeSerialIn()));
		}else if(this.getCsmTeSerialStart()!=null && this.getCsmTeSerialEnd()!=null){
			c.andcsmTeSerialBetween(this.getCsmTeSerialStart(), this.getCsmTeSerialEnd());
		}else if(this.getCsmTeSerialGreater()!=null){
			c.andcsmTeSerialGreaterThan(this.getCsmTeSerialGreater());
		}else if(this.getCsmTeSerialLess()!=null){
			c.andcsmTeSerialLessThan(this.getCsmTeSerialLess());
		}
		if(this.getCsmMobileEquals()!=null){
			c.andcsmMobileEqualTo(this.getCsmMobileEquals());
		}else if(this.getCsmMobileIsNull()!=null && this.getCsmMobileIsNull()){
			c.andcsmMobileIsNull();
		}else if(this.getCsmMobileIsNotNull()!=null && this.getCsmMobileIsNotNull()){
			c.andcsmMobileIsNotNull();
		}else if(this.getCsmMobileLike()!=null){
			c.andcsmMobileLike(this.getCsmMobileLike());
		}else if(this.getCsmMobileIn()!=null){
			c.andcsmMobileIn(java.util.Arrays.asList(this.getCsmMobileIn()));
		}else if(this.getCsmMobileStart()!=null && this.getCsmMobileEnd()!=null){
			c.andcsmMobileBetween(this.getCsmMobileStart(), this.getCsmMobileEnd());
		}else if(this.getCsmMobileGreater()!=null){
			c.andcsmMobileGreaterThan(this.getCsmMobileGreater());
		}else if(this.getCsmMobileLess()!=null){
			c.andcsmMobileLessThan(this.getCsmMobileLess());
		}
		if(this.getCsmIccidEquals()!=null){
			c.andcsmIccidEqualTo(this.getCsmIccidEquals());
		}else if(this.getCsmIccidIsNull()!=null && this.getCsmIccidIsNull()){
			c.andcsmIccidIsNull();
		}else if(this.getCsmIccidIsNotNull()!=null && this.getCsmIccidIsNotNull()){
			c.andcsmIccidIsNotNull();
		}else if(this.getCsmIccidLike()!=null){
			c.andcsmIccidLike(this.getCsmIccidLike());
		}else if(this.getCsmIccidIn()!=null){
			c.andcsmIccidIn(java.util.Arrays.asList(this.getCsmIccidIn()));
		}else if(this.getCsmIccidStart()!=null && this.getCsmIccidEnd()!=null){
			c.andcsmIccidBetween(this.getCsmIccidStart(), this.getCsmIccidEnd());
		}else if(this.getCsmIccidGreater()!=null){
			c.andcsmIccidGreaterThan(this.getCsmIccidGreater());
		}else if(this.getCsmIccidLess()!=null){
			c.andcsmIccidLessThan(this.getCsmIccidLess());
		}
		if(this.getCsmPasswordEquals()!=null){
			c.andcsmPasswordEqualTo(this.getCsmPasswordEquals());
		}else if(this.getCsmPasswordIsNull()!=null && this.getCsmPasswordIsNull()){
			c.andcsmPasswordIsNull();
		}else if(this.getCsmPasswordIsNotNull()!=null && this.getCsmPasswordIsNotNull()){
			c.andcsmPasswordIsNotNull();
		}else if(this.getCsmPasswordLike()!=null){
			c.andcsmPasswordLike(this.getCsmPasswordLike());
		}else if(this.getCsmPasswordIn()!=null){
			c.andcsmPasswordIn(java.util.Arrays.asList(this.getCsmPasswordIn()));
		}else if(this.getCsmPasswordStart()!=null && this.getCsmPasswordEnd()!=null){
			c.andcsmPasswordBetween(this.getCsmPasswordStart(), this.getCsmPasswordEnd());
		}else if(this.getCsmPasswordGreater()!=null){
			c.andcsmPasswordGreaterThan(this.getCsmPasswordGreater());
		}else if(this.getCsmPasswordLess()!=null){
			c.andcsmPasswordLessThan(this.getCsmPasswordLess());
		}
		if(this.getCsmProtocolEquals()!=null){
			c.andcsmProtocolEqualTo(this.getCsmProtocolEquals());
		}else if(this.getCsmProtocolIsNull()!=null && this.getCsmProtocolIsNull()){
			c.andcsmProtocolIsNull();
		}else if(this.getCsmProtocolIsNotNull()!=null && this.getCsmProtocolIsNotNull()){
			c.andcsmProtocolIsNotNull();
		}else if(this.getCsmProtocolIn()!=null){
			c.andcsmProtocolIn(java.util.Arrays.asList(this.getCsmProtocolIn()));
		}else if(this.getCsmProtocolStart()!=null && this.getCsmProtocolEnd()!=null){
			c.andcsmProtocolBetween(this.getCsmProtocolStart(), this.getCsmProtocolEnd());
		}else if(this.getCsmProtocolGreater()!=null){
			c.andcsmProtocolGreaterThan(this.getCsmProtocolGreater());
		}else if(this.getCsmProtocolLess()!=null){
			c.andcsmProtocolLessThan(this.getCsmProtocolLess());
		}
		if(this.getCsmFunctionsEquals()!=null){
			c.andcsmFunctionsEqualTo(this.getCsmFunctionsEquals());
		}else if(this.getCsmFunctionsIsNull()!=null && this.getCsmFunctionsIsNull()){
			c.andcsmFunctionsIsNull();
		}else if(this.getCsmFunctionsIsNotNull()!=null && this.getCsmFunctionsIsNotNull()){
			c.andcsmFunctionsIsNotNull();
		}else if(this.getCsmFunctionsLike()!=null){
			c.andcsmFunctionsLike(this.getCsmFunctionsLike());
		}else if(this.getCsmFunctionsIn()!=null){
			c.andcsmFunctionsIn(java.util.Arrays.asList(this.getCsmFunctionsIn()));
		}else if(this.getCsmFunctionsStart()!=null && this.getCsmFunctionsEnd()!=null){
			c.andcsmFunctionsBetween(this.getCsmFunctionsStart(), this.getCsmFunctionsEnd());
		}else if(this.getCsmFunctionsGreater()!=null){
			c.andcsmFunctionsGreaterThan(this.getCsmFunctionsGreater());
		}else if(this.getCsmFunctionsLess()!=null){
			c.andcsmFunctionsLessThan(this.getCsmFunctionsLess());
		}
		if(this.getCsmBluetoothVersionEquals()!=null){
			c.andcsmBluetoothVersionEqualTo(this.getCsmBluetoothVersionEquals());
		}else if(this.getCsmBluetoothVersionIsNull()!=null && this.getCsmBluetoothVersionIsNull()){
			c.andcsmBluetoothVersionIsNull();
		}else if(this.getCsmBluetoothVersionIsNotNull()!=null && this.getCsmBluetoothVersionIsNotNull()){
			c.andcsmBluetoothVersionIsNotNull();
		}else if(this.getCsmBluetoothVersionIn()!=null){
			c.andcsmBluetoothVersionIn(java.util.Arrays.asList(this.getCsmBluetoothVersionIn()));
		}else if(this.getCsmBluetoothVersionStart()!=null && this.getCsmBluetoothVersionEnd()!=null){
			c.andcsmBluetoothVersionBetween(this.getCsmBluetoothVersionStart(), this.getCsmBluetoothVersionEnd());
		}else if(this.getCsmBluetoothVersionGreater()!=null){
			c.andcsmBluetoothVersionGreaterThan(this.getCsmBluetoothVersionGreater());
		}else if(this.getCsmBluetoothVersionLess()!=null){
			c.andcsmBluetoothVersionLessThan(this.getCsmBluetoothVersionLess());
		}
		if(this.getCsmBluetoothMacEquals()!=null){
			c.andcsmBluetoothMacEqualTo(this.getCsmBluetoothMacEquals());
		}else if(this.getCsmBluetoothMacIsNull()!=null && this.getCsmBluetoothMacIsNull()){
			c.andcsmBluetoothMacIsNull();
		}else if(this.getCsmBluetoothMacIsNotNull()!=null && this.getCsmBluetoothMacIsNotNull()){
			c.andcsmBluetoothMacIsNotNull();
		}else if(this.getCsmBluetoothMacLike()!=null){
			c.andcsmBluetoothMacLike(this.getCsmBluetoothMacLike());
		}else if(this.getCsmBluetoothMacIn()!=null){
			c.andcsmBluetoothMacIn(java.util.Arrays.asList(this.getCsmBluetoothMacIn()));
		}else if(this.getCsmBluetoothMacStart()!=null && this.getCsmBluetoothMacEnd()!=null){
			c.andcsmBluetoothMacBetween(this.getCsmBluetoothMacStart(), this.getCsmBluetoothMacEnd());
		}else if(this.getCsmBluetoothMacGreater()!=null){
			c.andcsmBluetoothMacGreaterThan(this.getCsmBluetoothMacGreater());
		}else if(this.getCsmBluetoothMacLess()!=null){
			c.andcsmBluetoothMacLessThan(this.getCsmBluetoothMacLess());
		}
		if(this.getCsmBluetoothPsdEquals()!=null){
			c.andcsmBluetoothPsdEqualTo(this.getCsmBluetoothPsdEquals());
		}else if(this.getCsmBluetoothPsdIsNull()!=null && this.getCsmBluetoothPsdIsNull()){
			c.andcsmBluetoothPsdIsNull();
		}else if(this.getCsmBluetoothPsdIsNotNull()!=null && this.getCsmBluetoothPsdIsNotNull()){
			c.andcsmBluetoothPsdIsNotNull();
		}else if(this.getCsmBluetoothPsdLike()!=null){
			c.andcsmBluetoothPsdLike(this.getCsmBluetoothPsdLike());
		}else if(this.getCsmBluetoothPsdIn()!=null){
			c.andcsmBluetoothPsdIn(java.util.Arrays.asList(this.getCsmBluetoothPsdIn()));
		}else if(this.getCsmBluetoothPsdStart()!=null && this.getCsmBluetoothPsdEnd()!=null){
			c.andcsmBluetoothPsdBetween(this.getCsmBluetoothPsdStart(), this.getCsmBluetoothPsdEnd());
		}else if(this.getCsmBluetoothPsdGreater()!=null){
			c.andcsmBluetoothPsdGreaterThan(this.getCsmBluetoothPsdGreater());
		}else if(this.getCsmBluetoothPsdLess()!=null){
			c.andcsmBluetoothPsdLessThan(this.getCsmBluetoothPsdLess());
		}
		if(this.getCsmMqttFlagEquals()!=null){
			c.andcsmMqttFlagEqualTo(this.getCsmMqttFlagEquals());
		}else if(this.getCsmMqttFlagIsNull()!=null && this.getCsmMqttFlagIsNull()){
			c.andcsmMqttFlagIsNull();
		}else if(this.getCsmMqttFlagIsNotNull()!=null && this.getCsmMqttFlagIsNotNull()){
			c.andcsmMqttFlagIsNotNull();
		}else if(this.getCsmMqttFlagLike()!=null){
			c.andcsmMqttFlagLike(this.getCsmMqttFlagLike());
		}else if(this.getCsmMqttFlagIn()!=null){
			c.andcsmMqttFlagIn(java.util.Arrays.asList(this.getCsmMqttFlagIn()));
		}else if(this.getCsmMqttFlagStart()!=null && this.getCsmMqttFlagEnd()!=null){
			c.andcsmMqttFlagBetween(this.getCsmMqttFlagStart(), this.getCsmMqttFlagEnd());
		}else if(this.getCsmMqttFlagGreater()!=null){
			c.andcsmMqttFlagGreaterThan(this.getCsmMqttFlagGreater());
		}else if(this.getCsmMqttFlagLess()!=null){
			c.andcsmMqttFlagLessThan(this.getCsmMqttFlagLess());
		}
		if(this.getCsmSuperSimEquals()!=null){
			c.andcsmSuperSimEqualTo(this.getCsmSuperSimEquals());
		}else if(this.getCsmSuperSimIsNull()!=null && this.getCsmSuperSimIsNull()){
			c.andcsmSuperSimIsNull();
		}else if(this.getCsmSuperSimIsNotNull()!=null && this.getCsmSuperSimIsNotNull()){
			c.andcsmSuperSimIsNotNull();
		}else if(this.getCsmSuperSimLike()!=null){
			c.andcsmSuperSimLike(this.getCsmSuperSimLike());
		}else if(this.getCsmSuperSimIn()!=null){
			c.andcsmSuperSimIn(java.util.Arrays.asList(this.getCsmSuperSimIn()));
		}else if(this.getCsmSuperSimStart()!=null && this.getCsmSuperSimEnd()!=null){
			c.andcsmSuperSimBetween(this.getCsmSuperSimStart(), this.getCsmSuperSimEnd());
		}else if(this.getCsmSuperSimGreater()!=null){
			c.andcsmSuperSimGreaterThan(this.getCsmSuperSimGreater());
		}else if(this.getCsmSuperSimLess()!=null){
			c.andcsmSuperSimLessThan(this.getCsmSuperSimLess());
		}
		if(this.getCsmLandmarkEquals()!=null){
			c.andcsmLandmarkEqualTo(this.getCsmLandmarkEquals());
		}else if(this.getCsmLandmarkIsNull()!=null && this.getCsmLandmarkIsNull()){
			c.andcsmLandmarkIsNull();
		}else if(this.getCsmLandmarkIsNotNull()!=null && this.getCsmLandmarkIsNotNull()){
			c.andcsmLandmarkIsNotNull();
		}else if(this.getCsmLandmarkLike()!=null){
			c.andcsmLandmarkLike(this.getCsmLandmarkLike());
		}else if(this.getCsmLandmarkIn()!=null){
			c.andcsmLandmarkIn(java.util.Arrays.asList(this.getCsmLandmarkIn()));
		}else if(this.getCsmLandmarkStart()!=null && this.getCsmLandmarkEnd()!=null){
			c.andcsmLandmarkBetween(this.getCsmLandmarkStart(), this.getCsmLandmarkEnd());
		}else if(this.getCsmLandmarkGreater()!=null){
			c.andcsmLandmarkGreaterThan(this.getCsmLandmarkGreater());
		}else if(this.getCsmLandmarkLess()!=null){
			c.andcsmLandmarkLessThan(this.getCsmLandmarkLess());
		}
		if(this.getCsmV2Equals()!=null){
			c.andcsmV2EqualTo(this.getCsmV2Equals());
		}else if(this.getCsmV2IsNull()!=null && this.getCsmV2IsNull()){
			c.andcsmV2IsNull();
		}else if(this.getCsmV2IsNotNull()!=null && this.getCsmV2IsNotNull()){
			c.andcsmV2IsNotNull();
		}else if(this.getCsmV2Like()!=null){
			c.andcsmV2Like(this.getCsmV2Like());
		}else if(this.getCsmV2In()!=null){
			c.andcsmV2In(java.util.Arrays.asList(this.getCsmV2In()));
		}else if(this.getCsmV2Start()!=null && this.getCsmV2End()!=null){
			c.andcsmV2Between(this.getCsmV2Start(), this.getCsmV2End());
		}else if(this.getCsmV2Greater()!=null){
			c.andcsmV2GreaterThan(this.getCsmV2Greater());
		}else if(this.getCsmV2Less()!=null){
			c.andcsmV2LessThan(this.getCsmV2Less());
		}
		if(this.getCsmV3Equals()!=null){
			c.andcsmV3EqualTo(this.getCsmV3Equals());
		}else if(this.getCsmV3IsNull()!=null && this.getCsmV3IsNull()){
			c.andcsmV3IsNull();
		}else if(this.getCsmV3IsNotNull()!=null && this.getCsmV3IsNotNull()){
			c.andcsmV3IsNotNull();
		}else if(this.getCsmV3Like()!=null){
			c.andcsmV3Like(this.getCsmV3Like());
		}else if(this.getCsmV3In()!=null){
			c.andcsmV3In(java.util.Arrays.asList(this.getCsmV3In()));
		}else if(this.getCsmV3Start()!=null && this.getCsmV3End()!=null){
			c.andcsmV3Between(this.getCsmV3Start(), this.getCsmV3End());
		}else if(this.getCsmV3Greater()!=null){
			c.andcsmV3GreaterThan(this.getCsmV3Greater());
		}else if(this.getCsmV3Less()!=null){
			c.andcsmV3LessThan(this.getCsmV3Less());
		}
		if(this.getCsmV3ToEquals()!=null){
			c.andcsmV3ToEqualTo(this.getCsmV3ToEquals());
		}else if(this.getCsmV3ToIsNull()!=null && this.getCsmV3ToIsNull()){
			c.andcsmV3ToIsNull();
		}else if(this.getCsmV3ToIsNotNull()!=null && this.getCsmV3ToIsNotNull()){
			c.andcsmV3ToIsNotNull();
		}else if(this.getCsmV3ToLike()!=null){
			c.andcsmV3ToLike(this.getCsmV3ToLike());
		}else if(this.getCsmV3ToIn()!=null){
			c.andcsmV3ToIn(java.util.Arrays.asList(this.getCsmV3ToIn()));
		}else if(this.getCsmV3ToStart()!=null && this.getCsmV3ToEnd()!=null){
			c.andcsmV3ToBetween(this.getCsmV3ToStart(), this.getCsmV3ToEnd());
		}else if(this.getCsmV3ToGreater()!=null){
			c.andcsmV3ToGreaterThan(this.getCsmV3ToGreater());
		}else if(this.getCsmV3ToLess()!=null){
			c.andcsmV3ToLessThan(this.getCsmV3ToLess());
		}
		if(this.getCsmSuitEquals()!=null){
			c.andcsmSuitEqualTo(this.getCsmSuitEquals());
		}else if(this.getCsmSuitIsNull()!=null && this.getCsmSuitIsNull()){
			c.andcsmSuitIsNull();
		}else if(this.getCsmSuitIsNotNull()!=null && this.getCsmSuitIsNotNull()){
			c.andcsmSuitIsNotNull();
		}else if(this.getCsmSuitIn()!=null){
			c.andcsmSuitIn(java.util.Arrays.asList(this.getCsmSuitIn()));
		}else if(this.getCsmSuitStart()!=null && this.getCsmSuitEnd()!=null){
			c.andcsmSuitBetween(this.getCsmSuitStart(), this.getCsmSuitEnd());
		}else if(this.getCsmSuitGreater()!=null){
			c.andcsmSuitGreaterThan(this.getCsmSuitGreater());
		}else if(this.getCsmSuitLess()!=null){
			c.andcsmSuitLessThan(this.getCsmSuitLess());
		}
		if(this.getCsmTlV1Equals()!=null){
			c.andcsmTlV1EqualTo(this.getCsmTlV1Equals());
		}else if(this.getCsmTlV1IsNull()!=null && this.getCsmTlV1IsNull()){
			c.andcsmTlV1IsNull();
		}else if(this.getCsmTlV1IsNotNull()!=null && this.getCsmTlV1IsNotNull()){
			c.andcsmTlV1IsNotNull();
		}else if(this.getCsmTlV1Like()!=null){
			c.andcsmTlV1Like(this.getCsmTlV1Like());
		}else if(this.getCsmTlV1In()!=null){
			c.andcsmTlV1In(java.util.Arrays.asList(this.getCsmTlV1In()));
		}else if(this.getCsmTlV1Start()!=null && this.getCsmTlV1End()!=null){
			c.andcsmTlV1Between(this.getCsmTlV1Start(), this.getCsmTlV1End());
		}else if(this.getCsmTlV1Greater()!=null){
			c.andcsmTlV1GreaterThan(this.getCsmTlV1Greater());
		}else if(this.getCsmTlV1Less()!=null){
			c.andcsmTlV1LessThan(this.getCsmTlV1Less());
		}
		if(this.getCsmTlV2Equals()!=null){
			c.andcsmTlV2EqualTo(this.getCsmTlV2Equals());
		}else if(this.getCsmTlV2IsNull()!=null && this.getCsmTlV2IsNull()){
			c.andcsmTlV2IsNull();
		}else if(this.getCsmTlV2IsNotNull()!=null && this.getCsmTlV2IsNotNull()){
			c.andcsmTlV2IsNotNull();
		}else if(this.getCsmTlV2In()!=null){
			c.andcsmTlV2In(java.util.Arrays.asList(this.getCsmTlV2In()));
		}else if(this.getCsmTlV2Start()!=null && this.getCsmTlV2End()!=null){
			c.andcsmTlV2Between(this.getCsmTlV2Start(), this.getCsmTlV2End());
		}else if(this.getCsmTlV2Greater()!=null){
			c.andcsmTlV2GreaterThan(this.getCsmTlV2Greater());
		}else if(this.getCsmTlV2Less()!=null){
			c.andcsmTlV2LessThan(this.getCsmTlV2Less());
		}
		if(this.getCsmNetTypeEquals()!=null){
			c.andcsmNetTypeEqualTo(this.getCsmNetTypeEquals());
		}else if(this.getCsmNetTypeIsNull()!=null && this.getCsmNetTypeIsNull()){
			c.andcsmNetTypeIsNull();
		}else if(this.getCsmNetTypeIsNotNull()!=null && this.getCsmNetTypeIsNotNull()){
			c.andcsmNetTypeIsNotNull();
		}else if(this.getCsmNetTypeIn()!=null){
			c.andcsmNetTypeIn(java.util.Arrays.asList(this.getCsmNetTypeIn()));
		}else if(this.getCsmNetTypeStart()!=null && this.getCsmNetTypeEnd()!=null){
			c.andcsmNetTypeBetween(this.getCsmNetTypeStart(), this.getCsmNetTypeEnd());
		}else if(this.getCsmNetTypeGreater()!=null){
			c.andcsmNetTypeGreaterThan(this.getCsmNetTypeGreater());
		}else if(this.getCsmNetTypeLess()!=null){
			c.andcsmNetTypeLessThan(this.getCsmNetTypeLess());
		}
		if(this.getCsmProTypeEquals()!=null){
			c.andcsmProTypeEqualTo(this.getCsmProTypeEquals());
		}else if(this.getCsmProTypeIsNull()!=null && this.getCsmProTypeIsNull()){
			c.andcsmProTypeIsNull();
		}else if(this.getCsmProTypeIsNotNull()!=null && this.getCsmProTypeIsNotNull()){
			c.andcsmProTypeIsNotNull();
		}else if(this.getCsmProTypeIn()!=null){
			c.andcsmProTypeIn(java.util.Arrays.asList(this.getCsmProTypeIn()));
		}else if(this.getCsmProTypeStart()!=null && this.getCsmProTypeEnd()!=null){
			c.andcsmProTypeBetween(this.getCsmProTypeStart(), this.getCsmProTypeEnd());
		}else if(this.getCsmProTypeGreater()!=null){
			c.andcsmProTypeGreaterThan(this.getCsmProTypeGreater());
		}else if(this.getCsmProTypeLess()!=null){
			c.andcsmProTypeLessThan(this.getCsmProTypeLess());
		}
		if(this.getCsmBaudRateEquals()!=null){
			c.andcsmBaudRateEqualTo(this.getCsmBaudRateEquals());
		}else if(this.getCsmBaudRateIsNull()!=null && this.getCsmBaudRateIsNull()){
			c.andcsmBaudRateIsNull();
		}else if(this.getCsmBaudRateIsNotNull()!=null && this.getCsmBaudRateIsNotNull()){
			c.andcsmBaudRateIsNotNull();
		}else if(this.getCsmBaudRateIn()!=null){
			c.andcsmBaudRateIn(java.util.Arrays.asList(this.getCsmBaudRateIn()));
		}else if(this.getCsmBaudRateStart()!=null && this.getCsmBaudRateEnd()!=null){
			c.andcsmBaudRateBetween(this.getCsmBaudRateStart(), this.getCsmBaudRateEnd());
		}else if(this.getCsmBaudRateGreater()!=null){
			c.andcsmBaudRateGreaterThan(this.getCsmBaudRateGreater());
		}else if(this.getCsmBaudRateLess()!=null){
			c.andcsmBaudRateLessThan(this.getCsmBaudRateLess());
		}
		if(this.getCsmRemarkEquals()!=null){
			c.andcsmRemarkEqualTo(this.getCsmRemarkEquals());
		}else if(this.getCsmRemarkIsNull()!=null && this.getCsmRemarkIsNull()){
			c.andcsmRemarkIsNull();
		}else if(this.getCsmRemarkIsNotNull()!=null && this.getCsmRemarkIsNotNull()){
			c.andcsmRemarkIsNotNull();
		}else if(this.getCsmRemarkLike()!=null){
			c.andcsmRemarkLike(this.getCsmRemarkLike());
		}else if(this.getCsmRemarkIn()!=null){
			c.andcsmRemarkIn(java.util.Arrays.asList(this.getCsmRemarkIn()));
		}else if(this.getCsmRemarkStart()!=null && this.getCsmRemarkEnd()!=null){
			c.andcsmRemarkBetween(this.getCsmRemarkStart(), this.getCsmRemarkEnd());
		}else if(this.getCsmRemarkGreater()!=null){
			c.andcsmRemarkGreaterThan(this.getCsmRemarkGreater());
		}else if(this.getCsmRemarkLess()!=null){
			c.andcsmRemarkLessThan(this.getCsmRemarkLess());
		}
		if(this.getCsmUpdateTimeEquals()!=null){
			c.andcsmUpdateTimeEqualTo(this.getCsmUpdateTimeEquals());
		}else if(this.getCsmUpdateTimeIsNull()!=null && this.getCsmUpdateTimeIsNull()){
			c.andcsmUpdateTimeIsNull();
		}else if(this.getCsmUpdateTimeIsNotNull()!=null && this.getCsmUpdateTimeIsNotNull()){
			c.andcsmUpdateTimeIsNotNull();
		}else if(this.getCsmUpdateTimeIn()!=null){
			c.andcsmUpdateTimeIn(java.util.Arrays.asList(this.getCsmUpdateTimeIn()));
		}else if(this.getCsmUpdateTimeStart()!=null && this.getCsmUpdateTimeEnd()!=null){
			c.andcsmUpdateTimeBetween(this.getCsmUpdateTimeStart(), this.getCsmUpdateTimeEnd());
		}else if(this.getCsmUpdateTimeGreater()!=null){
			c.andcsmUpdateTimeGreaterThan(this.getCsmUpdateTimeGreater());
		}else if(this.getCsmUpdateTimeLess()!=null){
			c.andcsmUpdateTimeLessThan(this.getCsmUpdateTimeLess());
		}
		if(this.getCsmAddTimeEquals()!=null){
			c.andcsmAddTimeEqualTo(this.getCsmAddTimeEquals());
		}else if(this.getCsmAddTimeIsNull()!=null && this.getCsmAddTimeIsNull()){
			c.andcsmAddTimeIsNull();
		}else if(this.getCsmAddTimeIsNotNull()!=null && this.getCsmAddTimeIsNotNull()){
			c.andcsmAddTimeIsNotNull();
		}else if(this.getCsmAddTimeIn()!=null){
			c.andcsmAddTimeIn(java.util.Arrays.asList(this.getCsmAddTimeIn()));
		}else if(this.getCsmAddTimeStart()!=null && this.getCsmAddTimeEnd()!=null){
			c.andcsmAddTimeBetween(this.getCsmAddTimeStart(), this.getCsmAddTimeEnd());
		}else if(this.getCsmAddTimeGreater()!=null){
			c.andcsmAddTimeGreaterThan(this.getCsmAddTimeGreater());
		}else if(this.getCsmAddTimeLess()!=null){
			c.andcsmAddTimeLessThan(this.getCsmAddTimeLess());
		}
		if(this.getCsmStatusEquals()!=null){
			c.andcsmStatusEqualTo(this.getCsmStatusEquals());
		}else if(this.getCsmStatusIsNull()!=null && this.getCsmStatusIsNull()){
			c.andcsmStatusIsNull();
		}else if(this.getCsmStatusIsNotNull()!=null && this.getCsmStatusIsNotNull()){
			c.andcsmStatusIsNotNull();
		}else if(this.getCsmStatusIn()!=null){
			c.andcsmStatusIn(java.util.Arrays.asList(this.getCsmStatusIn()));
		}else if(this.getCsmStatusStart()!=null && this.getCsmStatusEnd()!=null){
			c.andcsmStatusBetween(this.getCsmStatusStart(), this.getCsmStatusEnd());
		}else if(this.getCsmStatusGreater()!=null){
			c.andcsmStatusGreaterThan(this.getCsmStatusGreater());
		}else if(this.getCsmStatusLess()!=null){
			c.andcsmStatusLessThan(this.getCsmStatusLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
