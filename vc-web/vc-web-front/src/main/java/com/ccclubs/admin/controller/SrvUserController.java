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

import com.ccclubs.admin.entity.SrvUserCrieria;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.service.ISrvUserService;
import com.ccclubs.admin.query.SrvUserQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 用户管理Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/auth/user")
public class SrvUserController {

	@Autowired
	ISrvUserService srvUserService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<SrvUser> list(SrvUserQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<SrvUser> pageInfo = srvUserService.getPage(query.getCrieria(), page, rows);
		List<SrvUser> list = pageInfo.getList();
		for(SrvUser data : list){
			registResolvers(data);
		}
		
		TableResult<SrvUser> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 创建保存用户管理
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public VoResult<?> add(SrvUser data){
		srvUserService.insert(data);
		return VoResult.success();
	}
	
	/**
	 * 更新用户管理
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public VoResult<?> update(SrvUser data){
		srvUserService.updateByPrimaryKeySelective(data);
		return VoResult.success();
	}
	
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(SrvUser data){
		if(data!=null){
		}
	}
	
	/**
	 * 获取单条用户管理信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, SrvUser>> detail(@PathVariable(required = true) Long id){
		SrvUser data = srvUserService.selectByPrimaryKey( id.intValue());
		Map<String, SrvUser> map = new HashMap<String, SrvUser>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索用户管理信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , SrvUser queryRecord){
		SrvUserCrieria query = new SrvUserCrieria();
		SrvUserCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			String val = String.valueOf(text);
			c.andsuUsernameLike(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andsuGroupEqualTo(val.longValue());
		}
		PageInfo<SrvUser> pageInfo = srvUserService.getPage(query, 0, 10);
		List<SrvUser> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (SrvUser data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getSuId());
			map.put("text", data.getSuUsername());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}
