package com.wingchi.user.util;

import com.wingchi.user.bean.User;
import io.jsonwebtoken.*;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;


public class JwtUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(JwtUtil.class) ;
    private static final String SECRET = "my_secret" ;  // 密钥
    private static final Long EXPIRATION = 1800L ; //过期时间1800秒

    private static Date createExpirationDate(){
        return new Date(System.currentTimeMillis()+EXPIRATION*1000);
    }
    public static String createJWT(String userName,String userId) {
        return Jwts.builder()
                .setSubject(userName)
                .setId(userId)
                .claim("user_id", userId)
                .claim("userName",userName)
                .setExpiration(createExpirationDate())
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact() ;
    }
    public static Claims getClaims(String Token) {
        Claims claims;
        try{
            claims = Jwts.parser().
                setSigningKey(SECRET).parseClaimsJws(Token.trim()).getBody();
        }catch (ExpiredJwtException e) {
            LOGGER.error("JWT过期：", e);
            throw new RuntimeException("JWT过期");
        }catch (UnsupportedJwtException e) {
            LOGGER.error("不支持的JWT：", e);
            throw new RuntimeException("不支持的JWT");
        } catch (Exception e ){
            LOGGER.error("JWT格式验证失败:{}",Token); ;
            throw new RuntimeException("JWT格式验证失败!") ;
        }
        return claims ;
    }



    /**
     *
     * @param token
     * @return  true：过期 , false ：没过期
     */
    public  static boolean isTokenExpired(String token){
        Claims claims = getClaims(token) ;
        Date expiredDate = claims.getExpiration();

        return expiredDate.before(new Date());
    }
}
