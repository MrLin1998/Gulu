package com.linzb.guluuser.test.api.impl;

import com.linzb.guluapi.user.ApiUserService;
import org.springframework.stereotype.Service;

@Service("apiUserService")
public class ApiUserServiceImpl implements ApiUserService {

    @Override
    public String getUser() {
        System.out.println("接口被调用");
        return "我是用户";
    }
}
