package com.qianyufeni.learnBoot.controller;

import com.alibaba.fastjson.JSON;
import com.qianyufeni.learnBoot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse resp, @RequestBody User user){
        String token = UUID.randomUUID().toString();
        request.getSession().setAttribute(token, user);
        //request.getSession().setAttribute(token, JSON.toJSONString(user));
        Cookie cookie = new Cookie("token",token);
        resp.addCookie(cookie);
        return "login success";
    }

    @GetMapping("/getCurrentUser")
    public User getSession(HttpServletRequest request){
        String token = request.getHeader("token");
        logger.info(request.getSession().getId());
        User user = (User)request.getSession().getAttribute(token);
        return user;
    }

    /**
     * 测试不同的会话的session不一样,根据sessionid来区分不同会话(不同的客户端)
     * @param request
     */
    public void testSession(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length>0){
            for(Cookie cookie:cookies){
                logger.info("cookie.getName()="+cookie.getName());
                logger.info("cookie.getValue()="+cookie.getValue());
                logger.info("cookie.getDomain()="+cookie.getDomain());
            }
        }
        if(request.getSession() != null){
            logger.info("request.getSession().getId()="+request.getSession().getId());
        }
    }
}
