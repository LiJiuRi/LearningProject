package com.example.transaction.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: liXu
 * @Date: 2020/10/15 00:34
 * @Description:
 */
@Aspect
@Slf4j
@Component
public class RemoveBlankKeyAop {

    @Pointcut("@annotation(com.example.transaction.annotation.RemoveBlankKey)")
    public void methodPointcut() {
    }

    @Before(value = "methodPointcut()")
    public void before(JoinPoint point) {
        for (Object object : point.getArgs()) {
            if (object instanceof LinkedHashMap) {
                LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) object;
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Object value = it.next().getValue();
                    if (StringUtils.isBlank(value.toString().trim())) {
                        it.remove();
                    }
                }
            }
        }
    }
}
