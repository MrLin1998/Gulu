package com.linzb.guluuser.test.xxljobHandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;


/**
 * ceshi
 * @author linzb
 * @date 2023-11-02
 */
@Component
@JobHandler("testJobHandler")
public class TestJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("执行成功");
        return ReturnT.SUCCESS;
    }
}
