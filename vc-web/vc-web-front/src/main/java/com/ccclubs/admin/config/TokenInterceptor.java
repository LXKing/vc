package com.ccclubs.admin.config;

import com.ccclubs.admin.util.ResponseJsonUtils;
import com.ccclubs.admin.util.UserAccessUtils;
import com.ccclubs.admin.vo.ResultCode;
import com.ccclubs.admin.vo.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class TokenInterceptor  implements HandlerInterceptor {

    Logger logger= LoggerFactory.getLogger(TokenInterceptor.class);

    @Autowired
    UserAccessUtils userAccessUtils;
    /**
    * 在请求处理之前进行调用（Controller方法调用之前）
    * 返回true才会继续执行
    **/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies=httpServletRequest.getCookies();
        if (null==cookies||cookies.length<=0){
            logger.info("a request not have any cookies.");
            ResultMsg resultMsg=new ResultMsg<>(false,
                    ResultCode.INVALID_TOKEN, null);
            ResponseJsonUtils.json(httpServletResponse,resultMsg);
            return false;
        }
        String token;
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                token=cookie.getValue();

                if (null!=userAccessUtils.getCurrentUser(token)){
                    return true;
                }
            }
        }
        logger.info("a request do not have right token string.");
        ResultMsg resultMsg=new ResultMsg<>(false,
                ResultCode.INVALID_TOKEN, null);
        ResponseJsonUtils.json(httpServletResponse,resultMsg);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
