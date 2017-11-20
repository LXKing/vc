package com.ccclubs.frm.spring.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.usr.dto.ApiLogInput;
import com.ccclubs.usr.dto.ApiLogOutput;
import com.ccclubs.usr.inf.ApiLogInf;
import com.ccclubs.usr.version.UserServiceVersion;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * Api调用日志
 *
 * @author jianghaiyang
 * @create 2017-08-28
 **/
@Aspect
@Component
public class ApiInvokeHandler {

    private static Logger logger = LoggerFactory.getLogger(ApiInvokeHandler.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<>();
    private ThreadLocal<Long> logId = new ThreadLocal<>();

    @Reference(version = UserServiceVersion.V1)
    ApiLogInf apiLogInf;

    @Pointcut("@annotation(com.ccclubs.frm.spring.annotation.ApiSecurity)")
    public void apiLog() {
    }

    @Before("apiLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.debug("New api request handled.");
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 初始化日志
//        ApiLogInput input = new ApiLogInput();
//        input.setInTime(new Date());
//        input.setAppId(request.getHeader("appId"));
//        input.setUrl(request.getRequestURL().toString());
//        input.setHttpMethod(request.getMethod());
//        input.setIp(request.getRemoteAddr());
//        input.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        input.setInput(JSONObject.toJSONString(joinPoint.getArgs()));
//
//        // 保存日志
//        ApiLogOutput output = apiLogInf.saveLog(input);
//        // 记录日志ID
//        logId.set(output.getLogId());

    }

    @AfterReturning(returning = "ret", pointcut = "apiLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 更新日志
//        ApiLogInput input = new ApiLogInput();
//        input.setElapsed(System.currentTimeMillis()-startTime.get());
//        input.setOutTime(new Date());
//        input.setLogId(logId.get());
//        input.setOutput(JSONObject.toJSONString(ret));
//        apiLogInf.updateLog(input);
    }

}
