package com.ccclubs.command.inf.order.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.*;
import com.ccclubs.command.inf.order.OrderCmdInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.mqtt.*;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单指令实现
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
@Service(version = CommandServiceVersion.V1)
public class OrderCmdImpl implements OrderCmdInf {

    private static final Logger logger = LoggerFactory.getLogger(OrderCmdImpl.class);
    @Autowired
    private CsStructMapper sdao;
    @Autowired
    private CommandProcessInf process;
    @Resource
    private ValidateHelper validateHelper;
    @Resource
    private CsRemoteManager csRemoteManager;
    @Resource
    IdGeneratorHelper idGen;
    @Resource
    private ResultHelper resultHelper;
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Resource
    AuthValidateHelper authValidateHelper;

    /**
     * 订单数据下发指令（只判断成功与否，不返回data）
     *
     * @param input 订单指令参数
     * @return
     */
    @Override
    public IssueOrderOutput issueOrderData(IssueOrderInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Long structId = CommandConstants.CMD_ORDER.longValue();
        Date startTime = StringUtils.date(input.getStartTime(), CommandConstants.DATE_FORMAT);
        Date endTime = StringUtils.date(input.getEndTime(), CommandConstants.DATE_FORMAT);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, input.getVin());

        // add at 2017-11-17 ，兼容长安出行订单下发
        String rfidCode = StringUtils.empty(input.getRfid()) ? "00000000" : input.getRfid();
        int code = null == input.getAuthCode() ? 111111 : input.getAuthCode();

        while (rfidCode.length() < 8) {
            rfidCode = "0" + rfidCode;
        }

        if (code > 999999 || code < 100000) {
            code = 111111;
        }

        OrderDownStreamNew orderDownStream = new OrderDownStreamNew(csMachine.getCsmNumber(),
                input.getOrderId(), ProtocolTools.transformToTerminalTime(startTime),
                ProtocolTools.transformToTerminalTime(endTime), input.getOrderId(),
                rfidCode, code, input.getRealName(), input.getMobile(), input.getGender());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                arrayFormat("[{\"orderId\":\"{}\",\"startTime\":\"{}\",\"endTime\":\"{}\",\"rfid\":\"{}\",\"code\":\"{}\",\"simNo\":\"{}\",\"gender\":\"{}\",\"firstName\":\"{}\",\"secondName\":\"{}\",\"lastName\":\"{}\"}]",
                        orderDownStream.getArray()).getMessage(), Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, input.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        IssueOrderOutput output = new IssueOrderOutput();
        // 4.确认结果
        switch (input.getResultType()) {
            case 1://async
                output.setMessageId(csRemote.getCsrId());
                break;
            case 2://sync
                output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);
                break;
            case 3://http
                break;
        }
        return output;
    }

    /**
     * 下发订单数据--需要授权信息
     *
     * @param input 指令参数
     * @return
     */
    @Override
    public IssueAuthOrderOutput issueAuthOrderData(IssueAuthOrderInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Long structId = CommandConstants.CMD_ORDER_AUTH.longValue();
        Date startTime = StringUtils.date(input.getStartTime(), CommandConstants.DATE_FORMAT);
        Date endTime = StringUtils.date(input.getEndTime(), CommandConstants.DATE_FORMAT);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        OrderDownStream orderDownStream = new OrderDownStream(csMachine.getCsmNumber(),
                input.getOrderId(), ProtocolTools.transformToTerminalTime(startTime),
                ProtocolTools.transformToTerminalTime(endTime), input.getOrderId(),
                input.getRfid(), input.getAuthCode());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(Long.parseLong(structId.toString()));
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                arrayFormat("[{\"orderId\":\"{}\",\"startTime\":\"{}\",\"endTime\":\"{}\",\"rfid\":\"{}\",\"code\":\"{}\"}]",
                        orderDownStream.getArray()).getMessage(), Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, input.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        // 4.确认结果
        IssueAuthOrderOutput output = new IssueAuthOrderOutput();
        switch (input.getResultType()) {
            case 1://async
                output.setMessageId(csRemote.getCsrId());
                break;
            case 2://sync
                output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);
                break;
            case 3://http
                break;
        }
        return output;
    }

    @Override
    public IssueOrderDetailOutput issueOrderDetailData(IssueOrderDetailInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        OrderDetailDownStream orderDetailDownStream = new OrderDetailDownStream(
                csMachine.getCsmNumber(), input.getOrderId(), input.getRealName(), input.getMobile(),
                input.getOrderId(), input.getGender());
        // 发送指令
        logger.debug("command send start.");
        try {
            process.dealRemoteCommand(csMachine, orderDetailDownStream.getBytes(), false);
            return new IssueOrderDetailOutput();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public RenewOrderOutput renewOrder(RenewOrderInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Date renewTime = StringUtils.date(input.getRenewEndTime(), CommandConstants.DATE_FORMAT);
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        TimeSynchronization orederRenew = new TimeSynchronization(csMachine.getCsmNumber(),
                input.getOrderId(),
                ProtocolTools.transformToTerminalTime(renewTime), (short) 0x900E, (short) 0x0002);

        // 发送指令
        logger.debug("command send start.");
        try {
            process.dealRemoteCommand(csMachine, orederRenew.getBytes(), false);
            return new RenewOrderOutput();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public RenewOrderReplyFOutput renewOrderReplyFailed(RenewOrderReplyFInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        OrderModifyReplyFailure orderModifyReplyFailure = new OrderModifyReplyFailure(
                csMachine.getCsmNumber(),
                input.getOrderId(),
                input.getFlag());

        // 发送指令
        logger.debug("command send start.");
        try {
            process.dealRemoteCommand(csMachine, orderModifyReplyFailure.getBytes(), false);
            return new RenewOrderReplyFOutput();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public RenewOrderReplySOutput renewOrderReplySuccess(RenewOrderReplySInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Date renewTime = StringUtils.date(input.getRenewEndTime(), CommandConstants.DATE_FORMAT);
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        OrderModifyReplySuccess orderModifyReplySuccess = new OrderModifyReplySuccess(
                csMachine.getCsmNumber(),
                input.getOrderId(),
                ProtocolTools.transformToTerminalTime(renewTime));

        // 发送指令
        logger.debug("command send start.");
        try {
            process.dealRemoteCommand(csMachine, orderModifyReplySuccess.getBytes(), false);
            return new RenewOrderReplySOutput();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.SYSTEM_ERROR);
        }
    }
}
