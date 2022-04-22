package heaven.yygh.hosp.service;

import heaven.yygh.model.hosp.Schedule;
import heaven.yygh.vo.hosp.ScheduleOrderVo;
import heaven.yygh.vo.hosp.ScheduleQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
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

    //根据医院编号 科室编号，查询排版规则数据
    Map<String, Object> getRuleSchedule(long page, long limit, String hoscode, String depcode);

    // 根据医院编号、科室编号和工作日期。查询排班详细信息
    List<Schedule> getDetailSchedule(String hoscode, String depcode, String workDate);

    // 获取可预约的排班数据
    Map<String,Object> getBookingScheduleRule(Integer page, Integer limit, String hoscode, String depcode);

    Schedule getById(String scheduleId);

    //根据排班id获取预约下单数据
    ScheduleOrderVo getScheduleOrderVo(String scheduleId);

    // 更新排班数据
    void update(Schedule schedule);

}
