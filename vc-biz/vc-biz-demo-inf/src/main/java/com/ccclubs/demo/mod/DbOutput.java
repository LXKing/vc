package com.ccclubs.demo.mod;

import java.io.Serializable;
import java.util.List;

import com.ccclubs.demo.orm.model.SrvProperty;

public class DbOutput implements Serializable {
	/** 
	 * 
	 */
	private static final long serialVersionUID = -4063014538133832636L;
	private List<SrvProperty> list;

	public List<SrvProperty> getList() {
		return list;
	}

	public void setList(List<SrvProperty> list) {
		this.list = list;
	}

}
