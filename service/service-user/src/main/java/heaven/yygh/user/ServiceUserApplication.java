package heaven.yygh.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 9:54 2022/4/15
 * @Modified By:
 */
@SpringBootApplication
@ComponentScan(basePackages = "heaven.yygh")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "heaven.yygh")
public class ServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }
}
