package com.example.transaction.config;

import com.example.transaction.interceptor.DemoInterceptor;
import com.example.transaction.interceptor.TestFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: liXu
 * @Date: 2020/8/22 23:40
 * @Description:
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(new TestFilter()).addPathPatterns("/**");
    }
}
