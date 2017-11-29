package com.ccclubs.admin.vo;

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
public class Page implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	boolean prev;//是否有上一页
	boolean next;//是否有下一页
	int size;//每页记录数
	int total;//总页数
	long count;//总记录数
	int index;//当前页	

	public Page(int index, int size, long count) {
		super();
		this.total = (int) count / size + ((count % size) > 0 ? 1 : 0);
		this.prev = index > 0;
		this.next = (total - 1) > index;
		this.size = size;
		this.count = count;
		this.index = (index >= total) ? (total - 1) : index;
		this.index = this.index < 0 ? 0 : this.index;
	}

	public static long test(int index, int size, long count) {
		int total = (int) count / size + ((count % size) > 0 ? 1 : 0);
		index = (index >= total) ? (total - 1) : index;
		index = index < 0 ? 0 : index;
		return index * size;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
