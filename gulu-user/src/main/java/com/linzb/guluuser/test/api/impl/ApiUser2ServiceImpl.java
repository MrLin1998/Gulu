package com.linzb.guluuser.test.api.impl;

import com.linzb.guluapi.user.ApiUser2Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Service(interfaceClass = ApiUser2Service.class,version = "1.0.0")
@Component("apiUser2Service")
public class ApiUser2ServiceImpl implements ApiUser2Service {

    @Override
    public String getUser() {
        System.out.println("接口被调用");
        return "我是用户2";
    }
}
