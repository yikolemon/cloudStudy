package cn.zko0.springcloud.dao;

import feign.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
