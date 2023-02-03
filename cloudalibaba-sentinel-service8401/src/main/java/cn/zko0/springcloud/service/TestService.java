package cn.zko0.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author duanfuqiang
 * @date 2023/2/3 11:00
 * @description
 */
@Service
public class TestService {

    @SentinelResource("childTest")
    public String childTest(){
        return "child";
    }

}
