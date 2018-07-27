package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.VerModuleRelation;
import com.ccclubs.admin.model.VerSoftHardware;
import com.ccclubs.admin.model.VerUpgrade;
import com.ccclubs.admin.orm.mapper.VerModuleRelationMapper;
import com.ccclubs.admin.orm.mapper.VerSoftHardwareMapper;
import com.ccclubs.admin.orm.mapper.VerUpgradeMapper;
import com.ccclubs.admin.service.IVerModuleRelationService;
import com.ccclubs.admin.vo.version.VerModuleRelationVo;
import com.ccclubs.frm.base.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 版本模块关系的Service实现
 * @author Joel
 */
@Service
public class VerModuleRelationServiceImpl extends CrudService<VerModuleRelationMapper, VerModuleRelation, Integer> implements IVerModuleRelationService {

    @Autowired
    private VerModuleRelationMapper verModuleRelationMapper;

    @Autowired
    private VerSoftHardwareMapper verSoftHardwareMapper;

    @Autowired
    private VerUpgradeMapper verUpgradeMapper;

    @Override
    public List<VerModuleRelationVo> selectRelationsByVerId(Integer verId) {
        VerSoftHardware thisSofthardware = verSoftHardwareMapper.selectByPrimaryKey(verId);
        if (thisSofthardware != null) {
            List<VerModuleRelationVo> relationVos = verModuleRelationMapper.selectRelationsByVerId(verId, thisSofthardware.gettype());
            if (relationVos != null) {
                return relationVos;
            }
        }
        return new ArrayList<>();
    }

    @Override
    public int insertRelationByList(List<VerModuleRelation> relations) {
        if (relations == null || relations.size() == 0) {
            return 0;
        }
        // 进行更新操作(先删除原有再新增现有的)
        VerModuleRelation relationDel = new VerModuleRelation();
        relationDel.setVerId(relations.get(0).getVerId());
        delete(relationDel);
        return verModuleRelationMapper.insertByList(relations);
    }

    @Override
    public int batchDeleteByVerId(List<Integer> ids) {
        return verModuleRelationMapper.batchDeleteByVerId(ids);
    }

    @Override
    public int updateByList(List<VerModuleRelation> relations) {
        int updateCount = 0;
        // 先删除所有版本相关的模块关系，再重新新增模块关系
        VerModuleRelation relationDel = new VerModuleRelation();
        relationDel.setVerId(relations.get(0).getVerId());
        int delCount = delete(relationDel);
        if (delCount > 0) {
            for (VerModuleRelation r :
                    relations) {
                r.setid(null);
            }
            updateCount = verModuleRelationMapper.insertByList(relations);
        }
        return updateCount;
    }

    @Override
    public List<VerModuleRelation> getListByUpgradeVerId(Integer upVerId) {
        VerUpgrade verUpgrade = verUpgradeMapper.selectByPrimaryKey(upVerId);
        if (verUpgrade != null && verUpgrade.getHardVerId() != null && verUpgrade.getSoftVerId() != null) {

            return verModuleRelationMapper.selectBySoftHardVersion(verUpgrade.getHardVerId(), verUpgrade.getSoftVerId());
        } else {
            return new ArrayList<>();
        }
    }
}