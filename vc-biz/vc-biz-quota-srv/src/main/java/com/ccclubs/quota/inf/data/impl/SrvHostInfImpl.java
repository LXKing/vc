package com.ccclubs.quota.inf.data.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.data.SrvHostInf;
import com.ccclubs.quota.orm.mapper.SrvHostMapper;
import com.ccclubs.quota.orm.model.SrvHost;
import com.ccclubs.quota.orm.model.SrvHostExample;

@Service(version = "1.0.0")
public class SrvHostInfImpl implements SrvHostInf {
	@Resource
	private SrvHostMapper srvHostMapper;
	@Override
	public List<SrvHost> select() {
		SrvHostExample ex = new SrvHostExample();
		List<SrvHost> list = srvHostMapper.selectByExample(ex);
		return list;
	}

}
