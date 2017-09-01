package com.ccclubs.quota.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ccclubs.quota.orm.mapper.VcDistrictGpsMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictMapMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictPolylineMapper;
import com.ccclubs.quota.orm.model.VcDistrict;
import com.ccclubs.quota.orm.model.VcDistrictGps;
import com.ccclubs.quota.orm.model.VcDistrictGpsExample;
import com.ccclubs.quota.orm.model.VcDistrictPolyline;
import com.ccclubs.quota.orm.model.VcDistrictPolylineExample;
import com.ccclubs.quota.vo.MapMarkerPosition;
import com.ccclubs.quota.vo.MapPolyline;
import com.ccclubs.quota.vo.MapProvinces;

@Component
public class MapCache {
	@Resource
	private VcDistrictPolylineMapper vcDistrictPolylineMapper;
	@Resource
	private VcDistrictMapper vcDistrictMapper;
	@Resource
	private VcDistrictGpsMapper vcDistrictGpsMapper;
	@Resource
	private VcDistrictMapMapper vcDistrictMapMapper;
	@Resource
	private MapViewCache mapViewCache;
	/**
	 * 新增缓存
	 * 
	 * @param id
	 */
	@Cacheable(cacheNames = "map", key = "'VcDistrictPolyline_'+#districtId", cacheManager = "cacheManagerAccess")
	public List<MapPolyline> getMapPolyline(String districtId) {
		List<MapPolyline> mplist = new ArrayList<MapPolyline>();
		VcDistrictPolylineExample vdpe = new VcDistrictPolylineExample();
		VcDistrictPolylineExample.Criteria vdpeCri = vdpe.createCriteria();
		vdpeCri.andDistrictIdEqualTo(districtId);
		List<VcDistrictPolyline> vdplist = vcDistrictPolylineMapper.selectByExample(vdpe);
		for (VcDistrictPolyline vdp : vdplist) {
			mplist.add(new MapPolyline(vdp.getGps84Longitude().doubleValue(), vdp.getGps84Latitude().doubleValue()));
		}
		return mplist;
	}

	@Cacheable(cacheNames = "map", key = "'VcDistrict_'+#districtId", cacheManager = "cacheManagerAccess")
	public MapProvinces getMapProvinces(String districtId) {
		MapProvinces e = new MapProvinces();
		VcDistrict vd = vcDistrictMapper.selectByPrimaryKey(districtId);
		e.setDistrictName(vd.getDistrictName());
		MapMarkerPosition mmp = new MapMarkerPosition();
		mmp.setLatitude(vd.getDistrictCentreLat());
		mmp.setLongitude(vd.getDistrictCentreLon());
		e.setPosition(mmp);
		return e;
	}

	@Cacheable(cacheNames = "map", key = "'VcDistrictGps_'+#all", cacheManager = "cacheManagerAccess")
	public List<VcDistrictGps> getVcDistrictGpsList(String all) {
		VcDistrictGpsExample vdge = new VcDistrictGpsExample();
		List<VcDistrictGps> vdglist = vcDistrictGpsMapper.selectByExample(vdge);
		return vdglist;
	}
	
}
