package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.VerSoftHardwareCrieria;

public class VerSoftHardwareQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	private String verNoLike;
	
	private String verNoEquals;
	private String[] verNoIn;
	private Boolean verNoIsNull;
	private Boolean verNoIsNotNull;
	
	private String verNoStart;
	
	private String verNoEnd;
	
	private String verNoLess;
	
	private String verNoGreater;
	private String desLike;
	
	private String desEquals;
	private String[] desIn;
	private Boolean desIsNull;
	private Boolean desIsNotNull;
	
	private String desStart;
	
	private String desEnd;
	
	private String desLess;
	
	private String desGreater;
	
	private Short typeEquals;
	private Short[] typeIn;
	private Boolean typeIsNull;
	private Boolean typeIsNotNull;
	
	private Short typeStart;
	
	private Short typeEnd;
	
	private Short typeLess;
	
	private Short typeGreater;
	private String sidx;
	private String sord;

	public VerSoftHardwareQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public VerSoftHardwareQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public VerSoftHardwareQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public VerSoftHardwareQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public VerSoftHardwareQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public VerSoftHardwareQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public VerSoftHardwareQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public VerSoftHardwareQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public VerSoftHardwareQuery setVerNoLike(String verNoLike){
		this.verNoLike = verNoLike;
		return this;
	}
	public String getVerNoLike(){
		return this.verNoLike;
	}
	public VerSoftHardwareQuery setVerNoEquals(String verNoEquals){
		this.verNoEquals = verNoEquals;
		return this;
	}
	public String getVerNoEquals(){
		return this.verNoEquals;
	}
	public VerSoftHardwareQuery setVerNoIn(String[] verNoIn){
		this.verNoIn = verNoIn;
		return this;
	}
	public String[] getVerNoIn(){
		return this.verNoIn;
	}
	public VerSoftHardwareQuery setVerNoIsNull(Boolean verNoIsNull){
		this.verNoIsNull = verNoIsNull;
		return this;
	}
	public Boolean getVerNoIsNull(){
		return this.verNoIsNull;
	}
	public VerSoftHardwareQuery setVerNoIsNotNull(Boolean verNoIsNotNull){
		this.verNoIsNotNull = verNoIsNotNull;
		return this;
	}
	public Boolean getVerNoIsNotNull(){
		return this.verNoIsNotNull;
	}
	public VerSoftHardwareQuery setVerNoStart(String verNoStart){
		this.verNoStart = verNoStart;
		return this;
	}
	public String getVerNoStart(){
		return this.verNoStart;
	}
	public VerSoftHardwareQuery setVerNoEnd(String verNoEnd){
		this.verNoEnd = verNoEnd;
		return this;
	}
	public String getVerNoEnd(){
		return this.verNoEnd;
	}
	public VerSoftHardwareQuery setVerNoLess(String verNoLess){
		this.verNoLess = verNoLess;
		return this;
	}
	public String getVerNoLess(){
		return this.verNoLess;
	}
	public VerSoftHardwareQuery setVerNoGreater(String verNoGreater){
		this.verNoGreater = verNoGreater;
		return this;
	}
	public String getVerNoGreater(){
		return this.verNoGreater;
	}
	public VerSoftHardwareQuery setdesLike(String desLike){
		this.desLike = desLike;
		return this;
	}
	public String getdesLike(){
		return this.desLike;
	}
	public VerSoftHardwareQuery setdesEquals(String desEquals){
		this.desEquals = desEquals;
		return this;
	}
	public String getdesEquals(){
		return this.desEquals;
	}
	public VerSoftHardwareQuery setdesIn(String[] desIn){
		this.desIn = desIn;
		return this;
	}
	public String[] getdesIn(){
		return this.desIn;
	}
	public VerSoftHardwareQuery setdesIsNull(Boolean desIsNull){
		this.desIsNull = desIsNull;
		return this;
	}
	public Boolean getdesIsNull(){
		return this.desIsNull;
	}
	public VerSoftHardwareQuery setdesIsNotNull(Boolean desIsNotNull){
		this.desIsNotNull = desIsNotNull;
		return this;
	}
	public Boolean getdesIsNotNull(){
		return this.desIsNotNull;
	}
	public VerSoftHardwareQuery setdesStart(String desStart){
		this.desStart = desStart;
		return this;
	}
	public String getdesStart(){
		return this.desStart;
	}
	public VerSoftHardwareQuery setdesEnd(String desEnd){
		this.desEnd = desEnd;
		return this;
	}
	public String getdesEnd(){
		return this.desEnd;
	}
	public VerSoftHardwareQuery setdesLess(String desLess){
		this.desLess = desLess;
		return this;
	}
	public String getdesLess(){
		return this.desLess;
	}
	public VerSoftHardwareQuery setdesGreater(String desGreater){
		this.desGreater = desGreater;
		return this;
	}
	public String getdesGreater(){
		return this.desGreater;
	}
	public VerSoftHardwareQuery settypeEquals(Short typeEquals){
		this.typeEquals = typeEquals;
		return this;
	}
	public Short gettypeEquals(){
		return this.typeEquals;
	}
	public VerSoftHardwareQuery settypeIn(Short[] typeIn){
		this.typeIn = typeIn;
		return this;
	}
	public Short[] gettypeIn(){
		return this.typeIn;
	}
	public VerSoftHardwareQuery settypeIsNull(Boolean typeIsNull){
		this.typeIsNull = typeIsNull;
		return this;
	}
	public Boolean gettypeIsNull(){
		return this.typeIsNull;
	}
	public VerSoftHardwareQuery settypeIsNotNull(Boolean typeIsNotNull){
		this.typeIsNotNull = typeIsNotNull;
		return this;
	}
	public Boolean gettypeIsNotNull(){
		return this.typeIsNotNull;
	}
	public VerSoftHardwareQuery settypeStart(Short typeStart){
		this.typeStart = typeStart;
		return this;
	}
	public Short gettypeStart(){
		return this.typeStart;
	}
	public VerSoftHardwareQuery settypeEnd(Short typeEnd){
		this.typeEnd = typeEnd;
		return this;
	}
	public Short gettypeEnd(){
		return this.typeEnd;
	}
	public VerSoftHardwareQuery settypeLess(Short typeLess){
		this.typeLess = typeLess;
		return this;
	}
	public Short gettypeLess(){
		return this.typeLess;
	}
	public VerSoftHardwareQuery settypeGreater(Short typeGreater){
		this.typeGreater = typeGreater;
		return this;
	}
	public Short gettypeGreater(){
		return this.typeGreater;
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
		else if(this.sidx.equals("verNo")){
			return "ver_no";
		}
		else if(this.sidx.equals("des")){
			return "des";
		}
		else if(this.sidx.equals("type")){
			return "type";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public VerSoftHardwareCrieria getCrieria(){
		VerSoftHardwareCrieria q = new VerSoftHardwareCrieria();
		VerSoftHardwareCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getVerNoEquals()!=null){
			c.andverNoEqualTo(this.getVerNoEquals());
		}else if(this.getVerNoIsNull()!=null && this.getVerNoIsNull()){
			c.andverNoIsNull();
		}else if(this.getVerNoIsNotNull()!=null && this.getVerNoIsNotNull()){
			c.andverNoIsNotNull();
		}else if(this.getVerNoLike()!=null){
			c.andverNoLike(this.getVerNoLike());
		}else if(this.getVerNoIn()!=null){
			c.andverNoIn(java.util.Arrays.asList(this.getVerNoIn()));
		}else if(this.getVerNoStart()!=null && this.getVerNoEnd()!=null){
			c.andverNoBetween(this.getVerNoStart(), this.getVerNoEnd());
		}else if(this.getVerNoGreater()!=null){
			c.andverNoGreaterThan(this.getVerNoGreater());
		}else if(this.getVerNoLess()!=null){
			c.andverNoLessThan(this.getVerNoLess());
		}
		if(this.getdesEquals()!=null){
			c.anddesEqualTo(this.getdesEquals());
		}else if(this.getdesIsNull()!=null && this.getdesIsNull()){
			c.anddesIsNull();
		}else if(this.getdesIsNotNull()!=null && this.getdesIsNotNull()){
			c.anddesIsNotNull();
		}else if(this.getdesLike()!=null){
			c.anddesLike(this.getdesLike());
		}else if(this.getdesIn()!=null){
			c.anddesIn(java.util.Arrays.asList(this.getdesIn()));
		}else if(this.getdesStart()!=null && this.getdesEnd()!=null){
			c.anddesBetween(this.getdesStart(), this.getdesEnd());
		}else if(this.getdesGreater()!=null){
			c.anddesGreaterThan(this.getdesGreater());
		}else if(this.getdesLess()!=null){
			c.anddesLessThan(this.getdesLess());
		}
		if(this.gettypeEquals()!=null){
			c.andtypeEqualTo(this.gettypeEquals());
		}else if(this.gettypeIsNull()!=null && this.gettypeIsNull()){
			c.andtypeIsNull();
		}else if(this.gettypeIsNotNull()!=null && this.gettypeIsNotNull()){
			c.andtypeIsNotNull();
		}else if(this.gettypeIn()!=null){
			c.andtypeIn(java.util.Arrays.asList(this.gettypeIn()));
		}else if(this.gettypeStart()!=null && this.gettypeEnd()!=null){
			c.andtypeBetween(this.gettypeStart(), this.gettypeEnd());
		}else if(this.gettypeGreater()!=null){
			c.andtypeGreaterThan(this.gettypeGreater());
		}else if(this.gettypeLess()!=null){
			c.andtypeLessThan(this.gettypeLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
