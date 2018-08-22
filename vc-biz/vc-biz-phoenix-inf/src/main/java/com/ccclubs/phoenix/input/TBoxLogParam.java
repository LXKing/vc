package com.ccclubs.phoenix.input;

import com.ccclubs.phoenix.orm.consts.PhoenixFieldsConsts;
import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: GFA
 * @Project: vc
 * @Package: com.ccclubs.phoenix.input
 * @Date: 2018/08/20  14:10
 * @Description:
 */
public class TBoxLogParam extends CommonQuery implements Serializable,BaseParamInf {

    private static final long serialVersionUID = -3197150468095030871L;

    private String vin;

    private String teNumber;

    private String startTime;

    private String endTime;

    private Long orderNo;

    private String queryFields="";

    @Override
    public String getQueryFields() {
        queryFields= StringUtils.deleteWhitespace(queryFields);
        queryFields= StringUtils.join(PhoenixFieldsConsts.TBOX_LOG_FIELDS,",");
        return queryFields;
    }

    @Override
    public void setQueryFields(String queryFields) {
        this.queryFields = queryFields;
    }

    @Override
    public String getVin() {
        return vin;
    }

    @Override
    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String getTeNumber() {
        return teNumber;
    }

    @Override
    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    @Override
    public String getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }
}
