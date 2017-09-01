package com.ccclubs.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.common.validate.ValidateService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 数据权限切面处理
 *
 * @author jianghaiyang
 * @create 2017-07-17
 **/
@Component
@Aspect
public class DataAuthAspect {
    /**
     * 校验切入点
     */
    @Resource
    private ValidateService service;

    @Pointcut("@annotation(com.ccclubs.common.aop.DataAuth)")
    public void validate() {
    }

    /**
     * 数据权限校验
     *
     * @param joinPoint 连接点
     * @return 方法执行结果
     * @throws Throwable 调用出错
     */
    @Around("validate()")
    public Object start(ProceedingJoinPoint joinPoint) throws Throwable {

        /**
         * 解析注解
         */
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名
        DataAuth auth = method.getAnnotation(DataAuth.class);

        /**
         * 解析请求
         */
        Object[] args = joinPoint.getArgs();
        JSONObject params;
        if (args != null && args.length == 1) {
            params = JSON.parseObject(JSONObject.toJSONString(args[0]));
        }else{
            throw new ApiException(ApiEnum.REQUEST_PARAMS_VALID_FAILED);
        }

        String appId = (String) params.get("appId");
        String vin = (String) params.get("vin");
        String teNo = (String) params.get("teNo");

        /**
         * 权限校验
         */
        if (auth != null) {
            boolean validateResult = this.service.validateAuth(appId, vin, teNo);
            if (!validateResult) {
                throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
            }
        }

        /**
         * 方法执行
         */
        Object obj = joinPoint.proceed();

        return obj;
    }

}
