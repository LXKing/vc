package com.ccclubs.quota.vo;

import java.io.Serializable;
import java.util.List;

public class UserOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4189223985805053687L;
	private List<UserMenu> menus;
	private String nickname;
	private String createTime;
	private List<String> roleNames;

	public List<UserMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<UserMenu> menus) {
		this.menus = menus;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

}
