package com.ccclubs.demo.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class DemoCache {
	/**
	 * 新增缓存
	 * @param id
	 */
	@CachePut(cacheNames ="test", key="'id_'+#id")
	public void insert(String id){
		System.out.println("insert_"+id);
	}
	/**
	 * 查询缓存
	 * @param id 主键
	 * @return
	 */
	@Cacheable(cacheNames ="test", key="'id_'+#id")
	public String getId(String id){//实体类使用方法：#user.getUserName()
		System.out.println("get_"+id);
		return id;
	}
	/**
	 * 删除缓存
	 * @param id
	 * @return
	 */
	@CacheEvict(cacheNames ="test", key="'id_'+#id")
	public String delId(String id){
		System.out.println("get_"+id);
		return id;
	}
}
