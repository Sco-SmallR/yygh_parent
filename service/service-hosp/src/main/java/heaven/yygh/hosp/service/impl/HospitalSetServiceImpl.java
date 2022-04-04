package heaven.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import heaven.yygh.hosp.mapper.HospitalSetMapper;
import heaven.yygh.hosp.service.HospitalSetService;
import heaven.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 22:43 2022/3/29
 * @Modified By:
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet>
        implements HospitalSetService {
    @Autowired
    private HospitalSetMapper hospitalSetMapper;
}
