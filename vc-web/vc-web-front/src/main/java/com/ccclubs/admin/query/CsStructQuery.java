package com.ccclubs.admin.query;

import com.ccclubs.admin.entity.CsStructCrieria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class CsStructQuery {
	
	private Long cssIdEquals;
	private Long[] cssIdIn;
	private Boolean cssIdIsNull;
	private Boolean cssIdIsNotNull;
	
	private Long cssIdStart;
	
	private Long cssIdEnd;
	
	private Long cssIdLess;
	
	private Long cssIdGreater;
	private String cssNameLike;
	
	private String cssNameEquals;
	private String[] cssNameIn;
	private Boolean cssNameIsNull;
	private Boolean cssNameIsNotNull;
	
	private String cssNameStart;
	
	private String cssNameEnd;
	
	private String cssNameLess;
	
	private String cssNameGreater;
	
	private Short cssTypeEquals;
	private Short[] cssTypeIn;
	private Boolean cssTypeIsNull;
	private Boolean cssTypeIsNotNull;
	
	private Short cssTypeStart;
	
	private Short cssTypeEnd;
	
	private Short cssTypeLess;
	
	private Short cssTypeGreater;
	private String cssReqCodeLike;
	
	private String cssReqCodeEquals;
	private String[] cssReqCodeIn;
	private Boolean cssReqCodeIsNull;
	private Boolean cssReqCodeIsNotNull;
	
	private String cssReqCodeStart;
	
	private String cssReqCodeEnd;
	
	private String cssReqCodeLess;
	
	private String cssReqCodeGreater;
	private String cssRequestLike;
	
	private String cssRequestEquals;
	private String[] cssRequestIn;
	private Boolean cssRequestIsNull;
	private Boolean cssRequestIsNotNull;
	
	private String cssRequestStart;
	
	private String cssRequestEnd;
	
	private String cssRequestLess;
	
	private String cssRequestGreater;
	private String cssRepCodeLike;
	
	private String cssRepCodeEquals;
	private String[] cssRepCodeIn;
	private Boolean cssRepCodeIsNull;
	private Boolean cssRepCodeIsNotNull;
	
	private String cssRepCodeStart;
	
	private String cssRepCodeEnd;
	
	private String cssRepCodeLess;
	
	private String cssRepCodeGreater;
	private String cssResponseLike;
	
	private String cssResponseEquals;
	private String[] cssResponseIn;
	private Boolean cssResponseIsNull;
	private Boolean cssResponseIsNotNull;
	
	private String cssResponseStart;
	
	private String cssResponseEnd;
	
	private String cssResponseLess;
	
	private String cssResponseGreater;
	
	private Short cssStatusEquals;
	private Short[] cssStatusIn;
	private Boolean cssStatusIsNull;
	private Boolean cssStatusIsNotNull;
	
	private Short cssStatusStart;
	
	private Short cssStatusEnd;
	
	private Short cssStatusLess;
	
	private Short cssStatusGreater;
	private String sidx;
	private String sord;

	public CsStructQuery setCssIdEquals(Long cssIdEquals){
		this.cssIdEquals = cssIdEquals;
		return this;
	}
	public Long getCssIdEquals(){
		return this.cssIdEquals;
	}
	public CsStructQuery setCssIdIn(Long[] cssIdIn){
		this.cssIdIn = cssIdIn;
		return this;
	}
	public Long[] getCssIdIn(){
		return this.cssIdIn;
	}
	public CsStructQuery setCssIdIsNull(Boolean cssIdIsNull){
		this.cssIdIsNull = cssIdIsNull;
		return this;
	}
	public Boolean getCssIdIsNull(){
		return this.cssIdIsNull;
	}
	public CsStructQuery setCssIdIsNotNull(Boolean cssIdIsNotNull){
		this.cssIdIsNotNull = cssIdIsNotNull;
		return this;
	}
	public Boolean getCssIdIsNotNull(){
		return this.cssIdIsNotNull;
	}
	public CsStructQuery setCssIdStart(Long cssIdStart){
		this.cssIdStart = cssIdStart;
		return this;
	}
	public Long getCssIdStart(){
		return this.cssIdStart;
	}
	public CsStructQuery setCssIdEnd(Long cssIdEnd){
		this.cssIdEnd = cssIdEnd;
		return this;
	}
	public Long getCssIdEnd(){
		return this.cssIdEnd;
	}
	public CsStructQuery setCssIdLess(Long cssIdLess){
		this.cssIdLess = cssIdLess;
		return this;
	}
	public Long getCssIdLess(){
		return this.cssIdLess;
	}
	public CsStructQuery setCssIdGreater(Long cssIdGreater){
		this.cssIdGreater = cssIdGreater;
		return this;
	}
	public Long getCssIdGreater(){
		return this.cssIdGreater;
	}
	public CsStructQuery setCssNameLike(String cssNameLike){
		this.cssNameLike = cssNameLike;
		return this;
	}
	public String getCssNameLike(){
		return this.cssNameLike;
	}
	public CsStructQuery setCssNameEquals(String cssNameEquals){
		this.cssNameEquals = cssNameEquals;
		return this;
	}
	public String getCssNameEquals(){
		return this.cssNameEquals;
	}
	public CsStructQuery setCssNameIn(String[] cssNameIn){
		this.cssNameIn = cssNameIn;
		return this;
	}
	public String[] getCssNameIn(){
		return this.cssNameIn;
	}
	public CsStructQuery setCssNameIsNull(Boolean cssNameIsNull){
		this.cssNameIsNull = cssNameIsNull;
		return this;
	}
	public Boolean getCssNameIsNull(){
		return this.cssNameIsNull;
	}
	public CsStructQuery setCssNameIsNotNull(Boolean cssNameIsNotNull){
		this.cssNameIsNotNull = cssNameIsNotNull;
		return this;
	}
	public Boolean getCssNameIsNotNull(){
		return this.cssNameIsNotNull;
	}
	public CsStructQuery setCssNameStart(String cssNameStart){
		this.cssNameStart = cssNameStart;
		return this;
	}
	public String getCssNameStart(){
		return this.cssNameStart;
	}
	public CsStructQuery setCssNameEnd(String cssNameEnd){
		this.cssNameEnd = cssNameEnd;
		return this;
	}
	public String getCssNameEnd(){
		return this.cssNameEnd;
	}
	public CsStructQuery setCssNameLess(String cssNameLess){
		this.cssNameLess = cssNameLess;
		return this;
	}
	public String getCssNameLess(){
		return this.cssNameLess;
	}
	public CsStructQuery setCssNameGreater(String cssNameGreater){
		this.cssNameGreater = cssNameGreater;
		return this;
	}
	public String getCssNameGreater(){
		return this.cssNameGreater;
	}
	public CsStructQuery setCssTypeEquals(Short cssTypeEquals){
		this.cssTypeEquals = cssTypeEquals;
		return this;
	}
	public Short getCssTypeEquals(){
		return this.cssTypeEquals;
	}
	public CsStructQuery setCssTypeIn(Short[] cssTypeIn){
		this.cssTypeIn = cssTypeIn;
		return this;
	}
	public Short[] getCssTypeIn(){
		return this.cssTypeIn;
	}
	public CsStructQuery setCssTypeIsNull(Boolean cssTypeIsNull){
		this.cssTypeIsNull = cssTypeIsNull;
		return this;
	}
	public Boolean getCssTypeIsNull(){
		return this.cssTypeIsNull;
	}
	public CsStructQuery setCssTypeIsNotNull(Boolean cssTypeIsNotNull){
		this.cssTypeIsNotNull = cssTypeIsNotNull;
		return this;
	}
	public Boolean getCssTypeIsNotNull(){
		return this.cssTypeIsNotNull;
	}
	public CsStructQuery setCssTypeStart(Short cssTypeStart){
		this.cssTypeStart = cssTypeStart;
		return this;
	}
	public Short getCssTypeStart(){
		return this.cssTypeStart;
	}
	public CsStructQuery setCssTypeEnd(Short cssTypeEnd){
		this.cssTypeEnd = cssTypeEnd;
		return this;
	}
	public Short getCssTypeEnd(){
		return this.cssTypeEnd;
	}
	public CsStructQuery setCssTypeLess(Short cssTypeLess){
		this.cssTypeLess = cssTypeLess;
		return this;
	}
	public Short getCssTypeLess(){
		return this.cssTypeLess;
	}
	public CsStructQuery setCssTypeGreater(Short cssTypeGreater){
		this.cssTypeGreater = cssTypeGreater;
		return this;
	}
	public Short getCssTypeGreater(){
		return this.cssTypeGreater;
	}
	public CsStructQuery setCssReqCodeLike(String cssReqCodeLike){
		this.cssReqCodeLike = cssReqCodeLike;
		return this;
	}
	public String getCssReqCodeLike(){
		return this.cssReqCodeLike;
	}
	public CsStructQuery setCssReqCodeEquals(String cssReqCodeEquals){
		this.cssReqCodeEquals = cssReqCodeEquals;
		return this;
	}
	public String getCssReqCodeEquals(){
		return this.cssReqCodeEquals;
	}
	public CsStructQuery setCssReqCodeIn(String[] cssReqCodeIn){
		this.cssReqCodeIn = cssReqCodeIn;
		return this;
	}
	public String[] getCssReqCodeIn(){
		return this.cssReqCodeIn;
	}
	public CsStructQuery setCssReqCodeIsNull(Boolean cssReqCodeIsNull){
		this.cssReqCodeIsNull = cssReqCodeIsNull;
		return this;
	}
	public Boolean getCssReqCodeIsNull(){
		return this.cssReqCodeIsNull;
	}
	public CsStructQuery setCssReqCodeIsNotNull(Boolean cssReqCodeIsNotNull){
		this.cssReqCodeIsNotNull = cssReqCodeIsNotNull;
		return this;
	}
	public Boolean getCssReqCodeIsNotNull(){
		return this.cssReqCodeIsNotNull;
	}
	public CsStructQuery setCssReqCodeStart(String cssReqCodeStart){
		this.cssReqCodeStart = cssReqCodeStart;
		return this;
	}
	public String getCssReqCodeStart(){
		return this.cssReqCodeStart;
	}
	public CsStructQuery setCssReqCodeEnd(String cssReqCodeEnd){
		this.cssReqCodeEnd = cssReqCodeEnd;
		return this;
	}
	public String getCssReqCodeEnd(){
		return this.cssReqCodeEnd;
	}
	public CsStructQuery setCssReqCodeLess(String cssReqCodeLess){
		this.cssReqCodeLess = cssReqCodeLess;
		return this;
	}
	public String getCssReqCodeLess(){
		return this.cssReqCodeLess;
	}
	public CsStructQuery setCssReqCodeGreater(String cssReqCodeGreater){
		this.cssReqCodeGreater = cssReqCodeGreater;
		return this;
	}
	public String getCssReqCodeGreater(){
		return this.cssReqCodeGreater;
	}
	public CsStructQuery setCssRequestLike(String cssRequestLike){
		this.cssRequestLike = cssRequestLike;
		return this;
	}
	public String getCssRequestLike(){
		return this.cssRequestLike;
	}
	public CsStructQuery setCssRequestEquals(String cssRequestEquals){
		this.cssRequestEquals = cssRequestEquals;
		return this;
	}
	public String getCssRequestEquals(){
		return this.cssRequestEquals;
	}
	public CsStructQuery setCssRequestIn(String[] cssRequestIn){
		this.cssRequestIn = cssRequestIn;
		return this;
	}
	public String[] getCssRequestIn(){
		return this.cssRequestIn;
	}
	public CsStructQuery setCssRequestIsNull(Boolean cssRequestIsNull){
		this.cssRequestIsNull = cssRequestIsNull;
		return this;
	}
	public Boolean getCssRequestIsNull(){
		return this.cssRequestIsNull;
	}
	public CsStructQuery setCssRequestIsNotNull(Boolean cssRequestIsNotNull){
		this.cssRequestIsNotNull = cssRequestIsNotNull;
		return this;
	}
	public Boolean getCssRequestIsNotNull(){
		return this.cssRequestIsNotNull;
	}
	public CsStructQuery setCssRequestStart(String cssRequestStart){
		this.cssRequestStart = cssRequestStart;
		return this;
	}
	public String getCssRequestStart(){
		return this.cssRequestStart;
	}
	public CsStructQuery setCssRequestEnd(String cssRequestEnd){
		this.cssRequestEnd = cssRequestEnd;
		return this;
	}
	public String getCssRequestEnd(){
		return this.cssRequestEnd;
	}
	public CsStructQuery setCssRequestLess(String cssRequestLess){
		this.cssRequestLess = cssRequestLess;
		return this;
	}
	public String getCssRequestLess(){
		return this.cssRequestLess;
	}
	public CsStructQuery setCssRequestGreater(String cssRequestGreater){
		this.cssRequestGreater = cssRequestGreater;
		return this;
	}
	public String getCssRequestGreater(){
		return this.cssRequestGreater;
	}
	public CsStructQuery setCssRepCodeLike(String cssRepCodeLike){
		this.cssRepCodeLike = cssRepCodeLike;
		return this;
	}
	public String getCssRepCodeLike(){
		return this.cssRepCodeLike;
	}
	public CsStructQuery setCssRepCodeEquals(String cssRepCodeEquals){
		this.cssRepCodeEquals = cssRepCodeEquals;
		return this;
	}
	public String getCssRepCodeEquals(){
		return this.cssRepCodeEquals;
	}
	public CsStructQuery setCssRepCodeIn(String[] cssRepCodeIn){
		this.cssRepCodeIn = cssRepCodeIn;
		return this;
	}
	public String[] getCssRepCodeIn(){
		return this.cssRepCodeIn;
	}
	public CsStructQuery setCssRepCodeIsNull(Boolean cssRepCodeIsNull){
		this.cssRepCodeIsNull = cssRepCodeIsNull;
		return this;
	}
	public Boolean getCssRepCodeIsNull(){
		return this.cssRepCodeIsNull;
	}
	public CsStructQuery setCssRepCodeIsNotNull(Boolean cssRepCodeIsNotNull){
		this.cssRepCodeIsNotNull = cssRepCodeIsNotNull;
		return this;
	}
	public Boolean getCssRepCodeIsNotNull(){
		return this.cssRepCodeIsNotNull;
	}
	public CsStructQuery setCssRepCodeStart(String cssRepCodeStart){
		this.cssRepCodeStart = cssRepCodeStart;
		return this;
	}
	public String getCssRepCodeStart(){
		return this.cssRepCodeStart;
	}
	public CsStructQuery setCssRepCodeEnd(String cssRepCodeEnd){
		this.cssRepCodeEnd = cssRepCodeEnd;
		return this;
	}
	public String getCssRepCodeEnd(){
		return this.cssRepCodeEnd;
	}
	public CsStructQuery setCssRepCodeLess(String cssRepCodeLess){
		this.cssRepCodeLess = cssRepCodeLess;
		return this;
	}
	public String getCssRepCodeLess(){
		return this.cssRepCodeLess;
	}
	public CsStructQuery setCssRepCodeGreater(String cssRepCodeGreater){
		this.cssRepCodeGreater = cssRepCodeGreater;
		return this;
	}
	public String getCssRepCodeGreater(){
		return this.cssRepCodeGreater;
	}
	public CsStructQuery setCssResponseLike(String cssResponseLike){
		this.cssResponseLike = cssResponseLike;
		return this;
	}
	public String getCssResponseLike(){
		return this.cssResponseLike;
	}
	public CsStructQuery setCssResponseEquals(String cssResponseEquals){
		this.cssResponseEquals = cssResponseEquals;
		return this;
	}
	public String getCssResponseEquals(){
		return this.cssResponseEquals;
	}
	public CsStructQuery setCssResponseIn(String[] cssResponseIn){
		this.cssResponseIn = cssResponseIn;
		return this;
	}
	public String[] getCssResponseIn(){
		return this.cssResponseIn;
	}
	public CsStructQuery setCssResponseIsNull(Boolean cssResponseIsNull){
		this.cssResponseIsNull = cssResponseIsNull;
		return this;
	}
	public Boolean getCssResponseIsNull(){
		return this.cssResponseIsNull;
	}
	public CsStructQuery setCssResponseIsNotNull(Boolean cssResponseIsNotNull){
		this.cssResponseIsNotNull = cssResponseIsNotNull;
		return this;
	}
	public Boolean getCssResponseIsNotNull(){
		return this.cssResponseIsNotNull;
	}
	public CsStructQuery setCssResponseStart(String cssResponseStart){
		this.cssResponseStart = cssResponseStart;
		return this;
	}
	public String getCssResponseStart(){
		return this.cssResponseStart;
	}
	public CsStructQuery setCssResponseEnd(String cssResponseEnd){
		this.cssResponseEnd = cssResponseEnd;
		return this;
	}
	public String getCssResponseEnd(){
		return this.cssResponseEnd;
	}
	public CsStructQuery setCssResponseLess(String cssResponseLess){
		this.cssResponseLess = cssResponseLess;
		return this;
	}
	public String getCssResponseLess(){
		return this.cssResponseLess;
	}
	public CsStructQuery setCssResponseGreater(String cssResponseGreater){
		this.cssResponseGreater = cssResponseGreater;
		return this;
	}
	public String getCssResponseGreater(){
		return this.cssResponseGreater;
	}
	public CsStructQuery setCssStatusEquals(Short cssStatusEquals){
		this.cssStatusEquals = cssStatusEquals;
		return this;
	}
	public Short getCssStatusEquals(){
		return this.cssStatusEquals;
	}
	public CsStructQuery setCssStatusIn(Short[] cssStatusIn){
		this.cssStatusIn = cssStatusIn;
		return this;
	}
	public Short[] getCssStatusIn(){
		return this.cssStatusIn;
	}
	public CsStructQuery setCssStatusIsNull(Boolean cssStatusIsNull){
		this.cssStatusIsNull = cssStatusIsNull;
		return this;
	}
	public Boolean getCssStatusIsNull(){
		return this.cssStatusIsNull;
	}
	public CsStructQuery setCssStatusIsNotNull(Boolean cssStatusIsNotNull){
		this.cssStatusIsNotNull = cssStatusIsNotNull;
		return this;
	}
	public Boolean getCssStatusIsNotNull(){
		return this.cssStatusIsNotNull;
	}
	public CsStructQuery setCssStatusStart(Short cssStatusStart){
		this.cssStatusStart = cssStatusStart;
		return this;
	}
	public Short getCssStatusStart(){
		return this.cssStatusStart;
	}
	public CsStructQuery setCssStatusEnd(Short cssStatusEnd){
		this.cssStatusEnd = cssStatusEnd;
		return this;
	}
	public Short getCssStatusEnd(){
		return this.cssStatusEnd;
	}
	public CsStructQuery setCssStatusLess(Short cssStatusLess){
		this.cssStatusLess = cssStatusLess;
		return this;
	}
	public Short getCssStatusLess(){
		return this.cssStatusLess;
	}
	public CsStructQuery setCssStatusGreater(Short cssStatusGreater){
		this.cssStatusGreater = cssStatusGreater;
		return this;
	}
	public Short getCssStatusGreater(){
		return this.cssStatusGreater;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("cssId")){
			return "css_id";
		}
		else if(this.sidx.equals("cssName")){
			return "css_name";
		}
		else if(this.sidx.equals("cssType")){
			return "css_type";
		}
		else if(this.sidx.equals("cssReqCode")){
			return "css_req_code";
		}
		else if(this.sidx.equals("cssRequest")){
			return "css_request";
		}
		else if(this.sidx.equals("cssRepCode")){
			return "css_rep_code";
		}
		else if(this.sidx.equals("cssResponse")){
			return "css_response";
		}
		else if(this.sidx.equals("cssStatus")){
			return "css_status";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}
	
	public CsStructCrieria getCrieria(){
		CsStructCrieria q = new CsStructCrieria();
		CsStructCrieria.Criteria c = q.createCriteria();
		
		if(this.getCssIdEquals()!=null){
			c.andcssIdEqualTo(this.getCssIdEquals());
		}else if(this.getCssIdIsNull()!=null && this.getCssIdIsNull()){
			c.andcssIdIsNull();
		}else if(this.getCssIdIsNotNull()!=null && this.getCssIdIsNotNull()){
			c.andcssIdIsNotNull();
		}else if(this.getCssIdIn()!=null){
			c.andcssIdIn(java.util.Arrays.asList(this.getCssIdIn()));
		}else if(this.getCssIdStart()!=null && this.getCssIdEnd()!=null){
			c.andcssIdBetween(this.getCssIdStart(), this.getCssIdEnd());
		}else if(this.getCssIdGreater()!=null){
			c.andcssIdGreaterThan(this.getCssIdGreater());
		}else if(this.getCssIdLess()!=null){
			c.andcssIdLessThan(this.getCssIdLess());
		}
		if(this.getCssNameEquals()!=null){
			c.andcssNameEqualTo(this.getCssNameEquals());
		}else if(this.getCssNameIsNull()!=null && this.getCssNameIsNull()){
			c.andcssNameIsNull();
		}else if(this.getCssNameIsNotNull()!=null && this.getCssNameIsNotNull()){
			c.andcssNameIsNotNull();
		}else if(this.getCssNameLike()!=null){
			c.andcssNameLike(this.getCssNameLike());
		}else if(this.getCssNameIn()!=null){
			c.andcssNameIn(java.util.Arrays.asList(this.getCssNameIn()));
		}else if(this.getCssNameStart()!=null && this.getCssNameEnd()!=null){
			c.andcssNameBetween(this.getCssNameStart(), this.getCssNameEnd());
		}else if(this.getCssNameGreater()!=null){
			c.andcssNameGreaterThan(this.getCssNameGreater());
		}else if(this.getCssNameLess()!=null){
			c.andcssNameLessThan(this.getCssNameLess());
		}
		if(this.getCssTypeEquals()!=null){
			c.andcssTypeEqualTo(this.getCssTypeEquals());
		}else if(this.getCssTypeIsNull()!=null && this.getCssTypeIsNull()){
			c.andcssTypeIsNull();
		}else if(this.getCssTypeIsNotNull()!=null && this.getCssTypeIsNotNull()){
			c.andcssTypeIsNotNull();
		}else if(this.getCssTypeIn()!=null){
			c.andcssTypeIn(java.util.Arrays.asList(this.getCssTypeIn()));
		}else if(this.getCssTypeStart()!=null && this.getCssTypeEnd()!=null){
			c.andcssTypeBetween(this.getCssTypeStart(), this.getCssTypeEnd());
		}else if(this.getCssTypeGreater()!=null){
			c.andcssTypeGreaterThan(this.getCssTypeGreater());
		}else if(this.getCssTypeLess()!=null){
			c.andcssTypeLessThan(this.getCssTypeLess());
		}
		if(this.getCssReqCodeEquals()!=null){
			c.andcssReqCodeEqualTo(this.getCssReqCodeEquals());
		}else if(this.getCssReqCodeIsNull()!=null && this.getCssReqCodeIsNull()){
			c.andcssReqCodeIsNull();
		}else if(this.getCssReqCodeIsNotNull()!=null && this.getCssReqCodeIsNotNull()){
			c.andcssReqCodeIsNotNull();
		}else if(this.getCssReqCodeLike()!=null){
			c.andcssReqCodeLike(this.getCssReqCodeLike());
		}else if(this.getCssReqCodeIn()!=null){
			c.andcssReqCodeIn(java.util.Arrays.asList(this.getCssReqCodeIn()));
		}else if(this.getCssReqCodeStart()!=null && this.getCssReqCodeEnd()!=null){
			c.andcssReqCodeBetween(this.getCssReqCodeStart(), this.getCssReqCodeEnd());
		}else if(this.getCssReqCodeGreater()!=null){
			c.andcssReqCodeGreaterThan(this.getCssReqCodeGreater());
		}else if(this.getCssReqCodeLess()!=null){
			c.andcssReqCodeLessThan(this.getCssReqCodeLess());
		}
		if(this.getCssRequestEquals()!=null){
			c.andcssRequestEqualTo(this.getCssRequestEquals());
		}else if(this.getCssRequestIsNull()!=null && this.getCssRequestIsNull()){
			c.andcssRequestIsNull();
		}else if(this.getCssRequestIsNotNull()!=null && this.getCssRequestIsNotNull()){
			c.andcssRequestIsNotNull();
		}else if(this.getCssRequestLike()!=null){
			c.andcssRequestLike(this.getCssRequestLike());
		}else if(this.getCssRequestIn()!=null){
			c.andcssRequestIn(java.util.Arrays.asList(this.getCssRequestIn()));
		}else if(this.getCssRequestStart()!=null && this.getCssRequestEnd()!=null){
			c.andcssRequestBetween(this.getCssRequestStart(), this.getCssRequestEnd());
		}else if(this.getCssRequestGreater()!=null){
			c.andcssRequestGreaterThan(this.getCssRequestGreater());
		}else if(this.getCssRequestLess()!=null){
			c.andcssRequestLessThan(this.getCssRequestLess());
		}
		if(this.getCssRepCodeEquals()!=null){
			c.andcssRepCodeEqualTo(this.getCssRepCodeEquals());
		}else if(this.getCssRepCodeIsNull()!=null && this.getCssRepCodeIsNull()){
			c.andcssRepCodeIsNull();
		}else if(this.getCssRepCodeIsNotNull()!=null && this.getCssRepCodeIsNotNull()){
			c.andcssRepCodeIsNotNull();
		}else if(this.getCssRepCodeLike()!=null){
			c.andcssRepCodeLike(this.getCssRepCodeLike());
		}else if(this.getCssRepCodeIn()!=null){
			c.andcssRepCodeIn(java.util.Arrays.asList(this.getCssRepCodeIn()));
		}else if(this.getCssRepCodeStart()!=null && this.getCssRepCodeEnd()!=null){
			c.andcssRepCodeBetween(this.getCssRepCodeStart(), this.getCssRepCodeEnd());
		}else if(this.getCssRepCodeGreater()!=null){
			c.andcssRepCodeGreaterThan(this.getCssRepCodeGreater());
		}else if(this.getCssRepCodeLess()!=null){
			c.andcssRepCodeLessThan(this.getCssRepCodeLess());
		}
		if(this.getCssResponseEquals()!=null){
			c.andcssResponseEqualTo(this.getCssResponseEquals());
		}else if(this.getCssResponseIsNull()!=null && this.getCssResponseIsNull()){
			c.andcssResponseIsNull();
		}else if(this.getCssResponseIsNotNull()!=null && this.getCssResponseIsNotNull()){
			c.andcssResponseIsNotNull();
		}else if(this.getCssResponseLike()!=null){
			c.andcssResponseLike(this.getCssResponseLike());
		}else if(this.getCssResponseIn()!=null){
			c.andcssResponseIn(java.util.Arrays.asList(this.getCssResponseIn()));
		}else if(this.getCssResponseStart()!=null && this.getCssResponseEnd()!=null){
			c.andcssResponseBetween(this.getCssResponseStart(), this.getCssResponseEnd());
		}else if(this.getCssResponseGreater()!=null){
			c.andcssResponseGreaterThan(this.getCssResponseGreater());
		}else if(this.getCssResponseLess()!=null){
			c.andcssResponseLessThan(this.getCssResponseLess());
		}
		if(this.getCssStatusEquals()!=null){
			c.andcssStatusEqualTo(this.getCssStatusEquals());
		}else if(this.getCssStatusIsNull()!=null && this.getCssStatusIsNull()){
			c.andcssStatusIsNull();
		}else if(this.getCssStatusIsNotNull()!=null && this.getCssStatusIsNotNull()){
			c.andcssStatusIsNotNull();
		}else if(this.getCssStatusIn()!=null){
			c.andcssStatusIn(java.util.Arrays.asList(this.getCssStatusIn()));
		}else if(this.getCssStatusStart()!=null && this.getCssStatusEnd()!=null){
			c.andcssStatusBetween(this.getCssStatusStart(), this.getCssStatusEnd());
		}else if(this.getCssStatusGreater()!=null){
			c.andcssStatusGreaterThan(this.getCssStatusGreater());
		}else if(this.getCssStatusLess()!=null){
			c.andcssStatusLessThan(this.getCssStatusLess());
		}
		if((this.getSidx()!=null && !this.getSidx().trim().equals("")) && this.getSord()!=null)
			q.setOrderByClause(""+ this.getSidx()+" "+this.getSord());
		return q;
	}
	
}
