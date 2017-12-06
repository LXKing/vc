package com.ccclubs.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthenticationService {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * @param jwtUser 传入的参数需要是一个继承了JwtUser的类的对象。
     * @return 返回生成成功的token。
     * */
    public String createAuthenticationToken(JwtUser jwtUser){

        final JwtUser userDetails = jwtTokenUtil.loadUserByUsername(jwtUser.getUsername());
        if (userDetails==null){
            final String token = jwtTokenUtil.generateToken(jwtUser);
            jwtUser.setToken(token);
            jwtTokenUtil.saveUserByUsername(jwtUser);
            return token;
        }
        else {
            return userDetails.getToken();
        }

    }


    /**
     * @param username 传入的参数是需要被删除的用户的用户名。
     * @return 返回成功或者失败。不存在此token或者username为空都为失败FALSE
     * */
    public boolean deleteAuthenticationToken(String username){
       return jwtTokenUtil.deleteUserByUsername(username);
    }


    /**
     * @param request 传入的参数是http的请求实例
     * @return 返回生成成功的token，失败返回空。
     * */
    public String refreshAndGetAuthenticationToken(HttpServletRequest request) {

        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user =  jwtTokenUtil.loadUserByUsername(username);
        if (null==user){return null;}
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            user.setToken(refreshedToken);
            jwtTokenUtil.saveUserByUsername(user);
            return refreshedToken;
        } else {
            return null;
        }

    }

    public JwtUser getJwtUserFromToken(HttpServletRequest request){
        try {
            if (validateToken(request)){
                String token = request.getHeader(tokenHeader);
                String username = jwtTokenUtil.getUsernameFromToken(token);
                return jwtTokenUtil.loadUserByUsername(username);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       return null;
    }

    private Boolean validateToken(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        Boolean isOk = jwtTokenUtil.validateToken(token);
        if (isOk){
            //TODO 这里可以做一个token刷新的逻辑
        }
        return isOk;
    }
}
