package cn.zko0.springcloud.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author duanfuqiang
 * @date 2023/1/21 23:31
 * @description
 */
@Slf4j
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    //从配置文件里读取serverURL
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id")Long id){
        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
    }

}
