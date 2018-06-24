package com.ccclubs.gateway.jt808.util;

import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.msg.AckReaultType;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;
import com.ccclubs.gateway.jt808.message.pac.PacHeader;
import com.ccclubs.gateway.jt808.message.pac.Package808;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 16:02
 * Email:  yeanzhi@ccclubs.com
 * 回应构造器
 */
public final class AckBuilder {

    public static Package808 ofNormal(Integer serialNo, Integer pacId, String mobile, AckReaultType reaultType) {
        Package808 pac = Package808.ofNew();
        // header
        pac.getHeader()
                .setPacId(pacId)
                .setTerMobile(mobile)
                .setPacSerialNo(serialNo)
                .setPacContentAttr(null)
                .setPacSealInfo(null);

        // body
        pac.getBody().setContent(null);
        return pac;
    }

    public static Package808 fromSourcePac(Package808 sourcePac) {
        // 原报文头部
        PacHeader sourceHeader = sourcePac.getHeader();

        // 应答报文实体
        Package808 pac = Package808.ofNew();
        // header
        pac.getHeader()
                .setPacId(PacUtil.getAckPacType(sourceHeader.getPacId()).getCode())
                .setTerMobile(sourceHeader.getTerMobile())
                .setPacSerialNo(null)
                .setPacContentAttr(null)
                .setPacSealInfo(null);

        // body
        pac.getBody().setContent(null);
        return pac;
    }


}
