package com.ccclubs.admin.orm.mapper;

import com.ccclubs.admin.model.VerModule;
import com.ccclubs.frm.base.BaseDAO;

import java.util.List;

/**
 * 版本模块管理的Mapper实现
 * @author Joel
 */
public interface VerModuleMapper extends BaseDAO<VerModule,Integer> {

    /**
     * 获取所有模块（包括软硬件）
     * @return
     */
    List<VerModule> selectAllModule();
	
}
