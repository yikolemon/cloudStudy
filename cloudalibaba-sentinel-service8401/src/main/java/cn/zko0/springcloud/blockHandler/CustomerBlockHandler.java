package cn.zko0.springcloud.blockHandler;

import cn.zko0.springcloud.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义限流测试，Glogal handlerException ---- 1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义限流测试，Glogal handlerException ---- 2");
    }
}
