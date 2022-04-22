package heaven.yygh.msm.recevier;

import com.rabbitmq.client.Channel;
import heaven.yygh.common.rabbit.constant.MqConst;
import heaven.yygh.msm.service.SendMailService;
import heaven.yygh.vo.msm.MsmVo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 17:41 2022/4/20
 * @Modified By:
 */
@Component
public class SmsReceiver {

    @Autowired
    private SendMailService sendMailService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqConst.QUEUE_MSM_ITEM, durable = "true"),
            exchange = @Exchange(value = MqConst.EXCHANGE_DIRECT_MSM),
            key = {MqConst.ROUTING_MSM_ITEM}
    ))
    public void send(MsmVo msmVo, Channel channel, Message message) {
        sendMailService.send(msmVo);
    }
}

