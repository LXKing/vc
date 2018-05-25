package com.ccclubs.phoenix.input;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 17:11
 * @Description: 参数基础接口！
 */
public interface BaseParamInf {
    String getQueryFields();

    void setQueryFields(String queryFields);

    String getVin();

    void setVin(String vin);

    String getTeNumber();

    void setTeNumber(String teNumber);


    String getStartTime();

    void setStartTime(String startTime);

    String getEndTime();

    void setEndTime(String endTime);

    String getOrder();

    void setOrder(String order);

    String getAppId();

    void setAppId(String appId);

    int getPageNum();

    void setPageNum(int pageNum);

    int getPageSize();

    void setPageSize(int pageSize);

}
