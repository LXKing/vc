package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.SrvUserCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SrvUserQuery {
	
	private Integer suIdEquals;
	private Integer[] suIdIn;
	private Boolean suIdIsNull;
	private Boolean suIdIsNotNull;
	
	private Integer suIdStart;
	
	private Integer suIdEnd;
	
	private Integer suIdLess;
	
	private Integer suIdGreater;
	private String suHostLike;
	
	private String suHostEquals;
	private String[] suHostIn;
	private Boolean suHostIsNull;
	private Boolean suHostIsNotNull;
	
	private String suHostStart;
	
	private String suHostEnd;
	
	private String suHostLess;
	
	private String suHostGreater;
	
	private Long suGroupEquals;
	private Long[] suGroupIn;
	private Boolean suGroupIsNull;
	private Boolean suGroupIsNotNull;
	
	private Long suGroupStart;
	
	private Long suGroupEnd;
	
	private Long suGroupLess;
	
	private Long suGroupGreater;
	private String suUsernameLike;
	
	private String suUsernameEquals;
	private String[] suUsernameIn;
	private Boolean suUsernameIsNull;
	private Boolean suUsernameIsNotNull;
	
	private String suUsernameStart;
	
	private String suUsernameEnd;
	
	private String suUsernameLess;
	
	private String suUsernameGreater;
	private String suPasswordLike;
	
	private String suPasswordEquals;
	private String[] suPasswordIn;
	private Boolean suPasswordIsNull;
	private Boolean suPasswordIsNotNull;
	
	private String suPasswordStart;
	
	private String suPasswordEnd;
	
	private String suPasswordLess;
	
	private String suPasswordGreater;
	private String suRealNameLike;
	
	private String suRealNameEquals;
	private String[] suRealNameIn;
	private Boolean suRealNameIsNull;
	private Boolean suRealNameIsNotNull;
	
	private String suRealNameStart;
	
	private String suRealNameEnd;
	
	private String suRealNameLess;
	
	private String suRealNameGreater;
	private String suMobileLike;
	
	private String suMobileEquals;
	private String[] suMobileIn;
	private Boolean suMobileIsNull;
	private Boolean suMobileIsNotNull;
	
	private String suMobileStart;
	
	private String suMobileEnd;
	
	private String suMobileLess;
	
	private String suMobileGreater;
	private String suShortcutLike;
	
	private String suShortcutEquals;
	private String[] suShortcutIn;
	private Boolean suShortcutIsNull;
	private Boolean suShortcutIsNotNull;
	
	private String suShortcutStart;
	
	private String suShortcutEnd;
	
	private String suShortcutLess;
	
	private String suShortcutGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suAddTimeEquals;
	private Date[] suAddTimeIn;
	private Boolean suAddTimeIsNull;
	private Boolean suAddTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suAddTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suAddTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suLastTimeEquals;
	private Date[] suLastTimeIn;
	private Boolean suLastTimeIsNull;
	private Boolean suLastTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suLastTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suLastTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suLastTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date suLastTimeGreater;
	private String suLastIpLike;
	
	private String suLastIpEquals;
	private String[] suLastIpIn;
	private Boolean suLastIpIsNull;
	private Boolean suLastIpIsNotNull;
	
	private String suLastIpStart;
	
	private String suLastIpEnd;
	
	private String suLastIpLess;
	
	private String suLastIpGreater;
	
	private Short suStatusEquals;
	private Short[] suStatusIn;
	private Boolean suStatusIsNull;
	private Boolean suStatusIsNotNull;
	
	private Short suStatusStart;
	
	private Short suStatusEnd;
	
	private Short suStatusLess;
	
	private Short suStatusGreater;
	private String sidx;
	private String sord;

	public SrvUserQuery setSuIdEquals(Integer suIdEquals){
		this.suIdEquals = suIdEquals;
		return this;
	}
	public Integer getSuIdEquals(){
		return this.suIdEquals;
	}
	public SrvUserQuery setSuIdIn(Integer[] suIdIn){
		this.suIdIn = suIdIn;
		return this;
	}
	public Integer[] getSuIdIn(){
		return this.suIdIn;
	}
	public SrvUserQuery setSuIdIsNull(Boolean suIdIsNull){
		this.suIdIsNull = suIdIsNull;
		return this;
	}
	public Boolean getSuIdIsNull(){
		return this.suIdIsNull;
	}
	public SrvUserQuery setSuIdIsNotNull(Boolean suIdIsNotNull){
		this.suIdIsNotNull = suIdIsNotNull;
		return this;
	}
	public Boolean getSuIdIsNotNull(){
		return this.suIdIsNotNull;
	}
	public SrvUserQuery setSuIdStart(Integer suIdStart){
		this.suIdStart = suIdStart;
		return this;
	}
	public Integer getSuIdStart(){
		return this.suIdStart;
	}
	public SrvUserQuery setSuIdEnd(Integer suIdEnd){
		this.suIdEnd = suIdEnd;
		return this;
	}
	public Integer getSuIdEnd(){
		return this.suIdEnd;
	}
	public SrvUserQuery setSuIdLess(Integer suIdLess){
		this.suIdLess = suIdLess;
		return this;
	}
	public Integer getSuIdLess(){
		return this.suIdLess;
	}
	public SrvUserQuery setSuIdGreater(Integer suIdGreater){
		this.suIdGreater = suIdGreater;
		return this;
	}
	public Integer getSuIdGreater(){
		return this.suIdGreater;
	}
	public SrvUserQuery setSuHostLike(String suHostLike){
		this.suHostLike = suHostLike;
		return this;
	}
	public String getSuHostLike(){
		return this.suHostLike;
	}
	public SrvUserQuery setSuHostEquals(String suHostEquals){
		this.suHostEquals = suHostEquals;
		return this;
	}
	public String getSuHostEquals(){
		return this.suHostEquals;
	}
	public SrvUserQuery setSuHostIn(String[] suHostIn){
		this.suHostIn = suHostIn;
		return this;
	}
	public String[] getSuHostIn(){
		return this.suHostIn;
	}
	public SrvUserQuery setSuHostIsNull(Boolean suHostIsNull){
		this.suHostIsNull = suHostIsNull;
		return this;
	}
	public Boolean getSuHostIsNull(){
		return this.suHostIsNull;
	}
	public SrvUserQuery setSuHostIsNotNull(Boolean suHostIsNotNull){
		this.suHostIsNotNull = suHostIsNotNull;
		return this;
	}
	public Boolean getSuHostIsNotNull(){
		return this.suHostIsNotNull;
	}
	public SrvUserQuery setSuHostStart(String suHostStart){
		this.suHostStart = suHostStart;
		return this;
	}
	public String getSuHostStart(){
		return this.suHostStart;
	}
	public SrvUserQuery setSuHostEnd(String suHostEnd){
		this.suHostEnd = suHostEnd;
		return this;
	}
	public String getSuHostEnd(){
		return this.suHostEnd;
	}
	public SrvUserQuery setSuHostLess(String suHostLess){
		this.suHostLess = suHostLess;
		return this;
	}
	public String getSuHostLess(){
		return this.suHostLess;
	}
	public SrvUserQuery setSuHostGreater(String suHostGreater){
		this.suHostGreater = suHostGreater;
		return this;
	}
	public String getSuHostGreater(){
		return this.suHostGreater;
	}
	public SrvUserQuery setSuGroupEquals(Long suGroupEquals){
		this.suGroupEquals = suGroupEquals;
		return this;
	}
	public Long getSuGroupEquals(){
		return this.suGroupEquals;
	}
	public SrvUserQuery setSuGroupIn(Long[] suGroupIn){
		this.suGroupIn = suGroupIn;
		return this;
	}
	public Long[] getSuGroupIn(){
		return this.suGroupIn;
	}
	public SrvUserQuery setSuGroupIsNull(Boolean suGroupIsNull){
		this.suGroupIsNull = suGroupIsNull;
		return this;
	}
	public Boolean getSuGroupIsNull(){
		return this.suGroupIsNull;
	}
	public SrvUserQuery setSuGroupIsNotNull(Boolean suGroupIsNotNull){
		this.suGroupIsNotNull = suGroupIsNotNull;
		return this;
	}
	public Boolean getSuGroupIsNotNull(){
		return this.suGroupIsNotNull;
	}
	public SrvUserQuery setSuGroupStart(Long suGroupStart){
		this.suGroupStart = suGroupStart;
		return this;
	}
	public Long getSuGroupStart(){
		return this.suGroupStart;
	}
	public SrvUserQuery setSuGroupEnd(Long suGroupEnd){
		this.suGroupEnd = suGroupEnd;
		return this;
	}
	public Long getSuGroupEnd(){
		return this.suGroupEnd;
	}
	public SrvUserQuery setSuGroupLess(Long suGroupLess){
		this.suGroupLess = suGroupLess;
		return this;
	}
	public Long getSuGroupLess(){
		return this.suGroupLess;
	}
	public SrvUserQuery setSuGroupGreater(Long suGroupGreater){
		this.suGroupGreater = suGroupGreater;
		return this;
	}
	public Long getSuGroupGreater(){
		return this.suGroupGreater;
	}
	public SrvUserQuery setSuUsernameLike(String suUsernameLike){
		this.suUsernameLike = suUsernameLike;
		return this;
	}
	public String getSuUsernameLike(){
		return this.suUsernameLike;
	}
	public SrvUserQuery setSuUsernameEquals(String suUsernameEquals){
		this.suUsernameEquals = suUsernameEquals;
		return this;
	}
	public String getSuUsernameEquals(){
		return this.suUsernameEquals;
	}
	public SrvUserQuery setSuUsernameIn(String[] suUsernameIn){
		this.suUsernameIn = suUsernameIn;
		return this;
	}
	public String[] getSuUsernameIn(){
		return this.suUsernameIn;
	}
	public SrvUserQuery setSuUsernameIsNull(Boolean suUsernameIsNull){
		this.suUsernameIsNull = suUsernameIsNull;
		return this;
	}
	public Boolean getSuUsernameIsNull(){
		return this.suUsernameIsNull;
	}
	public SrvUserQuery setSuUsernameIsNotNull(Boolean suUsernameIsNotNull){
		this.suUsernameIsNotNull = suUsernameIsNotNull;
		return this;
	}
	public Boolean getSuUsernameIsNotNull(){
		return this.suUsernameIsNotNull;
	}
	public SrvUserQuery setSuUsernameStart(String suUsernameStart){
		this.suUsernameStart = suUsernameStart;
		return this;
	}
	public String getSuUsernameStart(){
		return this.suUsernameStart;
	}
	public SrvUserQuery setSuUsernameEnd(String suUsernameEnd){
		this.suUsernameEnd = suUsernameEnd;
		return this;
	}
	public String getSuUsernameEnd(){
		return this.suUsernameEnd;
	}
	public SrvUserQuery setSuUsernameLess(String suUsernameLess){
		this.suUsernameLess = suUsernameLess;
		return this;
	}
	public String getSuUsernameLess(){
		return this.suUsernameLess;
	}
	public SrvUserQuery setSuUsernameGreater(String suUsernameGreater){
		this.suUsernameGreater = suUsernameGreater;
		return this;
	}
	public String getSuUsernameGreater(){
		return this.suUsernameGreater;
	}
	public SrvUserQuery setSuPasswordLike(String suPasswordLike){
		this.suPasswordLike = suPasswordLike;
		return this;
	}
	public String getSuPasswordLike(){
		return this.suPasswordLike;
	}
	public SrvUserQuery setSuPasswordEquals(String suPasswordEquals){
		this.suPasswordEquals = suPasswordEquals;
		return this;
	}
	public String getSuPasswordEquals(){
		return this.suPasswordEquals;
	}
	public SrvUserQuery setSuPasswordIn(String[] suPasswordIn){
		this.suPasswordIn = suPasswordIn;
		return this;
	}
	public String[] getSuPasswordIn(){
		return this.suPasswordIn;
	}
	public SrvUserQuery setSuPasswordIsNull(Boolean suPasswordIsNull){
		this.suPasswordIsNull = suPasswordIsNull;
		return this;
	}
	public Boolean getSuPasswordIsNull(){
		return this.suPasswordIsNull;
	}
	public SrvUserQuery setSuPasswordIsNotNull(Boolean suPasswordIsNotNull){
		this.suPasswordIsNotNull = suPasswordIsNotNull;
		return this;
	}
	public Boolean getSuPasswordIsNotNull(){
		return this.suPasswordIsNotNull;
	}
	public SrvUserQuery setSuPasswordStart(String suPasswordStart){
		this.suPasswordStart = suPasswordStart;
		return this;
	}
	public String getSuPasswordStart(){
		return this.suPasswordStart;
	}
	public SrvUserQuery setSuPasswordEnd(String suPasswordEnd){
		this.suPasswordEnd = suPasswordEnd;
		return this;
	}
	public String getSuPasswordEnd(){
		return this.suPasswordEnd;
	}
	public SrvUserQuery setSuPasswordLess(String suPasswordLess){
		this.suPasswordLess = suPasswordLess;
		return this;
	}
	public String getSuPasswordLess(){
		return this.suPasswordLess;
	}
	public SrvUserQuery setSuPasswordGreater(String suPasswordGreater){
		this.suPasswordGreater = suPasswordGreater;
		return this;
	}
	public String getSuPasswordGreater(){
		return this.suPasswordGreater;
	}
	public SrvUserQuery setSuRealNameLike(String suRealNameLike){
		this.suRealNameLike = suRealNameLike;
		return this;
	}
	public String getSuRealNameLike(){
		return this.suRealNameLike;
	}
	public SrvUserQuery setSuRealNameEquals(String suRealNameEquals){
		this.suRealNameEquals = suRealNameEquals;
		return this;
	}
	public String getSuRealNameEquals(){
		return this.suRealNameEquals;
	}
	public SrvUserQuery setSuRealNameIn(String[] suRealNameIn){
		this.suRealNameIn = suRealNameIn;
		return this;
	}
	public String[] getSuRealNameIn(){
		return this.suRealNameIn;
	}
	public SrvUserQuery setSuRealNameIsNull(Boolean suRealNameIsNull){
		this.suRealNameIsNull = suRealNameIsNull;
		return this;
	}
	public Boolean getSuRealNameIsNull(){
		return this.suRealNameIsNull;
	}
	public SrvUserQuery setSuRealNameIsNotNull(Boolean suRealNameIsNotNull){
		this.suRealNameIsNotNull = suRealNameIsNotNull;
		return this;
	}
	public Boolean getSuRealNameIsNotNull(){
		return this.suRealNameIsNotNull;
	}
	public SrvUserQuery setSuRealNameStart(String suRealNameStart){
		this.suRealNameStart = suRealNameStart;
		return this;
	}
	public String getSuRealNameStart(){
		return this.suRealNameStart;
	}
	public SrvUserQuery setSuRealNameEnd(String suRealNameEnd){
		this.suRealNameEnd = suRealNameEnd;
		return this;
	}
	public String getSuRealNameEnd(){
		return this.suRealNameEnd;
	}
	public SrvUserQuery setSuRealNameLess(String suRealNameLess){
		this.suRealNameLess = suRealNameLess;
		return this;
	}
	public String getSuRealNameLess(){
		return this.suRealNameLess;
	}
	public SrvUserQuery setSuRealNameGreater(String suRealNameGreater){
		this.suRealNameGreater = suRealNameGreater;
		return this;
	}
	public String getSuRealNameGreater(){
		return this.suRealNameGreater;
	}
	public SrvUserQuery setSuMobileLike(String suMobileLike){
		this.suMobileLike = suMobileLike;
		return this;
	}
	public String getSuMobileLike(){
		return this.suMobileLike;
	}
	public SrvUserQuery setSuMobileEquals(String suMobileEquals){
		this.suMobileEquals = suMobileEquals;
		return this;
	}
	public String getSuMobileEquals(){
		return this.suMobileEquals;
	}
	public SrvUserQuery setSuMobileIn(String[] suMobileIn){
		this.suMobileIn = suMobileIn;
		return this;
	}
	public String[] getSuMobileIn(){
		return this.suMobileIn;
	}
	public SrvUserQuery setSuMobileIsNull(Boolean suMobileIsNull){
		this.suMobileIsNull = suMobileIsNull;
		return this;
	}
	public Boolean getSuMobileIsNull(){
		return this.suMobileIsNull;
	}
	public SrvUserQuery setSuMobileIsNotNull(Boolean suMobileIsNotNull){
		this.suMobileIsNotNull = suMobileIsNotNull;
		return this;
	}
	public Boolean getSuMobileIsNotNull(){
		return this.suMobileIsNotNull;
	}
	public SrvUserQuery setSuMobileStart(String suMobileStart){
		this.suMobileStart = suMobileStart;
		return this;
	}
	public String getSuMobileStart(){
		return this.suMobileStart;
	}
	public SrvUserQuery setSuMobileEnd(String suMobileEnd){
		this.suMobileEnd = suMobileEnd;
		return this;
	}
	public String getSuMobileEnd(){
		return this.suMobileEnd;
	}
	public SrvUserQuery setSuMobileLess(String suMobileLess){
		this.suMobileLess = suMobileLess;
		return this;
	}
	public String getSuMobileLess(){
		return this.suMobileLess;
	}
	public SrvUserQuery setSuMobileGreater(String suMobileGreater){
		this.suMobileGreater = suMobileGreater;
		return this;
	}
	public String getSuMobileGreater(){
		return this.suMobileGreater;
	}
	public SrvUserQuery setSuShortcutLike(String suShortcutLike){
		this.suShortcutLike = suShortcutLike;
		return this;
	}
	public String getSuShortcutLike(){
		return this.suShortcutLike;
	}
	public SrvUserQuery setSuShortcutEquals(String suShortcutEquals){
		this.suShortcutEquals = suShortcutEquals;
		return this;
	}
	public String getSuShortcutEquals(){
		return this.suShortcutEquals;
	}
	public SrvUserQuery setSuShortcutIn(String[] suShortcutIn){
		this.suShortcutIn = suShortcutIn;
		return this;
	}
	public String[] getSuShortcutIn(){
		return this.suShortcutIn;
	}
	public SrvUserQuery setSuShortcutIsNull(Boolean suShortcutIsNull){
		this.suShortcutIsNull = suShortcutIsNull;
		return this;
	}
	public Boolean getSuShortcutIsNull(){
		return this.suShortcutIsNull;
	}
	public SrvUserQuery setSuShortcutIsNotNull(Boolean suShortcutIsNotNull){
		this.suShortcutIsNotNull = suShortcutIsNotNull;
		return this;
	}
	public Boolean getSuShortcutIsNotNull(){
		return this.suShortcutIsNotNull;
	}
	public SrvUserQuery setSuShortcutStart(String suShortcutStart){
		this.suShortcutStart = suShortcutStart;
		return this;
	}
	public String getSuShortcutStart(){
		return this.suShortcutStart;
	}
	public SrvUserQuery setSuShortcutEnd(String suShortcutEnd){
		this.suShortcutEnd = suShortcutEnd;
		return this;
	}
	public String getSuShortcutEnd(){
		return this.suShortcutEnd;
	}
	public SrvUserQuery setSuShortcutLess(String suShortcutLess){
		this.suShortcutLess = suShortcutLess;
		return this;
	}
	public String getSuShortcutLess(){
		return this.suShortcutLess;
	}
	public SrvUserQuery setSuShortcutGreater(String suShortcutGreater){
		this.suShortcutGreater = suShortcutGreater;
		return this;
	}
	public String getSuShortcutGreater(){
		return this.suShortcutGreater;
	}
	public SrvUserQuery setSuAddTimeEquals(Date suAddTimeEquals){
		this.suAddTimeEquals = suAddTimeEquals;
		return this;
	}
	public Date getSuAddTimeEquals(){
		return this.suAddTimeEquals;
	}
	public SrvUserQuery setSuAddTimeIn(Date[] suAddTimeIn){
		this.suAddTimeIn = suAddTimeIn;
		return this;
	}
	public Date[] getSuAddTimeIn(){
		return this.suAddTimeIn;
	}
	public SrvUserQuery setSuAddTimeIsNull(Boolean suAddTimeIsNull){
		this.suAddTimeIsNull = suAddTimeIsNull;
		return this;
	}
	public Boolean getSuAddTimeIsNull(){
		return this.suAddTimeIsNull;
	}
	public SrvUserQuery setSuAddTimeIsNotNull(Boolean suAddTimeIsNotNull){
		this.suAddTimeIsNotNull = suAddTimeIsNotNull;
		return this;
	}
	public Boolean getSuAddTimeIsNotNull(){
		return this.suAddTimeIsNotNull;
	}
	public SrvUserQuery setSuAddTimeStart(Date suAddTimeStart){
		this.suAddTimeStart = suAddTimeStart;
		return this;
	}
	public Date getSuAddTimeStart(){
		return this.suAddTimeStart;
	}
	public SrvUserQuery setSuAddTimeEnd(Date suAddTimeEnd){
		this.suAddTimeEnd = suAddTimeEnd;
		return this;
	}
	public Date getSuAddTimeEnd(){
		return this.suAddTimeEnd;
	}
	public SrvUserQuery setSuAddTimeLess(Date suAddTimeLess){
		this.suAddTimeLess = suAddTimeLess;
		return this;
	}
	public Date getSuAddTimeLess(){
		return this.suAddTimeLess;
	}
	public SrvUserQuery setSuAddTimeGreater(Date suAddTimeGreater){
		this.suAddTimeGreater = suAddTimeGreater;
		return this;
	}
	public Date getSuAddTimeGreater(){
		return this.suAddTimeGreater;
	}
	public SrvUserQuery setSuLastTimeEquals(Date suLastTimeEquals){
		this.suLastTimeEquals = suLastTimeEquals;
		return this;
	}
	public Date getSuLastTimeEquals(){
		return this.suLastTimeEquals;
	}
	public SrvUserQuery setSuLastTimeIn(Date[] suLastTimeIn){
		this.suLastTimeIn = suLastTimeIn;
		return this;
	}
	public Date[] getSuLastTimeIn(){
		return this.suLastTimeIn;
	}
	public SrvUserQuery setSuLastTimeIsNull(Boolean suLastTimeIsNull){
		this.suLastTimeIsNull = suLastTimeIsNull;
		return this;
	}
	public Boolean getSuLastTimeIsNull(){
		return this.suLastTimeIsNull;
	}
	public SrvUserQuery setSuLastTimeIsNotNull(Boolean suLastTimeIsNotNull){
		this.suLastTimeIsNotNull = suLastTimeIsNotNull;
		return this;
	}
	public Boolean getSuLastTimeIsNotNull(){
		return this.suLastTimeIsNotNull;
	}
	public SrvUserQuery setSuLastTimeStart(Date suLastTimeStart){
		this.suLastTimeStart = suLastTimeStart;
		return this;
	}
	public Date getSuLastTimeStart(){
		return this.suLastTimeStart;
	}
	public SrvUserQuery setSuLastTimeEnd(Date suLastTimeEnd){
		this.suLastTimeEnd = suLastTimeEnd;
		return this;
	}
	public Date getSuLastTimeEnd(){
		return this.suLastTimeEnd;
	}
	public SrvUserQuery setSuLastTimeLess(Date suLastTimeLess){
		this.suLastTimeLess = suLastTimeLess;
		return this;
	}
	public Date getSuLastTimeLess(){
		return this.suLastTimeLess;
	}
	public SrvUserQuery setSuLastTimeGreater(Date suLastTimeGreater){
		this.suLastTimeGreater = suLastTimeGreater;
		return this;
	}
	public Date getSuLastTimeGreater(){
		return this.suLastTimeGreater;
	}
	public SrvUserQuery setSuLastIpLike(String suLastIpLike){
		this.suLastIpLike = suLastIpLike;
		return this;
	}
	public String getSuLastIpLike(){
		return this.suLastIpLike;
	}
	public SrvUserQuery setSuLastIpEquals(String suLastIpEquals){
		this.suLastIpEquals = suLastIpEquals;
		return this;
	}
	public String getSuLastIpEquals(){
		return this.suLastIpEquals;
	}
	public SrvUserQuery setSuLastIpIn(String[] suLastIpIn){
		this.suLastIpIn = suLastIpIn;
		return this;
	}
	public String[] getSuLastIpIn(){
		return this.suLastIpIn;
	}
	public SrvUserQuery setSuLastIpIsNull(Boolean suLastIpIsNull){
		this.suLastIpIsNull = suLastIpIsNull;
		return this;
	}
	public Boolean getSuLastIpIsNull(){
		return this.suLastIpIsNull;
	}
	public SrvUserQuery setSuLastIpIsNotNull(Boolean suLastIpIsNotNull){
		this.suLastIpIsNotNull = suLastIpIsNotNull;
		return this;
	}
	public Boolean getSuLastIpIsNotNull(){
		return this.suLastIpIsNotNull;
	}
	public SrvUserQuery setSuLastIpStart(String suLastIpStart){
		this.suLastIpStart = suLastIpStart;
		return this;
	}
	public String getSuLastIpStart(){
		return this.suLastIpStart;
	}
	public SrvUserQuery setSuLastIpEnd(String suLastIpEnd){
		this.suLastIpEnd = suLastIpEnd;
		return this;
	}
	public String getSuLastIpEnd(){
		return this.suLastIpEnd;
	}
	public SrvUserQuery setSuLastIpLess(String suLastIpLess){
		this.suLastIpLess = suLastIpLess;
		return this;
	}
	public String getSuLastIpLess(){
		return this.suLastIpLess;
	}
	public SrvUserQuery setSuLastIpGreater(String suLastIpGreater){
		this.suLastIpGreater = suLastIpGreater;
		return this;
	}
	public String getSuLastIpGreater(){
		return this.suLastIpGreater;
	}
	public SrvUserQuery setSuStatusEquals(Short suStatusEquals){
		this.suStatusEquals = suStatusEquals;
		return this;
	}
	public Short getSuStatusEquals(){
		return this.suStatusEquals;
	}
	public SrvUserQuery setSuStatusIn(Short[] suStatusIn){
		this.suStatusIn = suStatusIn;
		return this;
	}
	public Short[] getSuStatusIn(){
		return this.suStatusIn;
	}
	public SrvUserQuery setSuStatusIsNull(Boolean suStatusIsNull){
		this.suStatusIsNull = suStatusIsNull;
		return this;
	}
	public Boolean getSuStatusIsNull(){
		return this.suStatusIsNull;
	}
	public SrvUserQuery setSuStatusIsNotNull(Boolean suStatusIsNotNull){
		this.suStatusIsNotNull = suStatusIsNotNull;
		return this;
	}
	public Boolean getSuStatusIsNotNull(){
		return this.suStatusIsNotNull;
	}
	public SrvUserQuery setSuStatusStart(Short suStatusStart){
		this.suStatusStart = suStatusStart;
		return this;
	}
	public Short getSuStatusStart(){
		return this.suStatusStart;
	}
	public SrvUserQuery setSuStatusEnd(Short suStatusEnd){
		this.suStatusEnd = suStatusEnd;
		return this;
	}
	public Short getSuStatusEnd(){
		return this.suStatusEnd;
	}
	public SrvUserQuery setSuStatusLess(Short suStatusLess){
		this.suStatusLess = suStatusLess;
		return this;
	}
	public Short getSuStatusLess(){
		return this.suStatusLess;
	}
	public SrvUserQuery setSuStatusGreater(Short suStatusGreater){
		this.suStatusGreater = suStatusGreater;
		return this;
	}
	public Short getSuStatusGreater(){
		return this.suStatusGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("suId")){
			return "su_id";
		}
		else if(this.sidx.equals("suHost")){
			return "su_host";
		}
		else if(this.sidx.equals("suGroup")){
			return "su_group";
		}
		else if(this.sidx.equals("suUsername")){
			return "su_username";
		}
		else if(this.sidx.equals("suPassword")){
			return "su_password";
		}
		else if(this.sidx.equals("suRealName")){
			return "su_real_name";
		}
		else if(this.sidx.equals("suMobile")){
			return "su_mobile";
		}
		else if(this.sidx.equals("suShortcut")){
			return "su_shortcut";
		}
		else if(this.sidx.equals("suAddTime")){
			return "su_add_time";
		}
		else if(this.sidx.equals("suLastTime")){
			return "su_last_time";
		}
		else if(this.sidx.equals("suLastIp")){
			return "su_last_ip";
		}
		else if(this.sidx.equals("suStatus")){
			return "su_status";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public SrvUserCrieria getCrieria(){
		SrvUserCrieria q = new SrvUserCrieria();
		SrvUserCrieria.Criteria c = q.createCriteria();
		
		if(this.getSuIdEquals()!=null){
			c.andsuIdEqualTo(this.getSuIdEquals());
		}else if(this.getSuIdIsNull()!=null && this.getSuIdIsNull()){
			c.andsuIdIsNull();
		}else if(this.getSuIdIsNotNull()!=null && this.getSuIdIsNotNull()){
			c.andsuIdIsNotNull();
		}else if(this.getSuIdIn()!=null){
			c.andsuIdIn(java.util.Arrays.asList(this.getSuIdIn()));
		}else if(this.getSuIdStart()!=null && this.getSuIdEnd()!=null){
			c.andsuIdBetween(this.getSuIdStart(), this.getSuIdEnd());
		}else if(this.getSuIdGreater()!=null){
			c.andsuIdGreaterThan(this.getSuIdGreater());
		}else if(this.getSuIdLess()!=null){
			c.andsuIdLessThan(this.getSuIdLess());
		}
		if(this.getSuHostEquals()!=null){
			c.andsuHostEqualTo(this.getSuHostEquals());
		}else if(this.getSuHostIsNull()!=null && this.getSuHostIsNull()){
			c.andsuHostIsNull();
		}else if(this.getSuHostIsNotNull()!=null && this.getSuHostIsNotNull()){
			c.andsuHostIsNotNull();
		}else if(this.getSuHostLike()!=null){
			c.andsuHostLike(this.getSuHostLike());
		}else if(this.getSuHostIn()!=null){
			c.andsuHostIn(java.util.Arrays.asList(this.getSuHostIn()));
		}else if(this.getSuHostStart()!=null && this.getSuHostEnd()!=null){
			c.andsuHostBetween(this.getSuHostStart(), this.getSuHostEnd());
		}else if(this.getSuHostGreater()!=null){
			c.andsuHostGreaterThan(this.getSuHostGreater());
		}else if(this.getSuHostLess()!=null){
			c.andsuHostLessThan(this.getSuHostLess());
		}
		if(this.getSuGroupEquals()!=null){
			c.andsuGroupEqualTo(this.getSuGroupEquals());
		}else if(this.getSuGroupIsNull()!=null && this.getSuGroupIsNull()){
			c.andsuGroupIsNull();
		}else if(this.getSuGroupIsNotNull()!=null && this.getSuGroupIsNotNull()){
			c.andsuGroupIsNotNull();
		}else if(this.getSuGroupIn()!=null){
			c.andsuGroupIn(java.util.Arrays.asList(this.getSuGroupIn()));
		}else if(this.getSuGroupStart()!=null && this.getSuGroupEnd()!=null){
			c.andsuGroupBetween(this.getSuGroupStart(), this.getSuGroupEnd());
		}else if(this.getSuGroupGreater()!=null){
			c.andsuGroupGreaterThan(this.getSuGroupGreater());
		}else if(this.getSuGroupLess()!=null){
			c.andsuGroupLessThan(this.getSuGroupLess());
		}
		if(this.getSuUsernameEquals()!=null){
			c.andsuUsernameEqualTo(this.getSuUsernameEquals());
		}else if(this.getSuUsernameIsNull()!=null && this.getSuUsernameIsNull()){
			c.andsuUsernameIsNull();
		}else if(this.getSuUsernameIsNotNull()!=null && this.getSuUsernameIsNotNull()){
			c.andsuUsernameIsNotNull();
		}else if(this.getSuUsernameLike()!=null){
			c.andsuUsernameLike(this.getSuUsernameLike());
		}else if(this.getSuUsernameIn()!=null){
			c.andsuUsernameIn(java.util.Arrays.asList(this.getSuUsernameIn()));
		}else if(this.getSuUsernameStart()!=null && this.getSuUsernameEnd()!=null){
			c.andsuUsernameBetween(this.getSuUsernameStart(), this.getSuUsernameEnd());
		}else if(this.getSuUsernameGreater()!=null){
			c.andsuUsernameGreaterThan(this.getSuUsernameGreater());
		}else if(this.getSuUsernameLess()!=null){
			c.andsuUsernameLessThan(this.getSuUsernameLess());
		}
		if(this.getSuPasswordEquals()!=null){
			c.andsuPasswordEqualTo(this.getSuPasswordEquals());
		}else if(this.getSuPasswordIsNull()!=null && this.getSuPasswordIsNull()){
			c.andsuPasswordIsNull();
		}else if(this.getSuPasswordIsNotNull()!=null && this.getSuPasswordIsNotNull()){
			c.andsuPasswordIsNotNull();
		}else if(this.getSuPasswordLike()!=null){
			c.andsuPasswordLike(this.getSuPasswordLike());
		}else if(this.getSuPasswordIn()!=null){
			c.andsuPasswordIn(java.util.Arrays.asList(this.getSuPasswordIn()));
		}else if(this.getSuPasswordStart()!=null && this.getSuPasswordEnd()!=null){
			c.andsuPasswordBetween(this.getSuPasswordStart(), this.getSuPasswordEnd());
		}else if(this.getSuPasswordGreater()!=null){
			c.andsuPasswordGreaterThan(this.getSuPasswordGreater());
		}else if(this.getSuPasswordLess()!=null){
			c.andsuPasswordLessThan(this.getSuPasswordLess());
		}
		if(this.getSuRealNameEquals()!=null){
			c.andsuRealNameEqualTo(this.getSuRealNameEquals());
		}else if(this.getSuRealNameIsNull()!=null && this.getSuRealNameIsNull()){
			c.andsuRealNameIsNull();
		}else if(this.getSuRealNameIsNotNull()!=null && this.getSuRealNameIsNotNull()){
			c.andsuRealNameIsNotNull();
		}else if(this.getSuRealNameLike()!=null){
			c.andsuRealNameLike(this.getSuRealNameLike());
		}else if(this.getSuRealNameIn()!=null){
			c.andsuRealNameIn(java.util.Arrays.asList(this.getSuRealNameIn()));
		}else if(this.getSuRealNameStart()!=null && this.getSuRealNameEnd()!=null){
			c.andsuRealNameBetween(this.getSuRealNameStart(), this.getSuRealNameEnd());
		}else if(this.getSuRealNameGreater()!=null){
			c.andsuRealNameGreaterThan(this.getSuRealNameGreater());
		}else if(this.getSuRealNameLess()!=null){
			c.andsuRealNameLessThan(this.getSuRealNameLess());
		}
		if(this.getSuMobileEquals()!=null){
			c.andsuMobileEqualTo(this.getSuMobileEquals());
		}else if(this.getSuMobileIsNull()!=null && this.getSuMobileIsNull()){
			c.andsuMobileIsNull();
		}else if(this.getSuMobileIsNotNull()!=null && this.getSuMobileIsNotNull()){
			c.andsuMobileIsNotNull();
		}else if(this.getSuMobileLike()!=null){
			c.andsuMobileLike(this.getSuMobileLike());
		}else if(this.getSuMobileIn()!=null){
			c.andsuMobileIn(java.util.Arrays.asList(this.getSuMobileIn()));
		}else if(this.getSuMobileStart()!=null && this.getSuMobileEnd()!=null){
			c.andsuMobileBetween(this.getSuMobileStart(), this.getSuMobileEnd());
		}else if(this.getSuMobileGreater()!=null){
			c.andsuMobileGreaterThan(this.getSuMobileGreater());
		}else if(this.getSuMobileLess()!=null){
			c.andsuMobileLessThan(this.getSuMobileLess());
		}
		if(this.getSuShortcutEquals()!=null){
			c.andsuShortcutEqualTo(this.getSuShortcutEquals());
		}else if(this.getSuShortcutIsNull()!=null && this.getSuShortcutIsNull()){
			c.andsuShortcutIsNull();
		}else if(this.getSuShortcutIsNotNull()!=null && this.getSuShortcutIsNotNull()){
			c.andsuShortcutIsNotNull();
		}else if(this.getSuShortcutLike()!=null){
			c.andsuShortcutLike(this.getSuShortcutLike());
		}else if(this.getSuShortcutIn()!=null){
			c.andsuShortcutIn(java.util.Arrays.asList(this.getSuShortcutIn()));
		}else if(this.getSuShortcutStart()!=null && this.getSuShortcutEnd()!=null){
			c.andsuShortcutBetween(this.getSuShortcutStart(), this.getSuShortcutEnd());
		}else if(this.getSuShortcutGreater()!=null){
			c.andsuShortcutGreaterThan(this.getSuShortcutGreater());
		}else if(this.getSuShortcutLess()!=null){
			c.andsuShortcutLessThan(this.getSuShortcutLess());
		}
		if(this.getSuAddTimeEquals()!=null){
			c.andsuAddTimeEqualTo(this.getSuAddTimeEquals());
		}else if(this.getSuAddTimeIsNull()!=null && this.getSuAddTimeIsNull()){
			c.andsuAddTimeIsNull();
		}else if(this.getSuAddTimeIsNotNull()!=null && this.getSuAddTimeIsNotNull()){
			c.andsuAddTimeIsNotNull();
		}else if(this.getSuAddTimeIn()!=null){
			c.andsuAddTimeIn(java.util.Arrays.asList(this.getSuAddTimeIn()));
		}else if(this.getSuAddTimeStart()!=null && this.getSuAddTimeEnd()!=null){
			c.andsuAddTimeBetween(this.getSuAddTimeStart(), this.getSuAddTimeEnd());
		}else if(this.getSuAddTimeGreater()!=null){
			c.andsuAddTimeGreaterThan(this.getSuAddTimeGreater());
		}else if(this.getSuAddTimeLess()!=null){
			c.andsuAddTimeLessThan(this.getSuAddTimeLess());
		}
		if(this.getSuLastTimeEquals()!=null){
			c.andsuLastTimeEqualTo(this.getSuLastTimeEquals());
		}else if(this.getSuLastTimeIsNull()!=null && this.getSuLastTimeIsNull()){
			c.andsuLastTimeIsNull();
		}else if(this.getSuLastTimeIsNotNull()!=null && this.getSuLastTimeIsNotNull()){
			c.andsuLastTimeIsNotNull();
		}else if(this.getSuLastTimeIn()!=null){
			c.andsuLastTimeIn(java.util.Arrays.asList(this.getSuLastTimeIn()));
		}else if(this.getSuLastTimeStart()!=null && this.getSuLastTimeEnd()!=null){
			c.andsuLastTimeBetween(this.getSuLastTimeStart(), this.getSuLastTimeEnd());
		}else if(this.getSuLastTimeGreater()!=null){
			c.andsuLastTimeGreaterThan(this.getSuLastTimeGreater());
		}else if(this.getSuLastTimeLess()!=null){
			c.andsuLastTimeLessThan(this.getSuLastTimeLess());
		}
		if(this.getSuLastIpEquals()!=null){
			c.andsuLastIpEqualTo(this.getSuLastIpEquals());
		}else if(this.getSuLastIpIsNull()!=null && this.getSuLastIpIsNull()){
			c.andsuLastIpIsNull();
		}else if(this.getSuLastIpIsNotNull()!=null && this.getSuLastIpIsNotNull()){
			c.andsuLastIpIsNotNull();
		}else if(this.getSuLastIpLike()!=null){
			c.andsuLastIpLike(this.getSuLastIpLike());
		}else if(this.getSuLastIpIn()!=null){
			c.andsuLastIpIn(java.util.Arrays.asList(this.getSuLastIpIn()));
		}else if(this.getSuLastIpStart()!=null && this.getSuLastIpEnd()!=null){
			c.andsuLastIpBetween(this.getSuLastIpStart(), this.getSuLastIpEnd());
		}else if(this.getSuLastIpGreater()!=null){
			c.andsuLastIpGreaterThan(this.getSuLastIpGreater());
		}else if(this.getSuLastIpLess()!=null){
			c.andsuLastIpLessThan(this.getSuLastIpLess());
		}
		if(this.getSuStatusEquals()!=null){
			c.andsuStatusEqualTo(this.getSuStatusEquals());
		}else if(this.getSuStatusIsNull()!=null && this.getSuStatusIsNull()){
			c.andsuStatusIsNull();
		}else if(this.getSuStatusIsNotNull()!=null && this.getSuStatusIsNotNull()){
			c.andsuStatusIsNotNull();
		}else if(this.getSuStatusIn()!=null){
			c.andsuStatusIn(java.util.Arrays.asList(this.getSuStatusIn()));
		}else if(this.getSuStatusStart()!=null && this.getSuStatusEnd()!=null){
			c.andsuStatusBetween(this.getSuStatusStart(), this.getSuStatusEnd());
		}else if(this.getSuStatusGreater()!=null){
			c.andsuStatusGreaterThan(this.getSuStatusGreater());
		}else if(this.getSuStatusLess()!=null){
			c.andsuStatusLessThan(this.getSuStatusLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
