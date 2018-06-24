package com.ccclubs.frm.influxdb;

/**
 * Created by kevin on 16/11/24.
 */
public class TableNotDefinedException extends Exception {
    TableNotDefinedException(String msg) {
        super(msg);
    }
}
