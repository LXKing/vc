package com.ccclubs.quota.inf.monitor.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

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

	@Override
	public void add(CsStructAddInput input) {
		CsStructWithBLOBs record = new CsStructWithBLOBs();
		record.setCssName(input.getCssName());
		record.setCssReqCode(input.getCssReqCode());
		record.setCssRequest(input.getCssRequest());
		record.setCssStatus(input.getCssStatus());
		record.setCssType(input.getCssType());
		csStructMapper.insertSelective(record);
	}

	@Override
	public void del(BaseDeleteKeysInput input) {
		CsStructExample ex = new CsStructExample();
		CsStructExample.Criteria excri = ex.createCriteria();
		excri.andCssIdIn(input.getIds());
		csStructMapper.deleteByExample(ex);
	}

	@Override
	public void mod(CsStructAddInput input) {
		CsStructWithBLOBs record = new CsStructWithBLOBs();
		record.setCssId(input.getCssId());
		record.setCssName(input.getCssName());
		record.setCssReqCode(input.getCssReqCode());
		record.setCssRequest(input.getCssRequest());
		record.setCssStatus(input.getCssStatus());
		record.setCssType(input.getCssType());
		csStructMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public CsStructWithBLOBs mod(Long cssId) {
		CsStructWithBLOBs cswb = csStructMapper.selectByPrimaryKey(cssId);
		return cswb;
	}

	@Override
	public PageInfo<CsStructWithBLOBs> que(CsStructQueryInput input) {
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		
		CsStructExample ex = new CsStructExample();
		CsStructExample.Criteria excri = ex.createCriteria();
		if(null != input.getCssId()){
			excri.andCssIdEqualTo(input.getCssId());
		}
		if(null != input.getCssStatus()){
			excri.andCssStatusEqualTo(input.getCssStatus());
		}
		if(null != input.getCssType()){
			excri.andCssTypeEqualTo(input.getCssType());
		}
		if(StringUtils.isNotBlank(input.getCssName())){
			excri.andCssNameEqualTo(input.getCssName());
		}
		List<CsStructWithBLOBs>  list = csStructMapper.selectByExampleWithBLOBs(ex);
		PageInfo<CsStructWithBLOBs> pinfo = new PageInfo<CsStructWithBLOBs>(list);
		return pinfo;
	}

}
