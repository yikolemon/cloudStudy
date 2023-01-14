package cn.zko0.springcloud;

import cn.zko0.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author duanfuqiang
 * @date 2023/1/11 20:12
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
//name 需要访问的微服务的名称 ,configuration为负载均衡规则的配置类
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
