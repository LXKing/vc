package com.ccclubs.hbase.inf;

import com.ccclubs.hbase.vo.input.TestInput;
import com.ccclubs.hbase.vo.model.TestDto;

import java.util.List;

/**
 * Created by taosm on 2017/8/30 0030.
 */
public interface HbaseTestInf {
    void testScan();
    //返回测试数据列表
    List<TestDto> getTestDtoList(TestInput testInput);

    //返回上一页测试数据列表
    List<TestDto> getTestDtoListByPrePage(TestInput testInput);
}
