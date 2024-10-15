package com.linzb.gulucommon.limit;

import java.lang.annotation.*;


/**
 * 限流注解
 *
 * @author linzb
 * @date 2024-10-12
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {

    String key() default "";

    int interval() default 60;

    int time() default 60;

    String limitType() default "";

    String message() default "请求次数过于频繁，稍后再试";

}
