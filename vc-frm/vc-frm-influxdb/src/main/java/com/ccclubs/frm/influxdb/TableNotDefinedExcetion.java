package com.ccclubs.frm.influxdb;

/**
 * Created by kevin on 16/11/24.
 */
public class TableNotDefinedExcetion extends Exception {
    TableNotDefinedExcetion(String msg)
    {
        super(msg);
    }
}
