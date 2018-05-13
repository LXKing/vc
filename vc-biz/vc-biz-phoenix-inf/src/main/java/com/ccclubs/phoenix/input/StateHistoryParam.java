package com.ccclubs.phoenix.input;

import com.ccclubs.phoenix.orm.consts.PhoenixFieldsConsts;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/8
 * @Time: 10:32
 * @Description: 全新重构的历史查询接口输入参数！
 */

public class StateHistoryParam extends CommonQuery implements Serializable {

    private static final long serialVersionUID = -3564573388669759575L;

    private String vin;

    private String teNumber;

    private String timePoint;

    private String queryFields="";

    private String tableName;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public String getQueryFields() {
        queryFields= StringUtils.deleteWhitespace(queryFields);
        if("*".equals(queryFields)){
            queryFields= StringUtils.join(PhoenixFieldsConsts.carStateAllFields,",");
        }
        else if(StringUtils.isEmpty(queryFields)){
            queryFields= StringUtils.join(PhoenixFieldsConsts.carStatePageDefaultFields,",");
        }
        else if ("PACE".equals(queryFields)){
            queryFields=StringUtils.join(PhoenixFieldsConsts.carPaceFields,",");
        }
        return queryFields;

    }

    public void setQueryFields(String queryFields) {
        this.queryFields = queryFields;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
