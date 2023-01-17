/*
package cn.zko0.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author duanfuqiang
 * @date 2023/1/17 0:30
 * @description
 *//*

@Configuration
public class GatwayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        */
/*routes.route("path_route_angenin",  //id
                r -> r.path("/zhidao")  //访问 http://localhost:9527/zhidao
                        .uri("https://zhidao.baidu.com/"));  //就会转发到*//*


        routes.route("path_route_angenin2",  //id
                r -> r.path("/tieba")  //访问 http://localhost:9527/tieba
                        .uri("https://tieba.baidu.com/index.html"));  //就会转发到
        return routes.build();
    }
}
*/
