package com.ccclubs.admin.query;

import java.io.Serializable;

public class HistoryStateQuery implements Serializable{


	private static final long serialVersionUID = 8074566454928353060L;

	private Long currentTimeStart;

	private Long currentTimeEnd;

	private String csNumberEquals;


	public String getCsNumberEquals(){return this.csNumberEquals;}

	public HistoryStateQuery setCsNumberEquals(String csNumberEquals){
		this.csNumberEquals = csNumberEquals;
		return this;
	}

	public HistoryStateQuery setCurrentTimeStart(Long currentTimeStart){
		this.currentTimeStart = currentTimeStart;
		return this;
	}

	public Long getCurrentTimeStart(){
		return this.currentTimeStart;
	}

	public HistoryStateQuery setCurrentTimeEnd(Long currentTimeEnd){
		this.currentTimeEnd = currentTimeEnd;
		return this;
	}

	public Long getCurrentTimeEnd(){
		return this.currentTimeEnd;
	}
	

	
}
