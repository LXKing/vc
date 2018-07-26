package com.ccclubs.admin.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class HistoryStateQuery implements Serializable{


	private static final long serialVersionUID = 8074566454928353060L;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date currentTimeStart;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date currentTimeEnd;

	private String csVinEquals;


	public String getCsVinEquals(){return this.csVinEquals;}

	public HistoryStateQuery setCsVinEquals(String csVinEquals){
		this.csVinEquals = csVinEquals;
		return this;
	}

	public HistoryStateQuery setCurrentTimeStart(Date currentTimeStart){
		this.currentTimeStart = currentTimeStart;
		return this;
	}

	public Date getCurrentTimeStart(){
		return this.currentTimeStart;
	}

	public HistoryStateQuery setCurrentTimeEnd(Date currentTimeEnd){
		this.currentTimeEnd = currentTimeEnd;
		return this;
	}

	public Date getCurrentTimeEnd(){
		return this.currentTimeEnd;
	}
	

	
}
