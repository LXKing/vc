package com.ccclubs.quota.vo;

import java.io.Serializable;

public class DriveMilesBizQuotaInput implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6252965977453304771L;
	private String csVin;
	private String csNumber;
	private Integer pageSize;
	private Integer pageNum;
	private String sortField;
	private String sortOrder;

	public String getCsVin() {
		return csVin;
	}

	public void setCsVin(String csVin) {
		this.csVin = csVin;
	}

	public String getCsNumber() {
		return csNumber;
	}

	public void setCsNumber(String csNumber) {
		this.csNumber = csNumber;
	}

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

}
