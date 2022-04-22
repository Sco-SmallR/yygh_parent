package heaven.yygh.msm.service;

import heaven.yygh.vo.msm.MsmVo;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 11:40 2022/4/16
 * @Modified By:
 */
public interface SendMailService {

    boolean sendMail(String email, String code);

    //发送短信封装
    boolean send(MsmVo msmVo);

}
