package com.example.transaction.aop;
import com.alibaba.fastjson.JSON;
import com.example.transaction.annotation.AutoLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 这是一种写法
 * 自动日志输出 aop
 * @author binbin.hou
 * @since 0.0.3
 */
@Aspect
@Slf4j
@Component
public class AutoLogAop {

    @Pointcut("@annotation(com.example.transaction.annotation.AutoLog)")
    public void methodPointcut(){
        System.out.println();
        System.out.println();
    }

    @Before(value = "methodPointcut()")
    public void before(JoinPoint point){
        System.out.println(JSON.toJSONString(point));
        System.out.println();
    }

    @After(value = "methodPointcut()")
    public void after(){
        //log.error("after方法------------------------------------");
    }

    /**
     * 执行核心方法
     *
     * 相当于 MethodInterceptor
     * @param point 切点
     * @return 结果
     * @throws Throwable 异常信息
     * @since 0.0.3
     */
    //@Around("@annotation(autoLog)")
    @Around(value = "methodPointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Method method = getCurrentMethod(point);
        String methodName = method.getName();
        AutoLog autoLog = method.getAnnotation(AutoLog.class);
        try {
            final long startMills = System.currentTimeMillis();
            //1. 是否输入入参
            if (autoLog.param()) {
                log.info("{} param is {}.", methodName, Arrays.toString(point.getArgs()));
            }

            //2. 执行方法
            Object result = point.proceed();

            //3. 结果
            if (autoLog.result()) {
                log.info("{} result is {}.", methodName, result);
            }
            //3.1 耗时
            final long slowThreshold = autoLog.slowThresholdMills();
            if (autoLog.costTime() || slowThreshold >= 0) {
                final long endMills = System.currentTimeMillis();
                long costTime = endMills - startMills;
                if (autoLog.costTime()) {
                    log.info("{} cost time is {}ms.", methodName, costTime);
                }

                //3.2 慢日志
                if (slowThreshold >= 0 && costTime >= slowThreshold) {
                    log.warn("{} is slow log, {}ms >= {}ms.", methodName, costTime, slowThreshold);
                }
            }

            return result;
        } catch (Throwable e) {
            if(autoLog.exception()) {
                log.error("{} meet ex.", methodName, e);
            }

            throw e;
        }
    }

    /**
     * 获取当前方法信息
     *
     * @param point 切点
     * @return 方法
     */
    private Method getCurrentMethod(ProceedingJoinPoint point) throws NoSuchMethodException {
        try {
            Signature sig = point.getSignature();
            MethodSignature msig = (MethodSignature) sig;
            Object target = point.getTarget();
            return target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw e;
        }
    }

}
