package com.codermi.mybatis.aspect;

import com.alibaba.fastjson.JSON;
import com.codermi.mybatis.aspect.annotaion.LogAccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author qiudm
 * @date 2018/12/26 14:30
 * @desc
 */
@Aspect
@Component
public class LogAccessAspect {

    @Pointcut(value = "@annotation(com.codermi.mybatis.aspect.annotaion.LogAccess)")
    public void pointcutName(){

    }

    @Before(value = "pointcutName()")
    public void beforeMethod() {
        System.out.println("before11 = " );
    }

    @Around(value = "pointcutName()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(" around===== ");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAccess logAccess = method.getAnnotation(LogAccess.class);
        String remark = logAccess.remark();
        System.out.println("remark = " + remark);
        Object[] args = joinPoint.getArgs();
        System.out.println("JSON.toJSONString(args) = " + JSON.toJSONString(args));
        return joinPoint.proceed();
    }
















}
