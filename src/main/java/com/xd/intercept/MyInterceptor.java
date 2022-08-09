package com.xd.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器。 如果 没有 携带   token（jwt） ，
 * <p>
 * 则不预 通过。 直接返回 登录页
 * <p>
 * 如果有 token ， 则 提示 token 是否  正确， 是否 过期！！
 * 如果过期。 直接返回 登录页
 * 如果错误。 直接返回 登录页
 */

//@Component // Service controller ....
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("controller执行之前");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //    Controller方法处理之
        System.out.println("controller执行之前");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        页面渲染后
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
