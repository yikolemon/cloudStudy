package cn.zko0.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author duanfuqiang
 * @date 2023/1/11 20:12
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain80Zk {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80Zk.class,args);
    }
}
