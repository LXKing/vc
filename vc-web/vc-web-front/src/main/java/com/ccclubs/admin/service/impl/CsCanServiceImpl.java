package com.ccclubs.admin.service.impl;

import com.ccclubs.admin.model.CsCan;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.orm.mapper.CsCanMapper;
import com.ccclubs.admin.service.ICsCanService;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.base.CrudService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆实时CAN信息的Service实现
 *
 * @author Joel
 */
@Service
public class CsCanServiceImpl extends CrudService<CsCanMapper, CsCan, Long> implements ICsCanService {

    @Autowired
    CsCanMapper canMapper;

    @Override
    public Integer getCarCount(Integer state) {
        Integer count = canMapper.getCarCount(state);
        if (count == null) {
            return 0;
        }
        return count;
    }

}