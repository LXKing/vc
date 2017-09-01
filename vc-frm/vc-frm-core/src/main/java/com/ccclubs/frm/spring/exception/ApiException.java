package com.ccclubs.frm.spring.exception;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import com.ccclubs.frm.spring.constant.ApiEnum;

public class ApiException extends RuntimeException {
	private static final Logger logger = LoggerFactory.getLogger(ApiException.class);

	private static final long serialVersionUID = -7972762881287030971L;
	private int code;
	private String msg;
	private String traceId;
	
	public ApiException(ApiEnum api) {
		super(api.msg());
		this.traceId = UUID.randomUUID().toString();
		this.code = api.code();
		this.msg = api.msg();
		logger.error("traceId:{}, code:{}, msg:{}, detailMessage:{}", this.traceId, this.code, this.msg, super.getMessage());
	}
	
	public ApiException(ApiEnum api, Object... params) {
		super(api.msg());
		this.traceId = UUID.randomUUID().toString();
		this.code = api.code();
		this.msg = MessageFormatter.arrayFormat(api.msg(), params).getMessage();;
		logger.error("traceId:{}, code:{}, msg:{}, detailMessage:{}", this.traceId, this.code, this.msg, super.getMessage());
	}
	
	
	public ApiException(int code, String msg) {
		super(msg);
		this.traceId = UUID.randomUUID().toString();
		this.code = code;
		this.msg = msg;
		logger.error("traceId:{}, code:{}, msg:{}, detailMessage:{}", this.traceId, this.code, this.msg, super.getMessage());
	}

	public ApiException(int code, String msg, Throwable cause) {
		super(msg);
		this.traceId = UUID.randomUUID().toString();
		this.code = code;
		this.msg = msg;
		logger.error("traceId:{}, code:{}, msg:{}", this.traceId, this.code, this.msg);
		logger.error("ApiException:", cause);
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

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

}
