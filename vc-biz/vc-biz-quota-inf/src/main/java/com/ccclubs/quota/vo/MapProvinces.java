package com.ccclubs.quota.vo;

import java.io.Serializable;

public class MapProvinces implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4410734766420936168L;
	private MapMarkerPosition position;
	private String districtName;
	private int carNums;

	public MapMarkerPosition getPosition() {
		return position;
	}

	public void setPosition(MapMarkerPosition position) {
		this.position = position;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getCarNums() {
		return carNums;
	}

	public void setCarNums(int carNums) {
		this.carNums = carNums;
	}

}
