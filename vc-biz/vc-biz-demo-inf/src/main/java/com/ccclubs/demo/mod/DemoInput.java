package com.ccclubs.demo.mod;

import java.io.Serializable;

public class DemoInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6549374455970197439L;
	private String say;
	private int type;

	public String getSay() {
		return say;
	}

	public void setSay(String say) {
		this.say = say;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
