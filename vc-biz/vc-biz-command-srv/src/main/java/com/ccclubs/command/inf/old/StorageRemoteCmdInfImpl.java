package com.ccclubs.command.inf.old;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.StorageRemoteCmdInput;
import com.ccclubs.command.dto.StorageRemoteCmdOutput;
import com.ccclubs.command.inf.air.impl.AirConditionerCmdImpl;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.CsRemoteUtil;
import com.ccclubs.command.util.IdGeneratorHelper;
import com.ccclubs.command.util.ResultHelper;
import com.ccclubs.command.util.TerminalOnlineHelper;
import com.ccclubs.command.util.ValidateHelper;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0.0
 * @time 2018/8/21
 * @auther Alban
 * @email fengjun@ccclubs.com
 */
@Service(version = CommandServiceVersion.V1)
public class StorageRemoteCmdInfImpl implements StorageRemoteCmdInf {


    private static final Logger logger = LoggerFactory.getLogger(AirConditionerCmdImpl.class);


    @Autowired
    private CsStructMapper sdao;

    /**
     * 验证
     */
    @Resource
    private ValidateHelper validateHelper;


    @Resource
    private CsRemoteManager csRemoteManager;

    /**
     * 上下线查询
     */
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;

    @Resource
    IdGeneratorHelper idGen;

    /**
     * 将指令存储到mongo
     */
    @Override
    public StorageRemoteCmdOutput saveRemoteCmdToMongo(StorageRemoteCmdInput input) {

        // 获取结构ID
        Long structId =input.getStructId();
        logger.debug("begin save command {} start.", structId);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, input.getVin());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        if (csStruct == null || StringUtils.isEmpty(csStruct.getCssRequest())) {
            logger.error("指令[{}]不存在!", input.getStructId());
            throw new ApiException(ApiEnum.COMMAND_NOT_FOUND);
        }
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(input.getValues(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil
                .construct(csVehicle, csMachine, structId, array, input.getUser(), csrId);
        csRemoteManager.asyncSave(csRemote);
        StorageRemoteCmdOutput storageRemoteCmdOutput=new StorageRemoteCmdOutput();
        storageRemoteCmdOutput.setStrJson(input.getValues());
        storageRemoteCmdOutput.setRemoteId(csrId);
        return storageRemoteCmdOutput;
    }
}
