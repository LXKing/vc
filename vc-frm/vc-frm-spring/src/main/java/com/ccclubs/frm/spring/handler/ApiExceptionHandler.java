package com.ccclubs.frm.spring.handler;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.exception.ApiException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ApiExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ApiMessage<String> resolveException(HttpServletRequest request, HttpServletResponse response,
                                               Object handler, Exception ex) {
        ApiMessage<String> am = null;
        ApiException ae = null;
        if (null != ex) {
            if (ex instanceof ApiException) {
                ae = (ApiException) ex;
                am = new ApiMessage<>(ae.getCode(), ae.getMessage(), ae.getTraceId());
            } else if (ex instanceof RuntimeException) {
                String msg = ex.getMessage();
                String keywords = "dubbox:";
                if (msg != null && msg.startsWith(keywords)) {
                    String jsonContents = msg.substring(keywords.length());
                    try {
                        ObjectReader objectReader = Jackson2ObjectMapperBuilder.json().build().configure(SerializationFeature.WRAP_ROOT_VALUE, false).reader();
                        JavaType secondJavaType = objectReader.getTypeFactory().constructType(ApiMessage.class);
                        am = objectReader.forType(secondJavaType).readValue(jsonContents);
                    } catch (Exception e) {
                        logger.error("dubbox service error:", e);
                        ae = new ApiException(ApiEnum.DUBBOX_SERVICE_ERROR.code(), "Dubbox Service Error, Please contact the administrator!", ex);
                    }
                } else {
                    ae = new ApiException(ApiEnum.RUNTIME_ERROR.code(), "Runtime Error, Please contact the administrator!", ex);
                }
            }
        }
        if (null == am) {
            if (null == ae) {
                ae = new ApiException(ApiEnum.FAIL.code(), "Internal Server Error, Please contact the administrator!", ex);
            }
            am = new ApiMessage<>(ApiEnum.FAIL.code(), ae.getMsg(), ae.getTraceId());
        }
        return am;

    }
}
