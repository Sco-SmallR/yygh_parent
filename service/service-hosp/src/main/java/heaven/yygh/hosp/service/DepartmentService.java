package heaven.yygh.hosp.service;


import heaven.yygh.model.hosp.Department;
import heaven.yygh.vo.hosp.DepartmentQueryVo;
import heaven.yygh.vo.hosp.DepartmentVo;
import org.springframework.data.domain.Page;

import java.util.List;
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

    List<DepartmentVo> findDeptTree(String hoscode);

    String getDepName(String hoscode, String depcode);

    Department getDepartment(String hoscode, String depcode);

}
