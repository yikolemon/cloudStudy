package cn.zko0.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("cn.zko0.springcloud.dao")
@Configuration
public class MybatisConfig {
}