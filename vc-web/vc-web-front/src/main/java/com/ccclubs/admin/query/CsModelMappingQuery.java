package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsModelMappingCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsModelMappingQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	
	private Integer userIdEquals;
	private Integer[] userIdIn;
	private Boolean userIdIsNull;
	private Boolean userIdIsNotNull;
	
	private Integer userIdStart;
	
	private Integer userIdEnd;
	
	private Integer userIdLess;
	
	private Integer userIdGreater;
	
	private Integer modelIdEquals;
	private Integer[] modelIdIn;
	private Boolean modelIdIsNull;
	private Boolean modelIdIsNotNull;
	
	private Integer modelIdStart;
	
	private Integer modelIdEnd;
	
	private Integer modelIdLess;
	
	private Integer modelIdGreater;
	private String remarkLike;
	
	private String remarkEquals;
	private String[] remarkIn;
	private Boolean remarkIsNull;
	private Boolean remarkIsNotNull;
	
	private String remarkStart;
	
	private String remarkEnd;
	
	private String remarkLess;
	
	private String remarkGreater;
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

	public CsModelMappingQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public CsModelMappingQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public CsModelMappingQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public CsModelMappingQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public CsModelMappingQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public CsModelMappingQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public CsModelMappingQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public CsModelMappingQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public CsModelMappingQuery setUserIdEquals(Integer userIdEquals){
		this.userIdEquals = userIdEquals;
		return this;
	}
	public Integer getUserIdEquals(){
		return this.userIdEquals;
	}
	public CsModelMappingQuery setUserIdIn(Integer[] userIdIn){
		this.userIdIn = userIdIn;
		return this;
	}
	public Integer[] getUserIdIn(){
		return this.userIdIn;
	}
	public CsModelMappingQuery setUserIdIsNull(Boolean userIdIsNull){
		this.userIdIsNull = userIdIsNull;
		return this;
	}
	public Boolean getUserIdIsNull(){
		return this.userIdIsNull;
	}
	public CsModelMappingQuery setUserIdIsNotNull(Boolean userIdIsNotNull){
		this.userIdIsNotNull = userIdIsNotNull;
		return this;
	}
	public Boolean getUserIdIsNotNull(){
		return this.userIdIsNotNull;
	}
	public CsModelMappingQuery setUserIdStart(Integer userIdStart){
		this.userIdStart = userIdStart;
		return this;
	}
	public Integer getUserIdStart(){
		return this.userIdStart;
	}
	public CsModelMappingQuery setUserIdEnd(Integer userIdEnd){
		this.userIdEnd = userIdEnd;
		return this;
	}
	public Integer getUserIdEnd(){
		return this.userIdEnd;
	}
	public CsModelMappingQuery setUserIdLess(Integer userIdLess){
		this.userIdLess = userIdLess;
		return this;
	}
	public Integer getUserIdLess(){
		return this.userIdLess;
	}
	public CsModelMappingQuery setUserIdGreater(Integer userIdGreater){
		this.userIdGreater = userIdGreater;
		return this;
	}
	public Integer getUserIdGreater(){
		return this.userIdGreater;
	}
	public CsModelMappingQuery setModelIdEquals(Integer modelIdEquals){
		this.modelIdEquals = modelIdEquals;
		return this;
	}
	public Integer getModelIdEquals(){
		return this.modelIdEquals;
	}
	public CsModelMappingQuery setModelIdIn(Integer[] modelIdIn){
		this.modelIdIn = modelIdIn;
		return this;
	}
	public Integer[] getModelIdIn(){
		return this.modelIdIn;
	}
	public CsModelMappingQuery setModelIdIsNull(Boolean modelIdIsNull){
		this.modelIdIsNull = modelIdIsNull;
		return this;
	}
	public Boolean getModelIdIsNull(){
		return this.modelIdIsNull;
	}
	public CsModelMappingQuery setModelIdIsNotNull(Boolean modelIdIsNotNull){
		this.modelIdIsNotNull = modelIdIsNotNull;
		return this;
	}
	public Boolean getModelIdIsNotNull(){
		return this.modelIdIsNotNull;
	}
	public CsModelMappingQuery setModelIdStart(Integer modelIdStart){
		this.modelIdStart = modelIdStart;
		return this;
	}
	public Integer getModelIdStart(){
		return this.modelIdStart;
	}
	public CsModelMappingQuery setModelIdEnd(Integer modelIdEnd){
		this.modelIdEnd = modelIdEnd;
		return this;
	}
	public Integer getModelIdEnd(){
		return this.modelIdEnd;
	}
	public CsModelMappingQuery setModelIdLess(Integer modelIdLess){
		this.modelIdLess = modelIdLess;
		return this;
	}
	public Integer getModelIdLess(){
		return this.modelIdLess;
	}
	public CsModelMappingQuery setModelIdGreater(Integer modelIdGreater){
		this.modelIdGreater = modelIdGreater;
		return this;
	}
	public Integer getModelIdGreater(){
		return this.modelIdGreater;
	}
	public CsModelMappingQuery setremarkLike(String remarkLike){
		this.remarkLike = remarkLike;
		return this;
	}
	public String getremarkLike(){
		return this.remarkLike;
	}
	public CsModelMappingQuery setremarkEquals(String remarkEquals){
		this.remarkEquals = remarkEquals;
		return this;
	}
	public String getremarkEquals(){
		return this.remarkEquals;
	}
	public CsModelMappingQuery setremarkIn(String[] remarkIn){
		this.remarkIn = remarkIn;
		return this;
	}
	public String[] getremarkIn(){
		return this.remarkIn;
	}
	public CsModelMappingQuery setremarkIsNull(Boolean remarkIsNull){
		this.remarkIsNull = remarkIsNull;
		return this;
	}
	public Boolean getremarkIsNull(){
		return this.remarkIsNull;
	}
	public CsModelMappingQuery setremarkIsNotNull(Boolean remarkIsNotNull){
		this.remarkIsNotNull = remarkIsNotNull;
		return this;
	}
	public Boolean getremarkIsNotNull(){
		return this.remarkIsNotNull;
	}
	public CsModelMappingQuery setremarkStart(String remarkStart){
		this.remarkStart = remarkStart;
		return this;
	}
	public String getremarkStart(){
		return this.remarkStart;
	}
	public CsModelMappingQuery setremarkEnd(String remarkEnd){
		this.remarkEnd = remarkEnd;
		return this;
	}
	public String getremarkEnd(){
		return this.remarkEnd;
	}
	public CsModelMappingQuery setremarkLess(String remarkLess){
		this.remarkLess = remarkLess;
		return this;
	}
	public String getremarkLess(){
		return this.remarkLess;
	}
	public CsModelMappingQuery setremarkGreater(String remarkGreater){
		this.remarkGreater = remarkGreater;
		return this;
	}
	public String getremarkGreater(){
		return this.remarkGreater;
	}
	public CsModelMappingQuery setAddTimeEquals(Date addTimeEquals){
		this.addTimeEquals = addTimeEquals;
		return this;
	}
	public Date getAddTimeEquals(){
		return this.addTimeEquals;
	}
	public CsModelMappingQuery setAddTimeIn(Date[] addTimeIn){
		this.addTimeIn = addTimeIn;
		return this;
	}
	public Date[] getAddTimeIn(){
		return this.addTimeIn;
	}
	public CsModelMappingQuery setAddTimeIsNull(Boolean addTimeIsNull){
		this.addTimeIsNull = addTimeIsNull;
		return this;
	}
	public Boolean getAddTimeIsNull(){
		return this.addTimeIsNull;
	}
	public CsModelMappingQuery setAddTimeIsNotNull(Boolean addTimeIsNotNull){
		this.addTimeIsNotNull = addTimeIsNotNull;
		return this;
	}
	public Boolean getAddTimeIsNotNull(){
		return this.addTimeIsNotNull;
	}
	public CsModelMappingQuery setAddTimeStart(Date addTimeStart){
		this.addTimeStart = addTimeStart;
		return this;
	}
	public Date getAddTimeStart(){
		return this.addTimeStart;
	}
	public CsModelMappingQuery setAddTimeEnd(Date addTimeEnd){
		this.addTimeEnd = addTimeEnd;
		return this;
	}
	public Date getAddTimeEnd(){
		return this.addTimeEnd;
	}
	public CsModelMappingQuery setAddTimeLess(Date addTimeLess){
		this.addTimeLess = addTimeLess;
		return this;
	}
	public Date getAddTimeLess(){
		return this.addTimeLess;
	}
	public CsModelMappingQuery setAddTimeGreater(Date addTimeGreater){
		this.addTimeGreater = addTimeGreater;
		return this;
	}
	public Date getAddTimeGreater(){
		return this.addTimeGreater;
	}
	public CsModelMappingQuery setUpdateTimeEquals(Date updateTimeEquals){
		this.updateTimeEquals = updateTimeEquals;
		return this;
	}
	public Date getUpdateTimeEquals(){
		return this.updateTimeEquals;
	}
	public CsModelMappingQuery setUpdateTimeIn(Date[] updateTimeIn){
		this.updateTimeIn = updateTimeIn;
		return this;
	}
	public Date[] getUpdateTimeIn(){
		return this.updateTimeIn;
	}
	public CsModelMappingQuery setUpdateTimeIsNull(Boolean updateTimeIsNull){
		this.updateTimeIsNull = updateTimeIsNull;
		return this;
	}
	public Boolean getUpdateTimeIsNull(){
		return this.updateTimeIsNull;
	}
	public CsModelMappingQuery setUpdateTimeIsNotNull(Boolean updateTimeIsNotNull){
		this.updateTimeIsNotNull = updateTimeIsNotNull;
		return this;
	}
	public Boolean getUpdateTimeIsNotNull(){
		return this.updateTimeIsNotNull;
	}
	public CsModelMappingQuery setUpdateTimeStart(Date updateTimeStart){
		this.updateTimeStart = updateTimeStart;
		return this;
	}
	public Date getUpdateTimeStart(){
		return this.updateTimeStart;
	}
	public CsModelMappingQuery setUpdateTimeEnd(Date updateTimeEnd){
		this.updateTimeEnd = updateTimeEnd;
		return this;
	}
	public Date getUpdateTimeEnd(){
		return this.updateTimeEnd;
	}
	public CsModelMappingQuery setUpdateTimeLess(Date updateTimeLess){
		this.updateTimeLess = updateTimeLess;
		return this;
	}
	public Date getUpdateTimeLess(){
		return this.updateTimeLess;
	}
	public CsModelMappingQuery setUpdateTimeGreater(Date updateTimeGreater){
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
		else if(this.sidx.equals("userId")){
			return "user_id";
		}
		else if(this.sidx.equals("modelId")){
			return "model_id";
		}
		else if(this.sidx.equals("remark")){
			return "remark";
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
	
	public CsModelMappingCrieria getCrieria(){
		CsModelMappingCrieria q = new CsModelMappingCrieria();
		CsModelMappingCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getUserIdEquals()!=null){
			c.anduserIdEqualTo(this.getUserIdEquals());
		}else if(this.getUserIdIsNull()!=null && this.getUserIdIsNull()){
			c.anduserIdIsNull();
		}else if(this.getUserIdIsNotNull()!=null && this.getUserIdIsNotNull()){
			c.anduserIdIsNotNull();
		}else if(this.getUserIdIn()!=null){
			c.anduserIdIn(java.util.Arrays.asList(this.getUserIdIn()));
		}else if(this.getUserIdStart()!=null && this.getUserIdEnd()!=null){
			c.anduserIdBetween(this.getUserIdStart(), this.getUserIdEnd());
		}else if(this.getUserIdGreater()!=null){
			c.anduserIdGreaterThan(this.getUserIdGreater());
		}else if(this.getUserIdLess()!=null){
			c.anduserIdLessThan(this.getUserIdLess());
		}
		if(this.getModelIdEquals()!=null){
			c.andmodelIdEqualTo(this.getModelIdEquals());
		}else if(this.getModelIdIsNull()!=null && this.getModelIdIsNull()){
			c.andmodelIdIsNull();
		}else if(this.getModelIdIsNotNull()!=null && this.getModelIdIsNotNull()){
			c.andmodelIdIsNotNull();
		}else if(this.getModelIdIn()!=null){
			c.andmodelIdIn(java.util.Arrays.asList(this.getModelIdIn()));
		}else if(this.getModelIdStart()!=null && this.getModelIdEnd()!=null){
			c.andmodelIdBetween(this.getModelIdStart(), this.getModelIdEnd());
		}else if(this.getModelIdGreater()!=null){
			c.andmodelIdGreaterThan(this.getModelIdGreater());
		}else if(this.getModelIdLess()!=null){
			c.andmodelIdLessThan(this.getModelIdLess());
		}
		if(this.getremarkEquals()!=null){
			c.andremarkEqualTo(this.getremarkEquals());
		}else if(this.getremarkIsNull()!=null && this.getremarkIsNull()){
			c.andremarkIsNull();
		}else if(this.getremarkIsNotNull()!=null && this.getremarkIsNotNull()){
			c.andremarkIsNotNull();
		}else if(this.getremarkLike()!=null){
			c.andremarkLike(this.getremarkLike());
		}else if(this.getremarkIn()!=null){
			c.andremarkIn(java.util.Arrays.asList(this.getremarkIn()));
		}else if(this.getremarkStart()!=null && this.getremarkEnd()!=null){
			c.andremarkBetween(this.getremarkStart(), this.getremarkEnd());
		}else if(this.getremarkGreater()!=null){
			c.andremarkGreaterThan(this.getremarkGreater());
		}else if(this.getremarkLess()!=null){
			c.andremarkLessThan(this.getremarkLess());
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
