package heaven.yygh.hosp.service;

import heaven.yygh.model.hosp.Hospital;

import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 22:01 2022/4/8
 * @Modified By:
 */
public interface HospitalService {

    void save(Map<String, Object> paramMap);
    // 根据医院编号查询
    Hospital getByHoscde(String hoscode);
}
