package com.ccclubs.hbase.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.hbase.inf.HbaseTestInf;
import com.ccclubs.hbase.vo.input.TestInput;
import com.ccclubs.hbase.vo.model.TestDto;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by taosm on 2017/8/30 0030.
 */
@RefreshScope
@RestController
public class HbaseTestApi {
    @Reference(version="1.0.0")
    private HbaseTestInf hbaseTestInf;


    @ApiOperation(value="测试方法", notes="执行测试方法")
    @RequestMapping(path="/hbase/v2", method={RequestMethod.POST, RequestMethod.GET})
    void hbaseTest() throws Exception {
        hbaseTestInf.testScan();
    }

    @ApiOperation(value="测试实体", notes="获取测试实体列表")
    @RequestMapping(path="/hbase/v2/getTestDtoList", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<List<TestDto>> getTestDtoList(TestInput testInput) throws Exception {
        List<TestDto> testDtoList = hbaseTestInf.getTestDtoList(testInput);
        return new ApiMessage<List<TestDto>>(testDtoList);
    }

    @ApiOperation(value="测试实体", notes="获取测试实体列表")
    @RequestMapping(path="/hbase/v2/getTestDtoListByPrePage", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<List<TestDto>> getTestDtoListByPrePage(TestInput testInput) throws Exception {
        List<TestDto> testDtoList = hbaseTestInf.getTestDtoListByPrePage(testInput);
        return new ApiMessage<List<TestDto>>(testDtoList);
    }
}
