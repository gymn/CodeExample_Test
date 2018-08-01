package com.gymn.aop;

import com.gymn.aop.annotation.AjaxResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
    public void pointCut(){}

    @Around("pointCut()")
    public String aroundAdvice(ProceedingJoinPoint joinPoint){
        String extraInfo = new Date().toString();
        String res = "";
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        AjaxResponse annotation = method.getAnnotation(AjaxResponse.class);
        String status = annotation.status();

        try {
            res = joinPoint.proceed().toString();
        }catch (Throwable e){
            e.printStackTrace();
        }
        return "数据："+res+",时间:"+extraInfo + "， 状态："+status;
    }

    @Pointcut("execution(public String com.gymn.aop.CoreController.show())")
    public void pointCutShow(){}

    @Before("pointCutShow()")
    public String beforeAdvice(JoinPoint joinPoint){
        System.out.println("表演开始啦。。。。");
        return "lalalalal";
    }
}
