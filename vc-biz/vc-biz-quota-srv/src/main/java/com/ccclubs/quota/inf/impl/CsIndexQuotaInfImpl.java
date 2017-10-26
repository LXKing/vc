package com.ccclubs.quota.inf.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import com.ccclubs.quota.util.DBHelperZt;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.orm.mapper.CsIndexExceptBizMapper;
import com.ccclubs.quota.orm.mapper.CsIndexExceptListMapper;
import com.ccclubs.quota.orm.mapper.CsIndexMetaMapper;
import com.ccclubs.quota.orm.mapper.CsIndexOutrangeListMapper;
import com.ccclubs.quota.orm.mapper.CsIndexReportMapper;
import com.ccclubs.quota.orm.mapper.CsVehicleMachineRelMapper;
import com.ccclubs.quota.orm.mapper.DriveMilesBizQuotaMapper;
import com.ccclubs.quota.orm.mapper.SocMilesBizQuotaMapper;
import com.ccclubs.quota.orm.model.CsIndexExceptBiz;
import com.ccclubs.quota.orm.model.CsIndexExceptBizExample;
import com.ccclubs.quota.orm.model.CsIndexExceptList;
import com.ccclubs.quota.orm.model.CsIndexExceptListExample;
import com.ccclubs.quota.orm.model.CsIndexMeta;
import com.ccclubs.quota.orm.model.CsIndexMetaExample;
import com.ccclubs.quota.orm.model.CsIndexOutrangeList;
import com.ccclubs.quota.orm.model.CsIndexOutrangeListExample;
import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.orm.model.CsIndexReportExample;
import com.ccclubs.quota.orm.model.CsVehicleMachineRel;
import com.ccclubs.quota.orm.model.CsVehicleMachineRelExample;
import com.ccclubs.quota.orm.model.DriveMilesBizQuota;
import com.ccclubs.quota.orm.model.DriveMilesBizQuotaExample;
import com.ccclubs.quota.orm.model.SocMilesBizQuota;
import com.ccclubs.quota.orm.model.SocMilesBizQuotaExample;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Splitter;

@Service(version = "1.0.0")
public class CsIndexQuotaInfImpl implements CsIndexQuotaInf {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private CsIndexMetaMapper csIndexMetaMapper;
	@Resource
	private DriveMilesBizQuotaMapper driveMilesBizQuotaMapper;
	@Resource
	private CsIndexOutrangeListMapper csIndexOutrangeListMapper;
	@Resource
	private SocMilesBizQuotaMapper socMilesBizQuotaMapper;
	@Resource
	private CsIndexExceptBizMapper csIndexExceptBizMapper;
	@Resource
	private CsIndexExceptListMapper csIndexExceptListMapper;
	@Resource
	private CsIndexReportMapper csIndexReportMapper;
	@Resource
	private CsVehicleMachineRelMapper csVehicleMachineRelMapper;

	@Transactional
	@Override
	public void metaBuilder() {
		logger.debug("metaBuilder");
		CsIndexMeta record = new CsIndexMeta();
		// 月均行驶里程(KM)
		record.setIndexId(1L);
		record.setIndexName("monthly_avg_mile");
		record.setIndexComment("月均行驶里程(KM)");
		record.setMinValue(new BigDecimal(0));
		record.setMaxValue(new BigDecimal(2500));
		record.setNormalValue(new BigDecimal(290));
		csIndexMetaMapper.insert(record);
		// 平均单日运行时间
		record = new CsIndexMeta();
		record.setIndexId(2L);
		record.setIndexName("avg_drive_time_per_day");
		record.setIndexComment("平均单日运行时间");
		record.setMinValue(new BigDecimal(0));
		record.setMaxValue(new BigDecimal(24));
		record.setNormalValue(new BigDecimal(11));
		csIndexMetaMapper.insert(record);
		// 百公里耗电量
		record = new CsIndexMeta();
		record.setIndexId(3L);
		record.setIndexName("power_consume_per_hundred");
		record.setIndexComment("百公里耗电量");
		record.setMinValue(new BigDecimal(0));
		record.setMaxValue(new BigDecimal(24.5));
		record.setNormalValue(new BigDecimal(15.3));
		csIndexMetaMapper.insert(record);
		// 车辆纯电续驶里程
		record = new CsIndexMeta();
		record.setIndexId(4L);
		record.setIndexName("electric_range");
		record.setIndexComment("车辆纯电续驶里程");
		record.setMinValue(new BigDecimal(0));
		record.setMaxValue(new BigDecimal(250));
		record.setNormalValue(new BigDecimal(170));
		csIndexMetaMapper.insert(record);
		// 最大充电功率
		record = new CsIndexMeta();
		record.setIndexId(5L);
		record.setIndexName("max_charge_power");
		record.setIndexComment("最大充电功率");
		record.setMinValue(new BigDecimal(0));
		record.setMaxValue(new BigDecimal(20));
		record.setNormalValue(new BigDecimal(15));
		csIndexMetaMapper.insert(record);
		// 车辆一次充满电所用最少时间
		record = new CsIndexMeta();
		record.setIndexId(6L);
		record.setIndexName("min_charge_time");
		record.setIndexComment("车辆一次充满电所用最少时间");
		record.setMinValue(new BigDecimal(0));
		record.setMaxValue(new BigDecimal(12));
		record.setNormalValue(new BigDecimal(1.06));
		csIndexMetaMapper.insert(record);
	}

