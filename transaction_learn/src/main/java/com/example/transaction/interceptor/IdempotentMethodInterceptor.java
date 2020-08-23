package com.example.transaction.interceptor;


import com.example.transaction.annotation.Idempotent;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 防止重复提交AOP拦截器
 */
@Slf4j
public class IdempotentMethodInterceptor implements MethodInterceptor {
    /**
     * 防止接口重复提交header参数
     */
    private static final String AUTHENTICATION = "Authentication";

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println();
        //获取幂等性注解对象
        Idempotent idempotent = invocation.getMethod().getAnnotation(Idempotent.class);
        //幂等性未启用
        if (Objects.isNull(idempotent)) {
            log.info("未使用注解");
            return invocation.proceed();
        }
        log.info("方法执行之前");
        Object object = invocation.proceed();
        log.info("方法执行之后");
        return object;
    }
}
