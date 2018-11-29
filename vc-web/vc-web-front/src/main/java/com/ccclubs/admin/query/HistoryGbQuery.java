package com.ccclubs.admin.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HistoryGbQuery {
	


	
	private String csVinEquals;

	private String csNumberEquals;
	

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date addTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date addTimeEnd;




	

	private String sidx;
	private String sord;


	public HistoryGbQuery setCsVinEquals(String csVinEquals){
		this.csVinEquals = csVinEquals;
		return this;
	}

	public String getCsVinEquals() {
		return this.csVinEquals;
	}

	public HistoryGbQuery setCsNumberEquals(String csNumberEquals) {
		this.csNumberEquals = csNumberEquals;
		return this;
	}

	public String getCsNumberEquals() {
		return this.csNumberEquals;
	}

	public HistoryGbQuery setAddTimeStart(Date addTimeStart){
		this.addTimeStart = addTimeStart;
		return this;
	}
	public Date getAddTimeStart(){
		return this.addTimeStart;
	}
	public HistoryGbQuery setAddTimeEnd(Date addTimeEnd){
		this.addTimeEnd = addTimeEnd;
		return this;
	}

	public Date getAddTimeEnd(){
		return this.addTimeEnd;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("carGbHistoryId")){
			return "car_gb_history_id";
		}
		else if(this.sidx.equals("csVin")){
			return "cs_vin";
		}
		else if(this.sidx.equals("csAccess")){
			return "cs_access";
		}
		else if(this.sidx.equals("addTime")){
			return "add_time";
		}
		else if(this.sidx.equals("currentTime")){
			return "current_time";
		}
		else if(this.sidx.equals("csProtocol")){
			return "cs_protocol";
		}
		else if(this.sidx.equals("gbData")){
			return "gb_data";
		}
		else if(this.sidx.equals("gbType")){
			return "gb_type";
		}
		else if(this.sidx.equals("csVerify")){
			return "cs_verify";
		}
		return this.sidx;
	}
	public void setSord(String sord){
		this.sord = sord;
	}
	public String getSord(){
		return this.sord;
	}

	
}