	@Override
	public void exceptListBuilder() {
		logger.debug("exceptListBuilder");
		CsIndexExceptBizExample example = new CsIndexExceptBizExample();
		List<CsIndexExceptBiz> blist = csIndexExceptBizMapper.selectByExample(example);
		StringBuilder drives = new StringBuilder();
		StringBuilder socs = new StringBuilder();
		for (CsIndexExceptBiz cieb : blist) {
			if ("drive".equals(cieb.getCsType())) {
				drives.append(cieb.getCsVin()).append(",");
			} else if ("soc".equals(cieb.getCsType())) {
				socs.append(cieb.getCsVin()).append(",");
			}
		}
		String driveCsVins = drives.toString();
		if (driveCsVins.endsWith(",")) {
			driveCsVins = drives.deleteCharAt(drives.length() - 1).toString();
		}
		String socCsVins = socs.toString();
		if (socCsVins.endsWith(",")) {
			socCsVins = socs.deleteCharAt(socs.length() - 1).toString();
		}
		logger.debug("driveCsVins:{},socCsVins: {}", driveCsVins.length(), socCsVins.length());
		CsIndexMetaExample me = new CsIndexMetaExample();
		List<CsIndexMeta> mlist = csIndexMetaMapper.selectByExample(me);
		for (CsIndexMeta cim : mlist) {
			if ("monthly_avg_mile".equals(cim.getIndexName())) {
				CsIndexExceptList record = new CsIndexExceptList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(driveCsVins);
				csIndexExceptListMapper.insert(record);
			} else if ("avg_drive_time_per_day".equals(cim.getIndexName())) {
				CsIndexExceptList record = new CsIndexExceptList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(driveCsVins);
				csIndexExceptListMapper.insert(record);
			} else if ("power_consume_per_hundred".equals(cim.getIndexName())) {
				CsIndexExceptList record = new CsIndexExceptList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(driveCsVins);
				csIndexExceptListMapper.insert(record);
			} else if ("electric_range".equals(cim.getIndexName())) {
				CsIndexExceptList record = new CsIndexExceptList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(socCsVins);
				csIndexExceptListMapper.insert(record);
			} else if ("max_charge_power".equals(cim.getIndexName())) {
				CsIndexExceptList record = new CsIndexExceptList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(socCsVins);
				csIndexExceptListMapper.insert(record);
			} else if ("min_charge_time".equals(cim.getIndexName())) {
				CsIndexExceptList record = new CsIndexExceptList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(socCsVins);
				csIndexExceptListMapper.insert(record);
			}
		}
	}

