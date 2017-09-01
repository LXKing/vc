package com.ccclubs.quota.vo.basis;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BasicModelQueryInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306256770042694715L;
	private Integer pageSize;
	private Integer pageNum;
	private String sortField;
	private String sortOrder;
	private Integer csmId;
	private String csmName;
	private Integer csmStatus;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date csmAddTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date csmAddTimeEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date csmUpdateTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date csmUpdateTimeEnd;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getCsmId() {
		return csmId;
	}

	public void setCsmId(Integer csmId) {
		this.csmId = csmId;
	}

	public String getCsmName() {
		return csmName;
	}

	public void setCsmName(String csmName) {
		this.csmName = csmName;
	}

	public Integer getCsmStatus() {
		return csmStatus;
	}

	public void setCsmStatus(Integer csmStatus) {
		this.csmStatus = csmStatus;
	}

	public Date getCsmAddTimeStart() {
		return csmAddTimeStart;
	}

	public void setCsmAddTimeStart(Date csmAddTimeStart) {
		this.csmAddTimeStart = csmAddTimeStart;
	}

	public Date getCsmAddTimeEnd() {
		return csmAddTimeEnd;
	}

	public void setCsmAddTimeEnd(Date csmAddTimeEnd) {
		this.csmAddTimeEnd = csmAddTimeEnd;
	}

	public Date getCsmUpdateTimeStart() {
		return csmUpdateTimeStart;
	}

	public void setCsmUpdateTimeStart(Date csmUpdateTimeStart) {
		this.csmUpdateTimeStart = csmUpdateTimeStart;
	}

	public Date getCsmUpdateTimeEnd() {
		return csmUpdateTimeEnd;
	}

	public void setCsmUpdateTimeEnd(Date csmUpdateTimeEnd) {
		this.csmUpdateTimeEnd = csmUpdateTimeEnd;
	}

}
