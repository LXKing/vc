package com.ccclubs.quota.inf.basis.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.basis.CsTerminalInf;
import com.ccclubs.quota.orm.mapper.CsTerminalMapper;
import com.ccclubs.quota.orm.model.CsTerminal;
import com.ccclubs.quota.orm.model.CsTerminalExample;
import com.ccclubs.quota.vo.basis.CsTerminalAddInput;
import com.ccclubs.quota.vo.basis.CsTerminalDelInput;
import com.ccclubs.quota.vo.basis.CsTerminalQueryInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service(version = "1.0.0")
public class CsTerminalInfImpl implements CsTerminalInf {
	@Resource
	private CsTerminalMapper csTerminalMapper;
	
	@Override
	public void add(CsTerminalAddInput input) {
		CsTerminal record = new CsTerminal();
		record.setCstCity(input.getCstCity());
		record.setCstColor(input.getCstColor());
		record.setCstIdd(input.getCstIdd());
		record.setCstMade(input.getCstMade());
		record.setCstMobile(input.getCstMobile());
		record.setCstModel(input.getCstModel());
		record.setCstNumber(input.getCstNumber());
		record.setCstProvince(input.getCstProvince());
		record.setCstStatus(input.getCstStatus());
		Date now = new Date();
		record.setCstAddTime(now);
		record.setCstUpdateTime(now);
		csTerminalMapper.insertSelective(record);
	}

	@Override
	public void del(CsTerminalDelInput input) {
		CsTerminalExample ex = new CsTerminalExample();
		CsTerminalExample.Criteria excri = ex.createCriteria();
		excri.andCstIdIn(input.getIds());
		csTerminalMapper.deleteByExample(ex);
	}

	@Override
	public void mod(CsTerminalAddInput input) {
		CsTerminal record = new CsTerminal();
		record.setCstCity(input.getCstCity());
		record.setCstColor(input.getCstColor());
		record.setCstId(input.getCstId());
		record.setCstIdd(input.getCstIdd());
		record.setCstMade(input.getCstMade());
		record.setCstMobile(input.getCstMobile());
		record.setCstModel(input.getCstModel());
		record.setCstNumber(input.getCstNumber());
		record.setCstProvince(input.getCstProvince());
		record.setCstStatus(input.getCstStatus());
		Date now = new Date();
		record.setCstUpdateTime(now);
		csTerminalMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public CsTerminal mod(Long cstId) {
		CsTerminal ct = csTerminalMapper.selectByPrimaryKey(cstId);
		return ct;
	}

	@Override
	public PageInfo<CsTerminal> que(CsTerminalQueryInput input) {
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		
		CsTerminalExample ex = new CsTerminalExample();
		CsTerminalExample.Criteria excri = ex.createCriteria();
		if(StringUtils.isNotBlank(input.getCstIdd())){
			excri.andCstIddEqualTo(input.getCstIdd());
		}
		if(null != input.getCstId()){
			excri.andCstIdEqualTo(input.getCstId());
		}
		if(null != input.getCstStatus()){
			excri.andCstStatusEqualTo(input.getCstStatus());
		}
		if(null != input.getCstAddTimeStart()){
			excri.andCstAddTimeGreaterThanOrEqualTo(input.getCstAddTimeStart());
		}
		if(null != input.getCstAddTimeEnd()){
			excri.andCstAddTimeLessThanOrEqualTo(input.getCstAddTimeEnd());
		}
		if(null != input.getCstUpdateTimeStart()){
			excri.andCstUpdateTimeGreaterThanOrEqualTo(input.getCstUpdateTimeStart());
		}
		if(null != input.getCstUpdateTimeEnd()){
			excri.andCstUpdateTimeLessThanOrEqualTo(input.getCstUpdateTimeEnd());
		}
		List<CsTerminal> list = csTerminalMapper.selectByExample(ex);
		PageInfo<CsTerminal> pinfo = new PageInfo<CsTerminal>(list);
		return pinfo;
	}

}
