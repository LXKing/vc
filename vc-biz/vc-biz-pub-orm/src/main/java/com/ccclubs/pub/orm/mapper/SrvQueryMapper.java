package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.SrvQuery;
import com.ccclubs.pub.orm.model.SrvQueryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SrvQueryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    long countByExample(SrvQueryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int deleteByExample(SrvQueryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long sqId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int insert(SrvQuery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int insertSelective(SrvQuery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    List<SrvQuery> selectByExampleWithBLOBs(SrvQueryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    List<SrvQuery> selectByExample(SrvQueryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    SrvQuery selectByPrimaryKey(Long sqId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SrvQuery record, @Param("example") SrvQueryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") SrvQuery record, @Param("example") SrvQueryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SrvQuery record, @Param("example") SrvQueryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SrvQuery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(SrvQuery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_query
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SrvQuery record);
}