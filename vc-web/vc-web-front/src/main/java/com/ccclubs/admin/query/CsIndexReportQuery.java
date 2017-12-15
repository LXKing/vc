package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsIndexReportCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsIndexReportQuery {
	
	private Long idEquals;
	private Long[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Long idStart;
	
	private Long idEnd;
	
	private Long idLess;
	
	private Long idGreater;
	private String csVinLike;
	
	private String csVinEquals;
	private String[] csVinIn;
	private Boolean csVinIsNull;
	private Boolean csVinIsNotNull;
	
	private String csVinStart;
	
	private String csVinEnd;
	
	private String csVinLess;
	
	private String csVinGreater;
	private String csNumberLike;
	
	private String csNumberEquals;
	private String[] csNumberIn;
	private Boolean csNumberIsNull;
	private Boolean csNumberIsNotNull;
	
	private String csNumberStart;
	
	private String csNumberEnd;
	
	private String csNumberLess;
	
	private String csNumberGreater;
	
	private Double monthlyAvgMileEquals;
	private Double[] monthlyAvgMileIn;
	private Boolean monthlyAvgMileIsNull;
	private Boolean monthlyAvgMileIsNotNull;
	
	private Double monthlyAvgMileStart;
	
	private Double monthlyAvgMileEnd;
	
	private Double monthlyAvgMileLess;
	
	private Double monthlyAvgMileGreater;
	
	private Double avgDriveTimePerDayEquals;
	private Double[] avgDriveTimePerDayIn;
	private Boolean avgDriveTimePerDayIsNull;
	private Boolean avgDriveTimePerDayIsNotNull;
	
	private Double avgDriveTimePerDayStart;
	
	private Double avgDriveTimePerDayEnd;
	
	private Double avgDriveTimePerDayLess;
	
	private Double avgDriveTimePerDayGreater;
	
	private Double powerConsumePerHundredEquals;
	private Double[] powerConsumePerHundredIn;
	private Boolean powerConsumePerHundredIsNull;
	private Boolean powerConsumePerHundredIsNotNull;
	
	private Double powerConsumePerHundredStart;
	
	private Double powerConsumePerHundredEnd;
	
	private Double powerConsumePerHundredLess;
	
	private Double powerConsumePerHundredGreater;
	
	private Double electricRangeEquals;
	private Double[] electricRangeIn;
	private Boolean electricRangeIsNull;
	private Boolean electricRangeIsNotNull;
	
	private Double electricRangeStart;
	
	private Double electricRangeEnd;
	
	private Double electricRangeLess;
	
	private Double electricRangeGreater;
	
	private Double maxChargePowerEquals;
	private Double[] maxChargePowerIn;
	private Boolean maxChargePowerIsNull;
	private Boolean maxChargePowerIsNotNull;
	
	private Double maxChargePowerStart;
	
	private Double maxChargePowerEnd;
	
	private Double maxChargePowerLess;
	
	private Double maxChargePowerGreater;
	
	private Double minChargeTimeEquals;
	private Double[] minChargeTimeIn;
	private Boolean minChargeTimeIsNull;
	private Boolean minChargeTimeIsNotNull;
	
	private Double minChargeTimeStart;
	
	private Double minChargeTimeEnd;
	
	private Double minChargeTimeLess;
	
	private Double minChargeTimeGreater;
	
	private Double cumulativeMileageEquals;
	private Double[] cumulativeMileageIn;
	private Boolean cumulativeMileageIsNull;
	private Boolean cumulativeMileageIsNotNull;
	
	private Double cumulativeMileageStart;
	
	private Double cumulativeMileageEnd;
	
	private Double cumulativeMileageLess;
	
	private Double cumulativeMileageGreater;
	
	private Double cumulativeChargeEquals;
	private Double[] cumulativeChargeIn;
	private Boolean cumulativeChargeIsNull;
	private Boolean cumulativeChargeIsNotNull;
	
	private Double cumulativeChargeStart;
	
	private Double cumulativeChargeEnd;
	
	private Double cumulativeChargeLess;
	
	private Double cumulativeChargeGreater;
	
	private Integer dataTypeEquals;
	private Integer[] dataTypeIn;
	private Boolean dataTypeIsNull;
	private Boolean dataTypeIsNotNull;
	
	private Integer dataTypeStart;
	
	private Integer dataTypeEnd;
	
	private Integer dataTypeLess;
	
	private Integer dataTypeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTimeEquals;
	private Date[] createTimeIn;
	private Boolean createTimeIsNull;
	private Boolean createTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date modifyDateEquals;
	private Date[] modifyDateIn;
	private Boolean modifyDateIsNull;
	private Boolean modifyDateIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date modifyDateStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date modifyDateEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date modifyDateLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date modifyDateGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date facTimeEquals;
	private Date[] facTimeIn;
	private Boolean facTimeIsNull;
	private Boolean facTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date facTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date facTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date facTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date facTimeGreater;
	private String sidx;
	private String sord;

	public CsIndexReportQuery setidEquals(Long idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Long getidEquals(){
		return this.idEquals;
	}
	public CsIndexReportQuery setidIn(Long[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Long[] getidIn(){
		return this.idIn;
	}
	public CsIndexReportQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public CsIndexReportQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public CsIndexReportQuery setidStart(Long idStart){
		this.idStart = idStart;
		return this;
	}
	public Long getidStart(){
		return this.idStart;
	}
	public CsIndexReportQuery setidEnd(Long idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Long getidEnd(){
		return this.idEnd;
	}
	public CsIndexReportQuery setidLess(Long idLess){
		this.idLess = idLess;
		return this;
	}
	public Long getidLess(){
		return this.idLess;
	}
	public CsIndexReportQuery setidGreater(Long idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Long getidGreater(){
		return this.idGreater;
	}
	public CsIndexReportQuery setCsVinLike(String csVinLike){
		this.csVinLike = csVinLike;
		return this;
	}
	public String getCsVinLike(){
		return this.csVinLike;
	}
	public CsIndexReportQuery setCsVinEquals(String csVinEquals){
		this.csVinEquals = csVinEquals;
		return this;
	}
	public String getCsVinEquals(){
		return this.csVinEquals;
	}
	public CsIndexReportQuery setCsVinIn(String[] csVinIn){
		this.csVinIn = csVinIn;
		return this;
	}
	public String[] getCsVinIn(){
		return this.csVinIn;
	}
	public CsIndexReportQuery setCsVinIsNull(Boolean csVinIsNull){
		this.csVinIsNull = csVinIsNull;
		return this;
	}
	public Boolean getCsVinIsNull(){
		return this.csVinIsNull;
	}
	public CsIndexReportQuery setCsVinIsNotNull(Boolean csVinIsNotNull){
		this.csVinIsNotNull = csVinIsNotNull;
		return this;
	}
	public Boolean getCsVinIsNotNull(){
		return this.csVinIsNotNull;
	}
	public CsIndexReportQuery setCsVinStart(String csVinStart){
		this.csVinStart = csVinStart;
		return this;
	}
	public String getCsVinStart(){
		return this.csVinStart;
	}
	public CsIndexReportQuery setCsVinEnd(String csVinEnd){
		this.csVinEnd = csVinEnd;
		return this;
	}
	public String getCsVinEnd(){
		return this.csVinEnd;
	}
	public CsIndexReportQuery setCsVinLess(String csVinLess){
		this.csVinLess = csVinLess;
		return this;
	}
	public String getCsVinLess(){
		return this.csVinLess;
	}
	public CsIndexReportQuery setCsVinGreater(String csVinGreater){
		this.csVinGreater = csVinGreater;
		return this;
	}
	public String getCsVinGreater(){
		return this.csVinGreater;
	}
	public CsIndexReportQuery setCsNumberLike(String csNumberLike){
		this.csNumberLike = csNumberLike;
		return this;
	}
	public String getCsNumberLike(){
		return this.csNumberLike;
	}
	public CsIndexReportQuery setCsNumberEquals(String csNumberEquals){
		this.csNumberEquals = csNumberEquals;
		return this;
	}
	public String getCsNumberEquals(){
		return this.csNumberEquals;
	}
	public CsIndexReportQuery setCsNumberIn(String[] csNumberIn){
		this.csNumberIn = csNumberIn;
		return this;
	}
	public String[] getCsNumberIn(){
		return this.csNumberIn;
	}
	public CsIndexReportQuery setCsNumberIsNull(Boolean csNumberIsNull){
		this.csNumberIsNull = csNumberIsNull;
		return this;
	}
	public Boolean getCsNumberIsNull(){
		return this.csNumberIsNull;
	}
	public CsIndexReportQuery setCsNumberIsNotNull(Boolean csNumberIsNotNull){
		this.csNumberIsNotNull = csNumberIsNotNull;
		return this;
	}
	public Boolean getCsNumberIsNotNull(){
		return this.csNumberIsNotNull;
	}
	public CsIndexReportQuery setCsNumberStart(String csNumberStart){
		this.csNumberStart = csNumberStart;
		return this;
	}
	public String getCsNumberStart(){
		return this.csNumberStart;
	}
	public CsIndexReportQuery setCsNumberEnd(String csNumberEnd){
		this.csNumberEnd = csNumberEnd;
		return this;
	}
	public String getCsNumberEnd(){
		return this.csNumberEnd;
	}
	public CsIndexReportQuery setCsNumberLess(String csNumberLess){
		this.csNumberLess = csNumberLess;
		return this;
	}
	public String getCsNumberLess(){
		return this.csNumberLess;
	}
	public CsIndexReportQuery setCsNumberGreater(String csNumberGreater){
		this.csNumberGreater = csNumberGreater;
		return this;
	}
	public String getCsNumberGreater(){
		return this.csNumberGreater;
	}
	public CsIndexReportQuery setMonthlyAvgMileEquals(Double monthlyAvgMileEquals){
		this.monthlyAvgMileEquals = monthlyAvgMileEquals;
		return this;
	}
	public Double getMonthlyAvgMileEquals(){
		return this.monthlyAvgMileEquals;
	}
	public CsIndexReportQuery setMonthlyAvgMileIn(Double[] monthlyAvgMileIn){
		this.monthlyAvgMileIn = monthlyAvgMileIn;
		return this;
	}
	public Double[] getMonthlyAvgMileIn(){
		return this.monthlyAvgMileIn;
	}
	public CsIndexReportQuery setMonthlyAvgMileIsNull(Boolean monthlyAvgMileIsNull){
		this.monthlyAvgMileIsNull = monthlyAvgMileIsNull;
		return this;
	}
	public Boolean getMonthlyAvgMileIsNull(){
		return this.monthlyAvgMileIsNull;
	}
	public CsIndexReportQuery setMonthlyAvgMileIsNotNull(Boolean monthlyAvgMileIsNotNull){
		this.monthlyAvgMileIsNotNull = monthlyAvgMileIsNotNull;
		return this;
	}
	public Boolean getMonthlyAvgMileIsNotNull(){
		return this.monthlyAvgMileIsNotNull;
	}
	public CsIndexReportQuery setMonthlyAvgMileStart(Double monthlyAvgMileStart){
		this.monthlyAvgMileStart = monthlyAvgMileStart;
		return this;
	}
	public Double getMonthlyAvgMileStart(){
		return this.monthlyAvgMileStart;
	}
	public CsIndexReportQuery setMonthlyAvgMileEnd(Double monthlyAvgMileEnd){
		this.monthlyAvgMileEnd = monthlyAvgMileEnd;
		return this;
	}
	public Double getMonthlyAvgMileEnd(){
		return this.monthlyAvgMileEnd;
	}
	public CsIndexReportQuery setMonthlyAvgMileLess(Double monthlyAvgMileLess){
		this.monthlyAvgMileLess = monthlyAvgMileLess;
		return this;
	}
	public Double getMonthlyAvgMileLess(){
		return this.monthlyAvgMileLess;
	}
	public CsIndexReportQuery setMonthlyAvgMileGreater(Double monthlyAvgMileGreater){
		this.monthlyAvgMileGreater = monthlyAvgMileGreater;
		return this;
	}
	public Double getMonthlyAvgMileGreater(){
		return this.monthlyAvgMileGreater;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayEquals(Double avgDriveTimePerDayEquals){
		this.avgDriveTimePerDayEquals = avgDriveTimePerDayEquals;
		return this;
	}
	public Double getAvgDriveTimePerDayEquals(){
		return this.avgDriveTimePerDayEquals;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayIn(Double[] avgDriveTimePerDayIn){
		this.avgDriveTimePerDayIn = avgDriveTimePerDayIn;
		return this;
	}
	public Double[] getAvgDriveTimePerDayIn(){
		return this.avgDriveTimePerDayIn;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayIsNull(Boolean avgDriveTimePerDayIsNull){
		this.avgDriveTimePerDayIsNull = avgDriveTimePerDayIsNull;
		return this;
	}
	public Boolean getAvgDriveTimePerDayIsNull(){
		return this.avgDriveTimePerDayIsNull;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayIsNotNull(Boolean avgDriveTimePerDayIsNotNull){
		this.avgDriveTimePerDayIsNotNull = avgDriveTimePerDayIsNotNull;
		return this;
	}
	public Boolean getAvgDriveTimePerDayIsNotNull(){
		return this.avgDriveTimePerDayIsNotNull;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayStart(Double avgDriveTimePerDayStart){
		this.avgDriveTimePerDayStart = avgDriveTimePerDayStart;
		return this;
	}
	public Double getAvgDriveTimePerDayStart(){
		return this.avgDriveTimePerDayStart;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayEnd(Double avgDriveTimePerDayEnd){
		this.avgDriveTimePerDayEnd = avgDriveTimePerDayEnd;
		return this;
	}
	public Double getAvgDriveTimePerDayEnd(){
		return this.avgDriveTimePerDayEnd;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayLess(Double avgDriveTimePerDayLess){
		this.avgDriveTimePerDayLess = avgDriveTimePerDayLess;
		return this;
	}
	public Double getAvgDriveTimePerDayLess(){
		return this.avgDriveTimePerDayLess;
	}
	public CsIndexReportQuery setAvgDriveTimePerDayGreater(Double avgDriveTimePerDayGreater){
		this.avgDriveTimePerDayGreater = avgDriveTimePerDayGreater;
		return this;
	}
	public Double getAvgDriveTimePerDayGreater(){
		return this.avgDriveTimePerDayGreater;
	}
	public CsIndexReportQuery setPowerConsumePerHundredEquals(Double powerConsumePerHundredEquals){
		this.powerConsumePerHundredEquals = powerConsumePerHundredEquals;
		return this;
	}
	public Double getPowerConsumePerHundredEquals(){
		return this.powerConsumePerHundredEquals;
	}
	public CsIndexReportQuery setPowerConsumePerHundredIn(Double[] powerConsumePerHundredIn){
		this.powerConsumePerHundredIn = powerConsumePerHundredIn;
		return this;
	}
	public Double[] getPowerConsumePerHundredIn(){
		return this.powerConsumePerHundredIn;
	}
	public CsIndexReportQuery setPowerConsumePerHundredIsNull(Boolean powerConsumePerHundredIsNull){
		this.powerConsumePerHundredIsNull = powerConsumePerHundredIsNull;
		return this;
	}
	public Boolean getPowerConsumePerHundredIsNull(){
		return this.powerConsumePerHundredIsNull;
	}
	public CsIndexReportQuery setPowerConsumePerHundredIsNotNull(Boolean powerConsumePerHundredIsNotNull){
		this.powerConsumePerHundredIsNotNull = powerConsumePerHundredIsNotNull;
		return this;
	}
	public Boolean getPowerConsumePerHundredIsNotNull(){
		return this.powerConsumePerHundredIsNotNull;
	}
	public CsIndexReportQuery setPowerConsumePerHundredStart(Double powerConsumePerHundredStart){
		this.powerConsumePerHundredStart = powerConsumePerHundredStart;
		return this;
	}
	public Double getPowerConsumePerHundredStart(){
		return this.powerConsumePerHundredStart;
	}
	public CsIndexReportQuery setPowerConsumePerHundredEnd(Double powerConsumePerHundredEnd){
		this.powerConsumePerHundredEnd = powerConsumePerHundredEnd;
		return this;
	}
	public Double getPowerConsumePerHundredEnd(){
		return this.powerConsumePerHundredEnd;
	}
	public CsIndexReportQuery setPowerConsumePerHundredLess(Double powerConsumePerHundredLess){
		this.powerConsumePerHundredLess = powerConsumePerHundredLess;
		return this;
	}
	public Double getPowerConsumePerHundredLess(){
		return this.powerConsumePerHundredLess;
	}
	public CsIndexReportQuery setPowerConsumePerHundredGreater(Double powerConsumePerHundredGreater){
		this.powerConsumePerHundredGreater = powerConsumePerHundredGreater;
		return this;
	}
	public Double getPowerConsumePerHundredGreater(){
		return this.powerConsumePerHundredGreater;
	}
	public CsIndexReportQuery setElectricRangeEquals(Double electricRangeEquals){
		this.electricRangeEquals = electricRangeEquals;
		return this;
	}
	public Double getElectricRangeEquals(){
		return this.electricRangeEquals;
	}
	public CsIndexReportQuery setElectricRangeIn(Double[] electricRangeIn){
		this.electricRangeIn = electricRangeIn;
		return this;
	}
	public Double[] getElectricRangeIn(){
		return this.electricRangeIn;
	}
	public CsIndexReportQuery setElectricRangeIsNull(Boolean electricRangeIsNull){
		this.electricRangeIsNull = electricRangeIsNull;
		return this;
	}
	public Boolean getElectricRangeIsNull(){
		return this.electricRangeIsNull;
	}
	public CsIndexReportQuery setElectricRangeIsNotNull(Boolean electricRangeIsNotNull){
		this.electricRangeIsNotNull = electricRangeIsNotNull;
		return this;
	}
	public Boolean getElectricRangeIsNotNull(){
		return this.electricRangeIsNotNull;
	}
	public CsIndexReportQuery setElectricRangeStart(Double electricRangeStart){
		this.electricRangeStart = electricRangeStart;
		return this;
	}
	public Double getElectricRangeStart(){
		return this.electricRangeStart;
	}
	public CsIndexReportQuery setElectricRangeEnd(Double electricRangeEnd){
		this.electricRangeEnd = electricRangeEnd;
		return this;
	}
	public Double getElectricRangeEnd(){
		return this.electricRangeEnd;
	}
	public CsIndexReportQuery setElectricRangeLess(Double electricRangeLess){
		this.electricRangeLess = electricRangeLess;
		return this;
	}
	public Double getElectricRangeLess(){
		return this.electricRangeLess;
	}
	public CsIndexReportQuery setElectricRangeGreater(Double electricRangeGreater){
		this.electricRangeGreater = electricRangeGreater;
		return this;
	}
	public Double getElectricRangeGreater(){
		return this.electricRangeGreater;
	}
	public CsIndexReportQuery setMaxChargePowerEquals(Double maxChargePowerEquals){
		this.maxChargePowerEquals = maxChargePowerEquals;
		return this;
	}
	public Double getMaxChargePowerEquals(){
		return this.maxChargePowerEquals;
	}
	public CsIndexReportQuery setMaxChargePowerIn(Double[] maxChargePowerIn){
		this.maxChargePowerIn = maxChargePowerIn;
		return this;
	}
	public Double[] getMaxChargePowerIn(){
		return this.maxChargePowerIn;
	}
	public CsIndexReportQuery setMaxChargePowerIsNull(Boolean maxChargePowerIsNull){
		this.maxChargePowerIsNull = maxChargePowerIsNull;
		return this;
	}
	public Boolean getMaxChargePowerIsNull(){
		return this.maxChargePowerIsNull;
	}
	public CsIndexReportQuery setMaxChargePowerIsNotNull(Boolean maxChargePowerIsNotNull){
		this.maxChargePowerIsNotNull = maxChargePowerIsNotNull;
		return this;
	}
	public Boolean getMaxChargePowerIsNotNull(){
		return this.maxChargePowerIsNotNull;
	}
	public CsIndexReportQuery setMaxChargePowerStart(Double maxChargePowerStart){
		this.maxChargePowerStart = maxChargePowerStart;
		return this;
	}
	public Double getMaxChargePowerStart(){
		return this.maxChargePowerStart;
	}
	public CsIndexReportQuery setMaxChargePowerEnd(Double maxChargePowerEnd){
		this.maxChargePowerEnd = maxChargePowerEnd;
		return this;
	}
	public Double getMaxChargePowerEnd(){
		return this.maxChargePowerEnd;
	}
	public CsIndexReportQuery setMaxChargePowerLess(Double maxChargePowerLess){
		this.maxChargePowerLess = maxChargePowerLess;
		return this;
	}
	public Double getMaxChargePowerLess(){
		return this.maxChargePowerLess;
	}
	public CsIndexReportQuery setMaxChargePowerGreater(Double maxChargePowerGreater){
		this.maxChargePowerGreater = maxChargePowerGreater;
		return this;
	}
	public Double getMaxChargePowerGreater(){
		return this.maxChargePowerGreater;
	}
	public CsIndexReportQuery setMinChargeTimeEquals(Double minChargeTimeEquals){
		this.minChargeTimeEquals = minChargeTimeEquals;
		return this;
	}
	public Double getMinChargeTimeEquals(){
		return this.minChargeTimeEquals;
	}
	public CsIndexReportQuery setMinChargeTimeIn(Double[] minChargeTimeIn){
		this.minChargeTimeIn = minChargeTimeIn;
		return this;
	}
	public Double[] getMinChargeTimeIn(){
		return this.minChargeTimeIn;
	}
	public CsIndexReportQuery setMinChargeTimeIsNull(Boolean minChargeTimeIsNull){
		this.minChargeTimeIsNull = minChargeTimeIsNull;
		return this;
	}
	public Boolean getMinChargeTimeIsNull(){
		return this.minChargeTimeIsNull;
	}
	public CsIndexReportQuery setMinChargeTimeIsNotNull(Boolean minChargeTimeIsNotNull){
		this.minChargeTimeIsNotNull = minChargeTimeIsNotNull;
		return this;
	}
	public Boolean getMinChargeTimeIsNotNull(){
		return this.minChargeTimeIsNotNull;
	}
	public CsIndexReportQuery setMinChargeTimeStart(Double minChargeTimeStart){
		this.minChargeTimeStart = minChargeTimeStart;
		return this;
	}
	public Double getMinChargeTimeStart(){
		return this.minChargeTimeStart;
	}
	public CsIndexReportQuery setMinChargeTimeEnd(Double minChargeTimeEnd){
		this.minChargeTimeEnd = minChargeTimeEnd;
		return this;
	}
	public Double getMinChargeTimeEnd(){
		return this.minChargeTimeEnd;
	}
	public CsIndexReportQuery setMinChargeTimeLess(Double minChargeTimeLess){
		this.minChargeTimeLess = minChargeTimeLess;
		return this;
	}
	public Double getMinChargeTimeLess(){
		return this.minChargeTimeLess;
	}
	public CsIndexReportQuery setMinChargeTimeGreater(Double minChargeTimeGreater){
		this.minChargeTimeGreater = minChargeTimeGreater;
		return this;
	}
	public Double getMinChargeTimeGreater(){
		return this.minChargeTimeGreater;
	}
	public CsIndexReportQuery setCumulativeMileageEquals(Double cumulativeMileageEquals){
		this.cumulativeMileageEquals = cumulativeMileageEquals;
		return this;
	}
	public Double getCumulativeMileageEquals(){
		return this.cumulativeMileageEquals;
	}
	public CsIndexReportQuery setCumulativeMileageIn(Double[] cumulativeMileageIn){
		this.cumulativeMileageIn = cumulativeMileageIn;
		return this;
	}
	public Double[] getCumulativeMileageIn(){
		return this.cumulativeMileageIn;
	}
	public CsIndexReportQuery setCumulativeMileageIsNull(Boolean cumulativeMileageIsNull){
		this.cumulativeMileageIsNull = cumulativeMileageIsNull;
		return this;
	}
	public Boolean getCumulativeMileageIsNull(){
		return this.cumulativeMileageIsNull;
	}
	public CsIndexReportQuery setCumulativeMileageIsNotNull(Boolean cumulativeMileageIsNotNull){
		this.cumulativeMileageIsNotNull = cumulativeMileageIsNotNull;
		return this;
	}
	public Boolean getCumulativeMileageIsNotNull(){
		return this.cumulativeMileageIsNotNull;
	}
	public CsIndexReportQuery setCumulativeMileageStart(Double cumulativeMileageStart){
		this.cumulativeMileageStart = cumulativeMileageStart;
		return this;
	}
	public Double getCumulativeMileageStart(){
		return this.cumulativeMileageStart;
	}
	public CsIndexReportQuery setCumulativeMileageEnd(Double cumulativeMileageEnd){
		this.cumulativeMileageEnd = cumulativeMileageEnd;
		return this;
	}
	public Double getCumulativeMileageEnd(){
		return this.cumulativeMileageEnd;
	}
	public CsIndexReportQuery setCumulativeMileageLess(Double cumulativeMileageLess){
		this.cumulativeMileageLess = cumulativeMileageLess;
		return this;
	}
	public Double getCumulativeMileageLess(){
		return this.cumulativeMileageLess;
	}
	public CsIndexReportQuery setCumulativeMileageGreater(Double cumulativeMileageGreater){
		this.cumulativeMileageGreater = cumulativeMileageGreater;
		return this;
	}
	public Double getCumulativeMileageGreater(){
		return this.cumulativeMileageGreater;
	}
	public CsIndexReportQuery setCumulativeChargeEquals(Double cumulativeChargeEquals){
		this.cumulativeChargeEquals = cumulativeChargeEquals;
		return this;
	}
	public Double getCumulativeChargeEquals(){
		return this.cumulativeChargeEquals;
	}
	public CsIndexReportQuery setCumulativeChargeIn(Double[] cumulativeChargeIn){
		this.cumulativeChargeIn = cumulativeChargeIn;
		return this;
	}
	public Double[] getCumulativeChargeIn(){
		return this.cumulativeChargeIn;
	}
	public CsIndexReportQuery setCumulativeChargeIsNull(Boolean cumulativeChargeIsNull){
		this.cumulativeChargeIsNull = cumulativeChargeIsNull;
		return this;
	}
	public Boolean getCumulativeChargeIsNull(){
		return this.cumulativeChargeIsNull;
	}
	public CsIndexReportQuery setCumulativeChargeIsNotNull(Boolean cumulativeChargeIsNotNull){
		this.cumulativeChargeIsNotNull = cumulativeChargeIsNotNull;
		return this;
	}
	public Boolean getCumulativeChargeIsNotNull(){
		return this.cumulativeChargeIsNotNull;
	}
	public CsIndexReportQuery setCumulativeChargeStart(Double cumulativeChargeStart){
		this.cumulativeChargeStart = cumulativeChargeStart;
		return this;
	}
	public Double getCumulativeChargeStart(){
		return this.cumulativeChargeStart;
	}
	public CsIndexReportQuery setCumulativeChargeEnd(Double cumulativeChargeEnd){
		this.cumulativeChargeEnd = cumulativeChargeEnd;
		return this;
	}
	public Double getCumulativeChargeEnd(){
		return this.cumulativeChargeEnd;
	}
	public CsIndexReportQuery setCumulativeChargeLess(Double cumulativeChargeLess){
		this.cumulativeChargeLess = cumulativeChargeLess;
		return this;
	}
	public Double getCumulativeChargeLess(){
		return this.cumulativeChargeLess;
	}
	public CsIndexReportQuery setCumulativeChargeGreater(Double cumulativeChargeGreater){
		this.cumulativeChargeGreater = cumulativeChargeGreater;
		return this;
	}
	public Double getCumulativeChargeGreater(){
		return this.cumulativeChargeGreater;
	}
	public CsIndexReportQuery setDataTypeEquals(Integer dataTypeEquals){
		this.dataTypeEquals = dataTypeEquals;
		return this;
	}
	public Integer getDataTypeEquals(){
		return this.dataTypeEquals;
	}
	public CsIndexReportQuery setDataTypeIn(Integer[] dataTypeIn){
		this.dataTypeIn = dataTypeIn;
		return this;
	}
	public Integer[] getDataTypeIn(){
		return this.dataTypeIn;
	}
	public CsIndexReportQuery setDataTypeIsNull(Boolean dataTypeIsNull){
		this.dataTypeIsNull = dataTypeIsNull;
		return this;
	}
	public Boolean getDataTypeIsNull(){
		return this.dataTypeIsNull;
	}
	public CsIndexReportQuery setDataTypeIsNotNull(Boolean dataTypeIsNotNull){
		this.dataTypeIsNotNull = dataTypeIsNotNull;
		return this;
	}
	public Boolean getDataTypeIsNotNull(){
		return this.dataTypeIsNotNull;
	}
	public CsIndexReportQuery setDataTypeStart(Integer dataTypeStart){
		this.dataTypeStart = dataTypeStart;
		return this;
	}
	public Integer getDataTypeStart(){
		return this.dataTypeStart;
	}
	public CsIndexReportQuery setDataTypeEnd(Integer dataTypeEnd){
		this.dataTypeEnd = dataTypeEnd;
		return this;
	}
	public Integer getDataTypeEnd(){
		return this.dataTypeEnd;
	}
	public CsIndexReportQuery setDataTypeLess(Integer dataTypeLess){
		this.dataTypeLess = dataTypeLess;
		return this;
	}
	public Integer getDataTypeLess(){
		return this.dataTypeLess;
	}
	public CsIndexReportQuery setDataTypeGreater(Integer dataTypeGreater){
		this.dataTypeGreater = dataTypeGreater;
		return this;
	}
	public Integer getDataTypeGreater(){
		return this.dataTypeGreater;
	}
	public CsIndexReportQuery setcreateTimeEquals(Date createTimeEquals){
		this.createTimeEquals = createTimeEquals;
		return this;
	}
	public Date getcreateTimeEquals(){
		return this.createTimeEquals;
	}
	public CsIndexReportQuery setcreateTimeIn(Date[] createTimeIn){
		this.createTimeIn = createTimeIn;
		return this;
	}
	public Date[] getcreateTimeIn(){
		return this.createTimeIn;
	}
	public CsIndexReportQuery setcreateTimeIsNull(Boolean createTimeIsNull){
		this.createTimeIsNull = createTimeIsNull;
		return this;
	}
	public Boolean getcreateTimeIsNull(){
		return this.createTimeIsNull;
	}
	public CsIndexReportQuery setcreateTimeIsNotNull(Boolean createTimeIsNotNull){
		this.createTimeIsNotNull = createTimeIsNotNull;
		return this;
	}
	public Boolean getcreateTimeIsNotNull(){
		return this.createTimeIsNotNull;
	}
	public CsIndexReportQuery setcreateTimeStart(Date createTimeStart){
		this.createTimeStart = createTimeStart;
		return this;
	}
	public Date getcreateTimeStart(){
		return this.createTimeStart;
	}
	public CsIndexReportQuery setcreateTimeEnd(Date createTimeEnd){
		this.createTimeEnd = createTimeEnd;
		return this;
	}
	public Date getcreateTimeEnd(){
		return this.createTimeEnd;
	}
	public CsIndexReportQuery setcreateTimeLess(Date createTimeLess){
		this.createTimeLess = createTimeLess;
		return this;
	}
	public Date getcreateTimeLess(){
		return this.createTimeLess;
	}
	public CsIndexReportQuery setcreateTimeGreater(Date createTimeGreater){
		this.createTimeGreater = createTimeGreater;
		return this;
	}
	public Date getcreateTimeGreater(){
		return this.createTimeGreater;
	}
	public CsIndexReportQuery setmodifyDateEquals(Date modifyDateEquals){
		this.modifyDateEquals = modifyDateEquals;
		return this;
	}
	public Date getmodifyDateEquals(){
		return this.modifyDateEquals;
	}
	public CsIndexReportQuery setmodifyDateIn(Date[] modifyDateIn){
		this.modifyDateIn = modifyDateIn;
		return this;
	}
	public Date[] getmodifyDateIn(){
		return this.modifyDateIn;
	}
	public CsIndexReportQuery setmodifyDateIsNull(Boolean modifyDateIsNull){
		this.modifyDateIsNull = modifyDateIsNull;
		return this;
	}
	public Boolean getmodifyDateIsNull(){
		return this.modifyDateIsNull;
	}
	public CsIndexReportQuery setmodifyDateIsNotNull(Boolean modifyDateIsNotNull){
		this.modifyDateIsNotNull = modifyDateIsNotNull;
		return this;
	}
	public Boolean getmodifyDateIsNotNull(){
		return this.modifyDateIsNotNull;
	}
	public CsIndexReportQuery setmodifyDateStart(Date modifyDateStart){
		this.modifyDateStart = modifyDateStart;
		return this;
	}
	public Date getmodifyDateStart(){
		return this.modifyDateStart;
	}
	public CsIndexReportQuery setmodifyDateEnd(Date modifyDateEnd){
		this.modifyDateEnd = modifyDateEnd;
		return this;
	}
	public Date getmodifyDateEnd(){
		return this.modifyDateEnd;
	}
	public CsIndexReportQuery setmodifyDateLess(Date modifyDateLess){
		this.modifyDateLess = modifyDateLess;
		return this;
	}
	public Date getmodifyDateLess(){
		return this.modifyDateLess;
	}
	public CsIndexReportQuery setmodifyDateGreater(Date modifyDateGreater){
		this.modifyDateGreater = modifyDateGreater;
		return this;
	}
	public Date getmodifyDateGreater(){
		return this.modifyDateGreater;
	}
	public CsIndexReportQuery setFacTimeEquals(Date facTimeEquals){
		this.facTimeEquals = facTimeEquals;
		return this;
	}
	public Date getFacTimeEquals(){
		return this.facTimeEquals;
	}
	public CsIndexReportQuery setFacTimeIn(Date[] facTimeIn){
		this.facTimeIn = facTimeIn;
		return this;
	}
	public Date[] getFacTimeIn(){
		return this.facTimeIn;
	}
	public CsIndexReportQuery setFacTimeIsNull(Boolean facTimeIsNull){
		this.facTimeIsNull = facTimeIsNull;
		return this;
	}
	public Boolean getFacTimeIsNull(){
		return this.facTimeIsNull;
	}
	public CsIndexReportQuery setFacTimeIsNotNull(Boolean facTimeIsNotNull){
		this.facTimeIsNotNull = facTimeIsNotNull;
		return this;
	}
	public Boolean getFacTimeIsNotNull(){
		return this.facTimeIsNotNull;
	}
	public CsIndexReportQuery setFacTimeStart(Date facTimeStart){
		this.facTimeStart = facTimeStart;
		return this;
	}
	public Date getFacTimeStart(){
		return this.facTimeStart;
	}
	public CsIndexReportQuery setFacTimeEnd(Date facTimeEnd){
		this.facTimeEnd = facTimeEnd;
		return this;
	}
	public Date getFacTimeEnd(){
		return this.facTimeEnd;
	}
	public CsIndexReportQuery setFacTimeLess(Date facTimeLess){
		this.facTimeLess = facTimeLess;
		return this;
	}
	public Date getFacTimeLess(){
		return this.facTimeLess;
	}
	public CsIndexReportQuery setFacTimeGreater(Date facTimeGreater){
		this.facTimeGreater = facTimeGreater;
		return this;
	}
	public Date getFacTimeGreater(){
		return this.facTimeGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("id")){
			return "id";
		}
		else if(this.sidx.equals("csVin")){
			return "cs_vin";
		}
		else if(this.sidx.equals("csNumber")){
			return "cs_number";
		}
		else if(this.sidx.equals("monthlyAvgMile")){
			return "monthly_avg_mile";
		}
		else if(this.sidx.equals("avgDriveTimePerDay")){
			return "avg_drive_time_per_day";
		}
		else if(this.sidx.equals("powerConsumePerHundred")){
			return "power_consume_per_hundred";
		}
		else if(this.sidx.equals("electricRange")){
			return "electric_range";
		}
		else if(this.sidx.equals("maxChargePower")){
			return "max_charge_power";
		}
		else if(this.sidx.equals("minChargeTime")){
			return "min_charge_time";
		}
		else if(this.sidx.equals("cumulativeMileage")){
			return "cumulative_mileage";
		}
		else if(this.sidx.equals("cumulativeCharge")){
			return "cumulative_charge";
		}
		else if(this.sidx.equals("dataType")){
			return "data_type";
		}
		else if(this.sidx.equals("createTime")){
			return "createTime";
		}
		else if(this.sidx.equals("modifyDate")){
			return "modifyDate";
		}
		else if(this.sidx.equals("facTime")){
			return "fac_time";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsIndexReportCrieria getCrieria(){
		CsIndexReportCrieria q = new CsIndexReportCrieria();
		CsIndexReportCrieria.Criteria c = q.createCriteria();
		
		if(this.getidEquals()!=null){
			c.andidEqualTo(this.getidEquals());
		}else if(this.getidIsNull()!=null && this.getidIsNull()){
			c.andidIsNull();
		}else if(this.getidIsNotNull()!=null && this.getidIsNotNull()){
			c.andidIsNotNull();
		}else if(this.getidIn()!=null){
			c.andidIn(java.util.Arrays.asList(this.getidIn()));
		}else if(this.getidStart()!=null && this.getidEnd()!=null){
			c.andidBetween(this.getidStart(), this.getidEnd());
		}else if(this.getidGreater()!=null){
			c.andidGreaterThan(this.getidGreater());
		}else if(this.getidLess()!=null){
			c.andidLessThan(this.getidLess());
		}
		if(this.getCsVinEquals()!=null){
			c.andcsVinEqualTo(this.getCsVinEquals());
		}else if(this.getCsVinIsNull()!=null && this.getCsVinIsNull()){
			c.andcsVinIsNull();
		}else if(this.getCsVinIsNotNull()!=null && this.getCsVinIsNotNull()){
			c.andcsVinIsNotNull();
		}else if(this.getCsVinLike()!=null){
			c.andcsVinLike(this.getCsVinLike());
		}else if(this.getCsVinIn()!=null){
			c.andcsVinIn(java.util.Arrays.asList(this.getCsVinIn()));
		}else if(this.getCsVinStart()!=null && this.getCsVinEnd()!=null){
			c.andcsVinBetween(this.getCsVinStart(), this.getCsVinEnd());
		}else if(this.getCsVinGreater()!=null){
			c.andcsVinGreaterThan(this.getCsVinGreater());
		}else if(this.getCsVinLess()!=null){
			c.andcsVinLessThan(this.getCsVinLess());
		}
		if(this.getCsNumberEquals()!=null){
			c.andcsNumberEqualTo(this.getCsNumberEquals());
		}else if(this.getCsNumberIsNull()!=null && this.getCsNumberIsNull()){
			c.andcsNumberIsNull();
		}else if(this.getCsNumberIsNotNull()!=null && this.getCsNumberIsNotNull()){
			c.andcsNumberIsNotNull();
		}else if(this.getCsNumberLike()!=null){
			c.andcsNumberLike(this.getCsNumberLike());
		}else if(this.getCsNumberIn()!=null){
			c.andcsNumberIn(java.util.Arrays.asList(this.getCsNumberIn()));
		}else if(this.getCsNumberStart()!=null && this.getCsNumberEnd()!=null){
			c.andcsNumberBetween(this.getCsNumberStart(), this.getCsNumberEnd());
		}else if(this.getCsNumberGreater()!=null){
			c.andcsNumberGreaterThan(this.getCsNumberGreater());
		}else if(this.getCsNumberLess()!=null){
			c.andcsNumberLessThan(this.getCsNumberLess());
		}
		if(this.getMonthlyAvgMileEquals()!=null){
			c.andmonthlyAvgMileEqualTo(this.getMonthlyAvgMileEquals());
		}else if(this.getMonthlyAvgMileIsNull()!=null && this.getMonthlyAvgMileIsNull()){
			c.andmonthlyAvgMileIsNull();
		}else if(this.getMonthlyAvgMileIsNotNull()!=null && this.getMonthlyAvgMileIsNotNull()){
			c.andmonthlyAvgMileIsNotNull();
		}else if(this.getMonthlyAvgMileIn()!=null){
			c.andmonthlyAvgMileIn(java.util.Arrays.asList(this.getMonthlyAvgMileIn()));
		}else if(this.getMonthlyAvgMileStart()!=null && this.getMonthlyAvgMileEnd()!=null){
			c.andmonthlyAvgMileBetween(this.getMonthlyAvgMileStart(), this.getMonthlyAvgMileEnd());
		}else if(this.getMonthlyAvgMileGreater()!=null){
			c.andmonthlyAvgMileGreaterThan(this.getMonthlyAvgMileGreater());
		}else if(this.getMonthlyAvgMileLess()!=null){
			c.andmonthlyAvgMileLessThan(this.getMonthlyAvgMileLess());
		}
		if(this.getAvgDriveTimePerDayEquals()!=null){
			c.andavgDriveTimePerDayEqualTo(this.getAvgDriveTimePerDayEquals());
		}else if(this.getAvgDriveTimePerDayIsNull()!=null && this.getAvgDriveTimePerDayIsNull()){
			c.andavgDriveTimePerDayIsNull();
		}else if(this.getAvgDriveTimePerDayIsNotNull()!=null && this.getAvgDriveTimePerDayIsNotNull()){
			c.andavgDriveTimePerDayIsNotNull();
		}else if(this.getAvgDriveTimePerDayIn()!=null){
			c.andavgDriveTimePerDayIn(java.util.Arrays.asList(this.getAvgDriveTimePerDayIn()));
		}else if(this.getAvgDriveTimePerDayStart()!=null && this.getAvgDriveTimePerDayEnd()!=null){
			c.andavgDriveTimePerDayBetween(this.getAvgDriveTimePerDayStart(), this.getAvgDriveTimePerDayEnd());
		}else if(this.getAvgDriveTimePerDayGreater()!=null){
			c.andavgDriveTimePerDayGreaterThan(this.getAvgDriveTimePerDayGreater());
		}else if(this.getAvgDriveTimePerDayLess()!=null){
			c.andavgDriveTimePerDayLessThan(this.getAvgDriveTimePerDayLess());
		}
		if(this.getPowerConsumePerHundredEquals()!=null){
			c.andpowerConsumePerHundredEqualTo(this.getPowerConsumePerHundredEquals());
		}else if(this.getPowerConsumePerHundredIsNull()!=null && this.getPowerConsumePerHundredIsNull()){
			c.andpowerConsumePerHundredIsNull();
		}else if(this.getPowerConsumePerHundredIsNotNull()!=null && this.getPowerConsumePerHundredIsNotNull()){
			c.andpowerConsumePerHundredIsNotNull();
		}else if(this.getPowerConsumePerHundredIn()!=null){
			c.andpowerConsumePerHundredIn(java.util.Arrays.asList(this.getPowerConsumePerHundredIn()));
		}else if(this.getPowerConsumePerHundredStart()!=null && this.getPowerConsumePerHundredEnd()!=null){
			c.andpowerConsumePerHundredBetween(this.getPowerConsumePerHundredStart(), this.getPowerConsumePerHundredEnd());
		}else if(this.getPowerConsumePerHundredGreater()!=null){
			c.andpowerConsumePerHundredGreaterThan(this.getPowerConsumePerHundredGreater());
		}else if(this.getPowerConsumePerHundredLess()!=null){
			c.andpowerConsumePerHundredLessThan(this.getPowerConsumePerHundredLess());
		}
		if(this.getElectricRangeEquals()!=null){
			c.andelectricRangeEqualTo(this.getElectricRangeEquals());
		}else if(this.getElectricRangeIsNull()!=null && this.getElectricRangeIsNull()){
			c.andelectricRangeIsNull();
		}else if(this.getElectricRangeIsNotNull()!=null && this.getElectricRangeIsNotNull()){
			c.andelectricRangeIsNotNull();
		}else if(this.getElectricRangeIn()!=null){
			c.andelectricRangeIn(java.util.Arrays.asList(this.getElectricRangeIn()));
		}else if(this.getElectricRangeStart()!=null && this.getElectricRangeEnd()!=null){
			c.andelectricRangeBetween(this.getElectricRangeStart(), this.getElectricRangeEnd());
		}else if(this.getElectricRangeGreater()!=null){
			c.andelectricRangeGreaterThan(this.getElectricRangeGreater());
		}else if(this.getElectricRangeLess()!=null){
			c.andelectricRangeLessThan(this.getElectricRangeLess());
		}
		if(this.getMaxChargePowerEquals()!=null){
			c.andmaxChargePowerEqualTo(this.getMaxChargePowerEquals());
		}else if(this.getMaxChargePowerIsNull()!=null && this.getMaxChargePowerIsNull()){
			c.andmaxChargePowerIsNull();
		}else if(this.getMaxChargePowerIsNotNull()!=null && this.getMaxChargePowerIsNotNull()){
			c.andmaxChargePowerIsNotNull();
		}else if(this.getMaxChargePowerIn()!=null){
			c.andmaxChargePowerIn(java.util.Arrays.asList(this.getMaxChargePowerIn()));
		}else if(this.getMaxChargePowerStart()!=null && this.getMaxChargePowerEnd()!=null){
			c.andmaxChargePowerBetween(this.getMaxChargePowerStart(), this.getMaxChargePowerEnd());
		}else if(this.getMaxChargePowerGreater()!=null){
			c.andmaxChargePowerGreaterThan(this.getMaxChargePowerGreater());
		}else if(this.getMaxChargePowerLess()!=null){
			c.andmaxChargePowerLessThan(this.getMaxChargePowerLess());
		}
		if(this.getMinChargeTimeEquals()!=null){
			c.andminChargeTimeEqualTo(this.getMinChargeTimeEquals());
		}else if(this.getMinChargeTimeIsNull()!=null && this.getMinChargeTimeIsNull()){
			c.andminChargeTimeIsNull();
		}else if(this.getMinChargeTimeIsNotNull()!=null && this.getMinChargeTimeIsNotNull()){
			c.andminChargeTimeIsNotNull();
		}else if(this.getMinChargeTimeIn()!=null){
			c.andminChargeTimeIn(java.util.Arrays.asList(this.getMinChargeTimeIn()));
		}else if(this.getMinChargeTimeStart()!=null && this.getMinChargeTimeEnd()!=null){
			c.andminChargeTimeBetween(this.getMinChargeTimeStart(), this.getMinChargeTimeEnd());
		}else if(this.getMinChargeTimeGreater()!=null){
			c.andminChargeTimeGreaterThan(this.getMinChargeTimeGreater());
		}else if(this.getMinChargeTimeLess()!=null){
			c.andminChargeTimeLessThan(this.getMinChargeTimeLess());
		}
		if(this.getCumulativeMileageEquals()!=null){
			c.andcumulativeMileageEqualTo(this.getCumulativeMileageEquals());
		}else if(this.getCumulativeMileageIsNull()!=null && this.getCumulativeMileageIsNull()){
			c.andcumulativeMileageIsNull();
		}else if(this.getCumulativeMileageIsNotNull()!=null && this.getCumulativeMileageIsNotNull()){
			c.andcumulativeMileageIsNotNull();
		}else if(this.getCumulativeMileageIn()!=null){
			c.andcumulativeMileageIn(java.util.Arrays.asList(this.getCumulativeMileageIn()));
		}else if(this.getCumulativeMileageStart()!=null && this.getCumulativeMileageEnd()!=null){
			c.andcumulativeMileageBetween(this.getCumulativeMileageStart(), this.getCumulativeMileageEnd());
		}else if(this.getCumulativeMileageGreater()!=null){
			c.andcumulativeMileageGreaterThan(this.getCumulativeMileageGreater());
		}else if(this.getCumulativeMileageLess()!=null){
			c.andcumulativeMileageLessThan(this.getCumulativeMileageLess());
		}
		if(this.getCumulativeChargeEquals()!=null){
			c.andcumulativeChargeEqualTo(this.getCumulativeChargeEquals());
		}else if(this.getCumulativeChargeIsNull()!=null && this.getCumulativeChargeIsNull()){
			c.andcumulativeChargeIsNull();
		}else if(this.getCumulativeChargeIsNotNull()!=null && this.getCumulativeChargeIsNotNull()){
			c.andcumulativeChargeIsNotNull();
		}else if(this.getCumulativeChargeIn()!=null){
			c.andcumulativeChargeIn(java.util.Arrays.asList(this.getCumulativeChargeIn()));
		}else if(this.getCumulativeChargeStart()!=null && this.getCumulativeChargeEnd()!=null){
			c.andcumulativeChargeBetween(this.getCumulativeChargeStart(), this.getCumulativeChargeEnd());
		}else if(this.getCumulativeChargeGreater()!=null){
			c.andcumulativeChargeGreaterThan(this.getCumulativeChargeGreater());
		}else if(this.getCumulativeChargeLess()!=null){
			c.andcumulativeChargeLessThan(this.getCumulativeChargeLess());
		}
		if(this.getDataTypeEquals()!=null){
			c.anddataTypeEqualTo(this.getDataTypeEquals());
		}else if(this.getDataTypeIsNull()!=null && this.getDataTypeIsNull()){
			c.anddataTypeIsNull();
		}else if(this.getDataTypeIsNotNull()!=null && this.getDataTypeIsNotNull()){
			c.anddataTypeIsNotNull();
		}else if(this.getDataTypeIn()!=null){
			c.anddataTypeIn(java.util.Arrays.asList(this.getDataTypeIn()));
		}else if(this.getDataTypeStart()!=null && this.getDataTypeEnd()!=null){
			c.anddataTypeBetween(this.getDataTypeStart(), this.getDataTypeEnd());
		}else if(this.getDataTypeGreater()!=null){
			c.anddataTypeGreaterThan(this.getDataTypeGreater());
		}else if(this.getDataTypeLess()!=null){
			c.anddataTypeLessThan(this.getDataTypeLess());
		}
		if(this.getcreateTimeEquals()!=null){
			c.andcreateTimeEqualTo(this.getcreateTimeEquals());
		}else if(this.getcreateTimeIsNull()!=null && this.getcreateTimeIsNull()){
			c.andcreateTimeIsNull();
		}else if(this.getcreateTimeIsNotNull()!=null && this.getcreateTimeIsNotNull()){
			c.andcreateTimeIsNotNull();
		}else if(this.getcreateTimeIn()!=null){
			c.andcreateTimeIn(java.util.Arrays.asList(this.getcreateTimeIn()));
		}else if(this.getcreateTimeStart()!=null && this.getcreateTimeEnd()!=null){
			c.andcreateTimeBetween(this.getcreateTimeStart(), this.getcreateTimeEnd());
		}else if(this.getcreateTimeGreater()!=null){
			c.andcreateTimeGreaterThan(this.getcreateTimeGreater());
		}else if(this.getcreateTimeLess()!=null){
			c.andcreateTimeLessThan(this.getcreateTimeLess());
		}
		if(this.getmodifyDateEquals()!=null){
			c.andmodifyDateEqualTo(this.getmodifyDateEquals());
		}else if(this.getmodifyDateIsNull()!=null && this.getmodifyDateIsNull()){
			c.andmodifyDateIsNull();
		}else if(this.getmodifyDateIsNotNull()!=null && this.getmodifyDateIsNotNull()){
			c.andmodifyDateIsNotNull();
		}else if(this.getmodifyDateIn()!=null){
			c.andmodifyDateIn(java.util.Arrays.asList(this.getmodifyDateIn()));
		}else if(this.getmodifyDateStart()!=null && this.getmodifyDateEnd()!=null){
			c.andmodifyDateBetween(this.getmodifyDateStart(), this.getmodifyDateEnd());
		}else if(this.getmodifyDateGreater()!=null){
			c.andmodifyDateGreaterThan(this.getmodifyDateGreater());
		}else if(this.getmodifyDateLess()!=null){
			c.andmodifyDateLessThan(this.getmodifyDateLess());
		}
		if(this.getFacTimeEquals()!=null){
			c.andfacTimeEqualTo(this.getFacTimeEquals());
		}else if(this.getFacTimeIsNull()!=null && this.getFacTimeIsNull()){
			c.andfacTimeIsNull();
		}else if(this.getFacTimeIsNotNull()!=null && this.getFacTimeIsNotNull()){
			c.andfacTimeIsNotNull();
		}else if(this.getFacTimeIn()!=null){
			c.andfacTimeIn(java.util.Arrays.asList(this.getFacTimeIn()));
		}else if(this.getFacTimeStart()!=null && this.getFacTimeEnd()!=null){
			c.andfacTimeBetween(this.getFacTimeStart(), this.getFacTimeEnd());
		}else if(this.getFacTimeGreater()!=null){
			c.andfacTimeGreaterThan(this.getFacTimeGreater());
		}else if(this.getFacTimeLess()!=null){
			c.andfacTimeLessThan(this.getFacTimeLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
