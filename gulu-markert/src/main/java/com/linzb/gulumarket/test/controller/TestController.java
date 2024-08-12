package com.linzb.gulumarket.test.controller;

import com.linzb.guluapi.user.ApiUser2Service;
import com.linzb.guluapi.user.ApiUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ApiUserService apiUserService;

    @Reference(interfaceClass = ApiUser2Service.class,version = "1.0.0")
    private ApiUser2Service apiUser2Service;

    @GetMapping("/getUser")
    String getUser(){
        return apiUserService.getUser();
    }

    @GetMapping("/getUser2")
    String getUser2(){
        return apiUser2Service.getUser();
    }

}
