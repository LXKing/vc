package com.ccclubs.admin.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HistoryCanQuery {
	

	private String csVinEquals;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date currentTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date currentTimeEnd;

	private String sidx;
	private String sord;

	public HistoryCanQuery setCsVinEquals(String csVinEquals){
		this.csVinEquals = csVinEquals;
		return this;
	}
	public String getCsVinEquals(){
		return this.csVinEquals;
	}
	public HistoryCanQuery setCurrentTimeStart(Date currentTimeStart){
		this.currentTimeStart = currentTimeStart;
		return this;
	}
	public Date getCurrentTimeStart(){
		return this.currentTimeStart;
	}
	public HistoryCanQuery setCurrentTimeEnd(Date currentTimeEnd){
		this.currentTimeEnd = currentTimeEnd;
		return this;
	}
	public Date getCurrentTimeEnd(){
		return this.currentTimeEnd;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}
	public String getSidx(){
		if(this.sidx == null){
			return "";
		}
		else if(this.sidx.equals("carCanHistoryId")){
			return "car_can_history_id";
		}
		else if(this.sidx.equals("csVin")){
			return "cs_vin";
		}
		else if(this.sidx.equals("canData")){
			return "can_data";
		}
		else if(this.sidx.equals("addTime")){
			return "add_time";
		}
		else if(this.sidx.equals("currentTime")){
			return "current_time";
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
