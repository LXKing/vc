package com.ccclubs.storage.inf;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @param <T>
 * @Author Alban
 * 此接口用于抽象存储类的需要实现的基本功能。
 */
public interface BaseHistoryInf<T> {

    /**
     * 传入 {@link PreparedStatement} 到此方法，
     * 会依据实现将{@param historyDate}中的值组装到
     *
     * @param preparedStatement 中。
     * @throws SQLException
     */
    void insertBulid(T historyDate, PreparedStatement preparedStatement) throws SQLException;

    /**
     * @param records 需要存储的值的List集合。
     *                写入或更新信息
     */
    void saveOrUpdate(List<T> records);

}
