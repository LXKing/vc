package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsMappingCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsMappingQuery {
	
	private Integer csmIdEquals;
	private Integer[] csmIdIn;
	private Boolean csmIdIsNull;
	private Boolean csmIdIsNotNull;
	
	private Integer csmIdStart;
	
	private Integer csmIdEnd;
	
	private Integer csmIdLess;
	
	private Integer csmIdGreater;
	
	private Integer csmCarEquals;
	private Integer[] csmCarIn;
	private Boolean csmCarIsNull;
	private Boolean csmCarIsNotNull;
	
	private Integer csmCarStart;
	
	private Integer csmCarEnd;
	
	private Integer csmCarLess;
	
	private Integer csmCarGreater;
	
	private Integer csmManageEquals;
	private Integer[] csmManageIn;
	private Boolean csmManageIsNull;
	private Boolean csmManageIsNotNull;
	
	private Integer csmManageStart;
	
	private Integer csmManageEnd;
	
	private Integer csmManageLess;
	
	private Integer csmManageGreater;
	private String sidx;
	private String sord;

	public CsMappingQuery setCsmIdEquals(Integer csmIdEquals){
		this.csmIdEquals = csmIdEquals;
		return this;
	}
	public Integer getCsmIdEquals(){
		return this.csmIdEquals;
	}
	public CsMappingQuery setCsmIdIn(Integer[] csmIdIn){
		this.csmIdIn = csmIdIn;
		return this;
	}
	public Integer[] getCsmIdIn(){
		return this.csmIdIn;
	}
	public CsMappingQuery setCsmIdIsNull(Boolean csmIdIsNull){
		this.csmIdIsNull = csmIdIsNull;
		return this;
	}
	public Boolean getCsmIdIsNull(){
		return this.csmIdIsNull;
	}
	public CsMappingQuery setCsmIdIsNotNull(Boolean csmIdIsNotNull){
		this.csmIdIsNotNull = csmIdIsNotNull;
		return this;
	}
	public Boolean getCsmIdIsNotNull(){
		return this.csmIdIsNotNull;
	}
	public CsMappingQuery setCsmIdStart(Integer csmIdStart){
		this.csmIdStart = csmIdStart;
		return this;
	}
	public Integer getCsmIdStart(){
		return this.csmIdStart;
	}
	public CsMappingQuery setCsmIdEnd(Integer csmIdEnd){
		this.csmIdEnd = csmIdEnd;
		return this;
	}
	public Integer getCsmIdEnd(){
		return this.csmIdEnd;
	}
	public CsMappingQuery setCsmIdLess(Integer csmIdLess){
		this.csmIdLess = csmIdLess;
		return this;
	}
	public Integer getCsmIdLess(){
		return this.csmIdLess;
	}
	public CsMappingQuery setCsmIdGreater(Integer csmIdGreater){
		this.csmIdGreater = csmIdGreater;
		return this;
	}
	public Integer getCsmIdGreater(){
		return this.csmIdGreater;
	}
	public CsMappingQuery setCsmCarEquals(Integer csmCarEquals){
		this.csmCarEquals = csmCarEquals;
		return this;
	}
	public Integer getCsmCarEquals(){
		return this.csmCarEquals;
	}
	public CsMappingQuery setCsmCarIn(Integer[] csmCarIn){
		this.csmCarIn = csmCarIn;
		return this;
	}
	public Integer[] getCsmCarIn(){
		return this.csmCarIn;
	}
	public CsMappingQuery setCsmCarIsNull(Boolean csmCarIsNull){
		this.csmCarIsNull = csmCarIsNull;
		return this;
	}
	public Boolean getCsmCarIsNull(){
		return this.csmCarIsNull;
	}
	public CsMappingQuery setCsmCarIsNotNull(Boolean csmCarIsNotNull){
		this.csmCarIsNotNull = csmCarIsNotNull;
		return this;
	}
	public Boolean getCsmCarIsNotNull(){
		return this.csmCarIsNotNull;
	}
	public CsMappingQuery setCsmCarStart(Integer csmCarStart){
		this.csmCarStart = csmCarStart;
		return this;
	}
	public Integer getCsmCarStart(){
		return this.csmCarStart;
	}
	public CsMappingQuery setCsmCarEnd(Integer csmCarEnd){
		this.csmCarEnd = csmCarEnd;
		return this;
	}
	public Integer getCsmCarEnd(){
		return this.csmCarEnd;
	}
	public CsMappingQuery setCsmCarLess(Integer csmCarLess){
		this.csmCarLess = csmCarLess;
		return this;
	}
	public Integer getCsmCarLess(){
		return this.csmCarLess;
	}
	public CsMappingQuery setCsmCarGreater(Integer csmCarGreater){
		this.csmCarGreater = csmCarGreater;
		return this;
	}
	public Integer getCsmCarGreater(){
		return this.csmCarGreater;
	}
	public CsMappingQuery setCsmManageEquals(Integer csmManageEquals){
		this.csmManageEquals = csmManageEquals;
		return this;
	}
	public Integer getCsmManageEquals(){
		return this.csmManageEquals;
	}
	public CsMappingQuery setCsmManageIn(Integer[] csmManageIn){
		this.csmManageIn = csmManageIn;
		return this;
	}
	public Integer[] getCsmManageIn(){
		return this.csmManageIn;
	}
	public CsMappingQuery setCsmManageIsNull(Boolean csmManageIsNull){
		this.csmManageIsNull = csmManageIsNull;
		return this;
	}
	public Boolean getCsmManageIsNull(){
		return this.csmManageIsNull;
	}
	public CsMappingQuery setCsmManageIsNotNull(Boolean csmManageIsNotNull){
		this.csmManageIsNotNull = csmManageIsNotNull;
		return this;
	}
	public Boolean getCsmManageIsNotNull(){
		return this.csmManageIsNotNull;
	}
	public CsMappingQuery setCsmManageStart(Integer csmManageStart){
		this.csmManageStart = csmManageStart;
		return this;
	}
	public Integer getCsmManageStart(){
		return this.csmManageStart;
	}
	public CsMappingQuery setCsmManageEnd(Integer csmManageEnd){
		this.csmManageEnd = csmManageEnd;
		return this;
	}
	public Integer getCsmManageEnd(){
		return this.csmManageEnd;
	}
	public CsMappingQuery setCsmManageLess(Integer csmManageLess){
		this.csmManageLess = csmManageLess;
		return this;
	}
	public Integer getCsmManageLess(){
		return this.csmManageLess;
	}
	public CsMappingQuery setCsmManageGreater(Integer csmManageGreater){
		this.csmManageGreater = csmManageGreater;
		return this;
	}
	public Integer getCsmManageGreater(){
		return this.csmManageGreater;
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
		else if(this.sidx.equals("csmCar")){
			return "csm_car";
		}
		else if(this.sidx.equals("csmManage")){
			return "csm_manage";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsMappingCrieria getCrieria(){
		CsMappingCrieria q = new CsMappingCrieria();
		CsMappingCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getCsmCarEquals()!=null){
			c.andcsmCarEqualTo(this.getCsmCarEquals());
		}else if(this.getCsmCarIsNull()!=null && this.getCsmCarIsNull()){
			c.andcsmCarIsNull();
		}else if(this.getCsmCarIsNotNull()!=null && this.getCsmCarIsNotNull()){
			c.andcsmCarIsNotNull();
		}else if(this.getCsmCarIn()!=null){
			c.andcsmCarIn(java.util.Arrays.asList(this.getCsmCarIn()));
		}else if(this.getCsmCarStart()!=null && this.getCsmCarEnd()!=null){
			c.andcsmCarBetween(this.getCsmCarStart(), this.getCsmCarEnd());
		}else if(this.getCsmCarGreater()!=null){
			c.andcsmCarGreaterThan(this.getCsmCarGreater());
		}else if(this.getCsmCarLess()!=null){
			c.andcsmCarLessThan(this.getCsmCarLess());
		}
		if(this.getCsmManageEquals()!=null){
			c.andcsmManageEqualTo(this.getCsmManageEquals());
		}else if(this.getCsmManageIsNull()!=null && this.getCsmManageIsNull()){
			c.andcsmManageIsNull();
		}else if(this.getCsmManageIsNotNull()!=null && this.getCsmManageIsNotNull()){
			c.andcsmManageIsNotNull();
		}else if(this.getCsmManageIn()!=null){
			c.andcsmManageIn(java.util.Arrays.asList(this.getCsmManageIn()));
		}else if(this.getCsmManageStart()!=null && this.getCsmManageEnd()!=null){
			c.andcsmManageBetween(this.getCsmManageStart(), this.getCsmManageEnd());
		}else if(this.getCsmManageGreater()!=null){
			c.andcsmManageGreaterThan(this.getCsmManageGreater());
		}else if(this.getCsmManageLess()!=null){
			c.andcsmManageLessThan(this.getCsmManageLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
