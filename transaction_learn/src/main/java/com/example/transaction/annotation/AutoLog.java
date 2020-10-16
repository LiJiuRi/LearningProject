package com.example.transaction.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AutoLog {

    /**
     * 输出参数
     * @return 参数
     * @since 0.0.1
     */
    boolean param() default true;

    /**
     * 是否输出结果
     * @return 结果
     * @since 0.0.1
     */
    boolean result() default true;

    /**
     * 是否输出时间
     * @return 耗时
     * @since 0.0.1
     */
    boolean costTime() default false;

    /**
     * 是否输出异常信息
     * @return 是否
     * @since 0.0.6
     */
    boolean exception() default true;

    /**
     * 慢日志阈值
     *
     * 当值小于 0 时，不进行慢日志统计。
     * 当值大于等于0时，当前值只要大于等于这个值，就进行统计。
     * @return 阈值
     * @since 0.0.4
     */
    long slowThresholdMills() default -1;

}
