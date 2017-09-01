package com.ccclubs.quota.vo.basis;

import java.io.Serializable;
import java.util.List;

public class BasicModelDelInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3285968133286777852L;

	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	
	
}
