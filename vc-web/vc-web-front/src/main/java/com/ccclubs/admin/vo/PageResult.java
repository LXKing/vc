package com.ccclubs.admin.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

/******************************
 * 版权所有：车厘子 所有权利
 * 创建日期: 2017-8-22 上午11:23:24
 * 创建作者：Just (yanzhao@ccclubs.com)
 * 类名称　：PageResult.java
 * 版　　本：
 * 功　　能：
 * 最后修改：
 * 修改记录：
*****************************************/
public class PageResult<T> implements Serializable {
	
	private static final long serialVersionUID = -4451790780197383217L;
	private Page page;
	private List tbody;//结果集	
	
	public PageResult(PageInfo<T> page){
		this.page = new Page(page.getPageNum(), page.getPageSize(), page.getTotal());
		this.tbody = page.getList() == null ? new ArrayList<>() : page.getList();
	}

	public PageResult(Page page, List tbody) {
		this.page = page;
		this.tbody = tbody == null ? new ArrayList() : tbody;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List getTbody() {
		return tbody;
	}

	public void settbody(List tbody) {
		this.tbody = tbody;
	}
}
