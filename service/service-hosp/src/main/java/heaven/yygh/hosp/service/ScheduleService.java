package heaven.yygh.hosp.service;

import heaven.yygh.model.hosp.Schedule;
import heaven.yygh.vo.hosp.ScheduleQueryVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:13 2022/4/10
 * @Modified By:
 */

public interface ScheduleService {
    Page<Schedule> selectPage(int page, int limit, ScheduleQueryVo scheduleQueryVo);

    void save(Map<String, Object> paramMap);

    void remove(String hoscode, String hosScheduleId);
}
