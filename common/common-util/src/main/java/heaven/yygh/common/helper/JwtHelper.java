package heaven.yygh.common.helper;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 14:16 2022/4/15
 * @Modified By:
 */
public class JwtHelper {

    // token过期时间设置
    private static long tokenExpiration = 24 * 60 * 60 * 1000;
    // 签名秘钥
    private static String tokenSignKey = "123456";

    // 根据参数生成token
    public static String createToken(Long userId, String userName) {
        String token = Jwts.builder()
                .setSubject("YYGH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))// 当前时间+过期时间为到期时间
                .claim("userId", userId)
                .claim("userName", userName)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)// 签名hash
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    // 根据token字符串得到用户id
    public static Long getUserId(String token) {
        if (StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");
        return userId.longValue();
    }

    // 根据token字符串得到用户名称
    public static String getUserName(String token) {
        if (StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws
                = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("userName");
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken(1L, "lucy");
        System.out.println(token);
        System.out.println(JwtHelper.getUserId(token));
        System.out.println(JwtHelper.getUserName(token));
    }
}
