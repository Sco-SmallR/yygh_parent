package heaven.yygh.hosp.respository;

import heaven.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 21:11 2022/4/9
 * @Modified By:
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {

    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}
