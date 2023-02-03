package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.entities.CommonResult;
import cn.zko0.springcloud.entities.Payment;
import cn.zko0.springcloud.service.PaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    //public static  final  String SERVICE_URL = "http://nacos-payment-provider";
//    @Resource
//    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    @SentinelResource(value ="paymentSQL" ,blockHandler = "blockHandler")
    public CommonResult< Payment > paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"blockHandler-sentinel 限流，BlockException： " + e.getMessage(), payment);
    }


//    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback ="handlerFallback",blockHandler = "blockHandler",
//                        exceptionsToIgnore = {NullPointerException.class})
//    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")   //没有配置
//    //@SentinelResource(value = "fallback",fallback ="handlerFallback")   //没有配置
//    public CommonResult<Payment> fallback(@PathVariable  Long id) {
//        CommonResult<Payment> result = restTemplate.getForObject(
//                SERVICE_URL + "/paymentSQL/" + id,CommonResult.class,id);
//        if(id == 4){
//            throw new IllegalArgumentException("IllegalArgument,非法参数异常...");
//        }else if(result.getData() == null) {
//            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
//        }
//        return  result;
//    }
//
    //blockHandler兜底

//
//
//    //fallback兜底
//    public CommonResult handlerFallback(@PathVariable Long id,Throwable e) {
//        Payment payment = new Payment(id,"null");
//        return new CommonResult(444,"异常handlerFallback，exception内容： " + e.getMessage(), payment);
//    }

}
