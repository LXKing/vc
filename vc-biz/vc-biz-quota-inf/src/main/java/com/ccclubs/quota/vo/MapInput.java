package com.ccclubs.quota.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MapInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4592335913033181170L;
	private BigDecimal lat;
	private BigDecimal lng;
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	
	

}
