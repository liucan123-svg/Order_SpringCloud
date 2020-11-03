package com.lc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

 @Bean
 public Docket getDocket() {

  return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(apiInfo())
          .useDefaultResponseMessages(false)
          .select()
          .build();

 }

 private ApiInfo apiInfo() {
  return new ApiInfoBuilder()
          .title("外卖订单系统接口文档----欢乐送")
          .description("这是系统接口文档说明")
          .contact(new Contact("刘璨-www.tourist-lc.com", "http://www.tourist-lc.com", "1435564677@qq.com"))
          .version("1.0")
          .build();
         }
      }


