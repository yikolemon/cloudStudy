package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.entities.CommonResult;
import cn.zko0.springcloud.entities.Payment;
import cn.zko0.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author duanfuqiang
 * @date 2023/1/11 15:59
 * @description
 */
@Controller
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果{}",result);
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

        if(payment != null){
            //查询成功
            return new CommonResult(200, "查询成功", payment);
        }else{
            return new CommonResult(444, "没有对应记录，查询ID：" + id);
        }
    }

}
