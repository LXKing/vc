package com.ccclubs.quota.inf.data.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.data.CsCanInf;
import com.ccclubs.quota.orm.mapper.CsCanBizMapper;
import com.ccclubs.quota.orm.model.CsCan;
import com.ccclubs.quota.orm.model.CsCanBiz;
import com.ccclubs.quota.orm.model.CsCanBizExample;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.data.CsCanAddInput;
import com.ccclubs.quota.vo.data.CsCanQueryInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(version = "1.0.0")
public class CsCanInfImpl implements CsCanInf {
	@Resource
	private CsCanBizMapper csCanBizMapper;

	@Override
	public void add(CsCanAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(BaseDeleteInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mod(CsCanAddInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public CsCan mod(Integer cssId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CsCanBiz> que(CsCanQueryInput input) {
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		
		CsCanBizExample ex = new CsCanBizExample();
		List<CsCanBiz> list = csCanBizMapper.selectByExample(ex);
		PageInfo<CsCanBiz> pinfo = new PageInfo<CsCanBiz>(list);
		return pinfo;
	}

}
