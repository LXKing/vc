package com.ccclubs.quota.vo.monitor;

import com.ccclubs.quota.vo.BaseQueryInput;

public class CsStructQueryInput extends BaseQueryInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8508664752471280430L;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column cs_struct.css_id
	 *
	 * @mbg.generated
	 */
	private Long cssId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column cs_struct.css_name
	 *
	 * @mbg.generated
	 */
	private String cssName;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column cs_struct.css_type
	 *
	 * @mbg.generated
	 */
	private Integer cssType;
	
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column cs_struct.css_status
	 *
	 * @mbg.generated
	 */
	private Integer cssStatus;

	public Long getCssId() {
		return cssId;
	}

	public void setCssId(Long cssId) {
		this.cssId = cssId;
	}

	public String getCssName() {
		return cssName;
	}

	public void setCssName(String cssName) {
		this.cssName = cssName;
	}

	public Integer getCssType() {
		return cssType;
	}

	public void setCssType(Integer cssType) {
		this.cssType = cssType;
	}

	public Integer getCssStatus() {
		return cssStatus;
	}

	public void setCssStatus(Integer cssStatus) {
		this.cssStatus = cssStatus;
	}
	
	
	
}
