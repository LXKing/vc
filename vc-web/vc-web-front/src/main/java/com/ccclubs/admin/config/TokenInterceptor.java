package com.ccclubs.admin.config;

import com.ccclubs.admin.util.UserAccessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor  implements HandlerInterceptor {

    @Autowired
    UserAccessUtils userAccessUtils;//FIXME 无法注入，为null
    /**
    * 在请求处理之前进行调用（Controller方法调用之前）
    * 返回true才会继续执行
    **/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies=httpServletRequest.getCookies();
        if (cookies.length<=0){
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
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
