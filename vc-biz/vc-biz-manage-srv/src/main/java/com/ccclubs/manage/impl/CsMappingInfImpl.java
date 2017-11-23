package com.ccclubs.manage.impl;

import com.ccclubs.manage.inf.CsMappingInf;
import com.ccclubs.manage.mapper.CsMappingMapper;
import com.ccclubs.manage.model.CsMapping;
import com.ccclubs.manage.model.CsMappingExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/10
 * Time: 15:15
 * Email:fengjun@ccclubs.com
 */
@Service
public class CsMappingInfImpl implements CsMappingInf {

    @Resource
    private CsMappingMapper csMappingMapper;


    @Override
    public List<Integer> getVehicleIdsByUser(Integer csAccess) {

        CsMappingExample csMappingExample=new CsMappingExample();
        CsMappingExample.Criteria criteria = csMappingExample.createCriteria();
        if (null!=csAccess) {
            criteria.andCsmManageEqualTo(csAccess);

        }
        List<CsMapping> csMappingList=csMappingMapper.selectByExample(csMappingExample);
        List<Integer> integerList=new ArrayList<>();
        for(CsMapping csMapping:csMappingList){
            integerList.add(csMapping.getCsmCar());
        }
        return integerList;

    }

    @Override
    public boolean addCsMapping(Integer csAccessId, Integer csCarId) {
        CsMapping csMapping=new CsMapping();
        csMapping.setCsmCar(csCarId);
        csMapping.setCsmManage(csAccessId);

        //TODO 此处还应该加入管理员权限的mapping
        int successCount=csMappingMapper.insert(csMapping);
        if (successCount>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCsMapping(Integer csAccessId, Integer csCarId) {
        CsMappingExample csMappingExample=new CsMappingExample();
        CsMappingExample.Criteria criteria = csMappingExample.createCriteria();
        //TODO 在车辆删除的时候是不是应该所有的此车对应关系都删了？？？
        if (null!=csAccessId) {
            criteria.andCsmManageEqualTo(csAccessId);
        }
        if (null!=csCarId){
            criteria.andCsmCarEqualTo(csCarId);
        }

        int successCount=csMappingMapper.deleteByExample(csMappingExample);
        if (successCount>0){
            return true;
        }
        return false;
    }


}
