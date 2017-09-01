package com.ccclubs.demo.orm.mapper;

import com.ccclubs.demo.orm.model.CsCan;
import com.ccclubs.demo.orm.model.CsCanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsCanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    long countByExample(CsCanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int deleteByExample(CsCanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long cscId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int insert(CsCan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int insertSelective(CsCan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    List<CsCan> selectByExample(CsCanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    CsCan selectByPrimaryKey(Long cscId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsCan record, @Param("example") CsCanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsCan record, @Param("example") CsCanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CsCan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CsCan record);
}