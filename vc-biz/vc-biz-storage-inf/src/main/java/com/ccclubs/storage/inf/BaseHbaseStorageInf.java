package com.ccclubs.storage.inf;

import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/3/30
 * @Time: 11:12
 * @Description: 此接口是为了抽象从规则引擎写入Phoenix服务的调用的，
 * 用以精简冗余代码，提升代码可读性和拓展性的。
 * 主要思想是依赖倒置和开闭原则。
 */
public interface BaseHbaseStorageInf<T> {
    /**
     * 存储T类型的历史数据到mongoDB，此方法现在已经废弃。
     * */
    @Deprecated
    void saveHistoryData(T data);
    /**
     * 存储T类型的历史数据到HBASE。
     * */
    void saveHistoryDataToHbase(T data);
    /**
     * 存储T类型的历史数据的集合到HBASE。
     * */
    void saveHistoryDataToHbase(List<T> listData);

}
