package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.SrvHost;
import com.ccclubs.pub.orm.model.SrvHostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SrvHostMapper {
    long countByExample(SrvHostExample example);

    int deleteByExample(SrvHostExample example);

    int deleteByPrimaryKey(Integer shId);

    int insert(SrvHost record);

    int insertSelective(SrvHost record);

    List<SrvHost> selectByExample(SrvHostExample example);

    SrvHost selectByPrimaryKey(Integer shId);

    int updateByExampleSelective(@Param("record") SrvHost record,
        @Param("example") SrvHostExample example);

    int updateByExample(@Param("record") SrvHost record, @Param("example") SrvHostExample example);

    int updateByPrimaryKeySelective(SrvHost record);

    int updateByPrimaryKey(SrvHost record);
}