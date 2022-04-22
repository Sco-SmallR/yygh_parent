package heaven.yygh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.order.OrderInfo;
import org.springframework.stereotype.Service;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:29 2022/4/20
 * @Modified By:
 */
public interface OrderService extends IService<OrderInfo> {
    //保存订单
    Long saveOrder(String scheduleId, Long patientId);
}