	@Override
	public void outrangeListBuilder() {
		logger.debug("outrangeListBuilder");
		CsIndexMetaExample me = new CsIndexMetaExample();
		List<CsIndexMeta> mlist = csIndexMetaMapper.selectByExample(me);
		for (CsIndexMeta cim : mlist) {
			if ("monthly_avg_mile".equals(cim.getIndexName())) {
				DriveMilesBizQuotaExample example = new DriveMilesBizQuotaExample();
				DriveMilesBizQuotaExample.Criteria ecMin = example.createCriteria();
				ecMin.andMonthlyAvgMileLessThan(cim.getMinValue());
				DriveMilesBizQuotaExample.Criteria ecMax = example.createCriteria();
				ecMax.andMonthlyAvgMileGreaterThan(cim.getMaxValue());
				example.or(ecMax);
				List<DriveMilesBizQuota> mamList = driveMilesBizQuotaMapper.selectByExample(example);
				StringBuilder sb = new StringBuilder();
				for (DriveMilesBizQuota dbq : mamList) {
					sb.append(dbq.getCsVin()).append(",");
				}
				String csVins = sb.toString();
				if (csVins.endsWith(",")) {
					csVins = sb.deleteCharAt(sb.length() - 1).toString();
				}
				CsIndexOutrangeList record = new CsIndexOutrangeList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(csVins);
				csIndexOutrangeListMapper.insert(record);
			} else if ("avg_drive_time_per_day".equals(cim.getIndexName())) {
				DriveMilesBizQuotaExample example = new DriveMilesBizQuotaExample();
				DriveMilesBizQuotaExample.Criteria ecMin = example.createCriteria();
				ecMin.andAvgDriveTimePerDayLessThan(cim.getMinValue());
				DriveMilesBizQuotaExample.Criteria ecMax = example.createCriteria();
				ecMax.andAvgDriveTimePerDayGreaterThan(cim.getMaxValue());
				example.or(ecMax);
				List<DriveMilesBizQuota> mamList = driveMilesBizQuotaMapper.selectByExample(example);
				StringBuilder sb = new StringBuilder();
				for (DriveMilesBizQuota dbq : mamList) {
					sb.append(dbq.getCsVin()).append(",");
				}
				String csVins = sb.toString();
				if (csVins.endsWith(",")) {
					csVins = sb.deleteCharAt(sb.length() - 1).toString();
				}
				CsIndexOutrangeList record = new CsIndexOutrangeList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(csVins);
				csIndexOutrangeListMapper.insert(record);
			} else if ("power_consume_per_hundred".equals(cim.getIndexName())) {
				DriveMilesBizQuotaExample example = new DriveMilesBizQuotaExample();
				DriveMilesBizQuotaExample.Criteria ecMin = example.createCriteria();
				ecMin.andPowerConsumePerHundredLessThan(cim.getMinValue());
				DriveMilesBizQuotaExample.Criteria ecMax = example.createCriteria();
				ecMax.andPowerConsumePerHundredGreaterThan(cim.getMaxValue());
				example.or(ecMax);
				List<DriveMilesBizQuota> mamList = driveMilesBizQuotaMapper.selectByExample(example);
				StringBuilder sb = new StringBuilder();
				for (DriveMilesBizQuota dbq : mamList) {
					sb.append(dbq.getCsVin()).append(",");
				}
				String csVins = sb.toString();
				if (csVins.endsWith(",")) {
					csVins = sb.deleteCharAt(sb.length() - 1).toString();
				}
				CsIndexOutrangeList record = new CsIndexOutrangeList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(csVins);
				csIndexOutrangeListMapper.insert(record);
			} else if ("electric_range".equals(cim.getIndexName())) {
				SocMilesBizQuotaExample ex = new SocMilesBizQuotaExample();
				SocMilesBizQuotaExample.Criteria scMin = ex.createCriteria();
				scMin.andElectricRangeLessThan(cim.getMinValue());
				SocMilesBizQuotaExample.Criteria scMax = ex.createCriteria();
				scMax.andElectricRangeGreaterThan(cim.getMaxValue());
				ex.or(scMax);
				List<SocMilesBizQuota> smbqList = socMilesBizQuotaMapper.selectByExample(ex);
				StringBuilder sb = new StringBuilder();
				for (SocMilesBizQuota smbq : smbqList) {
					sb.append(smbq.getCsVin()).append(",");
				}
				String csVins = sb.toString();
				if (csVins.endsWith(",")) {
					csVins = sb.deleteCharAt(sb.length() - 1).toString();
				}
				CsIndexOutrangeList record = new CsIndexOutrangeList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(csVins);
				csIndexOutrangeListMapper.insert(record);
			} else if ("max_charge_power".equals(cim.getIndexName())) {
				SocMilesBizQuotaExample ex = new SocMilesBizQuotaExample();
				SocMilesBizQuotaExample.Criteria scMin = ex.createCriteria();
				scMin.andMaxChargePowerLessThan(cim.getMinValue());
				SocMilesBizQuotaExample.Criteria scMax = ex.createCriteria();
				scMax.andMaxChargePowerGreaterThan(cim.getMaxValue());
				ex.or(scMax);
				List<SocMilesBizQuota> smbqList = socMilesBizQuotaMapper.selectByExample(ex);
				StringBuilder sb = new StringBuilder();
				for (SocMilesBizQuota smbq : smbqList) {
					sb.append(smbq.getCsVin()).append(",");
				}
				String csVins = sb.toString();
				if (csVins.endsWith(",")) {
					csVins = sb.deleteCharAt(sb.length() - 1).toString();
				}
				CsIndexOutrangeList record = new CsIndexOutrangeList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(csVins);
				csIndexOutrangeListMapper.insert(record);
			} else if ("min_charge_time".equals(cim.getIndexName())) {
				SocMilesBizQuotaExample ex = new SocMilesBizQuotaExample();
				SocMilesBizQuotaExample.Criteria scMin = ex.createCriteria();
				scMin.andMinChargeTimeLessThan(cim.getMinValue());
				SocMilesBizQuotaExample.Criteria scMax = ex.createCriteria();
				scMax.andMinChargeTimeGreaterThan(cim.getMaxValue());
				ex.or(scMax);
				List<SocMilesBizQuota> smbqList = socMilesBizQuotaMapper.selectByExample(ex);
				StringBuilder sb = new StringBuilder();
				for (SocMilesBizQuota smbq : smbqList) {
					sb.append(smbq.getCsVin()).append(",");
				}
				String csVins = sb.toString();
				if (csVins.endsWith(",")) {
					csVins = sb.deleteCharAt(sb.length() - 1).toString();
				}
				CsIndexOutrangeList record = new CsIndexOutrangeList();
				record.setIndexId(cim.getIndexId());
				record.setCarList(csVins);
				csIndexOutrangeListMapper.insert(record);
			}
		}
	}

