package com.ccclubs.admin.service;

import com.ccclubs.admin.model.VerModuleRelation;
import com.ccclubs.admin.vo.version.VerModuleRelationVo;
import com.ccclubs.frm.base.BaseService;

import java.util.List;

/**
 * 版本模块关系的Service接口
 * @author Joel
 */
public interface IVerModuleRelationService extends BaseService<VerModuleRelation, Integer> {
    /**
     * 根据版本号查询该版本下的软/硬件模块详情列表
     * @param verId
     * @return
     */
    List<VerModuleRelationVo> selectRelationsByVerId(Integer verId);

    /**
     * 批量插入版本模块关系
     * @param relations
     * @return
     */
    int insertRelationByList(List<VerModuleRelation> relations);

    /**
     * 批量删除版本号列表中的版本号对应的软硬件模块关联映射
     * @param ids
     * @return
     */
    int batchDeleteByVerId(List<Integer> ids);

    /**
     * 批量更新版本号中对应的软硬件映射
     *      先删除版本号对应的所有模板映射，之后新增新的模板映射
     * @param relations
     * @return
     */
    int updateByList(List<VerModuleRelation> relations);

    /**
     * 根据升级版本ID获取版本内软硬件模块映射值
     * @param upVerId
     * @return
     */
    List<VerModuleRelation> getListByUpgradeVerId(Integer upVerId);
}