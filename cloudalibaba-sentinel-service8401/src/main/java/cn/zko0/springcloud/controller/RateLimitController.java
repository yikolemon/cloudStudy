package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.blockHandler.CustomerBlockHandler;
import cn.zko0.springcloud.entities.CommonResult;
import cn.zko0.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanfuqiang
 * @date 2023/2/3 16:28
 * @description
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return  new CommonResult(200,"按照资源名称限流测试",new Payment(2020L,"serial001"));
    }

    //兜底方法
    public CommonResult handleException(BlockException exception) {
        return  new CommonResult(444,exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")	//没有兜底方法，系统就用默认的
    public CommonResult byUrl() {
        return  new CommonResult(200,"按照byUrl限流测试",new Payment(2020L,"serial002"));
    }

    //CustomerBlockHandler
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return  new CommonResult(200,"按照客户自定义限流测试",new Payment(2020L,"serial003"));
    }

}
