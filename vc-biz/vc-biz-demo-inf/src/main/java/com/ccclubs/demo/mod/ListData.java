package com.ccclubs.demo.mod;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class ListData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1386727124993853723L;
	@NotBlank(message="不能为空")
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
