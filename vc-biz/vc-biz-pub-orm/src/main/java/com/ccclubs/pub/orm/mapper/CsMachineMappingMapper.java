package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.CsMachineMapping;
import com.ccclubs.pub.orm.model.CsMachineMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsMachineMappingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    long countByExample(CsMachineMappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int deleteByExample(CsMachineMappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer csId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int insert(CsMachineMapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int insertSelective(CsMachineMapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    List<CsMachineMapping> selectByExample(CsMachineMappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    CsMachineMapping selectByPrimaryKey(Integer csId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsMachineMapping record, @Param("example") CsMachineMappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsMachineMapping record, @Param("example") CsMachineMappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CsMachineMapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_machine_mapping
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CsMachineMapping record);
}