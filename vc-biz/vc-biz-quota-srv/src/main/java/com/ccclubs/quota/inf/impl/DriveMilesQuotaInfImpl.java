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
import com.ccclubs.quota.inf.DriveMilesQuotaInf;
import com.ccclubs.quota.orm.mapper.DriveMilesBasicZtMapper;
import com.ccclubs.quota.orm.mapper.DriveMilesBizQuotaMapper;
import com.ccclubs.quota.orm.mapper.DriveMilesQuotaMapper;
import com.ccclubs.quota.orm.model.DriveMilesBasicZt;
import com.ccclubs.quota.orm.model.DriveMilesBasicZtExample;
import com.ccclubs.quota.orm.model.DriveMilesBizQuota;
import com.ccclubs.quota.orm.model.DriveMilesBizQuotaExample;
import com.ccclubs.quota.orm.model.DriveMilesQuota;
import com.ccclubs.quota.orm.model.DriveMilesQuotaExample;
import com.ccclubs.quota.vo.DriveMilesBasicZtInput;
import com.ccclubs.quota.vo.DriveMilesBizQuotaInput;
import com.ccclubs.quota.vo.DriveMilesQuotaInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;

@Service(version = "1.0.0")
public class DriveMilesQuotaInfImpl implements DriveMilesQuotaInf {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final float KWH = 24.2f;

	@Resource
	private DriveMilesBizQuotaMapper driveMilesBizQuotaMapper;
	@Resource
	private DriveMilesQuotaMapper driveMilesQuotaMapper;
	@Resource
	private DriveMilesBasicZtMapper driveMilesBasicZtMapper;