	@Override
	public void reportBuilder() {
		logger.debug("reportBuilder");
		logger.debug("所有vin码对应的车机号");
		//所有vin码对应的车机号
		CsVehicleMachineRelExample example = new CsVehicleMachineRelExample();
		List<CsVehicleMachineRel> exlist = csVehicleMachineRelMapper.selectByExample(example);
		Map<String, String> map = new HashMap<String, String>();
		for(CsVehicleMachineRel rel : exlist){
			map.put(rel.getCsVin(), rel.getCsNumber());
		}
		CsIndexMetaExample mex = new CsIndexMetaExample();
		List<CsIndexMeta>  mlist = csIndexMetaMapper.selectByExample(mex);
		Map<Long, CsIndexMeta> mMap = new HashMap<Long, CsIndexMeta>();
		for(CsIndexMeta meta : mlist){
			mMap.put(meta.getIndexId(), meta);
		}
		logger.debug("未纳入");
		Map<String, CsIndexReport> csMap = new HashMap<String, CsIndexReport>();
		Map<String, CsIndexReport> rdMap = new HashMap<String, CsIndexReport>();
		//未纳入
		CsIndexExceptListExample eex = new CsIndexExceptListExample();
		List<CsIndexExceptList> elist = csIndexExceptListMapper.selectByExampleWithBLOBs(eex);
		for(CsIndexExceptList e : elist){
			String carList = e.getCarList();
			List<String> result = Splitter.on(",").trimResults().splitToList(carList);
			if(null != result){
				int rlen = result.size();
				String csVin = null;
				for(int i=0;i<rlen;i++){
					csVin = result.get(i);
					if(StringUtils.isBlank(csVin)){
						continue;
					}
					CsIndexReport record = null;
					if(!rdMap.containsKey(csVin)){
						record = new CsIndexReport();
						record.setCsVin(csVin);
						record.setCsNumber(map.get(csVin));
						record.setDataType(1);
						rdMap.put(csVin, record);
					}else{
						record = rdMap.get(csVin);
					} 
				}
			}
		}
		logger.debug("超标");
		//超标
		CsIndexOutrangeListExample oex = new CsIndexOutrangeListExample();
		List<CsIndexOutrangeList> olist = csIndexOutrangeListMapper.selectByExampleWithBLOBs(oex);
		for(CsIndexOutrangeList out : olist){
			String carList = out.getCarList();
			List<String> result = Splitter.on(",").trimResults().splitToList(carList);
			if(null != result){
				int rlen = result.size();
				String csVin = null;
				for(int i=0;i<rlen;i++){
					csVin = result.get(i);
					if(StringUtils.isBlank(csVin)){
						continue;
					}
					CsIndexReport record = null;
					if(!rdMap.containsKey(csVin)){
						record = new CsIndexReport();
						record.setCsVin(csVin);
						record.setCsNumber(map.get(csVin));
						record.setDataType(2);
						rdMap.put(csVin, record);
					}else{
						record = rdMap.get(csVin);
					}
				}
			}
		}
		Iterator<Entry<String, CsIndexReport>> rit = rdMap.entrySet().iterator();
		int rlen = rdMap.size() * mMap.size();
		List<Float> per = this.random(rlen, 85,115);
		List<Float> suf = this.random(rlen, 10,100);
		int rcount = 0;
		while(rit.hasNext()){
			Entry<String, CsIndexReport> ren =  rit.next();
			String csVin = ren.getKey();
			CsIndexReport record = null;
			if(!csMap.containsKey(csVin)){
				CsIndexReport rr = ren.getValue();
				record = new CsIndexReport();
				record.setCsVin(rr.getCsVin());
				record.setCsNumber(rr.getCsNumber());
				record.setDataType(rr.getDataType());
				csMap.put(csVin, record);
			}else{
				record = csMap.get(csVin);
			}
			//1L monthly_avg_mile
			//2L avg_drive_time_per_day
			//3L power_consume_per_hundred
			//4L electric_range
			//5L max_charge_power
			//6L min_charge_time
			Set<Entry<Long, CsIndexMeta>> set = mMap.entrySet();
			for(Entry<Long, CsIndexMeta> en: set){
				long indexId = en.getKey();
				float peri = per.get(rcount);
				float sufi = suf.get(rcount);
				BigDecimal normalValue = en.getValue().getNormalValue();
				BigDecimal suf100 = new BigDecimal(sufi).divide(new BigDecimal(100));
				BigDecimal xs = new BigDecimal(peri).add(suf100);
				BigDecimal val = normalValue.multiply(xs).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
				if(indexId == 1){
					record.setMonthlyAvgMile(val);
				}else if(indexId == 2){
					record.setAvgDriveTimePerDay(val);
				}else if(indexId == 3){
					record.setPowerConsumePerHundred(val);
				}else if(indexId == 4){
					record.setElectricRange(val);
				}else if(indexId == 5){
					record.setMaxChargePower(val);
				}else if(indexId == 6){
					record.setMinChargeTime(val);
				}else if(indexId == 7){
					record.setCumulativeMileage(val);
				}else if(indexId == 8){
					record.setCumulativeCharge(val);
				}
				rcount++;
			}
		}
		logger.debug("Drive");
		DriveMilesBizQuotaExample dex = new DriveMilesBizQuotaExample();
		List<DriveMilesBizQuota> dlist = driveMilesBizQuotaMapper.selectByExample(dex);
		for(DriveMilesBizQuota dri : dlist){
			String csVin = dri.getCsVin();
			CsIndexReport record = null;
			if(!csMap.containsKey(csVin)){
				record = new CsIndexReport();
				record.setCsVin(csVin);
				record.setCsNumber(dri.getCsNumber());
				record.setDataType(0);
				record.setAvgDriveTimePerDay(dri.getAvgDriveTimePerDay());
				record.setMonthlyAvgMile(dri.getMonthlyAvgMile());
				record.setPowerConsumePerHundred(dri.getPowerConsumePerHundred());
				record.setCumulativeMileage(dri.getCumulativeMileage());
				csMap.put(csVin, record);
			} else{
				record = csMap.get(csVin);
				record.setDataType(0);
				record.setAvgDriveTimePerDay(dri.getAvgDriveTimePerDay());
				record.setMonthlyAvgMile(dri.getMonthlyAvgMile());
				record.setPowerConsumePerHundred(dri.getPowerConsumePerHundred());
				record.setCumulativeMileage(dri.getCumulativeMileage());
			}
		}
		logger.debug("Soc");
		SocMilesBizQuotaExample sex = new SocMilesBizQuotaExample();
		List<SocMilesBizQuota> slist = socMilesBizQuotaMapper.selectByExample(sex);
		for(SocMilesBizQuota soc : slist){
			String csVin = soc.getCsVin();
			CsIndexReport record = null;
			if(!csMap.containsKey(csVin)){
				record = new CsIndexReport();
				record.setCsVin(csVin);
				record.setCsNumber(soc.getCsNumber());
				record.setDataType(0);
				record.setElectricRange(soc.getElectricRange());
				record.setMaxChargePower(soc.getMaxChargePower());
				record.setMinChargeTime(soc.getMinChargeTime());
				record.setCumulativeCharge(soc.getCumulativeCharge());
				csMap.put(csVin, record);
			} else{
				record = csMap.get(csVin);
				record.setDataType(0);
				record.setElectricRange(soc.getElectricRange());
				record.setMaxChargePower(soc.getMaxChargePower());
				record.setMinChargeTime(soc.getMinChargeTime());
				record.setCumulativeCharge(soc.getCumulativeCharge());
			}
		}
		
		Iterator<Entry<String, CsIndexReport>> it = csMap.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, CsIndexReport> entry = it.next();
			CsIndexReport record = entry.getValue();
			logger.debug(record.toString());
			csIndexReportMapper.insert(record);
		}
		//
	}
	
	private List<Float> random(int len, int lower ,int upper) {
		RandomDataGenerator rd = new RandomDataGenerator();
		rd.reSeedSecure(447865003005179574L);
		int jg = upper - lower;
		int bs = 10;
		while(len > jg){
			jg = jg * 10;
			bs = bs * 10;
		} 
		lower = lower * bs;
		upper = upper * bs;
		List<Float> list = new ArrayList<Float>();
		int count = 0;
		while(count < len){
			float rdm = (float)rd.nextSecureInt(lower, upper) / (float)bs;
			list.add(rdm);
			count++;
			logger.debug("count:{}, rd:{}", count, rdm);
		}
		return list;
	}

	@Override
	public PageInfo<CsIndexReport> bizQuota(CsIndexReportInput input) {
		CsIndexReportExample example = new CsIndexReportExample();
		CsIndexReportExample.Criteria ecri = example.createCriteria();
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
			} else if ("electricRange".equals(sortFiled)) {
				example.setOrderByClause("electric_range " + sort);
			} else if ("maxChargePower".equals(sortFiled)) {
				example.setOrderByClause("max_charge_power " + sort);
			} else if ("minChargeTime".equals(sortFiled)) {
				example.setOrderByClause("min_charge_time " + sort);
			} else if("cumulativeMileage".equals(sortFiled)){
				example.setOrderByClause("cumulative_mileage " + sort);
			} else if("cumulativeCharge".equals(sortFiled)){
				example.setOrderByClause("cumulativeCharge " + sort);
			}
		}
		int pageNum = null == input.getPageNum() ? 1 : input.getPageNum();
		int pageSize = null == input.getPageSize() ? 10 : input.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<CsIndexReport> list = csIndexReportMapper.selectByExample(example);
		PageInfo<CsIndexReport> pinfo = new PageInfo<CsIndexReport>(list);
		return pinfo;
	}

	/**
	 * 获取车辆指标存在vin/不存在vin的数据
	 * @param readExcelList
	 * @return
	 */
	@Override
	public Map<String,CsIndexReport>  ztReportExport(List<CsIndexReport> readExcelList) {
		//1.先获取到前端传进来的条件
		readExcelList.remove(0);
		//从excel获取到所有条件的vin码
		List<String>vinList=new ArrayList<>();
		for (CsIndexReport csIndexReport:readExcelList){
			vinList.add(csIndexReport.getCsVin());
		}
		//
		CsIndexReportExample example = new CsIndexReportExample();
		CsIndexReportExample.Criteria criteria=example.createCriteria();
		criteria.andCsVinIn(vinList);
		List<CsIndexReport> exlist=new ArrayList<>();
		if(vinList!=null&&vinList.size()>0){
			//根据条件查询的数据
			exlist = csIndexReportMapper.selectByExample(example);
		}
		Map<String,CsIndexReport> dateMap=new HashMap<>();
		//
		for(CsIndexReport csIndexReport: exlist){
			dateMap.put(csIndexReport.getCsVin(),csIndexReport);
		}
		DBHelperZt dbHelperZt= new DBHelperZt();
		dbHelperZt.getDBConnect();
		dbHelperZt.getZtCurrentOBD(exlist);
		//
		return dateMap;
	}
}
