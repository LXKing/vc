package com.ccclubs.quota.vo;

import java.io.Serializable;
import java.util.List;

public class BaseDeleteInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2214332376932118826L;
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
