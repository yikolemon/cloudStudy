package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.service.TestService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @Resource
    private TestService testService;

    @GetMapping("/testA")
    public String testA() {
        return "----testA"+testService.childTest();
    }

    @GetMapping("/testB")
    public String testB() {
        return "----testB"+testService.childTest();
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testC 测试RT");
        return "----testC";
    }

    @GetMapping("/testD")
    public String testD() throws Exception {
        double random = (int)(Math.random()*10);
        if (random==0) throw new Exception("异常模拟");
        log.info("testD 测试比例异常");
        return "----testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false)String p1,
                             @RequestParam(value = "p2", required = false)String p2) {
        return "----testHotKey";
    }

/*    //兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        // sentinel的默认提示都是： Blocked by Sentinel (flow limiting)
        return "----deal_testHotKey, o(╥﹏╥)o";
    }*/

}
