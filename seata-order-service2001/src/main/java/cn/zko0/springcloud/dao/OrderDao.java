package cn.zko0.springcloud.dao;

import cn.zko0.springcloud.domain.Order;
import feign.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    //1 新建订单
    int create(Order order);

    //2 修改订单状态,从0改为1
    int update(@Param("userId") Long userId, @Param("status") Integer status);

}
