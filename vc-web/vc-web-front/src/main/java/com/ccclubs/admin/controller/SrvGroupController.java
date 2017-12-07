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

import com.ccclubs.admin.entity.SrvGroupCrieria;
import com.ccclubs.admin.model.SrvGroup;
import com.ccclubs.admin.service.ISrvGroupService;
import com.ccclubs.admin.query.SrvGroupQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 角色组管理Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/auth/group")
public class SrvGroupController {

	@Autowired
	ISrvGroupService srvGroupService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<SrvGroup> list(SrvGroupQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<SrvGroup> pageInfo = srvGroupService.getPage(query.getCrieria(), page, rows);
		List<SrvGroup> list = pageInfo.getList();
		for(SrvGroup data : list){
			registResolvers(data);
		}
		
		TableResult<SrvGroup> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 创建保存角色组管理
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public VoResult<?> add(SrvGroup data){
		srvGroupService.insert(data);
		return VoResult.success();
	}
	
	/**
	 * 更新角色组管理
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public VoResult<?> update(SrvGroup data){
		srvGroupService.updateByPrimaryKeySelective(data);
		return VoResult.success();
	}
	
	/**
	 * 删除角色组管理
	 * @return
	 */
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
	public VoResult<?> delete(@RequestParam(required=true)final Long[] ids){
		srvGroupService.batchDelete(ids);
		return VoResult.success();
	}
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(SrvGroup data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.SrvGroupResolver.状态.getResolver());
		}
	}
	
	/**
	 * 获取单条角色组管理信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, SrvGroup>> detail(@PathVariable(required = true) Long id){
		SrvGroup data = srvGroupService.selectByPrimaryKey( id.intValue());
		Map<String, SrvGroup> map = new HashMap<String, SrvGroup>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索角色组管理信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , SrvGroup queryRecord){
		SrvGroupCrieria query = new SrvGroupCrieria();
		SrvGroupCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			String val = String.valueOf(text);
			c.andsgNameLike(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andsgIdEqualTo(val);
		}
		PageInfo<SrvGroup> pageInfo = srvGroupService.getPage(query, 0, 10);
		List<SrvGroup> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (SrvGroup data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getSgId());
			map.put("text", data.getSgName());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}
