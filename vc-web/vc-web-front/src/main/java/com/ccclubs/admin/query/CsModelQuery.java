package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsModelCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsModelQuery {
	
	private Integer csmIdEquals;
	private Integer[] csmIdIn;
	private Boolean csmIdIsNull;
	private Boolean csmIdIsNotNull;
	
	private Integer csmIdStart;
	
	private Integer csmIdEnd;
	
	private Integer csmIdLess;
	
	private Integer csmIdGreater;
	private String csmNameLike;
	
	private String csmNameEquals;
	private String[] csmNameIn;
	private Boolean csmNameIsNull;
	private Boolean csmNameIsNotNull;
	
	private String csmNameStart;
	
	private String csmNameEnd;
	
	private String csmNameLess;
	
	private String csmNameGreater;
	private String csmFlagLike;
	
	private String csmFlagEquals;
	private String[] csmFlagIn;
	private Boolean csmFlagIsNull;
	private Boolean csmFlagIsNotNull;
	
	private String csmFlagStart;
	
	private String csmFlagEnd;
	
	private String csmFlagLess;
	
	private String csmFlagGreater;
	
	private Short csmTypeEquals;
	private Short[] csmTypeIn;
	private Boolean csmTypeIsNull;
	private Boolean csmTypeIsNotNull;
	
	private Short csmTypeStart;
	
	private Short csmTypeEnd;
	
	private Short csmTypeLess;
	
	private Short csmTypeGreater;
	
	private Short csmFileEquals;
	private Short[] csmFileIn;
	private Boolean csmFileIsNull;
	private Boolean csmFileIsNotNull;
	
	private Short csmFileStart;
	
	private Short csmFileEnd;
	
	private Short csmFileLess;
	
	private Short csmFileGreater;
	
	private Short csmCatagoryEquals;
	private Short[] csmCatagoryIn;
	private Boolean csmCatagoryIsNull;
	private Boolean csmCatagoryIsNotNull;
	
	private Short csmCatagoryStart;
	
	private Short csmCatagoryEnd;
	
	private Short csmCatagoryLess;
	
	private Short csmCatagoryGreater;
	
	private Double csmTankCapacityEquals;
	private Double[] csmTankCapacityIn;
	private Boolean csmTankCapacityIsNull;
	private Boolean csmTankCapacityIsNotNull;
	
	private Double csmTankCapacityStart;
	
	private Double csmTankCapacityEnd;
	
	private Double csmTankCapacityLess;
	
	private Double csmTankCapacityGreater;
	
	private Double csmBatteryCapacityEquals;
	private Double[] csmBatteryCapacityIn;
	private Boolean csmBatteryCapacityIsNull;
	private Boolean csmBatteryCapacityIsNotNull;
	
	private Double csmBatteryCapacityStart;
	
	private Double csmBatteryCapacityEnd;
	
	private Double csmBatteryCapacityLess;
	
	private Double csmBatteryCapacityGreater;
	
	private Short csmStatusEquals;
	private Short[] csmStatusIn;
	private Boolean csmStatusIsNull;
	private Boolean csmStatusIsNotNull;
	
	private Short csmStatusStart;
	
	private Short csmStatusEnd;
	
	private Short csmStatusLess;
	
	private Short csmStatusGreater;
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
	private String sidx;
	private String sord;

	public CsModelQuery setCsmIdEquals(Integer csmIdEquals){
		this.csmIdEquals = csmIdEquals;
		return this;
	}
	public Integer getCsmIdEquals(){
		return this.csmIdEquals;
	}
	public CsModelQuery setCsmIdIn(Integer[] csmIdIn){
		this.csmIdIn = csmIdIn;
		return this;
	}
	public Integer[] getCsmIdIn(){
		return this.csmIdIn;
	}
	public CsModelQuery setCsmIdIsNull(Boolean csmIdIsNull){
		this.csmIdIsNull = csmIdIsNull;
		return this;
	}
	public Boolean getCsmIdIsNull(){
		return this.csmIdIsNull;
	}
	public CsModelQuery setCsmIdIsNotNull(Boolean csmIdIsNotNull){
		this.csmIdIsNotNull = csmIdIsNotNull;
		return this;
	}
	public Boolean getCsmIdIsNotNull(){
		return this.csmIdIsNotNull;
	}
	public CsModelQuery setCsmIdStart(Integer csmIdStart){
		this.csmIdStart = csmIdStart;
		return this;
	}
	public Integer getCsmIdStart(){
		return this.csmIdStart;
	}
	public CsModelQuery setCsmIdEnd(Integer csmIdEnd){
		this.csmIdEnd = csmIdEnd;
		return this;
	}
	public Integer getCsmIdEnd(){
		return this.csmIdEnd;
	}
	public CsModelQuery setCsmIdLess(Integer csmIdLess){
		this.csmIdLess = csmIdLess;
		return this;
	}
	public Integer getCsmIdLess(){
		return this.csmIdLess;
	}
	public CsModelQuery setCsmIdGreater(Integer csmIdGreater){
		this.csmIdGreater = csmIdGreater;
		return this;
	}
	public Integer getCsmIdGreater(){
		return this.csmIdGreater;
	}
	public CsModelQuery setCsmNameLike(String csmNameLike){
		this.csmNameLike = csmNameLike;
		return this;
	}
	public String getCsmNameLike(){
		return this.csmNameLike;
	}
	public CsModelQuery setCsmNameEquals(String csmNameEquals){
		this.csmNameEquals = csmNameEquals;
		return this;
	}
	public String getCsmNameEquals(){
		return this.csmNameEquals;
	}
	public CsModelQuery setCsmNameIn(String[] csmNameIn){
		this.csmNameIn = csmNameIn;
		return this;
	}
	public String[] getCsmNameIn(){
		return this.csmNameIn;
	}
	public CsModelQuery setCsmNameIsNull(Boolean csmNameIsNull){
		this.csmNameIsNull = csmNameIsNull;
		return this;
	}
	public Boolean getCsmNameIsNull(){
		return this.csmNameIsNull;
	}
	public CsModelQuery setCsmNameIsNotNull(Boolean csmNameIsNotNull){
		this.csmNameIsNotNull = csmNameIsNotNull;
		return this;
	}
	public Boolean getCsmNameIsNotNull(){
		return this.csmNameIsNotNull;
	}
	public CsModelQuery setCsmNameStart(String csmNameStart){
		this.csmNameStart = csmNameStart;
		return this;
	}
	public String getCsmNameStart(){
		return this.csmNameStart;
	}
	public CsModelQuery setCsmNameEnd(String csmNameEnd){
		this.csmNameEnd = csmNameEnd;
		return this;
	}
	public String getCsmNameEnd(){
		return this.csmNameEnd;
	}
	public CsModelQuery setCsmNameLess(String csmNameLess){
		this.csmNameLess = csmNameLess;
		return this;
	}
	public String getCsmNameLess(){
		return this.csmNameLess;
	}
	public CsModelQuery setCsmNameGreater(String csmNameGreater){
		this.csmNameGreater = csmNameGreater;
		return this;
	}
	public String getCsmNameGreater(){
		return this.csmNameGreater;
	}
	public CsModelQuery setCsmFlagLike(String csmFlagLike){
		this.csmFlagLike = csmFlagLike;
		return this;
	}
	public String getCsmFlagLike(){
		return this.csmFlagLike;
	}
	public CsModelQuery setCsmFlagEquals(String csmFlagEquals){
		this.csmFlagEquals = csmFlagEquals;
		return this;
	}
	public String getCsmFlagEquals(){
		return this.csmFlagEquals;
	}
	public CsModelQuery setCsmFlagIn(String[] csmFlagIn){
		this.csmFlagIn = csmFlagIn;
		return this;
	}
	public String[] getCsmFlagIn(){
		return this.csmFlagIn;
	}
	public CsModelQuery setCsmFlagIsNull(Boolean csmFlagIsNull){
		this.csmFlagIsNull = csmFlagIsNull;
		return this;
	}
	public Boolean getCsmFlagIsNull(){
		return this.csmFlagIsNull;
	}
	public CsModelQuery setCsmFlagIsNotNull(Boolean csmFlagIsNotNull){
		this.csmFlagIsNotNull = csmFlagIsNotNull;
		return this;
	}
	public Boolean getCsmFlagIsNotNull(){
		return this.csmFlagIsNotNull;
	}
	public CsModelQuery setCsmFlagStart(String csmFlagStart){
		this.csmFlagStart = csmFlagStart;
		return this;
	}
	public String getCsmFlagStart(){
		return this.csmFlagStart;
	}
	public CsModelQuery setCsmFlagEnd(String csmFlagEnd){
		this.csmFlagEnd = csmFlagEnd;
		return this;
	}
	public String getCsmFlagEnd(){
		return this.csmFlagEnd;
	}
	public CsModelQuery setCsmFlagLess(String csmFlagLess){
		this.csmFlagLess = csmFlagLess;
		return this;
	}
	public String getCsmFlagLess(){
		return this.csmFlagLess;
	}
	public CsModelQuery setCsmFlagGreater(String csmFlagGreater){
		this.csmFlagGreater = csmFlagGreater;
		return this;
	}
	public String getCsmFlagGreater(){
		return this.csmFlagGreater;
	}
	public CsModelQuery setCsmTypeEquals(Short csmTypeEquals){
		this.csmTypeEquals = csmTypeEquals;
		return this;
	}
	public Short getCsmTypeEquals(){
		return this.csmTypeEquals;
	}
	public CsModelQuery setCsmTypeIn(Short[] csmTypeIn){
		this.csmTypeIn = csmTypeIn;
		return this;
	}
	public Short[] getCsmTypeIn(){
		return this.csmTypeIn;
	}
	public CsModelQuery setCsmTypeIsNull(Boolean csmTypeIsNull){
		this.csmTypeIsNull = csmTypeIsNull;
		return this;
	}
	public Boolean getCsmTypeIsNull(){
		return this.csmTypeIsNull;
	}
	public CsModelQuery setCsmTypeIsNotNull(Boolean csmTypeIsNotNull){
		this.csmTypeIsNotNull = csmTypeIsNotNull;
		return this;
	}
	public Boolean getCsmTypeIsNotNull(){
		return this.csmTypeIsNotNull;
	}
	public CsModelQuery setCsmTypeStart(Short csmTypeStart){
		this.csmTypeStart = csmTypeStart;
		return this;
	}
	public Short getCsmTypeStart(){
		return this.csmTypeStart;
	}
	public CsModelQuery setCsmTypeEnd(Short csmTypeEnd){
		this.csmTypeEnd = csmTypeEnd;
		return this;
	}
	public Short getCsmTypeEnd(){
		return this.csmTypeEnd;
	}
	public CsModelQuery setCsmTypeLess(Short csmTypeLess){
		this.csmTypeLess = csmTypeLess;
		return this;
	}
	public Short getCsmTypeLess(){
		return this.csmTypeLess;
	}
	public CsModelQuery setCsmTypeGreater(Short csmTypeGreater){
		this.csmTypeGreater = csmTypeGreater;
		return this;
	}
	public Short getCsmTypeGreater(){
		return this.csmTypeGreater;
	}
	public CsModelQuery setCsmFileEquals(Short csmFileEquals){
		this.csmFileEquals = csmFileEquals;
		return this;
	}
	public Short getCsmFileEquals(){
		return this.csmFileEquals;
	}
	public CsModelQuery setCsmFileIn(Short[] csmFileIn){
		this.csmFileIn = csmFileIn;
		return this;
	}
	public Short[] getCsmFileIn(){
		return this.csmFileIn;
	}
	public CsModelQuery setCsmFileIsNull(Boolean csmFileIsNull){
		this.csmFileIsNull = csmFileIsNull;
		return this;
	}
	public Boolean getCsmFileIsNull(){
		return this.csmFileIsNull;
	}
	public CsModelQuery setCsmFileIsNotNull(Boolean csmFileIsNotNull){
		this.csmFileIsNotNull = csmFileIsNotNull;
		return this;
	}
	public Boolean getCsmFileIsNotNull(){
		return this.csmFileIsNotNull;
	}
	public CsModelQuery setCsmFileStart(Short csmFileStart){
		this.csmFileStart = csmFileStart;
		return this;
	}
	public Short getCsmFileStart(){
		return this.csmFileStart;
	}
	public CsModelQuery setCsmFileEnd(Short csmFileEnd){
		this.csmFileEnd = csmFileEnd;
		return this;
	}
	public Short getCsmFileEnd(){
		return this.csmFileEnd;
	}
	public CsModelQuery setCsmFileLess(Short csmFileLess){
		this.csmFileLess = csmFileLess;
		return this;
	}
	public Short getCsmFileLess(){
		return this.csmFileLess;
	}
	public CsModelQuery setCsmFileGreater(Short csmFileGreater){
		this.csmFileGreater = csmFileGreater;
		return this;
	}
	public Short getCsmFileGreater(){
		return this.csmFileGreater;
	}
	public CsModelQuery setCsmCatagoryEquals(Short csmCatagoryEquals){
		this.csmCatagoryEquals = csmCatagoryEquals;
		return this;
	}
	public Short getCsmCatagoryEquals(){
		return this.csmCatagoryEquals;
	}
	public CsModelQuery setCsmCatagoryIn(Short[] csmCatagoryIn){
		this.csmCatagoryIn = csmCatagoryIn;
		return this;
	}
	public Short[] getCsmCatagoryIn(){
		return this.csmCatagoryIn;
	}
	public CsModelQuery setCsmCatagoryIsNull(Boolean csmCatagoryIsNull){
		this.csmCatagoryIsNull = csmCatagoryIsNull;
		return this;
	}
	public Boolean getCsmCatagoryIsNull(){
		return this.csmCatagoryIsNull;
	}
	public CsModelQuery setCsmCatagoryIsNotNull(Boolean csmCatagoryIsNotNull){
		this.csmCatagoryIsNotNull = csmCatagoryIsNotNull;
		return this;
	}
	public Boolean getCsmCatagoryIsNotNull(){
		return this.csmCatagoryIsNotNull;
	}
	public CsModelQuery setCsmCatagoryStart(Short csmCatagoryStart){
		this.csmCatagoryStart = csmCatagoryStart;
		return this;
	}
	public Short getCsmCatagoryStart(){
		return this.csmCatagoryStart;
	}
	public CsModelQuery setCsmCatagoryEnd(Short csmCatagoryEnd){
		this.csmCatagoryEnd = csmCatagoryEnd;
		return this;
	}
	public Short getCsmCatagoryEnd(){
		return this.csmCatagoryEnd;
	}
	public CsModelQuery setCsmCatagoryLess(Short csmCatagoryLess){
		this.csmCatagoryLess = csmCatagoryLess;
		return this;
	}
	public Short getCsmCatagoryLess(){
		return this.csmCatagoryLess;
	}
	public CsModelQuery setCsmCatagoryGreater(Short csmCatagoryGreater){
		this.csmCatagoryGreater = csmCatagoryGreater;
		return this;
	}
	public Short getCsmCatagoryGreater(){
		return this.csmCatagoryGreater;
	}
	public CsModelQuery setCsmTankCapacityEquals(Double csmTankCapacityEquals){
		this.csmTankCapacityEquals = csmTankCapacityEquals;
		return this;
	}
	public Double getCsmTankCapacityEquals(){
		return this.csmTankCapacityEquals;
	}
	public CsModelQuery setCsmTankCapacityIn(Double[] csmTankCapacityIn){
		this.csmTankCapacityIn = csmTankCapacityIn;
		return this;
	}
	public Double[] getCsmTankCapacityIn(){
		return this.csmTankCapacityIn;
	}
	public CsModelQuery setCsmTankCapacityIsNull(Boolean csmTankCapacityIsNull){
		this.csmTankCapacityIsNull = csmTankCapacityIsNull;
		return this;
	}
	public Boolean getCsmTankCapacityIsNull(){
		return this.csmTankCapacityIsNull;
	}
	public CsModelQuery setCsmTankCapacityIsNotNull(Boolean csmTankCapacityIsNotNull){
		this.csmTankCapacityIsNotNull = csmTankCapacityIsNotNull;
		return this;
	}
	public Boolean getCsmTankCapacityIsNotNull(){
		return this.csmTankCapacityIsNotNull;
	}
	public CsModelQuery setCsmTankCapacityStart(Double csmTankCapacityStart){
		this.csmTankCapacityStart = csmTankCapacityStart;
		return this;
	}
	public Double getCsmTankCapacityStart(){
		return this.csmTankCapacityStart;
	}
	public CsModelQuery setCsmTankCapacityEnd(Double csmTankCapacityEnd){
		this.csmTankCapacityEnd = csmTankCapacityEnd;
		return this;
	}
	public Double getCsmTankCapacityEnd(){
		return this.csmTankCapacityEnd;
	}
	public CsModelQuery setCsmTankCapacityLess(Double csmTankCapacityLess){
		this.csmTankCapacityLess = csmTankCapacityLess;
		return this;
	}
	public Double getCsmTankCapacityLess(){
		return this.csmTankCapacityLess;
	}
	public CsModelQuery setCsmTankCapacityGreater(Double csmTankCapacityGreater){
		this.csmTankCapacityGreater = csmTankCapacityGreater;
		return this;
	}
	public Double getCsmTankCapacityGreater(){
		return this.csmTankCapacityGreater;
	}
	public CsModelQuery setCsmBatteryCapacityEquals(Double csmBatteryCapacityEquals){
		this.csmBatteryCapacityEquals = csmBatteryCapacityEquals;
		return this;
	}
	public Double getCsmBatteryCapacityEquals(){
		return this.csmBatteryCapacityEquals;
	}
	public CsModelQuery setCsmBatteryCapacityIn(Double[] csmBatteryCapacityIn){
		this.csmBatteryCapacityIn = csmBatteryCapacityIn;
		return this;
	}
	public Double[] getCsmBatteryCapacityIn(){
		return this.csmBatteryCapacityIn;
	}
	public CsModelQuery setCsmBatteryCapacityIsNull(Boolean csmBatteryCapacityIsNull){
		this.csmBatteryCapacityIsNull = csmBatteryCapacityIsNull;
		return this;
	}
	public Boolean getCsmBatteryCapacityIsNull(){
		return this.csmBatteryCapacityIsNull;
	}
	public CsModelQuery setCsmBatteryCapacityIsNotNull(Boolean csmBatteryCapacityIsNotNull){
		this.csmBatteryCapacityIsNotNull = csmBatteryCapacityIsNotNull;
		return this;
	}
	public Boolean getCsmBatteryCapacityIsNotNull(){
		return this.csmBatteryCapacityIsNotNull;
	}
	public CsModelQuery setCsmBatteryCapacityStart(Double csmBatteryCapacityStart){
		this.csmBatteryCapacityStart = csmBatteryCapacityStart;
		return this;
	}
	public Double getCsmBatteryCapacityStart(){
		return this.csmBatteryCapacityStart;
	}
	public CsModelQuery setCsmBatteryCapacityEnd(Double csmBatteryCapacityEnd){
		this.csmBatteryCapacityEnd = csmBatteryCapacityEnd;
		return this;
	}
	public Double getCsmBatteryCapacityEnd(){
		return this.csmBatteryCapacityEnd;
	}
	public CsModelQuery setCsmBatteryCapacityLess(Double csmBatteryCapacityLess){
		this.csmBatteryCapacityLess = csmBatteryCapacityLess;
		return this;
	}
	public Double getCsmBatteryCapacityLess(){
		return this.csmBatteryCapacityLess;
	}
	public CsModelQuery setCsmBatteryCapacityGreater(Double csmBatteryCapacityGreater){
		this.csmBatteryCapacityGreater = csmBatteryCapacityGreater;
		return this;
	}
	public Double getCsmBatteryCapacityGreater(){
		return this.csmBatteryCapacityGreater;
	}
	public CsModelQuery setCsmStatusEquals(Short csmStatusEquals){
		this.csmStatusEquals = csmStatusEquals;
		return this;
	}
	public Short getCsmStatusEquals(){
		return this.csmStatusEquals;
	}
	public CsModelQuery setCsmStatusIn(Short[] csmStatusIn){
		this.csmStatusIn = csmStatusIn;
		return this;
	}
	public Short[] getCsmStatusIn(){
		return this.csmStatusIn;
	}
	public CsModelQuery setCsmStatusIsNull(Boolean csmStatusIsNull){
		this.csmStatusIsNull = csmStatusIsNull;
		return this;
	}
	public Boolean getCsmStatusIsNull(){
		return this.csmStatusIsNull;
	}
	public CsModelQuery setCsmStatusIsNotNull(Boolean csmStatusIsNotNull){
		this.csmStatusIsNotNull = csmStatusIsNotNull;
		return this;
	}
	public Boolean getCsmStatusIsNotNull(){
		return this.csmStatusIsNotNull;
	}
	public CsModelQuery setCsmStatusStart(Short csmStatusStart){
		this.csmStatusStart = csmStatusStart;
		return this;
	}
	public Short getCsmStatusStart(){
		return this.csmStatusStart;
	}
	public CsModelQuery setCsmStatusEnd(Short csmStatusEnd){
		this.csmStatusEnd = csmStatusEnd;
		return this;
	}
	public Short getCsmStatusEnd(){
		return this.csmStatusEnd;
	}
	public CsModelQuery setCsmStatusLess(Short csmStatusLess){
		this.csmStatusLess = csmStatusLess;
		return this;
	}
	public Short getCsmStatusLess(){
		return this.csmStatusLess;
	}
	public CsModelQuery setCsmStatusGreater(Short csmStatusGreater){
		this.csmStatusGreater = csmStatusGreater;
		return this;
	}
	public Short getCsmStatusGreater(){
		return this.csmStatusGreater;
	}
	public CsModelQuery setCsmAddTimeEquals(Date csmAddTimeEquals){
		this.csmAddTimeEquals = csmAddTimeEquals;
		return this;
	}
	public Date getCsmAddTimeEquals(){
		return this.csmAddTimeEquals;
	}
	public CsModelQuery setCsmAddTimeIn(Date[] csmAddTimeIn){
		this.csmAddTimeIn = csmAddTimeIn;
		return this;
	}
	public Date[] getCsmAddTimeIn(){
		return this.csmAddTimeIn;
	}
	public CsModelQuery setCsmAddTimeIsNull(Boolean csmAddTimeIsNull){
		this.csmAddTimeIsNull = csmAddTimeIsNull;
		return this;
	}
	public Boolean getCsmAddTimeIsNull(){
		return this.csmAddTimeIsNull;
	}
	public CsModelQuery setCsmAddTimeIsNotNull(Boolean csmAddTimeIsNotNull){
		this.csmAddTimeIsNotNull = csmAddTimeIsNotNull;
		return this;
	}
	public Boolean getCsmAddTimeIsNotNull(){
		return this.csmAddTimeIsNotNull;
	}
	public CsModelQuery setCsmAddTimeStart(Date csmAddTimeStart){
		this.csmAddTimeStart = csmAddTimeStart;
		return this;
	}
	public Date getCsmAddTimeStart(){
		return this.csmAddTimeStart;
	}
	public CsModelQuery setCsmAddTimeEnd(Date csmAddTimeEnd){
		this.csmAddTimeEnd = csmAddTimeEnd;
		return this;
	}
	public Date getCsmAddTimeEnd(){
		return this.csmAddTimeEnd;
	}
	public CsModelQuery setCsmAddTimeLess(Date csmAddTimeLess){
		this.csmAddTimeLess = csmAddTimeLess;
		return this;
	}
	public Date getCsmAddTimeLess(){
		return this.csmAddTimeLess;
	}
	public CsModelQuery setCsmAddTimeGreater(Date csmAddTimeGreater){
		this.csmAddTimeGreater = csmAddTimeGreater;
		return this;
	}
	public Date getCsmAddTimeGreater(){
		return this.csmAddTimeGreater;
	}
	public CsModelQuery setCsmUpdateTimeEquals(Date csmUpdateTimeEquals){
		this.csmUpdateTimeEquals = csmUpdateTimeEquals;
		return this;
	}
	public Date getCsmUpdateTimeEquals(){
		return this.csmUpdateTimeEquals;
	}
	public CsModelQuery setCsmUpdateTimeIn(Date[] csmUpdateTimeIn){
		this.csmUpdateTimeIn = csmUpdateTimeIn;
		return this;
	}
	public Date[] getCsmUpdateTimeIn(){
		return this.csmUpdateTimeIn;
	}
	public CsModelQuery setCsmUpdateTimeIsNull(Boolean csmUpdateTimeIsNull){
		this.csmUpdateTimeIsNull = csmUpdateTimeIsNull;
		return this;
	}
	public Boolean getCsmUpdateTimeIsNull(){
		return this.csmUpdateTimeIsNull;
	}
	public CsModelQuery setCsmUpdateTimeIsNotNull(Boolean csmUpdateTimeIsNotNull){
		this.csmUpdateTimeIsNotNull = csmUpdateTimeIsNotNull;
		return this;
	}
	public Boolean getCsmUpdateTimeIsNotNull(){
		return this.csmUpdateTimeIsNotNull;
	}
	public CsModelQuery setCsmUpdateTimeStart(Date csmUpdateTimeStart){
		this.csmUpdateTimeStart = csmUpdateTimeStart;
		return this;
	}
	public Date getCsmUpdateTimeStart(){
		return this.csmUpdateTimeStart;
	}
	public CsModelQuery setCsmUpdateTimeEnd(Date csmUpdateTimeEnd){
		this.csmUpdateTimeEnd = csmUpdateTimeEnd;
		return this;
	}
	public Date getCsmUpdateTimeEnd(){
		return this.csmUpdateTimeEnd;
	}
	public CsModelQuery setCsmUpdateTimeLess(Date csmUpdateTimeLess){
		this.csmUpdateTimeLess = csmUpdateTimeLess;
		return this;
	}
	public Date getCsmUpdateTimeLess(){
		return this.csmUpdateTimeLess;
	}
	public CsModelQuery setCsmUpdateTimeGreater(Date csmUpdateTimeGreater){
		this.csmUpdateTimeGreater = csmUpdateTimeGreater;
		return this;
	}
	public Date getCsmUpdateTimeGreater(){
		return this.csmUpdateTimeGreater;
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
		else if(this.sidx.equals("csmName")){
			return "csm_name";
		}
		else if(this.sidx.equals("csmFlag")){
			return "csm_flag";
		}
		else if(this.sidx.equals("csmType")){
			return "csm_type";
		}
		else if(this.sidx.equals("csmFile")){
			return "csm_file";
		}
		else if(this.sidx.equals("csmCatagory")){
			return "csm_catagory";
		}
		else if(this.sidx.equals("csmTankCapacity")){
			return "csm_tank_capacity";
		}
		else if(this.sidx.equals("csmBatteryCapacity")){
			return "csm_battery_capacity";
		}
		else if(this.sidx.equals("csmStatus")){
			return "csm_status";
		}
		else if(this.sidx.equals("csmAddTime")){
			return "csm_add_time";
		}
		else if(this.sidx.equals("csmUpdateTime")){
			return "csm_update_time";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsModelCrieria getCrieria(){
		CsModelCrieria q = new CsModelCrieria();
		CsModelCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getCsmNameEquals()!=null){
			c.andcsmNameEqualTo(this.getCsmNameEquals());
		}else if(this.getCsmNameIsNull()!=null && this.getCsmNameIsNull()){
			c.andcsmNameIsNull();
		}else if(this.getCsmNameIsNotNull()!=null && this.getCsmNameIsNotNull()){
			c.andcsmNameIsNotNull();
		}else if(this.getCsmNameLike()!=null){
			c.andcsmNameLike(this.getCsmNameLike());
		}else if(this.getCsmNameIn()!=null){
			c.andcsmNameIn(java.util.Arrays.asList(this.getCsmNameIn()));
		}else if(this.getCsmNameStart()!=null && this.getCsmNameEnd()!=null){
			c.andcsmNameBetween(this.getCsmNameStart(), this.getCsmNameEnd());
		}else if(this.getCsmNameGreater()!=null){
			c.andcsmNameGreaterThan(this.getCsmNameGreater());
		}else if(this.getCsmNameLess()!=null){
			c.andcsmNameLessThan(this.getCsmNameLess());
		}
		if(this.getCsmFlagEquals()!=null){
			c.andcsmFlagEqualTo(this.getCsmFlagEquals());
		}else if(this.getCsmFlagIsNull()!=null && this.getCsmFlagIsNull()){
			c.andcsmFlagIsNull();
		}else if(this.getCsmFlagIsNotNull()!=null && this.getCsmFlagIsNotNull()){
			c.andcsmFlagIsNotNull();
		}else if(this.getCsmFlagLike()!=null){
			c.andcsmFlagLike(this.getCsmFlagLike());
		}else if(this.getCsmFlagIn()!=null){
			c.andcsmFlagIn(java.util.Arrays.asList(this.getCsmFlagIn()));
		}else if(this.getCsmFlagStart()!=null && this.getCsmFlagEnd()!=null){
			c.andcsmFlagBetween(this.getCsmFlagStart(), this.getCsmFlagEnd());
		}else if(this.getCsmFlagGreater()!=null){
			c.andcsmFlagGreaterThan(this.getCsmFlagGreater());
		}else if(this.getCsmFlagLess()!=null){
			c.andcsmFlagLessThan(this.getCsmFlagLess());
		}
		if(this.getCsmTypeEquals()!=null){
			c.andcsmTypeEqualTo(this.getCsmTypeEquals());
		}else if(this.getCsmTypeIsNull()!=null && this.getCsmTypeIsNull()){
			c.andcsmTypeIsNull();
		}else if(this.getCsmTypeIsNotNull()!=null && this.getCsmTypeIsNotNull()){
			c.andcsmTypeIsNotNull();
		}else if(this.getCsmTypeIn()!=null){
			c.andcsmTypeIn(java.util.Arrays.asList(this.getCsmTypeIn()));
		}else if(this.getCsmTypeStart()!=null && this.getCsmTypeEnd()!=null){
			c.andcsmTypeBetween(this.getCsmTypeStart(), this.getCsmTypeEnd());
		}else if(this.getCsmTypeGreater()!=null){
			c.andcsmTypeGreaterThan(this.getCsmTypeGreater());
		}else if(this.getCsmTypeLess()!=null){
			c.andcsmTypeLessThan(this.getCsmTypeLess());
		}
		if(this.getCsmFileEquals()!=null){
			c.andcsmFileEqualTo(this.getCsmFileEquals());
		}else if(this.getCsmFileIsNull()!=null && this.getCsmFileIsNull()){
			c.andcsmFileIsNull();
		}else if(this.getCsmFileIsNotNull()!=null && this.getCsmFileIsNotNull()){
			c.andcsmFileIsNotNull();
		}else if(this.getCsmFileIn()!=null){
			c.andcsmFileIn(java.util.Arrays.asList(this.getCsmFileIn()));
		}else if(this.getCsmFileStart()!=null && this.getCsmFileEnd()!=null){
			c.andcsmFileBetween(this.getCsmFileStart(), this.getCsmFileEnd());
		}else if(this.getCsmFileGreater()!=null){
			c.andcsmFileGreaterThan(this.getCsmFileGreater());
		}else if(this.getCsmFileLess()!=null){
			c.andcsmFileLessThan(this.getCsmFileLess());
		}
		if(this.getCsmCatagoryEquals()!=null){
			c.andcsmCatagoryEqualTo(this.getCsmCatagoryEquals());
		}else if(this.getCsmCatagoryIsNull()!=null && this.getCsmCatagoryIsNull()){
			c.andcsmCatagoryIsNull();
		}else if(this.getCsmCatagoryIsNotNull()!=null && this.getCsmCatagoryIsNotNull()){
			c.andcsmCatagoryIsNotNull();
		}else if(this.getCsmCatagoryIn()!=null){
			c.andcsmCatagoryIn(java.util.Arrays.asList(this.getCsmCatagoryIn()));
		}else if(this.getCsmCatagoryStart()!=null && this.getCsmCatagoryEnd()!=null){
			c.andcsmCatagoryBetween(this.getCsmCatagoryStart(), this.getCsmCatagoryEnd());
		}else if(this.getCsmCatagoryGreater()!=null){
			c.andcsmCatagoryGreaterThan(this.getCsmCatagoryGreater());
		}else if(this.getCsmCatagoryLess()!=null){
			c.andcsmCatagoryLessThan(this.getCsmCatagoryLess());
		}
		if(this.getCsmTankCapacityEquals()!=null){
			c.andcsmTankCapacityEqualTo(this.getCsmTankCapacityEquals());
		}else if(this.getCsmTankCapacityIsNull()!=null && this.getCsmTankCapacityIsNull()){
			c.andcsmTankCapacityIsNull();
		}else if(this.getCsmTankCapacityIsNotNull()!=null && this.getCsmTankCapacityIsNotNull()){
			c.andcsmTankCapacityIsNotNull();
		}else if(this.getCsmTankCapacityIn()!=null){
			c.andcsmTankCapacityIn(java.util.Arrays.asList(this.getCsmTankCapacityIn()));
		}else if(this.getCsmTankCapacityStart()!=null && this.getCsmTankCapacityEnd()!=null){
			c.andcsmTankCapacityBetween(this.getCsmTankCapacityStart(), this.getCsmTankCapacityEnd());
		}else if(this.getCsmTankCapacityGreater()!=null){
			c.andcsmTankCapacityGreaterThan(this.getCsmTankCapacityGreater());
		}else if(this.getCsmTankCapacityLess()!=null){
			c.andcsmTankCapacityLessThan(this.getCsmTankCapacityLess());
		}
		if(this.getCsmBatteryCapacityEquals()!=null){
			c.andcsmBatteryCapacityEqualTo(this.getCsmBatteryCapacityEquals());
		}else if(this.getCsmBatteryCapacityIsNull()!=null && this.getCsmBatteryCapacityIsNull()){
			c.andcsmBatteryCapacityIsNull();
		}else if(this.getCsmBatteryCapacityIsNotNull()!=null && this.getCsmBatteryCapacityIsNotNull()){
			c.andcsmBatteryCapacityIsNotNull();
		}else if(this.getCsmBatteryCapacityIn()!=null){
			c.andcsmBatteryCapacityIn(java.util.Arrays.asList(this.getCsmBatteryCapacityIn()));
		}else if(this.getCsmBatteryCapacityStart()!=null && this.getCsmBatteryCapacityEnd()!=null){
			c.andcsmBatteryCapacityBetween(this.getCsmBatteryCapacityStart(), this.getCsmBatteryCapacityEnd());
		}else if(this.getCsmBatteryCapacityGreater()!=null){
			c.andcsmBatteryCapacityGreaterThan(this.getCsmBatteryCapacityGreater());
		}else if(this.getCsmBatteryCapacityLess()!=null){
			c.andcsmBatteryCapacityLessThan(this.getCsmBatteryCapacityLess());
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
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
