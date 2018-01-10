package com.ccclubs.quota.vo.basis;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ccclubs.quota.vo.BaseQueryInput;

public class TbUpgradeQueryInput extends BaseQueryInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3259224489269749839L;
	private Integer tbuId;
	private Integer tbuMachineMin;
	private Integer tbuMachineMax;
	private String tbuNumber;
	private String tbuSimNo;
	private Integer tbuTeType;
	private Integer tbuProtocol;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tbuAddTimeStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tbuAddTimeEnd;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tbuUpdateTimeStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tbuUpdateTimeEnd;
	private Integer tbuStatus;

	public Integer getTbuId() {
		return tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public Integer getTbuMachineMin() {
		return tbuMachineMin;
	}

	public void setTbuMachineMin(Integer tbuMachineMin) {
		this.tbuMachineMin = tbuMachineMin;
	}

	public Integer getTbuMachineMax() {
		return tbuMachineMax;
	}

	public void setTbuMachineMax(Integer tbuMachineMax) {
		this.tbuMachineMax = tbuMachineMax;
	}

	public String getTbuNumber() {
		return tbuNumber;
	}

	public void setTbuNumber(String tbuNumber) {
		this.tbuNumber = tbuNumber;
	}

	public String getTbuSimNo() {
		return tbuSimNo;
	}

	public void setTbuSimNo(String tbuSimNo) {
		this.tbuSimNo = tbuSimNo;
	}

	public Integer getTbuTeType() {
		return tbuTeType;
	}

	public void setTbuTeType(Integer tbuTeType) {
		this.tbuTeType = tbuTeType;
	}

	public Integer getTbuProtocol() {
		return tbuProtocol;
	}

	public void setTbuProtocol(Integer tbuProtocol) {
		this.tbuProtocol = tbuProtocol;
	}

	public Date getTbuAddTimeStart() {
		return tbuAddTimeStart;
	}

	public void setTbuAddTimeStart(Date tbuAddTimeStart) {
		this.tbuAddTimeStart = tbuAddTimeStart;
	}

	public Date getTbuAddTimeEnd() {
		return tbuAddTimeEnd;
	}

	public void setTbuAddTimeEnd(Date tbuAddTimeEnd) {
		this.tbuAddTimeEnd = tbuAddTimeEnd;
	}

	public Date getTbuUpdateTimeStart() {
		return tbuUpdateTimeStart;
	}

	public void setTbuUpdateTimeStart(Date tbuUpdateTimeStart) {
		this.tbuUpdateTimeStart = tbuUpdateTimeStart;
	}

	public Date getTbuUpdateTimeEnd() {
		return tbuUpdateTimeEnd;
	}

	public void setTbuUpdateTimeEnd(Date tbuUpdateTimeEnd) {
		this.tbuUpdateTimeEnd = tbuUpdateTimeEnd;
	}

	public Integer getTbuStatus() {
		return tbuStatus;
	}

	public void setTbuStatus(Integer tbuStatus) {
		this.tbuStatus = tbuStatus;
	}

}
