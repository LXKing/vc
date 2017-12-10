package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.CsVehicleExample;
import com.ccclubs.pub.orm.vo.VehicleVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsVehicleMapper {

    /**
     * 批量插入
     *
     * @mbg.generated
     * @param record
     */
    int batchInsert(List<CsVehicle> record);

    /**
     * 根据vin和teNo查询结果
     * @param vo
     * @return
     */
    VehicleVo selectByVinAndTeNo(VehicleVo vo);

    long countByExample(CsVehicleExample example);

    int deleteByExample(CsVehicleExample example);

    int deleteByPrimaryKey(Integer csvId);

    int insert(CsVehicle record);

    int insertSelective(CsVehicle record);

    List<CsVehicle> selectByExample(CsVehicleExample example);

    CsVehicle selectByPrimaryKey(Integer csvId);

    int updateByExampleSelective(@Param("record") CsVehicle record,
        @Param("example") CsVehicleExample example);

    int updateByExample(@Param("record") CsVehicle record,
        @Param("example") CsVehicleExample example);

    int updateByPrimaryKeySelective(CsVehicle record);

    int updateByPrimaryKey(CsVehicle record);
}