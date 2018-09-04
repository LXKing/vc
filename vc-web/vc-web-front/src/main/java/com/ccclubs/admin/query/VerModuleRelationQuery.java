package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.VerModuleRelationCrieria;

public class VerModuleRelationQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	
	private Integer verIdEquals;
	private Integer[] verIdIn;
	private Boolean verIdIsNull;
	private Boolean verIdIsNotNull;
	
	private Integer verIdStart;
	
	private Integer verIdEnd;
	
	private Integer verIdLess;
	
	private Integer verIdGreater;
	
	private Integer moduleIdEquals;
	private Integer[] moduleIdIn;
	private Boolean moduleIdIsNull;
	private Boolean moduleIdIsNotNull;
	
	private Integer moduleIdStart;
	
	private Integer moduleIdEnd;
	
	private Integer moduleIdLess;
	
	private Integer moduleIdGreater;
	private String moduleValLike;
	
	private String moduleValEquals;
	private String[] moduleValIn;
	private Boolean moduleValIsNull;
	private Boolean moduleValIsNotNull;
	
	private String moduleValStart;
	
	private String moduleValEnd;
	
	private String moduleValLess;
	
	private String moduleValGreater;
	
	private Short isSupEquals;
	private Short[] isSupIn;
	private Boolean isSupIsNull;
	private Boolean isSupIsNotNull;
	
	private Short isSupStart;
	
	private Short isSupEnd;
	
	private Short isSupLess;
	
	private Short isSupGreater;
	private String sidx;
	private String sord;

	public VerModuleRelationQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public VerModuleRelationQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public VerModuleRelationQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public VerModuleRelationQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public VerModuleRelationQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public VerModuleRelationQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public VerModuleRelationQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public VerModuleRelationQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public VerModuleRelationQuery setVerIdEquals(Integer verIdEquals){
		this.verIdEquals = verIdEquals;
		return this;
	}
	public Integer getVerIdEquals(){
		return this.verIdEquals;
	}
	public VerModuleRelationQuery setVerIdIn(Integer[] verIdIn){
		this.verIdIn = verIdIn;
		return this;
	}
	public Integer[] getVerIdIn(){
		return this.verIdIn;
	}
	public VerModuleRelationQuery setVerIdIsNull(Boolean verIdIsNull){
		this.verIdIsNull = verIdIsNull;
		return this;
	}
	public Boolean getVerIdIsNull(){
		return this.verIdIsNull;
	}
	public VerModuleRelationQuery setVerIdIsNotNull(Boolean verIdIsNotNull){
		this.verIdIsNotNull = verIdIsNotNull;
		return this;
	}
	public Boolean getVerIdIsNotNull(){
		return this.verIdIsNotNull;
	}
	public VerModuleRelationQuery setVerIdStart(Integer verIdStart){
		this.verIdStart = verIdStart;
		return this;
	}
	public Integer getVerIdStart(){
		return this.verIdStart;
	}
	public VerModuleRelationQuery setVerIdEnd(Integer verIdEnd){
		this.verIdEnd = verIdEnd;
		return this;
	}
	public Integer getVerIdEnd(){
		return this.verIdEnd;
	}
	public VerModuleRelationQuery setVerIdLess(Integer verIdLess){
		this.verIdLess = verIdLess;
		return this;
	}
	public Integer getVerIdLess(){
		return this.verIdLess;
	}
	public VerModuleRelationQuery setVerIdGreater(Integer verIdGreater){
		this.verIdGreater = verIdGreater;
		return this;
	}
	public Integer getVerIdGreater(){
		return this.verIdGreater;
	}
	public VerModuleRelationQuery setModuleIdEquals(Integer moduleIdEquals){
		this.moduleIdEquals = moduleIdEquals;
		return this;
	}
	public Integer getModuleIdEquals(){
		return this.moduleIdEquals;
	}
	public VerModuleRelationQuery setModuleIdIn(Integer[] moduleIdIn){
		this.moduleIdIn = moduleIdIn;
		return this;
	}
	public Integer[] getModuleIdIn(){
		return this.moduleIdIn;
	}
	public VerModuleRelationQuery setModuleIdIsNull(Boolean moduleIdIsNull){
		this.moduleIdIsNull = moduleIdIsNull;
		return this;
	}
	public Boolean getModuleIdIsNull(){
		return this.moduleIdIsNull;
	}
	public VerModuleRelationQuery setModuleIdIsNotNull(Boolean moduleIdIsNotNull){
		this.moduleIdIsNotNull = moduleIdIsNotNull;
		return this;
	}
	public Boolean getModuleIdIsNotNull(){
		return this.moduleIdIsNotNull;
	}
	public VerModuleRelationQuery setModuleIdStart(Integer moduleIdStart){
		this.moduleIdStart = moduleIdStart;
		return this;
	}
	public Integer getModuleIdStart(){
		return this.moduleIdStart;
	}
	public VerModuleRelationQuery setModuleIdEnd(Integer moduleIdEnd){
		this.moduleIdEnd = moduleIdEnd;
		return this;
	}
	public Integer getModuleIdEnd(){
		return this.moduleIdEnd;
	}
	public VerModuleRelationQuery setModuleIdLess(Integer moduleIdLess){
		this.moduleIdLess = moduleIdLess;
		return this;
	}
	public Integer getModuleIdLess(){
		return this.moduleIdLess;
	}
	public VerModuleRelationQuery setModuleIdGreater(Integer moduleIdGreater){
		this.moduleIdGreater = moduleIdGreater;
		return this;
	}
	public Integer getModuleIdGreater(){
		return this.moduleIdGreater;
	}
	public VerModuleRelationQuery setModuleValLike(String moduleValLike){
		this.moduleValLike = moduleValLike;
		return this;
	}
	public String getModuleValLike(){
		return this.moduleValLike;
	}
	public VerModuleRelationQuery setModuleValEquals(String moduleValEquals){
		this.moduleValEquals = moduleValEquals;
		return this;
	}
	public String getModuleValEquals(){
		return this.moduleValEquals;
	}
	public VerModuleRelationQuery setModuleValIn(String[] moduleValIn){
		this.moduleValIn = moduleValIn;
		return this;
	}
	public String[] getModuleValIn(){
		return this.moduleValIn;
	}
	public VerModuleRelationQuery setModuleValIsNull(Boolean moduleValIsNull){
		this.moduleValIsNull = moduleValIsNull;
		return this;
	}
	public Boolean getModuleValIsNull(){
		return this.moduleValIsNull;
	}
	public VerModuleRelationQuery setModuleValIsNotNull(Boolean moduleValIsNotNull){
		this.moduleValIsNotNull = moduleValIsNotNull;
		return this;
	}
	public Boolean getModuleValIsNotNull(){
		return this.moduleValIsNotNull;
	}
	public VerModuleRelationQuery setModuleValStart(String moduleValStart){
		this.moduleValStart = moduleValStart;
		return this;
	}
	public String getModuleValStart(){
		return this.moduleValStart;
	}
	public VerModuleRelationQuery setModuleValEnd(String moduleValEnd){
		this.moduleValEnd = moduleValEnd;
		return this;
	}
	public String getModuleValEnd(){
		return this.moduleValEnd;
	}
	public VerModuleRelationQuery setModuleValLess(String moduleValLess){
		this.moduleValLess = moduleValLess;
		return this;
	}
	public String getModuleValLess(){
		return this.moduleValLess;
	}
	public VerModuleRelationQuery setModuleValGreater(String moduleValGreater){
		this.moduleValGreater = moduleValGreater;
		return this;
	}
	public String getModuleValGreater(){
		return this.moduleValGreater;
	}
	public VerModuleRelationQuery setIsSupEquals(Short isSupEquals){
		this.isSupEquals = isSupEquals;
		return this;
	}
	public Short getIsSupEquals(){
		return this.isSupEquals;
	}
	public VerModuleRelationQuery setIsSupIn(Short[] isSupIn){
		this.isSupIn = isSupIn;
		return this;
	}
	public Short[] getIsSupIn(){
		return this.isSupIn;
	}
	public VerModuleRelationQuery setIsSupIsNull(Boolean isSupIsNull){
		this.isSupIsNull = isSupIsNull;
		return this;
	}
	public Boolean getIsSupIsNull(){
		return this.isSupIsNull;
	}
	public VerModuleRelationQuery setIsSupIsNotNull(Boolean isSupIsNotNull){
		this.isSupIsNotNull = isSupIsNotNull;
		return this;
	}
	public Boolean getIsSupIsNotNull(){
		return this.isSupIsNotNull;
	}
	public VerModuleRelationQuery setIsSupStart(Short isSupStart){
		this.isSupStart = isSupStart;
		return this;
	}
	public Short getIsSupStart(){
		return this.isSupStart;
	}
	public VerModuleRelationQuery setIsSupEnd(Short isSupEnd){
		this.isSupEnd = isSupEnd;
		return this;
	}
	public Short getIsSupEnd(){
		return this.isSupEnd;
	}
	public VerModuleRelationQuery setIsSupLess(Short isSupLess){
		this.isSupLess = isSupLess;
		return this;
	}
	public Short getIsSupLess(){
		return this.isSupLess;
	}
	public VerModuleRelationQuery setIsSupGreater(Short isSupGreater){
		this.isSupGreater = isSupGreater;
		return this;
	}
	public Short getIsSupGreater(){
		return this.isSupGreater;
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
		else if(this.sidx.equals("verId")){
			return "ver_id";
		}
		else if(this.sidx.equals("moduleId")){
			return "module_id";
		}
		else if(this.sidx.equals("moduleVal")){
			return "module_val";
		}
		else if(this.sidx.equals("isSup")){
			return "is_sup";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public VerModuleRelationCrieria getCrieria(){
		VerModuleRelationCrieria q = new VerModuleRelationCrieria();
		VerModuleRelationCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getVerIdEquals()!=null){
			c.andverIdEqualTo(this.getVerIdEquals());
		}else if(this.getVerIdIsNull()!=null && this.getVerIdIsNull()){
			c.andverIdIsNull();
		}else if(this.getVerIdIsNotNull()!=null && this.getVerIdIsNotNull()){
			c.andverIdIsNotNull();
		}else if(this.getVerIdIn()!=null){
			c.andverIdIn(java.util.Arrays.asList(this.getVerIdIn()));
		}else if(this.getVerIdStart()!=null && this.getVerIdEnd()!=null){
			c.andverIdBetween(this.getVerIdStart(), this.getVerIdEnd());
		}else if(this.getVerIdGreater()!=null){
			c.andverIdGreaterThan(this.getVerIdGreater());
		}else if(this.getVerIdLess()!=null){
			c.andverIdLessThan(this.getVerIdLess());
		}
		if(this.getModuleIdEquals()!=null){
			c.andmoduleIdEqualTo(this.getModuleIdEquals());
		}else if(this.getModuleIdIsNull()!=null && this.getModuleIdIsNull()){
			c.andmoduleIdIsNull();
		}else if(this.getModuleIdIsNotNull()!=null && this.getModuleIdIsNotNull()){
			c.andmoduleIdIsNotNull();
		}else if(this.getModuleIdIn()!=null){
			c.andmoduleIdIn(java.util.Arrays.asList(this.getModuleIdIn()));
		}else if(this.getModuleIdStart()!=null && this.getModuleIdEnd()!=null){
			c.andmoduleIdBetween(this.getModuleIdStart(), this.getModuleIdEnd());
		}else if(this.getModuleIdGreater()!=null){
			c.andmoduleIdGreaterThan(this.getModuleIdGreater());
		}else if(this.getModuleIdLess()!=null){
			c.andmoduleIdLessThan(this.getModuleIdLess());
		}
		if(this.getModuleValEquals()!=null){
			c.andmoduleValEqualTo(this.getModuleValEquals());
		}else if(this.getModuleValIsNull()!=null && this.getModuleValIsNull()){
			c.andmoduleValIsNull();
		}else if(this.getModuleValIsNotNull()!=null && this.getModuleValIsNotNull()){
			c.andmoduleValIsNotNull();
		}else if(this.getModuleValLike()!=null){
			c.andmoduleValLike(this.getModuleValLike());
		}else if(this.getModuleValIn()!=null){
			c.andmoduleValIn(java.util.Arrays.asList(this.getModuleValIn()));
		}else if(this.getModuleValStart()!=null && this.getModuleValEnd()!=null){
			c.andmoduleValBetween(this.getModuleValStart(), this.getModuleValEnd());
		}else if(this.getModuleValGreater()!=null){
			c.andmoduleValGreaterThan(this.getModuleValGreater());
		}else if(this.getModuleValLess()!=null){
			c.andmoduleValLessThan(this.getModuleValLess());
		}
		if(this.getIsSupEquals()!=null){
			c.andisSupEqualTo(this.getIsSupEquals());
		}else if(this.getIsSupIsNull()!=null && this.getIsSupIsNull()){
			c.andisSupIsNull();
		}else if(this.getIsSupIsNotNull()!=null && this.getIsSupIsNotNull()){
			c.andisSupIsNotNull();
		}else if(this.getIsSupIn()!=null){
			c.andisSupIn(java.util.Arrays.asList(this.getIsSupIn()));
		}else if(this.getIsSupStart()!=null && this.getIsSupEnd()!=null){
			c.andisSupBetween(this.getIsSupStart(), this.getIsSupEnd());
		}else if(this.getIsSupGreater()!=null){
			c.andisSupGreaterThan(this.getIsSupGreater());
		}else if(this.getIsSupLess()!=null){
			c.andisSupLessThan(this.getIsSupLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
