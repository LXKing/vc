package com.ccclubs.pub.orm.mapper;


import com.ccclubs.pub.orm.model.CsTboxBindHis;
import com.ccclubs.pub.orm.model.CsTboxBindHisExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 的Mapper实现
 * @author Joel
 */
public interface CsTboxBindHisMapper {
   int  insert(CsTboxBindHis csTboxBindHis);

    int updateByExampleSelective(@Param("record") CsTboxBindHis record, @Param("example") CsTboxBindHisExample example);

    List<CsTboxBindHis> selectByExample(CsTboxBindHisExample example);

}
