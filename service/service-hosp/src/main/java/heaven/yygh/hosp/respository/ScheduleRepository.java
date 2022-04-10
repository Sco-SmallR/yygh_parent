package heaven.yygh.hosp.respository;

import heaven.yygh.model.hosp.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:07 2022/4/10
 * @Modified By:
 */
@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    Schedule getScheduleByHoscodeAndHosScheduleId(String hoscode, String hosScheduleId);
}
