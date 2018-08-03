package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.VerFtpSerCrieria;

public class VerFtpSerQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	private String nameLike;
	
	private String nameEquals;
	private String[] nameIn;
	private Boolean nameIsNull;
	private Boolean nameIsNotNull;
	
	private String nameStart;
	
	private String nameEnd;
	
	private String nameLess;
	
	private String nameGreater;
	private String serUsernameLike;
	
	private String serUsernameEquals;
	private String[] serUsernameIn;
	private Boolean serUsernameIsNull;
	private Boolean serUsernameIsNotNull;
	
	private String serUsernameStart;
	
	private String serUsernameEnd;
	
	private String serUsernameLess;
	
	private String serUsernameGreater;
	private String serPwdLike;
	
	private String serPwdEquals;
	private String[] serPwdIn;
	private Boolean serPwdIsNull;
	private Boolean serPwdIsNotNull;
	
	private String serPwdStart;
	
	private String serPwdEnd;
	
	private String serPwdLess;
	
	private String serPwdGreater;
	private String urlLike;
	
	private String urlEquals;
	private String[] urlIn;
	private Boolean urlIsNull;
	private Boolean urlIsNotNull;
	
	private String urlStart;
	
	private String urlEnd;
	
	private String urlLess;
	
	private String urlGreater;
	
	private Integer portEquals;
	private Integer[] portIn;
	private Boolean portIsNull;
	private Boolean portIsNotNull;
	
	private Integer portStart;
	
	private Integer portEnd;
	
	private Integer portLess;
	
	private Integer portGreater;
	
	private Integer typeEquals;
	private Integer[] typeIn;
	private Boolean typeIsNull;
	private Boolean typeIsNotNull;
	
	private Integer typeStart;
	
	private Integer typeEnd;
	
	private Integer typeLess;
	
	private Integer typeGreater;
	private String sidx;
	private String sord;

	public VerFtpSerQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public VerFtpSerQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public VerFtpSerQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public VerFtpSerQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public VerFtpSerQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public VerFtpSerQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public VerFtpSerQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public VerFtpSerQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public VerFtpSerQuery setnameLike(String nameLike){
		this.nameLike = nameLike;
		return this;
	}
	public String getnameLike(){
		return this.nameLike;
	}
	public VerFtpSerQuery setnameEquals(String nameEquals){
		this.nameEquals = nameEquals;
		return this;
	}
	public String getnameEquals(){
		return this.nameEquals;
	}
	public VerFtpSerQuery setnameIn(String[] nameIn){
		this.nameIn = nameIn;
		return this;
	}
	public String[] getnameIn(){
		return this.nameIn;
	}
	public VerFtpSerQuery setnameIsNull(Boolean nameIsNull){
		this.nameIsNull = nameIsNull;
		return this;
	}
	public Boolean getnameIsNull(){
		return this.nameIsNull;
	}
	public VerFtpSerQuery setnameIsNotNull(Boolean nameIsNotNull){
		this.nameIsNotNull = nameIsNotNull;
		return this;
	}
	public Boolean getnameIsNotNull(){
		return this.nameIsNotNull;
	}
	public VerFtpSerQuery setnameStart(String nameStart){
		this.nameStart = nameStart;
		return this;
	}
	public String getnameStart(){
		return this.nameStart;
	}
	public VerFtpSerQuery setnameEnd(String nameEnd){
		this.nameEnd = nameEnd;
		return this;
	}
	public String getnameEnd(){
		return this.nameEnd;
	}
	public VerFtpSerQuery setnameLess(String nameLess){
		this.nameLess = nameLess;
		return this;
	}
	public String getnameLess(){
		return this.nameLess;
	}
	public VerFtpSerQuery setnameGreater(String nameGreater){
		this.nameGreater = nameGreater;
		return this;
	}
	public String getnameGreater(){
		return this.nameGreater;
	}
	public VerFtpSerQuery setSerUsernameLike(String serUsernameLike){
		this.serUsernameLike = serUsernameLike;
		return this;
	}
	public String getSerUsernameLike(){
		return this.serUsernameLike;
	}
	public VerFtpSerQuery setSerUsernameEquals(String serUsernameEquals){
		this.serUsernameEquals = serUsernameEquals;
		return this;
	}
	public String getSerUsernameEquals(){
		return this.serUsernameEquals;
	}
	public VerFtpSerQuery setSerUsernameIn(String[] serUsernameIn){
		this.serUsernameIn = serUsernameIn;
		return this;
	}
	public String[] getSerUsernameIn(){
		return this.serUsernameIn;
	}
	public VerFtpSerQuery setSerUsernameIsNull(Boolean serUsernameIsNull){
		this.serUsernameIsNull = serUsernameIsNull;
		return this;
	}
	public Boolean getSerUsernameIsNull(){
		return this.serUsernameIsNull;
	}
	public VerFtpSerQuery setSerUsernameIsNotNull(Boolean serUsernameIsNotNull){
		this.serUsernameIsNotNull = serUsernameIsNotNull;
		return this;
	}
	public Boolean getSerUsernameIsNotNull(){
		return this.serUsernameIsNotNull;
	}
	public VerFtpSerQuery setSerUsernameStart(String serUsernameStart){
		this.serUsernameStart = serUsernameStart;
		return this;
	}
	public String getSerUsernameStart(){
		return this.serUsernameStart;
	}
	public VerFtpSerQuery setSerUsernameEnd(String serUsernameEnd){
		this.serUsernameEnd = serUsernameEnd;
		return this;
	}
	public String getSerUsernameEnd(){
		return this.serUsernameEnd;
	}
	public VerFtpSerQuery setSerUsernameLess(String serUsernameLess){
		this.serUsernameLess = serUsernameLess;
		return this;
	}
	public String getSerUsernameLess(){
		return this.serUsernameLess;
	}
	public VerFtpSerQuery setSerUsernameGreater(String serUsernameGreater){
		this.serUsernameGreater = serUsernameGreater;
		return this;
	}
	public String getSerUsernameGreater(){
		return this.serUsernameGreater;
	}
	public VerFtpSerQuery setSerPwdLike(String serPwdLike){
		this.serPwdLike = serPwdLike;
		return this;
	}
	public String getSerPwdLike(){
		return this.serPwdLike;
	}
	public VerFtpSerQuery setSerPwdEquals(String serPwdEquals){
		this.serPwdEquals = serPwdEquals;
		return this;
	}
	public String getSerPwdEquals(){
		return this.serPwdEquals;
	}
	public VerFtpSerQuery setSerPwdIn(String[] serPwdIn){
		this.serPwdIn = serPwdIn;
		return this;
	}
	public String[] getSerPwdIn(){
		return this.serPwdIn;
	}
	public VerFtpSerQuery setSerPwdIsNull(Boolean serPwdIsNull){
		this.serPwdIsNull = serPwdIsNull;
		return this;
	}
	public Boolean getSerPwdIsNull(){
		return this.serPwdIsNull;
	}
	public VerFtpSerQuery setSerPwdIsNotNull(Boolean serPwdIsNotNull){
		this.serPwdIsNotNull = serPwdIsNotNull;
		return this;
	}
	public Boolean getSerPwdIsNotNull(){
		return this.serPwdIsNotNull;
	}
	public VerFtpSerQuery setSerPwdStart(String serPwdStart){
		this.serPwdStart = serPwdStart;
		return this;
	}
	public String getSerPwdStart(){
		return this.serPwdStart;
	}
	public VerFtpSerQuery setSerPwdEnd(String serPwdEnd){
		this.serPwdEnd = serPwdEnd;
		return this;
	}
	public String getSerPwdEnd(){
		return this.serPwdEnd;
	}
	public VerFtpSerQuery setSerPwdLess(String serPwdLess){
		this.serPwdLess = serPwdLess;
		return this;
	}
	public String getSerPwdLess(){
		return this.serPwdLess;
	}
	public VerFtpSerQuery setSerPwdGreater(String serPwdGreater){
		this.serPwdGreater = serPwdGreater;
		return this;
	}
	public String getSerPwdGreater(){
		return this.serPwdGreater;
	}
	public VerFtpSerQuery seturlLike(String urlLike){
		this.urlLike = urlLike;
		return this;
	}
	public String geturlLike(){
		return this.urlLike;
	}
	public VerFtpSerQuery seturlEquals(String urlEquals){
		this.urlEquals = urlEquals;
		return this;
	}
	public String geturlEquals(){
		return this.urlEquals;
	}
	public VerFtpSerQuery seturlIn(String[] urlIn){
		this.urlIn = urlIn;
		return this;
	}
	public String[] geturlIn(){
		return this.urlIn;
	}
	public VerFtpSerQuery seturlIsNull(Boolean urlIsNull){
		this.urlIsNull = urlIsNull;
		return this;
	}
	public Boolean geturlIsNull(){
		return this.urlIsNull;
	}
	public VerFtpSerQuery seturlIsNotNull(Boolean urlIsNotNull){
		this.urlIsNotNull = urlIsNotNull;
		return this;
	}
	public Boolean geturlIsNotNull(){
		return this.urlIsNotNull;
	}
	public VerFtpSerQuery seturlStart(String urlStart){
		this.urlStart = urlStart;
		return this;
	}
	public String geturlStart(){
		return this.urlStart;
	}
	public VerFtpSerQuery seturlEnd(String urlEnd){
		this.urlEnd = urlEnd;
		return this;
	}
	public String geturlEnd(){
		return this.urlEnd;
	}
	public VerFtpSerQuery seturlLess(String urlLess){
		this.urlLess = urlLess;
		return this;
	}
	public String geturlLess(){
		return this.urlLess;
	}
	public VerFtpSerQuery seturlGreater(String urlGreater){
		this.urlGreater = urlGreater;
		return this;
	}
	public String geturlGreater(){
		return this.urlGreater;
	}
	public VerFtpSerQuery setportEquals(Integer portEquals){
		this.portEquals = portEquals;
		return this;
	}
	public Integer getportEquals(){
		return this.portEquals;
	}
	public VerFtpSerQuery setportIn(Integer[] portIn){
		this.portIn = portIn;
		return this;
	}
	public Integer[] getportIn(){
		return this.portIn;
	}
	public VerFtpSerQuery setportIsNull(Boolean portIsNull){
		this.portIsNull = portIsNull;
		return this;
	}
	public Boolean getportIsNull(){
		return this.portIsNull;
	}
	public VerFtpSerQuery setportIsNotNull(Boolean portIsNotNull){
		this.portIsNotNull = portIsNotNull;
		return this;
	}
	public Boolean getportIsNotNull(){
		return this.portIsNotNull;
	}
	public VerFtpSerQuery setportStart(Integer portStart){
		this.portStart = portStart;
		return this;
	}
	public Integer getportStart(){
		return this.portStart;
	}
	public VerFtpSerQuery setportEnd(Integer portEnd){
		this.portEnd = portEnd;
		return this;
	}
	public Integer getportEnd(){
		return this.portEnd;
	}
	public VerFtpSerQuery setportLess(Integer portLess){
		this.portLess = portLess;
		return this;
	}
	public Integer getportLess(){
		return this.portLess;
	}
	public VerFtpSerQuery setportGreater(Integer portGreater){
		this.portGreater = portGreater;
		return this;
	}
	public Integer getportGreater(){
		return this.portGreater;
	}
	public VerFtpSerQuery settypeEquals(Integer typeEquals){
		this.typeEquals = typeEquals;
		return this;
	}
	public Integer gettypeEquals(){
		return this.typeEquals;
	}
	public VerFtpSerQuery settypeIn(Integer[] typeIn){
		this.typeIn = typeIn;
		return this;
	}
	public Integer[] gettypeIn(){
		return this.typeIn;
	}
	public VerFtpSerQuery settypeIsNull(Boolean typeIsNull){
		this.typeIsNull = typeIsNull;
		return this;
	}
	public Boolean gettypeIsNull(){
		return this.typeIsNull;
	}
	public VerFtpSerQuery settypeIsNotNull(Boolean typeIsNotNull){
		this.typeIsNotNull = typeIsNotNull;
		return this;
	}
	public Boolean gettypeIsNotNull(){
		return this.typeIsNotNull;
	}
	public VerFtpSerQuery settypeStart(Integer typeStart){
		this.typeStart = typeStart;
		return this;
	}
	public Integer gettypeStart(){
		return this.typeStart;
	}
	public VerFtpSerQuery settypeEnd(Integer typeEnd){
		this.typeEnd = typeEnd;
		return this;
	}
	public Integer gettypeEnd(){
		return this.typeEnd;
	}
	public VerFtpSerQuery settypeLess(Integer typeLess){
		this.typeLess = typeLess;
		return this;
	}
	public Integer gettypeLess(){
		return this.typeLess;
	}
	public VerFtpSerQuery settypeGreater(Integer typeGreater){
		this.typeGreater = typeGreater;
		return this;
	}
	public Integer gettypeGreater(){
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
		else if(this.sidx.equals("name")){
			return "name";
		}
		else if(this.sidx.equals("serUsername")){
			return "ser_username";
		}
		else if(this.sidx.equals("serPwd")){
			return "ser_pwd";
		}
		else if(this.sidx.equals("url")){
			return "url";
		}
		else if(this.sidx.equals("port")){
			return "port";
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
	
	public VerFtpSerCrieria getCrieria(){
		VerFtpSerCrieria q = new VerFtpSerCrieria();
		VerFtpSerCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getnameEquals()!=null){
			c.andnameEqualTo(this.getnameEquals());
		}else if(this.getnameIsNull()!=null && this.getnameIsNull()){
			c.andnameIsNull();
		}else if(this.getnameIsNotNull()!=null && this.getnameIsNotNull()){
			c.andnameIsNotNull();
		}else if(this.getnameLike()!=null){
			c.andnameLike(this.getnameLike());
		}else if(this.getnameIn()!=null){
			c.andnameIn(java.util.Arrays.asList(this.getnameIn()));
		}else if(this.getnameStart()!=null && this.getnameEnd()!=null){
			c.andnameBetween(this.getnameStart(), this.getnameEnd());
		}else if(this.getnameGreater()!=null){
			c.andnameGreaterThan(this.getnameGreater());
		}else if(this.getnameLess()!=null){
			c.andnameLessThan(this.getnameLess());
		}
		if(this.getSerUsernameEquals()!=null){
			c.andserUsernameEqualTo(this.getSerUsernameEquals());
		}else if(this.getSerUsernameIsNull()!=null && this.getSerUsernameIsNull()){
			c.andserUsernameIsNull();
		}else if(this.getSerUsernameIsNotNull()!=null && this.getSerUsernameIsNotNull()){
			c.andserUsernameIsNotNull();
		}else if(this.getSerUsernameLike()!=null){
			c.andserUsernameLike(this.getSerUsernameLike());
		}else if(this.getSerUsernameIn()!=null){
			c.andserUsernameIn(java.util.Arrays.asList(this.getSerUsernameIn()));
		}else if(this.getSerUsernameStart()!=null && this.getSerUsernameEnd()!=null){
			c.andserUsernameBetween(this.getSerUsernameStart(), this.getSerUsernameEnd());
		}else if(this.getSerUsernameGreater()!=null){
			c.andserUsernameGreaterThan(this.getSerUsernameGreater());
		}else if(this.getSerUsernameLess()!=null){
			c.andserUsernameLessThan(this.getSerUsernameLess());
		}
		if(this.getSerPwdEquals()!=null){
			c.andserPwdEqualTo(this.getSerPwdEquals());
		}else if(this.getSerPwdIsNull()!=null && this.getSerPwdIsNull()){
			c.andserPwdIsNull();
		}else if(this.getSerPwdIsNotNull()!=null && this.getSerPwdIsNotNull()){
			c.andserPwdIsNotNull();
		}else if(this.getSerPwdLike()!=null){
			c.andserPwdLike(this.getSerPwdLike());
		}else if(this.getSerPwdIn()!=null){
			c.andserPwdIn(java.util.Arrays.asList(this.getSerPwdIn()));
		}else if(this.getSerPwdStart()!=null && this.getSerPwdEnd()!=null){
			c.andserPwdBetween(this.getSerPwdStart(), this.getSerPwdEnd());
		}else if(this.getSerPwdGreater()!=null){
			c.andserPwdGreaterThan(this.getSerPwdGreater());
		}else if(this.getSerPwdLess()!=null){
			c.andserPwdLessThan(this.getSerPwdLess());
		}
		if(this.geturlEquals()!=null){
			c.andurlEqualTo(this.geturlEquals());
		}else if(this.geturlIsNull()!=null && this.geturlIsNull()){
			c.andurlIsNull();
		}else if(this.geturlIsNotNull()!=null && this.geturlIsNotNull()){
			c.andurlIsNotNull();
		}else if(this.geturlLike()!=null){
			c.andurlLike(this.geturlLike());
		}else if(this.geturlIn()!=null){
			c.andurlIn(java.util.Arrays.asList(this.geturlIn()));
		}else if(this.geturlStart()!=null && this.geturlEnd()!=null){
			c.andurlBetween(this.geturlStart(), this.geturlEnd());
		}else if(this.geturlGreater()!=null){
			c.andurlGreaterThan(this.geturlGreater());
		}else if(this.geturlLess()!=null){
			c.andurlLessThan(this.geturlLess());
		}
		if(this.getportEquals()!=null){
			c.andportEqualTo(this.getportEquals());
		}else if(this.getportIsNull()!=null && this.getportIsNull()){
			c.andportIsNull();
		}else if(this.getportIsNotNull()!=null && this.getportIsNotNull()){
			c.andportIsNotNull();
		}else if(this.getportIn()!=null){
			c.andportIn(java.util.Arrays.asList(this.getportIn()));
		}else if(this.getportStart()!=null && this.getportEnd()!=null){
			c.andportBetween(this.getportStart(), this.getportEnd());
		}else if(this.getportGreater()!=null){
			c.andportGreaterThan(this.getportGreater());
		}else if(this.getportLess()!=null){
			c.andportLessThan(this.getportLess());
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
