package com.ccclubs.admin.vo;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

public class TableResult<T> {
	
	private int code;
	
	private String msg;
	
	private long count;
	
	private List<T> data;
	
	private Page page;
	
	public TableResult(PageInfo<T> page){
		this.page = new Page(page.getPageNum(), page.getPageSize(), page.getTotal());
		this.data = page.getList() == null ? new ArrayList<T>() : page.getList();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		if(page!=null)return page.getCount();
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
}
