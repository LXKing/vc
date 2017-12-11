package com.ccclubs.admin.util.jwt;

import com.ccclubs.admin.constants.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 ****************************
 * 版权所有：车厘子 所有权利
 * 创建日期: 2017-9-11
 * 创建作者：zkm
 * 类名称　：JwtHelper.java
 * 版　　本：
 * 功　　能：
 * 最后修改：
 * 修改记录：
 *****************************
 */
public class JwtHelper
{
    
    /**
     * 解析JWT
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security)
    {
        try
        {
            Claims claims = Jwts
                    .parser()
                    .setSigningKey(
                            DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    /**
     * 解析JWT拿取username
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static String getUserNameByJWT(String jsonWebToken, String base64Security)
    {
        String username = null;
        try
        {
            Claims claims = parseJWT(jsonWebToken, base64Security);
            username = (String) claims.get("username");
        }
        catch (Exception ex)
        {
            return null;
        }
        return username;
    }
    /**
     * 创建JWT秘钥
     * @param userId 会员ID
     * @param issuer 请求者ID
     * @param base64Security 签名
     * @return
     */
    public static String createJWT(String userId, String issuer,
            String base64Security,String username)
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter
                .parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,
                signatureAlgorithm.getJcaName());

        // 添加构成JWT的参数
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam(Constants.HEADER_TYPE, Constants.HEADER_JWT)
                .claim(Constants.JWT_USERID, userId)
                .claim("username", username)
                .setIssuer(issuer).setAudience(Constants.AUTH_WRITE)
                .signWith(signatureAlgorithm, signingKey);
        
        // 添加Token过期时间
        if (Constants.ROLE_ADMIN.equals(issuer))
        {
            long expMillis = nowMillis + Constants.ADMIN_TIME;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        // 生成JWT
        return builder.compact();
    } 
    
    public static void main(String[] args)
    {   
        long nowMillis = System.currentTimeMillis();
        
        Date now = new Date(nowMillis+10000);

//        String token = createJWT(1000L,null);
        System.out.println(now);
//        Claims claims = parseJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZW1iZXJpZCI6MTAwMH0.66LJeQgfV09fUpTeoFPNaY2a_8x5YxhmsbdgSYjL3zg","tp2bae3cd994f90718d5") ;
//        != null)
//        {
            System.out.println(1);
//            }else{
//                System.out.println(2);
//            }

    }
}
