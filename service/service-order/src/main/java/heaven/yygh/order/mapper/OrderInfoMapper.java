package heaven.yygh.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import heaven.yygh.model.order.OrderInfo;
import heaven.yygh.vo.order.OrderCountQueryVo;
import heaven.yygh.vo.order.OrderCountVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:31 2022/4/20
 * @Modified By:
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    //查询预约统计数据的方法
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);
}
