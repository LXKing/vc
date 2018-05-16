package com.ccclubs.phoenix.input;

import com.ccclubs.phoenix.orm.consts.PhoenixFieldsConsts;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
@Deprecated
public class CarGbHistoryParam extends Page implements Serializable{


    private static final long serialVersionUID = -6596177061016048194L;

    private String cs_vin;

    private String start_time;

    private String end_time;

    private String query_fields="";

    private String order="desc";

    private String tableName;

    public String getCs_vin() {
        return cs_vin;
    }

    public void setCs_vin(String cs_vin) {
        this.cs_vin = cs_vin;
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
            query_fields= StringUtils.join(PhoenixFieldsConsts.carGbAllFields,",");
        }
        else if(StringUtils.isEmpty(query_fields)){
            query_fields= StringUtils.join(PhoenixFieldsConsts.carGbPageDefaultFields,",");
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "CarGbHistoryParam{" +
                "cs_vin='" + cs_vin + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", query_fields='" + query_fields + '\'' +
                ", order='" + order + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
