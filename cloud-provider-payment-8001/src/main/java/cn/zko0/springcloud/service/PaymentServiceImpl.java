package cn.zko0.springcloud.service;

import cn.zko0.springcloud.dao.PaymentDao;
import cn.zko0.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author duanfuqiang
 * @date 2023/1/11 15:57
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
