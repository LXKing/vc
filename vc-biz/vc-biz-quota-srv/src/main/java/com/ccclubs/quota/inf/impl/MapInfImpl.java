package com.ccclubs.quota.inf.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.quota.cache.MapViewCache;
import com.ccclubs.quota.inf.MapInf;
import com.ccclubs.quota.orm.mapper.CsStateMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictGpsMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictMapMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictPolylineMapper;
import com.ccclubs.quota.orm.model.CsState;
import com.ccclubs.quota.orm.model.CsStateExample;
import com.ccclubs.quota.tools.GPSUtils;
import com.ccclubs.quota.vo.MapInput;
import com.ccclubs.quota.vo.MapOutput;
 
@Service(version = "1.0.0")
public class MapInfImpl implements MapInf {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private CsStateMapper csStateMapper;
	@Resource
	private VcDistrictGpsMapper vcDistrictGpsMapper;
	@Resource
	private VcDistrictMapMapper vcDistrictMapMapper;
	@Resource
	private VcDistrictPolylineMapper vcDistrictPolylineMapper;
	@Resource
	private VcDistrictMapper vcDistrictMapper;
	@Resource
	private MapViewCache mapViewCache;
	@Override
	public List<CsState> csStateList() {
		CsStateExample example = new CsStateExample();
		List<CsState> list = csStateMapper.selectByExample(example);
		for(CsState cs : list){
			BigDecimal lon = cs.getCssLongitude();
			BigDecimal lat = cs.getCssLatitude();
			double[] dn = GPSUtils.gps84_To_Gcj02(lat.doubleValue(), lon.doubleValue());
			cs.setCssLatitude(new BigDecimal(dn[0]));
			cs.setCssLongitude(new BigDecimal(dn[1]));
		}
		return list;
	}
	@Override
	public MapOutput map(MapInput input) {
		logger.debug("map");
		MapOutput out = mapViewCache.getDistrictsView("all");
		return out;
	}
	@Override
	public MapOutput district(MapInput input) {
		MapOutput out = null;
		if(null != input.getLat() && null != input.getLng()){
			out = mapViewCache.getDistrictCars(input.getLat(), input.getLng());
		}
		return out;
	}
	
}
