package heaven.yygh.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:16 2022/4/15
 * @Modified By:
 */
@Configuration
@MapperScan("heaven.yygh.user.mapper")
public class UserConfig {

}
