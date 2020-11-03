package com.lc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**  @description：  自定义全局filter 这里只对用户username进行判断
 * Spring Cloud Gateway中有二种类型过滤器:GlobalFilter和GatewayFilter
 * GlobalFilter：全局过滤器，对所有路由均起作用
 * GatewayFilter :只对指定的路由起作用
*/

//@Configuration
@Slf4j
public class GatewayConfig implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入自定义的Filter");
        if(exchange.getRequest().getQueryParams().get("username")!=null){
            log.info("用户信息合法");
            return chain.filter(exchange);
        }else{
            log.info("用户信息不合法");
        }
        return exchange.getResponse().setComplete();
    }



//     * @return 0 - ~ 的优先级 -数字越低表示最先执行， -1表示最先执行

    @Override
    public int getOrder() {
        return -1;
    }
}
