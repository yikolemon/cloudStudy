package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.domain.CommonResult;
import cn.zko0.springcloud.service.StorageService;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

	@RequestMapping("/storage/decrease")
	public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        //xid检查
        String xid = RootContext.getXID();
        System.out.println("xid_order:" +xid );
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功!");
    }

}
