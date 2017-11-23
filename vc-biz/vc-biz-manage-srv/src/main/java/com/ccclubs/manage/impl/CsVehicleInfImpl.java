package com.ccclubs.manage.impl;

import com.ccclubs.manage.dto.CsVehicleInput;
import com.ccclubs.manage.inf.CsMachineInf;
import com.ccclubs.manage.dto.CsVehicleOutput;
import com.ccclubs.manage.inf.CsVehicleInf;
import com.ccclubs.manage.orm.mapper.CsVehicleBizMapper;
import com.ccclubs.manage.orm.mapper.CsVehicleMapper;
import com.ccclubs.manage.orm.model.*;
import com.ccclubs.manage.util.EvManageStringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 16:36
 * Email:fengjun@ccclubs.com
 */
@Service
public class CsVehicleInfImpl implements CsVehicleInf {

    @Resource
    private CsVehicleMapper csVehicleMapper;

    @Autowired
    private CsMachineInf csMachineService;

    @Resource
    private CsVehicleBizMapper csVehicleBizMapper;


    @Override
    public PageInfo<CsVehicle> getCsVehiclePage(CsVehicleInput csVehicleInput) {
        CsMachine csMachine=null;
        if (null!=csVehicleInput.getCsNumber()){
            csMachine=csMachineService.getCsMachineByCsNumber(csVehicleInput.getCsNumber());
        }
        if (null!=csMachine){
            if (csMachine.getCsmAccess().equals(csVehicleInput.getCsAccess())){
                //if (null==csVehicleInput.getCsMachineId())
                {
                    csVehicleInput.setCsMachineId(csMachine.getCsmId());
                }

            }
        }


        CsVehicleExample csVehicleExample=new CsVehicleExample();
        CsVehicleExample.Criteria criteria=csVehicleExample.createCriteria();
        //TODO 这里做判断是批量csVin还是单个csVin。
        if (StringUtils.isNotBlank(csVehicleInput.getCsVin())){
            criteria.andCsvVinEqualTo(csVehicleInput.getCsVin());
        }
        if(null!=csVehicleInput.getCsAccess()&&csVehicleInput.getCsAccess()>0){
            //TODO 权限处理应更换为token取值
            criteria.andCsvAccessEqualTo(csVehicleInput.getCsAccess());
        }
        if (null!=csVehicleInput.getId()){
            criteria.andCsvIdEqualTo(csVehicleInput.getId());
        }
        if (StringUtils.isNotBlank(csVehicleInput.getCsCarNo())){
            criteria.andCsvCarNoEqualTo(csVehicleInput.getCsCarNo());
        }
        if (null!=csVehicleInput.getCsMachineId()){
            criteria.andCsvMachineEqualTo(csVehicleInput.getCsMachineId());
        }
        int pageNum = null == csVehicleInput.getPageNum() ? 1 : csVehicleInput.getPageNum();
        int pageSize = null == csVehicleInput.getPageSize() ? 10 : csVehicleInput.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<CsVehicle> csVehicleList=csVehicleMapper.selectByExample(csVehicleExample);
        PageInfo<CsVehicle> pi=new PageInfo<>(csVehicleList);
        return pi;
    }


