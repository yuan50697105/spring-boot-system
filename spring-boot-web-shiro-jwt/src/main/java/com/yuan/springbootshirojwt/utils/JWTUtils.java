package com.yuan.springbootshirojwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author yuane
 * @date 2019/7/2 20:41
 **/
public class JWTUtils {
    private static final String SECRET = UUID.randomUUID().toString();

    public static String sign(String username, String passowrd) {
        return JWT.create().withExpiresAt(DateUtils.addDays(new Date(), 10)).withClaim("username", username).sign(Algorithm.HMAC256(passowrd));
    }

    public static boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @param token
     *         the token
     *
     * @return token中包含的用户名 username
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
