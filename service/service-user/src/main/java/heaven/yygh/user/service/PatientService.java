package heaven.yygh.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.user.Patient;

import java.util.List;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 12:06 2022/4/18
 * @Modified By:
 */
public interface PatientService extends IService<Patient> {
    //获取就诊人列表
    List<Patient> findAllUserId(Long userId);
    //根据id获取就诊人信息
    Patient getPatientId(Long id);
}
