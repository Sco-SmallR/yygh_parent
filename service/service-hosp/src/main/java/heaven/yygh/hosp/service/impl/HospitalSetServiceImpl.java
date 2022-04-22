package heaven.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import heaven.yygh.common.exception.YyghException;
import heaven.yygh.common.result.ResultCodeEnum;
import heaven.yygh.hosp.mapper.HospitalSetMapper;
import heaven.yygh.hosp.service.HospitalSetService;
import heaven.yygh.model.hosp.HospitalSet;
import heaven.yygh.vo.order.SignInfoVo;
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

    @Override
    public String getSignKey(String hoscode) {
        QueryWrapper<HospitalSet> wrapper=new QueryWrapper<>();
        wrapper.eq("hoscode",hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(wrapper);
        return hospitalSet.getSignKey();
    }
    //获取医院签名信息
    @Override
    public SignInfoVo getSignInfoVo(String hoscode) {
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        wrapper.eq("hoscode",hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(wrapper);
        if(null == hospitalSet) {
            throw new YyghException(ResultCodeEnum.HOSPITAL_OPEN);
        }
        SignInfoVo signInfoVo = new SignInfoVo();
        signInfoVo.setApiUrl(hospitalSet.getApiUrl());
        signInfoVo.setSignKey(hospitalSet.getSignKey());
        return signInfoVo;
    }

}
