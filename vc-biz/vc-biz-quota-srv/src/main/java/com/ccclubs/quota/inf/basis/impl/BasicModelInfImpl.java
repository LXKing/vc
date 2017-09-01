package com.ccclubs.quota.inf.basis.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.basis.BasicModelInf;
import com.ccclubs.quota.orm.mapper.CsModelMapper;
import com.ccclubs.quota.orm.model.CsModel;
import com.ccclubs.quota.orm.model.CsModelExample;
import com.ccclubs.quota.vo.basis.BasicModelAddInput;
import com.ccclubs.quota.vo.basis.BasicModelDelInput;
import com.ccclubs.quota.vo.basis.BasicModelQueryInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(version = "1.0.0")
public class BasicModelInfImpl implements BasicModelInf {
	@Resource
	private CsModelMapper csModelMapper;

	@Transactional
	@Override
	public void add(BasicModelAddInput input) {
		CsModel record = new CsModel();
		record.setCsmName(input.getCsmName());
		record.setCsmStatus(input.getCsmStatus());
		record.setCsmTankCapacity(input.getCsmTankCapacity());
		record.setCsmType(input.getCsmType());
		record.setCsmFlag(input.getCsmFlag());
		record.setCsmFile(input.getCsmFile());
		record.setCsmCatagory(input.getCsmCatagory());
		record.setCsmBatteryCapacity(input.getCsmBatteryCapacity());
		Date now  = new Date();
		record.setCsmAddTime(now);
		record.setCsmUpdateTime(now);
		record.setCsmStatus(1);
		csModelMapper.insertSelective(record);
	}

	@Override
	public void del(BasicModelDelInput input) {
		CsModelExample ex = new CsModelExample();
		CsModelExample.Criteria excri = ex.createCriteria();
		excri.andCsmIdIn(input.getIds());
		csModelMapper.deleteByExample(ex);
	}

	@Override
	public void mod(BasicModelAddInput input) {
		CsModel record = new CsModel();
		record.setCsmId(input.getCsmId());
		record.setCsmName(input.getCsmName());
		record.setCsmStatus(input.getCsmStatus());
		record.setCsmTankCapacity(input.getCsmTankCapacity());
		record.setCsmType(input.getCsmType());
		record.setCsmFlag(input.getCsmFlag());
		record.setCsmFile(input.getCsmFile());
		record.setCsmCatagory(input.getCsmCatagory());
		record.setCsmBatteryCapacity(input.getCsmBatteryCapacity());
		Date now  = new Date();
		record.setCsmUpdateTime(now);
		
		csModelMapper.updateByPrimaryKeySelective(record);

	}

	@Override
	public CsModel mod(Integer csmId) {
		CsModel csModel = csModelMapper.selectByPrimaryKey(csmId);
		return csModel;
	}

	@Override
	public PageInfo<CsModel> que(BasicModelQueryInput input) {

		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);

		CsModelExample ex = new CsModelExample();
		CsModelExample.Criteria excri = ex.createCriteria();
		if(StringUtils.isNotBlank(input.getCsmName())){
			excri.andCsmNameEqualTo(input.getCsmName());
		}
		if(null != input.getCsmId()){
			excri.andCsmIdEqualTo(input.getCsmId());
		}
		if(null != input.getCsmStatus()){
			excri.andCsmStatusEqualTo(input.getCsmStatus());
		}
		if(null != input.getCsmAddTimeStart()){
			excri.andCsmAddTimeGreaterThanOrEqualTo(input.getCsmAddTimeStart());
		}
		if(null != input.getCsmAddTimeEnd()){
			excri.andCsmAddTimeLessThanOrEqualTo(input.getCsmAddTimeEnd());
		}
		if(null != input.getCsmUpdateTimeStart()){
			excri.andCsmUpdateTimeGreaterThanOrEqualTo(input.getCsmUpdateTimeStart());
		}
		if(null != input.getCsmUpdateTimeEnd()){
			excri.andCsmUpdateTimeLessThanOrEqualTo(input.getCsmUpdateTimeEnd());
		}
		List<CsModel> list = csModelMapper.selectByExample(ex);
		PageInfo<CsModel> pinfo = new PageInfo<CsModel>(list);
		return pinfo;
	}

}
