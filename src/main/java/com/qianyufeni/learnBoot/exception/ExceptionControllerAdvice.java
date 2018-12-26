package com.qianyufeni.learnBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice("com.qianyufeni.learnBoot.controller")
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        Map<String, Object> body = new HashMap<>(2);
        //body中加入自定义异常类的参数
        //约定BadRequestException只能在controller层抛出
        if(ex instanceof BadRequestException){
            body.put("code",((BadRequestException) ex).getCode());
            if(((BadRequestException) ex).getStatus() != null){
                status = ((BadRequestException) ex).getStatus();
            }
        }
        if(ex instanceof BusinessException){
            body.put("code",((BusinessException) ex).getCode());
        }
        body.put("exceptionMessage",ex.getMessage());
        return new ResponseEntity<>(body, status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
