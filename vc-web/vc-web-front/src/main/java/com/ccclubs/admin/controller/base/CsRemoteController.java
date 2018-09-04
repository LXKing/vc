package com.ccclubs.admin.controller.base;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.admin.entity.CsMappingCrieria;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.model.CsMapping;
import com.ccclubs.admin.model.CsModelMapping;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.SrvGroup;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.query.CsMachineQuery;
import com.ccclubs.admin.query.CsVehicleQuery;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.ICsMappingService;
import com.ccclubs.admin.service.ICsModelMappingService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.service.ISrvGroupService;
import com.ccclubs.admin.util.UserAccessUtils;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.command.dto.DealRemoteCmdInput;
import com.ccclubs.command.dto.StorageRemoteCmdInput;
import com.ccclubs.command.dto.StorageRemoteCmdOutput;
import com.ccclubs.command.inf.old.DealRemoteCmdInf;
import com.ccclubs.command.inf.old.StorageRemoteCmdInf;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.orm.query.CsRemoteQuery;
import com.ccclubs.mongo.service.impl.CsRemoteService;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CsRemote
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("monitor/historyRemote")
public class CsRemoteController {

    private static Logger logger = LoggerFactory.getLogger(CsRemoteController.class);
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsRemoteService csRemoteService;
    @Autowired
    ISrvGroupService srvGroupService;
    @Autowired
    UserAccessUtils userAccessUtils;
    @Autowired
    ICsMappingService csMappingService;
    @Autowired
    ICsModelMappingService csModelMappingService;

    @Autowired
    ICsMachineService csMachineService;
    @Autowired
    ICsVehicleService csVehicleService;
    @Reference(version = CommandServiceVersion.V1)
    DealRemoteCmdInf dealRemoteCmdService;
    @Reference(version = CommandServiceVersion.V1)
    StorageRemoteCmdInf storageRemoteCmdService;


    /**
     * 获取分页列表数据
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<CsRemote> list(CsRemoteQuery query,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            @RequestParam(defaultValue = "csrAddTime") String order) {
        PageInfo<CsRemote> pageResult = csRemoteService
                .getPage(query, new PageRequest(page, rows, new Sort(Sort.Direction.DESC, order)));
        List<CsRemote> list = pageResult.getList();
        for (CsRemote data : list) {
            registResolvers(data);
        }
        TableResult<CsRemote> tableResult = new TableResult<>(page, rows, pageResult);
        return tableResult;
    }

    /**
     * 删除数据
     */
    @RequestMapping(value = "delete/{ids}", method = RequestMethod.DELETE)
    public int list(@PathVariable("ids") String ids) {
        return csRemoteService.delete(ids);
    }

    @RequestMapping(value = "doRemote", method = RequestMethod.POST)
    public VoResult<?> doRemote(@CookieValue("token") String token
            , String targetVehicles, String remark
            , String strJson, Long structId) {

        if (null == targetVehicles || targetVehicles.isEmpty()) {

            return VoResult.error("30001", "参数号码列表为空");
        }
        if (structId == null) {
            return VoResult.error("30001", "未选择指令");
        }
        if (null == strJson || strJson.isEmpty()) {
            return VoResult.error("30001", "未填写指令值");
        }
        String[] targetVehicleLsit = targetVehicles.split(",");
        if (!(targetVehicleLsit.length > 0)) {
            return VoResult.error("30001", "参数号码列表为空");
        }

        CsVehicleQuery query = new CsVehicleQuery();
        //先添加统一的用户查询权限条件。
        SrvUser user = userAccessUtils.getCurrentUser(token);
        String authority = addQueryConditionsByUser(user, query);
        logger.info("authority=" + authority);
//想法是首先得到对应的用户组来进行处理，对query加上新的条件来限制查询到的结果。
//    if (null == user) {
//      return new ResultMsg<>(false,
//          ResultCode.INVALID_TOKEN, null);
//    }
        if (null == authority) {
            return VoResult.error("30001", "用户错误");
        }
        List<CsVehicle> csVehicleList = new ArrayList<>();

        CsMachineQuery csMachineQuery = new CsMachineQuery();
        csMachineQuery.setCsmNumberIn(targetVehicleLsit);
        List<CsMachine> csMachineList = csMachineService.getAllByParam(csMachineQuery.getCrieria());

        if (null != csMachineList && csMachineList.size() > 0) {
            Integer[] csMachineIds = new Integer[csMachineList.size()];
            for (int i = 0; i < csMachineList.size(); i++) {
                csMachineIds[i] = csMachineList.get(i).getCsmId();
            }
            //首先查询车机号码符合条件的
            CsVehicleQuery csVehicleQueryForMachine = null;
            try {
                csVehicleQueryForMachine = (CsVehicleQuery) query.clone();
            } catch (CloneNotSupportedException e) {
                logger.debug(e.getMessage());
            }
            if (null != csVehicleQueryForMachine) {
                csVehicleQueryForMachine.setCsvMachineIn(csMachineIds);
                csVehicleList.addAll(csVehicleService
                        .getAllByParam(csVehicleQueryForMachine.getCrieria()));
            }
        }

        //然后查询车牌号码符合条件的
        CsVehicleQuery csVehicleQueryForCarNumber = null;
        try {
            csVehicleQueryForCarNumber = (CsVehicleQuery) query.clone();
        } catch (CloneNotSupportedException e) {
            logger.debug(e.getMessage());
        }
        if (null != csVehicleQueryForCarNumber) {
            csVehicleQueryForCarNumber.setCsvCarNoIn(targetVehicleLsit);
            csVehicleList.addAll(csVehicleService
                    .getAllByParam(csVehicleQueryForCarNumber.getCrieria()));
        }
        //最后查询车架号码符合条件的
        CsVehicleQuery csVehicleQueryForCsVin = null;
        try {
            csVehicleQueryForCsVin = (CsVehicleQuery) query.clone();
        } catch (CloneNotSupportedException e) {
            logger.debug(e.getMessage());
        }
        if (null != csVehicleQueryForCsVin) {
            csVehicleQueryForCsVin.setCsvVinIn(targetVehicleLsit);
            csVehicleList
                    .addAll(csVehicleService.getAllByParam(csVehicleQueryForCsVin.getCrieria()));
        }

        if (structId == 85 || structId == 86) {
            //订单下发时间转换处理
            List<Map> strArray = JSONArray.parseArray(strJson, Map.class);
            // 开始日期
            Date startTime = StringUtils
                    .date((String) strArray.get(0).get("startTime"), "yyyy-MM-dd HH:mm:ss");
            // 结束日期
            Date endTime = StringUtils
                    .date((String) strArray.get(0).get("endTime"), "yyyy-MM-dd HH:mm:ss");
            Integer startTimeInt = ProtocolTools.transformToTerminalTime(startTime);
            Integer endTimeInt = ProtocolTools.transformToTerminalTime(endTime);
            strArray.get(0).put("endTime", endTimeInt.toString());
            strArray.get(0).put("startTime", startTimeInt.toString());

            strJson = JSON.toJSONString(strArray);

        }

        if (csVehicleList.size() > 0) {
            //保存指令并发送指令
            for (CsVehicle csVehicle : csVehicleList) {
                logger.info("VIN码为{}车牌号为{}的车辆被发送指令{}"
                        , csVehicle.getCsvVin(), csVehicle.getCsvCarNo(), strJson);
                StorageRemoteCmdInput storageRemoteCmdInput = new StorageRemoteCmdInput();

                storageRemoteCmdInput.setStructId(structId);
                storageRemoteCmdInput.setUser(authority);
                storageRemoteCmdInput.setValues(strJson);
                storageRemoteCmdInput.setVin(csVehicle.getCsvVin());

                StorageRemoteCmdOutput storageRemoteCmdOutput =
                        storageRemoteCmdService.saveRemoteCmdToMongo(storageRemoteCmdInput);
                if (null != storageRemoteCmdOutput) {
                    DealRemoteCmdInput dealRemoteCmdInput = new DealRemoteCmdInput();
                    dealRemoteCmdInput.setRemoteId(storageRemoteCmdOutput.getRemoteId());
                    dealRemoteCmdInput.setStrJson(storageRemoteCmdOutput.getStrJson());
                    dealRemoteCmdService.dealRemoteCommand(dealRemoteCmdInput);
                }
            }

        }

        return VoResult.success();
    }


