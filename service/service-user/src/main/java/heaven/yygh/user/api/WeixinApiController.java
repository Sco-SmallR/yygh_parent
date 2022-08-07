package heaven.yygh.user.api;

import com.alibaba.fastjson.JSONObject;
import heaven.yygh.common.exception.YyghException;
import heaven.yygh.common.helper.JwtHelper;
import heaven.yygh.common.result.Result;
import heaven.yygh.common.result.ResultCodeEnum;
import heaven.yygh.model.user.UserInfo;
import heaven.yygh.user.service.UserInfoService;
import heaven.yygh.user.utils.ConstantWxPropertiesUtil;
import heaven.yygh.user.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:02 2022/4/17
 * @Modified By:
 */
@Controller // restcontroller支持返回数据，controller支持页面跳转
@RequestMapping("/api/ucenter/wx")
public class WeixinApiController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

    // 微信扫描后回调的方法
    @GetMapping("callback")
    public String callback(String code, String state) throws UnsupportedEncodingException {


        //第一步 获取票据code
        System.out.println("code" + code);


        //第二步 拿到code和微信id和秘钥，请求微信固定地址，得到两个值
        //使用code和appid以及appscrect换取access_token
        // % 占位符
        StringBuffer baseAccessTokenUrl = new StringBuffer()
                .append("https://api.weixin.qq.com/sns/oauth2/access_token")
                .append("?appid=%s")
                .append("&secret=%s")
                .append("&code=%s")
                .append("&grant_type=authorization_code");

        String accessTokenUrl = String.format(baseAccessTokenUrl.toString(),
                ConstantWxPropertiesUtil.WX_OPEN_APP_ID,
                ConstantWxPropertiesUtil.WX_OPEN_APP_SECRET,
                code);


        //使用httpclient请求这个地址
        String result = null;
        try {
            result = HttpClientUtils.get(accessTokenUrl);
        } catch (Exception e) {
            throw new YyghException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
        }

        System.out.println("使用code换取的access_token结果 = " + result);
        // 从返回的字符串获取两个值 openid 和 access_tocken
        JSONObject resultJson = JSONObject.parseObject(result);
        String accessToken = resultJson.getString("access_token");
        String openId = resultJson.getString("openid");


        // 根据openid判断
        UserInfo userInfo = userInfoService.selectWxInfoOpenId(openId);
        if (userInfo == null) {
            //根据access_token获取微信用户的基本信息
            //先根据openid进行数据库查询
            // UserInfo userInfo = userInfoService.getByOpenid(openId);
            // 如果没有查到用户信息,那么调用微信个人信息获取的接口
            // if(null == userInfo){
            //如果查询到个人信息，那么直接进行登录
            //使用access_token换取受保护的资源：微信的个人信息
            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                    "?access_token=%s" +
                    "&openid=%s";
            String userInfoUrl = String.format(baseUserInfoUrl, accessToken, openId);
            String resultUserInfo = null;
            try {
                resultUserInfo = HttpClientUtils.get(userInfoUrl);
            } catch (Exception e) {
                throw new YyghException(ResultCodeEnum.FETCH_USERINFO_ERROR);
            }
            System.out.println("使用access_token获取用户信息的结果 = " + resultUserInfo);
            JSONObject resultUserInfoJson = JSONObject.parseObject(resultUserInfo);

            //解析用户信息
            String nickname = resultUserInfoJson.getString("nickname");// 昵称
            String headimgurl = resultUserInfoJson.getString("headimgurl");// 头像


            //获取扫码人信息添加数据库
            userInfo = new UserInfo();
            userInfo.setOpenid(openId);
            userInfo.setNickName(nickname);
            userInfo.setStatus(1);
            userInfoService.save(userInfo);
        }


        // 返回name和token字符串
        Map<String, String> map = new HashMap<>();
        String name = userInfo.getName();
        if (StringUtils.isEmpty(name)) {
            name = userInfo.getNickName();
        }
        if (StringUtils.isEmpty(name)) {
            name = userInfo.getPhone();
        }
        // 判断userinfo是否有手机号，如果手机号为空，返回openid
        // 如果手机号不为空，返回openid值是空字符串
        // 前端判断：如果openid不为空，绑定手机号，如果openid为空 ，不需要绑定手机号
        map.put("name", name);
        if (StringUtils.isEmpty(userInfo.getPhone())) {
            map.put("openid", userInfo.getOpenid());
        } else {
            map.put("openid", "");
        }
        // 使用jwt生成token
        String token = JwtHelper.createToken(userInfo.getId(), name);
        map.put("token", token);
        // 跳转前端页面
        return "redirect:" + ConstantWxPropertiesUtil.YYGH_BASE_URL + "/weixin/callback?token=" + map.get("token") + "&openid=" + map.get("openid") + "&name=" + URLEncoder.encode(map.get("name"),"utf-8");

    }

    /**
     * 获取微信登录参数
     */
    @GetMapping("getLoginParam")
    @ResponseBody
    public Result genQrConnect(HttpSession session) throws UnsupportedEncodingException {
        String redirectUri = URLEncoder.encode(ConstantWxPropertiesUtil.WX_OPEN_REDIRECT_URL, "UTF-8");
        Map<String, Object> map = new HashMap<>();
        map.put("appid", ConstantWxPropertiesUtil.WX_OPEN_APP_ID);
        map.put("redirectUri", redirectUri);
        map.put("scope", "snsapi_login");
        map.put("state", System.currentTimeMillis() + "");//System.currentTimeMillis()+""
        return Result.ok(map);
    }


}

