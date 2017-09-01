package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.CsIndexMeta;
import com.ccclubs.quota.orm.model.CsIndexMetaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsIndexMetaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    long countByExample(CsIndexMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int deleteByExample(CsIndexMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long indexId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int insert(CsIndexMeta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int insertSelective(CsIndexMeta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    List<CsIndexMeta> selectByExample(CsIndexMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    CsIndexMeta selectByPrimaryKey(Long indexId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsIndexMeta record, @Param("example") CsIndexMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsIndexMeta record, @Param("example") CsIndexMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CsIndexMeta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_index_meta
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CsIndexMeta record);
}