package com.ccclubs.demo.mod;

import javax.validation.constraints.NotNull;

public class IEVPOPInput {
	@NotNull(message="终端编号必填")
	private String client;
	@NotNull(message="应用所属城市必填")
	private Integer host;
	@NotNull(message="远程控制类型必填")
	private Integer type;
	@NotNull(message="应用发起方调用接口的时间必填")
	private String timestamp;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getHost() {
		return host;
	}

	public void setHost(Integer host) {
		this.host = host;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
