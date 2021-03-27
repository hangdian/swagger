package com.hg.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(Environment environment){
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)//是否启动swagger。
                .select()
                /*
                RequestHandlerSelectors,配置要扫描的接口的方式
                basePackage扫描的包
                any全部
                none不扫描
                withClassAnnotation扫描类上的注解，参数是一个注解的反射对象
                withMethodAnnotation()扫描方法上的注解

                 */
                .apis(RequestHandlerSelectors.basePackage("com.hg.demo.controller"))
                //过滤什么路径
                //.paths(PathSelectors.ant("/hg/**"))
                .build();
    }
    private ApiInfo apiInfo(){
        Contact contact = new Contact("cunzhu", "www.cunzhu.com", "2061971769@qq.com");
        return new ApiInfo(
                "cunzhu 的swagger文档",
                "做好自己的事",
                "v1.0",
                "www.cunzhu.com",
                  contact,
                "Apache 2.0",
                "www.cunzhu.com",
                new ArrayList());
    }
}
