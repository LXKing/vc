package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.VcJobTriggerInfoCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class VcJobTriggerInfoQuery {
	
	private Long jobIdEquals;
	private Long[] jobIdIn;
	private Boolean jobIdIsNull;
	private Boolean jobIdIsNotNull;
	
	private Long jobIdStart;
	
	private Long jobIdEnd;
	
	private Long jobIdLess;
	
	private Long jobIdGreater;
	private String jobCodeLike;
	
	private String jobCodeEquals;
	private String[] jobCodeIn;
	private Boolean jobCodeIsNull;
	private Boolean jobCodeIsNotNull;
	
	private String jobCodeStart;
	
	private String jobCodeEnd;
	
	private String jobCodeLess;
	
	private String jobCodeGreater;
	private String jobNameLike;
	
	private String jobNameEquals;
	private String[] jobNameIn;
	private Boolean jobNameIsNull;
	private Boolean jobNameIsNotNull;
	
	private String jobNameStart;
	
	private String jobNameEnd;
	
	private String jobNameLess;
	
	private String jobNameGreater;
	private String jobParamLike;
	
	private String jobParamEquals;
	private String[] jobParamIn;
	private Boolean jobParamIsNull;
	private Boolean jobParamIsNotNull;
	
	private String jobParamStart;
	
	private String jobParamEnd;
	
	private String jobParamLess;
	
	private String jobParamGreater;
	private String jobDescLike;
	
	private String jobDescEquals;
	private String[] jobDescIn;
	private Boolean jobDescIsNull;
	private Boolean jobDescIsNotNull;
	
	private String jobDescStart;
	
	private String jobDescEnd;
	
	private String jobDescLess;
	
	private String jobDescGreater;
	private String sidx;
	private String sord;

	public VcJobTriggerInfoQuery setJobIdEquals(Long jobIdEquals){
		this.jobIdEquals = jobIdEquals;
		return this;
	}
	public Long getJobIdEquals(){
		return this.jobIdEquals;
	}
	public VcJobTriggerInfoQuery setJobIdIn(Long[] jobIdIn){
		this.jobIdIn = jobIdIn;
		return this;
	}
	public Long[] getJobIdIn(){
		return this.jobIdIn;
	}
	public VcJobTriggerInfoQuery setJobIdIsNull(Boolean jobIdIsNull){
		this.jobIdIsNull = jobIdIsNull;
		return this;
	}
	public Boolean getJobIdIsNull(){
		return this.jobIdIsNull;
	}
	public VcJobTriggerInfoQuery setJobIdIsNotNull(Boolean jobIdIsNotNull){
		this.jobIdIsNotNull = jobIdIsNotNull;
		return this;
	}
	public Boolean getJobIdIsNotNull(){
		return this.jobIdIsNotNull;
	}
	public VcJobTriggerInfoQuery setJobIdStart(Long jobIdStart){
		this.jobIdStart = jobIdStart;
		return this;
	}
	public Long getJobIdStart(){
		return this.jobIdStart;
	}
	public VcJobTriggerInfoQuery setJobIdEnd(Long jobIdEnd){
		this.jobIdEnd = jobIdEnd;
		return this;
	}
	public Long getJobIdEnd(){
		return this.jobIdEnd;
	}
	public VcJobTriggerInfoQuery setJobIdLess(Long jobIdLess){
		this.jobIdLess = jobIdLess;
		return this;
	}
	public Long getJobIdLess(){
		return this.jobIdLess;
	}
	public VcJobTriggerInfoQuery setJobIdGreater(Long jobIdGreater){
		this.jobIdGreater = jobIdGreater;
		return this;
	}
	public Long getJobIdGreater(){
		return this.jobIdGreater;
	}
	public VcJobTriggerInfoQuery setJobCodeLike(String jobCodeLike){
		this.jobCodeLike = jobCodeLike;
		return this;
	}
	public String getJobCodeLike(){
		return this.jobCodeLike;
	}
	public VcJobTriggerInfoQuery setJobCodeEquals(String jobCodeEquals){
		this.jobCodeEquals = jobCodeEquals;
		return this;
	}
	public String getJobCodeEquals(){
		return this.jobCodeEquals;
	}
	public VcJobTriggerInfoQuery setJobCodeIn(String[] jobCodeIn){
		this.jobCodeIn = jobCodeIn;
		return this;
	}
	public String[] getJobCodeIn(){
		return this.jobCodeIn;
	}
	public VcJobTriggerInfoQuery setJobCodeIsNull(Boolean jobCodeIsNull){
		this.jobCodeIsNull = jobCodeIsNull;
		return this;
	}
	public Boolean getJobCodeIsNull(){
		return this.jobCodeIsNull;
	}
	public VcJobTriggerInfoQuery setJobCodeIsNotNull(Boolean jobCodeIsNotNull){
		this.jobCodeIsNotNull = jobCodeIsNotNull;
		return this;
	}
	public Boolean getJobCodeIsNotNull(){
		return this.jobCodeIsNotNull;
	}
	public VcJobTriggerInfoQuery setJobCodeStart(String jobCodeStart){
		this.jobCodeStart = jobCodeStart;
		return this;
	}
	public String getJobCodeStart(){
		return this.jobCodeStart;
	}
	public VcJobTriggerInfoQuery setJobCodeEnd(String jobCodeEnd){
		this.jobCodeEnd = jobCodeEnd;
		return this;
	}
	public String getJobCodeEnd(){
		return this.jobCodeEnd;
	}
	public VcJobTriggerInfoQuery setJobCodeLess(String jobCodeLess){
		this.jobCodeLess = jobCodeLess;
		return this;
	}
	public String getJobCodeLess(){
		return this.jobCodeLess;
	}
	public VcJobTriggerInfoQuery setJobCodeGreater(String jobCodeGreater){
		this.jobCodeGreater = jobCodeGreater;
		return this;
	}
	public String getJobCodeGreater(){
		return this.jobCodeGreater;
	}
	public VcJobTriggerInfoQuery setJobNameLike(String jobNameLike){
		this.jobNameLike = jobNameLike;
		return this;
	}
	public String getJobNameLike(){
		return this.jobNameLike;
	}
	public VcJobTriggerInfoQuery setJobNameEquals(String jobNameEquals){
		this.jobNameEquals = jobNameEquals;
		return this;
	}
	public String getJobNameEquals(){
		return this.jobNameEquals;
	}
	public VcJobTriggerInfoQuery setJobNameIn(String[] jobNameIn){
		this.jobNameIn = jobNameIn;
		return this;
	}
	public String[] getJobNameIn(){
		return this.jobNameIn;
	}
	public VcJobTriggerInfoQuery setJobNameIsNull(Boolean jobNameIsNull){
		this.jobNameIsNull = jobNameIsNull;
		return this;
	}
	public Boolean getJobNameIsNull(){
		return this.jobNameIsNull;
	}
	public VcJobTriggerInfoQuery setJobNameIsNotNull(Boolean jobNameIsNotNull){
		this.jobNameIsNotNull = jobNameIsNotNull;
		return this;
	}
	public Boolean getJobNameIsNotNull(){
		return this.jobNameIsNotNull;
	}
	public VcJobTriggerInfoQuery setJobNameStart(String jobNameStart){
		this.jobNameStart = jobNameStart;
		return this;
	}
	public String getJobNameStart(){
		return this.jobNameStart;
	}
	public VcJobTriggerInfoQuery setJobNameEnd(String jobNameEnd){
		this.jobNameEnd = jobNameEnd;
		return this;
	}
	public String getJobNameEnd(){
		return this.jobNameEnd;
	}
	public VcJobTriggerInfoQuery setJobNameLess(String jobNameLess){
		this.jobNameLess = jobNameLess;
		return this;
	}
	public String getJobNameLess(){
		return this.jobNameLess;
	}
	public VcJobTriggerInfoQuery setJobNameGreater(String jobNameGreater){
		this.jobNameGreater = jobNameGreater;
		return this;
	}
	public String getJobNameGreater(){
		return this.jobNameGreater;
	}
	public VcJobTriggerInfoQuery setJobParamLike(String jobParamLike){
		this.jobParamLike = jobParamLike;
		return this;
	}
	public String getJobParamLike(){
		return this.jobParamLike;
	}
	public VcJobTriggerInfoQuery setJobParamEquals(String jobParamEquals){
		this.jobParamEquals = jobParamEquals;
		return this;
	}
	public String getJobParamEquals(){
		return this.jobParamEquals;
	}
	public VcJobTriggerInfoQuery setJobParamIn(String[] jobParamIn){
		this.jobParamIn = jobParamIn;
		return this;
	}
	public String[] getJobParamIn(){
		return this.jobParamIn;
	}
	public VcJobTriggerInfoQuery setJobParamIsNull(Boolean jobParamIsNull){
		this.jobParamIsNull = jobParamIsNull;
		return this;
	}
	public Boolean getJobParamIsNull(){
		return this.jobParamIsNull;
	}
	public VcJobTriggerInfoQuery setJobParamIsNotNull(Boolean jobParamIsNotNull){
		this.jobParamIsNotNull = jobParamIsNotNull;
		return this;
	}
	public Boolean getJobParamIsNotNull(){
		return this.jobParamIsNotNull;
	}
	public VcJobTriggerInfoQuery setJobParamStart(String jobParamStart){
		this.jobParamStart = jobParamStart;
		return this;
	}
	public String getJobParamStart(){
		return this.jobParamStart;
	}
	public VcJobTriggerInfoQuery setJobParamEnd(String jobParamEnd){
		this.jobParamEnd = jobParamEnd;
		return this;
	}
	public String getJobParamEnd(){
		return this.jobParamEnd;
	}
	public VcJobTriggerInfoQuery setJobParamLess(String jobParamLess){
		this.jobParamLess = jobParamLess;
		return this;
	}
	public String getJobParamLess(){
		return this.jobParamLess;
	}
	public VcJobTriggerInfoQuery setJobParamGreater(String jobParamGreater){
		this.jobParamGreater = jobParamGreater;
		return this;
	}
	public String getJobParamGreater(){
		return this.jobParamGreater;
	}
	public VcJobTriggerInfoQuery setJobDescLike(String jobDescLike){
		this.jobDescLike = jobDescLike;
		return this;
	}
	public String getJobDescLike(){
		return this.jobDescLike;
	}
	public VcJobTriggerInfoQuery setJobDescEquals(String jobDescEquals){
		this.jobDescEquals = jobDescEquals;
		return this;
	}
	public String getJobDescEquals(){
		return this.jobDescEquals;
	}
	public VcJobTriggerInfoQuery setJobDescIn(String[] jobDescIn){
		this.jobDescIn = jobDescIn;
		return this;
	}
	public String[] getJobDescIn(){
		return this.jobDescIn;
	}
	public VcJobTriggerInfoQuery setJobDescIsNull(Boolean jobDescIsNull){
		this.jobDescIsNull = jobDescIsNull;
		return this;
	}
	public Boolean getJobDescIsNull(){
		return this.jobDescIsNull;
	}
	public VcJobTriggerInfoQuery setJobDescIsNotNull(Boolean jobDescIsNotNull){
		this.jobDescIsNotNull = jobDescIsNotNull;
		return this;
	}
	public Boolean getJobDescIsNotNull(){
		return this.jobDescIsNotNull;
	}
	public VcJobTriggerInfoQuery setJobDescStart(String jobDescStart){
		this.jobDescStart = jobDescStart;
		return this;
	}
	public String getJobDescStart(){
		return this.jobDescStart;
	}
	public VcJobTriggerInfoQuery setJobDescEnd(String jobDescEnd){
		this.jobDescEnd = jobDescEnd;
		return this;
	}
	public String getJobDescEnd(){
		return this.jobDescEnd;
	}
	public VcJobTriggerInfoQuery setJobDescLess(String jobDescLess){
		this.jobDescLess = jobDescLess;
		return this;
	}
	public String getJobDescLess(){
		return this.jobDescLess;
	}
	public VcJobTriggerInfoQuery setJobDescGreater(String jobDescGreater){
		this.jobDescGreater = jobDescGreater;
		return this;
	}
	public String getJobDescGreater(){
		return this.jobDescGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("jobId")){
			return "job_id";
		}
		else if(this.sidx.equals("jobCode")){
			return "job_code";
		}
		else if(this.sidx.equals("jobName")){
			return "job_name";
		}
		else if(this.sidx.equals("jobParam")){
			return "job_param";
		}
		else if(this.sidx.equals("jobDesc")){
			return "job_desc";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public VcJobTriggerInfoCrieria getCrieria(){
		VcJobTriggerInfoCrieria q = new VcJobTriggerInfoCrieria();
		VcJobTriggerInfoCrieria.Criteria c = q.createCriteria();
		
		if(this.getJobIdEquals()!=null){
			c.andjobIdEqualTo(this.getJobIdEquals());
		}else if(this.getJobIdIsNull()!=null && this.getJobIdIsNull()){
			c.andjobIdIsNull();
		}else if(this.getJobIdIsNotNull()!=null && this.getJobIdIsNotNull()){
			c.andjobIdIsNotNull();
		}else if(this.getJobIdIn()!=null){
			c.andjobIdIn(java.util.Arrays.asList(this.getJobIdIn()));
		}else if(this.getJobIdStart()!=null && this.getJobIdEnd()!=null){
			c.andjobIdBetween(this.getJobIdStart(), this.getJobIdEnd());
		}else if(this.getJobIdGreater()!=null){
			c.andjobIdGreaterThan(this.getJobIdGreater());
		}else if(this.getJobIdLess()!=null){
			c.andjobIdLessThan(this.getJobIdLess());
		}
		if(this.getJobCodeEquals()!=null){
			c.andjobCodeEqualTo(this.getJobCodeEquals());
		}else if(this.getJobCodeIsNull()!=null && this.getJobCodeIsNull()){
			c.andjobCodeIsNull();
		}else if(this.getJobCodeIsNotNull()!=null && this.getJobCodeIsNotNull()){
			c.andjobCodeIsNotNull();
		}else if(this.getJobCodeLike()!=null){
			c.andjobCodeLike(this.getJobCodeLike());
		}else if(this.getJobCodeIn()!=null){
			c.andjobCodeIn(java.util.Arrays.asList(this.getJobCodeIn()));
		}else if(this.getJobCodeStart()!=null && this.getJobCodeEnd()!=null){
			c.andjobCodeBetween(this.getJobCodeStart(), this.getJobCodeEnd());
		}else if(this.getJobCodeGreater()!=null){
			c.andjobCodeGreaterThan(this.getJobCodeGreater());
		}else if(this.getJobCodeLess()!=null){
			c.andjobCodeLessThan(this.getJobCodeLess());
		}
		if(this.getJobNameEquals()!=null){
			c.andjobNameEqualTo(this.getJobNameEquals());
		}else if(this.getJobNameIsNull()!=null && this.getJobNameIsNull()){
			c.andjobNameIsNull();
		}else if(this.getJobNameIsNotNull()!=null && this.getJobNameIsNotNull()){
			c.andjobNameIsNotNull();
		}else if(this.getJobNameLike()!=null){
			c.andjobNameLike(this.getJobNameLike());
		}else if(this.getJobNameIn()!=null){
			c.andjobNameIn(java.util.Arrays.asList(this.getJobNameIn()));
		}else if(this.getJobNameStart()!=null && this.getJobNameEnd()!=null){
			c.andjobNameBetween(this.getJobNameStart(), this.getJobNameEnd());
		}else if(this.getJobNameGreater()!=null){
			c.andjobNameGreaterThan(this.getJobNameGreater());
		}else if(this.getJobNameLess()!=null){
			c.andjobNameLessThan(this.getJobNameLess());
		}
		if(this.getJobParamEquals()!=null){
			c.andjobParamEqualTo(this.getJobParamEquals());
		}else if(this.getJobParamIsNull()!=null && this.getJobParamIsNull()){
			c.andjobParamIsNull();
		}else if(this.getJobParamIsNotNull()!=null && this.getJobParamIsNotNull()){
			c.andjobParamIsNotNull();
		}else if(this.getJobParamLike()!=null){
			c.andjobParamLike(this.getJobParamLike());
		}else if(this.getJobParamIn()!=null){
			c.andjobParamIn(java.util.Arrays.asList(this.getJobParamIn()));
		}else if(this.getJobParamStart()!=null && this.getJobParamEnd()!=null){
			c.andjobParamBetween(this.getJobParamStart(), this.getJobParamEnd());
		}else if(this.getJobParamGreater()!=null){
			c.andjobParamGreaterThan(this.getJobParamGreater());
		}else if(this.getJobParamLess()!=null){
			c.andjobParamLessThan(this.getJobParamLess());
		}
		if(this.getJobDescEquals()!=null){
			c.andjobDescEqualTo(this.getJobDescEquals());
		}else if(this.getJobDescIsNull()!=null && this.getJobDescIsNull()){
			c.andjobDescIsNull();
		}else if(this.getJobDescIsNotNull()!=null && this.getJobDescIsNotNull()){
			c.andjobDescIsNotNull();
		}else if(this.getJobDescLike()!=null){
			c.andjobDescLike(this.getJobDescLike());
		}else if(this.getJobDescIn()!=null){
			c.andjobDescIn(java.util.Arrays.asList(this.getJobDescIn()));
		}else if(this.getJobDescStart()!=null && this.getJobDescEnd()!=null){
			c.andjobDescBetween(this.getJobDescStart(), this.getJobDescEnd());
		}else if(this.getJobDescGreater()!=null){
			c.andjobDescGreaterThan(this.getJobDescGreater());
		}else if(this.getJobDescLess()!=null){
			c.andjobDescLessThan(this.getJobDescLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
