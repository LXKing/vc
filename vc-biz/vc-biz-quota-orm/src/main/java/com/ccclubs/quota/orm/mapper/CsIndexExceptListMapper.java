package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.CsIndexExceptList;
import com.ccclubs.quota.orm.model.CsIndexExceptListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsIndexExceptListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    long countByExample(CsIndexExceptListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int deleteByExample(CsIndexExceptListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long indexId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int insert(CsIndexExceptList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int insertSelective(CsIndexExceptList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    List<CsIndexExceptList> selectByExampleWithBLOBs(CsIndexExceptListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    List<CsIndexExceptList> selectByExample(CsIndexExceptListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    CsIndexExceptList selectByPrimaryKey(Long indexId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsIndexExceptList record, @Param("example") CsIndexExceptListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") CsIndexExceptList record, @Param("example") CsIndexExceptListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsIndexExceptList record, @Param("example") CsIndexExceptListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CsIndexExceptList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_except_list
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(CsIndexExceptList record);
}