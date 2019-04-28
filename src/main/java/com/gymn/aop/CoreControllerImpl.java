package com.gymn.aop;

import com.gymn.aop.annotation.AjaxResponse;
import com.gymn.aop.annotation.Log2DB;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * Author:hunan
 * Date:2018/5/2
 */
@Component
public class CoreControllerImpl implements CoreController{
    @AjaxResponse(status = "yes")
    public String greet(String name) {
        return "hello "+name;
    }

    @Override
    public String invokeGreet() {
        return ((CoreControllerImpl)AopContext.currentProxy()).greet("hunan");
    }

    @Override
    public String invokeShow(){
        //return this.show();
        //return ((CoreControllerImpl) AopContext.currentProxy()).show();
        return ((CoreControllerImpl)SpringContextUtil.getBean(this.getClass())).show();
    }

    @AjaxResponse
    public String show(){
        return "Sing a song";
    }

    @Log2DB
    public String testAfter(String name) {
        return "hello, "+name;
    }

}
