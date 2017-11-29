/*
 * $Id: Result.java 2017-8-22 上午11:30:14Z byz $
 * Copyright (c)  by liuxu. All right reserved.
 */
package com.ccclubs.admin.vo;

/******************************
 * 版权所有：车厘子 所有权利
 * 创建日期: 2017-8-22 上午11:30:14
 * 创建作者：Just (yanzhao@ccclubs.com)
 * 类名称　：Result.java
 * 版　　本：
 * 功　　能：
 * 最后修改：
 * 修改记录：
*****************************************/
public class VoResult<T> {

	/**
	 * 处理是否成功
	 */
	private boolean success;

	/**
	 * 错误代码
	 */
	private String code;

	/**
	 * 错误提示
	 */
	private String message;

	/**
	 * 数据
	 */
	private T value;

	@SuppressWarnings("rawtypes")
	public static VoResult success() {
		return new VoResult().setSuccess(true);
	}

	@SuppressWarnings("rawtypes")
	public static VoResult error(String code, String message) {
		VoResult jf = new VoResult();
		jf.setSuccess(false);
		jf.setCode(code);
		jf.setMessage(message);
		return jf;
	}

	public boolean isSuccess() {

		return success;
	}

	public VoResult<T> setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getCode() {
		return code;
	}

	public VoResult<T> setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public VoResult<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getValue() {
		return value;
	}

	public VoResult<T> setValue(T value) {
		this.value = value;
		return this;
	}
}