    @Override
    public PageInfo<CsVehicleBiz> getCsVehicleBizPage(CsVehicleInput csVehicleInput) {
        CsMachine csMachine=null;
        if (null!=csVehicleInput.getCsNumber()){
            csMachine=csMachineService.getCsMachineByCsNumber(csVehicleInput.getCsNumber());
        }
        if (null!=csMachine){
            if (csMachine.getCsmAccess().equals(csVehicleInput.getCsAccess())){
                //if (null==csVehicleInput.getCsMachineId())
                {
                    csVehicleInput.setCsMachineId(csMachine.getCsmId());
                }

            }
        }


        CsVehicleBizExample csVehicleBizExample=new CsVehicleBizExample();
        CsVehicleBizExample.Criteria criteria=csVehicleBizExample.createCriteria();


        //是否绑定车机逻辑判断
        if(csVehicleInput.getIsBind()>-1){
            if (csVehicleInput.getIsBind()==0){
                criteria.andCsvMachineIsNull();
            }
            else if(csVehicleInput.getIsBind()==1){
                criteria.andCsvMachineIsNotNull();
            }
            else {

            }
        }


        // 这里做判断是批量csVin还是单个csVin。
        if (StringUtils.isNotBlank(csVehicleInput.getCsVin())){
            if (EvManageStringUtil.isExpression(csVehicleInput.getCsVin())){
                //多个（模糊范围）查询
                List<String> stringList=EvManageStringUtil.buildCsVinByExpression(csVehicleInput.getCsVin());
                if (null!=stringList&&stringList.size()>1){
                    criteria.andCsvVinIn(stringList);
                }
            }
            else {
                //单个精确查询
                criteria.andCsvVinLike("%"+csVehicleInput.getCsVin());
            }
        }


        if(null!=csVehicleInput.getCsAccess()&&csVehicleInput.getCsAccess()>0){
            //TODO 权限处理应更换为token取值
            criteria.andCsvAccessEqualTo(csVehicleInput.getCsAccess());
        }


        if (null!=csVehicleInput.getAddTimeBegin()&&null!=csVehicleInput.getAddTimeEnd()){
            try {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                criteria.andCsvAddTimeBetween(format.parse(csVehicleInput.getAddTimeBegin()),format.parse(csVehicleInput.getAddTimeEnd()));
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        // 出厂时间查询
        if (null!=csVehicleInput.getFactoryTimeBegin()&&null!=csVehicleInput.getFactoryTimeEnd()){
            try {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                criteria.andCsvProdDateBetween(format.parse(csVehicleInput.getFactoryTimeBegin()),format.parse(csVehicleInput.getFactoryTimeEnd()));
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }


        if (null!=csVehicleInput.getId()){
            criteria.andCsvIdEqualTo(csVehicleInput.getId());
        }
        if (StringUtils.isNotBlank(csVehicleInput.getCsCarNo())){
            criteria.andCsvCarNoEqualTo(csVehicleInput.getCsCarNo());
        }
        if (null!=csVehicleInput.getCsMachineId()){
            criteria.andCsvMachineEqualTo(csVehicleInput.getCsMachineId());
        }


        int pageNum = null == csVehicleInput.getPageNum() ? 1 : csVehicleInput.getPageNum();
        int pageSize = null == csVehicleInput.getPageSize() ? 10 : csVehicleInput.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("csv_add_time DESC");
        List<CsVehicleBiz> csVehicleBizList=csVehicleBizMapper.selectByExample(csVehicleBizExample);
        PageInfo<CsVehicleBiz> pi=new PageInfo<>(csVehicleBizList);
        return pi;

    }





    @Override
    public CsVehicleOutput getCsVehicleAll(CsVehicleInput csVehicleInput) {
        CsVehicleOutput csVehicleOutput=new CsVehicleOutput();
        //TODO 权限处理
        csVehicleOutput.setList(csVehicleMapper.selectByExample(new CsVehicleExample()));
        return csVehicleOutput;
    }

    @Override
    public List<Integer> getMachineIdListByVehicles(List<Integer> ids) {
        List<CsVehicle> csVehicleList=this.getVehiclesByIds(ids);
        List<Integer> integerList=new ArrayList<>();
        for (CsVehicle csVehicle:csVehicleList){
            integerList.add(csVehicle.getCsvMachine());
        }
        return integerList;
    }

    @Override
    public List<CsVehicle> getVehiclesByIds(List<Integer> ids) {
        CsVehicleExample csVehicleExample=new CsVehicleExample();
        CsVehicleExample.Criteria criteria=csVehicleExample.createCriteria();
        if (null!=ids&&ids.size()>0){
            criteria.andCsvIdIn(ids);
        }
        //TODO 权限处理
        List<CsVehicle> csVehicleList=csVehicleMapper.selectByExample(csVehicleExample);
        return csVehicleList;
    }

    @Override
    public CsVehicle getCsVehicleByCsMachineId(Integer id) {
        CsVehicle csVehicle=null;
        CsVehicleExample csVehicleExample=new CsVehicleExample();
        CsVehicleExample.Criteria criteria=csVehicleExample.createCriteria();
        if(null!=id){
            criteria.andCsvMachineEqualTo(id);
        }
        List<CsVehicle> csVehicleList=csVehicleMapper.selectByExample(csVehicleExample);
        if (null!=csVehicleList&&csVehicleList.size()>0){
            csVehicle=csVehicleList.get(0);
        }
        return csVehicle;
    }

    @Override
    public CsVehicle getCsVehicleByCsVin(String csVin) {
        CsVehicle csVehicle=null;
        CsVehicleExample csVehicleExample=new CsVehicleExample();
        CsVehicleExample.Criteria criteria=csVehicleExample.createCriteria();
        if (StringUtils.isNotBlank(csVin)){
            criteria.andCsvVinEqualTo(csVin);
        }
        List<CsVehicle> csVehicleList=csVehicleMapper.selectByExample(csVehicleExample);
        if (null!=csVehicleList&&csVehicleList.size()>0){
            csVehicle=csVehicleList.get(0);
        }
        return  csVehicle;
    }

    @Override
    public CsVehicle getCsVehicleByCsCarNo(String csCarNo) {
        CsVehicle csVehicle=null;
        CsVehicleExample csVehicleExample=new CsVehicleExample();
        CsVehicleExample.Criteria criteria=csVehicleExample.createCriteria();
        if (StringUtils.isNotBlank(csCarNo)){
            criteria.andCsvCarNoEqualTo(csCarNo);

        }
        List<CsVehicle> csVehicleList=csVehicleMapper.selectByExample(csVehicleExample);
        if (null!=csVehicleList&&csVehicleList.size()>0){
            csVehicle=csVehicleList.get(0);
        }
        return  csVehicle;
    }

    @Override
    public boolean deleteCsVehicles(CsVehicleInput csVehicleInput) {
        if (null!=csVehicleInput.getIds()&&csVehicleInput.getIds().size()>0){
            int successCount=0;
            Integer accessId=csVehicleInput.getCsAccess();

            for (Integer id:csVehicleInput.getIds()){
                CsVehicleExample csVehicleExample=new CsVehicleExample();
                CsVehicleExample.Criteria criteria=csVehicleExample.createCriteria();
                criteria.andCsvAccessEqualTo(accessId);
                criteria.andCsvIdEqualTo(id);
                //TODO 删除车辆时还应该删除对应的mapping！
                if (csVehicleMapper.deleteByExample(csVehicleExample)>0){
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
    public boolean insertOrUpdateCsVehicle(CsVehicleInput csVehicleInput) {
        int successCount=0;
        if (null==csVehicleInput.getCsVehicle()){
            return false;
        }
        if (null!=csVehicleInput.getCsVehicle().getCsvId()){
            //更新逻辑
            successCount=csVehicleMapper.updateByPrimaryKeySelective(csVehicleInput.getCsVehicle());
        }
        else {
            //插入逻辑
            successCount=csVehicleMapper.insertSelective(csVehicleInput.getCsVehicle());
            //TODO 插入后还应该在cs_mapping中做关联处理，注意吧管理员用户的关联关系也理清楚。
        }


        if (successCount>0){
            return true;
        }
        return false;
    }


}
