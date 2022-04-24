package heaven.yygh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.order.OrderInfo;
import heaven.yygh.model.order.PaymentInfo;

import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 16:05 2022/4/23
 * @Modified By:
 */
public interface PaymentService extends IService<PaymentInfo> {
    /**
     * 保存交易记录
     * @param order
     * @param paymentType 支付类型（1：微信 2：支付宝）
     */
    void savePaymentInfo(OrderInfo order, Integer paymentType);

    void paySuccess(String out_trade_no, Integer status, Map<String, String> resultMap);

    /**
     * 获取支付记录
     * @param orderId
     * @param paymentType
     * @return
     */
    PaymentInfo getPaymentInfo(Long orderId, Integer paymentType);

}
