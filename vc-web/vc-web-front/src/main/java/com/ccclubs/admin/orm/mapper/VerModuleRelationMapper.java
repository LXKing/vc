package com.ccclubs.admin.orm.mapper;

import com.ccclubs.admin.model.VerModuleRelation;
import com.ccclubs.admin.vo.version.VerModuleRelationVo;
import com.ccclubs.frm.base.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 版本模块关系的Mapper实现
 * @author Joel
 */
public interface VerModuleRelationMapper extends BaseDAO<VerModuleRelation,Integer> {

    /**
     * 根据版本ID获取对应的模块关联映射
     * @param verId
     * @param type
     * @return
     */
    List<VerModuleRelationVo> selectRelationsByVerId(@Param("verId") Integer verId, @Param("type") Short type);

    /**
     * 批量插入
     * @param relations
     * @return
     */
    int insertByList(List<VerModuleRelation> relations);


    /**
     * 根据版本ID批量删除
     * @param ids
     * @return
     */
    int batchDeleteByVerId(List<Integer> ids);

    /**
     * 根据升级版本号，获取该版本号下软硬件模块的模块关联取值信息
     * @param hardId    硬件版本ID
     * @param softId    软件版本ID
     * @return
     */
    List<VerModuleRelation> selectBySoftHardVersion(@Param("hardId") Integer hardId, @Param("softId") Integer softId);
}
