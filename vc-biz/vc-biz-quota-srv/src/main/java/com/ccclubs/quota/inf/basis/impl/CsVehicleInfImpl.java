package com.ccclubs.quota.inf.basis.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.basis.CsVehicleInf;
import com.ccclubs.quota.orm.mapper.CsVehicleMapper;
import com.ccclubs.quota.orm.model.CsVehicle;
import com.ccclubs.quota.orm.model.CsVehicleExample;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.basis.CsVehicleAddInput;
import com.ccclubs.quota.vo.basis.CsVehicleQueryInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(version = "1.0.0")
public class CsVehicleInfImpl implements CsVehicleInf {
	@Resource
	private CsVehicleMapper csVehicleMapper;
	@Override
	public void add(CsVehicleAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(BaseDeleteInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mod(CsVehicleAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public CsVehicle mod(Integer csvId) {
		CsVehicle cv = csVehicleMapper.selectByPrimaryKey(csvId);
		return cv;
	}

	@Override
	public PageInfo<CsVehicle> que(CsVehicleQueryInput input) {
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		CsVehicleExample ex = new CsVehicleExample();
		//CsVehicleExample.Criteria excri = ex.createCriteria();
		List<CsVehicle> list = csVehicleMapper.selectByExample(ex);
		PageInfo<CsVehicle> pinfo = new PageInfo<CsVehicle>(list);
		return pinfo;
	}

}
