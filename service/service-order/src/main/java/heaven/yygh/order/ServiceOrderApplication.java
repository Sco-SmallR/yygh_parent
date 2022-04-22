package heaven.yygh.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:22 2022/4/20
 * @Modified By:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"heaven.yygh"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"heaven.yygh"})
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
