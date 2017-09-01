package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.DvdVersionIntput;
import com.ccclubs.command.dto.DvdVersionOutput;
import com.ccclubs.command.dto.ReturnCheckOutput;
import com.ccclubs.command.inf.power.PowerModeSwitchImpl;
import com.ccclubs.command.inf.update.SetDvdVersionInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteService;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.ResultHelper;
import com.ccclubs.command.util.ValidateHelper;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongodb.orm.model.CsRemote;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DVD最新版本设置
 *
 * @author jianghaiyang
 * @create 2017-08-01
 **/
@Service(version = CommandServiceVersion.V1)
public class SetDvdVersionImpl implements SetDvdVersionInf{
    private static final Logger logger = LoggerFactory.getLogger(SetDvdVersionImpl.class);

    @Autowired
    private CommandProcessInf process;

    @Autowired
    private CsStructMapper sdao;

    @Resource
    private ValidateHelper validateHelper;

    @Resource
    private ResultHelper resultHelper;

    @Resource
    private CsRemoteService remoteService;

    @Override
    @DataAuth
    public DvdVersionOutput setDvdVersion(DvdVersionIntput input) {
        Integer structId = CommandConstants.CMD_DVD;
        logger.info("begin process command {} start.", structId);
        // 校验指令码
        if (null == structId) {
            throw new ApiException(ApiEnum.COMMAND_NOT_FOUND);
        }

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(Long.parseLong(structId.toString()));
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                format("[{\"value\":\"{}\"}]", input.getLatestVersion())
                .getMessage(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        CsRemote csRemote = remoteService.save(csVehicle, csMachine, structId, input.getAppId());

        // 3.发送指令
        logger.info("command send start.");
        process.dealRemoteCommand(csRemote, array);

        DvdVersionOutput output = new DvdVersionOutput();

        // 4.确认结果
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output);

        return output;
    }
}
