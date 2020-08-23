package com.example.transaction.config;

import com.example.transaction.annotation.Idempotent;
import com.example.transaction.interceptor.IdempotentMethodInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: liXu
 * @Date: 2020/8/17 23:45
 * @Description:
 */
@Configuration
public class InterceptorAnnotationConfig {

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor3() {
        IdempotentMethodInterceptor interceptor = new IdempotentMethodInterceptor();

        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(null, Idempotent.class);

        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        advisor.setOrder(2);
        return advisor;
    }
}