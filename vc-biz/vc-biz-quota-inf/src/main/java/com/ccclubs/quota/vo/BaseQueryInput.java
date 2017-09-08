package com.ccclubs.quota.vo;

import java.io.Serializable;

public class BaseQueryInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5128618118897123420L;
	private Integer pageSize = 10;
	private Integer pageNum = 1;
	private String sortField;
	private String sortOrder;
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
