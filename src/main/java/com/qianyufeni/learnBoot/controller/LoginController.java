package com.qianyufeni.learnBoot.controller;

import com.alibaba.fastjson.JSON;
import com.qianyufeni.learnBoot.constant.RequestExceptionEnum;
import com.qianyufeni.learnBoot.entity.User;
import com.qianyufeni.learnBoot.exception.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
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

    @Autowired
    private StringRedisTemplate redisTemplate;
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse resp, @RequestBody @Validated User user){
        System.out.println(Thread.currentThread().getName());
        if(null == user){
            throw new BadRequestException(RequestExceptionEnum.USER_NOT_FOUND.getCode(),RequestExceptionEnum.USER_NOT_FOUND.getMessage());
        }
        String pwdFromRedis = redisTemplate.opsForValue().get(user.getUserName());
        if(StringUtils.isEmpty(pwdFromRedis)){
            throw new BadRequestException(RequestExceptionEnum.USER_NOT_FOUND.getCode(),RequestExceptionEnum.USER_NOT_FOUND.getMessage());
        }
        if(!user.getPassword().equals(pwdFromRedis)){
            throw new BadRequestException(RequestExceptionEnum.UESER_PASSWORD_WRONG.getCode(),RequestExceptionEnum.UESER_PASSWORD_WRONG.getMessage());
        }
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
