package com.ccclubs.hbase.mapper;

import com.ccclubs.frm.hbase.api.RowMapper;
import com.ccclubs.hbase.vo.model.TestDto;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by taosm on 2017/8/31 0031.
 */
public class TestMapper implements RowMapper<TestDto> {
    public static final byte[] COLUMNFAMILY = "f".getBytes();

    public static final byte[] DATA = "data".getBytes();

    @Override
    public TestDto mapRow(Result result, int rowNum) throws Exception {
        TestDto testDto = new TestDto();
        String data = Bytes.toString(result.getValue(COLUMNFAMILY,DATA));
        testDto.setData(data);
        return testDto;
    }
}
