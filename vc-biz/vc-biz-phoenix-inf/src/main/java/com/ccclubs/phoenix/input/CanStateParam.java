package com.ccclubs.phoenix.input;

import com.ccclubs.phoenix.orm.consts.PhoenixFieldsConsts;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * 2018/9/17
 * CanState 查询条件
 *
 * @author machuanpeng
 */
public class CanStateParam extends CommonQuery implements Serializable {

    private static final long serialVersionUID = 1523254466062601494L;
    /**
     * can记录时间戳
     */
    private Long canTime;
    /**
     * 车机号
     */
    private String teNumber;
    /**
     * 查询字段
     */
    private String queryFields = "";

    public String getQueryFields() {
        queryFields = StringUtils.deleteWhitespace(queryFields);
        queryFields = StringUtils.join(PhoenixFieldsConsts.carStateAllNewFields, ",");
        return queryFields;
    }

    public void setQueryFields(String queryFields) {
        this.queryFields = queryFields;
    }

    public Long getCanTime() {
        return canTime;
    }

    public void setCanTime(Long canTime) {
        this.canTime = canTime;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }
}
