package com.example.transaction.annotation;

import java.lang.annotation.*;

/**
* @Description: 限制重复提交注解
* @create: 2020/3/26
*/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {
    /**
     * 启动幂等性功能
     */
    boolean enable() default true;
}
