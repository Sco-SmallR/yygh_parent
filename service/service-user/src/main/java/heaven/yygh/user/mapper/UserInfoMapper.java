package heaven.yygh.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import heaven.yygh.model.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:12 2022/4/15
 * @Modified By:
 */

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}