	@Override
	public PageInfo<DriveMilesBizQuota> bizQuota(DriveMilesBizQuotaInput input) {
		logger.debug("-------------");
		DriveMilesBizQuotaExample example = new DriveMilesBizQuotaExample();
		DriveMilesBizQuotaExample.Criteria ecri = example.createCriteria();
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
			if ("monthlyAvgMile".equals(sortFiled)) {
				example.setOrderByClause("monthly_avg_mile " + sort);
			} else if ("avgDriveTimePerDay".equals(sortFiled)) {
				example.setOrderByClause("avg_drive_time_per_day " + sort);
			} else if ("powerConsumePerHundred".equals(sortFiled)) {
				example.setOrderByClause("power_consume_per_hundred " + sort);
			}
		}
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<DriveMilesBizQuota> list = driveMilesBizQuotaMapper.selectByExample(example);
		PageInfo<DriveMilesBizQuota> pinfo = new PageInfo<DriveMilesBizQuota>(list);
		return pinfo;
	}

	@Override
	public PageInfo<DriveMilesBasicZt> bizQuotaDetail(DriveMilesBasicZtInput input) {
		DriveMilesBasicZtExample example = new DriveMilesBasicZtExample();
		DriveMilesBasicZtExample.Criteria ecri = example.createCriteria();
		if (StringUtils.isNotBlank(input.getCsVin())) {
			ecri.andCsVinEqualTo(input.getCsVin());
		}
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<DriveMilesBasicZt> list = driveMilesBasicZtMapper.selectByExample(example);
		PageInfo<DriveMilesBasicZt> pinfo = new PageInfo<DriveMilesBasicZt>(list);
		return pinfo;
	}

	@Override
	public PageInfo<DriveMilesQuota> calcQuota(DriveMilesQuotaInput input) {
		DriveMilesQuotaExample example = new DriveMilesQuotaExample();
		DriveMilesQuotaExample.Criteria ecri = example.createCriteria();
		if (StringUtils.isNotBlank(input.getCsVin())) {
			ecri.andCsVinEqualTo(input.getCsVin());
		}
		if (StringUtils.isNotBlank(input.getCsNumber())) {
			ecri.andCsNumberEqualTo(input.getCsNumber());
		}
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<DriveMilesQuota> dlist = driveMilesQuotaMapper.selectByExample(example);
		PageInfo<DriveMilesQuota> pinfo = new PageInfo<DriveMilesQuota>(dlist);
		List<DriveMilesQuota> plist = pinfo.getList();
		DriveMilesBasicZtExample zte = null;
		List<DriveMilesBasicZt> ztList = null;
		int ztLen = 0;
		for (DriveMilesQuota dmq : plist) {
			zte = new DriveMilesBasicZtExample();
			DriveMilesBasicZtExample.Criteria ztcri = zte.createCriteria();
			ztcri.andCsVinEqualTo(dmq.getCsVin());
			ztcri.andStartTimeGreaterThanOrEqualTo("2017-01-01 00:00:00");
			ztcri.andStartTimeLessThanOrEqualTo("2017-06-31 23:59:59");
			zte.setOrderByClause("start_time asc");
			ztList = driveMilesBasicZtMapper.selectByExample(zte);
			ztLen = null == ztList ? 0 : ztList.size();
			this.driveCalc(dmq, ztList, ztLen);
		}
		return pinfo;
	}

	private void driveCalc(DriveMilesQuota dmq, List<DriveMilesBasicZt> ztList, int ztLen) {
		float formulaSum = 0.00f;
		int formulaCount = 0;
		HashMap<String, Float> monthMap = new HashMap<String, Float>();
		float mileSum = 0.00f;
		HashMap<String, Long> dayMap = new HashMap<String, Long>();
		long daySum = 0L;
		String startTime = null;
		if(ztLen > 1){
			for (DriveMilesBasicZt zt : ztList) {
				int socStart = zt.getStartSoc();
				int socEnd = zt.getEndSoc();
				float milesStart = zt.getStartMiles();
				float milesEnd = zt.getEndMiles();
				startTime = zt.getStartTime();
				dmq.setCsNumber(zt.getCsNumber());

				int soc = socStart - socEnd;
				float mile = milesEnd - milesStart;

				// 百公里耗电量
				float formulaH = mile <= 0 ? 0 : soc / mile;
				if (formulaH > 0 && formulaH <= 1) {
					formulaSum += formulaH;
					formulaCount++;
				}
				// 月均行驶里程
				if (mile > 0 && mile < 2500) {
					mileSum += mile;
					String startTimeMonth = startTime.substring(0, 7);
					if (monthMap.containsKey(startTimeMonth)) {
						float old_miles = monthMap.get(startTimeMonth);
						old_miles += mile;
						monthMap.put(startTimeMonth, old_miles);
					} else {
						monthMap.put(startTimeMonth, mile);
					}
				}
				// 日均行驶时间
				long paceTime = zt.getPaceTimemills();
				if (paceTime > 0) {
					daySum += paceTime;
					String startTimeDay = startTime.substring(0, 10);
					if (dayMap.containsKey(startTimeDay)) {
						long old_timemills = dayMap.get(startTimeDay);
						old_timemills += paceTime;
						dayMap.put(startTimeDay, old_timemills);
					} else {
						dayMap.put(startTimeDay, paceTime);
					}
				}
			}
		}
		
		// 百公里耗电量
		float powerConsumePerHundred = formulaCount == 0 ? 0 : formulaSum / (float) formulaCount * KWH;
		dmq.setPowerConsumePerHundred(new BigDecimal(powerConsumePerHundred).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 月均行驶里程
		int monthLen = monthMap.size() == 0 ? 0 : monthMap.size();
		float monthlyAvgMile = monthLen == 0 ? 0 : (float) mileSum / (float) monthLen;
		dmq.setMonthlyAvgMile(new BigDecimal(monthlyAvgMile).setScale(2, BigDecimal.ROUND_HALF_UP));
		//累计行驶里程
		dmq.setCumulativeMileage(new BigDecimal(mileSum).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 日均行驶时间
		int dayLen = dayMap.size() == 0 ? 0 : dayMap.size();
		float avgDriveTimePerDay = dayLen == 0 ? 0 :  ((float) daySum / (float)dayLen)/(1000*60*60);
		dmq.setAvgDriveTimePerDay(new BigDecimal(avgDriveTimePerDay).setScale(2, BigDecimal.ROUND_HALF_UP));
	}

	@Override
	public void quotaBuilder() {
		DriveMilesBasicZtExample zte = new DriveMilesBasicZtExample();
		DriveMilesBasicZtExample.Criteria ztcri = zte.createCriteria();
		ztcri.andStartTimeGreaterThanOrEqualTo("2017-01-01 00:00:00");
		ztcri.andStartTimeLessThanOrEqualTo("2017-06-31 23:59:59");
		//zte.setOrderByClause("start_time asc");
		List<DriveMilesBasicZt> allList = driveMilesBasicZtMapper.selectByExample(zte);
		Map<String, List<DriveMilesBasicZt>> map = new HashMap<String, List<DriveMilesBasicZt>>();
		String csVin = null;
		List<DriveMilesBasicZt> list = null;
		for (DriveMilesBasicZt dmq : allList) {
			csVin = dmq.getCsVin();
			if(map.containsKey(csVin)){
				list = map.get(csVin);
				if(null != list){
					list.add(dmq);
				}
			}else{
				list = new ArrayList<DriveMilesBasicZt>();
				list.add(dmq);
				map.put(csVin, list);
			}
		}
		
		Ordering<DriveMilesBasicZt> ordering = Ordering.from(new Comparator<DriveMilesBasicZt>() {
            @Override
            public int compare(DriveMilesBasicZt o1, DriveMilesBasicZt o2) {
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
		Iterator<Entry<String, List<DriveMilesBasicZt>>> it = map.entrySet().iterator();
		Entry<String, List<DriveMilesBasicZt>> entry = null;
		List<DriveMilesBasicZt> ztkeyList = null;
		List<DriveMilesBasicZt> ztList = null;
		DriveMilesQuota dmq = null;
		long serialNo = 0;
		while(it.hasNext()){
			entry = it.next();
			ztkeyList = entry.getValue();
			dmq = new DriveMilesQuota();
			ztList = ordering.sortedCopy(ztkeyList);
			int ztLen = null == ztList ? 0 : ztList.size();
			if(ztLen == 1){
				dmq.setCsNumber(ztList.get(0).getCsNumber());
			}
			this.driveCalc(dmq, ztList, ztLen);
			
			DriveMilesBizQuota record = new DriveMilesBizQuota();
			record.setCsVin(entry.getKey());
			record.setAvgDriveTimePerDay(dmq.getAvgDriveTimePerDay());
			record.setMonthlyAvgMile(dmq.getMonthlyAvgMile());
			record.setPowerConsumePerHundred(dmq.getPowerConsumePerHundred());
			record.setCsNumber(dmq.getCsNumber());
			record.setCumulativeMileage(dmq.getCumulativeMileage());
			record.setSerialNo(serialNo);
			driveMilesBizQuotaMapper.insert(record);
			serialNo ++;
		}
		
	}

}
