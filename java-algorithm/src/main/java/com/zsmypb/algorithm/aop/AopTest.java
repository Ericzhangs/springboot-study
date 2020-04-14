package com.zsmypb.algorithm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhangs.
 * @date 2020/4/13.
 */
@Aspect
@Component
public class AopTest {

    @Pointcut("@annotation(aopInterface)")
    public void pointcut(AopInterface aopInterface) {
        // Do nothing because of pointcut
    }
    @Around(value = "pointcut(aopInterface)")
    public Object around(ProceedingJoinPoint joinPoint, AopInterface aopInterface) throws Throwable {
        System.out.println("进入切面");
        System.out.println(joinPoint);
        System.out.println(aopInterface.methodName());
        return true;
    }
}
