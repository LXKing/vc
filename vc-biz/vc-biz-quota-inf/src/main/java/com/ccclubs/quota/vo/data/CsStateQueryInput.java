package com.ccclubs.quota.vo.data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ccclubs.quota.vo.BaseQueryInput;

public class CsStateQueryInput extends BaseQueryInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1544537519749147833L;
	private Integer cssAccess;
	private String cssNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cssAddTimeStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cssAddTimeEnd;
	private Integer cssSaving;
	private Long cssOrder;

	 

	public Integer getCssAccess() {
		return cssAccess;
	}

	public void setCssAccess(Integer cssAccess) {
		this.cssAccess = cssAccess;
	}

	public String getCssNumber() {
		return cssNumber;
	}

	public void setCssNumber(String cssNumber) {
		this.cssNumber = cssNumber;
	}

	public Date getCssAddTimeStart() {
		return cssAddTimeStart;
	}

	public void setCssAddTimeStart(Date cssAddTimeStart) {
		this.cssAddTimeStart = cssAddTimeStart;
	}

	public Date getCssAddTimeEnd() {
		return cssAddTimeEnd;
	}

	public void setCssAddTimeEnd(Date cssAddTimeEnd) {
		this.cssAddTimeEnd = cssAddTimeEnd;
	}

	public Integer getCssSaving() {
		return cssSaving;
	}

	public void setCssSaving(Integer cssSaving) {
		this.cssSaving = cssSaving;
	}

	public Long getCssOrder() {
		return cssOrder;
	}

	public void setCssOrder(Long cssOrder) {
		this.cssOrder = cssOrder;
	}

}
