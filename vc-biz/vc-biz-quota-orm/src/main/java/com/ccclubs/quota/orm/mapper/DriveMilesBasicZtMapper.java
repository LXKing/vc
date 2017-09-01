package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.DriveMilesBasicZt;
import com.ccclubs.quota.orm.model.DriveMilesBasicZtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriveMilesBasicZtMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    long countByExample(DriveMilesBasicZtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int deleteByExample(DriveMilesBasicZtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int insert(DriveMilesBasicZt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int insertSelective(DriveMilesBasicZt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    List<DriveMilesBasicZt> selectByExample(DriveMilesBasicZtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    DriveMilesBasicZt selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DriveMilesBasicZt record, @Param("example") DriveMilesBasicZtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DriveMilesBasicZt record, @Param("example") DriveMilesBasicZtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DriveMilesBasicZt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drive_miles_basic_zt
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DriveMilesBasicZt record);
}