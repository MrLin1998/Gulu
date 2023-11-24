package com.linzb.guluuser.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RedissonConfig {
    final private static String PROTOCOL = "redis://";

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String passwd;

    @Value("${spring.redis.database}")
    private int database;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {

//        String nodeList = Arrays.asList(nodes.split(",")).stream()
//                .map(item -> PROTOCOL+item)
//                .collect(Collectors.joining(","));
//        String[] nodeList = Arrays.asList(nodes.split(",")).stream()
//                .map(item -> PROTOCOL+item)
//                .toArray(String[]::new);
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+nodeList[0]);



        Config config = new Config();
        config.useSingleServer()
                .setAddress(PROTOCOL+host+":"+port)
                .setPassword(passwd)
                .setDatabase(database)
                .setTimeout(10000);
        return Redisson.create(config);
    }
}
