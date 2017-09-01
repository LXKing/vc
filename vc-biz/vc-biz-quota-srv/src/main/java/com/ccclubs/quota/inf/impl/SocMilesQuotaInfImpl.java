package com.ccclubs.quota.inf.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.SocMilesQuotaInf;
import com.ccclubs.quota.orm.mapper.SocMilesBasicZtMapper;
import com.ccclubs.quota.orm.mapper.SocMilesBizQuotaMapper;
import com.ccclubs.quota.orm.mapper.SocMilesQuotaMapper;
import com.ccclubs.quota.orm.model.SocMilesBasicZt;
import com.ccclubs.quota.orm.model.SocMilesBasicZtExample;
import com.ccclubs.quota.orm.model.SocMilesBizQuota;
import com.ccclubs.quota.orm.model.SocMilesBizQuotaExample;
import com.ccclubs.quota.orm.model.SocMilesQuota;
import com.ccclubs.quota.orm.model.SocMilesQuotaExample;
import com.ccclubs.quota.vo.SocMilesBasicZtInput;
import com.ccclubs.quota.vo.SocMilesBizQuotaInput;
import com.ccclubs.quota.vo.SocMilesQuotaInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;

@Service(version = "1.0.0")
public class SocMilesQuotaInfImpl implements SocMilesQuotaInf {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final float KWH = 24.2f;

	@Resource
	private SocMilesBizQuotaMapper socMilesBizQuotaMapper;
	@Resource
	private SocMilesQuotaMapper socMilesQuotaMapper;
	@Resource
	private SocMilesBasicZtMapper socMilesBasicZtMapper;

	@Override
	public PageInfo<SocMilesBizQuota> bizQuota(SocMilesBizQuotaInput input) {
		logger.debug("-------------");
		SocMilesBizQuotaExample example = new SocMilesBizQuotaExample();
		SocMilesBizQuotaExample.Criteria ecri = example.createCriteria();
		if (StringUtils.isNotBlank(input.getCsVin())) {
			ecri.andCsVinEqualTo(input.getCsVin());
		}
		if (StringUtils.isNotBlank(input.getCsNumber())) {
			ecri.andCsNumberEqualTo(input.getCsNumber());
		}

		String sortFiled = input.getSortField();
		if (StringUtils.isNoneBlank(sortFiled)) {
			String sort = null == input.getSortOrder() ? "desc" : input.getSortOrder();
			if (sort.startsWith("asc")) {
				sort = "asc";
			} else if (sort.startsWith("desc")) {
				sort = "desc";
			}
			if ("electricRange".equals(sortFiled)) {
				example.setOrderByClause("electric_range " + sort);
			} else if ("maxChargePower".equals(sortFiled)) {
				example.setOrderByClause("max_charge_power " + sort);
			} else if ("minChargeTime".equals(sortFiled)) {
				example.setOrderByClause("min_charge_time " + sort);
			}
		}
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<SocMilesBizQuota> list = socMilesBizQuotaMapper.selectByExample(example);
		PageInfo<SocMilesBizQuota> pinfo = new PageInfo<SocMilesBizQuota>(list);
		return pinfo;
	}

	@Override
	public PageInfo<SocMilesBasicZt> bizQuotaDetail(SocMilesBasicZtInput input) {
		logger.debug("-------------");
		SocMilesBasicZtExample example = new SocMilesBasicZtExample();
		SocMilesBasicZtExample.Criteria ecri = example.createCriteria();
		if (StringUtils.isNotBlank(input.getCsVin())) {
			ecri.andCsVinEqualTo(input.getCsVin());
		}
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<SocMilesBasicZt> list = socMilesBasicZtMapper.selectByExample(example);
		PageInfo<SocMilesBasicZt> pinfo = new PageInfo<SocMilesBasicZt>(list);
		return pinfo;
	}

