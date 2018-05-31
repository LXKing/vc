package com.ccclubs.gateway.jt808.util;

import com.ccclubs.gateway.jt808.constant.msg.AckReaultType;
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


}
