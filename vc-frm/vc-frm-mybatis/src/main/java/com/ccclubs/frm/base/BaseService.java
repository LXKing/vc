package com.ccclubs.frm.base;


import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * service基类
 * @author Joel
 * @create 2017-8-11
 */
public interface BaseService<T, PK> extends BaseDAO<T, PK>{

//    T get(PK id);
//
//    T get2(PK id);
//
//    int save(T t);
//
//    int batchSave(List<T> ts);

    /**
     * 分页查询
     * @param t
     * @return
     */
    PageInfo<T> getPage(Object t, int pageNum, int pageSize);
    
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(Object[] ids);
//
//    /**
//     * 逻辑删除
//     * @param t
//     * @return
//     */
//    int delete(T t);
//
//    /**
//     * 逻辑删除
//     * @param id
//     * @return
//     */
//    int deleteById(PK id);
//
    List<T> getAll();


    List<T> getAllByParam(Object t);

}
