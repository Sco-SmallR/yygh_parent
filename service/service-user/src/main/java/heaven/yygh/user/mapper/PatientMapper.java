package heaven.yygh.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import heaven.yygh.model.user.Patient;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 12:07 2022/4/18
 * @Modified By:
 */
@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
}
