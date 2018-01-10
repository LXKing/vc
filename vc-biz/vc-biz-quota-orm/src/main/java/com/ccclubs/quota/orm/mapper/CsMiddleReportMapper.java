package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.CsMiddleReport;
import com.ccclubs.quota.orm.model.CsMiddleReportExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3 0003.
 */
public interface CsMiddleReportMapper {

    List<CsMiddleReport> selectByExample(CsMiddleReportExample example);

    void  updateByExampleSelective(@Param("record") CsMiddleReport record,@Param("example") CsMiddleReportExample example);

    void insertBatchSelective(List<CsMiddleReport> list);

    void insertSelective(CsMiddleReport csMiddleReport);
}
