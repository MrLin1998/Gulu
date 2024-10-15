package com.linzb.guluuser.common.aspect;

import com.linzb.gulucommon.limit.RateLimit;
import com.linzb.guluuser.common.util.CacheUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Aspect
@Component
public class RateLimitAspect {

    private static  final String RATE_LIMIT_KEY_PRE = "guluuser:rateLimit:";
    private static  final String RATE_LIMIT_SCRIPT=
            "local key = KEYS[1]\n" +
                    "local count = tonumber(ARGV[1])\n" +
                    "local time = tonumber(ARGV[2])\n" +
                    "local current = redis.call('get', key)\n" +
                    "if current and tonumber(current) >= count then\n" +
                    "    return 1\n" +
                    "end\n" +
                    "current = redis.call('incr', key)\n" +
                    "if tonumber(current) == 1 then\n" +
                    "    redis.call('expire', key, time)\n" +
                    "end\n" +
                    "return 0\n";

    @Resource
    private CacheUtil cacheUtil;

    @Before("@annotation(com.linzb.gulucommon.limit.RateLimit)")
    public void doBefore(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        RateLimit rateLimit = method.getAnnotation(RateLimit.class);
        String key = RATE_LIMIT_KEY_PRE+rateLimit.key();
        Long result = cacheUtil.executeLuaScript(RATE_LIMIT_SCRIPT,Long.class, key, rateLimit.time(), rateLimit.interval());
        if(0L != result){
            throw new RuntimeException(rateLimit.message());
        }

    }



}
