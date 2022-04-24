package heaven.yygh.order.service;

import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 16:03 2022/4/23
 * @Modified By:
 */
public interface WeixinService {
    /**
     * 根据订单号下单，生成支付链接
     */
    Map createNative(Long orderId);

    Map<String, String> queryPayStatus(Long orderId, String name);

    /***
     * 退款
     * @param orderId
     * @return
     */
    Boolean refund(Long orderId);

}

