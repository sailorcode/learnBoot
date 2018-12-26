package com.qianyufeni.learnBoot.interceptors;

import com.qianyufeni.learnBoot.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 拦截所有的请求,做登录验证,拦截请求地址的配置方法:继承WebMvcConfigurationSupport,重写addInterceptors方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String uri = request.getRequestURI();
        if(uri.indexOf("login")>=0){
            return true;
        }
        String token = request.getHeader("token");
        User user = (User)request.getSession().getAttribute(token);
        if(null != user){*/
            return true;
       /* }
        return false;*/
    }
}
