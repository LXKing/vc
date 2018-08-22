package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.TBoxLogParam;
import com.ccclubs.phoenix.orm.dto.TBoxLogDto;
import com.ccclubs.phoenix.output.TBoxLogOutput;
import java.util.List;

/**
 * @Author: GFA
 * @Project: vc
 * @Package: com.ccclubs.phoenix.inf
 * @Date: 2018/08/20  15:46
 * @Description:
 */
public interface TBoxLogInf {

    //查询车辆状态信息（带车架 VIN码、车机号 是否绑定的信息）
    List<TBoxLogDto> queryTBoxDtoList(TBoxLogParam param, Boolean idBound);

    //查询车辆状态信息记录总数（带车架 VIN码、车机号 是否绑定的信息）
    Long queryListCount(TBoxLogParam param, Boolean idBound);

    //查询车辆状态信息(封装)（带车架 VIN码、车机号 是否绑定的信息）
    TBoxLogOutput queryListByParam(TBoxLogParam param, Boolean idBound);
}
