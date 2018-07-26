package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.VerUpgradeRecordCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class VerUpgradeRecordQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	private String vinLike;
	
	private String vinEquals;
	private String[] vinIn;
	private Boolean vinIsNull;
	private Boolean vinIsNotNull;
	
	private String vinStart;
	
	private String vinEnd;
	
	private String vinLess;
	
	private String vinGreater;
	
	private Integer carModelEquals;
	private Integer[] carModelIn;
	private Boolean carModelIsNull;
	private Boolean carModelIsNotNull;
	
	private Integer carModelStart;
	
	private Integer carModelEnd;
	
	private Integer carModelLess;
	
	private Integer carModelGreater;
	private String teNumberLike;
	
	private String teNumberEquals;
	private String[] teNumberIn;
	private Boolean teNumberIsNull;
	private Boolean teNumberIsNotNull;
	
	private String teNumberStart;
	
	private String teNumberEnd;
	
	private String teNumberLess;
	
	private String teNumberGreater;
	
	private Short teTypeEquals;
	private Short[] teTypeIn;
	private Boolean teTypeIsNull;
	private Boolean teTypeIsNotNull;
	
	private Short teTypeStart;
	
	private Short teTypeEnd;
	
	private Short teTypeLess;
	
	private Short teTypeGreater;
	private String teModelLike;
	
	private String teModelEquals;
	private String[] teModelIn;
	private Boolean teModelIsNull;
	private Boolean teModelIsNotNull;
	
	private String teModelStart;
	
	private String teModelEnd;
	
	private String teModelLess;
	
	private String teModelGreater;
	
	private Integer fromVersionEquals;
	private Integer[] fromVersionIn;
	private Boolean fromVersionIsNull;
	private Boolean fromVersionIsNotNull;
	
	private Integer fromVersionStart;
	
	private Integer fromVersionEnd;
	
	private Integer fromVersionLess;
	
	private Integer fromVersionGreater;
	
	private Integer toVersionEquals;
	private Integer[] toVersionIn;
	private Boolean toVersionIsNull;
	private Boolean toVersionIsNotNull;
	
	private Integer toVersionStart;
	
	private Integer toVersionEnd;
	
	private Integer toVersionLess;
	
	private Integer toVersionGreater;
	
	private Short statusEquals;
	private Short[] statusIn;
	private Boolean statusIsNull;
	private Boolean statusIsNotNull;
	
	private Short statusStart;
	
	private Short statusEnd;
	
	private Short statusLess;
	
	private Short statusGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date addTimeEquals;
	private Date[] addTimeIn;
	private Boolean addTimeIsNull;
	private Boolean addTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date addTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date addTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date addTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date addTimeGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateTimeEquals;
	private Date[] updateTimeIn;
	private Boolean updateTimeIsNull;
	private Boolean updateTimeIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateTimeLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateTimeGreater;
	private String sidx;
	private String sord;

	public VerUpgradeRecordQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public VerUpgradeRecordQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public VerUpgradeRecordQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public VerUpgradeRecordQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public VerUpgradeRecordQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public VerUpgradeRecordQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public VerUpgradeRecordQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public VerUpgradeRecordQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public VerUpgradeRecordQuery setvinLike(String vinLike){
		this.vinLike = vinLike;
		return this;
	}
	public String getvinLike(){
		return this.vinLike;
	}
	public VerUpgradeRecordQuery setvinEquals(String vinEquals){
		this.vinEquals = vinEquals;
		return this;
	}
	public String getvinEquals(){
		return this.vinEquals;
	}
	public VerUpgradeRecordQuery setvinIn(String[] vinIn){
		this.vinIn = vinIn;
		return this;
	}
	public String[] getvinIn(){
		return this.vinIn;
	}
	public VerUpgradeRecordQuery setvinIsNull(Boolean vinIsNull){
		this.vinIsNull = vinIsNull;
		return this;
	}
	public Boolean getvinIsNull(){
		return this.vinIsNull;
	}
	public VerUpgradeRecordQuery setvinIsNotNull(Boolean vinIsNotNull){
		this.vinIsNotNull = vinIsNotNull;
		return this;
	}
	public Boolean getvinIsNotNull(){
		return this.vinIsNotNull;
	}
	public VerUpgradeRecordQuery setvinStart(String vinStart){
		this.vinStart = vinStart;
		return this;
	}
	public String getvinStart(){
		return this.vinStart;
	}
	public VerUpgradeRecordQuery setvinEnd(String vinEnd){
		this.vinEnd = vinEnd;
		return this;
	}
	public String getvinEnd(){
		return this.vinEnd;
	}
	public VerUpgradeRecordQuery setvinLess(String vinLess){
		this.vinLess = vinLess;
		return this;
	}
	public String getvinLess(){
		return this.vinLess;
	}
	public VerUpgradeRecordQuery setvinGreater(String vinGreater){
		this.vinGreater = vinGreater;
		return this;
	}
	public String getvinGreater(){
		return this.vinGreater;
	}
	public VerUpgradeRecordQuery setCarModelEquals(Integer carModelEquals){
		this.carModelEquals = carModelEquals;
		return this;
	}
	public Integer getCarModelEquals(){
		return this.carModelEquals;
	}
	public VerUpgradeRecordQuery setCarModelIn(Integer[] carModelIn){
		this.carModelIn = carModelIn;
		return this;
	}
	public Integer[] getCarModelIn(){
		return this.carModelIn;
	}
	public VerUpgradeRecordQuery setCarModelIsNull(Boolean carModelIsNull){
		this.carModelIsNull = carModelIsNull;
		return this;
	}
	public Boolean getCarModelIsNull(){
		return this.carModelIsNull;
	}
	public VerUpgradeRecordQuery setCarModelIsNotNull(Boolean carModelIsNotNull){
		this.carModelIsNotNull = carModelIsNotNull;
		return this;
	}
	public Boolean getCarModelIsNotNull(){
		return this.carModelIsNotNull;
	}
	public VerUpgradeRecordQuery setCarModelStart(Integer carModelStart){
		this.carModelStart = carModelStart;
		return this;
	}
	public Integer getCarModelStart(){
		return this.carModelStart;
	}
	public VerUpgradeRecordQuery setCarModelEnd(Integer carModelEnd){
		this.carModelEnd = carModelEnd;
		return this;
	}
	public Integer getCarModelEnd(){
		return this.carModelEnd;
	}
	public VerUpgradeRecordQuery setCarModelLess(Integer carModelLess){
		this.carModelLess = carModelLess;
		return this;
	}
	public Integer getCarModelLess(){
		return this.carModelLess;
	}
	public VerUpgradeRecordQuery setCarModelGreater(Integer carModelGreater){
		this.carModelGreater = carModelGreater;
		return this;
	}
	public Integer getCarModelGreater(){
		return this.carModelGreater;
	}
	public VerUpgradeRecordQuery setTeNumberLike(String teNumberLike){
		this.teNumberLike = teNumberLike;
		return this;
	}
	public String getTeNumberLike(){
		return this.teNumberLike;
	}
	public VerUpgradeRecordQuery setTeNumberEquals(String teNumberEquals){
		this.teNumberEquals = teNumberEquals;
		return this;
	}
	public String getTeNumberEquals(){
		return this.teNumberEquals;
	}
	public VerUpgradeRecordQuery setTeNumberIn(String[] teNumberIn){
		this.teNumberIn = teNumberIn;
		return this;
	}
	public String[] getTeNumberIn(){
		return this.teNumberIn;
	}
	public VerUpgradeRecordQuery setTeNumberIsNull(Boolean teNumberIsNull){
		this.teNumberIsNull = teNumberIsNull;
		return this;
	}
	public Boolean getTeNumberIsNull(){
		return this.teNumberIsNull;
	}
	public VerUpgradeRecordQuery setTeNumberIsNotNull(Boolean teNumberIsNotNull){
		this.teNumberIsNotNull = teNumberIsNotNull;
		return this;
	}
	public Boolean getTeNumberIsNotNull(){
		return this.teNumberIsNotNull;
	}
	public VerUpgradeRecordQuery setTeNumberStart(String teNumberStart){
		this.teNumberStart = teNumberStart;
		return this;
	}
	public String getTeNumberStart(){
		return this.teNumberStart;
	}
	public VerUpgradeRecordQuery setTeNumberEnd(String teNumberEnd){
		this.teNumberEnd = teNumberEnd;
		return this;
	}
	public String getTeNumberEnd(){
		return this.teNumberEnd;
	}
	public VerUpgradeRecordQuery setTeNumberLess(String teNumberLess){
		this.teNumberLess = teNumberLess;
		return this;
	}
	public String getTeNumberLess(){
		return this.teNumberLess;
	}
	public VerUpgradeRecordQuery setTeNumberGreater(String teNumberGreater){
		this.teNumberGreater = teNumberGreater;
		return this;
	}
	public String getTeNumberGreater(){
		return this.teNumberGreater;
	}
	public VerUpgradeRecordQuery setTeTypeEquals(Short teTypeEquals){
		this.teTypeEquals = teTypeEquals;
		return this;
	}
	public Short getTeTypeEquals(){
		return this.teTypeEquals;
	}
	public VerUpgradeRecordQuery setTeTypeIn(Short[] teTypeIn){
		this.teTypeIn = teTypeIn;
		return this;
	}
	public Short[] getTeTypeIn(){
		return this.teTypeIn;
	}
	public VerUpgradeRecordQuery setTeTypeIsNull(Boolean teTypeIsNull){
		this.teTypeIsNull = teTypeIsNull;
		return this;
	}
	public Boolean getTeTypeIsNull(){
		return this.teTypeIsNull;
	}
	public VerUpgradeRecordQuery setTeTypeIsNotNull(Boolean teTypeIsNotNull){
		this.teTypeIsNotNull = teTypeIsNotNull;
		return this;
	}
	public Boolean getTeTypeIsNotNull(){
		return this.teTypeIsNotNull;
	}
	public VerUpgradeRecordQuery setTeTypeStart(Short teTypeStart){
		this.teTypeStart = teTypeStart;
		return this;
	}
	public Short getTeTypeStart(){
		return this.teTypeStart;
	}
	public VerUpgradeRecordQuery setTeTypeEnd(Short teTypeEnd){
		this.teTypeEnd = teTypeEnd;
		return this;
	}
	public Short getTeTypeEnd(){
		return this.teTypeEnd;
	}
	public VerUpgradeRecordQuery setTeTypeLess(Short teTypeLess){
		this.teTypeLess = teTypeLess;
		return this;
	}
	public Short getTeTypeLess(){
		return this.teTypeLess;
	}
	public VerUpgradeRecordQuery setTeTypeGreater(Short teTypeGreater){
		this.teTypeGreater = teTypeGreater;
		return this;
	}
	public Short getTeTypeGreater(){
		return this.teTypeGreater;
	}
	public VerUpgradeRecordQuery setTeModelLike(String teModelLike){
		this.teModelLike = teModelLike;
		return this;
	}
	public String getTeModelLike(){
		return this.teModelLike;
	}
	public VerUpgradeRecordQuery setTeModelEquals(String teModelEquals){
		this.teModelEquals = teModelEquals;
		return this;
	}
	public String getTeModelEquals(){
		return this.teModelEquals;
	}
	public VerUpgradeRecordQuery setTeModelIn(String[] teModelIn){
		this.teModelIn = teModelIn;
		return this;
	}
	public String[] getTeModelIn(){
		return this.teModelIn;
	}
	public VerUpgradeRecordQuery setTeModelIsNull(Boolean teModelIsNull){
		this.teModelIsNull = teModelIsNull;
		return this;
	}
	public Boolean getTeModelIsNull(){
		return this.teModelIsNull;
	}
	public VerUpgradeRecordQuery setTeModelIsNotNull(Boolean teModelIsNotNull){
		this.teModelIsNotNull = teModelIsNotNull;
		return this;
	}
	public Boolean getTeModelIsNotNull(){
		return this.teModelIsNotNull;
	}
	public VerUpgradeRecordQuery setTeModelStart(String teModelStart){
		this.teModelStart = teModelStart;
		return this;
	}
	public String getTeModelStart(){
		return this.teModelStart;
	}
	public VerUpgradeRecordQuery setTeModelEnd(String teModelEnd){
		this.teModelEnd = teModelEnd;
		return this;
	}
	public String getTeModelEnd(){
		return this.teModelEnd;
	}
	public VerUpgradeRecordQuery setTeModelLess(String teModelLess){
		this.teModelLess = teModelLess;
		return this;
	}
	public String getTeModelLess(){
		return this.teModelLess;
	}
	public VerUpgradeRecordQuery setTeModelGreater(String teModelGreater){
		this.teModelGreater = teModelGreater;
		return this;
	}
	public String getTeModelGreater(){
		return this.teModelGreater;
	}
	public VerUpgradeRecordQuery setFromVersionEquals(Integer fromVersionEquals){
		this.fromVersionEquals = fromVersionEquals;
		return this;
	}
	public Integer getFromVersionEquals(){
		return this.fromVersionEquals;
	}
	public VerUpgradeRecordQuery setFromVersionIn(Integer[] fromVersionIn){
		this.fromVersionIn = fromVersionIn;
		return this;
	}
	public Integer[] getFromVersionIn(){
		return this.fromVersionIn;
	}
	public VerUpgradeRecordQuery setFromVersionIsNull(Boolean fromVersionIsNull){
		this.fromVersionIsNull = fromVersionIsNull;
		return this;
	}
	public Boolean getFromVersionIsNull(){
		return this.fromVersionIsNull;
	}
	public VerUpgradeRecordQuery setFromVersionIsNotNull(Boolean fromVersionIsNotNull){
		this.fromVersionIsNotNull = fromVersionIsNotNull;
		return this;
	}
	public Boolean getFromVersionIsNotNull(){
		return this.fromVersionIsNotNull;
	}
	public VerUpgradeRecordQuery setFromVersionStart(Integer fromVersionStart){
		this.fromVersionStart = fromVersionStart;
		return this;
	}
	public Integer getFromVersionStart(){
		return this.fromVersionStart;
	}
	public VerUpgradeRecordQuery setFromVersionEnd(Integer fromVersionEnd){
		this.fromVersionEnd = fromVersionEnd;
		return this;
	}
	public Integer getFromVersionEnd(){
		return this.fromVersionEnd;
	}
	public VerUpgradeRecordQuery setFromVersionLess(Integer fromVersionLess){
		this.fromVersionLess = fromVersionLess;
		return this;
	}
	public Integer getFromVersionLess(){
		return this.fromVersionLess;
	}
	public VerUpgradeRecordQuery setFromVersionGreater(Integer fromVersionGreater){
		this.fromVersionGreater = fromVersionGreater;
		return this;
	}
	public Integer getFromVersionGreater(){
		return this.fromVersionGreater;
	}
	public VerUpgradeRecordQuery setToVersionEquals(Integer toVersionEquals){
		this.toVersionEquals = toVersionEquals;
		return this;
	}
	public Integer getToVersionEquals(){
		return this.toVersionEquals;
	}
	public VerUpgradeRecordQuery setToVersionIn(Integer[] toVersionIn){
		this.toVersionIn = toVersionIn;
		return this;
	}
	public Integer[] getToVersionIn(){
		return this.toVersionIn;
	}
	public VerUpgradeRecordQuery setToVersionIsNull(Boolean toVersionIsNull){
		this.toVersionIsNull = toVersionIsNull;
		return this;
	}
	public Boolean getToVersionIsNull(){
		return this.toVersionIsNull;
	}
	public VerUpgradeRecordQuery setToVersionIsNotNull(Boolean toVersionIsNotNull){
		this.toVersionIsNotNull = toVersionIsNotNull;
		return this;
	}
	public Boolean getToVersionIsNotNull(){
		return this.toVersionIsNotNull;
	}
	public VerUpgradeRecordQuery setToVersionStart(Integer toVersionStart){
		this.toVersionStart = toVersionStart;
		return this;
	}
	public Integer getToVersionStart(){
		return this.toVersionStart;
	}
	public VerUpgradeRecordQuery setToVersionEnd(Integer toVersionEnd){
		this.toVersionEnd = toVersionEnd;
		return this;
	}
	public Integer getToVersionEnd(){
		return this.toVersionEnd;
	}
	public VerUpgradeRecordQuery setToVersionLess(Integer toVersionLess){
		this.toVersionLess = toVersionLess;
		return this;
	}
	public Integer getToVersionLess(){
		return this.toVersionLess;
	}
	public VerUpgradeRecordQuery setToVersionGreater(Integer toVersionGreater){
		this.toVersionGreater = toVersionGreater;
		return this;
	}
	public Integer getToVersionGreater(){
		return this.toVersionGreater;
	}
	public VerUpgradeRecordQuery setstatusEquals(Short statusEquals){
		this.statusEquals = statusEquals;
		return this;
	}
	public Short getstatusEquals(){
		return this.statusEquals;
	}
	public VerUpgradeRecordQuery setstatusIn(Short[] statusIn){
		this.statusIn = statusIn;
		return this;
	}
	public Short[] getstatusIn(){
		return this.statusIn;
	}
	public VerUpgradeRecordQuery setstatusIsNull(Boolean statusIsNull){
		this.statusIsNull = statusIsNull;
		return this;
	}
	public Boolean getstatusIsNull(){
		return this.statusIsNull;
	}
	public VerUpgradeRecordQuery setstatusIsNotNull(Boolean statusIsNotNull){
		this.statusIsNotNull = statusIsNotNull;
		return this;
	}
	public Boolean getstatusIsNotNull(){
		return this.statusIsNotNull;
	}
	public VerUpgradeRecordQuery setstatusStart(Short statusStart){
		this.statusStart = statusStart;
		return this;
	}
	public Short getstatusStart(){
		return this.statusStart;
	}
	public VerUpgradeRecordQuery setstatusEnd(Short statusEnd){
		this.statusEnd = statusEnd;
		return this;
	}
	public Short getstatusEnd(){
		return this.statusEnd;
	}
	public VerUpgradeRecordQuery setstatusLess(Short statusLess){
		this.statusLess = statusLess;
		return this;
	}
	public Short getstatusLess(){
		return this.statusLess;
	}
	public VerUpgradeRecordQuery setstatusGreater(Short statusGreater){
		this.statusGreater = statusGreater;
		return this;
	}
	public Short getstatusGreater(){
		return this.statusGreater;
	}
	public VerUpgradeRecordQuery setAddTimeEquals(Date addTimeEquals){
		this.addTimeEquals = addTimeEquals;
		return this;
	}
	public Date getAddTimeEquals(){
		return this.addTimeEquals;
	}
	public VerUpgradeRecordQuery setAddTimeIn(Date[] addTimeIn){
		this.addTimeIn = addTimeIn;
		return this;
	}
	public Date[] getAddTimeIn(){
		return this.addTimeIn;
	}
	public VerUpgradeRecordQuery setAddTimeIsNull(Boolean addTimeIsNull){
		this.addTimeIsNull = addTimeIsNull;
		return this;
	}
	public Boolean getAddTimeIsNull(){
		return this.addTimeIsNull;
	}
	public VerUpgradeRecordQuery setAddTimeIsNotNull(Boolean addTimeIsNotNull){
		this.addTimeIsNotNull = addTimeIsNotNull;
		return this;
	}
	public Boolean getAddTimeIsNotNull(){
		return this.addTimeIsNotNull;
	}
	public VerUpgradeRecordQuery setAddTimeStart(Date addTimeStart){
		this.addTimeStart = addTimeStart;
		return this;
	}
	public Date getAddTimeStart(){
		return this.addTimeStart;
	}
	public VerUpgradeRecordQuery setAddTimeEnd(Date addTimeEnd){
		this.addTimeEnd = addTimeEnd;
		return this;
	}
	public Date getAddTimeEnd(){
		return this.addTimeEnd;
	}
	public VerUpgradeRecordQuery setAddTimeLess(Date addTimeLess){
		this.addTimeLess = addTimeLess;
		return this;
	}
	public Date getAddTimeLess(){
		return this.addTimeLess;
	}
	public VerUpgradeRecordQuery setAddTimeGreater(Date addTimeGreater){
		this.addTimeGreater = addTimeGreater;
		return this;
	}
	public Date getAddTimeGreater(){
		return this.addTimeGreater;
	}
	public VerUpgradeRecordQuery setUpdateTimeEquals(Date updateTimeEquals){
		this.updateTimeEquals = updateTimeEquals;
		return this;
	}
	public Date getUpdateTimeEquals(){
		return this.updateTimeEquals;
	}
	public VerUpgradeRecordQuery setUpdateTimeIn(Date[] updateTimeIn){
		this.updateTimeIn = updateTimeIn;
		return this;
	}
	public Date[] getUpdateTimeIn(){
		return this.updateTimeIn;
	}
	public VerUpgradeRecordQuery setUpdateTimeIsNull(Boolean updateTimeIsNull){
		this.updateTimeIsNull = updateTimeIsNull;
		return this;
	}
	public Boolean getUpdateTimeIsNull(){
		return this.updateTimeIsNull;
	}
	public VerUpgradeRecordQuery setUpdateTimeIsNotNull(Boolean updateTimeIsNotNull){
		this.updateTimeIsNotNull = updateTimeIsNotNull;
		return this;
	}
	public Boolean getUpdateTimeIsNotNull(){
		return this.updateTimeIsNotNull;
	}
	public VerUpgradeRecordQuery setUpdateTimeStart(Date updateTimeStart){
		this.updateTimeStart = updateTimeStart;
		return this;
	}
	public Date getUpdateTimeStart(){
		return this.updateTimeStart;
	}
	public VerUpgradeRecordQuery setUpdateTimeEnd(Date updateTimeEnd){
		this.updateTimeEnd = updateTimeEnd;
		return this;
	}
	public Date getUpdateTimeEnd(){
		return this.updateTimeEnd;
	}
	public VerUpgradeRecordQuery setUpdateTimeLess(Date updateTimeLess){
		this.updateTimeLess = updateTimeLess;
		return this;
	}
	public Date getUpdateTimeLess(){
		return this.updateTimeLess;
	}
	public VerUpgradeRecordQuery setUpdateTimeGreater(Date updateTimeGreater){
		this.updateTimeGreater = updateTimeGreater;
		return this;
	}
	public Date getUpdateTimeGreater(){
		return this.updateTimeGreater;
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
		else if(this.sidx.equals("vin")){
			return "vin";
		}
		else if(this.sidx.equals("carModel")){
			return "car_model";
		}
		else if(this.sidx.equals("teNumber")){
			return "te_number";
		}
		else if(this.sidx.equals("teType")){
			return "te_type";
		}
		else if(this.sidx.equals("teModel")){
			return "te_model";
		}
		else if(this.sidx.equals("fromVersion")){
			return "from_version";
		}
		else if(this.sidx.equals("toVersion")){
			return "to_version";
		}
		else if(this.sidx.equals("status")){
			return "status";
		}
		else if(this.sidx.equals("addTime")){
			return "add_time";
		}
		else if(this.sidx.equals("updateTime")){
			return "update_time";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public VerUpgradeRecordCrieria getCrieria(){
		VerUpgradeRecordCrieria q = new VerUpgradeRecordCrieria();
		VerUpgradeRecordCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getvinEquals()!=null){
			c.andvinEqualTo(this.getvinEquals());
		}else if(this.getvinIsNull()!=null && this.getvinIsNull()){
			c.andvinIsNull();
		}else if(this.getvinIsNotNull()!=null && this.getvinIsNotNull()){
			c.andvinIsNotNull();
		}else if(this.getvinLike()!=null){
			c.andvinLike(this.getvinLike());
		}else if(this.getvinIn()!=null){
			c.andvinIn(java.util.Arrays.asList(this.getvinIn()));
		}else if(this.getvinStart()!=null && this.getvinEnd()!=null){
			c.andvinBetween(this.getvinStart(), this.getvinEnd());
		}else if(this.getvinGreater()!=null){
			c.andvinGreaterThan(this.getvinGreater());
		}else if(this.getvinLess()!=null){
			c.andvinLessThan(this.getvinLess());
		}
		if(this.getCarModelEquals()!=null){
			c.andcarModelEqualTo(this.getCarModelEquals());
		}else if(this.getCarModelIsNull()!=null && this.getCarModelIsNull()){
			c.andcarModelIsNull();
		}else if(this.getCarModelIsNotNull()!=null && this.getCarModelIsNotNull()){
			c.andcarModelIsNotNull();
		}else if(this.getCarModelIn()!=null){
			c.andcarModelIn(java.util.Arrays.asList(this.getCarModelIn()));
		}else if(this.getCarModelStart()!=null && this.getCarModelEnd()!=null){
			c.andcarModelBetween(this.getCarModelStart(), this.getCarModelEnd());
		}else if(this.getCarModelGreater()!=null){
			c.andcarModelGreaterThan(this.getCarModelGreater());
		}else if(this.getCarModelLess()!=null){
			c.andcarModelLessThan(this.getCarModelLess());
		}
		if(this.getTeNumberEquals()!=null){
			c.andteNumberEqualTo(this.getTeNumberEquals());
		}else if(this.getTeNumberIsNull()!=null && this.getTeNumberIsNull()){
			c.andteNumberIsNull();
		}else if(this.getTeNumberIsNotNull()!=null && this.getTeNumberIsNotNull()){
			c.andteNumberIsNotNull();
		}else if(this.getTeNumberLike()!=null){
			c.andteNumberLike(this.getTeNumberLike());
		}else if(this.getTeNumberIn()!=null){
			c.andteNumberIn(java.util.Arrays.asList(this.getTeNumberIn()));
		}else if(this.getTeNumberStart()!=null && this.getTeNumberEnd()!=null){
			c.andteNumberBetween(this.getTeNumberStart(), this.getTeNumberEnd());
		}else if(this.getTeNumberGreater()!=null){
			c.andteNumberGreaterThan(this.getTeNumberGreater());
		}else if(this.getTeNumberLess()!=null){
			c.andteNumberLessThan(this.getTeNumberLess());
		}
		if(this.getTeTypeEquals()!=null){
			c.andteTypeEqualTo(this.getTeTypeEquals());
		}else if(this.getTeTypeIsNull()!=null && this.getTeTypeIsNull()){
			c.andteTypeIsNull();
		}else if(this.getTeTypeIsNotNull()!=null && this.getTeTypeIsNotNull()){
			c.andteTypeIsNotNull();
		}else if(this.getTeTypeIn()!=null){
			c.andteTypeIn(java.util.Arrays.asList(this.getTeTypeIn()));
		}else if(this.getTeTypeStart()!=null && this.getTeTypeEnd()!=null){
			c.andteTypeBetween(this.getTeTypeStart(), this.getTeTypeEnd());
		}else if(this.getTeTypeGreater()!=null){
			c.andteTypeGreaterThan(this.getTeTypeGreater());
		}else if(this.getTeTypeLess()!=null){
			c.andteTypeLessThan(this.getTeTypeLess());
		}
		if(this.getTeModelEquals()!=null){
			c.andteModelEqualTo(this.getTeModelEquals());
		}else if(this.getTeModelIsNull()!=null && this.getTeModelIsNull()){
			c.andteModelIsNull();
		}else if(this.getTeModelIsNotNull()!=null && this.getTeModelIsNotNull()){
			c.andteModelIsNotNull();
		}else if(this.getTeModelLike()!=null){
			c.andteModelLike(this.getTeModelLike());
		}else if(this.getTeModelIn()!=null){
			c.andteModelIn(java.util.Arrays.asList(this.getTeModelIn()));
		}else if(this.getTeModelStart()!=null && this.getTeModelEnd()!=null){
			c.andteModelBetween(this.getTeModelStart(), this.getTeModelEnd());
		}else if(this.getTeModelGreater()!=null){
			c.andteModelGreaterThan(this.getTeModelGreater());
		}else if(this.getTeModelLess()!=null){
			c.andteModelLessThan(this.getTeModelLess());
		}
		if(this.getFromVersionEquals()!=null){
			c.andfromVersionEqualTo(this.getFromVersionEquals());
		}else if(this.getFromVersionIsNull()!=null && this.getFromVersionIsNull()){
			c.andfromVersionIsNull();
		}else if(this.getFromVersionIsNotNull()!=null && this.getFromVersionIsNotNull()){
			c.andfromVersionIsNotNull();
		}else if(this.getFromVersionIn()!=null){
			c.andfromVersionIn(java.util.Arrays.asList(this.getFromVersionIn()));
		}else if(this.getFromVersionStart()!=null && this.getFromVersionEnd()!=null){
			c.andfromVersionBetween(this.getFromVersionStart(), this.getFromVersionEnd());
		}else if(this.getFromVersionGreater()!=null){
			c.andfromVersionGreaterThan(this.getFromVersionGreater());
		}else if(this.getFromVersionLess()!=null){
			c.andfromVersionLessThan(this.getFromVersionLess());
		}
		if(this.getToVersionEquals()!=null){
			c.andtoVersionEqualTo(this.getToVersionEquals());
		}else if(this.getToVersionIsNull()!=null && this.getToVersionIsNull()){
			c.andtoVersionIsNull();
		}else if(this.getToVersionIsNotNull()!=null && this.getToVersionIsNotNull()){
			c.andtoVersionIsNotNull();
		}else if(this.getToVersionIn()!=null){
			c.andtoVersionIn(java.util.Arrays.asList(this.getToVersionIn()));
		}else if(this.getToVersionStart()!=null && this.getToVersionEnd()!=null){
			c.andtoVersionBetween(this.getToVersionStart(), this.getToVersionEnd());
		}else if(this.getToVersionGreater()!=null){
			c.andtoVersionGreaterThan(this.getToVersionGreater());
		}else if(this.getToVersionLess()!=null){
			c.andtoVersionLessThan(this.getToVersionLess());
		}
		if(this.getstatusEquals()!=null){
			c.andstatusEqualTo(this.getstatusEquals());
		}else if(this.getstatusIsNull()!=null && this.getstatusIsNull()){
			c.andstatusIsNull();
		}else if(this.getstatusIsNotNull()!=null && this.getstatusIsNotNull()){
			c.andstatusIsNotNull();
		}else if(this.getstatusIn()!=null){
			c.andstatusIn(java.util.Arrays.asList(this.getstatusIn()));
		}else if(this.getstatusStart()!=null && this.getstatusEnd()!=null){
			c.andstatusBetween(this.getstatusStart(), this.getstatusEnd());
		}else if(this.getstatusGreater()!=null){
			c.andstatusGreaterThan(this.getstatusGreater());
		}else if(this.getstatusLess()!=null){
			c.andstatusLessThan(this.getstatusLess());
		}
		if(this.getAddTimeEquals()!=null){
			c.andaddTimeEqualTo(this.getAddTimeEquals());
		}else if(this.getAddTimeIsNull()!=null && this.getAddTimeIsNull()){
			c.andaddTimeIsNull();
		}else if(this.getAddTimeIsNotNull()!=null && this.getAddTimeIsNotNull()){
			c.andaddTimeIsNotNull();
		}else if(this.getAddTimeIn()!=null){
			c.andaddTimeIn(java.util.Arrays.asList(this.getAddTimeIn()));
		}else if(this.getAddTimeStart()!=null && this.getAddTimeEnd()!=null){
			c.andaddTimeBetween(this.getAddTimeStart(), this.getAddTimeEnd());
		}else if(this.getAddTimeGreater()!=null){
			c.andaddTimeGreaterThan(this.getAddTimeGreater());
		}else if(this.getAddTimeLess()!=null){
			c.andaddTimeLessThan(this.getAddTimeLess());
		}
		if(this.getUpdateTimeEquals()!=null){
			c.andupdateTimeEqualTo(this.getUpdateTimeEquals());
		}else if(this.getUpdateTimeIsNull()!=null && this.getUpdateTimeIsNull()){
			c.andupdateTimeIsNull();
		}else if(this.getUpdateTimeIsNotNull()!=null && this.getUpdateTimeIsNotNull()){
			c.andupdateTimeIsNotNull();
		}else if(this.getUpdateTimeIn()!=null){
			c.andupdateTimeIn(java.util.Arrays.asList(this.getUpdateTimeIn()));
		}else if(this.getUpdateTimeStart()!=null && this.getUpdateTimeEnd()!=null){
			c.andupdateTimeBetween(this.getUpdateTimeStart(), this.getUpdateTimeEnd());
		}else if(this.getUpdateTimeGreater()!=null){
			c.andupdateTimeGreaterThan(this.getUpdateTimeGreater());
		}else if(this.getUpdateTimeLess()!=null){
			c.andupdateTimeLessThan(this.getUpdateTimeLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
