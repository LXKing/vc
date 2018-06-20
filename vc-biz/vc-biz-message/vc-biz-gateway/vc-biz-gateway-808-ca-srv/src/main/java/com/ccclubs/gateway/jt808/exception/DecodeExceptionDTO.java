package com.ccclubs.gateway.jt808.exception;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.gateway.common.inf.IExceptionDtoJsonParse;
import com.ccclubs.gateway.jt808.constant.PackagePart;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 21:29
 * Email:  yeanzhi@ccclubs.com
 * 包装解析异常信息
 */
public class DecodeExceptionDTO implements IExceptionDtoJsonParse {

    private static final String EXCEPTION_DECRIPTION_PRIFIX= "解析数据包时出现异常: ";

    // vin码
    private String uniqueNo;

    // 记录当前解析的位置
    private int decodeMarkIndex;

    // 异常值
    private String exceptionVal;

    // 期望值
    private String expectedVal;

    // 异常原因
    private String reason;

    // 16进制源数据包
    private String source;

    @Override
    public String toJson() {
        JSONObject json = new JSONObject();
        json.put("decodeMarkIndex", decodeMarkIndex);
        json.put("exceptionVal", exceptionVal);
        json.put("expectedVal", expectedVal);
        json.put("reason", reason);
        return json.toJSONString();
    }

    public DecodeExceptionDTO(String source) {
        this.source = source;
    }

    public DecodeExceptionDTO next() {
        ++ this.decodeMarkIndex;
        return this;
    }

    public DecodeExceptionDTO fail() {
        return this;
    }

    public String toLogString() {
        StringBuilder desSb = new StringBuilder(EXCEPTION_DECRIPTION_PRIFIX);
        PackagePart packagePart = PackagePart.getByCode(decodeMarkIndex);
        if (StringUtils.isNotEmpty(uniqueNo)) {
            desSb.append("车辆[").append(uniqueNo).append("]");
        }
        desSb
                .append("位置[").append(packagePart.getDes()).append("]")
                .append("异常值[").append(exceptionVal).append("]");
        if (StringUtils.isNotEmpty(expectedVal)) {
            desSb.append("期望值[").append(expectedVal).append("]");
        }
        if (StringUtils.isNotEmpty(reason)) {
            desSb.append("异常原因[").append(reason).append("]");
        }

        desSb.append("原始消息[").append(source).append("]");
        return desSb.toString();
    }

    // -------------------------------------------------------

    public int getDecodeMarkIndex() {
        return decodeMarkIndex;
    }

    public DecodeExceptionDTO setDecodeMarkIndex(int decodeMarkIndex) {
        this.decodeMarkIndex = decodeMarkIndex;
        return this;
    }

    public String getExceptionVal() {
        return exceptionVal;
    }

    public DecodeExceptionDTO setExceptionVal(String exceptionVal) {
        this.exceptionVal = exceptionVal;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public DecodeExceptionDTO setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getSource() {
        return source;
    }

    public DecodeExceptionDTO setSource(String source) {
        this.source = source;
        return this;
    }

    public String getExpectedVal() {
        return expectedVal;
    }

    public DecodeExceptionDTO setExpectedVal(String expectedVal) {
        this.expectedVal = expectedVal;
        return this;
    }

    public String getUniqueNo() {
        return uniqueNo;
    }

    public DecodeExceptionDTO setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
        return this;
    }
}
