package com.ccclubs.quota.inf.basis.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.basis.TbUpgradeInf;
import com.ccclubs.quota.orm.mapper.TbUpgradeMapper;
import com.ccclubs.quota.orm.model.TbUpgrade;
import com.ccclubs.quota.orm.model.TbUpgradeExample;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.basis.TbUpgradeAddInput;
import com.ccclubs.quota.vo.basis.TbUpgradeQueryInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(version = "1.0.0")
public class TbUpgradeInfImpl implements TbUpgradeInf {
	@Resource
	private TbUpgradeMapper tbUpgradeMapper;

	@Override
	public void add(TbUpgradeAddInput input) {
		TbUpgrade record = new TbUpgrade();
		Date now = new Date();
		record.setTbuNumber(input.getTbuNumber());
		record.setTbuMachine(input.getTbuMachine());
		record.setTbuNumber(input.getTbuNumber());
		record.setTbuProtocol(input.getTbuProtocol());
		record.setTbuRemarks(input.getTbuRemarks());
		record.setTbuSimNo(input.getTbuSimNo());
		record.setTbuStatus(input.getTbuStatus());
		record.setTbuTeType(input.getTbuTeType());
		record.setTbuEditor(0);
		record.setTbuFile(input.getTbuFile());
		record.setTbuAddTime(now);
		record.setTbuUpdateTime(now);
		tbUpgradeMapper.insertSelective(record);
	}

	@Override
	public void del(BaseDeleteInput input) {
		TbUpgradeExample ex = new TbUpgradeExample();
		TbUpgradeExample.Criteria excri = ex.createCriteria();
		excri.andTbuIdIn(input.getIds());
		tbUpgradeMapper.deleteByExample(ex);
	}

	@Override
	public void mod(TbUpgradeAddInput input) {
		TbUpgrade record = new TbUpgrade();
		Date now = new Date();
		record.setTbuId(input.getTbuId());
		record.setTbuNumber(input.getTbuNumber());
		record.setTbuMachine(input.getTbuMachine());
		record.setTbuNumber(input.getTbuNumber());
		record.setTbuProtocol(input.getTbuProtocol());
		record.setTbuRemarks(input.getTbuRemarks());
		record.setTbuSimNo(input.getTbuSimNo());
		record.setTbuStatus(input.getTbuStatus());
		record.setTbuTeType(input.getTbuTeType());
		record.setTbuFile(input.getTbuFile());
		record.setTbuUpdateTime(now);
		tbUpgradeMapper.insertSelective(record);

	}

	@Override
	public TbUpgrade mod(Integer tbuId) {
		TbUpgrade tu = tbUpgradeMapper.selectByPrimaryKey(tbuId);
		return tu;
	}

	@Override
	public PageInfo<TbUpgrade> que(TbUpgradeQueryInput input) {
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		
		TbUpgradeExample ex = new TbUpgradeExample();
		TbUpgradeExample.Criteria exc = ex.createCriteria();
		if(null != input.getTbuId()){
			exc.andTbuIdEqualTo(input.getTbuId());
		}
		if(null != input.getTbuMachineMin()){
			exc.andTbuMachineGreaterThanOrEqualTo(input.getTbuMachineMin());
		}
		if(null != input.getTbuMachineMax()){
			exc.andTbuMachineLessThanOrEqualTo(input.getTbuMachineMax());
		}
		if(StringUtils.isNotBlank(input.getTbuNumber())){
			exc.andTbuNumberEqualTo(input.getTbuNumber());
		}
		if(StringUtils.isNotBlank(input.getTbuSimNo())){
			exc.andTbuSimNoEqualTo(input.getTbuSimNo());
		}
		if(null != input.getTbuTeType()){
			exc.andTbuTeTypeEqualTo(input.getTbuTeType());
		}
		if(null != input.getTbuProtocol()){
			exc.andTbuProtocolEqualTo(input.getTbuProtocol());
		}
		if(null != input.getTbuAddTimeStart()){
			exc.andTbuAddTimeGreaterThanOrEqualTo(input.getTbuAddTimeStart());
		}
		if(null != input.getTbuAddTimeEnd()){
			exc.andTbuAddTimeLessThanOrEqualTo(input.getTbuAddTimeEnd());
		}
		if(null != input.getTbuUpdateTimeStart()){
			exc.andTbuUpdateTimeGreaterThanOrEqualTo(input.getTbuUpdateTimeStart());
		}
		if(null != input.getTbuUpdateTimeEnd()){
			exc.andTbuUpdateTimeLessThanOrEqualTo(input.getTbuUpdateTimeEnd());
		}
		if(null != input.getTbuStatus()){
			exc.andTbuStatusEqualTo(input.getTbuStatus());
		}
		List<TbUpgrade> tulist = tbUpgradeMapper.selectByExample(ex);
		PageInfo<TbUpgrade> pinfo = new PageInfo<TbUpgrade>(tulist);
		return pinfo;
	}

}
