package com.ccclubs.demo.inf.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.demo.inf.DemoDbInf;
import com.ccclubs.demo.mod.DbInput;
import com.ccclubs.demo.mod.DbOutput;
import com.ccclubs.demo.mod.DbPageInput;
import com.ccclubs.demo.mod.DbPageOutput;
import com.ccclubs.demo.orm.mapper.SrvPropertyMapper;
import com.ccclubs.demo.orm.model.SrvProperty;
import com.ccclubs.demo.orm.model.SrvPropertyExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(version = "1.0.0")
public class DemoDbInfImpl implements DemoDbInf {
	@Resource
	private SrvPropertyMapper srvPropertyMapper;

	@Override
	public String sayDbDemo(String db) {
		SrvPropertyExample example = new SrvPropertyExample();
		//SrvPropertyExample.Criteria criteria = example.createCriteria();
		List<SrvProperty> list = srvPropertyMapper.selectByExample(example);
		String firstName = null;
		for(SrvProperty sp : list){
			firstName = sp.getSpName();
		}
		return firstName;
	}

	@Override
	public DbOutput dbList(DbInput input) {
		SrvPropertyExample example = new SrvPropertyExample();
		//SrvPropertyExample.Criteria criteria = example.createCriteria();
		List<SrvProperty> list = srvPropertyMapper.selectByExample(example);
		DbOutput out = new DbOutput();
		out.setList(list);
		return out;
	}

	@Override
	public DbPageOutput dbList(DbPageInput input) {
		PageHelper.startPage(1, 5);
		SrvPropertyExample example = new SrvPropertyExample();
		//SrvPropertyExample.Criteria criteria = example.createCriteria();
		List<SrvProperty> list = srvPropertyMapper.selectByExample(example);
		DbPageOutput out = new DbPageOutput();
		PageInfo<SrvProperty> pi = new PageInfo<SrvProperty>(list);
		out.setList(pi.getList());
		return out;
	}

}
