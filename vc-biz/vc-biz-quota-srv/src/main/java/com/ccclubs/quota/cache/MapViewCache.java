package com.ccclubs.quota.cache;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ccclubs.quota.orm.mapper.VcDistrictMapMapper;
import com.ccclubs.quota.orm.mapper.VcDistrictPolylineMapper;
import com.ccclubs.quota.orm.model.VcDistrictGps;
import com.ccclubs.quota.orm.model.VcDistrictMap;
import com.ccclubs.quota.orm.model.VcDistrictMapExample;
import com.ccclubs.quota.tools.GPSUtils;
import com.ccclubs.quota.vo.MapMarkerPosition;
import com.ccclubs.quota.vo.MapOutput;
import com.ccclubs.quota.vo.MapPolyline;
import com.ccclubs.quota.vo.MapProvinces;

@Component
public class MapViewCache {
	
	@Resource
	private VcDistrictMapMapper vcDistrictMapMapper;
	@Resource
	private MapCache mapCache; 
	@Resource
	private VcDistrictPolylineMapper vcDistrictPolylineMapper;

	@Cacheable(cacheNames = "map", key = "'VcDistrictsView_'+#all", cacheManager = "cacheManagerAccess")
	public MapOutput getDistrictsView(String all) {
		MapOutput out = new MapOutput();
		List<VcDistrictGps> vdglist = mapCache.getVcDistrictGpsList("all");
		VcDistrictMapExample vdme = new VcDistrictMapExample();
		List<VcDistrictMap> vdmlist = vcDistrictMapMapper.selectByExample(vdme);
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, List<MapPolyline>> mpMap = new HashMap<String, List<MapPolyline>>();
		Map<String, List<MapProvinces>> dmpMap = new HashMap<String, List<MapProvinces>>();
		for (VcDistrictMap vdm : vdmlist) {
			BigDecimal lat = vdm.getCssLatitude();
			BigDecimal lon = vdm.getCssLongitude();
			for (VcDistrictGps vdg : vdglist) {
				boolean latMin = lat.compareTo(vdg.getMinLatitude()) >= 0;
				boolean latMax = lat.compareTo(vdg.getMaxLatitude()) <= 0;
				boolean lonMin = lon.compareTo(vdg.getMinLongitude()) >= 0;
				boolean lonMax = lon.compareTo(vdg.getMaxLongitude()) <= 0;
				if (latMin && latMax && lonMin && lonMax) {
					List<MapPolyline> mplist = null;
					if (mpMap.containsKey(vdg.getDistrictId())) {
						mplist = mpMap.get(vdg.getDistrictId());
					} else {
						mplist = mapCache.getMapPolyline(vdg.getDistrictId());
						mpMap.put(vdg.getDistrictId(), mplist);
					}
					boolean inside = IsInsidePolygon(mplist, lon.doubleValue(), lat.doubleValue());
					if (inside) {
						if (map.containsKey(vdg.getDistrictId())) {
							int count = map.get(vdg.getDistrictId());
							map.put(vdg.getDistrictId(), count + 1);
						} else {
							map.put(vdg.getDistrictId(), 1);
						}
						if(dmpMap.containsKey(vdg.getDistrictId())){
							List<MapProvinces> dmplist = dmpMap.get(vdg.getDistrictId());
							MapProvinces mp = new MapProvinces();
							mp.setDistrictName(vdm.getCssNumber());
							MapMarkerPosition position = new MapMarkerPosition();
							position.setLongitude(vdm.getCssLongitude());
							position.setLatitude(vdm.getCssLatitude());
							mp.setPosition(position);
							dmplist.add(mp);
						}else{
							List<MapProvinces> dmplist = new ArrayList<MapProvinces>();
							MapProvinces mp = new MapProvinces();
							mp.setDistrictName(vdm.getCssNumber());
							MapMarkerPosition position = new MapMarkerPosition();
							position.setLongitude(vdm.getCssLongitude());
							position.setLatitude(vdm.getCssLatitude());
							mp.setPosition(position);
							dmplist.add(mp);
							dmpMap.put(vdg.getDistrictId(), dmplist);
						}
					}

				}
			}
		}
		List<MapProvinces> mplist = new ArrayList<MapProvinces>();
		Set<Entry<String, Integer>> it = map.entrySet();
		for (Entry<String, Integer> entry : it) {
			MapProvinces e = mapCache.getMapProvinces(entry.getKey());
			e.setCarNums(entry.getValue());
			mplist.add(e);
		}
		out.setProvinces(mplist);
		return out;
	}

