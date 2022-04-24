package heaven.yygh.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.order.OrderInfo;
import heaven.yygh.vo.order.OrderCountQueryVo;
import heaven.yygh.vo.order.OrderQueryVo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:29 2022/4/20
 * @Modified By:
 */
public interface OrderService extends IService<OrderInfo> {
    //保存订单
    Long saveOrder(String scheduleId, Long patientId);

    // 根据订单id查询订单详情
    OrderInfo getOrder(String orderId);

    /**
     * 分页列表
     */
    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);
    /**
     * 取消订单
     * @param orderId
     */
    Boolean cancelOrder(Long orderId);


    void patientTips();
    /**
     * 订单统计
     */
    Map<String, Object> getCountMap(OrderCountQueryVo orderCountQueryVo);

}

