package com.ccclubs.quota.vo;

import java.io.Serializable;
import java.util.List;

public class MapOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7430888562245427120L;
	private List<MapProvinces> provinces;
	private String districtId;

	public List<MapProvinces> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<MapProvinces> provinces) {
		this.provinces = provinces;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

}
