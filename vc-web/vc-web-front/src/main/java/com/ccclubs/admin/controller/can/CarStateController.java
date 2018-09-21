package com.ccclubs.admin.controller.can;

import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.resolver.CsVehicleResolver;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.vo.TableResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2018/9/18
 * 时间段内在线车辆
 *
 * @author machuanpeng
 */
@RestController
@RequestMapping("/car/state")
public class CarStateController {

    @Autowired
    ICsVehicleService csVehicleService;

    /**
     * 2018/9/18
     * 获取分页列表数据
     *
     * @param page
     * @param rows
     * @return com.ccclubs.admin.vo.TableResult<>
     * @author machuanpeng
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public TableResult<CsVehicle> list(String vin, @RequestParam(defaultValue = "7") Integer days, @RequestParam(defaultValue = "0") Integer page,
                                       @RequestParam(defaultValue = "10") Integer rows) {
        PageHelper.startPage(page.intValue(), rows.intValue());
        PageInfo<CsVehicle> pageInfo = csVehicleService.getCarListWithTime(vin, days);
        List<CsVehicle> list = pageInfo.getList();
        for (CsVehicle data : list) {
            registResolvers(data);
        }
        TableResult<CsVehicle> result = new TableResult<>(pageInfo);
        return result;
    }

    /**
     * 注册属性内容解析器
     */
    void registResolvers(CsVehicle data) {
        if (data != null) {
            data.registResolver(CsVehicleResolver.接入商.getResolver());
            data.registResolver(CsVehicleResolver.车型.getResolver());
            data.registResolver(CsVehicleResolver.车机设备.getResolver());
            data.registResolver(CsVehicleResolver.车身颜色.getResolver());
            data.registResolver(CsVehicleResolver.地标类型.getResolver());
            data.registResolver(CsVehicleResolver.车辆领域.getResolver());
            data.registResolver(CsVehicleResolver.状态.getResolver());
        }
    }
}
