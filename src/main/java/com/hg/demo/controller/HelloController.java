package com.hg.demo.controller;

import com.hg.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("hello控制类")
@RestController
public class HelloController {
    @GetMapping ("/hello")
    public String hello(){
        return "hello";
    }
    //只要接口中返回的是存在的实体类就会被扫描

    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }
    @ApiOperation("hello控制类")
    @GetMapping(value = "hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }
    @ApiOperation("Post 测试类")
    @GetMapping(value = "/postt")
    public User postt(@ApiParam("用户名") User user){
        return user;
    }
}
