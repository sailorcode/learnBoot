package com.qianyufeni.learnBoot.exception;


import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class BaseErrorController extends BasicErrorController {
    public BaseErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    @Override
    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
        //body中加入自定义异常类的参数
        ServletException exception = (ServletException)request.getAttribute("javax.servlet.error.exception");
        BadRequestException badRequestException = (BadRequestException)exception.getCause();
        body.put("code",badRequestException.getCode());
        body.put("exceptionMessage",badRequestException.getMessage());
        return new ResponseEntity(body, badRequestException.getStatus());
    }
}
