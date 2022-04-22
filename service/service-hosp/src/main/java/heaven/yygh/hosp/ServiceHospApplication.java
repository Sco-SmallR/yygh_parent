package heaven.yygh.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 16:28 2022/3/29
 * @Modified By:
 */

@SpringBootApplication
@ComponentScan(basePackages = "heaven.yygh")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "heaven.yygh")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }

}
