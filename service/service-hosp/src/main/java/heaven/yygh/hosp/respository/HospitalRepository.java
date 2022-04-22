package heaven.yygh.hosp.respository;

import heaven.yygh.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 21:57 2022/4/8
 * @Modified By:
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

    //判断是否存在数据（按照mongo respository的命名规范写，不需要写实现）
    Hospital getHospitalByHoscode(String hoscode);

    List<Hospital> findHospitalByHosnameLike(String hosname);

}
