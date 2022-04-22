package heaven.yygh.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import heaven.yygh.cmn.client.DictFeignClient;
import heaven.yygh.enums.DictEnum;
import heaven.yygh.hosp.respository.HospitalRepository;
import heaven.yygh.hosp.service.DepartmentService;
import heaven.yygh.hosp.service.HospitalService;
import heaven.yygh.model.hosp.Hospital;
import heaven.yygh.vo.hosp.HospitalQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private DictFeignClient dictFeignClient;

    @Autowired
    private DepartmentService departmentService;


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
    public Hospital getByHoscode(String hoscode) {
        Hospital hospital = hospitalRepository.getHospitalByHoscode(hoscode);
        return hospital;
    }

    @Override
    public Page<Hospital> selectPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        //0为第一页
        Pageable pageable = PageRequest.of(page - 1, limit, sort);

        Hospital hospital = new Hospital();
        BeanUtils.copyProperties(hospitalQueryVo, hospital);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true); //改变默认大小写忽略方式：忽略大小写

        //创建实例
        Example<Hospital> example = Example.of(hospital, matcher);
        Page<Hospital> pages = hospitalRepository.findAll(example, pageable);

        // 调用feign查询医院等级
        pages.getContent().stream().forEach(item -> {
            this.packHospital(item);
        });

        return pages;
    }

    // 获取查询list集合，遍历进行医院等级封装
    private Hospital packHospital(Hospital hospital) {
        // 根据dictCode和value获取医院等级名称
        String hostypeString = dictFeignClient.getName(DictEnum.HOSTYPE.getDictCode(), hospital.getHostype());
        String provinceString = dictFeignClient.getName(hospital.getProvinceCode());
        String cityString = dictFeignClient.getName(hospital.getCityCode());
        String districtString = dictFeignClient.getName(hospital.getDistrictCode());

        hospital.getParam().put("hostypeString", hostypeString);
        hospital.getParam().put("fullAddress", provinceString + cityString + districtString + hospital.getAddress());
        return hospital;
    }

    // 医院状态更新
    @Override
    public void updateStatus(String id, Integer status) {
        if (status.intValue() == 0 || status.intValue() == 1) {
            Hospital hospital = hospitalRepository.findById(id).get();
            hospital.setStatus(status);
            hospital.setUpdateTime(new Date());
            hospitalRepository.save(hospital);
        }
    }

    // 医院详情
    @Override
    public Map<String, Object> show(String id) {
        Map<String, Object> result = new HashMap<>();

        Hospital hospital = this.packHospital(hospitalRepository.findById(id).get());
        result.put("hospital", hospital);

        //单独处理更直观
        result.put("bookingRule", hospital.getBookingRule());
        //不需要重复返回
        hospital.setBookingRule(null);
        return result;
    }

    @Override
    public String getHospName(String hoscode) {
        Hospital hospital = hospitalRepository.getHospitalByHoscode(hoscode);
        if(null != hospital) {
            return hospital.getHosname();
        }
        return "";

    }

    @Override
    public List<Hospital> findByHosname(String hosname) {
        return hospitalRepository.findHospitalByHosnameLike(hosname);
    }
    @Override
    public Map<String, Object> item(String hoscode) {
        Map<String, Object> result = new HashMap<>();
        //医院详情
        Hospital hospital = this.packHospital(this.getByHoscode(hoscode));
        result.put("hospital", hospital);
        //预约规则
        result.put("bookingRule", hospital.getBookingRule());
        //不需要重复返回
        hospital.setBookingRule(null);
        return result;
    }

}
