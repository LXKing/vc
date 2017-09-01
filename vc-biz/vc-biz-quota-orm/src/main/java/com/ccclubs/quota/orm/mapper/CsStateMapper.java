package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.CsState;
import com.ccclubs.quota.orm.model.CsStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsStateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    long countByExample(CsStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int deleteByExample(CsStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer cssId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int insert(CsState record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int insertSelective(CsState record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    List<CsState> selectByExample(CsStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    CsState selectByPrimaryKey(Integer cssId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsState record, @Param("example") CsStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsState record, @Param("example") CsStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CsState record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_state
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CsState record);
}