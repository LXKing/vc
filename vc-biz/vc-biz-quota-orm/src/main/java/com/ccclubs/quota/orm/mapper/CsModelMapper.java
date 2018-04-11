package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.CsModel;
import com.ccclubs.quota.orm.model.CsModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    long countByExample(CsModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int deleteByExample(CsModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer csmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int insert(CsModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int insertSelective(CsModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    List<CsModel> selectByExample(CsModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    CsModel selectByPrimaryKey(Integer csmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsModel record,
        @Param("example") CsModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsModel record, @Param("example") CsModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CsModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_model
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CsModel record);
}