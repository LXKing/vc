package com.ccclubs.command.inf.tamper.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.TamperInput;
import com.ccclubs.command.dto.TamperOutput;
import com.ccclubs.command.inf.tamper.TamperCmdInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.util.CmdUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.Tools;
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
 * 防拆控制服务
 * @auther Vincent
 * @wechat luxiaotao1123
 * @data 2018/8/21
 */
@Service(version = CommandServiceVersion.V1)
public class TamperCmdInfImpl implements TamperCmdInf {

    private static final Logger logger = LoggerFactory.getLogger(TamperCmdInfImpl.class);

    @Resource
    private ValidateHelper validateHelper;
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Resource
    private ResultHelper resultHelper;
    @Resource
    private CsRemoteManager csRemoteManager;
    @Resource
    IdGeneratorHelper idGen;
    @Autowired
    private CommandProcessInf process;
    @Autowired
    private CsStructMapper sdao;


    /**
     * 防拆指令下发
     * @param input
     * @return
     */
    @DataAuth
    @Override
    public TamperOutput tamperCommandComply(TamperInput input) {
        Long structId = CommandConstants.CMD_TAMPER.longValue();
        logger.debug("begin process command {} start.", structId);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine,input.getVin());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                        format("[{\"value\":\"{}\"}]", input.codeToHexString()).getMessage(),
                Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, input.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        TamperOutput output = new TamperOutput();
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);

        return output;
    }

    public static void main(String[] args) {
        String cssReq = "[{\"type\":\"Byte\",\"name\":\"function\",\"title\":\"功能码\",\"size\":\"1\",\"defaultValue\":\"0x06\",\"child\":[],\"define\":[]},{\"type\":\"Short\",\"name\":\"address\",\"title\":\"输出地址\",\"size\":\"2\",\"defaultValue\":\"0x1022\",\"child\":[],\"define\":[]},{\"type\":\"Short\",\"name\":\"value\",\"title\":\"输出值\",\"size\":\"2\",\"defaultValue\":\"0x0010\",\"child\":[],\"define\":[]},{\"type\":\"Byte\",\"name\":\"config\",\"title\":\"配置类型\",\"size\":\"1\",\"defaultValue\":\"0x05\",\"child\":[],\"define\":[]},{\"type\":\"Byte\",\"name\":\"value\",\"title\":\"配置值\",\"size\":\"1\",\"defaultValue\":\"\",\"child\":[],\"define\":[]}]";
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                        format("[{\"value\":\"{}\"}]", "0x01").getMessage(),
                Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);
        String resultCode = CmdUtils
                .getSimpleMQTTRemoteCommend(13213211L, "T66V0975", array);
        System.out.println(resultCode);
        byte[] srcArray = Tools.HexString2Bytes(resultCode);
        String simNo = "64806774370";
        T808Message ts = ProtocolTools.package2T808Message(simNo, srcArray);
        byte[] bytes = ts.WriteToBytes();

        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(byte b : bytes) {
            buf.append(String.format("%02x", b & 0xff));
        }

        System.out.println(buf.toString());

    }

}


//7E 8900 0018 064806774370 0000 F1 5436365630393735 0000000000000038 06102200100501 7D01 7E
//7e 8900 0018 064806774370 0000 f1 5436365630393735 0000000000c99e1b 06102200100501 09 7e
