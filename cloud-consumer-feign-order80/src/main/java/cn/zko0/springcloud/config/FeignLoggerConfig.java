package cn.zko0.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author duanfuqiang
 * @date 2023/1/15 13:09
 * @description
 */
@Configuration
public class FeignLoggerConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        //打印最详细的日志
        return Logger.Level.FULL;
    }
}
