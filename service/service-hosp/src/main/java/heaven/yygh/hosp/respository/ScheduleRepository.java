package heaven.yygh.hosp.respository;

import heaven.yygh.model.hosp.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:07 2022/4/10
 * @Modified By:
 */
@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    Schedule getScheduleByHoscodeAndHosScheduleId(String hoscode, String hosScheduleId);

    //根据医院编号 、科室编号和工作日期，查询排班详细信息
    List<Schedule> findScheduleByHoscodeAndDepcodeAndWorkDate(String hoscode, String depcode, Date toDate);

    Schedule getScheduleById(String scheduleId);

}
