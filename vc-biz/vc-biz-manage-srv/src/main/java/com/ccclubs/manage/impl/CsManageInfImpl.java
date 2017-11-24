package com.ccclubs.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.manage.inf.CsManageInf;
import com.ccclubs.manage.orm.mapper.CsManageMapper;
import com.ccclubs.manage.orm.model.CsManage;
import com.ccclubs.manage.orm.model.CsManageExample;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/13
 * Time: 14:11
 * Email:fengjun@ccclubs.com
 */
@Service(version = "1.0.0")
public class CsManageInfImpl implements CsManageInf {

    @Resource
    private CsManageMapper csManageMapper;

    @Override
    public CsManage getCsManageById(Integer id) {
        CsManage csManage=csManageMapper.selectByPrimaryKey(id);
        return csManage;
    }

    @Override
    public CsManage getCsManageByUserName(String username) {
        CsManage csManage=null;
        CsManageExample csManageExample=new CsManageExample();
        CsManageExample.Criteria criteria=csManageExample.createCriteria();
        if(StringUtils.isNotBlank(username)){
            criteria.andCsmUsernameEqualTo(username);
        }
        List<CsManage> csManageList=csManageMapper.selectByExample(csManageExample);
        if(null!=csManageList&&csManageList.size()>0){
            csManage=csManageList.get(0);
        }
        return csManage;
    }

    @Override
    public CsManage checkUserPassword(String username, String password) {
        CsManage csManage=null;
        CsManageExample csManageExample=new CsManageExample();
        CsManageExample.Criteria criteria=csManageExample.createCriteria();
        if (StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return null;
        }
        if(StringUtils.isNotBlank(username)){
            criteria.andCsmUsernameEqualTo(username);
        }
        if(StringUtils.isNotBlank(password)){
            criteria.andCsmPasswordEqualTo(password);
        }
        List<CsManage> csManageList=csManageMapper.selectByExample(csManageExample);
        if(null!=csManageList&&csManageList.size()>0){
            csManage=csManageList.get(0);
        }
        return csManage;
    }
}
