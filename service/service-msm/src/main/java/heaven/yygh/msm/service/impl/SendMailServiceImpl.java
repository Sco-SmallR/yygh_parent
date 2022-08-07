package heaven.yygh.msm.service.impl;

import com.alibaba.fastjson.JSONObject;
import heaven.yygh.msm.service.SendMailService;
import heaven.yygh.vo.msm.MsmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 11:41 2022/4/16
 * @Modified By:
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    //获取邮件发送类
    @Autowired
    JavaMailSender javaMailSender;

    //异步请求
    @Async
    public boolean sendMail(String emailAddress, String code) {

        //判断邮箱是否为空
        if (StringUtils.isEmpty(emailAddress)) {
            return false;
        }
        //初始化邮件信息类
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("验证码测试");
        simpleMailMessage.setFrom("2276701333@qq.com");//输入你的QQ邮箱
        simpleMailMessage.setTo(emailAddress);

        //验证码  使用json格式   {"code":"123456"}
        Map<String, Object> param = new HashMap();
        param.put("code", code);

        //将验证码存放进邮箱
        simpleMailMessage.setText("这是你的验证码" + JSONObject.toJSONString(param));// 用工具转成json

        //调用方法进行短信发送
        javaMailSender.send(simpleMailMessage);
        System.out.println(simpleMailMessage);
        return true;
    }

    //异步请求
    @Async
    public boolean sendMail(String emailAddress, Map<String, Object> param) {

        //判断邮箱是否为空
        if (StringUtils.isEmpty(emailAddress)) {
            return false;
        }
        //初始化邮件信息类
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("验证码测试");
        simpleMailMessage.setFrom("2276701333@qq.com");//输入你的QQ邮箱
        simpleMailMessage.setTo(emailAddress);

        //验证码  使用json格式   {"code":"123456"}
        //将验证码存放进邮箱
        simpleMailMessage.setText("这是你的验证码" + JSONObject.toJSONString(param));// 用工具转成json

        //调用方法进行短信发送
        javaMailSender.send(simpleMailMessage);
        System.out.println(simpleMailMessage);
        return true;
    }

    @Override
    public boolean send(MsmVo msmVo) {
        if (!StringUtils.isEmpty(msmVo.getPhone())) {
            return this.sendMail(msmVo.getPhone(), msmVo.getParam());
        }
        return false;
    }
}
