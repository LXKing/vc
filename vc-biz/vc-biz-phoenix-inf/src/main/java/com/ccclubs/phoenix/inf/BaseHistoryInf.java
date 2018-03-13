package com.ccclubs.phoenix.inf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface BaseHistoryInf<T> {

    void insertBulid(T historyDate,PreparedStatement preparedStatement) throws SQLException;
    //写入或更新信息
    void saveOrUpdate(List<T> records);

}
