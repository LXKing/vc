package com.ccclubs.admin.controller.can;

import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.resolver.CsVehicleResolver;
import com.ccclubs.admin.service.ICsMappingService;
import com.ccclubs.admin.service.ICsModelMappingService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.service.ISrvGroupService;
import com.ccclubs.admin.task.threads.BackgroundReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.util.UserAccessUtils;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    BackgroundReportThread reportThread;
    @Autowired
    UserAccessUtils userAccessUtils;
    @Autowired
    ISrvGroupService srvGroupService;
    @Autowired
    ICsModelMappingService csModelMappingService;
    @Autowired
    ICsMappingService csMappingService;

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

    /**
     * 2018/9/21
     * 数据导出
     *
     * @param vin
     * @param days
     * @return com.ccclubs.admin.vo.VoResult<java.lang.String>
     * @author machuanpeng
     */
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public VoResult<String> getReport(String vin, @RequestParam(defaultValue = "7") Integer days) {
        // 1、查询所有符合条件的车机
        List<CsVehicle> list = csVehicleService.getAllCarListWithTime(vin, days);
        // 2、车机信息转换填充
        for (CsVehicle data : list) {
            registResolvers(data);
        }
        // 3、要输出的字段
        HashMap<String, String> headerMap = this.getHeaderMap();
        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("Vehicle");
        reportThread.setList(list);
        reportThread.setUserUuid(uuid);
        reportThread.setHeadMap(headerMap);
        EvManageContext.getThreadPool().execute(reportThread);
        VoResult<String> r = new VoResult<>();
        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;
    }

    /**
     * 2018/9/21
     * 要输出的字段
     *
     * @param
     * @return java.util.HashMap<>
     * @author machuanpeng
     */
    private HashMap<String, String> getHeaderMap() {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("csvId", "编号");
        headerMap.put("csvAccessText", "接入商");
        headerMap.put("csvCarNo", "车牌号");
        headerMap.put("csvVin", "车架号");
        headerMap.put("csvEngineNo", "发动机(电机)编号");
        headerMap.put("csvCertific", "合格证号");
        headerMap.put("csvModelText", "车型");
        headerMap.put("csvMachineText", "车机设备");
        headerMap.put("csvColorCodeText", "车身颜色");
        headerMap.put("csvBataccuCode", "可充电储能系统编码");
        headerMap.put("csvProdDate", "出厂日期");
        headerMap.put("csvLandmarkText", "地标类型");
        headerMap.put("csvDomainText", "车辆领域");
        headerMap.put("csvModelCodeFull", "车型代码");
        headerMap.put("csvModelCodeSimple", "车型备案号");
        headerMap.put("csvInteriorColorCode", "内饰颜色");
        headerMap.put("csvStatusText", "状态");
        headerMap.put("csvAddTime", "添加时间");
        headerMap.put("csvUpdateTime", "修改时间");
        return headerMap;
    }

}
