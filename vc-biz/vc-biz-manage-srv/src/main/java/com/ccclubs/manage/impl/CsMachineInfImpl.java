package com.ccclubs.manage.impl;

import com.ccclubs.manage.dto.CsMachineInput;
import com.ccclubs.manage.dto.CsMachineOutput;
import com.ccclubs.manage.inf.CsMachineInf;
import com.ccclubs.manage.inf.CsVehicleInf;
import com.ccclubs.manage.mapper.CsMachineMapper;
import com.ccclubs.manage.model.CsMachine;
import com.ccclubs.manage.model.CsMachineExample;
import com.ccclubs.manage.model.CsVehicle;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 16:35
 * Email:fengjun@ccclubs.com
 */
@Service
public class CsMachineInfImpl implements CsMachineInf {

    @Resource
    private CsMachineMapper csMachineMapper;

    @Autowired
    private CsVehicleInf csVehicleService;

    @Override
    public PageInfo<CsMachine> getCsMachinePage(CsMachineInput csMachineInput) {
        CsVehicle csVehicle=null;
        if (null!=csMachineInput.getCsVin()){
            csVehicle=csVehicleService.getCsVehicleByCsVin(csMachineInput.getCsVin());
        }
        if (null!=csMachineInput.getCsCarNo()){
            csVehicle=csVehicleService.getCsVehicleByCsCarNo(csMachineInput.getCsCarNo());
        }
        if (null!=csVehicle){
            if (csVehicle.getCsvAccess().equals(csMachineInput.getCsAccess())){
                //if (null==csMachineInput.getId())
                {
                    csMachineInput.setId(csVehicle.getCsvMachine());
                }
            }
        }

        CsMachineExample csMachineExample=new CsMachineExample();
        CsMachineExample.Criteria criteria = csMachineExample.createCriteria();
        if (StringUtils.isNotBlank(csMachineInput.getCsNumber())) {
            criteria.andCsmNumberEqualTo(csMachineInput.getCsNumber());
        }
        if(null!=csMachineInput.getCsAccess()&&csMachineInput.getCsAccess()>0){
            //TODO 权限处理应更换为token取值
            criteria.andCsmAccessEqualTo(csMachineInput.getCsAccess());
        }
        if (null!=csMachineInput.getId()){
            criteria.andCsmIdEqualTo(csMachineInput.getId());
        }
        if (StringUtils.isNotBlank(csMachineInput.getTeNo())){
            criteria.andCsmTeNoEqualTo(csMachineInput.getTeNo());
        }
        if (StringUtils.isNotBlank(csMachineInput.getMobile())){
            criteria.andCsmMobileEqualTo(csMachineInput.getMobile());
        }

        int pageNum = null == csMachineInput.getPageNum() ? 1 : csMachineInput.getPageNum();
        int pageSize = null == csMachineInput.getPageSize() ? 10 : csMachineInput.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        //PageHelper.startPage(1, 5);
        List<CsMachine> csMachineList=csMachineMapper.selectByExample(csMachineExample);
        PageInfo<CsMachine> pi = new PageInfo<>(csMachineList);
        return pi;
    }


    @Override
    public CsMachineOutput getCsMachineAll(CsMachineInput csMachineInput) {

        CsMachineExample csMachineExample=new CsMachineExample();
        //TODO 权限处理
        int pageNum = null == csMachineInput.getPageNum() ? 1 : csMachineInput.getPageNum();
        int pageSize = null == csMachineInput.getPageSize() ? 10 : csMachineInput.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        //PageHelper.startPage(1, 5);
        List<CsMachine> csMachineList=csMachineMapper.selectByExample(csMachineExample);
        CsMachineOutput csMachineOutput=new CsMachineOutput();
        csMachineOutput.setList(csMachineList);
        return csMachineOutput;

    }

    @Override
    public CsMachine getCsMachineByCsNumber(String csNumber) {

        CsMachine csMachine=null;
        CsMachineExample csMachineExample=new CsMachineExample();
        CsMachineExample.Criteria criteria=csMachineExample.createCriteria();
        if (StringUtils.isNotBlank(csNumber)){
            criteria.andCsmNumberEqualTo(csNumber);
        }
        List<CsMachine> csMachineList=csMachineMapper.selectByExample(csMachineExample);
        if (null!=csMachineList&&csMachineList.size()>0){
            csMachine=csMachineList.get(0);
        }
        return csMachine;
    }

    @Override
    public boolean deleteCsMachines(CsMachineInput csMachineInput) {

        if (null!=csMachineInput.getIds()&&csMachineInput.getIds().size()>0){
            int successCount=0;
            Integer accessId=csMachineInput.getCsAccess();

            for (Integer id:csMachineInput.getIds()){
                CsMachineExample csMachineExample=new CsMachineExample();
                CsMachineExample.Criteria criteria=csMachineExample.createCriteria();
                criteria.andCsmAccessEqualTo(accessId);
                criteria.andCsmIdEqualTo(id);
                if (csMachineMapper.deleteByExample(csMachineExample)>0){
                    successCount++;
                }
            }

            if (successCount>0){
                //TODO 此处可以加入计数判断是否全部删除成功。
                return true;
            }
        }
        return false;

    }



    @Override
    public boolean insertOrUpdateCsMachine(CsMachineInput csMachineInput) {
        int successCount=0;
        if (null==csMachineInput.getCsMachine()){
            return false;
        }

        if (null!=csMachineInput.getCsMachine().getCsmId()){
            //为真是更新逻辑
            successCount=csMachineMapper.updateByPrimaryKeySelective(csMachineInput.getCsMachine());
        }
        else {
            //为假是插入逻辑
            successCount=csMachineMapper.insertSelective(csMachineInput.getCsMachine());
        }



        if(successCount>0){
            return true;
        }

        return false;
    }


}
