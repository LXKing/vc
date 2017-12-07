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

import com.ccclubs.admin.entity.CsStateCrieria;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.service.ICsStateService;
import com.ccclubs.admin.query.CsStateQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 车辆实时状态Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/state")
public class CsStateController {

	@Autowired
	ICsStateService csStateService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<CsState> list(CsStateQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<CsState> pageInfo = csStateService.getPage(query.getCrieria(), page, rows);
		List<CsState> list = pageInfo.getList();
		for(CsState data : list){
			registResolvers(data);
		}
		
		TableResult<CsState> r = new TableResult<>(pageInfo);
		return r;
	}

	
	
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(CsState data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.接入商.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.车机号.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.车辆.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.充电状态.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.GPS有效性.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.循环模式.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.PTC启停.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.压缩机.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.档风量.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.功耗模式.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.发动机状态.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.档位.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStateResolver.网络类型.getResolver());
		}
	}
	
	/**
	 * 获取单条车辆实时状态信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, CsState>> detail(@PathVariable(required = true) Long id){
		CsState data = csStateService.selectByPrimaryKey( id.intValue());
		Map<String, CsState> map = new HashMap<String, CsState>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索车辆实时状态信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , CsState queryRecord){
		CsStateCrieria query = new CsStateCrieria();
		CsStateCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			String val = String.valueOf(text);
			c.andcssNumberEqualTo(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andcssIdEqualTo(val);
		}
		PageInfo<CsState> pageInfo = csStateService.getPage(query, 0, 10);
		List<CsState> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (CsState data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getCssId());
			map.put("text", data.getCssNumber());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}