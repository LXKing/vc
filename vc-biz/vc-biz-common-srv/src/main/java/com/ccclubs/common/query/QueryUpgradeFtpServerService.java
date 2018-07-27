package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.VerFtpSerMapper;
import com.ccclubs.pub.orm.model.VerFtpSer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: yeanzi
 * @Date: 2018/5/29
 * @Time: 15:00
 * Email:  yeanzhi@ccclubs.com
 * 查询升级服务器服务
 */
@Component
public class QueryUpgradeFtpServerService {

    @Resource
    private VerFtpSerMapper verFtpSerMapper;

    public VerFtpSer getById(Integer id) {
        return verFtpSerMapper.selectByPrimaryKey(id);
    }

}
