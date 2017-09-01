package com.ccclubs.upgrade.srv.util;

import okhttp3.MediaType;

/**
 * Created by Jkevin on 2017/8/1.
 */
public class Constants {
    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String APPKEY = "appkey";

    public static void main(String[] args) {
        System.err.println(
                "  +--------------------------------     Tips    ---------------------------------+\n" +
                "  |                                                                              |\n" +
                "  |                                                                              |\n" +
                "  |                  vtsearch-api started in prod successfully                   |\n" +
                "  |                                                                              |\n" +
                "  |                                                                              |\n" +
                "  +------------------------------------------------------------------------------+");
    }
}
