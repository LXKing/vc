package com.ccclubs.quota.vo;

import java.io.Serializable;

public class UserInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7499239238510889479L;
	private String account;
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
