package com.linzb.guluuser.test.controller;

import com.linzb.guluuser.common.util.CacheUtil;
import com.linzb.guluuser.test.dao.TestDAO;
import com.linzb.guluuser.test.entity.EmpBasInfoExtCDO;
import com.linzb.guluuser.test.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${sss.a}")
    String a;

    @Resource
    TestService testService;
    @Resource
    TestDAO testDAO;
    @Resource
    CacheUtil cacheUtil;

    @PostMapping("/sss")
    public String test(){
        System.out.println(a);
        EmpBasInfoExtCDO empBasInfoExtCDO = testDAO.selectByPrimaryKey(new EmpBasInfoExtCDO().setEmpNo("3"));
        return empBasInfoExtCDO == null ?"null":empBasInfoExtCDO.toString();
    }

    @PostMapping("/redis")
    public String redis(){
        cacheUtil.set("s","sss");
        Object s = cacheUtil.get("s");
        return s == null ?"null":s.toString();
    }
}
