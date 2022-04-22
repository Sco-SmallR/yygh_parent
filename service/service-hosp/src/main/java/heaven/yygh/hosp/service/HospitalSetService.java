package heaven.yygh.hosp.service;


import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.hosp.Hospital;
import heaven.yygh.model.hosp.HospitalSet;
import heaven.yygh.vo.order.SignInfoVo;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 22:37 2022/3/29
 * @Modified By:
 */
public interface HospitalSetService extends IService<HospitalSet> {
    //2、根据传递过来的医院编码，查询数据库，查询签名
    String getSignKey(String hoscode);

    //获取医院签名信息
    SignInfoVo getSignInfoVo(String hoscode);


}
