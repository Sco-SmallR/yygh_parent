package heaven.yygh.hosp.service;


import heaven.yygh.model.hosp.Department;
import heaven.yygh.vo.hosp.DepartmentQueryVo;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 21:17 2022/4/9
 * @Modified By:
 */
public interface DepartmentService {
    void save(Map<String, Object> paramMap);

    Page<Department> selectPage(int page, int limit, DepartmentQueryVo departmentQueryVo);

    void remove(String hoscode, String depcode);

}
