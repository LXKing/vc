package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsStateCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class CsStateQuery {
	
	private Integer cssIdEquals;
	private Integer[] cssIdIn;
	private Boolean cssIdIsNull;
	private Boolean cssIdIsNotNull;
	
	private Integer cssIdStart;
	
	private Integer cssIdEnd;
	
	private Integer cssIdLess;
	
	private Integer cssIdGreater;
	
	private Short cssAccessEquals;
	private Short[] cssAccessIn;
	private Boolean cssAccessIsNull;
	private Boolean cssAccessIsNotNull;
	
	private Short cssAccessStart;
	
	private Short cssAccessEnd;
	
	private Short cssAccessLess;
	
	private Short cssAccessGreater;
	
	private Short cssHostEquals;
	private Short[] cssHostIn;
	private Boolean cssHostIsNull;
	private Boolean cssHostIsNotNull;
	
	private Short cssHostStart;
	
	private Short cssHostEnd;
	
	private Short cssHostLess;
	
	private Short cssHostGreater;
	private String cssNumberLike;
	
	private String cssNumberEquals;
	private String[] cssNumberIn;
	private Boolean cssNumberIsNull;
	private Boolean cssNumberIsNotNull;
	
	private String cssNumberStart;
	
	private String cssNumberEnd;
	
	private String cssNumberLess;
	
	private String cssNumberGreater;
	
	private Integer cssCarEquals;
	private Integer[] cssCarIn;
	private Boolean cssCarIsNull;
	private Boolean cssCarIsNotNull;
	
	private Integer cssCarStart;
	
	private Integer cssCarEnd;
	
	private Integer cssCarLess;
	
	private Integer cssCarGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssAddTimeEquals;
	private Date[] cssAddTimeIn;
	private Boolean cssAddTimeIsNull;
	private Boolean cssAddTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssAddTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssAddTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssCurrentTimeEquals;
	private Date[] cssCurrentTimeIn;
	private Boolean cssCurrentTimeIsNull;
	private Boolean cssCurrentTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssCurrentTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssCurrentTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssCurrentTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssCurrentTimeGreater;
	private String cssRentedLike;
	
	private String cssRentedEquals;
	private String[] cssRentedIn;
	private Boolean cssRentedIsNull;
	private Boolean cssRentedIsNotNull;
	
	private String cssRentedStart;
	
	private String cssRentedEnd;
	
	private String cssRentedLess;
	
	private String cssRentedGreater;
	
	private Integer cssWarnEquals;
	private Integer[] cssWarnIn;
	private Boolean cssWarnIsNull;
	private Boolean cssWarnIsNotNull;
	
	private Integer cssWarnStart;
	
	private Integer cssWarnEnd;
	
	private Integer cssWarnLess;
	
	private Integer cssWarnGreater;
	private String cssRfidLike;
	
	private String cssRfidEquals;
	private String[] cssRfidIn;
	private Boolean cssRfidIsNull;
	private Boolean cssRfidIsNotNull;
	
	private String cssRfidStart;
	
	private String cssRfidEnd;
	
	private String cssRfidLess;
	
	private String cssRfidGreater;
	private String cssRfidDteLike;
	
	private String cssRfidDteEquals;
	private String[] cssRfidDteIn;
	private Boolean cssRfidDteIsNull;
	private Boolean cssRfidDteIsNotNull;
	
	private String cssRfidDteStart;
	
	private String cssRfidDteEnd;
	
	private String cssRfidDteLess;
	
	private String cssRfidDteGreater;
	
	private BigDecimal cssObdMileEquals;
	private BigDecimal[] cssObdMileIn;
	private Boolean cssObdMileIsNull;
	private Boolean cssObdMileIsNotNull;
	
	private BigDecimal cssObdMileStart;
	
	private BigDecimal cssObdMileEnd;
	
	private BigDecimal cssObdMileLess;
	
	private BigDecimal cssObdMileGreater;
	
	private BigDecimal cssEngineTEquals;
	private BigDecimal[] cssEngineTIn;
	private Boolean cssEngineTIsNull;
	private Boolean cssEngineTIsNotNull;
	
	private BigDecimal cssEngineTStart;
	
	private BigDecimal cssEngineTEnd;
	
	private BigDecimal cssEngineTLess;
	
	private BigDecimal cssEngineTGreater;
	
	private BigDecimal cssMileageEquals;
	private BigDecimal[] cssMileageIn;
	private Boolean cssMileageIsNull;
	private Boolean cssMileageIsNotNull;
	
	private BigDecimal cssMileageStart;
	
	private BigDecimal cssMileageEnd;
	
	private BigDecimal cssMileageLess;
	
	private BigDecimal cssMileageGreater;
	
	private BigDecimal cssSpeedEquals;
	private BigDecimal[] cssSpeedIn;
	private Boolean cssSpeedIsNull;
	private Boolean cssSpeedIsNotNull;
	
	private BigDecimal cssSpeedStart;
	
	private BigDecimal cssSpeedEnd;
	
	private BigDecimal cssSpeedLess;
	
	private BigDecimal cssSpeedGreater;
	
	private Integer cssMotorEquals;
	private Integer[] cssMotorIn;
	private Boolean cssMotorIsNull;
	private Boolean cssMotorIsNotNull;
	
	private Integer cssMotorStart;
	
	private Integer cssMotorEnd;
	
	private Integer cssMotorLess;
	
	private Integer cssMotorGreater;
	
	private BigDecimal cssOilEquals;
	private BigDecimal[] cssOilIn;
	private Boolean cssOilIsNull;
	private Boolean cssOilIsNotNull;
	
	private BigDecimal cssOilStart;
	
	private BigDecimal cssOilEnd;
	
	private BigDecimal cssOilLess;
	
	private BigDecimal cssOilGreater;
	
	private Integer cssPowerEquals;
	private Integer[] cssPowerIn;
	private Boolean cssPowerIsNull;
	private Boolean cssPowerIsNotNull;
	
	private Integer cssPowerStart;
	
	private Integer cssPowerEnd;
	
	private Integer cssPowerLess;
	
	private Integer cssPowerGreater;
	
	private Short cssEvBatteryEquals;
	private Short[] cssEvBatteryIn;
	private Boolean cssEvBatteryIsNull;
	private Boolean cssEvBatteryIsNotNull;
	
	private Short cssEvBatteryStart;
	
	private Short cssEvBatteryEnd;
	
	private Short cssEvBatteryLess;
	
	private Short cssEvBatteryGreater;
	
	private Short cssChargingEquals;
	private Short[] cssChargingIn;
	private Boolean cssChargingIsNull;
	private Boolean cssChargingIsNotNull;
	
	private Short cssChargingStart;
	
	private Short cssChargingEnd;
	
	private Short cssChargingLess;
	
	private Short cssChargingGreater;
	
	private BigDecimal cssFuelMileageEquals;
	private BigDecimal[] cssFuelMileageIn;
	private Boolean cssFuelMileageIsNull;
	private Boolean cssFuelMileageIsNotNull;
	
	private BigDecimal cssFuelMileageStart;
	
	private BigDecimal cssFuelMileageEnd;
	
	private BigDecimal cssFuelMileageLess;
	
	private BigDecimal cssFuelMileageGreater;
	
	private BigDecimal cssElectricMileageEquals;
	private BigDecimal[] cssElectricMileageIn;
	private Boolean cssElectricMileageIsNull;
	private Boolean cssElectricMileageIsNotNull;
	
	private BigDecimal cssElectricMileageStart;
	
	private BigDecimal cssElectricMileageEnd;
	
	private BigDecimal cssElectricMileageLess;
	
	private BigDecimal cssElectricMileageGreater;
	
	private BigDecimal cssEnduranceEquals;
	private BigDecimal[] cssEnduranceIn;
	private Boolean cssEnduranceIsNull;
	private Boolean cssEnduranceIsNotNull;
	
	private BigDecimal cssEnduranceStart;
	
	private BigDecimal cssEnduranceEnd;
	
	private BigDecimal cssEnduranceLess;
	
	private BigDecimal cssEnduranceGreater;
	
	private BigDecimal cssTemperatureEquals;
	private BigDecimal[] cssTemperatureIn;
	private Boolean cssTemperatureIsNull;
	private Boolean cssTemperatureIsNotNull;
	
	private BigDecimal cssTemperatureStart;
	
	private BigDecimal cssTemperatureEnd;
	
	private BigDecimal cssTemperatureLess;
	
	private BigDecimal cssTemperatureGreater;
	
	private Short cssCsqEquals;
	private Short[] cssCsqIn;
	private Boolean cssCsqIsNull;
	private Boolean cssCsqIsNotNull;
	
	private Short cssCsqStart;
	
	private Short cssCsqEnd;
	
	private Short cssCsqLess;
	
	private Short cssCsqGreater;
	
	private BigDecimal cssLongitudeEquals;
	private BigDecimal[] cssLongitudeIn;
	private Boolean cssLongitudeIsNull;
	private Boolean cssLongitudeIsNotNull;
	
	private BigDecimal cssLongitudeStart;
	
	private BigDecimal cssLongitudeEnd;
	
	private BigDecimal cssLongitudeLess;
	
	private BigDecimal cssLongitudeGreater;
	
	private BigDecimal cssLatitudeEquals;
	private BigDecimal[] cssLatitudeIn;
	private Boolean cssLatitudeIsNull;
	private Boolean cssLatitudeIsNotNull;
	
	private BigDecimal cssLatitudeStart;
	
	private BigDecimal cssLatitudeEnd;
	
	private BigDecimal cssLatitudeLess;
	
	private BigDecimal cssLatitudeGreater;
	
	private Short cssGpsValidEquals;
	private Short[] cssGpsValidIn;
	private Boolean cssGpsValidIsNull;
	private Boolean cssGpsValidIsNotNull;
	
	private Short cssGpsValidStart;
	
	private Short cssGpsValidEnd;
	
	private Short cssGpsValidLess;
	
	private Short cssGpsValidGreater;
	
	private Short cssGpsCnEquals;
	private Short[] cssGpsCnIn;
	private Boolean cssGpsCnIsNull;
	private Boolean cssGpsCnIsNotNull;
	
	private Short cssGpsCnStart;
	
	private Short cssGpsCnEnd;
	
	private Short cssGpsCnLess;
	
	private Short cssGpsCnGreater;
	
	private Short cssGpsCountEquals;
	private Short[] cssGpsCountIn;
	private Boolean cssGpsCountIsNull;
	private Boolean cssGpsCountIsNotNull;
	
	private Short cssGpsCountStart;
	
	private Short cssGpsCountEnd;
	
	private Short cssGpsCountLess;
	
	private Short cssGpsCountGreater;
	
	private BigDecimal cssDirEquals;
	private BigDecimal[] cssDirIn;
	private Boolean cssDirIsNull;
	private Boolean cssDirIsNotNull;
	
	private BigDecimal cssDirStart;
	
	private BigDecimal cssDirEnd;
	
	private BigDecimal cssDirLess;
	
	private BigDecimal cssDirGreater;
	
	private Short cssCircularEquals;
	private Short[] cssCircularIn;
	private Boolean cssCircularIsNull;
	private Boolean cssCircularIsNotNull;
	
	private Short cssCircularStart;
	
	private Short cssCircularEnd;
	
	private Short cssCircularLess;
	
	private Short cssCircularGreater;
	
	private Short cssPtcEquals;
	private Short[] cssPtcIn;
	private Boolean cssPtcIsNull;
	private Boolean cssPtcIsNotNull;
	
	private Short cssPtcStart;
	
	private Short cssPtcEnd;
	
	private Short cssPtcLess;
	
	private Short cssPtcGreater;
	
	private Short cssCompresEquals;
	private Short[] cssCompresIn;
	private Boolean cssCompresIsNull;
	private Boolean cssCompresIsNotNull;
	
	private Short cssCompresStart;
	
	private Short cssCompresEnd;
	
	private Short cssCompresLess;
	
	private Short cssCompresGreater;
	
	private Short cssFanEquals;
	private Short[] cssFanIn;
	private Boolean cssFanIsNull;
	private Boolean cssFanIsNotNull;
	
	private Short cssFanStart;
	
	private Short cssFanEnd;
	
	private Short cssFanLess;
	
	private Short cssFanGreater;
	
	private Short cssSavingEquals;
	private Short[] cssSavingIn;
	private Boolean cssSavingIsNull;
	private Boolean cssSavingIsNotNull;
	
	private Short cssSavingStart;
	
	private Short cssSavingEnd;
	
	private Short cssSavingLess;
	
	private Short cssSavingGreater;
	private String cssDoorLike;
	
	private String cssDoorEquals;
	private String[] cssDoorIn;
	private Boolean cssDoorIsNull;
	private Boolean cssDoorIsNotNull;
	
	private String cssDoorStart;
	
	private String cssDoorEnd;
	
	private String cssDoorLess;
	
	private String cssDoorGreater;
	
	private Short cssEngineEquals;
	private Short[] cssEngineIn;
	private Boolean cssEngineIsNull;
	private Boolean cssEngineIsNotNull;
	
	private Short cssEngineStart;
	
	private Short cssEngineEnd;
	
	private Short cssEngineLess;
	
	private Short cssEngineGreater;
	
	private Short cssKeyEquals;
	private Short[] cssKeyIn;
	private Boolean cssKeyIsNull;
	private Boolean cssKeyIsNotNull;
	
	private Short cssKeyStart;
	
	private Short cssKeyEnd;
	
	private Short cssKeyLess;
	
	private Short cssKeyGreater;
	
	private Short cssGearEquals;
	private Short[] cssGearIn;
	private Boolean cssGearIsNull;
	private Boolean cssGearIsNotNull;
	
	private Short cssGearStart;
	
	private Short cssGearEnd;
	
	private Short cssGearLess;
	
	private Short cssGearGreater;
	
	private Integer cssLightEquals;
	private Integer[] cssLightIn;
	private Boolean cssLightIsNull;
	private Boolean cssLightIsNotNull;
	
	private Integer cssLightStart;
	
	private Integer cssLightEnd;
	
	private Integer cssLightLess;
	
	private Integer cssLightGreater;
	
	private Integer cssLockEquals;
	private Integer[] cssLockIn;
	private Boolean cssLockIsNull;
	private Boolean cssLockIsNotNull;
	
	private Integer cssLockStart;
	
	private Integer cssLockEnd;
	
	private Integer cssLockLess;
	
	private Integer cssLockGreater;
	
	private Short cssNetTypeEquals;
	private Short[] cssNetTypeIn;
	private Boolean cssNetTypeIsNull;
	private Boolean cssNetTypeIsNotNull;
	
	private Short cssNetTypeStart;
	
	private Short cssNetTypeEnd;
	
	private Short cssNetTypeLess;
	
	private Short cssNetTypeGreater;
	
	private Integer cssBaseLacEquals;
	private Integer[] cssBaseLacIn;
	private Boolean cssBaseLacIsNull;
	private Boolean cssBaseLacIsNotNull;
	
	private Integer cssBaseLacStart;
	
	private Integer cssBaseLacEnd;
	
	private Integer cssBaseLacLess;
	
	private Integer cssBaseLacGreater;
	
	private Integer cssBaseCiEquals;
	private Integer[] cssBaseCiIn;
	private Boolean cssBaseCiIsNull;
	private Boolean cssBaseCiIsNotNull;
	
	private Integer cssBaseCiStart;
	
	private Integer cssBaseCiEnd;
	
	private Integer cssBaseCiLess;
	
	private Integer cssBaseCiGreater;
	
	private Long cssOrderEquals;
	private Long[] cssOrderIn;
	private Boolean cssOrderIsNull;
	private Boolean cssOrderIsNotNull;
	
	private Long cssOrderStart;
	
	private Long cssOrderEnd;
	
	private Long cssOrderLess;
	
	private Long cssOrderGreater;
	private String cssMoDataLike;
	
	private String cssMoDataEquals;
	private String[] cssMoDataIn;
	private Boolean cssMoDataIsNull;
	private Boolean cssMoDataIsNotNull;
	
	private String cssMoDataStart;
	
	private String cssMoDataEnd;
	
	private String cssMoDataLess;
	
	private String cssMoDataGreater;
	private String cssTeNoLike;
	
	private String cssTeNoEquals;
	private String[] cssTeNoIn;
	private Boolean cssTeNoIsNull;
	private Boolean cssTeNoIsNotNull;
	
	private String cssTeNoStart;
	
	private String cssTeNoEnd;
	
	private String cssTeNoLess;
	
	private String cssTeNoGreater;
	
	private Integer cssAutopilotEquals;
	private Integer[] cssAutopilotIn;
	private Boolean cssAutopilotIsNull;
	private Boolean cssAutopilotIsNotNull;
	
	private Integer cssAutopilotStart;
	
	private Integer cssAutopilotEnd;
	
	private Integer cssAutopilotLess;
	
	private Integer cssAutopilotGreater;
	
	private Integer cssHandbrakeEquals;
	private Integer[] cssHandbrakeIn;
	private Boolean cssHandbrakeIsNull;
	private Boolean cssHandbrakeIsNotNull;
	
	private Integer cssHandbrakeStart;
	
	private Integer cssHandbrakeEnd;
	
	private Integer cssHandbrakeLess;
	
	private Integer cssHandbrakeGreater;
	private String sidx;
	private String sord;

	public CsStateQuery setCssIdEquals(Integer cssIdEquals){
		this.cssIdEquals = cssIdEquals;
		return this;
	}
	public Integer getCssIdEquals(){
		return this.cssIdEquals;
	}
	public CsStateQuery setCssIdIn(Integer[] cssIdIn){
		this.cssIdIn = cssIdIn;
		return this;
	}
	public Integer[] getCssIdIn(){
		return this.cssIdIn;
	}
	public CsStateQuery setCssIdIsNull(Boolean cssIdIsNull){
		this.cssIdIsNull = cssIdIsNull;
		return this;
	}
	public Boolean getCssIdIsNull(){
		return this.cssIdIsNull;
	}
	public CsStateQuery setCssIdIsNotNull(Boolean cssIdIsNotNull){
		this.cssIdIsNotNull = cssIdIsNotNull;
		return this;
	}
	public Boolean getCssIdIsNotNull(){
		return this.cssIdIsNotNull;
	}
	public CsStateQuery setCssIdStart(Integer cssIdStart){
		this.cssIdStart = cssIdStart;
		return this;
	}
	public Integer getCssIdStart(){
		return this.cssIdStart;
	}
	public CsStateQuery setCssIdEnd(Integer cssIdEnd){
		this.cssIdEnd = cssIdEnd;
		return this;
	}
	public Integer getCssIdEnd(){
		return this.cssIdEnd;
	}
	public CsStateQuery setCssIdLess(Integer cssIdLess){
		this.cssIdLess = cssIdLess;
		return this;
	}
	public Integer getCssIdLess(){
		return this.cssIdLess;
	}
	public CsStateQuery setCssIdGreater(Integer cssIdGreater){
		this.cssIdGreater = cssIdGreater;
		return this;
	}
	public Integer getCssIdGreater(){
		return this.cssIdGreater;
	}
	public CsStateQuery setCssAccessEquals(Short cssAccessEquals){
		this.cssAccessEquals = cssAccessEquals;
		return this;
	}
	public Short getCssAccessEquals(){
		return this.cssAccessEquals;
	}
	public CsStateQuery setCssAccessIn(Short[] cssAccessIn){
		this.cssAccessIn = cssAccessIn;
		return this;
	}
	public Short[] getCssAccessIn(){
		return this.cssAccessIn;
	}
	public CsStateQuery setCssAccessIsNull(Boolean cssAccessIsNull){
		this.cssAccessIsNull = cssAccessIsNull;
		return this;
	}
	public Boolean getCssAccessIsNull(){
		return this.cssAccessIsNull;
	}
	public CsStateQuery setCssAccessIsNotNull(Boolean cssAccessIsNotNull){
		this.cssAccessIsNotNull = cssAccessIsNotNull;
		return this;
	}
	public Boolean getCssAccessIsNotNull(){
		return this.cssAccessIsNotNull;
	}
	public CsStateQuery setCssAccessStart(Short cssAccessStart){
		this.cssAccessStart = cssAccessStart;
		return this;
	}
	public Short getCssAccessStart(){
		return this.cssAccessStart;
	}
	public CsStateQuery setCssAccessEnd(Short cssAccessEnd){
		this.cssAccessEnd = cssAccessEnd;
		return this;
	}
	public Short getCssAccessEnd(){
		return this.cssAccessEnd;
	}
	public CsStateQuery setCssAccessLess(Short cssAccessLess){
		this.cssAccessLess = cssAccessLess;
		return this;
	}
	public Short getCssAccessLess(){
		return this.cssAccessLess;
	}
	public CsStateQuery setCssAccessGreater(Short cssAccessGreater){
		this.cssAccessGreater = cssAccessGreater;
		return this;
	}
	public Short getCssAccessGreater(){
		return this.cssAccessGreater;
	}
	public CsStateQuery setCssHostEquals(Short cssHostEquals){
		this.cssHostEquals = cssHostEquals;
		return this;
	}
	public Short getCssHostEquals(){
		return this.cssHostEquals;
	}
	public CsStateQuery setCssHostIn(Short[] cssHostIn){
		this.cssHostIn = cssHostIn;
		return this;
	}
	public Short[] getCssHostIn(){
		return this.cssHostIn;
	}
	public CsStateQuery setCssHostIsNull(Boolean cssHostIsNull){
		this.cssHostIsNull = cssHostIsNull;
		return this;
	}
	public Boolean getCssHostIsNull(){
		return this.cssHostIsNull;
	}
	public CsStateQuery setCssHostIsNotNull(Boolean cssHostIsNotNull){
		this.cssHostIsNotNull = cssHostIsNotNull;
		return this;
	}
	public Boolean getCssHostIsNotNull(){
		return this.cssHostIsNotNull;
	}
	public CsStateQuery setCssHostStart(Short cssHostStart){
		this.cssHostStart = cssHostStart;
		return this;
	}
	public Short getCssHostStart(){
		return this.cssHostStart;
	}
	public CsStateQuery setCssHostEnd(Short cssHostEnd){
		this.cssHostEnd = cssHostEnd;
		return this;
	}
	public Short getCssHostEnd(){
		return this.cssHostEnd;
	}
	public CsStateQuery setCssHostLess(Short cssHostLess){
		this.cssHostLess = cssHostLess;
		return this;
	}
	public Short getCssHostLess(){
		return this.cssHostLess;
	}
	public CsStateQuery setCssHostGreater(Short cssHostGreater){
		this.cssHostGreater = cssHostGreater;
		return this;
	}
	public Short getCssHostGreater(){
		return this.cssHostGreater;
	}
	public CsStateQuery setCssNumberLike(String cssNumberLike){
		this.cssNumberLike = cssNumberLike;
		return this;
	}
	public String getCssNumberLike(){
		return this.cssNumberLike;
	}
	public CsStateQuery setCssNumberEquals(String cssNumberEquals){
		this.cssNumberEquals = cssNumberEquals;
		return this;
	}
	public String getCssNumberEquals(){
		return this.cssNumberEquals;
	}
	public CsStateQuery setCssNumberIn(String[] cssNumberIn){
		this.cssNumberIn = cssNumberIn;
		return this;
	}
	public String[] getCssNumberIn(){
		return this.cssNumberIn;
	}
	public CsStateQuery setCssNumberIsNull(Boolean cssNumberIsNull){
		this.cssNumberIsNull = cssNumberIsNull;
		return this;
	}
	public Boolean getCssNumberIsNull(){
		return this.cssNumberIsNull;
	}
	public CsStateQuery setCssNumberIsNotNull(Boolean cssNumberIsNotNull){
		this.cssNumberIsNotNull = cssNumberIsNotNull;
		return this;
	}
	public Boolean getCssNumberIsNotNull(){
		return this.cssNumberIsNotNull;
	}
	public CsStateQuery setCssNumberStart(String cssNumberStart){
		this.cssNumberStart = cssNumberStart;
		return this;
	}
	public String getCssNumberStart(){
		return this.cssNumberStart;
	}
	public CsStateQuery setCssNumberEnd(String cssNumberEnd){
		this.cssNumberEnd = cssNumberEnd;
		return this;
	}
	public String getCssNumberEnd(){
		return this.cssNumberEnd;
	}
	public CsStateQuery setCssNumberLess(String cssNumberLess){
		this.cssNumberLess = cssNumberLess;
		return this;
	}
	public String getCssNumberLess(){
		return this.cssNumberLess;
	}
	public CsStateQuery setCssNumberGreater(String cssNumberGreater){
		this.cssNumberGreater = cssNumberGreater;
		return this;
	}
	public String getCssNumberGreater(){
		return this.cssNumberGreater;
	}
	public CsStateQuery setCssCarEquals(Integer cssCarEquals){
		this.cssCarEquals = cssCarEquals;
		return this;
	}
	public Integer getCssCarEquals(){
		return this.cssCarEquals;
	}
	public CsStateQuery setCssCarIn(Integer[] cssCarIn){
		this.cssCarIn = cssCarIn;
		return this;
	}
	public Integer[] getCssCarIn(){
		return this.cssCarIn;
	}
	public CsStateQuery setCssCarIsNull(Boolean cssCarIsNull){
		this.cssCarIsNull = cssCarIsNull;
		return this;
	}
	public Boolean getCssCarIsNull(){
		return this.cssCarIsNull;
	}
	public CsStateQuery setCssCarIsNotNull(Boolean cssCarIsNotNull){
		this.cssCarIsNotNull = cssCarIsNotNull;
		return this;
	}
	public Boolean getCssCarIsNotNull(){
		return this.cssCarIsNotNull;
	}
	public CsStateQuery setCssCarStart(Integer cssCarStart){
		this.cssCarStart = cssCarStart;
		return this;
	}
	public Integer getCssCarStart(){
		return this.cssCarStart;
	}
	public CsStateQuery setCssCarEnd(Integer cssCarEnd){
		this.cssCarEnd = cssCarEnd;
		return this;
	}
	public Integer getCssCarEnd(){
		return this.cssCarEnd;
	}
	public CsStateQuery setCssCarLess(Integer cssCarLess){
		this.cssCarLess = cssCarLess;
		return this;
	}
	public Integer getCssCarLess(){
		return this.cssCarLess;
	}
	public CsStateQuery setCssCarGreater(Integer cssCarGreater){
		this.cssCarGreater = cssCarGreater;
		return this;
	}
	public Integer getCssCarGreater(){
		return this.cssCarGreater;
	}
	public CsStateQuery setCssAddTimeEquals(Date cssAddTimeEquals){
		this.cssAddTimeEquals = cssAddTimeEquals;
		return this;
	}
	public Date getCssAddTimeEquals(){
		return this.cssAddTimeEquals;
	}
	public CsStateQuery setCssAddTimeIn(Date[] cssAddTimeIn){
		this.cssAddTimeIn = cssAddTimeIn;
		return this;
	}
	public Date[] getCssAddTimeIn(){
		return this.cssAddTimeIn;
	}
	public CsStateQuery setCssAddTimeIsNull(Boolean cssAddTimeIsNull){
		this.cssAddTimeIsNull = cssAddTimeIsNull;
		return this;
	}
	public Boolean getCssAddTimeIsNull(){
		return this.cssAddTimeIsNull;
	}
	public CsStateQuery setCssAddTimeIsNotNull(Boolean cssAddTimeIsNotNull){
		this.cssAddTimeIsNotNull = cssAddTimeIsNotNull;
		return this;
	}
	public Boolean getCssAddTimeIsNotNull(){
		return this.cssAddTimeIsNotNull;
	}
	public CsStateQuery setCssAddTimeStart(Date cssAddTimeStart){
		this.cssAddTimeStart = cssAddTimeStart;
		return this;
	}
	public Date getCssAddTimeStart(){
		return this.cssAddTimeStart;
	}
	public CsStateQuery setCssAddTimeEnd(Date cssAddTimeEnd){
		this.cssAddTimeEnd = cssAddTimeEnd;
		return this;
	}
	public Date getCssAddTimeEnd(){
		return this.cssAddTimeEnd;
	}
	public CsStateQuery setCssAddTimeLess(Date cssAddTimeLess){
		this.cssAddTimeLess = cssAddTimeLess;
		return this;
	}
	public Date getCssAddTimeLess(){
		return this.cssAddTimeLess;
	}
	public CsStateQuery setCssAddTimeGreater(Date cssAddTimeGreater){
		this.cssAddTimeGreater = cssAddTimeGreater;
		return this;
	}
	public Date getCssAddTimeGreater(){
		return this.cssAddTimeGreater;
	}
	public CsStateQuery setCssCurrentTimeEquals(Date cssCurrentTimeEquals){
		this.cssCurrentTimeEquals = cssCurrentTimeEquals;
		return this;
	}
	public Date getCssCurrentTimeEquals(){
		return this.cssCurrentTimeEquals;
	}
	public CsStateQuery setCssCurrentTimeIn(Date[] cssCurrentTimeIn){
		this.cssCurrentTimeIn = cssCurrentTimeIn;
		return this;
	}
	public Date[] getCssCurrentTimeIn(){
		return this.cssCurrentTimeIn;
	}
	public CsStateQuery setCssCurrentTimeIsNull(Boolean cssCurrentTimeIsNull){
		this.cssCurrentTimeIsNull = cssCurrentTimeIsNull;
		return this;
	}
	public Boolean getCssCurrentTimeIsNull(){
		return this.cssCurrentTimeIsNull;
	}
	public CsStateQuery setCssCurrentTimeIsNotNull(Boolean cssCurrentTimeIsNotNull){
		this.cssCurrentTimeIsNotNull = cssCurrentTimeIsNotNull;
		return this;
	}
	public Boolean getCssCurrentTimeIsNotNull(){
		return this.cssCurrentTimeIsNotNull;
	}
	public CsStateQuery setCssCurrentTimeStart(Date cssCurrentTimeStart){
		this.cssCurrentTimeStart = cssCurrentTimeStart;
		return this;
	}
	public Date getCssCurrentTimeStart(){
		return this.cssCurrentTimeStart;
	}
	public CsStateQuery setCssCurrentTimeEnd(Date cssCurrentTimeEnd){
		this.cssCurrentTimeEnd = cssCurrentTimeEnd;
		return this;
	}
	public Date getCssCurrentTimeEnd(){
		return this.cssCurrentTimeEnd;
	}
	public CsStateQuery setCssCurrentTimeLess(Date cssCurrentTimeLess){
		this.cssCurrentTimeLess = cssCurrentTimeLess;
		return this;
	}
	public Date getCssCurrentTimeLess(){
		return this.cssCurrentTimeLess;
	}
	public CsStateQuery setCssCurrentTimeGreater(Date cssCurrentTimeGreater){
		this.cssCurrentTimeGreater = cssCurrentTimeGreater;
		return this;
	}
	public Date getCssCurrentTimeGreater(){
		return this.cssCurrentTimeGreater;
	}
	public CsStateQuery setCssRentedLike(String cssRentedLike){
		this.cssRentedLike = cssRentedLike;
		return this;
	}
	public String getCssRentedLike(){
		return this.cssRentedLike;
	}
	public CsStateQuery setCssRentedEquals(String cssRentedEquals){
		this.cssRentedEquals = cssRentedEquals;
		return this;
	}
	public String getCssRentedEquals(){
		return this.cssRentedEquals;
	}
	public CsStateQuery setCssRentedIn(String[] cssRentedIn){
		this.cssRentedIn = cssRentedIn;
		return this;
	}
	public String[] getCssRentedIn(){
		return this.cssRentedIn;
	}
	public CsStateQuery setCssRentedIsNull(Boolean cssRentedIsNull){
		this.cssRentedIsNull = cssRentedIsNull;
		return this;
	}
	public Boolean getCssRentedIsNull(){
		return this.cssRentedIsNull;
	}
	public CsStateQuery setCssRentedIsNotNull(Boolean cssRentedIsNotNull){
		this.cssRentedIsNotNull = cssRentedIsNotNull;
		return this;
	}
	public Boolean getCssRentedIsNotNull(){
		return this.cssRentedIsNotNull;
	}
	public CsStateQuery setCssRentedStart(String cssRentedStart){
		this.cssRentedStart = cssRentedStart;
		return this;
	}
	public String getCssRentedStart(){
		return this.cssRentedStart;
	}
	public CsStateQuery setCssRentedEnd(String cssRentedEnd){
		this.cssRentedEnd = cssRentedEnd;
		return this;
	}
	public String getCssRentedEnd(){
		return this.cssRentedEnd;
	}
	public CsStateQuery setCssRentedLess(String cssRentedLess){
		this.cssRentedLess = cssRentedLess;
		return this;
	}
	public String getCssRentedLess(){
		return this.cssRentedLess;
	}
	public CsStateQuery setCssRentedGreater(String cssRentedGreater){
		this.cssRentedGreater = cssRentedGreater;
		return this;
	}
	public String getCssRentedGreater(){
		return this.cssRentedGreater;
	}
	public CsStateQuery setCssWarnEquals(Integer cssWarnEquals){
		this.cssWarnEquals = cssWarnEquals;
		return this;
	}
	public Integer getCssWarnEquals(){
		return this.cssWarnEquals;
	}
	public CsStateQuery setCssWarnIn(Integer[] cssWarnIn){
		this.cssWarnIn = cssWarnIn;
		return this;
	}
	public Integer[] getCssWarnIn(){
		return this.cssWarnIn;
	}
	public CsStateQuery setCssWarnIsNull(Boolean cssWarnIsNull){
		this.cssWarnIsNull = cssWarnIsNull;
		return this;
	}
	public Boolean getCssWarnIsNull(){
		return this.cssWarnIsNull;
	}
	public CsStateQuery setCssWarnIsNotNull(Boolean cssWarnIsNotNull){
		this.cssWarnIsNotNull = cssWarnIsNotNull;
		return this;
	}
	public Boolean getCssWarnIsNotNull(){
		return this.cssWarnIsNotNull;
	}
	public CsStateQuery setCssWarnStart(Integer cssWarnStart){
		this.cssWarnStart = cssWarnStart;
		return this;
	}
	public Integer getCssWarnStart(){
		return this.cssWarnStart;
	}
	public CsStateQuery setCssWarnEnd(Integer cssWarnEnd){
		this.cssWarnEnd = cssWarnEnd;
		return this;
	}
	public Integer getCssWarnEnd(){
		return this.cssWarnEnd;
	}
	public CsStateQuery setCssWarnLess(Integer cssWarnLess){
		this.cssWarnLess = cssWarnLess;
		return this;
	}
	public Integer getCssWarnLess(){
		return this.cssWarnLess;
	}
	public CsStateQuery setCssWarnGreater(Integer cssWarnGreater){
		this.cssWarnGreater = cssWarnGreater;
		return this;
	}
	public Integer getCssWarnGreater(){
		return this.cssWarnGreater;
	}
	public CsStateQuery setCssRfidLike(String cssRfidLike){
		this.cssRfidLike = cssRfidLike;
		return this;
	}
	public String getCssRfidLike(){
		return this.cssRfidLike;
	}
	public CsStateQuery setCssRfidEquals(String cssRfidEquals){
		this.cssRfidEquals = cssRfidEquals;
		return this;
	}
	public String getCssRfidEquals(){
		return this.cssRfidEquals;
	}
	public CsStateQuery setCssRfidIn(String[] cssRfidIn){
		this.cssRfidIn = cssRfidIn;
		return this;
	}
	public String[] getCssRfidIn(){
		return this.cssRfidIn;
	}
	public CsStateQuery setCssRfidIsNull(Boolean cssRfidIsNull){
		this.cssRfidIsNull = cssRfidIsNull;
		return this;
	}
	public Boolean getCssRfidIsNull(){
		return this.cssRfidIsNull;
	}
	public CsStateQuery setCssRfidIsNotNull(Boolean cssRfidIsNotNull){
		this.cssRfidIsNotNull = cssRfidIsNotNull;
		return this;
	}
	public Boolean getCssRfidIsNotNull(){
		return this.cssRfidIsNotNull;
	}
	public CsStateQuery setCssRfidStart(String cssRfidStart){
		this.cssRfidStart = cssRfidStart;
		return this;
	}
	public String getCssRfidStart(){
		return this.cssRfidStart;
	}
	public CsStateQuery setCssRfidEnd(String cssRfidEnd){
		this.cssRfidEnd = cssRfidEnd;
		return this;
	}
	public String getCssRfidEnd(){
		return this.cssRfidEnd;
	}
	public CsStateQuery setCssRfidLess(String cssRfidLess){
		this.cssRfidLess = cssRfidLess;
		return this;
	}
	public String getCssRfidLess(){
		return this.cssRfidLess;
	}
	public CsStateQuery setCssRfidGreater(String cssRfidGreater){
		this.cssRfidGreater = cssRfidGreater;
		return this;
	}
	public String getCssRfidGreater(){
		return this.cssRfidGreater;
	}
	public CsStateQuery setCssRfidDteLike(String cssRfidDteLike){
		this.cssRfidDteLike = cssRfidDteLike;
		return this;
	}
	public String getCssRfidDteLike(){
		return this.cssRfidDteLike;
	}
	public CsStateQuery setCssRfidDteEquals(String cssRfidDteEquals){
		this.cssRfidDteEquals = cssRfidDteEquals;
		return this;
	}
	public String getCssRfidDteEquals(){
		return this.cssRfidDteEquals;
	}
	public CsStateQuery setCssRfidDteIn(String[] cssRfidDteIn){
		this.cssRfidDteIn = cssRfidDteIn;
		return this;
	}
	public String[] getCssRfidDteIn(){
		return this.cssRfidDteIn;
	}
	public CsStateQuery setCssRfidDteIsNull(Boolean cssRfidDteIsNull){
		this.cssRfidDteIsNull = cssRfidDteIsNull;
		return this;
	}
	public Boolean getCssRfidDteIsNull(){
		return this.cssRfidDteIsNull;
	}
	public CsStateQuery setCssRfidDteIsNotNull(Boolean cssRfidDteIsNotNull){
		this.cssRfidDteIsNotNull = cssRfidDteIsNotNull;
		return this;
	}
	public Boolean getCssRfidDteIsNotNull(){
		return this.cssRfidDteIsNotNull;
	}
	public CsStateQuery setCssRfidDteStart(String cssRfidDteStart){
		this.cssRfidDteStart = cssRfidDteStart;
		return this;
	}
	public String getCssRfidDteStart(){
		return this.cssRfidDteStart;
	}
	public CsStateQuery setCssRfidDteEnd(String cssRfidDteEnd){
		this.cssRfidDteEnd = cssRfidDteEnd;
		return this;
	}
	public String getCssRfidDteEnd(){
		return this.cssRfidDteEnd;
	}
	public CsStateQuery setCssRfidDteLess(String cssRfidDteLess){
		this.cssRfidDteLess = cssRfidDteLess;
		return this;
	}
	public String getCssRfidDteLess(){
		return this.cssRfidDteLess;
	}
	public CsStateQuery setCssRfidDteGreater(String cssRfidDteGreater){
		this.cssRfidDteGreater = cssRfidDteGreater;
		return this;
	}
	public String getCssRfidDteGreater(){
		return this.cssRfidDteGreater;
	}
	public CsStateQuery setCssObdMileEquals(BigDecimal cssObdMileEquals){
		this.cssObdMileEquals = cssObdMileEquals;
		return this;
	}
	public BigDecimal getCssObdMileEquals(){
		return this.cssObdMileEquals;
	}
	public CsStateQuery setCssObdMileIn(BigDecimal[] cssObdMileIn){
		this.cssObdMileIn = cssObdMileIn;
		return this;
	}
	public BigDecimal[] getCssObdMileIn(){
		return this.cssObdMileIn;
	}
	public CsStateQuery setCssObdMileIsNull(Boolean cssObdMileIsNull){
		this.cssObdMileIsNull = cssObdMileIsNull;
		return this;
	}
	public Boolean getCssObdMileIsNull(){
		return this.cssObdMileIsNull;
	}
	public CsStateQuery setCssObdMileIsNotNull(Boolean cssObdMileIsNotNull){
		this.cssObdMileIsNotNull = cssObdMileIsNotNull;
		return this;
	}
	public Boolean getCssObdMileIsNotNull(){
		return this.cssObdMileIsNotNull;
	}
	public CsStateQuery setCssObdMileStart(BigDecimal cssObdMileStart){
		this.cssObdMileStart = cssObdMileStart;
		return this;
	}
	public BigDecimal getCssObdMileStart(){
		return this.cssObdMileStart;
	}
	public CsStateQuery setCssObdMileEnd(BigDecimal cssObdMileEnd){
		this.cssObdMileEnd = cssObdMileEnd;
		return this;
	}
	public BigDecimal getCssObdMileEnd(){
		return this.cssObdMileEnd;
	}
	public CsStateQuery setCssObdMileLess(BigDecimal cssObdMileLess){
		this.cssObdMileLess = cssObdMileLess;
		return this;
	}
	public BigDecimal getCssObdMileLess(){
		return this.cssObdMileLess;
	}
	public CsStateQuery setCssObdMileGreater(BigDecimal cssObdMileGreater){
		this.cssObdMileGreater = cssObdMileGreater;
		return this;
	}
	public BigDecimal getCssObdMileGreater(){
		return this.cssObdMileGreater;
	}
	public CsStateQuery setCssEngineTEquals(BigDecimal cssEngineTEquals){
		this.cssEngineTEquals = cssEngineTEquals;
		return this;
	}
	public BigDecimal getCssEngineTEquals(){
		return this.cssEngineTEquals;
	}
	public CsStateQuery setCssEngineTIn(BigDecimal[] cssEngineTIn){
		this.cssEngineTIn = cssEngineTIn;
		return this;
	}
	public BigDecimal[] getCssEngineTIn(){
		return this.cssEngineTIn;
	}
	public CsStateQuery setCssEngineTIsNull(Boolean cssEngineTIsNull){
		this.cssEngineTIsNull = cssEngineTIsNull;
		return this;
	}
	public Boolean getCssEngineTIsNull(){
		return this.cssEngineTIsNull;
	}
	public CsStateQuery setCssEngineTIsNotNull(Boolean cssEngineTIsNotNull){
		this.cssEngineTIsNotNull = cssEngineTIsNotNull;
		return this;
	}
	public Boolean getCssEngineTIsNotNull(){
		return this.cssEngineTIsNotNull;
	}
	public CsStateQuery setCssEngineTStart(BigDecimal cssEngineTStart){
		this.cssEngineTStart = cssEngineTStart;
		return this;
	}
	public BigDecimal getCssEngineTStart(){
		return this.cssEngineTStart;
	}
	public CsStateQuery setCssEngineTEnd(BigDecimal cssEngineTEnd){
		this.cssEngineTEnd = cssEngineTEnd;
		return this;
	}
	public BigDecimal getCssEngineTEnd(){
		return this.cssEngineTEnd;
	}
	public CsStateQuery setCssEngineTLess(BigDecimal cssEngineTLess){
		this.cssEngineTLess = cssEngineTLess;
		return this;
	}
	public BigDecimal getCssEngineTLess(){
		return this.cssEngineTLess;
	}
	public CsStateQuery setCssEngineTGreater(BigDecimal cssEngineTGreater){
		this.cssEngineTGreater = cssEngineTGreater;
		return this;
	}
	public BigDecimal getCssEngineTGreater(){
		return this.cssEngineTGreater;
	}
	public CsStateQuery setCssMileageEquals(BigDecimal cssMileageEquals){
		this.cssMileageEquals = cssMileageEquals;
		return this;
	}
	public BigDecimal getCssMileageEquals(){
		return this.cssMileageEquals;
	}
	public CsStateQuery setCssMileageIn(BigDecimal[] cssMileageIn){
		this.cssMileageIn = cssMileageIn;
		return this;
	}
	public BigDecimal[] getCssMileageIn(){
		return this.cssMileageIn;
	}
	public CsStateQuery setCssMileageIsNull(Boolean cssMileageIsNull){
		this.cssMileageIsNull = cssMileageIsNull;
		return this;
	}
	public Boolean getCssMileageIsNull(){
		return this.cssMileageIsNull;
	}
	public CsStateQuery setCssMileageIsNotNull(Boolean cssMileageIsNotNull){
		this.cssMileageIsNotNull = cssMileageIsNotNull;
		return this;
	}
	public Boolean getCssMileageIsNotNull(){
		return this.cssMileageIsNotNull;
	}
	public CsStateQuery setCssMileageStart(BigDecimal cssMileageStart){
		this.cssMileageStart = cssMileageStart;
		return this;
	}
	public BigDecimal getCssMileageStart(){
		return this.cssMileageStart;
	}
	public CsStateQuery setCssMileageEnd(BigDecimal cssMileageEnd){
		this.cssMileageEnd = cssMileageEnd;
		return this;
	}
	public BigDecimal getCssMileageEnd(){
		return this.cssMileageEnd;
	}
	public CsStateQuery setCssMileageLess(BigDecimal cssMileageLess){
		this.cssMileageLess = cssMileageLess;
		return this;
	}
	public BigDecimal getCssMileageLess(){
		return this.cssMileageLess;
	}
	public CsStateQuery setCssMileageGreater(BigDecimal cssMileageGreater){
		this.cssMileageGreater = cssMileageGreater;
		return this;
	}
	public BigDecimal getCssMileageGreater(){
		return this.cssMileageGreater;
	}
	public CsStateQuery setCssSpeedEquals(BigDecimal cssSpeedEquals){
		this.cssSpeedEquals = cssSpeedEquals;
		return this;
	}
	public BigDecimal getCssSpeedEquals(){
		return this.cssSpeedEquals;
	}
	public CsStateQuery setCssSpeedIn(BigDecimal[] cssSpeedIn){
		this.cssSpeedIn = cssSpeedIn;
		return this;
	}
	public BigDecimal[] getCssSpeedIn(){
		return this.cssSpeedIn;
	}
	public CsStateQuery setCssSpeedIsNull(Boolean cssSpeedIsNull){
		this.cssSpeedIsNull = cssSpeedIsNull;
		return this;
	}
	public Boolean getCssSpeedIsNull(){
		return this.cssSpeedIsNull;
	}
	public CsStateQuery setCssSpeedIsNotNull(Boolean cssSpeedIsNotNull){
		this.cssSpeedIsNotNull = cssSpeedIsNotNull;
		return this;
	}
	public Boolean getCssSpeedIsNotNull(){
		return this.cssSpeedIsNotNull;
	}
	public CsStateQuery setCssSpeedStart(BigDecimal cssSpeedStart){
		this.cssSpeedStart = cssSpeedStart;
		return this;
	}
	public BigDecimal getCssSpeedStart(){
		return this.cssSpeedStart;
	}
	public CsStateQuery setCssSpeedEnd(BigDecimal cssSpeedEnd){
		this.cssSpeedEnd = cssSpeedEnd;
		return this;
	}
	public BigDecimal getCssSpeedEnd(){
		return this.cssSpeedEnd;
	}
	public CsStateQuery setCssSpeedLess(BigDecimal cssSpeedLess){
		this.cssSpeedLess = cssSpeedLess;
		return this;
	}
	public BigDecimal getCssSpeedLess(){
		return this.cssSpeedLess;
	}
	public CsStateQuery setCssSpeedGreater(BigDecimal cssSpeedGreater){
		this.cssSpeedGreater = cssSpeedGreater;
		return this;
	}
	public BigDecimal getCssSpeedGreater(){
		return this.cssSpeedGreater;
	}
	public CsStateQuery setCssMotorEquals(Integer cssMotorEquals){
		this.cssMotorEquals = cssMotorEquals;
		return this;
	}
	public Integer getCssMotorEquals(){
		return this.cssMotorEquals;
	}
	public CsStateQuery setCssMotorIn(Integer[] cssMotorIn){
		this.cssMotorIn = cssMotorIn;
		return this;
	}
	public Integer[] getCssMotorIn(){
		return this.cssMotorIn;
	}
	public CsStateQuery setCssMotorIsNull(Boolean cssMotorIsNull){
		this.cssMotorIsNull = cssMotorIsNull;
		return this;
	}
	public Boolean getCssMotorIsNull(){
		return this.cssMotorIsNull;
	}
	public CsStateQuery setCssMotorIsNotNull(Boolean cssMotorIsNotNull){
		this.cssMotorIsNotNull = cssMotorIsNotNull;
		return this;
	}
	public Boolean getCssMotorIsNotNull(){
		return this.cssMotorIsNotNull;
	}
	public CsStateQuery setCssMotorStart(Integer cssMotorStart){
		this.cssMotorStart = cssMotorStart;
		return this;
	}
	public Integer getCssMotorStart(){
		return this.cssMotorStart;
	}
	public CsStateQuery setCssMotorEnd(Integer cssMotorEnd){
		this.cssMotorEnd = cssMotorEnd;
		return this;
	}
	public Integer getCssMotorEnd(){
		return this.cssMotorEnd;
	}
	public CsStateQuery setCssMotorLess(Integer cssMotorLess){
		this.cssMotorLess = cssMotorLess;
		return this;
	}
	public Integer getCssMotorLess(){
		return this.cssMotorLess;
	}
	public CsStateQuery setCssMotorGreater(Integer cssMotorGreater){
		this.cssMotorGreater = cssMotorGreater;
		return this;
	}
	public Integer getCssMotorGreater(){
		return this.cssMotorGreater;
	}
	public CsStateQuery setCssOilEquals(BigDecimal cssOilEquals){
		this.cssOilEquals = cssOilEquals;
		return this;
	}
	public BigDecimal getCssOilEquals(){
		return this.cssOilEquals;
	}
	public CsStateQuery setCssOilIn(BigDecimal[] cssOilIn){
		this.cssOilIn = cssOilIn;
		return this;
	}
	public BigDecimal[] getCssOilIn(){
		return this.cssOilIn;
	}
	public CsStateQuery setCssOilIsNull(Boolean cssOilIsNull){
		this.cssOilIsNull = cssOilIsNull;
		return this;
	}
	public Boolean getCssOilIsNull(){
		return this.cssOilIsNull;
	}
	public CsStateQuery setCssOilIsNotNull(Boolean cssOilIsNotNull){
		this.cssOilIsNotNull = cssOilIsNotNull;
		return this;
	}
	public Boolean getCssOilIsNotNull(){
		return this.cssOilIsNotNull;
	}
	public CsStateQuery setCssOilStart(BigDecimal cssOilStart){
		this.cssOilStart = cssOilStart;
		return this;
	}
	public BigDecimal getCssOilStart(){
		return this.cssOilStart;
	}
	public CsStateQuery setCssOilEnd(BigDecimal cssOilEnd){
		this.cssOilEnd = cssOilEnd;
		return this;
	}
	public BigDecimal getCssOilEnd(){
		return this.cssOilEnd;
	}
	public CsStateQuery setCssOilLess(BigDecimal cssOilLess){
		this.cssOilLess = cssOilLess;
		return this;
	}
	public BigDecimal getCssOilLess(){
		return this.cssOilLess;
	}
	public CsStateQuery setCssOilGreater(BigDecimal cssOilGreater){
		this.cssOilGreater = cssOilGreater;
		return this;
	}
	public BigDecimal getCssOilGreater(){
		return this.cssOilGreater;
	}
	public CsStateQuery setCssPowerEquals(Integer cssPowerEquals){
		this.cssPowerEquals = cssPowerEquals;
		return this;
	}
	public Integer getCssPowerEquals(){
		return this.cssPowerEquals;
	}
	public CsStateQuery setCssPowerIn(Integer[] cssPowerIn){
		this.cssPowerIn = cssPowerIn;
		return this;
	}
	public Integer[] getCssPowerIn(){
		return this.cssPowerIn;
	}
	public CsStateQuery setCssPowerIsNull(Boolean cssPowerIsNull){
		this.cssPowerIsNull = cssPowerIsNull;
		return this;
	}
	public Boolean getCssPowerIsNull(){
		return this.cssPowerIsNull;
	}
	public CsStateQuery setCssPowerIsNotNull(Boolean cssPowerIsNotNull){
		this.cssPowerIsNotNull = cssPowerIsNotNull;
		return this;
	}
	public Boolean getCssPowerIsNotNull(){
		return this.cssPowerIsNotNull;
	}
	public CsStateQuery setCssPowerStart(Integer cssPowerStart){
		this.cssPowerStart = cssPowerStart;
		return this;
	}
	public Integer getCssPowerStart(){
		return this.cssPowerStart;
	}
	public CsStateQuery setCssPowerEnd(Integer cssPowerEnd){
		this.cssPowerEnd = cssPowerEnd;
		return this;
	}
	public Integer getCssPowerEnd(){
		return this.cssPowerEnd;
	}
	public CsStateQuery setCssPowerLess(Integer cssPowerLess){
		this.cssPowerLess = cssPowerLess;
		return this;
	}
	public Integer getCssPowerLess(){
		return this.cssPowerLess;
	}
	public CsStateQuery setCssPowerGreater(Integer cssPowerGreater){
		this.cssPowerGreater = cssPowerGreater;
		return this;
	}
	public Integer getCssPowerGreater(){
		return this.cssPowerGreater;
	}
	public CsStateQuery setCssEvBatteryEquals(Short cssEvBatteryEquals){
		this.cssEvBatteryEquals = cssEvBatteryEquals;
		return this;
	}
	public Short getCssEvBatteryEquals(){
		return this.cssEvBatteryEquals;
	}
	public CsStateQuery setCssEvBatteryIn(Short[] cssEvBatteryIn){
		this.cssEvBatteryIn = cssEvBatteryIn;
		return this;
	}
	public Short[] getCssEvBatteryIn(){
		return this.cssEvBatteryIn;
	}
	public CsStateQuery setCssEvBatteryIsNull(Boolean cssEvBatteryIsNull){
		this.cssEvBatteryIsNull = cssEvBatteryIsNull;
		return this;
	}
	public Boolean getCssEvBatteryIsNull(){
		return this.cssEvBatteryIsNull;
	}
	public CsStateQuery setCssEvBatteryIsNotNull(Boolean cssEvBatteryIsNotNull){
		this.cssEvBatteryIsNotNull = cssEvBatteryIsNotNull;
		return this;
	}
	public Boolean getCssEvBatteryIsNotNull(){
		return this.cssEvBatteryIsNotNull;
	}
	public CsStateQuery setCssEvBatteryStart(Short cssEvBatteryStart){
		this.cssEvBatteryStart = cssEvBatteryStart;
		return this;
	}
	public Short getCssEvBatteryStart(){
		return this.cssEvBatteryStart;
	}
	public CsStateQuery setCssEvBatteryEnd(Short cssEvBatteryEnd){
		this.cssEvBatteryEnd = cssEvBatteryEnd;
		return this;
	}
	public Short getCssEvBatteryEnd(){
		return this.cssEvBatteryEnd;
	}
	public CsStateQuery setCssEvBatteryLess(Short cssEvBatteryLess){
		this.cssEvBatteryLess = cssEvBatteryLess;
		return this;
	}
	public Short getCssEvBatteryLess(){
		return this.cssEvBatteryLess;
	}
	public CsStateQuery setCssEvBatteryGreater(Short cssEvBatteryGreater){
		this.cssEvBatteryGreater = cssEvBatteryGreater;
		return this;
	}
	public Short getCssEvBatteryGreater(){
		return this.cssEvBatteryGreater;
	}
	public CsStateQuery setCssChargingEquals(Short cssChargingEquals){
		this.cssChargingEquals = cssChargingEquals;
		return this;
	}
	public Short getCssChargingEquals(){
		return this.cssChargingEquals;
	}
	public CsStateQuery setCssChargingIn(Short[] cssChargingIn){
		this.cssChargingIn = cssChargingIn;
		return this;
	}
	public Short[] getCssChargingIn(){
		return this.cssChargingIn;
	}
	public CsStateQuery setCssChargingIsNull(Boolean cssChargingIsNull){
		this.cssChargingIsNull = cssChargingIsNull;
		return this;
	}
	public Boolean getCssChargingIsNull(){
		return this.cssChargingIsNull;
	}
	public CsStateQuery setCssChargingIsNotNull(Boolean cssChargingIsNotNull){
		this.cssChargingIsNotNull = cssChargingIsNotNull;
		return this;
	}
	public Boolean getCssChargingIsNotNull(){
		return this.cssChargingIsNotNull;
	}
	public CsStateQuery setCssChargingStart(Short cssChargingStart){
		this.cssChargingStart = cssChargingStart;
		return this;
	}
	public Short getCssChargingStart(){
		return this.cssChargingStart;
	}
	public CsStateQuery setCssChargingEnd(Short cssChargingEnd){
		this.cssChargingEnd = cssChargingEnd;
		return this;
	}
	public Short getCssChargingEnd(){
		return this.cssChargingEnd;
	}
	public CsStateQuery setCssChargingLess(Short cssChargingLess){
		this.cssChargingLess = cssChargingLess;
		return this;
	}
	public Short getCssChargingLess(){
		return this.cssChargingLess;
	}
	public CsStateQuery setCssChargingGreater(Short cssChargingGreater){
		this.cssChargingGreater = cssChargingGreater;
		return this;
	}
	public Short getCssChargingGreater(){
		return this.cssChargingGreater;
	}
	public CsStateQuery setCssFuelMileageEquals(BigDecimal cssFuelMileageEquals){
		this.cssFuelMileageEquals = cssFuelMileageEquals;
		return this;
	}
	public BigDecimal getCssFuelMileageEquals(){
		return this.cssFuelMileageEquals;
	}
	public CsStateQuery setCssFuelMileageIn(BigDecimal[] cssFuelMileageIn){
		this.cssFuelMileageIn = cssFuelMileageIn;
		return this;
	}
	public BigDecimal[] getCssFuelMileageIn(){
		return this.cssFuelMileageIn;
	}
	public CsStateQuery setCssFuelMileageIsNull(Boolean cssFuelMileageIsNull){
		this.cssFuelMileageIsNull = cssFuelMileageIsNull;
		return this;
	}
	public Boolean getCssFuelMileageIsNull(){
		return this.cssFuelMileageIsNull;
	}
	public CsStateQuery setCssFuelMileageIsNotNull(Boolean cssFuelMileageIsNotNull){
		this.cssFuelMileageIsNotNull = cssFuelMileageIsNotNull;
		return this;
	}
	public Boolean getCssFuelMileageIsNotNull(){
		return this.cssFuelMileageIsNotNull;
	}
	public CsStateQuery setCssFuelMileageStart(BigDecimal cssFuelMileageStart){
		this.cssFuelMileageStart = cssFuelMileageStart;
		return this;
	}
	public BigDecimal getCssFuelMileageStart(){
		return this.cssFuelMileageStart;
	}
	public CsStateQuery setCssFuelMileageEnd(BigDecimal cssFuelMileageEnd){
		this.cssFuelMileageEnd = cssFuelMileageEnd;
		return this;
	}
	public BigDecimal getCssFuelMileageEnd(){
		return this.cssFuelMileageEnd;
	}
	public CsStateQuery setCssFuelMileageLess(BigDecimal cssFuelMileageLess){
		this.cssFuelMileageLess = cssFuelMileageLess;
		return this;
	}
	public BigDecimal getCssFuelMileageLess(){
		return this.cssFuelMileageLess;
	}
	public CsStateQuery setCssFuelMileageGreater(BigDecimal cssFuelMileageGreater){
		this.cssFuelMileageGreater = cssFuelMileageGreater;
		return this;
	}
	public BigDecimal getCssFuelMileageGreater(){
		return this.cssFuelMileageGreater;
	}
	public CsStateQuery setCssElectricMileageEquals(BigDecimal cssElectricMileageEquals){
		this.cssElectricMileageEquals = cssElectricMileageEquals;
		return this;
	}
	public BigDecimal getCssElectricMileageEquals(){
		return this.cssElectricMileageEquals;
	}
	public CsStateQuery setCssElectricMileageIn(BigDecimal[] cssElectricMileageIn){
		this.cssElectricMileageIn = cssElectricMileageIn;
		return this;
	}
	public BigDecimal[] getCssElectricMileageIn(){
		return this.cssElectricMileageIn;
	}
	public CsStateQuery setCssElectricMileageIsNull(Boolean cssElectricMileageIsNull){
		this.cssElectricMileageIsNull = cssElectricMileageIsNull;
		return this;
	}
	public Boolean getCssElectricMileageIsNull(){
		return this.cssElectricMileageIsNull;
	}
	public CsStateQuery setCssElectricMileageIsNotNull(Boolean cssElectricMileageIsNotNull){
		this.cssElectricMileageIsNotNull = cssElectricMileageIsNotNull;
		return this;
	}
	public Boolean getCssElectricMileageIsNotNull(){
		return this.cssElectricMileageIsNotNull;
	}
	public CsStateQuery setCssElectricMileageStart(BigDecimal cssElectricMileageStart){
		this.cssElectricMileageStart = cssElectricMileageStart;
		return this;
	}
	public BigDecimal getCssElectricMileageStart(){
		return this.cssElectricMileageStart;
	}
	public CsStateQuery setCssElectricMileageEnd(BigDecimal cssElectricMileageEnd){
		this.cssElectricMileageEnd = cssElectricMileageEnd;
		return this;
	}
	public BigDecimal getCssElectricMileageEnd(){
		return this.cssElectricMileageEnd;
	}
	public CsStateQuery setCssElectricMileageLess(BigDecimal cssElectricMileageLess){
		this.cssElectricMileageLess = cssElectricMileageLess;
		return this;
	}
	public BigDecimal getCssElectricMileageLess(){
		return this.cssElectricMileageLess;
	}
	public CsStateQuery setCssElectricMileageGreater(BigDecimal cssElectricMileageGreater){
		this.cssElectricMileageGreater = cssElectricMileageGreater;
		return this;
	}
	public BigDecimal getCssElectricMileageGreater(){
		return this.cssElectricMileageGreater;
	}
	public CsStateQuery setCssEnduranceEquals(BigDecimal cssEnduranceEquals){
		this.cssEnduranceEquals = cssEnduranceEquals;
		return this;
	}
	public BigDecimal getCssEnduranceEquals(){
		return this.cssEnduranceEquals;
	}
	public CsStateQuery setCssEnduranceIn(BigDecimal[] cssEnduranceIn){
		this.cssEnduranceIn = cssEnduranceIn;
		return this;
	}
	public BigDecimal[] getCssEnduranceIn(){
		return this.cssEnduranceIn;
	}
	public CsStateQuery setCssEnduranceIsNull(Boolean cssEnduranceIsNull){
		this.cssEnduranceIsNull = cssEnduranceIsNull;
		return this;
	}
	public Boolean getCssEnduranceIsNull(){
		return this.cssEnduranceIsNull;
	}
	public CsStateQuery setCssEnduranceIsNotNull(Boolean cssEnduranceIsNotNull){
		this.cssEnduranceIsNotNull = cssEnduranceIsNotNull;
		return this;
	}
	public Boolean getCssEnduranceIsNotNull(){
		return this.cssEnduranceIsNotNull;
	}
	public CsStateQuery setCssEnduranceStart(BigDecimal cssEnduranceStart){
		this.cssEnduranceStart = cssEnduranceStart;
		return this;
	}
	public BigDecimal getCssEnduranceStart(){
		return this.cssEnduranceStart;
	}
	public CsStateQuery setCssEnduranceEnd(BigDecimal cssEnduranceEnd){
		this.cssEnduranceEnd = cssEnduranceEnd;
		return this;
	}
	public BigDecimal getCssEnduranceEnd(){
		return this.cssEnduranceEnd;
	}
	public CsStateQuery setCssEnduranceLess(BigDecimal cssEnduranceLess){
		this.cssEnduranceLess = cssEnduranceLess;
		return this;
	}
	public BigDecimal getCssEnduranceLess(){
		return this.cssEnduranceLess;
	}
	public CsStateQuery setCssEnduranceGreater(BigDecimal cssEnduranceGreater){
		this.cssEnduranceGreater = cssEnduranceGreater;
		return this;
	}
	public BigDecimal getCssEnduranceGreater(){
		return this.cssEnduranceGreater;
	}
	public CsStateQuery setCssTemperatureEquals(BigDecimal cssTemperatureEquals){
		this.cssTemperatureEquals = cssTemperatureEquals;
		return this;
	}
	public BigDecimal getCssTemperatureEquals(){
		return this.cssTemperatureEquals;
	}
	public CsStateQuery setCssTemperatureIn(BigDecimal[] cssTemperatureIn){
		this.cssTemperatureIn = cssTemperatureIn;
		return this;
	}
	public BigDecimal[] getCssTemperatureIn(){
		return this.cssTemperatureIn;
	}
	public CsStateQuery setCssTemperatureIsNull(Boolean cssTemperatureIsNull){
		this.cssTemperatureIsNull = cssTemperatureIsNull;
		return this;
	}
	public Boolean getCssTemperatureIsNull(){
		return this.cssTemperatureIsNull;
	}
	public CsStateQuery setCssTemperatureIsNotNull(Boolean cssTemperatureIsNotNull){
		this.cssTemperatureIsNotNull = cssTemperatureIsNotNull;
		return this;
	}
	public Boolean getCssTemperatureIsNotNull(){
		return this.cssTemperatureIsNotNull;
	}
	public CsStateQuery setCssTemperatureStart(BigDecimal cssTemperatureStart){
		this.cssTemperatureStart = cssTemperatureStart;
		return this;
	}
	public BigDecimal getCssTemperatureStart(){
		return this.cssTemperatureStart;
	}
	public CsStateQuery setCssTemperatureEnd(BigDecimal cssTemperatureEnd){
		this.cssTemperatureEnd = cssTemperatureEnd;
		return this;
	}
	public BigDecimal getCssTemperatureEnd(){
		return this.cssTemperatureEnd;
	}
	public CsStateQuery setCssTemperatureLess(BigDecimal cssTemperatureLess){
		this.cssTemperatureLess = cssTemperatureLess;
		return this;
	}
	public BigDecimal getCssTemperatureLess(){
		return this.cssTemperatureLess;
	}
	public CsStateQuery setCssTemperatureGreater(BigDecimal cssTemperatureGreater){
		this.cssTemperatureGreater = cssTemperatureGreater;
		return this;
	}
	public BigDecimal getCssTemperatureGreater(){
		return this.cssTemperatureGreater;
	}
	public CsStateQuery setCssCsqEquals(Short cssCsqEquals){
		this.cssCsqEquals = cssCsqEquals;
		return this;
	}
	public Short getCssCsqEquals(){
		return this.cssCsqEquals;
	}
	public CsStateQuery setCssCsqIn(Short[] cssCsqIn){
		this.cssCsqIn = cssCsqIn;
		return this;
	}
	public Short[] getCssCsqIn(){
		return this.cssCsqIn;
	}
	public CsStateQuery setCssCsqIsNull(Boolean cssCsqIsNull){
		this.cssCsqIsNull = cssCsqIsNull;
		return this;
	}
	public Boolean getCssCsqIsNull(){
		return this.cssCsqIsNull;
	}
	public CsStateQuery setCssCsqIsNotNull(Boolean cssCsqIsNotNull){
		this.cssCsqIsNotNull = cssCsqIsNotNull;
		return this;
	}
	public Boolean getCssCsqIsNotNull(){
		return this.cssCsqIsNotNull;
	}
	public CsStateQuery setCssCsqStart(Short cssCsqStart){
		this.cssCsqStart = cssCsqStart;
		return this;
	}
	public Short getCssCsqStart(){
		return this.cssCsqStart;
	}
	public CsStateQuery setCssCsqEnd(Short cssCsqEnd){
		this.cssCsqEnd = cssCsqEnd;
		return this;
	}
	public Short getCssCsqEnd(){
		return this.cssCsqEnd;
	}
	public CsStateQuery setCssCsqLess(Short cssCsqLess){
		this.cssCsqLess = cssCsqLess;
		return this;
	}
	public Short getCssCsqLess(){
		return this.cssCsqLess;
	}
	public CsStateQuery setCssCsqGreater(Short cssCsqGreater){
		this.cssCsqGreater = cssCsqGreater;
		return this;
	}
	public Short getCssCsqGreater(){
		return this.cssCsqGreater;
	}
	public CsStateQuery setCssLongitudeEquals(BigDecimal cssLongitudeEquals){
		this.cssLongitudeEquals = cssLongitudeEquals;
		return this;
	}
	public BigDecimal getCssLongitudeEquals(){
		return this.cssLongitudeEquals;
	}
	public CsStateQuery setCssLongitudeIn(BigDecimal[] cssLongitudeIn){
		this.cssLongitudeIn = cssLongitudeIn;
		return this;
	}
	public BigDecimal[] getCssLongitudeIn(){
		return this.cssLongitudeIn;
	}
	public CsStateQuery setCssLongitudeIsNull(Boolean cssLongitudeIsNull){
		this.cssLongitudeIsNull = cssLongitudeIsNull;
		return this;
	}
	public Boolean getCssLongitudeIsNull(){
		return this.cssLongitudeIsNull;
	}
	public CsStateQuery setCssLongitudeIsNotNull(Boolean cssLongitudeIsNotNull){
		this.cssLongitudeIsNotNull = cssLongitudeIsNotNull;
		return this;
	}
	public Boolean getCssLongitudeIsNotNull(){
		return this.cssLongitudeIsNotNull;
	}
	public CsStateQuery setCssLongitudeStart(BigDecimal cssLongitudeStart){
		this.cssLongitudeStart = cssLongitudeStart;
		return this;
	}
	public BigDecimal getCssLongitudeStart(){
		return this.cssLongitudeStart;
	}
	public CsStateQuery setCssLongitudeEnd(BigDecimal cssLongitudeEnd){
		this.cssLongitudeEnd = cssLongitudeEnd;
		return this;
	}
	public BigDecimal getCssLongitudeEnd(){
		return this.cssLongitudeEnd;
	}
	public CsStateQuery setCssLongitudeLess(BigDecimal cssLongitudeLess){
		this.cssLongitudeLess = cssLongitudeLess;
		return this;
	}
	public BigDecimal getCssLongitudeLess(){
		return this.cssLongitudeLess;
	}
	public CsStateQuery setCssLongitudeGreater(BigDecimal cssLongitudeGreater){
		this.cssLongitudeGreater = cssLongitudeGreater;
		return this;
	}
	public BigDecimal getCssLongitudeGreater(){
		return this.cssLongitudeGreater;
	}
	public CsStateQuery setCssLatitudeEquals(BigDecimal cssLatitudeEquals){
		this.cssLatitudeEquals = cssLatitudeEquals;
		return this;
	}
	public BigDecimal getCssLatitudeEquals(){
		return this.cssLatitudeEquals;
	}
	public CsStateQuery setCssLatitudeIn(BigDecimal[] cssLatitudeIn){
		this.cssLatitudeIn = cssLatitudeIn;
		return this;
	}
	public BigDecimal[] getCssLatitudeIn(){
		return this.cssLatitudeIn;
	}
	public CsStateQuery setCssLatitudeIsNull(Boolean cssLatitudeIsNull){
		this.cssLatitudeIsNull = cssLatitudeIsNull;
		return this;
	}
	public Boolean getCssLatitudeIsNull(){
		return this.cssLatitudeIsNull;
	}
	public CsStateQuery setCssLatitudeIsNotNull(Boolean cssLatitudeIsNotNull){
		this.cssLatitudeIsNotNull = cssLatitudeIsNotNull;
		return this;
	}
	public Boolean getCssLatitudeIsNotNull(){
		return this.cssLatitudeIsNotNull;
	}
	public CsStateQuery setCssLatitudeStart(BigDecimal cssLatitudeStart){
		this.cssLatitudeStart = cssLatitudeStart;
		return this;
	}
	public BigDecimal getCssLatitudeStart(){
		return this.cssLatitudeStart;
	}
	public CsStateQuery setCssLatitudeEnd(BigDecimal cssLatitudeEnd){
		this.cssLatitudeEnd = cssLatitudeEnd;
		return this;
	}
	public BigDecimal getCssLatitudeEnd(){
		return this.cssLatitudeEnd;
	}
	public CsStateQuery setCssLatitudeLess(BigDecimal cssLatitudeLess){
		this.cssLatitudeLess = cssLatitudeLess;
		return this;
	}
	public BigDecimal getCssLatitudeLess(){
		return this.cssLatitudeLess;
	}
	public CsStateQuery setCssLatitudeGreater(BigDecimal cssLatitudeGreater){
		this.cssLatitudeGreater = cssLatitudeGreater;
		return this;
	}
	public BigDecimal getCssLatitudeGreater(){
		return this.cssLatitudeGreater;
	}
	public CsStateQuery setCssGpsValidEquals(Short cssGpsValidEquals){
		this.cssGpsValidEquals = cssGpsValidEquals;
		return this;
	}
	public Short getCssGpsValidEquals(){
		return this.cssGpsValidEquals;
	}
	public CsStateQuery setCssGpsValidIn(Short[] cssGpsValidIn){
		this.cssGpsValidIn = cssGpsValidIn;
		return this;
	}
	public Short[] getCssGpsValidIn(){
		return this.cssGpsValidIn;
	}
	public CsStateQuery setCssGpsValidIsNull(Boolean cssGpsValidIsNull){
		this.cssGpsValidIsNull = cssGpsValidIsNull;
		return this;
	}
	public Boolean getCssGpsValidIsNull(){
		return this.cssGpsValidIsNull;
	}
	public CsStateQuery setCssGpsValidIsNotNull(Boolean cssGpsValidIsNotNull){
		this.cssGpsValidIsNotNull = cssGpsValidIsNotNull;
		return this;
	}
	public Boolean getCssGpsValidIsNotNull(){
		return this.cssGpsValidIsNotNull;
	}
	public CsStateQuery setCssGpsValidStart(Short cssGpsValidStart){
		this.cssGpsValidStart = cssGpsValidStart;
		return this;
	}
	public Short getCssGpsValidStart(){
		return this.cssGpsValidStart;
	}
	public CsStateQuery setCssGpsValidEnd(Short cssGpsValidEnd){
		this.cssGpsValidEnd = cssGpsValidEnd;
		return this;
	}
	public Short getCssGpsValidEnd(){
		return this.cssGpsValidEnd;
	}
	public CsStateQuery setCssGpsValidLess(Short cssGpsValidLess){
		this.cssGpsValidLess = cssGpsValidLess;
		return this;
	}
	public Short getCssGpsValidLess(){
		return this.cssGpsValidLess;
	}
	public CsStateQuery setCssGpsValidGreater(Short cssGpsValidGreater){
		this.cssGpsValidGreater = cssGpsValidGreater;
		return this;
	}
	public Short getCssGpsValidGreater(){
		return this.cssGpsValidGreater;
	}
	public CsStateQuery setCssGpsCnEquals(Short cssGpsCnEquals){
		this.cssGpsCnEquals = cssGpsCnEquals;
		return this;
	}
	public Short getCssGpsCnEquals(){
		return this.cssGpsCnEquals;
	}
	public CsStateQuery setCssGpsCnIn(Short[] cssGpsCnIn){
		this.cssGpsCnIn = cssGpsCnIn;
		return this;
	}
	public Short[] getCssGpsCnIn(){
		return this.cssGpsCnIn;
	}
	public CsStateQuery setCssGpsCnIsNull(Boolean cssGpsCnIsNull){
		this.cssGpsCnIsNull = cssGpsCnIsNull;
		return this;
	}
	public Boolean getCssGpsCnIsNull(){
		return this.cssGpsCnIsNull;
	}
	public CsStateQuery setCssGpsCnIsNotNull(Boolean cssGpsCnIsNotNull){
		this.cssGpsCnIsNotNull = cssGpsCnIsNotNull;
		return this;
	}
	public Boolean getCssGpsCnIsNotNull(){
		return this.cssGpsCnIsNotNull;
	}
	public CsStateQuery setCssGpsCnStart(Short cssGpsCnStart){
		this.cssGpsCnStart = cssGpsCnStart;
		return this;
	}
	public Short getCssGpsCnStart(){
		return this.cssGpsCnStart;
	}
	public CsStateQuery setCssGpsCnEnd(Short cssGpsCnEnd){
		this.cssGpsCnEnd = cssGpsCnEnd;
		return this;
	}
	public Short getCssGpsCnEnd(){
		return this.cssGpsCnEnd;
	}
	public CsStateQuery setCssGpsCnLess(Short cssGpsCnLess){
		this.cssGpsCnLess = cssGpsCnLess;
		return this;
	}
	public Short getCssGpsCnLess(){
		return this.cssGpsCnLess;
	}
	public CsStateQuery setCssGpsCnGreater(Short cssGpsCnGreater){
		this.cssGpsCnGreater = cssGpsCnGreater;
		return this;
	}
	public Short getCssGpsCnGreater(){
		return this.cssGpsCnGreater;
	}
	public CsStateQuery setCssGpsCountEquals(Short cssGpsCountEquals){
		this.cssGpsCountEquals = cssGpsCountEquals;
		return this;
	}
	public Short getCssGpsCountEquals(){
		return this.cssGpsCountEquals;
	}
	public CsStateQuery setCssGpsCountIn(Short[] cssGpsCountIn){
		this.cssGpsCountIn = cssGpsCountIn;
		return this;
	}
	public Short[] getCssGpsCountIn(){
		return this.cssGpsCountIn;
	}
	public CsStateQuery setCssGpsCountIsNull(Boolean cssGpsCountIsNull){
		this.cssGpsCountIsNull = cssGpsCountIsNull;
		return this;
	}
	public Boolean getCssGpsCountIsNull(){
		return this.cssGpsCountIsNull;
	}
	public CsStateQuery setCssGpsCountIsNotNull(Boolean cssGpsCountIsNotNull){
		this.cssGpsCountIsNotNull = cssGpsCountIsNotNull;
		return this;
	}
	public Boolean getCssGpsCountIsNotNull(){
		return this.cssGpsCountIsNotNull;
	}
	public CsStateQuery setCssGpsCountStart(Short cssGpsCountStart){
		this.cssGpsCountStart = cssGpsCountStart;
		return this;
	}
	public Short getCssGpsCountStart(){
		return this.cssGpsCountStart;
	}
	public CsStateQuery setCssGpsCountEnd(Short cssGpsCountEnd){
		this.cssGpsCountEnd = cssGpsCountEnd;
		return this;
	}
	public Short getCssGpsCountEnd(){
		return this.cssGpsCountEnd;
	}
	public CsStateQuery setCssGpsCountLess(Short cssGpsCountLess){
		this.cssGpsCountLess = cssGpsCountLess;
		return this;
	}
	public Short getCssGpsCountLess(){
		return this.cssGpsCountLess;
	}
	public CsStateQuery setCssGpsCountGreater(Short cssGpsCountGreater){
		this.cssGpsCountGreater = cssGpsCountGreater;
		return this;
	}
	public Short getCssGpsCountGreater(){
		return this.cssGpsCountGreater;
	}
	public CsStateQuery setCssDirEquals(BigDecimal cssDirEquals){
		this.cssDirEquals = cssDirEquals;
		return this;
	}
	public BigDecimal getCssDirEquals(){
		return this.cssDirEquals;
	}
	public CsStateQuery setCssDirIn(BigDecimal[] cssDirIn){
		this.cssDirIn = cssDirIn;
		return this;
	}
	public BigDecimal[] getCssDirIn(){
		return this.cssDirIn;
	}
	public CsStateQuery setCssDirIsNull(Boolean cssDirIsNull){
		this.cssDirIsNull = cssDirIsNull;
		return this;
	}
	public Boolean getCssDirIsNull(){
		return this.cssDirIsNull;
	}
	public CsStateQuery setCssDirIsNotNull(Boolean cssDirIsNotNull){
		this.cssDirIsNotNull = cssDirIsNotNull;
		return this;
	}
	public Boolean getCssDirIsNotNull(){
		return this.cssDirIsNotNull;
	}
	public CsStateQuery setCssDirStart(BigDecimal cssDirStart){
		this.cssDirStart = cssDirStart;
		return this;
	}
	public BigDecimal getCssDirStart(){
		return this.cssDirStart;
	}
	public CsStateQuery setCssDirEnd(BigDecimal cssDirEnd){
		this.cssDirEnd = cssDirEnd;
		return this;
	}
	public BigDecimal getCssDirEnd(){
		return this.cssDirEnd;
	}
	public CsStateQuery setCssDirLess(BigDecimal cssDirLess){
		this.cssDirLess = cssDirLess;
		return this;
	}
	public BigDecimal getCssDirLess(){
		return this.cssDirLess;
	}
	public CsStateQuery setCssDirGreater(BigDecimal cssDirGreater){
		this.cssDirGreater = cssDirGreater;
		return this;
	}
	public BigDecimal getCssDirGreater(){
		return this.cssDirGreater;
	}
	public CsStateQuery setCssCircularEquals(Short cssCircularEquals){
		this.cssCircularEquals = cssCircularEquals;
		return this;
	}
	public Short getCssCircularEquals(){
		return this.cssCircularEquals;
	}
	public CsStateQuery setCssCircularIn(Short[] cssCircularIn){
		this.cssCircularIn = cssCircularIn;
		return this;
	}
	public Short[] getCssCircularIn(){
		return this.cssCircularIn;
	}
	public CsStateQuery setCssCircularIsNull(Boolean cssCircularIsNull){
		this.cssCircularIsNull = cssCircularIsNull;
		return this;
	}
	public Boolean getCssCircularIsNull(){
		return this.cssCircularIsNull;
	}
	public CsStateQuery setCssCircularIsNotNull(Boolean cssCircularIsNotNull){
		this.cssCircularIsNotNull = cssCircularIsNotNull;
		return this;
	}
	public Boolean getCssCircularIsNotNull(){
		return this.cssCircularIsNotNull;
	}
	public CsStateQuery setCssCircularStart(Short cssCircularStart){
		this.cssCircularStart = cssCircularStart;
		return this;
	}
	public Short getCssCircularStart(){
		return this.cssCircularStart;
	}
	public CsStateQuery setCssCircularEnd(Short cssCircularEnd){
		this.cssCircularEnd = cssCircularEnd;
		return this;
	}
	public Short getCssCircularEnd(){
		return this.cssCircularEnd;
	}
	public CsStateQuery setCssCircularLess(Short cssCircularLess){
		this.cssCircularLess = cssCircularLess;
		return this;
	}
	public Short getCssCircularLess(){
		return this.cssCircularLess;
	}
	public CsStateQuery setCssCircularGreater(Short cssCircularGreater){
		this.cssCircularGreater = cssCircularGreater;
		return this;
	}
	public Short getCssCircularGreater(){
		return this.cssCircularGreater;
	}
	public CsStateQuery setCssPtcEquals(Short cssPtcEquals){
		this.cssPtcEquals = cssPtcEquals;
		return this;
	}
	public Short getCssPtcEquals(){
		return this.cssPtcEquals;
	}
	public CsStateQuery setCssPtcIn(Short[] cssPtcIn){
		this.cssPtcIn = cssPtcIn;
		return this;
	}
	public Short[] getCssPtcIn(){
		return this.cssPtcIn;
	}
	public CsStateQuery setCssPtcIsNull(Boolean cssPtcIsNull){
		this.cssPtcIsNull = cssPtcIsNull;
		return this;
	}
	public Boolean getCssPtcIsNull(){
		return this.cssPtcIsNull;
	}
	public CsStateQuery setCssPtcIsNotNull(Boolean cssPtcIsNotNull){
		this.cssPtcIsNotNull = cssPtcIsNotNull;
		return this;
	}
	public Boolean getCssPtcIsNotNull(){
		return this.cssPtcIsNotNull;
	}
	public CsStateQuery setCssPtcStart(Short cssPtcStart){
		this.cssPtcStart = cssPtcStart;
		return this;
	}
	public Short getCssPtcStart(){
		return this.cssPtcStart;
	}
	public CsStateQuery setCssPtcEnd(Short cssPtcEnd){
		this.cssPtcEnd = cssPtcEnd;
		return this;
	}
	public Short getCssPtcEnd(){
		return this.cssPtcEnd;
	}
	public CsStateQuery setCssPtcLess(Short cssPtcLess){
		this.cssPtcLess = cssPtcLess;
		return this;
	}
	public Short getCssPtcLess(){
		return this.cssPtcLess;
	}
	public CsStateQuery setCssPtcGreater(Short cssPtcGreater){
		this.cssPtcGreater = cssPtcGreater;
		return this;
	}
	public Short getCssPtcGreater(){
		return this.cssPtcGreater;
	}
	public CsStateQuery setCssCompresEquals(Short cssCompresEquals){
		this.cssCompresEquals = cssCompresEquals;
		return this;
	}
	public Short getCssCompresEquals(){
		return this.cssCompresEquals;
	}
	public CsStateQuery setCssCompresIn(Short[] cssCompresIn){
		this.cssCompresIn = cssCompresIn;
		return this;
	}
	public Short[] getCssCompresIn(){
		return this.cssCompresIn;
	}
	public CsStateQuery setCssCompresIsNull(Boolean cssCompresIsNull){
		this.cssCompresIsNull = cssCompresIsNull;
		return this;
	}
	public Boolean getCssCompresIsNull(){
		return this.cssCompresIsNull;
	}
	public CsStateQuery setCssCompresIsNotNull(Boolean cssCompresIsNotNull){
		this.cssCompresIsNotNull = cssCompresIsNotNull;
		return this;
	}
	public Boolean getCssCompresIsNotNull(){
		return this.cssCompresIsNotNull;
	}
	public CsStateQuery setCssCompresStart(Short cssCompresStart){
		this.cssCompresStart = cssCompresStart;
		return this;
	}
	public Short getCssCompresStart(){
		return this.cssCompresStart;
	}
	public CsStateQuery setCssCompresEnd(Short cssCompresEnd){
		this.cssCompresEnd = cssCompresEnd;
		return this;
	}
	public Short getCssCompresEnd(){
		return this.cssCompresEnd;
	}
	public CsStateQuery setCssCompresLess(Short cssCompresLess){
		this.cssCompresLess = cssCompresLess;
		return this;
	}
	public Short getCssCompresLess(){
		return this.cssCompresLess;
	}
	public CsStateQuery setCssCompresGreater(Short cssCompresGreater){
		this.cssCompresGreater = cssCompresGreater;
		return this;
	}
	public Short getCssCompresGreater(){
		return this.cssCompresGreater;
	}
	public CsStateQuery setCssFanEquals(Short cssFanEquals){
		this.cssFanEquals = cssFanEquals;
		return this;
	}
	public Short getCssFanEquals(){
		return this.cssFanEquals;
	}
	public CsStateQuery setCssFanIn(Short[] cssFanIn){
		this.cssFanIn = cssFanIn;
		return this;
	}
	public Short[] getCssFanIn(){
		return this.cssFanIn;
	}
	public CsStateQuery setCssFanIsNull(Boolean cssFanIsNull){
		this.cssFanIsNull = cssFanIsNull;
		return this;
	}
	public Boolean getCssFanIsNull(){
		return this.cssFanIsNull;
	}
	public CsStateQuery setCssFanIsNotNull(Boolean cssFanIsNotNull){
		this.cssFanIsNotNull = cssFanIsNotNull;
		return this;
	}
	public Boolean getCssFanIsNotNull(){
		return this.cssFanIsNotNull;
	}
	public CsStateQuery setCssFanStart(Short cssFanStart){
		this.cssFanStart = cssFanStart;
		return this;
	}
	public Short getCssFanStart(){
		return this.cssFanStart;
	}
	public CsStateQuery setCssFanEnd(Short cssFanEnd){
		this.cssFanEnd = cssFanEnd;
		return this;
	}
	public Short getCssFanEnd(){
		return this.cssFanEnd;
	}
	public CsStateQuery setCssFanLess(Short cssFanLess){
		this.cssFanLess = cssFanLess;
		return this;
	}
	public Short getCssFanLess(){
		return this.cssFanLess;
	}
	public CsStateQuery setCssFanGreater(Short cssFanGreater){
		this.cssFanGreater = cssFanGreater;
		return this;
	}
	public Short getCssFanGreater(){
		return this.cssFanGreater;
	}
	public CsStateQuery setCssSavingEquals(Short cssSavingEquals){
		this.cssSavingEquals = cssSavingEquals;
		return this;
	}
	public Short getCssSavingEquals(){
		return this.cssSavingEquals;
	}
	public CsStateQuery setCssSavingIn(Short[] cssSavingIn){
		this.cssSavingIn = cssSavingIn;
		return this;
	}
	public Short[] getCssSavingIn(){
		return this.cssSavingIn;
	}
	public CsStateQuery setCssSavingIsNull(Boolean cssSavingIsNull){
		this.cssSavingIsNull = cssSavingIsNull;
		return this;
	}
	public Boolean getCssSavingIsNull(){
		return this.cssSavingIsNull;
	}
	public CsStateQuery setCssSavingIsNotNull(Boolean cssSavingIsNotNull){
		this.cssSavingIsNotNull = cssSavingIsNotNull;
		return this;
	}
	public Boolean getCssSavingIsNotNull(){
		return this.cssSavingIsNotNull;
	}
	public CsStateQuery setCssSavingStart(Short cssSavingStart){
		this.cssSavingStart = cssSavingStart;
		return this;
	}
	public Short getCssSavingStart(){
		return this.cssSavingStart;
	}
	public CsStateQuery setCssSavingEnd(Short cssSavingEnd){
		this.cssSavingEnd = cssSavingEnd;
		return this;
	}
	public Short getCssSavingEnd(){
		return this.cssSavingEnd;
	}
	public CsStateQuery setCssSavingLess(Short cssSavingLess){
		this.cssSavingLess = cssSavingLess;
		return this;
	}
	public Short getCssSavingLess(){
		return this.cssSavingLess;
	}
	public CsStateQuery setCssSavingGreater(Short cssSavingGreater){
		this.cssSavingGreater = cssSavingGreater;
		return this;
	}
	public Short getCssSavingGreater(){
		return this.cssSavingGreater;
	}
	public CsStateQuery setCssDoorLike(String cssDoorLike){
		this.cssDoorLike = cssDoorLike;
		return this;
	}
	public String getCssDoorLike(){
		return this.cssDoorLike;
	}
	public CsStateQuery setCssDoorEquals(String cssDoorEquals){
		this.cssDoorEquals = cssDoorEquals;
		return this;
	}
	public String getCssDoorEquals(){
		return this.cssDoorEquals;
	}
	public CsStateQuery setCssDoorIn(String[] cssDoorIn){
		this.cssDoorIn = cssDoorIn;
		return this;
	}
	public String[] getCssDoorIn(){
		return this.cssDoorIn;
	}
	public CsStateQuery setCssDoorIsNull(Boolean cssDoorIsNull){
		this.cssDoorIsNull = cssDoorIsNull;
		return this;
	}
	public Boolean getCssDoorIsNull(){
		return this.cssDoorIsNull;
	}
	public CsStateQuery setCssDoorIsNotNull(Boolean cssDoorIsNotNull){
		this.cssDoorIsNotNull = cssDoorIsNotNull;
		return this;
	}
	public Boolean getCssDoorIsNotNull(){
		return this.cssDoorIsNotNull;
	}
	public CsStateQuery setCssDoorStart(String cssDoorStart){
		this.cssDoorStart = cssDoorStart;
		return this;
	}
	public String getCssDoorStart(){
		return this.cssDoorStart;
	}
	public CsStateQuery setCssDoorEnd(String cssDoorEnd){
		this.cssDoorEnd = cssDoorEnd;
		return this;
	}
	public String getCssDoorEnd(){
		return this.cssDoorEnd;
	}
	public CsStateQuery setCssDoorLess(String cssDoorLess){
		this.cssDoorLess = cssDoorLess;
		return this;
	}
	public String getCssDoorLess(){
		return this.cssDoorLess;
	}
	public CsStateQuery setCssDoorGreater(String cssDoorGreater){
		this.cssDoorGreater = cssDoorGreater;
		return this;
	}
	public String getCssDoorGreater(){
		return this.cssDoorGreater;
	}
	public CsStateQuery setCssEngineEquals(Short cssEngineEquals){
		this.cssEngineEquals = cssEngineEquals;
		return this;
	}
	public Short getCssEngineEquals(){
		return this.cssEngineEquals;
	}
	public CsStateQuery setCssEngineIn(Short[] cssEngineIn){
		this.cssEngineIn = cssEngineIn;
		return this;
	}
	public Short[] getCssEngineIn(){
		return this.cssEngineIn;
	}
	public CsStateQuery setCssEngineIsNull(Boolean cssEngineIsNull){
		this.cssEngineIsNull = cssEngineIsNull;
		return this;
	}
	public Boolean getCssEngineIsNull(){
		return this.cssEngineIsNull;
	}
	public CsStateQuery setCssEngineIsNotNull(Boolean cssEngineIsNotNull){
		this.cssEngineIsNotNull = cssEngineIsNotNull;
		return this;
	}
	public Boolean getCssEngineIsNotNull(){
		return this.cssEngineIsNotNull;
	}
	public CsStateQuery setCssEngineStart(Short cssEngineStart){
		this.cssEngineStart = cssEngineStart;
		return this;
	}
	public Short getCssEngineStart(){
		return this.cssEngineStart;
	}
	public CsStateQuery setCssEngineEnd(Short cssEngineEnd){
		this.cssEngineEnd = cssEngineEnd;
		return this;
	}
	public Short getCssEngineEnd(){
		return this.cssEngineEnd;
	}
	public CsStateQuery setCssEngineLess(Short cssEngineLess){
		this.cssEngineLess = cssEngineLess;
		return this;
	}
	public Short getCssEngineLess(){
		return this.cssEngineLess;
	}
	public CsStateQuery setCssEngineGreater(Short cssEngineGreater){
		this.cssEngineGreater = cssEngineGreater;
		return this;
	}
	public Short getCssEngineGreater(){
		return this.cssEngineGreater;
	}
	public CsStateQuery setCssKeyEquals(Short cssKeyEquals){
		this.cssKeyEquals = cssKeyEquals;
		return this;
	}
	public Short getCssKeyEquals(){
		return this.cssKeyEquals;
	}
	public CsStateQuery setCssKeyIn(Short[] cssKeyIn){
		this.cssKeyIn = cssKeyIn;
		return this;
	}
	public Short[] getCssKeyIn(){
		return this.cssKeyIn;
	}
	public CsStateQuery setCssKeyIsNull(Boolean cssKeyIsNull){
		this.cssKeyIsNull = cssKeyIsNull;
		return this;
	}
	public Boolean getCssKeyIsNull(){
		return this.cssKeyIsNull;
	}
	public CsStateQuery setCssKeyIsNotNull(Boolean cssKeyIsNotNull){
		this.cssKeyIsNotNull = cssKeyIsNotNull;
		return this;
	}
	public Boolean getCssKeyIsNotNull(){
		return this.cssKeyIsNotNull;
	}
	public CsStateQuery setCssKeyStart(Short cssKeyStart){
		this.cssKeyStart = cssKeyStart;
		return this;
	}
	public Short getCssKeyStart(){
		return this.cssKeyStart;
	}
	public CsStateQuery setCssKeyEnd(Short cssKeyEnd){
		this.cssKeyEnd = cssKeyEnd;
		return this;
	}
	public Short getCssKeyEnd(){
		return this.cssKeyEnd;
	}
	public CsStateQuery setCssKeyLess(Short cssKeyLess){
		this.cssKeyLess = cssKeyLess;
		return this;
	}
	public Short getCssKeyLess(){
		return this.cssKeyLess;
	}
	public CsStateQuery setCssKeyGreater(Short cssKeyGreater){
		this.cssKeyGreater = cssKeyGreater;
		return this;
	}
	public Short getCssKeyGreater(){
		return this.cssKeyGreater;
	}
	public CsStateQuery setCssGearEquals(Short cssGearEquals){
		this.cssGearEquals = cssGearEquals;
		return this;
	}
	public Short getCssGearEquals(){
		return this.cssGearEquals;
	}
	public CsStateQuery setCssGearIn(Short[] cssGearIn){
		this.cssGearIn = cssGearIn;
		return this;
	}
	public Short[] getCssGearIn(){
		return this.cssGearIn;
	}
	public CsStateQuery setCssGearIsNull(Boolean cssGearIsNull){
		this.cssGearIsNull = cssGearIsNull;
		return this;
	}
	public Boolean getCssGearIsNull(){
		return this.cssGearIsNull;
	}
	public CsStateQuery setCssGearIsNotNull(Boolean cssGearIsNotNull){
		this.cssGearIsNotNull = cssGearIsNotNull;
		return this;
	}
	public Boolean getCssGearIsNotNull(){
		return this.cssGearIsNotNull;
	}
	public CsStateQuery setCssGearStart(Short cssGearStart){
		this.cssGearStart = cssGearStart;
		return this;
	}
	public Short getCssGearStart(){
		return this.cssGearStart;
	}
	public CsStateQuery setCssGearEnd(Short cssGearEnd){
		this.cssGearEnd = cssGearEnd;
		return this;
	}
	public Short getCssGearEnd(){
		return this.cssGearEnd;
	}
	public CsStateQuery setCssGearLess(Short cssGearLess){
		this.cssGearLess = cssGearLess;
		return this;
	}
	public Short getCssGearLess(){
		return this.cssGearLess;
	}
	public CsStateQuery setCssGearGreater(Short cssGearGreater){
		this.cssGearGreater = cssGearGreater;
		return this;
	}
	public Short getCssGearGreater(){
		return this.cssGearGreater;
	}
	public CsStateQuery setCssLightEquals(Integer cssLightEquals){
		this.cssLightEquals = cssLightEquals;
		return this;
	}
	public Integer getCssLightEquals(){
		return this.cssLightEquals;
	}
	public CsStateQuery setCssLightIn(Integer[] cssLightIn){
		this.cssLightIn = cssLightIn;
		return this;
	}
	public Integer[] getCssLightIn(){
		return this.cssLightIn;
	}
	public CsStateQuery setCssLightIsNull(Boolean cssLightIsNull){
		this.cssLightIsNull = cssLightIsNull;
		return this;
	}
	public Boolean getCssLightIsNull(){
		return this.cssLightIsNull;
	}
	public CsStateQuery setCssLightIsNotNull(Boolean cssLightIsNotNull){
		this.cssLightIsNotNull = cssLightIsNotNull;
		return this;
	}
	public Boolean getCssLightIsNotNull(){
		return this.cssLightIsNotNull;
	}
	public CsStateQuery setCssLightStart(Integer cssLightStart){
		this.cssLightStart = cssLightStart;
		return this;
	}
	public Integer getCssLightStart(){
		return this.cssLightStart;
	}
	public CsStateQuery setCssLightEnd(Integer cssLightEnd){
		this.cssLightEnd = cssLightEnd;
		return this;
	}
	public Integer getCssLightEnd(){
		return this.cssLightEnd;
	}
	public CsStateQuery setCssLightLess(Integer cssLightLess){
		this.cssLightLess = cssLightLess;
		return this;
	}
	public Integer getCssLightLess(){
		return this.cssLightLess;
	}
	public CsStateQuery setCssLightGreater(Integer cssLightGreater){
		this.cssLightGreater = cssLightGreater;
		return this;
	}
	public Integer getCssLightGreater(){
		return this.cssLightGreater;
	}
	public CsStateQuery setCssLockEquals(Integer cssLockEquals){
		this.cssLockEquals = cssLockEquals;
		return this;
	}
	public Integer getCssLockEquals(){
		return this.cssLockEquals;
	}
	public CsStateQuery setCssLockIn(Integer[] cssLockIn){
		this.cssLockIn = cssLockIn;
		return this;
	}
	public Integer[] getCssLockIn(){
		return this.cssLockIn;
	}
	public CsStateQuery setCssLockIsNull(Boolean cssLockIsNull){
		this.cssLockIsNull = cssLockIsNull;
		return this;
	}
	public Boolean getCssLockIsNull(){
		return this.cssLockIsNull;
	}
	public CsStateQuery setCssLockIsNotNull(Boolean cssLockIsNotNull){
		this.cssLockIsNotNull = cssLockIsNotNull;
		return this;
	}
	public Boolean getCssLockIsNotNull(){
		return this.cssLockIsNotNull;
	}
	public CsStateQuery setCssLockStart(Integer cssLockStart){
		this.cssLockStart = cssLockStart;
		return this;
	}
	public Integer getCssLockStart(){
		return this.cssLockStart;
	}
	public CsStateQuery setCssLockEnd(Integer cssLockEnd){
		this.cssLockEnd = cssLockEnd;
		return this;
	}
	public Integer getCssLockEnd(){
		return this.cssLockEnd;
	}
	public CsStateQuery setCssLockLess(Integer cssLockLess){
		this.cssLockLess = cssLockLess;
		return this;
	}
	public Integer getCssLockLess(){
		return this.cssLockLess;
	}
	public CsStateQuery setCssLockGreater(Integer cssLockGreater){
		this.cssLockGreater = cssLockGreater;
		return this;
	}
	public Integer getCssLockGreater(){
		return this.cssLockGreater;
	}
	public CsStateQuery setCssNetTypeEquals(Short cssNetTypeEquals){
		this.cssNetTypeEquals = cssNetTypeEquals;
		return this;
	}
	public Short getCssNetTypeEquals(){
		return this.cssNetTypeEquals;
	}
	public CsStateQuery setCssNetTypeIn(Short[] cssNetTypeIn){
		this.cssNetTypeIn = cssNetTypeIn;
		return this;
	}
	public Short[] getCssNetTypeIn(){
		return this.cssNetTypeIn;
	}
	public CsStateQuery setCssNetTypeIsNull(Boolean cssNetTypeIsNull){
		this.cssNetTypeIsNull = cssNetTypeIsNull;
		return this;
	}
	public Boolean getCssNetTypeIsNull(){
		return this.cssNetTypeIsNull;
	}
	public CsStateQuery setCssNetTypeIsNotNull(Boolean cssNetTypeIsNotNull){
		this.cssNetTypeIsNotNull = cssNetTypeIsNotNull;
		return this;
	}
	public Boolean getCssNetTypeIsNotNull(){
		return this.cssNetTypeIsNotNull;
	}
	public CsStateQuery setCssNetTypeStart(Short cssNetTypeStart){
		this.cssNetTypeStart = cssNetTypeStart;
		return this;
	}
	public Short getCssNetTypeStart(){
		return this.cssNetTypeStart;
	}
	public CsStateQuery setCssNetTypeEnd(Short cssNetTypeEnd){
		this.cssNetTypeEnd = cssNetTypeEnd;
		return this;
	}
	public Short getCssNetTypeEnd(){
		return this.cssNetTypeEnd;
	}
	public CsStateQuery setCssNetTypeLess(Short cssNetTypeLess){
		this.cssNetTypeLess = cssNetTypeLess;
		return this;
	}
	public Short getCssNetTypeLess(){
		return this.cssNetTypeLess;
	}
	public CsStateQuery setCssNetTypeGreater(Short cssNetTypeGreater){
		this.cssNetTypeGreater = cssNetTypeGreater;
		return this;
	}
	public Short getCssNetTypeGreater(){
		return this.cssNetTypeGreater;
	}
	public CsStateQuery setCssBaseLacEquals(Integer cssBaseLacEquals){
		this.cssBaseLacEquals = cssBaseLacEquals;
		return this;
	}
	public Integer getCssBaseLacEquals(){
		return this.cssBaseLacEquals;
	}
	public CsStateQuery setCssBaseLacIn(Integer[] cssBaseLacIn){
		this.cssBaseLacIn = cssBaseLacIn;
		return this;
	}
	public Integer[] getCssBaseLacIn(){
		return this.cssBaseLacIn;
	}
	public CsStateQuery setCssBaseLacIsNull(Boolean cssBaseLacIsNull){
		this.cssBaseLacIsNull = cssBaseLacIsNull;
		return this;
	}
	public Boolean getCssBaseLacIsNull(){
		return this.cssBaseLacIsNull;
	}
	public CsStateQuery setCssBaseLacIsNotNull(Boolean cssBaseLacIsNotNull){
		this.cssBaseLacIsNotNull = cssBaseLacIsNotNull;
		return this;
	}
	public Boolean getCssBaseLacIsNotNull(){
		return this.cssBaseLacIsNotNull;
	}
	public CsStateQuery setCssBaseLacStart(Integer cssBaseLacStart){
		this.cssBaseLacStart = cssBaseLacStart;
		return this;
	}
	public Integer getCssBaseLacStart(){
		return this.cssBaseLacStart;
	}
	public CsStateQuery setCssBaseLacEnd(Integer cssBaseLacEnd){
		this.cssBaseLacEnd = cssBaseLacEnd;
		return this;
	}
	public Integer getCssBaseLacEnd(){
		return this.cssBaseLacEnd;
	}
	public CsStateQuery setCssBaseLacLess(Integer cssBaseLacLess){
		this.cssBaseLacLess = cssBaseLacLess;
		return this;
	}
	public Integer getCssBaseLacLess(){
		return this.cssBaseLacLess;
	}
	public CsStateQuery setCssBaseLacGreater(Integer cssBaseLacGreater){
		this.cssBaseLacGreater = cssBaseLacGreater;
		return this;
	}
	public Integer getCssBaseLacGreater(){
		return this.cssBaseLacGreater;
	}
	public CsStateQuery setCssBaseCiEquals(Integer cssBaseCiEquals){
		this.cssBaseCiEquals = cssBaseCiEquals;
		return this;
	}
	public Integer getCssBaseCiEquals(){
		return this.cssBaseCiEquals;
	}
	public CsStateQuery setCssBaseCiIn(Integer[] cssBaseCiIn){
		this.cssBaseCiIn = cssBaseCiIn;
		return this;
	}
	public Integer[] getCssBaseCiIn(){
		return this.cssBaseCiIn;
	}
	public CsStateQuery setCssBaseCiIsNull(Boolean cssBaseCiIsNull){
		this.cssBaseCiIsNull = cssBaseCiIsNull;
		return this;
	}
	public Boolean getCssBaseCiIsNull(){
		return this.cssBaseCiIsNull;
	}
	public CsStateQuery setCssBaseCiIsNotNull(Boolean cssBaseCiIsNotNull){
		this.cssBaseCiIsNotNull = cssBaseCiIsNotNull;
		return this;
	}
	public Boolean getCssBaseCiIsNotNull(){
		return this.cssBaseCiIsNotNull;
	}
	public CsStateQuery setCssBaseCiStart(Integer cssBaseCiStart){
		this.cssBaseCiStart = cssBaseCiStart;
		return this;
	}
	public Integer getCssBaseCiStart(){
		return this.cssBaseCiStart;
	}
	public CsStateQuery setCssBaseCiEnd(Integer cssBaseCiEnd){
		this.cssBaseCiEnd = cssBaseCiEnd;
		return this;
	}
	public Integer getCssBaseCiEnd(){
		return this.cssBaseCiEnd;
	}
	public CsStateQuery setCssBaseCiLess(Integer cssBaseCiLess){
		this.cssBaseCiLess = cssBaseCiLess;
		return this;
	}
	public Integer getCssBaseCiLess(){
		return this.cssBaseCiLess;
	}
	public CsStateQuery setCssBaseCiGreater(Integer cssBaseCiGreater){
		this.cssBaseCiGreater = cssBaseCiGreater;
		return this;
	}
	public Integer getCssBaseCiGreater(){
		return this.cssBaseCiGreater;
	}
	public CsStateQuery setCssOrderEquals(Long cssOrderEquals){
		this.cssOrderEquals = cssOrderEquals;
		return this;
	}
	public Long getCssOrderEquals(){
		return this.cssOrderEquals;
	}
	public CsStateQuery setCssOrderIn(Long[] cssOrderIn){
		this.cssOrderIn = cssOrderIn;
		return this;
	}
	public Long[] getCssOrderIn(){
		return this.cssOrderIn;
	}
	public CsStateQuery setCssOrderIsNull(Boolean cssOrderIsNull){
		this.cssOrderIsNull = cssOrderIsNull;
		return this;
	}
	public Boolean getCssOrderIsNull(){
		return this.cssOrderIsNull;
	}
	public CsStateQuery setCssOrderIsNotNull(Boolean cssOrderIsNotNull){
		this.cssOrderIsNotNull = cssOrderIsNotNull;
		return this;
	}
	public Boolean getCssOrderIsNotNull(){
		return this.cssOrderIsNotNull;
	}
	public CsStateQuery setCssOrderStart(Long cssOrderStart){
		this.cssOrderStart = cssOrderStart;
		return this;
	}
	public Long getCssOrderStart(){
		return this.cssOrderStart;
	}
	public CsStateQuery setCssOrderEnd(Long cssOrderEnd){
		this.cssOrderEnd = cssOrderEnd;
		return this;
	}
	public Long getCssOrderEnd(){
		return this.cssOrderEnd;
	}
	public CsStateQuery setCssOrderLess(Long cssOrderLess){
		this.cssOrderLess = cssOrderLess;
		return this;
	}
	public Long getCssOrderLess(){
		return this.cssOrderLess;
	}
	public CsStateQuery setCssOrderGreater(Long cssOrderGreater){
		this.cssOrderGreater = cssOrderGreater;
		return this;
	}
	public Long getCssOrderGreater(){
		return this.cssOrderGreater;
	}
	public CsStateQuery setCssMoDataLike(String cssMoDataLike){
		this.cssMoDataLike = cssMoDataLike;
		return this;
	}
	public String getCssMoDataLike(){
		return this.cssMoDataLike;
	}
	public CsStateQuery setCssMoDataEquals(String cssMoDataEquals){
		this.cssMoDataEquals = cssMoDataEquals;
		return this;
	}
	public String getCssMoDataEquals(){
		return this.cssMoDataEquals;
	}
	public CsStateQuery setCssMoDataIn(String[] cssMoDataIn){
		this.cssMoDataIn = cssMoDataIn;
		return this;
	}
	public String[] getCssMoDataIn(){
		return this.cssMoDataIn;
	}
	public CsStateQuery setCssMoDataIsNull(Boolean cssMoDataIsNull){
		this.cssMoDataIsNull = cssMoDataIsNull;
		return this;
	}
	public Boolean getCssMoDataIsNull(){
		return this.cssMoDataIsNull;
	}
	public CsStateQuery setCssMoDataIsNotNull(Boolean cssMoDataIsNotNull){
		this.cssMoDataIsNotNull = cssMoDataIsNotNull;
		return this;
	}
	public Boolean getCssMoDataIsNotNull(){
		return this.cssMoDataIsNotNull;
	}
	public CsStateQuery setCssMoDataStart(String cssMoDataStart){
		this.cssMoDataStart = cssMoDataStart;
		return this;
	}
	public String getCssMoDataStart(){
		return this.cssMoDataStart;
	}
	public CsStateQuery setCssMoDataEnd(String cssMoDataEnd){
		this.cssMoDataEnd = cssMoDataEnd;
		return this;
	}
	public String getCssMoDataEnd(){
		return this.cssMoDataEnd;
	}
	public CsStateQuery setCssMoDataLess(String cssMoDataLess){
		this.cssMoDataLess = cssMoDataLess;
		return this;
	}
	public String getCssMoDataLess(){
		return this.cssMoDataLess;
	}
	public CsStateQuery setCssMoDataGreater(String cssMoDataGreater){
		this.cssMoDataGreater = cssMoDataGreater;
		return this;
	}
	public String getCssMoDataGreater(){
		return this.cssMoDataGreater;
	}
	public CsStateQuery setCssTeNoLike(String cssTeNoLike){
		this.cssTeNoLike = cssTeNoLike;
		return this;
	}
	public String getCssTeNoLike(){
		return this.cssTeNoLike;
	}
	public CsStateQuery setCssTeNoEquals(String cssTeNoEquals){
		this.cssTeNoEquals = cssTeNoEquals;
		return this;
	}
	public String getCssTeNoEquals(){
		return this.cssTeNoEquals;
	}
	public CsStateQuery setCssTeNoIn(String[] cssTeNoIn){
		this.cssTeNoIn = cssTeNoIn;
		return this;
	}
	public String[] getCssTeNoIn(){
		return this.cssTeNoIn;
	}
	public CsStateQuery setCssTeNoIsNull(Boolean cssTeNoIsNull){
		this.cssTeNoIsNull = cssTeNoIsNull;
		return this;
	}
	public Boolean getCssTeNoIsNull(){
		return this.cssTeNoIsNull;
	}
	public CsStateQuery setCssTeNoIsNotNull(Boolean cssTeNoIsNotNull){
		this.cssTeNoIsNotNull = cssTeNoIsNotNull;
		return this;
	}
	public Boolean getCssTeNoIsNotNull(){
		return this.cssTeNoIsNotNull;
	}
	public CsStateQuery setCssTeNoStart(String cssTeNoStart){
		this.cssTeNoStart = cssTeNoStart;
		return this;
	}
	public String getCssTeNoStart(){
		return this.cssTeNoStart;
	}
	public CsStateQuery setCssTeNoEnd(String cssTeNoEnd){
		this.cssTeNoEnd = cssTeNoEnd;
		return this;
	}
	public String getCssTeNoEnd(){
		return this.cssTeNoEnd;
	}
	public CsStateQuery setCssTeNoLess(String cssTeNoLess){
		this.cssTeNoLess = cssTeNoLess;
		return this;
	}
	public String getCssTeNoLess(){
		return this.cssTeNoLess;
	}
	public CsStateQuery setCssTeNoGreater(String cssTeNoGreater){
		this.cssTeNoGreater = cssTeNoGreater;
		return this;
	}
	public String getCssTeNoGreater(){
		return this.cssTeNoGreater;
	}
	public CsStateQuery setCssAutopilotEquals(Integer cssAutopilotEquals){
		this.cssAutopilotEquals = cssAutopilotEquals;
		return this;
	}
	public Integer getCssAutopilotEquals(){
		return this.cssAutopilotEquals;
	}
	public CsStateQuery setCssAutopilotIn(Integer[] cssAutopilotIn){
		this.cssAutopilotIn = cssAutopilotIn;
		return this;
	}
	public Integer[] getCssAutopilotIn(){
		return this.cssAutopilotIn;
	}
	public CsStateQuery setCssAutopilotIsNull(Boolean cssAutopilotIsNull){
		this.cssAutopilotIsNull = cssAutopilotIsNull;
		return this;
	}
	public Boolean getCssAutopilotIsNull(){
		return this.cssAutopilotIsNull;
	}
	public CsStateQuery setCssAutopilotIsNotNull(Boolean cssAutopilotIsNotNull){
		this.cssAutopilotIsNotNull = cssAutopilotIsNotNull;
		return this;
	}
	public Boolean getCssAutopilotIsNotNull(){
		return this.cssAutopilotIsNotNull;
	}
	public CsStateQuery setCssAutopilotStart(Integer cssAutopilotStart){
		this.cssAutopilotStart = cssAutopilotStart;
		return this;
	}
	public Integer getCssAutopilotStart(){
		return this.cssAutopilotStart;
	}
	public CsStateQuery setCssAutopilotEnd(Integer cssAutopilotEnd){
		this.cssAutopilotEnd = cssAutopilotEnd;
		return this;
	}
	public Integer getCssAutopilotEnd(){
		return this.cssAutopilotEnd;
	}
	public CsStateQuery setCssAutopilotLess(Integer cssAutopilotLess){
		this.cssAutopilotLess = cssAutopilotLess;
		return this;
	}
	public Integer getCssAutopilotLess(){
		return this.cssAutopilotLess;
	}
	public CsStateQuery setCssAutopilotGreater(Integer cssAutopilotGreater){
		this.cssAutopilotGreater = cssAutopilotGreater;
		return this;
	}
	public Integer getCssAutopilotGreater(){
		return this.cssAutopilotGreater;
	}
	public CsStateQuery setCssHandbrakeEquals(Integer cssHandbrakeEquals){
		this.cssHandbrakeEquals = cssHandbrakeEquals;
		return this;
	}
	public Integer getCssHandbrakeEquals(){
		return this.cssHandbrakeEquals;
	}
	public CsStateQuery setCssHandbrakeIn(Integer[] cssHandbrakeIn){
		this.cssHandbrakeIn = cssHandbrakeIn;
		return this;
	}
	public Integer[] getCssHandbrakeIn(){
		return this.cssHandbrakeIn;
	}
	public CsStateQuery setCssHandbrakeIsNull(Boolean cssHandbrakeIsNull){
		this.cssHandbrakeIsNull = cssHandbrakeIsNull;
		return this;
	}
	public Boolean getCssHandbrakeIsNull(){
		return this.cssHandbrakeIsNull;
	}
	public CsStateQuery setCssHandbrakeIsNotNull(Boolean cssHandbrakeIsNotNull){
		this.cssHandbrakeIsNotNull = cssHandbrakeIsNotNull;
		return this;
	}
	public Boolean getCssHandbrakeIsNotNull(){
		return this.cssHandbrakeIsNotNull;
	}
	public CsStateQuery setCssHandbrakeStart(Integer cssHandbrakeStart){
		this.cssHandbrakeStart = cssHandbrakeStart;
		return this;
	}
	public Integer getCssHandbrakeStart(){
		return this.cssHandbrakeStart;
	}
	public CsStateQuery setCssHandbrakeEnd(Integer cssHandbrakeEnd){
		this.cssHandbrakeEnd = cssHandbrakeEnd;
		return this;
	}
	public Integer getCssHandbrakeEnd(){
		return this.cssHandbrakeEnd;
	}
	public CsStateQuery setCssHandbrakeLess(Integer cssHandbrakeLess){
		this.cssHandbrakeLess = cssHandbrakeLess;
		return this;
	}
	public Integer getCssHandbrakeLess(){
		return this.cssHandbrakeLess;
	}
	public CsStateQuery setCssHandbrakeGreater(Integer cssHandbrakeGreater){
		this.cssHandbrakeGreater = cssHandbrakeGreater;
		return this;
	}
	public Integer getCssHandbrakeGreater(){
		return this.cssHandbrakeGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("cssId")){
			return "css_id";
		}
		else if(this.sidx.equals("cssAccess")){
			return "css_access";
		}
		else if(this.sidx.equals("cssHost")){
			return "css_host";
		}
		else if(this.sidx.equals("cssNumber")){
			return "css_number";
		}
		else if(this.sidx.equals("cssCar")){
			return "css_car";
		}
		else if(this.sidx.equals("cssAddTime")){
			return "css_add_time";
		}
		else if(this.sidx.equals("cssCurrentTime")){
			return "css_current_time";
		}
		else if(this.sidx.equals("cssRented")){
			return "css_rented";
		}
		else if(this.sidx.equals("cssWarn")){
			return "css_warn";
		}
		else if(this.sidx.equals("cssRfid")){
			return "css_rfid";
		}
		else if(this.sidx.equals("cssRfidDte")){
			return "css_rfid_dte";
		}
		else if(this.sidx.equals("cssObdMile")){
			return "css_obd_mile";
		}
		else if(this.sidx.equals("cssEngineT")){
			return "css_engine_t";
		}
		else if(this.sidx.equals("cssMileage")){
			return "css_mileage";
		}
		else if(this.sidx.equals("cssSpeed")){
			return "css_speed";
		}
		else if(this.sidx.equals("cssMotor")){
			return "css_motor";
		}
		else if(this.sidx.equals("cssOil")){
			return "css_oil";
		}
		else if(this.sidx.equals("cssPower")){
			return "css_power";
		}
		else if(this.sidx.equals("cssEvBattery")){
			return "css_ev_battery";
		}
		else if(this.sidx.equals("cssCharging")){
			return "css_charging";
		}
		else if(this.sidx.equals("cssFuelMileage")){
			return "css_fuel_mileage";
		}
		else if(this.sidx.equals("cssElectricMileage")){
			return "css_electric_mileage";
		}
		else if(this.sidx.equals("cssEndurance")){
			return "css_endurance";
		}
		else if(this.sidx.equals("cssTemperature")){
			return "css_temperature";
		}
		else if(this.sidx.equals("cssCsq")){
			return "css_csq";
		}
		else if(this.sidx.equals("cssLongitude")){
			return "css_longitude";
		}
		else if(this.sidx.equals("cssLatitude")){
			return "css_latitude";
		}
		else if(this.sidx.equals("cssGpsValid")){
			return "css_gps_valid";
		}
		else if(this.sidx.equals("cssGpsCn")){
			return "css_gps_cn";
		}
		else if(this.sidx.equals("cssGpsCount")){
			return "css_gps_count";
		}
		else if(this.sidx.equals("cssDir")){
			return "css_dir";
		}
		else if(this.sidx.equals("cssCircular")){
			return "css_circular";
		}
		else if(this.sidx.equals("cssPtc")){
			return "css_ptc";
		}
		else if(this.sidx.equals("cssCompres")){
			return "css_compres";
		}
		else if(this.sidx.equals("cssFan")){
			return "css_fan";
		}
		else if(this.sidx.equals("cssSaving")){
			return "css_saving";
		}
		else if(this.sidx.equals("cssDoor")){
			return "css_door";
		}
		else if(this.sidx.equals("cssEngine")){
			return "css_engine";
		}
		else if(this.sidx.equals("cssKey")){
			return "css_key";
		}
		else if(this.sidx.equals("cssGear")){
			return "css_gear";
		}
		else if(this.sidx.equals("cssLight")){
			return "css_light";
		}
		else if(this.sidx.equals("cssLock")){
			return "css_lock";
		}
		else if(this.sidx.equals("cssNetType")){
			return "css_net_type";
		}
		else if(this.sidx.equals("cssBaseLac")){
			return "css_base_lac";
		}
		else if(this.sidx.equals("cssBaseCi")){
			return "css_base_ci";
		}
		else if(this.sidx.equals("cssOrder")){
			return "css_order";
		}
		else if(this.sidx.equals("cssMoData")){
			return "css_mo_data";
		}
		else if(this.sidx.equals("cssTeNo")){
			return "css_te_no";
		}
		else if(this.sidx.equals("cssAutopilot")){
			return "css_autopilot";
		}
		else if(this.sidx.equals("cssHandbrake")){
			return "css_handbrake";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsStateCrieria getCrieria(){
		CsStateCrieria q = new CsStateCrieria();
		CsStateCrieria.Criteria c = q.createCriteria();
		
		if(this.getCssIdEquals()!=null){
			c.andcssIdEqualTo(this.getCssIdEquals());
		}else if(this.getCssIdIsNull()!=null && this.getCssIdIsNull()){
			c.andcssIdIsNull();
		}else if(this.getCssIdIsNotNull()!=null && this.getCssIdIsNotNull()){
			c.andcssIdIsNotNull();
		}else if(this.getCssIdIn()!=null){
			c.andcssIdIn(java.util.Arrays.asList(this.getCssIdIn()));
		}else if(this.getCssIdStart()!=null && this.getCssIdEnd()!=null){
			c.andcssIdBetween(this.getCssIdStart(), this.getCssIdEnd());
		}else if(this.getCssIdGreater()!=null){
			c.andcssIdGreaterThan(this.getCssIdGreater());
		}else if(this.getCssIdLess()!=null){
			c.andcssIdLessThan(this.getCssIdLess());
		}
		if(this.getCssAccessEquals()!=null){
			c.andcssAccessEqualTo(this.getCssAccessEquals());
		}else if(this.getCssAccessIsNull()!=null && this.getCssAccessIsNull()){
			c.andcssAccessIsNull();
		}else if(this.getCssAccessIsNotNull()!=null && this.getCssAccessIsNotNull()){
			c.andcssAccessIsNotNull();
		}else if(this.getCssAccessIn()!=null){
			c.andcssAccessIn(java.util.Arrays.asList(this.getCssAccessIn()));
		}else if(this.getCssAccessStart()!=null && this.getCssAccessEnd()!=null){
			c.andcssAccessBetween(this.getCssAccessStart(), this.getCssAccessEnd());
		}else if(this.getCssAccessGreater()!=null){
			c.andcssAccessGreaterThan(this.getCssAccessGreater());
		}else if(this.getCssAccessLess()!=null){
			c.andcssAccessLessThan(this.getCssAccessLess());
		}
		if(this.getCssHostEquals()!=null){
			c.andcssHostEqualTo(this.getCssHostEquals());
		}else if(this.getCssHostIsNull()!=null && this.getCssHostIsNull()){
			c.andcssHostIsNull();
		}else if(this.getCssHostIsNotNull()!=null && this.getCssHostIsNotNull()){
			c.andcssHostIsNotNull();
		}else if(this.getCssHostIn()!=null){
			c.andcssHostIn(java.util.Arrays.asList(this.getCssHostIn()));
		}else if(this.getCssHostStart()!=null && this.getCssHostEnd()!=null){
			c.andcssHostBetween(this.getCssHostStart(), this.getCssHostEnd());
		}else if(this.getCssHostGreater()!=null){
			c.andcssHostGreaterThan(this.getCssHostGreater());
		}else if(this.getCssHostLess()!=null){
			c.andcssHostLessThan(this.getCssHostLess());
		}
		if(this.getCssNumberEquals()!=null){
			c.andcssNumberEqualTo(this.getCssNumberEquals());
		}else if(this.getCssNumberIsNull()!=null && this.getCssNumberIsNull()){
			c.andcssNumberIsNull();
		}else if(this.getCssNumberIsNotNull()!=null && this.getCssNumberIsNotNull()){
			c.andcssNumberIsNotNull();
		}else if(this.getCssNumberLike()!=null){
			c.andcssNumberLike(this.getCssNumberLike());
		}else if(this.getCssNumberIn()!=null){
			c.andcssNumberIn(java.util.Arrays.asList(this.getCssNumberIn()));
		}else if(this.getCssNumberStart()!=null && this.getCssNumberEnd()!=null){
			c.andcssNumberBetween(this.getCssNumberStart(), this.getCssNumberEnd());
		}else if(this.getCssNumberGreater()!=null){
			c.andcssNumberGreaterThan(this.getCssNumberGreater());
		}else if(this.getCssNumberLess()!=null){
			c.andcssNumberLessThan(this.getCssNumberLess());
		}
		if(this.getCssCarEquals()!=null){
			c.andcssCarEqualTo(this.getCssCarEquals());
		}else if(this.getCssCarIsNull()!=null && this.getCssCarIsNull()){
			c.andcssCarIsNull();
		}else if(this.getCssCarIsNotNull()!=null && this.getCssCarIsNotNull()){
			c.andcssCarIsNotNull();
		}else if(this.getCssCarIn()!=null){
			c.andcssCarIn(java.util.Arrays.asList(this.getCssCarIn()));
		}else if(this.getCssCarStart()!=null && this.getCssCarEnd()!=null){
			c.andcssCarBetween(this.getCssCarStart(), this.getCssCarEnd());
		}else if(this.getCssCarGreater()!=null){
			c.andcssCarGreaterThan(this.getCssCarGreater());
		}else if(this.getCssCarLess()!=null){
			c.andcssCarLessThan(this.getCssCarLess());
		}
		if(this.getCssAddTimeEquals()!=null){
			c.andcssAddTimeEqualTo(this.getCssAddTimeEquals());
		}else if(this.getCssAddTimeIsNull()!=null && this.getCssAddTimeIsNull()){
			c.andcssAddTimeIsNull();
		}else if(this.getCssAddTimeIsNotNull()!=null && this.getCssAddTimeIsNotNull()){
			c.andcssAddTimeIsNotNull();
		}else if(this.getCssAddTimeIn()!=null){
			c.andcssAddTimeIn(java.util.Arrays.asList(this.getCssAddTimeIn()));
		}else if(this.getCssAddTimeStart()!=null && this.getCssAddTimeEnd()!=null){
			c.andcssAddTimeBetween(this.getCssAddTimeStart(), this.getCssAddTimeEnd());
		}else if(this.getCssAddTimeGreater()!=null){
			c.andcssAddTimeGreaterThan(this.getCssAddTimeGreater());
		}else if(this.getCssAddTimeLess()!=null){
			c.andcssAddTimeLessThan(this.getCssAddTimeLess());
		}
		if(this.getCssCurrentTimeEquals()!=null){
			c.andcssCurrentTimeEqualTo(this.getCssCurrentTimeEquals());
		}else if(this.getCssCurrentTimeIsNull()!=null && this.getCssCurrentTimeIsNull()){
			c.andcssCurrentTimeIsNull();
		}else if(this.getCssCurrentTimeIsNotNull()!=null && this.getCssCurrentTimeIsNotNull()){
			c.andcssCurrentTimeIsNotNull();
		}else if(this.getCssCurrentTimeIn()!=null){
			c.andcssCurrentTimeIn(java.util.Arrays.asList(this.getCssCurrentTimeIn()));
		}else if(this.getCssCurrentTimeStart()!=null && this.getCssCurrentTimeEnd()!=null){
			c.andcssCurrentTimeBetween(this.getCssCurrentTimeStart(), this.getCssCurrentTimeEnd());
		}else if(this.getCssCurrentTimeGreater()!=null){
			c.andcssCurrentTimeGreaterThan(this.getCssCurrentTimeGreater());
		}else if(this.getCssCurrentTimeLess()!=null){
			c.andcssCurrentTimeLessThan(this.getCssCurrentTimeLess());
		}
		if(this.getCssRentedEquals()!=null){
			c.andcssRentedEqualTo(this.getCssRentedEquals());
		}else if(this.getCssRentedIsNull()!=null && this.getCssRentedIsNull()){
			c.andcssRentedIsNull();
		}else if(this.getCssRentedIsNotNull()!=null && this.getCssRentedIsNotNull()){
			c.andcssRentedIsNotNull();
		}else if(this.getCssRentedLike()!=null){
			c.andcssRentedLike(this.getCssRentedLike());
		}else if(this.getCssRentedIn()!=null){
			c.andcssRentedIn(java.util.Arrays.asList(this.getCssRentedIn()));
		}else if(this.getCssRentedStart()!=null && this.getCssRentedEnd()!=null){
			c.andcssRentedBetween(this.getCssRentedStart(), this.getCssRentedEnd());
		}else if(this.getCssRentedGreater()!=null){
			c.andcssRentedGreaterThan(this.getCssRentedGreater());
		}else if(this.getCssRentedLess()!=null){
			c.andcssRentedLessThan(this.getCssRentedLess());
		}
		if(this.getCssWarnEquals()!=null){
			c.andcssWarnEqualTo(this.getCssWarnEquals());
		}else if(this.getCssWarnIsNull()!=null && this.getCssWarnIsNull()){
			c.andcssWarnIsNull();
		}else if(this.getCssWarnIsNotNull()!=null && this.getCssWarnIsNotNull()){
			c.andcssWarnIsNotNull();
		}else if(this.getCssWarnIn()!=null){
			c.andcssWarnIn(java.util.Arrays.asList(this.getCssWarnIn()));
		}else if(this.getCssWarnStart()!=null && this.getCssWarnEnd()!=null){
			c.andcssWarnBetween(this.getCssWarnStart(), this.getCssWarnEnd());
		}else if(this.getCssWarnGreater()!=null){
			c.andcssWarnGreaterThan(this.getCssWarnGreater());
		}else if(this.getCssWarnLess()!=null){
			c.andcssWarnLessThan(this.getCssWarnLess());
		}
		if(this.getCssRfidEquals()!=null){
			c.andcssRfidEqualTo(this.getCssRfidEquals());
		}else if(this.getCssRfidIsNull()!=null && this.getCssRfidIsNull()){
			c.andcssRfidIsNull();
		}else if(this.getCssRfidIsNotNull()!=null && this.getCssRfidIsNotNull()){
			c.andcssRfidIsNotNull();
		}else if(this.getCssRfidLike()!=null){
			c.andcssRfidLike(this.getCssRfidLike());
		}else if(this.getCssRfidIn()!=null){
			c.andcssRfidIn(java.util.Arrays.asList(this.getCssRfidIn()));
		}else if(this.getCssRfidStart()!=null && this.getCssRfidEnd()!=null){
			c.andcssRfidBetween(this.getCssRfidStart(), this.getCssRfidEnd());
		}else if(this.getCssRfidGreater()!=null){
			c.andcssRfidGreaterThan(this.getCssRfidGreater());
		}else if(this.getCssRfidLess()!=null){
			c.andcssRfidLessThan(this.getCssRfidLess());
		}
		if(this.getCssRfidDteEquals()!=null){
			c.andcssRfidDteEqualTo(this.getCssRfidDteEquals());
		}else if(this.getCssRfidDteIsNull()!=null && this.getCssRfidDteIsNull()){
			c.andcssRfidDteIsNull();
		}else if(this.getCssRfidDteIsNotNull()!=null && this.getCssRfidDteIsNotNull()){
			c.andcssRfidDteIsNotNull();
		}else if(this.getCssRfidDteLike()!=null){
			c.andcssRfidDteLike(this.getCssRfidDteLike());
		}else if(this.getCssRfidDteIn()!=null){
			c.andcssRfidDteIn(java.util.Arrays.asList(this.getCssRfidDteIn()));
		}else if(this.getCssRfidDteStart()!=null && this.getCssRfidDteEnd()!=null){
			c.andcssRfidDteBetween(this.getCssRfidDteStart(), this.getCssRfidDteEnd());
		}else if(this.getCssRfidDteGreater()!=null){
			c.andcssRfidDteGreaterThan(this.getCssRfidDteGreater());
		}else if(this.getCssRfidDteLess()!=null){
			c.andcssRfidDteLessThan(this.getCssRfidDteLess());
		}
		if(this.getCssObdMileEquals()!=null){
			c.andcssObdMileEqualTo(this.getCssObdMileEquals());
		}else if(this.getCssObdMileIsNull()!=null && this.getCssObdMileIsNull()){
			c.andcssObdMileIsNull();
		}else if(this.getCssObdMileIsNotNull()!=null && this.getCssObdMileIsNotNull()){
			c.andcssObdMileIsNotNull();
		}else if(this.getCssObdMileIn()!=null){
			c.andcssObdMileIn(java.util.Arrays.asList(this.getCssObdMileIn()));
		}else if(this.getCssObdMileStart()!=null && this.getCssObdMileEnd()!=null){
			c.andcssObdMileBetween(this.getCssObdMileStart(), this.getCssObdMileEnd());
		}else if(this.getCssObdMileGreater()!=null){
			c.andcssObdMileGreaterThan(this.getCssObdMileGreater());
		}else if(this.getCssObdMileLess()!=null){
			c.andcssObdMileLessThan(this.getCssObdMileLess());
		}
		if(this.getCssEngineTEquals()!=null){
			c.andcssEngineTEqualTo(this.getCssEngineTEquals());
		}else if(this.getCssEngineTIsNull()!=null && this.getCssEngineTIsNull()){
			c.andcssEngineTIsNull();
		}else if(this.getCssEngineTIsNotNull()!=null && this.getCssEngineTIsNotNull()){
			c.andcssEngineTIsNotNull();
		}else if(this.getCssEngineTIn()!=null){
			c.andcssEngineTIn(java.util.Arrays.asList(this.getCssEngineTIn()));
		}else if(this.getCssEngineTStart()!=null && this.getCssEngineTEnd()!=null){
			c.andcssEngineTBetween(this.getCssEngineTStart(), this.getCssEngineTEnd());
		}else if(this.getCssEngineTGreater()!=null){
			c.andcssEngineTGreaterThan(this.getCssEngineTGreater());
		}else if(this.getCssEngineTLess()!=null){
			c.andcssEngineTLessThan(this.getCssEngineTLess());
		}
		if(this.getCssMileageEquals()!=null){
			c.andcssMileageEqualTo(this.getCssMileageEquals());
		}else if(this.getCssMileageIsNull()!=null && this.getCssMileageIsNull()){
			c.andcssMileageIsNull();
		}else if(this.getCssMileageIsNotNull()!=null && this.getCssMileageIsNotNull()){
			c.andcssMileageIsNotNull();
		}else if(this.getCssMileageIn()!=null){
			c.andcssMileageIn(java.util.Arrays.asList(this.getCssMileageIn()));
		}else if(this.getCssMileageStart()!=null && this.getCssMileageEnd()!=null){
			c.andcssMileageBetween(this.getCssMileageStart(), this.getCssMileageEnd());
		}else if(this.getCssMileageGreater()!=null){
			c.andcssMileageGreaterThan(this.getCssMileageGreater());
		}else if(this.getCssMileageLess()!=null){
			c.andcssMileageLessThan(this.getCssMileageLess());
		}
		if(this.getCssSpeedEquals()!=null){
			c.andcssSpeedEqualTo(this.getCssSpeedEquals());
		}else if(this.getCssSpeedIsNull()!=null && this.getCssSpeedIsNull()){
			c.andcssSpeedIsNull();
		}else if(this.getCssSpeedIsNotNull()!=null && this.getCssSpeedIsNotNull()){
			c.andcssSpeedIsNotNull();
		}else if(this.getCssSpeedIn()!=null){
			c.andcssSpeedIn(java.util.Arrays.asList(this.getCssSpeedIn()));
		}else if(this.getCssSpeedStart()!=null && this.getCssSpeedEnd()!=null){
			c.andcssSpeedBetween(this.getCssSpeedStart(), this.getCssSpeedEnd());
		}else if(this.getCssSpeedGreater()!=null){
			c.andcssSpeedGreaterThan(this.getCssSpeedGreater());
		}else if(this.getCssSpeedLess()!=null){
			c.andcssSpeedLessThan(this.getCssSpeedLess());
		}
		if(this.getCssMotorEquals()!=null){
			c.andcssMotorEqualTo(this.getCssMotorEquals());
		}else if(this.getCssMotorIsNull()!=null && this.getCssMotorIsNull()){
			c.andcssMotorIsNull();
		}else if(this.getCssMotorIsNotNull()!=null && this.getCssMotorIsNotNull()){
			c.andcssMotorIsNotNull();
		}else if(this.getCssMotorIn()!=null){
			c.andcssMotorIn(java.util.Arrays.asList(this.getCssMotorIn()));
		}else if(this.getCssMotorStart()!=null && this.getCssMotorEnd()!=null){
			c.andcssMotorBetween(this.getCssMotorStart(), this.getCssMotorEnd());
		}else if(this.getCssMotorGreater()!=null){
			c.andcssMotorGreaterThan(this.getCssMotorGreater());
		}else if(this.getCssMotorLess()!=null){
			c.andcssMotorLessThan(this.getCssMotorLess());
		}
		if(this.getCssOilEquals()!=null){
			c.andcssOilEqualTo(this.getCssOilEquals());
		}else if(this.getCssOilIsNull()!=null && this.getCssOilIsNull()){
			c.andcssOilIsNull();
		}else if(this.getCssOilIsNotNull()!=null && this.getCssOilIsNotNull()){
			c.andcssOilIsNotNull();
		}else if(this.getCssOilIn()!=null){
			c.andcssOilIn(java.util.Arrays.asList(this.getCssOilIn()));
		}else if(this.getCssOilStart()!=null && this.getCssOilEnd()!=null){
			c.andcssOilBetween(this.getCssOilStart(), this.getCssOilEnd());
		}else if(this.getCssOilGreater()!=null){
			c.andcssOilGreaterThan(this.getCssOilGreater());
		}else if(this.getCssOilLess()!=null){
			c.andcssOilLessThan(this.getCssOilLess());
		}
		if(this.getCssPowerEquals()!=null){
			c.andcssPowerEqualTo(this.getCssPowerEquals());
		}else if(this.getCssPowerIsNull()!=null && this.getCssPowerIsNull()){
			c.andcssPowerIsNull();
		}else if(this.getCssPowerIsNotNull()!=null && this.getCssPowerIsNotNull()){
			c.andcssPowerIsNotNull();
		}else if(this.getCssPowerIn()!=null){
			c.andcssPowerIn(java.util.Arrays.asList(this.getCssPowerIn()));
		}else if(this.getCssPowerStart()!=null && this.getCssPowerEnd()!=null){
			c.andcssPowerBetween(this.getCssPowerStart(), this.getCssPowerEnd());
		}else if(this.getCssPowerGreater()!=null){
			c.andcssPowerGreaterThan(this.getCssPowerGreater());
		}else if(this.getCssPowerLess()!=null){
			c.andcssPowerLessThan(this.getCssPowerLess());
		}
		if(this.getCssEvBatteryEquals()!=null){
			c.andcssEvBatteryEqualTo(this.getCssEvBatteryEquals());
		}else if(this.getCssEvBatteryIsNull()!=null && this.getCssEvBatteryIsNull()){
			c.andcssEvBatteryIsNull();
		}else if(this.getCssEvBatteryIsNotNull()!=null && this.getCssEvBatteryIsNotNull()){
			c.andcssEvBatteryIsNotNull();
		}else if(this.getCssEvBatteryIn()!=null){
			c.andcssEvBatteryIn(java.util.Arrays.asList(this.getCssEvBatteryIn()));
		}else if(this.getCssEvBatteryStart()!=null && this.getCssEvBatteryEnd()!=null){
			c.andcssEvBatteryBetween(this.getCssEvBatteryStart(), this.getCssEvBatteryEnd());
		}else if(this.getCssEvBatteryGreater()!=null){
			c.andcssEvBatteryGreaterThan(this.getCssEvBatteryGreater());
		}else if(this.getCssEvBatteryLess()!=null){
			c.andcssEvBatteryLessThan(this.getCssEvBatteryLess());
		}
		if(this.getCssChargingEquals()!=null){
			c.andcssChargingEqualTo(this.getCssChargingEquals());
		}else if(this.getCssChargingIsNull()!=null && this.getCssChargingIsNull()){
			c.andcssChargingIsNull();
		}else if(this.getCssChargingIsNotNull()!=null && this.getCssChargingIsNotNull()){
			c.andcssChargingIsNotNull();
		}else if(this.getCssChargingIn()!=null){
			c.andcssChargingIn(java.util.Arrays.asList(this.getCssChargingIn()));
		}else if(this.getCssChargingStart()!=null && this.getCssChargingEnd()!=null){
			c.andcssChargingBetween(this.getCssChargingStart(), this.getCssChargingEnd());
		}else if(this.getCssChargingGreater()!=null){
			c.andcssChargingGreaterThan(this.getCssChargingGreater());
		}else if(this.getCssChargingLess()!=null){
			c.andcssChargingLessThan(this.getCssChargingLess());
		}
		if(this.getCssFuelMileageEquals()!=null){
			c.andcssFuelMileageEqualTo(this.getCssFuelMileageEquals());
		}else if(this.getCssFuelMileageIsNull()!=null && this.getCssFuelMileageIsNull()){
			c.andcssFuelMileageIsNull();
		}else if(this.getCssFuelMileageIsNotNull()!=null && this.getCssFuelMileageIsNotNull()){
			c.andcssFuelMileageIsNotNull();
		}else if(this.getCssFuelMileageIn()!=null){
			c.andcssFuelMileageIn(java.util.Arrays.asList(this.getCssFuelMileageIn()));
		}else if(this.getCssFuelMileageStart()!=null && this.getCssFuelMileageEnd()!=null){
			c.andcssFuelMileageBetween(this.getCssFuelMileageStart(), this.getCssFuelMileageEnd());
		}else if(this.getCssFuelMileageGreater()!=null){
			c.andcssFuelMileageGreaterThan(this.getCssFuelMileageGreater());
		}else if(this.getCssFuelMileageLess()!=null){
			c.andcssFuelMileageLessThan(this.getCssFuelMileageLess());
		}
		if(this.getCssElectricMileageEquals()!=null){
			c.andcssElectricMileageEqualTo(this.getCssElectricMileageEquals());
		}else if(this.getCssElectricMileageIsNull()!=null && this.getCssElectricMileageIsNull()){
			c.andcssElectricMileageIsNull();
		}else if(this.getCssElectricMileageIsNotNull()!=null && this.getCssElectricMileageIsNotNull()){
			c.andcssElectricMileageIsNotNull();
		}else if(this.getCssElectricMileageIn()!=null){
			c.andcssElectricMileageIn(java.util.Arrays.asList(this.getCssElectricMileageIn()));
		}else if(this.getCssElectricMileageStart()!=null && this.getCssElectricMileageEnd()!=null){
			c.andcssElectricMileageBetween(this.getCssElectricMileageStart(), this.getCssElectricMileageEnd());
		}else if(this.getCssElectricMileageGreater()!=null){
			c.andcssElectricMileageGreaterThan(this.getCssElectricMileageGreater());
		}else if(this.getCssElectricMileageLess()!=null){
			c.andcssElectricMileageLessThan(this.getCssElectricMileageLess());
		}
		if(this.getCssEnduranceEquals()!=null){
			c.andcssEnduranceEqualTo(this.getCssEnduranceEquals());
		}else if(this.getCssEnduranceIsNull()!=null && this.getCssEnduranceIsNull()){
			c.andcssEnduranceIsNull();
		}else if(this.getCssEnduranceIsNotNull()!=null && this.getCssEnduranceIsNotNull()){
			c.andcssEnduranceIsNotNull();
		}else if(this.getCssEnduranceIn()!=null){
			c.andcssEnduranceIn(java.util.Arrays.asList(this.getCssEnduranceIn()));
		}else if(this.getCssEnduranceStart()!=null && this.getCssEnduranceEnd()!=null){
			c.andcssEnduranceBetween(this.getCssEnduranceStart(), this.getCssEnduranceEnd());
		}else if(this.getCssEnduranceGreater()!=null){
			c.andcssEnduranceGreaterThan(this.getCssEnduranceGreater());
		}else if(this.getCssEnduranceLess()!=null){
			c.andcssEnduranceLessThan(this.getCssEnduranceLess());
		}
		if(this.getCssTemperatureEquals()!=null){
			c.andcssTemperatureEqualTo(this.getCssTemperatureEquals());
		}else if(this.getCssTemperatureIsNull()!=null && this.getCssTemperatureIsNull()){
			c.andcssTemperatureIsNull();
		}else if(this.getCssTemperatureIsNotNull()!=null && this.getCssTemperatureIsNotNull()){
			c.andcssTemperatureIsNotNull();
		}else if(this.getCssTemperatureIn()!=null){
			c.andcssTemperatureIn(java.util.Arrays.asList(this.getCssTemperatureIn()));
		}else if(this.getCssTemperatureStart()!=null && this.getCssTemperatureEnd()!=null){
			c.andcssTemperatureBetween(this.getCssTemperatureStart(), this.getCssTemperatureEnd());
		}else if(this.getCssTemperatureGreater()!=null){
			c.andcssTemperatureGreaterThan(this.getCssTemperatureGreater());
		}else if(this.getCssTemperatureLess()!=null){
			c.andcssTemperatureLessThan(this.getCssTemperatureLess());
		}
		if(this.getCssCsqEquals()!=null){
			c.andcssCsqEqualTo(this.getCssCsqEquals());
		}else if(this.getCssCsqIsNull()!=null && this.getCssCsqIsNull()){
			c.andcssCsqIsNull();
		}else if(this.getCssCsqIsNotNull()!=null && this.getCssCsqIsNotNull()){
			c.andcssCsqIsNotNull();
		}else if(this.getCssCsqIn()!=null){
			c.andcssCsqIn(java.util.Arrays.asList(this.getCssCsqIn()));
		}else if(this.getCssCsqStart()!=null && this.getCssCsqEnd()!=null){
			c.andcssCsqBetween(this.getCssCsqStart(), this.getCssCsqEnd());
		}else if(this.getCssCsqGreater()!=null){
			c.andcssCsqGreaterThan(this.getCssCsqGreater());
		}else if(this.getCssCsqLess()!=null){
			c.andcssCsqLessThan(this.getCssCsqLess());
		}
		if(this.getCssLongitudeEquals()!=null){
			c.andcssLongitudeEqualTo(this.getCssLongitudeEquals());
		}else if(this.getCssLongitudeIsNull()!=null && this.getCssLongitudeIsNull()){
			c.andcssLongitudeIsNull();
		}else if(this.getCssLongitudeIsNotNull()!=null && this.getCssLongitudeIsNotNull()){
			c.andcssLongitudeIsNotNull();
		}else if(this.getCssLongitudeIn()!=null){
			c.andcssLongitudeIn(java.util.Arrays.asList(this.getCssLongitudeIn()));
		}else if(this.getCssLongitudeStart()!=null && this.getCssLongitudeEnd()!=null){
			c.andcssLongitudeBetween(this.getCssLongitudeStart(), this.getCssLongitudeEnd());
		}else if(this.getCssLongitudeGreater()!=null){
			c.andcssLongitudeGreaterThan(this.getCssLongitudeGreater());
		}else if(this.getCssLongitudeLess()!=null){
			c.andcssLongitudeLessThan(this.getCssLongitudeLess());
		}
		if(this.getCssLatitudeEquals()!=null){
			c.andcssLatitudeEqualTo(this.getCssLatitudeEquals());
		}else if(this.getCssLatitudeIsNull()!=null && this.getCssLatitudeIsNull()){
			c.andcssLatitudeIsNull();
		}else if(this.getCssLatitudeIsNotNull()!=null && this.getCssLatitudeIsNotNull()){
			c.andcssLatitudeIsNotNull();
		}else if(this.getCssLatitudeIn()!=null){
			c.andcssLatitudeIn(java.util.Arrays.asList(this.getCssLatitudeIn()));
		}else if(this.getCssLatitudeStart()!=null && this.getCssLatitudeEnd()!=null){
			c.andcssLatitudeBetween(this.getCssLatitudeStart(), this.getCssLatitudeEnd());
		}else if(this.getCssLatitudeGreater()!=null){
			c.andcssLatitudeGreaterThan(this.getCssLatitudeGreater());
		}else if(this.getCssLatitudeLess()!=null){
			c.andcssLatitudeLessThan(this.getCssLatitudeLess());
		}
		if(this.getCssGpsValidEquals()!=null){
			c.andcssGpsValidEqualTo(this.getCssGpsValidEquals());
		}else if(this.getCssGpsValidIsNull()!=null && this.getCssGpsValidIsNull()){
			c.andcssGpsValidIsNull();
		}else if(this.getCssGpsValidIsNotNull()!=null && this.getCssGpsValidIsNotNull()){
			c.andcssGpsValidIsNotNull();
		}else if(this.getCssGpsValidIn()!=null){
			c.andcssGpsValidIn(java.util.Arrays.asList(this.getCssGpsValidIn()));
		}else if(this.getCssGpsValidStart()!=null && this.getCssGpsValidEnd()!=null){
			c.andcssGpsValidBetween(this.getCssGpsValidStart(), this.getCssGpsValidEnd());
		}else if(this.getCssGpsValidGreater()!=null){
			c.andcssGpsValidGreaterThan(this.getCssGpsValidGreater());
		}else if(this.getCssGpsValidLess()!=null){
			c.andcssGpsValidLessThan(this.getCssGpsValidLess());
		}
		if(this.getCssGpsCnEquals()!=null){
			c.andcssGpsCnEqualTo(this.getCssGpsCnEquals());
		}else if(this.getCssGpsCnIsNull()!=null && this.getCssGpsCnIsNull()){
			c.andcssGpsCnIsNull();
		}else if(this.getCssGpsCnIsNotNull()!=null && this.getCssGpsCnIsNotNull()){
			c.andcssGpsCnIsNotNull();
		}else if(this.getCssGpsCnIn()!=null){
			c.andcssGpsCnIn(java.util.Arrays.asList(this.getCssGpsCnIn()));
		}else if(this.getCssGpsCnStart()!=null && this.getCssGpsCnEnd()!=null){
			c.andcssGpsCnBetween(this.getCssGpsCnStart(), this.getCssGpsCnEnd());
		}else if(this.getCssGpsCnGreater()!=null){
			c.andcssGpsCnGreaterThan(this.getCssGpsCnGreater());
		}else if(this.getCssGpsCnLess()!=null){
			c.andcssGpsCnLessThan(this.getCssGpsCnLess());
		}
		if(this.getCssGpsCountEquals()!=null){
			c.andcssGpsCountEqualTo(this.getCssGpsCountEquals());
		}else if(this.getCssGpsCountIsNull()!=null && this.getCssGpsCountIsNull()){
			c.andcssGpsCountIsNull();
		}else if(this.getCssGpsCountIsNotNull()!=null && this.getCssGpsCountIsNotNull()){
			c.andcssGpsCountIsNotNull();
		}else if(this.getCssGpsCountIn()!=null){
			c.andcssGpsCountIn(java.util.Arrays.asList(this.getCssGpsCountIn()));
		}else if(this.getCssGpsCountStart()!=null && this.getCssGpsCountEnd()!=null){
			c.andcssGpsCountBetween(this.getCssGpsCountStart(), this.getCssGpsCountEnd());
		}else if(this.getCssGpsCountGreater()!=null){
			c.andcssGpsCountGreaterThan(this.getCssGpsCountGreater());
		}else if(this.getCssGpsCountLess()!=null){
			c.andcssGpsCountLessThan(this.getCssGpsCountLess());
		}
		if(this.getCssDirEquals()!=null){
			c.andcssDirEqualTo(this.getCssDirEquals());
		}else if(this.getCssDirIsNull()!=null && this.getCssDirIsNull()){
			c.andcssDirIsNull();
		}else if(this.getCssDirIsNotNull()!=null && this.getCssDirIsNotNull()){
			c.andcssDirIsNotNull();
		}else if(this.getCssDirIn()!=null){
			c.andcssDirIn(java.util.Arrays.asList(this.getCssDirIn()));
		}else if(this.getCssDirStart()!=null && this.getCssDirEnd()!=null){
			c.andcssDirBetween(this.getCssDirStart(), this.getCssDirEnd());
		}else if(this.getCssDirGreater()!=null){
			c.andcssDirGreaterThan(this.getCssDirGreater());
		}else if(this.getCssDirLess()!=null){
			c.andcssDirLessThan(this.getCssDirLess());
		}
		if(this.getCssCircularEquals()!=null){
			c.andcssCircularEqualTo(this.getCssCircularEquals());
		}else if(this.getCssCircularIsNull()!=null && this.getCssCircularIsNull()){
			c.andcssCircularIsNull();
		}else if(this.getCssCircularIsNotNull()!=null && this.getCssCircularIsNotNull()){
			c.andcssCircularIsNotNull();
		}else if(this.getCssCircularIn()!=null){
			c.andcssCircularIn(java.util.Arrays.asList(this.getCssCircularIn()));
		}else if(this.getCssCircularStart()!=null && this.getCssCircularEnd()!=null){
			c.andcssCircularBetween(this.getCssCircularStart(), this.getCssCircularEnd());
		}else if(this.getCssCircularGreater()!=null){
			c.andcssCircularGreaterThan(this.getCssCircularGreater());
		}else if(this.getCssCircularLess()!=null){
			c.andcssCircularLessThan(this.getCssCircularLess());
		}
		if(this.getCssPtcEquals()!=null){
			c.andcssPtcEqualTo(this.getCssPtcEquals());
		}else if(this.getCssPtcIsNull()!=null && this.getCssPtcIsNull()){
			c.andcssPtcIsNull();
		}else if(this.getCssPtcIsNotNull()!=null && this.getCssPtcIsNotNull()){
			c.andcssPtcIsNotNull();
		}else if(this.getCssPtcIn()!=null){
			c.andcssPtcIn(java.util.Arrays.asList(this.getCssPtcIn()));
		}else if(this.getCssPtcStart()!=null && this.getCssPtcEnd()!=null){
			c.andcssPtcBetween(this.getCssPtcStart(), this.getCssPtcEnd());
		}else if(this.getCssPtcGreater()!=null){
			c.andcssPtcGreaterThan(this.getCssPtcGreater());
		}else if(this.getCssPtcLess()!=null){
			c.andcssPtcLessThan(this.getCssPtcLess());
		}
		if(this.getCssCompresEquals()!=null){
			c.andcssCompresEqualTo(this.getCssCompresEquals());
		}else if(this.getCssCompresIsNull()!=null && this.getCssCompresIsNull()){
			c.andcssCompresIsNull();
		}else if(this.getCssCompresIsNotNull()!=null && this.getCssCompresIsNotNull()){
			c.andcssCompresIsNotNull();
		}else if(this.getCssCompresIn()!=null){
			c.andcssCompresIn(java.util.Arrays.asList(this.getCssCompresIn()));
		}else if(this.getCssCompresStart()!=null && this.getCssCompresEnd()!=null){
			c.andcssCompresBetween(this.getCssCompresStart(), this.getCssCompresEnd());
		}else if(this.getCssCompresGreater()!=null){
			c.andcssCompresGreaterThan(this.getCssCompresGreater());
		}else if(this.getCssCompresLess()!=null){
			c.andcssCompresLessThan(this.getCssCompresLess());
		}
		if(this.getCssFanEquals()!=null){
			c.andcssFanEqualTo(this.getCssFanEquals());
		}else if(this.getCssFanIsNull()!=null && this.getCssFanIsNull()){
			c.andcssFanIsNull();
		}else if(this.getCssFanIsNotNull()!=null && this.getCssFanIsNotNull()){
			c.andcssFanIsNotNull();
		}else if(this.getCssFanIn()!=null){
			c.andcssFanIn(java.util.Arrays.asList(this.getCssFanIn()));
		}else if(this.getCssFanStart()!=null && this.getCssFanEnd()!=null){
			c.andcssFanBetween(this.getCssFanStart(), this.getCssFanEnd());
		}else if(this.getCssFanGreater()!=null){
			c.andcssFanGreaterThan(this.getCssFanGreater());
		}else if(this.getCssFanLess()!=null){
			c.andcssFanLessThan(this.getCssFanLess());
		}
		if(this.getCssSavingEquals()!=null){
			c.andcssSavingEqualTo(this.getCssSavingEquals());
		}else if(this.getCssSavingIsNull()!=null && this.getCssSavingIsNull()){
			c.andcssSavingIsNull();
		}else if(this.getCssSavingIsNotNull()!=null && this.getCssSavingIsNotNull()){
			c.andcssSavingIsNotNull();
		}else if(this.getCssSavingIn()!=null){
			c.andcssSavingIn(java.util.Arrays.asList(this.getCssSavingIn()));
		}else if(this.getCssSavingStart()!=null && this.getCssSavingEnd()!=null){
			c.andcssSavingBetween(this.getCssSavingStart(), this.getCssSavingEnd());
		}else if(this.getCssSavingGreater()!=null){
			c.andcssSavingGreaterThan(this.getCssSavingGreater());
		}else if(this.getCssSavingLess()!=null){
			c.andcssSavingLessThan(this.getCssSavingLess());
		}
		if(this.getCssDoorEquals()!=null){
			c.andcssDoorEqualTo(this.getCssDoorEquals());
		}else if(this.getCssDoorIsNull()!=null && this.getCssDoorIsNull()){
			c.andcssDoorIsNull();
		}else if(this.getCssDoorIsNotNull()!=null && this.getCssDoorIsNotNull()){
			c.andcssDoorIsNotNull();
		}else if(this.getCssDoorLike()!=null){
			c.andcssDoorLike(this.getCssDoorLike());
		}else if(this.getCssDoorIn()!=null){
			c.andcssDoorIn(java.util.Arrays.asList(this.getCssDoorIn()));
		}else if(this.getCssDoorStart()!=null && this.getCssDoorEnd()!=null){
			c.andcssDoorBetween(this.getCssDoorStart(), this.getCssDoorEnd());
		}else if(this.getCssDoorGreater()!=null){
			c.andcssDoorGreaterThan(this.getCssDoorGreater());
		}else if(this.getCssDoorLess()!=null){
			c.andcssDoorLessThan(this.getCssDoorLess());
		}
		if(this.getCssEngineEquals()!=null){
			c.andcssEngineEqualTo(this.getCssEngineEquals());
		}else if(this.getCssEngineIsNull()!=null && this.getCssEngineIsNull()){
			c.andcssEngineIsNull();
		}else if(this.getCssEngineIsNotNull()!=null && this.getCssEngineIsNotNull()){
			c.andcssEngineIsNotNull();
		}else if(this.getCssEngineIn()!=null){
			c.andcssEngineIn(java.util.Arrays.asList(this.getCssEngineIn()));
		}else if(this.getCssEngineStart()!=null && this.getCssEngineEnd()!=null){
			c.andcssEngineBetween(this.getCssEngineStart(), this.getCssEngineEnd());
		}else if(this.getCssEngineGreater()!=null){
			c.andcssEngineGreaterThan(this.getCssEngineGreater());
		}else if(this.getCssEngineLess()!=null){
			c.andcssEngineLessThan(this.getCssEngineLess());
		}
		if(this.getCssKeyEquals()!=null){
			c.andcssKeyEqualTo(this.getCssKeyEquals());
		}else if(this.getCssKeyIsNull()!=null && this.getCssKeyIsNull()){
			c.andcssKeyIsNull();
		}else if(this.getCssKeyIsNotNull()!=null && this.getCssKeyIsNotNull()){
			c.andcssKeyIsNotNull();
		}else if(this.getCssKeyIn()!=null){
			c.andcssKeyIn(java.util.Arrays.asList(this.getCssKeyIn()));
		}else if(this.getCssKeyStart()!=null && this.getCssKeyEnd()!=null){
			c.andcssKeyBetween(this.getCssKeyStart(), this.getCssKeyEnd());
		}else if(this.getCssKeyGreater()!=null){
			c.andcssKeyGreaterThan(this.getCssKeyGreater());
		}else if(this.getCssKeyLess()!=null){
			c.andcssKeyLessThan(this.getCssKeyLess());
		}
		if(this.getCssGearEquals()!=null){
			c.andcssGearEqualTo(this.getCssGearEquals());
		}else if(this.getCssGearIsNull()!=null && this.getCssGearIsNull()){
			c.andcssGearIsNull();
		}else if(this.getCssGearIsNotNull()!=null && this.getCssGearIsNotNull()){
			c.andcssGearIsNotNull();
		}else if(this.getCssGearIn()!=null){
			c.andcssGearIn(java.util.Arrays.asList(this.getCssGearIn()));
		}else if(this.getCssGearStart()!=null && this.getCssGearEnd()!=null){
			c.andcssGearBetween(this.getCssGearStart(), this.getCssGearEnd());
		}else if(this.getCssGearGreater()!=null){
			c.andcssGearGreaterThan(this.getCssGearGreater());
		}else if(this.getCssGearLess()!=null){
			c.andcssGearLessThan(this.getCssGearLess());
		}
		if(this.getCssLightEquals()!=null){
			c.andcssLightEqualTo(this.getCssLightEquals());
		}else if(this.getCssLightIsNull()!=null && this.getCssLightIsNull()){
			c.andcssLightIsNull();
		}else if(this.getCssLightIsNotNull()!=null && this.getCssLightIsNotNull()){
			c.andcssLightIsNotNull();
		}else if(this.getCssLightIn()!=null){
			c.andcssLightIn(java.util.Arrays.asList(this.getCssLightIn()));
		}else if(this.getCssLightStart()!=null && this.getCssLightEnd()!=null){
			c.andcssLightBetween(this.getCssLightStart(), this.getCssLightEnd());
		}else if(this.getCssLightGreater()!=null){
			c.andcssLightGreaterThan(this.getCssLightGreater());
		}else if(this.getCssLightLess()!=null){
			c.andcssLightLessThan(this.getCssLightLess());
		}
		if(this.getCssLockEquals()!=null){
			c.andcssLockEqualTo(this.getCssLockEquals());
		}else if(this.getCssLockIsNull()!=null && this.getCssLockIsNull()){
			c.andcssLockIsNull();
		}else if(this.getCssLockIsNotNull()!=null && this.getCssLockIsNotNull()){
			c.andcssLockIsNotNull();
		}else if(this.getCssLockIn()!=null){
			c.andcssLockIn(java.util.Arrays.asList(this.getCssLockIn()));
		}else if(this.getCssLockStart()!=null && this.getCssLockEnd()!=null){
			c.andcssLockBetween(this.getCssLockStart(), this.getCssLockEnd());
		}else if(this.getCssLockGreater()!=null){
			c.andcssLockGreaterThan(this.getCssLockGreater());
		}else if(this.getCssLockLess()!=null){
			c.andcssLockLessThan(this.getCssLockLess());
		}
		if(this.getCssNetTypeEquals()!=null){
			c.andcssNetTypeEqualTo(this.getCssNetTypeEquals());
		}else if(this.getCssNetTypeIsNull()!=null && this.getCssNetTypeIsNull()){
			c.andcssNetTypeIsNull();
		}else if(this.getCssNetTypeIsNotNull()!=null && this.getCssNetTypeIsNotNull()){
			c.andcssNetTypeIsNotNull();
		}else if(this.getCssNetTypeIn()!=null){
			c.andcssNetTypeIn(java.util.Arrays.asList(this.getCssNetTypeIn()));
		}else if(this.getCssNetTypeStart()!=null && this.getCssNetTypeEnd()!=null){
			c.andcssNetTypeBetween(this.getCssNetTypeStart(), this.getCssNetTypeEnd());
		}else if(this.getCssNetTypeGreater()!=null){
			c.andcssNetTypeGreaterThan(this.getCssNetTypeGreater());
		}else if(this.getCssNetTypeLess()!=null){
			c.andcssNetTypeLessThan(this.getCssNetTypeLess());
		}
		if(this.getCssBaseLacEquals()!=null){
			c.andcssBaseLacEqualTo(this.getCssBaseLacEquals());
		}else if(this.getCssBaseLacIsNull()!=null && this.getCssBaseLacIsNull()){
			c.andcssBaseLacIsNull();
		}else if(this.getCssBaseLacIsNotNull()!=null && this.getCssBaseLacIsNotNull()){
			c.andcssBaseLacIsNotNull();
		}else if(this.getCssBaseLacIn()!=null){
			c.andcssBaseLacIn(java.util.Arrays.asList(this.getCssBaseLacIn()));
		}else if(this.getCssBaseLacStart()!=null && this.getCssBaseLacEnd()!=null){
			c.andcssBaseLacBetween(this.getCssBaseLacStart(), this.getCssBaseLacEnd());
		}else if(this.getCssBaseLacGreater()!=null){
			c.andcssBaseLacGreaterThan(this.getCssBaseLacGreater());
		}else if(this.getCssBaseLacLess()!=null){
			c.andcssBaseLacLessThan(this.getCssBaseLacLess());
		}
		if(this.getCssBaseCiEquals()!=null){
			c.andcssBaseCiEqualTo(this.getCssBaseCiEquals());
		}else if(this.getCssBaseCiIsNull()!=null && this.getCssBaseCiIsNull()){
			c.andcssBaseCiIsNull();
		}else if(this.getCssBaseCiIsNotNull()!=null && this.getCssBaseCiIsNotNull()){
			c.andcssBaseCiIsNotNull();
		}else if(this.getCssBaseCiIn()!=null){
			c.andcssBaseCiIn(java.util.Arrays.asList(this.getCssBaseCiIn()));
		}else if(this.getCssBaseCiStart()!=null && this.getCssBaseCiEnd()!=null){
			c.andcssBaseCiBetween(this.getCssBaseCiStart(), this.getCssBaseCiEnd());
		}else if(this.getCssBaseCiGreater()!=null){
			c.andcssBaseCiGreaterThan(this.getCssBaseCiGreater());
		}else if(this.getCssBaseCiLess()!=null){
			c.andcssBaseCiLessThan(this.getCssBaseCiLess());
		}
		if(this.getCssOrderEquals()!=null){
			c.andcssOrderEqualTo(this.getCssOrderEquals());
		}else if(this.getCssOrderIsNull()!=null && this.getCssOrderIsNull()){
			c.andcssOrderIsNull();
		}else if(this.getCssOrderIsNotNull()!=null && this.getCssOrderIsNotNull()){
			c.andcssOrderIsNotNull();
		}else if(this.getCssOrderIn()!=null){
			c.andcssOrderIn(java.util.Arrays.asList(this.getCssOrderIn()));
		}else if(this.getCssOrderStart()!=null && this.getCssOrderEnd()!=null){
			c.andcssOrderBetween(this.getCssOrderStart(), this.getCssOrderEnd());
		}else if(this.getCssOrderGreater()!=null){
			c.andcssOrderGreaterThan(this.getCssOrderGreater());
		}else if(this.getCssOrderLess()!=null){
			c.andcssOrderLessThan(this.getCssOrderLess());
		}
		if(this.getCssMoDataEquals()!=null){
			c.andcssMoDataEqualTo(this.getCssMoDataEquals());
		}else if(this.getCssMoDataIsNull()!=null && this.getCssMoDataIsNull()){
			c.andcssMoDataIsNull();
		}else if(this.getCssMoDataIsNotNull()!=null && this.getCssMoDataIsNotNull()){
			c.andcssMoDataIsNotNull();
		}else if(this.getCssMoDataLike()!=null){
			c.andcssMoDataLike(this.getCssMoDataLike());
		}else if(this.getCssMoDataIn()!=null){
			c.andcssMoDataIn(java.util.Arrays.asList(this.getCssMoDataIn()));
		}else if(this.getCssMoDataStart()!=null && this.getCssMoDataEnd()!=null){
			c.andcssMoDataBetween(this.getCssMoDataStart(), this.getCssMoDataEnd());
		}else if(this.getCssMoDataGreater()!=null){
			c.andcssMoDataGreaterThan(this.getCssMoDataGreater());
		}else if(this.getCssMoDataLess()!=null){
			c.andcssMoDataLessThan(this.getCssMoDataLess());
		}
		if(this.getCssTeNoEquals()!=null){
			c.andcssTeNoEqualTo(this.getCssTeNoEquals());
		}else if(this.getCssTeNoIsNull()!=null && this.getCssTeNoIsNull()){
			c.andcssTeNoIsNull();
		}else if(this.getCssTeNoIsNotNull()!=null && this.getCssTeNoIsNotNull()){
			c.andcssTeNoIsNotNull();
		}else if(this.getCssTeNoLike()!=null){
			c.andcssTeNoLike(this.getCssTeNoLike());
		}else if(this.getCssTeNoIn()!=null){
			c.andcssTeNoIn(java.util.Arrays.asList(this.getCssTeNoIn()));
		}else if(this.getCssTeNoStart()!=null && this.getCssTeNoEnd()!=null){
			c.andcssTeNoBetween(this.getCssTeNoStart(), this.getCssTeNoEnd());
		}else if(this.getCssTeNoGreater()!=null){
			c.andcssTeNoGreaterThan(this.getCssTeNoGreater());
		}else if(this.getCssTeNoLess()!=null){
			c.andcssTeNoLessThan(this.getCssTeNoLess());
		}
		if(this.getCssAutopilotEquals()!=null){
			c.andcssAutopilotEqualTo(this.getCssAutopilotEquals());
		}else if(this.getCssAutopilotIsNull()!=null && this.getCssAutopilotIsNull()){
			c.andcssAutopilotIsNull();
		}else if(this.getCssAutopilotIsNotNull()!=null && this.getCssAutopilotIsNotNull()){
			c.andcssAutopilotIsNotNull();
		}else if(this.getCssAutopilotIn()!=null){
			c.andcssAutopilotIn(java.util.Arrays.asList(this.getCssAutopilotIn()));
		}else if(this.getCssAutopilotStart()!=null && this.getCssAutopilotEnd()!=null){
			c.andcssAutopilotBetween(this.getCssAutopilotStart(), this.getCssAutopilotEnd());
		}else if(this.getCssAutopilotGreater()!=null){
			c.andcssAutopilotGreaterThan(this.getCssAutopilotGreater());
		}else if(this.getCssAutopilotLess()!=null){
			c.andcssAutopilotLessThan(this.getCssAutopilotLess());
		}
		if(this.getCssHandbrakeEquals()!=null){
			c.andcssHandbrakeEqualTo(this.getCssHandbrakeEquals());
		}else if(this.getCssHandbrakeIsNull()!=null && this.getCssHandbrakeIsNull()){
			c.andcssHandbrakeIsNull();
		}else if(this.getCssHandbrakeIsNotNull()!=null && this.getCssHandbrakeIsNotNull()){
			c.andcssHandbrakeIsNotNull();
		}else if(this.getCssHandbrakeIn()!=null){
			c.andcssHandbrakeIn(java.util.Arrays.asList(this.getCssHandbrakeIn()));
		}else if(this.getCssHandbrakeStart()!=null && this.getCssHandbrakeEnd()!=null){
			c.andcssHandbrakeBetween(this.getCssHandbrakeStart(), this.getCssHandbrakeEnd());
		}else if(this.getCssHandbrakeGreater()!=null){
			c.andcssHandbrakeGreaterThan(this.getCssHandbrakeGreater());
		}else if(this.getCssHandbrakeLess()!=null){
			c.andcssHandbrakeLessThan(this.getCssHandbrakeLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
