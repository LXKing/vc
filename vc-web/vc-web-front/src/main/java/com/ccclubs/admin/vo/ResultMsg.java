package com.ccclubs.admin.vo;

import java.io.Serializable;

/**
 ****************************
 * 版权所有：车厘子 所有权利
 * 创建日期: 2017-9-12
 * 创建作者：zkm
 * 类名称　：ResultMsg.java
 * 版　　本：@param <T>
 * 功　　能：
 * 最后修改：
 * 修改记录：
 *****************************
 */
public class ResultMsg<T> implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 5764539963462715L;
    private boolean success;
	private int code;
	private String message;
	private T data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResultMsg() {
		super();
	}

	public ResultMsg(boolean status, ResultCode resultCode, T data) {
		super();
		this.success = status;
		this.code = resultCode.getErrorCode();
		this.message = resultCode.getErrorMsg();
		this.data = data;
	}

}
