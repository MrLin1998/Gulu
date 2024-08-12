package com.linzb.guluuser;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.linzb.guluuser.test.dao")
@EnableDubbo
@ImportResource(locations = "classpath:config/dubbo/dubbo_provider.xml")
public class GuluUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuluUserApplication.class, args);
		System.out.println("=======启动成功=============");
	}

}
