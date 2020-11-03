package com.lc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@SpringBootApplication
@MapperScan("com.lc.dao") //com.lc.dao包下面的接口类，在编译之后都会生成相对应的实体类,添加后可省去@Mapper注解
@EnableCircuitBreaker  // 启动服务熔断机制,启动断路器
public class MenuApp {
    public static void main(String[] args) {
        SpringApplication.run(MenuApp.class, args);
    }
}
