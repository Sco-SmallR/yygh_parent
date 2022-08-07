package heaven.yygh.msm.controller;

import heaven.yygh.common.result.Result;
import heaven.yygh.msm.service.SendMailService;
import heaven.yygh.msm.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: SmallRong
 * @Description:邮箱验证码接口
 * @Date: Created in 11:39 2022/4/16
 * @Modified By:
 */
@RestController
@RequestMapping("/api/msm/email")
public class MyController {

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("send/{email}")
    public Result sendMail(@PathVariable String email) {
        //从redis获取验证码，如果获取获取到，返回ok
        // key 收件人地址  value 验证码
        String code = redisTemplate.opsForValue().get(email);
        if (!StringUtils.isEmpty(code)) {
            return Result.ok();
        }

        //如果从redis获取不到，
        // 生成验证码，
        code = RandomUtil.getSixBitRandom();
        //调用service方法，通过整合验证码服务进行发送
        boolean isSend = sendMailService.sendMail(email, code);
        //生成验证码放到redis里面，设置有效时间
        if (isSend) {
            redisTemplate.opsForValue().set(email, code, 2, TimeUnit.MINUTES);
            return Result.ok();
        } else {
            return Result.fail().message("发送验证码失败");
        }
    }
}
