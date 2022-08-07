package heaven.yygh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.order.PaymentInfo;
import heaven.yygh.model.order.RefundInfo;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 21:42 2022/4/23
 * @Modified By:
 */
public interface RefundInfoService extends IService<RefundInfo> {
    /**
     * 保存退款记录
     * @param paymentInfo
     */
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);
}

