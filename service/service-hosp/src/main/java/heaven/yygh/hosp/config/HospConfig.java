package heaven.yygh.hosp.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 9:12 2022/3/30
 * @Modified By:
 */
@Configuration
@MapperScan("heaven.yygh.hosp.mapper")
public class HospConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
