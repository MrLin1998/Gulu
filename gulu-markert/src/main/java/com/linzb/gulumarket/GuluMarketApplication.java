package com.linzb.gulumarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:config/dubbo/dubbo_consumer.xml")
@MapperScan("com.linzb.gulumarket.test.dao")
@MapperScan
public class GuluMarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuluMarketApplication.class,args);
        System.out.println("=======启动成功=============");
    }
}
