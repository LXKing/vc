package com.ccclubs.frm.base;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Joel
 * @create 2017-8-11
 */
public interface BaseDAO<T, PK>  extends Mapper<T>, MySqlMapper<T> {

//    int batchInsert(List<T> ts);
//
//    List<T> selectByParam(T t);
//
//    int countTotal(T t);
//
//    T selectById(PK id);
//
////    int insert(T record);
//
//    int insertSelective(T record);
//
//    int updateByPrimaryKeySelective(T record);
//
//    int updateByPrimaryKey(T record);

}
