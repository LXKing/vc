package com.ccclubs.admin.controller.base;

import com.ccclubs.admin.dto.CarStatisticsDto;
import com.ccclubs.admin.service.ICsCanService;
import com.ccclubs.admin.vo.VoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/9/18
 * 首页
 *
 * @author machuanpeng
 */
@RestController
@RequestMapping("/index")
public class CsIndexxController {
    @Autowired
    ICsCanService canService;

    /**
     * 2018/9/18
     * 车辆统计
     *
     * @param
     * @return com.ccclubs.admin.vo.TableResult<>
     * @author machuanpeng
     */
    @RequestMapping(value = "/car/statistics", method = RequestMethod.GET)
    public VoResult<CarStatisticsDto> list() {
        int allCar = canService.getCarCount(null);
        int onlineCar = canService.getCarCount(1);
        int offLine = allCar - onlineCar;
        CarStatisticsDto statisticsDto = new CarStatisticsDto(allCar, onlineCar, offLine);
        VoResult<CarStatisticsDto> result = new VoResult<>();
        result.setSuccess(true);
        result.setValue(statisticsDto);
        return result;
    }
}
