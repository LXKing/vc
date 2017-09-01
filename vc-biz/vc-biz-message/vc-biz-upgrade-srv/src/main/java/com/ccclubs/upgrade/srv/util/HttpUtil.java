package com.ccclubs.upgrade.srv.util;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * OkHttp通用封装
 *
 * @author jianghaiyang
 * @create 2017-08-14
 **/
public class HttpUtil {

    private static final OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS);

    public static final OkHttpClient client = builder.build();

}
