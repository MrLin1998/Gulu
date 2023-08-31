package com.linzb.guluuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.linzb.guluuser.test.dao")
public class GuluUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuluUserApplication.class, args);
		System.out.println("=======启动成功=============");
	}

}
