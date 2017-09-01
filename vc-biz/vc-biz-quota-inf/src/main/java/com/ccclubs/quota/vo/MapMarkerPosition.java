package com.ccclubs.quota.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MapMarkerPosition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1382812975336398577L;
	private BigDecimal longitude;
	private BigDecimal latitude;

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

}
