package cn.zko0.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author duanfuqiang
 * @date 2023/1/15 23:29
 * @description
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_OK----";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_TimeOut----";
    }
}
