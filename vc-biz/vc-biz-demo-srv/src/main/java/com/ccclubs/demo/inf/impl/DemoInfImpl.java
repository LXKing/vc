package com.ccclubs.demo.inf.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.demo.inf.DemoInf;
import com.ccclubs.demo.mod.DemoInput;
import com.ccclubs.demo.mod.DemoOutput;
import com.ccclubs.frm.spring.exception.ApiException;

@Service(version = "1.0.0")
public class DemoInfImpl implements DemoInf {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String sayDemo(String notify) {
		logger.debug("notify:{}", notify);
		return notify;
	}

	@Override
	public DemoOutput sayHi(DemoInput input) {
		DemoOutput out = new DemoOutput();
		out.setResult(input.getSay() + "@" + input.getType());
		return out;
	}

	@Override
	public DemoOutput dubboxErrorCall(DemoInput input) {
		DemoOutput out = new DemoOutput();
		out.setResult(input.getSay() + "@" + input.getType());
		throw new ApiException(100001, "error");
		//return out;
	}

}
