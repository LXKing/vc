package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.SrvDictCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SrvDictQuery {
	
	private Integer idEquals;
	private Integer[] idIn;
	private Boolean idIsNull;
	private Boolean idIsNotNull;
	
	private Integer idStart;
	
	private Integer idEnd;
	
	private Integer idLess;
	
	private Integer idGreater;
	private String valueLike;
	
	private String valueEquals;
	private String[] valueIn;
	private Boolean valueIsNull;
	private Boolean valueIsNotNull;
	
	private String valueStart;
	
	private String valueEnd;
	
	private String valueLess;
	
	private String valueGreater;
	private String labelLike;
	
	private String labelEquals;
	private String[] labelIn;
	private Boolean labelIsNull;
	private Boolean labelIsNotNull;
	
	private String labelStart;
	
	private String labelEnd;
	
	private String labelLess;
	
	private String labelGreater;
	private String typeLike;
	
	private String typeEquals;
	private String[] typeIn;
	private Boolean typeIsNull;
	private Boolean typeIsNotNull;
	
	private String typeStart;
	
	private String typeEnd;
	
	private String typeLess;
	
	private String typeGreater;
	private String descriptionLike;
	
	private String descriptionEquals;
	private String[] descriptionIn;
	private Boolean descriptionIsNull;
	private Boolean descriptionIsNotNull;
	
	private String descriptionStart;
	
	private String descriptionEnd;
	
	private String descriptionLess;
	
	private String descriptionGreater;
	
	private Integer sortEquals;
	private Integer[] sortIn;
	private Boolean sortIsNull;
	private Boolean sortIsNotNull;
	
	private Integer sortStart;
	
	private Integer sortEnd;
	
	private Integer sortLess;
	
	private Integer sortGreater;
	private String createByLike;
	
	private String createByEquals;
	private String[] createByIn;
	private Boolean createByIsNull;
	private Boolean createByIsNotNull;
	
	private String createByStart;
	
	private String createByEnd;
	
	private String createByLess;
	
	private String createByGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createDateEquals;
	private Date[] createDateIn;
	private Boolean createDateIsNull;
	private Boolean createDateIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createDateStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createDateEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createDateLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createDateGreater;
	private String updateByLike;
	
	private String updateByEquals;
	private String[] updateByIn;
	private Boolean updateByIsNull;
	private Boolean updateByIsNotNull;
	
	private String updateByStart;
	
	private String updateByEnd;
	
	private String updateByLess;
	
	private String updateByGreater;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateDateEquals;
	private Date[] updateDateIn;
	private Boolean updateDateIsNull;
	private Boolean updateDateIsNotNull;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateDateStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateDateEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateDateLess;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateDateGreater;
	private String remarksLike;
	
	private String remarksEquals;
	private String[] remarksIn;
	private Boolean remarksIsNull;
	private Boolean remarksIsNotNull;
	
	private String remarksStart;
	
	private String remarksEnd;
	
	private String remarksLess;
	
	private String remarksGreater;
	private String delFlagLike;
	
	private String delFlagEquals;
	private String[] delFlagIn;
	private Boolean delFlagIsNull;
	private Boolean delFlagIsNotNull;
	
	private String delFlagStart;
	
	private String delFlagEnd;
	
	private String delFlagLess;
	
	private String delFlagGreater;
	private String sidx;
	private String sord;

	public SrvDictQuery setidEquals(Integer idEquals){
		this.idEquals = idEquals;
		return this;
	}
	public Integer getidEquals(){
		return this.idEquals;
	}
	public SrvDictQuery setidIn(Integer[] idIn){
		this.idIn = idIn;
		return this;
	}
	public Integer[] getidIn(){
		return this.idIn;
	}
	public SrvDictQuery setidIsNull(Boolean idIsNull){
		this.idIsNull = idIsNull;
		return this;
	}
	public Boolean getidIsNull(){
		return this.idIsNull;
	}
	public SrvDictQuery setidIsNotNull(Boolean idIsNotNull){
		this.idIsNotNull = idIsNotNull;
		return this;
	}
	public Boolean getidIsNotNull(){
		return this.idIsNotNull;
	}
	public SrvDictQuery setidStart(Integer idStart){
		this.idStart = idStart;
		return this;
	}
	public Integer getidStart(){
		return this.idStart;
	}
	public SrvDictQuery setidEnd(Integer idEnd){
		this.idEnd = idEnd;
		return this;
	}
	public Integer getidEnd(){
		return this.idEnd;
	}
	public SrvDictQuery setidLess(Integer idLess){
		this.idLess = idLess;
		return this;
	}
	public Integer getidLess(){
		return this.idLess;
	}
	public SrvDictQuery setidGreater(Integer idGreater){
		this.idGreater = idGreater;
		return this;
	}
	public Integer getidGreater(){
		return this.idGreater;
	}
	public SrvDictQuery setvalueLike(String valueLike){
		this.valueLike = valueLike;
		return this;
	}
	public String getvalueLike(){
		return this.valueLike;
	}
	public SrvDictQuery setvalueEquals(String valueEquals){
		this.valueEquals = valueEquals;
		return this;
	}
	public String getvalueEquals(){
		return this.valueEquals;
	}
	public SrvDictQuery setvalueIn(String[] valueIn){
		this.valueIn = valueIn;
		return this;
	}
	public String[] getvalueIn(){
		return this.valueIn;
	}
	public SrvDictQuery setvalueIsNull(Boolean valueIsNull){
		this.valueIsNull = valueIsNull;
		return this;
	}
	public Boolean getvalueIsNull(){
		return this.valueIsNull;
	}
	public SrvDictQuery setvalueIsNotNull(Boolean valueIsNotNull){
		this.valueIsNotNull = valueIsNotNull;
		return this;
	}
	public Boolean getvalueIsNotNull(){
		return this.valueIsNotNull;
	}
	public SrvDictQuery setvalueStart(String valueStart){
		this.valueStart = valueStart;
		return this;
	}
	public String getvalueStart(){
		return this.valueStart;
	}
	public SrvDictQuery setvalueEnd(String valueEnd){
		this.valueEnd = valueEnd;
		return this;
	}
	public String getvalueEnd(){
		return this.valueEnd;
	}
	public SrvDictQuery setvalueLess(String valueLess){
		this.valueLess = valueLess;
		return this;
	}
	public String getvalueLess(){
		return this.valueLess;
	}
	public SrvDictQuery setvalueGreater(String valueGreater){
		this.valueGreater = valueGreater;
		return this;
	}
	public String getvalueGreater(){
		return this.valueGreater;
	}
	public SrvDictQuery setlabelLike(String labelLike){
		this.labelLike = labelLike;
		return this;
	}
	public String getlabelLike(){
		return this.labelLike;
	}
	public SrvDictQuery setlabelEquals(String labelEquals){
		this.labelEquals = labelEquals;
		return this;
	}
	public String getlabelEquals(){
		return this.labelEquals;
	}
	public SrvDictQuery setlabelIn(String[] labelIn){
		this.labelIn = labelIn;
		return this;
	}
	public String[] getlabelIn(){
		return this.labelIn;
	}
	public SrvDictQuery setlabelIsNull(Boolean labelIsNull){
		this.labelIsNull = labelIsNull;
		return this;
	}
	public Boolean getlabelIsNull(){
		return this.labelIsNull;
	}
	public SrvDictQuery setlabelIsNotNull(Boolean labelIsNotNull){
		this.labelIsNotNull = labelIsNotNull;
		return this;
	}
	public Boolean getlabelIsNotNull(){
		return this.labelIsNotNull;
	}
	public SrvDictQuery setlabelStart(String labelStart){
		this.labelStart = labelStart;
		return this;
	}
	public String getlabelStart(){
		return this.labelStart;
	}
	public SrvDictQuery setlabelEnd(String labelEnd){
		this.labelEnd = labelEnd;
		return this;
	}
	public String getlabelEnd(){
		return this.labelEnd;
	}
	public SrvDictQuery setlabelLess(String labelLess){
		this.labelLess = labelLess;
		return this;
	}
	public String getlabelLess(){
		return this.labelLess;
	}
	public SrvDictQuery setlabelGreater(String labelGreater){
		this.labelGreater = labelGreater;
		return this;
	}
	public String getlabelGreater(){
		return this.labelGreater;
	}
	public SrvDictQuery settypeLike(String typeLike){
		this.typeLike = typeLike;
		return this;
	}
	public String gettypeLike(){
		return this.typeLike;
	}
	public SrvDictQuery settypeEquals(String typeEquals){
		this.typeEquals = typeEquals;
		return this;
	}
	public String gettypeEquals(){
		return this.typeEquals;
	}
	public SrvDictQuery settypeIn(String[] typeIn){
		this.typeIn = typeIn;
		return this;
	}
	public String[] gettypeIn(){
		return this.typeIn;
	}
	public SrvDictQuery settypeIsNull(Boolean typeIsNull){
		this.typeIsNull = typeIsNull;
		return this;
	}
	public Boolean gettypeIsNull(){
		return this.typeIsNull;
	}
	public SrvDictQuery settypeIsNotNull(Boolean typeIsNotNull){
		this.typeIsNotNull = typeIsNotNull;
		return this;
	}
	public Boolean gettypeIsNotNull(){
		return this.typeIsNotNull;
	}
	public SrvDictQuery settypeStart(String typeStart){
		this.typeStart = typeStart;
		return this;
	}
	public String gettypeStart(){
		return this.typeStart;
	}
	public SrvDictQuery settypeEnd(String typeEnd){
		this.typeEnd = typeEnd;
		return this;
	}
	public String gettypeEnd(){
		return this.typeEnd;
	}
	public SrvDictQuery settypeLess(String typeLess){
		this.typeLess = typeLess;
		return this;
	}
	public String gettypeLess(){
		return this.typeLess;
	}
	public SrvDictQuery settypeGreater(String typeGreater){
		this.typeGreater = typeGreater;
		return this;
	}
	public String gettypeGreater(){
		return this.typeGreater;
	}
	public SrvDictQuery setdescriptionLike(String descriptionLike){
		this.descriptionLike = descriptionLike;
		return this;
	}
	public String getdescriptionLike(){
		return this.descriptionLike;
	}
	public SrvDictQuery setdescriptionEquals(String descriptionEquals){
		this.descriptionEquals = descriptionEquals;
		return this;
	}
	public String getdescriptionEquals(){
		return this.descriptionEquals;
	}
	public SrvDictQuery setdescriptionIn(String[] descriptionIn){
		this.descriptionIn = descriptionIn;
		return this;
	}
	public String[] getdescriptionIn(){
		return this.descriptionIn;
	}
	public SrvDictQuery setdescriptionIsNull(Boolean descriptionIsNull){
		this.descriptionIsNull = descriptionIsNull;
		return this;
	}
	public Boolean getdescriptionIsNull(){
		return this.descriptionIsNull;
	}
	public SrvDictQuery setdescriptionIsNotNull(Boolean descriptionIsNotNull){
		this.descriptionIsNotNull = descriptionIsNotNull;
		return this;
	}
	public Boolean getdescriptionIsNotNull(){
		return this.descriptionIsNotNull;
	}
	public SrvDictQuery setdescriptionStart(String descriptionStart){
		this.descriptionStart = descriptionStart;
		return this;
	}
	public String getdescriptionStart(){
		return this.descriptionStart;
	}
	public SrvDictQuery setdescriptionEnd(String descriptionEnd){
		this.descriptionEnd = descriptionEnd;
		return this;
	}
	public String getdescriptionEnd(){
		return this.descriptionEnd;
	}
	public SrvDictQuery setdescriptionLess(String descriptionLess){
		this.descriptionLess = descriptionLess;
		return this;
	}
	public String getdescriptionLess(){
		return this.descriptionLess;
	}
	public SrvDictQuery setdescriptionGreater(String descriptionGreater){
		this.descriptionGreater = descriptionGreater;
		return this;
	}
	public String getdescriptionGreater(){
		return this.descriptionGreater;
	}
	public SrvDictQuery setsortEquals(Integer sortEquals){
		this.sortEquals = sortEquals;
		return this;
	}
	public Integer getsortEquals(){
		return this.sortEquals;
	}
	public SrvDictQuery setsortIn(Integer[] sortIn){
		this.sortIn = sortIn;
		return this;
	}
	public Integer[] getsortIn(){
		return this.sortIn;
	}
	public SrvDictQuery setsortIsNull(Boolean sortIsNull){
		this.sortIsNull = sortIsNull;
		return this;
	}
	public Boolean getsortIsNull(){
		return this.sortIsNull;
	}
	public SrvDictQuery setsortIsNotNull(Boolean sortIsNotNull){
		this.sortIsNotNull = sortIsNotNull;
		return this;
	}
	public Boolean getsortIsNotNull(){
		return this.sortIsNotNull;
	}
	public SrvDictQuery setsortStart(Integer sortStart){
		this.sortStart = sortStart;
		return this;
	}
	public Integer getsortStart(){
		return this.sortStart;
	}
	public SrvDictQuery setsortEnd(Integer sortEnd){
		this.sortEnd = sortEnd;
		return this;
	}
	public Integer getsortEnd(){
		return this.sortEnd;
	}
	public SrvDictQuery setsortLess(Integer sortLess){
		this.sortLess = sortLess;
		return this;
	}
	public Integer getsortLess(){
		return this.sortLess;
	}
	public SrvDictQuery setsortGreater(Integer sortGreater){
		this.sortGreater = sortGreater;
		return this;
	}
	public Integer getsortGreater(){
		return this.sortGreater;
	}
	public SrvDictQuery setCreateByLike(String createByLike){
		this.createByLike = createByLike;
		return this;
	}
	public String getCreateByLike(){
		return this.createByLike;
	}
	public SrvDictQuery setCreateByEquals(String createByEquals){
		this.createByEquals = createByEquals;
		return this;
	}
	public String getCreateByEquals(){
		return this.createByEquals;
	}
	public SrvDictQuery setCreateByIn(String[] createByIn){
		this.createByIn = createByIn;
		return this;
	}
	public String[] getCreateByIn(){
		return this.createByIn;
	}
	public SrvDictQuery setCreateByIsNull(Boolean createByIsNull){
		this.createByIsNull = createByIsNull;
		return this;
	}
	public Boolean getCreateByIsNull(){
		return this.createByIsNull;
	}
	public SrvDictQuery setCreateByIsNotNull(Boolean createByIsNotNull){
		this.createByIsNotNull = createByIsNotNull;
		return this;
	}
	public Boolean getCreateByIsNotNull(){
		return this.createByIsNotNull;
	}
	public SrvDictQuery setCreateByStart(String createByStart){
		this.createByStart = createByStart;
		return this;
	}
	public String getCreateByStart(){
		return this.createByStart;
	}
	public SrvDictQuery setCreateByEnd(String createByEnd){
		this.createByEnd = createByEnd;
		return this;
	}
	public String getCreateByEnd(){
		return this.createByEnd;
	}
	public SrvDictQuery setCreateByLess(String createByLess){
		this.createByLess = createByLess;
		return this;
	}
	public String getCreateByLess(){
		return this.createByLess;
	}
	public SrvDictQuery setCreateByGreater(String createByGreater){
		this.createByGreater = createByGreater;
		return this;
	}
	public String getCreateByGreater(){
		return this.createByGreater;
	}
	public SrvDictQuery setCreateDateEquals(Date createDateEquals){
		this.createDateEquals = createDateEquals;
		return this;
	}
	public Date getCreateDateEquals(){
		return this.createDateEquals;
	}
	public SrvDictQuery setCreateDateIn(Date[] createDateIn){
		this.createDateIn = createDateIn;
		return this;
	}
	public Date[] getCreateDateIn(){
		return this.createDateIn;
	}
	public SrvDictQuery setCreateDateIsNull(Boolean createDateIsNull){
		this.createDateIsNull = createDateIsNull;
		return this;
	}
	public Boolean getCreateDateIsNull(){
		return this.createDateIsNull;
	}
	public SrvDictQuery setCreateDateIsNotNull(Boolean createDateIsNotNull){
		this.createDateIsNotNull = createDateIsNotNull;
		return this;
	}
	public Boolean getCreateDateIsNotNull(){
		return this.createDateIsNotNull;
	}
	public SrvDictQuery setCreateDateStart(Date createDateStart){
		this.createDateStart = createDateStart;
		return this;
	}
	public Date getCreateDateStart(){
		return this.createDateStart;
	}
	public SrvDictQuery setCreateDateEnd(Date createDateEnd){
		this.createDateEnd = createDateEnd;
		return this;
	}
	public Date getCreateDateEnd(){
		return this.createDateEnd;
	}
	public SrvDictQuery setCreateDateLess(Date createDateLess){
		this.createDateLess = createDateLess;
		return this;
	}
	public Date getCreateDateLess(){
		return this.createDateLess;
	}
	public SrvDictQuery setCreateDateGreater(Date createDateGreater){
		this.createDateGreater = createDateGreater;
		return this;
	}
	public Date getCreateDateGreater(){
		return this.createDateGreater;
	}
	public SrvDictQuery setUpdateByLike(String updateByLike){
		this.updateByLike = updateByLike;
		return this;
	}
	public String getUpdateByLike(){
		return this.updateByLike;
	}
	public SrvDictQuery setUpdateByEquals(String updateByEquals){
		this.updateByEquals = updateByEquals;
		return this;
	}
	public String getUpdateByEquals(){
		return this.updateByEquals;
	}
	public SrvDictQuery setUpdateByIn(String[] updateByIn){
		this.updateByIn = updateByIn;
		return this;
	}
	public String[] getUpdateByIn(){
		return this.updateByIn;
	}
	public SrvDictQuery setUpdateByIsNull(Boolean updateByIsNull){
		this.updateByIsNull = updateByIsNull;
		return this;
	}
	public Boolean getUpdateByIsNull(){
		return this.updateByIsNull;
	}
	public SrvDictQuery setUpdateByIsNotNull(Boolean updateByIsNotNull){
		this.updateByIsNotNull = updateByIsNotNull;
		return this;
	}
	public Boolean getUpdateByIsNotNull(){
		return this.updateByIsNotNull;
	}
	public SrvDictQuery setUpdateByStart(String updateByStart){
		this.updateByStart = updateByStart;
		return this;
	}
	public String getUpdateByStart(){
		return this.updateByStart;
	}
	public SrvDictQuery setUpdateByEnd(String updateByEnd){
		this.updateByEnd = updateByEnd;
		return this;
	}
	public String getUpdateByEnd(){
		return this.updateByEnd;
	}
	public SrvDictQuery setUpdateByLess(String updateByLess){
		this.updateByLess = updateByLess;
		return this;
	}
	public String getUpdateByLess(){
		return this.updateByLess;
	}
	public SrvDictQuery setUpdateByGreater(String updateByGreater){
		this.updateByGreater = updateByGreater;
		return this;
	}
	public String getUpdateByGreater(){
		return this.updateByGreater;
	}
	public SrvDictQuery setUpdateDateEquals(Date updateDateEquals){
		this.updateDateEquals = updateDateEquals;
		return this;
	}
	public Date getUpdateDateEquals(){
		return this.updateDateEquals;
	}
	public SrvDictQuery setUpdateDateIn(Date[] updateDateIn){
		this.updateDateIn = updateDateIn;
		return this;
	}
	public Date[] getUpdateDateIn(){
		return this.updateDateIn;
	}
	public SrvDictQuery setUpdateDateIsNull(Boolean updateDateIsNull){
		this.updateDateIsNull = updateDateIsNull;
		return this;
	}
	public Boolean getUpdateDateIsNull(){
		return this.updateDateIsNull;
	}
	public SrvDictQuery setUpdateDateIsNotNull(Boolean updateDateIsNotNull){
		this.updateDateIsNotNull = updateDateIsNotNull;
		return this;
	}
	public Boolean getUpdateDateIsNotNull(){
		return this.updateDateIsNotNull;
	}
	public SrvDictQuery setUpdateDateStart(Date updateDateStart){
		this.updateDateStart = updateDateStart;
		return this;
	}
	public Date getUpdateDateStart(){
		return this.updateDateStart;
	}
	public SrvDictQuery setUpdateDateEnd(Date updateDateEnd){
		this.updateDateEnd = updateDateEnd;
		return this;
	}
	public Date getUpdateDateEnd(){
		return this.updateDateEnd;
	}
	public SrvDictQuery setUpdateDateLess(Date updateDateLess){
		this.updateDateLess = updateDateLess;
		return this;
	}
	public Date getUpdateDateLess(){
		return this.updateDateLess;
	}
	public SrvDictQuery setUpdateDateGreater(Date updateDateGreater){
		this.updateDateGreater = updateDateGreater;
		return this;
	}
	public Date getUpdateDateGreater(){
		return this.updateDateGreater;
	}
	public SrvDictQuery setremarksLike(String remarksLike){
		this.remarksLike = remarksLike;
		return this;
	}
	public String getremarksLike(){
		return this.remarksLike;
	}
	public SrvDictQuery setremarksEquals(String remarksEquals){
		this.remarksEquals = remarksEquals;
		return this;
	}
	public String getremarksEquals(){
		return this.remarksEquals;
	}
	public SrvDictQuery setremarksIn(String[] remarksIn){
		this.remarksIn = remarksIn;
		return this;
	}
	public String[] getremarksIn(){
		return this.remarksIn;
	}
	public SrvDictQuery setremarksIsNull(Boolean remarksIsNull){
		this.remarksIsNull = remarksIsNull;
		return this;
	}
	public Boolean getremarksIsNull(){
		return this.remarksIsNull;
	}
	public SrvDictQuery setremarksIsNotNull(Boolean remarksIsNotNull){
		this.remarksIsNotNull = remarksIsNotNull;
		return this;
	}
	public Boolean getremarksIsNotNull(){
		return this.remarksIsNotNull;
	}
	public SrvDictQuery setremarksStart(String remarksStart){
		this.remarksStart = remarksStart;
		return this;
	}
	public String getremarksStart(){
		return this.remarksStart;
	}
	public SrvDictQuery setremarksEnd(String remarksEnd){
		this.remarksEnd = remarksEnd;
		return this;
	}
	public String getremarksEnd(){
		return this.remarksEnd;
	}
	public SrvDictQuery setremarksLess(String remarksLess){
		this.remarksLess = remarksLess;
		return this;
	}
	public String getremarksLess(){
		return this.remarksLess;
	}
	public SrvDictQuery setremarksGreater(String remarksGreater){
		this.remarksGreater = remarksGreater;
		return this;
	}
	public String getremarksGreater(){
		return this.remarksGreater;
	}
	public SrvDictQuery setDelFlagLike(String delFlagLike){
		this.delFlagLike = delFlagLike;
		return this;
	}
	public String getDelFlagLike(){
		return this.delFlagLike;
	}
	public SrvDictQuery setDelFlagEquals(String delFlagEquals){
		this.delFlagEquals = delFlagEquals;
		return this;
	}
	public String getDelFlagEquals(){
		return this.delFlagEquals;
	}
	public SrvDictQuery setDelFlagIn(String[] delFlagIn){
		this.delFlagIn = delFlagIn;
		return this;
	}
	public String[] getDelFlagIn(){
		return this.delFlagIn;
	}
	public SrvDictQuery setDelFlagIsNull(Boolean delFlagIsNull){
		this.delFlagIsNull = delFlagIsNull;
		return this;
	}
	public Boolean getDelFlagIsNull(){
		return this.delFlagIsNull;
	}
	public SrvDictQuery setDelFlagIsNotNull(Boolean delFlagIsNotNull){
		this.delFlagIsNotNull = delFlagIsNotNull;
		return this;
	}
	public Boolean getDelFlagIsNotNull(){
		return this.delFlagIsNotNull;
	}
	public SrvDictQuery setDelFlagStart(String delFlagStart){
		this.delFlagStart = delFlagStart;
		return this;
	}
	public String getDelFlagStart(){
		return this.delFlagStart;
	}
	public SrvDictQuery setDelFlagEnd(String delFlagEnd){
		this.delFlagEnd = delFlagEnd;
		return this;
	}
	public String getDelFlagEnd(){
		return this.delFlagEnd;
	}
	public SrvDictQuery setDelFlagLess(String delFlagLess){
		this.delFlagLess = delFlagLess;
		return this;
	}
	public String getDelFlagLess(){
		return this.delFlagLess;
	}
	public SrvDictQuery setDelFlagGreater(String delFlagGreater){
		this.delFlagGreater = delFlagGreater;
		return this;
	}
	public String getDelFlagGreater(){
		return this.delFlagGreater;
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
		else if(this.sidx.equals("value")){
			return "value";
		}
		else if(this.sidx.equals("label")){
			return "label";
		}
		else if(this.sidx.equals("type")){
			return "type";
		}
		else if(this.sidx.equals("description")){
			return "description";
		}
		else if(this.sidx.equals("sort")){
			return "sort";
		}
		else if(this.sidx.equals("createBy")){
			return "create_by";
		}
		else if(this.sidx.equals("createDate")){
			return "create_date";
		}
		else if(this.sidx.equals("updateBy")){
			return "update_by";
		}
		else if(this.sidx.equals("updateDate")){
			return "update_date";
		}
		else if(this.sidx.equals("remarks")){
			return "remarks";
		}
		else if(this.sidx.equals("delFlag")){
			return "del_flag";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public SrvDictCrieria getCrieria(){
		SrvDictCrieria q = new SrvDictCrieria();
		SrvDictCrieria.Criteria c = q.createCriteria();
		
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
		if(this.getvalueEquals()!=null){
			c.andvalueEqualTo(this.getvalueEquals());
		}else if(this.getvalueIsNull()!=null && this.getvalueIsNull()){
			c.andvalueIsNull();
		}else if(this.getvalueIsNotNull()!=null && this.getvalueIsNotNull()){
			c.andvalueIsNotNull();
		}else if(this.getvalueLike()!=null){
			c.andvalueLike(this.getvalueLike());
		}else if(this.getvalueIn()!=null){
			c.andvalueIn(java.util.Arrays.asList(this.getvalueIn()));
		}else if(this.getvalueStart()!=null && this.getvalueEnd()!=null){
			c.andvalueBetween(this.getvalueStart(), this.getvalueEnd());
		}else if(this.getvalueGreater()!=null){
			c.andvalueGreaterThan(this.getvalueGreater());
		}else if(this.getvalueLess()!=null){
			c.andvalueLessThan(this.getvalueLess());
		}
		if(this.getlabelEquals()!=null){
			c.andlabelEqualTo(this.getlabelEquals());
		}else if(this.getlabelIsNull()!=null && this.getlabelIsNull()){
			c.andlabelIsNull();
		}else if(this.getlabelIsNotNull()!=null && this.getlabelIsNotNull()){
			c.andlabelIsNotNull();
		}else if(this.getlabelLike()!=null){
			c.andlabelLike(this.getlabelLike());
		}else if(this.getlabelIn()!=null){
			c.andlabelIn(java.util.Arrays.asList(this.getlabelIn()));
		}else if(this.getlabelStart()!=null && this.getlabelEnd()!=null){
			c.andlabelBetween(this.getlabelStart(), this.getlabelEnd());
		}else if(this.getlabelGreater()!=null){
			c.andlabelGreaterThan(this.getlabelGreater());
		}else if(this.getlabelLess()!=null){
			c.andlabelLessThan(this.getlabelLess());
		}
		if(this.gettypeEquals()!=null){
			c.andtypeEqualTo(this.gettypeEquals());
		}else if(this.gettypeIsNull()!=null && this.gettypeIsNull()){
			c.andtypeIsNull();
		}else if(this.gettypeIsNotNull()!=null && this.gettypeIsNotNull()){
			c.andtypeIsNotNull();
		}else if(this.gettypeLike()!=null){
			c.andtypeLike(this.gettypeLike());
		}else if(this.gettypeIn()!=null){
			c.andtypeIn(java.util.Arrays.asList(this.gettypeIn()));
		}else if(this.gettypeStart()!=null && this.gettypeEnd()!=null){
			c.andtypeBetween(this.gettypeStart(), this.gettypeEnd());
		}else if(this.gettypeGreater()!=null){
			c.andtypeGreaterThan(this.gettypeGreater());
		}else if(this.gettypeLess()!=null){
			c.andtypeLessThan(this.gettypeLess());
		}
		if(this.getdescriptionEquals()!=null){
			c.anddescriptionEqualTo(this.getdescriptionEquals());
		}else if(this.getdescriptionIsNull()!=null && this.getdescriptionIsNull()){
			c.anddescriptionIsNull();
		}else if(this.getdescriptionIsNotNull()!=null && this.getdescriptionIsNotNull()){
			c.anddescriptionIsNotNull();
		}else if(this.getdescriptionLike()!=null){
			c.anddescriptionLike(this.getdescriptionLike());
		}else if(this.getdescriptionIn()!=null){
			c.anddescriptionIn(java.util.Arrays.asList(this.getdescriptionIn()));
		}else if(this.getdescriptionStart()!=null && this.getdescriptionEnd()!=null){
			c.anddescriptionBetween(this.getdescriptionStart(), this.getdescriptionEnd());
		}else if(this.getdescriptionGreater()!=null){
			c.anddescriptionGreaterThan(this.getdescriptionGreater());
		}else if(this.getdescriptionLess()!=null){
			c.anddescriptionLessThan(this.getdescriptionLess());
		}
		if(this.getsortEquals()!=null){
			c.andsortEqualTo(this.getsortEquals());
		}else if(this.getsortIsNull()!=null && this.getsortIsNull()){
			c.andsortIsNull();
		}else if(this.getsortIsNotNull()!=null && this.getsortIsNotNull()){
			c.andsortIsNotNull();
		}else if(this.getsortIn()!=null){
			c.andsortIn(java.util.Arrays.asList(this.getsortIn()));
		}else if(this.getsortStart()!=null && this.getsortEnd()!=null){
			c.andsortBetween(this.getsortStart(), this.getsortEnd());
		}else if(this.getsortGreater()!=null){
			c.andsortGreaterThan(this.getsortGreater());
		}else if(this.getsortLess()!=null){
			c.andsortLessThan(this.getsortLess());
		}
		if(this.getCreateByEquals()!=null){
			c.andcreateByEqualTo(this.getCreateByEquals());
		}else if(this.getCreateByIsNull()!=null && this.getCreateByIsNull()){
			c.andcreateByIsNull();
		}else if(this.getCreateByIsNotNull()!=null && this.getCreateByIsNotNull()){
			c.andcreateByIsNotNull();
		}else if(this.getCreateByLike()!=null){
			c.andcreateByLike(this.getCreateByLike());
		}else if(this.getCreateByIn()!=null){
			c.andcreateByIn(java.util.Arrays.asList(this.getCreateByIn()));
		}else if(this.getCreateByStart()!=null && this.getCreateByEnd()!=null){
			c.andcreateByBetween(this.getCreateByStart(), this.getCreateByEnd());
		}else if(this.getCreateByGreater()!=null){
			c.andcreateByGreaterThan(this.getCreateByGreater());
		}else if(this.getCreateByLess()!=null){
			c.andcreateByLessThan(this.getCreateByLess());
		}
		if(this.getCreateDateEquals()!=null){
			c.andcreateDateEqualTo(this.getCreateDateEquals());
		}else if(this.getCreateDateIsNull()!=null && this.getCreateDateIsNull()){
			c.andcreateDateIsNull();
		}else if(this.getCreateDateIsNotNull()!=null && this.getCreateDateIsNotNull()){
			c.andcreateDateIsNotNull();
		}else if(this.getCreateDateIn()!=null){
			c.andcreateDateIn(java.util.Arrays.asList(this.getCreateDateIn()));
		}else if(this.getCreateDateStart()!=null && this.getCreateDateEnd()!=null){
			c.andcreateDateBetween(this.getCreateDateStart(), this.getCreateDateEnd());
		}else if(this.getCreateDateGreater()!=null){
			c.andcreateDateGreaterThan(this.getCreateDateGreater());
		}else if(this.getCreateDateLess()!=null){
			c.andcreateDateLessThan(this.getCreateDateLess());
		}
		if(this.getUpdateByEquals()!=null){
			c.andupdateByEqualTo(this.getUpdateByEquals());
		}else if(this.getUpdateByIsNull()!=null && this.getUpdateByIsNull()){
			c.andupdateByIsNull();
		}else if(this.getUpdateByIsNotNull()!=null && this.getUpdateByIsNotNull()){
			c.andupdateByIsNotNull();
		}else if(this.getUpdateByLike()!=null){
			c.andupdateByLike(this.getUpdateByLike());
		}else if(this.getUpdateByIn()!=null){
			c.andupdateByIn(java.util.Arrays.asList(this.getUpdateByIn()));
		}else if(this.getUpdateByStart()!=null && this.getUpdateByEnd()!=null){
			c.andupdateByBetween(this.getUpdateByStart(), this.getUpdateByEnd());
		}else if(this.getUpdateByGreater()!=null){
			c.andupdateByGreaterThan(this.getUpdateByGreater());
		}else if(this.getUpdateByLess()!=null){
			c.andupdateByLessThan(this.getUpdateByLess());
		}
		if(this.getUpdateDateEquals()!=null){
			c.andupdateDateEqualTo(this.getUpdateDateEquals());
		}else if(this.getUpdateDateIsNull()!=null && this.getUpdateDateIsNull()){
			c.andupdateDateIsNull();
		}else if(this.getUpdateDateIsNotNull()!=null && this.getUpdateDateIsNotNull()){
			c.andupdateDateIsNotNull();
		}else if(this.getUpdateDateIn()!=null){
			c.andupdateDateIn(java.util.Arrays.asList(this.getUpdateDateIn()));
		}else if(this.getUpdateDateStart()!=null && this.getUpdateDateEnd()!=null){
			c.andupdateDateBetween(this.getUpdateDateStart(), this.getUpdateDateEnd());
		}else if(this.getUpdateDateGreater()!=null){
			c.andupdateDateGreaterThan(this.getUpdateDateGreater());
		}else if(this.getUpdateDateLess()!=null){
			c.andupdateDateLessThan(this.getUpdateDateLess());
		}
		if(this.getremarksEquals()!=null){
			c.andremarksEqualTo(this.getremarksEquals());
		}else if(this.getremarksIsNull()!=null && this.getremarksIsNull()){
			c.andremarksIsNull();
		}else if(this.getremarksIsNotNull()!=null && this.getremarksIsNotNull()){
			c.andremarksIsNotNull();
		}else if(this.getremarksLike()!=null){
			c.andremarksLike(this.getremarksLike());
		}else if(this.getremarksIn()!=null){
			c.andremarksIn(java.util.Arrays.asList(this.getremarksIn()));
		}else if(this.getremarksStart()!=null && this.getremarksEnd()!=null){
			c.andremarksBetween(this.getremarksStart(), this.getremarksEnd());
		}else if(this.getremarksGreater()!=null){
			c.andremarksGreaterThan(this.getremarksGreater());
		}else if(this.getremarksLess()!=null){
			c.andremarksLessThan(this.getremarksLess());
		}
		if(this.getDelFlagEquals()!=null){
			c.anddelFlagEqualTo(this.getDelFlagEquals());
		}else if(this.getDelFlagIsNull()!=null && this.getDelFlagIsNull()){
			c.anddelFlagIsNull();
		}else if(this.getDelFlagIsNotNull()!=null && this.getDelFlagIsNotNull()){
			c.anddelFlagIsNotNull();
		}else if(this.getDelFlagLike()!=null){
			c.anddelFlagLike(this.getDelFlagLike());
		}else if(this.getDelFlagIn()!=null){
			c.anddelFlagIn(java.util.Arrays.asList(this.getDelFlagIn()));
		}else if(this.getDelFlagStart()!=null && this.getDelFlagEnd()!=null){
			c.anddelFlagBetween(this.getDelFlagStart(), this.getDelFlagEnd());
		}else if(this.getDelFlagGreater()!=null){
			c.anddelFlagGreaterThan(this.getDelFlagGreater());
		}else if(this.getDelFlagLess()!=null){
			c.anddelFlagLessThan(this.getDelFlagLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
