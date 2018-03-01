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

import com.ccclubs.admin.entity.GbStateCrieria;
import com.ccclubs.admin.model.GbState;
import com.ccclubs.admin.service.IGbStateService;
import com.ccclubs.admin.query.GbStateQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 车辆国标历史信息Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/electricity/gbState")
public class GbStateController {

	@Autowired
	IGbStateService gbStateService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<GbState> list(GbStateQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<GbState> pageInfo = gbStateService.getPage(query.getCrieria(), page, rows);
		List<GbState> list = pageInfo.getList();
		for(GbState data : list){
			registResolvers(data);
		}
		
		TableResult<GbState> r = new TableResult<>(pageInfo);
		return r;
	}

	
	
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(GbState data){
		if(data!=null){
		}
	}
	
	/**
	 * 获取单条车辆国标历史信息信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, GbState>> detail(@PathVariable(required = true) Long id){
		GbState data = gbStateService.selectByPrimaryKey( id.intValue());
		Map<String, GbState> map = new HashMap<String, GbState>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索车辆国标历史信息信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , GbState queryRecord){
		GbStateCrieria query = new GbStateCrieria();
		GbStateCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			Integer val = Integer.valueOf(text);
			c.andgsIdEqualTo(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andgsIdEqualTo(val);
		}
		PageInfo<GbState> pageInfo = gbStateService.getPage(query, 0, 10);
		List<GbState> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (GbState data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getGsId());
			map.put("text", data.getGsId());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}
