package com.ccclubs.frm.spring.entity;

import java.io.Serializable;

import com.ccclubs.frm.spring.constant.ApiEnum;

public class ApiMessage<T> implements Serializable {
	private static final long serialVersionUID = 2512671927215872748L;
	
	private int code;
	private String message;
	private T data;
	private String traceId;
	/**
	 * 不要使用这个结构化实例，主要用于json反解析
	 */
	@Deprecated
	public ApiMessage(){
		
	}

	public ApiMessage(T data) {
		super();
		this.code = ApiEnum.SUCCESS.code();
		this.message = ApiEnum.SUCCESS.msg();
		this.data = data;
	}

	public ApiMessage(ApiEnum api) {
		super();
		this.code = api.code();
		this.message = api.msg();
	}

	public ApiMessage(int code, String msg) {
		super();
		this.code = code;
		this.message = msg;
	}

	public ApiMessage(int code, String msg, String traceId) {
		super();
		this.code = code;
		this.message = msg;
		this.traceId = traceId;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
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

	public void setMessage(String msg) {
		this.message = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