	public MapOutput getDistrictCars(BigDecimal lat, BigDecimal lon) {
		MapOutput out = new MapOutput();
		double[] gcj = GPSUtils.gcj02_To_Gps84(lat.doubleValue(), lon.doubleValue());
		double Lat = gcj[0];
		double Lng = gcj[1];
		double latR = 180 * Math.PI * 2 / 6372.797;
		double lngR = latR / Math.cos(gcj[0] * Math.PI / 180);
		double maxLat= Lat + latR;//最大纬度  
		double minLat= Lat - latR;//最小纬度  
		double maxLng = Lng + lngR;//最大经度  
		double minLng = Lng - lngR;//最小经度
		lat = new BigDecimal(gcj[0]).setScale(6, BigDecimal.ROUND_HALF_UP);
		lon = new BigDecimal(gcj[1]).setScale(6, BigDecimal.ROUND_HALF_UP);
		VcDistrictMapExample example = new VcDistrictMapExample();
		VcDistrictMapExample.Criteria ecri = example.createCriteria();
		ecri.andCssLatitudeLessThanOrEqualTo(new BigDecimal(maxLat));
		ecri.andCssLatitudeGreaterThanOrEqualTo(new BigDecimal(minLat));
		ecri.andCssLongitudeLessThanOrEqualTo(new BigDecimal(maxLng));
		ecri.andCssLongitudeGreaterThanOrEqualTo(new BigDecimal(minLng));
		List<VcDistrictMap> list = vcDistrictMapMapper.selectByExample(example);
		List<MapProvinces> mplist = new ArrayList<MapProvinces>();
		for(VcDistrictMap vdm : list){
			MapProvinces mp = new MapProvinces();
			mp.setDistrictName(vdm.getCssNumber());
			MapMarkerPosition position = new MapMarkerPosition();
			double[] n = GPSUtils.gps84_To_Gcj02(vdm.getCssLatitude().doubleValue(), vdm.getCssLongitude().doubleValue());
			if(GPSUtils.outOfChina(n[0], n[1])){
				continue;
			}
			position.setLongitude(new BigDecimal(n[1]).setScale(6, BigDecimal.ROUND_HALF_UP));
			position.setLatitude(new BigDecimal(n[0]).setScale(6, BigDecimal.ROUND_HALF_UP));
			mp.setPosition(position);
			mplist.add(mp);
		}
		out.setProvinces(mplist);
		return out;
	}

	public static boolean IsInsidePolygon(List<MapPolyline> poly, double x, double y) {
		int index = 0;
		boolean inside = false;
		if(null == poly || poly.size() < 1){
			return inside;
		}
		MapPolyline prePoint = poly.get(0);
		int size = poly.size();
		for (index = 1; index < size; index++) {
			MapPolyline nextPoint = poly.get(index);
			if (y > Math.min(prePoint.getY(), nextPoint.getY()) && y <= Math.max(prePoint.getY(), nextPoint.getY())
					&& x <= Math.max(prePoint.getX(), nextPoint.getX()) && prePoint.getY() != nextPoint.getY()) {
				double xinters = (y - prePoint.getY()) * (nextPoint.getX() - prePoint.getX())
						/ (nextPoint.getY() - prePoint.getY()) + prePoint.getX();
				if (prePoint.getX() == nextPoint.getX() || x <= xinters)
					inside ^= true;
			}
			prePoint = nextPoint;
		}
		return inside;
	}
}
