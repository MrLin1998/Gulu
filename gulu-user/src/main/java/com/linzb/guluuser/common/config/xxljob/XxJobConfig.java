package com.linzb.guluuser.common.config.xxljob;


import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xxljob配置类
 * @author linzb
 * @date 2023-11-02
 */
@Configuration
public class XxJobConfig{
    @Value("${xxl-job.address}")
    private String adminAddresses;


    @Value("${xxl-job.executor-appname}")
    private String appName;


    @Value("${xxl-job.executor-ip}")
    private String ip;


    @Value("${xxl-job.executor-port}")
    private int port;


    @Value("${xxl-job.accessToken}")
    private String accessToken;


    @Value("${xxl-job.executor-logpath}")
    private String logPath;


    @Value("${xxl-job.executor-logretentionday}")
    private int logRetentionDays;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppName(appName);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }

}
