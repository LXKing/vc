package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.VerTbox;
import com.ccclubs.pub.orm.model.VerTboxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VerTboxMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    long countByExample(VerTboxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int deleteByExample(VerTboxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int insert(VerTbox record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int insertSelective(VerTbox record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    List<VerTbox> selectByExample(VerTboxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    VerTbox selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VerTbox record, @Param("example") VerTboxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VerTbox record, @Param("example") VerTboxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VerTbox record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_tbox
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VerTbox record);
}