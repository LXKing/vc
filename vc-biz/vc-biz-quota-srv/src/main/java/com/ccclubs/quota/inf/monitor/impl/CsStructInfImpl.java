package com.ccclubs.quota.inf.monitor.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.monitor.CsStructInf;
import com.ccclubs.quota.orm.mapper.CsStructMapper;
import com.ccclubs.quota.orm.model.CsStructExample;
import com.ccclubs.quota.orm.model.CsStructWithBLOBs;
import com.ccclubs.quota.vo.BaseDeleteKeysInput;
import com.ccclubs.quota.vo.monitor.CsStructAddInput;
import com.ccclubs.quota.vo.monitor.CsStructQueryInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(version = "1.0.0")
public class CsStructInfImpl implements CsStructInf {
	@Resource
	private CsStructMapper csStructMapper;

	public CsStructInfImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(CsStructAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(BaseDeleteKeysInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mod(CsStructAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public CsStructWithBLOBs mod(Long cstId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CsStructWithBLOBs> que(CsStructQueryInput input) {
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		
		CsStructExample ex = new CsStructExample();
		//CsStructExample.Criteria excri = ex.createCriteria();
		List<CsStructWithBLOBs>  list = csStructMapper.selectByExampleWithBLOBs(ex);
		PageInfo<CsStructWithBLOBs> pinfo = new PageInfo<CsStructWithBLOBs>(list);
		return pinfo;
	}

}
