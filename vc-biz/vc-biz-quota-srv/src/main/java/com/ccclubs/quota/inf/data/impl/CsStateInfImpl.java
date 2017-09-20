package com.ccclubs.quota.inf.data.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.data.CsStateInf;
import com.ccclubs.quota.orm.mapper.CsStateBizMapper;
import com.ccclubs.quota.orm.model.CsState;
import com.ccclubs.quota.orm.model.CsStateBiz;
import com.ccclubs.quota.orm.model.CsStateBizExample;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.data.CsStateAddInput;
import com.ccclubs.quota.vo.data.CsStateQueryInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(version = "1.0.0")
public class CsStateInfImpl implements CsStateInf {
	@Resource
	private CsStateBizMapper csStateBizMapper;
	@Override
	public void add(CsStateAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(BaseDeleteInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mod(CsStateAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public CsState mod(Integer cssId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CsStateBiz> que(CsStateQueryInput input) {
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);

		CsStateBizExample ex = new CsStateBizExample();
		CsStateBizExample.Criteria exc = ex.createCriteria();
		if(null != input.getCssAccess()){
			exc.andCssAccessEqualTo(input.getCssAccess());
		}
		if(StringUtils.isNotBlank(input.getCssNumber())){
			exc.andCssNumberEqualTo(input.getCssNumber());
		}
		if(null != input.getCssOrder()){
			exc.andCssOrderEqualTo(input.getCssOrder());
		}
		if(null != input.getCssSaving()){
			exc.andCssSavingEqualTo(input.getCssSaving());
		}
		if(null != input.getCssAddTimeStart()){
			exc.andCssAddTimeGreaterThanOrEqualTo(input.getCssAddTimeStart());
		}
		if(null != input.getCssAddTimeEnd()){
			exc.andCssAddTimeLessThanOrEqualTo(input.getCssAddTimeEnd());
		}


		List<CsStateBiz> blist = csStateBizMapper.selectByExample(ex);
		PageInfo<CsStateBiz> pinfo = new PageInfo<CsStateBiz>(blist);
		return pinfo;
	}

}
