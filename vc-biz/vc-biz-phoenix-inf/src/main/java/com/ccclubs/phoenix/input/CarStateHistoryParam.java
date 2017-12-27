package com.ccclubs.phoenix.input;

import com.ccclubs.phoenix.orm.consts.Consts;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　 ┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/27 0027
 */
public class CarStateHistoryParam extends Page implements Serializable{

    private static final long serialVersionUID = -2518526959670695115L;

    private String csVin;

    private String cs_number;

    private String start_time;

    private String end_time;

    private String query_fields="";

    private String order="desc";

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCsVin() {
        return csVin;
    }

    public void setCsVin(String csVin) {
        this.csVin = csVin;
    }

    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getQuery_fields() {
        query_fields= StringUtils.deleteWhitespace(query_fields);
        if("*".equals(query_fields)){
            query_fields= StringUtils.join(Consts.carStateAllFields,",");
        }
        else if(StringUtils.isEmpty(query_fields)){
            query_fields= StringUtils.join(Consts.carStatePageDefaultFields,",");
        }
        else if ("PACE".equals(query_fields)){
            query_fields=StringUtils.join(Consts.carPaceFields,",");
        }
        return query_fields;
    }

    public void setQuery_fields(String query_fields) {
        this.query_fields = query_fields;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "CarStateHistoryParam{" +
                "csVin='" + csVin + '\'' +
                ", cs_number='" + cs_number + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", query_fields='" + query_fields + '\'' +
                ", order='" + order + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
