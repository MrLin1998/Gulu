package com.linzb.guluuser.test.controller;

import com.linzb.guluuser.common.util.CacheUtil;
import com.linzb.guluuser.test.dao.TestDAO;
import com.linzb.guluuser.test.entity.EmpBasInfoExtCDO;
import com.linzb.guluuser.test.service.TestService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
    @Resource
    KafkaTemplate kafkaTemplate;
    @Resource
    RedissonClient redissonClient;

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

    @PostMapping("/kafkaProduce")
    public String kafkaProduce(String s){
        kafkaTemplate.send("test",s);
        return "ok";
    }

    @PostMapping("/kafkaProduce2")
    public String kafkaProduce2(String topic,String partition,String s) throws Exception{
        Integer par = Integer.valueOf(partition);
        ListenableFuture future = kafkaTemplate.send(topic, par, null, s);
        SendResult sendResult=(SendResult)future.get(3L, TimeUnit.SECONDS);
        System.out.println(sendResult);
        return "ok";
    }


    @PostMapping("/kafkaProduce3")
    public String kafkaProduce2(String topic,String s,Integer times)throws  Exception{
        for(int i=0;i<times;i++){
            ListenableFuture send = kafkaTemplate.send(topic, s);
            SendResult sendResult=(SendResult)send.get(3L, TimeUnit.SECONDS);
            System.out.println(sendResult);
        }
        return "ok";
    }


    @PostMapping("/tax")
    public String tax(String topic,String s,Integer times)throws  Exception{
        for(int i=0;i<times;i++){
            ListenableFuture send = kafkaTemplate.send(topic, s);
            SendResult sendResult=(SendResult)send.get(3L, TimeUnit.SECONDS);
            System.out.println(sendResult);
        }
        return "ok";
    }

    @PostMapping("/redisson")
    public String redisson() throws  Exception{
        RLock myLock = redissonClient.getLock("myLock");
        myLock.tryLock(3,TimeUnit.SECONDS);
        Thread.sleep(8000);
        myLock.unlock();
        return "ok";
    }

}
