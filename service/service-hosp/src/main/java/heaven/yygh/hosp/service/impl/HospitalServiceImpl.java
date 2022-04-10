package heaven.yygh.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import heaven.yygh.hosp.respository.HospitalRepository;
import heaven.yygh.hosp.service.HospitalService;
import heaven.yygh.model.hosp.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 22:02 2022/4/8
 * @Modified By:
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public void save(Map<String, Object> paramMap) {
        //把参数map集合转换对象Hospital
        String mapString = JSONObject.toJSONString(paramMap);
        Hospital hospital = JSONObject.parseObject(mapString, Hospital.class);

        //判断是否存在数据
        String hoscode = hospital.getHoscode();
        Hospital HospitalExist = hospitalRepository.getHospitalByHoscode(hoscode);

        //如果不存在，进行添加
        if (HospitalExist != null) {
            hospital.setStatus(HospitalExist.getStatus());
            hospital.setCreateTime(HospitalExist.getCreateTime());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
        } else {
            //如果存在，颁行修改
        }
        hospital.setStatus(0);
        hospital.setCreateTime(new Date());
        hospital.setUpdateTime(new Date());
        hospital.setIsDeleted(0);
        hospitalRepository.save(hospital);
    }

    @Override
    public Hospital getByHoscde(String hoscode) {
        Hospital hospital = hospitalRepository.getHospitalByHoscode(hoscode);
        return hospital;
    }
}
