package heaven.yygh.common.utils;

import heaven.yygh.common.helper.JwtHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 21:48 2022/4/17
 * @Modified By:
 */
//获取当前用户信息工具类
public class AuthContextHolder {
    //获取当前用户id
    public static Long getUserId(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取userid
        Long userId = JwtHelper.getUserId(token);
        return userId;
    }
    //获取当前用户名称
    public static String getUserName(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取userid
        String userName = JwtHelper.getUserName(token);
        return userName;
    }
}
