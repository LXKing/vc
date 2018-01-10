package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsTerminalCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsTerminalQuery {
	
	private Long cstIdEquals;
	private Long[] cstIdIn;
	private Boolean cstIdIsNull;
	private Boolean cstIdIsNotNull;
	
	private Long cstIdStart;
	
	private Long cstIdEnd;
	
	private Long cstIdLess;
	
	private Long cstIdGreater;
	private String cstIddLike;
	
	private String cstIddEquals;
	private String[] cstIddIn;
	private Boolean cstIddIsNull;
	private Boolean cstIddIsNotNull;
	
	private String cstIddStart;
	
	private String cstIddEnd;
	
	private String cstIddLess;
	
	private String cstIddGreater;
	private String cstModelLike;
	
	private String cstModelEquals;
	private String[] cstModelIn;
	private Boolean cstModelIsNull;
	private Boolean cstModelIsNotNull;
	
	private String cstModelStart;
	
	private String cstModelEnd;
	
	private String cstModelLess;
	
	private String cstModelGreater;
	private String cstMadeLike;
	
	private String cstMadeEquals;
	private String[] cstMadeIn;
	private Boolean cstMadeIsNull;
	private Boolean cstMadeIsNotNull;
	
	private String cstMadeStart;
	
	private String cstMadeEnd;
	
	private String cstMadeLess;
	
	private String cstMadeGreater;
	private String cstProvinceLike;
	
	private String cstProvinceEquals;
	private String[] cstProvinceIn;
	private Boolean cstProvinceIsNull;
	private Boolean cstProvinceIsNotNull;
	
	private String cstProvinceStart;
	
	private String cstProvinceEnd;
	
	private String cstProvinceLess;
	
	private String cstProvinceGreater;
	private String cstCityLike;
	
	private String cstCityEquals;
	private String[] cstCityIn;
	private Boolean cstCityIsNull;
	private Boolean cstCityIsNotNull;
	
	private String cstCityStart;
	
	private String cstCityEnd;
	
	private String cstCityLess;
	
	private String cstCityGreater;
	
	private Short cstColorEquals;
	private Short[] cstColorIn;
	private Boolean cstColorIsNull;
	private Boolean cstColorIsNotNull;
	
	private Short cstColorStart;
	
	private Short cstColorEnd;
	
	private Short cstColorLess;
	
	private Short cstColorGreater;
	private String cstNumberLike;
	
	private String cstNumberEquals;
	private String[] cstNumberIn;
	private Boolean cstNumberIsNull;
	private Boolean cstNumberIsNotNull;
	
	private String cstNumberStart;
	
	private String cstNumberEnd;
	
	private String cstNumberLess;
	
	private String cstNumberGreater;
	private String cstMobileLike;
	
	private String cstMobileEquals;
	private String[] cstMobileIn;
	private Boolean cstMobileIsNull;
	private Boolean cstMobileIsNotNull;
	
	private String cstMobileStart;
	
	private String cstMobileEnd;
	
	private String cstMobileLess;
	
	private String cstMobileGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstUpdateTimeEquals;
	private Date[] cstUpdateTimeIn;
	private Boolean cstUpdateTimeIsNull;
	private Boolean cstUpdateTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstUpdateTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstUpdateTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstUpdateTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstUpdateTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstAddTimeEquals;
	private Date[] cstAddTimeIn;
	private Boolean cstAddTimeIsNull;
	private Boolean cstAddTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstAddTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cstAddTimeGreater;
	
	private Short cstStatusEquals;
	private Short[] cstStatusIn;
	private Boolean cstStatusIsNull;
	private Boolean cstStatusIsNotNull;
	
	private Short cstStatusStart;
	
	private Short cstStatusEnd;
	
	private Short cstStatusLess;
	
	private Short cstStatusGreater;
	private String sidx;
	private String sord;

	public CsTerminalQuery setCstIdEquals(Long cstIdEquals){
		this.cstIdEquals = cstIdEquals;
		return this;
	}
	public Long getCstIdEquals(){
		return this.cstIdEquals;
	}
	public CsTerminalQuery setCstIdIn(Long[] cstIdIn){
		this.cstIdIn = cstIdIn;
		return this;
	}
	public Long[] getCstIdIn(){
		return this.cstIdIn;
	}
	public CsTerminalQuery setCstIdIsNull(Boolean cstIdIsNull){
		this.cstIdIsNull = cstIdIsNull;
		return this;
	}
	public Boolean getCstIdIsNull(){
		return this.cstIdIsNull;
	}
	public CsTerminalQuery setCstIdIsNotNull(Boolean cstIdIsNotNull){
		this.cstIdIsNotNull = cstIdIsNotNull;
		return this;
	}
	public Boolean getCstIdIsNotNull(){
		return this.cstIdIsNotNull;
	}
	public CsTerminalQuery setCstIdStart(Long cstIdStart){
		this.cstIdStart = cstIdStart;
		return this;
	}
	public Long getCstIdStart(){
		return this.cstIdStart;
	}
	public CsTerminalQuery setCstIdEnd(Long cstIdEnd){
		this.cstIdEnd = cstIdEnd;
		return this;
	}
	public Long getCstIdEnd(){
		return this.cstIdEnd;
	}
	public CsTerminalQuery setCstIdLess(Long cstIdLess){
		this.cstIdLess = cstIdLess;
		return this;
	}
	public Long getCstIdLess(){
		return this.cstIdLess;
	}
	public CsTerminalQuery setCstIdGreater(Long cstIdGreater){
		this.cstIdGreater = cstIdGreater;
		return this;
	}
	public Long getCstIdGreater(){
		return this.cstIdGreater;
	}
	public CsTerminalQuery setCstIddLike(String cstIddLike){
		this.cstIddLike = cstIddLike;
		return this;
	}
	public String getCstIddLike(){
		return this.cstIddLike;
	}
	public CsTerminalQuery setCstIddEquals(String cstIddEquals){
		this.cstIddEquals = cstIddEquals;
		return this;
	}
	public String getCstIddEquals(){
		return this.cstIddEquals;
	}
	public CsTerminalQuery setCstIddIn(String[] cstIddIn){
		this.cstIddIn = cstIddIn;
		return this;
	}
	public String[] getCstIddIn(){
		return this.cstIddIn;
	}
	public CsTerminalQuery setCstIddIsNull(Boolean cstIddIsNull){
		this.cstIddIsNull = cstIddIsNull;
		return this;
	}
	public Boolean getCstIddIsNull(){
		return this.cstIddIsNull;
	}
	public CsTerminalQuery setCstIddIsNotNull(Boolean cstIddIsNotNull){
		this.cstIddIsNotNull = cstIddIsNotNull;
		return this;
	}
	public Boolean getCstIddIsNotNull(){
		return this.cstIddIsNotNull;
	}
	public CsTerminalQuery setCstIddStart(String cstIddStart){
		this.cstIddStart = cstIddStart;
		return this;
	}
	public String getCstIddStart(){
		return this.cstIddStart;
	}
	public CsTerminalQuery setCstIddEnd(String cstIddEnd){
		this.cstIddEnd = cstIddEnd;
		return this;
	}
	public String getCstIddEnd(){
		return this.cstIddEnd;
	}
	public CsTerminalQuery setCstIddLess(String cstIddLess){
		this.cstIddLess = cstIddLess;
		return this;
	}
	public String getCstIddLess(){
		return this.cstIddLess;
	}
	public CsTerminalQuery setCstIddGreater(String cstIddGreater){
		this.cstIddGreater = cstIddGreater;
		return this;
	}
	public String getCstIddGreater(){
		return this.cstIddGreater;
	}
	public CsTerminalQuery setCstModelLike(String cstModelLike){
		this.cstModelLike = cstModelLike;
		return this;
	}
	public String getCstModelLike(){
		return this.cstModelLike;
	}
	public CsTerminalQuery setCstModelEquals(String cstModelEquals){
		this.cstModelEquals = cstModelEquals;
		return this;
	}
	public String getCstModelEquals(){
		return this.cstModelEquals;
	}
	public CsTerminalQuery setCstModelIn(String[] cstModelIn){
		this.cstModelIn = cstModelIn;
		return this;
	}
	public String[] getCstModelIn(){
		return this.cstModelIn;
	}
	public CsTerminalQuery setCstModelIsNull(Boolean cstModelIsNull){
		this.cstModelIsNull = cstModelIsNull;
		return this;
	}
	public Boolean getCstModelIsNull(){
		return this.cstModelIsNull;
	}
	public CsTerminalQuery setCstModelIsNotNull(Boolean cstModelIsNotNull){
		this.cstModelIsNotNull = cstModelIsNotNull;
		return this;
	}
	public Boolean getCstModelIsNotNull(){
		return this.cstModelIsNotNull;
	}
	public CsTerminalQuery setCstModelStart(String cstModelStart){
		this.cstModelStart = cstModelStart;
		return this;
	}
	public String getCstModelStart(){
		return this.cstModelStart;
	}
	public CsTerminalQuery setCstModelEnd(String cstModelEnd){
		this.cstModelEnd = cstModelEnd;
		return this;
	}
	public String getCstModelEnd(){
		return this.cstModelEnd;
	}
	public CsTerminalQuery setCstModelLess(String cstModelLess){
		this.cstModelLess = cstModelLess;
		return this;
	}
	public String getCstModelLess(){
		return this.cstModelLess;
	}
	public CsTerminalQuery setCstModelGreater(String cstModelGreater){
		this.cstModelGreater = cstModelGreater;
		return this;
	}
	public String getCstModelGreater(){
		return this.cstModelGreater;
	}
	public CsTerminalQuery setCstMadeLike(String cstMadeLike){
		this.cstMadeLike = cstMadeLike;
		return this;
	}
	public String getCstMadeLike(){
		return this.cstMadeLike;
	}
	public CsTerminalQuery setCstMadeEquals(String cstMadeEquals){
		this.cstMadeEquals = cstMadeEquals;
		return this;
	}
	public String getCstMadeEquals(){
		return this.cstMadeEquals;
	}
	public CsTerminalQuery setCstMadeIn(String[] cstMadeIn){
		this.cstMadeIn = cstMadeIn;
		return this;
	}
	public String[] getCstMadeIn(){
		return this.cstMadeIn;
	}
	public CsTerminalQuery setCstMadeIsNull(Boolean cstMadeIsNull){
		this.cstMadeIsNull = cstMadeIsNull;
		return this;
	}
	public Boolean getCstMadeIsNull(){
		return this.cstMadeIsNull;
	}
	public CsTerminalQuery setCstMadeIsNotNull(Boolean cstMadeIsNotNull){
		this.cstMadeIsNotNull = cstMadeIsNotNull;
		return this;
	}
	public Boolean getCstMadeIsNotNull(){
		return this.cstMadeIsNotNull;
	}
	public CsTerminalQuery setCstMadeStart(String cstMadeStart){
		this.cstMadeStart = cstMadeStart;
		return this;
	}
	public String getCstMadeStart(){
		return this.cstMadeStart;
	}
	public CsTerminalQuery setCstMadeEnd(String cstMadeEnd){
		this.cstMadeEnd = cstMadeEnd;
		return this;
	}
	public String getCstMadeEnd(){
		return this.cstMadeEnd;
	}
	public CsTerminalQuery setCstMadeLess(String cstMadeLess){
		this.cstMadeLess = cstMadeLess;
		return this;
	}
	public String getCstMadeLess(){
		return this.cstMadeLess;
	}
	public CsTerminalQuery setCstMadeGreater(String cstMadeGreater){
		this.cstMadeGreater = cstMadeGreater;
		return this;
	}
	public String getCstMadeGreater(){
		return this.cstMadeGreater;
	}
	public CsTerminalQuery setCstProvinceLike(String cstProvinceLike){
		this.cstProvinceLike = cstProvinceLike;
		return this;
	}
	public String getCstProvinceLike(){
		return this.cstProvinceLike;
	}
	public CsTerminalQuery setCstProvinceEquals(String cstProvinceEquals){
		this.cstProvinceEquals = cstProvinceEquals;
		return this;
	}
	public String getCstProvinceEquals(){
		return this.cstProvinceEquals;
	}
	public CsTerminalQuery setCstProvinceIn(String[] cstProvinceIn){
		this.cstProvinceIn = cstProvinceIn;
		return this;
	}
	public String[] getCstProvinceIn(){
		return this.cstProvinceIn;
	}
	public CsTerminalQuery setCstProvinceIsNull(Boolean cstProvinceIsNull){
		this.cstProvinceIsNull = cstProvinceIsNull;
		return this;
	}
	public Boolean getCstProvinceIsNull(){
		return this.cstProvinceIsNull;
	}
	public CsTerminalQuery setCstProvinceIsNotNull(Boolean cstProvinceIsNotNull){
		this.cstProvinceIsNotNull = cstProvinceIsNotNull;
		return this;
	}
	public Boolean getCstProvinceIsNotNull(){
		return this.cstProvinceIsNotNull;
	}
	public CsTerminalQuery setCstProvinceStart(String cstProvinceStart){
		this.cstProvinceStart = cstProvinceStart;
		return this;
	}
	public String getCstProvinceStart(){
		return this.cstProvinceStart;
	}
	public CsTerminalQuery setCstProvinceEnd(String cstProvinceEnd){
		this.cstProvinceEnd = cstProvinceEnd;
		return this;
	}
	public String getCstProvinceEnd(){
		return this.cstProvinceEnd;
	}
	public CsTerminalQuery setCstProvinceLess(String cstProvinceLess){
		this.cstProvinceLess = cstProvinceLess;
		return this;
	}
	public String getCstProvinceLess(){
		return this.cstProvinceLess;
	}
	public CsTerminalQuery setCstProvinceGreater(String cstProvinceGreater){
		this.cstProvinceGreater = cstProvinceGreater;
		return this;
	}
	public String getCstProvinceGreater(){
		return this.cstProvinceGreater;
	}
	public CsTerminalQuery setCstCityLike(String cstCityLike){
		this.cstCityLike = cstCityLike;
		return this;
	}
	public String getCstCityLike(){
		return this.cstCityLike;
	}
	public CsTerminalQuery setCstCityEquals(String cstCityEquals){
		this.cstCityEquals = cstCityEquals;
		return this;
	}
	public String getCstCityEquals(){
		return this.cstCityEquals;
	}
	public CsTerminalQuery setCstCityIn(String[] cstCityIn){
		this.cstCityIn = cstCityIn;
		return this;
	}
	public String[] getCstCityIn(){
		return this.cstCityIn;
	}
	public CsTerminalQuery setCstCityIsNull(Boolean cstCityIsNull){
		this.cstCityIsNull = cstCityIsNull;
		return this;
	}
	public Boolean getCstCityIsNull(){
		return this.cstCityIsNull;
	}
	public CsTerminalQuery setCstCityIsNotNull(Boolean cstCityIsNotNull){
		this.cstCityIsNotNull = cstCityIsNotNull;
		return this;
	}
	public Boolean getCstCityIsNotNull(){
		return this.cstCityIsNotNull;
	}
	public CsTerminalQuery setCstCityStart(String cstCityStart){
		this.cstCityStart = cstCityStart;
		return this;
	}
	public String getCstCityStart(){
		return this.cstCityStart;
	}
	public CsTerminalQuery setCstCityEnd(String cstCityEnd){
		this.cstCityEnd = cstCityEnd;
		return this;
	}
	public String getCstCityEnd(){
		return this.cstCityEnd;
	}
	public CsTerminalQuery setCstCityLess(String cstCityLess){
		this.cstCityLess = cstCityLess;
		return this;
	}
	public String getCstCityLess(){
		return this.cstCityLess;
	}
	public CsTerminalQuery setCstCityGreater(String cstCityGreater){
		this.cstCityGreater = cstCityGreater;
		return this;
	}
	public String getCstCityGreater(){
		return this.cstCityGreater;
	}
	public CsTerminalQuery setCstColorEquals(Short cstColorEquals){
		this.cstColorEquals = cstColorEquals;
		return this;
	}
	public Short getCstColorEquals(){
		return this.cstColorEquals;
	}
	public CsTerminalQuery setCstColorIn(Short[] cstColorIn){
		this.cstColorIn = cstColorIn;
		return this;
	}
	public Short[] getCstColorIn(){
		return this.cstColorIn;
	}
	public CsTerminalQuery setCstColorIsNull(Boolean cstColorIsNull){
		this.cstColorIsNull = cstColorIsNull;
		return this;
	}
	public Boolean getCstColorIsNull(){
		return this.cstColorIsNull;
	}
	public CsTerminalQuery setCstColorIsNotNull(Boolean cstColorIsNotNull){
		this.cstColorIsNotNull = cstColorIsNotNull;
		return this;
	}
	public Boolean getCstColorIsNotNull(){
		return this.cstColorIsNotNull;
	}
	public CsTerminalQuery setCstColorStart(Short cstColorStart){
		this.cstColorStart = cstColorStart;
		return this;
	}
	public Short getCstColorStart(){
		return this.cstColorStart;
	}
	public CsTerminalQuery setCstColorEnd(Short cstColorEnd){
		this.cstColorEnd = cstColorEnd;
		return this;
	}
	public Short getCstColorEnd(){
		return this.cstColorEnd;
	}
	public CsTerminalQuery setCstColorLess(Short cstColorLess){
		this.cstColorLess = cstColorLess;
		return this;
	}
	public Short getCstColorLess(){
		return this.cstColorLess;
	}
	public CsTerminalQuery setCstColorGreater(Short cstColorGreater){
		this.cstColorGreater = cstColorGreater;
		return this;
	}
	public Short getCstColorGreater(){
		return this.cstColorGreater;
	}
	public CsTerminalQuery setCstNumberLike(String cstNumberLike){
		this.cstNumberLike = cstNumberLike;
		return this;
	}
	public String getCstNumberLike(){
		return this.cstNumberLike;
	}
	public CsTerminalQuery setCstNumberEquals(String cstNumberEquals){
		this.cstNumberEquals = cstNumberEquals;
		return this;
	}
	public String getCstNumberEquals(){
		return this.cstNumberEquals;
	}
	public CsTerminalQuery setCstNumberIn(String[] cstNumberIn){
		this.cstNumberIn = cstNumberIn;
		return this;
	}
	public String[] getCstNumberIn(){
		return this.cstNumberIn;
	}
	public CsTerminalQuery setCstNumberIsNull(Boolean cstNumberIsNull){
		this.cstNumberIsNull = cstNumberIsNull;
		return this;
	}
	public Boolean getCstNumberIsNull(){
		return this.cstNumberIsNull;
	}
	public CsTerminalQuery setCstNumberIsNotNull(Boolean cstNumberIsNotNull){
		this.cstNumberIsNotNull = cstNumberIsNotNull;
		return this;
	}
	public Boolean getCstNumberIsNotNull(){
		return this.cstNumberIsNotNull;
	}
	public CsTerminalQuery setCstNumberStart(String cstNumberStart){
		this.cstNumberStart = cstNumberStart;
		return this;
	}
	public String getCstNumberStart(){
		return this.cstNumberStart;
	}
	public CsTerminalQuery setCstNumberEnd(String cstNumberEnd){
		this.cstNumberEnd = cstNumberEnd;
		return this;
	}
	public String getCstNumberEnd(){
		return this.cstNumberEnd;
	}
	public CsTerminalQuery setCstNumberLess(String cstNumberLess){
		this.cstNumberLess = cstNumberLess;
		return this;
	}
	public String getCstNumberLess(){
		return this.cstNumberLess;
	}
	public CsTerminalQuery setCstNumberGreater(String cstNumberGreater){
		this.cstNumberGreater = cstNumberGreater;
		return this;
	}
	public String getCstNumberGreater(){
		return this.cstNumberGreater;
	}
	public CsTerminalQuery setCstMobileLike(String cstMobileLike){
		this.cstMobileLike = cstMobileLike;
		return this;
	}
	public String getCstMobileLike(){
		return this.cstMobileLike;
	}
	public CsTerminalQuery setCstMobileEquals(String cstMobileEquals){
		this.cstMobileEquals = cstMobileEquals;
		return this;
	}
	public String getCstMobileEquals(){
		return this.cstMobileEquals;
	}
	public CsTerminalQuery setCstMobileIn(String[] cstMobileIn){
		this.cstMobileIn = cstMobileIn;
		return this;
	}
	public String[] getCstMobileIn(){
		return this.cstMobileIn;
	}
	public CsTerminalQuery setCstMobileIsNull(Boolean cstMobileIsNull){
		this.cstMobileIsNull = cstMobileIsNull;
		return this;
	}
	public Boolean getCstMobileIsNull(){
		return this.cstMobileIsNull;
	}
	public CsTerminalQuery setCstMobileIsNotNull(Boolean cstMobileIsNotNull){
		this.cstMobileIsNotNull = cstMobileIsNotNull;
		return this;
	}
	public Boolean getCstMobileIsNotNull(){
		return this.cstMobileIsNotNull;
	}
	public CsTerminalQuery setCstMobileStart(String cstMobileStart){
		this.cstMobileStart = cstMobileStart;
		return this;
	}
	public String getCstMobileStart(){
		return this.cstMobileStart;
	}
	public CsTerminalQuery setCstMobileEnd(String cstMobileEnd){
		this.cstMobileEnd = cstMobileEnd;
		return this;
	}
	public String getCstMobileEnd(){
		return this.cstMobileEnd;
	}
	public CsTerminalQuery setCstMobileLess(String cstMobileLess){
		this.cstMobileLess = cstMobileLess;
		return this;
	}
	public String getCstMobileLess(){
		return this.cstMobileLess;
	}
	public CsTerminalQuery setCstMobileGreater(String cstMobileGreater){
		this.cstMobileGreater = cstMobileGreater;
		return this;
	}
	public String getCstMobileGreater(){
		return this.cstMobileGreater;
	}
	public CsTerminalQuery setCstUpdateTimeEquals(Date cstUpdateTimeEquals){
		this.cstUpdateTimeEquals = cstUpdateTimeEquals;
		return this;
	}
	public Date getCstUpdateTimeEquals(){
		return this.cstUpdateTimeEquals;
	}
	public CsTerminalQuery setCstUpdateTimeIn(Date[] cstUpdateTimeIn){
		this.cstUpdateTimeIn = cstUpdateTimeIn;
		return this;
	}
	public Date[] getCstUpdateTimeIn(){
		return this.cstUpdateTimeIn;
	}
	public CsTerminalQuery setCstUpdateTimeIsNull(Boolean cstUpdateTimeIsNull){
		this.cstUpdateTimeIsNull = cstUpdateTimeIsNull;
		return this;
	}
	public Boolean getCstUpdateTimeIsNull(){
		return this.cstUpdateTimeIsNull;
	}
	public CsTerminalQuery setCstUpdateTimeIsNotNull(Boolean cstUpdateTimeIsNotNull){
		this.cstUpdateTimeIsNotNull = cstUpdateTimeIsNotNull;
		return this;
	}
	public Boolean getCstUpdateTimeIsNotNull(){
		return this.cstUpdateTimeIsNotNull;
	}
	public CsTerminalQuery setCstUpdateTimeStart(Date cstUpdateTimeStart){
		this.cstUpdateTimeStart = cstUpdateTimeStart;
		return this;
	}
	public Date getCstUpdateTimeStart(){
		return this.cstUpdateTimeStart;
	}
	public CsTerminalQuery setCstUpdateTimeEnd(Date cstUpdateTimeEnd){
		this.cstUpdateTimeEnd = cstUpdateTimeEnd;
		return this;
	}
	public Date getCstUpdateTimeEnd(){
		return this.cstUpdateTimeEnd;
	}
	public CsTerminalQuery setCstUpdateTimeLess(Date cstUpdateTimeLess){
		this.cstUpdateTimeLess = cstUpdateTimeLess;
		return this;
	}
	public Date getCstUpdateTimeLess(){
		return this.cstUpdateTimeLess;
	}
	public CsTerminalQuery setCstUpdateTimeGreater(Date cstUpdateTimeGreater){
		this.cstUpdateTimeGreater = cstUpdateTimeGreater;
		return this;
	}
	public Date getCstUpdateTimeGreater(){
		return this.cstUpdateTimeGreater;
	}
	public CsTerminalQuery setCstAddTimeEquals(Date cstAddTimeEquals){
		this.cstAddTimeEquals = cstAddTimeEquals;
		return this;
	}
	public Date getCstAddTimeEquals(){
		return this.cstAddTimeEquals;
	}
	public CsTerminalQuery setCstAddTimeIn(Date[] cstAddTimeIn){
		this.cstAddTimeIn = cstAddTimeIn;
		return this;
	}
	public Date[] getCstAddTimeIn(){
		return this.cstAddTimeIn;
	}
	public CsTerminalQuery setCstAddTimeIsNull(Boolean cstAddTimeIsNull){
		this.cstAddTimeIsNull = cstAddTimeIsNull;
		return this;
	}
	public Boolean getCstAddTimeIsNull(){
		return this.cstAddTimeIsNull;
	}
	public CsTerminalQuery setCstAddTimeIsNotNull(Boolean cstAddTimeIsNotNull){
		this.cstAddTimeIsNotNull = cstAddTimeIsNotNull;
		return this;
	}
	public Boolean getCstAddTimeIsNotNull(){
		return this.cstAddTimeIsNotNull;
	}
	public CsTerminalQuery setCstAddTimeStart(Date cstAddTimeStart){
		this.cstAddTimeStart = cstAddTimeStart;
		return this;
	}
	public Date getCstAddTimeStart(){
		return this.cstAddTimeStart;
	}
	public CsTerminalQuery setCstAddTimeEnd(Date cstAddTimeEnd){
		this.cstAddTimeEnd = cstAddTimeEnd;
		return this;
	}
	public Date getCstAddTimeEnd(){
		return this.cstAddTimeEnd;
	}
	public CsTerminalQuery setCstAddTimeLess(Date cstAddTimeLess){
		this.cstAddTimeLess = cstAddTimeLess;
		return this;
	}
	public Date getCstAddTimeLess(){
		return this.cstAddTimeLess;
	}
	public CsTerminalQuery setCstAddTimeGreater(Date cstAddTimeGreater){
		this.cstAddTimeGreater = cstAddTimeGreater;
		return this;
	}
	public Date getCstAddTimeGreater(){
		return this.cstAddTimeGreater;
	}
	public CsTerminalQuery setCstStatusEquals(Short cstStatusEquals){
		this.cstStatusEquals = cstStatusEquals;
		return this;
	}
	public Short getCstStatusEquals(){
		return this.cstStatusEquals;
	}
	public CsTerminalQuery setCstStatusIn(Short[] cstStatusIn){
		this.cstStatusIn = cstStatusIn;
		return this;
	}
	public Short[] getCstStatusIn(){
		return this.cstStatusIn;
	}
	public CsTerminalQuery setCstStatusIsNull(Boolean cstStatusIsNull){
		this.cstStatusIsNull = cstStatusIsNull;
		return this;
	}
	public Boolean getCstStatusIsNull(){
		return this.cstStatusIsNull;
	}
	public CsTerminalQuery setCstStatusIsNotNull(Boolean cstStatusIsNotNull){
		this.cstStatusIsNotNull = cstStatusIsNotNull;
		return this;
	}
	public Boolean getCstStatusIsNotNull(){
		return this.cstStatusIsNotNull;
	}
	public CsTerminalQuery setCstStatusStart(Short cstStatusStart){
		this.cstStatusStart = cstStatusStart;
		return this;
	}
	public Short getCstStatusStart(){
		return this.cstStatusStart;
	}
	public CsTerminalQuery setCstStatusEnd(Short cstStatusEnd){
		this.cstStatusEnd = cstStatusEnd;
		return this;
	}
	public Short getCstStatusEnd(){
		return this.cstStatusEnd;
	}
	public CsTerminalQuery setCstStatusLess(Short cstStatusLess){
		this.cstStatusLess = cstStatusLess;
		return this;
	}
	public Short getCstStatusLess(){
		return this.cstStatusLess;
	}
	public CsTerminalQuery setCstStatusGreater(Short cstStatusGreater){
		this.cstStatusGreater = cstStatusGreater;
		return this;
	}
	public Short getCstStatusGreater(){
		return this.cstStatusGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("cstId")){
			return "cst_id";
		}
		else if(this.sidx.equals("cstIdd")){
			return "cst_idd";
		}
		else if(this.sidx.equals("cstModel")){
			return "cst_model";
		}
		else if(this.sidx.equals("cstMade")){
			return "cst_made";
		}
		else if(this.sidx.equals("cstProvince")){
			return "cst_province";
		}
		else if(this.sidx.equals("cstCity")){
			return "cst_city";
		}
		else if(this.sidx.equals("cstColor")){
			return "cst_color";
		}
		else if(this.sidx.equals("cstNumber")){
			return "cst_number";
		}
		else if(this.sidx.equals("cstMobile")){
			return "cst_mobile";
		}
		else if(this.sidx.equals("cstUpdateTime")){
			return "cst_update_time";
		}
		else if(this.sidx.equals("cstAddTime")){
			return "cst_add_time";
		}
		else if(this.sidx.equals("cstStatus")){
			return "cst_status";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsTerminalCrieria getCrieria(){
		CsTerminalCrieria q = new CsTerminalCrieria();
		CsTerminalCrieria.Criteria c = q.createCriteria();
		
		if(this.getCstIdEquals()!=null){
			c.andcstIdEqualTo(this.getCstIdEquals());
		}else if(this.getCstIdIsNull()!=null && this.getCstIdIsNull()){
			c.andcstIdIsNull();
		}else if(this.getCstIdIsNotNull()!=null && this.getCstIdIsNotNull()){
			c.andcstIdIsNotNull();
		}else if(this.getCstIdIn()!=null){
			c.andcstIdIn(java.util.Arrays.asList(this.getCstIdIn()));
		}else if(this.getCstIdStart()!=null && this.getCstIdEnd()!=null){
			c.andcstIdBetween(this.getCstIdStart(), this.getCstIdEnd());
		}else if(this.getCstIdGreater()!=null){
			c.andcstIdGreaterThan(this.getCstIdGreater());
		}else if(this.getCstIdLess()!=null){
			c.andcstIdLessThan(this.getCstIdLess());
		}
		if(this.getCstIddEquals()!=null){
			c.andcstIddEqualTo(this.getCstIddEquals());
		}else if(this.getCstIddIsNull()!=null && this.getCstIddIsNull()){
			c.andcstIddIsNull();
		}else if(this.getCstIddIsNotNull()!=null && this.getCstIddIsNotNull()){
			c.andcstIddIsNotNull();
		}else if(this.getCstIddLike()!=null){
			c.andcstIddLike(this.getCstIddLike());
		}else if(this.getCstIddIn()!=null){
			c.andcstIddIn(java.util.Arrays.asList(this.getCstIddIn()));
		}else if(this.getCstIddStart()!=null && this.getCstIddEnd()!=null){
			c.andcstIddBetween(this.getCstIddStart(), this.getCstIddEnd());
		}else if(this.getCstIddGreater()!=null){
			c.andcstIddGreaterThan(this.getCstIddGreater());
		}else if(this.getCstIddLess()!=null){
			c.andcstIddLessThan(this.getCstIddLess());
		}
		if(this.getCstModelEquals()!=null){
			c.andcstModelEqualTo(this.getCstModelEquals());
		}else if(this.getCstModelIsNull()!=null && this.getCstModelIsNull()){
			c.andcstModelIsNull();
		}else if(this.getCstModelIsNotNull()!=null && this.getCstModelIsNotNull()){
			c.andcstModelIsNotNull();
		}else if(this.getCstModelLike()!=null){
			c.andcstModelLike(this.getCstModelLike());
		}else if(this.getCstModelIn()!=null){
			c.andcstModelIn(java.util.Arrays.asList(this.getCstModelIn()));
		}else if(this.getCstModelStart()!=null && this.getCstModelEnd()!=null){
			c.andcstModelBetween(this.getCstModelStart(), this.getCstModelEnd());
		}else if(this.getCstModelGreater()!=null){
			c.andcstModelGreaterThan(this.getCstModelGreater());
		}else if(this.getCstModelLess()!=null){
			c.andcstModelLessThan(this.getCstModelLess());
		}
		if(this.getCstMadeEquals()!=null){
			c.andcstMadeEqualTo(this.getCstMadeEquals());
		}else if(this.getCstMadeIsNull()!=null && this.getCstMadeIsNull()){
			c.andcstMadeIsNull();
		}else if(this.getCstMadeIsNotNull()!=null && this.getCstMadeIsNotNull()){
			c.andcstMadeIsNotNull();
		}else if(this.getCstMadeLike()!=null){
			c.andcstMadeLike(this.getCstMadeLike());
		}else if(this.getCstMadeIn()!=null){
			c.andcstMadeIn(java.util.Arrays.asList(this.getCstMadeIn()));
		}else if(this.getCstMadeStart()!=null && this.getCstMadeEnd()!=null){
			c.andcstMadeBetween(this.getCstMadeStart(), this.getCstMadeEnd());
		}else if(this.getCstMadeGreater()!=null){
			c.andcstMadeGreaterThan(this.getCstMadeGreater());
		}else if(this.getCstMadeLess()!=null){
			c.andcstMadeLessThan(this.getCstMadeLess());
		}
		if(this.getCstProvinceEquals()!=null){
			c.andcstProvinceEqualTo(this.getCstProvinceEquals());
		}else if(this.getCstProvinceIsNull()!=null && this.getCstProvinceIsNull()){
			c.andcstProvinceIsNull();
		}else if(this.getCstProvinceIsNotNull()!=null && this.getCstProvinceIsNotNull()){
			c.andcstProvinceIsNotNull();
		}else if(this.getCstProvinceLike()!=null){
			c.andcstProvinceLike(this.getCstProvinceLike());
		}else if(this.getCstProvinceIn()!=null){
			c.andcstProvinceIn(java.util.Arrays.asList(this.getCstProvinceIn()));
		}else if(this.getCstProvinceStart()!=null && this.getCstProvinceEnd()!=null){
			c.andcstProvinceBetween(this.getCstProvinceStart(), this.getCstProvinceEnd());
		}else if(this.getCstProvinceGreater()!=null){
			c.andcstProvinceGreaterThan(this.getCstProvinceGreater());
		}else if(this.getCstProvinceLess()!=null){
			c.andcstProvinceLessThan(this.getCstProvinceLess());
		}
		if(this.getCstCityEquals()!=null){
			c.andcstCityEqualTo(this.getCstCityEquals());
		}else if(this.getCstCityIsNull()!=null && this.getCstCityIsNull()){
			c.andcstCityIsNull();
		}else if(this.getCstCityIsNotNull()!=null && this.getCstCityIsNotNull()){
			c.andcstCityIsNotNull();
		}else if(this.getCstCityLike()!=null){
			c.andcstCityLike(this.getCstCityLike());
		}else if(this.getCstCityIn()!=null){
			c.andcstCityIn(java.util.Arrays.asList(this.getCstCityIn()));
		}else if(this.getCstCityStart()!=null && this.getCstCityEnd()!=null){
			c.andcstCityBetween(this.getCstCityStart(), this.getCstCityEnd());
		}else if(this.getCstCityGreater()!=null){
			c.andcstCityGreaterThan(this.getCstCityGreater());
		}else if(this.getCstCityLess()!=null){
			c.andcstCityLessThan(this.getCstCityLess());
		}
		if(this.getCstColorEquals()!=null){
			c.andcstColorEqualTo(this.getCstColorEquals());
		}else if(this.getCstColorIsNull()!=null && this.getCstColorIsNull()){
			c.andcstColorIsNull();
		}else if(this.getCstColorIsNotNull()!=null && this.getCstColorIsNotNull()){
			c.andcstColorIsNotNull();
		}else if(this.getCstColorIn()!=null){
			c.andcstColorIn(java.util.Arrays.asList(this.getCstColorIn()));
		}else if(this.getCstColorStart()!=null && this.getCstColorEnd()!=null){
			c.andcstColorBetween(this.getCstColorStart(), this.getCstColorEnd());
		}else if(this.getCstColorGreater()!=null){
			c.andcstColorGreaterThan(this.getCstColorGreater());
		}else if(this.getCstColorLess()!=null){
			c.andcstColorLessThan(this.getCstColorLess());
		}
		if(this.getCstNumberEquals()!=null){
			c.andcstNumberEqualTo(this.getCstNumberEquals());
		}else if(this.getCstNumberIsNull()!=null && this.getCstNumberIsNull()){
			c.andcstNumberIsNull();
		}else if(this.getCstNumberIsNotNull()!=null && this.getCstNumberIsNotNull()){
			c.andcstNumberIsNotNull();
		}else if(this.getCstNumberLike()!=null){
			c.andcstNumberLike(this.getCstNumberLike());
		}else if(this.getCstNumberIn()!=null){
			c.andcstNumberIn(java.util.Arrays.asList(this.getCstNumberIn()));
		}else if(this.getCstNumberStart()!=null && this.getCstNumberEnd()!=null){
			c.andcstNumberBetween(this.getCstNumberStart(), this.getCstNumberEnd());
		}else if(this.getCstNumberGreater()!=null){
			c.andcstNumberGreaterThan(this.getCstNumberGreater());
		}else if(this.getCstNumberLess()!=null){
			c.andcstNumberLessThan(this.getCstNumberLess());
		}
		if(this.getCstMobileEquals()!=null){
			c.andcstMobileEqualTo(this.getCstMobileEquals());
		}else if(this.getCstMobileIsNull()!=null && this.getCstMobileIsNull()){
			c.andcstMobileIsNull();
		}else if(this.getCstMobileIsNotNull()!=null && this.getCstMobileIsNotNull()){
			c.andcstMobileIsNotNull();
		}else if(this.getCstMobileLike()!=null){
			c.andcstMobileLike(this.getCstMobileLike());
		}else if(this.getCstMobileIn()!=null){
			c.andcstMobileIn(java.util.Arrays.asList(this.getCstMobileIn()));
		}else if(this.getCstMobileStart()!=null && this.getCstMobileEnd()!=null){
			c.andcstMobileBetween(this.getCstMobileStart(), this.getCstMobileEnd());
		}else if(this.getCstMobileGreater()!=null){
			c.andcstMobileGreaterThan(this.getCstMobileGreater());
		}else if(this.getCstMobileLess()!=null){
			c.andcstMobileLessThan(this.getCstMobileLess());
		}
		if(this.getCstUpdateTimeEquals()!=null){
			c.andcstUpdateTimeEqualTo(this.getCstUpdateTimeEquals());
		}else if(this.getCstUpdateTimeIsNull()!=null && this.getCstUpdateTimeIsNull()){
			c.andcstUpdateTimeIsNull();
		}else if(this.getCstUpdateTimeIsNotNull()!=null && this.getCstUpdateTimeIsNotNull()){
			c.andcstUpdateTimeIsNotNull();
		}else if(this.getCstUpdateTimeIn()!=null){
			c.andcstUpdateTimeIn(java.util.Arrays.asList(this.getCstUpdateTimeIn()));
		}else if(this.getCstUpdateTimeStart()!=null && this.getCstUpdateTimeEnd()!=null){
			c.andcstUpdateTimeBetween(this.getCstUpdateTimeStart(), this.getCstUpdateTimeEnd());
		}else if(this.getCstUpdateTimeGreater()!=null){
			c.andcstUpdateTimeGreaterThan(this.getCstUpdateTimeGreater());
		}else if(this.getCstUpdateTimeLess()!=null){
			c.andcstUpdateTimeLessThan(this.getCstUpdateTimeLess());
		}
		if(this.getCstAddTimeEquals()!=null){
			c.andcstAddTimeEqualTo(this.getCstAddTimeEquals());
		}else if(this.getCstAddTimeIsNull()!=null && this.getCstAddTimeIsNull()){
			c.andcstAddTimeIsNull();
		}else if(this.getCstAddTimeIsNotNull()!=null && this.getCstAddTimeIsNotNull()){
			c.andcstAddTimeIsNotNull();
		}else if(this.getCstAddTimeIn()!=null){
			c.andcstAddTimeIn(java.util.Arrays.asList(this.getCstAddTimeIn()));
		}else if(this.getCstAddTimeStart()!=null && this.getCstAddTimeEnd()!=null){
			c.andcstAddTimeBetween(this.getCstAddTimeStart(), this.getCstAddTimeEnd());
		}else if(this.getCstAddTimeGreater()!=null){
			c.andcstAddTimeGreaterThan(this.getCstAddTimeGreater());
		}else if(this.getCstAddTimeLess()!=null){
			c.andcstAddTimeLessThan(this.getCstAddTimeLess());
		}
		if(this.getCstStatusEquals()!=null){
			c.andcstStatusEqualTo(this.getCstStatusEquals());
		}else if(this.getCstStatusIsNull()!=null && this.getCstStatusIsNull()){
			c.andcstStatusIsNull();
		}else if(this.getCstStatusIsNotNull()!=null && this.getCstStatusIsNotNull()){
			c.andcstStatusIsNotNull();
		}else if(this.getCstStatusIn()!=null){
			c.andcstStatusIn(java.util.Arrays.asList(this.getCstStatusIn()));
		}else if(this.getCstStatusStart()!=null && this.getCstStatusEnd()!=null){
			c.andcstStatusBetween(this.getCstStatusStart(), this.getCstStatusEnd());
		}else if(this.getCstStatusGreater()!=null){
			c.andcstStatusGreaterThan(this.getCstStatusGreater());
		}else if(this.getCstStatusLess()!=null){
			c.andcstStatusLessThan(this.getCstStatusLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
