package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsStatisticsCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsStatisticsQuery {
	
	private Integer cssIdEquals;
	private Integer[] cssIdIn;
	private Boolean cssIdIsNull;
	private Boolean cssIdIsNotNull;
	
	private Integer cssIdStart;
	
	private Integer cssIdEnd;
	
	private Integer cssIdLess;
	
	private Integer cssIdGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssTimeEquals;
	private Date[] cssTimeIn;
	private Boolean cssTimeIsNull;
	private Boolean cssTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cssTimeGreater;
	
	private Long cssUnitTimeEquals;
	private Long[] cssUnitTimeIn;
	private Boolean cssUnitTimeIsNull;
	private Boolean cssUnitTimeIsNotNull;
	
	private Long cssUnitTimeStart;
	
	private Long cssUnitTimeEnd;
	
	private Long cssUnitTimeLess;
	
	private Long cssUnitTimeGreater;
	
	private Integer cssRegisteredNumEquals;
	private Integer[] cssRegisteredNumIn;
	private Boolean cssRegisteredNumIsNull;
	private Boolean cssRegisteredNumIsNotNull;
	
	private Integer cssRegisteredNumStart;
	
	private Integer cssRegisteredNumEnd;
	
	private Integer cssRegisteredNumLess;
	
	private Integer cssRegisteredNumGreater;
	
	private Integer cssOnlineNumEquals;
	private Integer[] cssOnlineNumIn;
	private Boolean cssOnlineNumIsNull;
	private Boolean cssOnlineNumIsNotNull;
	
	private Integer cssOnlineNumStart;
	
	private Integer cssOnlineNumEnd;
	
	private Integer cssOnlineNumLess;
	
	private Integer cssOnlineNumGreater;
	
	private Integer cssOfflineNumEquals;
	private Integer[] cssOfflineNumIn;
	private Boolean cssOfflineNumIsNull;
	private Boolean cssOfflineNumIsNotNull;
	
	private Integer cssOfflineNumStart;
	
	private Integer cssOfflineNumEnd;
	
	private Integer cssOfflineNumLess;
	
	private Integer cssOfflineNumGreater;
	
	private Integer cssRunNumEquals;
	private Integer[] cssRunNumIn;
	private Boolean cssRunNumIsNull;
	private Boolean cssRunNumIsNotNull;
	
	private Integer cssRunNumStart;
	
	private Integer cssRunNumEnd;
	
	private Integer cssRunNumLess;
	
	private Integer cssRunNumGreater;
	
	private Integer cssChargingNumEquals;
	private Integer[] cssChargingNumIn;
	private Boolean cssChargingNumIsNull;
	private Boolean cssChargingNumIsNotNull;
	
	private Integer cssChargingNumStart;
	
	private Integer cssChargingNumEnd;
	
	private Integer cssChargingNumLess;
	
	private Integer cssChargingNumGreater;
	
	private Float cssTotalMileageEquals;
	private Float[] cssTotalMileageIn;
	private Boolean cssTotalMileageIsNull;
	private Boolean cssTotalMileageIsNotNull;
	
	private Float cssTotalMileageStart;
	
	private Float cssTotalMileageEnd;
	
	private Float cssTotalMileageLess;
	
	private Float cssTotalMileageGreater;
	
	private Float cssTotalChargeEquals;
	private Float[] cssTotalChargeIn;
	private Boolean cssTotalChargeIsNull;
	private Boolean cssTotalChargeIsNotNull;
	
	private Float cssTotalChargeStart;
	
	private Float cssTotalChargeEnd;
	
	private Float cssTotalChargeLess;
	
	private Float cssTotalChargeGreater;
	
	private Float cssTotalPowerConsumptionEquals;
	private Float[] cssTotalPowerConsumptionIn;
	private Boolean cssTotalPowerConsumptionIsNull;
	private Boolean cssTotalPowerConsumptionIsNotNull;
	
	private Float cssTotalPowerConsumptionStart;
	
	private Float cssTotalPowerConsumptionEnd;
	
	private Float cssTotalPowerConsumptionLess;
	
	private Float cssTotalPowerConsumptionGreater;
	
	private Long cssTotalRunTimeEquals;
	private Long[] cssTotalRunTimeIn;
	private Boolean cssTotalRunTimeIsNull;
	private Boolean cssTotalRunTimeIsNotNull;
	
	private Long cssTotalRunTimeStart;
	
	private Long cssTotalRunTimeEnd;
	
	private Long cssTotalRunTimeLess;
	
	private Long cssTotalRunTimeGreater;
	
	private Long cssIncrementMileageEquals;
	private Long[] cssIncrementMileageIn;
	private Boolean cssIncrementMileageIsNull;
	private Boolean cssIncrementMileageIsNotNull;
	
	private Long cssIncrementMileageStart;
	
	private Long cssIncrementMileageEnd;
	
	private Long cssIncrementMileageLess;
	
	private Long cssIncrementMileageGreater;
	
	private Integer cssAccessEquals;
	private Integer[] cssAccessIn;
	private Boolean cssAccessIsNull;
	private Boolean cssAccessIsNotNull;
	
	private Integer cssAccessStart;
	
	private Integer cssAccessEnd;
	
	private Integer cssAccessLess;
	
	private Integer cssAccessGreater;
	
	private Integer cssCarModelEquals;
	private Integer[] cssCarModelIn;
	private Boolean cssCarModelIsNull;
	private Boolean cssCarModelIsNotNull;
	
	private Integer cssCarModelStart;
	
	private Integer cssCarModelEnd;
	
	private Integer cssCarModelLess;
	
	private Integer cssCarModelGreater;
	private String sidx;
	private String sord;

	public CsStatisticsQuery setCssIdEquals(Integer cssIdEquals){
		this.cssIdEquals = cssIdEquals;
		return this;
	}
	public Integer getCssIdEquals(){
		return this.cssIdEquals;
	}
	public CsStatisticsQuery setCssIdIn(Integer[] cssIdIn){
		this.cssIdIn = cssIdIn;
		return this;
	}
	public Integer[] getCssIdIn(){
		return this.cssIdIn;
	}
	public CsStatisticsQuery setCssIdIsNull(Boolean cssIdIsNull){
		this.cssIdIsNull = cssIdIsNull;
		return this;
	}
	public Boolean getCssIdIsNull(){
		return this.cssIdIsNull;
	}
	public CsStatisticsQuery setCssIdIsNotNull(Boolean cssIdIsNotNull){
		this.cssIdIsNotNull = cssIdIsNotNull;
		return this;
	}
	public Boolean getCssIdIsNotNull(){
		return this.cssIdIsNotNull;
	}
	public CsStatisticsQuery setCssIdStart(Integer cssIdStart){
		this.cssIdStart = cssIdStart;
		return this;
	}
	public Integer getCssIdStart(){
		return this.cssIdStart;
	}
	public CsStatisticsQuery setCssIdEnd(Integer cssIdEnd){
		this.cssIdEnd = cssIdEnd;
		return this;
	}
	public Integer getCssIdEnd(){
		return this.cssIdEnd;
	}
	public CsStatisticsQuery setCssIdLess(Integer cssIdLess){
		this.cssIdLess = cssIdLess;
		return this;
	}
	public Integer getCssIdLess(){
		return this.cssIdLess;
	}
	public CsStatisticsQuery setCssIdGreater(Integer cssIdGreater){
		this.cssIdGreater = cssIdGreater;
		return this;
	}
	public Integer getCssIdGreater(){
		return this.cssIdGreater;
	}
	public CsStatisticsQuery setCssTimeEquals(Date cssTimeEquals){
		this.cssTimeEquals = cssTimeEquals;
		return this;
	}
	public Date getCssTimeEquals(){
		return this.cssTimeEquals;
	}
	public CsStatisticsQuery setCssTimeIn(Date[] cssTimeIn){
		this.cssTimeIn = cssTimeIn;
		return this;
	}
	public Date[] getCssTimeIn(){
		return this.cssTimeIn;
	}
	public CsStatisticsQuery setCssTimeIsNull(Boolean cssTimeIsNull){
		this.cssTimeIsNull = cssTimeIsNull;
		return this;
	}
	public Boolean getCssTimeIsNull(){
		return this.cssTimeIsNull;
	}
	public CsStatisticsQuery setCssTimeIsNotNull(Boolean cssTimeIsNotNull){
		this.cssTimeIsNotNull = cssTimeIsNotNull;
		return this;
	}
	public Boolean getCssTimeIsNotNull(){
		return this.cssTimeIsNotNull;
	}
	public CsStatisticsQuery setCssTimeStart(Date cssTimeStart){
		this.cssTimeStart = cssTimeStart;
		return this;
	}
	public Date getCssTimeStart(){
		return this.cssTimeStart;
	}
	public CsStatisticsQuery setCssTimeEnd(Date cssTimeEnd){
		this.cssTimeEnd = cssTimeEnd;
		return this;
	}
	public Date getCssTimeEnd(){
		return this.cssTimeEnd;
	}
	public CsStatisticsQuery setCssTimeLess(Date cssTimeLess){
		this.cssTimeLess = cssTimeLess;
		return this;
	}
	public Date getCssTimeLess(){
		return this.cssTimeLess;
	}
	public CsStatisticsQuery setCssTimeGreater(Date cssTimeGreater){
		this.cssTimeGreater = cssTimeGreater;
		return this;
	}
	public Date getCssTimeGreater(){
		return this.cssTimeGreater;
	}
	public CsStatisticsQuery setCssUnitTimeEquals(Long cssUnitTimeEquals){
		this.cssUnitTimeEquals = cssUnitTimeEquals;
		return this;
	}
	public Long getCssUnitTimeEquals(){
		return this.cssUnitTimeEquals;
	}
	public CsStatisticsQuery setCssUnitTimeIn(Long[] cssUnitTimeIn){
		this.cssUnitTimeIn = cssUnitTimeIn;
		return this;
	}
	public Long[] getCssUnitTimeIn(){
		return this.cssUnitTimeIn;
	}
	public CsStatisticsQuery setCssUnitTimeIsNull(Boolean cssUnitTimeIsNull){
		this.cssUnitTimeIsNull = cssUnitTimeIsNull;
		return this;
	}
	public Boolean getCssUnitTimeIsNull(){
		return this.cssUnitTimeIsNull;
	}
	public CsStatisticsQuery setCssUnitTimeIsNotNull(Boolean cssUnitTimeIsNotNull){
		this.cssUnitTimeIsNotNull = cssUnitTimeIsNotNull;
		return this;
	}
	public Boolean getCssUnitTimeIsNotNull(){
		return this.cssUnitTimeIsNotNull;
	}
	public CsStatisticsQuery setCssUnitTimeStart(Long cssUnitTimeStart){
		this.cssUnitTimeStart = cssUnitTimeStart;
		return this;
	}
	public Long getCssUnitTimeStart(){
		return this.cssUnitTimeStart;
	}
	public CsStatisticsQuery setCssUnitTimeEnd(Long cssUnitTimeEnd){
		this.cssUnitTimeEnd = cssUnitTimeEnd;
		return this;
	}
	public Long getCssUnitTimeEnd(){
		return this.cssUnitTimeEnd;
	}
	public CsStatisticsQuery setCssUnitTimeLess(Long cssUnitTimeLess){
		this.cssUnitTimeLess = cssUnitTimeLess;
		return this;
	}
	public Long getCssUnitTimeLess(){
		return this.cssUnitTimeLess;
	}
	public CsStatisticsQuery setCssUnitTimeGreater(Long cssUnitTimeGreater){
		this.cssUnitTimeGreater = cssUnitTimeGreater;
		return this;
	}
	public Long getCssUnitTimeGreater(){
		return this.cssUnitTimeGreater;
	}
	public CsStatisticsQuery setCssRegisteredNumEquals(Integer cssRegisteredNumEquals){
		this.cssRegisteredNumEquals = cssRegisteredNumEquals;
		return this;
	}
	public Integer getCssRegisteredNumEquals(){
		return this.cssRegisteredNumEquals;
	}
	public CsStatisticsQuery setCssRegisteredNumIn(Integer[] cssRegisteredNumIn){
		this.cssRegisteredNumIn = cssRegisteredNumIn;
		return this;
	}
	public Integer[] getCssRegisteredNumIn(){
		return this.cssRegisteredNumIn;
	}
	public CsStatisticsQuery setCssRegisteredNumIsNull(Boolean cssRegisteredNumIsNull){
		this.cssRegisteredNumIsNull = cssRegisteredNumIsNull;
		return this;
	}
	public Boolean getCssRegisteredNumIsNull(){
		return this.cssRegisteredNumIsNull;
	}
	public CsStatisticsQuery setCssRegisteredNumIsNotNull(Boolean cssRegisteredNumIsNotNull){
		this.cssRegisteredNumIsNotNull = cssRegisteredNumIsNotNull;
		return this;
	}
	public Boolean getCssRegisteredNumIsNotNull(){
		return this.cssRegisteredNumIsNotNull;
	}
	public CsStatisticsQuery setCssRegisteredNumStart(Integer cssRegisteredNumStart){
		this.cssRegisteredNumStart = cssRegisteredNumStart;
		return this;
	}
	public Integer getCssRegisteredNumStart(){
		return this.cssRegisteredNumStart;
	}
	public CsStatisticsQuery setCssRegisteredNumEnd(Integer cssRegisteredNumEnd){
		this.cssRegisteredNumEnd = cssRegisteredNumEnd;
		return this;
	}
	public Integer getCssRegisteredNumEnd(){
		return this.cssRegisteredNumEnd;
	}
	public CsStatisticsQuery setCssRegisteredNumLess(Integer cssRegisteredNumLess){
		this.cssRegisteredNumLess = cssRegisteredNumLess;
		return this;
	}
	public Integer getCssRegisteredNumLess(){
		return this.cssRegisteredNumLess;
	}
	public CsStatisticsQuery setCssRegisteredNumGreater(Integer cssRegisteredNumGreater){
		this.cssRegisteredNumGreater = cssRegisteredNumGreater;
		return this;
	}
	public Integer getCssRegisteredNumGreater(){
		return this.cssRegisteredNumGreater;
	}
	public CsStatisticsQuery setCssOnlineNumEquals(Integer cssOnlineNumEquals){
		this.cssOnlineNumEquals = cssOnlineNumEquals;
		return this;
	}
	public Integer getCssOnlineNumEquals(){
		return this.cssOnlineNumEquals;
	}
	public CsStatisticsQuery setCssOnlineNumIn(Integer[] cssOnlineNumIn){
		this.cssOnlineNumIn = cssOnlineNumIn;
		return this;
	}
	public Integer[] getCssOnlineNumIn(){
		return this.cssOnlineNumIn;
	}
	public CsStatisticsQuery setCssOnlineNumIsNull(Boolean cssOnlineNumIsNull){
		this.cssOnlineNumIsNull = cssOnlineNumIsNull;
		return this;
	}
	public Boolean getCssOnlineNumIsNull(){
		return this.cssOnlineNumIsNull;
	}
	public CsStatisticsQuery setCssOnlineNumIsNotNull(Boolean cssOnlineNumIsNotNull){
		this.cssOnlineNumIsNotNull = cssOnlineNumIsNotNull;
		return this;
	}
	public Boolean getCssOnlineNumIsNotNull(){
		return this.cssOnlineNumIsNotNull;
	}
	public CsStatisticsQuery setCssOnlineNumStart(Integer cssOnlineNumStart){
		this.cssOnlineNumStart = cssOnlineNumStart;
		return this;
	}
	public Integer getCssOnlineNumStart(){
		return this.cssOnlineNumStart;
	}
	public CsStatisticsQuery setCssOnlineNumEnd(Integer cssOnlineNumEnd){
		this.cssOnlineNumEnd = cssOnlineNumEnd;
		return this;
	}
	public Integer getCssOnlineNumEnd(){
		return this.cssOnlineNumEnd;
	}
	public CsStatisticsQuery setCssOnlineNumLess(Integer cssOnlineNumLess){
		this.cssOnlineNumLess = cssOnlineNumLess;
		return this;
	}
	public Integer getCssOnlineNumLess(){
		return this.cssOnlineNumLess;
	}
	public CsStatisticsQuery setCssOnlineNumGreater(Integer cssOnlineNumGreater){
		this.cssOnlineNumGreater = cssOnlineNumGreater;
		return this;
	}
	public Integer getCssOnlineNumGreater(){
		return this.cssOnlineNumGreater;
	}
	public CsStatisticsQuery setCssOfflineNumEquals(Integer cssOfflineNumEquals){
		this.cssOfflineNumEquals = cssOfflineNumEquals;
		return this;
	}
	public Integer getCssOfflineNumEquals(){
		return this.cssOfflineNumEquals;
	}
	public CsStatisticsQuery setCssOfflineNumIn(Integer[] cssOfflineNumIn){
		this.cssOfflineNumIn = cssOfflineNumIn;
		return this;
	}
	public Integer[] getCssOfflineNumIn(){
		return this.cssOfflineNumIn;
	}
	public CsStatisticsQuery setCssOfflineNumIsNull(Boolean cssOfflineNumIsNull){
		this.cssOfflineNumIsNull = cssOfflineNumIsNull;
		return this;
	}
	public Boolean getCssOfflineNumIsNull(){
		return this.cssOfflineNumIsNull;
	}
	public CsStatisticsQuery setCssOfflineNumIsNotNull(Boolean cssOfflineNumIsNotNull){
		this.cssOfflineNumIsNotNull = cssOfflineNumIsNotNull;
		return this;
	}
	public Boolean getCssOfflineNumIsNotNull(){
		return this.cssOfflineNumIsNotNull;
	}
	public CsStatisticsQuery setCssOfflineNumStart(Integer cssOfflineNumStart){
		this.cssOfflineNumStart = cssOfflineNumStart;
		return this;
	}
	public Integer getCssOfflineNumStart(){
		return this.cssOfflineNumStart;
	}
	public CsStatisticsQuery setCssOfflineNumEnd(Integer cssOfflineNumEnd){
		this.cssOfflineNumEnd = cssOfflineNumEnd;
		return this;
	}
	public Integer getCssOfflineNumEnd(){
		return this.cssOfflineNumEnd;
	}
	public CsStatisticsQuery setCssOfflineNumLess(Integer cssOfflineNumLess){
		this.cssOfflineNumLess = cssOfflineNumLess;
		return this;
	}
	public Integer getCssOfflineNumLess(){
		return this.cssOfflineNumLess;
	}
	public CsStatisticsQuery setCssOfflineNumGreater(Integer cssOfflineNumGreater){
		this.cssOfflineNumGreater = cssOfflineNumGreater;
		return this;
	}
	public Integer getCssOfflineNumGreater(){
		return this.cssOfflineNumGreater;
	}
	public CsStatisticsQuery setCssRunNumEquals(Integer cssRunNumEquals){
		this.cssRunNumEquals = cssRunNumEquals;
		return this;
	}
	public Integer getCssRunNumEquals(){
		return this.cssRunNumEquals;
	}
	public CsStatisticsQuery setCssRunNumIn(Integer[] cssRunNumIn){
		this.cssRunNumIn = cssRunNumIn;
		return this;
	}
	public Integer[] getCssRunNumIn(){
		return this.cssRunNumIn;
	}
	public CsStatisticsQuery setCssRunNumIsNull(Boolean cssRunNumIsNull){
		this.cssRunNumIsNull = cssRunNumIsNull;
		return this;
	}
	public Boolean getCssRunNumIsNull(){
		return this.cssRunNumIsNull;
	}
	public CsStatisticsQuery setCssRunNumIsNotNull(Boolean cssRunNumIsNotNull){
		this.cssRunNumIsNotNull = cssRunNumIsNotNull;
		return this;
	}
	public Boolean getCssRunNumIsNotNull(){
		return this.cssRunNumIsNotNull;
	}
	public CsStatisticsQuery setCssRunNumStart(Integer cssRunNumStart){
		this.cssRunNumStart = cssRunNumStart;
		return this;
	}
	public Integer getCssRunNumStart(){
		return this.cssRunNumStart;
	}
	public CsStatisticsQuery setCssRunNumEnd(Integer cssRunNumEnd){
		this.cssRunNumEnd = cssRunNumEnd;
		return this;
	}
	public Integer getCssRunNumEnd(){
		return this.cssRunNumEnd;
	}
	public CsStatisticsQuery setCssRunNumLess(Integer cssRunNumLess){
		this.cssRunNumLess = cssRunNumLess;
		return this;
	}
	public Integer getCssRunNumLess(){
		return this.cssRunNumLess;
	}
	public CsStatisticsQuery setCssRunNumGreater(Integer cssRunNumGreater){
		this.cssRunNumGreater = cssRunNumGreater;
		return this;
	}
	public Integer getCssRunNumGreater(){
		return this.cssRunNumGreater;
	}
	public CsStatisticsQuery setCssChargingNumEquals(Integer cssChargingNumEquals){
		this.cssChargingNumEquals = cssChargingNumEquals;
		return this;
	}
	public Integer getCssChargingNumEquals(){
		return this.cssChargingNumEquals;
	}
	public CsStatisticsQuery setCssChargingNumIn(Integer[] cssChargingNumIn){
		this.cssChargingNumIn = cssChargingNumIn;
		return this;
	}
	public Integer[] getCssChargingNumIn(){
		return this.cssChargingNumIn;
	}
	public CsStatisticsQuery setCssChargingNumIsNull(Boolean cssChargingNumIsNull){
		this.cssChargingNumIsNull = cssChargingNumIsNull;
		return this;
	}
	public Boolean getCssChargingNumIsNull(){
		return this.cssChargingNumIsNull;
	}
	public CsStatisticsQuery setCssChargingNumIsNotNull(Boolean cssChargingNumIsNotNull){
		this.cssChargingNumIsNotNull = cssChargingNumIsNotNull;
		return this;
	}
	public Boolean getCssChargingNumIsNotNull(){
		return this.cssChargingNumIsNotNull;
	}
	public CsStatisticsQuery setCssChargingNumStart(Integer cssChargingNumStart){
		this.cssChargingNumStart = cssChargingNumStart;
		return this;
	}
	public Integer getCssChargingNumStart(){
		return this.cssChargingNumStart;
	}
	public CsStatisticsQuery setCssChargingNumEnd(Integer cssChargingNumEnd){
		this.cssChargingNumEnd = cssChargingNumEnd;
		return this;
	}
	public Integer getCssChargingNumEnd(){
		return this.cssChargingNumEnd;
	}
	public CsStatisticsQuery setCssChargingNumLess(Integer cssChargingNumLess){
		this.cssChargingNumLess = cssChargingNumLess;
		return this;
	}
	public Integer getCssChargingNumLess(){
		return this.cssChargingNumLess;
	}
	public CsStatisticsQuery setCssChargingNumGreater(Integer cssChargingNumGreater){
		this.cssChargingNumGreater = cssChargingNumGreater;
		return this;
	}
	public Integer getCssChargingNumGreater(){
		return this.cssChargingNumGreater;
	}
	public CsStatisticsQuery setCssTotalMileageEquals(Float cssTotalMileageEquals){
		this.cssTotalMileageEquals = cssTotalMileageEquals;
		return this;
	}
	public Float getCssTotalMileageEquals(){
		return this.cssTotalMileageEquals;
	}
	public CsStatisticsQuery setCssTotalMileageIn(Float[] cssTotalMileageIn){
		this.cssTotalMileageIn = cssTotalMileageIn;
		return this;
	}
	public Float[] getCssTotalMileageIn(){
		return this.cssTotalMileageIn;
	}
	public CsStatisticsQuery setCssTotalMileageIsNull(Boolean cssTotalMileageIsNull){
		this.cssTotalMileageIsNull = cssTotalMileageIsNull;
		return this;
	}
	public Boolean getCssTotalMileageIsNull(){
		return this.cssTotalMileageIsNull;
	}
	public CsStatisticsQuery setCssTotalMileageIsNotNull(Boolean cssTotalMileageIsNotNull){
		this.cssTotalMileageIsNotNull = cssTotalMileageIsNotNull;
		return this;
	}
	public Boolean getCssTotalMileageIsNotNull(){
		return this.cssTotalMileageIsNotNull;
	}
	public CsStatisticsQuery setCssTotalMileageStart(Float cssTotalMileageStart){
		this.cssTotalMileageStart = cssTotalMileageStart;
		return this;
	}
	public Float getCssTotalMileageStart(){
		return this.cssTotalMileageStart;
	}
	public CsStatisticsQuery setCssTotalMileageEnd(Float cssTotalMileageEnd){
		this.cssTotalMileageEnd = cssTotalMileageEnd;
		return this;
	}
	public Float getCssTotalMileageEnd(){
		return this.cssTotalMileageEnd;
	}
	public CsStatisticsQuery setCssTotalMileageLess(Float cssTotalMileageLess){
		this.cssTotalMileageLess = cssTotalMileageLess;
		return this;
	}
	public Float getCssTotalMileageLess(){
		return this.cssTotalMileageLess;
	}
	public CsStatisticsQuery setCssTotalMileageGreater(Float cssTotalMileageGreater){
		this.cssTotalMileageGreater = cssTotalMileageGreater;
		return this;
	}
	public Float getCssTotalMileageGreater(){
		return this.cssTotalMileageGreater;
	}
	public CsStatisticsQuery setCssTotalChargeEquals(Float cssTotalChargeEquals){
		this.cssTotalChargeEquals = cssTotalChargeEquals;
		return this;
	}
	public Float getCssTotalChargeEquals(){
		return this.cssTotalChargeEquals;
	}
	public CsStatisticsQuery setCssTotalChargeIn(Float[] cssTotalChargeIn){
		this.cssTotalChargeIn = cssTotalChargeIn;
		return this;
	}
	public Float[] getCssTotalChargeIn(){
		return this.cssTotalChargeIn;
	}
	public CsStatisticsQuery setCssTotalChargeIsNull(Boolean cssTotalChargeIsNull){
		this.cssTotalChargeIsNull = cssTotalChargeIsNull;
		return this;
	}
	public Boolean getCssTotalChargeIsNull(){
		return this.cssTotalChargeIsNull;
	}
	public CsStatisticsQuery setCssTotalChargeIsNotNull(Boolean cssTotalChargeIsNotNull){
		this.cssTotalChargeIsNotNull = cssTotalChargeIsNotNull;
		return this;
	}
	public Boolean getCssTotalChargeIsNotNull(){
		return this.cssTotalChargeIsNotNull;
	}
	public CsStatisticsQuery setCssTotalChargeStart(Float cssTotalChargeStart){
		this.cssTotalChargeStart = cssTotalChargeStart;
		return this;
	}
	public Float getCssTotalChargeStart(){
		return this.cssTotalChargeStart;
	}
	public CsStatisticsQuery setCssTotalChargeEnd(Float cssTotalChargeEnd){
		this.cssTotalChargeEnd = cssTotalChargeEnd;
		return this;
	}
	public Float getCssTotalChargeEnd(){
		return this.cssTotalChargeEnd;
	}
	public CsStatisticsQuery setCssTotalChargeLess(Float cssTotalChargeLess){
		this.cssTotalChargeLess = cssTotalChargeLess;
		return this;
	}
	public Float getCssTotalChargeLess(){
		return this.cssTotalChargeLess;
	}
	public CsStatisticsQuery setCssTotalChargeGreater(Float cssTotalChargeGreater){
		this.cssTotalChargeGreater = cssTotalChargeGreater;
		return this;
	}
	public Float getCssTotalChargeGreater(){
		return this.cssTotalChargeGreater;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionEquals(Float cssTotalPowerConsumptionEquals){
		this.cssTotalPowerConsumptionEquals = cssTotalPowerConsumptionEquals;
		return this;
	}
	public Float getCssTotalPowerConsumptionEquals(){
		return this.cssTotalPowerConsumptionEquals;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionIn(Float[] cssTotalPowerConsumptionIn){
		this.cssTotalPowerConsumptionIn = cssTotalPowerConsumptionIn;
		return this;
	}
	public Float[] getCssTotalPowerConsumptionIn(){
		return this.cssTotalPowerConsumptionIn;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionIsNull(Boolean cssTotalPowerConsumptionIsNull){
		this.cssTotalPowerConsumptionIsNull = cssTotalPowerConsumptionIsNull;
		return this;
	}
	public Boolean getCssTotalPowerConsumptionIsNull(){
		return this.cssTotalPowerConsumptionIsNull;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionIsNotNull(Boolean cssTotalPowerConsumptionIsNotNull){
		this.cssTotalPowerConsumptionIsNotNull = cssTotalPowerConsumptionIsNotNull;
		return this;
	}
	public Boolean getCssTotalPowerConsumptionIsNotNull(){
		return this.cssTotalPowerConsumptionIsNotNull;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionStart(Float cssTotalPowerConsumptionStart){
		this.cssTotalPowerConsumptionStart = cssTotalPowerConsumptionStart;
		return this;
	}
	public Float getCssTotalPowerConsumptionStart(){
		return this.cssTotalPowerConsumptionStart;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionEnd(Float cssTotalPowerConsumptionEnd){
		this.cssTotalPowerConsumptionEnd = cssTotalPowerConsumptionEnd;
		return this;
	}
	public Float getCssTotalPowerConsumptionEnd(){
		return this.cssTotalPowerConsumptionEnd;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionLess(Float cssTotalPowerConsumptionLess){
		this.cssTotalPowerConsumptionLess = cssTotalPowerConsumptionLess;
		return this;
	}
	public Float getCssTotalPowerConsumptionLess(){
		return this.cssTotalPowerConsumptionLess;
	}
	public CsStatisticsQuery setCssTotalPowerConsumptionGreater(Float cssTotalPowerConsumptionGreater){
		this.cssTotalPowerConsumptionGreater = cssTotalPowerConsumptionGreater;
		return this;
	}
	public Float getCssTotalPowerConsumptionGreater(){
		return this.cssTotalPowerConsumptionGreater;
	}
	public CsStatisticsQuery setCssTotalRunTimeEquals(Long cssTotalRunTimeEquals){
		this.cssTotalRunTimeEquals = cssTotalRunTimeEquals;
		return this;
	}
	public Long getCssTotalRunTimeEquals(){
		return this.cssTotalRunTimeEquals;
	}
	public CsStatisticsQuery setCssTotalRunTimeIn(Long[] cssTotalRunTimeIn){
		this.cssTotalRunTimeIn = cssTotalRunTimeIn;
		return this;
	}
	public Long[] getCssTotalRunTimeIn(){
		return this.cssTotalRunTimeIn;
	}
	public CsStatisticsQuery setCssTotalRunTimeIsNull(Boolean cssTotalRunTimeIsNull){
		this.cssTotalRunTimeIsNull = cssTotalRunTimeIsNull;
		return this;
	}
	public Boolean getCssTotalRunTimeIsNull(){
		return this.cssTotalRunTimeIsNull;
	}
	public CsStatisticsQuery setCssTotalRunTimeIsNotNull(Boolean cssTotalRunTimeIsNotNull){
		this.cssTotalRunTimeIsNotNull = cssTotalRunTimeIsNotNull;
		return this;
	}
	public Boolean getCssTotalRunTimeIsNotNull(){
		return this.cssTotalRunTimeIsNotNull;
	}
	public CsStatisticsQuery setCssTotalRunTimeStart(Long cssTotalRunTimeStart){
		this.cssTotalRunTimeStart = cssTotalRunTimeStart;
		return this;
	}
	public Long getCssTotalRunTimeStart(){
		return this.cssTotalRunTimeStart;
	}
	public CsStatisticsQuery setCssTotalRunTimeEnd(Long cssTotalRunTimeEnd){
		this.cssTotalRunTimeEnd = cssTotalRunTimeEnd;
		return this;
	}
	public Long getCssTotalRunTimeEnd(){
		return this.cssTotalRunTimeEnd;
	}
	public CsStatisticsQuery setCssTotalRunTimeLess(Long cssTotalRunTimeLess){
		this.cssTotalRunTimeLess = cssTotalRunTimeLess;
		return this;
	}
	public Long getCssTotalRunTimeLess(){
		return this.cssTotalRunTimeLess;
	}
	public CsStatisticsQuery setCssTotalRunTimeGreater(Long cssTotalRunTimeGreater){
		this.cssTotalRunTimeGreater = cssTotalRunTimeGreater;
		return this;
	}
	public Long getCssTotalRunTimeGreater(){
		return this.cssTotalRunTimeGreater;
	}
	public CsStatisticsQuery setCssIncrementMileageEquals(Long cssIncrementMileageEquals){
		this.cssIncrementMileageEquals = cssIncrementMileageEquals;
		return this;
	}
	public Long getCssIncrementMileageEquals(){
		return this.cssIncrementMileageEquals;
	}
	public CsStatisticsQuery setCssIncrementMileageIn(Long[] cssIncrementMileageIn){
		this.cssIncrementMileageIn = cssIncrementMileageIn;
		return this;
	}
	public Long[] getCssIncrementMileageIn(){
		return this.cssIncrementMileageIn;
	}
	public CsStatisticsQuery setCssIncrementMileageIsNull(Boolean cssIncrementMileageIsNull){
		this.cssIncrementMileageIsNull = cssIncrementMileageIsNull;
		return this;
	}
	public Boolean getCssIncrementMileageIsNull(){
		return this.cssIncrementMileageIsNull;
	}
	public CsStatisticsQuery setCssIncrementMileageIsNotNull(Boolean cssIncrementMileageIsNotNull){
		this.cssIncrementMileageIsNotNull = cssIncrementMileageIsNotNull;
		return this;
	}
	public Boolean getCssIncrementMileageIsNotNull(){
		return this.cssIncrementMileageIsNotNull;
	}
	public CsStatisticsQuery setCssIncrementMileageStart(Long cssIncrementMileageStart){
		this.cssIncrementMileageStart = cssIncrementMileageStart;
		return this;
	}
	public Long getCssIncrementMileageStart(){
		return this.cssIncrementMileageStart;
	}
	public CsStatisticsQuery setCssIncrementMileageEnd(Long cssIncrementMileageEnd){
		this.cssIncrementMileageEnd = cssIncrementMileageEnd;
		return this;
	}
	public Long getCssIncrementMileageEnd(){
		return this.cssIncrementMileageEnd;
	}
	public CsStatisticsQuery setCssIncrementMileageLess(Long cssIncrementMileageLess){
		this.cssIncrementMileageLess = cssIncrementMileageLess;
		return this;
	}
	public Long getCssIncrementMileageLess(){
		return this.cssIncrementMileageLess;
	}
	public CsStatisticsQuery setCssIncrementMileageGreater(Long cssIncrementMileageGreater){
		this.cssIncrementMileageGreater = cssIncrementMileageGreater;
		return this;
	}
	public Long getCssIncrementMileageGreater(){
		return this.cssIncrementMileageGreater;
	}
	public CsStatisticsQuery setCssAccessEquals(Integer cssAccessEquals){
		this.cssAccessEquals = cssAccessEquals;
		return this;
	}
	public Integer getCssAccessEquals(){
		return this.cssAccessEquals;
	}
	public CsStatisticsQuery setCssAccessIn(Integer[] cssAccessIn){
		this.cssAccessIn = cssAccessIn;
		return this;
	}
	public Integer[] getCssAccessIn(){
		return this.cssAccessIn;
	}
	public CsStatisticsQuery setCssAccessIsNull(Boolean cssAccessIsNull){
		this.cssAccessIsNull = cssAccessIsNull;
		return this;
	}
	public Boolean getCssAccessIsNull(){
		return this.cssAccessIsNull;
	}
	public CsStatisticsQuery setCssAccessIsNotNull(Boolean cssAccessIsNotNull){
		this.cssAccessIsNotNull = cssAccessIsNotNull;
		return this;
	}
	public Boolean getCssAccessIsNotNull(){
		return this.cssAccessIsNotNull;
	}
	public CsStatisticsQuery setCssAccessStart(Integer cssAccessStart){
		this.cssAccessStart = cssAccessStart;
		return this;
	}
	public Integer getCssAccessStart(){
		return this.cssAccessStart;
	}
	public CsStatisticsQuery setCssAccessEnd(Integer cssAccessEnd){
		this.cssAccessEnd = cssAccessEnd;
		return this;
	}
	public Integer getCssAccessEnd(){
		return this.cssAccessEnd;
	}
	public CsStatisticsQuery setCssAccessLess(Integer cssAccessLess){
		this.cssAccessLess = cssAccessLess;
		return this;
	}
	public Integer getCssAccessLess(){
		return this.cssAccessLess;
	}
	public CsStatisticsQuery setCssAccessGreater(Integer cssAccessGreater){
		this.cssAccessGreater = cssAccessGreater;
		return this;
	}
	public Integer getCssAccessGreater(){
		return this.cssAccessGreater;
	}
	public CsStatisticsQuery setCssCarModelEquals(Integer cssCarModelEquals){
		this.cssCarModelEquals = cssCarModelEquals;
		return this;
	}
	public Integer getCssCarModelEquals(){
		return this.cssCarModelEquals;
	}
	public CsStatisticsQuery setCssCarModelIn(Integer[] cssCarModelIn){
		this.cssCarModelIn = cssCarModelIn;
		return this;
	}
	public Integer[] getCssCarModelIn(){
		return this.cssCarModelIn;
	}
	public CsStatisticsQuery setCssCarModelIsNull(Boolean cssCarModelIsNull){
		this.cssCarModelIsNull = cssCarModelIsNull;
		return this;
	}
	public Boolean getCssCarModelIsNull(){
		return this.cssCarModelIsNull;
	}
	public CsStatisticsQuery setCssCarModelIsNotNull(Boolean cssCarModelIsNotNull){
		this.cssCarModelIsNotNull = cssCarModelIsNotNull;
		return this;
	}
	public Boolean getCssCarModelIsNotNull(){
		return this.cssCarModelIsNotNull;
	}
	public CsStatisticsQuery setCssCarModelStart(Integer cssCarModelStart){
		this.cssCarModelStart = cssCarModelStart;
		return this;
	}
	public Integer getCssCarModelStart(){
		return this.cssCarModelStart;
	}
	public CsStatisticsQuery setCssCarModelEnd(Integer cssCarModelEnd){
		this.cssCarModelEnd = cssCarModelEnd;
		return this;
	}
	public Integer getCssCarModelEnd(){
		return this.cssCarModelEnd;
	}
	public CsStatisticsQuery setCssCarModelLess(Integer cssCarModelLess){
		this.cssCarModelLess = cssCarModelLess;
		return this;
	}
	public Integer getCssCarModelLess(){
		return this.cssCarModelLess;
	}
	public CsStatisticsQuery setCssCarModelGreater(Integer cssCarModelGreater){
		this.cssCarModelGreater = cssCarModelGreater;
		return this;
	}
	public Integer getCssCarModelGreater(){
		return this.cssCarModelGreater;
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
		else if(this.sidx.equals("cssTime")){
			return "css_time";
		}
		else if(this.sidx.equals("cssUnitTime")){
			return "css_unit_time";
		}
		else if(this.sidx.equals("cssRegisteredNum")){
			return "css_registered_num";
		}
		else if(this.sidx.equals("cssOnlineNum")){
			return "css_online_num";
		}
		else if(this.sidx.equals("cssOfflineNum")){
			return "css_offline_num";
		}
		else if(this.sidx.equals("cssRunNum")){
			return "css_run_num";
		}
		else if(this.sidx.equals("cssChargingNum")){
			return "css_charging_num";
		}
		else if(this.sidx.equals("cssTotalMileage")){
			return "css_total_mileage";
		}
		else if(this.sidx.equals("cssTotalCharge")){
			return "css_total_charge";
		}
		else if(this.sidx.equals("cssTotalPowerConsumption")){
			return "css_total_power_consumption";
		}
		else if(this.sidx.equals("cssTotalRunTime")){
			return "css_total_run_time";
		}
		else if(this.sidx.equals("cssIncrementMileage")){
			return "css_increment_mileage";
		}
		else if(this.sidx.equals("cssAccess")){
			return "css_access";
		}
		else if(this.sidx.equals("cssCarModel")){
			return "css_car_model";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsStatisticsCrieria getCrieria(){
		CsStatisticsCrieria q = new CsStatisticsCrieria();
		CsStatisticsCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getCssTimeEquals()!=null){
			c.andcssTimeEqualTo(this.getCssTimeEquals());
		}else if(this.getCssTimeIsNull()!=null && this.getCssTimeIsNull()){
			c.andcssTimeIsNull();
		}else if(this.getCssTimeIsNotNull()!=null && this.getCssTimeIsNotNull()){
			c.andcssTimeIsNotNull();
		}else if(this.getCssTimeIn()!=null){
			c.andcssTimeIn(java.util.Arrays.asList(this.getCssTimeIn()));
		}else if(this.getCssTimeStart()!=null && this.getCssTimeEnd()!=null){
			c.andcssTimeBetween(this.getCssTimeStart(), this.getCssTimeEnd());
		}else if(this.getCssTimeGreater()!=null){
			c.andcssTimeGreaterThan(this.getCssTimeGreater());
		}else if(this.getCssTimeLess()!=null){
			c.andcssTimeLessThan(this.getCssTimeLess());
		}
		if(this.getCssUnitTimeEquals()!=null){
			c.andcssUnitTimeEqualTo(this.getCssUnitTimeEquals());
		}else if(this.getCssUnitTimeIsNull()!=null && this.getCssUnitTimeIsNull()){
			c.andcssUnitTimeIsNull();
		}else if(this.getCssUnitTimeIsNotNull()!=null && this.getCssUnitTimeIsNotNull()){
			c.andcssUnitTimeIsNotNull();
		}else if(this.getCssUnitTimeIn()!=null){
			c.andcssUnitTimeIn(java.util.Arrays.asList(this.getCssUnitTimeIn()));
		}else if(this.getCssUnitTimeStart()!=null && this.getCssUnitTimeEnd()!=null){
			c.andcssUnitTimeBetween(this.getCssUnitTimeStart(), this.getCssUnitTimeEnd());
		}else if(this.getCssUnitTimeGreater()!=null){
			c.andcssUnitTimeGreaterThan(this.getCssUnitTimeGreater());
		}else if(this.getCssUnitTimeLess()!=null){
			c.andcssUnitTimeLessThan(this.getCssUnitTimeLess());
		}
		if(this.getCssRegisteredNumEquals()!=null){
			c.andcssRegisteredNumEqualTo(this.getCssRegisteredNumEquals());
		}else if(this.getCssRegisteredNumIsNull()!=null && this.getCssRegisteredNumIsNull()){
			c.andcssRegisteredNumIsNull();
		}else if(this.getCssRegisteredNumIsNotNull()!=null && this.getCssRegisteredNumIsNotNull()){
			c.andcssRegisteredNumIsNotNull();
		}else if(this.getCssRegisteredNumIn()!=null){
			c.andcssRegisteredNumIn(java.util.Arrays.asList(this.getCssRegisteredNumIn()));
		}else if(this.getCssRegisteredNumStart()!=null && this.getCssRegisteredNumEnd()!=null){
			c.andcssRegisteredNumBetween(this.getCssRegisteredNumStart(), this.getCssRegisteredNumEnd());
		}else if(this.getCssRegisteredNumGreater()!=null){
			c.andcssRegisteredNumGreaterThan(this.getCssRegisteredNumGreater());
		}else if(this.getCssRegisteredNumLess()!=null){
			c.andcssRegisteredNumLessThan(this.getCssRegisteredNumLess());
		}
		if(this.getCssOnlineNumEquals()!=null){
			c.andcssOnlineNumEqualTo(this.getCssOnlineNumEquals());
		}else if(this.getCssOnlineNumIsNull()!=null && this.getCssOnlineNumIsNull()){
			c.andcssOnlineNumIsNull();
		}else if(this.getCssOnlineNumIsNotNull()!=null && this.getCssOnlineNumIsNotNull()){
			c.andcssOnlineNumIsNotNull();
		}else if(this.getCssOnlineNumIn()!=null){
			c.andcssOnlineNumIn(java.util.Arrays.asList(this.getCssOnlineNumIn()));
		}else if(this.getCssOnlineNumStart()!=null && this.getCssOnlineNumEnd()!=null){
			c.andcssOnlineNumBetween(this.getCssOnlineNumStart(), this.getCssOnlineNumEnd());
		}else if(this.getCssOnlineNumGreater()!=null){
			c.andcssOnlineNumGreaterThan(this.getCssOnlineNumGreater());
		}else if(this.getCssOnlineNumLess()!=null){
			c.andcssOnlineNumLessThan(this.getCssOnlineNumLess());
		}
		if(this.getCssOfflineNumEquals()!=null){
			c.andcssOfflineNumEqualTo(this.getCssOfflineNumEquals());
		}else if(this.getCssOfflineNumIsNull()!=null && this.getCssOfflineNumIsNull()){
			c.andcssOfflineNumIsNull();
		}else if(this.getCssOfflineNumIsNotNull()!=null && this.getCssOfflineNumIsNotNull()){
			c.andcssOfflineNumIsNotNull();
		}else if(this.getCssOfflineNumIn()!=null){
			c.andcssOfflineNumIn(java.util.Arrays.asList(this.getCssOfflineNumIn()));
		}else if(this.getCssOfflineNumStart()!=null && this.getCssOfflineNumEnd()!=null){
			c.andcssOfflineNumBetween(this.getCssOfflineNumStart(), this.getCssOfflineNumEnd());
		}else if(this.getCssOfflineNumGreater()!=null){
			c.andcssOfflineNumGreaterThan(this.getCssOfflineNumGreater());
		}else if(this.getCssOfflineNumLess()!=null){
			c.andcssOfflineNumLessThan(this.getCssOfflineNumLess());
		}
		if(this.getCssRunNumEquals()!=null){
			c.andcssRunNumEqualTo(this.getCssRunNumEquals());
		}else if(this.getCssRunNumIsNull()!=null && this.getCssRunNumIsNull()){
			c.andcssRunNumIsNull();
		}else if(this.getCssRunNumIsNotNull()!=null && this.getCssRunNumIsNotNull()){
			c.andcssRunNumIsNotNull();
		}else if(this.getCssRunNumIn()!=null){
			c.andcssRunNumIn(java.util.Arrays.asList(this.getCssRunNumIn()));
		}else if(this.getCssRunNumStart()!=null && this.getCssRunNumEnd()!=null){
			c.andcssRunNumBetween(this.getCssRunNumStart(), this.getCssRunNumEnd());
		}else if(this.getCssRunNumGreater()!=null){
			c.andcssRunNumGreaterThan(this.getCssRunNumGreater());
		}else if(this.getCssRunNumLess()!=null){
			c.andcssRunNumLessThan(this.getCssRunNumLess());
		}
		if(this.getCssChargingNumEquals()!=null){
			c.andcssChargingNumEqualTo(this.getCssChargingNumEquals());
		}else if(this.getCssChargingNumIsNull()!=null && this.getCssChargingNumIsNull()){
			c.andcssChargingNumIsNull();
		}else if(this.getCssChargingNumIsNotNull()!=null && this.getCssChargingNumIsNotNull()){
			c.andcssChargingNumIsNotNull();
		}else if(this.getCssChargingNumIn()!=null){
			c.andcssChargingNumIn(java.util.Arrays.asList(this.getCssChargingNumIn()));
		}else if(this.getCssChargingNumStart()!=null && this.getCssChargingNumEnd()!=null){
			c.andcssChargingNumBetween(this.getCssChargingNumStart(), this.getCssChargingNumEnd());
		}else if(this.getCssChargingNumGreater()!=null){
			c.andcssChargingNumGreaterThan(this.getCssChargingNumGreater());
		}else if(this.getCssChargingNumLess()!=null){
			c.andcssChargingNumLessThan(this.getCssChargingNumLess());
		}
		if(this.getCssTotalMileageEquals()!=null){
			c.andcssTotalMileageEqualTo(this.getCssTotalMileageEquals());
		}else if(this.getCssTotalMileageIsNull()!=null && this.getCssTotalMileageIsNull()){
			c.andcssTotalMileageIsNull();
		}else if(this.getCssTotalMileageIsNotNull()!=null && this.getCssTotalMileageIsNotNull()){
			c.andcssTotalMileageIsNotNull();
		}else if(this.getCssTotalMileageIn()!=null){
			c.andcssTotalMileageIn(java.util.Arrays.asList(this.getCssTotalMileageIn()));
		}else if(this.getCssTotalMileageStart()!=null && this.getCssTotalMileageEnd()!=null){
			c.andcssTotalMileageBetween(this.getCssTotalMileageStart(), this.getCssTotalMileageEnd());
		}else if(this.getCssTotalMileageGreater()!=null){
			c.andcssTotalMileageGreaterThan(this.getCssTotalMileageGreater());
		}else if(this.getCssTotalMileageLess()!=null){
			c.andcssTotalMileageLessThan(this.getCssTotalMileageLess());
		}
		if(this.getCssTotalChargeEquals()!=null){
			c.andcssTotalChargeEqualTo(this.getCssTotalChargeEquals());
		}else if(this.getCssTotalChargeIsNull()!=null && this.getCssTotalChargeIsNull()){
			c.andcssTotalChargeIsNull();
		}else if(this.getCssTotalChargeIsNotNull()!=null && this.getCssTotalChargeIsNotNull()){
			c.andcssTotalChargeIsNotNull();
		}else if(this.getCssTotalChargeIn()!=null){
			c.andcssTotalChargeIn(java.util.Arrays.asList(this.getCssTotalChargeIn()));
		}else if(this.getCssTotalChargeStart()!=null && this.getCssTotalChargeEnd()!=null){
			c.andcssTotalChargeBetween(this.getCssTotalChargeStart(), this.getCssTotalChargeEnd());
		}else if(this.getCssTotalChargeGreater()!=null){
			c.andcssTotalChargeGreaterThan(this.getCssTotalChargeGreater());
		}else if(this.getCssTotalChargeLess()!=null){
			c.andcssTotalChargeLessThan(this.getCssTotalChargeLess());
		}
		if(this.getCssTotalPowerConsumptionEquals()!=null){
			c.andcssTotalPowerConsumptionEqualTo(this.getCssTotalPowerConsumptionEquals());
		}else if(this.getCssTotalPowerConsumptionIsNull()!=null && this.getCssTotalPowerConsumptionIsNull()){
			c.andcssTotalPowerConsumptionIsNull();
		}else if(this.getCssTotalPowerConsumptionIsNotNull()!=null && this.getCssTotalPowerConsumptionIsNotNull()){
			c.andcssTotalPowerConsumptionIsNotNull();
		}else if(this.getCssTotalPowerConsumptionIn()!=null){
			c.andcssTotalPowerConsumptionIn(java.util.Arrays.asList(this.getCssTotalPowerConsumptionIn()));
		}else if(this.getCssTotalPowerConsumptionStart()!=null && this.getCssTotalPowerConsumptionEnd()!=null){
			c.andcssTotalPowerConsumptionBetween(this.getCssTotalPowerConsumptionStart(), this.getCssTotalPowerConsumptionEnd());
		}else if(this.getCssTotalPowerConsumptionGreater()!=null){
			c.andcssTotalPowerConsumptionGreaterThan(this.getCssTotalPowerConsumptionGreater());
		}else if(this.getCssTotalPowerConsumptionLess()!=null){
			c.andcssTotalPowerConsumptionLessThan(this.getCssTotalPowerConsumptionLess());
		}
		if(this.getCssTotalRunTimeEquals()!=null){
			c.andcssTotalRunTimeEqualTo(this.getCssTotalRunTimeEquals());
		}else if(this.getCssTotalRunTimeIsNull()!=null && this.getCssTotalRunTimeIsNull()){
			c.andcssTotalRunTimeIsNull();
		}else if(this.getCssTotalRunTimeIsNotNull()!=null && this.getCssTotalRunTimeIsNotNull()){
			c.andcssTotalRunTimeIsNotNull();
		}else if(this.getCssTotalRunTimeIn()!=null){
			c.andcssTotalRunTimeIn(java.util.Arrays.asList(this.getCssTotalRunTimeIn()));
		}else if(this.getCssTotalRunTimeStart()!=null && this.getCssTotalRunTimeEnd()!=null){
			c.andcssTotalRunTimeBetween(this.getCssTotalRunTimeStart(), this.getCssTotalRunTimeEnd());
		}else if(this.getCssTotalRunTimeGreater()!=null){
			c.andcssTotalRunTimeGreaterThan(this.getCssTotalRunTimeGreater());
		}else if(this.getCssTotalRunTimeLess()!=null){
			c.andcssTotalRunTimeLessThan(this.getCssTotalRunTimeLess());
		}
		if(this.getCssIncrementMileageEquals()!=null){
			c.andcssIncrementMileageEqualTo(this.getCssIncrementMileageEquals());
		}else if(this.getCssIncrementMileageIsNull()!=null && this.getCssIncrementMileageIsNull()){
			c.andcssIncrementMileageIsNull();
		}else if(this.getCssIncrementMileageIsNotNull()!=null && this.getCssIncrementMileageIsNotNull()){
			c.andcssIncrementMileageIsNotNull();
		}else if(this.getCssIncrementMileageIn()!=null){
			c.andcssIncrementMileageIn(java.util.Arrays.asList(this.getCssIncrementMileageIn()));
		}else if(this.getCssIncrementMileageStart()!=null && this.getCssIncrementMileageEnd()!=null){
			c.andcssIncrementMileageBetween(this.getCssIncrementMileageStart(), this.getCssIncrementMileageEnd());
		}else if(this.getCssIncrementMileageGreater()!=null){
			c.andcssIncrementMileageGreaterThan(this.getCssIncrementMileageGreater());
		}else if(this.getCssIncrementMileageLess()!=null){
			c.andcssIncrementMileageLessThan(this.getCssIncrementMileageLess());
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
		if(this.getCssCarModelEquals()!=null){
			c.andcssCarModelEqualTo(this.getCssCarModelEquals());
		}else if(this.getCssCarModelIsNull()!=null && this.getCssCarModelIsNull()){
			c.andcssCarModelIsNull();
		}else if(this.getCssCarModelIsNotNull()!=null && this.getCssCarModelIsNotNull()){
			c.andcssCarModelIsNotNull();
		}else if(this.getCssCarModelIn()!=null){
			c.andcssCarModelIn(java.util.Arrays.asList(this.getCssCarModelIn()));
		}else if(this.getCssCarModelStart()!=null && this.getCssCarModelEnd()!=null){
			c.andcssCarModelBetween(this.getCssCarModelStart(), this.getCssCarModelEnd());
		}else if(this.getCssCarModelGreater()!=null){
			c.andcssCarModelGreaterThan(this.getCssCarModelGreater());
		}else if(this.getCssCarModelLess()!=null){
			c.andcssCarModelLessThan(this.getCssCarModelLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