	@Override
	public PageInfo<SocMilesQuota> calcQuota(SocMilesQuotaInput input) {
		SocMilesQuotaExample example = new SocMilesQuotaExample();
		SocMilesQuotaExample.Criteria ecri = example.createCriteria();
		if (StringUtils.isNotBlank(input.getCsVin())) {
			ecri.andCsVinEqualTo(input.getCsVin());
		}
		if (StringUtils.isNotBlank(input.getCsNumber())) {
			ecri.andCsNumberEqualTo(input.getCsNumber());
		}
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<SocMilesQuota> list = socMilesQuotaMapper.selectByExample(example);
		PageInfo<SocMilesQuota> pinfo = new PageInfo<SocMilesQuota>(list);
		List<SocMilesQuota> plist = pinfo.getList();
		SocMilesBasicZtExample zte = null;
		List<SocMilesBasicZt> ztList = null;
		int ztLen = 0;
		for (SocMilesQuota smq : plist) {
			zte = new SocMilesBasicZtExample();
			SocMilesBasicZtExample.Criteria ztcri = zte.createCriteria();
			ztcri.andCsVinEqualTo(smq.getCsVin());
			ztcri.andStartTimeGreaterThanOrEqualTo("2017-01-01 00:00:00");
			ztcri.andStartTimeLessThanOrEqualTo("2017-06-31 23:59:59");
			zte.setOrderByClause("start_time asc");
			ztList = socMilesBasicZtMapper.selectByExample(zte);
			ztLen = null == ztList ? 0 : ztList.size();
			this.socCalc(smq, ztList, ztLen);
		}
		return pinfo;
	}

