package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.SrvHostCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SrvHostQuery {
	
	private Integer shIdEquals;
	private Integer[] shIdIn;
	private Boolean shIdIsNull;
	private Boolean shIdIsNotNull;
	
	private Integer shIdStart;
	
	private Integer shIdEnd;
	
	private Integer shIdLess;
	
	private Integer shIdGreater;
	private String shNameLike;
	
	private String shNameEquals;
	private String[] shNameIn;
	private Boolean shNameIsNull;
	private Boolean shNameIsNotNull;
	
	private String shNameStart;
	
	private String shNameEnd;
	
	private String shNameLess;
	
	private String shNameGreater;
	private String shKeyLike;
	
	private String shKeyEquals;
	private String[] shKeyIn;
	private Boolean shKeyIsNull;
	private Boolean shKeyIsNotNull;
	
	private String shKeyStart;
	
	private String shKeyEnd;
	
	private String shKeyLess;
	
	private String shKeyGreater;
	private String shTopicLike;
	
	private String shTopicEquals;
	private String[] shTopicIn;
	private Boolean shTopicIsNull;
	private Boolean shTopicIsNotNull;
	
	private String shTopicStart;
	
	private String shTopicEnd;
	
	private String shTopicLess;
	
	private String shTopicGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shAddTimeEquals;
	private Date[] shAddTimeIn;
	private Boolean shAddTimeIsNull;
	private Boolean shAddTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shAddTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shAddTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shUptTimeEquals;
	private Date[] shUptTimeIn;
	private Boolean shUptTimeIsNull;
	private Boolean shUptTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shUptTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shUptTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shUptTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shUptTimeGreater;
	
	private Short shStatusEquals;
	private Short[] shStatusIn;
	private Boolean shStatusIsNull;
	private Boolean shStatusIsNotNull;
	
	private Short shStatusStart;
	
	private Short shStatusEnd;
	
	private Short shStatusLess;
	
	private Short shStatusGreater;
	private String shAppidLike;
	
	private String shAppidEquals;
	private String[] shAppidIn;
	private Boolean shAppidIsNull;
	private Boolean shAppidIsNotNull;
	
	private String shAppidStart;
	
	private String shAppidEnd;
	
	private String shAppidLess;
	
	private String shAppidGreater;
	private String sidx;
	private String sord;

	public SrvHostQuery setShIdEquals(Integer shIdEquals){
		this.shIdEquals = shIdEquals;
		return this;
	}
	public Integer getShIdEquals(){
		return this.shIdEquals;
	}
	public SrvHostQuery setShIdIn(Integer[] shIdIn){
		this.shIdIn = shIdIn;
		return this;
	}
	public Integer[] getShIdIn(){
		return this.shIdIn;
	}
	public SrvHostQuery setShIdIsNull(Boolean shIdIsNull){
		this.shIdIsNull = shIdIsNull;
		return this;
	}
	public Boolean getShIdIsNull(){
		return this.shIdIsNull;
	}
	public SrvHostQuery setShIdIsNotNull(Boolean shIdIsNotNull){
		this.shIdIsNotNull = shIdIsNotNull;
		return this;
	}
	public Boolean getShIdIsNotNull(){
		return this.shIdIsNotNull;
	}
	public SrvHostQuery setShIdStart(Integer shIdStart){
		this.shIdStart = shIdStart;
		return this;
	}
	public Integer getShIdStart(){
		return this.shIdStart;
	}
	public SrvHostQuery setShIdEnd(Integer shIdEnd){
		this.shIdEnd = shIdEnd;
		return this;
	}
	public Integer getShIdEnd(){
		return this.shIdEnd;
	}
	public SrvHostQuery setShIdLess(Integer shIdLess){
		this.shIdLess = shIdLess;
		return this;
	}
	public Integer getShIdLess(){
		return this.shIdLess;
	}
	public SrvHostQuery setShIdGreater(Integer shIdGreater){
		this.shIdGreater = shIdGreater;
		return this;
	}
	public Integer getShIdGreater(){
		return this.shIdGreater;
	}
	public SrvHostQuery setShNameLike(String shNameLike){
		this.shNameLike = shNameLike;
		return this;
	}
	public String getShNameLike(){
		return this.shNameLike;
	}
	public SrvHostQuery setShNameEquals(String shNameEquals){
		this.shNameEquals = shNameEquals;
		return this;
	}
	public String getShNameEquals(){
		return this.shNameEquals;
	}
	public SrvHostQuery setShNameIn(String[] shNameIn){
		this.shNameIn = shNameIn;
		return this;
	}
	public String[] getShNameIn(){
		return this.shNameIn;
	}
	public SrvHostQuery setShNameIsNull(Boolean shNameIsNull){
		this.shNameIsNull = shNameIsNull;
		return this;
	}
	public Boolean getShNameIsNull(){
		return this.shNameIsNull;
	}
	public SrvHostQuery setShNameIsNotNull(Boolean shNameIsNotNull){
		this.shNameIsNotNull = shNameIsNotNull;
		return this;
	}
	public Boolean getShNameIsNotNull(){
		return this.shNameIsNotNull;
	}
	public SrvHostQuery setShNameStart(String shNameStart){
		this.shNameStart = shNameStart;
		return this;
	}
	public String getShNameStart(){
		return this.shNameStart;
	}
	public SrvHostQuery setShNameEnd(String shNameEnd){
		this.shNameEnd = shNameEnd;
		return this;
	}
	public String getShNameEnd(){
		return this.shNameEnd;
	}
	public SrvHostQuery setShNameLess(String shNameLess){
		this.shNameLess = shNameLess;
		return this;
	}
	public String getShNameLess(){
		return this.shNameLess;
	}
	public SrvHostQuery setShNameGreater(String shNameGreater){
		this.shNameGreater = shNameGreater;
		return this;
	}
	public String getShNameGreater(){
		return this.shNameGreater;
	}
	public SrvHostQuery setShKeyLike(String shKeyLike){
		this.shKeyLike = shKeyLike;
		return this;
	}
	public String getShKeyLike(){
		return this.shKeyLike;
	}
	public SrvHostQuery setShKeyEquals(String shKeyEquals){
		this.shKeyEquals = shKeyEquals;
		return this;
	}
	public String getShKeyEquals(){
		return this.shKeyEquals;
	}
	public SrvHostQuery setShKeyIn(String[] shKeyIn){
		this.shKeyIn = shKeyIn;
		return this;
	}
	public String[] getShKeyIn(){
		return this.shKeyIn;
	}
	public SrvHostQuery setShKeyIsNull(Boolean shKeyIsNull){
		this.shKeyIsNull = shKeyIsNull;
		return this;
	}
	public Boolean getShKeyIsNull(){
		return this.shKeyIsNull;
	}
	public SrvHostQuery setShKeyIsNotNull(Boolean shKeyIsNotNull){
		this.shKeyIsNotNull = shKeyIsNotNull;
		return this;
	}
	public Boolean getShKeyIsNotNull(){
		return this.shKeyIsNotNull;
	}
	public SrvHostQuery setShKeyStart(String shKeyStart){
		this.shKeyStart = shKeyStart;
		return this;
	}
	public String getShKeyStart(){
		return this.shKeyStart;
	}
	public SrvHostQuery setShKeyEnd(String shKeyEnd){
		this.shKeyEnd = shKeyEnd;
		return this;
	}
	public String getShKeyEnd(){
		return this.shKeyEnd;
	}
	public SrvHostQuery setShKeyLess(String shKeyLess){
		this.shKeyLess = shKeyLess;
		return this;
	}
	public String getShKeyLess(){
		return this.shKeyLess;
	}
	public SrvHostQuery setShKeyGreater(String shKeyGreater){
		this.shKeyGreater = shKeyGreater;
		return this;
	}
	public String getShKeyGreater(){
		return this.shKeyGreater;
	}
	public SrvHostQuery setShTopicLike(String shTopicLike){
		this.shTopicLike = shTopicLike;
		return this;
	}
	public String getShTopicLike(){
		return this.shTopicLike;
	}
	public SrvHostQuery setShTopicEquals(String shTopicEquals){
		this.shTopicEquals = shTopicEquals;
		return this;
	}
	public String getShTopicEquals(){
		return this.shTopicEquals;
	}
	public SrvHostQuery setShTopicIn(String[] shTopicIn){
		this.shTopicIn = shTopicIn;
		return this;
	}
	public String[] getShTopicIn(){
		return this.shTopicIn;
	}
	public SrvHostQuery setShTopicIsNull(Boolean shTopicIsNull){
		this.shTopicIsNull = shTopicIsNull;
		return this;
	}
	public Boolean getShTopicIsNull(){
		return this.shTopicIsNull;
	}
	public SrvHostQuery setShTopicIsNotNull(Boolean shTopicIsNotNull){
		this.shTopicIsNotNull = shTopicIsNotNull;
		return this;
	}
	public Boolean getShTopicIsNotNull(){
		return this.shTopicIsNotNull;
	}
	public SrvHostQuery setShTopicStart(String shTopicStart){
		this.shTopicStart = shTopicStart;
		return this;
	}
	public String getShTopicStart(){
		return this.shTopicStart;
	}
	public SrvHostQuery setShTopicEnd(String shTopicEnd){
		this.shTopicEnd = shTopicEnd;
		return this;
	}
	public String getShTopicEnd(){
		return this.shTopicEnd;
	}
	public SrvHostQuery setShTopicLess(String shTopicLess){
		this.shTopicLess = shTopicLess;
		return this;
	}
	public String getShTopicLess(){
		return this.shTopicLess;
	}
	public SrvHostQuery setShTopicGreater(String shTopicGreater){
		this.shTopicGreater = shTopicGreater;
		return this;
	}
	public String getShTopicGreater(){
		return this.shTopicGreater;
	}
	public SrvHostQuery setShAddTimeEquals(Date shAddTimeEquals){
		this.shAddTimeEquals = shAddTimeEquals;
		return this;
	}
	public Date getShAddTimeEquals(){
		return this.shAddTimeEquals;
	}
	public SrvHostQuery setShAddTimeIn(Date[] shAddTimeIn){
		this.shAddTimeIn = shAddTimeIn;
		return this;
	}
	public Date[] getShAddTimeIn(){
		return this.shAddTimeIn;
	}
	public SrvHostQuery setShAddTimeIsNull(Boolean shAddTimeIsNull){
		this.shAddTimeIsNull = shAddTimeIsNull;
		return this;
	}
	public Boolean getShAddTimeIsNull(){
		return this.shAddTimeIsNull;
	}
	public SrvHostQuery setShAddTimeIsNotNull(Boolean shAddTimeIsNotNull){
		this.shAddTimeIsNotNull = shAddTimeIsNotNull;
		return this;
	}
	public Boolean getShAddTimeIsNotNull(){
		return this.shAddTimeIsNotNull;
	}
	public SrvHostQuery setShAddTimeStart(Date shAddTimeStart){
		this.shAddTimeStart = shAddTimeStart;
		return this;
	}
	public Date getShAddTimeStart(){
		return this.shAddTimeStart;
	}
	public SrvHostQuery setShAddTimeEnd(Date shAddTimeEnd){
		this.shAddTimeEnd = shAddTimeEnd;
		return this;
	}
	public Date getShAddTimeEnd(){
		return this.shAddTimeEnd;
	}
	public SrvHostQuery setShAddTimeLess(Date shAddTimeLess){
		this.shAddTimeLess = shAddTimeLess;
		return this;
	}
	public Date getShAddTimeLess(){
		return this.shAddTimeLess;
	}
	public SrvHostQuery setShAddTimeGreater(Date shAddTimeGreater){
		this.shAddTimeGreater = shAddTimeGreater;
		return this;
	}
	public Date getShAddTimeGreater(){
		return this.shAddTimeGreater;
	}
	public SrvHostQuery setShUptTimeEquals(Date shUptTimeEquals){
		this.shUptTimeEquals = shUptTimeEquals;
		return this;
	}
	public Date getShUptTimeEquals(){
		return this.shUptTimeEquals;
	}
	public SrvHostQuery setShUptTimeIn(Date[] shUptTimeIn){
		this.shUptTimeIn = shUptTimeIn;
		return this;
	}
	public Date[] getShUptTimeIn(){
		return this.shUptTimeIn;
	}
	public SrvHostQuery setShUptTimeIsNull(Boolean shUptTimeIsNull){
		this.shUptTimeIsNull = shUptTimeIsNull;
		return this;
	}
	public Boolean getShUptTimeIsNull(){
		return this.shUptTimeIsNull;
	}
	public SrvHostQuery setShUptTimeIsNotNull(Boolean shUptTimeIsNotNull){
		this.shUptTimeIsNotNull = shUptTimeIsNotNull;
		return this;
	}
	public Boolean getShUptTimeIsNotNull(){
		return this.shUptTimeIsNotNull;
	}
	public SrvHostQuery setShUptTimeStart(Date shUptTimeStart){
		this.shUptTimeStart = shUptTimeStart;
		return this;
	}
	public Date getShUptTimeStart(){
		return this.shUptTimeStart;
	}
	public SrvHostQuery setShUptTimeEnd(Date shUptTimeEnd){
		this.shUptTimeEnd = shUptTimeEnd;
		return this;
	}
	public Date getShUptTimeEnd(){
		return this.shUptTimeEnd;
	}
	public SrvHostQuery setShUptTimeLess(Date shUptTimeLess){
		this.shUptTimeLess = shUptTimeLess;
		return this;
	}
	public Date getShUptTimeLess(){
		return this.shUptTimeLess;
	}
	public SrvHostQuery setShUptTimeGreater(Date shUptTimeGreater){
		this.shUptTimeGreater = shUptTimeGreater;
		return this;
	}
	public Date getShUptTimeGreater(){
		return this.shUptTimeGreater;
	}
	public SrvHostQuery setShStatusEquals(Short shStatusEquals){
		this.shStatusEquals = shStatusEquals;
		return this;
	}
	public Short getShStatusEquals(){
		return this.shStatusEquals;
	}
	public SrvHostQuery setShStatusIn(Short[] shStatusIn){
		this.shStatusIn = shStatusIn;
		return this;
	}
	public Short[] getShStatusIn(){
		return this.shStatusIn;
	}
	public SrvHostQuery setShStatusIsNull(Boolean shStatusIsNull){
		this.shStatusIsNull = shStatusIsNull;
		return this;
	}
	public Boolean getShStatusIsNull(){
		return this.shStatusIsNull;
	}
	public SrvHostQuery setShStatusIsNotNull(Boolean shStatusIsNotNull){
		this.shStatusIsNotNull = shStatusIsNotNull;
		return this;
	}
	public Boolean getShStatusIsNotNull(){
		return this.shStatusIsNotNull;
	}
	public SrvHostQuery setShStatusStart(Short shStatusStart){
		this.shStatusStart = shStatusStart;
		return this;
	}
	public Short getShStatusStart(){
		return this.shStatusStart;
	}
	public SrvHostQuery setShStatusEnd(Short shStatusEnd){
		this.shStatusEnd = shStatusEnd;
		return this;
	}
	public Short getShStatusEnd(){
		return this.shStatusEnd;
	}
	public SrvHostQuery setShStatusLess(Short shStatusLess){
		this.shStatusLess = shStatusLess;
		return this;
	}
	public Short getShStatusLess(){
		return this.shStatusLess;
	}
	public SrvHostQuery setShStatusGreater(Short shStatusGreater){
		this.shStatusGreater = shStatusGreater;
		return this;
	}
	public Short getShStatusGreater(){
		return this.shStatusGreater;
	}
	public SrvHostQuery setShAppidLike(String shAppidLike){
		this.shAppidLike = shAppidLike;
		return this;
	}
	public String getShAppidLike(){
		return this.shAppidLike;
	}
	public SrvHostQuery setShAppidEquals(String shAppidEquals){
		this.shAppidEquals = shAppidEquals;
		return this;
	}
	public String getShAppidEquals(){
		return this.shAppidEquals;
	}
	public SrvHostQuery setShAppidIn(String[] shAppidIn){
		this.shAppidIn = shAppidIn;
		return this;
	}
	public String[] getShAppidIn(){
		return this.shAppidIn;
	}
	public SrvHostQuery setShAppidIsNull(Boolean shAppidIsNull){
		this.shAppidIsNull = shAppidIsNull;
		return this;
	}
	public Boolean getShAppidIsNull(){
		return this.shAppidIsNull;
	}
	public SrvHostQuery setShAppidIsNotNull(Boolean shAppidIsNotNull){
		this.shAppidIsNotNull = shAppidIsNotNull;
		return this;
	}
	public Boolean getShAppidIsNotNull(){
		return this.shAppidIsNotNull;
	}
	public SrvHostQuery setShAppidStart(String shAppidStart){
		this.shAppidStart = shAppidStart;
		return this;
	}
	public String getShAppidStart(){
		return this.shAppidStart;
	}
	public SrvHostQuery setShAppidEnd(String shAppidEnd){
		this.shAppidEnd = shAppidEnd;
		return this;
	}
	public String getShAppidEnd(){
		return this.shAppidEnd;
	}
	public SrvHostQuery setShAppidLess(String shAppidLess){
		this.shAppidLess = shAppidLess;
		return this;
	}
	public String getShAppidLess(){
		return this.shAppidLess;
	}
	public SrvHostQuery setShAppidGreater(String shAppidGreater){
		this.shAppidGreater = shAppidGreater;
		return this;
	}
	public String getShAppidGreater(){
		return this.shAppidGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("shId")){
			return "sh_id";
		}
		else if(this.sidx.equals("shName")){
			return "sh_name";
		}
		else if(this.sidx.equals("shKey")){
			return "sh_key";
		}
		else if(this.sidx.equals("shTopic")){
			return "sh_topic";
		}
		else if(this.sidx.equals("shAddTime")){
			return "sh_add_time";
		}
		else if(this.sidx.equals("shUptTime")){
			return "sh_upt_time";
		}
		else if(this.sidx.equals("shStatus")){
			return "sh_status";
		}
		else if(this.sidx.equals("shAppid")){
			return "sh_appid";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public SrvHostCrieria getCrieria(){
		SrvHostCrieria q = new SrvHostCrieria();
		SrvHostCrieria.Criteria c = q.createCriteria();
		
		if(this.getShIdEquals()!=null){
			c.andshIdEqualTo(this.getShIdEquals());
		}else if(this.getShIdIsNull()!=null && this.getShIdIsNull()){
			c.andshIdIsNull();
		}else if(this.getShIdIsNotNull()!=null && this.getShIdIsNotNull()){
			c.andshIdIsNotNull();
		}else if(this.getShIdIn()!=null){
			c.andshIdIn(java.util.Arrays.asList(this.getShIdIn()));
		}else if(this.getShIdStart()!=null && this.getShIdEnd()!=null){
			c.andshIdBetween(this.getShIdStart(), this.getShIdEnd());
		}else if(this.getShIdGreater()!=null){
			c.andshIdGreaterThan(this.getShIdGreater());
		}else if(this.getShIdLess()!=null){
			c.andshIdLessThan(this.getShIdLess());
		}
		if(this.getShNameEquals()!=null){
			c.andshNameEqualTo(this.getShNameEquals());
		}else if(this.getShNameIsNull()!=null && this.getShNameIsNull()){
			c.andshNameIsNull();
		}else if(this.getShNameIsNotNull()!=null && this.getShNameIsNotNull()){
			c.andshNameIsNotNull();
		}else if(this.getShNameLike()!=null){
			c.andshNameLike(this.getShNameLike());
		}else if(this.getShNameIn()!=null){
			c.andshNameIn(java.util.Arrays.asList(this.getShNameIn()));
		}else if(this.getShNameStart()!=null && this.getShNameEnd()!=null){
			c.andshNameBetween(this.getShNameStart(), this.getShNameEnd());
		}else if(this.getShNameGreater()!=null){
			c.andshNameGreaterThan(this.getShNameGreater());
		}else if(this.getShNameLess()!=null){
			c.andshNameLessThan(this.getShNameLess());
		}
		if(this.getShKeyEquals()!=null){
			c.andshKeyEqualTo(this.getShKeyEquals());
		}else if(this.getShKeyIsNull()!=null && this.getShKeyIsNull()){
			c.andshKeyIsNull();
		}else if(this.getShKeyIsNotNull()!=null && this.getShKeyIsNotNull()){
			c.andshKeyIsNotNull();
		}else if(this.getShKeyLike()!=null){
			c.andshKeyLike(this.getShKeyLike());
		}else if(this.getShKeyIn()!=null){
			c.andshKeyIn(java.util.Arrays.asList(this.getShKeyIn()));
		}else if(this.getShKeyStart()!=null && this.getShKeyEnd()!=null){
			c.andshKeyBetween(this.getShKeyStart(), this.getShKeyEnd());
		}else if(this.getShKeyGreater()!=null){
			c.andshKeyGreaterThan(this.getShKeyGreater());
		}else if(this.getShKeyLess()!=null){
			c.andshKeyLessThan(this.getShKeyLess());
		}
		if(this.getShTopicEquals()!=null){
			c.andshTopicEqualTo(this.getShTopicEquals());
		}else if(this.getShTopicIsNull()!=null && this.getShTopicIsNull()){
			c.andshTopicIsNull();
		}else if(this.getShTopicIsNotNull()!=null && this.getShTopicIsNotNull()){
			c.andshTopicIsNotNull();
		}else if(this.getShTopicLike()!=null){
			c.andshTopicLike(this.getShTopicLike());
		}else if(this.getShTopicIn()!=null){
			c.andshTopicIn(java.util.Arrays.asList(this.getShTopicIn()));
		}else if(this.getShTopicStart()!=null && this.getShTopicEnd()!=null){
			c.andshTopicBetween(this.getShTopicStart(), this.getShTopicEnd());
		}else if(this.getShTopicGreater()!=null){
			c.andshTopicGreaterThan(this.getShTopicGreater());
		}else if(this.getShTopicLess()!=null){
			c.andshTopicLessThan(this.getShTopicLess());
		}
		if(this.getShAddTimeEquals()!=null){
			c.andshAddTimeEqualTo(this.getShAddTimeEquals());
		}else if(this.getShAddTimeIsNull()!=null && this.getShAddTimeIsNull()){
			c.andshAddTimeIsNull();
		}else if(this.getShAddTimeIsNotNull()!=null && this.getShAddTimeIsNotNull()){
			c.andshAddTimeIsNotNull();
		}else if(this.getShAddTimeIn()!=null){
			c.andshAddTimeIn(java.util.Arrays.asList(this.getShAddTimeIn()));
		}else if(this.getShAddTimeStart()!=null && this.getShAddTimeEnd()!=null){
			c.andshAddTimeBetween(this.getShAddTimeStart(), this.getShAddTimeEnd());
		}else if(this.getShAddTimeGreater()!=null){
			c.andshAddTimeGreaterThan(this.getShAddTimeGreater());
		}else if(this.getShAddTimeLess()!=null){
			c.andshAddTimeLessThan(this.getShAddTimeLess());
		}
		if(this.getShUptTimeEquals()!=null){
			c.andshUptTimeEqualTo(this.getShUptTimeEquals());
		}else if(this.getShUptTimeIsNull()!=null && this.getShUptTimeIsNull()){
			c.andshUptTimeIsNull();
		}else if(this.getShUptTimeIsNotNull()!=null && this.getShUptTimeIsNotNull()){
			c.andshUptTimeIsNotNull();
		}else if(this.getShUptTimeIn()!=null){
			c.andshUptTimeIn(java.util.Arrays.asList(this.getShUptTimeIn()));
		}else if(this.getShUptTimeStart()!=null && this.getShUptTimeEnd()!=null){
			c.andshUptTimeBetween(this.getShUptTimeStart(), this.getShUptTimeEnd());
		}else if(this.getShUptTimeGreater()!=null){
			c.andshUptTimeGreaterThan(this.getShUptTimeGreater());
		}else if(this.getShUptTimeLess()!=null){
			c.andshUptTimeLessThan(this.getShUptTimeLess());
		}
		if(this.getShStatusEquals()!=null){
			c.andshStatusEqualTo(this.getShStatusEquals());
		}else if(this.getShStatusIsNull()!=null && this.getShStatusIsNull()){
			c.andshStatusIsNull();
		}else if(this.getShStatusIsNotNull()!=null && this.getShStatusIsNotNull()){
			c.andshStatusIsNotNull();
		}else if(this.getShStatusIn()!=null){
			c.andshStatusIn(java.util.Arrays.asList(this.getShStatusIn()));
		}else if(this.getShStatusStart()!=null && this.getShStatusEnd()!=null){
			c.andshStatusBetween(this.getShStatusStart(), this.getShStatusEnd());
		}else if(this.getShStatusGreater()!=null){
			c.andshStatusGreaterThan(this.getShStatusGreater());
		}else if(this.getShStatusLess()!=null){
			c.andshStatusLessThan(this.getShStatusLess());
		}
		if(this.getShAppidEquals()!=null){
			c.andshAppidEqualTo(this.getShAppidEquals());
		}else if(this.getShAppidIsNull()!=null && this.getShAppidIsNull()){
			c.andshAppidIsNull();
		}else if(this.getShAppidIsNotNull()!=null && this.getShAppidIsNotNull()){
			c.andshAppidIsNotNull();
		}else if(this.getShAppidLike()!=null){
			c.andshAppidLike(this.getShAppidLike());
		}else if(this.getShAppidIn()!=null){
			c.andshAppidIn(java.util.Arrays.asList(this.getShAppidIn()));
		}else if(this.getShAppidStart()!=null && this.getShAppidEnd()!=null){
			c.andshAppidBetween(this.getShAppidStart(), this.getShAppidEnd());
		}else if(this.getShAppidGreater()!=null){
			c.andshAppidGreaterThan(this.getShAppidGreater());
		}else if(this.getShAppidLess()!=null){
			c.andshAppidLessThan(this.getShAppidLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
