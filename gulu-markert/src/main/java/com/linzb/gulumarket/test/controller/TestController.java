package com.linzb.gulumarket.test.controller;

import com.linzb.guluapi.user.ApiUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ApiUserService apiUserService;

    @GetMapping("/getUser")
    String getUser(){
        return apiUserService.getUser();
    }

}
