package heaven.yygh.hosp.service;

import heaven.yygh.model.hosp.Hospital;
import heaven.yygh.vo.hosp.HospitalQueryVo;
import org.springframework.data.domain.Page;

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
    Hospital getByHoscode(String hoscode);

    /**
     * 分页查询
     * @param page 当前页码
     * @param limit 每页记录数
     * @param hospitalQueryVo 查询条件
     * @return
     */
    Page<Hospital> selectPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);

    void updateStatus(String id, Integer status);

    Object show(String id);

    String getHospName(String hoscode);

    Object findByHosname(String hosname);

    Object item(String hoscode);

}
