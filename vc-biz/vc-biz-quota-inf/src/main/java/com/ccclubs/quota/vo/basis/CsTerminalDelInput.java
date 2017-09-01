package com.ccclubs.quota.vo.basis;

import java.io.Serializable;
import java.util.List;

public class CsTerminalDelInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3285968133286777852L;

	private List<Long> ids;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	
	
}
