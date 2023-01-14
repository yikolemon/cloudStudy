package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.entities.CommonResult;
import cn.zko0.springcloud.entities.Payment;
import cn.zko0.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author duanfuqiang
 * @date 2023/1/11 15:59
 * @description
 */
@Controller
@Slf4j
@ResponseBody
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果{},端口号{}",result,port);
        if(result>0){
            return new CommonResult(200,"insert suc",result);
        }else {
            return new CommonResult(444,"insert fail",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果：{}" , payment);
        System.out.println("new");
        if(payment != null){
            //查询成功
            return new CommonResult(200, "查询成功"+"端口号"+port,payment);
        }else{
            return new CommonResult(444, "没有对应记录，查询ID：" + id+"端口号"+port);
        }
    }

    @GetMapping(value = "/payment/port")
    public String getPort(){
        return port;
    }

}
