package com.qianyufeni.learnBoot.aop;

import com.qianyufeni.learnBoot.annotation.ResourceLog;
import com.qianyufeni.learnBoot.util.ResponseData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResourceLogAop {
    @Pointcut("execution(* com.qianyufeni.learnBoot.controller.*.*(..))")
    public void operationLog(){};

    /**
     * 切点的条件可以用 ||,or表示或, 使用 &&,and表示与,！表示非. @annotation表示匹配有对应注解的方法
     * @param joinPoint
     * @param responseData
     * @param resourceLog
     */
    @AfterReturning(returning = "responseData",value = "operationLog() && @annotation(resourceLog)")
    public void afterReturn(JoinPoint joinPoint, ResponseData responseData, ResourceLog resourceLog){
        //获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("type=" + resourceLog.type() + "action=" + resourceLog.action()+"code="+responseData.getStatus());
    }

}
