package com.ccclubs.frm.spring.util;

import java.util.UUID;

/**
 * UUID生成
 *
 * @author jianghaiyang
 * @create 2018-09-06
 **/
public class UuidUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
