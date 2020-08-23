package com.example.transaction.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: liXu
 * @Date: 2020/8/22 23:57
 * @Description:
 */
@Slf4j
public class DemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求行的相关信息
        /*log.info("getHttpServletMapping = 【{}】", JSON.toJSONString(request.getHttpServletMapping()));
        log.info("getMethod:" + request.getMethod());
        log.info("getQueryString:" + request.getQueryString());
        log.info("getProtocol:" + request.getProtocol());
        log.info("getContextPath" + request.getContextPath());
        log.info("getPathInfo:" + request.getPathInfo());
        log.info("getPathTranslated:" + request.getPathTranslated());
        log.info("getServletPath:" + request.getServletPath());
        log.info("getRemoteAddr:" + request.getRemoteAddr());
        log.info("getRemoteHost:" + request.getRemoteHost());
        log.info("getRemotePort:" + request.getRemotePort());
        log.info("getLocalAddr:" + request.getLocalAddr());
        log.info("getLocalName:" + request.getLocalName());
        log.info("getLocalPort:" + request.getLocalPort());
        log.info("getServerName:" + request.getServerName());
        log.info("getServerPort:" + request.getServerPort());
        log.info("getScheme:" + request.getScheme());
        log.info("getRequestURL:" + request.getRequestURL());

        System.out.println("------------------------");
        System.out.println();*/
        log.info("请求参数count: " + request.getParameter("count"));
        log.info("请求参数demo: " + request.getParameter("demo"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
