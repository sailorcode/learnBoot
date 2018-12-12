package com.qianyufeni.learnBoot.controller;

import com.qianyufeni.learnBoot.constant.RequestExceptionEnum;
import com.qianyufeni.learnBoot.exception.BadRequestException;
import com.qianyufeni.learnBoot.service.TestExceptionService;
import com.qianyufeni.learnBoot.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class TestExceptionController {
    private final static Logger logger = LoggerFactory.getLogger(TestExceptionController.class);
    @Autowired
    private TestExceptionService testExceptionService;

    @GetMapping("/exception/")
    public void test(HttpServletRequest request,HttpServletResponse response){
        logger.info("MyThreadLocal.getMessage()="+MyThreadLocal.getMessage());
        //通过每次请求获取的线程id不同,表名每次请求都是不同的线程,每次请求都会新分配一个线程调用service方法
        logger.info("当前线程="+Thread.currentThread().getId());
        MyThreadLocal.setMessage("第一个值");
        //ThreadLocal可以存储同一个线程的共享变量,
        logger.info("MyThreadLocal.getMessage()="+MyThreadLocal.getMessage());
        //testExceptionService.throwExceptionTest();
        if(true){
            throw new BadRequestException(RequestExceptionEnum.BASE.getCode(),RequestExceptionEnum.BASE.getMessage());
        }
    }
}
