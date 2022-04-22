package heaven.yygh.msm.service;

import heaven.yygh.vo.msm.MsmVo;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:13 2022/4/16
 * @Modified By:
 */
public interface MsmService {

    //发送手机验证码
    boolean send(String phone, String code);
    //发送短信封装
    boolean send(MsmVo msmVo);
}
