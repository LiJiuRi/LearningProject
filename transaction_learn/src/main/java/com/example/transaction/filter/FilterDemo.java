package com.example.transaction.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther: liXu
 * @Date: 2020/8/31 19:46
 * @Description:
 */
@Slf4j
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter init finished");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("############TestFilter1 doFilterInternal executed############");
        filterChain.doFilter(servletRequest, servletResponse);
        //在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
        //System.out.println("############TestFilter1 doFilter after############");
    }

    @Override
    public void destroy() {

    }
}
