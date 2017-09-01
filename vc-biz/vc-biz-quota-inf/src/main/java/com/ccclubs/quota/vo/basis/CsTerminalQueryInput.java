package com.ccclubs.quota.vo.basis;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ccclubs.quota.vo.BaseQueryInput;

public class CsTerminalQueryInput extends BaseQueryInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1802668164193928696L;
	private Long cstId;
	private String cstIdd;
	private Integer cstStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cstAddTimeStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cstAddTimeEnd;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cstUpdateTimeStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cstUpdateTimeEnd;

	public Long getCstId() {
		return cstId;
	}

	public void setCstId(Long cstId) {
		this.cstId = cstId;
	}

	public String getCstIdd() {
		return cstIdd;
	}

	public void setCstIdd(String cstIdd) {
		this.cstIdd = cstIdd;
	}

	public Integer getCstStatus() {
		return cstStatus;
	}

	public void setCstStatus(Integer cstStatus) {
		this.cstStatus = cstStatus;
	}

	public Date getCstAddTimeStart() {
		return cstAddTimeStart;
	}

	public void setCstAddTimeStart(Date cstAddTimeStart) {
		this.cstAddTimeStart = cstAddTimeStart;
	}

	public Date getCstAddTimeEnd() {
		return cstAddTimeEnd;
	}

	public void setCstAddTimeEnd(Date cstAddTimeEnd) {
		this.cstAddTimeEnd = cstAddTimeEnd;
	}

	public Date getCstUpdateTimeStart() {
		return cstUpdateTimeStart;
	}

	public void setCstUpdateTimeStart(Date cstUpdateTimeStart) {
		this.cstUpdateTimeStart = cstUpdateTimeStart;
	}

	public Date getCstUpdateTimeEnd() {
		return cstUpdateTimeEnd;
	}

	public void setCstUpdateTimeEnd(Date cstUpdateTimeEnd) {
		this.cstUpdateTimeEnd = cstUpdateTimeEnd;
	}

}
