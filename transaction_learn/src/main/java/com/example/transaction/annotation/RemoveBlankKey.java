package com.example.transaction.annotation;

import java.lang.annotation.*;

/**
 * @Auther: liXu
 * @Date: 2020/10/14 23:50
 * @Description:
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoveBlankKey {
}
