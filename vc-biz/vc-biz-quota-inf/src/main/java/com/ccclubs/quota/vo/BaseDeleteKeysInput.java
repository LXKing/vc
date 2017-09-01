package com.ccclubs.quota.vo;

import java.io.Serializable;
import java.util.List;

public class BaseDeleteKeysInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2214332376932118826L;
	private List<Long> ids;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
