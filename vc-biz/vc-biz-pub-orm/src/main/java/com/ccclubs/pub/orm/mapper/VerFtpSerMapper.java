package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.VerFtpSer;
import com.ccclubs.pub.orm.model.VerFtpSerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VerFtpSerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    long countByExample(VerFtpSerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int deleteByExample(VerFtpSerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int insert(VerFtpSer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int insertSelective(VerFtpSer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    List<VerFtpSer> selectByExample(VerFtpSerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    VerFtpSer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VerFtpSer record, @Param("example") VerFtpSerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VerFtpSer record, @Param("example") VerFtpSerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VerFtpSer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_ftp_ser
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VerFtpSer record);
}