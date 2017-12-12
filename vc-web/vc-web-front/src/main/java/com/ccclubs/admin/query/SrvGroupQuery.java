package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.SrvGroupCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SrvGroupQuery {
	
	private Integer sgIdEquals;
	private Integer[] sgIdIn;
	private Boolean sgIdIsNull;
	private Boolean sgIdIsNotNull;
	
	private Integer sgIdStart;
	
	private Integer sgIdEnd;
	
	private Integer sgIdLess;
	
	private Integer sgIdGreater;
	private String sgNameLike;
	
	private String sgNameEquals;
	private String[] sgNameIn;
	private Boolean sgNameIsNull;
	private Boolean sgNameIsNotNull;
	
	private String sgNameStart;
	
	private String sgNameEnd;
	
	private String sgNameLess;
	
	private String sgNameGreater;
	
	private Long sgParentEquals;
	private Long[] sgParentIn;
	private Boolean sgParentIsNull;
	private Boolean sgParentIsNotNull;
	
	private Long sgParentStart;
	
	private Long sgParentEnd;
	
	private Long sgParentLess;
	
	private Long sgParentGreater;
	private String sgFamilyLike;
	
	private String sgFamilyEquals;
	private String[] sgFamilyIn;
	private Boolean sgFamilyIsNull;
	private Boolean sgFamilyIsNotNull;
	
	private String sgFamilyStart;
	
	private String sgFamilyEnd;
	
	private String sgFamilyLess;
	
	private String sgFamilyGreater;
	
	private Long sgUserEquals;
	private Long[] sgUserIn;
	private Boolean sgUserIsNull;
	private Boolean sgUserIsNotNull;
	
	private Long sgUserStart;
	
	private Long sgUserEnd;
	
	private Long sgUserLess;
	
	private Long sgUserGreater;
	private String sgFlagLike;
	
	private String sgFlagEquals;
	private String[] sgFlagIn;
	private Boolean sgFlagIsNull;
	private Boolean sgFlagIsNotNull;
	
	private String sgFlagStart;
	
	private String sgFlagEnd;
	
	private String sgFlagLess;
	
	private String sgFlagGreater;
	
	private Short sgStatusEquals;
	private Short[] sgStatusIn;
	private Boolean sgStatusIsNull;
	private Boolean sgStatusIsNotNull;
	
	private Short sgStatusStart;
	
	private Short sgStatusEnd;
	
	private Short sgStatusLess;
	
	private Short sgStatusGreater;
	private String sidx;
	private String sord;

	public SrvGroupQuery setSgIdEquals(Integer sgIdEquals){
		this.sgIdEquals = sgIdEquals;
		return this;
	}
	public Integer getSgIdEquals(){
		return this.sgIdEquals;
	}
	public SrvGroupQuery setSgIdIn(Integer[] sgIdIn){
		this.sgIdIn = sgIdIn;
		return this;
	}
	public Integer[] getSgIdIn(){
		return this.sgIdIn;
	}
	public SrvGroupQuery setSgIdIsNull(Boolean sgIdIsNull){
		this.sgIdIsNull = sgIdIsNull;
		return this;
	}
	public Boolean getSgIdIsNull(){
		return this.sgIdIsNull;
	}
	public SrvGroupQuery setSgIdIsNotNull(Boolean sgIdIsNotNull){
		this.sgIdIsNotNull = sgIdIsNotNull;
		return this;
	}
	public Boolean getSgIdIsNotNull(){
		return this.sgIdIsNotNull;
	}
	public SrvGroupQuery setSgIdStart(Integer sgIdStart){
		this.sgIdStart = sgIdStart;
		return this;
	}
	public Integer getSgIdStart(){
		return this.sgIdStart;
	}
	public SrvGroupQuery setSgIdEnd(Integer sgIdEnd){
		this.sgIdEnd = sgIdEnd;
		return this;
	}
	public Integer getSgIdEnd(){
		return this.sgIdEnd;
	}
	public SrvGroupQuery setSgIdLess(Integer sgIdLess){
		this.sgIdLess = sgIdLess;
		return this;
	}
	public Integer getSgIdLess(){
		return this.sgIdLess;
	}
	public SrvGroupQuery setSgIdGreater(Integer sgIdGreater){
		this.sgIdGreater = sgIdGreater;
		return this;
	}
	public Integer getSgIdGreater(){
		return this.sgIdGreater;
	}
	public SrvGroupQuery setSgNameLike(String sgNameLike){
		this.sgNameLike = sgNameLike;
		return this;
	}
	public String getSgNameLike(){
		return this.sgNameLike;
	}
	public SrvGroupQuery setSgNameEquals(String sgNameEquals){
		this.sgNameEquals = sgNameEquals;
		return this;
	}
	public String getSgNameEquals(){
		return this.sgNameEquals;
	}
	public SrvGroupQuery setSgNameIn(String[] sgNameIn){
		this.sgNameIn = sgNameIn;
		return this;
	}
	public String[] getSgNameIn(){
		return this.sgNameIn;
	}
	public SrvGroupQuery setSgNameIsNull(Boolean sgNameIsNull){
		this.sgNameIsNull = sgNameIsNull;
		return this;
	}
	public Boolean getSgNameIsNull(){
		return this.sgNameIsNull;
	}
	public SrvGroupQuery setSgNameIsNotNull(Boolean sgNameIsNotNull){
		this.sgNameIsNotNull = sgNameIsNotNull;
		return this;
	}
	public Boolean getSgNameIsNotNull(){
		return this.sgNameIsNotNull;
	}
	public SrvGroupQuery setSgNameStart(String sgNameStart){
		this.sgNameStart = sgNameStart;
		return this;
	}
	public String getSgNameStart(){
		return this.sgNameStart;
	}
	public SrvGroupQuery setSgNameEnd(String sgNameEnd){
		this.sgNameEnd = sgNameEnd;
		return this;
	}
	public String getSgNameEnd(){
		return this.sgNameEnd;
	}
	public SrvGroupQuery setSgNameLess(String sgNameLess){
		this.sgNameLess = sgNameLess;
		return this;
	}
	public String getSgNameLess(){
		return this.sgNameLess;
	}
	public SrvGroupQuery setSgNameGreater(String sgNameGreater){
		this.sgNameGreater = sgNameGreater;
		return this;
	}
	public String getSgNameGreater(){
		return this.sgNameGreater;
	}
	public SrvGroupQuery setSgParentEquals(Long sgParentEquals){
		this.sgParentEquals = sgParentEquals;
		return this;
	}
	public Long getSgParentEquals(){
		return this.sgParentEquals;
	}
	public SrvGroupQuery setSgParentIn(Long[] sgParentIn){
		this.sgParentIn = sgParentIn;
		return this;
	}
	public Long[] getSgParentIn(){
		return this.sgParentIn;
	}
	public SrvGroupQuery setSgParentIsNull(Boolean sgParentIsNull){
		this.sgParentIsNull = sgParentIsNull;
		return this;
	}
	public Boolean getSgParentIsNull(){
		return this.sgParentIsNull;
	}
	public SrvGroupQuery setSgParentIsNotNull(Boolean sgParentIsNotNull){
		this.sgParentIsNotNull = sgParentIsNotNull;
		return this;
	}
	public Boolean getSgParentIsNotNull(){
		return this.sgParentIsNotNull;
	}
	public SrvGroupQuery setSgParentStart(Long sgParentStart){
		this.sgParentStart = sgParentStart;
		return this;
	}
	public Long getSgParentStart(){
		return this.sgParentStart;
	}
	public SrvGroupQuery setSgParentEnd(Long sgParentEnd){
		this.sgParentEnd = sgParentEnd;
		return this;
	}
	public Long getSgParentEnd(){
		return this.sgParentEnd;
	}
	public SrvGroupQuery setSgParentLess(Long sgParentLess){
		this.sgParentLess = sgParentLess;
		return this;
	}
	public Long getSgParentLess(){
		return this.sgParentLess;
	}
	public SrvGroupQuery setSgParentGreater(Long sgParentGreater){
		this.sgParentGreater = sgParentGreater;
		return this;
	}
	public Long getSgParentGreater(){
		return this.sgParentGreater;
	}
	public SrvGroupQuery setSgFamilyLike(String sgFamilyLike){
		this.sgFamilyLike = sgFamilyLike;
		return this;
	}
	public String getSgFamilyLike(){
		return this.sgFamilyLike;
	}
	public SrvGroupQuery setSgFamilyEquals(String sgFamilyEquals){
		this.sgFamilyEquals = sgFamilyEquals;
		return this;
	}
	public String getSgFamilyEquals(){
		return this.sgFamilyEquals;
	}
	public SrvGroupQuery setSgFamilyIn(String[] sgFamilyIn){
		this.sgFamilyIn = sgFamilyIn;
		return this;
	}
	public String[] getSgFamilyIn(){
		return this.sgFamilyIn;
	}
	public SrvGroupQuery setSgFamilyIsNull(Boolean sgFamilyIsNull){
		this.sgFamilyIsNull = sgFamilyIsNull;
		return this;
	}
	public Boolean getSgFamilyIsNull(){
		return this.sgFamilyIsNull;
	}
	public SrvGroupQuery setSgFamilyIsNotNull(Boolean sgFamilyIsNotNull){
		this.sgFamilyIsNotNull = sgFamilyIsNotNull;
		return this;
	}
	public Boolean getSgFamilyIsNotNull(){
		return this.sgFamilyIsNotNull;
	}
	public SrvGroupQuery setSgFamilyStart(String sgFamilyStart){
		this.sgFamilyStart = sgFamilyStart;
		return this;
	}
	public String getSgFamilyStart(){
		return this.sgFamilyStart;
	}
	public SrvGroupQuery setSgFamilyEnd(String sgFamilyEnd){
		this.sgFamilyEnd = sgFamilyEnd;
		return this;
	}
	public String getSgFamilyEnd(){
		return this.sgFamilyEnd;
	}
	public SrvGroupQuery setSgFamilyLess(String sgFamilyLess){
		this.sgFamilyLess = sgFamilyLess;
		return this;
	}
	public String getSgFamilyLess(){
		return this.sgFamilyLess;
	}
	public SrvGroupQuery setSgFamilyGreater(String sgFamilyGreater){
		this.sgFamilyGreater = sgFamilyGreater;
		return this;
	}
	public String getSgFamilyGreater(){
		return this.sgFamilyGreater;
	}
	public SrvGroupQuery setSgUserEquals(Long sgUserEquals){
		this.sgUserEquals = sgUserEquals;
		return this;
	}
	public Long getSgUserEquals(){
		return this.sgUserEquals;
	}
	public SrvGroupQuery setSgUserIn(Long[] sgUserIn){
		this.sgUserIn = sgUserIn;
		return this;
	}
	public Long[] getSgUserIn(){
		return this.sgUserIn;
	}
	public SrvGroupQuery setSgUserIsNull(Boolean sgUserIsNull){
		this.sgUserIsNull = sgUserIsNull;
		return this;
	}
	public Boolean getSgUserIsNull(){
		return this.sgUserIsNull;
	}
	public SrvGroupQuery setSgUserIsNotNull(Boolean sgUserIsNotNull){
		this.sgUserIsNotNull = sgUserIsNotNull;
		return this;
	}
	public Boolean getSgUserIsNotNull(){
		return this.sgUserIsNotNull;
	}
	public SrvGroupQuery setSgUserStart(Long sgUserStart){
		this.sgUserStart = sgUserStart;
		return this;
	}
	public Long getSgUserStart(){
		return this.sgUserStart;
	}
	public SrvGroupQuery setSgUserEnd(Long sgUserEnd){
		this.sgUserEnd = sgUserEnd;
		return this;
	}
	public Long getSgUserEnd(){
		return this.sgUserEnd;
	}
	public SrvGroupQuery setSgUserLess(Long sgUserLess){
		this.sgUserLess = sgUserLess;
		return this;
	}
	public Long getSgUserLess(){
		return this.sgUserLess;
	}
	public SrvGroupQuery setSgUserGreater(Long sgUserGreater){
		this.sgUserGreater = sgUserGreater;
		return this;
	}
	public Long getSgUserGreater(){
		return this.sgUserGreater;
	}
	public SrvGroupQuery setSgFlagLike(String sgFlagLike){
		this.sgFlagLike = sgFlagLike;
		return this;
	}
	public String getSgFlagLike(){
		return this.sgFlagLike;
	}
	public SrvGroupQuery setSgFlagEquals(String sgFlagEquals){
		this.sgFlagEquals = sgFlagEquals;
		return this;
	}
	public String getSgFlagEquals(){
		return this.sgFlagEquals;
	}
	public SrvGroupQuery setSgFlagIn(String[] sgFlagIn){
		this.sgFlagIn = sgFlagIn;
		return this;
	}
	public String[] getSgFlagIn(){
		return this.sgFlagIn;
	}
	public SrvGroupQuery setSgFlagIsNull(Boolean sgFlagIsNull){
		this.sgFlagIsNull = sgFlagIsNull;
		return this;
	}
	public Boolean getSgFlagIsNull(){
		return this.sgFlagIsNull;
	}
	public SrvGroupQuery setSgFlagIsNotNull(Boolean sgFlagIsNotNull){
		this.sgFlagIsNotNull = sgFlagIsNotNull;
		return this;
	}
	public Boolean getSgFlagIsNotNull(){
		return this.sgFlagIsNotNull;
	}
	public SrvGroupQuery setSgFlagStart(String sgFlagStart){
		this.sgFlagStart = sgFlagStart;
		return this;
	}
	public String getSgFlagStart(){
		return this.sgFlagStart;
	}
	public SrvGroupQuery setSgFlagEnd(String sgFlagEnd){
		this.sgFlagEnd = sgFlagEnd;
		return this;
	}
	public String getSgFlagEnd(){
		return this.sgFlagEnd;
	}
	public SrvGroupQuery setSgFlagLess(String sgFlagLess){
		this.sgFlagLess = sgFlagLess;
		return this;
	}
	public String getSgFlagLess(){
		return this.sgFlagLess;
	}
	public SrvGroupQuery setSgFlagGreater(String sgFlagGreater){
		this.sgFlagGreater = sgFlagGreater;
		return this;
	}
	public String getSgFlagGreater(){
		return this.sgFlagGreater;
	}
	public SrvGroupQuery setSgStatusEquals(Short sgStatusEquals){
		this.sgStatusEquals = sgStatusEquals;
		return this;
	}
	public Short getSgStatusEquals(){
		return this.sgStatusEquals;
	}
	public SrvGroupQuery setSgStatusIn(Short[] sgStatusIn){
		this.sgStatusIn = sgStatusIn;
		return this;
	}
	public Short[] getSgStatusIn(){
		return this.sgStatusIn;
	}
	public SrvGroupQuery setSgStatusIsNull(Boolean sgStatusIsNull){
		this.sgStatusIsNull = sgStatusIsNull;
		return this;
	}
	public Boolean getSgStatusIsNull(){
		return this.sgStatusIsNull;
	}
	public SrvGroupQuery setSgStatusIsNotNull(Boolean sgStatusIsNotNull){
		this.sgStatusIsNotNull = sgStatusIsNotNull;
		return this;
	}
	public Boolean getSgStatusIsNotNull(){
		return this.sgStatusIsNotNull;
	}
	public SrvGroupQuery setSgStatusStart(Short sgStatusStart){
		this.sgStatusStart = sgStatusStart;
		return this;
	}
	public Short getSgStatusStart(){
		return this.sgStatusStart;
	}
	public SrvGroupQuery setSgStatusEnd(Short sgStatusEnd){
		this.sgStatusEnd = sgStatusEnd;
		return this;
	}
	public Short getSgStatusEnd(){
		return this.sgStatusEnd;
	}
	public SrvGroupQuery setSgStatusLess(Short sgStatusLess){
		this.sgStatusLess = sgStatusLess;
		return this;
	}
	public Short getSgStatusLess(){
		return this.sgStatusLess;
	}
	public SrvGroupQuery setSgStatusGreater(Short sgStatusGreater){
		this.sgStatusGreater = sgStatusGreater;
		return this;
	}
	public Short getSgStatusGreater(){
		return this.sgStatusGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("sgId")){
			return "sg_id";
		}
		else if(this.sidx.equals("sgName")){
			return "sg_name";
		}
		else if(this.sidx.equals("sgParent")){
			return "sg_parent";
		}
		else if(this.sidx.equals("sgFamily")){
			return "sg_family";
		}
		else if(this.sidx.equals("sgUser")){
			return "sg_user";
		}
		else if(this.sidx.equals("sgFlag")){
			return "sg_flag";
		}
		else if(this.sidx.equals("sgStatus")){
			return "sg_status";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public SrvGroupCrieria getCrieria(){
		SrvGroupCrieria q = new SrvGroupCrieria();
		SrvGroupCrieria.Criteria c = q.createCriteria();
		
		if(this.getSgIdEquals()!=null){
			c.andsgIdEqualTo(this.getSgIdEquals());
		}else if(this.getSgIdIsNull()!=null && this.getSgIdIsNull()){
			c.andsgIdIsNull();
		}else if(this.getSgIdIsNotNull()!=null && this.getSgIdIsNotNull()){
			c.andsgIdIsNotNull();
		}else if(this.getSgIdIn()!=null){
			c.andsgIdIn(java.util.Arrays.asList(this.getSgIdIn()));
		}else if(this.getSgIdStart()!=null && this.getSgIdEnd()!=null){
			c.andsgIdBetween(this.getSgIdStart(), this.getSgIdEnd());
		}else if(this.getSgIdGreater()!=null){
			c.andsgIdGreaterThan(this.getSgIdGreater());
		}else if(this.getSgIdLess()!=null){
			c.andsgIdLessThan(this.getSgIdLess());
		}
		if(this.getSgNameEquals()!=null){
			c.andsgNameEqualTo(this.getSgNameEquals());
		}else if(this.getSgNameIsNull()!=null && this.getSgNameIsNull()){
			c.andsgNameIsNull();
		}else if(this.getSgNameIsNotNull()!=null && this.getSgNameIsNotNull()){
			c.andsgNameIsNotNull();
		}else if(this.getSgNameLike()!=null){
			c.andsgNameLike(this.getSgNameLike());
		}else if(this.getSgNameIn()!=null){
			c.andsgNameIn(java.util.Arrays.asList(this.getSgNameIn()));
		}else if(this.getSgNameStart()!=null && this.getSgNameEnd()!=null){
			c.andsgNameBetween(this.getSgNameStart(), this.getSgNameEnd());
		}else if(this.getSgNameGreater()!=null){
			c.andsgNameGreaterThan(this.getSgNameGreater());
		}else if(this.getSgNameLess()!=null){
			c.andsgNameLessThan(this.getSgNameLess());
		}
		if(this.getSgParentEquals()!=null){
			c.andsgParentEqualTo(this.getSgParentEquals());
		}else if(this.getSgParentIsNull()!=null && this.getSgParentIsNull()){
			c.andsgParentIsNull();
		}else if(this.getSgParentIsNotNull()!=null && this.getSgParentIsNotNull()){
			c.andsgParentIsNotNull();
		}else if(this.getSgParentIn()!=null){
			c.andsgParentIn(java.util.Arrays.asList(this.getSgParentIn()));
		}else if(this.getSgParentStart()!=null && this.getSgParentEnd()!=null){
			c.andsgParentBetween(this.getSgParentStart(), this.getSgParentEnd());
		}else if(this.getSgParentGreater()!=null){
			c.andsgParentGreaterThan(this.getSgParentGreater());
		}else if(this.getSgParentLess()!=null){
			c.andsgParentLessThan(this.getSgParentLess());
		}
		if(this.getSgFamilyEquals()!=null){
			c.andsgFamilyEqualTo(this.getSgFamilyEquals());
		}else if(this.getSgFamilyIsNull()!=null && this.getSgFamilyIsNull()){
			c.andsgFamilyIsNull();
		}else if(this.getSgFamilyIsNotNull()!=null && this.getSgFamilyIsNotNull()){
			c.andsgFamilyIsNotNull();
		}else if(this.getSgFamilyLike()!=null){
			c.andsgFamilyLike(this.getSgFamilyLike());
		}else if(this.getSgFamilyIn()!=null){
			c.andsgFamilyIn(java.util.Arrays.asList(this.getSgFamilyIn()));
		}else if(this.getSgFamilyStart()!=null && this.getSgFamilyEnd()!=null){
			c.andsgFamilyBetween(this.getSgFamilyStart(), this.getSgFamilyEnd());
		}else if(this.getSgFamilyGreater()!=null){
			c.andsgFamilyGreaterThan(this.getSgFamilyGreater());
		}else if(this.getSgFamilyLess()!=null){
			c.andsgFamilyLessThan(this.getSgFamilyLess());
		}
		if(this.getSgUserEquals()!=null){
			c.andsgUserEqualTo(this.getSgUserEquals());
		}else if(this.getSgUserIsNull()!=null && this.getSgUserIsNull()){
			c.andsgUserIsNull();
		}else if(this.getSgUserIsNotNull()!=null && this.getSgUserIsNotNull()){
			c.andsgUserIsNotNull();
		}else if(this.getSgUserIn()!=null){
			c.andsgUserIn(java.util.Arrays.asList(this.getSgUserIn()));
		}else if(this.getSgUserStart()!=null && this.getSgUserEnd()!=null){
			c.andsgUserBetween(this.getSgUserStart(), this.getSgUserEnd());
		}else if(this.getSgUserGreater()!=null){
			c.andsgUserGreaterThan(this.getSgUserGreater());
		}else if(this.getSgUserLess()!=null){
			c.andsgUserLessThan(this.getSgUserLess());
		}
		if(this.getSgFlagEquals()!=null){
			c.andsgFlagEqualTo(this.getSgFlagEquals());
		}else if(this.getSgFlagIsNull()!=null && this.getSgFlagIsNull()){
			c.andsgFlagIsNull();
		}else if(this.getSgFlagIsNotNull()!=null && this.getSgFlagIsNotNull()){
			c.andsgFlagIsNotNull();
		}else if(this.getSgFlagLike()!=null){
			c.andsgFlagLike(this.getSgFlagLike());
		}else if(this.getSgFlagIn()!=null){
			c.andsgFlagIn(java.util.Arrays.asList(this.getSgFlagIn()));
		}else if(this.getSgFlagStart()!=null && this.getSgFlagEnd()!=null){
			c.andsgFlagBetween(this.getSgFlagStart(), this.getSgFlagEnd());
		}else if(this.getSgFlagGreater()!=null){
			c.andsgFlagGreaterThan(this.getSgFlagGreater());
		}else if(this.getSgFlagLess()!=null){
			c.andsgFlagLessThan(this.getSgFlagLess());
		}
		if(this.getSgStatusEquals()!=null){
			c.andsgStatusEqualTo(this.getSgStatusEquals());
		}else if(this.getSgStatusIsNull()!=null && this.getSgStatusIsNull()){
			c.andsgStatusIsNull();
		}else if(this.getSgStatusIsNotNull()!=null && this.getSgStatusIsNotNull()){
			c.andsgStatusIsNotNull();
		}else if(this.getSgStatusIn()!=null){
			c.andsgStatusIn(java.util.Arrays.asList(this.getSgStatusIn()));
		}else if(this.getSgStatusStart()!=null && this.getSgStatusEnd()!=null){
			c.andsgStatusBetween(this.getSgStatusStart(), this.getSgStatusEnd());
		}else if(this.getSgStatusGreater()!=null){
			c.andsgStatusGreaterThan(this.getSgStatusGreater());
		}else if(this.getSgStatusLess()!=null){
			c.andsgStatusLessThan(this.getSgStatusLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
