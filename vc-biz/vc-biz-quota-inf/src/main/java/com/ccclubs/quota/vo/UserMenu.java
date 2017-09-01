package com.ccclubs.quota.vo;

import java.io.Serializable;
import java.util.List;

public class UserMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4715118339965717220L;
	private String id;
	private String name;
	private String path;
	private String comp;
	private boolean isActive;
	private boolean close;
	private String className;
	private List<UserMenu> submenu;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<UserMenu> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<UserMenu> submenu) {
		this.submenu = submenu;
	}

}
