package com.ccclubs.demo.mod;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DemoEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3531165927614781349L;
	private BigDecimal myid;
	private String myName;
	private int myType;
	private Date myDate;

	public BigDecimal getMyid() {
		return myid;
	}

	public void setMyid(BigDecimal myid) {
		this.myid = myid;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public int getMyType() {
		return myType;
	}

	public void setMyType(int myType) {
		this.myType = myType;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

}
