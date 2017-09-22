package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.orm.model.CsIndexReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsIndexReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    long countByExample(CsIndexReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    int deleteByExample(CsIndexReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    int insert(CsIndexReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    int insertSelective(CsIndexReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    List<CsIndexReport> selectByExample(CsIndexReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsIndexReport record,
        @Param("example") CsIndexReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_report
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsIndexReport record,
        @Param("example") CsIndexReportExample example);

    List<CsIndexReport> selectByExampleRelateCsState(CsIndexReportExample example);

}