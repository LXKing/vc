package com.ccclubs.demo.mod;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

public class ListInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8976598201377653839L;
	@Valid
	private List<ListData> list;

	public List<ListData> getList() {
		return list;
	}

	public void setList(List<ListData> list) {
		this.list = list;
	}

}
