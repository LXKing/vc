package com.ccclubs.hbase.inf.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.hbase.api.HbaseTemplate;
import com.ccclubs.hbase.inf.HbaseTestInf;
import com.ccclubs.hbase.mapper.TestMapper;
import com.ccclubs.hbase.vo.input.TestInput;
import com.ccclubs.hbase.vo.model.TestDto;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
@Service(version = "1.0.0")
public class HbaseTestImpl implements HbaseTestInf {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Override
    public void testScan()  {
//        String startRow="0001";
//        String stopRow = "0011";
//        Scan scan = new Scan(Bytes.toBytes(startRow),Bytes.toBytes(stopRow));
//        scan.setCaching(500);
//        List<TestDto> testDtoList = this.hbaseTemplate.find("testtable",scan,new TestMapper());
        Put put1 = new Put(Bytes.toBytes("1002"));
        put1.addColumn(TestMapper.COLUMNFAMILY,TestMapper.DATA,Bytes.toBytes("data-1002"));
        this.hbaseTemplate.saveOrUpdate("testtable",put1);

        System.out.println();
    }

    @Override
    public List<TestDto> getTestDtoList(TestInput testInput) {
        String startRow = testInput.getStartRowKey();
        String stopRow = testInput.getStopRowKey();
        Scan scan = new Scan(Bytes.toBytes(startRow),Bytes.toBytes(stopRow));
        List<TestDto> testDtoList = this.hbaseTemplate.find("testtable",scan,new TestMapper());
        return testDtoList;
    }

    @Override
    public List<TestDto> getTestDtoListByPrePage(TestInput testInput) {
        String page_first_rowkey = testInput.getPage_first_rowkey();
        List<TestDto> testDtoList = this.hbaseTemplate.findByPrevPage("testtable",new TestMapper(),page_first_rowkey,20);
        return testDtoList;
    }
}
