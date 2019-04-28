package com.gymn.aop;

import com.alibaba.fastjson.JSON;
import com.gymn.aop.annotation.AjaxResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Author:hunan07
 * Date:2018/5/2
 */
@Aspect
@Component
public class AjaxResponseAspect {
    private ProceedingJoinPoint joinPoint;

    @Pointcut("@annotation(com.gymn.aop.annotation.AjaxResponse)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        String extraInfo = new Date().toString();
        String res = "";
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AjaxResponse annotation = method.getAnnotation(AjaxResponse.class);
        String status = annotation.status();

        try {
            res = joinPoint.proceed().toString();
        } catch (Throwable e) {
            System.out.println("yichang");
        }
        return "数据：" + res + ",时间:" + extraInfo + "， 状态：" + status;
    }

    @Pointcut("execution(public String com.gymn.aop.CoreControllerImpl.show())")
    public void pointCutShow() {
    }

    @Before("pointCutShow()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("表演即将开始：" + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "rvt", pointcut = "@annotation(com.gymn.aop.annotation.Log2DB)")
    public void logModify(JoinPoint joinPoint, Object rvt) {
        System.out.println("args:" + JSON.toJSONString(joinPoint.getArgs()));
        System.out.println("returning:"+JSON.toJSONString(rvt));
    }
}
