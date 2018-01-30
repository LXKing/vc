package com.ccclubs.command.util;

import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.util.CmdUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;

/**
 * CsRemote组装
 *
 * @author jianghaiyang
 * @create 2018-01-25
 **/
public class CsRemoteUtil {
    public static CsRemote construct(CsVehicle v, CsMachine m, Long structId, Object[] array, String appId, Long csrId) {
        CsRemote csRemote = new CsRemote();
        String resultCode = CmdUtils.getSimpleMQTTRemoteCommend(csrId, m.getCsmNumber(), array);
        csRemote.setCsrCode(resultCode);
        csRemote.setCsrId(csrId);
        csRemote.setCsrAccess(m.getCsmAccess());
        csRemote.setCsrHost(m.getCsmHost());
        csRemote.setCsrNumber(m.getCsmNumber());
        csRemote.setCsrCar(v.getCsvId());
        csRemote.setCsrWay(0);//0:网关 1:短信 断线的车辆建议用短信方式
        csRemote.setCsrType(structId.intValue());
        csRemote.setCsrEditor(appId);
        csRemote.setCsrAddTime(System.currentTimeMillis());
        csRemote.setCsrUpdateTime(null);
        // 因为是异步保存mongo，状态为已发送
        csRemote.setCsrState(1);//0:未发送 1:已发送 2:组装中
        csRemote.setCsrStatus(0);//0:未知 1:操作成功 2:操作失败
        return csRemote;
    }

    public static CsRemote construct808(CsVehicle v, CsMachine m, Long structId, String appId, Long csrId, Long csrsId) {
        CsRemote csRemote = new CsRemote();
        csRemote.setCsrId(csrId);
        csRemote.setCsrsId(csrsId);
        csRemote.setCsrAccess(m.getCsmAccess());
        csRemote.setCsrHost(m.getCsmHost());
        csRemote.setCsrNumber(m.getCsmNumber());
        csRemote.setCsrCar(v.getCsvId());
        csRemote.setCsrWay(0);//0:网关 1:短信 断线的车辆建议用短信方式
        csRemote.setCsrType(structId.intValue());
        csRemote.setCsrEditor(appId);
        csRemote.setCsrAddTime(System.currentTimeMillis());
        csRemote.setCsrUpdateTime(null);
        csRemote.setCsrState(2);//0:未发送 1:已发送 2:组装中
        csRemote.setCsrStatus(0);//0:未知 1:操作成功 2:操作失败
        return csRemote;
    }
}