    /**
     * 根据用户添加查询条件。
     */
    private String addQueryConditionsByUser(SrvUser user, CsVehicleQuery query) {
        //首先判断用户所在的组。
        SrvGroup srvGroup = srvGroupService.selectByPrimaryKey(user.getSuGroup().intValue());
        if (srvGroup.getSgFlag().equals("sys_user")) {
            //系统用户，此种用户可以随意查询（为所欲为）
            return "SysUser: " + user.getSuRealName() + " 账户：" + user.getSuUsername();
        } else if (srvGroup.getSgFlag().equals("factory_user")) {
            //车厂 （按照车型进行查询）
            CsModelMapping csModelMapping = new CsModelMapping();
            csModelMapping.setUserId(user.getSuId());
            List<CsModelMapping> csModelMappingList = csModelMappingService.select(csModelMapping);
            if (null != csModelMappingList && csModelMappingList.size() > 0) {
                Integer[] csModelIds = new Integer[csModelMappingList.size()];
                for (int i = 0; i < csModelMappingList.size(); i++) {
                    csModelIds[i] = csModelMappingList.get(i).getModelId();
                }
                query.setCsvModelIn(csModelIds);
            }
            if (query.getCsvModelIn() == null) {
                return null;
            } else {
                return "FactoryUser: " + user.getSuRealName() + " 账户：" + user.getSuUsername();
            }

        } else if (srvGroup.getSgFlag().equals("platform_user")) {
            //小散户（通过mapping进行对应）
            CsMappingCrieria csMappingCrieria = new CsMappingCrieria();
            CsMappingCrieria.Criteria criteriaMapping = csMappingCrieria.createCriteria();
            criteriaMapping.andcsmManageEqualTo(user.getSuId());
            List<CsMapping> csMappingList = csMappingService.selectByExample(csMappingCrieria);
            if (null != csMappingList && csMappingList.size() > 0) {
                Integer[] carIds = new Integer[csMappingList.size()];
                for (int i = 0; i < csMappingList.size(); i++) {
                    carIds[i] = csMappingList.get(i).getCsmCar();
                }
                query.setCsvIdIn(carIds);
            }
            if (query.getCsvIdIn() == null) {
                return null;
            } else {
                return "PlatformUser: " + user.getSuRealName() + " 账户：" + user.getSuUsername();
            }
        }
        return "未知用户：" + user.getSuRealName() + " 账户：" + user.getSuUsername();
    }


    /**
     * 注册属性内容解析器
     */
    void registResolvers(CsRemote data) {
        if (data != null) {
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.授权系统.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.车机号.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.关联车辆.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.发送方式.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.指令类型.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.发送状态.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsRemoteResolver.操作结果.getResolver());
        }
    }
}
