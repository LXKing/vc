package com.ccclubs.phoenix.impl;

import com.ccclubs.phoenix.input.BaseParamInf;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 17:18
 * @Description: SQL组装类！
 */

public class SqlAssembly {

    private String countSql;
    private String querySql;
    private String pointValue;
    private boolean isPageQuery = false;

    private SqlAssembly() {
    }

    /**
     * @param param        调用方传入的参数。
     * @param norTableName Phoenix要查询的表的对应正常表（VIN码主键）
     * @param expTableName Phoenix要查询的表的对应异常表（TE_NUMBER主键）
     */
    public SqlAssembly(BaseParamInf param,
                       String norTableName,
                       String expTableName) {
        String tableName = null;
        String pointKeyName = null;
        //区分查询何张表
        if (param.getVin() != null) {
            tableName = norTableName;
            pointKeyName = "VIN";
            pointValue = param.getVin();
        } else if (param.getTeNumber() != null) {
            tableName = expTableName;
            pointKeyName = "TE_NUMBER";
            pointValue = param.getTeNumber();
        }

        countSql = "select count(current_time) as total from "
                + tableName + " where " + pointKeyName +
                "=? and current_time>=? and current_time<=? ";

        String pageSql = "";
        if (param.getPageNum() > 0) {
            pageSql = "limit ? offset ? ";
            isPageQuery = true;
        }

        querySql = "select " +
                param.getQueryFields() + " from " + tableName + " where " + pointKeyName +
                "=? and current_time>=? and current_time<=? order by current_time  "
                + param.getOrder() + " " + pageSql;
    }

    /**
     * @return 组装完的查询Phoenix的count聚合SQL语句
     */
    public String getCountSql() {
        return countSql;
    }

    /**
     * @return 组装完的查询Phoenix的count聚合SQL语句
     */
    public String getQuerySql() {
        return querySql;
    }

    /**
     * @return 查询的可变的主键对应的值
     * 如果是SQL条件是VIN码，则返回VIN码，如果是TE_NUMBER则是车机号
     */
    public String getPointValue() {
        return pointValue;
    }

    /**
     * @return 组装完的查询Phoenix的SQL语句是否是分页查询
     */
    public boolean isPageQuery() {
        return isPageQuery;
    }


}
