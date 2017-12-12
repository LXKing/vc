package com.ccclubs.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

import com.ccclubs.admin.vo.TableResult;

import com.ccclubs.admin.entity.CsStatisticsCrieria;
import com.ccclubs.admin.model.CsStatistics;
import com.ccclubs.admin.service.ICsStatisticsService;
import com.ccclubs.admin.query.CsStatisticsQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 车辆统计数据Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/statistics")
public class CsStatisticsController {

	@Autowired
	ICsStatisticsService csStatisticsService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<CsStatistics> list(CsStatisticsQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<CsStatistics> pageInfo = csStatisticsService.getPage(query.getCrieria(), page, rows);
		List<CsStatistics> list = pageInfo.getList();
		for(CsStatistics data : list){
			registResolvers(data);
		}
		
		TableResult<CsStatistics> r = new TableResult<>(pageInfo);
		return r;
	}

	
	
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(CsStatistics data){
		if(data!=null){

		}
	}
	
	/**
	 * 获取单条车辆统计数据信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, CsStatistics>> detail(@PathVariable(required = true) Long id){
		CsStatistics data = csStatisticsService.selectByPrimaryKey( id.intValue());
		Map<String, CsStatistics> map = new HashMap<String, CsStatistics>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索车辆统计数据信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , CsStatistics queryRecord){
		CsStatisticsCrieria query = new CsStatisticsCrieria();
		CsStatisticsCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			Integer val = Integer.valueOf(text);
			c.andcssIdEqualTo(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andcssIdEqualTo(val);
		}
		PageInfo<CsStatistics> pageInfo = csStatisticsService.getPage(query, 0, 10);
		List<CsStatistics> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (CsStatistics data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getCssId());
			map.put("text", data.getCssId());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}