	private void socCalc(SocMilesQuota smq, List<SocMilesBasicZt> ztList, int ztLen) {
		SocMilesBasicZt zti = null;
		SocMilesBasicZt ztip1 = null;
		int ztLenLast = ztLen - 1;
		float sumE = 0.00f;
		int countE = 0;
		float maxChargePower = 0.00f;
		List<Float> minChargeTimeList = new ArrayList<Float>();
		float sumM = 0.00f;
		int countM = 0;
		float sumSOC = 0.00f;
		if(ztLen > 1){
			for (int i = 0; i < ztLen; i++) {
				zti = ztList.get(i);
				long paceTime = zti.getPaceTimemills();
				int ztiStartSoc = zti.getStartSoc();
				int ztiEndSoc = zti.getEndSoc();
				smq.setCsNumber(zti.getCsNumber());
				// 车辆纯电续驶里程
				if (i < ztLenLast) {
					ztip1 = ztList.get(i + 1);

					float ztiEndMiles = zti.getEndMiles();

					int p1StartSoc = ztip1.getStartSoc();
					float p1StartMiles = ztip1.getStartMiles();

					float stepMile = p1StartMiles - ztiEndMiles;
					float stepSoc = (float) (ztiEndSoc - p1StartSoc);

					float er = stepSoc <= 0 ? 0 : stepMile / stepSoc;
					if (er < 2 && er > 0) {
						sumE += er;
						countE++;
					}
				}
				// 最大充电功率
				float soc = (float) (ztiEndSoc - ztiStartSoc);

				float chargePower = (soc * KWH / 100) / ((float) paceTime / (1000 * 60 * 60));
				if (chargePower > 0 && chargePower < 20) {
					if (chargePower > maxChargePower) {
						maxChargePower = chargePower;
					}
				}
				// 车辆一次充满电所用最少时间

				if (soc > 0) {
					float socMinTime = soc == 0 ? 0 : ((float) paceTime / (1000 * 60 * 60)) / soc;
					if (socMinTime > 0 && socMinTime < 20) {
						sumSOC = sumSOC + soc;
						sumM = sumM + ztiStartSoc;
						countM ++;
						minChargeTimeList.add(socMinTime);
					}
				}
			}
		}
		
		// 车辆纯电续驶里程
		float electricRange = countE == 0 ? 0 : ((float) sumE / (float) countE) * 100;
		smq.setElectricRange(new BigDecimal(electricRange).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 最大充电功率
		smq.setMaxChargePower(new BigDecimal(maxChargePower).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 车辆一次充满电所用最少时间
		// 计算SOC起算点
		float avg_value = 0;//countM ==0 ? 0 : sumM / (float)countM;
		logger.debug("count:{}", countM);
		float minChargeTime = Float.MAX_VALUE;
		for (float min : minChargeTimeList) {
			float mct = min * (100 - avg_value);
			if(mct >= 0 && mct < minChargeTime){
				minChargeTime = mct;
			}
		}
		minChargeTime = null == minChargeTimeList || minChargeTimeList.size() ==0 ? 0 : minChargeTime;
		smq.setMinChargeTime(new BigDecimal(minChargeTime).setScale(2, BigDecimal.ROUND_HALF_UP));
		//累计充电量
		smq.setCumulativeCharge(new BigDecimal(sumSOC).setScale(2, BigDecimal.ROUND_HALF_UP));

	}

	@Override
	public void quotaBuilder() {
		SocMilesBasicZtExample zte = new SocMilesBasicZtExample();
		SocMilesBasicZtExample.Criteria ztcri = zte.createCriteria();
		ztcri.andStartTimeGreaterThanOrEqualTo("2017-01-01 00:00:00");
		ztcri.andStartTimeLessThanOrEqualTo("2017-06-31 23:59:59");
		//ztcri.andCsVinEqualTo("LJ8E3C1M1GB008801");
		//zte.setOrderByClause("start_time asc");
		List<SocMilesBasicZt> allList = socMilesBasicZtMapper.selectByExample(zte);
		Map<String, List<SocMilesBasicZt>> map = new HashMap<String, List<SocMilesBasicZt>>();
		String csVin = null;
		List<SocMilesBasicZt> list = null;
		for (SocMilesBasicZt dmq : allList) {
			csVin = dmq.getCsVin();
			if(map.containsKey(csVin)){
				list = map.get(csVin);
				if(null != list){
					list.add(dmq);
				}
			}else{
				list = new ArrayList<SocMilesBasicZt>();
				list.add(dmq);
				map.put(csVin, list);
			}
		}
		
		Ordering<SocMilesBasicZt> ordering = Ordering.from(new Comparator<SocMilesBasicZt>() {
            @Override
            public int compare(SocMilesBasicZt o1, SocMilesBasicZt o2) {
            	Date d1 = null;
				Date d2 = null;
				try {
					d1 = DateUtils.parseDate(o1.getStartTime(), new String[]{"yyyy-MM-dd HH:mm:ss"});
					d2 = DateUtils.parseDate(o2.getStartTime(), new String[]{"yyyy-MM-dd HH:mm:ss"});
				} catch (ParseException e) {
					logger.error("date comparator error", e);
				}
                return Longs.compare(d1.getTime(),d2.getTime());
            }
        });
		Iterator<Entry<String, List<SocMilesBasicZt>>> it = map.entrySet().iterator();
		Entry<String, List<SocMilesBasicZt>> entry = null;
		List<SocMilesBasicZt> ztkeyList = null;
		List<SocMilesBasicZt> ztList = null;
		SocMilesQuota smq = null;
		long serialNo = 0;
		while(it.hasNext()){
			entry = it.next();
			ztkeyList = entry.getValue();
			smq = new SocMilesQuota();
			ztList = ordering.sortedCopy(ztkeyList);
			int ztLen = null == ztList ? 0 : ztList.size();
			if(ztLen == 1){
				smq.setCsNumber(ztList.get(0).getCsNumber());
			}
			this.socCalc(smq, ztList, ztLen);
			logger.debug(smq.toString());
			SocMilesBizQuota record = new SocMilesBizQuota();
			record.setCsVin(entry.getKey());
			record.setCsNumber(smq.getCsNumber());
			record.setSerialNo(serialNo);
			record.setElectricRange(smq.getElectricRange());
			record.setMaxChargePower(smq.getMaxChargePower());
			record.setMinChargeTime(smq.getMinChargeTime());
			record.setCumulativeCharge(smq.getCumulativeCharge());
			socMilesBizQuotaMapper.insert(record);
			serialNo ++;
		}
	}

}
